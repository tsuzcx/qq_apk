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
  protected final ContentResolver bEK;
  private final k xhG;
  private final u xhH;
  
  public a()
  {
    AppMethodBeat.i(111230);
    this.bEK = MMApplicationContext.getContext().getContentResolver();
    this.xhG = new k();
    this.xhH = new u();
    AppMethodBeat.o(111230);
  }
  
  /* Error */
  private java.util.LinkedList<GalleryItem.AlbumItem> dQs()
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
    //   17: new 62	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 63	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: new 65	java/util/HashMap
    //   29: dup
    //   30: invokespecial 66	java/util/HashMap:<init>	()V
    //   33: astore 9
    //   35: aload_0
    //   36: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   39: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   42: aload_0
    //   43: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   46: invokevirtual 76	com/tencent/mm/plugin/gallery/model/u:dQt	()[Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   53: invokevirtual 80	com/tencent/mm/plugin/gallery/model/u:dQu	()Ljava/lang/String;
    //   56: aconst_null
    //   57: aload_0
    //   58: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   61: invokevirtual 83	com/tencent/mm/plugin/gallery/model/u:dQv	()Ljava/lang/String;
    //   64: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnonnull +131 -> 202
    //   74: ldc 91
    //   76: ldc 93
    //   78: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aconst_null
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   87: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   90: aload_0
    //   91: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   94: invokevirtual 103	com/tencent/mm/plugin/gallery/model/k:dQt	()[Ljava/lang/String;
    //   97: aload_0
    //   98: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   101: invokevirtual 104	com/tencent/mm/plugin/gallery/model/k:dQu	()Ljava/lang/String;
    //   104: aconst_null
    //   105: aload_0
    //   106: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   109: invokevirtual 105	com/tencent/mm/plugin/gallery/model/k:dQv	()Ljava/lang/String;
    //   112: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore 4
    //   117: aload 4
    //   119: ifnonnull +300 -> 419
    //   122: ldc 91
    //   124: ldc 107
    //   126: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 9
    //   131: invokevirtual 111	java/util/HashMap:isEmpty	()Z
    //   134: ifne +19 -> 153
    //   137: aload 7
    //   139: aload 9
    //   141: invokevirtual 115	java/util/HashMap:values	()Ljava/util/Collection;
    //   144: invokevirtual 119	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   147: pop
    //   148: aload 7
    //   150: invokestatic 125	java/util/Collections:sort	(Ljava/util/List;)V
    //   153: aload 7
    //   155: invokestatic 129	com/tencent/mm/plugin/gallery/model/a:aK	(Ljava/util/LinkedList;)V
    //   158: aload_3
    //   159: ifnull +10 -> 169
    //   162: aload 7
    //   164: iconst_1
    //   165: aload_3
    //   166: invokevirtual 133	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   169: ldc 57
    //   171: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 7
    //   176: areturn
    //   177: astore_3
    //   178: ldc 91
    //   180: ldc 135
    //   182: iconst_1
    //   183: anewarray 137	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_3
    //   189: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aconst_null
    //   197: astore 4
    //   199: goto -130 -> 69
    //   202: aload 4
    //   204: invokeinterface 149 1 0
    //   209: ifeq +319 -> 528
    //   212: aconst_null
    //   213: astore_3
    //   214: aload 4
    //   216: iconst_2
    //   217: ldc 151
    //   219: invokestatic 155	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   222: astore 6
    //   224: aload 6
    //   226: ifnull +296 -> 522
    //   229: aload 8
    //   231: aload 6
    //   233: getfield 161	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:albumName	Ljava/lang/String;
    //   236: invokeinterface 167 2 0
    //   241: ifne +281 -> 522
    //   244: aload 9
    //   246: aload 6
    //   248: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   251: aload 6
    //   253: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload 8
    //   259: aload 6
    //   261: getfield 161	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:albumName	Ljava/lang/String;
    //   264: invokeinterface 176 2 0
    //   269: pop
    //   270: aload_3
    //   271: ifnonnull +251 -> 522
    //   274: aload 6
    //   276: getfield 180	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpZ	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   279: astore_3
    //   280: aload 4
    //   282: invokeinterface 183 1 0
    //   287: ifne +238 -> 525
    //   290: aload 9
    //   292: invokevirtual 115	java/util/HashMap:values	()Ljava/util/Collection;
    //   295: invokeinterface 189 1 0
    //   300: astore 6
    //   302: iconst_0
    //   303: istore_1
    //   304: aload 6
    //   306: invokeinterface 194 1 0
    //   311: ifeq +22 -> 333
    //   314: aload 6
    //   316: invokeinterface 198 1 0
    //   321: checkcast 157	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   324: getfield 202	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:xiP	I
    //   327: iload_1
    //   328: iadd
    //   329: istore_1
    //   330: goto -26 -> 304
    //   333: new 157	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   336: dup
    //   337: invokestatic 30	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   340: ldc 203
    //   342: invokevirtual 207	android/content/Context:getString	(I)Ljava/lang/String;
    //   345: iload_1
    //   346: invokespecial 210	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:<init>	(Ljava/lang/String;I)V
    //   349: astore 6
    //   351: aload 6
    //   353: iconst_1
    //   354: putfield 214	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Uqb	Z
    //   357: aload 6
    //   359: aload_3
    //   360: putfield 180	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpZ	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   363: aload 6
    //   365: astore_3
    //   366: aload 4
    //   368: invokeinterface 217 1 0
    //   373: goto -290 -> 83
    //   376: astore_3
    //   377: aload 4
    //   379: invokeinterface 217 1 0
    //   384: ldc 57
    //   386: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: aload_3
    //   390: athrow
    //   391: astore 4
    //   393: ldc 91
    //   395: ldc 219
    //   397: iconst_1
    //   398: anewarray 137	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload 4
    //   405: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: aastore
    //   409: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: aload 5
    //   414: astore 4
    //   416: goto -299 -> 117
    //   419: aload 4
    //   421: invokeinterface 149 1 0
    //   426: ifeq +71 -> 497
    //   429: aload 4
    //   431: iconst_1
    //   432: ldc 151
    //   434: invokestatic 155	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   437: astore 5
    //   439: aload 5
    //   441: ifnull +44 -> 485
    //   444: aload 8
    //   446: aload 5
    //   448: getfield 161	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:albumName	Ljava/lang/String;
    //   451: invokeinterface 167 2 0
    //   456: ifne +29 -> 485
    //   459: aload 9
    //   461: aload 5
    //   463: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   466: aload 5
    //   468: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 8
    //   474: aload 5
    //   476: getfield 161	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:albumName	Ljava/lang/String;
    //   479: invokeinterface 176 2 0
    //   484: pop
    //   485: aload 4
    //   487: invokeinterface 183 1 0
    //   492: istore_2
    //   493: iload_2
    //   494: ifne -65 -> 429
    //   497: aload 4
    //   499: invokeinterface 217 1 0
    //   504: goto -375 -> 129
    //   507: astore_3
    //   508: aload 4
    //   510: invokeinterface 217 1 0
    //   515: ldc 57
    //   517: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: aload_3
    //   521: athrow
    //   522: goto -242 -> 280
    //   525: goto -311 -> 214
    //   528: aconst_null
    //   529: astore_3
    //   530: goto -164 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	a
    //   303	43	1	i	int
    //   492	2	2	bool	boolean
    //   82	84	3	localObject1	java.lang.Object
    //   177	12	3	localException1	java.lang.Exception
    //   213	153	3	localObject2	java.lang.Object
    //   376	14	3	localObject3	java.lang.Object
    //   507	14	3	localObject4	java.lang.Object
    //   529	1	3	localObject5	java.lang.Object
    //   67	311	4	localCursor	android.database.Cursor
    //   391	13	4	localException2	java.lang.Exception
    //   414	95	4	localAlbumItem1	GalleryItem.AlbumItem
    //   1	474	5	localAlbumItem2	GalleryItem.AlbumItem
    //   222	142	6	localObject6	java.lang.Object
    //   15	160	7	localLinkedList	java.util.LinkedList
    //   24	449	8	localArrayList	java.util.ArrayList
    //   33	427	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   35	69	177	java/lang/Exception
    //   202	212	376	finally
    //   214	224	376	finally
    //   229	270	376	finally
    //   274	280	376	finally
    //   280	302	376	finally
    //   304	330	376	finally
    //   333	363	376	finally
    //   83	117	391	java/lang/Exception
    //   419	429	507	finally
    //   429	439	507	finally
    //   444	485	507	finally
    //   485	493	507	finally
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 233	java/lang/System:currentTimeMillis	()J
    //   8: lstore 6
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 14
    //   16: aconst_null
    //   17: astore 22
    //   19: aconst_null
    //   20: astore 11
    //   22: aconst_null
    //   23: astore 19
    //   25: aconst_null
    //   26: astore 20
    //   28: aconst_null
    //   29: astore 18
    //   31: aconst_null
    //   32: astore 16
    //   34: aconst_null
    //   35: astore 15
    //   37: aconst_null
    //   38: astore 17
    //   40: aconst_null
    //   41: astore 21
    //   43: aconst_null
    //   44: astore 23
    //   46: aload 14
    //   48: astore 12
    //   50: aload 22
    //   52: astore 13
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 236	com/tencent/mm/plugin/gallery/model/a:ifz	Z
    //   59: aload 14
    //   61: astore 12
    //   63: aload 22
    //   65: astore 13
    //   67: new 59	java/util/LinkedList
    //   70: dup
    //   71: invokespecial 60	java/util/LinkedList:<init>	()V
    //   74: astore 25
    //   76: aload 14
    //   78: astore 12
    //   80: aload 22
    //   82: astore 13
    //   84: aload_1
    //   85: invokestatic 242	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   88: ifeq +653 -> 741
    //   91: iload_2
    //   92: iconst_1
    //   93: if_icmpeq +8 -> 101
    //   96: iload_2
    //   97: iconst_3
    //   98: if_icmpne +1606 -> 1704
    //   101: aload 14
    //   103: astore 12
    //   105: aload 22
    //   107: astore 13
    //   109: aload_0
    //   110: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   113: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   116: aload_0
    //   117: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   120: invokevirtual 245	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   127: aload_0
    //   128: getfield 249	com/tencent/mm/plugin/gallery/model/a:xhJ	[Ljava/lang/String;
    //   131: iconst_0
    //   132: invokevirtual 253	com/tencent/mm/plugin/gallery/model/k:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   135: aconst_null
    //   136: aload_0
    //   137: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   140: iconst_0
    //   141: invokevirtual 257	com/tencent/mm/plugin/gallery/model/k:pw	(Z)Ljava/lang/String;
    //   144: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore 11
    //   149: aload 11
    //   151: astore 12
    //   153: aload 11
    //   155: astore 13
    //   157: aload 11
    //   159: astore 14
    //   161: aload_0
    //   162: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   165: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   168: aload_0
    //   169: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   172: invokevirtual 245	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   175: aload_0
    //   176: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   179: aload_0
    //   180: getfield 249	com/tencent/mm/plugin/gallery/model/a:xhJ	[Ljava/lang/String;
    //   183: iconst_1
    //   184: invokevirtual 253	com/tencent/mm/plugin/gallery/model/k:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   187: aconst_null
    //   188: aload_0
    //   189: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   192: iconst_1
    //   193: invokevirtual 257	com/tencent/mm/plugin/gallery/model/k:pw	(Z)Ljava/lang/String;
    //   196: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   199: astore 10
    //   201: iload_2
    //   202: iconst_2
    //   203: if_icmpeq +16 -> 219
    //   206: aload 10
    //   208: astore 14
    //   210: aload 11
    //   212: astore 13
    //   214: iload_2
    //   215: iconst_3
    //   216: if_icmpne +1476 -> 1692
    //   219: aload 21
    //   221: astore 17
    //   223: aload 18
    //   225: astore 12
    //   227: aload 10
    //   229: astore 14
    //   231: aload 11
    //   233: astore 13
    //   235: aload 10
    //   237: astore 19
    //   239: aload 11
    //   241: astore 18
    //   243: aload 10
    //   245: astore 20
    //   247: aload 11
    //   249: astore 15
    //   251: aload_0
    //   252: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   255: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   258: aload_0
    //   259: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   262: invokevirtual 258	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   269: iconst_1
    //   270: anewarray 260	java/lang/String
    //   273: dup
    //   274: iconst_0
    //   275: aload_0
    //   276: getfield 249	com/tencent/mm/plugin/gallery/model/a:xhJ	[Ljava/lang/String;
    //   279: iconst_0
    //   280: aaload
    //   281: aastore
    //   282: iconst_0
    //   283: invokevirtual 261	com/tencent/mm/plugin/gallery/model/u:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   286: aconst_null
    //   287: aload_0
    //   288: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   291: iconst_0
    //   292: invokevirtual 262	com/tencent/mm/plugin/gallery/model/u:pw	(Z)Ljava/lang/String;
    //   295: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   298: astore 22
    //   300: aload 22
    //   302: astore 15
    //   304: aload 21
    //   306: astore 17
    //   308: aload 15
    //   310: astore 12
    //   312: aload 10
    //   314: astore 14
    //   316: aload 11
    //   318: astore 13
    //   320: aload 15
    //   322: astore 16
    //   324: aload 10
    //   326: astore 19
    //   328: aload 11
    //   330: astore 18
    //   332: aload 15
    //   334: astore 22
    //   336: aload 10
    //   338: astore 21
    //   340: aload 11
    //   342: astore 20
    //   344: aload_0
    //   345: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   348: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   351: aload_0
    //   352: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   355: invokevirtual 258	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   362: iconst_1
    //   363: anewarray 260	java/lang/String
    //   366: dup
    //   367: iconst_0
    //   368: aload_0
    //   369: getfield 249	com/tencent/mm/plugin/gallery/model/a:xhJ	[Ljava/lang/String;
    //   372: iconst_0
    //   373: aaload
    //   374: aastore
    //   375: iconst_1
    //   376: invokevirtual 261	com/tencent/mm/plugin/gallery/model/u:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   379: aconst_null
    //   380: aload_0
    //   381: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   384: iconst_1
    //   385: invokevirtual 262	com/tencent/mm/plugin/gallery/model/u:pw	(Z)Ljava/lang/String;
    //   388: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   391: astore 24
    //   393: aload 24
    //   395: astore 16
    //   397: aload 11
    //   399: astore 13
    //   401: aload 10
    //   403: astore 14
    //   405: aload 13
    //   407: ifnull +11 -> 418
    //   410: aload 13
    //   412: invokeinterface 149 1 0
    //   417: pop
    //   418: aload 14
    //   420: ifnull +11 -> 431
    //   423: aload 14
    //   425: invokeinterface 149 1 0
    //   430: pop
    //   431: aload 15
    //   433: ifnull +11 -> 444
    //   436: aload 15
    //   438: invokeinterface 149 1 0
    //   443: pop
    //   444: aload 16
    //   446: ifnull +11 -> 457
    //   449: aload 16
    //   451: invokeinterface 149 1 0
    //   456: pop
    //   457: aload 13
    //   459: iconst_1
    //   460: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   463: astore 10
    //   465: aload 14
    //   467: iconst_1
    //   468: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   471: astore 11
    //   473: aload 15
    //   475: iconst_2
    //   476: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   479: astore 12
    //   481: aload 16
    //   483: iconst_2
    //   484: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   487: astore 17
    //   489: iconst_1
    //   490: istore 9
    //   492: goto +1218 -> 1710
    //   495: aload 19
    //   497: astore 18
    //   499: aload 11
    //   501: ifnull +29 -> 530
    //   504: aload 19
    //   506: ifnull +1219 -> 1725
    //   509: aload 19
    //   511: astore 18
    //   513: aload 19
    //   515: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   518: aload 11
    //   520: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   523: lcmp
    //   524: ifge +6 -> 530
    //   527: goto +1198 -> 1725
    //   530: aload 18
    //   532: astore 19
    //   534: aload 12
    //   536: ifnull +29 -> 565
    //   539: aload 18
    //   541: ifnull +1191 -> 1732
    //   544: aload 18
    //   546: astore 19
    //   548: aload 18
    //   550: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   553: aload 12
    //   555: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   558: lcmp
    //   559: ifge +6 -> 565
    //   562: goto +1170 -> 1732
    //   565: aload 19
    //   567: astore 18
    //   569: aload 17
    //   571: ifnull +29 -> 600
    //   574: aload 19
    //   576: ifnull +1163 -> 1739
    //   579: aload 19
    //   581: astore 18
    //   583: aload 19
    //   585: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   588: aload 17
    //   590: getfield 271	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:xja	J
    //   593: lcmp
    //   594: ifge +6 -> 600
    //   597: goto +1142 -> 1739
    //   600: aload 18
    //   602: ifnull +536 -> 1138
    //   605: aload 25
    //   607: aload 18
    //   609: invokevirtual 272	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   612: pop
    //   613: aload 18
    //   615: aload 10
    //   617: if_acmpne +411 -> 1028
    //   620: aload 13
    //   622: invokeinterface 183 1 0
    //   627: pop
    //   628: aload 13
    //   630: iconst_1
    //   631: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   634: astore 18
    //   636: aload 12
    //   638: astore 10
    //   640: aload 18
    //   642: astore 12
    //   644: iload 9
    //   646: istore 8
    //   648: aload_0
    //   649: aload_3
    //   650: aload 25
    //   652: lload 4
    //   654: iload 9
    //   656: invokevirtual 275	com/tencent/mm/plugin/gallery/model/a:a	(Lcom/tencent/mm/plugin/gallery/model/i$c;Ljava/util/LinkedList;JZ)Z
    //   659: ifeq +15 -> 674
    //   662: iload 9
    //   664: istore 8
    //   666: iload 9
    //   668: ifeq +6 -> 674
    //   671: iconst_0
    //   672: istore 8
    //   674: aload_0
    //   675: getfield 236	com/tencent/mm/plugin/gallery/model/a:ifz	Z
    //   678: istore 9
    //   680: iload 9
    //   682: ifeq +1064 -> 1746
    //   685: aload 13
    //   687: ifnull +10 -> 697
    //   690: aload 13
    //   692: invokeinterface 217 1 0
    //   697: aload 14
    //   699: ifnull +10 -> 709
    //   702: aload 14
    //   704: invokeinterface 217 1 0
    //   709: aload 15
    //   711: ifnull +10 -> 721
    //   714: aload 15
    //   716: invokeinterface 217 1 0
    //   721: aload 16
    //   723: ifnull +10 -> 733
    //   726: aload 16
    //   728: invokeinterface 217 1 0
    //   733: ldc 227
    //   735: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   738: aload 25
    //   740: areturn
    //   741: iload_2
    //   742: iconst_1
    //   743: if_icmpeq +8 -> 751
    //   746: iload_2
    //   747: iconst_3
    //   748: if_icmpne +950 -> 1698
    //   751: aload 14
    //   753: astore 12
    //   755: aload 22
    //   757: astore 13
    //   759: aload_0
    //   760: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   763: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   766: aload_0
    //   767: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   770: invokevirtual 245	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   773: aload_0
    //   774: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   777: aload_1
    //   778: iconst_0
    //   779: invokevirtual 279	com/tencent/mm/plugin/gallery/model/k:bF	(Ljava/lang/String;Z)Ljava/lang/String;
    //   782: aconst_null
    //   783: aload_0
    //   784: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   787: iconst_0
    //   788: invokevirtual 257	com/tencent/mm/plugin/gallery/model/k:pw	(Z)Ljava/lang/String;
    //   791: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   794: astore 10
    //   796: aload 10
    //   798: astore 12
    //   800: aload 10
    //   802: astore 13
    //   804: aload 10
    //   806: astore 14
    //   808: aload_0
    //   809: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   812: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   815: aload_0
    //   816: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   819: invokevirtual 245	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   822: aload_0
    //   823: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   826: aload_1
    //   827: iconst_1
    //   828: invokevirtual 279	com/tencent/mm/plugin/gallery/model/k:bF	(Ljava/lang/String;Z)Ljava/lang/String;
    //   831: aconst_null
    //   832: aload_0
    //   833: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   836: iconst_1
    //   837: invokevirtual 257	com/tencent/mm/plugin/gallery/model/k:pw	(Z)Ljava/lang/String;
    //   840: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   843: astore 11
    //   845: iload_2
    //   846: iconst_2
    //   847: if_icmpeq +16 -> 863
    //   850: aload 11
    //   852: astore 14
    //   854: aload 10
    //   856: astore 13
    //   858: iload_2
    //   859: iconst_3
    //   860: if_icmpne +832 -> 1692
    //   863: aload 21
    //   865: astore 17
    //   867: aload 18
    //   869: astore 12
    //   871: aload 11
    //   873: astore 14
    //   875: aload 10
    //   877: astore 13
    //   879: aload 11
    //   881: astore 19
    //   883: aload 10
    //   885: astore 18
    //   887: aload 11
    //   889: astore 20
    //   891: aload 10
    //   893: astore 15
    //   895: aload_0
    //   896: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   899: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   902: aload_0
    //   903: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   906: invokevirtual 258	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   909: aload_0
    //   910: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   913: aload_1
    //   914: iconst_0
    //   915: invokevirtual 280	com/tencent/mm/plugin/gallery/model/u:bF	(Ljava/lang/String;Z)Ljava/lang/String;
    //   918: aconst_null
    //   919: aload_0
    //   920: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   923: iconst_0
    //   924: invokevirtual 262	com/tencent/mm/plugin/gallery/model/u:pw	(Z)Ljava/lang/String;
    //   927: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   930: astore 22
    //   932: aload 22
    //   934: astore 15
    //   936: aload 21
    //   938: astore 17
    //   940: aload 15
    //   942: astore 12
    //   944: aload 11
    //   946: astore 14
    //   948: aload 10
    //   950: astore 13
    //   952: aload 15
    //   954: astore 16
    //   956: aload 11
    //   958: astore 19
    //   960: aload 10
    //   962: astore 18
    //   964: aload 15
    //   966: astore 22
    //   968: aload 11
    //   970: astore 21
    //   972: aload 10
    //   974: astore 20
    //   976: aload_0
    //   977: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   980: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   983: aload_0
    //   984: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   987: invokevirtual 258	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   990: aload_0
    //   991: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   994: aload_1
    //   995: iconst_1
    //   996: invokevirtual 280	com/tencent/mm/plugin/gallery/model/u:bF	(Ljava/lang/String;Z)Ljava/lang/String;
    //   999: aconst_null
    //   1000: aload_0
    //   1001: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   1004: iconst_1
    //   1005: invokevirtual 262	com/tencent/mm/plugin/gallery/model/u:pw	(Z)Ljava/lang/String;
    //   1008: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1011: astore 24
    //   1013: aload 24
    //   1015: astore 16
    //   1017: aload 11
    //   1019: astore 14
    //   1021: aload 10
    //   1023: astore 13
    //   1025: goto -620 -> 405
    //   1028: aload 18
    //   1030: aload 11
    //   1032: if_acmpne +34 -> 1066
    //   1035: aload 14
    //   1037: invokeinterface 183 1 0
    //   1042: pop
    //   1043: aload 14
    //   1045: iconst_1
    //   1046: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1049: astore 11
    //   1051: aload 10
    //   1053: astore 18
    //   1055: aload 12
    //   1057: astore 10
    //   1059: aload 18
    //   1061: astore 12
    //   1063: goto -419 -> 644
    //   1066: aload 18
    //   1068: aload 12
    //   1070: if_acmpne +30 -> 1100
    //   1073: aload 15
    //   1075: invokeinterface 183 1 0
    //   1080: pop
    //   1081: aload 15
    //   1083: iconst_2
    //   1084: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1087: astore 18
    //   1089: aload 10
    //   1091: astore 12
    //   1093: aload 18
    //   1095: astore 10
    //   1097: goto -453 -> 644
    //   1100: aload 18
    //   1102: aload 17
    //   1104: if_acmpne +573 -> 1677
    //   1107: aload 16
    //   1109: invokeinterface 183 1 0
    //   1114: pop
    //   1115: aload 16
    //   1117: iconst_2
    //   1118: invokestatic 265	com/tencent/mm/plugin/gallery/model/a:b	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1121: astore 17
    //   1123: aload 10
    //   1125: astore 18
    //   1127: aload 12
    //   1129: astore 10
    //   1131: aload 18
    //   1133: astore 12
    //   1135: goto -491 -> 644
    //   1138: aload_3
    //   1139: ifnull +38 -> 1177
    //   1142: ldc 91
    //   1144: ldc_w 282
    //   1147: iconst_1
    //   1148: anewarray 137	java/lang/Object
    //   1151: dup
    //   1152: iconst_0
    //   1153: aload 25
    //   1155: invokevirtual 286	java/util/LinkedList:size	()I
    //   1158: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1161: aastore
    //   1162: invokestatic 294	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: aload_3
    //   1166: aload 25
    //   1168: lload 4
    //   1170: iload 9
    //   1172: invokeinterface 299 5 0
    //   1177: ldc 91
    //   1179: ldc_w 301
    //   1182: iconst_5
    //   1183: anewarray 137	java/lang/Object
    //   1186: dup
    //   1187: iconst_0
    //   1188: aload_1
    //   1189: aastore
    //   1190: dup
    //   1191: iconst_1
    //   1192: iload_2
    //   1193: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1196: aastore
    //   1197: dup
    //   1198: iconst_2
    //   1199: aload 25
    //   1201: invokevirtual 286	java/util/LinkedList:size	()I
    //   1204: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: dup
    //   1209: iconst_3
    //   1210: lload 4
    //   1212: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1215: aastore
    //   1216: dup
    //   1217: iconst_4
    //   1218: invokestatic 233	java/lang/System:currentTimeMillis	()J
    //   1221: lload 6
    //   1223: lsub
    //   1224: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1227: aastore
    //   1228: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1231: aload 13
    //   1233: ifnull +10 -> 1243
    //   1236: aload 13
    //   1238: invokeinterface 217 1 0
    //   1243: aload 14
    //   1245: ifnull +10 -> 1255
    //   1248: aload 14
    //   1250: invokeinterface 217 1 0
    //   1255: aload 15
    //   1257: ifnull +10 -> 1267
    //   1260: aload 15
    //   1262: invokeinterface 217 1 0
    //   1267: aload 16
    //   1269: ifnull +10 -> 1279
    //   1272: aload 16
    //   1274: invokeinterface 217 1 0
    //   1279: ldc 227
    //   1281: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1284: aload 25
    //   1286: areturn
    //   1287: astore 12
    //   1289: aconst_null
    //   1290: astore_1
    //   1291: aconst_null
    //   1292: astore_3
    //   1293: aconst_null
    //   1294: astore 10
    //   1296: aconst_null
    //   1297: astore 11
    //   1299: ldc 91
    //   1301: aload 12
    //   1303: ldc_w 310
    //   1306: iconst_0
    //   1307: anewarray 137	java/lang/Object
    //   1310: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1313: aload 11
    //   1315: ifnull +10 -> 1325
    //   1318: aload 11
    //   1320: invokeinterface 217 1 0
    //   1325: aload 10
    //   1327: ifnull +10 -> 1337
    //   1330: aload 10
    //   1332: invokeinterface 217 1 0
    //   1337: aload_3
    //   1338: ifnull +9 -> 1347
    //   1341: aload_3
    //   1342: invokeinterface 217 1 0
    //   1347: aload_1
    //   1348: ifnull +9 -> 1357
    //   1351: aload_1
    //   1352: invokeinterface 217 1 0
    //   1357: new 59	java/util/LinkedList
    //   1360: dup
    //   1361: invokespecial 60	java/util/LinkedList:<init>	()V
    //   1364: astore_1
    //   1365: ldc 227
    //   1367: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1370: aload_1
    //   1371: areturn
    //   1372: astore 10
    //   1374: aconst_null
    //   1375: astore_1
    //   1376: aload 12
    //   1378: astore_3
    //   1379: aload 19
    //   1381: astore 15
    //   1383: aload 23
    //   1385: astore 11
    //   1387: aload 11
    //   1389: astore 17
    //   1391: aload 15
    //   1393: astore 12
    //   1395: aload_1
    //   1396: astore 14
    //   1398: aload_3
    //   1399: astore 13
    //   1401: ldc 91
    //   1403: aload 10
    //   1405: ldc_w 310
    //   1408: iconst_0
    //   1409: anewarray 137	java/lang/Object
    //   1412: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1415: aload_3
    //   1416: ifnull +9 -> 1425
    //   1419: aload_3
    //   1420: invokeinterface 217 1 0
    //   1425: aload_1
    //   1426: ifnull +9 -> 1435
    //   1429: aload_1
    //   1430: invokeinterface 217 1 0
    //   1435: aload 15
    //   1437: ifnull +10 -> 1447
    //   1440: aload 15
    //   1442: invokeinterface 217 1 0
    //   1447: aload 11
    //   1449: ifnull -92 -> 1357
    //   1452: aload 11
    //   1454: invokeinterface 217 1 0
    //   1459: goto -102 -> 1357
    //   1462: astore_1
    //   1463: aconst_null
    //   1464: astore 14
    //   1466: aload 20
    //   1468: astore 12
    //   1470: aload 17
    //   1472: astore_3
    //   1473: aload 13
    //   1475: ifnull +10 -> 1485
    //   1478: aload 13
    //   1480: invokeinterface 217 1 0
    //   1485: aload 14
    //   1487: ifnull +10 -> 1497
    //   1490: aload 14
    //   1492: invokeinterface 217 1 0
    //   1497: aload 12
    //   1499: ifnull +10 -> 1509
    //   1502: aload 12
    //   1504: invokeinterface 217 1 0
    //   1509: aload_3
    //   1510: ifnull +9 -> 1519
    //   1513: aload_3
    //   1514: invokeinterface 217 1 0
    //   1519: ldc 227
    //   1521: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1524: aload_1
    //   1525: athrow
    //   1526: astore_1
    //   1527: aload 17
    //   1529: astore_3
    //   1530: goto -57 -> 1473
    //   1533: astore_1
    //   1534: aload 16
    //   1536: astore_3
    //   1537: aload 15
    //   1539: astore 12
    //   1541: goto -68 -> 1473
    //   1544: astore 14
    //   1546: aload_1
    //   1547: astore 12
    //   1549: aload_3
    //   1550: astore 13
    //   1552: aload 14
    //   1554: astore_1
    //   1555: aload 12
    //   1557: astore_3
    //   1558: aload 13
    //   1560: astore 12
    //   1562: aload 10
    //   1564: astore 14
    //   1566: aload 11
    //   1568: astore 13
    //   1570: goto -97 -> 1473
    //   1573: astore 10
    //   1575: aload 23
    //   1577: astore 11
    //   1579: aload 16
    //   1581: astore 15
    //   1583: aload 19
    //   1585: astore_1
    //   1586: aload 18
    //   1588: astore_3
    //   1589: goto -202 -> 1387
    //   1592: astore 10
    //   1594: aload 16
    //   1596: astore 11
    //   1598: aload 14
    //   1600: astore_1
    //   1601: aload 13
    //   1603: astore_3
    //   1604: goto -217 -> 1387
    //   1607: astore 12
    //   1609: aconst_null
    //   1610: astore_1
    //   1611: aconst_null
    //   1612: astore_3
    //   1613: aconst_null
    //   1614: astore 10
    //   1616: aload 14
    //   1618: astore 11
    //   1620: goto -321 -> 1299
    //   1623: astore 12
    //   1625: aconst_null
    //   1626: astore_1
    //   1627: aconst_null
    //   1628: astore_3
    //   1629: aload 20
    //   1631: astore 10
    //   1633: aload 15
    //   1635: astore 11
    //   1637: goto -338 -> 1299
    //   1640: astore 12
    //   1642: aconst_null
    //   1643: astore_1
    //   1644: aload 22
    //   1646: astore_3
    //   1647: aload 21
    //   1649: astore 10
    //   1651: aload 20
    //   1653: astore 11
    //   1655: goto -356 -> 1299
    //   1658: astore 12
    //   1660: aload 16
    //   1662: astore_1
    //   1663: aload 15
    //   1665: astore_3
    //   1666: aload 14
    //   1668: astore 10
    //   1670: aload 13
    //   1672: astore 11
    //   1674: goto -375 -> 1299
    //   1677: aload 10
    //   1679: astore 18
    //   1681: aload 12
    //   1683: astore 10
    //   1685: aload 18
    //   1687: astore 12
    //   1689: goto -1045 -> 644
    //   1692: aconst_null
    //   1693: astore 16
    //   1695: goto -1290 -> 405
    //   1698: aconst_null
    //   1699: astore 11
    //   1701: goto -856 -> 845
    //   1704: aconst_null
    //   1705: astore 10
    //   1707: goto -1506 -> 201
    //   1710: aconst_null
    //   1711: astore 19
    //   1713: aload 10
    //   1715: ifnull -1220 -> 495
    //   1718: aload 10
    //   1720: astore 19
    //   1722: goto -1227 -> 495
    //   1725: aload 11
    //   1727: astore 18
    //   1729: goto -1199 -> 530
    //   1732: aload 12
    //   1734: astore 19
    //   1736: goto -1171 -> 565
    //   1739: aload 17
    //   1741: astore 18
    //   1743: goto -1143 -> 600
    //   1746: aload 12
    //   1748: astore 18
    //   1750: aload 10
    //   1752: astore 12
    //   1754: aload 18
    //   1756: astore 10
    //   1758: iload 8
    //   1760: istore 9
    //   1762: goto -52 -> 1710
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1765	0	this	a
    //   0	1765	1	paramString	String
    //   0	1765	2	paramInt	int
    //   0	1765	3	paramc	i.c
    //   0	1765	4	paramLong	long
    //   8	1214	6	l	long
    //   646	1113	8	bool1	boolean
    //   490	1271	9	bool2	boolean
    //   11	1320	10	localObject1	java.lang.Object
    //   1372	191	10	localNullPointerException1	java.lang.NullPointerException
    //   1573	1	10	localNullPointerException2	java.lang.NullPointerException
    //   1592	1	10	localNullPointerException3	java.lang.NullPointerException
    //   1614	143	10	localObject2	java.lang.Object
    //   20	1706	11	localObject3	java.lang.Object
    //   48	1086	12	localObject4	java.lang.Object
    //   1287	90	12	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   1393	168	12	localObject5	java.lang.Object
    //   1607	1	12	localSQLiteDiskIOException2	android.database.sqlite.SQLiteDiskIOException
    //   1623	1	12	localSQLiteDiskIOException3	android.database.sqlite.SQLiteDiskIOException
    //   1640	1	12	localSQLiteDiskIOException4	android.database.sqlite.SQLiteDiskIOException
    //   1658	24	12	localSQLiteDiskIOException5	android.database.sqlite.SQLiteDiskIOException
    //   1687	66	12	localObject6	java.lang.Object
    //   52	1619	13	localObject7	java.lang.Object
    //   14	1477	14	localObject8	java.lang.Object
    //   1544	9	14	localObject9	java.lang.Object
    //   1564	103	14	localNullPointerException4	java.lang.NullPointerException
    //   35	1629	15	localObject10	java.lang.Object
    //   32	1662	16	localObject11	java.lang.Object
    //   38	1702	17	localObject12	java.lang.Object
    //   29	1726	18	localObject13	java.lang.Object
    //   23	1712	19	localObject14	java.lang.Object
    //   26	1626	20	localObject15	java.lang.Object
    //   41	1607	21	localObject16	java.lang.Object
    //   17	1628	22	localObject17	java.lang.Object
    //   44	1532	23	localObject18	java.lang.Object
    //   391	623	24	localCursor	android.database.Cursor
    //   74	1211	25	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   54	59	1287	android/database/sqlite/SQLiteDiskIOException
    //   67	76	1287	android/database/sqlite/SQLiteDiskIOException
    //   84	91	1287	android/database/sqlite/SQLiteDiskIOException
    //   109	149	1287	android/database/sqlite/SQLiteDiskIOException
    //   759	796	1287	android/database/sqlite/SQLiteDiskIOException
    //   54	59	1372	java/lang/NullPointerException
    //   67	76	1372	java/lang/NullPointerException
    //   84	91	1372	java/lang/NullPointerException
    //   109	149	1372	java/lang/NullPointerException
    //   161	201	1372	java/lang/NullPointerException
    //   759	796	1372	java/lang/NullPointerException
    //   808	845	1372	java/lang/NullPointerException
    //   54	59	1462	finally
    //   67	76	1462	finally
    //   84	91	1462	finally
    //   109	149	1462	finally
    //   161	201	1462	finally
    //   759	796	1462	finally
    //   808	845	1462	finally
    //   251	300	1526	finally
    //   344	393	1526	finally
    //   895	932	1526	finally
    //   976	1013	1526	finally
    //   1401	1415	1526	finally
    //   410	418	1533	finally
    //   423	431	1533	finally
    //   436	444	1533	finally
    //   449	457	1533	finally
    //   457	489	1533	finally
    //   513	527	1533	finally
    //   548	562	1533	finally
    //   583	597	1533	finally
    //   605	613	1533	finally
    //   620	636	1533	finally
    //   648	662	1533	finally
    //   674	680	1533	finally
    //   1035	1051	1533	finally
    //   1073	1089	1533	finally
    //   1107	1123	1533	finally
    //   1142	1177	1533	finally
    //   1177	1231	1533	finally
    //   1299	1313	1544	finally
    //   251	300	1573	java/lang/NullPointerException
    //   344	393	1573	java/lang/NullPointerException
    //   895	932	1573	java/lang/NullPointerException
    //   976	1013	1573	java/lang/NullPointerException
    //   410	418	1592	java/lang/NullPointerException
    //   423	431	1592	java/lang/NullPointerException
    //   436	444	1592	java/lang/NullPointerException
    //   449	457	1592	java/lang/NullPointerException
    //   457	489	1592	java/lang/NullPointerException
    //   513	527	1592	java/lang/NullPointerException
    //   548	562	1592	java/lang/NullPointerException
    //   583	597	1592	java/lang/NullPointerException
    //   605	613	1592	java/lang/NullPointerException
    //   620	636	1592	java/lang/NullPointerException
    //   648	662	1592	java/lang/NullPointerException
    //   674	680	1592	java/lang/NullPointerException
    //   1035	1051	1592	java/lang/NullPointerException
    //   1073	1089	1592	java/lang/NullPointerException
    //   1107	1123	1592	java/lang/NullPointerException
    //   1142	1177	1592	java/lang/NullPointerException
    //   1177	1231	1592	java/lang/NullPointerException
    //   161	201	1607	android/database/sqlite/SQLiteDiskIOException
    //   808	845	1607	android/database/sqlite/SQLiteDiskIOException
    //   251	300	1623	android/database/sqlite/SQLiteDiskIOException
    //   895	932	1623	android/database/sqlite/SQLiteDiskIOException
    //   344	393	1640	android/database/sqlite/SQLiteDiskIOException
    //   976	1013	1640	android/database/sqlite/SQLiteDiskIOException
    //   410	418	1658	android/database/sqlite/SQLiteDiskIOException
    //   423	431	1658	android/database/sqlite/SQLiteDiskIOException
    //   436	444	1658	android/database/sqlite/SQLiteDiskIOException
    //   449	457	1658	android/database/sqlite/SQLiteDiskIOException
    //   457	489	1658	android/database/sqlite/SQLiteDiskIOException
    //   513	527	1658	android/database/sqlite/SQLiteDiskIOException
    //   548	562	1658	android/database/sqlite/SQLiteDiskIOException
    //   583	597	1658	android/database/sqlite/SQLiteDiskIOException
    //   605	613	1658	android/database/sqlite/SQLiteDiskIOException
    //   620	636	1658	android/database/sqlite/SQLiteDiskIOException
    //   648	662	1658	android/database/sqlite/SQLiteDiskIOException
    //   674	680	1658	android/database/sqlite/SQLiteDiskIOException
    //   1035	1051	1658	android/database/sqlite/SQLiteDiskIOException
    //   1073	1089	1658	android/database/sqlite/SQLiteDiskIOException
    //   1107	1123	1658	android/database/sqlite/SQLiteDiskIOException
    //   1142	1177	1658	android/database/sqlite/SQLiteDiskIOException
    //   1177	1231	1658	android/database/sqlite/SQLiteDiskIOException
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.AlbumItem> dQr()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 323
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 328	com/tencent/mm/plugin/gallery/a/d:dSB	()Z
    //   12: ifeq +18 -> 30
    //   15: aload_0
    //   16: invokespecial 330	com/tencent/mm/plugin/gallery/model/a:dQs	()Ljava/util/LinkedList;
    //   19: astore 4
    //   21: ldc_w 323
    //   24: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload 4
    //   29: areturn
    //   30: new 65	java/util/HashMap
    //   33: dup
    //   34: invokespecial 66	java/util/HashMap:<init>	()V
    //   37: astore 8
    //   39: new 59	java/util/LinkedList
    //   42: dup
    //   43: invokespecial 60	java/util/LinkedList:<init>	()V
    //   46: astore 9
    //   48: aload_0
    //   49: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   52: getstatic 72	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: aload_0
    //   56: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   59: invokevirtual 76	com/tencent/mm/plugin/gallery/model/u:dQt	()[Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   66: invokevirtual 80	com/tencent/mm/plugin/gallery/model/u:dQu	()Ljava/lang/String;
    //   69: aconst_null
    //   70: aload_0
    //   71: getfield 48	com/tencent/mm/plugin/gallery/model/a:xhH	Lcom/tencent/mm/plugin/gallery/model/u;
    //   74: invokevirtual 83	com/tencent/mm/plugin/gallery/model/u:dQv	()Ljava/lang/String;
    //   77: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnonnull +137 -> 221
    //   87: ldc 91
    //   89: ldc 93
    //   91: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aconst_null
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 38	com/tencent/mm/plugin/gallery/model/a:bEK	Landroid/content/ContentResolver;
    //   101: getstatic 102	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   104: aload_0
    //   105: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   108: invokevirtual 103	com/tencent/mm/plugin/gallery/model/k:dQt	()[Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   115: invokevirtual 104	com/tencent/mm/plugin/gallery/model/k:dQu	()Ljava/lang/String;
    //   118: aconst_null
    //   119: aload_0
    //   120: getfield 43	com/tencent/mm/plugin/gallery/model/a:xhG	Lcom/tencent/mm/plugin/gallery/model/k;
    //   123: invokevirtual 105	com/tencent/mm/plugin/gallery/model/k:dQv	()Ljava/lang/String;
    //   126: invokevirtual 89	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnonnull +264 -> 397
    //   136: ldc 91
    //   138: ldc 107
    //   140: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 8
    //   145: invokevirtual 111	java/util/HashMap:isEmpty	()Z
    //   148: ifne +19 -> 167
    //   151: aload 9
    //   153: aload 8
    //   155: invokevirtual 115	java/util/HashMap:values	()Ljava/util/Collection;
    //   158: invokevirtual 119	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   161: pop
    //   162: aload 9
    //   164: invokestatic 125	java/util/Collections:sort	(Ljava/util/List;)V
    //   167: aload 9
    //   169: invokestatic 129	com/tencent/mm/plugin/gallery/model/a:aK	(Ljava/util/LinkedList;)V
    //   172: aload 4
    //   174: ifnull +11 -> 185
    //   177: aload 9
    //   179: iconst_1
    //   180: aload 4
    //   182: invokevirtual 133	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   185: ldc_w 323
    //   188: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload 9
    //   193: areturn
    //   194: astore 4
    //   196: ldc 91
    //   198: ldc 135
    //   200: iconst_1
    //   201: anewarray 137	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 4
    //   208: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: aastore
    //   212: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aconst_null
    //   216: astore 5
    //   218: goto -136 -> 82
    //   221: aload 5
    //   223: invokeinterface 149 1 0
    //   228: ifeq +271 -> 499
    //   231: aconst_null
    //   232: astore 6
    //   234: iconst_0
    //   235: istore_1
    //   236: aload 5
    //   238: iconst_2
    //   239: ldc 151
    //   241: invokestatic 155	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
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
    //   261: getfield 333	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Uqc	Z
    //   264: ifne +11 -> 275
    //   267: iload_1
    //   268: aload 10
    //   270: getfield 336	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:dJl	I
    //   273: iadd
    //   274: istore_2
    //   275: aload 8
    //   277: aload 10
    //   279: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   282: aload 10
    //   284: invokevirtual 174	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: aload 6
    //   290: astore 4
    //   292: iload_2
    //   293: istore_3
    //   294: aload 6
    //   296: ifnonnull +12 -> 308
    //   299: aload 10
    //   301: getfield 180	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpZ	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   304: astore 4
    //   306: iload_2
    //   307: istore_3
    //   308: aload 4
    //   310: astore 6
    //   312: iload_3
    //   313: istore_1
    //   314: aload 5
    //   316: invokeinterface 183 1 0
    //   321: ifne -85 -> 236
    //   324: new 157	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   327: dup
    //   328: invokestatic 30	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   331: ldc 203
    //   333: invokevirtual 207	android/content/Context:getString	(I)Ljava/lang/String;
    //   336: iload_3
    //   337: invokespecial 210	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:<init>	(Ljava/lang/String;I)V
    //   340: astore 6
    //   342: aload 6
    //   344: iconst_1
    //   345: putfield 214	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Uqb	Z
    //   348: aload 6
    //   350: aload 4
    //   352: putfield 180	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpZ	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   355: aload 6
    //   357: astore 4
    //   359: aload 5
    //   361: invokeinterface 217 1 0
    //   366: goto -269 -> 97
    //   369: astore 5
    //   371: ldc 91
    //   373: ldc 219
    //   375: iconst_1
    //   376: anewarray 137	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload 5
    //   383: invokevirtual 140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   386: aastore
    //   387: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: aload 7
    //   392: astore 5
    //   394: goto -263 -> 131
    //   397: aload 5
    //   399: invokeinterface 149 1 0
    //   404: ifeq +85 -> 489
    //   407: aload 5
    //   409: iconst_1
    //   410: ldc 151
    //   412: invokestatic 155	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   415: astore 6
    //   417: aload 6
    //   419: ifnull +60 -> 479
    //   422: aload 8
    //   424: aload 6
    //   426: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   429: invokevirtual 340	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   432: checkcast 157	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   435: astore 7
    //   437: aload 7
    //   439: ifnull +32 -> 471
    //   442: aload 6
    //   444: getfield 336	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:dJl	I
    //   447: istore_1
    //   448: aload 6
    //   450: aload 7
    //   452: getfield 336	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:dJl	I
    //   455: iload_1
    //   456: iadd
    //   457: putfield 336	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:dJl	I
    //   460: aload 8
    //   462: aload 6
    //   464: getfield 170	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   467: invokevirtual 343	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   470: pop
    //   471: aload 9
    //   473: aload 6
    //   475: invokevirtual 272	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   478: pop
    //   479: aload 5
    //   481: invokeinterface 183 1 0
    //   486: ifne -79 -> 407
    //   489: aload 5
    //   491: invokeinterface 217 1 0
    //   496: goto -353 -> 143
    //   499: aconst_null
    //   500: astore 4
    //   502: goto -143 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	a
    //   235	222	1	i	int
    //   258	49	2	j	int
    //   251	86	3	k	int
    //   19	162	4	localLinkedList1	java.util.LinkedList
    //   194	13	4	localException1	java.lang.Exception
    //   248	253	4	localObject1	java.lang.Object
    //   80	280	5	localCursor	android.database.Cursor
    //   369	13	5	localException2	java.lang.Exception
    //   392	98	5	localAlbumItem1	GalleryItem.AlbumItem
    //   232	242	6	localObject2	java.lang.Object
    //   1	450	7	localAlbumItem2	GalleryItem.AlbumItem
    //   37	424	8	localHashMap	java.util.HashMap
    //   46	426	9	localLinkedList2	java.util.LinkedList
    //   244	56	10	localAlbumItem3	GalleryItem.AlbumItem
    // Exception table:
    //   from	to	target	type
    //   48	82	194	java/lang/Exception
    //   97	131	369	java/lang/Exception
  }
  
  public final String pw(boolean paramBoolean)
  {
    AppMethodBeat.i(111231);
    if (paramBoolean)
    {
      str = b.xhL + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111231);
      return str;
    }
    String str = b.xhK + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a
 * JD-Core Version:    0.7.0.1
 */