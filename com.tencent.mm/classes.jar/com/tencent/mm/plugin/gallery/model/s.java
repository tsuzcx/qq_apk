package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.gallery.model.s.a;>;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static final Uri BVU;
  public boolean BVV;
  public boolean BVW;
  public List<GalleryItem.MediaItem> BVX;
  public int aeh;
  public ContentResolver kiH;
  
  static
  {
    AppMethodBeat.i(111376);
    BVU = Uri.parse("content://com.open.gallery.smart.provider");
    AppMethodBeat.o(111376);
  }
  
  private s()
  {
    AppMethodBeat.i(111368);
    this.aeh = 100;
    this.BVX = new ArrayList();
    this.kiH = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111368);
  }
  
  static LinkedList<GalleryItem.AlbumItem> av(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(173744);
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add(new GalleryItem.PrivateAlbumItem((a)paramArrayList.next()));
    }
    AppMethodBeat.o(173744);
    return localLinkedList;
  }
  
  public static s etX()
  {
    return s.j.BWs;
  }
  
  public static String[] etY()
  {
    return new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" };
  }
  
  public static c fl(List<a> paramList)
  {
    AppMethodBeat.i(111369);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      d locald = locala.BVY;
      Object localObject = (List)localHashMap.get(locald);
      if (localObject == null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(locala);
        localHashMap.put(locald, localObject);
        localArrayList.add(locald);
      }
      else
      {
        ((List)localObject).add(locala);
      }
    }
    paramList = new c(localArrayList, localHashMap);
    AppMethodBeat.o(111369);
    return paramList;
  }
  
  public static b hJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111372);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(111372);
      return null;
    }
    b localb = new b();
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        localb.BWe = paramString1.optBoolean("ocr", false);
        Object localObject = paramString1.optJSONObject("cropArea");
        if (localObject != null)
        {
          int i = ((JSONObject)localObject).optInt("cropType", 0);
          double d1 = ((JSONObject)localObject).optDouble("left", -1.0D);
          double d2 = ((JSONObject)localObject).optDouble("top", -1.0D);
          double d3 = ((JSONObject)localObject).optDouble("right", -1.0D);
          double d4 = ((JSONObject)localObject).optDouble("bottom", -1.0D);
          localObject = new s.e();
          ((s.e)localObject).BWl = i;
          ((s.e)localObject).BWm = d1;
          ((s.e)localObject).BWn = d2;
          ((s.e)localObject).BWo = d3;
          ((s.e)localObject).BWp = d4;
          ((s.e)localObject).id = paramString2;
          localb.BUm = ((s.e)localObject);
        }
        if (3 != paramString1.optInt("coverType", 1)) {
          continue;
        }
        bool = true;
        localb.BWf = bool;
        localb.BWg = paramString1.optBoolean("favorite", false);
      }
      catch (JSONException paramString1)
      {
        boolean bool;
        Log.e("MicroMsg.SmartGalleryQueryUtil", "parse album json error, msg: %s.", new Object[] { paramString1.getMessage(), paramString1 });
        continue;
      }
      AppMethodBeat.o(111372);
      return localb;
      bool = false;
    }
  }
  
  public static List<i> p(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(111370);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramList.iterator();
    paramList = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (a)((Iterator)localObject2).next();
      if ((((a)localObject1).BWd != null) && (((a)localObject1).BWd.BWe))
      {
        paramList = (List<a>)localObject1;
      }
      else
      {
        d locald = ((a)localObject1).BVY;
        Object localObject3 = (List)localHashMap.get(locald);
        if (localObject3 == null)
        {
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject1);
          localHashMap.put(locald, localObject3);
        }
        else
        {
          ((List)localObject3).add(localObject1);
        }
      }
    }
    Object localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d)((Iterator)localObject1).next();
      localArrayList.add(localObject2);
      localArrayList.addAll((Collection)localHashMap.get(localObject2));
    }
    if (paramList != null)
    {
      localArrayList.add(new d("OCR", MMApplicationContext.getContext().getResources().getString(b.i.smart_gallery_ocr_category_name)));
      paramList.albumName = MMApplicationContext.getContext().getResources().getString(b.i.smart_gallery_ocr_album_name, new Object[] { paramString });
      localArrayList.add(paramList);
    }
    AppMethodBeat.o(111370);
    return localArrayList;
  }
  
  public static List<GalleryItem.MediaItem> v(List<Long> paramList, int paramInt)
  {
    AppMethodBeat.i(111371);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramList))
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "getFavMediaItemByIds, ids is invalid.");
      AppMethodBeat.o(111371);
      return localArrayList;
    }
    Object localObject1 = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      j = Math.min(i + 20, paramList.size());
      Object localObject2 = ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(paramList.subList(i, j), null, null, null);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      if (j >= paramList.size())
      {
        paramList = ((ArrayList)localObject1).iterator();
        while (paramList.hasNext())
        {
          localObject1 = (g)paramList.next();
          if (((g)localObject1).field_favProto.syG.size() != 0)
          {
            i = ((g)localObject1).field_favProto.syG.size() - 1;
            if (i >= 0)
            {
              localObject2 = (anm)((g)localObject1).field_favProto.syG.get(i);
              if (u.agG(b.d((anm)localObject2))) {
                switch (paramInt)
                {
                }
              }
              for (;;)
              {
                i -= 1;
                break;
                if (((anm)localObject2).dataType == 2)
                {
                  localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((anm)localObject2), "", "image/fav");
                  ((GalleryItem.MediaItem)localObject2).BVm = ((g)localObject1).field_updateTime;
                  localArrayList.add(localObject2);
                  continue;
                  if ((((anm)localObject2).dataType == 4) || (((anm)localObject2).dataType == 15))
                  {
                    localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((anm)localObject2), "", "video/fav");
                    ((GalleryItem.MediaItem)localObject2).BVm = ((g)localObject1).field_updateTime;
                    localArrayList.add(localObject2);
                    continue;
                    if ((((anm)localObject2).dataType == 2) || (((anm)localObject2).dataType == 4) || (((anm)localObject2).dataType == 15)) {
                      if (((anm)localObject2).dataType == 2)
                      {
                        localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((anm)localObject2), "", "image/fav");
                        ((GalleryItem.MediaItem)localObject2).BVm = ((g)localObject1).field_updateTime;
                        localArrayList.add(localObject2);
                      }
                      else
                      {
                        localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((anm)localObject2), "", "video/fav");
                        ((GalleryItem.MediaItem)localObject2).BVm = ((g)localObject1).field_updateTime;
                        localArrayList.add(localObject2);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(111371);
        return localArrayList;
      }
    }
  }
  
  public final boolean etZ()
  {
    AppMethodBeat.i(173743);
    boolean bool;
    Object localObject;
    try
    {
      Bundle localBundle = this.kiH.call(BVU, "isSmartGalleryAvailable", null, null);
      if (localBundle != null)
      {
        bool = localBundle.getBoolean("isSmartGalleryAvailable");
        Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid res: %s.", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(173743);
        return bool;
      }
    }
    catch (Exception localException)
    {
      localObject = BVU.buildUpon().appendEncodedPath("albums").build();
      localObject = this.kiH.query((Uri)localObject, etY(), null, null, null);
      if (localObject == null) {
        break label146;
      }
    }
    Log.i("MicroMsg.SmartGalleryQueryUtil", "cursor not null.");
    if (((Cursor)localObject).moveToNext())
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid");
      bool = true;
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      AppMethodBeat.o(173743);
      return bool;
      bool = false;
      break;
      label146:
      bool = false;
    }
  }
  
  public final void eua()
  {
    AppMethodBeat.i(111373);
    Log.i("MicroMsg.SmartGalleryQueryUtil", "clearSelectedMediaPath");
    this.BVX.clear();
    AppMethodBeat.o(111373);
  }
  
  public final int eub()
  {
    AppMethodBeat.i(111375);
    int i = this.BVX.size();
    AppMethodBeat.o(111375);
    return i;
  }
  
  public final void fm(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111374);
    eua();
    this.BVX.addAll(paramList);
    AppMethodBeat.o(111374);
  }
  
  public static final class a
    extends s.i
  {
    public s.d BVY;
    public String BVZ;
    public int BWa;
    public long BWb;
    public String BWc;
    public s.b BWd;
    public String albumName;
    
    public a()
    {
      this.mType = 1;
    }
    
    public final void hK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(111360);
      this.BVY = new s.d(paramString1, paramString2);
      AppMethodBeat.o(111360);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111361);
      String str = "[albumID " + this.BVZ + " albumName " + this.albumName + " albumCapacity " + this.BWa + " albumCoverId " + this.BWb + " albumCoverData " + this.BWc + " albumTag " + this.BWd + "]";
      AppMethodBeat.o(111361);
      return str;
    }
  }
  
  public static final class b
  {
    public s.e BUm;
    public boolean BWe = false;
    public boolean BWf = false;
    public boolean BWg;
    
    public final String toString()
    {
      AppMethodBeat.i(111362);
      StringBuilder localStringBuilder = new StringBuilder("isOcr: ").append(this.BWe).append(" cropArea: ");
      if (this.BUm == null) {}
      for (String str = "";; str = this.BUm.toString())
      {
        str = str + " coverIsVideo: " + this.BWf;
        AppMethodBeat.o(111362);
        return str;
      }
    }
  }
  
  public static final class c
  {
    public List<s.d> BWh;
    public Map<s.d, List<s.a>> BWi;
    
    public c(List<s.d> paramList, Map<s.d, List<s.a>> paramMap)
    {
      this.BWh = paramList;
      this.BWi = paramMap;
    }
  }
  
  public static final class d
    extends s.i
  {
    public String BWj;
    public String BWk;
    
    d()
    {
      this.mType = 0;
    }
    
    d(String paramString1, String paramString2)
    {
      this();
      this.BWj = paramString1;
      this.BWk = paramString2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111364);
      if (((paramObject instanceof d)) && (this.BWk.equals(((d)paramObject).BWk)) && (this.BWj.equals(((d)paramObject).BWj)))
      {
        AppMethodBeat.o(111364);
        return true;
      }
      AppMethodBeat.o(111364);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111363);
      int i = this.BWj.hashCode();
      int j = this.BWk.hashCode();
      AppMethodBeat.o(111363);
      return (i + 629) * 37 + j;
    }
  }
  
  public static final class f
    extends s.i
  {
    public f()
    {
      this.mType = 2;
    }
  }
  
  public static abstract class i
  {
    public int mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.s
 * JD-Core Version:    0.7.0.1
 */