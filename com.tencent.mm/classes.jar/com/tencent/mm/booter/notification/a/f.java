package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.co;
import com.tencent.threadpool.c.d;

public final class f
{
  Context context;
  boolean luF;
  MediaPlayer luG;
  MMHandler luH;
  private MMHandler luI;
  
  private f()
  {
    AppMethodBeat.i(20065);
    this.luF = false;
    this.luG = null;
    this.luH = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(20056);
        Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.luF) });
        try
        {
          if (f.this.luG != null)
          {
            if (f.this.luG.isPlaying()) {
              f.this.luG.stop();
            }
            f.this.luG.release();
            f.this.luF = false;
            Log.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.luF) });
          }
          AppMethodBeat.o(20056);
          return;
        }
        catch (IllegalStateException paramAnonymousMessage)
        {
          Log.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[] { Boolean.valueOf(f.this.luF) });
          if (f.this.luG != null) {
            f.this.luG.release();
          }
          AppMethodBeat.o(20056);
        }
      }
    };
    this.context = MMApplicationContext.getContext();
    af.Ds(co.jcQ());
    AppMethodBeat.o(20065);
  }
  
  public final void s(final String paramString, final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(238925);
      if (this.luI == null)
      {
        Log.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
        HandlerThread localHandlerThread = d.jw("playSoundThread", 0);
        localHandlerThread.start();
        this.luI = new MMHandler(localHandlerThread.getLooper());
      }
      this.luI.post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: sipush 20057
          //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: aload_0
          //   7: getfield 22	com/tencent/mm/booter/notification/a/f$2:luJ	Lcom/tencent/mm/booter/notification/a/f;
          //   10: astore 14
          //   12: aload_0
          //   13: getfield 24	com/tencent/mm/booter/notification/a/f$2:luK	Ljava/lang/String;
          //   16: astore 15
          //   18: aload_0
          //   19: getfield 26	com/tencent/mm/booter/notification/a/f$2:luL	Z
          //   22: istore 8
          //   24: aload_0
          //   25: getfield 28	com/tencent/mm/booter/notification/a/f$2:luM	Z
          //   28: istore 9
          //   30: aload 14
          //   32: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   35: ifnonnull +11 -> 46
          //   38: aload 14
          //   40: invokestatic 55	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   43: putfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   46: aload 14
          //   48: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   51: ifnonnull +17 -> 68
          //   54: ldc 57
          //   56: ldc 59
          //   58: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   61: sipush 20057
          //   64: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   67: return
          //   68: aload 14
          //   70: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   73: ldc 70
          //   75: invokevirtual 76	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   78: checkcast 78	android/media/AudioManager
          //   81: astore 16
          //   83: aload 16
          //   85: iconst_5
          //   86: invokevirtual 82	android/media/AudioManager:getStreamVolume	(I)I
          //   89: istore 7
          //   91: iload 7
          //   93: ifne +10 -> 103
          //   96: sipush 20057
          //   99: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   102: return
          //   103: aload 14
          //   105: getfield 86	com/tencent/mm/booter/notification/a/f:luH	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   108: ldc 87
          //   110: invokevirtual 92	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
          //   113: aload 14
          //   115: getfield 86	com/tencent/mm/booter/notification/a/f:luH	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   118: ldc 87
          //   120: ldc2_w 93
          //   123: invokevirtual 98	com/tencent/mm/sdk/platformtools/MMHandler:sendEmptyMessageDelayed	(IJ)Z
          //   126: pop
          //   127: ldc 57
          //   129: ldc 100
          //   131: iconst_1
          //   132: anewarray 4	java/lang/Object
          //   135: dup
          //   136: iconst_0
          //   137: aload 14
          //   139: getfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   142: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   145: aastore
          //   146: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   149: aload 14
          //   151: getfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   154: istore 10
          //   156: iload 10
          //   158: ifeq +66 -> 224
          //   161: aload 14
          //   163: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   166: ifnull +52 -> 218
          //   169: aload 14
          //   171: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   174: invokevirtual 122	android/media/MediaPlayer:isPlaying	()Z
          //   177: ifeq +11 -> 188
          //   180: aload 14
          //   182: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   185: invokevirtual 125	android/media/MediaPlayer:stop	()V
          //   188: aload 14
          //   190: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   193: invokevirtual 128	android/media/MediaPlayer:release	()V
          //   196: ldc 57
          //   198: ldc 130
          //   200: iconst_1
          //   201: anewarray 4	java/lang/Object
          //   204: dup
          //   205: iconst_0
          //   206: aload 14
          //   208: getfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   211: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   214: aastore
          //   215: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   218: aload 14
          //   220: iconst_0
          //   221: putfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   224: aload 14
          //   226: new 132	com/tencent/mm/compatible/b/k
          //   229: dup
          //   230: invokespecial 133	com/tencent/mm/compatible/b/k:<init>	()V
          //   233: putfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   236: ldc 57
          //   238: ldc 135
          //   240: iconst_1
          //   241: anewarray 4	java/lang/Object
          //   244: dup
          //   245: iconst_0
          //   246: aload 14
          //   248: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   251: aastore
          //   252: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   255: aload 14
          //   257: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   260: astore 17
          //   262: invokestatic 141	java/lang/System:currentTimeMillis	()J
          //   265: lstore 11
          //   267: aload 15
          //   269: invokestatic 147	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   272: ifeq +482 -> 754
          //   275: iconst_2
          //   276: invokestatic 153	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
          //   279: astore 13
          //   281: aload 13
          //   283: ifnull +15 -> 298
          //   286: aload 17
          //   288: aload 14
          //   290: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   293: aload 13
          //   295: invokevirtual 157	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
          //   298: ldc 57
          //   300: ldc 159
          //   302: iconst_2
          //   303: anewarray 4	java/lang/Object
          //   306: dup
          //   307: iconst_0
          //   308: invokestatic 165	java/lang/Thread:currentThread	()Ljava/lang/Thread;
          //   311: invokevirtual 168	java/lang/Thread:getId	()J
          //   314: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   317: aastore
          //   318: dup
          //   319: iconst_1
          //   320: invokestatic 141	java/lang/System:currentTimeMillis	()J
          //   323: lload 11
          //   325: lsub
          //   326: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   329: aastore
          //   330: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   333: aload 16
          //   335: invokevirtual 176	android/media/AudioManager:isWiredHeadsetOn	()Z
          //   338: ifeq +603 -> 941
          //   341: iconst_0
          //   342: invokestatic 182	com/tencent/mm/plugin/audio/c/a:lS	(Z)I
          //   345: istore 7
          //   347: ldc 57
          //   349: ldc 184
          //   351: iconst_1
          //   352: anewarray 4	java/lang/Object
          //   355: dup
          //   356: iconst_0
          //   357: iload 7
          //   359: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   362: aastore
          //   363: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   366: aload 16
          //   368: iload 7
          //   370: invokevirtual 82	android/media/AudioManager:getStreamVolume	(I)I
          //   373: i2f
          //   374: fstore_1
          //   375: aload 16
          //   377: iconst_3
          //   378: invokevirtual 82	android/media/AudioManager:getStreamVolume	(I)I
          //   381: i2f
          //   382: fstore 5
          //   384: aload 16
          //   386: iload 7
          //   388: invokevirtual 195	android/media/AudioManager:getStreamMaxVolume	(I)I
          //   391: i2f
          //   392: fstore_2
          //   393: aload 16
          //   395: iconst_3
          //   396: invokevirtual 195	android/media/AudioManager:getStreamMaxVolume	(I)I
          //   399: i2f
          //   400: fstore 6
          //   402: fload_1
          //   403: fload_2
          //   404: fdiv
          //   405: fstore_3
          //   406: fload 5
          //   408: fload 6
          //   410: fdiv
          //   411: fstore 4
          //   413: ldc 57
          //   415: ldc 197
          //   417: iconst_3
          //   418: anewarray 4	java/lang/Object
          //   421: dup
          //   422: iconst_0
          //   423: fload_1
          //   424: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   427: aastore
          //   428: dup
          //   429: iconst_1
          //   430: fload_2
          //   431: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   434: aastore
          //   435: dup
          //   436: iconst_2
          //   437: fload_3
          //   438: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   441: aastore
          //   442: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   445: ldc 57
          //   447: ldc 204
          //   449: iconst_3
          //   450: anewarray 4	java/lang/Object
          //   453: dup
          //   454: iconst_0
          //   455: fload 5
          //   457: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   460: aastore
          //   461: dup
          //   462: iconst_1
          //   463: fload 6
          //   465: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   468: aastore
          //   469: dup
          //   470: iconst_2
          //   471: fload 4
          //   473: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   476: aastore
          //   477: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   480: fload_3
          //   481: fload 4
          //   483: fcmpl
          //   484: ifle +26 -> 510
          //   487: fload_2
          //   488: fload 4
          //   490: fmul
          //   491: fstore_1
          //   492: ldc 57
          //   494: ldc 206
          //   496: iconst_1
          //   497: anewarray 4	java/lang/Object
          //   500: dup
          //   501: iconst_0
          //   502: fload_1
          //   503: invokestatic 202	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   506: aastore
          //   507: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   510: ldc 57
          //   512: ldc 208
          //   514: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   517: aload 16
          //   519: iconst_0
          //   520: invokevirtual 214	android/media/AudioManager:setSpeakerphoneOn	(Z)V
          //   523: ldc 57
          //   525: ldc 216
          //   527: iconst_1
          //   528: anewarray 4	java/lang/Object
          //   531: dup
          //   532: iconst_0
          //   533: getstatic 222	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
          //   536: getfield 228	com/tencent/mm/compatible/deviceinfo/k:lVq	I
          //   539: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   542: aastore
          //   543: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   546: getstatic 222	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
          //   549: getfield 228	com/tencent/mm/compatible/deviceinfo/k:lVq	I
          //   552: iconst_1
          //   553: if_icmpne +351 -> 904
          //   556: ldc 57
          //   558: ldc 230
          //   560: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   563: aload 16
          //   565: invokevirtual 234	android/media/AudioManager:getMode	()I
          //   568: ifne +9 -> 577
          //   571: aload 16
          //   573: iconst_3
          //   574: invokevirtual 237	android/media/AudioManager:setMode	(I)V
          //   577: aload 14
          //   579: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   582: new 239	com/tencent/mm/booter/notification/a/f$3
          //   585: dup
          //   586: aload 14
          //   588: aload 16
          //   590: invokespecial 242	com/tencent/mm/booter/notification/a/f$3:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
          //   593: invokevirtual 246	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   596: aload 14
          //   598: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   601: new 248	com/tencent/mm/booter/notification/a/f$4
          //   604: dup
          //   605: aload 14
          //   607: aload 16
          //   609: invokespecial 249	com/tencent/mm/booter/notification/a/f$4:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
          //   612: invokevirtual 253	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   615: aload 14
          //   617: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   620: iload 7
          //   622: invokevirtual 256	android/media/MediaPlayer:setAudioStreamType	(I)V
          //   625: aload 14
          //   627: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   630: iconst_1
          //   631: invokevirtual 259	android/media/MediaPlayer:setLooping	(Z)V
          //   634: aload 14
          //   636: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   639: invokevirtual 262	android/media/MediaPlayer:prepare	()V
          //   642: aload 14
          //   644: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   647: fload_1
          //   648: fload_2
          //   649: fdiv
          //   650: fload_1
          //   651: fload_2
          //   652: fdiv
          //   653: invokevirtual 266	android/media/MediaPlayer:setVolume	(FF)V
          //   656: aload 14
          //   658: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   661: iconst_0
          //   662: invokevirtual 259	android/media/MediaPlayer:setLooping	(Z)V
          //   665: aload 14
          //   667: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   670: invokevirtual 269	android/media/MediaPlayer:start	()V
          //   673: aload 14
          //   675: iconst_1
          //   676: putfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   679: sipush 20057
          //   682: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   685: return
          //   686: astore 13
          //   688: ldc 57
          //   690: aload 13
          //   692: ldc_w 271
          //   695: iconst_0
          //   696: anewarray 4	java/lang/Object
          //   699: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   702: aload 14
          //   704: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   707: ifnull +11 -> 718
          //   710: aload 14
          //   712: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   715: invokevirtual 128	android/media/MediaPlayer:release	()V
          //   718: sipush 20057
          //   721: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   724: return
          //   725: astore 13
          //   727: ldc 57
          //   729: ldc_w 277
          //   732: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   735: aload 14
          //   737: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   740: ifnull -522 -> 218
          //   743: aload 14
          //   745: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   748: invokevirtual 128	android/media/MediaPlayer:release	()V
          //   751: goto -533 -> 218
          //   754: iload 9
          //   756: ifeq +28 -> 784
          //   759: aload 14
          //   761: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   764: new 279	java/io/File
          //   767: dup
          //   768: aload 15
          //   770: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
          //   773: invokestatic 288	com/tencent/mm/vfs/u:V	(Ljava/io/File;)Lcom/tencent/mm/vfs/u;
          //   776: invokestatic 294	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFile	(Landroid/content/Context;Lcom/tencent/mm/vfs/u;)Landroid/net/Uri;
          //   779: astore 13
          //   781: goto -500 -> 281
          //   784: iload 8
          //   786: ifeq +49 -> 835
          //   789: aload 14
          //   791: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   794: invokevirtual 298	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
          //   797: aload 15
          //   799: invokevirtual 304	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
          //   802: astore 13
          //   804: aload 17
          //   806: aload 13
          //   808: invokevirtual 310	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   811: aload 13
          //   813: invokevirtual 313	android/content/res/AssetFileDescriptor:getStartOffset	()J
          //   816: aload 13
          //   818: invokevirtual 316	android/content/res/AssetFileDescriptor:getLength	()J
          //   821: invokevirtual 319	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
          //   824: aload 13
          //   826: invokevirtual 322	android/content/res/AssetFileDescriptor:close	()V
          //   829: aconst_null
          //   830: astore 13
          //   832: goto -551 -> 281
          //   835: aload 15
          //   837: invokestatic 328	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   840: astore 13
          //   842: goto -561 -> 281
          //   845: astore 13
          //   847: aload 15
          //   849: invokestatic 147	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   852: ifne +24 -> 876
          //   855: iconst_2
          //   856: invokestatic 153	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
          //   859: astore 13
          //   861: aload 17
          //   863: aload 14
          //   865: getfield 49	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
          //   868: aload 13
          //   870: invokevirtual 157	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
          //   873: goto -575 -> 298
          //   876: ldc 57
          //   878: ldc_w 330
          //   881: iconst_2
          //   882: anewarray 4	java/lang/Object
          //   885: dup
          //   886: iconst_0
          //   887: aload 15
          //   889: aastore
          //   890: dup
          //   891: iconst_1
          //   892: iload 8
          //   894: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   897: aastore
          //   898: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   901: goto -603 -> 298
          //   904: aload 14
          //   906: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   909: new 332	com/tencent/mm/booter/notification/a/f$5
          //   912: dup
          //   913: aload 14
          //   915: invokespecial 335	com/tencent/mm/booter/notification/a/f$5:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   918: invokevirtual 246	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   921: aload 14
          //   923: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   926: new 337	com/tencent/mm/booter/notification/a/f$6
          //   929: dup
          //   930: aload 14
          //   932: invokespecial 338	com/tencent/mm/booter/notification/a/f$6:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   935: invokevirtual 253	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   938: goto -323 -> 615
          //   941: ldc 57
          //   943: ldc_w 340
          //   946: iconst_2
          //   947: anewarray 4	java/lang/Object
          //   950: dup
          //   951: iconst_0
          //   952: aload 16
          //   954: iconst_5
          //   955: invokevirtual 82	android/media/AudioManager:getStreamVolume	(I)I
          //   958: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   961: aastore
          //   962: dup
          //   963: iconst_1
          //   964: aload 15
          //   966: aastore
          //   967: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   970: aload 14
          //   972: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   975: new 342	com/tencent/mm/booter/notification/a/f$7
          //   978: dup
          //   979: aload 14
          //   981: invokespecial 343	com/tencent/mm/booter/notification/a/f$7:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   984: invokevirtual 246	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
          //   987: aload 14
          //   989: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   992: new 345	com/tencent/mm/booter/notification/a/f$8
          //   995: dup
          //   996: aload 14
          //   998: invokespecial 346	com/tencent/mm/booter/notification/a/f$8:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
          //   1001: invokevirtual 253	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
          //   1004: aload 14
          //   1006: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   1009: iconst_5
          //   1010: invokevirtual 256	android/media/MediaPlayer:setAudioStreamType	(I)V
          //   1013: aload 14
          //   1015: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   1018: iconst_1
          //   1019: invokevirtual 259	android/media/MediaPlayer:setLooping	(Z)V
          //   1022: aload 14
          //   1024: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   1027: invokevirtual 262	android/media/MediaPlayer:prepare	()V
          //   1030: aload 14
          //   1032: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   1035: iconst_0
          //   1036: invokevirtual 259	android/media/MediaPlayer:setLooping	(Z)V
          //   1039: aload 14
          //   1041: getfield 116	com/tencent/mm/booter/notification/a/f:luG	Landroid/media/MediaPlayer;
          //   1044: invokevirtual 269	android/media/MediaPlayer:start	()V
          //   1047: aload 14
          //   1049: iconst_1
          //   1050: putfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   1053: aload 14
          //   1055: getfield 103	com/tencent/mm/booter/notification/a/f:luF	Z
          //   1058: istore 10
          //   1060: invokestatic 352	android/os/Looper:myLooper	()Landroid/os/Looper;
          //   1063: ifnull +58 -> 1121
          //   1066: iconst_1
          //   1067: istore 8
          //   1069: invokestatic 355	android/os/Looper:getMainLooper	()Landroid/os/Looper;
          //   1072: ifnull +55 -> 1127
          //   1075: iconst_1
          //   1076: istore 9
          //   1078: ldc 57
          //   1080: ldc_w 357
          //   1083: iconst_3
          //   1084: anewarray 4	java/lang/Object
          //   1087: dup
          //   1088: iconst_0
          //   1089: iload 10
          //   1091: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1094: aastore
          //   1095: dup
          //   1096: iconst_1
          //   1097: iload 8
          //   1099: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1102: aastore
          //   1103: dup
          //   1104: iconst_2
          //   1105: iload 9
          //   1107: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1110: aastore
          //   1111: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1114: sipush 20057
          //   1117: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1120: return
          //   1121: iconst_0
          //   1122: istore 8
          //   1124: goto -55 -> 1069
          //   1127: iconst_0
          //   1128: istore 9
          //   1130: goto -52 -> 1078
          //   1133: astore 13
          //   1135: ldc 57
          //   1137: aload 13
          //   1139: ldc_w 359
          //   1142: iconst_0
          //   1143: anewarray 4	java/lang/Object
          //   1146: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1149: sipush 20057
          //   1152: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1155: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1156	0	this	2
          //   374	277	1	f1	float
          //   392	260	2	f2	float
          //   405	76	3	f3	float
          //   411	78	4	f4	float
          //   382	74	5	f5	float
          //   400	64	6	f6	float
          //   89	532	7	i	int
          //   22	1101	8	bool1	boolean
          //   28	1101	9	bool2	boolean
          //   154	936	10	bool3	boolean
          //   265	59	11	l	long
          //   279	15	13	localUri1	android.net.Uri
          //   686	5	13	localException1	java.lang.Exception
          //   725	1	13	localIllegalStateException	IllegalStateException
          //   779	62	13	localObject	Object
          //   845	1	13	localIOException	java.io.IOException
          //   859	10	13	localUri2	android.net.Uri
          //   1133	5	13	localException2	java.lang.Exception
          //   10	1044	14	localf	f
          //   16	949	15	str	String
          //   81	872	16	localAudioManager	AudioManager
          //   260	602	17	localMediaPlayer	MediaPlayer
          // Exception table:
          //   from	to	target	type
          //   68	91	686	java/lang/Exception
          //   103	156	686	java/lang/Exception
          //   161	188	686	java/lang/Exception
          //   188	218	686	java/lang/Exception
          //   218	224	686	java/lang/Exception
          //   224	281	686	java/lang/Exception
          //   286	298	686	java/lang/Exception
          //   298	480	686	java/lang/Exception
          //   492	510	686	java/lang/Exception
          //   510	577	686	java/lang/Exception
          //   577	615	686	java/lang/Exception
          //   615	685	686	java/lang/Exception
          //   727	751	686	java/lang/Exception
          //   759	781	686	java/lang/Exception
          //   789	829	686	java/lang/Exception
          //   835	842	686	java/lang/Exception
          //   847	873	686	java/lang/Exception
          //   876	901	686	java/lang/Exception
          //   904	938	686	java/lang/Exception
          //   941	1066	686	java/lang/Exception
          //   1069	1075	686	java/lang/Exception
          //   1078	1114	686	java/lang/Exception
          //   161	188	725	java/lang/IllegalStateException
          //   188	218	725	java/lang/IllegalStateException
          //   286	298	845	java/io/IOException
          //   702	718	1133	java/lang/Exception
        }
      });
      AppMethodBeat.o(238925);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f
 * JD-Core Version:    0.7.0.1
 */