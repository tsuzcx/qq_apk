package com.tencent.mm.compatible.j;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class a
{
  @TargetApi(5)
  public static String g(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getData() == null))
    {
      y.e("MicroMsg.GetVideoMetadata", "input invalid");
      return null;
    }
    long l = bk.UZ();
    String str = paramIntent.getDataString();
    y.i("MicroMsg.GetVideoMetadata", "get video file name, dataString " + str);
    if (str == null)
    {
      y.e("MicroMsg.GetVideoMetadata", "dataString empty");
      return null;
    }
    Object localObject = paramContext.getContentResolver();
    if (str.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString()))
    {
      paramIntent = ((ContentResolver)localObject).query(paramIntent.getData(), null, null, null, null);
      paramContext = null;
      localObject = paramContext;
      if (paramIntent != null)
      {
        localObject = paramContext;
        if (paramIntent.getCount() > 0)
        {
          paramIntent.moveToFirst();
          localObject = paramContext;
          if (paramContext == null) {
            localObject = paramIntent.getString(paramIntent.getColumnIndexOrThrow("_data"));
          }
        }
        paramIntent.close();
      }
      y.i("MicroMsg.GetVideoMetadata", "get video filename:" + (String)localObject + ", cost time: " + bk.cp(l));
      return localObject;
    }
    if (str.startsWith("content://")) {
      paramContext = bk.h(paramContext, paramIntent.getData());
    }
    for (;;)
    {
      label213:
      if (paramContext != null) {
        if (paramContext.startsWith("/storage/emulated/legacy"))
        {
          paramContext = h.getExternalStorageDirectory().getAbsolutePath() + paramContext.substring(24);
          label255:
          paramIntent = "_data LIKE " + DatabaseUtils.sqlEscapeString(paramContext);
          paramIntent = ((ContentResolver)localObject).query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, paramIntent, null, null);
          break;
          if (!str.startsWith("file://")) {
            break label411;
          }
          if (paramIntent.getExtras() == null) {
            break label406;
          }
          paramContext = (Uri)paramIntent.getExtras().getParcelable("android.intent.extra.STREAM");
          if ((paramContext == null) || (bk.bl(paramContext.getPath()))) {
            break label406;
          }
        }
      }
      label406:
      for (paramIntent = paramContext.getPath();; paramIntent = null)
      {
        paramContext = paramIntent;
        if (paramIntent != null) {
          break label213;
        }
        paramContext = str.substring(7);
        break label213;
        if (paramContext.startsWith("/sdcard"))
        {
          paramContext = h.getExternalStorageDirectory().getAbsolutePath() + paramContext.substring(7);
          break label255;
        }
        break label255;
        paramIntent = null;
        break;
      }
      label411:
      paramContext = null;
    }
  }
  
  /* Error */
  @TargetApi(5)
  public static a.a h(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 17	android/content/Intent:getData	()Landroid/net/Uri;
    //   8: ifnonnull +12 -> 20
    //   11: ldc 19
    //   13: ldc 21
    //   15: invokestatic 27	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 33	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   23: lstore 4
    //   25: aload_1
    //   26: invokevirtual 37	android/content/Intent:getDataString	()Ljava/lang/String;
    //   29: astore 8
    //   31: ldc 19
    //   33: new 39	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 180
    //   39: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload 8
    //   44: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 8
    //   55: ifnonnull +12 -> 67
    //   58: ldc 19
    //   60: ldc 57
    //   62: invokestatic 27	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_0
    //   68: invokevirtual 63	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   71: astore 13
    //   73: new 6	com/tencent/mm/compatible/j/a$a
    //   76: dup
    //   77: invokespecial 181	com/tencent/mm/compatible/j/a$a:<init>	()V
    //   80: astore 12
    //   82: aload 8
    //   84: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   87: invokevirtual 72	android/net/Uri:toString	()Ljava/lang/String;
    //   90: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq +380 -> 473
    //   96: aload 13
    //   98: aload_1
    //   99: invokevirtual 17	android/content/Intent:getData	()Landroid/net/Uri;
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual 84	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore 8
    //   111: ldc 182
    //   113: istore_2
    //   114: iload_2
    //   115: istore_3
    //   116: aload 8
    //   118: ifnull +195 -> 313
    //   121: aload 8
    //   123: invokeinterface 90 1 0
    //   128: ifle +176 -> 304
    //   131: aload 8
    //   133: invokeinterface 94 1 0
    //   138: pop
    //   139: aload 8
    //   141: aload 8
    //   143: ldc 184
    //   145: invokeinterface 100 2 0
    //   150: invokeinterface 188 2 0
    //   155: istore_3
    //   156: aload 12
    //   158: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   161: ifnonnull +24 -> 185
    //   164: aload 12
    //   166: aload 8
    //   168: aload 8
    //   170: ldc 96
    //   172: invokeinterface 100 2 0
    //   177: invokeinterface 104 2 0
    //   182: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   185: aload 12
    //   187: aload 8
    //   189: aload 8
    //   191: ldc 194
    //   193: invokeinterface 100 2 0
    //   198: invokeinterface 188 2 0
    //   203: putfield 197	com/tencent/mm/compatible/j/a$a:duration	I
    //   206: aload 12
    //   208: getfield 197	com/tencent/mm/compatible/j/a$a:duration	I
    //   211: ifne +85 -> 296
    //   214: aconst_null
    //   215: astore 11
    //   217: aconst_null
    //   218: astore 10
    //   220: aload 10
    //   222: astore 9
    //   224: aload 11
    //   226: astore_1
    //   227: ldc 19
    //   229: ldc 199
    //   231: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 10
    //   236: astore 9
    //   238: aload 11
    //   240: astore_1
    //   241: aload_0
    //   242: aload 12
    //   244: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   247: invokestatic 203	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   250: invokestatic 209	com/tencent/mm/compatible/b/j:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/j;
    //   253: astore 10
    //   255: aload 10
    //   257: ifnull +467 -> 724
    //   260: aload 10
    //   262: astore 9
    //   264: aload 10
    //   266: astore_1
    //   267: aload 10
    //   269: invokevirtual 214	android/media/MediaPlayer:getDuration	()I
    //   272: istore_2
    //   273: aload 10
    //   275: astore 9
    //   277: aload 10
    //   279: astore_1
    //   280: aload 12
    //   282: iload_2
    //   283: putfield 197	com/tencent/mm/compatible/j/a$a:duration	I
    //   286: aload 10
    //   288: ifnull +8 -> 296
    //   291: aload 10
    //   293: invokevirtual 217	android/media/MediaPlayer:release	()V
    //   296: aload 12
    //   298: aconst_null
    //   299: putfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   302: iload_3
    //   303: istore_2
    //   304: aload 8
    //   306: invokeinterface 108 1 0
    //   311: iload_2
    //   312: istore_3
    //   313: iload_3
    //   314: ldc 182
    //   316: if_icmpeq +21 -> 337
    //   319: iload_3
    //   320: i2l
    //   321: lstore 6
    //   323: aload 12
    //   325: aload 13
    //   327: lload 6
    //   329: iconst_1
    //   330: aconst_null
    //   331: invokestatic 227	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   334: putfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   337: aload 12
    //   339: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   342: invokestatic 171	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   345: ifne +76 -> 421
    //   348: aload 12
    //   350: getfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   353: ifnonnull +68 -> 421
    //   356: ldc 19
    //   358: ldc 229
    //   360: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 12
    //   365: aload 12
    //   367: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   370: iconst_1
    //   371: invokestatic 235	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   374: putfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   377: aload 12
    //   379: getfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   382: ifnonnull +39 -> 421
    //   385: aload_0
    //   386: new 13	android/content/Intent
    //   389: dup
    //   390: ldc 237
    //   392: new 39	java/lang/StringBuilder
    //   395: dup
    //   396: ldc 153
    //   398: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: aload 12
    //   403: getfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   406: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 203	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   415: invokespecial 243	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   418: invokevirtual 247	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   421: ldc 19
    //   423: ldc 249
    //   425: iconst_3
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: lload 4
    //   433: invokestatic 116	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   436: invokestatic 255	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   439: aastore
    //   440: dup
    //   441: iconst_1
    //   442: aload 12
    //   444: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   447: aastore
    //   448: dup
    //   449: iconst_2
    //   450: aload 12
    //   452: getfield 197	com/tencent/mm/compatible/j/a$a:duration	I
    //   455: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: invokestatic 263	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: aload 12
    //   464: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   467: ifnull +336 -> 803
    //   470: aload 12
    //   472: areturn
    //   473: aload 8
    //   475: ldc 121
    //   477: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   480: ifeq +115 -> 595
    //   483: aload 12
    //   485: aload_0
    //   486: aload_1
    //   487: invokevirtual 17	android/content/Intent:getData	()Landroid/net/Uri;
    //   490: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:h	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   493: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   496: aload 12
    //   498: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   501: ifnull +304 -> 805
    //   504: aload 12
    //   506: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   509: ldc 127
    //   511: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +157 -> 671
    //   517: aload 12
    //   519: new 39	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   526: invokestatic 135	com/tencent/mm/compatible/util/h:getExternalStorageDirectory	()Ljava/io/File;
    //   529: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   532: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 12
    //   537: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   540: bipush 24
    //   542: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   545: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   554: new 39	java/lang/StringBuilder
    //   557: dup
    //   558: ldc 145
    //   560: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   563: aload 12
    //   565: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   568: invokestatic 151	android/database/DatabaseUtils:sqlEscapeString	(Ljava/lang/String;)Ljava/lang/String;
    //   571: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: astore_1
    //   578: aload 13
    //   580: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   583: aconst_null
    //   584: aload_1
    //   585: aconst_null
    //   586: aconst_null
    //   587: invokevirtual 84	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   590: astore 8
    //   592: goto -481 -> 111
    //   595: aload 8
    //   597: ldc 153
    //   599: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   602: ifeq -106 -> 496
    //   605: aload_1
    //   606: invokevirtual 157	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   609: ifnull +39 -> 648
    //   612: aload_1
    //   613: invokevirtual 157	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   616: ldc 159
    //   618: invokevirtual 165	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   621: checkcast 71	android/net/Uri
    //   624: astore_1
    //   625: aload_1
    //   626: ifnull +22 -> 648
    //   629: aload_1
    //   630: invokevirtual 168	android/net/Uri:getPath	()Ljava/lang/String;
    //   633: invokestatic 171	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   636: ifne +12 -> 648
    //   639: aload 12
    //   641: aload_1
    //   642: invokevirtual 168	android/net/Uri:getPath	()Ljava/lang/String;
    //   645: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   648: aload 12
    //   650: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   653: ifnonnull -157 -> 496
    //   656: aload 12
    //   658: aload 8
    //   660: bipush 7
    //   662: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   665: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   668: goto -172 -> 496
    //   671: aload 12
    //   673: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   676: ldc 173
    //   678: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   681: ifeq -127 -> 554
    //   684: aload 12
    //   686: new 39	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   693: invokestatic 135	com/tencent/mm/compatible/util/h:getExternalStorageDirectory	()Ljava/io/File;
    //   696: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   699: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 12
    //   704: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   707: bipush 7
    //   709: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   712: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: putfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   721: goto -167 -> 554
    //   724: iconst_0
    //   725: istore_2
    //   726: goto -453 -> 273
    //   729: astore 10
    //   731: aload 9
    //   733: astore_1
    //   734: ldc 19
    //   736: aload 10
    //   738: ldc_w 265
    //   741: iconst_1
    //   742: anewarray 4	java/lang/Object
    //   745: dup
    //   746: iconst_0
    //   747: aload 12
    //   749: getfield 192	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   752: aastore
    //   753: invokestatic 269	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: aload 9
    //   758: ifnull -462 -> 296
    //   761: aload 9
    //   763: invokevirtual 217	android/media/MediaPlayer:release	()V
    //   766: goto -470 -> 296
    //   769: astore_0
    //   770: aload_1
    //   771: ifnull +7 -> 778
    //   774: aload_1
    //   775: invokevirtual 217	android/media/MediaPlayer:release	()V
    //   778: aload_0
    //   779: athrow
    //   780: astore_1
    //   781: ldc 19
    //   783: aload_1
    //   784: ldc_w 271
    //   787: iconst_0
    //   788: anewarray 4	java/lang/Object
    //   791: invokestatic 269	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   794: aload 12
    //   796: aconst_null
    //   797: putfield 221	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   800: goto -463 -> 337
    //   803: aconst_null
    //   804: areturn
    //   805: aconst_null
    //   806: astore 8
    //   808: goto -697 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	paramContext	Context
    //   0	811	1	paramIntent	Intent
    //   113	613	2	i	int
    //   115	205	3	j	int
    //   23	409	4	l1	long
    //   321	7	6	l2	long
    //   29	778	8	localObject1	Object
    //   222	540	9	localj1	com.tencent.mm.compatible.b.j
    //   218	74	10	localj2	com.tencent.mm.compatible.b.j
    //   729	8	10	localException	java.lang.Exception
    //   215	24	11	localObject2	Object
    //   80	715	12	locala	a.a
    //   71	508	13	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   227	234	729	java/lang/Exception
    //   241	255	729	java/lang/Exception
    //   267	273	729	java/lang/Exception
    //   280	286	729	java/lang/Exception
    //   227	234	769	finally
    //   241	255	769	finally
    //   267	273	769	finally
    //   280	286	769	finally
    //   734	756	769	finally
    //   323	337	780	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.j.a
 * JD-Core Version:    0.7.0.1
 */