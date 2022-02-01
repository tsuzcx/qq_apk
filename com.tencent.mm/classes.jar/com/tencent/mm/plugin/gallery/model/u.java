package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class u
  extends b
{
  protected final ContentResolver bon;
  
  public u()
  {
    AppMethodBeat.i(111380);
    this.bon = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111380);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    AppMethodBeat.i(111386);
    this.kUn = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString))
        {
          localCursor1 = this.bon.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, esT(), b(new String[] { this.BTW[0] }, false), null, rR(false));
          localObject1 = localCursor1;
        }
      }
      finally
      {
        Cursor localCursor1;
        Cursor localCursor2;
        Object localObject3;
        Object localObject4;
        label240:
        label248:
        paramc = null;
        localObject1 = null;
        continue;
      }
      try
      {
        localCursor2 = this.bon.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, esT(), b(new String[] { this.BTW[0] }, true), null, rR(true));
        if (localCursor1 == null) {}
      }
      finally
      {
        paramc = null;
        continue;
        bool2 = bool1;
        continue;
        do
        {
          break label248;
          if ((localObject2 == null) || (localObject2 == localObject1)) {
            break;
          }
          if (localObject2 == null) {
            break label240;
          }
        } while (localObject2 != localMediaItem);
        continue;
      }
      try
      {
        localCursor1.moveToFirst();
        if (localCursor2 != null) {
          localCursor2.moveToFirst();
        }
        localMediaItem = b(localCursor1, 2);
        localObject1 = b(localCursor2, 2);
        localObject2 = null;
        bool2 = true;
        localObject3 = localObject2;
        localObject4 = localObject1;
        bool1 = bool2;
        if (localObject1 == null) {
          continue;
        }
        localObject3 = localObject2;
        localObject4 = localObject1;
        bool1 = bool2;
        if (localMediaItem == null) {
          continue;
        }
        if (((GalleryItem.MediaItem)localObject1).BVm > localMediaItem.BVm)
        {
          localLinkedList.add(localObject1);
          localCursor2.moveToNext();
          localObject2 = localMediaItem;
          break label925;
          localMediaItem = b(localCursor1, 2);
          break label940;
          localObject1 = b(localCursor2, 2);
          bool1 = bool2;
          if (a(paramc, localLinkedList, paramLong, bool2))
          {
            bool1 = bool2;
            if (bool2) {
              bool1 = false;
            }
          }
          bool2 = this.kUn;
          if (!bool2) {
            break label915;
          }
          if (localCursor1 != null) {
            localCursor1.close();
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
          AppMethodBeat.o(111386);
          return localLinkedList;
          localCursor1 = this.bon.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, esT(), bK(paramString, false), null, rR(false));
          localObject1 = localCursor1;
          localCursor2 = this.bon.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, esT(), bK(paramString, true), null, rR(true));
        }
        else if (((GalleryItem.MediaItem)localObject1).BVm < localMediaItem.BVm)
        {
          localLinkedList.add(localMediaItem);
          localCursor1.moveToNext();
          localObject2 = localObject1;
        }
        else
        {
          localLinkedList.add(localMediaItem);
          localLinkedList.add(localObject1);
          localObject2 = null;
          localCursor2.moveToNext();
          localCursor1.moveToNext();
        }
      }
      finally
      {
        paramc = localCursor2;
        localObject1 = localCursor1;
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        if (paramc != null) {
          paramc.close();
        }
        AppMethodBeat.o(111386);
      }
    }
    bool1 = bool2;
    localObject1 = localObject3;
    bool2 = bool1;
    localObject2 = localMediaItem;
    if (localObject4 != null)
    {
      if ((localObject3 != null) && (localObject3.BVm > ((GalleryItem.MediaItem)localObject4).BVm))
      {
        localLinkedList.add(localObject3);
        localLinkedList.add(localObject4);
        localObject3 = null;
      }
      for (;;)
      {
        localCursor2.moveToNext();
        localObject4 = b(localCursor2, 2);
        bool2 = bool1;
        if (a(paramc, localLinkedList, paramLong, bool1))
        {
          bool2 = bool1;
          if (bool1) {
            bool2 = false;
          }
        }
        bool1 = this.kUn;
        if (!bool1) {
          break;
        }
        if (localCursor1 != null) {
          localCursor1.close();
        }
        if (localCursor2 != null) {
          localCursor2.close();
        }
        AppMethodBeat.o(111386);
        return localLinkedList;
        localLinkedList.add(localObject4);
      }
    }
    if (localObject2 != null)
    {
      if ((localObject1 != null) && (((GalleryItem.MediaItem)localObject1).BVm > ((GalleryItem.MediaItem)localObject2).BVm))
      {
        localLinkedList.add(localObject1);
        localLinkedList.add(localObject2);
        localObject1 = null;
      }
      for (;;)
      {
        localCursor1.moveToNext();
        localObject2 = b(localCursor1, 2);
        bool1 = bool2;
        if (a(paramc, localLinkedList, paramLong, bool2))
        {
          bool1 = bool2;
          if (bool2) {
            bool1 = false;
          }
        }
        boolean bool3 = this.kUn;
        bool2 = bool1;
        if (!bool3) {
          break;
        }
        if (localCursor1 != null) {
          localCursor1.close();
        }
        if (localCursor2 != null) {
          localCursor2.close();
        }
        AppMethodBeat.o(111386);
        return localLinkedList;
        localLinkedList.add(localObject2);
      }
    }
    if (localObject1 != null) {
      localLinkedList.add(localObject1);
    }
    paramc.b(localLinkedList, paramLong, bool2);
    Log.i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), Long.valueOf(paramLong) });
    if (localCursor1 != null) {
      localCursor1.close();
    }
    if (localCursor2 != null) {
      localCursor2.close();
    }
    AppMethodBeat.o(111386);
    return localLinkedList;
  }
  
  /* Error */
  public final int aIq(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: ldc 153
    //   16: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   19: aload_1
    //   20: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +16 -> 39
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 161	com/tencent/mm/plugin/gallery/model/b:aIq	(Ljava/lang/String;)I
    //   31: istore_2
    //   32: ldc 153
    //   34: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iload_2
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 31	com/tencent/mm/plugin/gallery/model/u:bon	Landroid/content/ContentResolver;
    //   43: astore 5
    //   45: getstatic 57	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   48: astore 9
    //   50: aload_0
    //   51: invokevirtual 61	com/tencent/mm/plugin/gallery/model/u:esT	()[Ljava/lang/String;
    //   54: astore 10
    //   56: aload_0
    //   57: aload_1
    //   58: iconst_0
    //   59: invokevirtual 113	com/tencent/mm/plugin/gallery/model/u:bK	(Ljava/lang/String;Z)Ljava/lang/String;
    //   62: astore 11
    //   64: aload_0
    //   65: iconst_0
    //   66: invokevirtual 75	com/tencent/mm/plugin/gallery/model/u:rR	(Z)Ljava/lang/String;
    //   69: astore 12
    //   71: aload 5
    //   73: aload 9
    //   75: aload 10
    //   77: aload 11
    //   79: aconst_null
    //   80: aload 12
    //   82: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 5
    //   87: aload 5
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +125 -> 218
    //   96: aload 4
    //   98: invokeinterface 164 1 0
    //   103: istore_3
    //   104: iload_3
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_0
    //   108: iadd
    //   109: istore_2
    //   110: aload 4
    //   112: ifnull +353 -> 465
    //   115: aload 4
    //   117: invokeinterface 109 1 0
    //   122: aload 8
    //   124: astore 5
    //   126: aload_0
    //   127: getfield 31	com/tencent/mm/plugin/gallery/model/u:bon	Landroid/content/ContentResolver;
    //   130: getstatic 57	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   133: aload_0
    //   134: invokevirtual 61	com/tencent/mm/plugin/gallery/model/u:esT	()[Ljava/lang/String;
    //   137: aload_0
    //   138: aload_1
    //   139: iconst_1
    //   140: invokevirtual 113	com/tencent/mm/plugin/gallery/model/u:bK	(Ljava/lang/String;Z)Ljava/lang/String;
    //   143: aconst_null
    //   144: aload_0
    //   145: iconst_1
    //   146: invokevirtual 75	com/tencent/mm/plugin/gallery/model/u:rR	(Z)Ljava/lang/String;
    //   149: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   152: astore 8
    //   154: aload 8
    //   156: ifnull +126 -> 282
    //   159: aload 8
    //   161: astore 6
    //   163: aload 8
    //   165: astore 5
    //   167: aload 8
    //   169: astore 7
    //   171: aload 8
    //   173: invokeinterface 164 1 0
    //   178: istore_3
    //   179: iload_2
    //   180: iload_3
    //   181: iadd
    //   182: istore_2
    //   183: aload 4
    //   185: ifnull +10 -> 195
    //   188: aload 4
    //   190: invokeinterface 109 1 0
    //   195: iload_2
    //   196: istore_3
    //   197: aload 8
    //   199: ifnull +12 -> 211
    //   202: aload 8
    //   204: invokeinterface 109 1 0
    //   209: iload_2
    //   210: istore_3
    //   211: ldc 153
    //   213: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: iload_3
    //   217: ireturn
    //   218: aload_0
    //   219: aload_1
    //   220: invokespecial 161	com/tencent/mm/plugin/gallery/model/b:aIq	(Ljava/lang/String;)I
    //   223: istore_3
    //   224: iload_3
    //   225: istore_2
    //   226: goto -120 -> 106
    //   229: astore 5
    //   231: aconst_null
    //   232: astore 4
    //   234: ldc 120
    //   236: aload 5
    //   238: ldc 166
    //   240: iconst_0
    //   241: anewarray 124	java/lang/Object
    //   244: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload 4
    //   249: ifnull +213 -> 462
    //   252: aload 4
    //   254: invokeinterface 109 1 0
    //   259: goto -137 -> 122
    //   262: astore_1
    //   263: aload 4
    //   265: ifnull +10 -> 275
    //   268: aload 4
    //   270: invokeinterface 109 1 0
    //   275: ldc 153
    //   277: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_1
    //   281: athrow
    //   282: aload 8
    //   284: astore 6
    //   286: aload 8
    //   288: astore 5
    //   290: aload 8
    //   292: astore 7
    //   294: aload_0
    //   295: aload_1
    //   296: invokespecial 161	com/tencent/mm/plugin/gallery/model/b:aIq	(Ljava/lang/String;)I
    //   299: istore_3
    //   300: goto -121 -> 179
    //   303: astore_1
    //   304: aload 6
    //   306: astore 5
    //   308: ldc 120
    //   310: aload_1
    //   311: ldc 166
    //   313: iconst_0
    //   314: anewarray 124	java/lang/Object
    //   317: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: aload 4
    //   322: ifnull +10 -> 332
    //   325: aload 4
    //   327: invokeinterface 109 1 0
    //   332: iload_2
    //   333: istore_3
    //   334: aload 6
    //   336: ifnull -125 -> 211
    //   339: aload 6
    //   341: invokeinterface 109 1 0
    //   346: iload_2
    //   347: istore_3
    //   348: goto -137 -> 211
    //   351: astore_1
    //   352: aload 4
    //   354: ifnull +10 -> 364
    //   357: aload 4
    //   359: invokeinterface 109 1 0
    //   364: aload 5
    //   366: ifnull +10 -> 376
    //   369: aload 5
    //   371: invokeinterface 109 1 0
    //   376: ldc 153
    //   378: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_1
    //   382: athrow
    //   383: astore_1
    //   384: aload 7
    //   386: astore 6
    //   388: goto -84 -> 304
    //   391: astore_1
    //   392: goto -129 -> 263
    //   395: astore_1
    //   396: goto -133 -> 263
    //   399: astore 5
    //   401: aconst_null
    //   402: astore 4
    //   404: goto -170 -> 234
    //   407: astore 5
    //   409: aconst_null
    //   410: astore 4
    //   412: goto -178 -> 234
    //   415: astore 5
    //   417: aconst_null
    //   418: astore 4
    //   420: goto -186 -> 234
    //   423: astore 5
    //   425: aconst_null
    //   426: astore 4
    //   428: goto -194 -> 234
    //   431: astore 5
    //   433: aconst_null
    //   434: astore 4
    //   436: goto -202 -> 234
    //   439: astore 5
    //   441: goto -207 -> 234
    //   444: astore 5
    //   446: goto -212 -> 234
    //   449: astore 5
    //   451: aconst_null
    //   452: astore 4
    //   454: goto -220 -> 234
    //   457: astore 5
    //   459: goto -225 -> 234
    //   462: goto -340 -> 122
    //   465: goto -343 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	u
    //   0	468	1	paramString	String
    //   13	334	2	i	int
    //   103	245	3	j	int
    //   10	443	4	localObject1	Object
    //   43	123	5	localObject2	Object
    //   229	8	5	localNullPointerException1	java.lang.NullPointerException
    //   288	82	5	localObject3	Object
    //   399	1	5	localNullPointerException2	java.lang.NullPointerException
    //   407	1	5	localNullPointerException3	java.lang.NullPointerException
    //   415	1	5	localNullPointerException4	java.lang.NullPointerException
    //   423	1	5	localNullPointerException5	java.lang.NullPointerException
    //   431	1	5	localNullPointerException6	java.lang.NullPointerException
    //   439	1	5	localNullPointerException7	java.lang.NullPointerException
    //   444	1	5	localNullPointerException8	java.lang.NullPointerException
    //   449	1	5	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   457	1	5	localSQLiteDiskIOException2	android.database.sqlite.SQLiteDiskIOException
    //   1	386	6	localObject4	Object
    //   7	378	7	localCursor1	Cursor
    //   4	287	8	localCursor2	Cursor
    //   48	26	9	localUri	android.net.Uri
    //   54	22	10	arrayOfString	String[]
    //   62	16	11	str1	String
    //   69	12	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   39	45	229	java/lang/NullPointerException
    //   39	45	262	finally
    //   45	50	262	finally
    //   50	56	262	finally
    //   56	64	262	finally
    //   64	71	262	finally
    //   71	87	262	finally
    //   126	154	303	java/lang/NullPointerException
    //   171	179	303	java/lang/NullPointerException
    //   294	300	303	java/lang/NullPointerException
    //   126	154	351	finally
    //   171	179	351	finally
    //   294	300	351	finally
    //   308	320	351	finally
    //   126	154	383	android/database/sqlite/SQLiteDiskIOException
    //   171	179	383	android/database/sqlite/SQLiteDiskIOException
    //   294	300	383	android/database/sqlite/SQLiteDiskIOException
    //   96	104	391	finally
    //   218	224	391	finally
    //   234	247	395	finally
    //   45	50	399	java/lang/NullPointerException
    //   50	56	407	java/lang/NullPointerException
    //   56	64	415	java/lang/NullPointerException
    //   64	71	423	java/lang/NullPointerException
    //   71	87	431	java/lang/NullPointerException
    //   96	104	439	java/lang/NullPointerException
    //   218	224	444	java/lang/NullPointerException
    //   39	45	449	android/database/sqlite/SQLiteDiskIOException
    //   45	50	449	android/database/sqlite/SQLiteDiskIOException
    //   50	56	449	android/database/sqlite/SQLiteDiskIOException
    //   56	64	449	android/database/sqlite/SQLiteDiskIOException
    //   64	71	449	android/database/sqlite/SQLiteDiskIOException
    //   71	87	449	android/database/sqlite/SQLiteDiskIOException
    //   96	104	457	android/database/sqlite/SQLiteDiskIOException
    //   218	224	457	android/database/sqlite/SQLiteDiskIOException
  }
  
  public final String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(111382);
    String str1;
    int j;
    int i;
    String str2;
    if (paramBoolean)
    {
      str1 = "(" + b.BTX + ">2147483647 OR " + b.BTX + "<=0 ) AND (_size>10240";
      j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        str2 = paramArrayOfString[i];
        str1 = str1 + " or lower(_data) like '%" + str2 + "%'";
        i += 1;
      }
    }
    for (paramArrayOfString = str1 + ")";; paramArrayOfString = str1 + ")")
    {
      Log.d("MicroMsg.ImageMediaQuery", "where %s", new Object[] { paramArrayOfString });
      AppMethodBeat.o(111382);
      return paramArrayOfString;
      str1 = b.BTX + "<=2147483647 AND " + b.BTX + ">0 AND (_size>10240";
      j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        str2 = paramArrayOfString[i];
        str1 = str1 + " or lower(_data) like '%" + str2 + "%'";
        i += 1;
      }
    }
  }
  
  public final String bK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111381);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.BTX + ">2147483647 OR " + b.BTX + "<=0 )";; paramString = b.BTX + "<=2147483647 AND " + b.BTX + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111381);
      return paramString;
    }
  }
  
  /* Error */
  public final LinkedList<GalleryItem.AlbumItem> esR()
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 44	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 45	java/util/LinkedList:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 31	com/tencent/mm/plugin/gallery/model/u:bon	Landroid/content/ContentResolver;
    //   17: getstatic 57	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: aload_0
    //   21: invokevirtual 229	com/tencent/mm/plugin/gallery/model/u:esU	()[Ljava/lang/String;
    //   24: aload_0
    //   25: invokevirtual 232	com/tencent/mm/plugin/gallery/model/u:esV	()Ljava/lang/String;
    //   28: aconst_null
    //   29: aload_0
    //   30: invokevirtual 235	com/tencent/mm/plugin/gallery/model/u:esW	()Ljava/lang/String;
    //   33: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +71 -> 111
    //   43: new 237	java/util/HashMap
    //   46: dup
    //   47: invokespecial 238	java/util/HashMap:<init>	()V
    //   50: astore_1
    //   51: aload 4
    //   53: invokeinterface 87 1 0
    //   58: ifeq +53 -> 111
    //   61: aload 4
    //   63: iconst_2
    //   64: ldc 240
    //   66: invokestatic 243	com/tencent/mm/plugin/gallery/model/u:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +15 -> 86
    //   74: aload_1
    //   75: aload_2
    //   76: getfield 248	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:MtW	Ljava/lang/String;
    //   79: aload_2
    //   80: invokeinterface 254 3 0
    //   85: pop
    //   86: aload 4
    //   88: invokeinterface 103 1 0
    //   93: ifne -32 -> 61
    //   96: aload_3
    //   97: aload_1
    //   98: invokeinterface 258 1 0
    //   103: invokevirtual 262	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   106: pop
    //   107: aload_3
    //   108: invokestatic 266	com/tencent/mm/plugin/gallery/model/u:bd	(Ljava/util/LinkedList;)V
    //   111: aload 4
    //   113: ifnull +10 -> 123
    //   116: aload 4
    //   118: invokeinterface 109 1 0
    //   123: ldc 226
    //   125: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_3
    //   129: areturn
    //   130: astore_2
    //   131: ldc 226
    //   133: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: aload 4
    //   141: ifnull +14 -> 155
    //   144: aload_2
    //   145: ifnull +51 -> 196
    //   148: aload 4
    //   150: invokeinterface 109 1 0
    //   155: ldc 226
    //   157: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: ldc 120
    //   165: ldc_w 268
    //   168: iconst_1
    //   169: anewarray 124	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_1
    //   175: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 274	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -59 -> 123
    //   185: astore 4
    //   187: aload_2
    //   188: aload 4
    //   190: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   193: goto -38 -> 155
    //   196: aload 4
    //   198: invokeinterface 109 1 0
    //   203: goto -48 -> 155
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -70 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	u
    //   50	48	1	localHashMap	java.util.HashMap
    //   138	23	1	localObject1	Object
    //   162	13	1	localException	java.lang.Exception
    //   206	1	1	localObject2	Object
    //   69	11	2	localAlbumItem	GalleryItem.AlbumItem
    //   130	58	2	localThrowable1	java.lang.Throwable
    //   208	1	2	localObject3	Object
    //   12	117	3	localLinkedList	LinkedList
    //   36	113	4	localCursor	Cursor
    //   185	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   43	61	130	java/lang/Throwable
    //   61	70	130	java/lang/Throwable
    //   74	86	130	java/lang/Throwable
    //   86	111	130	java/lang/Throwable
    //   131	138	138	finally
    //   13	38	162	java/lang/Exception
    //   116	123	162	java/lang/Exception
    //   148	155	162	java/lang/Exception
    //   155	162	162	java/lang/Exception
    //   187	193	162	java/lang/Exception
    //   196	203	162	java/lang/Exception
    //   148	155	185	java/lang/Throwable
    //   43	61	206	finally
    //   61	70	206	finally
    //   74	86	206	finally
    //   86	111	206	finally
  }
  
  public final String[] esT()
  {
    return new String[] { "_id", "_data", b.BTY, b.BTX, "mime_type", "latitude", "longitude" };
  }
  
  public final String[] esU()
  {
    AppMethodBeat.i(111384);
    if (e.evd())
    {
      str1 = b.BTY;
      str2 = b.BTX;
      AppMethodBeat.o(111384);
      return new String[] { "_id", "_data", "bucket_display_name", str1, str2, "mime_type", "bucket_id" };
    }
    String str1 = b.BTY;
    String str2 = b.BTX;
    String str3 = "max(" + b.BTX + ") as max_time";
    AppMethodBeat.o(111384);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String esV()
  {
    AppMethodBeat.i(241144);
    if (e.evd())
    {
      AppMethodBeat.o(241144);
      return null;
    }
    AppMethodBeat.o(241144);
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  public final String esW()
  {
    AppMethodBeat.i(241145);
    if (e.evd())
    {
      AppMethodBeat.o(241145);
      return "_id desc";
    }
    AppMethodBeat.o(241145);
    return "max_time desc, _id desc";
  }
  
  public final String rR(boolean paramBoolean)
  {
    AppMethodBeat.i(111383);
    if (paramBoolean)
    {
      str = b.BTY + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111383);
      return str;
    }
    String str = b.BTX + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111383);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.u
 * JD-Core Version:    0.7.0.1
 */