package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public final class kb
{
  private static final int a = 4096;
  
  /* Error */
  public static int a(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: ldc 16
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: arraylength
    //   11: ifeq +10 -> 21
    //   14: aload_1
    //   15: invokevirtual 28	java/io/File:isDirectory	()Z
    //   18: ifeq +10 -> 28
    //   21: ldc 16
    //   23: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aconst_null
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_3
    //   33: aload_1
    //   34: invokevirtual 34	java/io/File:exists	()Z
    //   37: ifne +8 -> 45
    //   40: aload_1
    //   41: invokevirtual 37	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 39	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iconst_0
    //   51: invokespecial 42	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 46	java/io/FileOutputStream:write	([B)V
    //   60: aload_1
    //   61: invokevirtual 49	java/io/FileOutputStream:flush	()V
    //   64: aload_0
    //   65: arraylength
    //   66: istore_2
    //   67: aload_1
    //   68: invokestatic 52	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   71: ldc 16
    //   73: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aload_3
    //   80: astore_0
    //   81: aload_0
    //   82: invokestatic 52	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   85: ldc 16
    //   87: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_0
    //   93: aload 4
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 52	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   100: ldc 16
    //   102: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -12 -> 96
    //   111: astore_0
    //   112: aload_1
    //   113: astore_0
    //   114: goto -33 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramArrayOfByte	byte[]
    //   0	117	1	paramFile	File
    //   66	11	2	i	int
    //   32	48	3	localObject1	Object
    //   29	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   33	45	92	finally
    //   45	55	92	finally
    //   55	67	107	finally
    //   55	67	111	java/io/IOException
  }
  
  private static int a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(224976);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(224976);
      return 0;
    }
    int i = a(paramArrayOfByte, new File(paramString));
    AppMethodBeat.o(224976);
    return i;
  }
  
  public static final long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(224968);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(224968);
      return -1L;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      int i;
      for (long l = 0L;; l += i)
      {
        i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      AppMethodBeat.o(224968);
      return l;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(224968);
    }
    return -1L;
  }
  
  public static final InputStream a(File paramFile)
  {
    AppMethodBeat.i(225028);
    try
    {
      if ((paramFile.exists()) && (paramFile.isFile()) && (paramFile.canRead()))
      {
        paramFile = new FileInputStream(paramFile);
        AppMethodBeat.o(225028);
        return paramFile;
      }
    }
    catch (IOException paramFile)
    {
      AppMethodBeat.o(225028);
    }
    return null;
  }
  
  public static final void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(224938);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(224938);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(224938);
  }
  
  private static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(225071);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramOutputStream == null))
    {
      AppMethodBeat.o(225071);
      return;
    }
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      AppMethodBeat.o(225071);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      AppMethodBeat.o(225071);
    }
  }
  
  public static void a(Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(225059);
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Bitmap localBitmap = paramVarArgs[i];
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(225059);
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(225007);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(225007);
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        bool = paramString.isDirectory();
        if (bool)
        {
          AppMethodBeat.o(225007);
          return true;
        }
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      AppMethodBeat.o(225007);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(225007);
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225036);
    paramString1 = new File(paramString1);
    if (paramString1.exists())
    {
      boolean bool = paramString1.renameTo(new File(paramString2));
      AppMethodBeat.o(225036);
      return bool;
    }
    AppMethodBeat.o(225036);
    return false;
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 130
    //   11: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 132	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 133	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: ldc 134
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_0
    //   30: aload_3
    //   31: iconst_0
    //   32: ldc 134
    //   34: invokevirtual 137	java/io/InputStream:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +19 -> 59
    //   43: aload_2
    //   44: aload_3
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   50: aload_2
    //   51: invokevirtual 142	java/io/ByteArrayOutputStream:size	()I
    //   54: ldc 134
    //   56: if_icmplt -27 -> 29
    //   59: aload_2
    //   60: invokevirtual 143	java/io/ByteArrayOutputStream:flush	()V
    //   63: aload_2
    //   64: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: astore_0
    //   68: aload_2
    //   69: invokestatic 52	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   72: ldc 130
    //   74: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: invokestatic 52	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   86: ldc 130
    //   88: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_2
    //   95: astore_0
    //   96: goto -14 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	InputStream
    //   37	10	1	i	int
    //   23	72	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   28	17	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	24	79	finally
    //   24	29	93	finally
    //   29	38	93	finally
    //   43	59	93	finally
    //   59	68	93	finally
  }
  
  public static final InputStream b(String paramString)
  {
    AppMethodBeat.i(225018);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(225018);
      return null;
    }
    try
    {
      paramString = a(new File(paramString));
      AppMethodBeat.o(225018);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(225018);
    }
    return null;
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    AppMethodBeat.i(224959);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(224959);
      return null;
    }
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        byte[] arrayOfByte = new byte[4096];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte, 0, 4096);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        a(paramInputStream);
      }
      finally
      {
        paramInputStream = localByteArrayOutputStream;
      }
    }
    finally
    {
      for (;;)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        paramInputStream = null;
      }
    }
    AppMethodBeat.o(224959);
    return null;
    localByteArrayOutputStream.flush();
    paramInputStream = localByteArrayOutputStream.toByteArray();
    a(localByteArrayOutputStream);
    AppMethodBeat.o(224959);
    return paramInputStream;
  }
  
  private static boolean c(InputStream paramInputStream)
  {
    AppMethodBeat.i(225079);
    if (paramInputStream != null) {}
    try
    {
      if (paramInputStream.available() > 0)
      {
        AppMethodBeat.o(225079);
        return true;
      }
      AppMethodBeat.o(225079);
      return false;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(225079);
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    AppMethodBeat.i(225049);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(225049);
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if (paramString != null) {
            if (paramString.length == 0)
            {
              localFile.delete();
              localStack.pop();
            }
            else
            {
              int j = paramString.length;
              int i = 0;
              label106:
              if (i < j)
              {
                localFile = paramString[i];
                if (!localFile.isDirectory()) {
                  break label141;
                }
                localStack.push(localFile.getAbsolutePath());
              }
              for (;;)
              {
                i += 1;
                break label106;
                break;
                label141:
                localFile.delete();
              }
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    AppMethodBeat.o(225049);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kb
 * JD-Core Version:    0.7.0.1
 */