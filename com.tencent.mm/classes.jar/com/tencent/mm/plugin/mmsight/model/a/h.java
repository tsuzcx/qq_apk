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
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c cXI;
  volatile boolean dsU;
  private int gnH;
  z gqj;
  final Object gqv;
  private boolean guv;
  private int hBe;
  int kQL;
  private MediaFormat mAudioFormat;
  private long startTime;
  private MediaCodec.BufferInfo tDY;
  long tDZ;
  int tEa;
  int tEb;
  long tEc;
  long tEd;
  boolean tEe;
  private boolean tEf;
  public c.a tEg;
  o tEh;
  private final Object tEi;
  volatile boolean tEj;
  boolean tEk;
  ap tEl;
  protected boolean tEm;
  boolean tEn;
  final Object tEo;
  c.b tEp;
  long tEq;
  private long tEr;
  boolean tEs;
  ap tEt;
  Runnable tEu;
  private com.tencent.mm.audio.b.c.a tEv;
  
  public h(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(89482);
    this.tDZ = 0L;
    this.TIMEOUT_USEC = 10000;
    this.tEe = false;
    this.tEf = false;
    this.tEg = null;
    this.startTime = 0L;
    this.gqv = new Object();
    this.tEi = new Object();
    this.tEj = false;
    this.tEk = true;
    this.guv = false;
    this.tEl = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.tEg != null)
        {
          h.this.tEg.aoB();
          h.this.tEg = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.cXI = null;
    this.tEo = new byte[0];
    this.dsU = false;
    this.tEq = 0L;
    this.tEr = -1L;
    this.tEs = false;
    this.tEu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.cXI == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.tEs = true;
        h.this.cQi();
        AppMethodBeat.o(89478);
      }
    };
    this.tEv = new com.tencent.mm.audio.b.c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.tEl.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.tEe) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.kQL += 128;
        }
        boolean bool = h.this.tEm;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.tEk) {
            break label207;
          }
          if (!localh.tEj) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.tEs)) {}
          synchronized (h.this.tEo)
          {
            if (h.this.tEp != null)
            {
              ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.tEp.aoA();
              h.this.tEp = null;
              h.this.tEn = true;
              h.this.tEs = true;
              h.this.tEt.removeCallbacks(h.this.tEu);
              h.this.tEt.post(h.this.tEu);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.gqv)
              {
                if (!localh.tEj) {}
              }
              label245:
              if (0L == localh.tDZ) {
                localh.tDZ = System.nanoTime();
              }
              if ((localh.tEh != null) && (localh.tEh.tEQ <= 0L)) {
                localh.tEh.tEQ = System.nanoTime();
              }
              if (localh.gqj == null) {
                continue;
              }
              if (localh.dsU)
              {
                ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.gqj == null) {
                ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              for (;;)
              {
                localh.drainEncoder(bool);
                break;
                try
                {
                  ??? = localh.gqj.getInputBuffers();
                  paramAnonymousInt = localh.gqj.dequeueInputBuffer(10000L);
                  localh.tEa = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    ad.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.drainEncoder(false);
                      localh.tEa = localh.gqj.dequeueInputBuffer(10000L);
                      if (localh.tEa >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.gqj != null) {
                    break label488;
                  }
                  ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label488:
                if (localh.tEa >= 0)
                {
                  ??? = ???[localh.tEa];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.tEb = ???.length;
                  localh.tEc = System.nanoTime();
                  localh.tEc -= localh.tEb / localh.audioSampleRate / 1000000000;
                  if (localh.tEb == -3) {
                    ad.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.tEc;
                  if (localh.tEh != null) {}
                  for (long l1 = localh.tEh.tEQ;; l1 = localh.tDZ)
                  {
                    localh.tEd = ((l2 - l1) / 1000L);
                    localh.tEd -= localh.tEq * 1000L;
                    ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.tEb + " audio bytes with pts " + localh.tEd + ", end:" + bool + ", enqueue:" + localh.tEa);
                    if (!bool) {
                      break label753;
                    }
                    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.gqj.a(localh.tEa, localh.tEb, localh.tEd, 4);
                    break;
                  }
                  label753:
                  localh.gqj.a(localh.tEa, localh.tEb, localh.tEd, 0);
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
    this.gnH = paramInt3;
    if (this.gnH <= 0) {
      this.gnH = 1;
    }
    this.tEh = null;
    this.tEk = ((b)g.ab(b.class)).a(b.a.pqb, true);
    this.guv = paramBoolean;
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.gnH), Boolean.valueOf(this.guv) });
    AppMethodBeat.o(89482);
  }
  
  private void cQj()
  {
    AppMethodBeat.i(89491);
    if ((this.tEj) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    this.tEj = true;
    try
    {
      if (this.gqj != null)
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.gqj.stop();
        this.gqj.release();
        this.gqj = null;
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
      this.gqj = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int D(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 88	com/tencent/mm/plugin/mmsight/model/a/h:tEf	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
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
    //   43: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 228	com/tencent/mm/audio/b/c:Ob	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gqj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
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
    //   85: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 233	com/tencent/mm/plugin/mmsight/model/a/h:ajF	()V
    //   92: aload_0
    //   93: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 238 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 240	com/tencent/mm/plugin/mmsight/model/a/h:kQL	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 242	com/tencent/mm/plugin/mmsight/model/a/h:tEm	Z
    //   123: aload_0
    //   124: getfield 117	com/tencent/mm/plugin/mmsight/model/a/h:tEo	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 244	com/tencent/mm/plugin/mmsight/model/a/h:tEn	Z
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 220	com/tencent/mm/plugin/mmsight/model/a/h:tEp	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_0
    //   143: getfield 88	com/tencent/mm/plugin/mmsight/model/a/h:tEf	Z
    //   146: ifne +60 -> 206
    //   149: aload_0
    //   150: new 224	com/tencent/mm/audio/b/c
    //   153: dup
    //   154: aload_0
    //   155: getfield 139	com/tencent/mm/plugin/mmsight/model/a/h:audioSampleRate	I
    //   158: aload_0
    //   159: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gnH	I
    //   162: iconst_5
    //   163: invokespecial 247	com/tencent/mm/audio/b/c:<init>	(III)V
    //   166: putfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   169: aload_0
    //   170: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   173: iconst_1
    //   174: invokevirtual 250	com/tencent/mm/audio/b/c:setAudioSource	(I)V
    //   177: aload_0
    //   178: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   181: sipush 128
    //   184: invokevirtual 253	com/tencent/mm/audio/b/c:hX	(I)V
    //   187: aload_0
    //   188: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   191: iconst_1
    //   192: invokevirtual 257	com/tencent/mm/audio/b/c:cr	(Z)V
    //   195: aload_0
    //   196: getfield 115	com/tencent/mm/plugin/mmsight/model/a/h:cXI	Lcom/tencent/mm/audio/b/c;
    //   199: aload_0
    //   200: getfield 135	com/tencent/mm/plugin/mmsight/model/a/h:tEv	Lcom/tencent/mm/audio/b/c$a;
    //   203: putfield 260	com/tencent/mm/audio/b/c:cYv	Lcom/tencent/mm/audio/b/c$a;
    //   206: aload_0
    //   207: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:tEt	Lcom/tencent/mm/sdk/platformtools/ap;
    //   210: ifnonnull +244 -> 454
    //   213: ldc 163
    //   215: ldc_w 264
    //   218: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_0
    //   222: new 266	com/tencent/mm/sdk/platformtools/ap
    //   225: dup
    //   226: invokespecial 267	com/tencent/mm/sdk/platformtools/ap:<init>	()V
    //   229: putfield 262	com/tencent/mm/plugin/mmsight/model/a/h:tEt	Lcom/tencent/mm/sdk/platformtools/ap;
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
    //   261: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_0
    //   265: new 271	android/media/MediaCodec$BufferInfo
    //   268: dup
    //   269: invokespecial 272	android/media/MediaCodec$BufferInfo:<init>	()V
    //   272: putfield 274	com/tencent/mm/plugin/mmsight/model/a/h:tDY	Landroid/media/MediaCodec$BufferInfo;
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
    //   332: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gnH	I
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
    //   360: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:gnH	I
    //   363: sipush 16384
    //   366: imul
    //   367: invokevirtual 292	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   370: aload_0
    //   371: ldc_w 283
    //   374: iconst_0
    //   375: invokestatic 304	com/tencent/mm/compatible/deviceinfo/z:q	(Ljava/lang/String;Z)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   378: putfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gqj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   381: aload_0
    //   382: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gqj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   385: aload_0
    //   386: getfield 279	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   389: aconst_null
    //   390: iconst_1
    //   391: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   394: aload_0
    //   395: getfield 191	com/tencent/mm/plugin/mmsight/model/a/h:gqj	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   398: invokevirtual 310	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   401: aload_0
    //   402: getfield 100	com/tencent/mm/plugin/mmsight/model/a/h:tEk	Z
    //   405: ifeq +104 -> 509
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 98	com/tencent/mm/plugin/mmsight/model/a/h:tEj	Z
    //   413: aload_0
    //   414: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   417: putfield 92	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   420: aload_0
    //   421: iconst_0
    //   422: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:tEe	Z
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
    //   455: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:tEt	Lcom/tencent/mm/sdk/platformtools/ap;
    //   458: invokevirtual 319	com/tencent/mm/sdk/platformtools/ap:getLooper	()Landroid/os/Looper;
    //   461: invokestatic 322	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   464: if_acmpeq -232 -> 232
    //   467: ldc 163
    //   469: ldc_w 324
    //   472: iconst_2
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_0
    //   479: getfield 262	com/tencent/mm/plugin/mmsight/model/a/h:tEt	Lcom/tencent/mm/sdk/platformtools/ap;
    //   482: invokevirtual 319	com/tencent/mm/sdk/platformtools/ap:getLooper	()Landroid/os/Looper;
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: invokestatic 322	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   491: aastore
    //   492: invokestatic 327	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload_0
    //   496: new 266	com/tencent/mm/sdk/platformtools/ap
    //   499: dup
    //   500: invokespecial 267	com/tencent/mm/sdk/platformtools/ap:<init>	()V
    //   503: putfield 262	com/tencent/mm/plugin/mmsight/model/a/h:tEt	Lcom/tencent/mm/sdk/platformtools/ap;
    //   506: goto -274 -> 232
    //   509: aload_0
    //   510: getfield 94	com/tencent/mm/plugin/mmsight/model/a/h:gqv	Ljava/lang/Object;
    //   513: astore_2
    //   514: aload_2
    //   515: monitorenter
    //   516: aload_0
    //   517: iconst_0
    //   518: putfield 98	com/tencent/mm/plugin/mmsight/model/a/h:tEj	Z
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
    //   563: invokestatic 334	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload_0
    //   567: invokevirtual 233	com/tencent/mm/plugin/mmsight/model/a/h:ajF	()V
    //   570: ldc_w 336
    //   573: ldc_w 338
    //   576: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: getstatic 344	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   582: ldc2_w 345
    //   585: ldc2_w 347
    //   588: lconst_1
    //   589: iconst_0
    //   590: invokevirtual 352	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   593: aload_0
    //   594: iconst_0
    //   595: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:tEe	Z
    //   598: ldc 218
    //   600: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   603: iconst_m1
    //   604: ireturn
    //   605: astore_2
    //   606: aload_0
    //   607: iconst_0
    //   608: putfield 86	com/tencent/mm/plugin/mmsight/model/a/h:tEe	Z
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
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.tEg = parama;
    if (!this.tEf)
    {
      if (this.cXI == null)
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.cXI.Ok()) {}
    }
    for (;;)
    {
      this.tEq = 0L;
      this.tEr = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.tEl.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.cXI == null)
    {
      bool1 = true;
      if (this.tEp != null) {
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
      ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.tEm) });
      if ((this.cXI != null) || (this.tEf)) {
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
    this.tEm = true;
    synchronized (this.tEo)
    {
      this.tEp = paramb;
      if ((this.tEn) && (paramb != null))
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.aoA();
        this.tEp = null;
      }
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.ajF();
            h.this.cQi();
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
    if ((this.tEh != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.tEh.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void ajF()
  {
    AppMethodBeat.i(89490);
    if (this.tEk)
    {
      cQj();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.gqv)
    {
      cQj();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean aoi()
  {
    return false;
  }
  
  public final void cQe()
  {
    this.tEe = true;
  }
  
  public final com.tencent.mm.audio.b.c.a cQf()
  {
    return this.tEv;
  }
  
  final void cQi()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.cXI != null) && (!this.tEf))
      {
        ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.cXI.Ob();
        this.cXI = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    ajF();
    cQi();
    AppMethodBeat.o(89488);
  }
  
  final void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.gqj == null)
    {
      ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
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
        ByteBuffer[] arrayOfByteBuffer = this.gqj.getOutputBuffers();
        this.hBe = this.gqj.dequeueOutputBuffer(this.tDY, 10000L);
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.hBe) });
        if (this.hBe == -1)
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
      if (this.hBe == -3)
      {
        localObject1 = this.gqj.getOutputBuffers();
      }
      else if (this.hBe == -2)
      {
        localMediaFormat = this.gqj.getOutputFormat();
        ad.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
        if (this.tEh != null) {
          this.tEh.l(localMediaFormat);
        }
      }
      else if (this.hBe < 0)
      {
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.hBe) });
      }
      else
      {
        ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localMediaFormat = localObject1[this.hBe];
        if (localMediaFormat == null)
        {
          localObject1 = new RuntimeException("encoderOutputBuffer " + this.hBe + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject1);
        }
        if ((this.tDY.flags & 0x2) != 0)
        {
          ad.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.tDY.size), Boolean.valueOf(aoi()) });
          if (aoi()) {
            this.tDY.size = 0;
          }
        }
        Object localObject2;
        if (this.tDY.size != 0)
        {
          if ((this.tEh != null) && (!this.tEh.isStart))
          {
            localObject2 = this.gqj.getOutputFormat();
            this.tEh.l((MediaFormat)localObject2);
          }
          localMediaFormat.position(this.tDY.offset);
          localMediaFormat.limit(this.tDY.offset + this.tDY.size);
          boolean bool = this.guv;
          if (!bool) {
            break label678;
          }
        }
        try
        {
          localObject2 = this.tDY;
          if (this.gqj.getOutputFormat() == null) {
            break label710;
          }
          i = this.gqj.getOutputFormat().getInteger("aac-profile");
          if (this.gqj.getOutputFormat() == null) {
            break label715;
          }
          j = a.GR(this.gqj.getOutputFormat().getInteger("sample-rate"));
          if (this.gqj.getOutputFormat() == null) {
            break label720;
          }
          k = this.gqj.getOutputFormat().getInteger("channel-count");
          a(localMediaFormat, (MediaCodec.BufferInfo)localObject2, i, j, k);
          this.gqj.releaseOutputBuffer(this.hBe, false);
          if ((this.tDY.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label691;
            }
            ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo = this.tDY;
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
      j = a.GR(this.mAudioFormat.getInteger("sample-rate"));
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
      h(localMediaFormat, this.tDY);
      break label554;
      ad.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      ajF();
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
    if ((this.tEh != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.tEh.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89493);
  }
  
  public void mO(int paramInt) {}
  
  public final void nf(boolean paramBoolean)
  {
    this.tEf = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.tEe = false;
    this.dsU = true;
    this.tEr = bt.GC();
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.tEr) });
    AppMethodBeat.o(89483);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    ad.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.tEr) });
    this.dsU = false;
    if (this.tEr > 0L) {
      this.tEq += bt.aS(this.tEr);
    }
    this.tEr = 0L;
    this.tEe = true;
    AppMethodBeat.o(89484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */