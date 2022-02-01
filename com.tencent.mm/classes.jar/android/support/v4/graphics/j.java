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
  public static File X(Context paramContext)
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
    paramContext = X(paramContext);
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
  
  /* Error */
  public static ByteBuffer a(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 78	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 80
    //   9: aload_1
    //   10: invokevirtual 86	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +15 -> 30
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_1
    //   29: areturn
    //   30: new 93	java/io/FileInputStream
    //   33: dup
    //   34: aload_2
    //   35: invokevirtual 97	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   38: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   41: astore 5
    //   43: aload 5
    //   45: invokevirtual 104	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 110	java/nio/channels/FileChannel:size	()J
    //   53: lstore_3
    //   54: aload_0
    //   55: getstatic 116	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   58: lconst_0
    //   59: lload_3
    //   60: invokevirtual 120	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   63: astore_0
    //   64: aload 5
    //   66: invokevirtual 121	java/io/FileInputStream:close	()V
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: ifnull -44 -> 28
    //   75: aload_2
    //   76: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   79: aload_0
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: athrow
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +39 -> 128
    //   92: aload 5
    //   94: invokevirtual 121	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_1
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: aload_2
    //   104: ifnull +11 -> 115
    //   107: aload_1
    //   108: ifnull +37 -> 145
    //   111: aload_2
    //   112: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore 5
    //   119: aload_1
    //   120: aload 5
    //   122: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   125: goto -28 -> 97
    //   128: aload 5
    //   130: invokevirtual 121	java/io/FileInputStream:close	()V
    //   133: goto -36 -> 97
    //   136: astore_2
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   142: goto -27 -> 115
    //   145: aload_2
    //   146: invokevirtual 91	android/os/ParcelFileDescriptor:close	()V
    //   149: goto -34 -> 115
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -67 -> 88
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_1
    //   161: goto -58 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   0	164	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	164	2	paramUri	android.net.Uri
    //   53	7	3	l	long
    //   41	52	5	localFileInputStream	java.io.FileInputStream
    //   117	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	14	81	java/io/IOException
    //   22	26	81	java/io/IOException
    //   75	79	81	java/io/IOException
    //   111	115	81	java/io/IOException
    //   115	117	81	java/io/IOException
    //   137	142	81	java/io/IOException
    //   145	149	81	java/io/IOException
    //   43	64	84	java/lang/Throwable
    //   85	87	87	finally
    //   30	43	99	java/lang/Throwable
    //   64	69	99	java/lang/Throwable
    //   97	99	99	java/lang/Throwable
    //   119	125	99	java/lang/Throwable
    //   128	133	99	java/lang/Throwable
    //   100	102	102	finally
    //   92	97	117	java/lang/Throwable
    //   111	115	136	java/lang/Throwable
    //   43	64	152	finally
    //   30	43	158	finally
    //   64	69	158	finally
    //   92	97	158	finally
    //   97	99	158	finally
    //   119	125	158	finally
    //   128	133	158	finally
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
    //   0: invokestatic 144	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 4
    //   5: new 146	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
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
    //   29: invokevirtual 155	java/io/InputStream:read	([B)I
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
    //   45: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
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
    //   62: ldc 161
    //   64: invokespecial 16	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_3
    //   68: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: invokestatic 138	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   79: aload 4
    //   81: invokestatic 168	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_3
    //   87: invokestatic 138	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   90: aload 4
    //   92: invokestatic 168	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   95: iconst_1
    //   96: ireturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 138	android/support/v4/graphics/j:closeQuietly	(Ljava/io/Closeable;)V
    //   104: aload 4
    //   106: invokestatic 168	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
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
    //   0: new 93	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 104	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 110	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 116	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 120	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 121	java/io/FileInputStream:close	()V
    //   36: aload_0
    //   37: areturn
    //   38: astore_3
    //   39: aload_3
    //   40: athrow
    //   41: astore_0
    //   42: aload_3
    //   43: ifnull +21 -> 64
    //   46: aload 4
    //   48: invokevirtual 121	java/io/FileInputStream:close	()V
    //   51: aload_0
    //   52: athrow
    //   53: astore 4
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 125	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   61: goto -10 -> 51
    //   64: aload 4
    //   66: invokevirtual 121	java/io/FileInputStream:close	()V
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