package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.q;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getEncoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setEncoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a hjp = new a.a((byte)0);
  volatile boolean hhJ;
  com.tencent.mm.compatible.deviceinfo.z hjj;
  MediaFormat hjk;
  long hjl;
  private long hjm;
  private q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, d.z> hjn;
  private d.g.a.a<d.z> hjo;
  private String mMimeType;
  final Object stopLock;
  
  public a(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, d.z> paramq, d.g.a.a<d.z> parama)
  {
    this.hjn = paramq;
    this.hjo = parama;
    this.stopLock = new Object();
    ad.i("MicroMsg.IAudioEncoder", "init audio encoder");
    this.mMimeType = paramMediaFormat.getString("mime");
    for (;;)
    {
      try
      {
        this.hjk = new MediaFormat();
        this.hjk.setString("mime", "audio/mp4a-latm");
        this.hjk.setInteger("aac-profile", 2);
        this.hjk.setInteger("sample-rate", 44100);
        if (paramMediaFormat.containsKey("channel-count"))
        {
          i = paramMediaFormat.getInteger("channel-count");
          break label245;
          this.hjk.setInteger("channel-count", i);
          this.hjk.setInteger("bitrate", paramMediaFormat.getInteger("bitrate"));
          this.hjk.setInteger("max-input-size", i * 2048);
          paramMediaFormat = com.tencent.mm.compatible.deviceinfo.z.vn("audio/mp4a-latm");
          p.g(paramMediaFormat, "MediaCodecProxy.createEncoderByType(AAC_MIME_TYPE)");
          this.hjj = paramMediaFormat;
          this.hjj.a(this.hjk, null, 1);
          ad.i("MicroMsg.IAudioEncoder", "finish init audio encoder, dstMediaFormat:" + this.hjk);
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
  
  public final void atr()
  {
    att();
  }
  
  public final void ats()
  {
    att();
  }
  
  /* Error */
  protected final void att()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 126	com/tencent/mm/media/e/a:stopLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 223	com/tencent/mm/media/e/a:hhJ	Z
    //   13: ifne +39 -> 52
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 223	com/tencent/mm/media/e/a:hhJ	Z
    //   21: ldc 128
    //   23: ldc 224
    //   25: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 190	com/tencent/mm/media/e/a:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   32: invokevirtual 227	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   35: aload_0
    //   36: getfield 190	com/tencent/mm/media/e/a:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   39: invokevirtual 230	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   42: aload_0
    //   43: getfield 124	com/tencent/mm/media/e/a:hjo	Ld/g/a/a;
    //   46: invokeinterface 235 1 0
    //   51: pop
    //   52: ldc 128
    //   54: new 196	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 237
    //   60: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 239	com/tencent/mm/media/e/a:hjm	J
    //   67: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: getstatic 248	d/z:MKo	Ld/z;
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
    //   91: ldc 128
    //   93: ldc 250
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: invokevirtual 253	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   79	1	2	localz	d.z
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
    p.h(paramMediaFormat, "<set-?>");
    this.hjk = paramMediaFormat;
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.h(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer == null) {
      ad.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
    }
    while (paramBufferInfo.size <= 0) {
      return;
    }
    ad.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + paramBufferInfo.size + ", pts:" + paramBufferInfo.presentationTimeUs);
    paramByteBuffer.position(paramBufferInfo.offset);
    paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
    long l = bt.aO(this.hjl);
    this.hjm += l;
    ad.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + l);
    this.hjn.d(paramByteBuffer, paramBufferInfo, this.hjk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.a
 * JD-Core Version:    0.7.0.1
 */