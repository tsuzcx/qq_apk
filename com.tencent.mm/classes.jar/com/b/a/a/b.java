package com.b.a.a;

import com.b.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class b
  implements com.b.a.a
{
  private RandomAccessFile aFN;
  private final a aFa;
  public File file;
  
  public b(File paramFile, a parama)
  {
    AppMethodBeat.i(183618);
    if (parama == null) {
      try
      {
        parama = new NullPointerException();
        AppMethodBeat.o(183618);
        throw parama;
      }
      catch (IOException parama)
      {
        paramFile = new n("Error using file " + paramFile + " as disc cache", parama);
        AppMethodBeat.o(183618);
        throw paramFile;
      }
    }
    this.aFa = parama;
    parama = paramFile.getParentFile();
    if (parama.exists())
    {
      if (!parama.isDirectory())
      {
        parama = new IOException("File " + parama + " is not directory!");
        AppMethodBeat.o(183618);
        throw parama;
      }
    }
    else if (!parama.mkdirs())
    {
      parama = new IOException(String.format("Directory %s can't be created", new Object[] { parama.getAbsolutePath() }));
      AppMethodBeat.o(183618);
      throw parama;
    }
    boolean bool = paramFile.exists();
    File localFile;
    if (bool)
    {
      parama = paramFile;
      this.file = parama;
      localFile = this.file;
      if (!bool) {
        break label250;
      }
    }
    label250:
    for (parama = "r";; parama = "rw")
    {
      this.aFN = new RandomAccessFile(localFile, parama);
      AppMethodBeat.o(183618);
      return;
      parama = new File(paramFile.getParentFile(), paramFile.getName() + ".download");
      break;
    }
  }
  
  /* Error */
  public final long available()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 115
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 102	com/b/a/a/b:aFN	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 118	java/io/RandomAccessFile:length	()J
    //   14: lstore_1
    //   15: lload_1
    //   16: l2i
    //   17: i2l
    //   18: lstore_1
    //   19: ldc 115
    //   21: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: lload_1
    //   27: lreturn
    //   28: astore_3
    //   29: new 34	com/b/a/n
    //   32: dup
    //   33: new 36	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 120
    //   39: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 93	com/b/a/a/b:file	Ljava/io/File;
    //   46: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aload_3
    //   53: invokespecial 57	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: astore_3
    //   57: ldc 115
    //   59: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: athrow
    //   64: astore_3
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_3
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	b
    //   14	13	1	l	long
    //   28	25	3	localIOException	IOException
    //   56	7	3	localn	n
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
  public final int c(byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 102	com/b/a/a/b:aFN	Ljava/io/RandomAccessFile;
    //   11: lload_2
    //   12: invokevirtual 127	java/io/RandomAccessFile:seek	(J)V
    //   15: aload_0
    //   16: getfield 102	com/b/a/a/b:aFN	Ljava/io/RandomAccessFile;
    //   19: aload_1
    //   20: iconst_0
    //   21: sipush 8192
    //   24: invokevirtual 131	java/io/RandomAccessFile:read	([BII)I
    //   27: istore 4
    //   29: ldc 123
    //   31: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload 4
    //   38: ireturn
    //   39: astore 5
    //   41: new 34	com/b/a/n
    //   44: dup
    //   45: ldc 133
    //   47: iconst_4
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: sipush 8192
    //   56: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: lload_2
    //   63: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_0
    //   70: invokevirtual 146	com/b/a/a/b:available	()J
    //   73: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: aload_1
    //   80: arraylength
    //   81: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: aload 5
    //   90: invokespecial 57	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: astore_1
    //   94: ldc 123
    //   96: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	b
    //   0	106	1	paramArrayOfByte	byte[]
    //   0	106	2	paramLong	long
    //   27	10	4	i	int
    //   39	50	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   7	29	39	java/io/IOException
    //   2	7	101	finally
    //   7	29	101	finally
    //   29	34	101	finally
    //   41	101	101	finally
  }
  
  public final void c(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      AppMethodBeat.i(183621);
      try
      {
        if (isCompleted())
        {
          paramArrayOfByte = new n("Error append cache: cache file " + this.file + " is completed!");
          AppMethodBeat.o(183621);
          throw paramArrayOfByte;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new n(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[] { Integer.valueOf(paramInt), this.aFN, Integer.valueOf(8192) }), paramArrayOfByte);
        AppMethodBeat.o(183621);
        throw paramArrayOfByte;
      }
      this.aFN.seek(available());
    }
    finally {}
    this.aFN.write(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(183621);
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 164
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 102	com/b/a/a/b:aFN	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 166	java/io/RandomAccessFile:close	()V
    //   14: aload_0
    //   15: getfield 59	com/b/a/a/b:aFa	Lcom/b/a/a/a;
    //   18: aload_0
    //   19: getfield 93	com/b/a/a/b:file	Ljava/io/File;
    //   22: invokeinterface 172 2 0
    //   27: ldc 164
    //   29: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: new 34	com/b/a/n
    //   39: dup
    //   40: new 36	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 174
    //   46: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 93	com/b/a/a/b:file	Ljava/io/File;
    //   53: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 57	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: astore_1
    //   64: ldc 164
    //   66: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	b
    //   35	25	1	localIOException	IOException
    //   63	7	1	localn	n
    //   71	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	35	java/io/IOException
    //   2	7	71	finally
    //   7	27	71	finally
    //   27	32	71	finally
    //   36	71	71	finally
  }
  
  /* Error */
  public final boolean isCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 175
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 93	com/b/a/a/b:file	Ljava/io/File;
    //   11: invokevirtual 106	java/io/File:getName	()Ljava/lang/String;
    //   14: ldc 108
    //   16: invokevirtual 179	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   19: ifne +14 -> 33
    //   22: iconst_1
    //   23: istore_1
    //   24: ldc 175
    //   26: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: ldc 175
    //   37: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -11 -> 29
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	b
    //   23	12	1	bool	boolean
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	43	finally
    //   24	29	43	finally
    //   35	40	43	finally
  }
  
  public final void ph()
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
          localObject1 = new n("Error renaming file " + this.file + " to " + localObject1 + " for completion!");
          AppMethodBeat.o(183623);
          throw ((Throwable)localObject1);
        }
      }
      finally {}
      this.file = localObject2;
      try
      {
        this.aFN = new RandomAccessFile(this.file, "r");
        this.aFa.q(this.file);
        AppMethodBeat.o(183623);
      }
      catch (IOException localIOException)
      {
        n localn = new n("Error opening " + this.file + " as disc cache", localIOException);
        AppMethodBeat.o(183623);
        throw localn;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */