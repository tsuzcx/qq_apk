package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "showInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "Lkotlin/collections/HashMap;", "getShowInfoMap", "()Ljava/util/HashMap;", "showRelationMap", "Ljava/util/LinkedList;", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "containsPath", "", "path", "delete", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "isAsync", "findShowInfoByPath", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isShowInfoEmpty", "isValid", "removeDependentRelation", "", "parent", "childPath", "removeShowInfoWithPath", "store", "toString", "Companion", "plugin-finder_release"})
public final class i
  extends cj
{
  private static final c.a info;
  public static final a sbG;
  final HashMap<String, ast> sbE;
  private final HashMap<String, LinkedList<String>> sbF;
  
  static
  {
    AppMethodBeat.i(178205);
    sbG = new a((byte)0);
    info = cj.VD();
    AppMethodBeat.o(178205);
  }
  
  public i()
  {
    AppMethodBeat.i(178204);
    this.sbE = new HashMap();
    this.sbF = new HashMap();
    AppMethodBeat.o(178204);
  }
  
  private boolean a(final c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(202107);
    p.h(paramc, "storage");
    CharSequence localCharSequence = (CharSequence)this.field_ctrInfo.GIg;
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
      ae.e("Finder.RedDotCtrInfo", this.field_tipsId + " is inValid");
      AppMethodBeat.o(202107);
      return false;
      i = 0;
      break;
    }
    label94:
    paramc = (a)new f(this, paramc);
    if (paramBoolean) {
      com.tencent.mm.ac.c.c("Finder.RedDotCtrInfo", (a)new e(paramc));
    }
    for (;;)
    {
      AppMethodBeat.o(202107);
      return true;
      paramc.invoke();
    }
  }
  
  private final void gq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    ast localast = (ast)this.sbE.get(paramString1);
    if ((localast == null) || (localast.GJM != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (LinkedList)this.sbF.get(paramString1);
    if (paramString1 != null)
    {
      p.g(paramString1, "list");
      j.c((List)paramString1, (d.g.a.b)new b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  public final ast aim(String paramString)
  {
    AppMethodBeat.i(178201);
    p.h(paramString, "path");
    paramString = (ast)this.sbE.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final LinkedList<String> ain(final String paramString)
  {
    int k = 0;
    int i = 0;
    AppMethodBeat.i(178202);
    p.h(paramString, "path");
    final LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (ast)this.sbE.get(paramString);
    ast localast;
    Object localObject2;
    String str;
    if ((localObject1 != null) && (((ast)localObject1).GJM == 1))
    {
      localast = (ast)this.sbE.remove(paramString);
      if (localast != null)
      {
        localLinkedList.add(paramString);
        localObject1 = (CharSequence)localast.xvd;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = localast.xvd;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          str = localast.path;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          gq((String)localObject1, (String)localObject2);
          localObject2 = localast.xvd;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localLinkedList.addAll((Collection)ain((String)localObject1));
        }
        localObject1 = this.field_ctrInfo.GIf;
        p.g(localObject1, "field_ctrInfo.show_infos");
        j.c((List)localObject1, (d.g.a.b)new c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    int j;
    if ((localObject1 != null) && (((ast)localObject1).GJM == 2))
    {
      localObject1 = (LinkedList)this.sbF.get(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label327;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.sbE.containsKey(localObject2)) {
          break label520;
        }
        i = 1;
      }
    }
    label520:
    for (;;)
    {
      break;
      j = 0;
      label327:
      if (j == 0)
      {
        localast = (ast)this.sbE.remove(paramString);
        if (localast != null)
        {
          localLinkedList.add(paramString);
          localObject1 = (CharSequence)localast.xvd;
          if (localObject1 != null)
          {
            i = k;
            if (((CharSequence)localObject1).length() != 0) {}
          }
          else
          {
            i = 1;
          }
          if (i == 0)
          {
            localObject2 = localast.xvd;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            str = localast.path;
            localObject2 = str;
            if (str == null) {
              localObject2 = "";
            }
            gq((String)localObject1, (String)localObject2);
            localObject2 = localast.xvd;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localLinkedList.addAll((Collection)ain((String)localObject1));
          }
          localObject1 = this.field_ctrInfo.GIf;
          p.g(localObject1, "field_ctrInfo.show_infos");
          j.c((List)localObject1, (d.g.a.b)new d(this, localLinkedList, paramString));
        }
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
  }
  
  public final i b(arj paramarj)
  {
    AppMethodBeat.i(178197);
    p.h(paramarj, "proto");
    this.field_ctrInfo = paramarj;
    this.field_tipsId = paramarj.GIg;
    this.field_time = ch.aDc();
    paramarj = paramarj.GIe;
    if (paramarj != null) {}
    try
    {
      localObject1 = new ark();
      ((ark)localObject1).parseFrom(paramarj.toByteArray());
      this.field_revokeId = ((ark)localObject1).GIi;
      localObject2 = new LinkedList();
      paramarj = this.field_ctrInfo.GIf;
      p.g(paramarj, "field_ctrInfo.show_infos");
      localObject3 = ((Iterable)paramarj).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ast)((Iterator)localObject3).next();
        localObject5 = (Map)this.sbE;
        localObject1 = ((ast)localObject4).path;
        paramarj = (arj)localObject1;
        if (localObject1 == null) {
          paramarj = "";
        }
        p.g(localObject4, "it");
        ((Map)localObject5).put(paramarj, localObject4);
        if (((ast)localObject4).GJM == 2)
        {
          localObject5 = (Map)this.sbF;
          localObject1 = ((ast)localObject4).path;
          paramarj = (arj)localObject1;
          if (localObject1 == null) {
            paramarj = "";
          }
          ((Map)localObject5).put(paramarj, new LinkedList());
          ((LinkedList)localObject2).add(localObject4);
        }
      }
    }
    catch (Exception paramarj)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        ae.l("Finder.RedDotCtrInfo", "", new Object[] { paramarj });
      }
      Object localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ast)((Iterator)localObject2).next();
        paramarj = this.field_ctrInfo.GIf;
        p.g(paramarj, "field_ctrInfo.show_infos");
        localObject4 = ((Iterable)paramarj).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          paramarj = (ast)((Iterator)localObject4).next();
          if (p.i(paramarj.xvd, ((ast)localObject3).path))
          {
            localObject5 = (LinkedList)((Map)this.sbF).get(((ast)localObject3).path);
            if (localObject5 != null)
            {
              localObject1 = paramarj.path;
              paramarj = (arj)localObject1;
              if (localObject1 == null) {
                paramarj = "";
              }
              ((LinkedList)localObject5).add(paramarj);
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
    AppMethodBeat.i(202110);
    p.h(paramc, "storage");
    this.field_ctrInfo.GIf.clear();
    this.sbE.clear();
    this.sbF.clear();
    paramBoolean = a(paramc, paramBoolean);
    AppMethodBeat.o(202110);
    return paramBoolean;
  }
  
  public final ass cBR()
  {
    AppMethodBeat.i(202106);
    ass localass2 = this.field_tipsShowEntranceExtInfo;
    ass localass1 = localass2;
    if (localass2 == null) {
      localass1 = new ass();
    }
    AppMethodBeat.o(202106);
    return localass1;
  }
  
  public final boolean cBS()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.GIf;
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
    AppMethodBeat.i(202109);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.GIf.size();
    AppMethodBeat.o(202109);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeDependentRelation$1$1"})
  static final class b
    extends q
    implements d.g.a.b<String, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$1$1"})
  static final class c
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    c(i parami, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$3$1"})
  static final class d
    extends q
    implements d.g.a.b<ast, Boolean>
  {
    d(i parami, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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