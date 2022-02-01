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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  private int audioChannelCount;
  int audioSampleRate;
  volatile boolean dDA;
  volatile com.tencent.mm.audio.b.c dhw;
  z hlX;
  final Object hmj;
  private boolean hpR;
  private int ixV;
  int lVV;
  private MediaFormat mAudioFormat;
  private long startTime;
  private MediaCodec.BufferInfo wbC;
  long wbD;
  int wbE;
  int wbF;
  long wbG;
  long wbH;
  boolean wbI;
  private boolean wbJ;
  public c.a wbK;
  p wbL;
  private final Object wbM;
  volatile boolean wbN;
  private volatile boolean wbO;
  boolean wbP;
  aq wbQ;
  protected boolean wbR;
  boolean wbS;
  final Object wbT;
  c.b wbU;
  long wbV;
  private long wbW;
  boolean wbX;
  aq wbY;
  Runnable wbZ;
  long wca;
  private com.tencent.mm.audio.b.c.a wcb;
  
  public h(int paramInt1, int paramInt2, int paramInt3, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(210680);
    this.wbD = 0L;
    this.TIMEOUT_USEC = 10000;
    this.wbI = false;
    this.wbJ = false;
    this.wbK = null;
    this.startTime = 0L;
    this.hmj = new Object();
    this.wbM = new Object();
    this.wbN = false;
    this.wbO = false;
    this.wbP = true;
    this.hpR = false;
    this.wbQ = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.wbK != null)
        {
          h.this.wbK.ayu();
          h.this.wbK = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.dhw = null;
    this.wbT = new byte[0];
    this.dDA = false;
    this.wbV = 0L;
    this.wbW = -1L;
    this.wbX = false;
    this.wbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.dhw == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.wbX = true;
        h.this.dqk();
        AppMethodBeat.o(89478);
      }
    };
    this.wca = 0L;
    this.wcb = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.wbQ.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.wbI) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.lVV += 128;
        }
        boolean bool = h.this.wbR;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.wbP) {
            break label207;
          }
          if (!localh.wbN) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.wbX)) {}
          synchronized (h.this.wbT)
          {
            if (h.this.wbU != null)
            {
              ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.wbU.ayt();
              h.this.wbU = null;
              h.this.wbS = true;
              h.this.wbX = true;
              h.this.wbY.removeCallbacks(h.this.wbZ);
              h.this.wbY.post(h.this.wbZ);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.hmj)
              {
                if (!localh.wbN) {}
              }
              label245:
              if (0L == localh.wbD) {
                localh.wbD = System.nanoTime();
              }
              if ((localh.wbL != null) && (localh.wbL.dqr() <= 0L)) {
                localh.wbL.dqs();
              }
              if (localh.hlX == null) {
                continue;
              }
              if (localh.dDA)
              {
                ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.hlX == null) {
                ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              label800:
              for (;;)
              {
                localh.drainEncoder(bool);
                break;
                try
                {
                  ??? = localh.hlX.getInputBuffers();
                  paramAnonymousInt = localh.hlX.dequeueInputBuffer(10000L);
                  localh.wbE = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    ae.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.drainEncoder(false);
                      localh.wbE = localh.hlX.dequeueInputBuffer(10000L);
                      if (localh.wbE >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.hlX != null) {
                    break label485;
                  }
                  ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  ae.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label485:
                if (localh.wbE >= 0)
                {
                  ??? = ???[localh.wbE];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.wbF = ???.length;
                  localh.wbG = System.nanoTime();
                  localh.wbG -= localh.wbF * 1000000000L / localh.audioSampleRate;
                  if (localh.wbF == -3) {
                    ae.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.wbG;
                  if (localh.wbL != null) {}
                  for (long l1 = localh.wbL.dqr();; l1 = localh.wbD)
                  {
                    localh.wbH = ((l2 - l1) / 1000L);
                    localh.wbH -= localh.wbV * 1000L;
                    if ((localh.wbG < 0L) && (localh.wca <= 0L)) {
                      localh.wca = (-localh.wbG);
                    }
                    localh.wbG += localh.wca;
                    ae.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.wbF + " audio bytes with pts " + localh.wbH + ", end:" + bool + ", enqueue:" + localh.wbE);
                    if (!bool) {
                      break label800;
                    }
                    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.hlX.a(localh.wbE, localh.wbF, localh.wbH, 4);
                    break;
                  }
                  localh.hlX.a(localh.wbE, localh.wbF, localh.wbH, 0);
                }
              }
            }
            ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
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
    this.wbL = paramp;
    this.wbP = ((b)g.ab(b.class)).a(b.a.qFy, true);
    this.hpR = paramBoolean;
    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.hpR) });
    AppMethodBeat.o(210680);
  }
  
  private void dql()
  {
    AppMethodBeat.i(89491);
    if ((this.wbN) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    while (this.wbO) {
      Thread.yield();
    }
    this.wbN = true;
    try
    {
      if (this.hlX != null)
      {
        ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.hlX.stop();
        this.hlX.release();
        this.hlX = null;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      this.hlX = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int E(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:wbJ	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   23: ifnonnull +414 -> 437
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc 169
    //   30: ldc 233
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: aastore
    //   43: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 239	com/tencent/mm/audio/b/c:PF	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:hlX	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   65: ifnonnull +377 -> 442
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 169
    //   72: ldc 241
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_3
    //   81: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 244	com/tencent/mm/plugin/mmsight/model/a/h:atH	()V
    //   92: aload_0
    //   93: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 249 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 251	com/tencent/mm/plugin/mmsight/model/a/h:lVV	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 253	com/tencent/mm/plugin/mmsight/model/a/h:wbR	Z
    //   123: aload_0
    //   124: getfield 121	com/tencent/mm/plugin/mmsight/model/a/h:wbT	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 255	com/tencent/mm/plugin/mmsight/model/a/h:wbS	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 131	com/tencent/mm/plugin/mmsight/model/a/h:wbX	Z
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 231	com/tencent/mm/plugin/mmsight/model/a/h:wbU	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_0
    //   148: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:wbJ	Z
    //   151: ifne +60 -> 211
    //   154: aload_0
    //   155: new 235	com/tencent/mm/audio/b/c
    //   158: dup
    //   159: aload_0
    //   160: getfield 145	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   163: aload_0
    //   164: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   167: iconst_5
    //   168: invokespecial 258	com/tencent/mm/audio/b/c:<init>	(III)V
    //   171: putfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   174: aload_0
    //   175: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   178: iconst_1
    //   179: invokevirtual 261	com/tencent/mm/audio/b/c:setAudioSource	(I)V
    //   182: aload_0
    //   183: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   186: sipush 128
    //   189: invokevirtual 264	com/tencent/mm/audio/b/c:hQ	(I)V
    //   192: aload_0
    //   193: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   196: iconst_1
    //   197: invokevirtual 268	com/tencent/mm/audio/b/c:cu	(Z)V
    //   200: aload_0
    //   201: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dhw	Lcom/tencent/mm/audio/b/c;
    //   204: aload_0
    //   205: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:wcb	Lcom/tencent/mm/audio/b/c$a;
    //   208: putfield 271	com/tencent/mm/audio/b/c:dij	Lcom/tencent/mm/audio/b/c$a;
    //   211: aload_0
    //   212: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:wbY	Lcom/tencent/mm/sdk/platformtools/aq;
    //   215: ifnonnull +244 -> 459
    //   218: ldc 169
    //   220: ldc_w 275
    //   223: invokestatic 207	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: new 277	com/tencent/mm/sdk/platformtools/aq
    //   230: dup
    //   231: invokespecial 278	com/tencent/mm/sdk/platformtools/aq:<init>	()V
    //   234: putfield 273	com/tencent/mm/plugin/mmsight/model/a/h:wbY	Lcom/tencent/mm/sdk/platformtools/aq;
    //   237: ldc 169
    //   239: ldc_w 280
    //   242: iconst_2
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload_0
    //   249: getfield 145	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   252: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload_0
    //   259: getfield 143	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   262: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 187	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_0
    //   270: new 282	android/media/MediaCodec$BufferInfo
    //   273: dup
    //   274: invokespecial 283	android/media/MediaCodec$BufferInfo:<init>	()V
    //   277: putfield 285	com/tencent/mm/plugin/mmsight/model/a/h:wbC	Landroid/media/MediaCodec$BufferInfo;
    //   280: aload_0
    //   281: new 287	android/media/MediaFormat
    //   284: dup
    //   285: invokespecial 288	android/media/MediaFormat:<init>	()V
    //   288: putfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   291: aload_0
    //   292: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   295: ldc_w 292
    //   298: ldc_w 294
    //   301: invokevirtual 297	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   308: ldc_w 299
    //   311: iconst_2
    //   312: invokevirtual 303	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   315: aload_0
    //   316: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   319: ldc_w 305
    //   322: aload_0
    //   323: getfield 145	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   326: invokevirtual 303	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   329: aload_0
    //   330: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   333: ldc_w 307
    //   336: aload_0
    //   337: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   340: invokevirtual 303	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   343: aload_0
    //   344: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   347: ldc_w 309
    //   350: aload_0
    //   351: getfield 143	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   354: invokevirtual 303	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   357: aload_0
    //   358: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   361: ldc_w 311
    //   364: aload_0
    //   365: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   368: sipush 16384
    //   371: imul
    //   372: invokevirtual 303	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   375: aload_0
    //   376: ldc_w 294
    //   379: iconst_0
    //   380: invokestatic 315	com/tencent/mm/compatible/deviceinfo/z:q	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   383: putfield 202	com/tencent/mm/plugin/mmsight/model/a/h:hlX	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   386: aload_0
    //   387: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:hlX	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   390: aload_0
    //   391: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   394: aconst_null
    //   395: iconst_1
    //   396: invokevirtual 318	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   399: aload_0
    //   400: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:hlX	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   403: invokevirtual 321	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   406: aload_0
    //   407: getfield 104	com/tencent/mm/plugin/mmsight/model/a/h:wbP	Z
    //   410: ifeq +104 -> 514
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:wbN	Z
    //   418: aload_0
    //   419: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   422: putfield 94	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   425: aload_0
    //   426: iconst_0
    //   427: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:wbI	Z
    //   430: ldc 229
    //   432: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   451: ldc 229
    //   453: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload 4
    //   458: athrow
    //   459: aload_0
    //   460: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:wbY	Lcom/tencent/mm/sdk/platformtools/aq;
    //   463: invokevirtual 330	com/tencent/mm/sdk/platformtools/aq:getLooper	()Landroid/os/Looper;
    //   466: invokestatic 333	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   469: if_acmpeq -232 -> 237
    //   472: ldc 169
    //   474: ldc_w 335
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:wbY	Lcom/tencent/mm/sdk/platformtools/aq;
    //   487: invokevirtual 330	com/tencent/mm/sdk/platformtools/aq:getLooper	()Landroid/os/Looper;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: invokestatic 333	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   496: aastore
    //   497: invokestatic 338	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: new 277	com/tencent/mm/sdk/platformtools/aq
    //   504: dup
    //   505: invokespecial 278	com/tencent/mm/sdk/platformtools/aq:<init>	()V
    //   508: putfield 273	com/tencent/mm/plugin/mmsight/model/a/h:wbY	Lcom/tencent/mm/sdk/platformtools/aq;
    //   511: goto -274 -> 237
    //   514: aload_0
    //   515: getfield 96	com/tencent/mm/plugin/mmsight/model/a/h:hmj	Ljava/lang/Object;
    //   518: astore_2
    //   519: aload_2
    //   520: monitorenter
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:wbN	Z
    //   526: aload_0
    //   527: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   530: putfield 94	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   533: aload_2
    //   534: monitorexit
    //   535: goto -110 -> 425
    //   538: astore 4
    //   540: aload_2
    //   541: monitorexit
    //   542: ldc 229
    //   544: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload 4
    //   549: athrow
    //   550: astore_2
    //   551: ldc 169
    //   553: aload_2
    //   554: ldc_w 340
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_2
    //   564: invokevirtual 341	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 345	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_0
    //   572: invokevirtual 244	com/tencent/mm/plugin/mmsight/model/a/h:atH	()V
    //   575: ldc_w 347
    //   578: ldc_w 349
    //   581: invokestatic 207	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: getstatic 355	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   587: ldc2_w 356
    //   590: ldc2_w 358
    //   593: lconst_1
    //   594: iconst_0
    //   595: invokevirtual 363	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:wbI	Z
    //   603: ldc 229
    //   605: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iconst_m1
    //   609: ireturn
    //   610: astore_2
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:wbI	Z
    //   616: ldc 229
    //   618: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.wbK = parama;
    if (!this.wbJ)
    {
      if (this.dhw == null)
      {
        ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.dhw.PO()) {}
    }
    for (;;)
    {
      this.wbV = 0L;
      this.wbW = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.wbQ.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.dhw == null)
    {
      bool1 = true;
      if (this.wbU != null) {
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
      ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.wbR) });
      if ((this.dhw != null) || (this.wbJ)) {
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
    this.wbR = true;
    synchronized (this.wbT)
    {
      this.wbU = paramb;
      if ((this.wbS) && (paramb != null))
      {
        ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.ayt();
        this.wbU = null;
      }
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.atH();
            h.this.dqk();
            AppMethodBeat.o(89481);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
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
    if ((this.wbL != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.wbL.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void atH()
  {
    AppMethodBeat.i(89490);
    if (this.wbP)
    {
      dql();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.hmj)
    {
      dql();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean ayb()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    atH();
    dqk();
    AppMethodBeat.o(89488);
  }
  
  public final void dqg()
  {
    this.wbI = true;
  }
  
  public final com.tencent.mm.audio.b.c.a dqh()
  {
    return this.wcb;
  }
  
  final void dqk()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.dhw != null) && (!this.wbJ))
      {
        ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.dhw.PF();
        this.dhw = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.hlX == null)
    {
      ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
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
        ByteBuffer[] arrayOfByteBuffer = this.hlX.getOutputBuffers();
        this.ixV = this.hlX.dequeueOutputBuffer(this.wbC, 10000L);
        ae.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.ixV) });
        if (this.ixV == -1)
        {
          ae.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
          AppMethodBeat.o(89492);
          return;
        }
      }
      catch (Exception localException1)
      {
        ae.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException1.getMessage() });
        AppMethodBeat.o(89492);
        return;
      }
      Object localObject1;
      if (this.ixV == -3)
      {
        localObject1 = this.hlX.getOutputBuffers();
      }
      else if (this.ixV == -2)
      {
        localMediaFormat = this.hlX.getOutputFormat();
        ae.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
        if (this.wbL != null) {
          this.wbL.f(localMediaFormat);
        }
      }
      else if (this.ixV < 0)
      {
        ae.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.ixV) });
      }
      else
      {
        ae.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localMediaFormat = localObject1[this.ixV];
        if (localMediaFormat == null)
        {
          localObject1 = new RuntimeException("encoderOutputBuffer " + this.ixV + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject1);
        }
        boolean bool = this.wbN;
        if (bool)
        {
          AppMethodBeat.o(89492);
          return;
        }
        this.wbO = true;
        if ((this.wbC.flags & 0x2) != 0)
        {
          ae.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.wbC.size), Boolean.valueOf(ayb()) });
          if (ayb()) {
            this.wbC.size = 0;
          }
        }
        Object localObject2;
        if (this.wbC.size != 0)
        {
          if ((this.wbL != null) && (!this.wbL.dqt()))
          {
            localObject2 = this.hlX.getOutputFormat();
            this.wbL.f((MediaFormat)localObject2);
          }
          localMediaFormat.position(this.wbC.offset);
          localMediaFormat.limit(this.wbC.offset + this.wbC.size);
          bool = this.hpR;
          if (!bool) {
            break label706;
          }
        }
        try
        {
          localObject2 = this.wbC;
          if (this.hlX.getOutputFormat() == null) {
            break label738;
          }
          i = this.hlX.getOutputFormat().getInteger("aac-profile");
          if (this.hlX.getOutputFormat() == null) {
            break label743;
          }
          j = a.KK(this.hlX.getOutputFormat().getInteger("sample-rate"));
          if (this.hlX.getOutputFormat() == null) {
            break label748;
          }
          k = this.hlX.getOutputFormat().getInteger("channel-count");
          a(localMediaFormat, (MediaCodec.BufferInfo)localObject2, i, j, k);
          this.hlX.releaseOutputBuffer(this.ixV, false);
          this.wbO = false;
          if ((this.wbC.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label719;
            }
            ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo = this.wbC;
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
      j = a.KK(this.mAudioFormat.getInteger("sample-rate"));
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
      h(localMediaFormat, this.wbC);
      break label577;
      ae.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      atH();
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
    if ((this.wbL != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.wbL.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89493);
  }
  
  public void oe(int paramInt) {}
  
  public final void ox(boolean paramBoolean)
  {
    this.wbJ = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.wbI = false;
    this.dDA = true;
    this.wbW = bu.HQ();
    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.wbW) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    ae.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.wbW) });
    this.dDA = false;
    if (this.wbW > 0L) {
      this.wbV += bu.aO(this.wbW);
    }
    this.wbW = 0L;
    this.wbI = true;
    AppMethodBeat.o(89484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */