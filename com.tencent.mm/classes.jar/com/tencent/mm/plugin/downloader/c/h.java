package com.tencent.mm.plugin.downloader.c;

import com.tencent.mm.sdk.platformtools.y;
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
  public static android.util.Pair<ByteBuffer, java.lang.Long> F(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 12	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 15	java/io/File:isFile	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 17	java/io/RandomAccessFile
    //   23: dup
    //   24: aload_0
    //   25: ldc 19
    //   27: invokespecial 23	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 29	com/tencent/mm/plugin/downloader/c/b:e	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   35: astore_0
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 35	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 37	java/lang/Long
    //   44: invokevirtual 41	java/lang/Long:longValue	()J
    //   47: invokestatic 47	com/tencent/mm/plugin/downloader/c/k:c	(Ljava/io/RandomAccessFile;J)Z
    //   50: ifeq +24 -> 74
    //   53: new 49	com/tencent/mm/plugin/downloader/c/b$b
    //   56: dup
    //   57: ldc 51
    //   59: invokespecial 54	com/tencent/mm/plugin/downloader/c/b$b:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: astore_0
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 58	java/io/RandomAccessFile:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: aload_1
    //   75: invokevirtual 58	java/io/RandomAccessFile:close	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_1
    //   83: goto -19 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramFile	File
    //   30	53	1	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   31	63	63	finally
    //   20	31	80	finally
  }
  
  public static boolean G(File paramFile)
  {
    for (;;)
    {
      try
      {
        paramFile = new JarFile(paramFile);
        JarEntry localJarEntry1 = paramFile.getJarEntry("META-INF/MANIFEST.MF");
        Enumeration localEnumeration = paramFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break label92;
        }
        JarEntry localJarEntry2 = (JarEntry)localEnumeration.nextElement();
        if (!localJarEntry2.getName().matches("META-INF/\\w+\\.SF")) {
          continue;
        }
        paramFile = paramFile.getJarEntry(localJarEntry2.getName());
        if ((localJarEntry1 != null) && (paramFile != null)) {
          return true;
        }
      }
      catch (IOException paramFile)
      {
        y.e("MicroMsg.Channel.V1SchemeUtil", "containV1Signature, error: %s", new Object[] { paramFile.getMessage() });
      }
      return false;
      label92:
      paramFile = null;
    }
  }
  
  static void a(int paramInt, DataOutput paramDataOutput)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putShort((short)paramInt);
    paramDataOutput.write(localByteBuffer.array());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.h
 * JD-Core Version:    0.7.0.1
 */