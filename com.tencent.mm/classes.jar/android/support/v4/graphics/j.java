package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class j
{
  public static File U(Context paramContext)
  {
    String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
    int i = 0;
    while (i < 100)
    {
      File localFile = new File(paramContext.getCacheDir(), str + i);
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = U(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = a(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = p(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    Resources localResources = null;
    try
    {
      paramResources = paramResources.openRawResource(paramInt);
      localResources = paramResources;
      boolean bool = a(paramFile, paramResources);
      return bool;
    }
    finally
    {
      closeQuietly(localResources);
    }
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 90	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 4
    //   5: new 92	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_3
    //   15: aload_3
    //   16: astore_0
    //   17: sipush 1024
    //   20: newarray byte
    //   22: astore 5
    //   24: aload_3
    //   25: astore_0
    //   26: aload_1
    //   27: aload 5
    //   29: invokevirtual 101	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpeq +51 -> 86
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: aload 5
    //   43: iconst_0
    //   44: iload_2
    //   45: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   48: goto -24 -> 24
    //   51: astore_0
    //   52: aload_3
    //   53: astore_1
    //   54: aload_0
    //   55: astore_3
    //   56: aload_1
    //   57: astore_0
    //   58: new 10	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 107
    //   64: invokespecial 16	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_3
    //   68: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: invokestatic 84	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   79: aload 4
    //   81: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_3
    //   87: invokestatic 84	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   90: aload 4
    //   92: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   95: iconst_1
    //   96: ireturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 84	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   104: aload 4
    //   106: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -12 -> 100
    //   115: astore_3
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -62 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramFile	File
    //   0	121	1	paramInputStream	java.io.InputStream
    //   32	13	2	i	int
    //   14	73	3	localObject	Object
    //   115	1	3	localIOException	IOException
    //   3	102	4	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   22	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	51	java/io/IOException
    //   26	33	51	java/io/IOException
    //   40	48	51	java/io/IOException
    //   5	15	97	finally
    //   17	24	111	finally
    //   26	33	111	finally
    //   40	48	111	finally
    //   58	75	111	finally
    //   5	15	115	java/io/IOException
  }
  
  /* Error */
  public static ByteBuffer b(Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 122	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: ldc 124
    //   9: aconst_null
    //   10: invokevirtual 130	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +17 -> 34
    //   20: aload 4
    //   22: ifnull +8 -> 30
    //   25: aload 4
    //   27: invokevirtual 135	android/os/ParcelFileDescriptor:close	()V
    //   30: aconst_null
    //   31: astore_1
    //   32: aload_1
    //   33: areturn
    //   34: new 137	java/io/FileInputStream
    //   37: dup
    //   38: aload 4
    //   40: invokevirtual 141	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   43: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 148	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 154	java/nio/channels/FileChannel:size	()J
    //   58: lstore_2
    //   59: aload_0
    //   60: getstatic 160	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   63: lconst_0
    //   64: lload_2
    //   65: invokevirtual 164	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   68: astore_0
    //   69: aload 5
    //   71: invokevirtual 165	java/io/FileInputStream:close	()V
    //   74: aload_0
    //   75: astore_1
    //   76: aload 4
    //   78: ifnull -46 -> 32
    //   81: aload 4
    //   83: invokevirtual 135	android/os/ParcelFileDescriptor:close	()V
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aload_1
    //   93: athrow
    //   94: astore_0
    //   95: aload_1
    //   96: ifnull +41 -> 137
    //   99: aload 5
    //   101: invokevirtual 165	java/io/FileInputStream:close	()V
    //   104: aload_0
    //   105: athrow
    //   106: astore_1
    //   107: aload_1
    //   108: athrow
    //   109: astore_0
    //   110: aload 4
    //   112: ifnull +12 -> 124
    //   115: aload_1
    //   116: ifnull +40 -> 156
    //   119: aload 4
    //   121: invokevirtual 135	android/os/ParcelFileDescriptor:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore 5
    //   128: aload_1
    //   129: aload 5
    //   131: invokevirtual 169	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   134: goto -30 -> 104
    //   137: aload 5
    //   139: invokevirtual 165	java/io/FileInputStream:close	()V
    //   142: goto -38 -> 104
    //   145: astore 4
    //   147: aload_1
    //   148: aload 4
    //   150: invokevirtual 169	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   153: goto -29 -> 124
    //   156: aload 4
    //   158: invokevirtual 135	android/os/ParcelFileDescriptor:close	()V
    //   161: goto -37 -> 124
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -72 -> 95
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -63 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContext	Context
    //   0	176	1	paramUri	android.net.Uri
    //   58	7	2	l	long
    //   13	107	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   145	12	4	localThrowable1	java.lang.Throwable
    //   46	54	5	localFileInputStream	java.io.FileInputStream
    //   126	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	15	88	java/io/IOException
    //   25	30	88	java/io/IOException
    //   81	86	88	java/io/IOException
    //   119	124	88	java/io/IOException
    //   124	126	88	java/io/IOException
    //   147	153	88	java/io/IOException
    //   156	161	88	java/io/IOException
    //   48	69	91	java/lang/Throwable
    //   92	94	94	finally
    //   34	48	106	java/lang/Throwable
    //   69	74	106	java/lang/Throwable
    //   104	106	106	java/lang/Throwable
    //   128	134	106	java/lang/Throwable
    //   137	142	106	java/lang/Throwable
    //   107	109	109	finally
    //   99	104	126	java/lang/Throwable
    //   119	124	145	java/lang/Throwable
    //   48	69	164	finally
    //   34	48	170	finally
    //   69	74	170	finally
    //   99	104	170	finally
    //   104	106	170	finally
    //   128	134	170	finally
    //   137	142	170	finally
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  private static ByteBuffer p(File paramFile)
  {
    // Byte code:
    //   0: new 137	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 148	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 154	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 160	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 164	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 165	java/io/FileInputStream:close	()V
    //   36: aload_0
    //   37: areturn
    //   38: astore_3
    //   39: aload_3
    //   40: athrow
    //   41: astore_0
    //   42: aload_3
    //   43: ifnull +21 -> 64
    //   46: aload 4
    //   48: invokevirtual 165	java/io/FileInputStream:close	()V
    //   51: aload_0
    //   52: athrow
    //   53: astore 4
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 169	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   61: goto -10 -> 51
    //   64: aload 4
    //   66: invokevirtual 165	java/io/FileInputStream:close	()V
    //   69: goto -18 -> 51
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_3
    //   75: goto -33 -> 42
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramFile	File
    //   20	7	1	l	long
    //   38	18	3	localThrowable1	java.lang.Throwable
    //   74	1	3	localObject	Object
    //   8	39	4	localFileInputStream	java.io.FileInputStream
    //   53	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   10	31	38	java/lang/Throwable
    //   39	41	41	finally
    //   46	51	53	java/lang/Throwable
    //   10	31	72	finally
    //   0	10	78	java/io/IOException
    //   31	36	78	java/io/IOException
    //   46	51	78	java/io/IOException
    //   51	53	78	java/io/IOException
    //   55	61	78	java/io/IOException
    //   64	69	78	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.j
 * JD-Core Version:    0.7.0.1
 */