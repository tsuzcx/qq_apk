package com.tencent.mm.audio.e;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class d
  implements a
{
  BlockingQueue<g.a> cXI;
  boolean cXJ;
  String cXK;
  private com.tencent.qqpinyin.voicerecoapi.a cXX;
  private a cXY;
  private OutputStream mFileOutputStream;
  
  public d()
  {
    AppMethodBeat.i(130024);
    this.cXI = new ArrayBlockingQueue(1024);
    this.cXJ = false;
    AppMethodBeat.o(130024);
  }
  
  public static boolean R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130030);
    long l = System.currentTimeMillis();
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      ac.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    Object localObject = new com.tencent.mm.vfs.e(paramString1);
    if (!((com.tencent.mm.vfs.e)localObject).exists())
    {
      ac.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    ac.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + ((com.tencent.mm.vfs.e)localObject).length());
    try
    {
      com.tencent.qqpinyin.voicerecoapi.a locala = new com.tencent.qqpinyin.voicerecoapi.a();
      if (locala.fCp() != 0)
      {
        ac.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
        locala.fCq();
        AppMethodBeat.o(130030);
        return false;
      }
      i.deleteFile(paramString2);
      new com.tencent.mm.vfs.e(paramString2).createNewFile();
      byte[] arrayOfByte1 = null;
      localObject = arrayOfByte1;
      try
      {
        byte[] arrayOfByte2 = new byte[4096];
        localObject = arrayOfByte1;
        paramString1 = i.openRead(paramString1);
        for (;;)
        {
          localObject = paramString1;
          int i = paramString1.read(arrayOfByte2);
          if (i <= 0) {
            break;
          }
          localObject = paramString1;
          arrayOfByte1 = locala.ab(arrayOfByte2, i);
          if (arrayOfByte1 == null)
          {
            localObject = paramString1;
            paramString1.close();
            AppMethodBeat.o(130030);
            return false;
          }
          localObject = paramString1;
          int j = i.e(paramString2, arrayOfByte1, arrayOfByte1.length);
          localObject = paramString1;
          ac.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + j + ", readLen = " + i);
        }
        localObject = paramString1;
      }
      catch (Exception paramString1)
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        locala.fCq();
        AppMethodBeat.o(130030);
        return false;
      }
      paramString1.close();
      localObject = paramString1;
      locala.fCq();
      localObject = paramString1;
      ac.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(130030);
      return true;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + paramString1.getMessage());
      AppMethodBeat.o(130030);
    }
    return false;
  }
  
  /* Error */
  public final void PM()
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 64
    //   7: ldc 163
    //   9: invokestatic 98	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 41	com/tencent/mm/audio/e/d:cXJ	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 165	com/tencent/mm/audio/e/d:cXY	Lcom/tencent/mm/audio/e/d$a;
    //   25: ifnull +30 -> 55
    //   28: aload_0
    //   29: getfield 165	com/tencent/mm/audio/e/d:cXY	Lcom/tencent/mm/audio/e/d$a;
    //   32: astore_1
    //   33: aload_1
    //   34: getfield 169	com/tencent/mm/audio/e/d$a:cXV	Ljava/util/concurrent/Future;
    //   37: ifnull +13 -> 50
    //   40: aload_1
    //   41: getfield 169	com/tencent/mm/audio/e/d$a:cXV	Ljava/util/concurrent/Future;
    //   44: invokeinterface 175 1 0
    //   49: pop
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 165	com/tencent/mm/audio/e/d:cXY	Lcom/tencent/mm/audio/e/d$a;
    //   55: aload_0
    //   56: getfield 177	com/tencent/mm/audio/e/d:cXX	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   59: ifnull +16 -> 75
    //   62: aload_0
    //   63: getfield 177	com/tencent/mm/audio/e/d:cXX	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   66: invokevirtual 109	com/tencent/qqpinyin/voicerecoapi/a:fCq	()I
    //   69: pop
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 177	com/tencent/mm/audio/e/d:cXX	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   75: aload_0
    //   76: getfield 179	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   79: ifnull +15 -> 94
    //   82: aload_0
    //   83: getfield 179	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   86: invokevirtual 182	java/io/OutputStream:close	()V
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 179	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   94: ldc 161
    //   96: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: ldc 161
    //   105: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: ldc 64
    //   113: ldc 184
    //   115: invokestatic 72	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -63 -> 55
    //   121: astore_1
    //   122: ldc 64
    //   124: ldc 186
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: invokevirtual 187	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 190	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: goto -85 -> 55
    //   143: astore_1
    //   144: ldc 64
    //   146: new 83	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 192
    //   152: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 194	com/tencent/mm/audio/e/d:cXK	Ljava/lang/String;
    //   159: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 196
    //   164: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 72	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -91 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	d
    //   32	9	1	locala	a
    //   100	9	1	localObject	Object
    //   110	1	1	localInterruptedException	InterruptedException
    //   121	12	1	localExecutionException	java.util.concurrent.ExecutionException
    //   143	25	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	21	100	finally
    //   101	103	100	finally
    //   28	50	110	java/lang/InterruptedException
    //   50	55	110	java/lang/InterruptedException
    //   28	50	121	java/util/concurrent/ExecutionException
    //   50	55	121	java/util/concurrent/ExecutionException
    //   82	89	143	java/lang/Exception
  }
  
  public final boolean PN()
  {
    AppMethodBeat.i(130029);
    if (this.cXX != null)
    {
      this.cXX.fCq();
      this.cXX = null;
    }
    this.cXX = new com.tencent.qqpinyin.voicerecoapi.a();
    int i = this.cXX.fCp();
    if (i != 0)
    {
      ac.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(i)));
      AppMethodBeat.o(130029);
      return false;
    }
    AppMethodBeat.o(130029);
    return true;
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(130026);
    int i = a(parama, 0, false);
    AppMethodBeat.o(130026);
    return i;
  }
  
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(130027);
    if ((this.cXX == null) || (parama.buf == null) || (parama.cWy == 0))
    {
      ac.e("MicroMsg.SpeexWriter", "try write invalid data to file");
      AppMethodBeat.o(130027);
      return -1;
    }
    try
    {
      parama = this.cXX.ab(parama.buf, parama.cWy);
      if ((parama != null) && (parama.length > 0))
      {
        ac.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[] { Integer.valueOf(parama.length) });
        this.mFileOutputStream.write(parama);
        this.mFileOutputStream.flush();
        paramInt = parama.length;
        AppMethodBeat.o(130027);
        return paramInt;
      }
      StringBuilder localStringBuilder = new StringBuilder("convert failed: ");
      if (parama == null) {}
      for (parama = "outBuffer is null";; parama = "size is zero")
      {
        ac.e("MicroMsg.SpeexWriter", parama);
        AppMethodBeat.o(130027);
        return -1;
      }
      return -1;
    }
    catch (Exception parama)
    {
      ac.e("MicroMsg.SpeexWriter", "write to file failed", new Object[] { parama });
      AppMethodBeat.o(130027);
    }
  }
  
  public final boolean fH(String paramString)
  {
    AppMethodBeat.i(130025);
    ac.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(130025);
      return false;
    }
    this.cXK = paramString;
    try
    {
      this.mFileOutputStream = i.cS(paramString, false);
      this.cXX = new com.tencent.qqpinyin.voicerecoapi.a();
      int i = this.cXX.fCp();
      if (i != 0)
      {
        ac.e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(i)));
        AppMethodBeat.o(130025);
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (this.mFileOutputStream == null) {}
    }
    try
    {
      this.mFileOutputStream.close();
      label105:
      ac.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[] { paramString });
      AppMethodBeat.o(130025);
      return false;
      AppMethodBeat.o(130025);
      return true;
    }
    catch (IOException localIOException)
    {
      break label105;
    }
  }
  
  final class a
    implements com.tencent.e.i.e, h
  {
    Future<?> cXV;
    
    public final void a(Future<?> paramFuture)
    {
      this.cXV = paramFuture;
    }
    
    public final String getKey()
    {
      return "SpeexWriter_run";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130023);
      for (;;)
      {
        synchronized (this.cXZ)
        {
          boolean bool = this.cXZ.cXJ;
          ac.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + bool + " queueLen: " + this.cXZ.cXI.size());
          if (bool) {
            if (this.cXZ.cXI.isEmpty()) {
              break;
            }
          }
        }
        try
        {
          ??? = (g.a)this.cXZ.cXI.poll(200L, TimeUnit.MILLISECONDS);
          if (??? != null) {
            break label159;
          }
          ac.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.cXZ.cXK);
        }
        catch (InterruptedException localInterruptedException)
        {
          ac.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
        }
        localObject2 = finally;
        AppMethodBeat.o(130023);
        throw localObject2;
        continue;
        label159:
        this.cXZ.a(localInterruptedException, 0, false);
      }
      AppMethodBeat.o(130023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.e.d
 * JD-Core Version:    0.7.0.1
 */