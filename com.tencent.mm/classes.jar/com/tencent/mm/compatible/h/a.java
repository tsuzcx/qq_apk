package com.tencent.mm.compatible.h;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.File;

public final class a
{
  /* Error */
  private static String e(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 11
    //   11: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 26	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 32	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: astore_0
    //   29: ldc 34
    //   31: ldc 36
    //   33: aload_0
    //   34: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +10 -> 57
    //   50: ldc 11
    //   52: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: ldc 59
    //   60: invokevirtual 63	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 69	android/net/Uri:getHost	()Ljava/lang/String;
    //   68: ldc 71
    //   70: ldc 73
    //   72: invokevirtual 77	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_1
    //   77: invokevirtual 80	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: ldc 59
    //   82: ldc 73
    //   84: invokevirtual 77	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 6
    //   89: new 82	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 84
    //   95: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 82	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 97
    //   115: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 73
    //   124: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 73
    //   135: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore_0
    //   149: aload_3
    //   150: aload 5
    //   152: invokevirtual 101	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: ifne +23 -> 178
    //   158: new 82	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   165: aload_3
    //   166: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 5
    //   171: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_0
    //   178: ldc 34
    //   180: ldc 106
    //   182: aload_0
    //   183: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: new 108	com/tencent/mm/vfs/e
    //   195: dup
    //   196: invokestatic 113	com/tencent/mm/loader/j/b:apK	()Ljava/lang/String;
    //   199: aload_0
    //   200: invokespecial 115	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 119	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   210: invokevirtual 123	com/tencent/mm/vfs/e:exists	()Z
    //   213: ifne +12 -> 225
    //   216: aload 5
    //   218: invokevirtual 119	com/tencent/mm/vfs/e:fxU	()Lcom/tencent/mm/vfs/e;
    //   221: invokevirtual 126	com/tencent/mm/vfs/e:mkdirs	()Z
    //   224: pop
    //   225: aload 5
    //   227: invokevirtual 123	com/tencent/mm/vfs/e:exists	()Z
    //   230: ifeq +9 -> 239
    //   233: aload 5
    //   235: invokevirtual 129	com/tencent/mm/vfs/e:delete	()Z
    //   238: pop
    //   239: aload 5
    //   241: invokevirtual 132	com/tencent/mm/vfs/e:createNewFile	()Z
    //   244: pop
    //   245: aload 5
    //   247: invokestatic 138	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   250: astore_0
    //   251: aload 4
    //   253: aload_1
    //   254: invokevirtual 142	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnonnull +18 -> 277
    //   262: aload_1
    //   263: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   266: aload_0
    //   267: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   270: ldc 11
    //   272: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aconst_null
    //   276: areturn
    //   277: aload_1
    //   278: astore 4
    //   280: aload_0
    //   281: astore_3
    //   282: sipush 1024
    //   285: newarray byte
    //   287: astore 6
    //   289: aload_1
    //   290: astore 4
    //   292: aload_0
    //   293: astore_3
    //   294: aload_1
    //   295: aload 6
    //   297: invokevirtual 154	java/io/InputStream:read	([B)I
    //   300: istore_2
    //   301: iload_2
    //   302: ifle +54 -> 356
    //   305: aload_1
    //   306: astore 4
    //   308: aload_0
    //   309: astore_3
    //   310: aload_0
    //   311: aload 6
    //   313: iconst_0
    //   314: iload_2
    //   315: invokevirtual 160	java/io/OutputStream:write	([BII)V
    //   318: goto -29 -> 289
    //   321: astore 5
    //   323: aload_1
    //   324: astore 4
    //   326: aload_0
    //   327: astore_3
    //   328: ldc 34
    //   330: aload 5
    //   332: ldc 162
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_1
    //   342: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   345: aload_0
    //   346: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   349: ldc 11
    //   351: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: aload_1
    //   357: astore 4
    //   359: aload_0
    //   360: astore_3
    //   361: aload 5
    //   363: invokevirtual 170	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   366: invokestatic 175	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   369: astore 5
    //   371: aload_1
    //   372: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   375: aload_0
    //   376: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   379: ldc 11
    //   381: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload 5
    //   386: areturn
    //   387: astore_1
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_0
    //   393: aload 4
    //   395: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   398: aload_0
    //   399: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   402: ldc 11
    //   404: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload_1
    //   408: athrow
    //   409: astore_1
    //   410: aconst_null
    //   411: astore 4
    //   413: goto -20 -> 393
    //   416: astore_1
    //   417: aload_3
    //   418: astore_0
    //   419: goto -26 -> 393
    //   422: astore 5
    //   424: aconst_null
    //   425: astore_1
    //   426: aconst_null
    //   427: astore_0
    //   428: goto -105 -> 323
    //   431: astore 5
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -112 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramContext	Context
    //   0	438	1	paramUri	Uri
    //   300	15	2	i	int
    //   75	343	3	localObject1	Object
    //   20	392	4	localObject2	Object
    //   107	139	5	localObject3	Object
    //   321	41	5	localException1	Exception
    //   369	16	5	str	String
    //   422	1	5	localException2	Exception
    //   431	1	5	localException3	Exception
    //   87	225	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   282	289	321	java/lang/Exception
    //   294	301	321	java/lang/Exception
    //   310	318	321	java/lang/Exception
    //   361	371	321	java/lang/Exception
    //   239	251	387	finally
    //   251	258	409	finally
    //   282	289	416	finally
    //   294	301	416	finally
    //   310	318	416	finally
    //   328	341	416	finally
    //   361	371	416	finally
    //   239	251	422	java/lang/Exception
    //   251	258	431	java/lang/Exception
  }
  
