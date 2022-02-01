package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getEncoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setEncoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a nzp = new a.a((byte)0);
  private final Object cBq;
  private String mMimeType;
  volatile boolean nxG;
  private q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, ah> nzq;
  private kotlin.g.a.a<ah> nzr;
  aa nzs;
  MediaFormat nzt;
  long nzu;
  private long nzv;
  
  public a(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, ah> paramq, kotlin.g.a.a<ah> parama)
  {
    this.nzq = paramq;
    this.nzr = parama;
    this.cBq = new Object();
    Log.i("MicroMsg.IAudioEncoder", "init audio encoder");
    this.mMimeType = paramMediaFormat.getString("mime");
    for (;;)
    {
      try
      {
        this.nzt = new MediaFormat();
        this.nzt.setString("mime", "audio/mp4a-latm");
        this.nzt.setInteger("aac-profile", 2);
        this.nzt.setInteger("sample-rate", 44100);
        if (!paramMediaFormat.containsKey("channel-count")) {
          break label230;
        }
        i = paramMediaFormat.getInteger("channel-count");
      }
      catch (Exception paramMediaFormat)
      {
        throw new IllegalStateException("init encoder error");
      }
      this.nzt.setInteger("channel-count", i);
      this.nzt.setInteger("bitrate", paramMediaFormat.getInteger("bitrate"));
      this.nzt.setInteger("max-input-size", i * 2048);
      paramMediaFormat = aa.u("audio/mp4a-latm", false);
      s.s(paramMediaFormat, "createEncoderByType(AAC_MIME_TYPE)");
      this.nzs = paramMediaFormat;
      this.nzs.a(this.nzt, null, 1);
      Log.i("MicroMsg.IAudioEncoder", s.X("finish init audio encoder, dstMediaFormat:", this.nzt));
      return;
      label230:
      while (i > 0) {
        break;
      }
      i = j;
    }
  }
  
  public static boolean boY()
  {
    return true;
  }
  
  public abstract void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean);
  
  protected final Object boO()
  {
    return this.cBq;
  }
  
  public final void boX()
  {
    bpa();
  }
  
  public final void boZ()
  {
    bpa();
  }
  
  /* Error */
  protected final void bpa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/tencent/mm/media/e/a:cBq	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 222	com/tencent/mm/media/e/a:nxG	Z
    //   13: ifne +39 -> 52
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 222	com/tencent/mm/media/e/a:nxG	Z
    //   21: ldc 132
    //   23: ldc 223
    //   25: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 193	com/tencent/mm/media/e/a:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   32: invokevirtual 226	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   35: aload_0
    //   36: getfield 193	com/tencent/mm/media/e/a:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   39: invokevirtual 229	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   42: aload_0
    //   43: getfield 128	com/tencent/mm/media/e/a:nzr	Lkotlin/g/a/a;
    //   46: invokeinterface 234 1 0
    //   51: pop
    //   52: ldc 132
    //   54: ldc 236
    //   56: aload_0
    //   57: getfield 238	com/tencent/mm/media/e/a:nzv	J
    //   60: invokestatic 244	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   63: invokestatic 203	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: getstatic 250	kotlin/ah:aiuX	Lkotlin/ah;
    //   72: astore_2
    //   73: aload_1
    //   74: monitorexit
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    //   83: astore_1
    //   84: ldc 132
    //   86: ldc 252
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: goto -27 -> 75
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	a
    //   83	12	1	localException	Exception
    //   105	4	1	localObject2	Object
    //   72	1	2	localah	ah
    //   78	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	52	78	finally
    //   52	73	78	finally
    //   2	9	83	java/lang/Exception
    //   73	75	83	java/lang/Exception
    //   79	83	83	java/lang/Exception
    //   2	9	105	finally
    //   73	75	105	finally
    //   79	83	105	finally
    //   84	102	105	finally
  }
  
  protected final void d(MediaFormat paramMediaFormat)
  {
    s.u(paramMediaFormat, "<set-?>");
    this.nzt = paramMediaFormat;
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    s.u(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer == null) {
      Log.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
    }
    while (paramBufferInfo.size <= 0) {
      return;
    }
    Log.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + paramBufferInfo.size + ", pts:" + paramBufferInfo.presentationTimeUs);
    paramByteBuffer.position(paramBufferInfo.offset);
    paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
    long l = Util.ticksToNow(this.nzu);
    this.nzv += l;
    Log.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + l);
    this.nzq.invoke(paramByteBuffer, paramBufferInfo, this.nzt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */