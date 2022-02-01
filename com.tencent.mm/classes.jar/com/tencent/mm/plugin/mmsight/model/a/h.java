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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h
  implements c
{
  private final int TIMEOUT_USEC;
  private int audioBitrate;
  private int audioChannelCount;
  int audioSampleRate;
  volatile com.tencent.mm.audio.b.c dyI;
  z ieT;
  final Object iff;
  private boolean ijm;
  private int jtk;
  private MediaFormat mAudioFormat;
  int ndx;
  volatile boolean pause;
  private long startTime;
  private MediaCodec.BufferInfo zvE;
  long zvF;
  int zvG;
  int zvH;
  long zvI;
  long zvJ;
  boolean zvK;
  private boolean zvL;
  public c.a zvM;
  p zvN;
  private final Object zvO;
  volatile boolean zvP;
  private volatile boolean zvQ;
  boolean zvR;
  MMHandler zvS;
  protected boolean zvT;
  boolean zvU;
  final Object zvV;
  c.b zvW;
  long zvX;
  private long zvY;
  boolean zvZ;
  MMHandler zwa;
  Runnable zwb;
  long zwc;
  private com.tencent.mm.audio.b.c.a zwd;
  
  public h(int paramInt1, int paramInt2, int paramInt3, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(241182);
    this.zvF = 0L;
    this.TIMEOUT_USEC = 10000;
    this.zvK = false;
    this.zvL = false;
    this.zvM = null;
    this.startTime = 0L;
    this.iff = new Object();
    this.zvO = new Object();
    this.zvP = false;
    this.zvQ = false;
    this.zvR = true;
    this.ijm = false;
    this.zvS = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89477);
        if (h.this.zvM != null)
        {
          h.this.zvM.aQY();
          h.this.zvM = null;
        }
        AppMethodBeat.o(89477);
      }
    };
    this.dyI = null;
    this.zvV = new byte[0];
    this.pause = false;
    this.zvX = 0L;
    this.zvY = -1L;
    this.zvZ = false;
    this.zwb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89478);
        if (h.this.dyI == null)
        {
          AppMethodBeat.o(89478);
          return;
        }
        h.this.zvZ = true;
        h.this.eka();
        AppMethodBeat.o(89478);
      }
    };
    this.zwc = 0L;
    this.zwd = new com.tencent.mm.audio.b.c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89480);
        Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(89480);
      }
      
      public final void w(byte[] arg1, int paramAnonymousInt)
      {
        AppMethodBeat.i(89479);
        h.this.zvS.sendEmptyMessage(0);
        paramAnonymousInt = 0;
        if (!h.this.zvK) {
          paramAnonymousInt = 1;
        }
        if (paramAnonymousInt == 0) {
          h.this.ndx += 128;
        }
        boolean bool = h.this.zvT;
        h localh;
        if (paramAnonymousInt == 0)
        {
          localh = h.this;
          if (!localh.zvR) {
            break label207;
          }
          if (!localh.zvP) {
            break label245;
          }
        }
        for (;;)
        {
          if ((bool) && (!h.this.zvZ)) {}
          synchronized (h.this.zvV)
          {
            if (h.this.zvW != null)
            {
              Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
              h.this.zvW.aQX();
              h.this.zvW = null;
              h.this.zvU = true;
              h.this.zvZ = true;
              h.this.zwa.removeCallbacks(h.this.zwb);
              h.this.zwa.post(h.this.zwb);
              AppMethodBeat.o(89479);
              return;
              label207:
              synchronized (localh.iff)
              {
                if (!localh.zvP) {}
              }
              label245:
              if (0L == localh.zvF) {
                localh.zvF = System.nanoTime();
              }
              if ((localh.zvN != null) && (localh.zvN.ekh() <= 0L)) {
                localh.zvN.eki();
              }
              if (localh.ieT == null) {
                continue;
              }
              if (localh.pause)
              {
                Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "not start now");
                continue;
              }
              if (localh.ieT == null) {
                Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
              }
              label800:
              for (;;)
              {
                localh.rd(bool);
                break;
                try
                {
                  ??? = localh.ieT.getInputBuffers();
                  paramAnonymousInt = localh.ieT.dequeueInputBuffer(10000L);
                  localh.zvG = paramAnonymousInt;
                  if (paramAnonymousInt < 0)
                  {
                    Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                    paramAnonymousInt = 0;
                    while (paramAnonymousInt < 5)
                    {
                      localh.rd(false);
                      localh.zvG = localh.ieT.dequeueInputBuffer(10000L);
                      if (localh.zvG >= 0) {
                        break;
                      }
                      paramAnonymousInt += 1;
                    }
                  }
                  if (localh.ieT != null) {
                    break label485;
                  }
                  Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:".concat(String.valueOf(bool)));
                }
                catch (Throwable ???)
                {
                  Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + ???.getMessage());
                }
                continue;
                label485:
                if (localh.zvG >= 0)
                {
                  ??? = ???[localh.zvG];
                  ((ByteBuffer)???).clear();
                  ((ByteBuffer)???).put(???);
                  ((ByteBuffer)???).position(0);
                  localh.zvH = ???.length;
                  localh.zvI = System.nanoTime();
                  localh.zvI -= localh.zvH * 1000000000L / localh.audioSampleRate;
                  if (localh.zvH == -3) {
                    Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                  }
                  long l2 = localh.zvI;
                  if (localh.zvN != null) {}
                  for (long l1 = localh.zvN.ekh();; l1 = localh.zvF)
                  {
                    localh.zvJ = ((l2 - l1) / 1000L);
                    localh.zvJ -= localh.zvX * 1000L;
                    if ((localh.zvI < 0L) && (localh.zwc <= 0L)) {
                      localh.zwc = (-localh.zvI);
                    }
                    localh.zvI += localh.zwc;
                    Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + localh.zvH + " audio bytes with pts " + localh.zvJ + ", end:" + bool + ", enqueue:" + localh.zvG);
                    if (!bool) {
                      break label800;
                    }
                    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                    localh.ieT.a(localh.zvG, localh.zvH, localh.zvJ, 4);
                    break;
                  }
                  localh.ieT.a(localh.zvG, localh.zvH, localh.zvJ, 0);
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
    this.zvN = paramp;
    this.zvR = ((b)g.af(b.class)).a(b.a.rYK, true);
    this.ijm = paramBoolean;
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", new Object[] { Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.ijm) });
    AppMethodBeat.o(241182);
  }
  
  private void ekb()
  {
    AppMethodBeat.i(89491);
    if ((this.zvP) || (0L == this.startTime))
    {
      AppMethodBeat.o(89491);
      return;
    }
    while (this.zvQ) {
      Thread.yield();
    }
    this.zvP = true;
    try
    {
      if (this.ieT != null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
        this.ieT.stop();
        this.ieT.release();
        this.ieT = null;
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
      this.ieT = null;
      AppMethodBeat.o(89491);
    }
  }
  
  /* Error */
  public int H(int paramInt, String arg2)
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:zvL	Z
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   16: ifnull +38 -> 54
    //   19: aload_0
    //   20: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
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
    //   43: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   50: invokevirtual 239	com/tencent/mm/audio/b/c:ZZ	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   58: ifnull +55 -> 113
    //   61: aload_0
    //   62: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
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
    //   85: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 244	com/tencent/mm/plugin/mmsight/model/a/h:aMi	()V
    //   92: aload_0
    //   93: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   96: ifnull +17 -> 113
    //   99: aload_0
    //   100: getfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   103: invokeinterface 249 1 0
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 251	com/tencent/mm/plugin/mmsight/model/a/h:ndx	I
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 253	com/tencent/mm/plugin/mmsight/model/a/h:zvT	Z
    //   123: aload_0
    //   124: getfield 121	com/tencent/mm/plugin/mmsight/model/a/h:zvV	Ljava/lang/Object;
    //   127: astore_2
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 255	com/tencent/mm/plugin/mmsight/model/a/h:zvU	Z
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 131	com/tencent/mm/plugin/mmsight/model/a/h:zvZ	Z
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 231	com/tencent/mm/plugin/mmsight/model/a/h:zvW	Lcom/tencent/mm/plugin/mmsight/model/a/c$b;
    //   145: aload_2
    //   146: monitorexit
    //   147: aload_0
    //   148: getfield 90	com/tencent/mm/plugin/mmsight/model/a/h:zvL	Z
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
    //   171: putfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   174: aload_0
    //   175: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   178: iconst_1
    //   179: invokevirtual 261	com/tencent/mm/audio/b/c:setAudioSource	(I)V
    //   182: aload_0
    //   183: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   186: sipush 128
    //   189: invokevirtual 264	com/tencent/mm/audio/b/c:jk	(I)V
    //   192: aload_0
    //   193: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   196: iconst_1
    //   197: invokevirtual 268	com/tencent/mm/audio/b/c:dc	(Z)V
    //   200: aload_0
    //   201: getfield 119	com/tencent/mm/plugin/mmsight/model/a/h:dyI	Lcom/tencent/mm/audio/b/c;
    //   204: aload_0
    //   205: getfield 141	com/tencent/mm/plugin/mmsight/model/a/h:zwd	Lcom/tencent/mm/audio/b/c$a;
    //   208: putfield 271	com/tencent/mm/audio/b/c:dzv	Lcom/tencent/mm/audio/b/c$a;
    //   211: aload_0
    //   212: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:zwa	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   215: ifnonnull +244 -> 459
    //   218: ldc 169
    //   220: ldc_w 275
    //   223: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: new 277	com/tencent/mm/sdk/platformtools/MMHandler
    //   230: dup
    //   231: invokespecial 278	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   234: putfield 273	com/tencent/mm/plugin/mmsight/model/a/h:zwa	Lcom/tencent/mm/sdk/platformtools/MMHandler;
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
    //   266: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_0
    //   270: new 282	android/media/MediaCodec$BufferInfo
    //   273: dup
    //   274: invokespecial 283	android/media/MediaCodec$BufferInfo:<init>	()V
    //   277: putfield 285	com/tencent/mm/plugin/mmsight/model/a/h:zvE	Landroid/media/MediaCodec$BufferInfo;
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
    //   383: putfield 202	com/tencent/mm/plugin/mmsight/model/a/h:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   386: aload_0
    //   387: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   390: aload_0
    //   391: getfield 290	com/tencent/mm/plugin/mmsight/model/a/h:mAudioFormat	Landroid/media/MediaFormat;
    //   394: aconst_null
    //   395: iconst_1
    //   396: invokevirtual 318	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   399: aload_0
    //   400: getfield 202	com/tencent/mm/plugin/mmsight/model/a/h:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   403: invokevirtual 321	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   406: aload_0
    //   407: getfield 104	com/tencent/mm/plugin/mmsight/model/a/h:zvR	Z
    //   410: ifeq +104 -> 514
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:zvP	Z
    //   418: aload_0
    //   419: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   422: putfield 94	com/tencent/mm/plugin/mmsight/model/a/h:startTime	J
    //   425: aload_0
    //   426: iconst_0
    //   427: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:zvK	Z
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
    //   460: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:zwa	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   463: invokevirtual 330	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   466: invokestatic 333	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   469: if_acmpeq -232 -> 237
    //   472: ldc 169
    //   474: ldc_w 335
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 273	com/tencent/mm/plugin/mmsight/model/a/h:zwa	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   487: invokevirtual 330	com/tencent/mm/sdk/platformtools/MMHandler:getLooper	()Landroid/os/Looper;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: invokestatic 333	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   496: aastore
    //   497: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: new 277	com/tencent/mm/sdk/platformtools/MMHandler
    //   504: dup
    //   505: invokespecial 278	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   508: putfield 273	com/tencent/mm/plugin/mmsight/model/a/h:zwa	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   511: goto -274 -> 237
    //   514: aload_0
    //   515: getfield 96	com/tencent/mm/plugin/mmsight/model/a/h:iff	Ljava/lang/Object;
    //   518: astore_2
    //   519: aload_2
    //   520: monitorenter
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 100	com/tencent/mm/plugin/mmsight/model/a/h:zvP	Z
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
    //   568: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_0
    //   572: invokevirtual 244	com/tencent/mm/plugin/mmsight/model/a/h:aMi	()V
    //   575: ldc_w 347
    //   578: ldc_w 349
    //   581: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: getstatic 355	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   587: ldc2_w 356
    //   590: ldc2_w 358
    //   593: lconst_1
    //   594: iconst_0
    //   595: invokevirtual 363	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:zvK	Z
    //   603: ldc 229
    //   605: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iconst_m1
    //   609: ireturn
    //   610: astore_2
    //   611: aload_0
    //   612: iconst_0
    //   613: putfield 88	com/tencent/mm/plugin/mmsight/model/a/h:zvK	Z
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
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[] { parama });
    this.zvM = parama;
    if (!this.zvL)
    {
      if (this.dyI == null)
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
        AppMethodBeat.o(89486);
        return -1;
      }
      if (!this.dyI.aai()) {}
    }
    for (;;)
    {
      this.zvX = 0L;
      this.zvY = -1L;
      AppMethodBeat.o(89486);
      return i;
      i = -1;
      continue;
      this.zvS.sendEmptyMessage(0);
    }
  }
  
  public final int a(c.b paramb)
  {
    AppMethodBeat.i(89487);
    boolean bool1;
    boolean bool2;
    if (this.dyI == null)
    {
      bool1 = true;
      if (this.zvW != null) {
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
      Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(this.zvT) });
      if ((this.dyI != null) || (this.zvL)) {
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
    this.zvT = true;
    synchronized (this.zvV)
    {
      this.zvW = paramb;
      if ((this.zvU) && (paramb != null))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
        paramb.aQX();
        this.zvW = null;
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89481);
          try
          {
            h.this.aMi();
            h.this.eka();
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
    if ((this.zvN != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.zvN.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89494);
  }
  
  protected final void aMi()
  {
    AppMethodBeat.i(89490);
    if (this.zvR)
    {
      ekb();
      AppMethodBeat.o(89490);
      return;
    }
    synchronized (this.iff)
    {
      ekb();
      AppMethodBeat.o(89490);
      return;
    }
  }
  
  protected boolean aQF()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89488);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
    aMi();
    eka();
    AppMethodBeat.o(89488);
  }
  
  public final void ejW()
  {
    this.zvK = true;
  }
  
  public final com.tencent.mm.audio.b.c.a ejX()
  {
    return this.zwd;
  }
  
  final void eka()
  {
    try
    {
      AppMethodBeat.i(89489);
      if ((this.dyI != null) && (!this.zvL))
      {
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
        this.dyI.ZZ();
        this.dyI = null;
      }
      AppMethodBeat.o(89489);
      return;
    }
    finally {}
  }
  
  protected void h(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89493);
    if ((this.zvN != null) && ((paramBufferInfo.flags & 0x4) == 0)) {
      this.zvN.j(paramByteBuffer, paramBufferInfo);
    }
    AppMethodBeat.o(89493);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89483);
    this.zvK = false;
    this.pause = true;
    this.zvY = Util.currentTicks();
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", new Object[] { Long.valueOf(this.zvY) });
    AppMethodBeat.o(89483);
  }
  
  public void rA(int paramInt) {}
  
  public final void rc(boolean paramBoolean)
  {
    this.zvL = paramBoolean;
  }
  
  final void rd(boolean paramBoolean)
  {
    AppMethodBeat.i(89492);
    if (this.ieT == null)
    {
      Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(paramBoolean)));
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
        ByteBuffer[] arrayOfByteBuffer = this.ieT.getOutputBuffers();
        this.jtk = this.ieT.dequeueOutputBuffer(this.zvE, 10000L);
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[] { Integer.valueOf(this.jtk) });
        if (this.jtk == -1)
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
      Object localObject1;
      if (this.jtk == -3)
      {
        localObject1 = this.ieT.getOutputBuffers();
      }
      else if (this.jtk == -2)
      {
        localMediaFormat = this.ieT.getOutputFormat();
        Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(localMediaFormat)));
        if (this.zvN != null) {
          this.zvN.f(localMediaFormat);
        }
      }
      else if (this.jtk < 0)
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(this.jtk) });
      }
      else
      {
        Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
        localMediaFormat = localObject1[this.jtk];
        if (localMediaFormat == null)
        {
          localObject1 = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
          AppMethodBeat.o(89492);
          throw ((Throwable)localObject1);
        }
        boolean bool = this.zvP;
        if (bool)
        {
          AppMethodBeat.o(89492);
          return;
        }
        this.zvQ = true;
        if ((this.zvE.flags & 0x2) != 0)
        {
          Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(this.zvE.size), Boolean.valueOf(aQF()) });
          if (aQF()) {
            this.zvE.size = 0;
          }
        }
        Object localObject2;
        if (this.zvE.size != 0)
        {
          if ((this.zvN != null) && (!this.zvN.ekj()))
          {
            localObject2 = this.ieT.getOutputFormat();
            this.zvN.f((MediaFormat)localObject2);
          }
          localMediaFormat.position(this.zvE.offset);
          localMediaFormat.limit(this.zvE.offset + this.zvE.size);
          bool = this.ijm;
          if (!bool) {
            break label706;
          }
        }
        try
        {
          localObject2 = this.zvE;
          if (this.ieT.getOutputFormat() == null) {
            break label738;
          }
          i = this.ieT.getOutputFormat().getInteger("aac-profile");
          if (this.ieT.getOutputFormat() == null) {
            break label743;
          }
          j = a.QL(this.ieT.getOutputFormat().getInteger("sample-rate"));
          if (this.ieT.getOutputFormat() == null) {
            break label748;
          }
          k = this.ieT.getOutputFormat().getInteger("channel-count");
          a(localMediaFormat, (MediaCodec.BufferInfo)localObject2, i, j, k);
          this.ieT.releaseOutputBuffer(this.jtk, false);
          this.zvQ = false;
          if ((this.zvE.flags & 0x4) != 0)
          {
            if (paramBoolean) {
              break label719;
            }
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
            AppMethodBeat.o(89492);
            return;
          }
        }
        catch (Exception localException2)
        {
          localBufferInfo = this.zvE;
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
      j = a.QL(this.mAudioFormat.getInteger("sample-rate"));
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
      h(localMediaFormat, this.zvE);
      break label577;
      Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
      aMi();
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
  
  public final void resume()
  {
    AppMethodBeat.i(89484);
    Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", new Object[] { Long.valueOf(this.zvY) });
    this.pause = false;
    if (this.zvY > 0L) {
      this.zvX += Util.ticksToNow(this.zvY);
    }
    this.zvY = 0L;
    this.zvK = true;
    AppMethodBeat.o(89484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.h
 * JD-Core Version:    0.7.0.1
 */