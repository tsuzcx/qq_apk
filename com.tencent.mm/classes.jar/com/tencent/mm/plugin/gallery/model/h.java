package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;

public final class h
  extends k
{
  private static int kGZ = 100;
  private i kHa = new i();
  private n kHb = new n();
  private MediaMetadataRetriever kHc = new MediaMetadataRetriever();
  int kHd = 0;
  
  private static GalleryItem.AlbumItem a(Cursor paramCursor, int paramInt, String paramString)
  {
    Long localLong = Long.valueOf(0L);
    try
    {
      l = bk.getLong(paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id")), 0L);
      localLong = Long.valueOf(l);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      long l;
      String str1;
      String str2;
      String str3;
      String str4;
      int i;
      break label33;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        label33:
        continue;
        paramString = localNumberFormatException;
      }
    }
    str1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow("_data"));
    str2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
    str3 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHj));
    l = paramCursor.getLong(paramCursor.getColumnIndexOrThrow(k.kHj));
    str4 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHh));
    paramString = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHi));
    if ((str3 == null) || (str3.equals("")) || (str3.equals(Integer.valueOf(0))))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 1L, 1L, true);
      if (0L != l) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 4L, 1L, true);
      }
      if (((str4 == null) || (str4.equals("")) || (str4.equals(Integer.valueOf(0)))) && (paramString != null) && (!paramString.equals("")) && (!paramString.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 3L, 1L, true);
      }
      if (((paramString == null) || (paramString.equals("")) || (paramString.equals(Integer.valueOf(0)))) && (str4 != null) && (!str4.equals("")) && (!str4.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 2L, 1L, true);
      }
    }
    while (bk.bl(str2))
    {
      y.e("MicroMsg.ImageAndVideoQuery", "null or nill album name, ignore this folder");
      return null;
      if ((paramString == null) || (paramString.equals("")) || (paramString.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 6L, 1L, true);
      } else if ((str4 == null) || (str4.equals("")) || (str4.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 5L, 1L, true);
      }
    }
    i = paramCursor.getInt(3);
    y.i("MicroMsg.ImageAndVideoQuery", str1 + "====" + str2 + "=====" + localLong + ", " + i);
    if ((i == 0) || ((bk.bl(str1)) && (bk.bl(null))))
    {
      y.e("MicroMsg.ImageAndVideoQuery", "query album failed, " + i + ", " + str1 + "," + null);
      return null;
    }
    if ((bk.bl(str1)) || (!e.bK(str1)))
    {
      paramString = null;
      if (!bk.bl(null)) {
        e.bK(null);
      }
      if (paramString == null)
      {
        y.e("MicroMsg.ImageAndVideoQuery", "this item has no thumb path and original path");
        return null;
      }
      paramCursor = paramCursor.getString(paramCursor.getColumnIndexOrThrow("mime_type"));
      paramCursor = GalleryItem.MediaItem.a(paramInt, localLong.longValue(), paramString, null, paramCursor);
      paramCursor.kGY = dn(str3, str4);
      paramString = new GalleryItem.AlbumItem(str2, i);
      paramString.kGU = paramCursor;
      return paramString;
    }
  }
  
  private static GalleryItem.MediaItem b(Cursor paramCursor, int paramInt)
  {
    Object localObject1 = Long.valueOf(0L);
    try
    {
      l = bk.getLong(paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id")), 0L);
      localObject1 = Long.valueOf(l);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      long l;
      String str1;
      String str2;
      String str3;
      Object localObject2;
      break label31;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label31:
      break label31;
    }
    str1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow("_data"));
    str2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHj));
    l = paramCursor.getLong(paramCursor.getColumnIndexOrThrow(k.kHj));
    str3 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHh));
    localObject2 = paramCursor.getString(paramCursor.getColumnIndexOrThrow(k.kHi));
    if ((str2 == null) || (str2.equals("")) || (str2.equals(Integer.valueOf(0))))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 1L, 1L, true);
      if (0L != l) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 4L, 1L, true);
      }
      if (((str3 == null) || (str3.equals("")) || (str3.equals(Integer.valueOf(0)))) && (localObject2 != null) && (!((String)localObject2).equals("")) && (!((String)localObject2).equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 3L, 1L, true);
      }
      if (((localObject2 == null) || (((String)localObject2).equals("")) || (((String)localObject2).equals(Integer.valueOf(0)))) && (str3 != null) && (!str3.equals("")) && (!str3.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 2L, 1L, true);
      }
    }
    for (;;)
    {
      localObject2 = GalleryItem.MediaItem.B(paramInt, ((Long)localObject1).longValue());
      if ((!bk.bl(str1)) && (new File(str1).exists())) {
        ((GalleryItem.MediaItem)localObject2).eAu = str1;
      }
      ((GalleryItem.MediaItem)localObject2).kGY = dn(str2, str3);
      if ((!bk.bl(((GalleryItem.MediaItem)localObject2).eAu)) || (!bk.bl(((GalleryItem.MediaItem)localObject2).jSX))) {
        break;
      }
      y.w("MicroMsg.ImageAndVideoQuery", "thumb file and orignal file both not exist");
      return null;
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (((String)localObject2).equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 6L, 1L, true);
      } else if ((str3 == null) || (str3.equals("")) || (str3.equals(Integer.valueOf(0)))) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 5L, 1L, true);
      }
    }
    localObject1 = paramCursor.getString(paramCursor.getColumnIndexOrThrow("mime_type"));
    paramCursor = (Cursor)localObject1;
    if (bk.bl((String)localObject1)) {
      paramCursor = "";
    }
    ((GalleryItem.MediaItem)localObject2).mMimeType = paramCursor;
    return localObject2;
  }
  
  protected final String Eq(String paramString)
  {
    return null;
  }
  
  protected final String aXA()
  {
    return null;
  }
  
  public final ArrayList<GalleryItem.AlbumItem> aXv()
  {
    Object localObject4 = null;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localCursor1 = this.eRr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.kHb.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.kHb.aXz());
      if (localCursor1 == null) {
        y.d("MicroMsg.ImageAndVideoQuery", "no video folder now");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Cursor localCursor1 = this.eRr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.kHa.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.kHa.aXz());
          if (localCursor1 != null) {
            break;
          }
          y.d("MicroMsg.ImageAndVideoQuery", "no image folder now");
          return localArrayList;
          localException1 = localException1;
          y.e("MicroMsg.ImageAndVideoQuery", "query video album list failed : [%s]", new Object[] { localException1.getMessage() });
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
                j += localAlbumItem.bLO;
                localObject2 = localObject3;
                i = j;
                if (localObject3 == null)
                {
                  localObject2 = localAlbumItem.kGU;
                  i = j;
                }
              }
              localObject3 = localObject2;
              j = i;
            } while (localCursor2.moveToNext());
            localObject3 = new GalleryItem.AlbumItem(ae.getContext().getString(R.l.gallery_all_video), i);
            ((GalleryItem.AlbumItem)localObject3).kGU = ((GalleryItem.MediaItem)localObject2);
            localArrayList.add(localObject3);
          }
          localCursor2.close();
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        Object localObject1;
        for (;;)
        {
          y.e("MicroMsg.ImageAndVideoQuery", "query image album list failed : [%s]", new Object[] { localException2.getMessage() });
          localObject1 = localObject4;
        }
        if (localObject1.moveToFirst()) {
          do
          {
            localObject2 = a(localObject1, 1, "bucket_display_name");
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          } while (localObject1.moveToNext());
        }
        localObject1.close();
      }
    }
    return localArrayList;
  }
  
  protected final Uri aXx()
  {
    return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  }
  
  protected final String[] aXy()
  {
    return null;
  }
  
  protected final String aXz()
  {
    return null;
  }
  
  public final ArrayList<GalleryItem.MediaItem> b(String paramString, int paramInt, g.c paramc, long paramLong)
  {
    y.i("MicroMsg.ImageAndVideoQuery", "queryMediaItemsInAlbum: %s", new Object[] { paramString });
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (;;)
    {
      try
      {
        localCursor1 = this.eRr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.kHa.aXy(), this.kHa.Eq(paramString), null, this.kHa.aXz());
        localCursor2 = localCursor1;
      }
      catch (Exception localException1)
      {
        Cursor localCursor1;
        Cursor localCursor3;
        y.e("MicroMsg.ImageAndVideoQuery", "query image items in album failed : [%s]", new Object[] { localException1.getMessage() });
        Cursor localCursor2 = null;
        continue;
        if ((!bool3) && (!bool2) && (localObject2 == null) && (paramString == null)) {
          continue;
        }
        if (!aXC()) {
          continue;
        }
        try
        {
          this.kHl = false;
          if (this.kHd > 1)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 0L, this.kHd, true);
            com.tencent.mm.plugin.report.service.h.nFQ.a(363L, 7L, 1L, true);
            this.kHd = 0;
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
          if (localCursor3 != null) {
            localCursor3.close();
          }
          if ((paramInt == 0) && (paramc != null)) {
            paramc.a(localArrayList, paramLong);
          }
          return localArrayList;
        }
        finally {}
        localObject1 = localObject2;
        boolean bool1 = bool3;
        if (localObject2 != null) {
          continue;
        }
        localObject1 = localObject2;
        bool1 = bool3;
        if (!bool3) {
          continue;
        }
        localObject1 = b(localCursor2, 1);
        bool1 = localCursor2.moveToNext();
        if ((paramString != null) || (!bool2)) {
          continue;
        }
        paramString = b(localCursor3, 2);
        boolean bool2 = localCursor3.moveToNext();
        if (localObject1 == null) {
          continue;
        }
        if ((paramString != null) && (((GalleryItem.MediaItem)localObject1).a(paramString) <= 0)) {
          continue;
        }
        y.d("MicroMsg.ImageAndVideoQuery", "image_id:%s mix_date:%s", new Object[] { Long.valueOf(bk.c(Long.valueOf(((GalleryItem.MediaItem)localObject1).kGX))), Long.valueOf(bk.c(Long.valueOf(((GalleryItem.MediaItem)localObject1).kGY))) });
        localArrayList.add(localObject1);
        localObject1 = null;
        if ((localArrayList.size() % kGZ != 0) || (paramc == null)) {
          continue;
        }
        paramc.a(localArrayList, paramLong);
        localArrayList.clear();
        paramInt = 1;
        Object localObject2 = localObject1;
        boolean bool3 = bool1;
        continue;
        localArrayList.add(paramString);
        paramString = null;
        continue;
        if (paramString == null) {
          continue;
        }
        localArrayList.add(paramString);
        paramString = null;
        continue;
        y.w("MicroMsg.ImageAndVideoQuery", "Image item and video item are all null");
        continue;
        paramInt = 0;
        localObject2 = localObject1;
        bool3 = bool1;
        continue;
        continue;
        localObject1 = null;
        continue;
      }
      if ((paramInt == 2) || (paramInt == 3))
      {
        try
        {
          localCursor1 = this.eRr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.kHb.aXy(), this.kHb.Eq(paramString), null, this.kHb.aXz());
          localCursor3 = localCursor1;
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.ImageAndVideoQuery", "query video items in album failed : [%s]", new Object[] { localException2.getMessage() });
          localCursor3 = null;
          continue;
          bool1 = false;
          continue;
          bool2 = false;
          continue;
          localObject2 = null;
          paramString = null;
          paramInt = 0;
          bool3 = bool1;
        }
        if ((localCursor2 != null) && (localCursor2.moveToFirst()))
        {
          bool1 = true;
          if ((localCursor3 == null) || (!localCursor3.moveToFirst())) {
            continue;
          }
          bool2 = true;
          if ((bool1) || (bool2)) {
            continue;
          }
          y.d("MicroMsg.ImageAndVideoQuery", "query album failed: " + paramString);
          if (paramc != null) {
            paramc.a(localArrayList, paramLong);
          }
          return localArrayList;
        }
      }
      Object localObject1 = null;
    }
  }
  
  protected final String[] getProjection()
  {
    return null;
  }
  
  protected final String getSelection()
  {
    return null;
  }
  
  protected final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.h
 * JD-Core Version:    0.7.0.1
 */