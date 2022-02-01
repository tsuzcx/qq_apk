package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "showInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "Lkotlin/collections/HashMap;", "getShowInfoMap", "()Ljava/util/HashMap;", "showRelationMap", "Ljava/util/LinkedList;", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "delete", "", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "findShowInfoByPath", "path", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "isShowInfoEmpty", "", "isValid", "removeDependentRelation", "parent", "childPath", "removeShowInfoWithPath", "store", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.g.c.ce
{
  private static final c.a info;
  public static final a qtN;
  final HashMap<String, aln> qtL;
  private final HashMap<String, LinkedList<String>> qtM;
  
  static
  {
    AppMethodBeat.i(178205);
    qtN = new a((byte)0);
    info = com.tencent.mm.g.c.ce.So();
    AppMethodBeat.o(178205);
  }
  
  public f()
  {
    AppMethodBeat.i(178204);
    this.qtL = new HashMap();
    this.qtM = new HashMap();
    AppMethodBeat.o(178204);
  }
  
  private final void fP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    aln localaln = (aln)this.qtL.get(paramString1);
    if ((localaln == null) || (localaln.DmL != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (LinkedList)this.qtM.get(paramString1);
    if (paramString1 != null)
    {
      k.g(paramString1, "list");
      j.a((List)paramString1, (b)new b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(178199);
    CharSequence localCharSequence = (CharSequence)this.field_ctrInfo.Dmu;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(178199);
      return true;
    }
    AppMethodBeat.o(178199);
    return false;
  }
  
  public final aln YX(String paramString)
  {
    AppMethodBeat.i(178201);
    k.h(paramString, "path");
    paramString = (aln)this.qtL.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final LinkedList<String> YY(final String paramString)
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(178202);
    k.h(paramString, "path");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (aln)this.qtL.get(paramString);
    Object localObject2;
    String str;
    if ((localObject1 != null) && (((aln)localObject1).DmL == 1))
    {
      localObject1 = (aln)this.qtL.remove(paramString);
      if (localObject1 != null)
      {
        localLinkedList.add(paramString);
        localObject2 = (CharSequence)((aln)localObject1).uOH;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = ((aln)localObject1).uOH;
          k.g(localObject2, "info.parent");
          str = ((aln)localObject1).path;
          k.g(str, "info.path");
          fP((String)localObject2, str);
          localObject1 = ((aln)localObject1).uOH;
          k.g(localObject1, "info.parent");
          localLinkedList.addAll((Collection)YY((String)localObject1));
        }
        localObject1 = this.field_ctrInfo.Dmt;
        k.g(localObject1, "field_ctrInfo.show_infos");
        j.a((List)localObject1, (b)new c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    int j;
    if ((localObject1 != null) && (((aln)localObject1).DmL == 2))
    {
      localObject1 = (LinkedList)this.qtM.get(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label309;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.qtL.containsKey(localObject2)) {
          break label484;
        }
        i = 1;
      }
    }
    label309:
    label484:
    for (;;)
    {
      break;
      j = 0;
      if (j == 0)
      {
        localObject1 = (aln)this.qtL.remove(paramString);
        if (localObject1 != null)
        {
          localLinkedList.add(paramString);
          localObject2 = (CharSequence)((aln)localObject1).uOH;
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
            localObject2 = ((aln)localObject1).uOH;
            k.g(localObject2, "it.parent");
            str = ((aln)localObject1).path;
            k.g(str, "it.path");
            fP((String)localObject2, str);
            localObject1 = ((aln)localObject1).uOH;
            k.g(localObject1, "it.parent");
            localLinkedList.addAll((Collection)YY((String)localObject1));
          }
          localObject1 = this.field_ctrInfo.Dmt;
          k.g(localObject1, "field_ctrInfo.show_infos");
          j.a((List)localObject1, (b)new d(this, localLinkedList, paramString));
        }
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(178198);
    k.h(parama, "storage");
    if (!isValid())
    {
      h.ep(this.field_tipsId + " is inValid");
      AppMethodBeat.o(178198);
      return false;
    }
    if (clt())
    {
      bool = parama.delete((c)this, new String[0]);
      AppMethodBeat.o(178198);
      return bool;
    }
    boolean bool = parama.replace((c)this);
    AppMethodBeat.o(178198);
    return bool;
  }
  
  public final f b(akv paramakv)
  {
    AppMethodBeat.i(178197);
    k.h(paramakv, "proto");
    this.field_ctrInfo = paramakv;
    this.field_tipsId = paramakv.Dmu;
    this.field_time = com.tencent.mm.model.ce.asS();
    paramakv = new LinkedList();
    Object localObject1 = this.field_ctrInfo.Dmt;
    k.g(localObject1, "field_ctrInfo.show_infos");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aln)((Iterator)localObject1).next();
      localObject3 = (Map)this.qtL;
      localObject4 = ((aln)localObject2).path;
      k.g(localObject4, "it.path");
      k.g(localObject2, "it");
      ((Map)localObject3).put(localObject4, localObject2);
      if (((aln)localObject2).DmL == 2)
      {
        localObject3 = (Map)this.qtM;
        localObject4 = ((aln)localObject2).path;
        k.g(localObject4, "it.path");
        ((Map)localObject3).put(localObject4, new LinkedList());
        paramakv.add(localObject2);
      }
    }
    paramakv = ((Iterable)paramakv).iterator();
    while (paramakv.hasNext())
    {
      localObject1 = (aln)paramakv.next();
      localObject2 = this.field_ctrInfo.Dmt;
      k.g(localObject2, "field_ctrInfo.show_infos");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aln)((Iterator)localObject2).next();
        if (k.g(((aln)localObject3).uOH, ((aln)localObject1).path))
        {
          localObject4 = (LinkedList)this.qtM.get(((aln)localObject1).path);
          if (localObject4 != null) {
            ((LinkedList)localObject4).add(((aln)localObject3).path);
          }
        }
      }
    }
    AppMethodBeat.o(178197);
    return this;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(197590);
    k.h(parama, "storage");
    this.field_ctrInfo.Dmt.clear();
    this.qtL.clear();
    this.qtM.clear();
    a(parama);
    AppMethodBeat.o(197590);
  }
  
  public final boolean clt()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.Dmt;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeDependentRelation$1$1"})
  static final class b
    extends d.g.b.l
    implements b<String, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$1$1"})
  static final class c
    extends d.g.b.l
    implements b<aln, Boolean>
  {
    c(f paramf, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$3$1"})
  static final class d
    extends d.g.b.l
    implements b<aln, Boolean>
  {
    d(f paramf, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.f
 * JD-Core Version:    0.7.0.1
 */