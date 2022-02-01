package com.tencent.mm.compatible.i;

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
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;

public final class a
{
  private static boolean C(Bitmap paramBitmap)
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
  
  private static Bitmap DF(String paramString)
  {
    AppMethodBeat.i(155918);
    if ((Util.isNullOrNil(paramString)) || (!y.ZC(paramString)))
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
  private static String c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 132
    //   11: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 144	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: astore_0
    //   29: ldc 41
    //   31: ldc 146
    //   33: aload_0
    //   34: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 155	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +10 -> 57
    //   50: ldc 132
    //   52: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: ldc 166
    //   60: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore_0
    //   64: aload_1
    //   65: invokevirtual 175	android/net/Uri:getHost	()Ljava/lang/String;
    //   68: ldc 177
    //   70: ldc 179
    //   72: invokevirtual 183	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_1
    //   77: invokevirtual 186	android/net/Uri:getPath	()Ljava/lang/String;
    //   80: ldc 166
    //   82: ldc 179
    //   84: invokevirtual 183	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 6
    //   89: new 188	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 190
    //   95: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: new 188	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 201
    //   115: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 179
    //   124: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 179
    //   135: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore_0
    //   149: aload_3
    //   150: aload 5
    //   152: invokevirtual 204	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   155: ifne +23 -> 178
    //   158: new 188	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   165: aload_3
    //   166: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 5
    //   171: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_0
    //   178: ldc 41
    //   180: ldc 207
    //   182: aload_0
    //   183: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 155	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: new 209	com/tencent/mm/vfs/u
    //   195: dup
    //   196: invokestatic 214	com/tencent/mm/loader/i/b:bnd	()Ljava/lang/String;
    //   199: aload_0
    //   200: invokespecial 216	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: astore 5
    //   205: aload 5
    //   207: invokevirtual 220	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   210: invokevirtual 224	com/tencent/mm/vfs/u:jKS	()Z
    //   213: ifne +12 -> 225
    //   216: aload 5
    //   218: invokevirtual 220	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   221: invokevirtual 227	com/tencent/mm/vfs/u:jKY	()Z
    //   224: pop
    //   225: aload 5
    //   227: invokevirtual 224	com/tencent/mm/vfs/u:jKS	()Z
    //   230: ifeq +9 -> 239
    //   233: aload 5
    //   235: invokevirtual 230	com/tencent/mm/vfs/u:diJ	()Z
    //   238: pop
    //   239: aload 5
    //   241: invokevirtual 233	com/tencent/mm/vfs/u:jKZ	()Z
    //   244: pop
    //   245: aload 5
    //   247: invokestatic 237	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   250: astore_0
    //   251: aload 4
    //   253: aload_1
    //   254: invokevirtual 241	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnonnull +18 -> 277
    //   262: aload_1
    //   263: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   266: aload_0
    //   267: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: ldc 132
    //   272: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   297: invokevirtual 251	java/io/InputStream:read	([B)I
    //   300: istore_2
    //   301: iload_2
    //   302: ifle +55 -> 357
    //   305: aload_1
    //   306: astore 4
    //   308: aload_0
    //   309: astore_3
    //   310: aload_0
    //   311: aload 6
    //   313: iconst_0
    //   314: iload_2
    //   315: invokevirtual 257	java/io/OutputStream:write	([BII)V
    //   318: goto -29 -> 289
    //   321: astore 5
    //   323: aload_1
    //   324: astore 4
    //   326: aload_0
    //   327: astore_3
    //   328: ldc 41
    //   330: aload 5
    //   332: ldc_w 259
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload_1
    //   343: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   346: aload_0
    //   347: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   350: ldc 132
    //   352: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aconst_null
    //   356: areturn
    //   357: aload_1
    //   358: astore 4
    //   360: aload_0
    //   361: astore_3
    //   362: aload 5
    //   364: invokevirtual 263	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   367: invokestatic 268	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   370: astore 5
    //   372: aload_1
    //   373: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   376: aload_0
    //   377: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   380: ldc 132
    //   382: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aload 5
    //   387: areturn
    //   388: astore_1
    //   389: aconst_null
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_0
    //   394: aload 4
    //   396: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   403: ldc 132
    //   405: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aconst_null
    //   412: astore 4
    //   414: goto -20 -> 394
    //   417: astore_1
    //   418: aload_3
    //   419: astore_0
    //   420: goto -26 -> 394
    //   423: astore 5
    //   425: aconst_null
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_0
    //   429: goto -106 -> 323
    //   432: astore 5
    //   434: aconst_null
    //   435: astore_1
    //   436: goto -113 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramContext	Context
    //   0	439	1	paramUri	Uri
    //   300	15	2	i	int
    //   75	344	3	localObject1	Object
    //   20	393	4	localObject2	Object
    //   107	139	5	localObject3	Object
    //   321	42	5	localException1	Exception
    //   370	16	5	str	String
    //   423	1	5	localException2	Exception
    //   432	1	5	localException3	Exception
    //   87	225	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   282	289	321	java/lang/Exception
    //   294	301	321	java/lang/Exception
    //   310	318	321	java/lang/Exception
    //   362	372	321	java/lang/Exception
    //   239	251	388	finally
    //   251	258	410	finally
    //   282	289	417	finally
    //   294	301	417	finally
    //   310	318	417	finally
    //   328	342	417	finally
    //   362	372	417	finally
    //   239	251	423	java/lang/Exception
    //   251	258	432	java/lang/Exception
  }
  
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
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new u((String)localObject3).jKS()))
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
      label273:
      if (localObject1 != null) {
        if (((String)localObject1).startsWith("/storage/emulated/legacy"))
        {
          localObject1 = g.aPZ().getAbsolutePath() + ((String)localObject1).substring(24);
          label320:
          localObject2 = "_data LIKE " + DatabaseUtils.sqlEscapeString((String)localObject1);
          localObject2 = ((ContentResolver)localObject3).query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, (String)localObject2, null, null);
          break;
          if (!str.startsWith("file://")) {
            break label515;
          }
          if (paramIntent.getExtras() == null) {
            break label509;
          }
          localObject1 = (Uri)paramIntent.getExtras().getParcelable("android.intent.extra.STREAM");
          if ((localObject1 == null) || (Util.isNullOrNil(((Uri)localObject1).getPath()))) {
            break label509;
          }
        }
      }
      label509:
      for (localObject2 = ((Uri)localObject1).getPath();; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label273;
        }
        localObject1 = str.substring(7);
        break label273;
        if (((String)localObject1).startsWith("/sdcard"))
        {
          localObject1 = g.aPZ().getAbsolutePath() + ((String)localObject1).substring(7);
          break label320;
          paramContext = c(paramContext, paramIntent.getData());
          AppMethodBeat.o(155916);
          return paramContext;
        }
        break label320;
        localObject2 = null;
        break;
      }
      label515:
      localObject1 = null;
    }
  }
  
  /* Error */
  public static a j(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 378
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 275	android/content/Intent:getData	()Landroid/net/Uri;
    //   14: ifnonnull +19 -> 33
    //   17: ldc 41
    //   19: ldc_w 277
    //   22: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc_w 378
    //   28: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: invokestatic 22	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   36: lstore 4
    //   38: aload_1
    //   39: invokevirtual 282	android/content/Intent:getDataString	()Ljava/lang/String;
    //   42: astore 8
    //   44: ldc 41
    //   46: ldc_w 380
    //   49: aload 8
    //   51: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual 155	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 8
    //   62: ifnonnull +19 -> 81
    //   65: ldc 41
    //   67: ldc_w 286
    //   70: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 378
    //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: aload_0
    //   82: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   85: astore 13
    //   87: new 6	com/tencent/mm/compatible/i/a$a
    //   90: dup
    //   91: invokespecial 381	com/tencent/mm/compatible/i/a$a:<init>	()V
    //   94: astore 12
    //   96: aload 8
    //   98: getstatic 292	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   101: invokevirtual 293	android/net/Uri:toString	()Ljava/lang/String;
    //   104: invokevirtual 296	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   107: ifeq +436 -> 543
    //   110: aload 13
    //   112: aload_1
    //   113: invokevirtual 275	android/content/Intent:getData	()Landroid/net/Uri;
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: aconst_null
    //   120: invokevirtual 300	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   123: astore 8
    //   125: ldc_w 382
    //   128: istore_2
    //   129: iload_2
    //   130: istore_3
    //   131: aload 8
    //   133: ifnull +199 -> 332
    //   136: aload 8
    //   138: invokeinterface 306 1 0
    //   143: ifle +180 -> 323
    //   146: aload 8
    //   148: invokeinterface 309 1 0
    //   153: pop
    //   154: aload 8
    //   156: aload 8
    //   158: ldc_w 384
    //   161: invokeinterface 315 2 0
    //   166: invokeinterface 386 2 0
    //   171: istore_3
    //   172: aload 12
    //   174: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   177: ifnonnull +25 -> 202
    //   180: aload 12
    //   182: aload 8
    //   184: aload 8
    //   186: ldc_w 311
    //   189: invokeinterface 315 2 0
    //   194: invokeinterface 318 2 0
    //   199: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   202: aload 12
    //   204: aload 8
    //   206: aload 8
    //   208: ldc_w 392
    //   211: invokeinterface 315 2 0
    //   216: invokeinterface 386 2 0
    //   221: putfield 395	com/tencent/mm/compatible/i/a$a:duration	I
    //   224: aload 12
    //   226: getfield 395	com/tencent/mm/compatible/i/a$a:duration	I
    //   229: ifne +86 -> 315
    //   232: aconst_null
    //   233: astore 11
    //   235: aconst_null
    //   236: astore 10
    //   238: aload 10
    //   240: astore 9
    //   242: aload 11
    //   244: astore_1
    //   245: ldc 41
    //   247: ldc_w 397
    //   250: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 10
    //   255: astore 9
    //   257: aload 11
    //   259: astore_1
    //   260: aload_0
    //   261: aload 12
    //   263: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   266: invokestatic 401	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   269: invokestatic 407	com/tencent/mm/compatible/b/k:b	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   272: astore 10
    //   274: aload 10
    //   276: ifnull +548 -> 824
    //   279: aload 10
    //   281: astore 9
    //   283: aload 10
    //   285: astore_1
    //   286: aload 10
    //   288: invokevirtual 412	android/media/MediaPlayer:getDuration	()I
    //   291: istore_2
    //   292: aload 10
    //   294: astore 9
    //   296: aload 10
    //   298: astore_1
    //   299: aload 12
    //   301: iload_2
    //   302: putfield 395	com/tencent/mm/compatible/i/a$a:duration	I
    //   305: aload 10
    //   307: ifnull +8 -> 315
    //   310: aload 10
    //   312: invokevirtual 413	android/media/MediaPlayer:release	()V
    //   315: aload 12
    //   317: aconst_null
    //   318: putfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   321: iload_3
    //   322: istore_2
    //   323: aload 8
    //   325: invokeinterface 321 1 0
    //   330: iload_2
    //   331: istore_3
    //   332: iload_3
    //   333: ldc_w 382
    //   336: if_icmpeq +29 -> 365
    //   339: iload_3
    //   340: i2l
    //   341: lstore 6
    //   343: aload 12
    //   345: aload 13
    //   347: lload 6
    //   349: iconst_1
    //   350: aconst_null
    //   351: invokestatic 423	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   354: putfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   357: ldc 41
    //   359: ldc_w 425
    //   362: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 12
    //   367: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   370: invokestatic 73	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   373: ifne +111 -> 484
    //   376: aload 12
    //   378: getfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   381: ifnonnull +103 -> 484
    //   384: ldc 41
    //   386: ldc_w 427
    //   389: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 12
    //   394: aload 12
    //   396: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   399: invokestatic 429	com/tencent/mm/compatible/i/a:DF	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   402: putfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   405: aload 12
    //   407: getfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   410: ifnull +14 -> 424
    //   413: aload 12
    //   415: getfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   418: invokestatic 431	com/tencent/mm/compatible/i/a:C	(Landroid/graphics/Bitmap;)Z
    //   421: ifeq +17 -> 438
    //   424: aload 12
    //   426: aload 12
    //   428: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   431: iconst_1
    //   432: invokestatic 437	com/tencent/mm/sdk/platformtools/BitmapUtil:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   435: putfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   438: aload 12
    //   440: getfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   443: ifnonnull +41 -> 484
    //   446: aload_0
    //   447: new 272	android/content/Intent
    //   450: dup
    //   451: ldc_w 439
    //   454: new 188	java/lang/StringBuilder
    //   457: dup
    //   458: ldc_w 359
    //   461: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: aload 12
    //   466: getfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   469: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 401	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   478: invokespecial 445	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   481: invokevirtual 449	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   484: ldc 41
    //   486: ldc_w 451
    //   489: iconst_3
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: lload 4
    //   497: invokestatic 53	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   500: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   503: aastore
    //   504: dup
    //   505: iconst_1
    //   506: aload 12
    //   508: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: aload 12
    //   516: getfield 395	com/tencent/mm/compatible/i/a$a:duration	I
    //   519: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload 12
    //   528: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   531: ifnull +378 -> 909
    //   534: ldc_w 378
    //   537: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   540: aload 12
    //   542: areturn
    //   543: aload 8
    //   545: ldc_w 331
    //   548: invokevirtual 296	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   551: ifeq +141 -> 692
    //   554: aload 12
    //   556: aload_0
    //   557: aload_1
    //   558: invokevirtual 275	android/content/Intent:getData	()Landroid/net/Uri;
    //   561: invokestatic 334	com/tencent/mm/sdk/platformtools/Util:getFilePath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   564: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   567: aload 12
    //   569: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   572: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifeq +16 -> 591
    //   578: aload 12
    //   580: aload_0
    //   581: aload_1
    //   582: invokevirtual 275	android/content/Intent:getData	()Landroid/net/Uri;
    //   585: invokestatic 375	com/tencent/mm/compatible/i/a:c	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   588: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   591: aload 12
    //   593: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   596: ifnull +321 -> 917
    //   599: aload 12
    //   601: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   604: ldc_w 336
    //   607: invokevirtual 296	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   610: ifeq +160 -> 770
    //   613: aload 12
    //   615: new 188	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   622: invokestatic 342	com/tencent/mm/compatible/util/g:aPZ	()Ljava/io/File;
    //   625: invokevirtual 347	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   628: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 12
    //   633: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   636: bipush 24
    //   638: invokevirtual 350	java/lang/String:substring	(I)Ljava/lang/String;
    //   641: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   650: new 188	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 352
    //   657: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: aload 12
    //   662: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   665: invokestatic 357	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   668: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: astore_1
    //   675: aload 13
    //   677: getstatic 292	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   680: aconst_null
    //   681: aload_1
    //   682: aconst_null
    //   683: aconst_null
    //   684: invokevirtual 300	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   687: astore 8
    //   689: goto -564 -> 125
    //   692: aload 8
    //   694: ldc_w 359
    //   697: invokevirtual 296	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   700: ifeq -109 -> 591
    //   703: aload_1
    //   704: invokevirtual 363	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   707: ifnull +40 -> 747
    //   710: aload_1
    //   711: invokevirtual 363	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   714: ldc_w 365
    //   717: invokevirtual 371	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   720: checkcast 172	android/net/Uri
    //   723: astore_1
    //   724: aload_1
    //   725: ifnull +22 -> 747
    //   728: aload_1
    //   729: invokevirtual 186	android/net/Uri:getPath	()Ljava/lang/String;
    //   732: invokestatic 73	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   735: ifne +12 -> 747
    //   738: aload 12
    //   740: aload_1
    //   741: invokevirtual 186	android/net/Uri:getPath	()Ljava/lang/String;
    //   744: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   747: aload 12
    //   749: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   752: ifnonnull -161 -> 591
    //   755: aload 12
    //   757: aload 8
    //   759: bipush 7
    //   761: invokevirtual 350	java/lang/String:substring	(I)Ljava/lang/String;
    //   764: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   767: goto -176 -> 591
    //   770: aload 12
    //   772: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   775: ldc_w 373
    //   778: invokevirtual 296	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   781: ifeq -131 -> 650
    //   784: aload 12
    //   786: new 188	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   793: invokestatic 342	com/tencent/mm/compatible/util/g:aPZ	()Ljava/io/File;
    //   796: invokevirtual 347	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   799: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload 12
    //   804: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   807: bipush 7
    //   809: invokevirtual 350	java/lang/String:substring	(I)Ljava/lang/String;
    //   812: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: putfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   821: goto -171 -> 650
    //   824: iconst_0
    //   825: istore_2
    //   826: goto -534 -> 292
    //   829: astore 10
    //   831: aload 9
    //   833: astore_1
    //   834: ldc 41
    //   836: aload 10
    //   838: ldc_w 453
    //   841: iconst_1
    //   842: anewarray 4	java/lang/Object
    //   845: dup
    //   846: iconst_0
    //   847: aload 12
    //   849: getfield 390	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
    //   852: aastore
    //   853: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   856: aload 9
    //   858: ifnull -543 -> 315
    //   861: aload 9
    //   863: invokevirtual 413	android/media/MediaPlayer:release	()V
    //   866: goto -551 -> 315
    //   869: astore_0
    //   870: aload_1
    //   871: ifnull +7 -> 878
    //   874: aload_1
    //   875: invokevirtual 413	android/media/MediaPlayer:release	()V
    //   878: ldc_w 378
    //   881: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   884: aload_0
    //   885: athrow
    //   886: astore_1
    //   887: ldc 41
    //   889: aload_1
    //   890: ldc_w 455
    //   893: iconst_0
    //   894: anewarray 4	java/lang/Object
    //   897: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: aload 12
    //   902: aconst_null
    //   903: putfield 417	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   906: goto -541 -> 365
    //   909: ldc_w 378
    //   912: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static final class a
  {
    public Bitmap bitmap = null;
    public int duration = 0;
    public String filename = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.i.a
 * JD-Core Version:    0.7.0.1
 */