package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  private int audioChannelCount;
  int audioSampleRate;
  volatile boolean dCv;
  volatile com.tencent.mm.audio.b.c dgu;
  z hjj;
  final Object hjv;
  private boolean hnd;
  private int ivb;
  int lRu;
  private MediaFormat mAudioFormat;
  private long startTime;
  long vPA;
  int vPB;
  int vPC;
  long vPD;
  long vPE;
  boolean vPF;
  private boolean vPG;
  public c.a vPH;
  p vPI;
  private final Object vPJ;
  volatile boolean vPK;
  private volatile boolean vPL;
  boolean vPM;
  ap vPN;
  protected boolean vPO;
  boolean vPP;
  final Object vPQ;
  c.b vPR;
  long vPS;
  private long vPT;
  boolean vPU;
  ap vPV;
  Runnable vPW;
  private com.tencent.mm.audio.b.c.a vPX;
  private MediaCodec.BufferInfo vPz;
  
  public h(int paramInt1, int paramInt2, int paramInt3, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(213678);
    this.vPA = 0L;
    this.TIMEOUT_USEC = 10000;
    this.vPF = false;
    this.vPG = false;
    this.vPH = null;
    this.startTime = 0L;
    this.hjv = new Object();
    this.vPJ = new Object();
    this.vPK = false;
    this.vPL = false;
    this.vPM = true;
    this.hnd = false;
    this.vPN = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.vPH != null)
        {
          h.this.vPH.ayf();
          h.this.vPH = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.dgu = null;
    this.vPQ = new byte[0];
    this.dCv = false;
    this.vPS = 0L;
    this.vPT = -1L;
    this.vPU = false;
    this.vPW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.dgu == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.vPU = true;
        h.this.dnm();
        AppMethodBeat.o(89478);
      }
    };
    this.vPX = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.vPN.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.vPF) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.lRu += 128;
        }
        boolean bool = h.this.vPO;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.vPM) {
            break label207;
          }
          if (!localh.vPK) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.vPU)) {}
          synchronized (h.this.vPQ)
          {
            if (h.this.vPR != null)
            {
              ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.vPR.aye();
              h.this.vPR = null;
              h.this.vPP = true;
              h.this.vPU = true;
              h.this.vPV.removeCallbacks(h.this.vPW);
              h.this.vPV.post(h.this.vPW);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.hjv)
              {
                if (!localh.vPK) {}
              }
              label245:
              if (0L == localh.vPA) {
                localh.vPA = System.nanoTime();
              }
              if ((localh.vPI != null) && (localh.vPI.dnt() <= 0L)) {
                localh.vPI.dnu();
              }
              if (localh.hjj == null) {
                continue;
              }
              if (localh.dCv)
              {
                ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.hjj == null) {
                ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localh.drainEncoder(bool);
                break;
                try
                {
                  ??? = localh.hjj.getInputBuffers();
                  paramAnonymousInt = localh.hjj.dequeueInputBuffer(10000L);
                  localh.vPB = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    ad.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.drainEncoder(false);
                      localh.vPB = localh.hjj.dequeueInputBuffer(10000L);
                      if (localh.vPB >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.hjj != null) {
                    break label485;
                  }
                  ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label485:
                if (localh.vPB >= 0)
                {
                  ??? = ???[localh.vPB];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.vPC = ???.length;
                  localh.vPD = System.nanoTime();
                  localh.vPD -= localh.vPC / localh.audioSampleRate * 1000000000;
                  if (localh.vPC == -3) {
                    ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.vPD;
                  if (localh.vPI != null) {}
                  for (long l1 = localh.vPI.dnt();; l1 = localh.vPA)
                  {
                    localh.vPE = ((l2 - l1) / 1000L);
                    localh.vPE -= localh.vPS * 1000L;
                    ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.vPC + " audio bytes with pts " + localh.vPE + ", end:" + bool + ", enqueue:" + localh.vPB);
                    if (!bool) {
                      break label750;
                    }
                    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.hjj.a(localh.vPB, localh.vPC, localh.vPE, 4);
                    break;
                  }
                  label750:
                  localh.hjj.a(localh.vPB, localh.vPC, localh.vPE, 0);
                }
              }
            }
            ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
          }
        }
      }
    };
    this.audioBitrate = paramInt2;
    this.audioSampleRate = paramInt1;
    this.audioChannelCount = paramInt3;
    if (this.audioChannelCount <= 0) {
      this.audioChannelCount = 1;
    }
    this.vPI = paramp;
    this.vPM = ((b)g.ab(b.class)).a(b.a.qys, true);
    this.hnd = paramBoolean;
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.hnd) });
    AppMethodBeat.o(213678);
  }
  
  private void dnn()
  {
    AppMethodBeat.i(89491);
    if ((this.vPK) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    while (this.vPL) {
      Thread.yield();
    }
    this.vPK = true;
    try
    {
      if (this.hjj != null)
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.hjj.stop();
        this.hjj.release();
        this.hjj = null;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      this.hjj = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int E(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 89	com/tencent/mm/plugin/mmsight/model/a/h:vPG	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   23: ifnonnull +414 -> 437
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc 166
    //   30: ldc 230
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: aastore
    //   43: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 236	com/tencent/mm/audio/b/c:PG	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   65: ifnonnull +377 -> 442
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 166
    //   72: ldc 238
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_3
    //   81: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 241	com/tencent/mm/plugin/mmsight/model/a/h:ats	()V
    //   92: aload_0
    //   93: getfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 246 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 248	com/tencent/mm/plugin/mmsight/model/a/h:lRu	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 250	com/tencent/mm/plugin/mmsight/model/a/h:vPO	Z
    //   123: aload_0
    //   124: getfield 120	com/tencent/mm/plugin/mmsight/model/a/h:vPQ	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 252	com/tencent/mm/plugin/mmsight/model/a/h:vPP	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 130	com/tencent/mm/plugin/mmsight/model/a/h:vPU	Z
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 228	com/tencent/mm/plugin/mmsight/model/a/h:vPR	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_0
    //   148: getfield 89	com/tencent/mm/plugin/mmsight/model/a/h:vPG	Z
    //   151: ifne +60 -> 211
    //   154: aload_0
    //   155: new 232	com/tencent/mm/audio/b/c
    //   158: dup
    //   159: aload_0
    //   160: getfield 142	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   163: aload_0
    //   164: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   167: iconst_5
    //   168: invokespecial 255	com/tencent/mm/audio/b/c:<init>	(III)V
    //   171: putfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   174: aload_0
    //   175: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   178: iconst_1
    //   179: invokevirtual 258	com/tencent/mm/audio/b/c:setAudioSource	(I)V
    //   182: aload_0
    //   183: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   186: sipush 128
    //   189: invokevirtual 261	com/tencent/mm/audio/b/c:hO	(I)V
    //   192: aload_0
    //   193: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   196: iconst_1
    //   197: invokevirtual 265	com/tencent/mm/audio/b/c:cu	(Z)V
    //   200: aload_0
    //   201: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:dgu	Lcom/tencent/mm/audio/b/c;
    //   204: aload_0
    //   205: getfield 138	com/tencent/mm/plugin/mmsight/model/a/h:vPX	Lcom/tencent/mm/audio/b/c$a;
    //   208: putfield 268	com/tencent/mm/audio/b/c:dhh	Lcom/tencent/mm/audio/b/c$a;
    //   211: aload_0
    //   212: getfield 270	com/tencent/mm/plugin/mmsight/model/a/h:vPV	Lcom/tencent/mm/sdk/platformtools/ap;
    //   215: ifnonnull +244 -> 459
    //   218: ldc 166
    //   220: ldc_w 272
    //   223: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: new 274	com/tencent/mm/sdk/platformtools/ap
    //   230: dup
    //   231: invokespecial 275	com/tencent/mm/sdk/platformtools/ap:<init>	()V
    //   234: putfield 270	com/tencent/mm/plugin/mmsight/model/a/h:vPV	Lcom/tencent/mm/sdk/platformtools/ap;
    //   237: ldc 166
    //   239: ldc_w 277
    //   242: iconst_2
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload_0
    //   249: getfield 142	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   252: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload_0
    //   259: getfield 140	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   262: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_0
    //   270: new 279	android/media/MediaCodec$BufferInfo
    //   273: dup
    //   274: invokespecial 280	android/media/MediaCodec$BufferInfo:<init>	()V
    //   277: putfield 282	com/tencent/mm/plugin/mmsight/model/a/h:vPz	Landroid/media/MediaCodec$BufferInfo;
    //   280: aload_0
    //   281: new 284	android/media/MediaFormat
    //   284: dup
    //   285: invokespecial 285	android/media/MediaFormat:<init>	()V
    //   288: putfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   291: aload_0
    //   292: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   295: ldc_w 289
    //   298: ldc_w 291
    //   301: invokevirtual 294	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   308: ldc_w 296
    //   311: iconst_2
    //   312: invokevirtual 300	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   315: aload_0
    //   316: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   319: ldc_w 302
    //   322: aload_0
    //   323: getfield 142	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   326: invokevirtual 300	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   329: aload_0
    //   330: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   333: ldc_w 304
    //   336: aload_0
    //   337: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   340: invokevirtual 300	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   343: aload_0
    //   344: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   347: ldc_w 306
    //   350: aload_0
    //   351: getfield 140	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   354: invokevirtual 300	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   357: aload_0
    //   358: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   361: ldc_w 308
    //   364: aload_0
    //   365: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   368: sipush 16384
    //   371: imul
    //   372: invokevirtual 300	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   375: aload_0
    //   376: ldc_w 291
    //   379: iconst_0
    //   380: invokestatic 312	com/tencent/mm/compatible/deviceinfo/z:q	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   383: putfield 199	com/tencent/mm/plugin/mmsight/model/a/h:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   386: aload_0
    //   387: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   390: aload_0
    //   391: getfield 287	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   394: aconst_null
    //   395: iconst_1
    //   396: invokevirtual 315	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   399: aload_0
    //   400: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:hjj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   403: invokevirtual 318	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   406: aload_0
    //   407: getfield 103	com/tencent/mm/plugin/mmsight/model/a/h:vPM	Z
    //   410: ifeq +104 -> 514
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 99	com/tencent/mm/plugin/mmsight/model/a/h:vPK	Z
    //   418: aload_0
    //   419: invokestatic 324	java/lang/System:currentTimeMillis	()J
    //   422: putfield 93	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   425: aload_0
    //   426: iconst_0
    //   427: putfield 87	com/tencent/mm/plugin/mmsight/model/a/h:vPF	Z
    //   430: ldc 226
    //   432: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: iconst_0
    //   436: ireturn
    //   437: iconst_0
    //   438: istore_3
    //   439: goto -411 -> 28
    //   442: iconst_0
    //   443: istore_3
    //   444: goto -374 -> 70
    //   447: astore 4
    //   449: aload_2
    //   450: monitorexit
    //   451: ldc 226
    //   453: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload 4
    //   458: athrow
    //   459: aload_0
    //   460: getfield 270	com/tencent/mm/plugin/mmsight/model/a/h:vPV	Lcom/tencent/mm/sdk/platformtools/ap;
    //   463: invokevirtual 327	com/tencent/mm/sdk/platformtools/ap:getLooper	()Landroid/os/Looper;
    //   466: invokestatic 330	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   469: if_acmpeq -232 -> 237
    //   472: ldc 166
    //   474: ldc_w 332
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 270	com/tencent/mm/plugin/mmsight/model/a/h:vPV	Lcom/tencent/mm/sdk/platformtools/ap;
    //   487: invokevirtual 327	com/tencent/mm/sdk/platformtools/ap:getLooper	()Landroid/os/Looper;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: invokestatic 330	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   496: aastore
    //   497: invokestatic 335	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: new 274	com/tencent/mm/sdk/platformtools/ap
    //   504: dup
    //   505: invokespecial 275	com/tencent/mm/sdk/platformtools/ap:<init>	()V
    //   508: putfield 270	com/tencent/mm/plugin/mmsight/model/a/h:vPV	Lcom/tencent/mm/sdk/platformtools/ap;
    //   511: goto -274 -> 237
    //   514: aload_0
    //   515: getfield 95	com/tencent/mm/plugin/mmsight/model/a/h:hjv	Ljava/lang/Object;
    //   518: astore_2
    //   519: aload_2
    //   520: monitorenter
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 99	com/tencent/mm/plugin/mmsight/model/a/h:vPK	Z
    //   526: aload_0
    //   527: invokestatic 324	java/lang/System:currentTimeMillis	()J
    //   530: putfield 93	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   533: aload_2
    //   534: monitorexit
    //   535: goto -110 -> 425
    //   538: astore 4
    //   540: aload_2
    //   541: monitorexit
    //   542: ldc 226
    //   544: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload 4
    //   549: athrow
    //   550: astore_2
    //   551: ldc 166
    //   553: aload_2
    //   554: ldc_w 337
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_2
    //   564: invokevirtual 338	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 342	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_0
    //   572: invokevirtual 241	com/tencent/mm/plugin/mmsight/model/a/h:ats	()V
    //   575: ldc_w 344
    //   578: ldc_w 346
    //   581: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: getstatic 352	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   587: ldc2_w 353
    //   590: ldc2_w 355
    //   593: lconst_1
    //   594: iconst_0
    //   595: invokevirtual 360	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 87	com/tencent/mm/plugin/mmsight/model/a/h:vPF	Z
    //   603: ldc 226
    //   605: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iconst_m1
    //   609: ireturn
    //   610: astore_2
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 87	com/tencent/mm/plugin/mmsight/model/a/h:vPF	Z
    //   616: ldc 226
    //   618: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   621: aload_2
    //   622: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	h
    //   0	623	1	paramInt	int
    //   27	417	3	bool	boolean
    //   447	10	4	localObject1	Object
    //   538	10	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   130	147	447	finally
    //   449	451	447	finally
    //   521	535	538	finally
    //   540	542	538	finally
    //   269	425	550	java/lang/Throwable
    //   514	521	550	java/lang/Throwable
    //   542	550	550	java/lang/Throwable
    //   269	425	610	finally
    //   514	521	610	finally
    //   542	550	610	finally
    //   551	598	610	finally
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    AppMethodBeat.i(89486);
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.vPH = parama;
    if (!this.vPG)
    {
      if (this.dgu == null)
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.dgu.PP()) {}
    }
    for (;;)
    {
      this.vPS = 0L;
      this.vPT = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.vPN.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.dgu == null)
    {
      bool1 = true;
      if (this.vPR != null) {
        break label102;
      }
      bool2 = true;
      label24:
      if (paramb != null) {
        break label107;
      }
    }
    label102:
    label107:
    for (boolean bool3 = true;; bool3 = false)
    {
      ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.vPO) });
      if ((this.dgu != null) || (this.vPG)) {
        break label113;
      }
      AppMethodBeat.o(89487);
      return -1;
      bool1 = false;
      break;
      bool2 = false;
      break label24;
    }
    label113:
    this.vPO = true;
    synchronized (this.vPQ)
    {
      this.vPR = paramb;
      if ((this.vPP) && (paramb != null))
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.aye();
        this.vPR = null;
      }
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.ats();
            h.this.dnm();
            AppMethodBeat.o(89481);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(89481);
          }
        }
      }, 500L);
      AppMethodBeat.o(89487);
      return 0;
    }
  }
  
  protected void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89494);
    if ((this.vPI != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.vPI.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void ats()
  {
    AppMethodBeat.i(89490);
    if (this.vPM)
    {
      dnn();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.hjv)
    {
      dnn();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean axM()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    ats();
    dnm();
    AppMethodBeat.o(89488);
  }
  
  public final void dni()
  {
    this.vPF = true;
  }
  
  public final com.tencent.mm.audio.b.c.a dnj()
  {
    return this.vPX;
  }
  
  final void dnm()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.dgu != null) && (!this.vPG))
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.dgu.PG();
        this.dgu = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.hjj == null)
    {
      ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(89492);
      return;
    }
    MediaFormat localMediaFormat;
    int j;
    label540:
    label565:
    label577:
    MediaCodec.BufferInfo localBufferInfo;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer = this.hjj.getOutputBuffers();
        this.ivb = this.hjj.dequeueOutputBuffer(this.vPz, 10000L);
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.ivb) });
        if (this.ivb == -1)
        {
          ad.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
          AppMethodBeat.o(89492);
          return;
        }
      }
      catch (Exception localException1)
      {
        ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException1.getMessage() });
        AppMethodBeat.o(89492);
        return;
      }
      Object localObject1;
      if (this.ivb == -3)
      {
        localObject1 = this.hjj.getOutputBuffers();
      }
      else if (this.ivb == -2)
      {
        localMediaFormat = this.hjj.getOutputFormat();
        ad.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
        if (this.vPI != null) {
          this.vPI.f(localMediaFormat);
        }
      }
      else if (this.ivb < 0)
      {
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.ivb) });
      }
      else
      {
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localMediaFormat = localObject1[this.ivb];
        if (localMediaFormat == null)
        {
          localObject1 = new RuntimeException("encoderOutputBuffer " + this.ivb + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject1);
        }
        boolean bool = this.vPK;
        if (bool)
        {
          AppMethodBeat.o(89492);
          return;
        }
        this.vPL = true;
        if ((this.vPz.flags & 0x2) != 0)
        {
          ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.vPz.size), Boolean.valueOf(axM()) });
          if (axM()) {
            this.vPz.size = 0;
          }
        }
        Object localObject2;
        if (this.vPz.size != 0)
        {
          if ((this.vPI != null) && (!this.vPI.dnv()))
          {
            localObject2 = this.hjj.getOutputFormat();
            this.vPI.f((MediaFormat)localObject2);
          }
          localMediaFormat.position(this.vPz.offset);
          localMediaFormat.limit(this.vPz.offset + this.vPz.size);
          bool = this.hnd;
          if (!bool) {
            break label706;
          }
        }
        try
        {
          localObject2 = this.vPz;
          if (this.hjj.getOutputFormat() == null) {
            break label738;
          }
          i = this.hjj.getOutputFormat().getInteger("aac-profile");
          if (this.hjj.getOutputFormat() == null) {
            break label743;
          }
          j = a.Kk(this.hjj.getOutputFormat().getInteger("sample-rate"));
          if (this.hjj.getOutputFormat() == null) {
            break label748;
          }
          k = this.hjj.getOutputFormat().getInteger("channel-count");
          a(localMediaFormat, (MediaCodec.BufferInfo)localObject2, i, j, k);
          this.hjj.releaseOutputBuffer(this.ivb, false);
          this.vPL = false;
          if ((this.vPz.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label719;
            }
            ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo = this.vPz;
          if (this.mAudioFormat == null) {
            break label754;
          }
        }
      }
    }
    int i = this.mAudioFormat.getInteger("aac-profile");
    label651:
    if (this.mAudioFormat != null)
    {
      j = a.Kk(this.mAudioFormat.getInteger("sample-rate"));
      label672:
      if (this.mAudioFormat == null) {
        break label764;
      }
    }
    label706:
    label719:
    label738:
    label743:
    label748:
    label754:
    label764:
    for (int k = this.mAudioFormat.getInteger("channel-count");; k = 1)
    {
      a(localMediaFormat, localBufferInfo, i, j, k);
      break label577;
      h(localMediaFormat, this.vPz);
      break label577;
      ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      ats();
      AppMethodBeat.o(89492);
      return;
      i = 2;
      break;
      j = 4;
      break label540;
      k = 1;
      break label565;
      i = 2;
      break label651;
      j = 4;
      break label672;
    }
  }
  
  protected void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89493);
    if ((this.vPI != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.vPI.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89493);
  }
  
  public void ob(int paramInt) {}
  
  public final void os(boolean paramBoolean)
  {
    this.vPG = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.vPF = false;
    this.dCv = true;
    this.vPT = bt.HI();
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.vPT) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.vPT) });
    this.dCv = false;
    if (this.vPT > 0L) {
      this.vPS += bt.aO(this.vPT);
    }
    this.vPT = 0L;
    this.vPF = true;
    AppMethodBeat.o(89484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */