package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class d
  implements a
{
  boolean clA;
  String clB;
  private OutputStream clI;
  private com.tencent.qqpinyin.voicerecoapi.a clO;
  private d.a clP;
  BlockingQueue<g.a> clz;
  
  public d()
  {
    AppMethodBeat.i(55775);
    this.clz = new ArrayBlockingQueue(1024);
    this.clA = false;
    AppMethodBeat.o(55775);
  }
  
  public static boolean K(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55781);
    long l = System.currentTimeMillis();
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      ab.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(55781);
      return false;
    }
    Object localObject = new b(paramString1);
    if (!((b)localObject).exists())
    {
      ab.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      AppMethodBeat.o(55781);
      return false;
    }
    ab.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + ((b)localObject).length());
    try
    {
      com.tencent.qqpinyin.voicerecoapi.a locala = new com.tencent.qqpinyin.voicerecoapi.a();
      if (locala.dUe() != 0)
      {
        ab.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
        locala.dUf();
        AppMethodBeat.o(55781);
        return false;
      }
      e.deleteFile(paramString2);
      new b(paramString2).createNewFile();
      byte[] arrayOfByte1 = null;
      localObject = arrayOfByte1;
      try
      {
        byte[] arrayOfByte2 = new byte[4096];
        localObject = arrayOfByte1;
        paramString1 = e.openRead(paramString1);
        for (;;)
        {
          localObject = paramString1;
          int i = paramString1.read(arrayOfByte2);
          if (i <= 0) {
            break;
          }
          localObject = paramString1;
          arrayOfByte1 = locala.Y(arrayOfByte2, i);
          if (arrayOfByte1 == null)
          {
            localObject = paramString1;
            paramString1.close();
            AppMethodBeat.o(55781);
            return false;
          }
          localObject = paramString1;
          int j = e.a(paramString2, arrayOfByte1, arrayOfByte1.length);
          localObject = paramString1;
          ab.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + j + ", readLen = " + i);
        }
        localObject = paramString1;
      }
      catch (Exception paramString1)
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        locala.dUf();
        AppMethodBeat.o(55781);
        return false;
      }
      paramString1.close();
      localObject = paramString1;
      locala.dUf();
      localObject = paramString1;
      ab.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(55781);
      return true;
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + paramString1.getMessage());
      AppMethodBeat.o(55781);
    }
    return false;
  }
  
  /* Error */
  public final void Fb()
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 63
    //   7: ldc 163
    //   9: invokestatic 97	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 40	com/tencent/mm/audio/e/d:clA	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: getfield 165	com/tencent/mm/audio/e/d:clP	Lcom/tencent/mm/audio/e/d$a;
    //   25: ifnull +20 -> 45
    //   28: getstatic 171	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   31: aload_0
    //   32: getfield 165	com/tencent/mm/audio/e/d:clP	Lcom/tencent/mm/audio/e/d$a;
    //   35: invokeinterface 177 2 0
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 165	com/tencent/mm/audio/e/d:clP	Lcom/tencent/mm/audio/e/d$a;
    //   45: aload_0
    //   46: getfield 179	com/tencent/mm/audio/e/d:clO	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   49: ifnull +16 -> 65
    //   52: aload_0
    //   53: getfield 179	com/tencent/mm/audio/e/d:clO	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   56: invokevirtual 108	com/tencent/qqpinyin/voicerecoapi/a:dUf	()I
    //   59: pop
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 179	com/tencent/mm/audio/e/d:clO	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   65: aload_0
    //   66: getfield 181	com/tencent/mm/audio/e/d:clI	Ljava/io/OutputStream;
    //   69: ifnull +15 -> 84
    //   72: aload_0
    //   73: getfield 181	com/tencent/mm/audio/e/d:clI	Ljava/io/OutputStream;
    //   76: invokevirtual 184	java/io/OutputStream:close	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 181	com/tencent/mm/audio/e/d:clI	Ljava/io/OutputStream;
    //   84: ldc 161
    //   86: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: ldc 161
    //   95: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: ldc 63
    //   103: ldc 186
    //   105: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: ldc 63
    //   114: ldc 188
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: invokevirtual 189	java/util/concurrent/ExecutionException:toString	()Ljava/lang/String;
    //   126: aastore
    //   127: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: goto -85 -> 45
    //   133: astore_1
    //   134: ldc 63
    //   136: new 82	java/lang/StringBuilder
    //   139: dup
    //   140: ldc 194
    //   142: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 196	com/tencent/mm/audio/e/d:clB	Ljava/lang/String;
    //   149: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 198
    //   154: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -91 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	d
    //   90	9	1	localObject	Object
    //   100	1	1	localInterruptedException	java.lang.InterruptedException
    //   111	12	1	localExecutionException	java.util.concurrent.ExecutionException
    //   133	25	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	21	90	finally
    //   91	93	90	finally
    //   28	45	100	java/lang/InterruptedException
    //   28	45	111	java/util/concurrent/ExecutionException
    //   72	79	133	java/lang/Exception
  }
  
  public final boolean Fc()
  {
    AppMethodBeat.i(55780);
    if (this.clO != null)
    {
      this.clO.dUf();
      this.clO = null;
    }
    this.clO = new com.tencent.qqpinyin.voicerecoapi.a();
    int i = this.clO.dUe();
    if (i != 0)
    {
      ab.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(i)));
      AppMethodBeat.o(55780);
      return false;
    }
    AppMethodBeat.o(55780);
    return true;
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(55777);
    int i = a(parama, 0, false);
    AppMethodBeat.o(55777);
    return i;
  }
  
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(55778);
    if ((this.clO == null) || (parama.buf == null) || (parama.ckj == 0))
    {
      ab.e("MicroMsg.SpeexWriter", "try write invalid data to file");
      AppMethodBeat.o(55778);
      return -1;
    }
    try
    {
      parama = this.clO.Y(parama.buf, parama.ckj);
      if ((parama != null) && (parama.length > 0))
      {
        ab.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[] { Integer.valueOf(parama.length) });
        this.clI.write(parama);
        this.clI.flush();
        paramInt = parama.length;
        AppMethodBeat.o(55778);
        return paramInt;
      }
      StringBuilder localStringBuilder = new StringBuilder("convert failed: ");
      if (parama == null) {}
      for (parama = "outBuffer is null";; parama = "size is zero")
      {
        ab.e("MicroMsg.SpeexWriter", parama);
        AppMethodBeat.o(55778);
        return -1;
      }
      return -1;
    }
    catch (Exception parama)
    {
      ab.e("MicroMsg.SpeexWriter", "write to file failed", new Object[] { parama });
      AppMethodBeat.o(55778);
    }
  }
  
  public final boolean eN(String paramString)
  {
    AppMethodBeat.i(55776);
    ab.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(55776);
      return false;
    }
    this.clB = paramString;
    try
    {
      this.clI = e.M(paramString, false);
      this.clO = new com.tencent.qqpinyin.voicerecoapi.a();
      int i = this.clO.dUe();
      if (i != 0)
      {
        ab.e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(i)));
        AppMethodBeat.o(55776);
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (this.clI == null) {}
    }
    try
    {
      this.clI.close();
      label108:
      ab.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[] { paramString });
      AppMethodBeat.o(55776);
      return false;
      AppMethodBeat.o(55776);
      return true;
    }
    catch (IOException localIOException)
    {
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.e.d
 * JD-Core Version:    0.7.0.1
 */