package com.tencent.mm.f.c;

import com.tencent.mm.f.b.g.a;
import com.tencent.mm.sdk.platformtools.y;
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
  private com.tencent.qqpinyin.voicerecoapi.a bED;
  private d.a bEE;
  BlockingQueue<g.a> bEq = new ArrayBlockingQueue(1024);
  boolean bEr = false;
  String bEs;
  private OutputStream bEy;
  
  public static boolean y(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      y.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      return false;
    }
    Object localObject = new b(paramString1);
    if (!((b)localObject).exists())
    {
      y.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
      return false;
    }
    y.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + ((b)localObject).length());
    com.tencent.qqpinyin.voicerecoapi.a locala;
    try
    {
      locala = new com.tencent.qqpinyin.voicerecoapi.a();
      if (locala.cOq() != 0)
      {
        y.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
        locala.cOr();
        return false;
      }
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + paramString1.getMessage());
      return false;
    }
    e.deleteFile(paramString2);
    new b(paramString2).createNewFile();
    byte[] arrayOfByte1 = null;
    localObject = arrayOfByte1;
    for (;;)
    {
      int i;
      try
      {
        byte[] arrayOfByte2 = new byte[4096];
        localObject = arrayOfByte1;
        paramString1 = e.openRead(paramString1);
        localObject = paramString1;
        i = paramString1.read(arrayOfByte2);
        if (i <= 0) {
          break;
        }
        localObject = paramString1;
        arrayOfByte1 = locala.X(arrayOfByte2, i);
        if (arrayOfByte1 == null)
        {
          localObject = paramString1;
          paramString1.close();
          return false;
        }
      }
      catch (Exception paramString1)
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        locala.cOr();
        return false;
      }
      localObject = paramString1;
      int j = e.a(paramString2, arrayOfByte1, arrayOfByte1.length);
      localObject = paramString1;
      y.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + j + ", readLen = " + i);
    }
    localObject = paramString1;
    paramString1.close();
    localObject = paramString1;
    locala.cOr();
    localObject = paramString1;
    y.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - l));
    return true;
  }
  
  public final int a(g.a parama)
  {
    return a(parama, 0, false);
  }
  
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    if ((this.bED == null) || (parama.buf == null) || (parama.bDu == 0))
    {
      y.e("MicroMsg.SpeexWriter", "try write invalid data to file");
      return -1;
    }
    for (;;)
    {
      try
      {
        parama = this.bED.X(parama.buf, parama.bDu);
        if ((parama != null) && (parama.length > 0))
        {
          y.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[] { Integer.valueOf(parama.length) });
          this.bEy.write(parama);
          this.bEy.flush();
          return parama.length;
        }
        StringBuilder localStringBuilder = new StringBuilder("convert failed: ");
        if (parama == null)
        {
          parama = "outBuffer is null";
          y.e("MicroMsg.SpeexWriter", parama);
          return -1;
        }
      }
      catch (Exception parama)
      {
        y.e("MicroMsg.SpeexWriter", "write to file failed", new Object[] { parama });
        return -1;
      }
      parama = "size is zero";
    }
  }
  
  public final boolean cG(String paramString)
  {
    y.i("MicroMsg.SpeexWriter", "initWriter, path: " + paramString);
    if (paramString == null) {
      return false;
    }
    this.bEs = paramString;
    try
    {
      this.bEy = e.I(paramString, false);
      this.bED = new com.tencent.qqpinyin.voicerecoapi.a();
      int i = this.bED.cOq();
      if (i != 0)
      {
        y.e("MicroMsg.SpeexWriter", "speexInit failed: " + i);
        return false;
      }
    }
    catch (Exception paramString)
    {
      if (this.bEy == null) {}
    }
    try
    {
      this.bEy.close();
      label102:
      y.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[] { paramString });
      return false;
      return true;
    }
    catch (IOException localIOException)
    {
      break label102;
    }
  }
  
  /* Error */
  public final void uE()
  {
    // Byte code:
    //   0: ldc 53
    //   2: ldc 217
    //   4: invokestatic 88	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 34	com/tencent/mm/f/c/d:bEr	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield 219	com/tencent/mm/f/c/d:bEE	Lcom/tencent/mm/f/c/d$a;
    //   20: ifnull +15 -> 35
    //   23: aload_0
    //   24: getfield 219	com/tencent/mm/f/c/d:bEE	Lcom/tencent/mm/f/c/d$a;
    //   27: invokestatic 225	com/tencent/mm/sdk/f/e:aa	(Ljava/lang/Runnable;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 219	com/tencent/mm/f/c/d:bEE	Lcom/tencent/mm/f/c/d$a;
    //   35: aload_0
    //   36: getfield 152	com/tencent/mm/f/c/d:bED	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   39: ifnull +16 -> 55
    //   42: aload_0
    //   43: getfield 152	com/tencent/mm/f/c/d:bED	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   46: invokevirtual 99	com/tencent/qqpinyin/voicerecoapi/a:cOr	()I
    //   49: pop
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 152	com/tencent/mm/f/c/d:bED	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   55: aload_0
    //   56: getfield 178	com/tencent/mm/f/c/d:bEy	Ljava/io/OutputStream;
    //   59: ifnull +15 -> 74
    //   62: aload_0
    //   63: getfield 178	com/tencent/mm/f/c/d:bEy	Ljava/io/OutputStream;
    //   66: invokevirtual 210	java/io/OutputStream:close	()V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 178	com/tencent/mm/f/c/d:bEy	Ljava/io/OutputStream;
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: ldc 53
    //   83: ldc 227
    //   85: invokestatic 61	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -53 -> 35
    //   91: astore_1
    //   92: ldc 53
    //   94: new 72	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 229
    //   100: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 204	com/tencent/mm/f/c/d:bEs	Ljava/lang/String;
    //   107: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 231
    //   112: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 61	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: goto -59 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	d
    //   75	4	1	localObject	Object
    //   80	1	1	localInterruptedException	java.lang.InterruptedException
    //   91	25	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	16	75	finally
    //   76	78	75	finally
    //   23	35	80	java/lang/InterruptedException
    //   62	69	91	java/lang/Exception
  }
  
  public final boolean uF()
  {
    if (this.bED != null)
    {
      this.bED.cOr();
      this.bED = null;
    }
    this.bED = new com.tencent.qqpinyin.voicerecoapi.a();
    int i = this.bED.cOq();
    if (i != 0)
    {
      y.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: " + i);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.d
 * JD-Core Version:    0.7.0.1
 */