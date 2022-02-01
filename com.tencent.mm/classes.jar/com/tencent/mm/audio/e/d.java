package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class d
  implements a
{
  private com.tencent.qqpinyin.voicerecoapi.a hyA;
  private d.a hyB;
  BlockingQueue<g.a> hym;
  boolean hyn;
  String hyo;
  private OutputStream mFileOutputStream;
  
  public d()
  {
    AppMethodBeat.i(130024);
    this.hym = new ArrayBlockingQueue(1024);
    this.hyn = false;
    AppMethodBeat.o(130024);
  }
  
  public static boolean ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130030);
    long l = System.currentTimeMillis();
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    Object localObject = new u(paramString1);
    if (!((u)localObject).jKS())
    {
      Log.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(130030);
      return false;
    }
    Log.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + ((u)localObject).length());
    try
    {
      com.tencent.qqpinyin.voicerecoapi.a locala = new com.tencent.qqpinyin.voicerecoapi.a();
      if (locala.jXa() != 0)
      {
        Log.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
        locala.jXb();
        AppMethodBeat.o(130030);
        return false;
      }
      y.deleteFile(paramString2);
      new u(paramString2).jKZ();
      byte[] arrayOfByte1 = null;
      localObject = arrayOfByte1;
      try
      {
        byte[] arrayOfByte2 = new byte[4096];
        localObject = arrayOfByte1;
        paramString1 = y.Lh(paramString1);
        for (;;)
        {
          localObject = paramString1;
          int i = paramString1.read(arrayOfByte2);
          if (i <= 0) {
            break;
          }
          localObject = paramString1;
          arrayOfByte1 = locala.ak(arrayOfByte2, i);
          if (arrayOfByte1 == null)
          {
            localObject = paramString1;
            paramString1.close();
            AppMethodBeat.o(130030);
            return false;
          }
          localObject = paramString1;
          int j = y.e(paramString2, arrayOfByte1, arrayOfByte1.length);
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
        locala.jXb();
        AppMethodBeat.o(130030);
        return false;
      }
      paramString1.close();
      localObject = paramString1;
      locala.jXb();
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
    if ((this.hyA == null) || (parama.buf == null) || (parama.hxg == 0))
    {
      Log.e("MicroMsg.SpeexWriter", "try write invalid data to file");
      AppMethodBeat.o(130027);
      return -1;
    }
    try
    {
      parama = this.hyA.ak(parama.buf, parama.hxg);
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
  
  public final boolean aIA()
  {
    AppMethodBeat.i(130029);
    if (this.hyA != null)
    {
      this.hyA.jXb();
      this.hyA = null;
    }
    this.hyA = new com.tencent.qqpinyin.voicerecoapi.a();
    int i = this.hyA.jXa();
    if (i != 0)
    {
      Log.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(i)));
      AppMethodBeat.o(130029);
      return false;
    }
    AppMethodBeat.o(130029);
    return true;
  }
  
  /* Error */
  public final void aIz()
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 63
    //   7: ldc 227
    //   9: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 40	com/tencent/mm/audio/e/d:hyn	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 229	com/tencent/mm/audio/e/d:hyB	Lcom/tencent/mm/audio/e/d$a;
    //   25: ifnull +18 -> 43
    //   28: ldc 225
    //   30: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: athrow
    //   35: astore_1
    //   36: ldc 63
    //   38: ldc 231
    //   40: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 163	com/tencent/mm/audio/e/d:hyA	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   47: ifnull +16 -> 63
    //   50: aload_0
    //   51: getfield 163	com/tencent/mm/audio/e/d:hyA	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   54: invokevirtual 108	com/tencent/qqpinyin/voicerecoapi/a:jXb	()I
    //   57: pop
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 163	com/tencent/mm/audio/e/d:hyA	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   63: aload_0
    //   64: getfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   67: ifnull +15 -> 82
    //   70: aload_0
    //   71: getfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   74: invokevirtual 232	java/io/OutputStream:close	()V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 189	com/tencent/mm/audio/e/d:mFileOutputStream	Ljava/io/OutputStream;
    //   82: ldc 225
    //   84: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc 225
    //   93: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: ldc 63
    //   101: ldc 234
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: invokevirtual 235	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -74 -> 43
    //   120: astore_1
    //   121: ldc 63
    //   123: new 82	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 237
    //   129: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield 239	com/tencent/mm/audio/e/d:hyo	Ljava/lang/String;
    //   136: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 241
    //   141: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: goto -80 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	d
    //   35	1	1	localInterruptedException	java.lang.InterruptedException
    //   88	9	1	localObject	Object
    //   98	12	1	localExecutionException	java.util.concurrent.ExecutionException
    //   120	25	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   28	35	35	java/lang/InterruptedException
    //   14	21	88	finally
    //   28	35	98	java/util/concurrent/ExecutionException
    //   70	77	120	java/lang/Exception
  }
  
  public final boolean jO(String paramString)
  {
    AppMethodBeat.i(130025);
    Log.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(130025);
      return false;
    }
    this.hyo = paramString;
    try
    {
      this.mFileOutputStream = y.ev(paramString, false);
      this.hyA = new com.tencent.qqpinyin.voicerecoapi.a();
      int i = this.hyA.jXa();
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
      label104:
      Log.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[] { paramString });
      AppMethodBeat.o(130025);
      return false;
      AppMethodBeat.o(130025);
      return true;
    }
    catch (IOException localIOException)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.e.d
 * JD-Core Version:    0.7.0.1
 */