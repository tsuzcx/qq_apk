package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class g$a
{
  /* Error */
  public static MediaPlayer a(android.content.Context paramContext, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +33 -> 39
    //   9: ldc 29
    //   11: ldc 31
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 32
    //   25: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 44	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: ldc 21
    //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_0
    //   40: ldc 32
    //   42: invokevirtual 53	android/content/Context:getString	(I)Ljava/lang/String;
    //   45: astore 8
    //   47: invokestatic 57	com/tencent/mm/plugin/collect/model/g:bVP	()Landroid/media/MediaPlayer;
    //   50: astore 7
    //   52: aload 7
    //   54: iconst_3
    //   55: invokevirtual 62	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   58: ldc 29
    //   60: ldc 64
    //   62: iconst_4
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 7
    //   70: invokevirtual 68	java/lang/Object:hashCode	()I
    //   73: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload 8
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: aload_0
    //   85: aastore
    //   86: dup
    //   87: iconst_3
    //   88: ldc 32
    //   90: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokestatic 70	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: astore 6
    //   100: aload_0
    //   101: invokevirtual 74	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   104: aload 8
    //   106: invokevirtual 80	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   109: astore_0
    //   110: aload 7
    //   112: aload_0
    //   113: invokevirtual 86	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   116: aload_0
    //   117: invokevirtual 90	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   120: aload_0
    //   121: invokevirtual 93	android/content/res/AssetFileDescriptor:getLength	()J
    //   124: invokevirtual 97	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   127: aload 7
    //   129: iconst_0
    //   130: invokevirtual 101	android/media/MediaPlayer:setLooping	(Z)V
    //   133: aload 7
    //   135: new 9	com/tencent/mm/plugin/collect/model/g$a$1
    //   138: dup
    //   139: aload 7
    //   141: aload_2
    //   142: invokespecial 105	com/tencent/mm/plugin/collect/model/g$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
    //   145: invokevirtual 109	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   148: aload 7
    //   150: new 11	com/tencent/mm/plugin/collect/model/g$a$2
    //   153: dup
    //   154: aload 8
    //   156: aload 7
    //   158: aload_1
    //   159: invokespecial 112	com/tencent/mm/plugin/collect/model/g$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   162: invokevirtual 116	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   165: aload 7
    //   167: invokevirtual 120	android/media/MediaPlayer:prepare	()V
    //   170: aload 7
    //   172: invokevirtual 123	android/media/MediaPlayer:start	()V
    //   175: aload 7
    //   177: invokevirtual 68	java/lang/Object:hashCode	()I
    //   180: istore_3
    //   181: invokestatic 129	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   184: ifnull +65 -> 249
    //   187: iconst_1
    //   188: istore 4
    //   190: invokestatic 132	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   193: ifnull +62 -> 255
    //   196: iconst_1
    //   197: istore 5
    //   199: ldc 29
    //   201: ldc 134
    //   203: iconst_3
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: iload_3
    //   210: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: iload 4
    //   218: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: iload 5
    //   226: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   229: aastore
    //   230: invokestatic 70	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_0
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   241: ldc 21
    //   243: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 7
    //   248: areturn
    //   249: iconst_0
    //   250: istore 4
    //   252: goto -62 -> 190
    //   255: iconst_0
    //   256: istore 5
    //   258: goto -59 -> 199
    //   261: astore_0
    //   262: ldc 29
    //   264: aload_0
    //   265: ldc 144
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 148	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -33 -> 241
    //   277: astore_1
    //   278: aload 6
    //   280: astore_0
    //   281: ldc 29
    //   283: ldc 150
    //   285: iconst_2
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: ldc 32
    //   293: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload_1
    //   300: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 44	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: ldc 29
    //   309: aload_1
    //   310: ldc 144
    //   312: iconst_0
    //   313: anewarray 4	java/lang/Object
    //   316: invokestatic 148	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   319: aload 7
    //   321: ifnull +8 -> 329
    //   324: aload 7
    //   326: invokevirtual 157	android/media/MediaPlayer:release	()V
    //   329: aload_0
    //   330: ifnull +7 -> 337
    //   333: aload_0
    //   334: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   337: ldc 21
    //   339: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aconst_null
    //   343: areturn
    //   344: astore_0
    //   345: ldc 29
    //   347: aload_0
    //   348: ldc 144
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 148	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: goto -20 -> 337
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_0
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   371: ldc 21
    //   373: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: aload_1
    //   377: athrow
    //   378: astore_0
    //   379: ldc 29
    //   381: aload_0
    //   382: ldc 144
    //   384: iconst_0
    //   385: anewarray 4	java/lang/Object
    //   388: invokestatic 148	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   391: goto -20 -> 371
    //   394: astore_1
    //   395: goto -32 -> 363
    //   398: astore_1
    //   399: goto -36 -> 363
    //   402: astore_1
    //   403: goto -122 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramContext	android.content.Context
    //   0	406	1	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   0	406	2	paramOnErrorListener	MediaPlayer.OnErrorListener
    //   180	30	3	i	int
    //   188	63	4	bool1	boolean
    //   197	60	5	bool2	boolean
    //   98	181	6	localObject	Object
    //   50	275	7	localMediaPlayer	MediaPlayer
    //   45	110	8	str	String
    // Exception table:
    //   from	to	target	type
    //   237	241	261	java/io/IOException
    //   100	110	277	java/lang/Exception
    //   333	337	344	java/io/IOException
    //   100	110	360	finally
    //   367	371	378	java/io/IOException
    //   110	187	394	finally
    //   190	196	394	finally
    //   199	233	394	finally
    //   281	319	398	finally
    //   324	329	398	finally
    //   110	187	402	java/lang/Exception
    //   190	196	402	java/lang/Exception
    //   199	233	402	java/lang/Exception
  }
  
  public static MediaPlayer a(String paramString, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener, g.b paramb)
  {
    AppMethodBeat.i(207040);
    final MediaPlayer localMediaPlayer = g.bVP();
    localMediaPlayer.setAudioStreamType(3);
    ac.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.setLooping(false);
      localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(63793);
          ac.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousMediaPlayer != null) {}
          try
          {
            paramAnonymousMediaPlayer.release();
            if (this.owP != null) {
              this.owP.release();
            }
          }
          catch (Exception localException)
          {
            label52:
            break label52;
          }
          if (paramOnErrorListener != null) {
            paramOnErrorListener.onError(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(63793);
          return false;
        }
      });
      localMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(63794);
          if (paramAnonymousMediaPlayer == null) {}
          for (int i = -1;; i = paramAnonymousMediaPlayer.hashCode())
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
            if (paramAnonymousMediaPlayer != null) {
              paramAnonymousMediaPlayer.release();
            }
            if (localMediaPlayer != null) {
              localMediaPlayer.release();
            }
            if (paramOnCompletionListener != null) {
              paramOnCompletionListener.onCompletion(paramAnonymousMediaPlayer);
            }
            AppMethodBeat.o(63794);
            return;
          }
        }
      });
      localMediaPlayer.prepare();
      localMediaPlayer.start();
      paramb.bVQ();
      int i = localMediaPlayer.hashCode();
      boolean bool1;
      if (Looper.myLooper() != null)
      {
        bool1 = true;
        if (Looper.getMainLooper() == null) {
          break label175;
        }
      }
      label175:
      for (boolean bool2 = true;; bool2 = false)
      {
        ac.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(207040);
        return localMediaPlayer;
        bool1 = false;
        break;
      }
      return null;
    }
    catch (Exception paramOnCompletionListener)
    {
      ac.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
      ac.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
      if (localMediaPlayer != null) {
        localMediaPlayer.release();
      }
      AppMethodBeat.o(207040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.a
 * JD-Core Version:    0.7.0.1
 */