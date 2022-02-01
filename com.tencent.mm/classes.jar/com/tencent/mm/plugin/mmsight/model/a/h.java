package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c cVe;
  volatile boolean dqE;
  private int gOt;
  z gQR;
  final Object gRd;
  private boolean gVa;
  private int ibF;
  int lsl;
  private MediaFormat mAudioFormat;
  private long startTime;
  private boolean uMA;
  public c.a uMB;
  o uMC;
  private final Object uMD;
  volatile boolean uME;
  boolean uMF;
  ao uMG;
  protected boolean uMH;
  boolean uMI;
  final Object uMJ;
  c.b uMK;
  long uML;
  private long uMM;
  boolean uMN;
  ao uMO;
  Runnable uMP;
  private com.tencent.mm.audio.b.c.a uMQ;
  private MediaCodec.BufferInfo uMt;
  long uMu;
  int uMv;
  int uMw;
  long uMx;
  long uMy;
  boolean uMz;
  
  public h(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(89482);
    this.uMu = 0L;
    this.TIMEOUT_USEC = 10000;
    this.uMz = false;
    this.uMA = false;
    this.uMB = null;
    this.startTime = 0L;
    this.gRd = new Object();
    this.uMD = new Object();
    this.uME = false;
    this.uMF = true;
    this.gVa = false;
    this.uMG = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.uMB != null)
        {
          h.this.uMB.avs();
          h.this.uMB = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.cVe = null;
    this.uMJ = new byte[0];
    this.dqE = false;
    this.uML = 0L;
    this.uMM = -1L;
    this.uMN = false;
    this.uMP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.cVe == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.uMN = true;
        h.this.ddQ();
        AppMethodBeat.o(89478);
      }
    };
    this.uMQ = new com.tencent.mm.audio.b.c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void u(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.uMG.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.uMz) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.lsl += 128;
        }
        boolean bool = h.this.uMH;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.uMF) {
            break label207;
          }
          if (!localh.uME) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.uMN)) {}
          synchronized (h.this.uMJ)
          {
            if (h.this.uMK != null)
            {
              ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.uMK.avr();
              h.this.uMK = null;
              h.this.uMI = true;
              h.this.uMN = true;
              h.this.uMO.removeCallbacks(h.this.uMP);
              h.this.uMO.post(h.this.uMP);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.gRd)
              {
                if (!localh.uME) {}
              }
              label245:
              if (0L == localh.uMu) {
                localh.uMu = System.nanoTime();
              }
              if ((localh.uMC != null) && (localh.uMC.uNl <= 0L)) {
                localh.uMC.uNl = System.nanoTime();
              }
              if (localh.gQR == null) {
                continue;
              }
              if (localh.dqE)
              {
                ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.gQR == null) {
                ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localh.drainEncoder(bool);
                break;
                try
                {
                  ??? = localh.gQR.getInputBuffers();
                  paramAnonymousInt = localh.gQR.dequeueInputBuffer(10000L);
                  localh.uMv = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    ac.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.drainEncoder(false);
                      localh.uMv = localh.gQR.dequeueInputBuffer(10000L);
                      if (localh.uMv >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.gQR != null) {
                    break label488;
                  }
                  ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  ac.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label488:
                if (localh.uMv >= 0)
                {
                  ??? = ???[localh.uMv];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.uMw = ???.length;
                  localh.uMx = System.nanoTime();
                  localh.uMx -= localh.uMw / localh.audioSampleRate / 1000000000;
                  if (localh.uMw == -3) {
                    ac.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.uMx;
                  if (localh.uMC != null) {}
                  for (long l1 = localh.uMC.uNl;; l1 = localh.uMu)
                  {
                    localh.uMy = ((l2 - l1) / 1000L);
                    localh.uMy -= localh.uML * 1000L;
                    ac.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.uMw + " audio bytes with pts " + localh.uMy + ", end:" + bool + ", enqueue:" + localh.uMv);
                    if (!bool) {
                      break label753;
                    }
                    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.gQR.a(localh.uMv, localh.uMw, localh.uMy, 4);
                    break;
                  }
                  label753:
                  localh.gQR.a(localh.uMv, localh.uMw, localh.uMy, 0);
                }
              }
            }
            ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
          }
        }
      }
    };
    this.audioBitrate = paramInt2;
    this.audioSampleRate = paramInt1;
    this.gOt = paramInt3;
    if (this.gOt <= 0) {
      this.gOt = 1;
    }
    this.uMC = null;
    this.uMF = ((b)g.ab(b.class)).a(b.a.pTM, true);
    this.gVa = paramBoolean;
    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.gOt), Boolean.valueOf(this.gVa) });
    AppMethodBeat.o(89482);
  }
  
  private void ddR()
  {
    AppMethodBeat.i(89491);
    if ((this.uME) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    this.uME = true;
    try
    {
      if (this.gQR != null)
      {
        ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.gQR.stop();
        this.gQR.release();
        this.gQR = null;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      this.gQR = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int E(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 88	com/tencent/mm/plugin/mmsight/model/a/h:uMA	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   23: ifnonnull +409 -> 432
    //   26: iconst_1
    //   27: istore_3
    //   28: ldc 163
    //   30: ldc 222
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 176	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   42: aastore
    //   43: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 228	com/tencent/mm/audio/b/c:NX	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   65: ifnonnull +372 -> 437
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 163
    //   72: ldc 230
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_3
    //   81: invokestatic 176	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 233	com/tencent/mm/plugin/mmsight/model/a/h:aqE	()V
    //   92: aload_0
    //   93: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 238 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 240	com/tencent/mm/plugin/mmsight/model/a/h:lsl	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 242	com/tencent/mm/plugin/mmsight/model/a/h:uMH	Z
    //   123: aload_0
    //   124: getfield 117	com/tencent/mm/plugin/mmsight/model/a/h:uMJ	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 244	com/tencent/mm/plugin/mmsight/model/a/h:uMI	Z
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 220	com/tencent/mm/plugin/mmsight/model/a/h:uMK	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_0
    //   143: getfield 88	com/tencent/mm/plugin/mmsight/model/a/h:uMA	Z
    //   146: ifne +60 -> 206
    //   149: aload_0
    //   150: new 224	com/tencent/mm/audio/b/c
    //   153: dup
    //   154: aload_0
    //   155: getfield 139	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   158: aload_0
    //   159: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gOt	I
    //   162: iconst_5
    //   163: invokespecial 247	com/tencent/mm/audio/b/c:<init>	(III)V
    //   166: putfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   169: aload_0
    //   170: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   173: iconst_1
    //   174: invokevirtual 250	com/tencent/mm/audio/b/c:setAudioSource	(I)V
    //   177: aload_0
    //   178: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   181: sipush 128
    //   184: invokevirtual 253	com/tencent/mm/audio/b/c:hH	(I)V
    //   187: aload_0
    //   188: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   191: iconst_1
    //   192: invokevirtual 257	com/tencent/mm/audio/b/c:cs	(Z)V
    //   195: aload_0
    //   196: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cVe	Lcom/tencent/mm/audio/b/c;
    //   199: aload_0
    //   200: getfield 135	com/tencent/mm/plugin/mmsight/model/a/h:uMQ	Lcom/tencent/mm/audio/b/c$a;
    //   203: putfield 260	com/tencent/mm/audio/b/c:cVR	Lcom/tencent/mm/audio/b/c$a;
    //   206: aload_0
    //   207: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:uMO	Lcom/tencent/mm/sdk/platformtools/ao;
    //   210: ifnonnull +244 -> 454
    //   213: ldc 163
    //   215: ldc_w 264
    //   218: invokestatic 196	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_0
    //   222: new 266	com/tencent/mm/sdk/platformtools/ao
    //   225: dup
    //   226: invokespecial 267	com/tencent/mm/sdk/platformtools/ao:<init>	()V
    //   229: putfield 262	com/tencent/mm/plugin/mmsight/model/a/h:uMO	Lcom/tencent/mm/sdk/platformtools/ao;
    //   232: ldc 163
    //   234: ldc_w 269
    //   237: iconst_2
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload_0
    //   244: getfield 139	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   247: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: aload_0
    //   254: getfield 137	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   257: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: invokestatic 181	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_0
    //   265: new 271	android/media/MediaCodec$BufferInfo
    //   268: dup
    //   269: invokespecial 272	android/media/MediaCodec$BufferInfo:<init>	()V
    //   272: putfield 274	com/tencent/mm/plugin/mmsight/model/a/h:uMt	Landroid/media/MediaCodec$BufferInfo;
    //   275: aload_0
    //   276: new 276	android/media/MediaFormat
    //   279: dup
    //   280: invokespecial 277	android/media/MediaFormat:<init>	()V
    //   283: putfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   286: aload_0
    //   287: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   290: ldc_w 281
    //   293: ldc_w 283
    //   296: invokevirtual 286	android/media/MediaFormat:setString	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_0
    //   300: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   303: ldc_w 288
    //   306: iconst_2
    //   307: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   310: aload_0
    //   311: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   314: ldc_w 294
    //   317: aload_0
    //   318: getfield 139	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   321: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   324: aload_0
    //   325: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   328: ldc_w 296
    //   331: aload_0
    //   332: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gOt	I
    //   335: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   338: aload_0
    //   339: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   342: ldc_w 298
    //   345: aload_0
    //   346: getfield 137	com/tencent/mm/plugin/mmsight/model/a/h:audioBitrate	I
    //   349: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   352: aload_0
    //   353: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   356: ldc_w 300
    //   359: aload_0
    //   360: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gOt	I
    //   363: sipush 16384
    //   366: imul
    //   367: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   370: aload_0
    //   371: ldc_w 283
    //   374: iconst_0
    //   375: invokestatic 304	com/tencent/mm/compatible/deviceinfo/z:q	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   378: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   381: aload_0
    //   382: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   385: aload_0
    //   386: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   389: aconst_null
    //   390: iconst_1
    //   391: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   394: aload_0
    //   395: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gQR	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   398: invokevirtual 310	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   401: aload_0
    //   402: getfield 100	com/tencent/mm/plugin/mmsight/model/a/h:uMF	Z
    //   405: ifeq +104 -> 509
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 98	com/tencent/mm/plugin/mmsight/model/a/h:uME	Z
    //   413: aload_0
    //   414: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   417: putfield 92	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   420: aload_0
    //   421: iconst_0
    //   422: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:uMz	Z
    //   425: ldc 218
    //   427: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: iconst_0
    //   431: ireturn
    //   432: iconst_0
    //   433: istore_3
    //   434: goto -406 -> 28
    //   437: iconst_0
    //   438: istore_3
    //   439: goto -369 -> 70
    //   442: astore 4
    //   444: aload_2
    //   445: monitorexit
    //   446: ldc 218
    //   448: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload 4
    //   453: athrow
    //   454: aload_0
    //   455: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:uMO	Lcom/tencent/mm/sdk/platformtools/ao;
    //   458: invokevirtual 319	com/tencent/mm/sdk/platformtools/ao:getLooper	()Landroid/os/Looper;
    //   461: invokestatic 322	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   464: if_acmpeq -232 -> 232
    //   467: ldc 163
    //   469: ldc_w 324
    //   472: iconst_2
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:uMO	Lcom/tencent/mm/sdk/platformtools/ao;
    //   482: invokevirtual 319	com/tencent/mm/sdk/platformtools/ao:getLooper	()Landroid/os/Looper;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: invokestatic 322	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   491: aastore
    //   492: invokestatic 327	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload_0
    //   496: new 266	com/tencent/mm/sdk/platformtools/ao
    //   499: dup
    //   500: invokespecial 267	com/tencent/mm/sdk/platformtools/ao:<init>	()V
    //   503: putfield 262	com/tencent/mm/plugin/mmsight/model/a/h:uMO	Lcom/tencent/mm/sdk/platformtools/ao;
    //   506: goto -274 -> 232
    //   509: aload_0
    //   510: getfield 94	com/tencent/mm/plugin/mmsight/model/a/h:gRd	Ljava/lang/Object;
    //   513: astore_2
    //   514: aload_2
    //   515: monitorenter
    //   516: aload_0
    //   517: iconst_0
    //   518: putfield 98	com/tencent/mm/plugin/mmsight/model/a/h:uME	Z
    //   521: aload_0
    //   522: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   525: putfield 92	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   528: aload_2
    //   529: monitorexit
    //   530: goto -110 -> 420
    //   533: astore 4
    //   535: aload_2
    //   536: monitorexit
    //   537: ldc 218
    //   539: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload 4
    //   544: athrow
    //   545: astore_2
    //   546: ldc 163
    //   548: aload_2
    //   549: ldc_w 329
    //   552: iconst_1
    //   553: anewarray 4	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: aload_2
    //   559: invokevirtual 330	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   562: aastore
    //   563: invokestatic 334	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload_0
    //   567: invokevirtual 233	com/tencent/mm/plugin/mmsight/model/a/h:aqE	()V
    //   570: ldc_w 336
    //   573: ldc_w 338
    //   576: invokestatic 196	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: getstatic 344	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   582: ldc2_w 345
    //   585: ldc2_w 347
    //   588: lconst_1
    //   589: iconst_0
    //   590: invokevirtual 352	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   593: aload_0
    //   594: iconst_0
    //   595: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:uMz	Z
    //   598: ldc 218
    //   600: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   603: iconst_m1
    //   604: ireturn
    //   605: astore_2
    //   606: aload_0
    //   607: iconst_0
    //   608: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:uMz	Z
    //   611: ldc 218
    //   613: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   616: aload_2
    //   617: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	h
    //   0	618	1	paramInt	int
    //   27	412	3	bool	boolean
    //   442	10	4	localObject1	Object
    //   533	10	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   130	142	442	finally
    //   444	446	442	finally
    //   516	530	533	finally
    //   535	537	533	finally
    //   264	420	545	java/lang/Throwable
    //   509	516	545	java/lang/Throwable
    //   537	545	545	java/lang/Throwable
    //   264	420	605	finally
    //   509	516	605	finally
    //   537	545	605	finally
    //   546	593	605	finally
  }
  
  public final int a(c.a parama)
  {
    int i = 0;
    AppMethodBeat.i(89486);
    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.uMB = parama;
    if (!this.uMA)
    {
      if (this.cVe == null)
      {
        ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.cVe.Og()) {}
    }
    for (;;)
    {
      this.uML = 0L;
      this.uMM = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.uMG.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.cVe == null)
    {
      bool1 = true;
      if (this.uMK != null) {
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
      ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.uMH) });
      if ((this.cVe != null) || (this.uMA)) {
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
    this.uMH = true;
    synchronized (this.uMJ)
    {
      this.uMK = paramb;
      if ((this.uMI) && (paramb != null))
      {
        ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.avr();
        this.uMK = null;
      }
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.aqE();
            h.this.ddQ();
            AppMethodBeat.o(89481);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[] { localException.getMessage() });
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
    if ((this.uMC != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.uMC.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void aqE()
  {
    AppMethodBeat.i(89490);
    if (this.uMF)
    {
      ddR();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.gRd)
    {
      ddR();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean auZ()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    aqE();
    ddQ();
    AppMethodBeat.o(89488);
  }
  
  public final void ddM()
  {
    this.uMz = true;
  }
  
  public final com.tencent.mm.audio.b.c.a ddN()
  {
    return this.uMQ;
  }
  
  final void ddQ()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.cVe != null) && (!this.uMA))
      {
        ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.cVe.NX();
        this.cVe = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.gQR == null)
    {
      ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(89492);
      return;
    }
    MediaFormat localMediaFormat;
    int j;
    label517:
    label542:
    label554:
    MediaCodec.BufferInfo localBufferInfo;
    for (;;)
    {
      try
      {
        ByteBuffer[] arrayOfByteBuffer = this.gQR.getOutputBuffers();
        this.ibF = this.gQR.dequeueOutputBuffer(this.uMt, 10000L);
        ac.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.ibF) });
        if (this.ibF == -1)
        {
          ac.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
          AppMethodBeat.o(89492);
          return;
        }
      }
      catch (Exception localException1)
      {
        ac.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[] { localException1.getMessage() });
        AppMethodBeat.o(89492);
        return;
      }
      Object localObject1;
      if (this.ibF == -3)
      {
        localObject1 = this.gQR.getOutputBuffers();
      }
      else if (this.ibF == -2)
      {
        localMediaFormat = this.gQR.getOutputFormat();
        ac.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
        if (this.uMC != null) {
          this.uMC.g(localMediaFormat);
        }
      }
      else if (this.ibF < 0)
      {
        ac.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.ibF) });
      }
      else
      {
        ac.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localMediaFormat = localObject1[this.ibF];
        if (localMediaFormat == null)
        {
          localObject1 = new RuntimeException("encoderOutputBuffer " + this.ibF + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject1);
        }
        if ((this.uMt.flags & 0x2) != 0)
        {
          ac.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.uMt.size), Boolean.valueOf(auZ()) });
          if (auZ()) {
            this.uMt.size = 0;
          }
        }
        Object localObject2;
        if (this.uMt.size != 0)
        {
          if ((this.uMC != null) && (!this.uMC.isStart))
          {
            localObject2 = this.gQR.getOutputFormat();
            this.uMC.g((MediaFormat)localObject2);
          }
          localMediaFormat.position(this.uMt.offset);
          localMediaFormat.limit(this.uMt.offset + this.uMt.size);
          boolean bool = this.gVa;
          if (!bool) {
            break label678;
          }
        }
        try
        {
          localObject2 = this.uMt;
          if (this.gQR.getOutputFormat() == null) {
            break label710;
          }
          i = this.gQR.getOutputFormat().getInteger("aac-profile");
          if (this.gQR.getOutputFormat() == null) {
            break label715;
          }
          j = a.IN(this.gQR.getOutputFormat().getInteger("sample-rate"));
          if (this.gQR.getOutputFormat() == null) {
            break label720;
          }
          k = this.gQR.getOutputFormat().getInteger("channel-count");
          a(localMediaFormat, (MediaCodec.BufferInfo)localObject2, i, j, k);
          this.gQR.releaseOutputBuffer(this.ibF, false);
          if ((this.uMt.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label691;
            }
            ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo = this.uMt;
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
      j = a.IN(this.mAudioFormat.getInteger("sample-rate"));
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
      a(localMediaFormat, localBufferInfo, i, j, k);
      break label554;
      h(localMediaFormat, this.uMt);
      break label554;
      ac.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      aqE();
      AppMethodBeat.o(89492);
      return;
      i = 2;
      break;
      j = 4;
      break label517;
      k = 1;
      break label542;
      i = 2;
      break label623;
      j = 4;
      break label644;
    }
  }
  
  protected void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89493);
    if ((this.uMC != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.uMC.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89493);
  }
  
  public void nC(int paramInt) {}
  
  public final void nY(boolean paramBoolean)
  {
    this.uMA = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.uMz = false;
    this.dqE = true;
    this.uMM = bs.Gn();
    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.uMM) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    ac.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.uMM) });
    this.dqE = false;
    if (this.uMM > 0L) {
      this.uML += bs.aO(this.uMM);
    }
    this.uMM = 0L;
    this.uMz = true;
    AppMethodBeat.o(89484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */