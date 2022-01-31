package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Comparator;
import java.util.LinkedList;

public final class a
  extends b
  implements Comparator<GalleryItem.MediaItem>
{
  protected ContentResolver aYt;
  private volatile boolean eUJ;
  private j nct;
  private n ncu;
  
  public a()
  {
    AppMethodBeat.i(21218);
    this.eUJ = false;
    this.aYt = ah.getContext().getContentResolver();
    this.nct = new j();
    this.ncu = new n();
    AppMethodBeat.o(21218);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.d paramd, long paramLong)
  {
    AppMethodBeat.i(21221);
    long l = System.currentTimeMillis();
    localObject3 = null;
    localObject1 = null;
    localObject4 = null;
    localObject2 = null;
    try
    {
      this.eUJ = false;
      localLinkedList = new LinkedList();
      if (bo.isNullOrNil(paramString)) {
        if ((paramInt == 1) || (paramInt == 3))
        {
          localObject2 = this.aYt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.nct.getProjection(), this.nct.a(this.ncw, false), null, this.nct.hS(false));
          localObject1 = localObject2;
        }
      }
    }
    finally
    {
      LinkedList localLinkedList;
      label302:
      label459:
      label494:
      Object localObject13;
      label389:
      label424:
      Object localObject12;
      paramd = null;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      if (localObject1 != null) {
        localObject1.close();
      }
      if (paramd != null) {
        paramd.close();
      }
      AppMethodBeat.o(21221);
    }
    for (;;)
    {
      try
      {
        localObject3 = this.aYt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.nct.getProjection(), this.nct.a(this.ncw, true), null, this.nct.hS(true));
        localObject1 = localObject2;
        localObject2 = localObject3;
        if (paramInt != 2)
        {
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (paramInt != 3) {
            continue;
          }
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
      }
      finally
      {
        paramd = null;
        localObject4 = null;
        localObject2 = null;
        localObject3 = localObject1;
        localObject1 = localObject4;
        break label1160;
        localObject1 = null;
        localObject2 = null;
        localObject5 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject5;
        break label302;
        localObject10 = null;
        if (localObject8 == null) {
          break label389;
        }
        localObject10 = localObject8;
        break label389;
        localObject9 = localObject7;
        break label424;
        localObject10 = localObject6;
        break label459;
        localObject11 = localObject5;
        break label494;
      }
      try
      {
        localObject6 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ncu.getProjection(), this.ncu.a(new String[] { this.ncw[0] }, false), null, this.ncu.hS(false));
        localObject5 = localObject6;
        localObject4 = localObject2;
        localObject3 = localObject1;
      }
      finally
      {
        paramd = null;
        localObject1 = null;
        localObject2 = localObject4;
        break label1160;
      }
    }
    try
    {
      localObject7 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ncu.getProjection(), this.ncu.a(new String[] { this.ncw[0] }, true), null, this.ncu.hS(true));
      localObject5 = localObject7;
      localObject4 = localObject1;
      localObject3 = localObject2;
      localObject2 = localObject6;
      localObject1 = localObject5;
      if (localObject4 == null) {}
    }
    finally
    {
      paramd = null;
      localObject1 = localObject5;
      localObject2 = localObject4;
      break label1160;
    }
    try
    {
      localObject4.moveToFirst();
      if (localObject3 != null) {
        ((Cursor)localObject3).moveToFirst();
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).moveToFirst();
      }
      if (localObject1 != null) {
        localObject1.moveToFirst();
      }
      localObject8 = b(localObject4, 1);
      localObject7 = b((Cursor)localObject3, 1);
      localObject6 = b((Cursor)localObject2, 2);
      localObject5 = b(localObject1, 2);
    }
    finally
    {
      paramd = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      break label1160;
    }
    localObject9 = localObject10;
    if (localObject7 != null)
    {
      if (localObject10 != null)
      {
        localObject9 = localObject10;
        if (((GalleryItem.MediaItem)localObject10).ndq < ((GalleryItem.MediaItem)localObject7).ndq) {}
      }
    }
    else
    {
      localObject10 = localObject9;
      if (localObject6 != null)
      {
        if (localObject9 == null) {
          break label1323;
        }
        localObject10 = localObject9;
        if (((GalleryItem.MediaItem)localObject9).ndq < ((GalleryItem.MediaItem)localObject6).ndq) {
          break label1323;
        }
      }
      localObject11 = localObject10;
      if (localObject5 != null)
      {
        if (localObject10 == null) {
          break label1330;
        }
        localObject11 = localObject10;
        if (((GalleryItem.MediaItem)localObject10).ndq < ((GalleryItem.MediaItem)localObject5).ndq) {
          break label1330;
        }
      }
      if (localObject11 != null)
      {
        localLinkedList.add(localObject11);
        if (localObject11 == localObject8)
        {
          localObject4.moveToNext();
          localObject13 = b(localObject4, 1);
          localObject12 = localObject7;
          localObject10 = localObject6;
          localObject9 = localObject5;
        }
        for (;;)
        {
          if (localLinkedList.size() + 1 % this.ncv == 0) {
            paramd.c(localLinkedList, paramLong);
          }
          boolean bool = this.eUJ;
          localObject5 = localObject9;
          localObject6 = localObject10;
          localObject7 = localObject12;
          localObject8 = localObject13;
          if (!bool) {
            break label1301;
          }
          if (localObject4 != null) {
            localObject4.close();
          }
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
          if (localObject1 != null) {
            localObject1.close();
          }
          AppMethodBeat.o(21221);
          return localLinkedList;
          if (paramInt != 1)
          {
            localObject2 = localObject4;
            localObject1 = localObject3;
            if (paramInt != 3) {}
          }
          else
          {
            localObject2 = this.aYt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.nct.getProjection(), this.nct.aV(paramString, false), null, this.nct.hS(false));
            localObject1 = localObject2;
            localObject3 = this.aYt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.nct.getProjection(), this.nct.aV(paramString, true), null, this.nct.hS(true));
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
          if (paramInt != 2)
          {
            localObject4 = localObject2;
            localObject3 = localObject1;
            if (paramInt != 3) {
              break label1280;
            }
          }
          localObject4 = localObject2;
          localObject3 = localObject1;
          localObject6 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ncu.getProjection(), this.ncu.aV(paramString, false), null, this.ncu.hS(false));
          localObject5 = localObject6;
          localObject4 = localObject2;
          localObject3 = localObject1;
          localObject7 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ncu.getProjection(), this.ncu.aV(paramString, true), null, this.ncu.hS(true));
          localObject3 = localObject7;
          localObject4 = localObject2;
          localObject5 = localObject1;
          localObject1 = localObject3;
          localObject2 = localObject6;
          localObject3 = localObject4;
          localObject4 = localObject5;
          break;
          if (localObject11 == localObject7)
          {
            ((Cursor)localObject3).moveToNext();
            localObject12 = b((Cursor)localObject3, 1);
            localObject9 = localObject5;
            localObject10 = localObject6;
            localObject13 = localObject8;
          }
          else if (localObject11 == localObject6)
          {
            ((Cursor)localObject2).moveToNext();
            localObject10 = b((Cursor)localObject2, 2);
            localObject9 = localObject5;
            localObject12 = localObject7;
            localObject13 = localObject8;
          }
          else
          {
            localObject9 = localObject5;
            localObject10 = localObject6;
            localObject12 = localObject7;
            localObject13 = localObject8;
            if (localObject11 == localObject5)
            {
              localObject1.moveToNext();
              localObject9 = b(localObject1, 2);
              localObject10 = localObject6;
              localObject12 = localObject7;
              localObject13 = localObject8;
            }
          }
        }
      }
      paramd.c(localLinkedList, paramLong);
      ab.i("MicroMsg.AllMediaQuery", "[queryMediaItemsInAlbum] albumName:%s type:%s result size:%s ticket:%s cost:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localLinkedList.size()), Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis() - l) });
      if (localObject4 != null) {
        localObject4.close();
      }
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      if (localObject1 != null) {
        localObject1.close();
      }
      AppMethodBeat.o(21221);
      return localLinkedList;
    }
  }
  
  public final LinkedList<GalleryItem.AlbumItem> bDJ()
  {
    Object localObject4 = null;
    AppMethodBeat.i(21220);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localCursor1 = this.aYt.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.ncu.bDL(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
      if (localCursor1 == null) {
        ab.d("MicroMsg.AllMediaQuery", "no video folder now");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Cursor localCursor1 = this.aYt.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.nct.bDL(), "0==0) GROUP BY (bucket_display_name", null, "max_time desc, _id desc");
          if (localCursor1 != null) {
            break;
          }
          ab.d("MicroMsg.AllMediaQuery", "no image folder now");
          AppMethodBeat.o(21220);
          return localLinkedList;
          localException1 = localException1;
          ab.e("MicroMsg.AllMediaQuery", "query video album list failed : [%s]", new Object[] { localException1.getMessage() });
          Cursor localCursor2 = null;
          continue;
          if (localCursor2.moveToFirst())
          {
            Object localObject3 = null;
            int j = 0;
            int i;
            do
            {
              GalleryItem.AlbumItem localAlbumItem = a(localCursor2, 2, "bucket_display_name");
              localObject2 = localObject3;
              i = j;
              if (localAlbumItem != null)
              {
                j += localAlbumItem.cti;
                localObject2 = localObject3;
                i = j;
                if (localObject3 == null)
                {
                  localObject2 = localAlbumItem.ndm;
                  i = j;
                }
              }
              localObject3 = localObject2;
              j = i;
            } while (localCursor2.moveToNext());
            localObject3 = new GalleryItem.AlbumItem(ah.getContext().getString(2131300272), i);
            ((GalleryItem.AlbumItem)localObject3).ndm = ((GalleryItem.MediaItem)localObject2);
            localLinkedList.add(localObject3);
          }
          localCursor2.close();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          ab.e("MicroMsg.AllMediaQuery", "query image album list failed : [%s]", new Object[] { localException2.getMessage() });
          Object localObject1 = localObject4;
          continue;
          if (localObject1.moveToFirst()) {
            do
            {
              localObject2 = a(localObject1, 1, "bucket_display_name");
              if (localObject2 != null) {
                localLinkedList.add(localObject2);
              }
            } while (localObject1.moveToNext());
          }
          localObject1.close();
        }
      }
    }
  }
  
  public final void bDK()
  {
    this.eUJ = true;
  }
  
  public final String hS(boolean paramBoolean)
  {
    AppMethodBeat.i(21219);
    if (paramBoolean)
    {
      str = b.ncy + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(21219);
      return str;
    }
    String str = b.ncx + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(21219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a
 * JD-Core Version:    0.7.0.1
 */