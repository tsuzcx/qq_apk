package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b
  implements i
{
  public static String tQx = "date_modified";
  public static String tQy = "datetaken";
  volatile boolean hmD = false;
  protected int tQv = 100;
  protected String[] tQw = { "camera", "screenshots", "download" };
  private boolean tQz = false;
  
  /* Error */
  private static long a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 11
    //   3: lload 11
    //   5: lstore 9
    //   7: aload_0
    //   8: invokestatic 56	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +148 -> 159
    //   14: aload_0
    //   15: lconst_0
    //   16: invokestatic 60	com/tencent/mm/sdk/platformtools/bu:getLong	(Ljava/lang/String;J)J
    //   19: lstore 5
    //   21: lload 5
    //   23: ldc2_w 61
    //   26: lcmp
    //   27: ifle +135 -> 162
    //   30: lload 5
    //   32: lstore 7
    //   34: getstatic 68	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   37: lload 5
    //   39: getstatic 68	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   42: invokevirtual 72	java/util/concurrent/TimeUnit:convert	(JLjava/util/concurrent/TimeUnit;)J
    //   45: lstore 9
    //   47: lload 9
    //   49: lstore 7
    //   51: lload 7
    //   53: lload_1
    //   54: lcmp
    //   55: ifle +30 -> 85
    //   58: iload 4
    //   60: ifeq +133 -> 193
    //   63: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   66: astore_0
    //   67: iload_3
    //   68: ifeq +118 -> 186
    //   71: ldc2_w 79
    //   74: lstore_1
    //   75: aload_0
    //   76: ldc2_w 81
    //   79: lload_1
    //   80: lconst_1
    //   81: iconst_0
    //   82: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   85: lload 5
    //   87: ldc2_w 61
    //   90: lcmp
    //   91: ifle +141 -> 232
    //   94: iload 4
    //   96: ifeq +25 -> 121
    //   99: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   102: astore_0
    //   103: iload_3
    //   104: ifeq +121 -> 225
    //   107: ldc2_w 87
    //   110: lstore_1
    //   111: aload_0
    //   112: ldc2_w 81
    //   115: lload_1
    //   116: lconst_1
    //   117: iconst_0
    //   118: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   121: lload 7
    //   123: lstore 9
    //   125: lload 5
    //   127: lconst_0
    //   128: lcmp
    //   129: ifgt +30 -> 159
    //   132: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   135: astore_0
    //   136: iload 4
    //   138: ifeq +131 -> 269
    //   141: ldc2_w 89
    //   144: lstore_1
    //   145: aload_0
    //   146: ldc2_w 81
    //   149: lload_1
    //   150: lconst_1
    //   151: iconst_0
    //   152: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   155: lload 7
    //   157: lstore 9
    //   159: lload 9
    //   161: lreturn
    //   162: lload 5
    //   164: lstore 7
    //   166: getstatic 68	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   169: lload 5
    //   171: getstatic 93	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   174: invokevirtual 72	java/util/concurrent/TimeUnit:convert	(JLjava/util/concurrent/TimeUnit;)J
    //   177: lstore 9
    //   179: lload 9
    //   181: lstore 7
    //   183: goto -132 -> 51
    //   186: ldc2_w 94
    //   189: lstore_1
    //   190: goto -115 -> 75
    //   193: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   196: astore_0
    //   197: iload_3
    //   198: ifeq +20 -> 218
    //   201: ldc2_w 96
    //   204: lstore_1
    //   205: aload_0
    //   206: ldc2_w 81
    //   209: lload_1
    //   210: lconst_1
    //   211: iconst_0
    //   212: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   215: goto -130 -> 85
    //   218: ldc2_w 98
    //   221: lstore_1
    //   222: goto -17 -> 205
    //   225: ldc2_w 100
    //   228: lstore_1
    //   229: goto -118 -> 111
    //   232: iload 4
    //   234: ifne -113 -> 121
    //   237: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   240: astore_0
    //   241: iload_3
    //   242: ifeq +20 -> 262
    //   245: ldc2_w 102
    //   248: lstore_1
    //   249: aload_0
    //   250: ldc2_w 81
    //   253: lload_1
    //   254: lconst_1
    //   255: iconst_0
    //   256: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   259: goto -138 -> 121
    //   262: ldc2_w 104
    //   265: lstore_1
    //   266: goto -17 -> 249
    //   269: ldc2_w 106
    //   272: lstore_1
    //   273: goto -128 -> 145
    //   276: astore_0
    //   277: lconst_0
    //   278: lstore 5
    //   280: lload 5
    //   282: lstore 7
    //   284: ldc 109
    //   286: aload_0
    //   287: ldc 111
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 117	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: lconst_0
    //   297: lload_1
    //   298: lcmp
    //   299: ifle +30 -> 329
    //   302: iload 4
    //   304: ifeq +104 -> 408
    //   307: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   310: astore_0
    //   311: iload_3
    //   312: ifeq +89 -> 401
    //   315: ldc2_w 79
    //   318: lstore_1
    //   319: aload_0
    //   320: ldc2_w 81
    //   323: lload_1
    //   324: lconst_1
    //   325: iconst_0
    //   326: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   329: lload 5
    //   331: ldc2_w 61
    //   334: lcmp
    //   335: ifle +112 -> 447
    //   338: iload 4
    //   340: ifeq +25 -> 365
    //   343: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   346: astore_0
    //   347: iload_3
    //   348: ifeq +92 -> 440
    //   351: ldc2_w 87
    //   354: lstore_1
    //   355: aload_0
    //   356: ldc2_w 81
    //   359: lload_1
    //   360: lconst_1
    //   361: iconst_0
    //   362: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   365: lload 11
    //   367: lstore 9
    //   369: lload 5
    //   371: lconst_0
    //   372: lcmp
    //   373: ifgt -214 -> 159
    //   376: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   379: astore_0
    //   380: iload 4
    //   382: ifeq +102 -> 484
    //   385: ldc2_w 89
    //   388: lstore_1
    //   389: aload_0
    //   390: ldc2_w 81
    //   393: lload_1
    //   394: lconst_1
    //   395: iconst_0
    //   396: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   399: lconst_0
    //   400: lreturn
    //   401: ldc2_w 94
    //   404: lstore_1
    //   405: goto -86 -> 319
    //   408: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   411: astore_0
    //   412: iload_3
    //   413: ifeq +20 -> 433
    //   416: ldc2_w 96
    //   419: lstore_1
    //   420: aload_0
    //   421: ldc2_w 81
    //   424: lload_1
    //   425: lconst_1
    //   426: iconst_0
    //   427: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   430: goto -101 -> 329
    //   433: ldc2_w 98
    //   436: lstore_1
    //   437: goto -17 -> 420
    //   440: ldc2_w 100
    //   443: lstore_1
    //   444: goto -89 -> 355
    //   447: iload 4
    //   449: ifne -84 -> 365
    //   452: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   455: astore_0
    //   456: iload_3
    //   457: ifeq +20 -> 477
    //   460: ldc2_w 102
    //   463: lstore_1
    //   464: aload_0
    //   465: ldc2_w 81
    //   468: lload_1
    //   469: lconst_1
    //   470: iconst_0
    //   471: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   474: goto -109 -> 365
    //   477: ldc2_w 104
    //   480: lstore_1
    //   481: goto -17 -> 464
    //   484: ldc2_w 106
    //   487: lstore_1
    //   488: goto -99 -> 389
    //   491: astore_0
    //   492: lconst_0
    //   493: lstore 7
    //   495: lconst_0
    //   496: lload_1
    //   497: lcmp
    //   498: ifle +32 -> 530
    //   501: iload 4
    //   503: ifeq +106 -> 609
    //   506: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   509: astore 13
    //   511: iload_3
    //   512: ifeq +90 -> 602
    //   515: ldc2_w 79
    //   518: lstore_1
    //   519: aload 13
    //   521: ldc2_w 81
    //   524: lload_1
    //   525: lconst_1
    //   526: iconst_0
    //   527: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   530: lload 7
    //   532: ldc2_w 61
    //   535: lcmp
    //   536: ifle +114 -> 650
    //   539: iload 4
    //   541: ifeq +27 -> 568
    //   544: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   547: astore 13
    //   549: iload_3
    //   550: ifeq +93 -> 643
    //   553: ldc2_w 87
    //   556: lstore_1
    //   557: aload 13
    //   559: ldc2_w 81
    //   562: lload_1
    //   563: lconst_1
    //   564: iconst_0
    //   565: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   568: lload 7
    //   570: lconst_0
    //   571: lcmp
    //   572: ifgt +28 -> 600
    //   575: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   578: astore 13
    //   580: iload 4
    //   582: ifeq +107 -> 689
    //   585: ldc2_w 89
    //   588: lstore_1
    //   589: aload 13
    //   591: ldc2_w 81
    //   594: lload_1
    //   595: lconst_1
    //   596: iconst_0
    //   597: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   600: aload_0
    //   601: athrow
    //   602: ldc2_w 94
    //   605: lstore_1
    //   606: goto -87 -> 519
    //   609: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   612: astore 13
    //   614: iload_3
    //   615: ifeq +21 -> 636
    //   618: ldc2_w 96
    //   621: lstore_1
    //   622: aload 13
    //   624: ldc2_w 81
    //   627: lload_1
    //   628: lconst_1
    //   629: iconst_0
    //   630: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   633: goto -103 -> 530
    //   636: ldc2_w 98
    //   639: lstore_1
    //   640: goto -18 -> 622
    //   643: ldc2_w 100
    //   646: lstore_1
    //   647: goto -90 -> 557
    //   650: iload 4
    //   652: ifne -84 -> 568
    //   655: getstatic 78	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   658: astore 13
    //   660: iload_3
    //   661: ifeq +21 -> 682
    //   664: ldc2_w 102
    //   667: lstore_1
    //   668: aload 13
    //   670: ldc2_w 81
    //   673: lload_1
    //   674: lconst_1
    //   675: iconst_0
    //   676: invokevirtual 86	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   679: goto -111 -> 568
    //   682: ldc2_w 104
    //   685: lstore_1
    //   686: goto -18 -> 668
    //   689: ldc2_w 106
    //   692: lstore_1
    //   693: goto -104 -> 589
    //   696: astore_0
    //   697: goto -202 -> 495
    //   700: astore_0
    //   701: goto -421 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	paramString	String
    //   0	704	1	paramLong	long
    //   0	704	3	paramBoolean1	boolean
    //   0	704	4	paramBoolean2	boolean
    //   19	351	5	l1	long
    //   32	537	7	l2	long
    //   5	363	9	l3	long
    //   1	365	11	l4	long
    //   509	160	13	localg	com.tencent.mm.plugin.report.service.g
    // Exception table:
    //   from	to	target	type
    //   14	21	276	java/lang/NumberFormatException
    //   14	21	491	finally
    //   34	47	696	finally
    //   166	179	696	finally
    //   284	296	696	finally
    //   34	47	700	java/lang/NumberFormatException
    //   166	179	700	java/lang/NumberFormatException
  }
  
  protected static GalleryItem.AlbumItem a(Cursor paramCursor, int paramInt, String paramString)
  {
    Object localObject2 = null;
    long l = bu.aSC(paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id")));
    Object localObject1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow("_data"));
    String str1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
    String str2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(tQx));
    String str3 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(tQy));
    if (bu.isNullOrNil(str1))
    {
      ae.e("MicroMsg.BaseMediaQuery", "null or nil album name, ignore this folder");
      paramCursor = localObject2;
    }
    do
    {
      return paramCursor;
      int i = paramCursor.getInt(3);
      ae.i("MicroMsg.BaseMediaQuery", "%s(%s) path:%s", new Object[] { str1, Integer.valueOf(i), localObject1 });
      if ((i == 0) || (bu.isNullOrNil((String)localObject1)))
      {
        ae.e("MicroMsg.BaseMediaQuery", "query album failed, " + i + ", " + (String)localObject1);
        return null;
      }
      paramString = (String)localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        paramString = null;
      }
      localObject1 = GalleryItem.MediaItem.a(paramInt, l, paramString, null, paramCursor.getString(paramCursor.getColumnIndexOrThrow("mime_type")));
      a(str2, str3, paramInt, (GalleryItem.MediaItem)localObject1);
      paramString = new GalleryItem.AlbumItem(str1, i);
      paramString.DRo = ((GalleryItem.MediaItem)localObject1);
      paramString.DRn = paramCursor.getString(paramCursor.getColumnIndexOrThrow("bucket_id"));
      paramCursor = paramString;
    } while (bu.isNullOrNil(paramString.DRn));
    paramInt = bu.aSB(paramString.DRn);
    if (com.tencent.mm.plugin.gallery.a.d.ubo == paramInt) {
      paramString.bVF = ak.getContext().getString(2131759756);
    }
    for (;;)
    {
      localObject1 = (GalleryItem.a)e.cXo().get(paramInt);
      paramCursor = paramString;
      if (localObject1 == null) {
        break;
      }
      if (!((GalleryItem.a)localObject1).key.toLowerCase().equals("WeChatWork")) {
        break label461;
      }
      paramString.bVF = ak.getContext().getString(2131759755);
      return paramString;
      if (com.tencent.mm.plugin.gallery.a.d.ubp == paramInt) {
        paramString.bVF = ak.getContext().getString(2131759751);
      } else if (com.tencent.mm.plugin.gallery.a.d.ubq == paramInt) {
        paramString.bVF = ak.getContext().getString(2131759752);
      } else if (com.tencent.mm.plugin.gallery.a.d.ubr.contains(Integer.valueOf(paramInt))) {
        paramString.bVF = ak.getContext().getString(2131759753);
      } else if (com.tencent.mm.plugin.gallery.a.d.ubs.contains(Integer.valueOf(paramInt))) {
        paramString.bVF = ak.getContext().getString(2131759754);
      }
    }
    label461:
    paramString.bVF = ((GalleryItem.a)localObject1).tRH;
    return paramString;
  }
  
  private static void a(String paramString1, String paramString2, int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    boolean bool2 = true;
    long l2 = System.currentTimeMillis();
    boolean bool1;
    long l1;
    if (paramInt == 1)
    {
      bool1 = true;
      l1 = a(paramString1, l2, bool1, true);
      if (paramInt != 1) {
        break label73;
      }
      bool1 = bool2;
      label36:
      l2 = a(paramString2, l2, bool1, false);
      if (l1 <= 0L) {
        break label79;
      }
    }
    for (;;)
    {
      paramMediaItem.tRN = l1;
      paramMediaItem.tRO = l2;
      return;
      bool1 = false;
      break;
      label73:
      bool1 = false;
      break label36;
      label79:
      l1 = l2;
    }
  }
  
  static void ap(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    GalleryItem.MediaItem localMediaItem = null;
    Object localObject = paramLinkedList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)((Iterator)localObject).next();
      i += localAlbumItem.drZ;
      if (localMediaItem != null) {
        break label96;
      }
      localMediaItem = localAlbumItem.DRo;
    }
    label96:
    for (;;)
    {
      break;
      localObject = new GalleryItem.AlbumItem("", i);
      ((GalleryItem.AlbumItem)localObject).DRp = true;
      if (localMediaItem != null) {}
      for (((GalleryItem.AlbumItem)localObject).DRo = localMediaItem;; ((GalleryItem.AlbumItem)localObject).DRo = new GalleryItem.ImageMediaItem())
      {
        paramLinkedList.add(0, localObject);
        return;
      }
    }
  }
  
  protected static GalleryItem.MediaItem b(Cursor paramCursor, int paramInt)
  {
    Object localObject;
    if ((paramCursor == null) || (paramCursor.isAfterLast()) || (paramCursor.isClosed())) {
      localObject = null;
    }
    GalleryItem.MediaItem localMediaItem;
    double d;
    do
    {
      do
      {
        return localObject;
        for (;;)
        {
          try
          {
            if (paramCursor.isAfterLast()) {
              break label476;
            }
            if (paramCursor.getColumnIndexOrThrow("_id") >= 0)
            {
              long l = bu.aSC(paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id")));
              localObject = paramCursor.getString(paramCursor.getColumnIndexOrThrow("_data"));
              str1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(tQx));
              String str2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(tQy));
              localMediaItem = GalleryItem.MediaItem.aj(paramInt, l);
              localMediaItem.tRJ = ((String)localObject);
              a(str1, str2, paramInt, localMediaItem);
              if (com.tencent.mm.protocal.d.FFI)
              {
                ae.v("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + l + " " + str1 + " " + str2 + "] | " + localMediaItem.tRN + " " + paramInt);
                if ((!bu.isNullOrNil(localMediaItem.tRJ)) || (!bu.isNullOrNil(localMediaItem.ruE))) {
                  break;
                }
                ae.w("MicroMsg.BaseMediaQuery", "thumb file and original file both not exist");
                paramCursor.moveToNext();
              }
              else
              {
                ae.d("MicroMsg.BaseMediaQuery", "[mediaConvertFrom] [" + l + " " + str1 + " " + str2 + "] | " + localMediaItem.tRN + " " + paramInt);
              }
            }
          }
          catch (Throwable paramCursor)
          {
            ae.printErrStackTrace("MicroMsg.BaseMediaQuery", paramCursor, "", new Object[0]);
            return null;
          }
        }
        String str1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow("mime_type"));
        localObject = str1;
        if (bu.isNullOrNil(str1)) {
          localObject = "";
        }
        localMediaItem.mMimeType = ((String)localObject);
        paramInt = paramCursor.getColumnIndexOrThrow("latitude");
        if (paramCursor.getType(paramInt) != 0)
        {
          d = paramCursor.getDouble(paramInt);
          if (a.m(d)) {
            localMediaItem.bXD = d;
          }
        }
        paramInt = paramCursor.getColumnIndexOrThrow("longitude");
        localObject = localMediaItem;
      } while (paramCursor.getType(paramInt) == 0);
      d = paramCursor.getDouble(paramInt);
      localObject = localMediaItem;
    } while (!a.l(d));
    localMediaItem.bXE = d;
    return localMediaItem;
    label476:
    return null;
  }
  
  final boolean a(i.c paramc, LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    if (!this.tQz) {
      if (!paramBoolean) {
        break label69;
      }
    }
    label69:
    for (this.tQv = 200; (paramc != null) && (paramLinkedList.size() % this.tQv == 0); this.tQv = 5000)
    {
      ae.d("MicroMsg.BaseMediaQuery", "page notify, notifyCount: %d.", new Object[] { Integer.valueOf(this.tQv) });
      paramc.b(paramLinkedList, paramLong, paramBoolean);
      return true;
    }
    return false;
  }
  
  public String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    return null;
  }
  
  public String br(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public String[] cXc()
  {
    return new String[0];
  }
  
  public final void cXd()
  {
    this.tQz = true;
    this.tQv = 1000;
  }
  
  public final void cXe()
  {
    this.hmD = true;
  }
  
  public String[] getProjection()
  {
    return new String[0];
  }
  
  public String mP(boolean paramBoolean)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.b
 * JD-Core Version:    0.7.0.1
 */