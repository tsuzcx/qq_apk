package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class F2fRcvVoiceListener$a
{
  /* Error */
  public static MediaPlayer a(android.content.Context paramContext, int paramInt, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +32 -> 38
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
    //   23: iload_1
    //   24: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 21
    //   33: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: aload_0
    //   39: iload_1
    //   40: invokevirtual 52	android/content/Context:getString	(I)Ljava/lang/String;
    //   43: astore 9
    //   45: invokestatic 56	com/tencent/mm/plugin/collect/model/F2fRcvVoiceListener:drG	()Landroid/media/MediaPlayer;
    //   48: astore 8
    //   50: aload 8
    //   52: iconst_3
    //   53: invokevirtual 61	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   56: ldc 29
    //   58: ldc 63
    //   60: iconst_4
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload 8
    //   68: invokevirtual 67	java/lang/Object:hashCode	()I
    //   71: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload 9
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: aload_0
    //   83: aastore
    //   84: dup
    //   85: iconst_3
    //   86: iload_1
    //   87: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aconst_null
    //   95: astore 7
    //   97: aload_0
    //   98: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   101: aload 9
    //   103: invokevirtual 79	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   106: astore_0
    //   107: aload 8
    //   109: aload_0
    //   110: invokevirtual 85	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   113: aload_0
    //   114: invokevirtual 89	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   117: aload_0
    //   118: invokevirtual 92	android/content/res/AssetFileDescriptor:getLength	()J
    //   121: invokevirtual 96	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   124: aload 8
    //   126: iconst_0
    //   127: invokevirtual 100	android/media/MediaPlayer:setLooping	(Z)V
    //   130: aload 8
    //   132: new 9	com/tencent/mm/plugin/collect/model/F2fRcvVoiceListener$a$1
    //   135: dup
    //   136: aload 8
    //   138: aload_3
    //   139: invokespecial 104	com/tencent/mm/plugin/collect/model/F2fRcvVoiceListener$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
    //   142: invokevirtual 108	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   145: aload 8
    //   147: new 11	com/tencent/mm/plugin/collect/model/F2fRcvVoiceListener$a$2
    //   150: dup
    //   151: aload 9
    //   153: aload 8
    //   155: aload_2
    //   156: invokespecial 111	com/tencent/mm/plugin/collect/model/F2fRcvVoiceListener$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   159: invokevirtual 115	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   162: aload 8
    //   164: invokevirtual 119	android/media/MediaPlayer:prepare	()V
    //   167: aload 8
    //   169: invokevirtual 122	android/media/MediaPlayer:start	()V
    //   172: aload 8
    //   174: invokevirtual 67	java/lang/Object:hashCode	()I
    //   177: istore 4
    //   179: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   182: ifnull +66 -> 248
    //   185: iconst_1
    //   186: istore 5
    //   188: invokestatic 131	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   191: ifnull +63 -> 254
    //   194: iconst_1
    //   195: istore 6
    //   197: ldc 29
    //   199: ldc 133
    //   201: iconst_3
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: iload 4
    //   209: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload 5
    //   217: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   220: aastore
    //   221: dup
    //   222: iconst_2
    //   223: iload 6
    //   225: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   228: aastore
    //   229: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
    //   240: ldc 21
    //   242: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload 8
    //   247: areturn
    //   248: iconst_0
    //   249: istore 5
    //   251: goto -63 -> 188
    //   254: iconst_0
    //   255: istore 6
    //   257: goto -60 -> 197
    //   260: astore_0
    //   261: ldc 29
    //   263: aload_0
    //   264: ldc 143
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: goto -33 -> 240
    //   276: astore_2
    //   277: aload 7
    //   279: astore_0
    //   280: ldc 29
    //   282: ldc 149
    //   284: iconst_2
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: iload_1
    //   291: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: aload_2
    //   298: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   301: aastore
    //   302: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: ldc 29
    //   307: aload_2
    //   308: ldc 143
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload 8
    //   319: ifnull +8 -> 327
    //   322: aload 8
    //   324: invokevirtual 156	android/media/MediaPlayer:release	()V
    //   327: aload_0
    //   328: ifnull +7 -> 335
    //   331: aload_0
    //   332: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
    //   335: ldc 21
    //   337: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aconst_null
    //   341: areturn
    //   342: astore_0
    //   343: ldc 29
    //   345: aload_0
    //   346: ldc 143
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: goto -20 -> 335
    //   358: astore_2
    //   359: aconst_null
    //   360: astore_0
    //   361: aload_0
    //   362: ifnull +7 -> 369
    //   365: aload_0
    //   366: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
    //   369: ldc 21
    //   371: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_2
    //   375: athrow
    //   376: astore_0
    //   377: ldc 29
    //   379: aload_0
    //   380: ldc 143
    //   382: iconst_0
    //   383: anewarray 4	java/lang/Object
    //   386: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: goto -20 -> 369
    //   392: astore_2
    //   393: goto -32 -> 361
    //   396: astore_2
    //   397: goto -36 -> 361
    //   400: astore_2
    //   401: goto -121 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramContext	android.content.Context
    //   0	404	1	paramInt	int
    //   0	404	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   0	404	3	paramOnErrorListener	MediaPlayer.OnErrorListener
    //   177	31	4	i	int
    //   186	64	5	bool1	boolean
    //   195	61	6	bool2	boolean
    //   95	183	7	localObject	Object
    //   48	275	8	localMediaPlayer	MediaPlayer
    //   43	109	9	str	String
    // Exception table:
    //   from	to	target	type
    //   236	240	260	java/io/IOException
    //   97	107	276	java/lang/Exception
    //   331	335	342	java/io/IOException
    //   97	107	358	finally
    //   365	369	376	java/io/IOException
    //   107	185	392	finally
    //   188	194	392	finally
    //   197	232	392	finally
    //   280	317	396	finally
    //   322	327	396	finally
    //   107	185	400	java/lang/Exception
    //   188	194	400	java/lang/Exception
    //   197	232	400	java/lang/Exception
  }
  
  public static MediaPlayer a(String paramString, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener, F2fRcvVoiceListener.b paramb)
  {
    AppMethodBeat.i(293524);
    final MediaPlayer localMediaPlayer = F2fRcvVoiceListener.drG();
    localMediaPlayer.setAudioStreamType(3);
    Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.setLooping(false);
      localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(63793);
          Log.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousMediaPlayer != null) {}
          try
          {
            paramAnonymousMediaPlayer.release();
            if (F2fRcvVoiceListener.a.this != null) {
              F2fRcvVoiceListener.a.this.release();
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
            Log.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), F2fRcvVoiceListener.a.this });
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
      paramb.drH();
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
        Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(293524);
        return localMediaPlayer;
        bool1 = false;
        break;
      }
      return null;
    }
    catch (Exception paramOnCompletionListener)
    {
      Log.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
      Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
      if (localMediaPlayer != null) {
        localMediaPlayer.release();
      }
      AppMethodBeat.o(293524);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.F2fRcvVoiceListener.a
 * JD-Core Version:    0.7.0.1
 */