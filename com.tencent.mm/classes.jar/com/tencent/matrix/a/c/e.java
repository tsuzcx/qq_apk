package com.tencent.matrix.a.c;

import android.text.TextUtils;
import com.tencent.matrix.g.d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class e
{
  private static final byte[] sBuffer = new byte[''];
  
  private static a P(byte[] paramArrayOfByte)
  {
    a locala = new a();
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
            locala.cUd = z(paramArrayOfByte, n, i);
          }
          k = 2;
          i = j;
          j = k;
          break;
        case 14: 
          m = 0;
          k = i;
          while ((k < i1) && (!Character.isSpaceChar(paramArrayOfByte[k])))
          {
            k += 1;
            m += 1;
          }
          locala.cUe = d.eT(z(paramArrayOfByte, i, m));
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
          locala.cUf = d.eT(z(paramArrayOfByte, i, m));
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
          locala.cUg = d.eT(z(paramArrayOfByte, i, m));
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
          locala.cUh = d.eT(z(paramArrayOfByte, i, m));
          i = k;
        }
      }
    }
    return locala;
  }
  
  public static a cf(int paramInt1, int paramInt2)
  {
    return ev("/proc/" + paramInt1 + "/task/" + paramInt2 + "/stat");
  }
  
  /* Error */
  private static a e(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 88	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 93	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 95	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 102	java/io/FileInputStream:read	([B)I
    //   34: istore_2
    //   35: aload 4
    //   37: invokevirtual 105	java/io/FileInputStream:close	()V
    //   40: iload_2
    //   41: ifle -25 -> 16
    //   44: aload_1
    //   45: invokestatic 107	com/tencent/matrix/a/c/e:P	([B)Lcom/tencent/matrix/a/c/e$a;
    //   48: areturn
    //   49: astore_3
    //   50: aload_3
    //   51: athrow
    //   52: astore_0
    //   53: aload_3
    //   54: ifnull +39 -> 93
    //   57: aload 4
    //   59: invokevirtual 105	java/io/FileInputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: ldc 109
    //   67: aload_0
    //   68: ldc 111
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 117	com/tencent/matrix/g/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: iconst_m1
    //   78: istore_2
    //   79: goto -39 -> 40
    //   82: astore 4
    //   84: aload_3
    //   85: aload 4
    //   87: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   90: goto -28 -> 62
    //   93: aload 4
    //   95: invokevirtual 105	java/io/FileInputStream:close	()V
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
  
  private static a ev(String paramString)
  {
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = e(paramString, sBuffer);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).cUd != null) {}
      }
      else
      {
        com.tencent.matrix.g.c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
        localObject1 = c.eu(paramString);
        paramString = new a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label188;
        }
        i = ((String)localObject1).indexOf(")");
        if (i > 0) {
          break label107;
        }
        throw new IllegalStateException((String)localObject1 + " has not ')'");
      }
    }
    catch (Throwable paramString)
    {
      com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.ProcStatUtil", paramString, "#parseJiffies fail", new Object[0]);
      localObject1 = null;
    }
    label107:
    do
    {
      return localObject1;
      localObject2 = ((String)localObject1).substring(0, i);
      paramString.cUd = ((String)localObject2).substring(((String)localObject2).indexOf("(") + 1, i);
      localObject1 = ((String)localObject1).substring(i + 1).split(" ");
      paramString.cUe = d.eT(localObject1[12]);
      paramString.cUf = d.eT(localObject1[13]);
      paramString.cUg = d.eT(localObject1[14]);
      paramString.cUh = d.eT(localObject1[15]);
      localObject1 = paramString;
    } while (paramString.cUd != null);
    label188:
    com.tencent.matrix.g.c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with splits fail", new Object[0]);
    return null;
  }
  
  public static a io(int paramInt)
  {
    return ev("/proc/" + paramInt + "/stat");
  }
  
  private static String z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
    return String.valueOf(paramArrayOfByte.array(), 0, paramArrayOfByte.limit());
  }
  
  public static final class a
  {
    public String cUd = "";
    public long cUe = -1L;
    public long cUf = -1L;
    public long cUg = -1L;
    public long cUh = -1L;
    
    public final long Sr()
    {
      return this.cUe + this.cUf + this.cUg + this.cUh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.c.e
 * JD-Core Version:    0.7.0.1
 */