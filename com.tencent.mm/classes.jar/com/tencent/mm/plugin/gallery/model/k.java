package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class k
  extends b
{
  protected ContentResolver bEK;
  
  public k()
  {
    AppMethodBeat.i(111331);
    this.bEK = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111331);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    AppMethodBeat.i(111337);
    this.ifz = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString))
        {
          localCursor1 = this.bEK.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), b(this.xhJ, false), null, pw(false));
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
        localCursor2 = this.bEK.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), b(this.xhJ, true), null, pw(true));
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
        if (((GalleryItem.MediaItem)localObject1).xja > localMediaItem.xja)
        {
          localLinkedList.add(localObject1);
          localCursor2.moveToNext();
          localObject2 = localMediaItem;
          break label959;
          localMediaItem = b(localCursor1, 1);
          break label974;
          localObject1 = b(localCursor2, 1);
          bool1 = bool2;
          if (a(paramc, localLinkedList, paramLong, bool2))
          {
            bool1 = bool2;
            if (bool2) {
              bool1 = false;
            }
          }
          bool2 = this.ifz;
          if (!bool2) {
            break label949;
          }
          if (localCursor1 != null) {
            localCursor1.close();
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
          AppMethodBeat.o(111337);
          return localLinkedList;
          localCursor1 = this.bEK.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), bF(paramString, false), null, pw(false));
          localObject1 = localCursor1;
          localCursor2 = this.bEK.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, getProjection(), bF(paramString, true), null, pw(true));
        }
        else if (((GalleryItem.MediaItem)localObject1).xja < localMediaItem.xja)
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
      if ((localObject3 != null) && (localObject3.xja > ((GalleryItem.MediaItem)localObject4).xja))
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
        bool1 = this.ifz;
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
      if ((localObject1 != null) && (((GalleryItem.MediaItem)localObject1).xja > ((GalleryItem.MediaItem)localObject2).xja))
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
        boolean bool3 = this.ifz;
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
    if (paramc != null) {
      paramc.b(localLinkedList, paramLong, bool2);
    }
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
  
  public final String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(111333);
    String str1;
    int j;
    int i;
    String str2;
    if (paramBoolean)
    {
      str1 = "(" + b.xhK + ">2147483647 OR " + b.xhK + "<=0 ) AND (_size>10240";
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
      str1 = b.xhK + "<=2147483647 AND " + b.xhK + ">0 AND (_size>10240";
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
  
  public final String bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111332);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.xhK + ">2147483647 OR " + b.xhK + "<=0 )";; paramString = b.xhK + "<=2147483647 AND " + b.xhK + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111332);
      return paramString;
    }
  }
  
  /* Error */
  public final LinkedList<GalleryItem.AlbumItem> dQr()
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 44	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 45	java/util/LinkedList:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 31	com/tencent/mm/plugin/gallery/model/k:bEK	Landroid/content/ContentResolver;
    //   17: getstatic 57	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: aload_0
    //   21: invokevirtual 210	com/tencent/mm/plugin/gallery/model/k:dQt	()[Ljava/lang/String;
    //   24: aload_0
    //   25: invokevirtual 213	com/tencent/mm/plugin/gallery/model/k:dQu	()Ljava/lang/String;
    //   28: aconst_null
    //   29: aload_0
    //   30: invokevirtual 216	com/tencent/mm/plugin/gallery/model/k:dQv	()Ljava/lang/String;
    //   33: invokevirtual 79	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +71 -> 111
    //   43: new 218	java/util/HashMap
    //   46: dup
    //   47: invokespecial 219	java/util/HashMap:<init>	()V
    //   50: astore_1
    //   51: aload 4
    //   53: invokeinterface 106 1 0
    //   58: ifeq +53 -> 111
    //   61: aload 4
    //   63: iconst_1
    //   64: ldc 221
    //   66: invokestatic 224	com/tencent/mm/plugin/gallery/model/k:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +15 -> 86
    //   74: aload_1
    //   75: aload_2
    //   76: getfield 229	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:UpY	Ljava/lang/String;
    //   79: aload_2
    //   80: invokeinterface 235 3 0
    //   85: pop
    //   86: aload 4
    //   88: invokeinterface 124 1 0
    //   93: ifne -32 -> 61
    //   96: aload_3
    //   97: aload_1
    //   98: invokeinterface 239 1 0
    //   103: invokevirtual 243	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   106: pop
    //   107: aload_3
    //   108: invokestatic 247	com/tencent/mm/plugin/gallery/model/k:aK	(Ljava/util/LinkedList;)V
    //   111: aload 4
    //   113: ifnull +10 -> 123
    //   116: aload 4
    //   118: invokeinterface 130 1 0
    //   123: ldc 207
    //   125: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_3
    //   129: areturn
    //   130: astore_2
    //   131: ldc 207
    //   133: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: aload 4
    //   141: ifnull +14 -> 155
    //   144: aload_2
    //   145: ifnull +50 -> 195
    //   148: aload 4
    //   150: invokeinterface 130 1 0
    //   155: ldc 207
    //   157: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: ldc 81
    //   165: ldc 249
    //   167: iconst_1
    //   168: anewarray 85	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_1
    //   174: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: goto -58 -> 123
    //   184: astore 4
    //   186: aload_2
    //   187: aload 4
    //   189: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   192: goto -37 -> 155
    //   195: aload 4
    //   197: invokeinterface 130 1 0
    //   202: goto -47 -> 155
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_2
    //   208: goto -69 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	k
    //   50	48	1	localHashMap	java.util.HashMap
    //   138	23	1	localObject1	Object
    //   162	12	1	localException	java.lang.Exception
    //   205	1	1	localObject2	Object
    //   69	11	2	localAlbumItem	GalleryItem.AlbumItem
    //   130	57	2	localThrowable1	java.lang.Throwable
    //   207	1	2	localObject3	Object
    //   12	117	3	localLinkedList	LinkedList
    //   36	113	4	localCursor	Cursor
    //   184	12	4	localThrowable2	java.lang.Throwable
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
    //   186	192	162	java/lang/Exception
    //   195	202	162	java/lang/Exception
    //   148	155	184	java/lang/Throwable
    //   43	61	205	finally
    //   61	70	205	finally
    //   74	86	205	finally
    //   86	111	205	finally
  }
  
  public final String[] dQt()
  {
    AppMethodBeat.i(111335);
    if (d.dSB())
    {
      str1 = b.xhL;
      str2 = b.xhK;
      AppMethodBeat.o(111335);
      return new String[] { "_id", "_data", "bucket_display_name", str1, str2, "mime_type", "bucket_id" };
    }
    String str1 = b.xhL;
    String str2 = b.xhK;
    String str3 = "max(" + b.xhK + ") as max_time";
    AppMethodBeat.o(111335);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String dQu()
  {
    AppMethodBeat.i(257728);
    if (d.dSB())
    {
      AppMethodBeat.o(257728);
      return null;
    }
    AppMethodBeat.o(257728);
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  public final String dQv()
  {
    AppMethodBeat.i(257729);
    if (d.dSB())
    {
      AppMethodBeat.o(257729);
      return "_id desc";
    }
    AppMethodBeat.o(257729);
    return "max_time desc, _id desc";
  }
  
  public final String[] getProjection()
  {
    return new String[] { "_id", "_data", b.xhL, b.xhK, "mime_type", "latitude", "longitude" };
  }
  
  public final String pw(boolean paramBoolean)
  {
    AppMethodBeat.i(111334);
    if (paramBoolean)
    {
      str = b.xhL + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111334);
      return str;
    }
    String str = b.xhK + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.k
 * JD-Core Version:    0.7.0.1
 */