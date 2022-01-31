package com.tencent.mm.media.d;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Landroid/media/MediaCodec;", "getEncoder", "()Landroid/media/MediaCodec;", "setEncoder", "(Landroid/media/MediaCodec;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a eUm = new a.a((byte)0);
  final Object eRH;
  volatile boolean eRq;
  MediaCodec eUg;
  MediaFormat eUh;
  long eUi;
  private long eUj;
  private m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> eUk;
  private a.f.a.a<y> eUl;
  private String mMimeType;
  
  public a(MediaFormat paramMediaFormat, m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> paramm, a.f.a.a<y> parama)
  {
    this.eUk = paramm;
    this.eUl = parama;
    this.eRH = new Object();
    ab.i("MicroMsg.IAudioEncoder", "init audio encoder");
    this.mMimeType = paramMediaFormat.getString("mime");
    for (;;)
    {
      try
      {
        this.eUh = new MediaFormat();
        this.eUh.setString("mime", "audio/mp4a-latm");
        this.eUh.setInteger("aac-profile", 2);
        this.eUh.setInteger("sample-rate", 44100);
        if (paramMediaFormat.containsKey("channel-count"))
        {
          i = paramMediaFormat.getInteger("channel-count");
          break label246;
          this.eUh.setInteger("channel-count", i);
          this.eUh.setInteger("bitrate", paramMediaFormat.getInteger("bitrate"));
          this.eUh.setInteger("max-input-size", i * 2048);
          paramMediaFormat = MediaCodec.createEncoderByType("audio/mp4a-latm");
          j.p(paramMediaFormat, "MediaCodec.createEncoderByType(AAC_MIME_TYPE)");
          this.eUg = paramMediaFormat;
          this.eUg.configure(this.eUh, null, null, 1);
          ab.i("MicroMsg.IAudioEncoder", "finish init audio encoder, dstMediaFormat:" + this.eUh);
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
      label246:
      while (i > 0) {
        break;
      }
      int i = j;
    }
  }
  
  public final void UN()
  {
    releaseEncoder();
  }
  
  public abstract void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean);
  
  protected final void d(MediaFormat paramMediaFormat)
  {
    j.q(paramMediaFormat, "<set-?>");
    this.eUh = paramMediaFormat;
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    j.q(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer == null) {
      ab.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
    }
    while (paramBufferInfo.size <= 0) {
      return;
    }
    ab.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + paramBufferInfo.size + ", pts:" + paramBufferInfo.presentationTimeUs);
    paramByteBuffer.position(paramBufferInfo.offset);
    paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
    long l = bo.av(this.eUi);
    this.eUj += l;
    ab.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + l);
    this.eUk.h(paramByteBuffer, paramBufferInfo);
  }
  
  /* Error */
  protected final void releaseEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 125	com/tencent/mm/media/d/a:eRH	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 290	com/tencent/mm/media/d/a:eRq	Z
    //   13: ifne +40 -> 53
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 290	com/tencent/mm/media/d/a:eRq	Z
    //   21: ldc 127
    //   23: ldc_w 291
    //   26: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 189	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   33: invokevirtual 294	android/media/MediaCodec:stop	()V
    //   36: aload_0
    //   37: getfield 189	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   40: invokevirtual 297	android/media/MediaCodec:release	()V
    //   43: aload_0
    //   44: getfield 123	com/tencent/mm/media/d/a:eUl	La/f/a/a;
    //   47: invokeinterface 302 1 0
    //   52: pop
    //   53: ldc 127
    //   55: new 195	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 304
    //   62: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 275	com/tencent/mm/media/d/a:eUj	J
    //   69: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: getstatic 310	a/y:BMg	La/y;
    //   81: astore_2
    //   82: aload_1
    //   83: monitorexit
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_2
    //   88: aload_1
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_1
    //   93: ldc 127
    //   95: ldc_w 312
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_1
    //   105: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic 318	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: goto -28 -> 84
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	a
    //   92	13	1	localException	Exception
    //   115	4	1	localObject2	Object
    //   81	1	2	localy	y
    //   87	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	53	87	finally
    //   53	82	87	finally
    //   2	9	92	java/lang/Exception
    //   82	84	92	java/lang/Exception
    //   88	92	92	java/lang/Exception
    //   2	9	115	finally
    //   82	84	115	finally
    //   88	92	115	finally
    //   93	112	115	finally
  }
  
  public final void stopEncoder()
  {
    releaseEncoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.a
 * JD-Core Version:    0.7.0.1
 */