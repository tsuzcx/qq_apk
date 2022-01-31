package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  private final int TIMEOUT_USEC;
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c ciR;
  private int eRF;
  boolean eUA;
  final Object eUB;
  MediaCodec eUg;
  private int fYr;
  private int fzT;
  int ipz;
  private MediaFormat mAudioFormat;
  private MediaCodec.BufferInfo oIQ;
  long oIR;
  int oIS;
  int oIT;
  long oIU;
  long oIV;
  boolean oIW;
  private boolean oIX;
  public c.a oIY;
  o oIZ;
  private final Object oJa;
  boolean oJb;
  ak oJc;
  protected boolean oJd;
  boolean oJe;
  final Object oJf;
  c.b oJg;
  boolean oJh;
  ak oJi;
  Runnable oJj;
  private com.tencent.mm.audio.b.c.a oJk;
  private long startTime;
  
  public h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140128);
    this.oIR = 0L;
    this.TIMEOUT_USEC = 10000;
    this.oIW = false;
    this.oIX = false;
    this.oIY = null;
    this.startTime = 0L;
    this.eUB = new Object();
    this.oJa = new Object();
    this.eUA = false;
    this.oJb = true;
    this.oJc = new h.1(this, Looper.getMainLooper());
    this.ciR = null;
    this.oJf = new byte[0];
    this.oJh = false;
    this.oJj = new h.2(this);
    this.oJk = new h.3(this);
    this.fzT = paramInt2;
    this.audioSampleRate = paramInt1;
    this.eRF = paramInt3;
    if (this.eRF <= 0) {
      this.eRF = 1;
    }
    this.oIZ = null;
    this.oJb = ((a)g.E(a.class)).a(a.a.lVO, true);
    ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s", new Object[] { Integer.valueOf(this.fzT), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.eRF) });
    AppMethodBeat.o(140128);
  }
  
  private void UN()
  {
    AppMethodBeat.i(138317);
    if (this.oJb)
    {
      bRp();
      AppMethodBeat.o(138317);
      return;
    }
    synchronized (this.eUB)
    {
      bRp();
      AppMethodBeat.o(138317);
      return;
    }
  }
  
  private void bRp()
  {
    AppMethodBeat.i(138318);
    if ((this.eUA) || (0L == this.startTime))
    {
      AppMethodBeat.o(138318);
      return;
    }
    this.eUA = true;
    try
    {
      if (this.eUg != null)
      {
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.eUg.stop();
        this.eUg.release();
        this.eUg = null;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      this.eUg = null;
      AppMethodBeat.o(138318);
    }
  }
  
  protected boolean Xp()
  {
    return false;
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    AppMethodBeat.i(76580);
    ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.oIY = parama;
    if (!this.oIX)
    {
      if (this.ciR == null)
      {
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(76580);
        return -1;
      }
      if (!this.ciR.EC()) {}
    }
    for (;;)
    {
      AppMethodBeat.o(76580);
      return i;
      i = -1;
      continue;
      this.oJc.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(76581);
    boolean bool1;
    boolean bool2;
    if (this.ciR == null)
    {
      bool1 = true;
      if (this.oJg != null) {
        break label99;
      }
      bool2 = true;
      label23:
      if (paramb != null) {
        break label104;
      }
    }
    label99:
    label104:
    for (boolean bool3 = true;; bool3 = false)
    {
      ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.oJd) });
      if ((this.ciR != null) || (this.oIX)) {
        break label110;
      }
      AppMethodBeat.o(76581);
      return -1;
      bool1 = false;
      break;
      bool2 = false;
      break label23;
    }
    label110:
    this.oJd = true;
    synchronized (this.oJf)
    {
      this.oJg = paramb;
      if ((this.oJe) && (paramb != null))
      {
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.XE();
        this.oJg = null;
      }
      al.p(new h.4(this), 500L);
      AppMethodBeat.o(76581);
      return 0;
    }
  }
  
  public final void bRk()
  {
    this.oIW = true;
  }
  
  public final com.tencent.mm.audio.b.c.a bRl()
  {
    return this.oJk;
  }
  
  final void bRo()
  {
    try
    {
      AppMethodBeat.i(140129);
      if ((this.ciR != null) && (!this.oIX))
      {
        ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.ciR.Et();
        this.ciR = null;
      }
      AppMethodBeat.o(140129);
      return;
    }
    finally {}
  }
  
  public final void clear()
  {
    AppMethodBeat.i(76582);
    ab.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    UN();
    bRo();
    AppMethodBeat.o(76582);
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(76583);
    if (this.eUg == null)
    {
      ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(76583);
      return;
    }
    do
    {
      Object localObject;
      for (;;)
      {
        try
        {
          ByteBuffer[] arrayOfByteBuffer = this.eUg.getOutputBuffers();
          this.fYr = this.eUg.dequeueOutputBuffer(this.oIQ, 10000L);
          ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.fYr) });
          if (this.fYr == -1)
          {
            ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
            AppMethodBeat.o(76583);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(76583);
          return;
        }
        if (this.fYr == -3)
        {
          localObject = this.eUg.getOutputBuffers();
        }
        else if (this.fYr == -2)
        {
          localMediaFormat1 = this.eUg.getOutputFormat();
          ab.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat1)));
          if (this.oIZ != null) {
            this.oIZ.f(localMediaFormat1);
          }
        }
        else
        {
          if (this.fYr >= 0) {
            break;
          }
          ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.fYr) });
        }
      }
      ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
      MediaFormat localMediaFormat1 = localObject[this.fYr];
      if (localMediaFormat1 == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.fYr + " was null");
        AppMethodBeat.o(76583);
        throw ((Throwable)localObject);
      }
      if ((this.oIQ.flags & 0x2) != 0)
      {
        ab.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.oIQ.size), Boolean.valueOf(Xp()) });
        if (Xp()) {
          this.oIQ.size = 0;
        }
      }
      if (this.oIQ.size != 0)
      {
        if ((this.oIZ != null) && (!this.oIZ.isStart))
        {
          MediaFormat localMediaFormat2 = this.eUg.getOutputFormat();
          this.oIZ.f(localMediaFormat2);
        }
        localMediaFormat1.position(this.oIQ.offset);
        localMediaFormat1.limit(this.oIQ.offset + this.oIQ.size);
        g(localMediaFormat1, this.oIQ);
      }
      this.eUg.releaseOutputBuffer(this.fYr, false);
    } while ((this.oIQ.flags & 0x4) == 0);
    if (!paramBoolean)
    {
      ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
      AppMethodBeat.o(76583);
      return;
    }
    ab.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
    UN();
    AppMethodBeat.o(76583);
  }
  
  protected void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(76584);
    if ((this.oIZ != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      o localo = this.oIZ;
      try
      {
        if ((localo.oJC != null) && (localo.oJE != -1) && (localo.isStart) && (paramByteBuffer != null) && (paramBufferInfo != null))
        {
          long l1 = paramBufferInfo.presentationTimeUs;
          paramBufferInfo.presentationTimeUs = ((System.nanoTime() - localo.oJF) / 1000L);
          long l2 = bo.yB();
          localo.oJC.writeSampleData(localo.oJE, paramByteBuffer, paramBufferInfo);
          ab.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Long.valueOf(bo.av(l2)), Long.valueOf(l1), Long.valueOf(paramBufferInfo.presentationTimeUs) });
        }
        AppMethodBeat.o(76584);
        return;
      }
      catch (Exception paramByteBuffer)
      {
        ab.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[] { paramByteBuffer.getMessage() });
      }
    }
    AppMethodBeat.o(76584);
  }
  
  public final void jn(boolean paramBoolean)
  {
    this.oIX = paramBoolean;
  }
  
  /* Error */
  public int t(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc_w 445
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 76	com/tencent/mm/plugin/mmsight/model/a/h:oIX	Z
    //   10: ifne +46 -> 56
    //   13: aload_0
    //   14: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   17: ifnull +39 -> 56
    //   20: aload_0
    //   21: getfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   24: ifnonnull +404 -> 428
    //   27: iconst_1
    //   28: istore_3
    //   29: ldc 147
    //   31: ldc_w 447
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iload_3
    //   41: invokestatic 229	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   44: aastore
    //   45: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_0
    //   49: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   52: invokevirtual 261	com/tencent/mm/audio/b/c:Et	()Z
    //   55: pop
    //   56: aload_0
    //   57: getfield 177	com/tencent/mm/plugin/mmsight/model/a/h:eUg	Landroid/media/MediaCodec;
    //   60: ifnull +56 -> 116
    //   63: aload_0
    //   64: getfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   67: ifnonnull +366 -> 433
    //   70: iconst_1
    //   71: istore_3
    //   72: ldc 147
    //   74: ldc_w 449
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload_3
    //   84: invokestatic 229	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: invokespecial 172	com/tencent/mm/plugin/mmsight/model/a/h:UN	()V
    //   95: aload_0
    //   96: getfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   99: ifnull +17 -> 116
    //   102: aload_0
    //   103: getfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   106: invokeinterface 240 1 0
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 451	com/tencent/mm/plugin/mmsight/model/a/h:ipz	I
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 231	com/tencent/mm/plugin/mmsight/model/a/h:oJd	Z
    //   126: aload_0
    //   127: getfield 105	com/tencent/mm/plugin/mmsight/model/a/h:oJf	Ljava/lang/Object;
    //   130: astore_2
    //   131: aload_2
    //   132: monitorenter
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 233	com/tencent/mm/plugin/mmsight/model/a/h:oJe	Z
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 222	com/tencent/mm/plugin/mmsight/model/a/h:oJg	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   143: aload_2
    //   144: monitorexit
    //   145: aload_0
    //   146: getfield 76	com/tencent/mm/plugin/mmsight/model/a/h:oIX	Z
    //   149: ifne +52 -> 201
    //   152: aload_0
    //   153: new 209	com/tencent/mm/audio/b/c
    //   156: dup
    //   157: aload_0
    //   158: getfield 123	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   161: aload_0
    //   162: getfield 125	com/tencent/mm/plugin/mmsight/model/a/h:eRF	I
    //   165: iconst_5
    //   166: invokespecial 453	com/tencent/mm/audio/b/c:<init>	(III)V
    //   169: putfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   172: aload_0
    //   173: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   176: sipush 128
    //   179: invokevirtual 456	com/tencent/mm/audio/b/c:gA	(I)V
    //   182: aload_0
    //   183: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   186: iconst_1
    //   187: invokevirtual 459	com/tencent/mm/audio/b/c:bz	(Z)V
    //   190: aload_0
    //   191: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:ciR	Lcom/tencent/mm/audio/b/c;
    //   194: aload_0
    //   195: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:oJk	Lcom/tencent/mm/audio/b/c$a;
    //   198: putfield 462	com/tencent/mm/audio/b/c:cjD	Lcom/tencent/mm/audio/b/c$a;
    //   201: aload_0
    //   202: getfield 464	com/tencent/mm/plugin/mmsight/model/a/h:oJi	Lcom/tencent/mm/sdk/platformtools/ak;
    //   205: ifnonnull +246 -> 451
    //   208: ldc 147
    //   210: ldc_w 466
    //   213: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: new 214	com/tencent/mm/sdk/platformtools/ak
    //   220: dup
    //   221: invokespecial 467	com/tencent/mm/sdk/platformtools/ak:<init>	()V
    //   224: putfield 464	com/tencent/mm/plugin/mmsight/model/a/h:oJi	Lcom/tencent/mm/sdk/platformtools/ak;
    //   227: ldc 147
    //   229: ldc_w 469
    //   232: iconst_2
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload_0
    //   239: getfield 123	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   242: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload_0
    //   249: getfield 121	com/tencent/mm/plugin/mmsight/model/a/h:fzT	I
    //   252: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: new 354	android/media/MediaCodec$BufferInfo
    //   263: dup
    //   264: invokespecial 470	android/media/MediaCodec$BufferInfo:<init>	()V
    //   267: putfield 289	com/tencent/mm/plugin/mmsight/model/a/h:oIQ	Landroid/media/MediaCodec$BufferInfo;
    //   270: aload_0
    //   271: new 472	android/media/MediaFormat
    //   274: dup
    //   275: invokespecial 473	android/media/MediaFormat:<init>	()V
    //   278: putfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   281: aload_0
    //   282: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   285: ldc_w 477
    //   288: ldc_w 479
    //   291: invokevirtual 482	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_0
    //   295: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   298: ldc_w 484
    //   301: iconst_2
    //   302: invokevirtual 488	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   305: aload_0
    //   306: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   309: ldc_w 490
    //   312: aload_0
    //   313: getfield 123	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   316: invokevirtual 488	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   319: aload_0
    //   320: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   323: ldc_w 492
    //   326: aload_0
    //   327: getfield 125	com/tencent/mm/plugin/mmsight/model/a/h:eRF	I
    //   330: invokevirtual 488	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   333: aload_0
    //   334: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   337: ldc_w 494
    //   340: aload_0
    //   341: getfield 121	com/tencent/mm/plugin/mmsight/model/a/h:fzT	I
    //   344: invokevirtual 488	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   347: aload_0
    //   348: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   351: ldc_w 496
    //   354: aload_0
    //   355: getfield 125	com/tencent/mm/plugin/mmsight/model/a/h:eRF	I
    //   358: sipush 16384
    //   361: imul
    //   362: invokevirtual 488	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   365: aload_0
    //   366: ldc_w 479
    //   369: invokestatic 500	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   372: putfield 177	com/tencent/mm/plugin/mmsight/model/a/h:eUg	Landroid/media/MediaCodec;
    //   375: aload_0
    //   376: getfield 177	com/tencent/mm/plugin/mmsight/model/a/h:eUg	Landroid/media/MediaCodec;
    //   379: aload_0
    //   380: getfield 475	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   383: aconst_null
    //   384: aconst_null
    //   385: iconst_1
    //   386: invokevirtual 504	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   389: aload_0
    //   390: getfield 177	com/tencent/mm/plugin/mmsight/model/a/h:eUg	Landroid/media/MediaCodec;
    //   393: invokevirtual 507	android/media/MediaCodec:start	()V
    //   396: aload_0
    //   397: getfield 88	com/tencent/mm/plugin/mmsight/model/a/h:oJb	Z
    //   400: ifeq +106 -> 506
    //   403: aload_0
    //   404: iconst_0
    //   405: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:eUA	Z
    //   408: aload_0
    //   409: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   412: putfield 80	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   415: aload_0
    //   416: iconst_0
    //   417: putfield 74	com/tencent/mm/plugin/mmsight/model/a/h:oIW	Z
    //   420: ldc_w 445
    //   423: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: iconst_0
    //   427: ireturn
    //   428: iconst_0
    //   429: istore_3
    //   430: goto -401 -> 29
    //   433: iconst_0
    //   434: istore_3
    //   435: goto -363 -> 72
    //   438: astore 4
    //   440: aload_2
    //   441: monitorexit
    //   442: ldc_w 445
    //   445: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload 4
    //   450: athrow
    //   451: aload_0
    //   452: getfield 464	com/tencent/mm/plugin/mmsight/model/a/h:oJi	Lcom/tencent/mm/sdk/platformtools/ak;
    //   455: invokevirtual 513	com/tencent/mm/sdk/platformtools/ak:getLooper	()Landroid/os/Looper;
    //   458: invokestatic 516	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   461: if_acmpeq -234 -> 227
    //   464: ldc 147
    //   466: ldc_w 518
    //   469: iconst_2
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload_0
    //   476: getfield 464	com/tencent/mm/plugin/mmsight/model/a/h:oJi	Lcom/tencent/mm/sdk/platformtools/ak;
    //   479: invokevirtual 513	com/tencent/mm/sdk/platformtools/ak:getLooper	()Landroid/os/Looper;
    //   482: aastore
    //   483: dup
    //   484: iconst_1
    //   485: invokestatic 516	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   488: aastore
    //   489: invokestatic 520	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   492: aload_0
    //   493: new 214	com/tencent/mm/sdk/platformtools/ak
    //   496: dup
    //   497: invokespecial 467	com/tencent/mm/sdk/platformtools/ak:<init>	()V
    //   500: putfield 464	com/tencent/mm/plugin/mmsight/model/a/h:oJi	Lcom/tencent/mm/sdk/platformtools/ak;
    //   503: goto -276 -> 227
    //   506: aload_0
    //   507: getfield 82	com/tencent/mm/plugin/mmsight/model/a/h:eUB	Ljava/lang/Object;
    //   510: astore_2
    //   511: aload_2
    //   512: monitorenter
    //   513: aload_0
    //   514: iconst_0
    //   515: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:eUA	Z
    //   518: aload_0
    //   519: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   522: putfield 80	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   525: aload_2
    //   526: monitorexit
    //   527: goto -112 -> 415
    //   530: astore 4
    //   532: aload_2
    //   533: monitorexit
    //   534: ldc_w 445
    //   537: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   540: aload 4
    //   542: athrow
    //   543: astore_2
    //   544: ldc 147
    //   546: aload_2
    //   547: ldc_w 522
    //   550: iconst_1
    //   551: anewarray 4	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: aload_2
    //   557: invokevirtual 523	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   560: aastore
    //   561: invokestatic 527	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: aload_0
    //   565: invokespecial 172	com/tencent/mm/plugin/mmsight/model/a/h:UN	()V
    //   568: ldc_w 529
    //   571: ldc_w 531
    //   574: invokestatic 182	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: getstatic 537	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   580: ldc2_w 538
    //   583: ldc2_w 540
    //   586: lconst_1
    //   587: iconst_0
    //   588: invokevirtual 545	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   591: aload_0
    //   592: iconst_0
    //   593: putfield 74	com/tencent/mm/plugin/mmsight/model/a/h:oIW	Z
    //   596: ldc_w 445
    //   599: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   602: iconst_m1
    //   603: ireturn
    //   604: astore_2
    //   605: aload_0
    //   606: iconst_0
    //   607: putfield 74	com/tencent/mm/plugin/mmsight/model/a/h:oIW	Z
    //   610: ldc_w 445
    //   613: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: aload_2
    //   617: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	h
    //   0	618	1	paramInt	int
    //   28	407	3	bool	boolean
    //   438	11	4	localObject1	Object
    //   530	11	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   133	145	438	finally
    //   440	442	438	finally
    //   513	527	530	finally
    //   532	534	530	finally
    //   259	415	543	java/lang/Throwable
    //   506	513	543	java/lang/Throwable
    //   534	543	543	java/lang/Throwable
    //   259	415	604	finally
    //   506	513	604	finally
    //   534	543	604	finally
    //   544	591	604	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */