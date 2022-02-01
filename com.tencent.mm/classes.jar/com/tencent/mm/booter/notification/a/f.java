package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.cl;

public final class f
{
  Context context;
  boolean iSI;
  MediaPlayer iSJ;
  @SuppressLint({"HandlerLeak"})
  MMHandler iSK;
  private MMHandler iSL;
  
  private f()
  {
    AppMethodBeat.i(20065);
    this.iSI = false;
    this.iSJ = null;
    this.iSK = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20056);
        Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.iSI) });
        try
        {
          if (f.this.iSJ != null)
          {
            if (f.this.iSJ.isPlaying()) {
              f.this.iSJ.stop();
            }
            f.this.iSJ.release();
            f.this.iSI = false;
            Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.iSI) });
          }
          AppMethodBeat.o(20056);
          return;
        }
        catch (IllegalStateException paramAnonymousMessage)
        {
          Log.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.iSI) });
          if (f.this.iSJ != null) {
            f.this.iSJ.release();
          }
          AppMethodBeat.o(20056);
        }
      }
    };
    this.context = MMApplicationContext.getContext();
    af.KN(cl.hAN());
    AppMethodBeat.o(20065);
  }
  
  public final void JV(final String paramString)
  {
    try
    {
      AppMethodBeat.i(20066);
      if (this.iSL == null)
      {
        Log.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
        HandlerThread localHandlerThread = d.ik("playSoundThread", 0);
        localHandlerThread.start();
        this.iSL = new MMHandler(localHandlerThread.getLooper());
      }
      this.iSL.post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: sipush 20057
          //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: aload_0
          //   7: getfield 21	com/tencent/mm/booter/notification/a/f$2:iSM	Lcom/tencent/mm/booter/notification/a/f;
          //   10: astore 14
          //   12: aload_0
          //   13: getfield 23	com/tencent/mm/booter/notification/a/f$2:iSN	Ljava/lang/String;
          //   16: astore 15
          //   18: aload_0
          //   19: getfield 25	com/tencent/mm/booter/notification/a/f$2:iSO	Z
          //   22: istore 8
          //   24: aload 14
          //   26: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   29: ifnonnull +11 -> 40
          //   32: aload 14
          //   34: invokestatic 52	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   37: putfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   40: aload 14
          //   42: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   45: ifnonnull +17 -> 62
          //   48: ldc 54
          //   50: ldc 56
          //   52: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   55: sipush 20057
          //   58: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   61: return
          //   62: aload 14
          //   64: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   67: ldc 67
          //   69: invokevirtual 73	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   72: checkcast 75	android/media/AudioManager
          //   75: astore 16
          //   77: aload 16
          //   79: iconst_5
          //   80: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
          //   83: istore 7
          //   85: iload 7
          //   87: ifne +10 -> 97
          //   90: sipush 20057
          //   93: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   96: return
          //   97: aload 14
          //   99: getfield 83	com/tencent/mm/booter/notification/a/f:iSK	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   102: ldc 84
          //   104: invokevirtual 89	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
          //   107: aload 14
          //   109: getfield 83	com/tencent/mm/booter/notification/a/f:iSK	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   112: ldc 84
          //   114: ldc2_w 90
          //   117: invokevirtual 95	com/tencent/mm/sdk/platformtools/MMHandler:sendEmptyMessageDelayed	(IJ)Z
          //   120: pop
          //   121: ldc 54
          //   123: ldc 97
          //   125: iconst_1
          //   126: anewarray 4	java/lang/Object
          //   129: dup
          //   130: iconst_0
          //   131: aload 14
          //   133: getfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   136: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   139: aastore
          //   140: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   143: aload 14
          //   145: getfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   148: istore 9
          //   150: iload 9
          //   152: ifeq +66 -> 218
          //   155: aload 14
          //   157: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   160: ifnull +52 -> 212
          //   163: aload 14
          //   165: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   168: invokevirtual 119	android/media/MediaPlayer:isPlaying	()Z
          //   171: ifeq +11 -> 182
          //   174: aload 14
          //   176: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   179: invokevirtual 122	android/media/MediaPlayer:stop	()V
          //   182: aload 14
          //   184: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   187: invokevirtual 125	android/media/MediaPlayer:release	()V
          //   190: ldc 54
          //   192: ldc 127
          //   194: iconst_1
          //   195: anewarray 4	java/lang/Object
          //   198: dup
          //   199: iconst_0
          //   200: aload 14
          //   202: getfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   205: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   208: aastore
          //   209: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   212: aload 14
          //   214: iconst_0
          //   215: putfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   218: aload 14
          //   220: new 129	com/tencent/mm/compatible/b/k
          //   223: dup
          //   224: invokespecial 130	com/tencent/mm/compatible/b/k:<init>	()V
          //   227: putfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   230: ldc 54
          //   232: ldc 132
          //   234: iconst_1
          //   235: anewarray 4	java/lang/Object
          //   238: dup
          //   239: iconst_0
          //   240: aload 14
          //   242: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   245: aastore
          //   246: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   249: aload 14
          //   251: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   254: astore 17
          //   256: invokestatic 138	java/lang/System:currentTimeMillis	()J
          //   259: lstore 11
          //   261: aload 15
          //   263: invokestatic 144	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   266: ifeq +482 -> 748
          //   269: iconst_2
          //   270: invokestatic 150	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
          //   273: astore 13
          //   275: aload 13
          //   277: ifnull +15 -> 292
          //   280: aload 17
          //   282: aload 14
          //   284: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   287: aload 13
          //   289: invokevirtual 154	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
          //   292: ldc 54
          //   294: ldc 156
          //   296: iconst_2
          //   297: anewarray 4	java/lang/Object
          //   300: dup
          //   301: iconst_0
          //   302: invokestatic 162	java/lang/Thread:currentThread	()Ljava/lang/Thread;
          //   305: invokevirtual 165	java/lang/Thread:getId	()J
          //   308: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   311: aastore
          //   312: dup
          //   313: iconst_1
          //   314: invokestatic 138	java/lang/System:currentTimeMillis	()J
          //   317: lload 11
          //   319: lsub
          //   320: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   323: aastore
          //   324: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   327: aload 16
          //   329: invokevirtual 173	android/media/AudioManager:isWiredHeadsetOn	()Z
          //   332: ifeq +573 -> 905
          //   335: iconst_0
          //   336: invokestatic 179	com/tencent/mm/plugin/audio/c/a:kG	(Z)I
          //   339: istore 7
          //   341: ldc 54
          //   343: ldc 181
          //   345: iconst_1
          //   346: anewarray 4	java/lang/Object
          //   349: dup
          //   350: iconst_0
          //   351: iload 7
          //   353: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   356: aastore
          //   357: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   360: aload 16
          //   362: iload 7
          //   364: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
          //   367: i2f
          //   368: fstore_1
          //   369: aload 16
          //   371: iconst_3
          //   372: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
          //   375: i2f
          //   376: fstore 5
          //   378: aload 16
          //   380: iload 7
          //   382: invokevirtual 192	android/media/AudioManager:getStreamMaxVolume	(I)I
          //   385: i2f
          //   386: fstore_2
          //   387: aload 16
          //   389: iconst_3
          //   390: invokevirtual 192	android/media/AudioManager:getStreamMaxVolume	(I)I
          //   393: i2f
          //   394: fstore 6
          //   396: fload_1
          //   397: fload_2
          //   398: fdiv
          //   399: fstore_3
          //   400: fload 5
          //   402: fload 6
          //   404: fdiv
          //   405: fstore 4
          //   407: ldc 54
          //   409: ldc 194
          //   411: iconst_3
          //   412: anewarray 4	java/lang/Object
          //   415: dup
          //   416: iconst_0
          //   417: fload_1
          //   418: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   421: aastore
          //   422: dup
          //   423: iconst_1
          //   424: fload_2
          //   425: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   428: aastore
          //   429: dup
          //   430: iconst_2
          //   431: fload_3
          //   432: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   435: aastore
          //   436: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   439: ldc 54
          //   441: ldc 201
          //   443: iconst_3
          //   444: anewarray 4	java/lang/Object
          //   447: dup
          //   448: iconst_0
          //   449: fload 5
          //   451: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   454: aastore
          //   455: dup
          //   456: iconst_1
          //   457: fload 6
          //   459: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   462: aastore
          //   463: dup
          //   464: iconst_2
          //   465: fload 4
          //   467: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   470: aastore
          //   471: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   474: fload_3
          //   475: fload 4
          //   477: fcmpl
          //   478: ifle +26 -> 504
          //   481: fload_2
          //   482: fload 4
          //   484: fmul
          //   485: fstore_1
          //   486: ldc 54
          //   488: ldc 203
          //   490: iconst_1
          //   491: anewarray 4	java/lang/Object
          //   494: dup
          //   495: iconst_0
          //   496: fload_1
          //   497: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   500: aastore
          //   501: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   504: ldc 54
          //   506: ldc 205
          //   508: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   511: aload 16
          //   513: iconst_0
          //   514: invokevirtual 211	android/media/AudioManager:setSpeakerphoneOn	(Z)V
          //   517: ldc 54
          //   519: ldc 213
          //   521: iconst_1
          //   522: anewarray 4	java/lang/Object
          //   525: dup
          //   526: iconst_0
          //   527: getstatic 219	com/tencent/mm/compatible/deviceinfo/af:juS	Lcom/tencent/mm/compatible/deviceinfo/k;
          //   530: getfield 225	com/tencent/mm/compatible/deviceinfo/k:jsa	I
          //   533: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   536: aastore
          //   537: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   540: getstatic 219	com/tencent/mm/compatible/deviceinfo/af:juS	Lcom/tencent/mm/compatible/deviceinfo/k;
          //   543: getfield 225	com/tencent/mm/compatible/deviceinfo/k:jsa	I
          //   546: iconst_1
          //   547: if_icmpne +321 -> 868
          //   550: ldc 54
          //   552: ldc 227
          //   554: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   557: aload 16
          //   559: invokevirtual 231	android/media/AudioManager:getMode	()I
          //   562: ifne +9 -> 571
          //   565: aload 16
          //   567: iconst_3
          //   568: invokevirtual 234	android/media/AudioManager:setMode	(I)V
          //   571: aload 14
          //   573: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   576: new 236	com/tencent/mm/booter/notification/a/f$3
          //   579: dup
          //   580: aload 14
          //   582: aload 16
          //   584: invokespecial 239	com/tencent/mm/booter/notification/a/f$3:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
          //   587: invokevirtual 243	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   590: aload 14
          //   592: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   595: new 245	com/tencent/mm/booter/notification/a/f$4
          //   598: dup
          //   599: aload 14
          //   601: aload 16
          //   603: invokespecial 246	com/tencent/mm/booter/notification/a/f$4:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
          //   606: invokevirtual 250	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   609: aload 14
          //   611: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   614: iload 7
          //   616: invokevirtual 253	android/media/MediaPlayer:setAudioStreamType	(I)V
          //   619: aload 14
          //   621: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   624: iconst_1
          //   625: invokevirtual 256	android/media/MediaPlayer:setLooping	(Z)V
          //   628: aload 14
          //   630: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   633: invokevirtual 259	android/media/MediaPlayer:prepare	()V
          //   636: aload 14
          //   638: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   641: fload_1
          //   642: fload_2
          //   643: fdiv
          //   644: fload_1
          //   645: fload_2
          //   646: fdiv
          //   647: invokevirtual 263	android/media/MediaPlayer:setVolume	(FF)V
          //   650: aload 14
          //   652: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   655: iconst_0
          //   656: invokevirtual 256	android/media/MediaPlayer:setLooping	(Z)V
          //   659: aload 14
          //   661: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   664: invokevirtual 266	android/media/MediaPlayer:start	()V
          //   667: aload 14
          //   669: iconst_1
          //   670: putfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   673: sipush 20057
          //   676: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   679: return
          //   680: astore 13
          //   682: ldc 54
          //   684: aload 13
          //   686: ldc_w 268
          //   689: iconst_0
          //   690: anewarray 4	java/lang/Object
          //   693: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   696: aload 14
          //   698: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   701: ifnull +11 -> 712
          //   704: aload 14
          //   706: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   709: invokevirtual 125	android/media/MediaPlayer:release	()V
          //   712: sipush 20057
          //   715: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   718: return
          //   719: astore 13
          //   721: ldc 54
          //   723: ldc_w 274
          //   726: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   729: aload 14
          //   731: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   734: ifnull -522 -> 212
          //   737: aload 14
          //   739: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   742: invokevirtual 125	android/media/MediaPlayer:release	()V
          //   745: goto -533 -> 212
          //   748: iload 8
          //   750: ifeq +49 -> 799
          //   753: aload 14
          //   755: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   758: invokevirtual 278	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
          //   761: aload 15
          //   763: invokevirtual 284	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
          //   766: astore 13
          //   768: aload 17
          //   770: aload 13
          //   772: invokevirtual 290	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   775: aload 13
          //   777: invokevirtual 293	android/content/res/AssetFileDescriptor:getStartOffset	()J
          //   780: aload 13
          //   782: invokevirtual 296	android/content/res/AssetFileDescriptor:getLength	()J
          //   785: invokevirtual 299	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
          //   788: aload 13
          //   790: invokevirtual 302	android/content/res/AssetFileDescriptor:close	()V
          //   793: aconst_null
          //   794: astore 13
          //   796: goto -521 -> 275
          //   799: aload 15
          //   801: invokestatic 308	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   804: astore 13
          //   806: goto -531 -> 275
          //   809: astore 13
          //   811: aload 15
          //   813: invokestatic 144	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   816: ifne +24 -> 840
          //   819: iconst_2
          //   820: invokestatic 150	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
          //   823: astore 13
          //   825: aload 17
          //   827: aload 14
          //   829: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   832: aload 13
          //   834: invokevirtual 154	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
          //   837: goto -545 -> 292
          //   840: ldc 54
          //   842: ldc_w 310
          //   845: iconst_2
          //   846: anewarray 4	java/lang/Object
          //   849: dup
          //   850: iconst_0
          //   851: aload 15
          //   853: aastore
          //   854: dup
          //   855: iconst_1
          //   856: iload 8
          //   858: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   861: aastore
          //   862: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   865: goto -573 -> 292
          //   868: aload 14
          //   870: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   873: new 312	com/tencent/mm/booter/notification/a/f$5
          //   876: dup
          //   877: aload 14
          //   879: invokespecial 315	com/tencent/mm/booter/notification/a/f$5:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   882: invokevirtual 243	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   885: aload 14
          //   887: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   890: new 317	com/tencent/mm/booter/notification/a/f$6
          //   893: dup
          //   894: aload 14
          //   896: invokespecial 318	com/tencent/mm/booter/notification/a/f$6:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   899: invokevirtual 250	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   902: goto -293 -> 609
          //   905: ldc 54
          //   907: ldc_w 320
          //   910: iconst_2
          //   911: anewarray 4	java/lang/Object
          //   914: dup
          //   915: iconst_0
          //   916: aload 16
          //   918: iconst_5
          //   919: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
          //   922: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   925: aastore
          //   926: dup
          //   927: iconst_1
          //   928: aload 15
          //   930: aastore
          //   931: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   934: aload 14
          //   936: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   939: new 322	com/tencent/mm/booter/notification/a/f$7
          //   942: dup
          //   943: aload 14
          //   945: invokespecial 323	com/tencent/mm/booter/notification/a/f$7:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   948: invokevirtual 243	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   951: aload 14
          //   953: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   956: new 325	com/tencent/mm/booter/notification/a/f$8
          //   959: dup
          //   960: aload 14
          //   962: invokespecial 326	com/tencent/mm/booter/notification/a/f$8:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   965: invokevirtual 250	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   968: aload 14
          //   970: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   973: iconst_5
          //   974: invokevirtual 253	android/media/MediaPlayer:setAudioStreamType	(I)V
          //   977: aload 14
          //   979: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   982: iconst_1
          //   983: invokevirtual 256	android/media/MediaPlayer:setLooping	(Z)V
          //   986: aload 14
          //   988: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   991: invokevirtual 259	android/media/MediaPlayer:prepare	()V
          //   994: aload 14
          //   996: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   999: iconst_0
          //   1000: invokevirtual 256	android/media/MediaPlayer:setLooping	(Z)V
          //   1003: aload 14
          //   1005: getfield 113	com/tencent/mm/booter/notification/a/f:iSJ	Landroid/media/MediaPlayer;
          //   1008: invokevirtual 266	android/media/MediaPlayer:start	()V
          //   1011: aload 14
          //   1013: iconst_1
          //   1014: putfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   1017: aload 14
          //   1019: getfield 100	com/tencent/mm/booter/notification/a/f:iSI	Z
          //   1022: istore 10
          //   1024: invokestatic 332	android/os/Looper:myLooper	()Landroid/os/Looper;
          //   1027: ifnull +58 -> 1085
          //   1030: iconst_1
          //   1031: istore 8
          //   1033: invokestatic 335	android/os/Looper:getMainLooper	()Landroid/os/Looper;
          //   1036: ifnull +55 -> 1091
          //   1039: iconst_1
          //   1040: istore 9
          //   1042: ldc 54
          //   1044: ldc_w 337
          //   1047: iconst_3
          //   1048: anewarray 4	java/lang/Object
          //   1051: dup
          //   1052: iconst_0
          //   1053: iload 10
          //   1055: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1058: aastore
          //   1059: dup
          //   1060: iconst_1
          //   1061: iload 8
          //   1063: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1066: aastore
          //   1067: dup
          //   1068: iconst_2
          //   1069: iload 9
          //   1071: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1074: aastore
          //   1075: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1078: sipush 20057
          //   1081: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1084: return
          //   1085: iconst_0
          //   1086: istore 8
          //   1088: goto -55 -> 1033
          //   1091: iconst_0
          //   1092: istore 9
          //   1094: goto -52 -> 1042
          //   1097: astore 13
          //   1099: ldc 54
          //   1101: aload 13
          //   1103: ldc_w 339
          //   1106: iconst_0
          //   1107: anewarray 4	java/lang/Object
          //   1110: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1113: sipush 20057
          //   1116: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1119: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1120	0	this	2
          //   368	277	1	f1	float
          //   386	260	2	f2	float
          //   399	76	3	f3	float
          //   405	78	4	f4	float
          //   376	74	5	f5	float
          //   394	64	6	f6	float
          //   83	532	7	i	int
          //   22	1065	8	bool1	boolean
          //   148	945	9	bool2	boolean
          //   1022	32	10	bool3	boolean
          //   259	59	11	l	long
          //   273	15	13	localUri1	android.net.Uri
          //   680	5	13	localException1	java.lang.Exception
          //   719	1	13	localIllegalStateException	IllegalStateException
          //   766	39	13	localObject	Object
          //   809	1	13	localIOException	java.io.IOException
          //   823	10	13	localUri2	android.net.Uri
          //   1097	5	13	localException2	java.lang.Exception
          //   10	1008	14	localf	f
          //   16	913	15	str	String
          //   75	842	16	localAudioManager	AudioManager
          //   254	572	17	localMediaPlayer	MediaPlayer
          // Exception table:
          //   from	to	target	type
          //   62	85	680	java/lang/Exception
          //   97	150	680	java/lang/Exception
          //   155	182	680	java/lang/Exception
          //   182	212	680	java/lang/Exception
          //   212	218	680	java/lang/Exception
          //   218	275	680	java/lang/Exception
          //   280	292	680	java/lang/Exception
          //   292	474	680	java/lang/Exception
          //   486	504	680	java/lang/Exception
          //   504	571	680	java/lang/Exception
          //   571	609	680	java/lang/Exception
          //   609	679	680	java/lang/Exception
          //   721	745	680	java/lang/Exception
          //   753	793	680	java/lang/Exception
          //   799	806	680	java/lang/Exception
          //   811	837	680	java/lang/Exception
          //   840	865	680	java/lang/Exception
          //   868	902	680	java/lang/Exception
          //   905	1030	680	java/lang/Exception
          //   1033	1039	680	java/lang/Exception
          //   1042	1078	680	java/lang/Exception
          //   155	182	719	java/lang/IllegalStateException
          //   182	212	719	java/lang/IllegalStateException
          //   280	292	809	java/io/IOException
          //   696	712	1097	java/lang/Exception
        }
      });
      AppMethodBeat.o(20066);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f
 * JD-Core Version:    0.7.0.1
 */