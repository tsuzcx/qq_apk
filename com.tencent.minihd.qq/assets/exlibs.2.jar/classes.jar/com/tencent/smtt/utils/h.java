package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.stat.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class h
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static h b;
  private String c;
  private String d;
  private String e;
  
  private h()
  {
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.e = String.valueOf(i + 10000000);
    this.c = (this.e + String.valueOf(j + 10000000));
  }
  
  public static h a()
  {
    try
    {
      if (b == null) {
        b = new h();
      }
      h localh = b;
      return localh;
    }
    finally {}
  }
  
  private String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = a[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    return a.a(this.e.getBytes(), paramArrayOfByte, 1);
  }
  
  public void b()
    throws Exception
  {
    Security.addProvider((Provider)Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
  }
  
  public String c()
    throws Exception
  {
    byte[] arrayOfByte;
    if (this.d == null)
    {
      arrayOfByte = this.c.getBytes();
      localObject1 = null;
    }
    try
    {
      localObject2 = Cipher.getInstance("RSA/ECB/NoPadding");
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          b();
          Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          localObject1 = localCipher;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    localObject2 = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    localObject1.init(1, KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject2));
    this.d = b(localObject1.doFinal(arrayOfByte));
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.h
 * JD-Core Version:    0.7.0.1
 */