  @TargetApi(5)
  public static String i(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(155916);
    if ((paramIntent == null) || (paramIntent.getData() == null))
    {
      ac.e("MicroMsg.GetVideoMetadata", "input invalid");
      AppMethodBeat.o(155916);
      return null;
    }
    long l = bs.Gn();
    String str = paramIntent.getDataString();
    ac.i("MicroMsg.GetVideoMetadata", "get video file name, dataString ".concat(String.valueOf(str)));
    if (str == null)
    {
      ac.e("MicroMsg.GetVideoMetadata", "dataString empty");
      AppMethodBeat.o(155916);
      return null;
    }
    Object localObject3 = paramContext.getContentResolver();
    Object localObject2;
    Object localObject1;
    if (str.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString()))
    {
      localObject2 = ((ContentResolver)localObject3).query(paramIntent.getData(), null, null, null, null);
      localObject1 = null;
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((Cursor)localObject2).getCount() > 0)
        {
          ((Cursor)localObject2).moveToFirst();
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndexOrThrow("_data"));
          }
        }
        ((Cursor)localObject2).close();
      }
      ac.i("MicroMsg.GetVideoMetadata", "get video filename:" + (String)localObject3 + ", cost time: " + bs.aO(l));
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new e((String)localObject3).exists()))
      {
        AppMethodBeat.o(155916);
        return localObject3;
      }
    }
    else if (str.startsWith("content://"))
    {
      localObject1 = bs.j(paramContext, paramIntent.getData());
    }
    for (;;)
    {
      label262:
      if (localObject1 != null) {
        if (((String)localObject1).startsWith("/storage/emulated/legacy"))
        {
          localObject1 = g.getExternalStorageDirectory().getAbsolutePath() + ((String)localObject1).substring(24);
          label309:
          localObject2 = "_data LIKE " + DatabaseUtils.sqlEscapeString((String)localObject1);
          localObject2 = ((ContentResolver)localObject3).query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, (String)localObject2, null, null);
          break;
          if (!str.startsWith("file://")) {
            break label503;
          }
          if (paramIntent.getExtras() == null) {
            break label497;
          }
          localObject1 = (Uri)paramIntent.getExtras().getParcelable("android.intent.extra.STREAM");
          if ((localObject1 == null) || (bs.isNullOrNil(((Uri)localObject1).getPath()))) {
            break label497;
          }
        }
      }
      label497:
      for (localObject2 = ((Uri)localObject1).getPath();; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label262;
        }
        localObject1 = str.substring(7);
        break label262;
        if (((String)localObject1).startsWith("/sdcard"))
        {
          localObject1 = g.getExternalStorageDirectory().getAbsolutePath() + ((String)localObject1).substring(7);
          break label309;
          paramContext = e(paramContext, paramIntent.getData());
          AppMethodBeat.o(155916);
          return paramContext;
        }
        break label309;
        localObject2 = null;
        break;
      }
      label503:
      localObject1 = null;
    }
  }
  
  /* Error */
  @TargetApi(5)
  public static a.a j(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 301
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 186	android/content/Intent:getData	()Landroid/net/Uri;
    //   14: ifnonnull +18 -> 32
    //   17: ldc 34
    //   19: ldc 188
    //   21: invokestatic 190	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc_w 301
    //   27: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: invokestatic 194	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   35: lstore 4
    //   37: aload_1
    //   38: invokevirtual 197	android/content/Intent:getDataString	()Ljava/lang/String;
    //   41: astore 8
    //   43: ldc 34
    //   45: ldc_w 303
    //   48: aload 8
    //   50: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokevirtual 46	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 8
    //   61: ifnonnull +18 -> 79
    //   64: ldc 34
    //   66: ldc 201
    //   68: invokestatic 190	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: ldc_w 301
    //   74: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: aload_0
    //   80: invokevirtual 26	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   83: astore 13
    //   85: new 6	com/tencent/mm/compatible/h/a$a
    //   88: dup
    //   89: invokespecial 304	com/tencent/mm/compatible/h/a$a:<init>	()V
    //   92: astore 12
    //   94: aload 8
    //   96: getstatic 207	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   99: invokevirtual 208	android/net/Uri:toString	()Ljava/lang/String;
    //   102: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   105: ifeq +435 -> 540
    //   108: aload 13
    //   110: aload_1
    //   111: invokevirtual 186	android/content/Intent:getData	()Landroid/net/Uri;
    //   114: aconst_null
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: invokevirtual 215	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore 8
    //   123: ldc_w 305
    //   126: istore_2
    //   127: iload_2
    //   128: istore_3
    //   129: aload 8
    //   131: ifnull +198 -> 329
    //   134: aload 8
    //   136: invokeinterface 221 1 0
    //   141: ifle +179 -> 320
    //   144: aload 8
    //   146: invokeinterface 224 1 0
    //   151: pop
    //   152: aload 8
    //   154: aload 8
    //   156: ldc_w 307
    //   159: invokeinterface 230 2 0
    //   164: invokeinterface 311 2 0
    //   169: istore_3
    //   170: aload 12
    //   172: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   175: ifnonnull +24 -> 199
    //   178: aload 12
    //   180: aload 8
    //   182: aload 8
    //   184: ldc 226
    //   186: invokeinterface 230 2 0
    //   191: invokeinterface 234 2 0
    //   196: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   199: aload 12
    //   201: aload 8
    //   203: aload 8
    //   205: ldc_w 317
    //   208: invokeinterface 230 2 0
    //   213: invokeinterface 311 2 0
    //   218: putfield 320	com/tencent/mm/compatible/h/a$a:duration	I
    //   221: aload 12
    //   223: getfield 320	com/tencent/mm/compatible/h/a$a:duration	I
    //   226: ifne +86 -> 312
    //   229: aconst_null
    //   230: astore 11
    //   232: aconst_null
    //   233: astore 10
    //   235: aload 10
    //   237: astore 9
    //   239: aload 11
    //   241: astore_1
    //   242: ldc 34
    //   244: ldc_w 322
    //   247: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 10
    //   252: astore 9
    //   254: aload 11
    //   256: astore_1
    //   257: aload_0
    //   258: aload 12
    //   260: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   263: invokestatic 326	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   266: invokestatic 331	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   269: astore 10
    //   271: aload 10
    //   273: ifnull +547 -> 820
    //   276: aload 10
    //   278: astore 9
    //   280: aload 10
    //   282: astore_1
    //   283: aload 10
    //   285: invokevirtual 336	android/media/MediaPlayer:getDuration	()I
    //   288: istore_2
    //   289: aload 10
    //   291: astore 9
    //   293: aload 10
    //   295: astore_1
    //   296: aload 12
    //   298: iload_2
    //   299: putfield 320	com/tencent/mm/compatible/h/a$a:duration	I
    //   302: aload 10
    //   304: ifnull +8 -> 312
    //   307: aload 10
    //   309: invokevirtual 339	android/media/MediaPlayer:release	()V
    //   312: aload 12
    //   314: aconst_null
    //   315: putfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   318: iload_3
    //   319: istore_2
    //   320: aload 8
    //   322: invokeinterface 237 1 0
    //   327: iload_2
    //   328: istore_3
    //   329: iload_3
    //   330: ldc_w 305
    //   333: if_icmpeq +29 -> 362
    //   336: iload_3
    //   337: i2l
    //   338: lstore 6
    //   340: aload 12
    //   342: aload 13
    //   344: lload 6
    //   346: iconst_1
    //   347: aconst_null
    //   348: invokestatic 349	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   351: putfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   354: ldc 34
    //   356: ldc_w 351
    //   359: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload 12
    //   364: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   367: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   370: ifne +111 -> 481
    //   373: aload 12
    //   375: getfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   378: ifnonnull +103 -> 481
    //   381: ldc 34
    //   383: ldc_w 353
    //   386: invokestatic 51	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 12
    //   391: aload 12
    //   393: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   396: invokestatic 357	com/tencent/mm/compatible/h/a:sH	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   399: putfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   402: aload 12
    //   404: getfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   407: ifnull +14 -> 421
    //   410: aload 12
    //   412: getfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   415: invokestatic 361	com/tencent/mm/compatible/h/a:u	(Landroid/graphics/Bitmap;)Z
    //   418: ifeq +17 -> 435
    //   421: aload 12
    //   423: aload 12
    //   425: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   428: iconst_1
    //   429: invokestatic 367	com/tencent/mm/sdk/platformtools/f:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   432: putfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   435: aload 12
    //   437: getfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   440: ifnonnull +41 -> 481
    //   443: aload_0
    //   444: new 183	android/content/Intent
    //   447: dup
    //   448: ldc_w 369
    //   451: new 82	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 279
    //   458: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: aload 12
    //   463: getfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   466: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 326	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   475: invokespecial 375	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   478: invokevirtual 379	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   481: ldc 34
    //   483: ldc_w 381
    //   486: iconst_3
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: lload 4
    //   494: invokestatic 245	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   497: invokestatic 386	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   500: aastore
    //   501: dup
    //   502: iconst_1
    //   503: aload 12
    //   505: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   508: aastore
    //   509: dup
    //   510: iconst_2
    //   511: aload 12
    //   513: getfield 320	com/tencent/mm/compatible/h/a$a:duration	I
    //   516: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: invokestatic 394	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: aload 12
    //   525: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   528: ifnull +377 -> 905
    //   531: ldc_w 301
    //   534: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: aload 12
    //   539: areturn
    //   540: aload 8
    //   542: ldc 251
    //   544: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   547: ifeq +141 -> 688
    //   550: aload 12
    //   552: aload_0
    //   553: aload_1
    //   554: invokevirtual 186	android/content/Intent:getData	()Landroid/net/Uri;
    //   557: invokestatic 254	com/tencent/mm/sdk/platformtools/bs:j	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   560: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   563: aload 12
    //   565: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   568: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   571: ifeq +16 -> 587
    //   574: aload 12
    //   576: aload_0
    //   577: aload_1
    //   578: invokevirtual 186	android/content/Intent:getData	()Landroid/net/Uri;
    //   581: invokestatic 298	com/tencent/mm/compatible/h/a:e	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   584: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   587: aload 12
    //   589: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   592: ifnull +321 -> 913
    //   595: aload 12
    //   597: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   600: ldc_w 256
    //   603: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   606: ifeq +160 -> 766
    //   609: aload 12
    //   611: new 82	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   618: invokestatic 262	com/tencent/mm/compatible/util/g:getExternalStorageDirectory	()Ljava/io/File;
    //   621: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   624: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 12
    //   629: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   632: bipush 24
    //   634: invokevirtual 270	java/lang/String:substring	(I)Ljava/lang/String;
    //   637: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   646: new 82	java/lang/StringBuilder
    //   649: dup
    //   650: ldc_w 272
    //   653: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   656: aload 12
    //   658: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   661: invokestatic 277	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   664: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: astore_1
    //   671: aload 13
    //   673: getstatic 207	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   676: aconst_null
    //   677: aload_1
    //   678: aconst_null
    //   679: aconst_null
    //   680: invokevirtual 215	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   683: astore 8
    //   685: goto -562 -> 123
    //   688: aload 8
    //   690: ldc_w 279
    //   693: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   696: ifeq -109 -> 587
    //   699: aload_1
    //   700: invokevirtual 283	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   703: ifnull +40 -> 743
    //   706: aload_1
    //   707: invokevirtual 283	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   710: ldc_w 285
    //   713: invokevirtual 291	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   716: checkcast 65	android/net/Uri
    //   719: astore_1
    //   720: aload_1
    //   721: ifnull +22 -> 743
    //   724: aload_1
    //   725: invokevirtual 80	android/net/Uri:getPath	()Ljava/lang/String;
    //   728: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   731: ifne +12 -> 743
    //   734: aload 12
    //   736: aload_1
    //   737: invokevirtual 80	android/net/Uri:getPath	()Ljava/lang/String;
    //   740: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   743: aload 12
    //   745: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   748: ifnonnull -161 -> 587
    //   751: aload 12
    //   753: aload 8
    //   755: bipush 7
    //   757: invokevirtual 270	java/lang/String:substring	(I)Ljava/lang/String;
    //   760: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   763: goto -176 -> 587
    //   766: aload 12
    //   768: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   771: ldc_w 296
    //   774: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   777: ifeq -131 -> 646
    //   780: aload 12
    //   782: new 82	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   789: invokestatic 262	com/tencent/mm/compatible/util/g:getExternalStorageDirectory	()Ljava/io/File;
    //   792: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   795: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 12
    //   800: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   803: bipush 7
    //   805: invokevirtual 270	java/lang/String:substring	(I)Ljava/lang/String;
    //   808: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: putfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   817: goto -171 -> 646
    //   820: iconst_0
    //   821: istore_2
    //   822: goto -533 -> 289
    //   825: astore 10
    //   827: aload 9
    //   829: astore_1
    //   830: ldc 34
    //   832: aload 10
    //   834: ldc_w 396
    //   837: iconst_1
    //   838: anewarray 4	java/lang/Object
    //   841: dup
    //   842: iconst_0
    //   843: aload 12
    //   845: getfield 315	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
    //   848: aastore
    //   849: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   852: aload 9
    //   854: ifnull -542 -> 312
    //   857: aload 9
    //   859: invokevirtual 339	android/media/MediaPlayer:release	()V
    //   862: goto -550 -> 312
    //   865: astore_0
    //   866: aload_1
    //   867: ifnull +7 -> 874
    //   870: aload_1
    //   871: invokevirtual 339	android/media/MediaPlayer:release	()V
    //   874: ldc_w 301
    //   877: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   880: aload_0
    //   881: athrow
    //   882: astore_1
    //   883: ldc 34
    //   885: aload_1
    //   886: ldc_w 398
    //   889: iconst_0
    //   890: anewarray 4	java/lang/Object
    //   893: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   896: aload 12
    //   898: aconst_null
    //   899: putfield 343	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   902: goto -540 -> 362
    //   905: ldc_w 301
    //   908: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   911: aconst_null
    //   912: areturn
    //   913: aconst_null
    //   914: astore 8
    //   916: goto -793 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	919	0	paramContext	Context
    //   0	919	1	paramIntent	Intent
    //   126	696	2	i	int
    //   128	209	3	j	int
    //   35	458	4	l1	long
    //   338	7	6	l2	long
    //   41	874	8	localObject1	Object
    //   237	621	9	localk1	com.tencent.mm.compatible.b.k
    //   233	75	10	localk2	com.tencent.mm.compatible.b.k
    //   825	8	10	localException	Exception
    //   230	25	11	localObject2	Object
    //   92	805	12	locala	a.a
    //   83	589	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   242	250	825	java/lang/Exception
    //   257	271	825	java/lang/Exception
    //   283	289	825	java/lang/Exception
    //   296	302	825	java/lang/Exception
    //   242	250	865	finally
    //   257	271	865	finally
    //   283	289	865	finally
    //   296	302	865	finally
    //   830	852	865	finally
    //   340	362	882	java/lang/Exception
  }
  
  private static Bitmap sH(String paramString)
  {
    AppMethodBeat.i(155918);
    if ((bs.isNullOrNil(paramString)) || (!i.eA(paramString)))
    {
      ac.e("MicroMsg.GetVideoMetadata", "getVideoThumb, %s not exist!!", new Object[] { paramString });
      AppMethodBeat.o(155918);
      return null;
    }
    long l = bs.Gn();
    ac.i("MicroMsg.GetVideoMetadata", "getVideoThumb, %s", new Object[] { paramString });
    try
    {
      d locald = new d();
      locald.setDataSource(paramString);
      int i = bs.getInt(locald.extractMetadata(18), -1);
      int j = bs.getInt(locald.extractMetadata(19), -1);
      paramString = locald.getFrameAtTime(0L, 2);
      locald.release();
      ac.i("MicroMsg.GetVideoMetadata", "getVideoThumb, width: %s, height: %s, cost:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bs.aO(l)) });
      if (paramString != null)
      {
        AppMethodBeat.o(155918);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.GetVideoMetadata", paramString, "get video thumb error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(155918);
    }
    return null;
  }
  
  private static boolean u(Bitmap paramBitmap)
  {
    AppMethodBeat.i(155919);
    if (paramBitmap != null)
    {
      long l2 = bs.Gn();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, 20, 20, true);
      int[] arrayOfInt = new int[400];
      paramBitmap.getPixels(arrayOfInt, 0, 20, 0, 0, 20, 20);
      long l1 = 0L;
      int i = 0;
      while (i < 400)
      {
        l1 += Color.blue(arrayOfInt[i]);
        i += 1;
      }
      l1 = ((float)l1 / 400.0F);
      ac.i("MicroMsg.GetVideoMetadata", "isBitmapDark, avg bitmap avgColor:%s, cost:%s", new Object[] { Long.valueOf(l1), Long.valueOf(bs.aO(l2)) });
      if (l1 <= 10L)
      {
        AppMethodBeat.o(155919);
        return true;
      }
      AppMethodBeat.o(155919);
      return false;
    }
    AppMethodBeat.o(155919);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.h.a
 * JD-Core Version:    0.7.0.1
 */