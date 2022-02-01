package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getEncoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setEncoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function3;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function3;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a gQX = new a.a((byte)0);
  volatile boolean gNN;
  z gQR;
  MediaFormat gQS;
  long gQT;
  private long gQU;
  private q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, y> gQV;
  private d.g.a.a<y> gQW;
  private String mMimeType;
  final Object stopLock;
  
  public a(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, y> paramq, d.g.a.a<y> parama)
  {
    this.gQV = paramq;
    this.gQW = parama;
    this.stopLock = new Object();
    ac.i("MicroMsg.IAudioEncoder", "init audio encoder");
    this.mMimeType = paramMediaFormat.getString("mime");
    for (;;)
    {
      try
      {
        this.gQS = new MediaFormat();
        this.gQS.setString("mime", "audio/mp4a-latm");
        this.gQS.setInteger("aac-profile", 2);
        this.gQS.setInteger("sample-rate", 44100);
        if (paramMediaFormat.containsKey("channel-count"))
        {
          i = paramMediaFormat.getInteger("channel-count");
          break label245;
          this.gQS.setInteger("channel-count", i);
          this.gQS.setInteger("bitrate", paramMediaFormat.getInteger("bitrate"));
          this.gQS.setInteger("max-input-size", i * 2048);
          paramMediaFormat = z.sy("audio/mp4a-latm");
          k.g(paramMediaFormat, "MediaCodecProxy.createEncoderByType(AAC_MIME_TYPE)");
          this.gQR = paramMediaFormat;
          this.gQR.a(this.gQS, null, 1);
          ac.i("MicroMsg.IAudioEncoder", "finish init audio encoder, dstMediaFormat:" + this.gQS);
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
  
  public final void aqD()
  {
    aqF();
  }
  
  public final void aqE()
  {
    aqF();
  }
  
  /* Error */
  protected final void aqF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 126	com/tencent/mm/media/d/a:stopLock	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 223	com/tencent/mm/media/d/a:gNN	Z
    //   13: ifne +39 -> 52
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 223	com/tencent/mm/media/d/a:gNN	Z
    //   21: ldc 128
    //   23: ldc 224
    //   25: invokestatic 136	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 190	com/tencent/mm/media/d/a:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   32: invokevirtual 227	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   35: aload_0
    //   36: getfield 190	com/tencent/mm/media/d/a:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   39: invokevirtual 230	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   42: aload_0
    //   43: getfield 124	com/tencent/mm/media/d/a:gQW	Ld/g/a/a;
    //   46: invokeinterface 235 1 0
    //   51: pop
    //   52: ldc 128
    //   54: new 196	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 237
    //   60: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 239	com/tencent/mm/media/d/a:gQU	J
    //   67: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 136	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: getstatic 248	d/y:KTp	Ld/y;
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
    //   106: invokestatic 257	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   79	1	2	localy	y
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
    k.h(paramMediaFormat, "<set-?>");
    this.gQS = paramMediaFormat;
  }
  
  public final void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    k.h(paramBufferInfo, "bufferInfo");
    if (paramByteBuffer == null) {
      ac.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
    }
    while (paramBufferInfo.size <= 0) {
      return;
    }
    ac.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + paramBufferInfo.size + ", pts:" + paramBufferInfo.presentationTimeUs);
    paramByteBuffer.position(paramBufferInfo.offset);
    paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
    long l = bs.aO(this.gQT);
    this.gQU += l;
    ac.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + l);
    this.gQV.d(paramByteBuffer, paramBufferInfo, this.gQS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.a
 * JD-Core Version:    0.7.0.1
 */