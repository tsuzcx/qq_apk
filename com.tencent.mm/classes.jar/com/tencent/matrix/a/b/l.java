package com.tencent.matrix.a.b;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class l
{
  private static final ThreadLocal<byte[]> eTX = new ThreadLocal();
  private static b eTY;
  
  private static d T(byte[] paramArrayOfByte)
  {
    d locald = new d();
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
            locald.eUa = x(paramArrayOfByte, n, i);
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
          locald.eRO = x(paramArrayOfByte, i, m);
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
          str = x(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new c(x(paramArrayOfByte, 0, paramArrayOfByte.length) + "\nutime: " + str);
          }
          locald.eUb = d.hq(str);
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
          str = x(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new c(x(paramArrayOfByte, 0, paramArrayOfByte.length) + "\nstime: " + str);
          }
          locald.eUc = d.hq(str);
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
          str = x(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new c(x(paramArrayOfByte, 0, paramArrayOfByte.length) + "\ncutime: " + str);
          }
          locald.eUd = d.hq(str);
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
          str = x(paramArrayOfByte, i, m);
          if (!isNumeric(str)) {
            throw new c(x(paramArrayOfByte, 0, paramArrayOfByte.length) + "\ncstime: " + str);
          }
          locald.eUe = d.hq(str);
          i = k;
        }
      }
    }
    return locald;
  }
  
  public static void a(b paramb)
  {
    eTY = paramb;
  }
  
  private static byte[] axA()
  {
    if (eTX.get() == null) {
      eTX.set(new byte['']);
    }
    return (byte[])eTX.get();
  }
  
  public static d axB()
  {
    return dm(Process.myPid(), Process.myTid());
  }
  
  public static d dm(int paramInt1, int paramInt2)
  {
    return gz("/proc/" + paramInt1 + "/task/" + paramInt2 + "/stat");
  }
  
  /* Error */
  private static d f(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 146	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 151	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 153	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 160	java/io/FileInputStream:read	([B)I
    //   34: istore_2
    //   35: aload 4
    //   37: invokevirtual 163	java/io/FileInputStream:close	()V
    //   40: iload_2
    //   41: ifle -25 -> 16
    //   44: aload_1
    //   45: invokestatic 165	com/tencent/matrix/a/b/l:T	([B)Lcom/tencent/matrix/a/b/l$d;
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: athrow
    //   52: astore_3
    //   53: aload_0
    //   54: ifnull +39 -> 93
    //   57: aload 4
    //   59: invokevirtual 163	java/io/FileInputStream:close	()V
    //   62: aload_3
    //   63: athrow
    //   64: astore_0
    //   65: ldc 167
    //   67: aload_0
    //   68: ldc 169
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 175	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: iconst_m1
    //   78: istore_2
    //   79: goto -39 -> 40
    //   82: astore 4
    //   84: aload_0
    //   85: aload 4
    //   87: invokevirtual 181	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   90: goto -28 -> 62
    //   93: aload 4
    //   95: invokevirtual 163	java/io/FileInputStream:close	()V
    //   98: goto -36 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   0	101	1	paramArrayOfByte	byte[]
    //   34	45	2	i	int
    //   52	11	3	localObject	Object
    //   26	32	4	localFileInputStream	java.io.FileInputStream
    //   82	12	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	35	49	finally
    //   50	52	52	finally
    //   18	28	64	java/io/IOException
    //   35	40	64	java/io/IOException
    //   62	64	64	java/io/IOException
    //   84	90	64	java/io/IOException
    //   93	98	64	java/io/IOException
    //   57	62	82	finally
  }
  
  private static d gz(String paramString)
  {
    Object localObject4;
    label566:
    for (;;)
    {
      d locald3;
      Object localObject5;
      try
      {
        d locald1 = a.g(paramString, axA());
        Object localObject3;
        if (locald1 != null)
        {
          localObject3 = locald1;
          if (locald1.eUa != null) {
            break;
          }
        }
        c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with buffer fail, fallback with spilts", new Object[0]);
        try
        {
          localObject3 = b.gy(paramString);
          locald3 = new d();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label566;
          }
          i = ((String)localObject3).indexOf(")");
          if (i > 0) {
            continue;
          }
          throw new IllegalStateException((String)localObject3 + " has not ')'");
        }
        catch (c localc3)
        {
          locald3 = locald1;
          if (eTY != null)
          {
            eTY.onError(2, localc3.content);
            locald3 = locald1;
          }
        }
        if (locald3 != null)
        {
          localObject4 = locald3;
          if (locald3.eUa != null) {
            break;
          }
        }
        c.w("Matrix.battery.ProcStatUtil", "#parseJiffies read with splits fail", new Object[0]);
        return null;
      }
      catch (c localc1)
      {
        int i;
        if (eTY != null) {
          eTY.onError(3, localc1.content);
        }
        try
        {
          d locald2 = f(paramString, axA());
        }
        catch (c localc2)
        {
          if (eTY != null) {
            eTY.onError(1, localc2.content);
          }
          Object localObject1 = null;
        }
        continue;
        localObject5 = localObject4.substring(0, i);
        locald3.eUa = ((String)localObject5).substring(((String)localObject5).indexOf("(") + 1, i);
        localObject5 = localObject4.substring(i + 1).split(" ");
        if (!isNumeric(localObject5[12])) {
          throw new c(localObject4 + "\nutime: " + localObject5[12]);
        }
      }
      finally
      {
        c.w("Matrix.battery.ProcStatUtil", "#parseJiffies fail: " + localObject2.getMessage(), new Object[0]);
        if (eTY != null) {
          eTY.onError(0, b.gy(paramString) + "\n" + localObject2.getMessage());
        }
        return null;
      }
      if (!isNumeric(localObject5[13])) {
        throw new c(localObject4 + "\nstime: " + localObject5[13]);
      }
      if (!isNumeric(localObject5[14])) {
        throw new c(localObject4 + "\ncutime: " + localObject5[14]);
      }
      if (!isNumeric(localObject5[15])) {
        throw new c(localObject4 + "\ncstime: " + localObject5[15]);
      }
      locald3.eRO = localObject5[1];
      locald3.eUb = d.hq(localObject5[12]);
      locald3.eUc = d.hq(localObject5[13]);
      locald3.eUd = d.hq(localObject5[14]);
      locald3.eUe = d.hq(localObject5[15]);
    }
    return localObject4;
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
  
  public static d ng(int paramInt)
  {
    return gz("/proc/" + paramInt + "/stat");
  }
  
  private static String x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
  
  static final class a
  {
    private static final ThreadLocal<k> eTZ = new InheritableThreadLocal();
    
    private static long a(k paramk)
    {
      long l = paramk.axz();
      paramk.s(' ');
      return l;
    }
    
    static l.d g(String paramString, byte[] paramArrayOfByte)
    {
      int k = 1;
      int j = 0;
      k localk = new k(paramString, paramArrayOfByte);
      int i;
      try
      {
        localk.axy();
        localk.s('(');
        paramString = CharBuffer.allocate(16);
        paramString.clear();
        i = 1;
        for (;;)
        {
          if (localk.hasNext())
          {
            localk.next();
            if (')' != localk.eTU)
            {
              paramArrayOfByte = paramString;
              if (!paramString.hasRemaining())
              {
                paramArrayOfByte = CharBuffer.allocate(paramString.capacity() * 2);
                paramString.flip();
                paramArrayOfByte.put(paramString);
              }
              paramArrayOfByte.put(localk.eTU);
              i = 0;
              paramString = paramArrayOfByte;
            }
            else if (i != 0)
            {
              throw new k.a("Couldn't read string!");
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        if ((paramString instanceof l.c)) {
          throw paramString;
        }
      }
      finally {}
      try
      {
        localk.close();
        label142:
        throw paramString;
        localk.bh();
        if (i != 0) {
          throw new k.a("Couldn't read string because file ended!");
        }
        paramString.flip();
        localk.s(' ');
        paramArrayOfByte = CharBuffer.allocate(1);
        paramArrayOfByte.clear();
        i = k;
        while (localk.hasNext())
        {
          localk.next();
          if (!Character.isWhitespace(localk.eTU))
          {
            localObject = paramArrayOfByte;
            if (!paramArrayOfByte.hasRemaining())
            {
              localObject = CharBuffer.allocate(paramArrayOfByte.capacity() * 2);
              paramArrayOfByte.flip();
              ((CharBuffer)localObject).put(paramArrayOfByte);
            }
            ((CharBuffer)localObject).put(localk.eTU);
            i = 0;
            paramArrayOfByte = (byte[])localObject;
          }
          else
          {
            if (i != 0) {
              throw new k.a("Couldn't read string!");
            }
            localk.bh();
          }
        }
        if (i != 0) {
          throw new k.a("Couldn't read string because file ended!");
        }
        paramArrayOfByte.flip();
        i = j;
        while (i < 11)
        {
          localk.s(' ');
          i += 1;
        }
        localObject = new l.d();
        ((l.d)localObject).eUa = String.valueOf(paramString);
        ((l.d)localObject).eRO = String.valueOf(paramArrayOfByte);
        ((l.d)localObject).eUb = a(localk);
        ((l.d)localObject).eUc = a(localk);
        ((l.d)localObject).eUd = a(localk);
        ((l.d)localObject).eUe = a(localk);
        try
        {
          localk.close();
          return localObject;
        }
        catch (Exception paramString)
        {
          return localObject;
        }
        throw new l.c("ProcStatReader error: " + paramString.getClass().getName() + ", " + paramString.getMessage());
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        break label142;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onError(int paramInt, String paramString);
  }
  
  public static final class c
    extends Exception
  {
    public final String content;
    
    public c(String paramString)
    {
      this.content = paramString;
    }
  }
  
  public static final class d
  {
    public String eRO = "_";
    public String eUa = "";
    public long eUb = -1L;
    public long eUc = -1L;
    public long eUd = -1L;
    public long eUe = -1L;
    
    public final long axC()
    {
      return this.eUb + this.eUc + this.eUd + this.eUe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.l
 * JD-Core Version:    0.7.0.1
 */