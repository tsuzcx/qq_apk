package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends b
{
  protected ContentResolver dif;
  
  public n()
  {
    AppMethodBeat.i(111331);
    this.dif = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111331);
  }
  
  public final LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, l.c paramc, long paramLong)
  {
    AppMethodBeat.i(111337);
    this.nzW = false;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        if (Util.isNullOrNil(paramString))
        {
          localCursor1 = this.dif.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fzV(), b(this.HGr, false), null, vQ(false));
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
        localCursor2 = this.dif.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fzV(), b(this.HGr, true), null, vQ(true));
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
        if (((GalleryItem.MediaItem)localObject1).HHK > localMediaItem.HHK)
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
          bool2 = this.nzW;
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
          localCursor1 = this.dif.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fzV(), ce(paramString, false), null, vQ(false));
          localObject1 = localCursor1;
          localCursor2 = this.dif.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fzV(), ce(paramString, true), null, vQ(true));
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
        AppMethodBeat.o(111337);
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
        localObject4 = c(localCursor2, 1);
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
        AppMethodBeat.o(111337);
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
        localObject2 = c(localCursor1, 1);
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
  
  public final String b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(111333);
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
      AppMethodBeat.o(111333);
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
    AppMethodBeat.i(111332);
    StringBuilder localStringBuilder = new StringBuilder("bucket_display_name='").append(paramString).append("' AND ");
    if (paramBoolean) {}
    for (paramString = "(" + b.HGs + ">2147483647 OR " + b.HGs + "<=0 )";; paramString = b.HGs + "<=2147483647 AND " + b.HGs + ">0")
    {
      paramString = paramString;
      AppMethodBeat.o(111332);
      return paramString;
    }
  }
  
  public final LinkedList<GalleryItem.AlbumItem> fzT()
  {
    AppMethodBeat.i(111336);
    LinkedList localLinkedList = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    try
    {
      Cursor localCursor1 = this.dif.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fzW(), fzX(), null, fzY());
      if (localCursor1 == null)
      {
        Log.d("MicroMsg.ImageMediaQuery", "no image folder now");
        if (!localHashMap.isEmpty())
        {
          localLinkedList.addAll(localHashMap.values());
          Collections.sort(localLinkedList);
        }
        bl(localLinkedList);
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
            label132:
            localAlbumItem = a(localCursor2, 1, "bucket_display_name");
            if (localAlbumItem != null)
            {
              if (localArrayList.contains(localAlbumItem.albumName)) {
                break label212;
              }
              localHashMap.put(localAlbumItem.akit, localAlbumItem);
              localArrayList.add(localAlbumItem.albumName);
            }
          }
          for (;;)
          {
            boolean bool = localCursor2.moveToNext();
            if (bool) {
              break label132;
            }
            if (localCursor2 == null) {
              break;
            }
            localCursor2.close();
            break;
            label212:
            if ((!localHashMap.containsKey(localAlbumItem.akit)) || (localAlbumItem.HHB == null) || (((GalleryItem.AlbumItem)localHashMap.get(localAlbumItem.akit)).HHB == null) || (localAlbumItem.HHB.c(((GalleryItem.AlbumItem)localHashMap.get(localAlbumItem.akit)).HHB) <= 0)) {
              break label329;
            }
            localHashMap.put(localAlbumItem.akit, localAlbumItem);
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
            label329:
            Log.w("MicroMsg.ImageMediaQuery", "queryAlbumListWalkAround, videoAlbumMap no containsKey = " + localAlbumItem.akit + ", albumName= " + localAlbumItem.albumName);
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
  
  public final String[] fzV()
  {
    return new String[] { "_id", "_data", b.HGt, b.HGs, "mime_type", "latitude", "longitude" };
  }
  
  public final String[] fzW()
  {
    AppMethodBeat.i(111335);
    if (h.fBW())
    {
      str1 = b.HGt;
      str2 = b.HGs;
      AppMethodBeat.o(111335);
      return new String[] { "_id", "_data", "bucket_display_name", str1, str2, "mime_type", "bucket_id" };
    }
    String str1 = b.HGt;
    String str2 = b.HGs;
    String str3 = "max(" + b.HGs + ") as max_time";
    AppMethodBeat.o(111335);
    return new String[] { "_id", "_data", "bucket_display_name", "count(*)", str1, str2, "mime_type", str3, "bucket_id" };
  }
  
  public final String fzX()
  {
    AppMethodBeat.i(289601);
    if (h.fBW())
    {
      AppMethodBeat.o(289601);
      return null;
    }
    AppMethodBeat.o(289601);
    return "0==0) GROUP BY (bucket_display_name";
  }
  
  public final String fzY()
  {
    AppMethodBeat.i(289604);
    if (h.fBW())
    {
      AppMethodBeat.o(289604);
      return "_id desc";
    }
    AppMethodBeat.o(289604);
    return "max_time desc, _id desc";
  }
  
  public final String vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(111334);
    if (paramBoolean)
    {
      str = b.HGt + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111334);
      return str;
    }
    String str = b.HGs + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.n
 * JD-Core Version:    0.7.0.1
 */