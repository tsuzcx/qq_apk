package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.gallery.model.t.a;>;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static final Uri dYo;
  public int HIs;
  public boolean HIt;
  public boolean HIu;
  public List<GalleryItem.MediaItem> HIv;
  public ContentResolver mJn;
  
  static
  {
    AppMethodBeat.i(111376);
    dYo = Uri.parse("content://com.open.gallery.smart.provider");
    AppMethodBeat.o(111376);
  }
  
  private t()
  {
    AppMethodBeat.i(111368);
    this.HIs = 100;
    this.HIv = new ArrayList();
    this.mJn = MMApplicationContext.getContext().getContentResolver();
    AppMethodBeat.o(111368);
  }
  
  public static List<GalleryItem.MediaItem> O(List<Long> paramList, int paramInt)
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
      Object localObject2 = ((ah)h.az(ah.class)).getFavItemInfoStorage().a(paramList.subList(i, j), null, null, null, false);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      if (j >= paramList.size())
      {
        paramList = ((ArrayList)localObject1).iterator();
        while (paramList.hasNext())
        {
          localObject1 = (g)paramList.next();
          if (((g)localObject1).field_favProto.vEn.size() != 0)
          {
            i = ((g)localObject1).field_favProto.vEn.size() - 1;
            if (i >= 0)
            {
              localObject2 = (arf)((g)localObject1).field_favProto.vEn.get(i);
              if (com.tencent.mm.vfs.y.ZC(b.d((arf)localObject2))) {
                switch (paramInt)
                {
                }
              }
              for (;;)
              {
                i -= 1;
                break;
                if (((arf)localObject2).dataType == 2)
                {
                  localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((arf)localObject2), "", "image/fav");
                  ((GalleryItem.MediaItem)localObject2).HHK = ((g)localObject1).field_updateTime;
                  localArrayList.add(localObject2);
                  continue;
                  if ((((arf)localObject2).dataType == 4) || (((arf)localObject2).dataType == 15))
                  {
                    localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((arf)localObject2), "", "video/fav");
                    ((GalleryItem.MediaItem)localObject2).HHK = ((g)localObject1).field_updateTime;
                    localArrayList.add(localObject2);
                    continue;
                    if ((((arf)localObject2).dataType == 2) || (((arf)localObject2).dataType == 4) || (((arf)localObject2).dataType == 15)) {
                      if (((arf)localObject2).dataType == 2)
                      {
                        localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((arf)localObject2), "", "image/fav");
                        ((GalleryItem.MediaItem)localObject2).HHK = ((g)localObject1).field_updateTime;
                        localArrayList.add(localObject2);
                      }
                      else
                      {
                        localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((arf)localObject2), "", "video/fav");
                        ((GalleryItem.MediaItem)localObject2).HHK = ((g)localObject1).field_updateTime;
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
  
  static LinkedList<GalleryItem.AlbumItem> aK(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(173744);
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add(new PrivateAlbumItem((a)paramArrayList.next()));
    }
    AppMethodBeat.o(173744);
    return localLinkedList;
  }
  
  public static t fAV()
  {
    return j.HIP;
  }
  
  public static String[] fAW()
  {
    return new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" };
  }
  
  public static b iL(String paramString1, String paramString2)
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
        localb.HIC = paramString1.optBoolean("ocr", false);
        Object localObject = paramString1.optJSONObject("cropArea");
        if (localObject != null)
        {
          int i = ((JSONObject)localObject).optInt("cropType", 0);
          double d1 = ((JSONObject)localObject).optDouble("left", -1.0D);
          double d2 = ((JSONObject)localObject).optDouble("top", -1.0D);
          double d3 = ((JSONObject)localObject).optDouble("right", -1.0D);
          double d4 = ((JSONObject)localObject).optDouble("bottom", -1.0D);
          localObject = new t.e();
          ((t.e)localObject).HII = i;
          ((t.e)localObject).HIJ = d1;
          ((t.e)localObject).HIK = d2;
          ((t.e)localObject).HIL = d3;
          ((t.e)localObject).HIM = d4;
          ((t.e)localObject).id = paramString2;
          localb.HGH = ((t.e)localObject);
        }
        if (3 != paramString1.optInt("coverType", 1)) {
          continue;
        }
        bool = true;
        localb.HID = bool;
        localb.HIE = paramString1.optBoolean("favorite", false);
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
  
  public static t.c ib(List<a> paramList)
  {
    AppMethodBeat.i(111369);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      t.d locald = locala.HIw;
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
    paramList = new t.c(localArrayList, localHashMap);
    AppMethodBeat.o(111369);
    return paramList;
  }
  
  public static List<t.i> x(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(111370);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramList.iterator();
    paramList = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (a)((Iterator)localObject2).next();
      if ((((a)localObject1).HIB != null) && (((a)localObject1).HIB.HIC))
      {
        paramList = (List<a>)localObject1;
      }
      else
      {
        t.d locald = ((a)localObject1).HIw;
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
      localObject2 = (t.d)((Iterator)localObject1).next();
      localArrayList.add(localObject2);
      localArrayList.addAll((Collection)localHashMap.get(localObject2));
    }
    if (paramList != null)
    {
      localArrayList.add(new t.d("OCR", MMApplicationContext.getContext().getResources().getString(b.i.smart_gallery_ocr_category_name)));
      paramList.albumName = MMApplicationContext.getContext().getResources().getString(b.i.smart_gallery_ocr_album_name, new Object[] { paramString });
      localArrayList.add(paramList);
    }
    AppMethodBeat.o(111370);
    return localArrayList;
  }
  
  public final void fAX()
  {
    AppMethodBeat.i(111373);
    Log.i("MicroMsg.SmartGalleryQueryUtil", "clearSelectedMediaPath");
    this.HIv.clear();
    AppMethodBeat.o(111373);
  }
  
  public final int fAY()
  {
    AppMethodBeat.i(111375);
    int i = this.HIv.size();
    AppMethodBeat.o(111375);
    return i;
  }
  
  public final boolean hF(Context paramContext)
  {
    AppMethodBeat.i(289618);
    if (!i.s(paramContext, "android.permission.READ_EXTERNAL_STORAGE"))
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid without READ_EXTERNAL_STORAGE.");
      AppMethodBeat.o(289618);
      return false;
    }
    Log.i("MicroMsg.SmartGalleryQueryUtil", "has permiss.");
    boolean bool;
    try
    {
      paramContext = this.mJn.call(dYo, "isSmartGalleryAvailable", null, null);
      if (paramContext != null)
      {
        bool = paramContext.getBoolean("isSmartGalleryAvailable");
        Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid res: %s.", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(289618);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext = dYo.buildUpon().appendEncodedPath("albums").build();
      paramContext = this.mJn.query(paramContext, fAW(), null, null, null);
      if (paramContext == null) {
        break label177;
      }
    }
    Log.i("MicroMsg.SmartGalleryQueryUtil", "cursor not null.");
    if (paramContext.moveToNext())
    {
      Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid");
      bool = true;
      paramContext.close();
    }
    for (;;)
    {
      AppMethodBeat.o(289618);
      return bool;
      bool = false;
      break;
      label177:
      bool = false;
    }
  }
  
  public final void ic(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111374);
    fAX();
    this.HIv.addAll(paramList);
    AppMethodBeat.o(111374);
  }
  
  public static final class a
    extends t.i
  {
    public String HIA;
    public t.b HIB;
    public t.d HIw;
    public String HIx;
    public int HIy;
    public long HIz;
    public String albumName;
    
    public a()
    {
      this.mType = 1;
    }
    
    public final void iM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(111360);
      this.HIw = new t.d(paramString1, paramString2);
      AppMethodBeat.o(111360);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111361);
      String str = "[albumID " + this.HIx + " albumName " + this.albumName + " albumCapacity " + this.HIy + " albumCoverId " + this.HIz + " albumCoverData " + this.HIA + " albumTag " + this.HIB + "]";
      AppMethodBeat.o(111361);
      return str;
    }
  }
  
  public static final class b
  {
    public t.e HGH;
    public boolean HIC = false;
    public boolean HID = false;
    public boolean HIE;
    
    public final String toString()
    {
      AppMethodBeat.i(111362);
      StringBuilder localStringBuilder = new StringBuilder("isOcr: ").append(this.HIC).append(" cropArea: ");
      if (this.HGH == null) {}
      for (String str = "";; str = this.HGH.toString())
      {
        str = str + " coverIsVideo: " + this.HID;
        AppMethodBeat.o(111362);
        return str;
      }
    }
  }
  
  public static final class g
  {
    public long HIN;
    public long HIO;
    public String data;
    public String type;
  }
  
  public static abstract interface h
  {
    public abstract void s(List<t.g> paramList, boolean paramBoolean);
  }
  
  static final class j
  {
    static t HIP;
    
    static
    {
      AppMethodBeat.i(111367);
      HIP = new t((byte)0);
      AppMethodBeat.o(111367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.t
 * JD-Core Version:    0.7.0.1
 */