package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends b
{
  protected ContentResolver bon;
  
  public k()
  {
    AppMethodBeat.i(111331);
    this.bon = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111331);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    AppMethodBeat.i(111337);
    this.kUn = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString))
        {
          localCursor1 = this.bon.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, esT(), b(this.BTW, false), null, rR(false));
          localObject1 = localCursor1;
        }
      }
      finally
      {
        Cursor localCursor1;
        Cursor localCursor2;
        Object localObject3;
        Object localObject4;
        label270:
        label278:
        paramc = null;
        localObject1 = null;
        continue;
      }
      try
      {
        localCursor2 = this.bon.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, esT(), b(this.BTW, true), null, rR(true));
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
          break label278;
          if ((localObject2 == null) || (localObject2 == localObject1)) {
            break;
          }
          if (localObject2 == null) {
            break label270;
          }
        } while (localObject2 != localMediaItem);
        continue;
      }
      try
      {
        Log.i("MicroMsg.ImageMediaQuery", "cursorValid count:%s", new Object[] { Integer.valueOf(localCursor1.getCount()) });
        localCursor1.moveToFirst();
        if (localCursor2 != null)
        {
          Log.i("MicroMsg.ImageMediaQuery", "cursorInvalid count:%s", new Object[] { Integer.valueOf(localCursor2.getCount()) });
          localCursor2.moveToFirst();
        }
        localMediaItem = b(localCursor1, 1);
        localObject1 = b(localCursor2, 1);
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
          break label955;
          localMediaItem = b(localCursor1, 1);
          break label970;
          localObject1 = b(localCursor2, 1);
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
            break label945;
          }
          if (localCursor1 != null) {
            localCursor1.close();
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
          AppMethodBeat.o(111337);
          return localLinkedList;
          localCursor1 = this.bon.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, esT(), bK(paramString, false), null, rR(false));
          localObject1 = localCursor1;
          localCursor2 = this.bon.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, esT(), bK(paramString, true), null, rR(true));
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
        AppMethodBeat.o(111337);
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
        localObject4 = b(localCursor2, 1);
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
        AppMethodBeat.o(111337);
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
        localObject2 = b(localCursor1, 1);
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
        AppMethodBeat.o(111337);
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
    AppMethodBeat.o(111337);
    return localLinkedList;
  }
  
  /* Error */
  public final int aIp(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: iconst_0
    //   13: istore_3
    //   14: ldc 158
    //   16: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   19: aload_1
    //   20: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +16 -> 39
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 166	com/tencent/mm/plugin/gallery/model/b:aIp	(Ljava/lang/String;)I
    //   31: istore_2
    //   32: ldc 158
    //   34: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iload_2
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 31	com/tencent/mm/plugin/gallery/model/k:bon	Landroid/content/ContentResolver;
    //   43: getstatic 57	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   46: aload_0
    //   47: invokevirtual 61	com/tencent/mm/plugin/gallery/model/k:esT	()[Ljava/lang/String;
    //   50: aload_0
    //   51: aload_1
    //   52: iconst_0
    //   53: invokevirtual 134	com/tencent/mm/plugin/gallery/model/k:bK	(Ljava/lang/String;Z)Ljava/lang/String;
    //   56: aconst_null
    //   57: aload_0
    //   58: iconst_0
    //   59: invokevirtual 73	com/tencent/mm/plugin/gallery/model/k:rR	(Z)Ljava/lang/String;
    //   62: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +123 -> 192
    //   72: aload 5
    //   74: astore 6
    //   76: aload 5
    //   78: invokeinterface 91 1 0
    //   83: istore_2
    //   84: iload_2
    //   85: iconst_0
    //   86: iadd
    //   87: istore_2
    //   88: aload 5
    //   90: ifnull +287 -> 377
    //   93: aload 5
    //   95: invokeinterface 130 1 0
    //   100: aload 9
    //   102: astore 5
    //   104: aload 8
    //   106: astore 4
    //   108: aload 7
    //   110: astore 6
    //   112: aload_0
    //   113: getfield 31	com/tencent/mm/plugin/gallery/model/k:bon	Landroid/content/ContentResolver;
    //   116: getstatic 57	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   119: aload_0
    //   120: invokevirtual 61	com/tencent/mm/plugin/gallery/model/k:esT	()[Ljava/lang/String;
    //   123: aload_0
    //   124: aload_1
    //   125: iconst_1
    //   126: invokevirtual 134	com/tencent/mm/plugin/gallery/model/k:bK	(Ljava/lang/String;Z)Ljava/lang/String;
    //   129: aconst_null
    //   130: aload_0
    //   131: iconst_1
    //   132: invokevirtual 73	com/tencent/mm/plugin/gallery/model/k:rR	(Z)Ljava/lang/String;
    //   135: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   138: astore 7
    //   140: aload 7
    //   142: ifnull +124 -> 266
    //   145: aload 7
    //   147: astore 5
    //   149: aload 7
    //   151: astore 4
    //   153: aload 7
    //   155: astore 6
    //   157: aload 7
    //   159: invokeinterface 91 1 0
    //   164: istore_3
    //   165: iload_2
    //   166: iload_3
    //   167: iadd
    //   168: istore_2
    //   169: iload_2
    //   170: istore_3
    //   171: aload 7
    //   173: ifnull +12 -> 185
    //   176: aload 7
    //   178: invokeinterface 130 1 0
    //   183: iload_2
    //   184: istore_3
    //   185: ldc 158
    //   187: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iload_3
    //   191: ireturn
    //   192: aload 5
    //   194: astore 6
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 166	com/tencent/mm/plugin/gallery/model/b:aIp	(Ljava/lang/String;)I
    //   201: istore_2
    //   202: goto -118 -> 84
    //   205: astore 4
    //   207: aconst_null
    //   208: astore 5
    //   210: aload 5
    //   212: astore 6
    //   214: ldc 81
    //   216: aload 4
    //   218: ldc 168
    //   220: iconst_0
    //   221: anewarray 85	java/lang/Object
    //   224: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: iload_3
    //   228: istore_2
    //   229: aload 5
    //   231: ifnull -131 -> 100
    //   234: aload 5
    //   236: invokeinterface 130 1 0
    //   241: iload_3
    //   242: istore_2
    //   243: goto -143 -> 100
    //   246: astore_1
    //   247: aload 4
    //   249: ifnull +10 -> 259
    //   252: aload 4
    //   254: invokeinterface 130 1 0
    //   259: ldc 158
    //   261: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: athrow
    //   266: aload 7
    //   268: astore 5
    //   270: aload 7
    //   272: astore 4
    //   274: aload 7
    //   276: astore 6
    //   278: aload_0
    //   279: aload_1
    //   280: invokespecial 166	com/tencent/mm/plugin/gallery/model/b:aIp	(Ljava/lang/String;)I
    //   283: istore_3
    //   284: goto -119 -> 165
    //   287: astore_1
    //   288: aload 5
    //   290: astore 4
    //   292: ldc 81
    //   294: aload_1
    //   295: ldc 168
    //   297: iconst_0
    //   298: anewarray 85	java/lang/Object
    //   301: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: iload_2
    //   305: istore_3
    //   306: aload 5
    //   308: ifnull -123 -> 185
    //   311: aload 5
    //   313: invokeinterface 130 1 0
    //   318: iload_2
    //   319: istore_3
    //   320: goto -135 -> 185
    //   323: astore_1
    //   324: aload 4
    //   326: ifnull +10 -> 336
    //   329: aload 4
    //   331: invokeinterface 130 1 0
    //   336: ldc 158
    //   338: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_1
    //   342: athrow
    //   343: astore_1
    //   344: aload 6
    //   346: astore 5
    //   348: goto -60 -> 288
    //   351: astore_1
    //   352: aload 6
    //   354: astore 4
    //   356: goto -109 -> 247
    //   359: astore 4
    //   361: goto -151 -> 210
    //   364: astore 4
    //   366: aconst_null
    //   367: astore 5
    //   369: goto -159 -> 210
    //   372: astore 4
    //   374: goto -164 -> 210
    //   377: goto -277 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	k
    //   0	380	1	paramString	String
    //   31	288	2	i	int
    //   13	307	3	j	int
    //   10	142	4	localObject1	Object
    //   205	48	4	localNullPointerException1	java.lang.NullPointerException
    //   272	83	4	localObject2	Object
    //   359	1	4	localNullPointerException2	java.lang.NullPointerException
    //   364	1	4	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   372	1	4	localSQLiteDiskIOException2	android.database.sqlite.SQLiteDiskIOException
    //   65	303	5	localObject3	Object
    //   74	279	6	localObject4	Object
    //   7	268	7	localCursor	Cursor
    //   4	101	8	localObject5	Object
    //   1	100	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   39	67	205	java/lang/NullPointerException
    //   39	67	246	finally
    //   112	140	287	java/lang/NullPointerException
    //   157	165	287	java/lang/NullPointerException
    //   278	284	287	java/lang/NullPointerException
    //   112	140	323	finally
    //   157	165	323	finally
    //   278	284	323	finally
    //   292	304	323	finally
    //   112	140	343	android/database/sqlite/SQLiteDiskIOException
    //   157	165	343	android/database/sqlite/SQLiteDiskIOException
    //   278	284	343	android/database/sqlite/SQLiteDiskIOException
    //   76	84	351	finally
    //   196	202	351	finally
    //   214	227	351	finally
    //   76	84	359	java/lang/NullPointerException
    //   196	202	359	java/lang/NullPointerException
    //   39	67	364	android/database/sqlite/SQLiteDiskIOException
    //   76	84	372	android/database/sqlite/SQLiteDiskIOException
    //   196	202	372	android/database/sqlite/SQLiteDiskIOException
  }
  
  public final String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(111333);
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
      AppMethodBeat.o(111333);
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
    AppMethodBeat.i(111332);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.BTX + ">2147483647 OR " + b.BTX + "<=0 )";; paramString = b.BTX + "<=2147483647 AND " + b.BTX + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111332);
      return paramString;
    }
  }
  
  public final LinkedList<GalleryItem.AlbumItem> esR()
  {
    AppMethodBeat.i(111336);
    LinkedList localLinkedList = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    try
    {
      Cursor localCursor1 = this.bon.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, esU(), esV(), null, esW());
      if (localCursor1 == null)
      {
        Log.d("MicroMsg.ImageMediaQuery", "no image folder now");
        if (!localHashMap.isEmpty())
        {
          localLinkedList.addAll(localHashMap.values());
          Collections.sort(localLinkedList);
        }
        bd(localLinkedList);
        AppMethodBeat.o(111336);
        return localLinkedList;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ImageMediaQuery", "query image album list failed : [%s]", new Object[] { localException1.getMessage() });
        Cursor localCursor2 = null;
        continue;
        try
        {
          if (localCursor2.moveToFirst())
          {
            label133:
            localAlbumItem = a(localCursor2, 1, "bucket_display_name");
            if (localAlbumItem != null)
            {
              if (localArrayList.contains(localAlbumItem.albumName)) {
                break label213;
              }
              localHashMap.put(localAlbumItem.MtW, localAlbumItem);
              localArrayList.add(localAlbumItem.albumName);
            }
          }
          for (;;)
          {
            boolean bool = localCursor2.moveToNext();
            if (bool) {
              break label133;
            }
            if (localCursor2 == null) {
              break;
            }
            localCursor2.close();
            break;
            label213:
            if ((!localHashMap.containsKey(localAlbumItem.MtW)) || (localAlbumItem.BVd == null) || (((GalleryItem.AlbumItem)localHashMap.get(localAlbumItem.MtW)).BVd == null) || (localAlbumItem.BVd.d(((GalleryItem.AlbumItem)localHashMap.get(localAlbumItem.MtW)).BVd) <= 0)) {
              break label331;
            }
            localHashMap.put(localAlbumItem.MtW, localAlbumItem);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            GalleryItem.AlbumItem localAlbumItem;
            Log.e("MicroMsg.ImageMediaQuery", "query image album list failed : [%s]", new Object[] { localException2.getMessage() });
            if (localCursor2 == null) {
              break;
            }
            localCursor2.close();
            break;
            label331:
            Log.w("MicroMsg.ImageMediaQuery", "queryAlbumListWalkAround, videoAlbumMap no containsKey = " + localAlbumItem.MtW + ", albumName= " + localAlbumItem.albumName);
          }
        }
        finally
        {
          if (localCursor2 != null) {
            localCursor2.close();
          }
          AppMethodBeat.o(111336);
        }
      }
    }
  }
  
  public final String[] esT()
  {
    return new String[] { "_id", "_data", b.BTY, b.BTX, "mime_type", "latitude", "longitude" };
  }
  
  public final String[] esU()
  {
    AppMethodBeat.i(111335);
    if (e.evd())
    {
      str1 = b.BTY;
      str2 = b.BTX;
      AppMethodBeat.o(111335);
      return new String[] { "_id", "_data", "bucket_display_name", str1, str2, "mime_type", "bucket_id" };
    }
    String str1 = b.BTY;
    String str2 = b.BTX;
    String str3 = "max(" + b.BTX + ") as max_time";
    AppMethodBeat.o(111335);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String esV()
  {
    AppMethodBeat.i(241763);
    if (e.evd())
    {
      AppMethodBeat.o(241763);
      return null;
    }
    AppMethodBeat.o(241763);
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  public final String esW()
  {
    AppMethodBeat.i(241767);
    if (e.evd())
    {
      AppMethodBeat.o(241767);
      return "_id desc";
    }
    AppMethodBeat.o(241767);
    return "max_time desc, _id desc";
  }
  
  public final String rR(boolean paramBoolean)
  {
    AppMethodBeat.i(111334);
    if (paramBoolean)
    {
      str = b.BTY + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111334);
      return str;
    }
    String str = b.BTX + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.k
 * JD-Core Version:    0.7.0.1
 */