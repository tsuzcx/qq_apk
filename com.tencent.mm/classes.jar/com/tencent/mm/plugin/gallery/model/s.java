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
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  public int eU;
  public ContentResolver gJw;
  public boolean tSs;
  public boolean tSt;
  public List<GalleryItem.MediaItem> tSu;
  
  static
  {
    AppMethodBeat.i(111376);
    BASE_URI = Uri.parse("content://com.open.gallery.smart.provider");
    AppMethodBeat.o(111376);
  }
  
  private s()
  {
    AppMethodBeat.i(111368);
    this.eU = 100;
    this.tSu = new ArrayList();
    this.gJw = ak.getContext().getContentResolver();
    AppMethodBeat.o(111368);
  }
  
  static LinkedList<GalleryItem.AlbumItem> ab(ArrayList<a> paramArrayList)
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
  
  public static s cYc()
  {
    return j.tSL;
  }
  
  public static String[] cYd()
  {
    return new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" };
  }
  
  public static c ec(List<a> paramList)
  {
    AppMethodBeat.i(111369);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      d locald = locala.tSv;
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
  
  public static b gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111372);
    if (bu.isNullOrNil(paramString1))
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
        localb.tSB = paramString1.optBoolean("ocr", false);
        Object localObject = paramString1.optJSONObject("cropArea");
        if (localObject != null)
        {
          int i = ((JSONObject)localObject).optInt("cropType", 0);
          double d1 = ((JSONObject)localObject).optDouble("left", -1.0D);
          double d2 = ((JSONObject)localObject).optDouble("top", -1.0D);
          double d3 = ((JSONObject)localObject).optDouble("right", -1.0D);
          double d4 = ((JSONObject)localObject).optDouble("bottom", -1.0D);
          localObject = new e();
          ((e)localObject).tSI = i;
          ((e)localObject).owS = d1;
          ((e)localObject).owT = d2;
          ((e)localObject).owU = d3;
          ((e)localObject).owV = d4;
          ((e)localObject).id = paramString2;
          localb.tQM = ((e)localObject);
        }
        if (3 != paramString1.optInt("coverType", 1)) {
          continue;
        }
        bool = true;
        localb.tSC = bool;
        localb.tSD = paramString1.optBoolean("favorite", false);
      }
      catch (JSONException paramString1)
      {
        boolean bool;
        ae.e("MicroMsg.SmartGalleryQueryUtil", "parse album json error, msg: %s.", new Object[] { paramString1.getMessage(), paramString1 });
        continue;
      }
      AppMethodBeat.o(111372);
      return localb;
      bool = false;
    }
  }
  
  public static List<i> l(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(111370);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramList.iterator();
    paramList = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (a)((Iterator)localObject2).next();
      if ((((a)localObject1).tSA != null) && (((a)localObject1).tSA.tSB))
      {
        paramList = (List<a>)localObject1;
      }
      else
      {
        d locald = ((a)localObject1).tSv;
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
      localArrayList.add(new d("OCR", ak.getContext().getResources().getString(2131763726)));
      paramList.tRB = ak.getContext().getResources().getString(2131763725, new Object[] { paramString });
      localArrayList.add(paramList);
    }
    AppMethodBeat.o(111370);
    return localArrayList;
  }
  
  public static List<GalleryItem.MediaItem> s(List<Long> paramList, int paramInt)
  {
    AppMethodBeat.i(111371);
    ArrayList localArrayList = new ArrayList();
    if (bu.ht(paramList))
    {
      ae.i("MicroMsg.SmartGalleryQueryUtil", "getFavMediaItemByIds, ids is invalid.");
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
          } while (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.size() == 0);
          i = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.size() - 1;
        } while (i < 0);
        localObject2 = (ajx)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ.get(i);
        if (o.fB(b.d((ajx)localObject2))) {
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
        if (((ajx)localObject2).dataType == 2)
        {
          localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((ajx)localObject2), "", "image/fav");
          ((GalleryItem.MediaItem)localObject2).tRN = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
          localArrayList.add(localObject2);
          continue;
          if ((((ajx)localObject2).dataType == 4) || (((ajx)localObject2).dataType == 15))
          {
            localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((ajx)localObject2), "", "video/fav");
            ((GalleryItem.MediaItem)localObject2).tRN = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
            localArrayList.add(localObject2);
            continue;
            if ((((ajx)localObject2).dataType == 2) || (((ajx)localObject2).dataType == 4) || (((ajx)localObject2).dataType == 15)) {
              if (((ajx)localObject2).dataType == 2)
              {
                localObject2 = GalleryItem.MediaItem.a(1, -1L, b.d((ajx)localObject2), "", "image/fav");
                ((GalleryItem.MediaItem)localObject2).tRN = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
                localArrayList.add(localObject2);
              }
              else
              {
                localObject2 = GalleryItem.MediaItem.a(2, -1L, b.d((ajx)localObject2), "", "video/fav");
                ((GalleryItem.MediaItem)localObject2).tRN = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime;
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
  
  public final boolean cYe()
  {
    AppMethodBeat.i(173743);
    boolean bool;
    Object localObject;
    try
    {
      Bundle localBundle = this.gJw.call(BASE_URI, "isSmartGalleryAvailable", null, null);
      if (localBundle != null)
      {
        bool = localBundle.getBoolean("isSmartGalleryAvailable");
        ae.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid res: %s.", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(173743);
        return bool;
      }
    }
    catch (Exception localException)
    {
      localObject = BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject = this.gJw.query((Uri)localObject, cYd(), null, null, null);
      if (localObject == null) {
        break label146;
      }
    }
    ae.i("MicroMsg.SmartGalleryQueryUtil", "cursor not null.");
    if (((Cursor)localObject).moveToNext())
    {
      ae.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid");
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
  
  public final void cYf()
  {
    AppMethodBeat.i(111373);
    ae.i("MicroMsg.SmartGalleryQueryUtil", "clearSelectedMediaPath");
    this.tSu.clear();
    AppMethodBeat.o(111373);
  }
  
  public final int cYg()
  {
    AppMethodBeat.i(111375);
    int i = this.tSu.size();
    AppMethodBeat.o(111375);
    return i;
  }
  
  public final void ed(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111374);
    cYf();
    this.tSu.addAll(paramList);
    AppMethodBeat.o(111374);
  }
  
  public static final class a
    extends s.i
  {
    public String tRB;
    public s.b tSA;
    public s.d tSv;
    public String tSw;
    public int tSx;
    public long tSy;
    public String tSz;
    
    public a()
    {
      this.mType = 1;
    }
    
    public final void gW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(111360);
      this.tSv = new s.d(paramString1, paramString2);
      AppMethodBeat.o(111360);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111361);
      String str = "[albumID " + this.tSw + " albumName " + this.tRB + " albumCapacity " + this.tSx + " albumCoverId " + this.tSy + " albumCoverData " + this.tSz + " albumTag " + this.tSA + "]";
      AppMethodBeat.o(111361);
      return str;
    }
  }
  
  public static final class b
  {
    public s.e tQM;
    public boolean tSB = false;
    public boolean tSC = false;
    public boolean tSD;
    
    public final String toString()
    {
      AppMethodBeat.i(111362);
      StringBuilder localStringBuilder = new StringBuilder("isOcr: ").append(this.tSB).append(" cropArea: ");
      if (this.tQM == null) {}
      for (String str = "";; str = this.tQM.toString())
      {
        str = str + " coverIsVideo: " + this.tSC;
        AppMethodBeat.o(111362);
        return str;
      }
    }
  }
  
  public static final class c
  {
    public List<s.d> tSE;
    public Map<s.d, List<s.a>> tSF;
    
    public c(List<s.d> paramList, Map<s.d, List<s.a>> paramMap)
    {
      this.tSE = paramList;
      this.tSF = paramMap;
    }
  }
  
  public static final class d
    extends s.i
  {
    public String tSG;
    public String tSH;
    
    d()
    {
      this.mType = 0;
    }
    
    d(String paramString1, String paramString2)
    {
      this();
      this.tSG = paramString1;
      this.tSH = paramString2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111364);
      if (((paramObject instanceof d)) && (this.tSH.equals(((d)paramObject).tSH)) && (this.tSG.equals(((d)paramObject).tSG)))
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
      int i = this.tSG.hashCode();
      int j = this.tSH.hashCode();
      AppMethodBeat.o(111363);
      return (i + 629) * 37 + j;
    }
  }
  
  public static final class e
  {
    public String id;
    double owS;
    double owT;
    double owU;
    double owV;
    int tSI = 0;
    
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
      String str = "crop area info -> cropType:" + this.tSI + " left:" + this.owS + " top:" + this.owT + " right:" + this.owU + " bottom:" + this.owV + " id:" + this.id;
      AppMethodBeat.o(111366);
      return str;
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
  
  static final class j
  {
    static s tSL;
    
    static
    {
      AppMethodBeat.i(111367);
      tSL = new s((byte)0);
      AppMethodBeat.o(111367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.s
 * JD-Core Version:    0.7.0.1
 */