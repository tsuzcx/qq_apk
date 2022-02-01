package com.tencent.mm.audio.e;

import com.tencent.f.i.e;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private com.tencent.qqpinyin.voicerecoapi.a dBB;
  private a dBC;
  BlockingQueue<g.a> dBm;
  boolean dBn;
  String dBo;
  private OutputStream mFileOutputStream;
  
  public d()
  {
    AppMethodBeat.i(130024);
    this.dBm = new ArrayBlockingQueue(1024);
    this.dBn = false;
    AppMethodBeat.o(130024);
  }
  
  public static boolean U(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130030);
    long l = System.currentTimeMillis();
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    Object localObject = new o(paramString1);
    if (!((o)localObject).exists())
    {
      Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    Log.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + ((o)localObject).length());
    try
    {
      com.tencent.qqpinyin.voicerecoapi.a locala = new com.tencent.qqpinyin.voicerecoapi.a();
      if (locala.hkr() != 0)
      {
        Log.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
        locala.hks();
        AppMethodBeat.o(130030);
        return false;
      }
      s.deleteFile(paramString2);
      new o(paramString2).createNewFile();
      byte[] arrayOfByte1 = null;
      localObject = arrayOfByte1;
      try
      {
        byte[] arrayOfByte2 = new byte[4096];
        localObject = arrayOfByte1;
        paramString1 = s.openRead(paramString1);
        for (;;)
        {
          localObject = paramString1;
          int i = paramString1.read(arrayOfByte2);
          if (i <= 0) {
            break;
          }
          localObject = paramString1;
          arrayOfByte1 = locala.ah(arrayOfByte2, i);
          if (arrayOfByte1 == null)
          {
            localObject = paramString1;
            paramString1.close();
            AppMethodBeat.o(130030);
            return false;
          }
          localObject = paramString1;
          int j = s.e(paramString2, arrayOfByte1, arrayOfByte1.length);
          localObject = paramString1;
          Log.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + j + ", readLen = " + i);
        }
        localObject = paramString1;
      }
      catch (Exception paramString1)
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        locala.hks();
        AppMethodBeat.o(130030);
        return false;
      }
      paramString1.close();
      localObject = paramString1;
      locala.hks();
      localObject = paramString1;
      Log.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(130030);
      return true;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + paramString1.getMessage());
      AppMethodBeat.o(130030);
    }
    return false;
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
    if ((this.dBB == null) || (parama.buf == null) || (parama.dAc == 0))
    {
      Log.e("MicroMsg.SpeexWriter", "try write invalid data to file");
      AppMethodBeat.o(130027);
      return -1;
    }
    try
    {
      parama = this.dBB.ah(parama.buf, parama.dAc);
      if ((parama != null) && (parama.length > 0))
      {
        Log.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[] { Integer.valueOf(parama.length) });
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
        Log.e("MicroMsg.SpeexWriter", parama);
        AppMethodBeat.o(130027);
        return -1;
      }
      return -1;
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.SpeexWriter", "write to file failed", new Object[] { parama });
      AppMethodBeat.o(130027);
    }
  }
  
  /* Error */
  public final void abP()
  {
    // Byte code:
    //   0: ldc 214
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 64
    //   7: ldc 216
    //   9: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 41	com/tencent/mm/audio/e/d:dBn	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 218	com/tencent/mm/audio/e/d:dBC	Lcom/tencent/mm/audio/e/d$a;
    //   25: ifnull +30 -> 55
    //   28: aload_0
    //   29: getfield 218	com/tencent/mm/audio/e/d:dBC	Lcom/tencent/mm/audio/e/d$a;
    //   32: astore_1
    //   33: aload_1
    //   34: getfield 222	com/tencent/mm/audio/e/d$a:dBz	Ljava/util/concurrent/Future;
    //   37: ifnull +13 -> 50
    //   40: aload_1
    //   41: getfield 222	com/tencent/mm/audio/e/d$a:dBz	Ljava/util/concurrent/Future;
    //   44: invokeinterface 228 1 0
    //   49: pop
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 218	com/tencent/mm/audio/e/d:dBC	Lcom/tencent/mm/audio/e/d$a;
    //   55: aload_0
    //   56: getfield 163	com/tencent/mm/audio/e/d:dBB	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   59: ifnull +16 -> 75
    //   62: aload_0
    //   63: getfield 163	com/tencent/mm/audio/e/d:dBB	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   66: invokevirtual 109	com/tencent/qqpinyin/voicerecoapi/a:hks	()I
    //   69: pop
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 163	com/tencent/mm/audio/e/d:dBB	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   75: aload_0
    //   76: getfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   79: ifnull +15 -> 94
    //   82: aload_0
    //   83: getfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   86: invokevirtual 229	java/io/OutputStream:close	()V
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   94: ldc 214
    //   96: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: ldc 214
    //   105: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: ldc 64
    //   113: ldc 231
    //   115: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -63 -> 55
    //   121: astore_1
    //   122: ldc 64
    //   124: ldc 233
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: invokevirtual 234	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: goto -85 -> 55
    //   143: astore_1
    //   144: ldc 64
    //   146: new 83	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 236
    //   152: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 238	com/tencent/mm/audio/e/d:dBo	Ljava/lang/String;
    //   159: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 240
    //   164: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final boolean abQ()
  {
    AppMethodBeat.i(130029);
    if (this.dBB != null)
    {
      this.dBB.hks();
      this.dBB = null;
    }
    this.dBB = new com.tencent.qqpinyin.voicerecoapi.a();
    int i = this.dBB.hkr();
    if (i != 0)
    {
      Log.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(i)));
      AppMethodBeat.o(130029);
      return false;
    }
    AppMethodBeat.o(130029);
    return true;
  }
  
  public final boolean hz(String paramString)
  {
    AppMethodBeat.i(130025);
    Log.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(130025);
      return false;
    }
    this.dBo = paramString;
    try
    {
      this.mFileOutputStream = s.dw(paramString, false);
      this.dBB = new com.tencent.qqpinyin.voicerecoapi.a();
      int i = this.dBB.hkr();
      if (i != 0)
      {
        Log.e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(i)));
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
      Log.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[] { paramString });
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
    implements e, h
  {
    Future<?> dBz;
    
    public final void a(Future<?> paramFuture)
    {
      this.dBz = paramFuture;
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
        synchronized (this.dBD)
        {
          boolean bool = this.dBD.dBn;
          Log.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + bool + " queueLen: " + this.dBD.dBm.size());
          if (bool) {
            if (this.dBD.dBm.isEmpty()) {
              break;
            }
          }
        }
        try
        {
          ??? = (g.a)this.dBD.dBm.poll(200L, TimeUnit.MILLISECONDS);
          if (??? != null) {
            break label159;
          }
          Log.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.dBD.dBo);
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
        }
        localObject2 = finally;
        AppMethodBeat.o(130023);
        throw localObject2;
        continue;
        label159:
        this.dBD.a(localInterruptedException, 0, false);
      }
      AppMethodBeat.o(130023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.e.d
 * JD-Core Version:    0.7.0.1
 */