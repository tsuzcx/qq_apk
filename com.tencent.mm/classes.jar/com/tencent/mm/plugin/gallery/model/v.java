package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class v
  extends b
{
  protected final ContentResolver dif;
  
  public v()
  {
    AppMethodBeat.i(111380);
    this.dif = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111380);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, l.c paramc, long paramLong)
  {
    AppMethodBeat.i(111386);
    this.nzW = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString))
        {
          localCursor1 = this.dif.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, fzV(), b(new String[] { this.HGr[0] }, false), null, vQ(false));
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
        localCursor2 = this.dif.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, fzV(), b(new String[] { this.HGr[0] }, true), null, vQ(true));
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
        localMediaItem = c(localCursor1, 2);
        localObject1 = c(localCursor2, 2);
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
        if (((GalleryItem.MediaItem)localObject1).HHK > localMediaItem.HHK)
        {
          localLinkedList.add(localObject1);
          localCursor2.moveToNext();
          localObject2 = localMediaItem;
          break label925;
          localMediaItem = c(localCursor1, 2);
          break label940;
          localObject1 = c(localCursor2, 2);
          bool1 = bool2;
          if (a(paramc, localLinkedList, paramLong, bool2))
          {
            bool1 = bool2;
            if (bool2) {
              bool1 = false;
            }
          }
          bool2 = this.nzW;
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
          localCursor1 = this.dif.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, fzV(), ce(paramString, false), null, vQ(false));
          localObject1 = localCursor1;
          localCursor2 = this.dif.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, fzV(), ce(paramString, true), null, vQ(true));
        }
        else if (((GalleryItem.MediaItem)localObject1).HHK < localMediaItem.HHK)
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
      if ((localObject3 != null) && (localObject3.HHK > ((GalleryItem.MediaItem)localObject4).HHK))
      {
        localLinkedList.add(localObject3);
        localLinkedList.add(localObject4);
        localObject3 = null;
      }
      for (;;)
      {
        localCursor2.moveToNext();
        localObject4 = c(localCursor2, 2);
        bool2 = bool1;
        if (a(paramc, localLinkedList, paramLong, bool1))
        {
          bool2 = bool1;
          if (bool1) {
            bool2 = false;
          }
        }
        bool1 = this.nzW;
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
      if ((localObject1 != null) && (((GalleryItem.MediaItem)localObject1).HHK > ((GalleryItem.MediaItem)localObject2).HHK))
      {
        localLinkedList.add(localObject1);
        localLinkedList.add(localObject2);
        localObject1 = null;
      }
      for (;;)
      {
        localCursor1.moveToNext();
        localObject2 = c(localCursor1, 2);
        bool1 = bool2;
        if (a(paramc, localLinkedList, paramLong, bool2))
        {
          bool1 = bool2;
          if (bool2) {
            bool1 = false;
          }
        }
        boolean bool3 = this.nzW;
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
  
  public final String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(111382);
    String str1;
    int j;
    int i;
    String str2;
    if (paramBoolean)
    {
      str1 = "(" + b.HGs + ">2147483647 OR " + b.HGs + "<=0 ) AND (_size>10240";
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
      str1 = b.HGs + "<=2147483647 AND " + b.HGs + ">0 AND (_size>10240";
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
  
  public final String ce(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111381);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.HGs + ">2147483647 OR " + b.HGs + "<=0 )";; paramString = b.HGs + "<=2147483647 AND " + b.HGs + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111381);
      return paramString;
    }
  }
  
  /* Error */
  public final LinkedList<GalleryItem.AlbumItem> fzT()
  {
    // Byte code:
    //   0: ldc 201
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 44	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 45	java/util/LinkedList:<init>	()V
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 31	com/tencent/mm/plugin/gallery/model/v:dif	Landroid/content/ContentResolver;
    //   17: getstatic 57	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: aload_0
    //   21: invokevirtual 204	com/tencent/mm/plugin/gallery/model/v:fzW	()[Ljava/lang/String;
    //   24: aload_0
    //   25: invokevirtual 207	com/tencent/mm/plugin/gallery/model/v:fzX	()Ljava/lang/String;
    //   28: aconst_null
    //   29: aload_0
    //   30: invokevirtual 210	com/tencent/mm/plugin/gallery/model/v:fzY	()Ljava/lang/String;
    //   33: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +72 -> 110
    //   41: new 212	java/util/HashMap
    //   44: dup
    //   45: invokespecial 213	java/util/HashMap:<init>	()V
    //   48: astore_3
    //   49: aload_2
    //   50: invokeinterface 87 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_2
    //   59: iconst_2
    //   60: ldc 215
    //   62: invokestatic 218	com/tencent/mm/plugin/gallery/model/v:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +17 -> 86
    //   72: aload_3
    //   73: aload 4
    //   75: getfield 223	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:akit	Ljava/lang/String;
    //   78: aload 4
    //   80: invokeinterface 229 3 0
    //   85: pop
    //   86: aload_2
    //   87: invokeinterface 104 1 0
    //   92: ifne -34 -> 58
    //   95: aload_1
    //   96: aload_3
    //   97: invokeinterface 233 1 0
    //   102: invokevirtual 237	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   105: pop
    //   106: aload_1
    //   107: invokestatic 241	com/tencent/mm/plugin/gallery/model/v:bl	(Ljava/util/LinkedList;)V
    //   110: aload_2
    //   111: ifnull +9 -> 120
    //   114: aload_2
    //   115: invokeinterface 110 1 0
    //   120: ldc 201
    //   122: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_1
    //   126: areturn
    //   127: astore_3
    //   128: aload_2
    //   129: ifnull +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 110 1 0
    //   138: ldc 201
    //   140: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_3
    //   144: athrow
    //   145: astore_2
    //   146: ldc 121
    //   148: ldc 243
    //   150: iconst_1
    //   151: anewarray 125	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_2
    //   157: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   160: aastore
    //   161: invokestatic 249	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -44 -> 120
    //   167: astore_2
    //   168: aload_3
    //   169: aload_2
    //   170: invokevirtual 255	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   173: goto -35 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	v
    //   12	114	1	localLinkedList	LinkedList
    //   36	97	2	localCursor	Cursor
    //   145	12	2	localException	java.lang.Exception
    //   167	3	2	localThrowable	java.lang.Throwable
    //   48	49	3	localHashMap	java.util.HashMap
    //   127	42	3	localObject	Object
    //   65	14	4	localAlbumItem	GalleryItem.AlbumItem
    // Exception table:
    //   from	to	target	type
    //   41	58	127	finally
    //   58	67	127	finally
    //   72	86	127	finally
    //   86	110	127	finally
    //   13	37	145	java/lang/Exception
    //   114	120	145	java/lang/Exception
    //   138	145	145	java/lang/Exception
    //   168	173	145	java/lang/Exception
    //   132	138	167	finally
  }
  
  public final String[] fzV()
  {
    return new String[] { "_id", "_data", b.HGt, b.HGs, "mime_type", "latitude", "longitude" };
  }
  
  public final String[] fzW()
  {
    AppMethodBeat.i(111384);
    if (h.fBW())
    {
      str1 = b.HGt;
      str2 = b.HGs;
      AppMethodBeat.o(111384);
      return new String[] { "_id", "_data", "bucket_display_name", str1, str2, "mime_type", "bucket_id" };
    }
    String str1 = b.HGt;
    String str2 = b.HGs;
    String str3 = "max(" + b.HGs + ") as max_time";
    AppMethodBeat.o(111384);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String fzX()
  {
    AppMethodBeat.i(289611);
    if (h.fBW())
    {
      AppMethodBeat.o(289611);
      return null;
    }
    AppMethodBeat.o(289611);
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  public final String fzY()
  {
    AppMethodBeat.i(289612);
    if (h.fBW())
    {
      AppMethodBeat.o(289612);
      return "_id desc";
    }
    AppMethodBeat.o(289612);
    return "max_time desc, _id desc";
  }
  
  public final String vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(111383);
    if (paramBoolean)
    {
      str = b.HGt + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111383);
      return str;
    }
    String str = b.HGs + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111383);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.v
 * JD-Core Version:    0.7.0.1
 */