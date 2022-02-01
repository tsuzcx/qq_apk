package com.tencent.mm.compatible.i;

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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class a
{
  private static Bitmap Lb(String paramString)
  {
    AppMethodBeat.i(155918);
    if ((Util.isNullOrNil(paramString)) || (!u.agG(paramString)))
    {
      Log.e("MicroMsg.GetVideoMetadata", "getVideoThumb, %s not exist!!", new Object[] { paramString });
      AppMethodBeat.o(155918);
      return null;
    }
    long l = Util.currentTicks();
    Log.i("MicroMsg.GetVideoMetadata", "getVideoThumb, %s", new Object[] { paramString });
    try
    {
      d locald = new d();
      locald.setDataSource(paramString);
      int i = Util.getInt(locald.extractMetadata(18), -1);
      int j = Util.getInt(locald.extractMetadata(19), -1);
      paramString = locald.getFrameAtTime(0L, 2);
      locald.release();
      Log.i("MicroMsg.GetVideoMetadata", "getVideoThumb, width: %s, height: %s, cost:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)) });
      if (paramString != null)
      {
        AppMethodBeat.o(155918);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.GetVideoMetadata", paramString, "get video thumb error! %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(155918);
    }
    return null;
  }
  
  /* Error */
  private static String e(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 106
    //   11: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 112	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 118	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: astore_0
    //   29: ldc 30
    //   31: ldc 120
    //   33: aload_0
    //   34: invokestatic 125	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 129	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +10 -> 57
    //   50: ldc 106
    //   52: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: ldc 140
    //   60: invokevirtual 144	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 149	android/net/Uri:getHost	()Ljava/lang/String;
    //   68: ldc 151
    //   70: ldc 153
    //   72: invokevirtual 157	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_1
    //   77: invokevirtual 160	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: ldc 140
    //   82: ldc 153
    //   84: invokevirtual 157	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 6
    //   89: new 162	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 164
    //   95: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 162	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 175
    //   115: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 153
    //   124: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 153
    //   135: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore_0
    //   149: aload_3
    //   150: aload 5
    //   152: invokevirtual 178	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: ifne +23 -> 178
    //   158: new 162	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   165: aload_3
    //   166: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 5
    //   171: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_0
    //   178: ldc 30
    //   180: ldc 181
    //   182: aload_0
    //   183: invokestatic 125	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 129	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: new 183	com/tencent/mm/vfs/q
    //   195: dup
    //   196: invokestatic 188	com/tencent/mm/loader/j/b:aTp	()Ljava/lang/String;
    //   199: aload_0
    //   200: invokespecial 190	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 194	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   210: invokevirtual 198	com/tencent/mm/vfs/q:ifE	()Z
    //   213: ifne +12 -> 225
    //   216: aload 5
    //   218: invokevirtual 194	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   221: invokevirtual 201	com/tencent/mm/vfs/q:ifL	()Z
    //   224: pop
    //   225: aload 5
    //   227: invokevirtual 198	com/tencent/mm/vfs/q:ifE	()Z
    //   230: ifeq +9 -> 239
    //   233: aload 5
    //   235: invokevirtual 204	com/tencent/mm/vfs/q:cFq	()Z
    //   238: pop
    //   239: aload 5
    //   241: invokevirtual 207	com/tencent/mm/vfs/q:ifM	()Z
    //   244: pop
    //   245: aload 5
    //   247: invokestatic 211	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   250: astore_0
    //   251: aload 4
    //   253: aload_1
    //   254: invokevirtual 215	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnonnull +18 -> 277
    //   262: aload_1
    //   263: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   266: aload_0
    //   267: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: ldc 106
    //   272: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   297: invokevirtual 225	java/io/InputStream:read	([B)I
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
    //   315: invokevirtual 231	java/io/OutputStream:write	([BII)V
    //   318: goto -29 -> 289
    //   321: astore 5
    //   323: aload_1
    //   324: astore 4
    //   326: aload_0
    //   327: astore_3
    //   328: ldc 30
    //   330: aload 5
    //   332: ldc 233
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_1
    //   342: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   345: aload_0
    //   346: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   349: ldc 106
    //   351: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: aload_1
    //   357: astore 4
    //   359: aload_0
    //   360: astore_3
    //   361: aload 5
    //   363: invokevirtual 236	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   366: astore 5
    //   368: aload_1
    //   369: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   372: aload_0
    //   373: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   376: ldc 106
    //   378: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload 5
    //   383: areturn
    //   384: astore_1
    //   385: aconst_null
    //   386: astore 4
    //   388: aconst_null
    //   389: astore_0
    //   390: aload 4
    //   392: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   395: aload_0
    //   396: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   399: ldc 106
    //   401: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload_1
    //   405: athrow
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 4
    //   410: goto -20 -> 390
    //   413: astore_1
    //   414: aload_3
    //   415: astore_0
    //   416: goto -26 -> 390
    //   419: astore 5
    //   421: aconst_null
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_0
    //   425: goto -102 -> 323
    //   428: astore 5
    //   430: aconst_null
    //   431: astore_1
    //   432: goto -109 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramContext	Context
    //   0	435	1	paramUri	Uri
    //   300	15	2	i	int
    //   75	340	3	localObject1	Object
    //   20	389	4	localObject2	Object
    //   107	139	5	localObject3	Object
    //   321	41	5	localException1	Exception
    //   366	16	5	str	String
    //   419	1	5	localException2	Exception
    //   428	1	5	localException3	Exception
    //   87	225	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   282	289	321	java/lang/Exception
    //   294	301	321	java/lang/Exception
    //   310	318	321	java/lang/Exception
    //   361	368	321	java/lang/Exception
    //   239	251	384	finally
    //   251	258	406	finally
    //   282	289	413	finally
    //   294	301	413	finally
    //   310	318	413	finally
    //   328	341	413	finally
    //   361	368	413	finally
    //   239	251	419	java/lang/Exception
    //   251	258	428	java/lang/Exception
  }
  
  @TargetApi(5)
  public static String i(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(155916);
    if ((paramIntent == null) || (paramIntent.getData() == null))
    {
      Log.e("MicroMsg.GetVideoMetadata", "input invalid");
      AppMethodBeat.o(155916);
      return null;
    }
    long l = Util.currentTicks();
    String str = paramIntent.getDataString();
    Log.i("MicroMsg.GetVideoMetadata", "get video file name, dataString ".concat(String.valueOf(str)));
    if (str == null)
    {
      Log.e("MicroMsg.GetVideoMetadata", "dataString empty");
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
      Log.i("MicroMsg.GetVideoMetadata", "get video filename:" + (String)localObject3 + ", cost time: " + Util.ticksToNow(l));
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new q((String)localObject3).ifE()))
      {
        AppMethodBeat.o(155916);
        return localObject3;
      }
    }
    else if (str.startsWith("content://"))
    {
      localObject1 = Util.getFilePath(paramContext, paramIntent.getData());
    }
    for (;;)
    {
      label268:
      if (localObject1 != null) {
        if (((String)localObject1).startsWith("/storage/emulated/legacy"))
        {
          localObject1 = g.avF().getAbsolutePath() + ((String)localObject1).substring(24);
          label315:
          localObject2 = "_data LIKE " + DatabaseUtils.sqlEscapeString((String)localObject1);
          localObject2 = ((ContentResolver)localObject3).query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, (String)localObject2, null, null);
          break;
          if (!str.startsWith("file://")) {
            break label509;
          }
          if (paramIntent.getExtras() == null) {
            break label503;
          }
          localObject1 = (Uri)paramIntent.getExtras().getParcelable("android.intent.extra.STREAM");
          if ((localObject1 == null) || (Util.isNullOrNil(((Uri)localObject1).getPath()))) {
            break label503;
          }
        }
      }
      label503:
      for (localObject2 = ((Uri)localObject1).getPath();; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label268;
        }
        localObject1 = str.substring(7);
        break label268;
        if (((String)localObject1).startsWith("/sdcard"))
        {
          localObject1 = g.avF().getAbsolutePath() + ((String)localObject1).substring(7);
          break label315;
          paramContext = e(paramContext, paramIntent.getData());
          AppMethodBeat.o(155916);
          return paramContext;
        }
        break label315;
        localObject2 = null;
        break;
      }
      label509:
      localObject1 = null;
    }
  }
  
  /* Error */
  @TargetApi(5)
  public static a.a j(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 247	android/content/Intent:getData	()Landroid/net/Uri;
    //   14: ifnonnull +18 -> 32
    //   17: ldc 30
    //   19: ldc 249
    //   21: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc_w 351
    //   27: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: invokestatic 45	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   35: lstore 4
    //   37: aload_1
    //   38: invokevirtual 254	android/content/Intent:getDataString	()Ljava/lang/String;
    //   41: astore 8
    //   43: ldc 30
    //   45: ldc_w 353
    //   48: aload 8
    //   50: invokestatic 125	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokevirtual 129	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 8
    //   61: ifnonnull +19 -> 80
    //   64: ldc 30
    //   66: ldc_w 258
    //   69: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 351
    //   75: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: invokevirtual 112	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   84: astore 13
    //   86: new 6	com/tencent/mm/compatible/i/a$a
    //   89: dup
    //   90: invokespecial 354	com/tencent/mm/compatible/i/a$a:<init>	()V
    //   93: astore 12
    //   95: aload 8
    //   97: getstatic 264	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   100: invokevirtual 265	android/net/Uri:toString	()Ljava/lang/String;
    //   103: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   106: ifeq +436 -> 542
    //   109: aload 13
    //   111: aload_1
    //   112: invokevirtual 247	android/content/Intent:getData	()Landroid/net/Uri;
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   122: astore 8
    //   124: ldc_w 355
    //   127: istore_2
    //   128: iload_2
    //   129: istore_3
    //   130: aload 8
    //   132: ifnull +199 -> 331
    //   135: aload 8
    //   137: invokeinterface 278 1 0
    //   142: ifle +180 -> 322
    //   145: aload 8
    //   147: invokeinterface 281 1 0
    //   152: pop
    //   153: aload 8
    //   155: aload 8
    //   157: ldc_w 357
    //   160: invokeinterface 287 2 0
    //   165: invokeinterface 360 2 0
    //   170: istore_3
    //   171: aload 12
    //   173: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   176: ifnonnull +25 -> 201
    //   179: aload 12
    //   181: aload 8
    //   183: aload 8
    //   185: ldc_w 283
    //   188: invokeinterface 287 2 0
    //   193: invokeinterface 290 2 0
    //   198: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   201: aload 12
    //   203: aload 8
    //   205: aload 8
    //   207: ldc_w 366
    //   210: invokeinterface 287 2 0
    //   215: invokeinterface 360 2 0
    //   220: putfield 369	com/tencent/mm/compatible/i/a$a:duration	I
    //   223: aload 12
    //   225: getfield 369	com/tencent/mm/compatible/i/a$a:duration	I
    //   228: ifne +86 -> 314
    //   231: aconst_null
    //   232: astore 11
    //   234: aconst_null
    //   235: astore 10
    //   237: aload 10
    //   239: astore 9
    //   241: aload 11
    //   243: astore_1
    //   244: ldc 30
    //   246: ldc_w 371
    //   249: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 10
    //   254: astore 9
    //   256: aload 11
    //   258: astore_1
    //   259: aload_0
    //   260: aload 12
    //   262: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   265: invokestatic 375	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   268: invokestatic 381	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   271: astore 10
    //   273: aload 10
    //   275: ifnull +548 -> 823
    //   278: aload 10
    //   280: astore 9
    //   282: aload 10
    //   284: astore_1
    //   285: aload 10
    //   287: invokevirtual 386	android/media/MediaPlayer:getDuration	()I
    //   290: istore_2
    //   291: aload 10
    //   293: astore 9
    //   295: aload 10
    //   297: astore_1
    //   298: aload 12
    //   300: iload_2
    //   301: putfield 369	com/tencent/mm/compatible/i/a$a:duration	I
    //   304: aload 10
    //   306: ifnull +8 -> 314
    //   309: aload 10
    //   311: invokevirtual 387	android/media/MediaPlayer:release	()V
    //   314: aload 12
    //   316: aconst_null
    //   317: putfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   320: iload_3
    //   321: istore_2
    //   322: aload 8
    //   324: invokeinterface 293 1 0
    //   329: iload_2
    //   330: istore_3
    //   331: iload_3
    //   332: ldc_w 355
    //   335: if_icmpeq +29 -> 364
    //   338: iload_3
    //   339: i2l
    //   340: lstore 6
    //   342: aload 12
    //   344: aload 13
    //   346: lload 6
    //   348: iconst_1
    //   349: aconst_null
    //   350: invokestatic 397	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   353: putfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   356: ldc 30
    //   358: ldc_w 399
    //   361: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 12
    //   366: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   369: invokestatic 23	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   372: ifne +111 -> 483
    //   375: aload 12
    //   377: getfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   380: ifnonnull +103 -> 483
    //   383: ldc 30
    //   385: ldc_w 401
    //   388: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload 12
    //   393: aload 12
    //   395: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   398: invokestatic 403	com/tencent/mm/compatible/i/a:Lb	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   401: putfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   404: aload 12
    //   406: getfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   409: ifnull +14 -> 423
    //   412: aload 12
    //   414: getfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   417: invokestatic 407	com/tencent/mm/compatible/i/a:q	(Landroid/graphics/Bitmap;)Z
    //   420: ifeq +17 -> 437
    //   423: aload 12
    //   425: aload 12
    //   427: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   430: iconst_1
    //   431: invokestatic 413	com/tencent/mm/sdk/platformtools/BitmapUtil:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   434: putfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   437: aload 12
    //   439: getfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   442: ifnonnull +41 -> 483
    //   445: aload_0
    //   446: new 243	android/content/Intent
    //   449: dup
    //   450: ldc_w 415
    //   453: new 162	java/lang/StringBuilder
    //   456: dup
    //   457: ldc_w 331
    //   460: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   463: aload 12
    //   465: getfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   468: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 375	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   477: invokespecial 421	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   480: invokevirtual 425	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   483: ldc 30
    //   485: ldc_w 427
    //   488: iconst_3
    //   489: anewarray 4	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: lload 4
    //   496: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   499: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   502: aastore
    //   503: dup
    //   504: iconst_1
    //   505: aload 12
    //   507: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   510: aastore
    //   511: dup
    //   512: iconst_2
    //   513: aload 12
    //   515: getfield 369	com/tencent/mm/compatible/i/a$a:duration	I
    //   518: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: aastore
    //   522: invokestatic 49	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: aload 12
    //   527: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   530: ifnull +378 -> 908
    //   533: ldc_w 351
    //   536: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload 12
    //   541: areturn
    //   542: aload 8
    //   544: ldc_w 303
    //   547: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   550: ifeq +141 -> 691
    //   553: aload 12
    //   555: aload_0
    //   556: aload_1
    //   557: invokevirtual 247	android/content/Intent:getData	()Landroid/net/Uri;
    //   560: invokestatic 306	com/tencent/mm/sdk/platformtools/Util:getFilePath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   563: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   566: aload 12
    //   568: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   571: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   574: ifeq +16 -> 590
    //   577: aload 12
    //   579: aload_0
    //   580: aload_1
    //   581: invokevirtual 247	android/content/Intent:getData	()Landroid/net/Uri;
    //   584: invokestatic 347	com/tencent/mm/compatible/i/a:e	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   587: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   590: aload 12
    //   592: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   595: ifnull +321 -> 916
    //   598: aload 12
    //   600: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   603: ldc_w 308
    //   606: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   609: ifeq +160 -> 769
    //   612: aload 12
    //   614: new 162	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   621: invokestatic 314	com/tencent/mm/compatible/util/g:avF	()Ljava/io/File;
    //   624: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   627: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 12
    //   632: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   635: bipush 24
    //   637: invokevirtual 322	java/lang/String:substring	(I)Ljava/lang/String;
    //   640: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   649: new 162	java/lang/StringBuilder
    //   652: dup
    //   653: ldc_w 324
    //   656: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   659: aload 12
    //   661: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   664: invokestatic 329	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   667: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: astore_1
    //   674: aload 13
    //   676: getstatic 264	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   679: aconst_null
    //   680: aload_1
    //   681: aconst_null
    //   682: aconst_null
    //   683: invokevirtual 272	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   686: astore 8
    //   688: goto -564 -> 124
    //   691: aload 8
    //   693: ldc_w 331
    //   696: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   699: ifeq -109 -> 590
    //   702: aload_1
    //   703: invokevirtual 335	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   706: ifnull +40 -> 746
    //   709: aload_1
    //   710: invokevirtual 335	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   713: ldc_w 337
    //   716: invokevirtual 343	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   719: checkcast 146	android/net/Uri
    //   722: astore_1
    //   723: aload_1
    //   724: ifnull +22 -> 746
    //   727: aload_1
    //   728: invokevirtual 160	android/net/Uri:getPath	()Ljava/lang/String;
    //   731: invokestatic 23	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   734: ifne +12 -> 746
    //   737: aload 12
    //   739: aload_1
    //   740: invokevirtual 160	android/net/Uri:getPath	()Ljava/lang/String;
    //   743: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   746: aload 12
    //   748: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   751: ifnonnull -161 -> 590
    //   754: aload 12
    //   756: aload 8
    //   758: bipush 7
    //   760: invokevirtual 322	java/lang/String:substring	(I)Ljava/lang/String;
    //   763: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   766: goto -176 -> 590
    //   769: aload 12
    //   771: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   774: ldc_w 345
    //   777: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   780: ifeq -131 -> 649
    //   783: aload 12
    //   785: new 162	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   792: invokestatic 314	com/tencent/mm/compatible/util/g:avF	()Ljava/io/File;
    //   795: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   798: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 12
    //   803: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   806: bipush 7
    //   808: invokevirtual 322	java/lang/String:substring	(I)Ljava/lang/String;
    //   811: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: putfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   820: goto -171 -> 649
    //   823: iconst_0
    //   824: istore_2
    //   825: goto -534 -> 291
    //   828: astore 10
    //   830: aload 9
    //   832: astore_1
    //   833: ldc 30
    //   835: aload 10
    //   837: ldc_w 429
    //   840: iconst_1
    //   841: anewarray 4	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: aload 12
    //   848: getfield 364	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   851: aastore
    //   852: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   855: aload 9
    //   857: ifnull -543 -> 314
    //   860: aload 9
    //   862: invokevirtual 387	android/media/MediaPlayer:release	()V
    //   865: goto -551 -> 314
    //   868: astore_0
    //   869: aload_1
    //   870: ifnull +7 -> 877
    //   873: aload_1
    //   874: invokevirtual 387	android/media/MediaPlayer:release	()V
    //   877: ldc_w 351
    //   880: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   883: aload_0
    //   884: athrow
    //   885: astore_1
    //   886: ldc 30
    //   888: aload_1
    //   889: ldc_w 431
    //   892: iconst_0
    //   893: anewarray 4	java/lang/Object
    //   896: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: aload 12
    //   901: aconst_null
    //   902: putfield 391	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   905: goto -541 -> 364
    //   908: ldc_w 351
    //   911: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   914: aconst_null
    //   915: areturn
    //   916: aconst_null
    //   917: astore 8
    //   919: goto -795 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	922	0	paramContext	Context
    //   0	922	1	paramIntent	Intent
    //   127	698	2	i	int
    //   129	210	3	j	int
    //   35	460	4	l1	long
    //   340	7	6	l2	long
    //   41	877	8	localObject1	Object
    //   239	622	9	localk1	com.tencent.mm.compatible.b.k
    //   235	75	10	localk2	com.tencent.mm.compatible.b.k
    //   828	8	10	localException	Exception
    //   232	25	11	localObject2	Object
    //   93	807	12	locala	a.a
    //   84	591	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   244	252	828	java/lang/Exception
    //   259	273	828	java/lang/Exception
    //   285	291	828	java/lang/Exception
    //   298	304	828	java/lang/Exception
    //   244	252	868	finally
    //   259	273	868	finally
    //   285	291	868	finally
    //   298	304	868	finally
    //   833	855	868	finally
    //   342	364	885	java/lang/Exception
  }
  
  private static boolean q(Bitmap paramBitmap)
  {
    AppMethodBeat.i(155919);
    if (paramBitmap != null)
    {
      long l2 = Util.currentTicks();
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
      Log.i("MicroMsg.GetVideoMetadata", "isBitmapDark, avg bitmap avgColor:%s, cost:%s", new Object[] { Long.valueOf(l1), Long.valueOf(Util.ticksToNow(l2)) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.i.a
 * JD-Core Version:    0.7.0.1
 */