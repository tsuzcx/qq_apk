package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
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
  private WeakReference<e> mWeakListener = null;
  
  static
  {
    AppMethodBeat.i(66725);
    b.f();
    AppMethodBeat.o(66725);
  }
  
  public static long getDurationMS(String paramString)
  {
    AppMethodBeat.i(66720);
    long l = nativeGetDurationMS(paramString);
    AppMethodBeat.o(66720);
    return l;
  }
  
  public static TXCUGCBGMPlayer getInstance()
  {
    AppMethodBeat.i(66709);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TXCUGCBGMPlayer();
      }
      TXCUGCBGMPlayer localTXCUGCBGMPlayer = instance;
      AppMethodBeat.o(66709);
      return localTXCUGCBGMPlayer;
    }
    finally
    {
      AppMethodBeat.o(66709);
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
    AppMethodBeat.i(66722);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      if (locale != null) {
        locale.onPlayEnd(paramInt);
      }
      AppMethodBeat.o(66722);
      return;
    }
    finally
    {
      AppMethodBeat.o(66722);
    }
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(66723);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      if (locale != null) {
        locale.onPlayProgress(paramLong1, paramLong2);
      }
      AppMethodBeat.o(66723);
      return;
    }
    finally
    {
      AppMethodBeat.o(66723);
    }
  }
  
  private void onPlayStart()
  {
    AppMethodBeat.i(66721);
    e locale = null;
    try
    {
      if (this.mWeakListener != null) {
        locale = (e)this.mWeakListener.get();
      }
      if (locale != null) {
        locale.onPlayStart();
      }
      AppMethodBeat.o(66721);
      return;
    }
    finally
    {
      AppMethodBeat.o(66721);
    }
  }
  
  public long getCurPosition()
  {
    AppMethodBeat.i(66719);
    long l = nativeGetCurPosition();
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "getCurPosition:".concat(String.valueOf(l)));
    AppMethodBeat.o(66719);
    return l;
  }
  
  public void pause()
  {
    AppMethodBeat.i(66713);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    this.mIsPause = true;
    nativePause();
    AppMethodBeat.o(66713);
  }
  
  public void playFromTime(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(66717);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "playFromTime:" + paramLong1 + ", " + paramLong2);
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
    nativePlayFromTime(paramLong1, paramLong2);
    AppMethodBeat.o(66717);
  }
  
  public void resume()
  {
    AppMethodBeat.i(66714);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    this.mIsPause = false;
    nativeResume();
    AppMethodBeat.o(66714);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_2
    //   2: ldc 196
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   10: lstore 6
    //   12: aload_0
    //   13: invokespecial 202	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayStart	()V
    //   16: aload_0
    //   17: getfield 63	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 63	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   27: invokevirtual 205	java/lang/String:isEmpty	()Z
    //   30: ifeq +102 -> 132
    //   33: ldc 21
    //   35: new 165	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 207
    //   41: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: getfield 63	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   48: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 210	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: bipush 254
    //   59: istore_1
    //   60: aconst_null
    //   61: astore 8
    //   63: aload 8
    //   65: ifnull +23 -> 88
    //   68: aload 8
    //   70: invokevirtual 214	android/media/AudioTrack:pause	()V
    //   73: aload 8
    //   75: invokevirtual 217	android/media/AudioTrack:flush	()V
    //   78: aload 8
    //   80: invokevirtual 220	android/media/AudioTrack:stop	()V
    //   83: aload 8
    //   85: invokevirtual 223	android/media/AudioTrack:release	()V
    //   88: ldc 21
    //   90: new 165	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 225
    //   96: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   102: lload 6
    //   104: lsub
    //   105: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 65	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsRunning	Z
    //   118: ifeq +8 -> 126
    //   121: aload_0
    //   122: iload_1
    //   123: invokespecial 226	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayEnd	(I)V
    //   126: ldc 196
    //   128: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 73	com/tencent/liteav/audio/TXCUGCBGMPlayer:mVolume	F
    //   137: invokespecial 228	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSetVolume	(F)V
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 75	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSpeedRate	F
    //   145: invokespecial 230	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSetSpeedRate	(F)V
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 77	com/tencent/liteav/audio/TXCUGCBGMPlayer:mStartTimeMS	J
    //   153: aload_0
    //   154: getfield 79	com/tencent/liteav/audio/TXCUGCBGMPlayer:mEndTimeMS	J
    //   157: invokespecial 185	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativePlayFromTime	(JJ)V
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 81	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSeekBytes	J
    //   165: invokespecial 232	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeSeekBytes	(J)V
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 63	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   173: invokespecial 234	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeStartPlay	(Ljava/lang/String;)Z
    //   176: ifne +11 -> 187
    //   179: iconst_m1
    //   180: istore_1
    //   181: aconst_null
    //   182: astore 8
    //   184: goto -121 -> 63
    //   187: aload_0
    //   188: getfield 69	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   191: ifeq +224 -> 415
    //   194: aload_0
    //   195: invokespecial 161	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativePause	()V
    //   198: ldc 21
    //   200: new 165	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 236
    //   206: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: getfield 63	com/tencent/liteav/audio/TXCUGCBGMPlayer:mFilePath	Ljava/lang/String;
    //   213: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 238
    //   218: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: getfield 73	com/tencent/liteav/audio/TXCUGCBGMPlayer:mVolume	F
    //   225: invokevirtual 241	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   228: ldc 243
    //   230: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 75	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSpeedRate	F
    //   237: invokevirtual 241	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   240: ldc 245
    //   242: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: getfield 77	com/tencent/liteav/audio/TXCUGCBGMPlayer:mStartTimeMS	J
    //   249: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: ldc 247
    //   254: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 79	com/tencent/liteav/audio/TXCUGCBGMPlayer:mEndTimeMS	J
    //   261: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: ldc 249
    //   266: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_0
    //   270: getfield 81	com/tencent/liteav/audio/TXCUGCBGMPlayer:mSeekBytes	J
    //   273: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: ldc 251
    //   278: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: getfield 69	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   285: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   288: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_0
    //   295: invokespecial 256	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetSampleRate	()I
    //   298: istore_3
    //   299: aload_0
    //   300: invokespecial 258	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetChannels	()I
    //   303: istore 4
    //   305: aload_0
    //   306: invokespecial 260	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetBitsPerChannel	()I
    //   309: istore 5
    //   311: iload 4
    //   313: iconst_1
    //   314: if_icmpne +244 -> 558
    //   317: iconst_2
    //   318: istore_1
    //   319: iload 5
    //   321: bipush 8
    //   323: if_icmpne +230 -> 553
    //   326: new 212	android/media/AudioTrack
    //   329: dup
    //   330: iconst_3
    //   331: iload_3
    //   332: iload_1
    //   333: iload_2
    //   334: iload_3
    //   335: iload_1
    //   336: iload_2
    //   337: invokestatic 264	android/media/AudioTrack:getMinBufferSize	(III)I
    //   340: iconst_1
    //   341: invokespecial 267	android/media/AudioTrack:<init>	(IIIIII)V
    //   344: astore 8
    //   346: aload 8
    //   348: invokevirtual 270	android/media/AudioTrack:play	()V
    //   351: iload 4
    //   353: sipush 2048
    //   356: imul
    //   357: iconst_2
    //   358: imul
    //   359: istore_1
    //   360: iload_1
    //   361: newarray byte
    //   363: astore 9
    //   365: aload_0
    //   366: getfield 65	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsRunning	Z
    //   369: ifeq +179 -> 548
    //   372: invokestatic 275	java/lang/Thread:interrupted	()Z
    //   375: ifne +173 -> 548
    //   378: aload_0
    //   379: aload 9
    //   381: iload_1
    //   382: invokespecial 277	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeRead	([BI)I
    //   385: istore_2
    //   386: iload_2
    //   387: ifge +106 -> 493
    //   390: ldc 21
    //   392: ldc_w 279
    //   395: invokestatic 156	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: aload_0
    //   400: invokespecial 281	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   403: aload_0
    //   404: invokespecial 281	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   407: invokespecial 282	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayProgress	(JJ)V
    //   410: iconst_0
    //   411: istore_1
    //   412: goto -349 -> 63
    //   415: aload_0
    //   416: invokespecial 190	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeResume	()V
    //   419: goto -221 -> 198
    //   422: astore 8
    //   424: ldc 21
    //   426: new 165	java/lang/StringBuilder
    //   429: dup
    //   430: ldc_w 284
    //   433: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   436: aload 8
    //   438: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   441: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 210	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: bipush 253
    //   452: istore_1
    //   453: aconst_null
    //   454: astore 8
    //   456: goto -393 -> 63
    //   459: astore 9
    //   461: ldc 21
    //   463: new 165	java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w 289
    //   470: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload 9
    //   475: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   478: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 210	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: bipush 252
    //   489: istore_1
    //   490: goto -427 -> 63
    //   493: iload_2
    //   494: ifne +24 -> 518
    //   497: aload_0
    //   498: getfield 69	com/tencent/liteav/audio/TXCUGCBGMPlayer:mIsPause	Z
    //   501: ifeq -136 -> 365
    //   504: ldc2_w 290
    //   507: invokestatic 294	java/lang/Thread:sleep	(J)V
    //   510: goto -145 -> 365
    //   513: astore 10
    //   515: goto -150 -> 365
    //   518: aload 8
    //   520: aload 9
    //   522: iconst_0
    //   523: iload_2
    //   524: invokevirtual 298	android/media/AudioTrack:write	([BII)I
    //   527: pop
    //   528: aload_0
    //   529: aload_0
    //   530: invokespecial 300	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurPtsMS	()J
    //   533: aload_0
    //   534: invokespecial 281	com/tencent/liteav/audio/TXCUGCBGMPlayer:nativeGetCurDurationMS	()J
    //   537: invokespecial 282	com/tencent/liteav/audio/TXCUGCBGMPlayer:onPlayProgress	(JJ)V
    //   540: goto -175 -> 365
    //   543: astore 8
    //   545: goto -457 -> 88
    //   548: iconst_0
    //   549: istore_1
    //   550: goto -487 -> 63
    //   553: iconst_2
    //   554: istore_2
    //   555: goto -229 -> 326
    //   558: iconst_3
    //   559: istore_1
    //   560: goto -241 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	TXCUGCBGMPlayer
    //   59	501	1	i	int
    //   1	554	2	j	int
    //   298	37	3	k	int
    //   303	54	4	m	int
    //   309	15	5	n	int
    //   10	93	6	l	long
    //   61	286	8	localAudioTrack	android.media.AudioTrack
    //   422	15	8	localException1	java.lang.Exception
    //   454	65	8	localObject	Object
    //   543	1	8	localException2	java.lang.Exception
    //   363	17	9	arrayOfByte	byte[]
    //   459	62	9	localException3	java.lang.Exception
    //   513	1	10	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   326	346	422	java/lang/Exception
    //   346	351	459	java/lang/Exception
    //   504	510	513	java/lang/InterruptedException
    //   68	88	543	java/lang/Exception
  }
  
  public void seekBytes(long paramLong)
  {
    AppMethodBeat.i(66718);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "seekBytes:".concat(String.valueOf(paramLong)));
    long l = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l = 0L;
    }
    this.mSeekBytes = l;
    nativeSeekBytes(l);
    AppMethodBeat.o(66718);
  }
  
  public void setOnPlayListener(e parame)
  {
    try
    {
      AppMethodBeat.i(66710);
      if (parame == null) {
        this.mWeakListener = null;
      }
      this.mWeakListener = new WeakReference(parame);
      AppMethodBeat.o(66710);
      return;
    }
    finally {}
  }
  
  public void setSpeedRate(float paramFloat)
  {
    AppMethodBeat.i(66716);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "setSpeedRate:".concat(String.valueOf(paramFloat)));
    this.mSpeedRate = paramFloat;
    nativeSetSpeedRate(paramFloat);
    AppMethodBeat.o(66716);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(66715);
    this.mVolume = paramFloat;
    nativeSetVolume(paramFloat);
    AppMethodBeat.o(66715);
  }
  
  public void startPlay(String paramString)
  {
    AppMethodBeat.i(66711);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "startPlay:".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(66711);
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
    AppMethodBeat.o(66711);
  }
  
  public void stopPlay()
  {
    AppMethodBeat.i(66712);
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
        AppMethodBeat.o(66712);
        return;
      }
      finally
      {
        AppMethodBeat.o(66712);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */