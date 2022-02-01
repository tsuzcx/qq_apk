package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer
  implements Runnable
{
  private static final int PLAY_ERR_AUDIO_TRACK = -3;
  private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
  private static final int PLAY_ERR_FILE_NOTFOUND = -2;
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
  private static TXCUGCBGMPlayer instance;
  private long mEndTimeMS = 0L;
  private String mFilePath = null;
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private long mSeekBytes = 0L;
  private float mSpeedRate = 1.0F;
  private long mStartTimeMS = 0L;
  private Thread mThread = null;
  private float mVolume = 1.0F;
  private WeakReference<f> mWeakListener = null;
  
  static
  {
    AppMethodBeat.i(16297);
    com.tencent.liteav.basic.util.f.f();
    AppMethodBeat.o(16297);
  }
  
  public static long getDurationMS(String paramString)
  {
    AppMethodBeat.i(16292);
    long l = nativeGetDurationMS(paramString);
    AppMethodBeat.o(16292);
    return l;
  }
  
  public static TXCUGCBGMPlayer getInstance()
  {
    AppMethodBeat.i(16281);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCUGCBGMPlayer();
      }
      TXCUGCBGMPlayer localTXCUGCBGMPlayer = instance;
      AppMethodBeat.o(16281);
      return localTXCUGCBGMPlayer;
    }
    finally
    {
      AppMethodBeat.o(16281);
    }
  }
  
  private native int nativeGetBitsPerChannel();
  
  private native int nativeGetChannels();
  
  private native long nativeGetCurDurationMS();
  
  private native long nativeGetCurPosition();
  
  private native long nativeGetCurPtsMS();
  
  private static native long nativeGetDurationMS(String paramString);
  
  private native int nativeGetSampleRate();
  
  private native void nativePause();
  
  private native void nativePlayFromTime(long paramLong1, long paramLong2);
  
  private native int nativeRead(byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeResume();
  
  private native void nativeSeekBytes(long paramLong);
  
  private native void nativeSetSpeedRate(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native boolean nativeStartPlay(String paramString);
  
  private native void nativeStopPlay();
  
  private void onPlayEnd(int paramInt)
  {
    AppMethodBeat.i(16294);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayEnd(paramInt);
      }
      AppMethodBeat.o(16294);
      return;
    }
    finally
    {
      AppMethodBeat.o(16294);
    }
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16295);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayProgress(paramLong1, paramLong2);
      }
      AppMethodBeat.o(16295);
      return;
    }
    finally
    {
      AppMethodBeat.o(16295);
    }
  }
  
  private void onPlayStart()
  {
    AppMethodBeat.i(16293);
    f localf = null;
    try
    {
      if (this.mWeakListener != null) {
        localf = (f)this.mWeakListener.get();
      }
      if (localf != null) {
        localf.onPlayStart();
      }
      AppMethodBeat.o(16293);
      return;
    }
    finally
    {
      AppMethodBeat.o(16293);
    }
  }
  
  public long getCurPosition()
  {
    AppMethodBeat.i(16291);
    long l = nativeGetCurPosition();
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "getCurPosition:".concat(String.valueOf(l)));
    AppMethodBeat.o(16291);
    return l;
  }
  
  public void pause()
  {
    AppMethodBeat.i(16285);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    this.mIsPause = true;
    nativePause();
    AppMethodBeat.o(16285);
  }
  
  public void playFromTime(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16289);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "playFromTime:" + paramLong1 + ", " + paramLong2);
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
    nativePlayFromTime(paramLong1, paramLong2);
    AppMethodBeat.o(16289);
  }
  
  public void resume()
  {
    AppMethodBeat.i(16286);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    this.mIsPause = false;
    nativeResume();
    AppMethodBeat.o(16286);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_2
    //   2: sipush 16296
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   11: lstore 6
    //   13: aload_0
    //   14: invokespecial 191	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayStart	()V
    //   17: aload_0
    //   18: getfield 62	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   21: ifnull +13 -> 34
    //   24: aload_0
    //   25: getfield 62	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   28: invokevirtual 194	java/lang/String:isEmpty	()Z
    //   31: ifeq +103 -> 134
    //   34: ldc 21
    //   36: new 156	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 196
    //   42: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 62	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   49: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 199	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: bipush 254
    //   60: istore_1
    //   61: aconst_null
    //   62: astore 8
    //   64: aload 8
    //   66: ifnull +23 -> 89
    //   69: aload 8
    //   71: invokevirtual 203	android/media/AudioTrack:pause	()V
    //   74: aload 8
    //   76: invokevirtual 206	android/media/AudioTrack:flush	()V
    //   79: aload 8
    //   81: invokevirtual 209	android/media/AudioTrack:stop	()V
    //   84: aload 8
    //   86: invokevirtual 212	android/media/AudioTrack:release	()V
    //   89: ldc 21
    //   91: new 156	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 214
    //   97: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   103: lload 6
    //   105: lsub
    //   106: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 64	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsRunning	Z
    //   119: ifeq +8 -> 127
    //   122: aload_0
    //   123: iload_1
    //   124: invokespecial 215	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayEnd	(I)V
    //   127: sipush 16296
    //   130: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 72	com/tencent/liteav/audio/TXCUGCBGMPlayer:mVolume	F
    //   139: invokespecial 217	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSetVolume	(F)V
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 74	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSpeedRate	F
    //   147: invokespecial 219	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSetSpeedRate	(F)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 76	com/tencent/liteav/audio/TXCUGCBGMPlayer:mStartTimeMS	J
    //   155: aload_0
    //   156: getfield 78	com/tencent/liteav/audio/TXCUGCBGMPlayer:mEndTimeMS	J
    //   159: invokespecial 176	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativePlayFromTime	(JJ)V
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 80	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSeekBytes	J
    //   167: invokespecial 221	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSeekBytes	(J)V
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 62	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   175: invokespecial 223	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeStartPlay	(Ljava/lang/String;)Z
    //   178: ifne +11 -> 189
    //   181: iconst_m1
    //   182: istore_1
    //   183: aconst_null
    //   184: astore 8
    //   186: goto -122 -> 64
    //   189: aload_0
    //   190: getfield 68	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   193: ifeq +224 -> 417
    //   196: aload_0
    //   197: invokespecial 153	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativePause	()V
    //   200: ldc 21
    //   202: new 156	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 225
    //   208: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: getfield 62	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   215: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 227
    //   220: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 72	com/tencent/liteav/audio/TXCUGCBGMPlayer:mVolume	F
    //   227: invokevirtual 230	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   230: ldc 232
    //   232: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 74	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSpeedRate	F
    //   239: invokevirtual 230	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   242: ldc 234
    //   244: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: getfield 76	com/tencent/liteav/audio/TXCUGCBGMPlayer:mStartTimeMS	J
    //   251: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc 236
    //   256: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 78	com/tencent/liteav/audio/TXCUGCBGMPlayer:mEndTimeMS	J
    //   263: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: ldc 238
    //   268: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: getfield 80	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSeekBytes	J
    //   275: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: ldc 240
    //   280: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: getfield 68	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   287: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: invokespecial 245	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetSampleRate	()I
    //   300: istore_3
    //   301: aload_0
    //   302: invokespecial 247	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetChannels	()I
    //   305: istore 4
    //   307: aload_0
    //   308: invokespecial 249	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetBitsPerChannel	()I
    //   311: istore 5
    //   313: iload 4
    //   315: iconst_1
    //   316: if_icmpne +244 -> 560
    //   319: iconst_2
    //   320: istore_1
    //   321: iload 5
    //   323: bipush 8
    //   325: if_icmpne +230 -> 555
    //   328: new 201	android/media/AudioTrack
    //   331: dup
    //   332: iconst_3
    //   333: iload_3
    //   334: iload_1
    //   335: iload_2
    //   336: iload_3
    //   337: iload_1
    //   338: iload_2
    //   339: invokestatic 253	android/media/AudioTrack:getMinBufferSize	(III)I
    //   342: iconst_1
    //   343: invokespecial 256	android/media/AudioTrack:<init>	(IIIIII)V
    //   346: astore 8
    //   348: aload 8
    //   350: invokevirtual 259	android/media/AudioTrack:play	()V
    //   353: iload 4
    //   355: sipush 2048
    //   358: imul
    //   359: iconst_2
    //   360: imul
    //   361: istore_1
    //   362: iload_1
    //   363: newarray byte
    //   365: astore 9
    //   367: aload_0
    //   368: getfield 64	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsRunning	Z
    //   371: ifeq +179 -> 550
    //   374: invokestatic 264	java/lang/Thread:interrupted	()Z
    //   377: ifne +173 -> 550
    //   380: aload_0
    //   381: aload 9
    //   383: iload_1
    //   384: invokespecial 266	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeRead	([BI)I
    //   387: istore_2
    //   388: iload_2
    //   389: ifge +106 -> 495
    //   392: ldc 21
    //   394: ldc_w 268
    //   397: invokestatic 149	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: aload_0
    //   402: invokespecial 270	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   405: aload_0
    //   406: invokespecial 270	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   409: invokespecial 271	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayProgress	(JJ)V
    //   412: iconst_0
    //   413: istore_1
    //   414: goto -350 -> 64
    //   417: aload_0
    //   418: invokespecial 180	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeResume	()V
    //   421: goto -221 -> 200
    //   424: astore 8
    //   426: ldc 21
    //   428: new 156	java/lang/StringBuilder
    //   431: dup
    //   432: ldc_w 273
    //   435: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: aload 8
    //   440: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 199	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: bipush 253
    //   454: istore_1
    //   455: aconst_null
    //   456: astore 8
    //   458: goto -394 -> 64
    //   461: astore 9
    //   463: ldc 21
    //   465: new 156	java/lang/StringBuilder
    //   468: dup
    //   469: ldc_w 278
    //   472: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   475: aload 9
    //   477: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 199	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: bipush 252
    //   491: istore_1
    //   492: goto -428 -> 64
    //   495: iload_2
    //   496: ifne +24 -> 520
    //   499: aload_0
    //   500: getfield 68	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   503: ifeq -136 -> 367
    //   506: ldc2_w 279
    //   509: invokestatic 283	java/lang/Thread:sleep	(J)V
    //   512: goto -145 -> 367
    //   515: astore 10
    //   517: goto -150 -> 367
    //   520: aload 8
    //   522: aload 9
    //   524: iconst_0
    //   525: iload_2
    //   526: invokevirtual 287	android/media/AudioTrack:write	([BII)I
    //   529: pop
    //   530: aload_0
    //   531: aload_0
    //   532: invokespecial 289	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurPtsMS	()J
    //   535: aload_0
    //   536: invokespecial 270	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   539: invokespecial 271	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayProgress	(JJ)V
    //   542: goto -175 -> 367
    //   545: astore 8
    //   547: goto -458 -> 89
    //   550: iconst_0
    //   551: istore_1
    //   552: goto -488 -> 64
    //   555: iconst_2
    //   556: istore_2
    //   557: goto -229 -> 328
    //   560: iconst_3
    //   561: istore_1
    //   562: goto -241 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	TXCUGCBGMPlayer
    //   60	502	1	i	int
    //   1	556	2	j	int
    //   300	37	3	k	int
    //   305	54	4	m	int
    //   311	15	5	n	int
    //   11	93	6	l	long
    //   62	287	8	localAudioTrack	android.media.AudioTrack
    //   424	15	8	localException1	java.lang.Exception
    //   456	65	8	localObject	Object
    //   545	1	8	localException2	java.lang.Exception
    //   365	17	9	arrayOfByte	byte[]
    //   461	62	9	localException3	java.lang.Exception
    //   515	1	10	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   328	348	424	java/lang/Exception
    //   348	353	461	java/lang/Exception
    //   506	512	515	java/lang/InterruptedException
    //   69	89	545	java/lang/Exception
  }
  
  public void seekBytes(long paramLong)
  {
    AppMethodBeat.i(16290);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "seekBytes:".concat(String.valueOf(paramLong)));
    long l = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l = 0L;
    }
    this.mSeekBytes = l;
    nativeSeekBytes(l);
    AppMethodBeat.o(16290);
  }
  
  public void setOnPlayListener(f paramf)
  {
    try
    {
      AppMethodBeat.i(16282);
      if (paramf == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(paramf);
      AppMethodBeat.o(16282);
      return;
    }
    finally {}
  }
  
  public void setSpeedRate(float paramFloat)
  {
    AppMethodBeat.i(16288);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "setSpeedRate:".concat(String.valueOf(paramFloat)));
    this.mSpeedRate = paramFloat;
    nativeSetSpeedRate(paramFloat);
    AppMethodBeat.o(16288);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(16287);
    this.mVolume = paramFloat;
    nativeSetVolume(paramFloat);
    AppMethodBeat.o(16287);
  }
  
  public void startPlay(String paramString)
  {
    AppMethodBeat.i(16283);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlay:".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(16283);
      return;
    }
    if (this.mIsRunning)
    {
      TXCLog.w("AudioCenter:TXCUGCBGMPlayer", "BGM正在播放中，将重新启动");
      stopPlay();
    }
    this.mIsPause = false;
    this.mSeekBytes = 0L;
    this.mFilePath = paramString;
    this.mIsRunning = true;
    this.mThread = new Thread(this, "UGCBGMPlayer");
    this.mThread.start();
    AppMethodBeat.o(16283);
  }
  
  public void stopPlay()
  {
    AppMethodBeat.i(16284);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopPlay");
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    if ((this.mThread != null) && (this.mThread.isAlive()) && (Thread.currentThread().getId() != this.mThread.getId())) {}
    try
    {
      this.mThread.join();
      label64:
      this.mThread = null;
      try
      {
        nativeStopPlay();
        TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - l));
        AppMethodBeat.o(16284);
        return;
      }
      finally
      {
        AppMethodBeat.o(16284);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */