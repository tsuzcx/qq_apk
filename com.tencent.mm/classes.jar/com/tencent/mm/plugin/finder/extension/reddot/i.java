package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "showInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "Lkotlin/collections/HashMap;", "getShowInfoMap", "()Ljava/util/HashMap;", "showRelationMap", "Ljava/util/LinkedList;", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "containsPath", "", "path", "delete", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "isAsync", "findShowInfoByPath", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isShowInfoEmpty", "isValid", "removeDependentRelation", "", "parent", "childPath", "removeShowInfoWithPath", "store", "toString", "Companion", "plugin-finder_release"})
public final class i
  extends cj
{
  private static final c.a info;
  public static final a rTe;
  final HashMap<String, ase> rTc;
  private final HashMap<String, LinkedList<String>> rTd;
  
  static
  {
    AppMethodBeat.i(178205);
    rTe = new a((byte)0);
    info = cj.Vv();
    AppMethodBeat.o(178205);
  }
  
  public i()
  {
    AppMethodBeat.i(178204);
    this.rTc = new HashMap();
    this.rTd = new HashMap();
    AppMethodBeat.o(178204);
  }
  
  private boolean a(final c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(201655);
    p.h(paramc, "storage");
    CharSequence localCharSequence = (CharSequence)this.field_ctrInfo.GoQ;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label94;
      }
      ad.e("Finder.RedDotCtrInfo", this.field_tipsId + " is inValid");
      AppMethodBeat.o(201655);
      return false;
      i = 0;
      break;
    }
    label94:
    paramc = (a)new f(this, paramc);
    if (paramBoolean) {
      com.tencent.mm.ad.c.c("Finder.RedDotCtrInfo", (a)new e(paramc));
    }
    for (;;)
    {
      AppMethodBeat.o(201655);
      return true;
      paramc.invoke();
    }
  }
  
  private final void gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    ase localase = (ase)this.rTc.get(paramString1);
    if ((localase == null) || (localase.Gqr != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (LinkedList)this.rTd.get(paramString1);
    if (paramString1 != null)
    {
      p.g(paramString1, "list");
      j.b((List)paramString1, (d.g.a.b)new b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  public final boolean ahp(String paramString)
  {
    AppMethodBeat.i(201660);
    p.h(paramString, "path");
    if (this.rTc.get(paramString) != null)
    {
      AppMethodBeat.o(201660);
      return true;
    }
    AppMethodBeat.o(201660);
    return false;
  }
  
  public final ase ahq(String paramString)
  {
    AppMethodBeat.i(178201);
    p.h(paramString, "path");
    paramString = (ase)this.rTc.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final LinkedList<String> ahr(final String paramString)
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(178202);
    p.h(paramString, "path");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (ase)this.rTc.get(paramString);
    Object localObject2;
    String str;
    if ((localObject1 != null) && (((ase)localObject1).Gqr == 1))
    {
      localObject1 = (ase)this.rTc.remove(paramString);
      if (localObject1 != null)
      {
        localLinkedList.add(paramString);
        localObject2 = (CharSequence)((ase)localObject1).xfl;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = ((ase)localObject1).xfl;
          p.g(localObject2, "info.parent");
          str = ((ase)localObject1).path;
          p.g(str, "info.path");
          gl((String)localObject2, str);
          localObject1 = ((ase)localObject1).xfl;
          p.g(localObject1, "info.parent");
          localLinkedList.addAll((Collection)ahr((String)localObject1));
        }
        localObject1 = this.field_ctrInfo.GoP;
        p.g(localObject1, "field_ctrInfo.show_infos");
        j.b((List)localObject1, (d.g.a.b)new c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    int j;
    if ((localObject1 != null) && (((ase)localObject1).Gqr == 2))
    {
      localObject1 = (LinkedList)this.rTd.get(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label309;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.rTc.containsKey(localObject2)) {
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
        localObject1 = (ase)this.rTc.remove(paramString);
        if (localObject1 != null)
        {
          localLinkedList.add(paramString);
          localObject2 = (CharSequence)((ase)localObject1).xfl;
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
            localObject2 = ((ase)localObject1).xfl;
            p.g(localObject2, "it.parent");
            str = ((ase)localObject1).path;
            p.g(str, "it.path");
            gl((String)localObject2, str);
            localObject1 = ((ase)localObject1).xfl;
            p.g(localObject1, "it.parent");
            localLinkedList.addAll((Collection)ahr((String)localObject1));
          }
          localObject1 = this.field_ctrInfo.GoP;
          p.g(localObject1, "field_ctrInfo.show_infos");
          j.b((List)localObject1, (d.g.a.b)new d(this, localLinkedList, paramString));
        }
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
  }
  
  public final i b(aqu paramaqu)
  {
    AppMethodBeat.i(178197);
    p.h(paramaqu, "proto");
    this.field_ctrInfo = paramaqu;
    this.field_tipsId = paramaqu.GoQ;
    this.field_time = cf.aCM();
    paramaqu = paramaqu.GoO;
    if (paramaqu != null) {}
    try
    {
      localObject1 = new aqv();
      ((aqv)localObject1).parseFrom(paramaqu.toByteArray());
      this.field_revokeId = ((aqv)localObject1).GoS;
      paramaqu = new LinkedList();
      localObject1 = this.field_ctrInfo.GoP;
      p.g(localObject1, "field_ctrInfo.show_infos");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ase)((Iterator)localObject1).next();
        localObject3 = (Map)this.rTc;
        localObject4 = ((ase)localObject2).path;
        p.g(localObject4, "it.path");
        p.g(localObject2, "it");
        ((Map)localObject3).put(localObject4, localObject2);
        if (((ase)localObject2).Gqr == 2)
        {
          localObject3 = (Map)this.rTd;
          localObject4 = ((ase)localObject2).path;
          p.g(localObject4, "it.path");
          ((Map)localObject3).put(localObject4, new LinkedList());
          paramaqu.add(localObject2);
        }
      }
    }
    catch (Exception paramaqu)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        ad.l("Finder.RedDotCtrInfo", "", new Object[] { paramaqu });
      }
      paramaqu = ((Iterable)paramaqu).iterator();
      while (paramaqu.hasNext())
      {
        localObject1 = (ase)paramaqu.next();
        localObject2 = this.field_ctrInfo.GoP;
        p.g(localObject2, "field_ctrInfo.show_infos");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ase)((Iterator)localObject2).next();
          if (p.i(((ase)localObject3).xfl, ((ase)localObject1).path))
          {
            localObject4 = (LinkedList)this.rTd.get(((ase)localObject1).path);
            if (localObject4 != null) {
              ((LinkedList)localObject4).add(((ase)localObject3).path);
            }
          }
        }
      }
      AppMethodBeat.o(178197);
    }
    return this;
  }
  
  public final boolean b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(201658);
    p.h(paramc, "storage");
    this.field_ctrInfo.GoP.clear();
    this.rTc.clear();
    this.rTd.clear();
    paramBoolean = a(paramc, paramBoolean);
    AppMethodBeat.o(201658);
    return paramBoolean;
  }
  
  public final asd cAi()
  {
    AppMethodBeat.i(201654);
    asd localasd2 = this.field_tipsShowEntranceExtInfo;
    asd localasd1 = localasd2;
    if (localasd2 == null) {
      localasd1 = new asd();
    }
    AppMethodBeat.o(201654);
    return localasd1;
  }
  
  public final boolean cAj()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.GoP;
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
    AppMethodBeat.i(201657);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.GoP.size();
    AppMethodBeat.o(201657);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeDependentRelation$1$1"})
  static final class b
    extends q
    implements d.g.a.b<String, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$1$1"})
  static final class c
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    c(i parami, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$3$1"})
  static final class d
    extends q
    implements d.g.a.b<ase, Boolean>
  {
    d(i parami, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(i parami, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.i
 * JD-Core Version:    0.7.0.1
 */