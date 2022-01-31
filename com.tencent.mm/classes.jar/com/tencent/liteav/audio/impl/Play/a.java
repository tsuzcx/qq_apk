package com.tencent.liteav.audio.impl.Play;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class a
  implements Runnable
{
  private static final String a = "AudioCenter:" + a.class.getSimpleName();
  private WeakReference<d> b = null;
  private MediaCodec c = null;
  private MediaCodec.BufferInfo d;
  private MediaFormat e;
  private long f = 0L;
  private volatile boolean g = false;
  private Vector<com.tencent.liteav.basic.f.a> h;
  private List i;
  private Thread j = null;
  
  private int a(com.tencent.liteav.basic.f.a parama, ByteBuffer[] paramArrayOfByteBuffer, int paramInt)
  {
    if (paramInt >= 0) {}
    label388:
    for (;;)
    {
      try
      {
        if (parama.f != null)
        {
          paramArrayOfByteBuffer = paramArrayOfByteBuffer[paramInt];
          paramArrayOfByteBuffer.clear();
          paramArrayOfByteBuffer.put(parama.f);
        }
        if ((parama == null) || (parama.f.length <= 0)) {
          continue;
        }
        this.c.queueInputBuffer(paramInt, 0, parama.f.length, c(), 0);
        paramArrayOfByteBuffer = this.c.getOutputBuffers();
        parama = paramArrayOfByteBuffer;
        if (this.d == null)
        {
          this.d = new MediaCodec.BufferInfo();
          parama = paramArrayOfByteBuffer;
        }
        paramInt = this.c.dequeueOutputBuffer(this.d, 10000L);
        if (paramInt != -3) {
          continue;
        }
        parama = this.c.getOutputBuffers();
        if (paramInt >= 0) {
          continue;
        }
      }
      catch (Exception parama)
      {
        Object localObject;
        long l;
        continue;
      }
      return TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
      this.c.queueInputBuffer(paramInt, 0, 0, c(), 4);
      continue;
      if (paramInt == -2)
      {
        this.e = this.c.getOutputFormat();
        if (this.b != null)
        {
          paramArrayOfByteBuffer = (d)this.b.get();
          localObject = new com.tencent.liteav.basic.f.a();
          ((com.tencent.liteav.basic.f.a)localObject).c = com.tencent.liteav.basic.a.a.h;
          ((com.tencent.liteav.basic.f.a)localObject).b = this.e.getInteger("channel-count");
          ((com.tencent.liteav.basic.f.a)localObject).a = this.e.getInteger("sample-rate");
          if (paramArrayOfByteBuffer == null) {
            break label388;
          }
          paramArrayOfByteBuffer.onPlayAudioInfoChanged((com.tencent.liteav.basic.f.a)localObject, (com.tencent.liteav.basic.f.a)localObject);
          break label388;
        }
      }
      else if (paramInt >= 0)
      {
        localObject = parama[paramInt];
        ((ByteBuffer)localObject).position(this.d.offset);
        ((ByteBuffer)localObject).limit(this.d.offset + this.d.size);
        paramArrayOfByteBuffer = new byte[this.d.size];
        ((ByteBuffer)localObject).get(paramArrayOfByteBuffer);
        l = ((Long)this.i.get(0)).longValue();
        this.i.remove(0);
        if (this.b != null)
        {
          localObject = (d)this.b.get();
          if (localObject != null) {
            ((d)localObject).onPlayPcmData(paramArrayOfByteBuffer, l);
          }
        }
        this.c.releaseOutputBuffer(paramInt, false);
      }
      continue;
      if (paramInt == -1) {
        return -1;
      }
    }
  }
  
  /* Error */
  private int b(com.tencent.liteav.basic.f.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   4: arraylength
    //   5: iconst_2
    //   6: if_icmpeq +29 -> 35
    //   9: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   12: new 32	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 202
    //   18: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   25: arraylength
    //   26: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 211	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_1
    //   36: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   39: ifnull +611 -> 650
    //   42: aload_1
    //   43: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   46: iconst_0
    //   47: baload
    //   48: bipush 7
    //   50: iand
    //   51: iconst_1
    //   52: ishl
    //   53: aload_1
    //   54: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   57: iconst_1
    //   58: baload
    //   59: sipush 128
    //   62: iand
    //   63: bipush 7
    //   65: ishr
    //   66: ior
    //   67: invokestatic 216	com/tencent/liteav/audio/impl/a:a	(I)I
    //   70: istore_2
    //   71: aload_1
    //   72: getfield 74	com/tencent/liteav/basic/f/a:f	[B
    //   75: iconst_1
    //   76: baload
    //   77: bipush 120
    //   79: iand
    //   80: iconst_3
    //   81: ishr
    //   82: istore_3
    //   83: aload_0
    //   84: ldc 218
    //   86: iload_2
    //   87: iload_3
    //   88: invokestatic 222	android/media/MediaFormat:createAudioFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   91: putfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   94: aload_0
    //   95: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   98: ldc 224
    //   100: ldc 225
    //   102: invokevirtual 229	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   105: aload_0
    //   106: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   109: ldc 231
    //   111: iconst_0
    //   112: invokevirtual 229	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   115: aload_0
    //   116: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   119: ldc 233
    //   121: iconst_2
    //   122: invokevirtual 229	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   125: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   128: new 32	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 235
    //   134: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   141: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 240	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 58	com/tencent/liteav/audio/impl/Play/a:b	Ljava/lang/ref/WeakReference;
    //   154: ifnull +60 -> 214
    //   157: aload_0
    //   158: getfield 58	com/tencent/liteav/audio/impl/Play/a:b	Ljava/lang/ref/WeakReference;
    //   161: invokevirtual 126	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   164: checkcast 128	com/tencent/liteav/audio/d
    //   167: astore 4
    //   169: new 71	com/tencent/liteav/basic/f/a
    //   172: dup
    //   173: invokespecial 129	com/tencent/liteav/basic/f/a:<init>	()V
    //   176: astore 5
    //   178: aload 5
    //   180: getstatic 133	com/tencent/liteav/basic/a/a:h	I
    //   183: putfield 135	com/tencent/liteav/basic/f/a:c	I
    //   186: aload 5
    //   188: iload_3
    //   189: putfield 145	com/tencent/liteav/basic/f/a:b	I
    //   192: aload 5
    //   194: iload_2
    //   195: putfield 149	com/tencent/liteav/basic/f/a:a	I
    //   198: aload 4
    //   200: ifnull +14 -> 214
    //   203: aload 4
    //   205: aload 5
    //   207: aload 5
    //   209: invokeinterface 153 3 0
    //   214: aload_0
    //   215: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   218: ifnull +17 -> 235
    //   221: aload_0
    //   222: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   225: invokevirtual 243	android/media/MediaCodec:stop	()V
    //   228: aload_0
    //   229: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   232: invokevirtual 246	android/media/MediaCodec:release	()V
    //   235: aload_0
    //   236: ldc 218
    //   238: invokestatic 250	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   241: putfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   244: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   247: bipush 21
    //   249: if_icmplt +288 -> 537
    //   252: iconst_0
    //   253: istore_2
    //   254: aload_0
    //   255: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   258: aload_0
    //   259: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   262: aconst_null
    //   263: aconst_null
    //   264: iconst_0
    //   265: invokevirtual 259	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   268: aload_0
    //   269: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   272: invokevirtual 262	android/media/MediaCodec:start	()V
    //   275: aload_0
    //   276: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   279: ifnull +26 -> 305
    //   282: aload_0
    //   283: aload_1
    //   284: aload_0
    //   285: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   288: invokevirtual 265	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   291: aload_0
    //   292: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   295: ldc2_w 103
    //   298: invokevirtual 269	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   301: invokespecial 271	com/tencent/liteav/audio/impl/Play/a:a	(Lcom/tencent/liteav/basic/f/a;[Ljava/nio/ByteBuffer;I)I
    //   304: pop
    //   305: getstatic 114	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_PLAY_ERR_OK	I
    //   308: ireturn
    //   309: astore 4
    //   311: iconst_0
    //   312: istore_2
    //   313: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   316: new 32	java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 273
    //   323: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: iload_2
    //   327: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc_w 275
    //   333: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 4
    //   338: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: goto -112 -> 235
    //   350: astore 4
    //   352: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   355: new 32	java/lang/StringBuilder
    //   358: dup
    //   359: ldc_w 279
    //   362: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload 4
    //   367: invokevirtual 282	java/io/IOException:getMessage	()Ljava/lang/String;
    //   370: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: goto -135 -> 244
    //   382: astore 4
    //   384: iconst_0
    //   385: istore_3
    //   386: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   389: new 32	java/lang/StringBuilder
    //   392: dup
    //   393: ldc_w 284
    //   396: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   399: aload 4
    //   401: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: ldc_w 286
    //   407: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload_3
    //   411: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: ldc_w 288
    //   417: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   424: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: iload_2
    //   434: iconst_1
    //   435: iadd
    //   436: istore_2
    //   437: iload_2
    //   438: iconst_1
    //   439: if_icmple +28 -> 467
    //   442: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   445: ldc_w 290
    //   448: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_0
    //   452: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   455: invokevirtual 246	android/media/MediaCodec:release	()V
    //   458: aload_0
    //   459: aconst_null
    //   460: putfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   463: getstatic 293	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_PLAY_ERR_INVALID_STATE	I
    //   466: ireturn
    //   467: aload 4
    //   469: invokevirtual 297	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   472: ifeq +18 -> 490
    //   475: aload_0
    //   476: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   479: invokevirtual 243	android/media/MediaCodec:stop	()V
    //   482: goto -228 -> 254
    //   485: astore 4
    //   487: goto -233 -> 254
    //   490: aload 4
    //   492: invokevirtual 300	android/media/MediaCodec$CodecException:isTransient	()Z
    //   495: ifeq +17 -> 512
    //   498: ldc2_w 301
    //   501: invokestatic 308	java/lang/Thread:sleep	(J)V
    //   504: goto -250 -> 254
    //   507: astore 4
    //   509: goto -255 -> 254
    //   512: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   515: ldc_w 310
    //   518: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   525: invokevirtual 246	android/media/MediaCodec:release	()V
    //   528: aload_0
    //   529: aconst_null
    //   530: putfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   533: getstatic 293	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_PLAY_ERR_INVALID_STATE	I
    //   536: ireturn
    //   537: iconst_0
    //   538: istore_2
    //   539: aload_0
    //   540: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   543: aload_0
    //   544: getfield 120	com/tencent/liteav/audio/impl/Play/a:e	Landroid/media/MediaFormat;
    //   547: aconst_null
    //   548: aconst_null
    //   549: iconst_0
    //   550: invokevirtual 259	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   553: aload_0
    //   554: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   557: invokevirtual 262	android/media/MediaCodec:start	()V
    //   560: goto -285 -> 275
    //   563: astore 4
    //   565: iconst_1
    //   566: istore_3
    //   567: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   570: new 32	java/lang/StringBuilder
    //   573: dup
    //   574: ldc_w 312
    //   577: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   580: aload 4
    //   582: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   585: ldc_w 286
    //   588: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload_3
    //   592: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: iload_2
    //   602: iconst_1
    //   603: iadd
    //   604: istore_2
    //   605: iload_2
    //   606: iconst_1
    //   607: if_icmple +28 -> 635
    //   610: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   613: ldc_w 290
    //   616: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload_0
    //   620: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   623: invokevirtual 246	android/media/MediaCodec:release	()V
    //   626: aload_0
    //   627: aconst_null
    //   628: putfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   631: getstatic 293	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_PLAY_ERR_INVALID_STATE	I
    //   634: ireturn
    //   635: aload_0
    //   636: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   639: invokevirtual 315	android/media/MediaCodec:reset	()V
    //   642: goto -103 -> 539
    //   645: astore 4
    //   647: goto -108 -> 539
    //   650: getstatic 318	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_COMMON_ERR_INVALID_PARAMS	I
    //   653: ireturn
    //   654: astore 4
    //   656: iconst_0
    //   657: istore_3
    //   658: goto -91 -> 567
    //   661: astore 4
    //   663: iconst_1
    //   664: istore_3
    //   665: goto -279 -> 386
    //   668: astore 4
    //   670: iconst_1
    //   671: istore_2
    //   672: goto -359 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	a
    //   0	675	1	parama	com.tencent.liteav.basic.f.a
    //   70	602	2	k	int
    //   82	583	3	m	int
    //   167	37	4	locald	d
    //   309	28	4	localException1	Exception
    //   350	16	4	localIOException	java.io.IOException
    //   382	86	4	localCodecException1	android.media.MediaCodec.CodecException
    //   485	6	4	localException2	Exception
    //   507	1	4	localInterruptedException	InterruptedException
    //   563	18	4	localIllegalStateException1	java.lang.IllegalStateException
    //   645	1	4	localException3	Exception
    //   654	1	4	localIllegalStateException2	java.lang.IllegalStateException
    //   661	1	4	localCodecException2	android.media.MediaCodec.CodecException
    //   668	1	4	localException4	Exception
    //   176	32	5	locala	com.tencent.liteav.basic.f.a
    // Exception table:
    //   from	to	target	type
    //   221	228	309	java/lang/Exception
    //   235	244	350	java/io/IOException
    //   254	268	382	android/media/MediaCodec$CodecException
    //   475	482	485	java/lang/Exception
    //   498	504	507	java/lang/InterruptedException
    //   553	560	563	java/lang/IllegalStateException
    //   635	642	645	java/lang/Exception
    //   539	553	654	java/lang/IllegalStateException
    //   268	275	661	android/media/MediaCodec$CodecException
    //   228	235	668	java/lang/Exception
  }
  
  private long c()
  {
    long l2 = TXCTimeUtil.getTimeTick();
    long l1 = l2;
    if (l2 < this.f) {
      l1 = l2 + (this.f - l2);
    }
    this.f = l1;
    return l1;
  }
  
  public long a()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.e != null)
    {
      float f1 = this.e.getInteger("sample-rate");
      l1 = l2;
      if (f1 != 0.0F) {
        l1 = (this.i.size() * 1024.0F * 1000.0F / f1);
      }
    }
    return l1;
  }
  
  public void a(com.tencent.liteav.basic.f.a parama)
  {
    if (!this.g) {
      return;
    }
    synchronized (this.h)
    {
      if (this.h != null) {
        this.h.add(parama);
      }
      return;
    }
  }
  
  public void a(WeakReference<d> paramWeakReference)
  {
    if (this.g) {
      b();
    }
    this.b = paramWeakReference;
    this.f = 0L;
    this.h = new Vector();
    this.i = new ArrayList();
    this.g = true;
    this.j = new Thread(this);
    this.j.setName(a);
    this.j.start();
  }
  
  public void b()
  {
    this.g = false;
    if (this.j != null) {}
    try
    {
      this.j.join();
      label19:
      this.j = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label19;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/liteav/audio/impl/Play/a:g	Z
    //   4: ifeq +236 -> 240
    //   7: aload_0
    //   8: getfield 331	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   11: astore 4
    //   13: aload 4
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 331	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   20: invokevirtual 360	java/util/Vector:isEmpty	()Z
    //   23: istore_3
    //   24: aload 4
    //   26: monitorexit
    //   27: iload_3
    //   28: ifeq +25 -> 53
    //   31: ldc2_w 361
    //   34: invokestatic 308	java/lang/Thread:sleep	(J)V
    //   37: goto -37 -> 0
    //   40: astore 4
    //   42: goto -42 -> 0
    //   45: astore 5
    //   47: aload 4
    //   49: monitorexit
    //   50: aload 5
    //   52: athrow
    //   53: aload_0
    //   54: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   57: ifnull +215 -> 272
    //   60: aload_0
    //   61: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   64: invokevirtual 265	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   67: astore 4
    //   69: iconst_1
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   75: ldc2_w 103
    //   78: invokevirtual 269	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   81: istore_2
    //   82: iload_2
    //   83: istore_1
    //   84: iload_1
    //   85: ifge +4 -> 89
    //   88: return
    //   89: aload_0
    //   90: getfield 331	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   93: astore 5
    //   95: aload 5
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 331	com/tencent/liteav/audio/impl/Play/a:h	Ljava/util/Vector;
    //   102: iconst_0
    //   103: invokevirtual 363	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   106: checkcast 71	com/tencent/liteav/basic/f/a
    //   109: astore 6
    //   111: aload 5
    //   113: monitorexit
    //   114: aload 6
    //   116: getfield 365	com/tencent/liteav/basic/f/a:d	I
    //   119: getstatic 368	com/tencent/liteav/basic/a/a:k	I
    //   122: if_icmpne +60 -> 182
    //   125: aload_0
    //   126: aload 6
    //   128: invokespecial 370	com/tencent/liteav/audio/impl/Play/a:b	(Lcom/tencent/liteav/basic/f/a;)I
    //   131: pop
    //   132: goto -132 -> 0
    //   135: astore 4
    //   137: iconst_0
    //   138: istore_1
    //   139: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   142: new 32	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 372
    //   149: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: iload_1
    //   153: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 374
    //   159: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 4
    //   164: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: return
    //   174: astore 4
    //   176: aload 5
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    //   182: aload 6
    //   184: getfield 365	com/tencent/liteav/basic/f/a:d	I
    //   187: getstatic 377	com/tencent/liteav/basic/a/a:l	I
    //   190: if_icmpne +38 -> 228
    //   193: aload_0
    //   194: getfield 170	com/tencent/liteav/audio/impl/Play/a:i	Ljava/util/List;
    //   197: new 177	java/lang/Long
    //   200: dup
    //   201: aload 6
    //   203: getfield 379	com/tencent/liteav/basic/f/a:e	J
    //   206: invokespecial 381	java/lang/Long:<init>	(J)V
    //   209: invokeinterface 382 2 0
    //   214: pop
    //   215: aload_0
    //   216: aload 6
    //   218: aload 4
    //   220: iload_1
    //   221: invokespecial 271	com/tencent/liteav/audio/impl/Play/a:a	(Lcom/tencent/liteav/basic/f/a;[Ljava/nio/ByteBuffer;I)I
    //   224: pop
    //   225: goto -225 -> 0
    //   228: getstatic 53	com/tencent/liteav/audio/impl/Play/a:a	Ljava/lang/String;
    //   231: ldc_w 384
    //   234: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -237 -> 0
    //   240: aload_0
    //   241: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   244: ifnull -156 -> 88
    //   247: aload_0
    //   248: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   251: invokevirtual 243	android/media/MediaCodec:stop	()V
    //   254: aload_0
    //   255: getfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   258: invokevirtual 246	android/media/MediaCodec:release	()V
    //   261: aload_0
    //   262: aconst_null
    //   263: putfield 60	com/tencent/liteav/audio/impl/Play/a:c	Landroid/media/MediaCodec;
    //   266: return
    //   267: astore 4
    //   269: goto -130 -> 139
    //   272: aconst_null
    //   273: astore 4
    //   275: iconst_m1
    //   276: istore_1
    //   277: goto -188 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	a
    //   70	207	1	k	int
    //   81	2	2	m	int
    //   23	5	3	bool	boolean
    //   11	14	4	localVector1	Vector
    //   40	8	4	localException1	Exception
    //   67	1	4	arrayOfByteBuffer1	ByteBuffer[]
    //   135	28	4	localException2	Exception
    //   174	45	4	arrayOfByteBuffer2	ByteBuffer[]
    //   267	1	4	localException3	Exception
    //   273	1	4	localObject1	Object
    //   45	6	5	localObject2	Object
    //   109	108	6	locala	com.tencent.liteav.basic.f.a
    // Exception table:
    //   from	to	target	type
    //   31	37	40	java/lang/Exception
    //   16	27	45	finally
    //   47	50	45	finally
    //   60	69	135	java/lang/Exception
    //   98	114	174	finally
    //   176	179	174	finally
    //   71	82	267	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.a
 * JD-Core Version:    0.7.0.1
 */