package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Comparator;

public final class a
  extends b
  implements Comparator<GalleryItem.MediaItem>
{
  private final n HGo;
  private final v HGp;
  protected final ContentResolver dif;
  
  public a()
  {
    AppMethodBeat.i(111230);
    this.dif = MMApplicationContext.getContext().getContentResolver();
    this.HGo = new n();
    this.HGp = new v();
    AppMethodBeat.o(111230);
  }
  
  /* Error */
  private java.util.LinkedList<GalleryItem.AlbumItem> fzU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 57
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 59	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 60	java/util/LinkedList:<init>	()V
    //   15: astore 7
    //   17: new 62	java/util/HashMap
    //   20: dup
    //   21: invokespecial 63	java/util/HashMap:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   30: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   33: aload_0
    //   34: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   37: invokevirtual 73	com/tencent/mm/plugin/gallery/model/v:fzW	()[Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   44: invokevirtual 77	com/tencent/mm/plugin/gallery/model/v:fzX	()Ljava/lang/String;
    //   47: aconst_null
    //   48: aload_0
    //   49: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   52: invokevirtual 80	com/tencent/mm/plugin/gallery/model/v:fzY	()Ljava/lang/String;
    //   55: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 4
    //   60: aload 4
    //   62: ifnonnull +131 -> 193
    //   65: ldc 88
    //   67: ldc 90
    //   69: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_0
    //   75: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   78: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   81: aload_0
    //   82: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   85: invokevirtual 100	com/tencent/mm/plugin/gallery/model/n:fzW	()[Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   92: invokevirtual 101	com/tencent/mm/plugin/gallery/model/n:fzX	()Ljava/lang/String;
    //   95: aconst_null
    //   96: aload_0
    //   97: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   100: invokevirtual 102	com/tencent/mm/plugin/gallery/model/n:fzY	()Ljava/lang/String;
    //   103: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore 4
    //   108: aload 4
    //   110: ifnonnull +358 -> 468
    //   113: ldc 88
    //   115: ldc 104
    //   117: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 8
    //   122: invokevirtual 108	java/util/HashMap:isEmpty	()Z
    //   125: ifne +19 -> 144
    //   128: aload 7
    //   130: aload 8
    //   132: invokevirtual 112	java/util/HashMap:values	()Ljava/util/Collection;
    //   135: invokevirtual 116	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   138: pop
    //   139: aload 7
    //   141: invokestatic 122	java/util/Collections:sort	(Ljava/util/List;)V
    //   144: aload 7
    //   146: invokestatic 126	com/tencent/mm/plugin/gallery/model/a:bl	(Ljava/util/LinkedList;)V
    //   149: aload_3
    //   150: ifnull +10 -> 160
    //   153: aload 7
    //   155: iconst_1
    //   156: aload_3
    //   157: invokevirtual 130	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   160: ldc 57
    //   162: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 7
    //   167: areturn
    //   168: astore_3
    //   169: ldc 88
    //   171: ldc 132
    //   173: iconst_1
    //   174: anewarray 134	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_3
    //   180: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aconst_null
    //   188: astore 4
    //   190: goto -130 -> 60
    //   193: aload 4
    //   195: invokeinterface 146 1 0
    //   200: ifeq +526 -> 726
    //   203: aconst_null
    //   204: astore_3
    //   205: aload 4
    //   207: iconst_2
    //   208: ldc 148
    //   210: invokestatic 152	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   213: astore 6
    //   215: aload 6
    //   217: ifnull +503 -> 720
    //   220: aload 8
    //   222: aload 6
    //   224: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   227: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: ifnonnull +490 -> 720
    //   233: aload 8
    //   235: aload 6
    //   237: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   240: aload 6
    //   242: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload_3
    //   247: ifnonnull +473 -> 720
    //   250: aload 6
    //   252: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   255: astore_3
    //   256: aload 6
    //   258: ifnull +70 -> 328
    //   261: aload 8
    //   263: aload 6
    //   265: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   268: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   271: ifnull +57 -> 328
    //   274: aload 8
    //   276: aload 6
    //   278: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   281: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   284: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   287: astore 9
    //   289: aload 9
    //   291: aload 9
    //   293: getfield 174	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:AXs	I
    //   296: iconst_1
    //   297: iadd
    //   298: putfield 174	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:AXs	I
    //   301: aload 8
    //   303: aload 6
    //   305: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   308: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   314: astore 6
    //   316: aload 6
    //   318: aload 6
    //   320: getfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   323: iconst_1
    //   324: iadd
    //   325: putfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   328: aload 4
    //   330: invokeinterface 180 1 0
    //   335: ifne +388 -> 723
    //   338: aload 8
    //   340: invokevirtual 112	java/util/HashMap:values	()Ljava/util/Collection;
    //   343: invokeinterface 186 1 0
    //   348: astore 6
    //   350: iconst_0
    //   351: istore_1
    //   352: aload 6
    //   354: invokeinterface 191 1 0
    //   359: ifeq +22 -> 381
    //   362: aload 6
    //   364: invokeinterface 195 1 0
    //   369: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   372: getfield 174	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:AXs	I
    //   375: iload_1
    //   376: iadd
    //   377: istore_1
    //   378: goto -26 -> 352
    //   381: new 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   384: dup
    //   385: invokestatic 30	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   388: getstatic 200	com/tencent/mm/plugin/gallery/b$i:gallery_all_video	I
    //   391: invokevirtual 204	android/content/Context:getString	(I)Ljava/lang/String;
    //   394: iload_1
    //   395: invokespecial 207	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:<init>	(Ljava/lang/String;I)V
    //   398: astore 6
    //   400: aload 6
    //   402: iconst_1
    //   403: putfield 211	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akiv	Z
    //   406: aload 6
    //   408: aload_3
    //   409: putfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   412: aload 6
    //   414: astore_3
    //   415: aload 4
    //   417: invokeinterface 214 1 0
    //   422: goto -348 -> 74
    //   425: astore_3
    //   426: aload 4
    //   428: invokeinterface 214 1 0
    //   433: ldc 57
    //   435: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload_3
    //   439: athrow
    //   440: astore 4
    //   442: ldc 88
    //   444: ldc 216
    //   446: iconst_1
    //   447: anewarray 134	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: aload 4
    //   454: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: aastore
    //   458: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: aload 5
    //   463: astore 4
    //   465: goto -357 -> 108
    //   468: aload 4
    //   470: invokeinterface 146 1 0
    //   475: ifeq +96 -> 571
    //   478: aload 4
    //   480: iconst_1
    //   481: ldc 148
    //   483: invokestatic 152	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   486: astore 5
    //   488: aload 5
    //   490: ifnull +69 -> 559
    //   493: aload 8
    //   495: aload 5
    //   497: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   500: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   503: ifnonnull +78 -> 581
    //   506: aload 8
    //   508: aload 5
    //   510: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   513: aload 5
    //   515: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: aload 8
    //   521: aload 5
    //   523: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   526: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   529: ifnull +30 -> 559
    //   532: aload 8
    //   534: aload 5
    //   536: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   539: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   542: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   545: astore 5
    //   547: aload 5
    //   549: aload 5
    //   551: getfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   554: iconst_1
    //   555: iadd
    //   556: putfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   559: aload 4
    //   561: invokeinterface 180 1 0
    //   566: istore_2
    //   567: iload_2
    //   568: ifne -90 -> 478
    //   571: aload 4
    //   573: invokeinterface 214 1 0
    //   578: goto -458 -> 120
    //   581: aload 8
    //   583: aload 5
    //   585: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   588: invokevirtual 220	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   591: ifeq +88 -> 679
    //   594: aload 5
    //   596: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   599: ifnull +80 -> 679
    //   602: aload 8
    //   604: aload 5
    //   606: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   609: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   612: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   615: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   618: ifnull +61 -> 679
    //   621: aload 5
    //   623: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   626: aload 8
    //   628: aload 5
    //   630: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   633: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   636: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   639: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   642: invokevirtual 226	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:c	(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)I
    //   645: ifle +34 -> 679
    //   648: aload 8
    //   650: aload 5
    //   652: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   655: aload 5
    //   657: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   660: pop
    //   661: goto -142 -> 519
    //   664: astore_3
    //   665: aload 4
    //   667: invokeinterface 214 1 0
    //   672: ldc 57
    //   674: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   677: aload_3
    //   678: athrow
    //   679: ldc 88
    //   681: new 228	java/lang/StringBuilder
    //   684: dup
    //   685: ldc 230
    //   687: invokespecial 233	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   690: aload 5
    //   692: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   695: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc 239
    //   700: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 5
    //   705: getfield 242	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:albumName	Ljava/lang/String;
    //   708: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: goto -198 -> 519
    //   720: goto -464 -> 256
    //   723: goto -518 -> 205
    //   726: aconst_null
    //   727: astore_3
    //   728: goto -313 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	731	0	this	a
    //   351	44	1	i	int
    //   566	2	2	bool	boolean
    //   73	84	3	localObject1	java.lang.Object
    //   168	12	3	localException1	java.lang.Exception
    //   204	211	3	localObject2	java.lang.Object
    //   425	14	3	localObject3	java.lang.Object
    //   664	14	3	localObject4	java.lang.Object
    //   727	1	3	localObject5	java.lang.Object
    //   58	369	4	localCursor	android.database.Cursor
    //   440	13	4	localException2	java.lang.Exception
    //   463	203	4	localAlbumItem1	GalleryItem.AlbumItem
    //   1	703	5	localAlbumItem2	GalleryItem.AlbumItem
    //   213	200	6	localObject6	java.lang.Object
    //   15	151	7	localLinkedList	java.util.LinkedList
    //   24	625	8	localHashMap	java.util.HashMap
    //   287	5	9	localAlbumItem3	GalleryItem.AlbumItem
    // Exception table:
    //   from	to	target	type
    //   26	60	168	java/lang/Exception
    //   193	203	425	finally
    //   205	215	425	finally
    //   220	246	425	finally
    //   250	256	425	finally
    //   261	328	425	finally
    //   328	350	425	finally
    //   352	378	425	finally
    //   381	412	425	finally
    //   74	108	440	java/lang/Exception
    //   468	478	664	finally
    //   478	488	664	finally
    //   493	519	664	finally
    //   519	559	664	finally
    //   559	567	664	finally
    //   581	661	664	finally
    //   679	717	664	finally
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, l.c paramc, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 14
    //   17: aconst_null
    //   18: astore 22
    //   20: aconst_null
    //   21: astore 11
    //   23: aconst_null
    //   24: astore 19
    //   26: aconst_null
    //   27: astore 20
    //   29: aconst_null
    //   30: astore 16
    //   32: aconst_null
    //   33: astore 15
    //   35: aconst_null
    //   36: astore 17
    //   38: aconst_null
    //   39: astore 18
    //   41: aconst_null
    //   42: astore 21
    //   44: aconst_null
    //   45: astore 23
    //   47: aload 14
    //   49: astore 12
    //   51: aload 22
    //   53: astore 13
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 265	com/tencent/mm/plugin/gallery/model/a:nzW	Z
    //   60: aload 14
    //   62: astore 12
    //   64: aload 22
    //   66: astore 13
    //   68: new 59	java/util/LinkedList
    //   71: dup
    //   72: invokespecial 60	java/util/LinkedList:<init>	()V
    //   75: astore 25
    //   77: aload 14
    //   79: astore 12
    //   81: aload 22
    //   83: astore 13
    //   85: aload_1
    //   86: invokestatic 271	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   89: ifeq +658 -> 747
    //   92: iload_2
    //   93: iconst_1
    //   94: if_icmpeq +8 -> 102
    //   97: iload_2
    //   98: iconst_3
    //   99: if_icmpne +1538 -> 1637
    //   102: aload 14
    //   104: astore 12
    //   106: aload 22
    //   108: astore 13
    //   110: aload_0
    //   111: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   114: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   117: aload_0
    //   118: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   121: invokevirtual 274	com/tencent/mm/plugin/gallery/model/n:fzV	()[Ljava/lang/String;
    //   124: aload_0
    //   125: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   128: aload_0
    //   129: getfield 278	com/tencent/mm/plugin/gallery/model/a:HGr	[Ljava/lang/String;
    //   132: iconst_0
    //   133: invokevirtual 282	com/tencent/mm/plugin/gallery/model/n:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   136: aconst_null
    //   137: aload_0
    //   138: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   141: iconst_0
    //   142: invokevirtual 286	com/tencent/mm/plugin/gallery/model/n:vQ	(Z)Ljava/lang/String;
    //   145: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore 11
    //   150: aload 11
    //   152: astore 12
    //   154: aload 11
    //   156: astore 13
    //   158: aload 11
    //   160: astore 14
    //   162: aload_0
    //   163: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   166: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   169: aload_0
    //   170: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   173: invokevirtual 274	com/tencent/mm/plugin/gallery/model/n:fzV	()[Ljava/lang/String;
    //   176: aload_0
    //   177: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   180: aload_0
    //   181: getfield 278	com/tencent/mm/plugin/gallery/model/a:HGr	[Ljava/lang/String;
    //   184: iconst_1
    //   185: invokevirtual 282	com/tencent/mm/plugin/gallery/model/n:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   188: aconst_null
    //   189: aload_0
    //   190: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   193: iconst_1
    //   194: invokevirtual 286	com/tencent/mm/plugin/gallery/model/n:vQ	(Z)Ljava/lang/String;
    //   197: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   200: astore 10
    //   202: iload_2
    //   203: iconst_2
    //   204: if_icmpeq +16 -> 220
    //   207: aload 10
    //   209: astore 14
    //   211: aload 11
    //   213: astore 13
    //   215: iload_2
    //   216: iconst_3
    //   217: if_icmpne +1404 -> 1621
    //   220: aload 21
    //   222: astore 18
    //   224: aload 16
    //   226: astore 12
    //   228: aload 10
    //   230: astore 17
    //   232: aload 11
    //   234: astore 16
    //   236: aload 15
    //   238: astore 13
    //   240: aload 10
    //   242: astore 14
    //   244: aload 11
    //   246: astore 19
    //   248: aload 10
    //   250: astore 20
    //   252: aload 11
    //   254: astore 15
    //   256: aload_0
    //   257: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   260: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   263: aload_0
    //   264: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   267: invokevirtual 287	com/tencent/mm/plugin/gallery/model/v:fzV	()[Ljava/lang/String;
    //   270: aload_0
    //   271: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   274: iconst_1
    //   275: anewarray 289	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: aload_0
    //   281: getfield 278	com/tencent/mm/plugin/gallery/model/a:HGr	[Ljava/lang/String;
    //   284: iconst_0
    //   285: aaload
    //   286: aastore
    //   287: iconst_0
    //   288: invokevirtual 290	com/tencent/mm/plugin/gallery/model/v:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   291: aconst_null
    //   292: aload_0
    //   293: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   296: iconst_0
    //   297: invokevirtual 291	com/tencent/mm/plugin/gallery/model/v:vQ	(Z)Ljava/lang/String;
    //   300: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   303: astore 22
    //   305: aload 22
    //   307: astore 15
    //   309: aload 21
    //   311: astore 18
    //   313: aload 15
    //   315: astore 12
    //   317: aload 10
    //   319: astore 17
    //   321: aload 11
    //   323: astore 16
    //   325: aload 15
    //   327: astore 13
    //   329: aload 10
    //   331: astore 14
    //   333: aload 11
    //   335: astore 19
    //   337: aload 15
    //   339: astore 22
    //   341: aload 10
    //   343: astore 21
    //   345: aload 11
    //   347: astore 20
    //   349: aload_0
    //   350: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   353: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   356: aload_0
    //   357: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   360: invokevirtual 287	com/tencent/mm/plugin/gallery/model/v:fzV	()[Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   367: iconst_1
    //   368: anewarray 289	java/lang/String
    //   371: dup
    //   372: iconst_0
    //   373: aload_0
    //   374: getfield 278	com/tencent/mm/plugin/gallery/model/a:HGr	[Ljava/lang/String;
    //   377: iconst_0
    //   378: aaload
    //   379: aastore
    //   380: iconst_1
    //   381: invokevirtual 290	com/tencent/mm/plugin/gallery/model/v:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   384: aconst_null
    //   385: aload_0
    //   386: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   389: iconst_1
    //   390: invokevirtual 291	com/tencent/mm/plugin/gallery/model/v:vQ	(Z)Ljava/lang/String;
    //   393: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   396: astore 24
    //   398: aload 24
    //   400: astore 16
    //   402: aload 11
    //   404: astore 13
    //   406: aload 10
    //   408: astore 14
    //   410: aload 13
    //   412: ifnull +11 -> 423
    //   415: aload 13
    //   417: invokeinterface 146 1 0
    //   422: pop
    //   423: aload 14
    //   425: ifnull +11 -> 436
    //   428: aload 14
    //   430: invokeinterface 146 1 0
    //   435: pop
    //   436: aload 15
    //   438: ifnull +11 -> 449
    //   441: aload 15
    //   443: invokeinterface 146 1 0
    //   448: pop
    //   449: aload 16
    //   451: ifnull +11 -> 462
    //   454: aload 16
    //   456: invokeinterface 146 1 0
    //   461: pop
    //   462: aload 13
    //   464: iconst_1
    //   465: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   468: astore 10
    //   470: aload 14
    //   472: iconst_1
    //   473: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   476: astore 11
    //   478: aload 15
    //   480: iconst_2
    //   481: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   484: astore 12
    //   486: aload 16
    //   488: iconst_2
    //   489: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   492: astore 17
    //   494: iconst_1
    //   495: istore 9
    //   497: goto +1146 -> 1643
    //   500: aload 19
    //   502: astore 18
    //   504: aload 11
    //   506: ifnull +29 -> 535
    //   509: aload 19
    //   511: ifnull +1147 -> 1658
    //   514: aload 19
    //   516: astore 18
    //   518: aload 19
    //   520: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   523: aload 11
    //   525: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   528: lcmp
    //   529: ifge +6 -> 535
    //   532: goto +1126 -> 1658
    //   535: aload 18
    //   537: astore 19
    //   539: aload 12
    //   541: ifnull +29 -> 570
    //   544: aload 18
    //   546: ifnull +1119 -> 1665
    //   549: aload 18
    //   551: astore 19
    //   553: aload 18
    //   555: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   558: aload 12
    //   560: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   563: lcmp
    //   564: ifge +6 -> 570
    //   567: goto +1098 -> 1665
    //   570: aload 19
    //   572: astore 18
    //   574: aload 17
    //   576: ifnull +29 -> 605
    //   579: aload 19
    //   581: ifnull +1091 -> 1672
    //   584: aload 19
    //   586: astore 18
    //   588: aload 19
    //   590: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   593: aload 17
    //   595: getfield 298	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:HHK	J
    //   598: lcmp
    //   599: ifge +6 -> 605
    //   602: goto +1070 -> 1672
    //   605: aload 18
    //   607: ifnull +541 -> 1148
    //   610: aload 25
    //   612: aload 18
    //   614: invokevirtual 300	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   617: pop
    //   618: aload 18
    //   620: aload 10
    //   622: if_acmpne +416 -> 1038
    //   625: aload 13
    //   627: invokeinterface 180 1 0
    //   632: pop
    //   633: aload 13
    //   635: iconst_1
    //   636: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   639: astore 18
    //   641: aload 12
    //   643: astore 10
    //   645: aload 18
    //   647: astore 12
    //   649: iload 9
    //   651: istore 8
    //   653: aload_0
    //   654: aload_3
    //   655: aload 25
    //   657: lload 4
    //   659: iload 9
    //   661: invokevirtual 303	com/tencent/mm/plugin/gallery/model/a:a	(Lcom/tencent/mm/plugin/gallery/model/l$c;Ljava/util/LinkedList;JZ)Z
    //   664: ifeq +15 -> 679
    //   667: iload 9
    //   669: istore 8
    //   671: iload 9
    //   673: ifeq +6 -> 679
    //   676: iconst_0
    //   677: istore 8
    //   679: aload_0
    //   680: getfield 265	com/tencent/mm/plugin/gallery/model/a:nzW	Z
    //   683: istore 9
    //   685: iload 9
    //   687: ifeq +992 -> 1679
    //   690: aload 13
    //   692: ifnull +10 -> 702
    //   695: aload 13
    //   697: invokeinterface 214 1 0
    //   702: aload 14
    //   704: ifnull +10 -> 714
    //   707: aload 14
    //   709: invokeinterface 214 1 0
    //   714: aload 15
    //   716: ifnull +10 -> 726
    //   719: aload 15
    //   721: invokeinterface 214 1 0
    //   726: aload 16
    //   728: ifnull +10 -> 738
    //   731: aload 16
    //   733: invokeinterface 214 1 0
    //   738: ldc_w 256
    //   741: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: aload 25
    //   746: areturn
    //   747: iload_2
    //   748: iconst_1
    //   749: if_icmpeq +8 -> 757
    //   752: iload_2
    //   753: iconst_3
    //   754: if_icmpne +877 -> 1631
    //   757: aload 14
    //   759: astore 12
    //   761: aload 22
    //   763: astore 13
    //   765: aload_0
    //   766: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   769: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   772: aload_0
    //   773: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   776: invokevirtual 274	com/tencent/mm/plugin/gallery/model/n:fzV	()[Ljava/lang/String;
    //   779: aload_0
    //   780: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   783: aload_1
    //   784: iconst_0
    //   785: invokevirtual 307	com/tencent/mm/plugin/gallery/model/n:ce	(Ljava/lang/String;Z)Ljava/lang/String;
    //   788: aconst_null
    //   789: aload_0
    //   790: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   793: iconst_0
    //   794: invokevirtual 286	com/tencent/mm/plugin/gallery/model/n:vQ	(Z)Ljava/lang/String;
    //   797: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   800: astore 10
    //   802: aload 10
    //   804: astore 12
    //   806: aload 10
    //   808: astore 13
    //   810: aload 10
    //   812: astore 14
    //   814: aload_0
    //   815: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   818: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   821: aload_0
    //   822: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   825: invokevirtual 274	com/tencent/mm/plugin/gallery/model/n:fzV	()[Ljava/lang/String;
    //   828: aload_0
    //   829: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   832: aload_1
    //   833: iconst_1
    //   834: invokevirtual 307	com/tencent/mm/plugin/gallery/model/n:ce	(Ljava/lang/String;Z)Ljava/lang/String;
    //   837: aconst_null
    //   838: aload_0
    //   839: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   842: iconst_1
    //   843: invokevirtual 286	com/tencent/mm/plugin/gallery/model/n:vQ	(Z)Ljava/lang/String;
    //   846: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   849: astore 11
    //   851: iload_2
    //   852: iconst_2
    //   853: if_icmpeq +16 -> 869
    //   856: aload 11
    //   858: astore 14
    //   860: aload 10
    //   862: astore 13
    //   864: iload_2
    //   865: iconst_3
    //   866: if_icmpne +755 -> 1621
    //   869: aload 21
    //   871: astore 18
    //   873: aload 16
    //   875: astore 12
    //   877: aload 11
    //   879: astore 17
    //   881: aload 10
    //   883: astore 16
    //   885: aload 15
    //   887: astore 13
    //   889: aload 11
    //   891: astore 14
    //   893: aload 10
    //   895: astore 19
    //   897: aload 11
    //   899: astore 20
    //   901: aload 10
    //   903: astore 15
    //   905: aload_0
    //   906: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   909: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   912: aload_0
    //   913: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   916: invokevirtual 287	com/tencent/mm/plugin/gallery/model/v:fzV	()[Ljava/lang/String;
    //   919: aload_0
    //   920: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   923: aload_1
    //   924: iconst_0
    //   925: invokevirtual 308	com/tencent/mm/plugin/gallery/model/v:ce	(Ljava/lang/String;Z)Ljava/lang/String;
    //   928: aconst_null
    //   929: aload_0
    //   930: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   933: iconst_0
    //   934: invokevirtual 291	com/tencent/mm/plugin/gallery/model/v:vQ	(Z)Ljava/lang/String;
    //   937: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   940: astore 22
    //   942: aload 22
    //   944: astore 15
    //   946: aload 21
    //   948: astore 18
    //   950: aload 15
    //   952: astore 12
    //   954: aload 11
    //   956: astore 17
    //   958: aload 10
    //   960: astore 16
    //   962: aload 15
    //   964: astore 13
    //   966: aload 11
    //   968: astore 14
    //   970: aload 10
    //   972: astore 19
    //   974: aload 15
    //   976: astore 22
    //   978: aload 11
    //   980: astore 21
    //   982: aload 10
    //   984: astore 20
    //   986: aload_0
    //   987: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   990: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   993: aload_0
    //   994: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   997: invokevirtual 287	com/tencent/mm/plugin/gallery/model/v:fzV	()[Ljava/lang/String;
    //   1000: aload_0
    //   1001: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   1004: aload_1
    //   1005: iconst_1
    //   1006: invokevirtual 308	com/tencent/mm/plugin/gallery/model/v:ce	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1009: aconst_null
    //   1010: aload_0
    //   1011: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   1014: iconst_1
    //   1015: invokevirtual 291	com/tencent/mm/plugin/gallery/model/v:vQ	(Z)Ljava/lang/String;
    //   1018: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1021: astore 24
    //   1023: aload 24
    //   1025: astore 16
    //   1027: aload 11
    //   1029: astore 14
    //   1031: aload 10
    //   1033: astore 13
    //   1035: goto -625 -> 410
    //   1038: aload 18
    //   1040: aload 11
    //   1042: if_acmpne +34 -> 1076
    //   1045: aload 14
    //   1047: invokeinterface 180 1 0
    //   1052: pop
    //   1053: aload 14
    //   1055: iconst_1
    //   1056: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1059: astore 11
    //   1061: aload 10
    //   1063: astore 18
    //   1065: aload 12
    //   1067: astore 10
    //   1069: aload 18
    //   1071: astore 12
    //   1073: goto -424 -> 649
    //   1076: aload 18
    //   1078: aload 12
    //   1080: if_acmpne +30 -> 1110
    //   1083: aload 15
    //   1085: invokeinterface 180 1 0
    //   1090: pop
    //   1091: aload 15
    //   1093: iconst_2
    //   1094: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1097: astore 18
    //   1099: aload 10
    //   1101: astore 12
    //   1103: aload 18
    //   1105: astore 10
    //   1107: goto -458 -> 649
    //   1110: aload 18
    //   1112: aload 17
    //   1114: if_acmpne +492 -> 1606
    //   1117: aload 16
    //   1119: invokeinterface 180 1 0
    //   1124: pop
    //   1125: aload 16
    //   1127: iconst_2
    //   1128: invokestatic 294	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1131: astore 17
    //   1133: aload 10
    //   1135: astore 18
    //   1137: aload 12
    //   1139: astore 10
    //   1141: aload 18
    //   1143: astore 12
    //   1145: goto -496 -> 649
    //   1148: ldc 88
    //   1150: ldc_w 310
    //   1153: iconst_1
    //   1154: anewarray 134	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: aload 25
    //   1161: invokevirtual 314	java/util/LinkedList:size	()I
    //   1164: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1167: aastore
    //   1168: invokestatic 322	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1171: aload_3
    //   1172: aload 25
    //   1174: lload 4
    //   1176: iload 9
    //   1178: invokeinterface 327 5 0
    //   1183: ldc 88
    //   1185: ldc_w 329
    //   1188: iconst_5
    //   1189: anewarray 134	java/lang/Object
    //   1192: dup
    //   1193: iconst_0
    //   1194: aload_1
    //   1195: aastore
    //   1196: dup
    //   1197: iconst_1
    //   1198: iload_2
    //   1199: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1202: aastore
    //   1203: dup
    //   1204: iconst_2
    //   1205: aload 25
    //   1207: invokevirtual 314	java/util/LinkedList:size	()I
    //   1210: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1213: aastore
    //   1214: dup
    //   1215: iconst_3
    //   1216: lload 4
    //   1218: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1221: aastore
    //   1222: dup
    //   1223: iconst_4
    //   1224: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   1227: lload 6
    //   1229: lsub
    //   1230: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1233: aastore
    //   1234: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1237: aload 13
    //   1239: ifnull +10 -> 1249
    //   1242: aload 13
    //   1244: invokeinterface 214 1 0
    //   1249: aload 14
    //   1251: ifnull +10 -> 1261
    //   1254: aload 14
    //   1256: invokeinterface 214 1 0
    //   1261: aload 15
    //   1263: ifnull +10 -> 1273
    //   1266: aload 15
    //   1268: invokeinterface 214 1 0
    //   1273: aload 16
    //   1275: ifnull +10 -> 1285
    //   1278: aload 16
    //   1280: invokeinterface 214 1 0
    //   1285: ldc_w 256
    //   1288: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1291: aload 25
    //   1293: areturn
    //   1294: astore_1
    //   1295: aconst_null
    //   1296: astore_3
    //   1297: aconst_null
    //   1298: astore 10
    //   1300: aconst_null
    //   1301: astore 11
    //   1303: aconst_null
    //   1304: astore 12
    //   1306: aload 12
    //   1308: astore 13
    //   1310: aload 11
    //   1312: astore 14
    //   1314: aload 10
    //   1316: astore 15
    //   1318: aload_3
    //   1319: astore 18
    //   1321: aload 15
    //   1323: astore 12
    //   1325: aload 14
    //   1327: astore 17
    //   1329: aload 13
    //   1331: astore 16
    //   1333: ldc 88
    //   1335: aload_1
    //   1336: ldc_w 338
    //   1339: iconst_0
    //   1340: anewarray 134	java/lang/Object
    //   1343: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1346: aload 13
    //   1348: ifnull +10 -> 1358
    //   1351: aload 13
    //   1353: invokeinterface 214 1 0
    //   1358: aload 14
    //   1360: ifnull +10 -> 1370
    //   1363: aload 14
    //   1365: invokeinterface 214 1 0
    //   1370: aload 15
    //   1372: ifnull +10 -> 1382
    //   1375: aload 15
    //   1377: invokeinterface 214 1 0
    //   1382: aload_3
    //   1383: ifnull +9 -> 1392
    //   1386: aload_3
    //   1387: invokeinterface 214 1 0
    //   1392: new 59	java/util/LinkedList
    //   1395: dup
    //   1396: invokespecial 60	java/util/LinkedList:<init>	()V
    //   1399: astore_1
    //   1400: ldc_w 256
    //   1403: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1406: aload_1
    //   1407: areturn
    //   1408: astore_1
    //   1409: aconst_null
    //   1410: astore 14
    //   1412: aload 12
    //   1414: astore 13
    //   1416: aload 20
    //   1418: astore 12
    //   1420: aload 13
    //   1422: ifnull +10 -> 1432
    //   1425: aload 13
    //   1427: invokeinterface 214 1 0
    //   1432: aload 14
    //   1434: ifnull +10 -> 1444
    //   1437: aload 14
    //   1439: invokeinterface 214 1 0
    //   1444: aload 12
    //   1446: ifnull +10 -> 1456
    //   1449: aload 12
    //   1451: invokeinterface 214 1 0
    //   1456: aload 18
    //   1458: ifnull +10 -> 1468
    //   1461: aload 18
    //   1463: invokeinterface 214 1 0
    //   1468: ldc_w 256
    //   1471: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1474: aload_1
    //   1475: athrow
    //   1476: astore_1
    //   1477: aload 17
    //   1479: astore 14
    //   1481: aload 16
    //   1483: astore 13
    //   1485: goto -65 -> 1420
    //   1488: astore_1
    //   1489: aload 16
    //   1491: astore 18
    //   1493: aload 15
    //   1495: astore 12
    //   1497: goto -77 -> 1420
    //   1500: astore_1
    //   1501: aconst_null
    //   1502: astore 14
    //   1504: aload 23
    //   1506: astore_3
    //   1507: aload 19
    //   1509: astore 15
    //   1511: goto -193 -> 1318
    //   1514: astore_1
    //   1515: aload 23
    //   1517: astore_3
    //   1518: aload 13
    //   1520: astore 15
    //   1522: aload 19
    //   1524: astore 13
    //   1526: goto -208 -> 1318
    //   1529: astore_1
    //   1530: aload 16
    //   1532: astore_3
    //   1533: goto -215 -> 1318
    //   1536: astore_1
    //   1537: aconst_null
    //   1538: astore_3
    //   1539: aconst_null
    //   1540: astore 10
    //   1542: aconst_null
    //   1543: astore 11
    //   1545: aload 14
    //   1547: astore 12
    //   1549: goto -243 -> 1306
    //   1552: astore_1
    //   1553: aconst_null
    //   1554: astore_3
    //   1555: aconst_null
    //   1556: astore 10
    //   1558: aload 20
    //   1560: astore 11
    //   1562: aload 15
    //   1564: astore 12
    //   1566: goto -260 -> 1306
    //   1569: astore_1
    //   1570: aconst_null
    //   1571: astore_3
    //   1572: aload 22
    //   1574: astore 10
    //   1576: aload 21
    //   1578: astore 11
    //   1580: aload 20
    //   1582: astore 12
    //   1584: goto -278 -> 1306
    //   1587: astore_1
    //   1588: aload 16
    //   1590: astore_3
    //   1591: aload 15
    //   1593: astore 10
    //   1595: aload 14
    //   1597: astore 11
    //   1599: aload 13
    //   1601: astore 12
    //   1603: goto -297 -> 1306
    //   1606: aload 10
    //   1608: astore 18
    //   1610: aload 12
    //   1612: astore 10
    //   1614: aload 18
    //   1616: astore 12
    //   1618: goto -969 -> 649
    //   1621: aconst_null
    //   1622: astore 16
    //   1624: aload 17
    //   1626: astore 15
    //   1628: goto -1218 -> 410
    //   1631: aconst_null
    //   1632: astore 11
    //   1634: goto -783 -> 851
    //   1637: aconst_null
    //   1638: astore 10
    //   1640: goto -1438 -> 202
    //   1643: aconst_null
    //   1644: astore 19
    //   1646: aload 10
    //   1648: ifnull -1148 -> 500
    //   1651: aload 10
    //   1653: astore 19
    //   1655: goto -1155 -> 500
    //   1658: aload 11
    //   1660: astore 18
    //   1662: goto -1127 -> 535
    //   1665: aload 12
    //   1667: astore 19
    //   1669: goto -1099 -> 570
    //   1672: aload 17
    //   1674: astore 18
    //   1676: goto -1071 -> 605
    //   1679: aload 12
    //   1681: astore 18
    //   1683: aload 10
    //   1685: astore 12
    //   1687: aload 18
    //   1689: astore 10
    //   1691: iload 8
    //   1693: istore 9
    //   1695: goto -52 -> 1643
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1698	0	this	a
    //   0	1698	1	paramString	String
    //   0	1698	2	paramInt	int
    //   0	1698	3	paramc	l.c
    //   0	1698	4	paramLong	long
    //   9	1219	6	l	long
    //   651	1041	8	bool1	boolean
    //   495	1199	9	bool2	boolean
    //   12	1678	10	localObject1	java.lang.Object
    //   21	1638	11	localObject2	java.lang.Object
    //   49	1637	12	localObject3	java.lang.Object
    //   53	1547	13	localObject4	java.lang.Object
    //   15	1581	14	localObject5	java.lang.Object
    //   33	1594	15	localObject6	java.lang.Object
    //   30	1593	16	localObject7	java.lang.Object
    //   36	1637	17	localObject8	java.lang.Object
    //   39	1649	18	localObject9	java.lang.Object
    //   24	1644	19	localObject10	java.lang.Object
    //   27	1554	20	localObject11	java.lang.Object
    //   42	1535	21	localObject12	java.lang.Object
    //   18	1555	22	localObject13	java.lang.Object
    //   45	1471	23	localObject14	java.lang.Object
    //   396	628	24	localCursor	android.database.Cursor
    //   75	1217	25	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   55	60	1294	android/database/sqlite/SQLiteDiskIOException
    //   68	77	1294	android/database/sqlite/SQLiteDiskIOException
    //   85	92	1294	android/database/sqlite/SQLiteDiskIOException
    //   110	150	1294	android/database/sqlite/SQLiteDiskIOException
    //   765	802	1294	android/database/sqlite/SQLiteDiskIOException
    //   55	60	1408	finally
    //   68	77	1408	finally
    //   85	92	1408	finally
    //   110	150	1408	finally
    //   162	202	1408	finally
    //   765	802	1408	finally
    //   814	851	1408	finally
    //   256	305	1476	finally
    //   349	398	1476	finally
    //   905	942	1476	finally
    //   986	1023	1476	finally
    //   1333	1346	1476	finally
    //   415	423	1488	finally
    //   428	436	1488	finally
    //   441	449	1488	finally
    //   454	462	1488	finally
    //   462	494	1488	finally
    //   518	532	1488	finally
    //   553	567	1488	finally
    //   588	602	1488	finally
    //   610	618	1488	finally
    //   625	641	1488	finally
    //   653	667	1488	finally
    //   679	685	1488	finally
    //   1045	1061	1488	finally
    //   1083	1099	1488	finally
    //   1117	1133	1488	finally
    //   1148	1237	1488	finally
    //   55	60	1500	java/lang/NullPointerException
    //   68	77	1500	java/lang/NullPointerException
    //   85	92	1500	java/lang/NullPointerException
    //   110	150	1500	java/lang/NullPointerException
    //   162	202	1500	java/lang/NullPointerException
    //   765	802	1500	java/lang/NullPointerException
    //   814	851	1500	java/lang/NullPointerException
    //   256	305	1514	java/lang/NullPointerException
    //   349	398	1514	java/lang/NullPointerException
    //   905	942	1514	java/lang/NullPointerException
    //   986	1023	1514	java/lang/NullPointerException
    //   415	423	1529	java/lang/NullPointerException
    //   428	436	1529	java/lang/NullPointerException
    //   441	449	1529	java/lang/NullPointerException
    //   454	462	1529	java/lang/NullPointerException
    //   462	494	1529	java/lang/NullPointerException
    //   518	532	1529	java/lang/NullPointerException
    //   553	567	1529	java/lang/NullPointerException
    //   588	602	1529	java/lang/NullPointerException
    //   610	618	1529	java/lang/NullPointerException
    //   625	641	1529	java/lang/NullPointerException
    //   653	667	1529	java/lang/NullPointerException
    //   679	685	1529	java/lang/NullPointerException
    //   1045	1061	1529	java/lang/NullPointerException
    //   1083	1099	1529	java/lang/NullPointerException
    //   1117	1133	1529	java/lang/NullPointerException
    //   1148	1237	1529	java/lang/NullPointerException
    //   162	202	1536	android/database/sqlite/SQLiteDiskIOException
    //   814	851	1536	android/database/sqlite/SQLiteDiskIOException
    //   256	305	1552	android/database/sqlite/SQLiteDiskIOException
    //   905	942	1552	android/database/sqlite/SQLiteDiskIOException
    //   349	398	1569	android/database/sqlite/SQLiteDiskIOException
    //   986	1023	1569	android/database/sqlite/SQLiteDiskIOException
    //   415	423	1587	android/database/sqlite/SQLiteDiskIOException
    //   428	436	1587	android/database/sqlite/SQLiteDiskIOException
    //   441	449	1587	android/database/sqlite/SQLiteDiskIOException
    //   454	462	1587	android/database/sqlite/SQLiteDiskIOException
    //   462	494	1587	android/database/sqlite/SQLiteDiskIOException
    //   518	532	1587	android/database/sqlite/SQLiteDiskIOException
    //   553	567	1587	android/database/sqlite/SQLiteDiskIOException
    //   588	602	1587	android/database/sqlite/SQLiteDiskIOException
    //   610	618	1587	android/database/sqlite/SQLiteDiskIOException
    //   625	641	1587	android/database/sqlite/SQLiteDiskIOException
    //   653	667	1587	android/database/sqlite/SQLiteDiskIOException
    //   679	685	1587	android/database/sqlite/SQLiteDiskIOException
    //   1045	1061	1587	android/database/sqlite/SQLiteDiskIOException
    //   1083	1099	1587	android/database/sqlite/SQLiteDiskIOException
    //   1117	1133	1587	android/database/sqlite/SQLiteDiskIOException
    //   1148	1237	1587	android/database/sqlite/SQLiteDiskIOException
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.AlbumItem> fzT()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 351
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 356	com/tencent/mm/plugin/gallery/b/h:fBW	()Z
    //   12: ifeq +18 -> 30
    //   15: aload_0
    //   16: invokespecial 358	com/tencent/mm/plugin/gallery/model/a:fzU	()Ljava/util/LinkedList;
    //   19: astore 4
    //   21: ldc_w 351
    //   24: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload 4
    //   29: areturn
    //   30: new 62	java/util/HashMap
    //   33: dup
    //   34: invokespecial 63	java/util/HashMap:<init>	()V
    //   37: astore 8
    //   39: new 59	java/util/LinkedList
    //   42: dup
    //   43: invokespecial 60	java/util/LinkedList:<init>	()V
    //   46: astore 9
    //   48: aload_0
    //   49: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   52: getstatic 69	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: aload_0
    //   56: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   59: invokevirtual 73	com/tencent/mm/plugin/gallery/model/v:fzW	()[Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   66: invokevirtual 77	com/tencent/mm/plugin/gallery/model/v:fzX	()Ljava/lang/String;
    //   69: aconst_null
    //   70: aload_0
    //   71: getfield 48	com/tencent/mm/plugin/gallery/model/a:HGp	Lcom/tencent/mm/plugin/gallery/model/v;
    //   74: invokevirtual 80	com/tencent/mm/plugin/gallery/model/v:fzY	()Ljava/lang/String;
    //   77: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnonnull +137 -> 221
    //   87: ldc 88
    //   89: ldc 90
    //   91: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aconst_null
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 38	com/tencent/mm/plugin/gallery/model/a:dif	Landroid/content/ContentResolver;
    //   101: getstatic 99	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   104: aload_0
    //   105: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   108: invokevirtual 100	com/tencent/mm/plugin/gallery/model/n:fzW	()[Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   115: invokevirtual 101	com/tencent/mm/plugin/gallery/model/n:fzX	()Ljava/lang/String;
    //   118: aconst_null
    //   119: aload_0
    //   120: getfield 43	com/tencent/mm/plugin/gallery/model/a:HGo	Lcom/tencent/mm/plugin/gallery/model/n;
    //   123: invokevirtual 102	com/tencent/mm/plugin/gallery/model/n:fzY	()Ljava/lang/String;
    //   126: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnonnull +265 -> 398
    //   136: ldc 88
    //   138: ldc 104
    //   140: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 8
    //   145: invokevirtual 108	java/util/HashMap:isEmpty	()Z
    //   148: ifne +19 -> 167
    //   151: aload 9
    //   153: aload 8
    //   155: invokevirtual 112	java/util/HashMap:values	()Ljava/util/Collection;
    //   158: invokevirtual 116	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   161: pop
    //   162: aload 9
    //   164: invokestatic 122	java/util/Collections:sort	(Ljava/util/List;)V
    //   167: aload 9
    //   169: invokestatic 126	com/tencent/mm/plugin/gallery/model/a:bl	(Ljava/util/LinkedList;)V
    //   172: aload 4
    //   174: ifnull +11 -> 185
    //   177: aload 9
    //   179: iconst_1
    //   180: aload 4
    //   182: invokevirtual 130	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   185: ldc_w 351
    //   188: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload 9
    //   193: areturn
    //   194: astore 4
    //   196: ldc 88
    //   198: ldc 132
    //   200: iconst_1
    //   201: anewarray 134	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 4
    //   208: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: aastore
    //   212: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aconst_null
    //   216: astore 5
    //   218: goto -136 -> 82
    //   221: aload 5
    //   223: invokeinterface 146 1 0
    //   228: ifeq +272 -> 500
    //   231: aconst_null
    //   232: astore 6
    //   234: iconst_0
    //   235: istore_1
    //   236: aload 5
    //   238: iconst_2
    //   239: ldc 148
    //   241: invokestatic 152	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   244: astore 10
    //   246: aload 6
    //   248: astore 4
    //   250: iload_1
    //   251: istore_3
    //   252: aload 10
    //   254: ifnull +54 -> 308
    //   257: iload_1
    //   258: istore_2
    //   259: aload 10
    //   261: getfield 361	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akiw	Z
    //   264: ifne +11 -> 275
    //   267: iload_1
    //   268: aload 10
    //   270: getfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   273: iadd
    //   274: istore_2
    //   275: aload 8
    //   277: aload 10
    //   279: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   282: aload 10
    //   284: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: aload 6
    //   290: astore 4
    //   292: iload_2
    //   293: istore_3
    //   294: aload 6
    //   296: ifnonnull +12 -> 308
    //   299: aload 10
    //   301: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   304: astore 4
    //   306: iload_2
    //   307: istore_3
    //   308: aload 4
    //   310: astore 6
    //   312: iload_3
    //   313: istore_1
    //   314: aload 5
    //   316: invokeinterface 180 1 0
    //   321: ifne -85 -> 236
    //   324: new 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   327: dup
    //   328: invokestatic 30	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   331: getstatic 200	com/tencent/mm/plugin/gallery/b$i:gallery_all_video	I
    //   334: invokevirtual 204	android/content/Context:getString	(I)Ljava/lang/String;
    //   337: iload_3
    //   338: invokespecial 207	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:<init>	(Ljava/lang/String;I)V
    //   341: astore 6
    //   343: aload 6
    //   345: iconst_1
    //   346: putfield 211	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akiv	Z
    //   349: aload 6
    //   351: aload 4
    //   353: putfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:HHB	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   356: aload 6
    //   358: astore 4
    //   360: aload 5
    //   362: invokeinterface 214 1 0
    //   367: goto -270 -> 97
    //   370: astore 5
    //   372: ldc 88
    //   374: ldc 216
    //   376: iconst_1
    //   377: anewarray 134	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload 5
    //   384: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   387: aastore
    //   388: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   391: aload 7
    //   393: astore 5
    //   395: goto -264 -> 131
    //   398: aload 5
    //   400: invokeinterface 146 1 0
    //   405: ifeq +85 -> 490
    //   408: aload 5
    //   410: iconst_1
    //   411: ldc 148
    //   413: invokestatic 152	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +60 -> 480
    //   423: aload 8
    //   425: aload 6
    //   427: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   430: invokevirtual 162	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   433: checkcast 154	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   436: astore 7
    //   438: aload 7
    //   440: ifnull +32 -> 472
    //   443: aload 6
    //   445: getfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   448: istore_1
    //   449: aload 6
    //   451: aload 7
    //   453: getfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   456: iload_1
    //   457: iadd
    //   458: putfield 177	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:hGP	I
    //   461: aload 8
    //   463: aload 6
    //   465: getfield 158	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   468: invokevirtual 364	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 9
    //   474: aload 6
    //   476: invokevirtual 300	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   479: pop
    //   480: aload 5
    //   482: invokeinterface 180 1 0
    //   487: ifne -79 -> 408
    //   490: aload 5
    //   492: invokeinterface 214 1 0
    //   497: goto -354 -> 143
    //   500: aconst_null
    //   501: astore 4
    //   503: goto -143 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	a
    //   235	223	1	i	int
    //   258	49	2	j	int
    //   251	87	3	k	int
    //   19	162	4	localLinkedList1	java.util.LinkedList
    //   194	13	4	localException1	java.lang.Exception
    //   248	254	4	localObject1	java.lang.Object
    //   80	281	5	localCursor	android.database.Cursor
    //   370	13	5	localException2	java.lang.Exception
    //   393	98	5	localAlbumItem1	GalleryItem.AlbumItem
    //   232	243	6	localObject2	java.lang.Object
    //   1	451	7	localAlbumItem2	GalleryItem.AlbumItem
    //   37	425	8	localHashMap	java.util.HashMap
    //   46	427	9	localLinkedList2	java.util.LinkedList
    //   244	56	10	localAlbumItem3	GalleryItem.AlbumItem
    // Exception table:
    //   from	to	target	type
    //   48	82	194	java/lang/Exception
    //   97	131	370	java/lang/Exception
  }
  
  public final String vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(111231);
    if (paramBoolean)
    {
      str = b.HGt + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111231);
      return str;
    }
    String str = b.HGs + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a
 * JD-Core Version:    0.7.0.1
 */