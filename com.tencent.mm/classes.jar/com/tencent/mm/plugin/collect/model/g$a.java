package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$a
{
  /* Error */
  public static MediaPlayer a(android.content.Context paramContext, MediaPlayer.OnCompletionListener paramOnCompletionListener, MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +33 -> 39
    //   9: ldc 21
    //   11: ldc 23
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 24
    //   25: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: invokestatic 36	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: ldc 13
    //   34: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_0
    //   40: ldc 24
    //   42: invokevirtual 45	android/content/Context:getString	(I)Ljava/lang/String;
    //   45: astore 8
    //   47: new 47	android/media/MediaPlayer
    //   50: dup
    //   51: invokespecial 51	android/media/MediaPlayer:<init>	()V
    //   54: astore 7
    //   56: aload 7
    //   58: iconst_3
    //   59: invokevirtual 54	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   62: ldc 21
    //   64: ldc 56
    //   66: iconst_4
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload 7
    //   74: invokevirtual 60	java/lang/Object:hashCode	()I
    //   77: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload 8
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: aload_0
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: ldc 24
    //   94: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aconst_null
    //   102: astore 6
    //   104: aload_0
    //   105: invokevirtual 66	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   108: aload 8
    //   110: invokevirtual 72	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   113: astore_0
    //   114: aload 7
    //   116: aload_0
    //   117: invokevirtual 78	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   120: aload_0
    //   121: invokevirtual 82	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   124: aload_0
    //   125: invokevirtual 85	android/content/res/AssetFileDescriptor:getLength	()J
    //   128: invokevirtual 89	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   131: aload 7
    //   133: iconst_0
    //   134: invokevirtual 93	android/media/MediaPlayer:setLooping	(Z)V
    //   137: aload 7
    //   139: new 95	com/tencent/mm/plugin/collect/model/g$a$1
    //   142: dup
    //   143: aload 7
    //   145: aload_2
    //   146: invokespecial 98	com/tencent/mm/plugin/collect/model/g$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
    //   149: invokevirtual 102	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   152: aload 7
    //   154: new 104	com/tencent/mm/plugin/collect/model/g$a$2
    //   157: dup
    //   158: aload 8
    //   160: aload 7
    //   162: aload_1
    //   163: invokespecial 107	com/tencent/mm/plugin/collect/model/g$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   166: invokevirtual 111	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   169: aload 7
    //   171: invokevirtual 114	android/media/MediaPlayer:prepare	()V
    //   174: aload 7
    //   176: invokevirtual 117	android/media/MediaPlayer:start	()V
    //   179: aload 7
    //   181: invokevirtual 60	java/lang/Object:hashCode	()I
    //   184: istore_3
    //   185: invokestatic 123	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   188: ifnull +65 -> 253
    //   191: iconst_1
    //   192: istore 4
    //   194: invokestatic 126	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   197: ifnull +62 -> 259
    //   200: iconst_1
    //   201: istore 5
    //   203: ldc 21
    //   205: ldc 128
    //   207: iconst_3
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: iload_3
    //   214: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: iload 4
    //   222: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: iload 5
    //   230: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   233: aastore
    //   234: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   245: ldc 13
    //   247: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 7
    //   252: areturn
    //   253: iconst_0
    //   254: istore 4
    //   256: goto -62 -> 194
    //   259: iconst_0
    //   260: istore 5
    //   262: goto -59 -> 203
    //   265: astore_0
    //   266: ldc 21
    //   268: aload_0
    //   269: ldc 138
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -33 -> 245
    //   281: astore_1
    //   282: aload 6
    //   284: astore_0
    //   285: ldc 21
    //   287: ldc 144
    //   289: iconst_2
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: ldc 24
    //   297: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aload_1
    //   304: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: aastore
    //   308: invokestatic 36	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: ldc 21
    //   313: aload_1
    //   314: ldc 138
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload 7
    //   325: invokevirtual 151	android/media/MediaPlayer:release	()V
    //   328: aload_0
    //   329: ifnull +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   336: ldc 13
    //   338: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_0
    //   344: ldc 21
    //   346: aload_0
    //   347: ldc 138
    //   349: iconst_0
    //   350: anewarray 4	java/lang/Object
    //   353: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: goto -20 -> 336
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_0
    //   362: aload_0
    //   363: ifnull +7 -> 370
    //   366: aload_0
    //   367: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   370: ldc 13
    //   372: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_1
    //   376: athrow
    //   377: astore_0
    //   378: ldc 21
    //   380: aload_0
    //   381: ldc 138
    //   383: iconst_0
    //   384: anewarray 4	java/lang/Object
    //   387: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: goto -20 -> 370
    //   393: astore_1
    //   394: goto -32 -> 362
    //   397: astore_1
    //   398: goto -36 -> 362
    //   401: astore_1
    //   402: goto -117 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramContext	android.content.Context
    //   0	405	1	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   0	405	2	paramOnErrorListener	MediaPlayer.OnErrorListener
    //   184	30	3	i	int
    //   192	63	4	bool1	boolean
    //   201	60	5	bool2	boolean
    //   102	181	6	localObject	Object
    //   54	270	7	localMediaPlayer	MediaPlayer
    //   45	114	8	str	String
    // Exception table:
    //   from	to	target	type
    //   241	245	265	java/io/IOException
    //   104	114	281	java/lang/Exception
    //   332	336	343	java/io/IOException
    //   104	114	359	finally
    //   366	370	377	java/io/IOException
    //   114	191	393	finally
    //   194	200	393	finally
    //   203	237	393	finally
    //   285	328	397	finally
    //   114	191	401	java/lang/Exception
    //   194	200	401	java/lang/Exception
    //   203	237	401	java/lang/Exception
  }
  
  public static MediaPlayer a(String paramString, MediaPlayer.OnCompletionListener paramOnCompletionListener, MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    AppMethodBeat.i(40946);
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setAudioStreamType(3);
    ab.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.setLooping(false);
      localMediaPlayer.setOnErrorListener(new g.a.3(localMediaPlayer, paramOnErrorListener));
      localMediaPlayer.setOnCompletionListener(new g.a.4(paramString, localMediaPlayer, paramOnCompletionListener));
      localMediaPlayer.prepare();
      localMediaPlayer.start();
      int i = localMediaPlayer.hashCode();
      boolean bool1;
      if (Looper.myLooper() != null)
      {
        bool1 = true;
        if (Looper.getMainLooper() == null) {
          break label171;
        }
      }
      label171:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(40946);
        return localMediaPlayer;
        bool1 = false;
        break;
      }
      return null;
    }
    catch (Exception paramOnCompletionListener)
    {
      ab.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
      ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
      localMediaPlayer.release();
      AppMethodBeat.o(40946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.a
 * JD-Core Version:    0.7.0.1
 */