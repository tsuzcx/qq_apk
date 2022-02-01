package oicq.wlogin_sdk.pow;

import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.report.event.c;
import oicq.wlogin_sdk.tools.util;

public class ClientPow
{
  boolean a = false;
  
  public ClientPow()
  {
    try
    {
      System.loadLibrary("pow");
      this.a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      util.LOGI(localUnsatisfiedLinkError.toString(), "");
    }
  }
  
  private int a(a parama)
  {
    long l1 = 0L;
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[parama.h.length];
    System.arraycopy(parama.h, 0, arrayOfByte2, 0, parama.h.length);
    Object localObject = new BigInteger(arrayOfByte2);
    long l2 = 0L;
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      if (parama.c == 1)
      {
        a(arrayOfByte2, arrayOfByte1);
        l2 += System.currentTimeMillis() - l3;
        if (Arrays.equals(arrayOfByte1, parama.j))
        {
          localObject = Arrays.copyOf(arrayOfByte2, arrayOfByte2.length);
          parama.n = ((byte[])localObject);
          parama.m = localObject.length;
          util.LOGI("sha_cost:" + l2 + " bignum_cost:" + l1, "");
          return parama.p;
        }
      }
      else
      {
        if (parama.c == 2)
        {
          c(arrayOfByte2);
          util.LOGI("hash func not support sm3", "");
          return -1;
        }
        util.LOGI("error hash func", "");
        return -1;
      }
      parama.p += 1;
      l3 = System.currentTimeMillis();
      localObject = ((BigInteger)localObject).add(BigInteger.ONE);
      byte[] arrayOfByte3 = ((BigInteger)localObject).toByteArray();
      if (arrayOfByte3.length > arrayOfByte2.length)
      {
        util.LOGI("big number too large len:" + arrayOfByte3.length, "");
        return -1;
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
      l1 += System.currentTimeMillis() - l3;
    }
  }
  
  private int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return 1;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramArrayOfByte1);
      paramArrayOfByte1 = localMessageDigest.digest();
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      return 0;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      util.LOGI(paramArrayOfByte1.toString(), "");
    }
    return 2;
  }
  
  private int b(a parama)
  {
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[parama.h.length];
    System.arraycopy(parama.h, 0, arrayOfByte2, 0, parama.h.length);
    Object localObject = new BigInteger(arrayOfByte2);
    for (;;)
    {
      if (parama.c == 1)
      {
        a(arrayOfByte2, arrayOfByte1);
        if (a(arrayOfByte1, parama.e) == 0)
        {
          localObject = Arrays.copyOf(arrayOfByte2, arrayOfByte2.length);
          parama.n = ((byte[])localObject);
          parama.m = localObject.length;
          return parama.p;
        }
      }
      else
      {
        if (parama.c == 2)
        {
          c(arrayOfByte2);
          util.LOGI("hash func not support sm3", "");
          return -1;
        }
        util.LOGI("error hash func", "");
        return -1;
      }
      parama.p += 1;
      localObject = ((BigInteger)localObject).add(BigInteger.ONE);
      byte[] arrayOfByte3 = ((BigInteger)localObject).toByteArray();
      if (arrayOfByte3.length > arrayOfByte2.length)
      {
        util.LOGI("big number too large len:" + arrayOfByte3.length, "");
        return -1;
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    }
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
  
  int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > 32) {
      return 1;
    }
    int j = 255;
    int i = 0;
    while ((j >= 0) && (i < paramInt))
    {
      if ((paramArrayOfByte[(j / 8)] & 1 << j % 8) != 0) {
        return 2;
      }
      j -= 1;
      i += 1;
    }
    return 0;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject3 = new byte[0];
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      util.LOGI(util.LOG_TAG_POW + " calPow inBuf is empty", "");
      return localObject3;
    }
    StringBuffer localStringBuffer = new StringBuffer(util.LOG_TAG_POW + "_calPow");
    localStringBuffer.append(",inBuf=").append(util.getByteLength(paramArrayOfByte));
    Object localObject1 = localObject3;
    if (this.a) {}
    try
    {
      localObject1 = nativeGetPow(paramArrayOfByte);
      localStringBuffer.append(",native=").append(util.getByteLength((byte[])localObject1));
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (localObject1.length != 0) {
          break label152;
        }
      }
      try
      {
        paramArrayOfByte = b(paramArrayOfByte);
        localObject1 = paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          label152:
          Object localObject2;
          util.printThrowable(paramArrayOfByte, util.LOG_TAG_POW + "calPowJavaImpl");
          c.a(new b("wtlogin_pow_error", "java_error", Log.getStackTraceString(paramArrayOfByte)));
        }
      }
      localStringBuffer.append(",java=").append(util.getByteLength((byte[])localObject1));
      localObject3 = localObject1;
      util.LOGI(localStringBuffer.toString(), "");
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        util.printThrowable(localException, util.LOG_TAG_POW + "nativeGetPow");
        c.a(new b("wtlogin_pow_error", "c_error", Log.getStackTraceString(localException)));
        localObject2 = localObject3;
      }
    }
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[0];
    a locala = new a();
    int i = locala.a(paramArrayOfByte);
    if (i != 0)
    {
      util.LOGI("pow buf to st failed.ret=" + i, "");
      paramArrayOfByte = arrayOfByte;
      return paramArrayOfByte;
    }
    long l = System.currentTimeMillis();
    locala.p = 0;
    locala.o = 0;
    switch (locala.b)
    {
    default: 
      util.LOGI("not support algorithm=" + locala.b, "");
      return arrayOfByte;
    }
    for (i = b(locala);; i = a(locala))
    {
      paramArrayOfByte = arrayOfByte;
      if (i < 0) {
        break;
      }
      locala.o = ((int)(System.currentTimeMillis() - l));
      locala.d = 1;
      locala.p = i;
      util.LOGI("cnt=" + locala.p + " cost=" + locala.o, "");
      arrayOfByte = locala.a();
      if (arrayOfByte != null)
      {
        paramArrayOfByte = arrayOfByte;
        if (arrayOfByte.length > 0) {
          break;
        }
      }
      util.LOGI("pow st to buf failed.", "");
      return arrayOfByte;
    }
  }
  
  public native byte[] nativeGetPow(byte[] paramArrayOfByte);
  
  public native byte[] nativeGetTestData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pow.ClientPow
 * JD-Core Version:    0.7.0.1
 */