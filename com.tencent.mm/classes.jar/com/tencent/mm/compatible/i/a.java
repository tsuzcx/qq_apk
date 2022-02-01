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
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;

public final class a
{
  private static Bitmap Ei(String paramString)
  {
    AppMethodBeat.i(155918);
    if ((Util.isNullOrNil(paramString)) || (!s.YS(paramString)))
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
  private static String g(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 108
    //   11: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 120	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: astore_0
    //   29: ldc 31
    //   31: ldc 122
    //   33: aload_0
    //   34: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 131	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +10 -> 57
    //   50: ldc 108
    //   52: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: ldc 142
    //   60: invokevirtual 146	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 151	android/net/Uri:getHost	()Ljava/lang/String;
    //   68: ldc 153
    //   70: ldc 155
    //   72: invokevirtual 159	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_1
    //   77: invokevirtual 162	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: ldc 142
    //   82: ldc 155
    //   84: invokevirtual 159	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 6
    //   89: new 164	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 166
    //   95: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 164	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 177
    //   115: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 155
    //   124: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 155
    //   135: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore_0
    //   149: aload_3
    //   150: aload 5
    //   152: invokevirtual 180	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: ifne +23 -> 178
    //   158: new 164	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   165: aload_3
    //   166: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 5
    //   171: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_0
    //   178: ldc 31
    //   180: ldc 183
    //   182: aload_0
    //   183: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 131	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: new 185	com/tencent/mm/vfs/o
    //   195: dup
    //   196: invokestatic 190	com/tencent/mm/loader/j/b:aLn	()Ljava/lang/String;
    //   199: aload_0
    //   200: invokespecial 192	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 196	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   210: invokevirtual 200	com/tencent/mm/vfs/o:exists	()Z
    //   213: ifne +12 -> 225
    //   216: aload 5
    //   218: invokevirtual 196	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   221: invokevirtual 203	com/tencent/mm/vfs/o:mkdirs	()Z
    //   224: pop
    //   225: aload 5
    //   227: invokevirtual 200	com/tencent/mm/vfs/o:exists	()Z
    //   230: ifeq +9 -> 239
    //   233: aload 5
    //   235: invokevirtual 206	com/tencent/mm/vfs/o:delete	()Z
    //   238: pop
    //   239: aload 5
    //   241: invokevirtual 209	com/tencent/mm/vfs/o:createNewFile	()Z
    //   244: pop
    //   245: aload 5
    //   247: invokestatic 213	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   250: astore_0
    //   251: aload 4
    //   253: aload_1
    //   254: invokevirtual 217	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnonnull +18 -> 277
    //   262: aload_1
    //   263: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   266: aload_0
    //   267: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: ldc 108
    //   272: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   297: invokevirtual 227	java/io/InputStream:read	([B)I
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
    //   315: invokevirtual 233	java/io/OutputStream:write	([BII)V
    //   318: goto -29 -> 289
    //   321: astore 5
    //   323: aload_1
    //   324: astore 4
    //   326: aload_0
    //   327: astore_3
    //   328: ldc 31
    //   330: aload 5
    //   332: ldc 235
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_1
    //   342: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   345: aload_0
    //   346: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   349: ldc 108
    //   351: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: aload_1
    //   357: astore 4
    //   359: aload_0
    //   360: astore_3
    //   361: aload 5
    //   363: invokevirtual 239	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   366: invokestatic 244	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   369: astore 5
    //   371: aload_1
    //   372: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   375: aload_0
    //   376: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   379: ldc 108
    //   381: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload 5
    //   386: areturn
    //   387: astore_1
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_0
    //   393: aload 4
    //   395: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   398: aload_0
    //   399: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   402: ldc 108
    //   404: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new o((String)localObject3).exists()))
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
      label269:
      if (localObject1 != null) {
        if (((String)localObject1).startsWith("/storage/emulated/legacy"))
        {
          localObject1 = g.getExternalStorageDirectory().getAbsolutePath() + ((String)localObject1).substring(24);
          label316:
          localObject2 = "_data LIKE " + DatabaseUtils.sqlEscapeString((String)localObject1);
          localObject2 = ((ContentResolver)localObject3).query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, (String)localObject2, null, null);
          break;
          if (!str.startsWith("file://")) {
            break label510;
          }
          if (paramIntent.getExtras() == null) {
            break label504;
          }
          localObject1 = (Uri)paramIntent.getExtras().getParcelable("android.intent.extra.STREAM");
          if ((localObject1 == null) || (Util.isNullOrNil(((Uri)localObject1).getPath()))) {
            break label504;
          }
        }
      }
      label504:
      for (localObject2 = ((Uri)localObject1).getPath();; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label269;
        }
        localObject1 = str.substring(7);
        break label269;
        if (((String)localObject1).startsWith("/sdcard"))
        {
          localObject1 = g.getExternalStorageDirectory().getAbsolutePath() + ((String)localObject1).substring(7);
          break label316;
          paramContext = g(paramContext, paramIntent.getData());
          AppMethodBeat.o(155916);
          return paramContext;
        }
        break label316;
        localObject2 = null;
        break;
      }
      label510:
      localObject1 = null;
    }
  }
  
  /* Error */
  @TargetApi(5)
  public static a j(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 254	android/content/Intent:getData	()Landroid/net/Uri;
    //   14: ifnonnull +19 -> 33
    //   17: ldc 31
    //   19: ldc_w 256
    //   22: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc_w 358
    //   28: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: invokestatic 46	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   36: lstore 4
    //   38: aload_1
    //   39: invokevirtual 261	android/content/Intent:getDataString	()Ljava/lang/String;
    //   42: astore 8
    //   44: ldc 31
    //   46: ldc_w 360
    //   49: aload 8
    //   51: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual 131	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 8
    //   62: ifnonnull +19 -> 81
    //   65: ldc 31
    //   67: ldc_w 265
    //   70: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 358
    //   76: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: aload_0
    //   82: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   85: astore 13
    //   87: new 6	com/tencent/mm/compatible/i/a$a
    //   90: dup
    //   91: invokespecial 361	com/tencent/mm/compatible/i/a$a:<init>	()V
    //   94: astore 12
    //   96: aload 8
    //   98: getstatic 271	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   101: invokevirtual 272	android/net/Uri:toString	()Ljava/lang/String;
    //   104: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   107: ifeq +436 -> 543
    //   110: aload 13
    //   112: aload_1
    //   113: invokevirtual 254	android/content/Intent:getData	()Landroid/net/Uri;
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: aconst_null
    //   120: invokevirtual 279	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   123: astore 8
    //   125: ldc_w 362
    //   128: istore_2
    //   129: iload_2
    //   130: istore_3
    //   131: aload 8
    //   133: ifnull +199 -> 332
    //   136: aload 8
    //   138: invokeinterface 285 1 0
    //   143: ifle +180 -> 323
    //   146: aload 8
    //   148: invokeinterface 288 1 0
    //   153: pop
    //   154: aload 8
    //   156: aload 8
    //   158: ldc_w 364
    //   161: invokeinterface 294 2 0
    //   166: invokeinterface 367 2 0
    //   171: istore_3
    //   172: aload 12
    //   174: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   177: ifnonnull +25 -> 202
    //   180: aload 12
    //   182: aload 8
    //   184: aload 8
    //   186: ldc_w 290
    //   189: invokeinterface 294 2 0
    //   194: invokeinterface 297 2 0
    //   199: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   202: aload 12
    //   204: aload 8
    //   206: aload 8
    //   208: ldc_w 373
    //   211: invokeinterface 294 2 0
    //   216: invokeinterface 367 2 0
    //   221: putfield 376	com/tencent/mm/compatible/i/a$a:duration	I
    //   224: aload 12
    //   226: getfield 376	com/tencent/mm/compatible/i/a$a:duration	I
    //   229: ifne +86 -> 315
    //   232: aconst_null
    //   233: astore 11
    //   235: aconst_null
    //   236: astore 10
    //   238: aload 10
    //   240: astore 9
    //   242: aload 11
    //   244: astore_1
    //   245: ldc 31
    //   247: ldc_w 378
    //   250: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 10
    //   255: astore 9
    //   257: aload 11
    //   259: astore_1
    //   260: aload_0
    //   261: aload 12
    //   263: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   266: invokestatic 382	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   269: invokestatic 388	com/tencent/mm/compatible/b/k:f	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   272: astore 10
    //   274: aload 10
    //   276: ifnull +548 -> 824
    //   279: aload 10
    //   281: astore 9
    //   283: aload 10
    //   285: astore_1
    //   286: aload 10
    //   288: invokevirtual 393	android/media/MediaPlayer:getDuration	()I
    //   291: istore_2
    //   292: aload 10
    //   294: astore 9
    //   296: aload 10
    //   298: astore_1
    //   299: aload 12
    //   301: iload_2
    //   302: putfield 376	com/tencent/mm/compatible/i/a$a:duration	I
    //   305: aload 10
    //   307: ifnull +8 -> 315
    //   310: aload 10
    //   312: invokevirtual 394	android/media/MediaPlayer:release	()V
    //   315: aload 12
    //   317: aconst_null
    //   318: putfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   321: iload_3
    //   322: istore_2
    //   323: aload 8
    //   325: invokeinterface 300 1 0
    //   330: iload_2
    //   331: istore_3
    //   332: iload_3
    //   333: ldc_w 362
    //   336: if_icmpeq +29 -> 365
    //   339: iload_3
    //   340: i2l
    //   341: lstore 6
    //   343: aload 12
    //   345: aload 13
    //   347: lload 6
    //   349: iconst_1
    //   350: aconst_null
    //   351: invokestatic 404	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   354: putfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   357: ldc 31
    //   359: ldc_w 406
    //   362: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 12
    //   367: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   370: invokestatic 24	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   373: ifne +111 -> 484
    //   376: aload 12
    //   378: getfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   381: ifnonnull +103 -> 484
    //   384: ldc 31
    //   386: ldc_w 408
    //   389: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 12
    //   394: aload 12
    //   396: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   399: invokestatic 410	com/tencent/mm/compatible/i/a:Ei	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   402: putfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   405: aload 12
    //   407: getfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   410: ifnull +14 -> 424
    //   413: aload 12
    //   415: getfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   418: invokestatic 414	com/tencent/mm/compatible/i/a:v	(Landroid/graphics/Bitmap;)Z
    //   421: ifeq +17 -> 438
    //   424: aload 12
    //   426: aload 12
    //   428: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   431: iconst_1
    //   432: invokestatic 420	com/tencent/mm/sdk/platformtools/BitmapUtil:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   435: putfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   438: aload 12
    //   440: getfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   443: ifnonnull +41 -> 484
    //   446: aload_0
    //   447: new 251	android/content/Intent
    //   450: dup
    //   451: ldc_w 422
    //   454: new 164	java/lang/StringBuilder
    //   457: dup
    //   458: ldc_w 338
    //   461: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: aload 12
    //   466: getfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   469: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 382	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   478: invokespecial 428	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   481: invokevirtual 432	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   484: ldc 31
    //   486: ldc_w 434
    //   489: iconst_3
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: lload 4
    //   497: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   500: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   503: aastore
    //   504: dup
    //   505: iconst_1
    //   506: aload 12
    //   508: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: aload 12
    //   516: getfield 376	com/tencent/mm/compatible/i/a$a:duration	I
    //   519: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload 12
    //   528: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   531: ifnull +378 -> 909
    //   534: ldc_w 358
    //   537: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   540: aload 12
    //   542: areturn
    //   543: aload 8
    //   545: ldc_w 310
    //   548: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   551: ifeq +141 -> 692
    //   554: aload 12
    //   556: aload_0
    //   557: aload_1
    //   558: invokevirtual 254	android/content/Intent:getData	()Landroid/net/Uri;
    //   561: invokestatic 313	com/tencent/mm/sdk/platformtools/Util:getFilePath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   564: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   567: aload 12
    //   569: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   572: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifeq +16 -> 591
    //   578: aload 12
    //   580: aload_0
    //   581: aload_1
    //   582: invokevirtual 254	android/content/Intent:getData	()Landroid/net/Uri;
    //   585: invokestatic 354	com/tencent/mm/compatible/i/a:g	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   588: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   591: aload 12
    //   593: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   596: ifnull +321 -> 917
    //   599: aload 12
    //   601: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   604: ldc_w 315
    //   607: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   610: ifeq +160 -> 770
    //   613: aload 12
    //   615: new 164	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   622: invokestatic 321	com/tencent/mm/compatible/util/g:getExternalStorageDirectory	()Ljava/io/File;
    //   625: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   628: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 12
    //   633: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   636: bipush 24
    //   638: invokevirtual 329	java/lang/String:substring	(I)Ljava/lang/String;
    //   641: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   650: new 164	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 331
    //   657: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: aload 12
    //   662: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   665: invokestatic 336	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   668: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: astore_1
    //   675: aload 13
    //   677: getstatic 271	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   680: aconst_null
    //   681: aload_1
    //   682: aconst_null
    //   683: aconst_null
    //   684: invokevirtual 279	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   687: astore 8
    //   689: goto -564 -> 125
    //   692: aload 8
    //   694: ldc_w 338
    //   697: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   700: ifeq -109 -> 591
    //   703: aload_1
    //   704: invokevirtual 342	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   707: ifnull +40 -> 747
    //   710: aload_1
    //   711: invokevirtual 342	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   714: ldc_w 344
    //   717: invokevirtual 350	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   720: checkcast 148	android/net/Uri
    //   723: astore_1
    //   724: aload_1
    //   725: ifnull +22 -> 747
    //   728: aload_1
    //   729: invokevirtual 162	android/net/Uri:getPath	()Ljava/lang/String;
    //   732: invokestatic 24	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   735: ifne +12 -> 747
    //   738: aload 12
    //   740: aload_1
    //   741: invokevirtual 162	android/net/Uri:getPath	()Ljava/lang/String;
    //   744: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   747: aload 12
    //   749: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   752: ifnonnull -161 -> 591
    //   755: aload 12
    //   757: aload 8
    //   759: bipush 7
    //   761: invokevirtual 329	java/lang/String:substring	(I)Ljava/lang/String;
    //   764: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   767: goto -176 -> 591
    //   770: aload 12
    //   772: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   775: ldc_w 352
    //   778: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   781: ifeq -131 -> 650
    //   784: aload 12
    //   786: new 164	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   793: invokestatic 321	com/tencent/mm/compatible/util/g:getExternalStorageDirectory	()Ljava/io/File;
    //   796: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   799: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload 12
    //   804: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   807: bipush 7
    //   809: invokevirtual 329	java/lang/String:substring	(I)Ljava/lang/String;
    //   812: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: putfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   821: goto -171 -> 650
    //   824: iconst_0
    //   825: istore_2
    //   826: goto -534 -> 292
    //   829: astore 10
    //   831: aload 9
    //   833: astore_1
    //   834: ldc 31
    //   836: aload 10
    //   838: ldc_w 436
    //   841: iconst_1
    //   842: anewarray 4	java/lang/Object
    //   845: dup
    //   846: iconst_0
    //   847: aload 12
    //   849: getfield 371	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   852: aastore
    //   853: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   856: aload 9
    //   858: ifnull -543 -> 315
    //   861: aload 9
    //   863: invokevirtual 394	android/media/MediaPlayer:release	()V
    //   866: goto -551 -> 315
    //   869: astore_0
    //   870: aload_1
    //   871: ifnull +7 -> 878
    //   874: aload_1
    //   875: invokevirtual 394	android/media/MediaPlayer:release	()V
    //   878: ldc_w 358
    //   881: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   884: aload_0
    //   885: athrow
    //   886: astore_1
    //   887: ldc 31
    //   889: aload_1
    //   890: ldc_w 438
    //   893: iconst_0
    //   894: anewarray 4	java/lang/Object
    //   897: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: aload 12
    //   902: aconst_null
    //   903: putfield 398	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   906: goto -541 -> 365
    //   909: ldc_w 358
    //   912: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: aconst_null
    //   916: areturn
    //   917: aconst_null
    //   918: astore 8
    //   920: goto -795 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	paramContext	Context
    //   0	923	1	paramIntent	Intent
    //   128	698	2	i	int
    //   130	210	3	j	int
    //   36	460	4	l1	long
    //   341	7	6	l2	long
    //   42	877	8	localObject1	Object
    //   240	622	9	localk1	com.tencent.mm.compatible.b.k
    //   236	75	10	localk2	com.tencent.mm.compatible.b.k
    //   829	8	10	localException	Exception
    //   233	25	11	localObject2	Object
    //   94	807	12	locala	a
    //   85	591	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   245	253	829	java/lang/Exception
    //   260	274	829	java/lang/Exception
    //   286	292	829	java/lang/Exception
    //   299	305	829	java/lang/Exception
    //   245	253	869	finally
    //   260	274	869	finally
    //   286	292	869	finally
    //   299	305	869	finally
    //   834	856	869	finally
    //   343	365	886	java/lang/Exception
  }
  
  private static boolean v(Bitmap paramBitmap)
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
  
  public static final class a
  {
    public Bitmap bitmap = null;
    public int duration = 0;
    public String filename = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.i.a
 * JD-Core Version:    0.7.0.1
 */