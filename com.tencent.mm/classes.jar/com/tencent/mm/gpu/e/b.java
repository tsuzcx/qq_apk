package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.File;
import org.xwalk.core.Log;

public final class b
{
  public static boolean mvm;
  private static final MultiProcessMMKV mvn;
  
  static
  {
    AppMethodBeat.i(231778);
    mvm = false;
    mvn = MultiProcessMMKV.getMMKV("mmkv_gpu_so_update");
    AppMethodBeat.o(231778);
  }
  
  /* Error */
  private static byte[] D(File paramFile)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 44	java/io/File:exists	()Z
    //   9: ifne +10 -> 19
    //   12: ldc 38
    //   14: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: new 46	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: aload_0
    //   24: invokevirtual 50	java/io/File:length	()J
    //   27: l2i
    //   28: invokespecial 53	java/io/ByteArrayOutputStream:<init>	(I)V
    //   31: astore 4
    //   33: new 55	java/io/BufferedInputStream
    //   36: dup
    //   37: new 57	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 63	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: aload_2
    //   50: astore_0
    //   51: sipush 1024
    //   54: newarray byte
    //   56: astore_3
    //   57: aload_2
    //   58: astore_0
    //   59: aload_2
    //   60: aload_3
    //   61: iconst_0
    //   62: sipush 1024
    //   65: invokevirtual 67	java/io/BufferedInputStream:read	([BII)I
    //   68: istore_1
    //   69: iconst_m1
    //   70: iload_1
    //   71: if_icmpeq +42 -> 113
    //   74: aload_2
    //   75: astore_0
    //   76: aload 4
    //   78: aload_3
    //   79: iconst_0
    //   80: iload_1
    //   81: invokevirtual 71	java/io/ByteArrayOutputStream:write	([BII)V
    //   84: goto -27 -> 57
    //   87: astore_0
    //   88: aload_2
    //   89: astore_0
    //   90: ldc 73
    //   92: ldc 75
    //   94: invokestatic 81	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload 4
    //   103: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   106: ldc 38
    //   108: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: aload_2
    //   114: astore_0
    //   115: aload 4
    //   117: invokevirtual 91	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: astore_3
    //   121: aload_2
    //   122: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   125: aload 4
    //   127: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   130: ldc 38
    //   132: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   144: aload 4
    //   146: invokestatic 87	com/tencent/g/c/f:closeQuietly	(Ljava/io/Closeable;)V
    //   149: ldc 38
    //   151: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_0
    //   155: athrow
    //   156: astore_2
    //   157: aload_0
    //   158: astore_3
    //   159: aload_2
    //   160: astore_0
    //   161: aload_3
    //   162: astore_2
    //   163: goto -23 -> 140
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -81 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramFile	File
    //   68	13	1	i	int
    //   48	93	2	localBufferedInputStream	java.io.BufferedInputStream
    //   156	4	2	localObject1	Object
    //   162	7	2	localObject2	Object
    //   56	106	3	localObject3	Object
    //   31	114	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	57	87	java/io/IOException
    //   59	69	87	java/io/IOException
    //   76	84	87	java/io/IOException
    //   115	121	87	java/io/IOException
    //   33	49	137	finally
    //   51	57	156	finally
    //   59	69	156	finally
    //   76	84	156	finally
    //   90	97	156	finally
    //   115	121	156	finally
    //   33	49	166	java/io/IOException
  }
  
  private static boolean EN(String paramString)
  {
    AppMethodBeat.i(231762);
    String str = mvn.getString("mmkv_gpu_so_md5", null);
    if (str == null)
    {
      Log.d("MicroMsg.GpuSoUpdateJudge", "isGpuSoUpdateLib32 lastMd5 == null, is first to do md5");
      mvm = true;
    }
    paramString = new File(paramString).listFiles();
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(231762);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramString[i];
      Object localObject = D(localFile);
      if (localObject == null) {
        Log.e("MicroMsg.GpuSoUpdateJudge", "read gpu relative so file content fail");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = g.getMessageDigest((byte[])localObject);
        Log.e("MicroMsg.GpuSoUpdateJudge", "soname = " + localFile.getName() + ", md5 = " + (String)localObject);
        localStringBuilder.append((String)localObject);
      }
    }
    if (mvm)
    {
      mvn.putString("mmkv_gpu_so_md5", localStringBuilder.toString());
      AppMethodBeat.o(231762);
      return true;
    }
    paramString = localStringBuilder.toString();
    Log.d("MicroMsg.GpuSoUpdateJudge", "currMd5 = ".concat(String.valueOf(paramString)));
    if (!paramString.equals(str))
    {
      AppMethodBeat.o(231762);
      return true;
    }
    AppMethodBeat.o(231762);
    return false;
  }
  
  public static boolean aXT()
  {
    AppMethodBeat.i(231750);
    boolean bool1 = EN("/vendor/lib/egl");
    boolean bool2 = EN("/vendor/lib64/egl");
    AppMethodBeat.o(231750);
    return bool1 & bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.gpu.e.b
 * JD-Core Version:    0.7.0.1
 */