package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class u
  extends b
{
  protected ContentResolver bEI;
  
  public u()
  {
    AppMethodBeat.i(111380);
    this.bEI = ak.getContext().getContentResolver();
    AppMethodBeat.o(111380);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    AppMethodBeat.i(111386);
    this.hmD = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (bu.isNullOrNil(paramString))
        {
          localCursor1 = this.bEI.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), b(new String[] { this.tQw[0] }, false), null, mP(false));
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
        localCursor2 = this.bEI.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), b(new String[] { this.tQw[0] }, true), null, mP(true));
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
        if (((GalleryItem.MediaItem)localObject1).tRN > localMediaItem.tRN)
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
          bool2 = this.hmD;
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
          localCursor1 = this.bEI.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), br(paramString, false), null, mP(false));
          localObject1 = localCursor1;
          localCursor2 = this.bEI.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), br(paramString, true), null, mP(true));
        }
        else if (((GalleryItem.MediaItem)localObject1).tRN < localMediaItem.tRN)
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
      if ((localObject3 != null) && (localObject3.tRN > ((GalleryItem.MediaItem)localObject4).tRN))
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
        bool1 = this.hmD;
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
      if ((localObject1 != null) && (((GalleryItem.MediaItem)localObject1).tRN > ((GalleryItem.MediaItem)localObject2).tRN))
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
        boolean bool3 = this.hmD;
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
    ae.i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), Long.valueOf(paramLong) });
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
      str1 = "(" + b.tQx + ">2147483647 OR " + b.tQx + "<=0 ) AND (_size>10240";
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
      ae.d("MicroMsg.ImageMediaQuery", "where %s", new Object[] { paramArrayOfString });
      AppMethodBeat.o(111382);
      return paramArrayOfString;
      str1 = b.tQx + "<=2147483647 AND " + b.tQx + ">0 AND (_size>10240";
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
  
  public final String br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111381);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.tQx + ">2147483647 OR " + b.tQx + "<=0 )";; paramString = b.tQx + "<=2147483647 AND " + b.tQx + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111381);
      return paramString;
    }
  }
  
  /* Error */
  public final LinkedList<GalleryItem.AlbumItem> cXb()
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 44	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 45	java/util/LinkedList:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 31	com/tencent/mm/plugin/gallery/model/u:bEI	Landroid/content/ContentResolver;
    //   17: getstatic 57	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: aload_0
    //   21: invokevirtual 205	com/tencent/mm/plugin/gallery/model/u:cXc	()[Ljava/lang/String;
    //   24: ldc 207
    //   26: aconst_null
    //   27: ldc 209
    //   29: invokevirtual 81	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +46 -> 82
    //   39: aload 4
    //   41: invokeinterface 87 1 0
    //   46: ifeq +36 -> 82
    //   49: aload 4
    //   51: iconst_2
    //   52: ldc 211
    //   54: invokestatic 214	com/tencent/mm/plugin/gallery/model/u:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +9 -> 68
    //   62: aload_3
    //   63: aload_1
    //   64: invokevirtual 100	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: aload 4
    //   70: invokeinterface 103 1 0
    //   75: ifne -26 -> 49
    //   78: aload_3
    //   79: invokestatic 218	com/tencent/mm/plugin/gallery/model/u:ap	(Ljava/util/LinkedList;)V
    //   82: aload 4
    //   84: ifnull +10 -> 94
    //   87: aload 4
    //   89: invokeinterface 109 1 0
    //   94: ldc 202
    //   96: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_3
    //   100: areturn
    //   101: astore_2
    //   102: ldc 202
    //   104: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: aload 4
    //   112: ifnull +14 -> 126
    //   115: aload_2
    //   116: ifnull +50 -> 166
    //   119: aload 4
    //   121: invokeinterface 109 1 0
    //   126: ldc 202
    //   128: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: ldc 120
    //   136: ldc 220
    //   138: iconst_1
    //   139: anewarray 124	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: goto -58 -> 94
    //   155: astore 4
    //   157: aload_2
    //   158: aload 4
    //   160: invokevirtual 230	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   163: goto -37 -> 126
    //   166: aload 4
    //   168: invokeinterface 109 1 0
    //   173: goto -47 -> 126
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -69 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	u
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
  
  public final String[] cXc()
  {
    AppMethodBeat.i(111384);
    String str1 = b.tQy;
    String str2 = b.tQx;
    String str3 = "max(" + b.tQx + ") as max_time";
    AppMethodBeat.o(111384);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String[] getProjection()
  {
    return new String[] { "_id", "_data", b.tQy, b.tQx, "mime_type", "latitude", "longitude" };
  }
  
  public final String mP(boolean paramBoolean)
  {
    AppMethodBeat.i(111383);
    if (paramBoolean)
    {
      str = b.tQy + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111383);
      return str;
    }
    String str = b.tQx + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111383);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.u
 * JD-Core Version:    0.7.0.1
 */