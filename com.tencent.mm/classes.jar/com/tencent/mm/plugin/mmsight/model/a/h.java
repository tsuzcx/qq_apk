package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public class h
  implements c
{
  private MediaCodec.BufferInfo KWM;
  long KWN;
  int KWO;
  int KWP;
  long KWQ;
  long KWR;
  boolean KWS;
  private boolean KWT;
  public c.a KWU;
  o KWV;
  private final Object KWW;
  volatile boolean KWX;
  private volatile boolean KWY;
  boolean KWZ;
  MMHandler KXa;
  protected boolean KXb;
  boolean KXc;
  final Object KXd;
  c.b KXe;
  long KXf;
  private long KXg;
  boolean KXh;
  MMHandler KXi;
  Runnable KXj;
  long KXk;
  private com.tencent.mm.audio.b.c.a KXl;
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  private int audioChannelCount;
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c hvI;
  private MediaFormat mAudioFormat;
  private boolean nDh;
  final Object nzC;
  aa nzs;
  volatile boolean pause;
  private int pcl;
  private long startTime;
  int tiD;
  
  public h(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(89482);
    this.KWN = 0L;
    this.TIMEOUT_USEC = 10000;
    this.KWS = false;
    this.KWT = false;
    this.KWU = null;
    this.startTime = 0L;
    this.nzC = new Object();
    this.KWW = new Object();
    this.KWX = false;
    this.KWY = false;
    this.KWZ = true;
    this.nDh = false;
    this.KXa = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.KWU != null)
        {
          h.this.KWU.buO();
          h.this.KWU = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.hvI = null;
    this.KXd = new byte[0];
    this.pause = false;
    this.KXf = 0L;
    this.KXg = -1L;
    this.KXh = false;
    this.KXj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.hvI == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.KXh = true;
        h.this.gcz();
        AppMethodBeat.o(89478);
      }
    };
    this.KXk = 0L;
    this.KXl = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.KXa.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.KWS) {
          paramAnonymousInt = 1;
        }
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          localh.tiD += 128;
        }
        boolean bool = h.this.KXb;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.KWZ) {
            break label209;
          }
          if (!localh.KWX) {
            break label247;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.KXh)) {}
          synchronized (h.this.KXd)
          {
            if (h.this.KXe != null)
            {
              Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.KXe.buN();
              h.this.KXe = null;
              h.this.KXc = true;
              h.this.KXh = true;
              h.this.KXi.removeCallbacks(h.this.KXj);
              h.this.KXi.post(h.this.KXj);
              AppMethodBeat.o(89479);
              return;
              label209:
              synchronized (localh.nzC)
              {
                if (!localh.KWX) {}
              }
              label247:
              if (0L == localh.KWN) {
                localh.KWN = System.nanoTime();
              }
              if (localh.KWV != null)
              {
                AppMethodBeat.o(89479);
                throw null;
              }
              if (localh.nzs == null) {
                continue;
              }
              if (localh.pause)
              {
                Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.nzs == null) {
                Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localh.yv(bool);
                break;
                try
                {
                  ??? = localh.nzs.aPD();
                  paramAnonymousInt = localh.nzs.dequeueInputBuffer(10000L);
                  localh.KWO = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.yv(false);
                      localh.KWO = localh.nzs.dequeueInputBuffer(10000L);
                      if (localh.KWO >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.nzs != null) {
                    break label473;
                  }
                  Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                  continue;
                }
                finally
                {
                  Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label473:
                if (localh.KWO >= 0)
                {
                  ??? = ???[localh.KWO];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.KWP = ???.length;
                  localh.KWQ = System.nanoTime();
                  localh.KWQ -= localh.KWP * 1000000000L / localh.audioSampleRate;
                  if (localh.KWP == -3) {
                    Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l = localh.KWQ;
                  if (localh.KWV != null)
                  {
                    AppMethodBeat.o(89479);
                    throw null;
                  }
                  localh.KWR = ((l - localh.KWN) / 1000L);
                  localh.KWR -= localh.KXf * 1000L;
                  if ((localh.KWQ < 0L) && (localh.KXk <= 0L)) {
                    localh.KXk = (-localh.KWQ);
                  }
                  localh.KWQ += localh.KXk;
                  Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.KWP + " audio bytes with pts " + localh.KWR + ", end:" + bool + ", enqueue:" + localh.KWO);
                  if (bool)
                  {
                    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.nzs.a(localh.KWO, localh.KWP, localh.KWR, 4);
                  }
                  else
                  {
                    localh.nzs.a(localh.KWO, localh.KWP, localh.KWR, 0);
                  }
                }
              }
            }
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
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
    this.KWV = null;
    this.KWZ = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVg, false);
    this.nDh = paramBoolean;
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.nDh) });
    AppMethodBeat.o(89482);
  }
  
  private void gcA()
  {
    AppMethodBeat.i(89491);
    if ((this.KWX) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    while (this.KWY) {
      Thread.yield();
    }
    this.KWX = true;
    try
    {
      if (this.nzs != null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.nzs.stop();
        this.nzs.release();
        this.nzs = null;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      this.nzs = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int L(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 87	com/tencent/mm/plugin/mmsight/model/a/h:KWT	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   23: ifnonnull +414 -> 437
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc 166
    //   30: ldc 228
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: aastore
    //   43: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 234	com/tencent/mm/audio/b/c:aGH	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   65: ifnonnull +377 -> 442
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 166
    //   72: ldc 236
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_3
    //   81: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 239	com/tencent/mm/plugin/mmsight/model/a/h:boZ	()V
    //   92: aload_0
    //   93: getfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 244 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 246	com/tencent/mm/plugin/mmsight/model/a/h:tiD	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 248	com/tencent/mm/plugin/mmsight/model/a/h:KXb	Z
    //   123: aload_0
    //   124: getfield 118	com/tencent/mm/plugin/mmsight/model/a/h:KXd	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 250	com/tencent/mm/plugin/mmsight/model/a/h:KXc	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 128	com/tencent/mm/plugin/mmsight/model/a/h:KXh	Z
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 226	com/tencent/mm/plugin/mmsight/model/a/h:KXe	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_0
    //   148: getfield 87	com/tencent/mm/plugin/mmsight/model/a/h:KWT	Z
    //   151: ifne +60 -> 211
    //   154: aload_0
    //   155: new 230	com/tencent/mm/audio/b/c
    //   158: dup
    //   159: aload_0
    //   160: getfield 142	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   163: aload_0
    //   164: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   167: iconst_5
    //   168: invokespecial 253	com/tencent/mm/audio/b/c:<init>	(III)V
    //   171: putfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   174: aload_0
    //   175: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   178: iconst_1
    //   179: invokevirtual 256	com/tencent/mm/audio/b/c:ol	(I)V
    //   182: aload_0
    //   183: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   186: sipush 128
    //   189: invokevirtual 259	com/tencent/mm/audio/b/c:ok	(I)V
    //   192: aload_0
    //   193: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   196: iconst_1
    //   197: invokevirtual 263	com/tencent/mm/audio/b/c:eo	(Z)V
    //   200: aload_0
    //   201: getfield 116	com/tencent/mm/plugin/mmsight/model/a/h:hvI	Lcom/tencent/mm/audio/b/c;
    //   204: aload_0
    //   205: getfield 138	com/tencent/mm/plugin/mmsight/model/a/h:KXl	Lcom/tencent/mm/audio/b/c$a;
    //   208: putfield 266	com/tencent/mm/audio/b/c:hwy	Lcom/tencent/mm/audio/b/c$a;
    //   211: aload_0
    //   212: getfield 268	com/tencent/mm/plugin/mmsight/model/a/h:KXi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   215: ifnonnull +244 -> 459
    //   218: ldc 166
    //   220: ldc_w 270
    //   223: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: new 272	com/tencent/mm/sdk/platformtools/MMHandler
    //   230: dup
    //   231: invokespecial 273	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   234: putfield 268	com/tencent/mm/plugin/mmsight/model/a/h:KXi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   237: ldc 166
    //   239: ldc_w 275
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
    //   266: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_0
    //   270: new 277	android/media/MediaCodec$BufferInfo
    //   273: dup
    //   274: invokespecial 278	android/media/MediaCodec$BufferInfo:<init>	()V
    //   277: putfield 280	com/tencent/mm/plugin/mmsight/model/a/h:KWM	Landroid/media/MediaCodec$BufferInfo;
    //   280: aload_0
    //   281: new 282	android/media/MediaFormat
    //   284: dup
    //   285: invokespecial 283	android/media/MediaFormat:<init>	()V
    //   288: putfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   291: aload_0
    //   292: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   295: ldc_w 287
    //   298: ldc_w 289
    //   301: invokevirtual 292	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   308: ldc_w 294
    //   311: iconst_2
    //   312: invokevirtual 298	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   315: aload_0
    //   316: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   319: ldc_w 300
    //   322: aload_0
    //   323: getfield 142	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   326: invokevirtual 298	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   329: aload_0
    //   330: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   333: ldc_w 302
    //   336: aload_0
    //   337: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   340: invokevirtual 298	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   343: aload_0
    //   344: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   347: ldc_w 304
    //   350: aload_0
    //   351: getfield 140	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   354: invokevirtual 298	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   357: aload_0
    //   358: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   361: ldc_w 306
    //   364: aload_0
    //   365: getfield 144	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   368: sipush 16384
    //   371: imul
    //   372: invokevirtual 298	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   375: aload_0
    //   376: ldc_w 289
    //   379: iconst_0
    //   380: invokestatic 310	com/tencent/mm/compatible/deviceinfo/aa:u	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   383: putfield 199	com/tencent/mm/plugin/mmsight/model/a/h:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   386: aload_0
    //   387: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   390: aload_0
    //   391: getfield 285	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   394: aconst_null
    //   395: iconst_1
    //   396: invokevirtual 313	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   399: aload_0
    //   400: getfield 199	com/tencent/mm/plugin/mmsight/model/a/h:nzs	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   403: invokevirtual 316	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   406: aload_0
    //   407: getfield 101	com/tencent/mm/plugin/mmsight/model/a/h:KWZ	Z
    //   410: ifeq +104 -> 514
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 97	com/tencent/mm/plugin/mmsight/model/a/h:KWX	Z
    //   418: aload_0
    //   419: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   422: putfield 91	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   425: aload_0
    //   426: iconst_0
    //   427: putfield 85	com/tencent/mm/plugin/mmsight/model/a/h:KWS	Z
    //   430: ldc 224
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
    //   451: ldc 224
    //   453: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload 4
    //   458: athrow
    //   459: aload_0
    //   460: getfield 268	com/tencent/mm/plugin/mmsight/model/a/h:KXi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   463: invokevirtual 325	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   466: invokestatic 328	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   469: if_acmpeq -232 -> 237
    //   472: ldc 166
    //   474: ldc_w 330
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 268	com/tencent/mm/plugin/mmsight/model/a/h:KXi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   487: invokevirtual 325	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: invokestatic 328	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   496: aastore
    //   497: invokestatic 333	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: new 272	com/tencent/mm/sdk/platformtools/MMHandler
    //   504: dup
    //   505: invokespecial 273	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   508: putfield 268	com/tencent/mm/plugin/mmsight/model/a/h:KXi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   511: goto -274 -> 237
    //   514: aload_0
    //   515: getfield 93	com/tencent/mm/plugin/mmsight/model/a/h:nzC	Ljava/lang/Object;
    //   518: astore_2
    //   519: aload_2
    //   520: monitorenter
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 97	com/tencent/mm/plugin/mmsight/model/a/h:KWX	Z
    //   526: aload_0
    //   527: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   530: putfield 91	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   533: aload_2
    //   534: monitorexit
    //   535: goto -110 -> 425
    //   538: astore 4
    //   540: aload_2
    //   541: monitorexit
    //   542: ldc 224
    //   544: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload 4
    //   549: athrow
    //   550: astore_2
    //   551: ldc 166
    //   553: aload_2
    //   554: ldc_w 335
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_2
    //   564: invokevirtual 338	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_0
    //   572: invokevirtual 239	com/tencent/mm/plugin/mmsight/model/a/h:boZ	()V
    //   575: ldc_w 344
    //   578: ldc_w 346
    //   581: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: getstatic 352	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   587: ldc2_w 353
    //   590: ldc2_w 355
    //   593: lconst_1
    //   594: iconst_0
    //   595: invokevirtual 360	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 85	com/tencent/mm/plugin/mmsight/model/a/h:KWS	Z
    //   603: ldc 224
    //   605: invokestatic 187	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iconst_m1
    //   609: ireturn
    //   610: astore_2
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 85	com/tencent/mm/plugin/mmsight/model/a/h:KWS	Z
    //   616: ldc 224
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
    //   521	535	538	finally
    //   269	425	550	finally
    //   514	521	550	finally
    //   540	550	550	finally
    //   551	598	610	finally
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    AppMethodBeat.i(89486);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.KWU = parama;
    if (!this.KWT)
    {
      if (this.hvI == null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.hvI.aGR()) {}
    }
    for (;;)
    {
      this.KXf = 0L;
      this.KXg = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.KXa.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.hvI == null)
    {
      bool1 = true;
      if (this.KXe != null) {
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
      Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.KXb) });
      if ((this.hvI != null) || (this.KWT)) {
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
    this.KXb = true;
    synchronized (this.KXd)
    {
      this.KXe = paramb;
      if ((this.KXc) && (paramb != null))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.buN();
        this.KXe = null;
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.boZ();
            h.this.gcz();
            AppMethodBeat.o(89481);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
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
    if ((this.KWV != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89494);
      throw null;
    }
    AppMethodBeat.o(89494);
  }
  
  protected boolean boY()
  {
    return false;
  }
  
  protected final void boZ()
  {
    AppMethodBeat.i(89490);
    if (this.KWZ)
    {
      gcA();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.nzC)
    {
      gcA();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    boZ();
    gcz();
    AppMethodBeat.o(89488);
  }
  
  public final void gcw()
  {
    this.KWS = true;
  }
  
  public final com.tencent.mm.audio.b.c.a gcx()
  {
    return this.KXl;
  }
  
  final void gcz()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.hvI != null) && (!this.KWT))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.hvI.aGH();
        this.hvI = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  protected void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89493);
    if ((this.KWV != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89493);
      throw null;
    }
    AppMethodBeat.o(89493);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.KWS = false;
    this.pause = true;
    this.KXg = Util.currentTicks();
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.KXg) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.KXg) });
    this.pause = false;
    if (this.KXg > 0L) {
      this.KXf += Util.ticksToNow(this.KXg);
    }
    this.KXg = 0L;
    this.KWS = true;
    AppMethodBeat.o(89484);
  }
  
  public void uu(int paramInt) {}
  
  public final void yt(boolean paramBoolean)
  {
    this.KWT = paramBoolean;
  }
  
  final void yv(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.nzs == null)
    {
      Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(89492);
      return;
    }
    ByteBuffer localByteBuffer;
    int j;
    label512:
    label537:
    label549:
    MediaCodec.BufferInfo localBufferInfo2;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer = this.nzs.aPE();
        this.pcl = this.nzs.dequeueOutputBuffer(this.KWM, 10000L);
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.pcl) });
        if (this.pcl == -1)
        {
          Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
          AppMethodBeat.o(89492);
          return;
        }
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException1.getMessage() });
        AppMethodBeat.o(89492);
        return;
      }
      Object localObject;
      if (this.pcl == -3)
      {
        localObject = this.nzs.aPE();
      }
      else if (this.pcl == -2)
      {
        Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(this.nzs.getOutputFormat())));
        if (this.KWV != null)
        {
          AppMethodBeat.o(89492);
          throw null;
        }
      }
      else if (this.pcl < 0)
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.pcl) });
      }
      else
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localByteBuffer = localObject[this.pcl];
        if (localByteBuffer == null)
        {
          localObject = new RuntimeException("encoderOutputBuffer " + this.pcl + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject);
        }
        boolean bool = this.KWX;
        if (bool)
        {
          AppMethodBeat.o(89492);
          return;
        }
        this.KWY = true;
        if ((this.KWM.flags & 0x2) != 0)
        {
          Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.KWM.size), Boolean.valueOf(boY()) });
          if (boY()) {
            this.KWM.size = 0;
          }
        }
        if (this.KWM.size != 0)
        {
          if (this.KWV != null)
          {
            AppMethodBeat.o(89492);
            throw null;
          }
          localByteBuffer.position(this.KWM.offset);
          localByteBuffer.limit(this.KWM.offset + this.KWM.size);
          bool = this.nDh;
          if (!bool) {
            break label678;
          }
        }
        try
        {
          MediaCodec.BufferInfo localBufferInfo1 = this.KWM;
          if (this.nzs.getOutputFormat() == null) {
            break label710;
          }
          i = this.nzs.getOutputFormat().getInteger("aac-profile");
          if (this.nzs.getOutputFormat() == null) {
            break label715;
          }
          j = a.abb(this.nzs.getOutputFormat().getInteger("sample-rate"));
          if (this.nzs.getOutputFormat() == null) {
            break label720;
          }
          k = this.nzs.getOutputFormat().getInteger("channel-count");
          a(localByteBuffer, localBufferInfo1, i, j, k);
          this.nzs.releaseOutputBuffer(this.pcl, false);
          this.KWY = false;
          if ((this.KWM.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label691;
            }
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo2 = this.KWM;
          if (this.mAudioFormat == null) {
            break label726;
          }
        }
      }
    }
    int i = this.mAudioFormat.getInteger("aac-profile");
    label623:
    if (this.mAudioFormat != null)
    {
      j = a.abb(this.mAudioFormat.getInteger("sample-rate"));
      if (this.mAudioFormat == null) {
        break label736;
      }
    }
    label644:
    label678:
    label691:
    label710:
    label715:
    label720:
    label726:
    label736:
    for (int k = this.mAudioFormat.getInteger("channel-count");; k = 1)
    {
      a(localByteBuffer, localBufferInfo2, i, j, k);
      break label549;
      h(localByteBuffer, this.KWM);
      break label549;
      Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      boZ();
      AppMethodBeat.o(89492);
      return;
      i = 2;
      break;
      j = 4;
      break label512;
      k = 1;
      break label537;
      i = 2;
      break label623;
      j = 4;
      break label644;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */