package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getEncoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setEncoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a kTN = new a((byte)0);
  private final Object aFF;
  volatile boolean kSa;
  aa kTH;
  MediaFormat kTI;
  long kTJ;
  private long kTK;
  private q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> kTL;
  private kotlin.g.a.a<x> kTM;
  private String mMimeType;
  
  public a(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> paramq, kotlin.g.a.a<x> parama)
  {
    this.kTL = paramq;
    this.kTM = parama;
    this.aFF = new Object();
    Log.i("MicroMsg.IAudioEncoder", "init audio encoder");
    this.mMimeType = paramMediaFormat.getString("mime");
    for (;;)
    {
      try
      {
        this.kTI = new MediaFormat();
        this.kTI.setString("mime", "audio/mp4a-latm");
        this.kTI.setInteger("aac-profile", 2);
        this.kTI.setInteger("sample-rate", 44100);
        if (paramMediaFormat.containsKey("channel-count"))
        {
          i = paramMediaFormat.getInteger("channel-count");
          break label245;
          this.kTI.setInteger("channel-count", i);
          this.kTI.setInteger("bitrate", paramMediaFormat.getInteger("bitrate"));
          this.kTI.setInteger("max-input-size", i * 2048);
          paramMediaFormat = aa.KS("audio/mp4a-latm");
          p.j(paramMediaFormat, "MediaCodecProxy.createEncoderByType(AAC_MIME_TYPE)");
          this.kTH = paramMediaFormat;
          this.kTH.a(this.kTI, null, 1);
          Log.i("MicroMsg.IAudioEncoder", "finish init audio encoder, dstMediaFormat:" + this.kTI);
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramMediaFormat)
      {
        throw ((Throwable)new IllegalStateException("init encoder error"));
      }
      label245:
      while (i > 0) {
        break;
      }
      int i = j;
    }
  }
  
  protected final Object aUl()
  {
    return this.aFF;
  }
  
  public final void aUw()
  {
    aUy();
  }
  
  public final void aUx()
  {
    aUy();
  }
  
  /* Error */
  protected final void aUy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/tencent/mm/media/e/a:aFF	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 225	com/tencent/mm/media/e/a:kSa	Z
    //   13: ifne +39 -> 52
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 225	com/tencent/mm/media/e/a:kSa	Z
    //   21: ldc 130
    //   23: ldc 226
    //   25: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 192	com/tencent/mm/media/e/a:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   32: invokevirtual 229	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   35: aload_0
    //   36: getfield 192	com/tencent/mm/media/e/a:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   39: invokevirtual 232	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   42: aload_0
    //   43: getfield 126	com/tencent/mm/media/e/a:kTM	Lkotlin/g/a/a;
    //   46: invokeinterface 237 1 0
    //   51: pop
    //   52: ldc 130
    //   54: new 197	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 239
    //   60: invokespecial 201	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 241	com/tencent/mm/media/e/a:kTK	J
    //   67: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: getstatic 250	kotlin/x:aazN	Lkotlin/x;
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_1
    //   91: ldc 130
    //   93: ldc 252
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -27 -> 82
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   90	12	1	localException	Exception
    //   112	4	1	localObject2	Object
    //   79	1	2	localx	x
    //   85	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	52	85	finally
    //   52	80	85	finally
    //   2	9	90	java/lang/Exception
    //   80	82	90	java/lang/Exception
    //   86	90	90	java/lang/Exception
    //   2	9	112	finally
    //   80	82	112	finally
    //   86	90	112	finally
    //   91	109	112	finally
  }
  
  public abstract void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean);
  
  protected final void d(MediaFormat paramMediaFormat)
  {
    p.k(paramMediaFormat, "<set-?>");
    this.kTI = paramMediaFormat;
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.k(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer == null) {
      Log.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
    }
    while (paramBufferInfo.size <= 0) {
      return;
    }
    Log.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + paramBufferInfo.size + ", pts:" + paramBufferInfo.presentationTimeUs);
    paramByteBuffer.position(paramBufferInfo.offset);
    paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
    long l = Util.ticksToNow(this.kTJ);
    this.kTK += l;
    Log.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + l);
    this.kTL.c(paramByteBuffer, paramBufferInfo, this.kTI);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/IAudioEncoder$Companion;", "", "()V", "AAC_MIME_TYPE", "", "TAG", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */