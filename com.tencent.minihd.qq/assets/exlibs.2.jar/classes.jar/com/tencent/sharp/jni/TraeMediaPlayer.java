package com.tencent.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  static final String TAG = "TraeMediaPlay";
  public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
  public static final int TRAE_MEDIAPLAER_STOP = 100;
  private Context _context;
  private int _durationMS = -1;
  private boolean _hasCall = false;
  private boolean _loop = false;
  int _loopCount = 0;
  private int _prevVolume = -1;
  boolean _ringMode = false;
  private int _streamType = 0;
  private Timer _watchTimer = null;
  private TimerTask _watchTimertask = null;
  private OnCompletionListener mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, OnCompletionListener paramOnCompletionListener)
  {
    this._context = paramContext;
    this.mCallback = paramOnCompletionListener;
  }
  
  private void volumeDo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2)) {
      return;
    }
    for (;;)
    {
      int k;
      try
      {
        AudioManager localAudioManager = (AudioManager)this._context.getSystemService("audio");
        int j = localAudioManager.getStreamVolume(this._streamType);
        i = localAudioManager.getStreamMaxVolume(this._streamType);
        k = localAudioManager.getStreamVolume(2);
        int m = localAudioManager.getStreamMaxVolume(2);
        k = (int)(k * 1.0D / m * i);
        if (k + 1 >= i)
        {
          localAudioManager.setStreamVolume(this._streamType, i, 0);
          this._prevVolume = j;
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i = k + 1;
    }
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2) || (this._prevVolume == -1)) {
      return;
    }
    try
    {
      ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int getDuration()
  {
    return this._durationMS;
  }
  
  public int getStreamType()
  {
    return this._streamType;
  }
  
  public boolean hasCall()
  {
    return this._hasCall;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
    if (this._loop) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this._loopCount > 0) {
          continue;
        }
        volumeUndo();
        if (this.mMediaPlay.isPlaying()) {
          this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        this.mMediaPlay.release();
        this.mMediaPlay = null;
        if (this.mCallback != null) {
          this.mCallback.onCompletion();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.mMediaPlay.start();
      this._loopCount -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.mMediaPlay.release();
      label50:
      this.mMediaPlay = null;
      if (this.mCallback != null) {
        this.mCallback.onCompletion();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label50;
    }
  }
  
  @Deprecated
  public boolean playRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    return playRing(0L, paramInt1, paramInt2, paramUri, paramString, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, paramInt4);
  }
  
  /* Error */
  public boolean playRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: iload 7
    //   2: ifne +10 -> 12
    //   5: iload 8
    //   7: ifgt +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   16: ifnull +31 -> 47
    //   19: aload_0
    //   20: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   23: invokevirtual 149	android/media/MediaPlayer:isPlaying	()Z
    //   26: istore 12
    //   28: iload 12
    //   30: ifeq +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   39: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   47: aload_0
    //   48: getfield 65	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   51: ifnull +20 -> 71
    //   54: aload_0
    //   55: getfield 65	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   58: invokevirtual 184	java/util/Timer:cancel	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 65	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 67	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   71: aload_0
    //   72: getfield 71	com/tencent/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   75: ldc 83
    //   77: invokevirtual 89	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   80: checkcast 91	android/media/AudioManager
    //   83: astore 13
    //   85: aload_0
    //   86: new 146	android/media/MediaPlayer
    //   89: dup
    //   90: invokespecial 185	android/media/MediaPlayer:<init>	()V
    //   93: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   96: aload_0
    //   97: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   100: ifnonnull +53 -> 153
    //   103: aload_0
    //   104: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   107: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   115: iconst_0
    //   116: ireturn
    //   117: astore 13
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   124: goto -77 -> 47
    //   127: astore 5
    //   129: aload_0
    //   130: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   133: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   141: iconst_0
    //   142: ireturn
    //   143: astore 5
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   150: aload 5
    //   152: athrow
    //   153: aload_0
    //   154: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   157: aload_0
    //   158: invokevirtual 189	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   161: aload_0
    //   162: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   165: aload_0
    //   166: invokevirtual 193	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   169: iload_3
    //   170: tableswitch	default:+474 -> 644, 0:+51->221, 1:+184->354, 2:+200->370
    //   197: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   200: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   208: aload_0
    //   209: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   212: astore 5
    //   214: aload 5
    //   216: ifnonnull +166 -> 382
    //   219: iconst_0
    //   220: ireturn
    //   221: aconst_null
    //   222: astore 5
    //   224: aload_0
    //   225: getfield 71	com/tencent/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   228: invokevirtual 197	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: iload 4
    //   233: invokevirtual 203	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   236: astore 6
    //   238: aload 6
    //   240: astore 5
    //   242: aload_0
    //   243: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   246: aload 6
    //   248: invokevirtual 209	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   251: aload 6
    //   253: invokevirtual 213	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   256: aload 6
    //   258: invokevirtual 216	android/content/res/AssetFileDescriptor:getLength	()J
    //   261: invokevirtual 220	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   264: aload 6
    //   266: ifnull +11 -> 277
    //   269: aload 6
    //   271: invokevirtual 223	android/content/res/AssetFileDescriptor:close	()V
    //   274: goto -66 -> 208
    //   277: aload_0
    //   278: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   281: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   284: aload_0
    //   285: aconst_null
    //   286: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   289: aload_0
    //   290: getfield 73	com/tencent/sharp/jni/TraeMediaPlayer:mCallback	Lcom/tencent/sharp/jni/TraeMediaPlayer$OnCompletionListener;
    //   293: ifnull +354 -> 647
    //   296: aload_0
    //   297: getfield 73	com/tencent/sharp/jni/TraeMediaPlayer:mCallback	Lcom/tencent/sharp/jni/TraeMediaPlayer$OnCompletionListener;
    //   300: invokeinterface 160 1 0
    //   305: goto +342 -> 647
    //   308: astore 6
    //   310: aload 5
    //   312: ifnull +11 -> 323
    //   315: aload 5
    //   317: invokevirtual 223	android/content/res/AssetFileDescriptor:close	()V
    //   320: aload 6
    //   322: athrow
    //   323: aload_0
    //   324: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   327: invokevirtual 158	android/media/MediaPlayer:release	()V
    //   330: aload_0
    //   331: aconst_null
    //   332: putfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   335: aload_0
    //   336: getfield 73	com/tencent/sharp/jni/TraeMediaPlayer:mCallback	Lcom/tencent/sharp/jni/TraeMediaPlayer$OnCompletionListener;
    //   339: ifnull +310 -> 649
    //   342: aload_0
    //   343: getfield 73	com/tencent/sharp/jni/TraeMediaPlayer:mCallback	Lcom/tencent/sharp/jni/TraeMediaPlayer$OnCompletionListener;
    //   346: invokeinterface 160 1 0
    //   351: goto +298 -> 649
    //   354: aload_0
    //   355: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   358: aload_0
    //   359: getfield 71	com/tencent/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   362: aload 5
    //   364: invokevirtual 226	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   367: goto -159 -> 208
    //   370: aload_0
    //   371: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   374: aload 6
    //   376: invokevirtual 228	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   379: goto -171 -> 208
    //   382: aload_0
    //   383: iload 9
    //   385: putfield 63	com/tencent/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   388: iconst_0
    //   389: istore_3
    //   390: aload_0
    //   391: getfield 63	com/tencent/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   394: ifeq +163 -> 557
    //   397: aload_0
    //   398: iconst_2
    //   399: putfield 53	com/tencent/sharp/jni/TraeMediaPlayer:_streamType	I
    //   402: iconst_1
    //   403: istore_3
    //   404: aload_0
    //   405: iload 10
    //   407: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   410: aload_0
    //   411: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   414: ifeq +9 -> 423
    //   417: aload_0
    //   418: iload 11
    //   420: putfield 53	com/tencent/sharp/jni/TraeMediaPlayer:_streamType	I
    //   423: aload_0
    //   424: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   427: aload_0
    //   428: getfield 53	com/tencent/sharp/jni/TraeMediaPlayer:_streamType	I
    //   431: invokevirtual 232	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   434: aload_0
    //   435: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   438: invokevirtual 235	android/media/MediaPlayer:prepare	()V
    //   441: aload_0
    //   442: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   445: iload 7
    //   447: invokevirtual 239	android/media/MediaPlayer:setLooping	(Z)V
    //   450: aload_0
    //   451: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   454: invokevirtual 166	android/media/MediaPlayer:start	()V
    //   457: aload_0
    //   458: iload 7
    //   460: putfield 57	com/tencent/sharp/jni/TraeMediaPlayer:_loop	Z
    //   463: aload_0
    //   464: getfield 57	com/tencent/sharp/jni/TraeMediaPlayer:_loop	Z
    //   467: iconst_1
    //   468: if_icmpne +146 -> 614
    //   471: aload_0
    //   472: iconst_1
    //   473: putfield 61	com/tencent/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   476: aload_0
    //   477: iconst_m1
    //   478: putfield 59	com/tencent/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   481: aload_0
    //   482: aload_0
    //   483: getfield 61	com/tencent/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   486: iconst_1
    //   487: isub
    //   488: putfield 61	com/tencent/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   491: aload_0
    //   492: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   495: ifne +9 -> 504
    //   498: aload 13
    //   500: iload_3
    //   501: invokevirtual 242	android/media/AudioManager:setMode	(I)V
    //   504: aload_0
    //   505: getfield 59	com/tencent/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   508: ifle +143 -> 651
    //   511: aload_0
    //   512: new 181	java/util/Timer
    //   515: dup
    //   516: invokespecial 243	java/util/Timer:<init>	()V
    //   519: putfield 65	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   522: aload_0
    //   523: new 10	com/tencent/sharp/jni/TraeMediaPlayer$1
    //   526: dup
    //   527: aload_0
    //   528: invokespecial 246	com/tencent/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/sharp/jni/TraeMediaPlayer;)V
    //   531: putfield 67	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   534: aload_0
    //   535: getfield 65	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   538: aload_0
    //   539: getfield 67	com/tencent/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   542: aload_0
    //   543: getfield 59	com/tencent/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   546: sipush 1000
    //   549: iadd
    //   550: i2l
    //   551: invokevirtual 250	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   554: goto +97 -> 651
    //   557: getstatic 255	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   560: ldc_w 257
    //   563: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   566: ifeq +30 -> 596
    //   569: getstatic 266	android/os/Build:MODEL	Ljava/lang/String;
    //   572: ldc_w 268
    //   575: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +18 -> 596
    //   581: iload 10
    //   583: ifne +13 -> 596
    //   586: aload_0
    //   587: iconst_2
    //   588: putfield 53	com/tencent/sharp/jni/TraeMediaPlayer:_streamType	I
    //   591: iconst_2
    //   592: istore_3
    //   593: goto -189 -> 404
    //   596: aload_0
    //   597: iconst_0
    //   598: putfield 53	com/tencent/sharp/jni/TraeMediaPlayer:_streamType	I
    //   601: getstatic 273	android/os/Build$VERSION:SDK_INT	I
    //   604: bipush 11
    //   606: if_icmplt -202 -> 404
    //   609: iconst_3
    //   610: istore_3
    //   611: goto -207 -> 404
    //   614: aload_0
    //   615: iload 8
    //   617: putfield 61	com/tencent/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   620: aload_0
    //   621: aload_0
    //   622: getfield 61	com/tencent/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   625: aload_0
    //   626: getfield 51	com/tencent/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   629: invokevirtual 275	android/media/MediaPlayer:getDuration	()I
    //   632: imul
    //   633: putfield 59	com/tencent/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   636: goto -155 -> 481
    //   639: astore 5
    //   641: goto -505 -> 136
    //   644: goto -448 -> 196
    //   647: iconst_0
    //   648: ireturn
    //   649: iconst_0
    //   650: ireturn
    //   651: iconst_1
    //   652: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	TraeMediaPlayer
    //   0	653	1	paramLong	long
    //   0	653	3	paramInt1	int
    //   0	653	4	paramInt2	int
    //   0	653	5	paramUri	Uri
    //   0	653	6	paramString	String
    //   0	653	7	paramBoolean1	boolean
    //   0	653	8	paramInt3	int
    //   0	653	9	paramBoolean2	boolean
    //   0	653	10	paramBoolean3	boolean
    //   0	653	11	paramInt4	int
    //   26	3	12	bool	boolean
    //   83	1	13	localAudioManager	AudioManager
    //   117	382	13	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   35	42	117	java/lang/Exception
    //   12	28	127	java/lang/Exception
    //   42	47	127	java/lang/Exception
    //   47	71	127	java/lang/Exception
    //   71	115	127	java/lang/Exception
    //   119	124	127	java/lang/Exception
    //   145	153	127	java/lang/Exception
    //   153	169	127	java/lang/Exception
    //   196	208	127	java/lang/Exception
    //   208	214	127	java/lang/Exception
    //   269	274	127	java/lang/Exception
    //   277	305	127	java/lang/Exception
    //   315	323	127	java/lang/Exception
    //   323	351	127	java/lang/Exception
    //   354	367	127	java/lang/Exception
    //   370	379	127	java/lang/Exception
    //   382	388	127	java/lang/Exception
    //   390	402	127	java/lang/Exception
    //   404	423	127	java/lang/Exception
    //   423	481	127	java/lang/Exception
    //   481	504	127	java/lang/Exception
    //   504	554	127	java/lang/Exception
    //   557	581	127	java/lang/Exception
    //   586	591	127	java/lang/Exception
    //   596	601	127	java/lang/Exception
    //   601	609	127	java/lang/Exception
    //   614	636	127	java/lang/Exception
    //   35	42	143	finally
    //   224	238	308	finally
    //   242	264	308	finally
    //   129	136	639	java/lang/Exception
  }
  
  @Deprecated
  public boolean playRing(String paramString1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    return playRing(0L, paramInt1, paramInt2, paramUri, paramString2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, paramInt4);
  }
  
  @Deprecated
  public void stopRing()
  {
    stopRing(0L);
  }
  
  public void stopRing(long paramLong)
  {
    if (this.mMediaPlay == null) {
      return;
    }
    if (this.mMediaPlay.isPlaying()) {
      this.mMediaPlay.stop();
    }
    this.mMediaPlay.reset();
    try
    {
      if (this._watchTimer != null)
      {
        this._watchTimer.cancel();
        this._watchTimer = null;
        this._watchTimertask = null;
      }
      this.mMediaPlay.release();
    }
    catch (Exception localException)
    {
      label63:
      break label63;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */