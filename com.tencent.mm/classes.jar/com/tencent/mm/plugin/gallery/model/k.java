package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class k
  extends b
{
  protected ContentResolver bwu;
  
  public k()
  {
    AppMethodBeat.i(111331);
    this.bwu = aj.getContext().getContentResolver();
    AppMethodBeat.o(111331);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    AppMethodBeat.i(111337);
    this.gqP = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (bt.isNullOrNil(paramString))
        {
          localCursor1 = this.bwu.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), b(this.rAc, false), null, lC(false));
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
        localCursor2 = this.bwu.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), b(this.rAc, true), null, lC(true));
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
        ad.i("MicroMsg.ImageMediaQuery", "cursorValid count:%s", new Object[] { Integer.valueOf(localCursor1.getCount()) });
        localCursor1.moveToFirst();
        if (localCursor2 != null)
        {
          ad.i("MicroMsg.ImageMediaQuery", "cursorInvalid count:%s", new Object[] { Integer.valueOf(localCursor2.getCount()) });
          localCursor2.moveToFirst();
        }
        localMediaItem = c(localCursor1, 1);
        localObject1 = c(localCursor2, 1);
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
        if (((GalleryItem.MediaItem)localObject1).rBt > localMediaItem.rBt)
        {
          localLinkedList.add(localObject1);
          localCursor2.moveToNext();
          localObject2 = localMediaItem;
          break label955;
          localMediaItem = c(localCursor1, 1);
          break label970;
          localObject1 = c(localCursor2, 1);
          bool1 = bool2;
          if (a(paramc, localLinkedList, paramLong, bool2))
          {
            bool1 = bool2;
            if (bool2) {
              bool1 = false;
            }
          }
          bool2 = this.gqP;
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
          localCursor1 = this.bwu.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), bd(paramString, false), null, lC(false));
          localObject1 = localCursor1;
          localCursor2 = this.bwu.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), bd(paramString, true), null, lC(true));
        }
        else if (((GalleryItem.MediaItem)localObject1).rBt < localMediaItem.rBt)
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
      if ((localObject3 != null) && (localObject3.rBt > ((GalleryItem.MediaItem)localObject4).rBt))
      {
        localLinkedList.add(localObject3);
        localLinkedList.add(localObject4);
        localObject3 = null;
      }
      for (;;)
      {
        localCursor2.moveToNext();
        localObject4 = c(localCursor2, 1);
        bool2 = bool1;
        if (a(paramc, localLinkedList, paramLong, bool1))
        {
          bool2 = bool1;
          if (bool1) {
            bool2 = false;
          }
        }
        bool1 = this.gqP;
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
      if ((localObject1 != null) && (((GalleryItem.MediaItem)localObject1).rBt > ((GalleryItem.MediaItem)localObject2).rBt))
      {
        localLinkedList.add(localObject1);
        localLinkedList.add(localObject2);
        localObject1 = null;
      }
      for (;;)
      {
        localCursor1.moveToNext();
        localObject2 = c(localCursor1, 1);
        bool1 = bool2;
        if (a(paramc, localLinkedList, paramLong, bool2))
        {
          bool1 = bool2;
          if (bool2) {
            bool1 = false;
          }
        }
        boolean bool3 = this.gqP;
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
    ad.i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), Long.valueOf(paramLong) });
    if (localCursor1 != null) {
      localCursor1.close();
    }
    if (localCursor2 != null) {
      localCursor2.close();
    }
    AppMethodBeat.o(111337);
    return localLinkedList;
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
      str1 = "(" + b.rAd + ">2147483647 OR " + b.rAd + "<=0 ) AND (_size>10240";
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
      ad.d("MicroMsg.ImageMediaQuery", "where %s", new Object[] { paramArrayOfString });
      AppMethodBeat.o(111333);
      return paramArrayOfString;
      str1 = b.rAd + "<=2147483647 AND " + b.rAd + ">0 AND (_size>10240";
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
  
  public final String bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111332);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name=\"").append(paramString).append("\" AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.rAd + ">2147483647 OR " + b.rAd + "<=0 )";; paramString = b.rAd + "<=2147483647 AND " + b.rAd + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111332);
      return paramString;
    }
  }
  
  /* Error */
  public final LinkedList<GalleryItem.AlbumItem> cyR()
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 44	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 45	java/util/LinkedList:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 31	com/tencent/mm/plugin/gallery/model/k:bwu	Landroid/content/ContentResolver;
    //   17: getstatic 57	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: aload_0
    //   21: invokevirtual 211	com/tencent/mm/plugin/gallery/model/k:cyS	()[Ljava/lang/String;
    //   24: ldc 213
    //   26: aconst_null
    //   27: ldc 215
    //   29: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +46 -> 82
    //   39: aload 4
    //   41: invokeinterface 106 1 0
    //   46: ifeq +36 -> 82
    //   49: aload 4
    //   51: iconst_1
    //   52: ldc 217
    //   54: invokestatic 220	com/tencent/mm/plugin/gallery/model/k:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_3
    //   63: aload_1
    //   64: invokevirtual 122	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload 4
    //   70: invokeinterface 125 1 0
    //   75: ifne -26 -> 49
    //   78: aload_3
    //   79: invokestatic 224	com/tencent/mm/plugin/gallery/model/k:ag	(Ljava/util/LinkedList;)V
    //   82: aload 4
    //   84: ifnull +10 -> 94
    //   87: aload 4
    //   89: invokeinterface 131 1 0
    //   94: ldc 208
    //   96: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_3
    //   100: areturn
    //   101: astore_2
    //   102: ldc 208
    //   104: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: aload 4
    //   112: ifnull +14 -> 126
    //   115: aload_2
    //   116: ifnull +50 -> 166
    //   119: aload 4
    //   121: invokeinterface 131 1 0
    //   126: ldc 208
    //   128: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: ldc 81
    //   136: ldc 226
    //   138: iconst_1
    //   139: anewarray 85	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: goto -58 -> 94
    //   155: astore 4
    //   157: aload_2
    //   158: aload 4
    //   160: invokevirtual 236	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   163: goto -37 -> 126
    //   166: aload 4
    //   168: invokeinterface 131 1 0
    //   173: goto -47 -> 126
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -69 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	k
    //   57	7	1	localAlbumItem	GalleryItem.AlbumItem
    //   109	23	1	localObject1	Object
    //   133	12	1	localException	java.lang.Exception
    //   176	1	1	localObject2	Object
    //   101	57	2	localThrowable1	java.lang.Throwable
    //   178	1	2	localObject3	Object
    //   12	88	3	localLinkedList	LinkedList
    //   32	88	4	localCursor	Cursor
    //   155	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   39	49	101	java/lang/Throwable
    //   49	58	101	java/lang/Throwable
    //   62	68	101	java/lang/Throwable
    //   68	82	101	java/lang/Throwable
    //   102	109	109	finally
    //   13	34	133	java/lang/Exception
    //   87	94	133	java/lang/Exception
    //   119	126	133	java/lang/Exception
    //   126	133	133	java/lang/Exception
    //   157	163	133	java/lang/Exception
    //   166	173	133	java/lang/Exception
    //   119	126	155	java/lang/Throwable
    //   39	49	176	finally
    //   49	58	176	finally
    //   62	68	176	finally
    //   68	82	176	finally
  }
  
  public final String[] cyS()
  {
    AppMethodBeat.i(111335);
    String str1 = b.rAe;
    String str2 = b.rAd;
    String str3 = "max(" + b.rAd + ") as max_time";
    AppMethodBeat.o(111335);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String[] getProjection()
  {
    return new String[] { "_id", "_data", b.rAe, b.rAd, "mime_type", "latitude", "longitude" };
  }
  
  public final String lC(boolean paramBoolean)
  {
    AppMethodBeat.i(111334);
    if (paramBoolean)
    {
      str = b.rAe + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111334);
      return str;
    }
    String str = b.rAd + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.k
 * JD-Core Version:    0.7.0.1
 */