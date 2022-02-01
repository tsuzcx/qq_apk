package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  Runnable FbA;
  long FbB;
  private com.tencent.mm.audio.b.c.a FbC;
  private MediaCodec.BufferInfo Fbd;
  long Fbe;
  int Fbf;
  int Fbg;
  long Fbh;
  long Fbi;
  boolean Fbj;
  private boolean Fbk;
  public c.a Fbl;
  o Fbm;
  private final Object Fbn;
  volatile boolean Fbo;
  private volatile boolean Fbp;
  boolean Fbq;
  MMHandler Fbr;
  protected boolean Fbs;
  boolean Fbt;
  final Object Fbu;
  c.b Fbv;
  long Fbw;
  private long Fbx;
  boolean Fby;
  MMHandler Fbz;
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  private int audioChannelCount;
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c frx;
  aa kTH;
  final Object kTT;
  private boolean kXY;
  private MediaFormat mAudioFormat;
  private int miO;
  volatile boolean pause;
  int qdO;
  private long startTime;
  
  public h(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(89482);
    this.Fbe = 0L;
    this.TIMEOUT_USEC = 10000;
    this.Fbj = false;
    this.Fbk = false;
    this.Fbl = null;
    this.startTime = 0L;
    this.kTT = new Object();
    this.Fbn = new Object();
    this.Fbo = false;
    this.Fbp = false;
    this.Fbq = true;
    this.kXY = false;
    this.Fbr = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.Fbl != null)
        {
          h.this.Fbl.aZS();
          h.this.Fbl = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.frx = null;
    this.Fbu = new byte[0];
    this.pause = false;
    this.Fbw = 0L;
    this.Fbx = -1L;
    this.Fby = false;
    this.FbA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.frx == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.Fby = true;
        h.this.eTG();
        AppMethodBeat.o(89478);
      }
    };
    this.FbB = 0L;
    this.FbC = new com.tencent.mm.audio.b.c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.Fbr.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.Fbj) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.qdO += 128;
        }
        boolean bool = h.this.Fbs;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.Fbq) {
            break label207;
          }
          if (!localh.Fbo) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.Fby)) {}
          synchronized (h.this.Fbu)
          {
            if (h.this.Fbv != null)
            {
              Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.Fbv.aZQ();
              h.this.Fbv = null;
              h.this.Fbt = true;
              h.this.Fby = true;
              h.this.Fbz.removeCallbacks(h.this.FbA);
              h.this.Fbz.post(h.this.FbA);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.kTT)
              {
                if (!localh.Fbo) {}
              }
              label245:
              if (0L == localh.Fbe) {
                localh.Fbe = System.nanoTime();
              }
              if (localh.Fbm != null)
              {
                AppMethodBeat.o(89479);
                throw null;
              }
              if (localh.kTH == null) {
                continue;
              }
              if (localh.pause)
              {
                Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.kTH == null) {
                Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localh.uh(bool);
                break;
                try
                {
                  ??? = localh.kTH.avj();
                  paramAnonymousInt = localh.kTH.EX(10000L);
                  localh.Fbf = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.uh(false);
                      localh.Fbf = localh.kTH.EX(10000L);
                      if (localh.Fbf >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.kTH != null) {
                    break label471;
                  }
                  Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label471:
                if (localh.Fbf >= 0)
                {
                  ??? = ???[localh.Fbf];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.Fbg = ???.length;
                  localh.Fbh = System.nanoTime();
                  localh.Fbh -= localh.Fbg * 1000000000L / localh.audioSampleRate;
                  if (localh.Fbg == -3) {
                    Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l = localh.Fbh;
                  if (localh.Fbm != null)
                  {
                    AppMethodBeat.o(89479);
                    throw null;
                  }
                  localh.Fbi = ((l - localh.Fbe) / 1000L);
                  localh.Fbi -= localh.Fbw * 1000L;
                  if ((localh.Fbh < 0L) && (localh.FbB <= 0L)) {
                    localh.FbB = (-localh.Fbh);
                  }
                  localh.Fbh += localh.FbB;
                  Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.Fbg + " audio bytes with pts " + localh.Fbi + ", end:" + bool + ", enqueue:" + localh.Fbf);
                  if (bool)
                  {
                    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.kTH.a(localh.Fbf, localh.Fbg, localh.Fbi, 4);
                  }
                  else
                  {
                    localh.kTH.a(localh.Fbf, localh.Fbg, localh.Fbi, 0);
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
    this.Fbm = null;
    this.Fbq = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vFH, true);
    this.kXY = paramBoolean;
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.kXY) });
    AppMethodBeat.o(89482);
  }
  
  private void eTH()
  {
    AppMethodBeat.i(89491);
    if ((this.Fbo) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    while (this.Fbp) {
      Thread.yield();
    }
    this.Fbo = true;
    try
    {
      if (this.kTH != null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.kTH.stop();
        this.kTH.release();
        this.kTH = null;
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
      this.kTH = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int J(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:Fbk	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   23: ifnonnull +414 -> 437
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc 169
    //   30: ldc 232
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: aastore
    //   43: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 238	com/tencent/mm/audio/b/c:aeJ	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   65: ifnonnull +377 -> 442
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 169
    //   72: ldc 240
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_3
    //   81: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 243	com/tencent/mm/plugin/mmsight/model/a/h:aUx	()V
    //   92: aload_0
    //   93: getfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 248 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 250	com/tencent/mm/plugin/mmsight/model/a/h:qdO	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 252	com/tencent/mm/plugin/mmsight/model/a/h:Fbs	Z
    //   123: aload_0
    //   124: getfield 121	com/tencent/mm/plugin/mmsight/model/a/h:Fbu	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 254	com/tencent/mm/plugin/mmsight/model/a/h:Fbt	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 131	com/tencent/mm/plugin/mmsight/model/a/h:Fby	Z
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 230	com/tencent/mm/plugin/mmsight/model/a/h:Fbv	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_0
    //   148: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:Fbk	Z
    //   151: ifne +60 -> 211
    //   154: aload_0
    //   155: new 234	com/tencent/mm/audio/b/c
    //   158: dup
    //   159: aload_0
    //   160: getfield 145	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   163: aload_0
    //   164: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   167: iconst_5
    //   168: invokespecial 257	com/tencent/mm/audio/b/c:<init>	(III)V
    //   171: putfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   174: aload_0
    //   175: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   178: iconst_1
    //   179: invokevirtual 260	com/tencent/mm/audio/b/c:kE	(I)V
    //   182: aload_0
    //   183: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   186: sipush 128
    //   189: invokevirtual 263	com/tencent/mm/audio/b/c:kD	(I)V
    //   192: aload_0
    //   193: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   196: iconst_1
    //   197: invokevirtual 267	com/tencent/mm/audio/b/c:dC	(Z)V
    //   200: aload_0
    //   201: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:frx	Lcom/tencent/mm/audio/b/c;
    //   204: aload_0
    //   205: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:FbC	Lcom/tencent/mm/audio/b/c$a;
    //   208: putfield 270	com/tencent/mm/audio/b/c:fsk	Lcom/tencent/mm/audio/b/c$a;
    //   211: aload_0
    //   212: getfield 272	com/tencent/mm/plugin/mmsight/model/a/h:Fbz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   215: ifnonnull +244 -> 459
    //   218: ldc 169
    //   220: ldc_w 274
    //   223: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: new 276	com/tencent/mm/sdk/platformtools/MMHandler
    //   230: dup
    //   231: invokespecial 277	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   234: putfield 272	com/tencent/mm/plugin/mmsight/model/a/h:Fbz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   237: ldc 169
    //   239: ldc_w 279
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
    //   266: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_0
    //   270: new 281	android/media/MediaCodec$BufferInfo
    //   273: dup
    //   274: invokespecial 282	android/media/MediaCodec$BufferInfo:<init>	()V
    //   277: putfield 284	com/tencent/mm/plugin/mmsight/model/a/h:Fbd	Landroid/media/MediaCodec$BufferInfo;
    //   280: aload_0
    //   281: new 286	android/media/MediaFormat
    //   284: dup
    //   285: invokespecial 287	android/media/MediaFormat:<init>	()V
    //   288: putfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   291: aload_0
    //   292: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   295: ldc_w 291
    //   298: ldc_w 293
    //   301: invokevirtual 296	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   308: ldc_w 298
    //   311: iconst_2
    //   312: invokevirtual 302	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   315: aload_0
    //   316: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   319: ldc_w 304
    //   322: aload_0
    //   323: getfield 145	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   326: invokevirtual 302	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   329: aload_0
    //   330: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   333: ldc_w 306
    //   336: aload_0
    //   337: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   340: invokevirtual 302	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   343: aload_0
    //   344: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   347: ldc_w 308
    //   350: aload_0
    //   351: getfield 143	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   354: invokevirtual 302	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   357: aload_0
    //   358: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   361: ldc_w 310
    //   364: aload_0
    //   365: getfield 147	com/tencent/mm/plugin/mmsight/model/a/h:audioChannelCount	I
    //   368: sipush 16384
    //   371: imul
    //   372: invokevirtual 302	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   375: aload_0
    //   376: ldc_w 293
    //   379: iconst_0
    //   380: invokestatic 314	com/tencent/mm/compatible/deviceinfo/aa:t	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   383: putfield 202	com/tencent/mm/plugin/mmsight/model/a/h:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   386: aload_0
    //   387: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   390: aload_0
    //   391: getfield 289	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   394: aconst_null
    //   395: iconst_1
    //   396: invokevirtual 317	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   399: aload_0
    //   400: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:kTH	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   403: invokevirtual 320	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   406: aload_0
    //   407: getfield 104	com/tencent/mm/plugin/mmsight/model/a/h:Fbq	Z
    //   410: ifeq +104 -> 514
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:Fbo	Z
    //   418: aload_0
    //   419: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   422: putfield 94	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   425: aload_0
    //   426: iconst_0
    //   427: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:Fbj	Z
    //   430: ldc 228
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
    //   451: ldc 228
    //   453: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload 4
    //   458: athrow
    //   459: aload_0
    //   460: getfield 272	com/tencent/mm/plugin/mmsight/model/a/h:Fbz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   463: invokevirtual 329	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   466: invokestatic 332	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   469: if_acmpeq -232 -> 237
    //   472: ldc 169
    //   474: ldc_w 334
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 272	com/tencent/mm/plugin/mmsight/model/a/h:Fbz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   487: invokevirtual 329	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: invokestatic 332	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   496: aastore
    //   497: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: new 276	com/tencent/mm/sdk/platformtools/MMHandler
    //   504: dup
    //   505: invokespecial 277	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   508: putfield 272	com/tencent/mm/plugin/mmsight/model/a/h:Fbz	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   511: goto -274 -> 237
    //   514: aload_0
    //   515: getfield 96	com/tencent/mm/plugin/mmsight/model/a/h:kTT	Ljava/lang/Object;
    //   518: astore_2
    //   519: aload_2
    //   520: monitorenter
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:Fbo	Z
    //   526: aload_0
    //   527: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   530: putfield 94	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   533: aload_2
    //   534: monitorexit
    //   535: goto -110 -> 425
    //   538: astore 4
    //   540: aload_2
    //   541: monitorexit
    //   542: ldc 228
    //   544: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload 4
    //   549: athrow
    //   550: astore_2
    //   551: ldc 169
    //   553: aload_2
    //   554: ldc_w 339
    //   557: iconst_1
    //   558: anewarray 4	java/lang/Object
    //   561: dup
    //   562: iconst_0
    //   563: aload_2
    //   564: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_0
    //   572: invokevirtual 243	com/tencent/mm/plugin/mmsight/model/a/h:aUx	()V
    //   575: ldc_w 346
    //   578: ldc_w 348
    //   581: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: getstatic 354	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   587: ldc2_w 355
    //   590: ldc2_w 357
    //   593: lconst_1
    //   594: iconst_0
    //   595: invokevirtual 362	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:Fbj	Z
    //   603: ldc 228
    //   605: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iconst_m1
    //   609: ireturn
    //   610: astore_2
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:Fbj	Z
    //   616: ldc 228
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
    //   521	535	538	finally
    //   269	425	550	java/lang/Throwable
    //   514	521	550	java/lang/Throwable
    //   540	550	550	java/lang/Throwable
    //   269	425	610	finally
    //   514	521	610	finally
    //   540	550	610	finally
    //   551	598	610	finally
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    AppMethodBeat.i(89486);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.Fbl = parama;
    if (!this.Fbk)
    {
      if (this.frx == null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.frx.aeU()) {}
    }
    for (;;)
    {
      this.Fbw = 0L;
      this.Fbx = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.Fbr.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.frx == null)
    {
      bool1 = true;
      if (this.Fbv != null) {
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
      Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.Fbs) });
      if ((this.frx != null) || (this.Fbk)) {
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
    this.Fbs = true;
    synchronized (this.Fbu)
    {
      this.Fbv = paramb;
      if ((this.Fbt) && (paramb != null))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.aZQ();
        this.Fbv = null;
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.aUx();
            h.this.eTG();
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
    if ((this.Fbm != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89494);
      throw null;
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void aUx()
  {
    AppMethodBeat.i(89490);
    if (this.Fbq)
    {
      eTH();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.kTT)
    {
      eTH();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean aZx()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    aUx();
    eTG();
    AppMethodBeat.o(89488);
  }
  
  public final void eTD()
  {
    this.Fbj = true;
  }
  
  public final com.tencent.mm.audio.b.c.a eTE()
  {
    return this.FbC;
  }
  
  final void eTG()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.frx != null) && (!this.Fbk))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.frx.aeJ();
        this.frx = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  protected void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89493);
    if ((this.Fbm != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89493);
      throw null;
    }
    AppMethodBeat.o(89493);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.Fbj = false;
    this.pause = true;
    this.Fbx = Util.currentTicks();
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.Fbx) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.Fbx) });
    this.pause = false;
    if (this.Fbx > 0L) {
      this.Fbw += Util.ticksToNow(this.Fbx);
    }
    this.Fbx = 0L;
    this.Fbj = true;
    AppMethodBeat.o(89484);
  }
  
  public final void uf(boolean paramBoolean)
  {
    this.Fbk = paramBoolean;
  }
  
  final void uh(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.kTH == null)
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
        ByteBuffer[] arrayOfByteBuffer = this.kTH.avk();
        this.miO = this.kTH.a(this.Fbd, 10000L);
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.miO) });
        if (this.miO == -1)
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
      if (this.miO == -3)
      {
        localObject = this.kTH.avk();
      }
      else if (this.miO == -2)
      {
        Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(this.kTH.avi())));
        if (this.Fbm != null)
        {
          AppMethodBeat.o(89492);
          throw null;
        }
      }
      else if (this.miO < 0)
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.miO) });
      }
      else
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localByteBuffer = localObject[this.miO];
        if (localByteBuffer == null)
        {
          localObject = new RuntimeException("encoderOutputBuffer " + this.miO + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject);
        }
        boolean bool = this.Fbo;
        if (bool)
        {
          AppMethodBeat.o(89492);
          return;
        }
        this.Fbp = true;
        if ((this.Fbd.flags & 0x2) != 0)
        {
          Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.Fbd.size), Boolean.valueOf(aZx()) });
          if (aZx()) {
            this.Fbd.size = 0;
          }
        }
        if (this.Fbd.size != 0)
        {
          if (this.Fbm != null)
          {
            AppMethodBeat.o(89492);
            throw null;
          }
          localByteBuffer.position(this.Fbd.offset);
          localByteBuffer.limit(this.Fbd.offset + this.Fbd.size);
          bool = this.kXY;
          if (!bool) {
            break label678;
          }
        }
        try
        {
          MediaCodec.BufferInfo localBufferInfo1 = this.Fbd;
          if (this.kTH.avi() == null) {
            break label710;
          }
          i = this.kTH.avi().getInteger("aac-profile");
          if (this.kTH.avi() == null) {
            break label715;
          }
          j = a.WZ(this.kTH.avi().getInteger("sample-rate"));
          if (this.kTH.avi() == null) {
            break label720;
          }
          k = this.kTH.avi().getInteger("channel-count");
          a(localByteBuffer, localBufferInfo1, i, j, k);
          this.kTH.releaseOutputBuffer(this.miO, false);
          this.Fbp = false;
          if ((this.Fbd.flags & 0x4) != 0)
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
          localBufferInfo2 = this.Fbd;
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
      j = a.WZ(this.mAudioFormat.getInteger("sample-rate"));
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
      h(localByteBuffer, this.Fbd);
      break label549;
      Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      aUx();
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
  
  public void uu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */