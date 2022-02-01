package com.danikula.videocache.file;

import com.danikula.videocache.Cache;
import com.danikula.videocache.ProxyCacheException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCache
  implements Cache
{
  private static final String TEMP_POSTFIX = ".download";
  private RandomAccessFile dataFile;
  private final DiskUsage diskUsage;
  public File file;
  
  public FileCache(File paramFile)
  {
    this(paramFile, new UnlimitedDiskUsage());
    AppMethodBeat.i(190345);
    AppMethodBeat.o(190345);
  }
  
  public FileCache(File paramFile, DiskUsage paramDiskUsage)
  {
    AppMethodBeat.i(183618);
    if (paramDiskUsage == null) {
      try
      {
        paramDiskUsage = new NullPointerException();
        AppMethodBeat.o(183618);
        throw paramDiskUsage;
      }
      catch (IOException paramDiskUsage)
      {
        paramFile = new ProxyCacheException("Error using file " + paramFile + " as disc cache", paramDiskUsage);
        AppMethodBeat.o(183618);
        throw paramFile;
      }
    }
    this.diskUsage = paramDiskUsage;
    Files.makeDir(paramFile.getParentFile());
    boolean bool = paramFile.exists();
    File localFile;
    if (bool)
    {
      paramDiskUsage = paramFile;
      this.file = paramDiskUsage;
      localFile = this.file;
      if (!bool) {
        break label164;
      }
    }
    label164:
    for (paramDiskUsage = "r";; paramDiskUsage = "rw")
    {
      this.dataFile = new RandomAccessFile(localFile, paramDiskUsage);
      AppMethodBeat.o(183618);
      return;
      paramDiskUsage = new File(paramFile.getParentFile(), paramFile.getName() + ".download");
      break;
    }
  }
  
  private boolean isTempFile(File paramFile)
  {
    AppMethodBeat.i(190347);
    boolean bool = paramFile.getName().endsWith(".download");
    AppMethodBeat.o(190347);
    return bool;
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      AppMethodBeat.i(183621);
      try
      {
        if (isCompleted())
        {
          ProxyCacheException localProxyCacheException = new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
          AppMethodBeat.o(183621);
          throw localProxyCacheException;
        }
      }
      catch (IOException localIOException)
      {
        paramArrayOfByte = new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[] { Integer.valueOf(paramInt), this.dataFile, Integer.valueOf(paramArrayOfByte.length) }), localIOException);
        AppMethodBeat.o(183621);
        throw paramArrayOfByte;
      }
      this.dataFile.seek(available());
    }
    finally {}
    this.dataFile.write(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(183621);
  }
  
  /* Error */
  public long available()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 97	com/danikula/videocache/file/FileCache:dataFile	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 151	java/io/RandomAccessFile:length	()J
    //   14: lstore_1
    //   15: lload_1
    //   16: l2i
    //   17: i2l
    //   18: lstore_1
    //   19: ldc 148
    //   21: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: lload_1
    //   27: lreturn
    //   28: astore_3
    //   29: new 46	com/danikula/videocache/ProxyCacheException
    //   32: dup
    //   33: new 48	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 153
    //   39: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 88	com/danikula/videocache/file/FileCache:file	Ljava/io/File;
    //   46: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aload_3
    //   53: invokespecial 69	com/danikula/videocache/ProxyCacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: astore_3
    //   57: ldc 148
    //   59: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: athrow
    //   64: astore_3
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_3
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	FileCache
    //   14	13	1	l	long
    //   28	25	3	localIOException	IOException
    //   56	7	3	localProxyCacheException	ProxyCacheException
    //   64	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	15	28	java/io/IOException
    //   2	7	64	finally
    //   7	15	64	finally
    //   19	24	64	finally
    //   29	64	64	finally
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 97	com/danikula/videocache/file/FileCache:dataFile	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 157	java/io/RandomAccessFile:close	()V
    //   14: aload_0
    //   15: getfield 71	com/danikula/videocache/file/FileCache:diskUsage	Lcom/danikula/videocache/file/DiskUsage;
    //   18: aload_0
    //   19: getfield 88	com/danikula/videocache/file/FileCache:file	Ljava/io/File;
    //   22: invokeinterface 162 2 0
    //   27: ldc 155
    //   29: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: new 46	com/danikula/videocache/ProxyCacheException
    //   39: dup
    //   40: new 48	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 164
    //   46: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 88	com/danikula/videocache/file/FileCache:file	Ljava/io/File;
    //   53: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 69	com/danikula/videocache/ProxyCacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: astore_1
    //   64: ldc 155
    //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FileCache
    //   35	25	1	localIOException	IOException
    //   63	7	1	localProxyCacheException	ProxyCacheException
    //   71	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	35	java/io/IOException
    //   2	7	71	finally
    //   7	27	71	finally
    //   27	32	71	finally
    //   36	71	71	finally
  }
  
  public void complete()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(183623);
        if (isCompleted())
        {
          AppMethodBeat.o(183623);
          return;
        }
        close();
        Object localObject1 = this.file.getName().substring(0, this.file.getName().length() - 9);
        localObject1 = new File(this.file.getParentFile(), (String)localObject1);
        if (!this.file.renameTo((File)localObject1))
        {
          localObject1 = new ProxyCacheException("Error renaming file " + this.file + " to " + localObject1 + " for completion!");
          AppMethodBeat.o(183623);
          throw ((Throwable)localObject1);
        }
      }
      finally {}
      this.file = localObject2;
      try
      {
        this.dataFile = new RandomAccessFile(this.file, "r");
        this.diskUsage.touch(this.file);
        AppMethodBeat.o(183623);
      }
      catch (IOException localIOException)
      {
        ProxyCacheException localProxyCacheException = new ProxyCacheException("Error opening " + this.file + " as disc cache", localIOException);
        AppMethodBeat.o(183623);
        throw localProxyCacheException;
      }
    }
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  /* Error */
  public boolean isCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 187
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 88	com/danikula/videocache/file/FileCache:file	Ljava/io/File;
    //   12: invokespecial 189	com/danikula/videocache/file/FileCache:isTempFile	(Ljava/io/File;)Z
    //   15: ifne +14 -> 29
    //   18: iconst_1
    //   19: istore_1
    //   20: ldc 187
    //   22: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc 187
    //   33: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -11 -> 25
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	FileCache
    //   19	12	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	39	finally
    //   20	25	39	finally
    //   31	36	39	finally
  }
  
  /* Error */
  public int read(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 192
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 97	com/danikula/videocache/file/FileCache:dataFile	Ljava/io/RandomAccessFile;
    //   11: lload_2
    //   12: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   15: aload_0
    //   16: getfield 97	com/danikula/videocache/file/FileCache:dataFile	Ljava/io/RandomAccessFile;
    //   19: aload_1
    //   20: iconst_0
    //   21: iload 4
    //   23: invokevirtual 195	java/io/RandomAccessFile:read	([BII)I
    //   26: istore 5
    //   28: ldc 192
    //   30: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 5
    //   37: ireturn
    //   38: astore 6
    //   40: new 46	com/danikula/videocache/ProxyCacheException
    //   43: dup
    //   44: ldc 197
    //   46: iconst_4
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: iload 4
    //   54: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: lload_2
    //   61: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: aload_0
    //   68: invokevirtual 139	com/danikula/videocache/file/FileCache:available	()J
    //   71: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: aload_1
    //   78: arraylength
    //   79: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: aload 6
    //   88: invokespecial 69	com/danikula/videocache/ProxyCacheException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: astore_1
    //   92: ldc 192
    //   94: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	FileCache
    //   0	104	1	paramArrayOfByte	byte[]
    //   0	104	2	paramLong	long
    //   0	104	4	paramInt	int
    //   26	10	5	i	int
    //   38	49	6	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   7	28	38	java/io/IOException
    //   2	7	99	finally
    //   7	28	99	finally
    //   28	33	99	finally
    //   40	99	99	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.file.FileCache
 * JD-Core Version:    0.7.0.1
 */