package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "showInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "Lkotlin/collections/HashMap;", "getShowInfoMap", "()Ljava/util/HashMap;", "showRelationMap", "Ljava/util/LinkedList;", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "delete", "", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "findShowInfoByPath", "path", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isShowInfoEmpty", "isValid", "removeDependentRelation", "", "parent", "childPath", "removeShowInfoWithPath", "store", "toString", "Companion", "plugin-finder_release"})
public final class h
  extends cg
{
  private static final c.a info;
  public static final h.a rfv;
  final HashMap<String, aon> rft;
  private final HashMap<String, LinkedList<String>> rfu;
  
  static
  {
    AppMethodBeat.i(178205);
    rfv = new h.a((byte)0);
    info = cg.Th();
    AppMethodBeat.o(178205);
  }
  
  public h()
  {
    AppMethodBeat.i(178204);
    this.rft = new HashMap();
    this.rfu = new HashMap();
    AppMethodBeat.o(178204);
  }
  
  private final void gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    aon localaon = (aon)this.rft.get(paramString1);
    if ((localaon == null) || (localaon.EHC != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (LinkedList)this.rfu.get(paramString1);
    if (paramString1 != null)
    {
      k.g(paramString1, "list");
      j.a((List)paramString1, (d.g.a.b)new h.b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(178199);
    CharSequence localCharSequence = (CharSequence)this.field_ctrInfo.EGt;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(178199);
      return true;
    }
    AppMethodBeat.o(178199);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(178198);
    k.h(paramb, "storage");
    if (!isValid())
    {
      ac.e("Finder.RedDotCtrInfo", this.field_tipsId + " is inValid");
      AppMethodBeat.o(178198);
      return false;
    }
    if (ctZ()) {}
    for (boolean bool = paramb.delete((c)this, new String[0]);; bool = paramb.replace((c)this))
    {
      ac.i("Finder.RedDotCtrInfo", "[store] ret=".concat(String.valueOf(bool)));
      AppMethodBeat.o(178198);
      return bool;
    }
  }
  
  public final LinkedList<String> adA(String paramString)
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(178202);
    k.h(paramString, "path");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (aon)this.rft.get(paramString);
    Object localObject2;
    String str;
    if ((localObject1 != null) && (((aon)localObject1).EHC == 1))
    {
      localObject1 = (aon)this.rft.remove(paramString);
      if (localObject1 != null)
      {
        localLinkedList.add(paramString);
        localObject2 = (CharSequence)((aon)localObject1).vXx;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = ((aon)localObject1).vXx;
          k.g(localObject2, "info.parent");
          str = ((aon)localObject1).path;
          k.g(str, "info.path");
          gc((String)localObject2, str);
          localObject1 = ((aon)localObject1).vXx;
          k.g(localObject1, "info.parent");
          localLinkedList.addAll((Collection)adA((String)localObject1));
        }
        localObject1 = this.field_ctrInfo.EGs;
        k.g(localObject1, "field_ctrInfo.show_infos");
        j.a((List)localObject1, (d.g.a.b)new h.c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    int j;
    if ((localObject1 != null) && (((aon)localObject1).EHC == 2))
    {
      localObject1 = (LinkedList)this.rfu.get(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label309;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.rft.containsKey(localObject2)) {
          break label487;
        }
        i = 1;
      }
    }
    label309:
    label487:
    for (;;)
    {
      break;
      j = 0;
      if (j == 0)
      {
        localObject1 = (aon)this.rft.remove(paramString);
        if (localObject1 != null)
        {
          localLinkedList.add(paramString);
          localObject2 = (CharSequence)((aon)localObject1).vXx;
          if (localObject2 != null)
          {
            i = k;
            if (((CharSequence)localObject2).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i == 0)
          {
            localObject2 = ((aon)localObject1).vXx;
            k.g(localObject2, "it.parent");
            str = ((aon)localObject1).path;
            k.g(str, "it.path");
            gc((String)localObject2, str);
            localObject1 = ((aon)localObject1).vXx;
            k.g(localObject1, "it.parent");
            localLinkedList.addAll((Collection)adA((String)localObject1));
          }
          localObject1 = this.field_ctrInfo.EGs;
          k.g(localObject1, "field_ctrInfo.show_infos");
          j.a((List)localObject1, (d.g.a.b)new h.d(this, localLinkedList, paramString));
        }
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
  }
  
  public final aon adz(String paramString)
  {
    AppMethodBeat.i(178201);
    k.h(paramString, "path");
    paramString = (aon)this.rft.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final h b(ani paramani)
  {
    AppMethodBeat.i(178197);
    k.h(paramani, "proto");
    this.field_ctrInfo = paramani;
    this.field_tipsId = paramani.EGt;
    this.field_time = ce.azJ();
    paramani = paramani.EGr;
    if (paramani != null) {}
    try
    {
      localObject1 = new anj();
      ((anj)localObject1).parseFrom(paramani.toByteArray());
      this.field_revokeId = ((anj)localObject1).EGv;
      paramani = new LinkedList();
      localObject1 = this.field_ctrInfo.EGs;
      k.g(localObject1, "field_ctrInfo.show_infos");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aon)((Iterator)localObject1).next();
        localObject3 = (Map)this.rft;
        localObject4 = ((aon)localObject2).path;
        k.g(localObject4, "it.path");
        k.g(localObject2, "it");
        ((Map)localObject3).put(localObject4, localObject2);
        if (((aon)localObject2).EHC == 2)
        {
          localObject3 = (Map)this.rfu;
          localObject4 = ((aon)localObject2).path;
          k.g(localObject4, "it.path");
          ((Map)localObject3).put(localObject4, new LinkedList());
          paramani.add(localObject2);
        }
      }
    }
    catch (Exception paramani)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        ac.l("Finder.RedDotCtrInfo", "", new Object[] { paramani });
      }
      paramani = ((Iterable)paramani).iterator();
      while (paramani.hasNext())
      {
        localObject1 = (aon)paramani.next();
        localObject2 = this.field_ctrInfo.EGs;
        k.g(localObject2, "field_ctrInfo.show_infos");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aon)((Iterator)localObject2).next();
          if (k.g(((aon)localObject3).vXx, ((aon)localObject1).path))
          {
            localObject4 = (LinkedList)this.rfu.get(((aon)localObject1).path);
            if (localObject4 != null) {
              ((LinkedList)localObject4).add(((aon)localObject3).path);
            }
          }
        }
      }
      AppMethodBeat.o(178197);
    }
    return this;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(201487);
    k.h(paramb, "storage");
    this.field_ctrInfo.EGs.clear();
    this.rft.clear();
    this.rfu.clear();
    boolean bool = a(paramb);
    AppMethodBeat.o(201487);
    return bool;
  }
  
  public final aom ctY()
  {
    AppMethodBeat.i(201485);
    aom localaom2 = this.field_tipsShowEntranceExtInfo;
    aom localaom1 = localaom2;
    if (localaom2 == null) {
      localaom1 = new aom();
    }
    AppMethodBeat.o(201485);
    return localaom1;
  }
  
  public final boolean ctZ()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.EGs;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      AppMethodBeat.o(178200);
      return true;
    }
    AppMethodBeat.o(178200);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201486);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId;
    AppMethodBeat.o(201486);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */