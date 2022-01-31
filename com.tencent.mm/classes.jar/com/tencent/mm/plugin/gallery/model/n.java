package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class n
  extends b
{
  protected ContentResolver aYt;
  private volatile boolean eUJ;
  
  public n()
  {
    AppMethodBeat.i(21333);
    this.eUJ = false;
    this.aYt = ah.getContext().getContentResolver();
    AppMethodBeat.o(21333);
  }
  
  private boolean a(i.d paramd, LinkedList paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(21340);
    if ((paramd != null) && (paramLinkedList.size() + 1 % this.ncv == 0)) {
      paramd.c(paramLinkedList, paramLong);
    }
    boolean bool = this.eUJ;
    AppMethodBeat.o(21340);
    return bool;
  }
  
  public final String a(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(21335);
    String str1;
    int j;
    int i;
    String str2;
    if (paramBoolean)
    {
      str1 = "(" + b.ncx + ">2147483647 OR " + b.ncx + "<=0 ) AND (_size>10240";
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
      ab.d("MicroMsg.ImageMediaQuery", "where %s", new Object[] { paramArrayOfString });
      AppMethodBeat.o(21335);
      return paramArrayOfString;
      str1 = b.ncx + "<=2147483647 AND " + b.ncx + ">0 AND (_size>10240";
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
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.d paramd, long paramLong)
  {
    AppMethodBeat.i(21339);
    this.eUJ = false;
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (bo.isNullOrNil(paramString))
      {
        localObject2 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), a(new String[] { this.ncw[0] }, false), null, hS(false));
        localObject1 = localObject2;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        Object localObject5;
        label160:
        Object localObject3;
        Object localObject6;
        boolean bool;
        label446:
        label458:
        localCursor = null;
        localObject4 = null;
      }
    }
    try
    {
      localCursor = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), a(new String[] { this.ncw[0] }, true), null, hS(true));
      localObject4 = localObject2;
      for (;;)
      {
        if (localObject4 != null) {}
        try
        {
          localObject4.moveToFirst();
          if (localCursor != null) {
            localCursor.moveToFirst();
          }
          localObject1 = b(localObject4, 2);
          localObject2 = b(localCursor, 2);
          localObject5 = null;
          localObject3 = localObject5;
          localObject6 = localObject2;
          if (localObject2 == null) {
            break label478;
          }
          localObject3 = localObject5;
          localObject6 = localObject2;
          if (localObject1 == null) {
            break label478;
          }
          if (((GalleryItem.MediaItem)localObject2).ndq > ((GalleryItem.MediaItem)localObject1).ndq)
          {
            localLinkedList.add(localObject2);
            localCursor.moveToNext();
            localObject3 = localObject1;
          }
          for (;;)
          {
            if (localObject3 == localObject2) {
              localObject1 = b(localObject4, 2);
            }
            if (localObject3 == localObject1) {
              localObject2 = b(localCursor, 2);
            }
            bool = a(paramd, localLinkedList, paramLong);
            localObject5 = localObject3;
            if (!bool) {
              break label160;
            }
            if (localObject4 != null) {
              localObject4.close();
            }
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(21339);
            return localLinkedList;
            localObject2 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), aV(paramString, false), null, hS(false));
            localObject1 = localObject2;
            localCursor = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getProjection(), aV(paramString, true), null, hS(true));
            localObject4 = localObject2;
            break;
            if (((GalleryItem.MediaItem)localObject2).ndq < ((GalleryItem.MediaItem)localObject1).ndq)
            {
              localLinkedList.add(localObject1);
              localObject4.moveToNext();
              localObject3 = localObject2;
            }
            else
            {
              localLinkedList.add(localObject1);
              localLinkedList.add(localObject2);
              localObject3 = null;
              localCursor.moveToNext();
              localObject4.moveToNext();
            }
          }
          if (localObject4 == null) {
            break label458;
          }
        }
        finally {}
      }
    }
    finally
    {
      localCursor = null;
      localObject4 = localObject1;
      break label446;
    }
    localObject4.close();
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(21339);
    throw paramString;
    label478:
    localObject2 = localObject3;
    localObject5 = localObject1;
    if (localObject6 != null)
    {
      if ((localObject3 != null) && (localObject3.ndq > ((GalleryItem.MediaItem)localObject6).ndq))
      {
        localLinkedList.add(localObject3);
        localLinkedList.add(localObject6);
        localObject3 = null;
      }
      for (;;)
      {
        localCursor.moveToNext();
        localObject6 = b(localCursor, 2);
        bool = a(paramd, localLinkedList, paramLong);
        if (!bool) {
          break;
        }
        if (localObject4 != null) {
          localObject4.close();
        }
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(21339);
        return localLinkedList;
        localLinkedList.add(localObject6);
      }
    }
    if (localObject5 != null)
    {
      if ((localObject2 != null) && (((GalleryItem.MediaItem)localObject2).ndq > ((GalleryItem.MediaItem)localObject5).ndq))
      {
        localLinkedList.add(localObject2);
        localLinkedList.add(localObject5);
        localObject2 = null;
      }
      for (;;)
      {
        localObject4.moveToNext();
        localObject5 = b(localObject4, 2);
        bool = a(paramd, localLinkedList, paramLong);
        if (!bool) {
          break;
        }
        if (localObject4 != null) {
          localObject4.close();
        }
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(21339);
        return localLinkedList;
        localLinkedList.add(localObject5);
      }
    }
    if (localObject2 != null) {
      localLinkedList.add(localObject2);
    }
    paramd.c(localLinkedList, paramLong);
    ab.i("MicroMsg.ImageMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result:%s ticket:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), Long.valueOf(paramLong) });
    if (localObject4 != null) {
      localObject4.close();
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(21339);
    return localLinkedList;
  }
  
  public final String aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(21334);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name=\"").append(paramString).append("\" AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.ncx + ">2147483647 OR " + b.ncx + "<=0 )";; paramString = b.ncx + "<=2147483647 AND " + b.ncx + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(21334);
      return paramString;
    }
  }
  
  public final LinkedList<GalleryItem.AlbumItem> bDJ()
  {
    AppMethodBeat.i(21338);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    try
    {
      Cursor localCursor = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, bDL(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
      if (localCursor == null)
      {
        ab.d("MicroMsg.ImageMediaQuery", "no media folder now");
        AppMethodBeat.o(21338);
        return localLinkedList;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ImageMediaQuery", "query album list failed : [%s]", new Object[] { localException.getMessage() });
        localObject1 = null;
      }
    }
    if (localObject1.moveToFirst()) {}
    for (;;)
    {
      long l = bo.apW(localObject1.getString(localObject1.getColumnIndexOrThrow("_id")));
      Object localObject3 = localObject1.getString(localObject1.getColumnIndexOrThrow("_data"));
      Object localObject2 = localObject1.getString(localObject1.getColumnIndexOrThrow("bucket_display_name"));
      if (bo.isNullOrNil((String)localObject2)) {
        ab.e("MicroMsg.ImageMediaQuery", "null or nill album name, ignore this folder");
      }
      while (!localObject1.moveToNext())
      {
        localObject1.close();
        AppMethodBeat.o(21338);
        return localLinkedList;
        if ((!bo.isNullOrNil((String)localObject3)) && (e.cN((String)localObject3)))
        {
          int i = localObject1.getInt(3);
          if (i == 0)
          {
            ab.e("MicroMsg.ImageMediaQuery", "query album failed, " + i + ", " + (String)localObject3);
          }
          else
          {
            ab.i("MicroMsg.ImageMediaQuery", "%s(%s) path:%s", new Object[] { localObject2, Integer.valueOf(i), localObject3 });
            String str = localObject1.getString(localObject1.getColumnIndexOrThrow("mime_type"));
            localObject3 = GalleryItem.MediaItem.a(2, Long.valueOf(l).longValue(), (String)localObject3, null, str);
            localObject2 = new GalleryItem.AlbumItem((String)localObject2, i);
            ((GalleryItem.AlbumItem)localObject2).ndm = ((GalleryItem.MediaItem)localObject3);
            localLinkedList.add(localObject2);
          }
        }
      }
    }
  }
  
  public final void bDK()
  {
    this.eUJ = true;
  }
  
  public final String[] bDL()
  {
    AppMethodBeat.i(21337);
    String str1 = b.ncy;
    String str2 = b.ncx;
    String str3 = "max(" + b.ncx + ") as max_time";
    AppMethodBeat.o(21337);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3 };
  }
  
  public final String[] getProjection()
  {
    return new String[] { "_id", "_data", b.ncy, b.ncx, "mime_type", "latitude", "longitude" };
  }
  
  public final String hS(boolean paramBoolean)
  {
    AppMethodBeat.i(21336);
    if (paramBoolean)
    {
      str = b.ncy + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(21336);
      return str;
    }
    String str = b.ncx + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(21336);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.n
 * JD-Core Version:    0.7.0.1
 */