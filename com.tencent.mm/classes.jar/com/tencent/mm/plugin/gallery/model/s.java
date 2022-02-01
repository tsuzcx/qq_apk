package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
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
  public static final Uri BASE_URI;
  public ContentResolver gne;
  public int sKQ;
  public boolean sKR;
  public boolean sKS;
  public List<GalleryItem.MediaItem> sKT;
  
  static
  {
    AppMethodBeat.i(111376);
    BASE_URI = Uri.parse("content://com.open.gallery.smart.provider");
    AppMethodBeat.o(111376);
  }
  
  private s()
  {
    AppMethodBeat.i(111368);
    this.sKQ = 100;
    this.sKT = new ArrayList();
    this.gne = ai.getContext().getContentResolver();
    AppMethodBeat.o(111368);
  }
  
  static LinkedList<GalleryItem.AlbumItem> ac(ArrayList<a> paramArrayList)
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
  
  public static s cNf()
  {
    return s.j.sLl;
  }
  
  public static String[] cNg()
  {
    return new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" };
  }
  
  public static s.c dO(List<a> paramList)
  {
    AppMethodBeat.i(111369);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      d locald = locala.sKU;
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
    paramList = new s.c(localArrayList, localHashMap);
    AppMethodBeat.o(111369);
    return paramList;
  }
  
  public static b gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111372);
    if (bs.isNullOrNil(paramString1))
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
        localb.sLa = paramString1.optBoolean("ocr", false);
        Object localObject = paramString1.optJSONObject("cropArea");
        if (localObject != null)
        {
          int i = ((JSONObject)localObject).optInt("cropType", 0);
          double d1 = ((JSONObject)localObject).optDouble("left", -1.0D);
          double d2 = ((JSONObject)localObject).optDouble("top", -1.0D);
          double d3 = ((JSONObject)localObject).optDouble("right", -1.0D);
          double d4 = ((JSONObject)localObject).optDouble("bottom", -1.0D);
          localObject = new e();
          ((e)localObject).sLi = i;
          ((e)localObject).nNQ = d1;
          ((e)localObject).nNR = d2;
          ((e)localObject).nNS = d3;
          ((e)localObject).nNT = d4;
          ((e)localObject).id = paramString2;
          localb.sJk = ((e)localObject);
        }
        if (3 != paramString1.optInt("coverType", 1)) {
          continue;
        }
        bool = true;
        localb.sLb = bool;
        localb.sLd = paramString1.optBoolean("favorite", false);
      }
      catch (JSONException paramString1)
      {
        boolean bool;
        ac.e("MicroMsg.SmartGalleryQueryUtil", "parse album json error, msg: %s.", new Object[] { paramString1.getMessage(), paramString1 });
        continue;
      }
      AppMethodBeat.o(111372);
      return localb;
      bool = false;
    }
  }
  
  public static List<s.i> m(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(111370);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramList.iterator();
    paramList = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (a)((Iterator)localObject2).next();
      if ((((a)localObject1).sKZ != null) && (((a)localObject1).sKZ.sLa))
      {
        paramList = (List<a>)localObject1;
      }
      else
      {
        d locald = ((a)localObject1).sKU;
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
      localArrayList.add(new d("OCR", ai.getContext().getResources().getString(2131763726)));
      paramList.sJZ = ai.getContext().getResources().getString(2131763725, new Object[] { paramString });
      localArrayList.add(paramList);
    }
    AppMethodBeat.o(111370);
    return localArrayList;
  }
  
  public static List<GalleryItem.MediaItem> p(List<Long> paramList, int paramInt)
  {
    AppMethodBeat.i(111371);
    ArrayList localArrayList = new ArrayList();
    if (bs.gY(paramList))
    {
      ac.i("MicroMsg.SmartGalleryQueryUtil", "getFavMediaItemByIds, ids is invalid.");
      AppMethodBeat.o(111371);
      return localArrayList;
    }
    Object localObject1 = new ArrayList();
    int i;
    for (int j = 0;; j = i)
    {
      Object localObject2;
      if (j + 20 < paramList.size())
      {
        i = j + 20;
        localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(paramList.subList(j, i), null, null, null);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
          ((ArrayList)localObject1).addAll((Collection)localObject2);
        }
        if (i < paramList.size()) {
          continue;
        }
        paramList = ((ArrayList)localObject1).iterator();
        label186:
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (com.tencent.mm.plugin.fav.a.g)paramList.next();
          } while (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.size() == 0);
          i = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.size() - 1;
        } while (i < 0);
        localObject2 = (agx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC.get(i);
        if (i.eA(b.d((agx)localObject2))) {
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break label186;
        i = paramList.size();
        break;
        if (((agx)localObject2).dataType == 2)
        {
          localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((agx)localObject2), "", "image/fav");
          ((GalleryItem.MediaItem)localObject2).sKl = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
          localArrayList.add(localObject2);
          continue;
          if ((((agx)localObject2).dataType == 4) || (((agx)localObject2).dataType == 15))
          {
            localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((agx)localObject2), "", "video/fav");
            ((GalleryItem.MediaItem)localObject2).sKl = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
            localArrayList.add(localObject2);
            continue;
            if ((((agx)localObject2).dataType == 2) || (((agx)localObject2).dataType == 4) || (((agx)localObject2).dataType == 15)) {
              if (((agx)localObject2).dataType == 2)
              {
                localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((agx)localObject2), "", "image/fav");
                ((GalleryItem.MediaItem)localObject2).sKl = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
                localArrayList.add(localObject2);
              }
              else
              {
                localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((agx)localObject2), "", "video/fav");
                ((GalleryItem.MediaItem)localObject2).sKl = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
      AppMethodBeat.o(111371);
      return localArrayList;
    }
  }
  
  public final boolean cNh()
  {
    AppMethodBeat.i(173743);
    boolean bool;
    Object localObject;
    try
    {
      Bundle localBundle = this.gne.call(BASE_URI, "isSmartGalleryAvailable", null, null);
      if (localBundle != null)
      {
        bool = localBundle.getBoolean("isSmartGalleryAvailable");
        ac.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid res: %s.", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(173743);
        return bool;
      }
    }
    catch (Exception localException)
    {
      localObject = BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject = this.gne.query((Uri)localObject, cNg(), null, null, null);
      if (localObject == null) {
        break label146;
      }
    }
    ac.i("MicroMsg.SmartGalleryQueryUtil", "cursor not null.");
    if (((Cursor)localObject).moveToNext())
    {
      ac.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid");
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
  
  public final void cNi()
  {
    AppMethodBeat.i(111373);
    ac.i("MicroMsg.SmartGalleryQueryUtil", "clearSelectedMediaPath");
    this.sKT.clear();
    AppMethodBeat.o(111373);
  }
  
  public final int cNj()
  {
    AppMethodBeat.i(111375);
    int i = this.sKT.size();
    AppMethodBeat.o(111375);
    return i;
  }
  
  public final void dP(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111374);
    cNi();
    this.sKT.addAll(paramList);
    AppMethodBeat.o(111374);
  }
  
  public static final class a
    extends s.i
  {
    public String sJZ;
    public s.d sKU;
    public String sKV;
    public int sKW;
    public long sKX;
    public String sKY;
    public s.b sKZ;
    
    public a()
    {
      this.mType = 1;
    }
    
    public final void gG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(111360);
      this.sKU = new s.d(paramString1, paramString2);
      AppMethodBeat.o(111360);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111361);
      String str = "[albumID " + this.sKV + " albumName " + this.sJZ + " albumCapacity " + this.sKW + " albumCoverId " + this.sKX + " albumCoverData " + this.sKY + " albumTag " + this.sKZ + "]";
      AppMethodBeat.o(111361);
      return str;
    }
  }
  
  public static final class b
  {
    public s.e sJk;
    public boolean sLa = false;
    public boolean sLb = false;
    public boolean sLd;
    
    public final String toString()
    {
      AppMethodBeat.i(111362);
      StringBuilder localStringBuilder = new StringBuilder("isOcr: ").append(this.sLa).append(" cropArea: ");
      if (this.sJk == null) {}
      for (String str = "";; str = this.sJk.toString())
      {
        str = str + " coverIsVideo: " + this.sLb;
        AppMethodBeat.o(111362);
        return str;
      }
    }
  }
  
  public static final class d
    extends s.i
  {
    public String sLg;
    public String sLh;
    
    d()
    {
      this.mType = 0;
    }
    
    d(String paramString1, String paramString2)
    {
      this();
      this.sLg = paramString1;
      this.sLh = paramString2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111364);
      if (((paramObject instanceof d)) && (this.sLh.equals(((d)paramObject).sLh)) && (this.sLg.equals(((d)paramObject).sLg)))
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
      int i = this.sLg.hashCode();
      int j = this.sLh.hashCode();
      AppMethodBeat.o(111363);
      return (i + 629) * 37 + j;
    }
  }
  
  public static final class e
  {
    public String id;
    double nNQ;
    double nNR;
    double nNS;
    double nNT;
    int sLi = 0;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111365);
      if (paramObject == null)
      {
        AppMethodBeat.o(111365);
        return false;
      }
      boolean bool = ((e)paramObject).id.equals(this.id);
      AppMethodBeat.o(111365);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111366);
      String str = "crop area info -> cropType:" + this.sLi + " left:" + this.nNQ + " top:" + this.nNR + " right:" + this.nNS + " bottom:" + this.nNT + " id:" + this.id;
      AppMethodBeat.o(111366);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.s
 * JD-Core Version:    0.7.0.1
 */