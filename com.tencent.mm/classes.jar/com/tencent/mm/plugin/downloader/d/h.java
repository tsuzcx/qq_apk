package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class h
{
  /* Error */
  public static android.util.Pair<ByteBuffer, java.lang.Long> N(File paramFile)
  {
    // Byte code:
    //   0: sipush 2323
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +17 -> 24
    //   10: aload_0
    //   11: invokevirtual 18	java/io/File:exists	()Z
    //   14: ifeq +10 -> 24
    //   17: aload_0
    //   18: invokevirtual 21	java/io/File:isFile	()Z
    //   21: ifne +11 -> 32
    //   24: sipush 2323
    //   27: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: new 26	java/io/RandomAccessFile
    //   35: dup
    //   36: aload_0
    //   37: ldc 28
    //   39: invokespecial 32	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 38	com/tencent/mm/plugin/downloader/d/b:e	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   47: astore_0
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 44	android/util/Pair:second	Ljava/lang/Object;
    //   53: checkcast 46	java/lang/Long
    //   56: invokevirtual 50	java/lang/Long:longValue	()J
    //   59: invokestatic 56	com/tencent/mm/plugin/downloader/d/k:c	(Ljava/io/RandomAccessFile;J)Z
    //   62: ifeq +38 -> 100
    //   65: new 58	com/tencent/mm/plugin/downloader/d/b$b
    //   68: dup
    //   69: ldc 60
    //   71: invokespecial 63	com/tencent/mm/plugin/downloader/d/b$b:<init>	(Ljava/lang/String;)V
    //   74: astore_0
    //   75: sipush 2323
    //   78: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   92: sipush 2323
    //   95: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: athrow
    //   100: aload_1
    //   101: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   104: sipush 2323
    //   107: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -31 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	File
    //   42	73	1	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   43	83	83	finally
    //   32	43	112	finally
  }
  
  public static boolean O(File paramFile)
  {
    AppMethodBeat.i(2324);
    for (;;)
    {
      try
      {
        paramFile = new JarFile(paramFile);
        JarEntry localJarEntry1 = paramFile.getJarEntry("META-INF/MANIFEST.MF");
        Enumeration localEnumeration = paramFile.entries();
        if (localEnumeration.hasMoreElements())
        {
          JarEntry localJarEntry2 = (JarEntry)localEnumeration.nextElement();
          if (!localJarEntry2.getName().matches("META-INF/\\w+\\.SF")) {
            continue;
          }
          paramFile = paramFile.getJarEntry(localJarEntry2.getName());
          if ((localJarEntry1 != null) && (paramFile != null))
          {
            AppMethodBeat.o(2324);
            return true;
          }
        }
      }
      catch (IOException paramFile)
      {
        ab.e("MicroMsg.Channel.V1SchemeUtil", "containV1Signature, error: %s", new Object[] { paramFile.getMessage() });
        AppMethodBeat.o(2324);
        return false;
      }
      paramFile = null;
    }
  }
  
  static void a(int paramInt, DataOutput paramDataOutput)
  {
    AppMethodBeat.i(2325);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)paramInt);
    paramDataOutput.write(localByteBuffer.array());
    AppMethodBeat.o(2325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.h
 * JD-Core Version:    0.7.0.1
 */