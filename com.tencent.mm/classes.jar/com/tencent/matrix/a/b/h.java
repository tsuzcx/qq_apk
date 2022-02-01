package com.tencent.matrix.a.b;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class h
{
  private static a cXA;
  private static final ThreadLocal<byte[]> cXz = new ThreadLocal();
  
  private static c U(byte[] paramArrayOfByte)
  {
    c localc = new c();
    int i1 = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    while (i < i1) {
      if (Character.isSpaceChar(paramArrayOfByte[i]))
      {
        j += 1;
        i += 1;
      }
      else
      {
        int k;
        int m;
        String str;
        switch (j)
        {
        default: 
          i += 1;
          break;
        case 1: 
          k = 0;
          j = i;
          while ((j < i1) && (41 != paramArrayOfByte[j]))
          {
            j += 1;
            k += 1;
          }
          m = k;
          int n = i;
          if (40 == paramArrayOfByte[i])
          {
            n = i + 1;
            m = k - 1;
          }
          i = m;
          if (41 == paramArrayOfByte[(n + m - 1)]) {
            i = m - 1;
          }
          if (i > 0) {
            localc.cXB = z(paramArrayOfByte, n, i);
          }
          k = 2;
          i = j;
          j = k;
          break;
        case 3: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          localc.cVV = z(paramArrayOfByte, i, m);
          i = k;
          break;
        case 14: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          str = z(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new b(z(paramArrayOfByte, 0, paramArrayOfByte.length) + "\nutime: " + str);
          }
          localc.cXC = d.fN(str);
          i = k;
          break;
        case 15: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          str = z(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new b(z(paramArrayOfByte, 0, paramArrayOfByte.length) + "\nstime: " + str);
          }
          localc.cXD = d.fN(str);
          i = k;
          break;
        case 16: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          str = z(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new b(z(paramArrayOfByte, 0, paramArrayOfByte.length) + "\ncutime: " + str);
          }
          localc.cXE = d.fN(str);
          i = k;
          break;
        case 17: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          str = z(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new b(z(paramArrayOfByte, 0, paramArrayOfByte.length) + "\ncstime: " + str);
          }
          localc.cXF = d.fN(str);
          i = k;
        }
      }
    }
    return localc;
  }
  
  public static c WE()
  {
    return cy(Process.myPid(), Process.myTid());
  }
  
  public static void a(a parama)
  {
    cXA = parama;
  }
  
  public static c cy(int paramInt1, int paramInt2)
  {
    return fb("/proc/" + paramInt1 + "/task/" + paramInt2 + "/stat");
  }
  
  /* Error */
  private static c e(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 133	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 138	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 140	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 147	java/io/FileInputStream:read	([B)I
    //   34: istore_2
    //   35: aload 4
    //   37: invokevirtual 150	java/io/FileInputStream:close	()V
    //   40: iload_2
    //   41: ifle -25 -> 16
    //   44: aload_1
    //   45: invokestatic 152	com/tencent/matrix/a/b/h:U	([B)Lcom/tencent/matrix/a/b/h$c;
    //   48: areturn
    //   49: astore_3
    //   50: aload_3
    //   51: athrow
    //   52: astore_0
    //   53: aload_3
    //   54: ifnull +39 -> 93
    //   57: aload 4
    //   59: invokevirtual 150	java/io/FileInputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: ldc 154
    //   67: aload_0
    //   68: ldc 156
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 162	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: iconst_m1
    //   78: istore_2
    //   79: goto -39 -> 40
    //   82: astore 4
    //   84: aload_3
    //   85: aload 4
    //   87: invokevirtual 166	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   90: goto -28 -> 62
    //   93: aload 4
    //   95: invokevirtual 150	java/io/FileInputStream:close	()V
    //   98: goto -36 -> 62
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_3
    //   104: goto -51 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   0	107	1	paramArrayOfByte	byte[]
    //   34	45	2	i	int
    //   49	36	3	localThrowable1	Throwable
    //   103	1	3	localObject	Object
    //   26	32	4	localFileInputStream	java.io.FileInputStream
    //   82	12	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	35	49	java/lang/Throwable
    //   50	52	52	finally
    //   18	28	64	java/io/IOException
    //   35	40	64	java/io/IOException
    //   57	62	64	java/io/IOException
    //   62	64	64	java/io/IOException
    //   84	90	64	java/io/IOException
    //   93	98	64	java/io/IOException
    //   57	62	82	java/lang/Throwable
    //   28	35	101	finally
  }
  
  private static c fb(String paramString)
  {
    Object localObject3;
    try
    {
      if (cXz.get() == null) {
        cXz.set(new byte['']);
      }
      localc1 = e(paramString, (byte[])cXz.get());
    }
    catch (b localb1)
    {
      int i;
      for (;;)
      {
        c localc1;
        Object localObject2;
        if (cXA != null) {
          cXA.onError(1, localb1.content);
        }
        localObject1 = null;
      }
      localObject4 = localObject3.substring(0, i);
      localc2.cXB = ((String)localObject4).substring(((String)localObject4).indexOf("(") + 1, i);
      localObject4 = localObject3.substring(i + 1).split(" ");
      if (isNumeric(localObject4[12])) {
        break label364;
      }
      throw new b(localObject3 + "\nutime: " + localObject4[12]);
    }
    catch (Throwable localThrowable)
    {
      c.w("Matrix.battery.ProcStatUtil", "#parseJiffies fail: " + localThrowable.getMessage(), new Object[0]);
      if (cXA == null) {
        break label362;
      }
      cXA.onError(0, b.fa(paramString) + "\n" + localThrowable.getMessage());
      label362:
      return null;
    }
    if (localc1 != null)
    {
      localObject2 = localc1;
      if (localc1.cXB != null) {}
    }
    else
    {
      c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
      c localc2;
      try
      {
        localObject2 = b.fa(paramString);
        localc2 = new c();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i = ((String)localObject2).indexOf(")");
          if (i <= 0) {
            throw new IllegalStateException((String)localObject2 + " has not ')'");
          }
        }
      }
      catch (b localb2)
      {
        localc2 = localc1;
        if (cXA != null)
        {
          cXA.onError(2, localb2.content);
          localc2 = localc1;
        }
      }
      for (;;)
      {
        if (localc2 != null)
        {
          localObject3 = localc2;
          if (localc2.cXB != null) {
            break;
          }
        }
        c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with splits fail", new Object[0]);
        return null;
        Object localObject1;
        Object localObject4;
        label364:
        if (!isNumeric(localObject4[13])) {
          throw new b(localObject3 + "\nstime: " + localObject4[13]);
        }
        if (!isNumeric(localObject4[14])) {
          throw new b(localObject3 + "\ncutime: " + localObject4[14]);
        }
        if (!isNumeric(localObject4[15])) {
          throw new b(localObject3 + "\ncstime: " + localObject4[15]);
        }
        localc2.cVV = localObject4[1];
        localc2.cXC = d.fN(localObject4[12]);
        localc2.cXD = d.fN(localObject4[13]);
        localc2.cXE = d.fN(localObject4[14]);
        localc2.cXF = d.fN(localObject4[15]);
      }
    }
    return localObject3;
  }
  
  private static boolean isNumeric(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.startsWith("-")) {
      return TextUtils.isDigitsOnly(paramString.substring(1));
    }
    return TextUtils.isDigitsOnly(paramString);
  }
  
  public static c jA(int paramInt)
  {
    return fb("/proc/" + paramInt + "/stat");
  }
  
  private static String z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
      paramArrayOfByte = String.valueOf(paramArrayOfByte.array(), 0, paramArrayOfByte.limit());
      return paramArrayOfByte;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      c.w("Matrix.battery.ProcStatUtil", "#safeBytesToString failed: " + paramArrayOfByte.getMessage(), new Object[0]);
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
  }
  
  public static final class b
    extends Exception
  {
    public final String content;
    
    public b(String paramString)
    {
      this.content = paramString;
    }
  }
  
  public static final class c
  {
    public String cVV = "_";
    public String cXB = "";
    public long cXC = -1L;
    public long cXD = -1L;
    public long cXE = -1L;
    public long cXF = -1L;
    
    public final long WF()
    {
      return this.cXC + this.cXD + this.cXE + this.cXF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.h
 * JD-Core Version:    0.7.0.1
 */