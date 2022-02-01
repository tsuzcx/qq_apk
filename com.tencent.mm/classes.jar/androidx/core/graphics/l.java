package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import androidx.core.d.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(196111);
    paramContext = ai(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(196111);
      return null;
    }
    try
    {
      boolean bool = a(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = m(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
      AppMethodBeat.o(196111);
    }
  }
  
  /* Error */
  public static ByteBuffer a(Context paramContext, CancellationSignal paramCancellationSignal, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 44	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore_0
    //   10: aload_0
    //   11: aload_2
    //   12: ldc 46
    //   14: aload_1
    //   15: invokevirtual 52	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +18 -> 38
    //   23: aload_0
    //   24: ifnull +7 -> 31
    //   27: aload_0
    //   28: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   31: ldc 38
    //   33: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 60	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 64	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   46: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 72	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 78	java/nio/channels/FileChannel:size	()J
    //   59: lstore_3
    //   60: aload_2
    //   61: getstatic 84	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   64: lconst_0
    //   65: lload_3
    //   66: invokevirtual 88	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   69: astore_2
    //   70: aload_1
    //   71: invokevirtual 89	java/io/FileInputStream:close	()V
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   82: ldc 38
    //   84: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 89	java/io/FileInputStream:close	()V
    //   94: ldc 38
    //   96: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   110: ldc 38
    //   112: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: ldc 38
    //   120: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aload_2
    //   127: aload_1
    //   128: invokevirtual 95	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   131: goto -37 -> 94
    //   134: astore_0
    //   135: aload_1
    //   136: aload_0
    //   137: invokevirtual 95	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   140: goto -30 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   0	143	1	paramCancellationSignal	CancellationSignal
    //   0	143	2	paramUri	Uri
    //   59	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   50	70	89	finally
    //   38	50	101	finally
    //   70	74	101	finally
    //   94	101	101	finally
    //   126	131	101	finally
    //   10	19	117	java/io/IOException
    //   27	31	117	java/io/IOException
    //   78	82	117	java/io/IOException
    //   110	117	117	java/io/IOException
    //   135	140	117	java/io/IOException
    //   90	94	125	finally
    //   106	110	134	finally
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, e.b[] paramArrayOfb, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(196153);
    paramCancellationSignal = new HashMap();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfb[i];
      if (((e.b)localObject).mResultCode == 0)
      {
        localObject = ((e.b)localObject).mUri;
        if (!paramCancellationSignal.containsKey(localObject)) {
          paramCancellationSignal.put(localObject, a(paramContext, null, (Uri)localObject));
        }
      }
      i += 1;
    }
    paramContext = Collections.unmodifiableMap(paramCancellationSignal);
    AppMethodBeat.o(196153);
    return paramContext;
  }
  
  public static boolean a(File paramFile, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(196135);
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
      AppMethodBeat.o(196135);
    }
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 150	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   8: astore 4
    //   10: new 152	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: sipush 1024
    //   25: newarray byte
    //   27: astore 5
    //   29: aload_3
    //   30: astore_0
    //   31: aload_1
    //   32: aload 5
    //   34: invokevirtual 161	java/io/InputStream:read	([B)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_m1
    //   40: if_icmpeq +56 -> 96
    //   43: aload_3
    //   44: astore_0
    //   45: aload_3
    //   46: aload 5
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 165	java/io/FileOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore_0
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: astore_3
    //   61: aload_1
    //   62: astore_0
    //   63: new 167	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 169
    //   69: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_3
    //   73: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: invokestatic 143	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   84: aload 4
    //   86: invokestatic 184	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   89: ldc 144
    //   91: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_3
    //   97: invokestatic 143	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   100: aload 4
    //   102: invokestatic 184	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   105: ldc 144
    //   107: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 143	androidx/core/graphics/l:closeQuietly	(Ljava/io/Closeable;)V
    //   119: aload 4
    //   121: invokestatic 184	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   124: ldc 144
    //   126: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -17 -> 115
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_1
    //   138: goto -77 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramFile	File
    //   0	141	1	paramInputStream	java.io.InputStream
    //   37	13	2	i	int
    //   19	78	3	localObject	Object
    //   135	1	3	localIOException	IOException
    //   8	112	4	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   27	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	29	56	java/io/IOException
    //   31	38	56	java/io/IOException
    //   45	53	56	java/io/IOException
    //   10	20	112	finally
    //   22	29	131	finally
    //   31	38	131	finally
    //   45	53	131	finally
    //   63	80	131	finally
    //   10	20	135	java/io/IOException
  }
  
  public static File ai(Context paramContext)
  {
    AppMethodBeat.i(196073);
    paramContext = paramContext.getCacheDir();
    if (paramContext == null)
    {
      AppMethodBeat.o(196073);
      return null;
    }
    String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
    int i = 0;
    while (i < 100)
    {
      File localFile = new File(paramContext, str + i);
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool)
        {
          AppMethodBeat.o(196073);
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        i += 1;
      }
    }
    AppMethodBeat.o(196073);
    return null;
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(196143);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(196143);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(196143);
  }
  
  /* Error */
  private static ByteBuffer m(File paramFile)
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 60	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 72	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 78	java/nio/channels/FileChannel:size	()J
    //   23: lstore_1
    //   24: aload_3
    //   25: getstatic 84	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   28: lconst_0
    //   29: lload_1
    //   30: invokevirtual 88	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   33: astore_3
    //   34: aload_0
    //   35: invokevirtual 89	java/io/FileInputStream:close	()V
    //   38: ldc 220
    //   40: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_3
    //   44: areturn
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 89	java/io/FileInputStream:close	()V
    //   50: ldc 220
    //   52: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_3
    //   56: athrow
    //   57: astore_0
    //   58: ldc 220
    //   60: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: aload_3
    //   67: aload_0
    //   68: invokevirtual 95	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   71: goto -21 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramFile	File
    //   23	7	1	l	long
    //   18	26	3	localObject1	Object
    //   45	22	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	34	45	finally
    //   5	14	57	java/io/IOException
    //   34	38	57	java/io/IOException
    //   50	57	57	java/io/IOException
    //   66	71	57	java/io/IOException
    //   46	50	65	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.l
 * JD-Core Version:    0.7.0.1
 */