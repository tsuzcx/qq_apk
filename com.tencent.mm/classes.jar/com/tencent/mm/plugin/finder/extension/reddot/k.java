package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.co;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "finderRedDotExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getFinderRedDotExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "setFinderRedDotExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;)V", "showInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getShowInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "showRelationMap", "", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "cloneInstance", "containsPath", "", "path", "delete", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "isAsync", "findShowInfoByPath", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isShowInfoEmpty", "isValid", "parseEntranceExtInfo", "", "parseRedDotExtInfo", "removeDependentRelation", "parent", "childPath", "removeShowInfoWithPath", "Ljava/util/LinkedList;", "store", "toString", "Companion", "plugin-finder_release"})
public final class k
  extends co
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a tLn;
  public final ConcurrentHashMap<String, bdo> tLk;
  private final ConcurrentHashMap<String, List<String>> tLl;
  public bbj tLm;
  
  static
  {
    AppMethodBeat.i(178205);
    tLn = new a((byte)0);
    info = co.ajs();
    AppMethodBeat.o(178205);
  }
  
  public k()
  {
    AppMethodBeat.i(178204);
    this.tLk = new ConcurrentHashMap();
    this.tLl = new ConcurrentHashMap();
    this.tLm = new bbj();
    AppMethodBeat.o(178204);
  }
  
  private boolean a(final c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(243637);
    p.h(paramc, "storage");
    Object localObject = (CharSequence)this.field_ctrInfo.LKM;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
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
      Log.e("Finder.RedDotCtrInfo", this.field_tipsId + " is inValid");
      AppMethodBeat.o(243637);
      return false;
      i = 0;
      break;
    }
    label94:
    localObject = new k();
    bbi localbbi = new bbi();
    localbbi.priority = this.field_ctrInfo.priority;
    localbbi.type = this.field_ctrInfo.type;
    localbbi.LKL = this.field_ctrInfo.LKL;
    localbbi.GaM.addAll((Collection)this.field_ctrInfo.GaM);
    localbbi.LKM = this.field_ctrInfo.LKM;
    localbbi.pRN = this.field_ctrInfo.pRN;
    localbbi.feedId = this.field_ctrInfo.feedId;
    localbbi.LKN = this.field_ctrInfo.LKN;
    ((k)localObject).field_ctrInfo = localbbi;
    ((k)localObject).field_tipsId = this.field_tipsId;
    ((k)localObject).field_time = this.field_time;
    ((k)localObject).field_revokeId = this.field_revokeId;
    ((k)localObject).field_ctrType = this.field_ctrType;
    ((k)localObject).field_expiredTime = this.field_expiredTime;
    ((k)localObject).field_tipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
    paramc = (a)new f(this, paramc, (k)localObject);
    if (paramBoolean) {
      d.c("Finder.RedDotCtrInfo", (a)new e(paramc));
    }
    for (;;)
    {
      AppMethodBeat.o(243637);
      return true;
      paramc.invoke();
    }
  }
  
  private final void dby()
  {
    AppMethodBeat.i(243635);
    for (;;)
    {
      try
      {
        Object localObject = this.field_ctrInfo.LKL;
        if (localObject != null) {
          this.tLm.parseFrom(((com.tencent.mm.bw.b)localObject).zy);
        }
        if (this.tLm.tab_type == 0)
        {
          localObject = this.field_tipsShowEntranceExtInfo;
          this.tLm.tabTipsByPassInfo = ((FinderTipsShowEntranceExtInfo)localObject).tabTipsByPassInfo;
          this.tLm.username = ((FinderTipsShowEntranceExtInfo)localObject).username;
          this.tLm.tab_type = ((FinderTipsShowEntranceExtInfo)localObject).tab_type;
          this.tLm.object_id = ((FinderTipsShowEntranceExtInfo)localObject).object_id;
          this.tLm.object_nonce_id = ((FinderTipsShowEntranceExtInfo)localObject).object_nonce_id;
          StringBuilder localStringBuilder = new StringBuilder("[parseRedDotExtInfo] use old logic for FinderRedDotExtInfo. tabTipsByPassInfo=");
          if (((FinderTipsShowEntranceExtInfo)localObject).tabTipsByPassInfo != null)
          {
            bool = true;
            Log.i("Finder.RedDotManager", bool + " tipsId=" + this.field_tipsId);
            AppMethodBeat.o(243635);
          }
        }
        else
        {
          localObject = new StringBuilder("[parseRedDotExtInfo] tabTipsByPassInfo=");
          if (this.tLm.tabTipsByPassInfo != null)
          {
            bool = true;
            Log.i("Finder.RedDotManager", bool + " tipsId=" + this.field_tipsId);
            AppMethodBeat.o(243635);
            return;
          }
          bool = false;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        Log.printDebugStack("Finder.RedDotCtrInfo", "", new Object[] { localException });
        AppMethodBeat.o(243635);
        return;
      }
    }
  }
  
  private final void g(bbi parambbi)
  {
    AppMethodBeat.i(243636);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
    parambbi = parambbi.GaM;
    p.g(parambbi, "proto.show_infos");
    Iterator localIterator = ((Iterable)parambbi).iterator();
    while (localIterator.hasNext())
    {
      parambbi = (bdo)localIterator.next();
      if (parambbi.LNn == 1)
      {
        parambbi = parambbi.LNo;
        if (parambbi != null) {}
        for (parambbi = parambbi.zy;; parambbi = null)
        {
          localFinderTipsShowEntranceExtInfo.parseFrom(parambbi);
          break;
        }
      }
    }
    this.field_tipsShowEntranceExtInfo = localFinderTipsShowEntranceExtInfo;
    AppMethodBeat.o(243636);
  }
  
  private final void gJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    bdo localbdo = (bdo)this.tLk.get(paramString1);
    if ((localbdo == null) || (localbdo.LNm != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (List)this.tLl.get(paramString1);
    if (paramString1 != null)
    {
      p.g(paramString1, "list");
      d.a(paramString1, (kotlin.g.a.b)new b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  public final bdo atl(String paramString)
  {
    AppMethodBeat.i(178201);
    p.h(paramString, "path");
    paramString = (bdo)this.tLk.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final LinkedList<String> atm(final String paramString)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(178202);
    p.h(paramString, "path");
    final LinkedList localLinkedList = new LinkedList();
    ??? = (bdo)this.tLk.get(paramString);
    bdo localbdo;
    Object localObject2;
    String str;
    if ((??? != null) && (((bdo)???).LNm == 1))
    {
      localbdo = (bdo)this.tLk.remove(paramString);
      if (localbdo != null)
      {
        localLinkedList.add(paramString);
        ??? = (CharSequence)localbdo.Bvg;
        if ((??? == null) || (((CharSequence)???).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = localbdo.Bvg;
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = "";
          }
          str = localbdo.path;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          gJ((String)???, (String)localObject2);
          localObject2 = localbdo.Bvg;
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = "";
          }
          localLinkedList.addAll((Collection)atm((String)???));
        }
        ??? = this.field_ctrInfo.GaM;
        p.g(???, "field_ctrInfo.show_infos");
        j.c((List)???, (kotlin.g.a.b)new c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    if ((??? != null) && (((bdo)???).LNm == 2))
    {
      ??? = (List)this.tLl.get(paramString);
      if (??? == null) {
        break label553;
      }
    }
    label553:
    label558:
    label563:
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ((Iterable)???).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          if (!this.tLk.containsKey(str)) {
            break label563;
          }
          i = 1;
          break label563;
        }
        localObject2 = x.SXb;
        if (i == 0)
        {
          localbdo = (bdo)this.tLk.remove(paramString);
          if (localbdo != null)
          {
            localLinkedList.add(paramString);
            ??? = (CharSequence)localbdo.Bvg;
            i = j;
            if (??? != null)
            {
              if (((CharSequence)???).length() != 0) {
                break label558;
              }
              i = j;
            }
            if (i == 0)
            {
              localObject2 = localbdo.Bvg;
              ??? = localObject2;
              if (localObject2 == null) {
                ??? = "";
              }
              str = localbdo.path;
              localObject2 = str;
              if (str == null) {
                localObject2 = "";
              }
              gJ((String)???, (String)localObject2);
              localObject2 = localbdo.Bvg;
              ??? = localObject2;
              if (localObject2 == null) {
                ??? = "";
              }
              localLinkedList.addAll((Collection)atm((String)???));
            }
            ??? = this.field_ctrInfo.GaM;
            p.g(???, "field_ctrInfo.show_infos");
            j.c((List)???, (kotlin.g.a.b)new d(this, localLinkedList, paramString));
          }
        }
        AppMethodBeat.o(178202);
        return localLinkedList;
      }
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final boolean b(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(243640);
    p.h(paramc, "storage");
    this.field_ctrInfo.GaM.clear();
    this.tLk.clear();
    this.tLl.clear();
    paramBoolean = a(paramc, paramBoolean);
    AppMethodBeat.o(243640);
    return paramBoolean;
  }
  
  public final FinderTipsShowEntranceExtInfo dbx()
  {
    AppMethodBeat.i(243634);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo2 = this.field_tipsShowEntranceExtInfo;
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo1 = localFinderTipsShowEntranceExtInfo2;
    if (localFinderTipsShowEntranceExtInfo2 == null) {
      localFinderTipsShowEntranceExtInfo1 = new FinderTipsShowEntranceExtInfo();
    }
    AppMethodBeat.o(243634);
    return localFinderTipsShowEntranceExtInfo1;
  }
  
  public final boolean dbz()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.GaM;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      AppMethodBeat.o(178200);
      return true;
    }
    AppMethodBeat.o(178200);
    return false;
  }
  
  public final k f(bbi parambbi)
  {
    AppMethodBeat.i(178197);
    p.h(parambbi, "proto");
    this.field_ctrInfo = parambbi;
    this.field_ctrType = parambbi.type;
    this.field_expiredTime = parambbi.pRN;
    this.field_tipsId = parambbi.LKM;
    this.field_time = cl.aWA();
    g(parambbi);
    dby();
    this.field_revokeId = this.tLm.LKO;
    parambbi.feedId = this.tLm.object_id;
    Object localObject2 = new LinkedList();
    parambbi = this.field_ctrInfo.GaM;
    p.g(parambbi, "field_ctrInfo.show_infos");
    Object localObject3 = ((Iterable)parambbi).iterator();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bdo)((Iterator)localObject3).next();
      localObject5 = (Map)this.tLk;
      localObject1 = ((bdo)localObject4).path;
      parambbi = (bbi)localObject1;
      if (localObject1 == null) {
        parambbi = "";
      }
      p.g(localObject4, "it");
      ((Map)localObject5).put(parambbi, localObject4);
      if (((bdo)localObject4).LNm == 2)
      {
        localObject1 = (Map)this.tLl;
        parambbi = ((bdo)localObject4).path;
        if (parambbi != null) {
          break label409;
        }
        parambbi = "";
      }
    }
    label409:
    for (;;)
    {
      localObject5 = Collections.synchronizedList((List)new LinkedList());
      p.g(localObject5, "Collections.synchronizedList(LinkedList<String>())");
      ((Map)localObject1).put(parambbi, localObject5);
      ((LinkedList)localObject2).add(localObject4);
      break;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bdo)((Iterator)localObject2).next();
        parambbi = this.field_ctrInfo.GaM;
        p.g(parambbi, "field_ctrInfo.show_infos");
        localObject4 = ((Iterable)parambbi).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          parambbi = (bdo)((Iterator)localObject4).next();
          if (p.j(parambbi.Bvg, ((bdo)localObject3).path))
          {
            localObject5 = (List)((Map)this.tLl).get(((bdo)localObject3).path);
            if (localObject5 != null)
            {
              localObject1 = parambbi.path;
              parambbi = (bbi)localObject1;
              if (localObject1 == null) {
                parambbi = "";
              }
              ((List)localObject5).add(parambbi);
            }
          }
        }
      }
      AppMethodBeat.o(178197);
      return this;
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243639);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.GaM.size();
    AppMethodBeat.o(243639);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeDependentRelation$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    c(k paramk, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$3$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<bdo, Boolean>
  {
    d(k paramk, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(k paramk1, c paramc, k paramk2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.k
 * JD-Core Version:    0.7.0.1
 */