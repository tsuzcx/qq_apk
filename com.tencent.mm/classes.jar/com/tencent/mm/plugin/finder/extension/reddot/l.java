package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.c.cu;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bkn;
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
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "finderRedDotExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getFinderRedDotExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "setFinderRedDotExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;)V", "showInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getShowInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "showRelationMap", "", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "cloneInstance", "containsPath", "", "path", "delete", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "isAsync", "findShowInfoByPath", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isShowInfoEmpty", "isValid", "parseEntranceExtInfo", "", "parseRedDotExtInfo", "removeDependentRelation", "parent", "childPath", "removeShowInfoWithPath", "Ljava/util/LinkedList;", "store", "toString", "Companion", "plugin-finder_release"})
public final class l
  extends cu
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a xuN;
  final ConcurrentHashMap<String, bkn> xuK;
  private final ConcurrentHashMap<String, List<String>> xuL;
  public bhx xuM;
  
  static
  {
    AppMethodBeat.i(178205);
    xuN = new a((byte)0);
    info = cu.aoY();
    AppMethodBeat.o(178205);
  }
  
  public l()
  {
    AppMethodBeat.i(178204);
    this.xuK = new ConcurrentHashMap();
    this.xuL = new ConcurrentHashMap();
    this.xuM = new bhx();
    AppMethodBeat.o(178204);
  }
  
  private boolean a(final c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(291226);
    p.k(paramc, "storage");
    Object localObject = (CharSequence)this.field_ctrInfo.SQm;
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
      AppMethodBeat.o(291226);
      return false;
      i = 0;
      break;
    }
    label94:
    localObject = new l();
    bhw localbhw = new bhw();
    localbhw.priority = this.field_ctrInfo.priority;
    localbhw.type = this.field_ctrInfo.type;
    localbhw.SSl = this.field_ctrInfo.SSl;
    localbhw.MFx.addAll((Collection)this.field_ctrInfo.MFx);
    localbhw.SQm = this.field_ctrInfo.SQm;
    localbhw.tnN = this.field_ctrInfo.tnN;
    localbhw.feedId = this.field_ctrInfo.feedId;
    localbhw.SSo = this.field_ctrInfo.SSo;
    localbhw.SRZ = this.field_ctrInfo.SRZ;
    ((l)localObject).field_ctrInfo = localbhw;
    ((l)localObject).field_tipsId = this.field_tipsId;
    ((l)localObject).field_time = this.field_time;
    ((l)localObject).field_revokeId = this.field_revokeId;
    ((l)localObject).field_ctrType = this.field_ctrType;
    ((l)localObject).field_expiredTime = this.field_expiredTime;
    ((l)localObject).field_tipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
    paramc = (a)new f(this, paramc, (l)localObject);
    if (paramBoolean) {
      d.c("Finder.RedDotCtrInfo", (a)new e(paramc));
    }
    for (;;)
    {
      AppMethodBeat.o(291226);
      return true;
      paramc.invoke();
    }
  }
  
  private final void drH()
  {
    AppMethodBeat.i(291224);
    for (;;)
    {
      try
      {
        Object localObject = this.field_ctrInfo.SSl;
        if (localObject != null) {
          this.xuM.parseFrom(((com.tencent.mm.cd.b)localObject).UH);
        }
        if (this.xuM.tab_type == 0)
        {
          localObject = this.field_tipsShowEntranceExtInfo;
          this.xuM.tabTipsByPassInfo = ((FinderTipsShowEntranceExtInfo)localObject).tabTipsByPassInfo;
          this.xuM.username = ((FinderTipsShowEntranceExtInfo)localObject).username;
          this.xuM.tab_type = ((FinderTipsShowEntranceExtInfo)localObject).tab_type;
          this.xuM.object_id = ((FinderTipsShowEntranceExtInfo)localObject).object_id;
          this.xuM.object_nonce_id = ((FinderTipsShowEntranceExtInfo)localObject).object_nonce_id;
          StringBuilder localStringBuilder = new StringBuilder("[parseRedDotExtInfo] use old logic for FinderRedDotExtInfo. tabTipsByPassInfo=");
          if (((FinderTipsShowEntranceExtInfo)localObject).tabTipsByPassInfo != null)
          {
            bool = true;
            Log.i("Finder.RedDotManager", bool + " tipsId=" + this.field_tipsId);
            AppMethodBeat.o(291224);
          }
        }
        else
        {
          localObject = new StringBuilder("[parseRedDotExtInfo] tabTipsByPassInfo=");
          if (this.xuM.tabTipsByPassInfo != null)
          {
            bool = true;
            Log.i("Finder.RedDotManager", bool + " tipsId=" + this.field_tipsId);
            AppMethodBeat.o(291224);
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
        AppMethodBeat.o(291224);
        return;
      }
    }
  }
  
  private final void f(bhw parambhw)
  {
    AppMethodBeat.i(291225);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
    parambhw = parambhw.MFx;
    p.j(parambhw, "proto.show_infos");
    Iterator localIterator = ((Iterable)parambhw).iterator();
    while (localIterator.hasNext())
    {
      parambhw = (bkn)localIterator.next();
      if (parambhw.SVt == 1)
      {
        parambhw = parambhw.SVu;
        if (parambhw != null) {}
        for (parambhw = parambhw.UH;; parambhw = null)
        {
          localFinderTipsShowEntranceExtInfo.parseFrom(parambhw);
          break;
        }
      }
    }
    this.field_tipsShowEntranceExtInfo = localFinderTipsShowEntranceExtInfo;
    AppMethodBeat.o(291225);
  }
  
  private final void gX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    bkn localbkn = (bkn)this.xuK.get(paramString1);
    if ((localbkn == null) || (localbkn.SVs != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (List)this.xuL.get(paramString1);
    if (paramString1 != null)
    {
      p.j(paramString1, "list");
      d.a(paramString1, (kotlin.g.a.b)new b(paramString2));
      AppMethodBeat.o(178203);
      return;
    }
    AppMethodBeat.o(178203);
  }
  
  public final bkn aBy(String paramString)
  {
    AppMethodBeat.i(178201);
    p.k(paramString, "path");
    paramString = (bkn)this.xuK.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final LinkedList<String> aBz(final String paramString)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(178202);
    p.k(paramString, "path");
    final LinkedList localLinkedList = new LinkedList();
    ??? = (bkn)this.xuK.get(paramString);
    bkn localbkn;
    Object localObject2;
    String str;
    if ((??? != null) && (((bkn)???).SVs == 1))
    {
      localbkn = (bkn)this.xuK.remove(paramString);
      if (localbkn != null)
      {
        localLinkedList.add(paramString);
        ??? = (CharSequence)localbkn.HpB;
        if ((??? == null) || (((CharSequence)???).length() == 0)) {
          i = 1;
        }
        if (i == 0)
        {
          localObject2 = localbkn.HpB;
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = "";
          }
          str = localbkn.path;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          gX((String)???, (String)localObject2);
          localObject2 = localbkn.HpB;
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = "";
          }
          localLinkedList.addAll((Collection)aBz((String)???));
        }
        ??? = this.field_ctrInfo.MFx;
        p.j(???, "field_ctrInfo.show_infos");
        j.c((List)???, (kotlin.g.a.b)new c(this, localLinkedList, paramString));
      }
      AppMethodBeat.o(178202);
      return localLinkedList;
    }
    if ((??? != null) && (((bkn)???).SVs == 2))
    {
      ??? = (List)this.xuL.get(paramString);
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
          if (!this.xuK.containsKey(str)) {
            break label563;
          }
          i = 1;
          break label563;
        }
        localObject2 = x.aazN;
        if (i == 0)
        {
          localbkn = (bkn)this.xuK.remove(paramString);
          if (localbkn != null)
          {
            localLinkedList.add(paramString);
            ??? = (CharSequence)localbkn.HpB;
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
              localObject2 = localbkn.HpB;
              ??? = localObject2;
              if (localObject2 == null) {
                ??? = "";
              }
              str = localbkn.path;
              localObject2 = str;
              if (str == null) {
                localObject2 = "";
              }
              gX((String)???, (String)localObject2);
              localObject2 = localbkn.HpB;
              ??? = localObject2;
              if (localObject2 == null) {
                ??? = "";
              }
              localLinkedList.addAll((Collection)aBz((String)???));
            }
            ??? = this.field_ctrInfo.MFx;
            p.j(???, "field_ctrInfo.show_infos");
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
    AppMethodBeat.i(291229);
    p.k(paramc, "storage");
    this.field_ctrInfo.MFx.clear();
    this.xuK.clear();
    this.xuL.clear();
    paramBoolean = a(paramc, paramBoolean);
    AppMethodBeat.o(291229);
    return paramBoolean;
  }
  
  public final FinderTipsShowEntranceExtInfo drG()
  {
    AppMethodBeat.i(291223);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo2 = this.field_tipsShowEntranceExtInfo;
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo1 = localFinderTipsShowEntranceExtInfo2;
    if (localFinderTipsShowEntranceExtInfo2 == null) {
      localFinderTipsShowEntranceExtInfo1 = new FinderTipsShowEntranceExtInfo();
    }
    AppMethodBeat.o(291223);
    return localFinderTipsShowEntranceExtInfo1;
  }
  
  public final boolean drI()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.MFx;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      AppMethodBeat.o(178200);
      return true;
    }
    AppMethodBeat.o(178200);
    return false;
  }
  
  public final l e(bhw parambhw)
  {
    AppMethodBeat.i(178197);
    p.k(parambhw, "proto");
    this.field_ctrInfo = parambhw;
    this.field_ctrType = parambhw.type;
    this.field_expiredTime = parambhw.tnN;
    this.field_tipsId = parambhw.SQm;
    if (this.field_time <= 0L) {
      this.field_time = cm.bfE();
    }
    f(parambhw);
    drH();
    this.field_revokeId = this.xuM.SSp;
    parambhw.feedId = this.xuM.object_id;
    Object localObject2 = new LinkedList();
    parambhw = this.field_ctrInfo.MFx;
    p.j(parambhw, "field_ctrInfo.show_infos");
    Object localObject3 = ((Iterable)parambhw).iterator();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bkn)((Iterator)localObject3).next();
      localObject5 = (Map)this.xuK;
      localObject1 = ((bkn)localObject4).path;
      parambhw = (bhw)localObject1;
      if (localObject1 == null) {
        parambhw = "";
      }
      p.j(localObject4, "it");
      ((Map)localObject5).put(parambhw, localObject4);
      if (((bkn)localObject4).SVs == 2)
      {
        localObject1 = (Map)this.xuL;
        parambhw = ((bkn)localObject4).path;
        if (parambhw != null) {
          break label418;
        }
        parambhw = "";
      }
    }
    label418:
    for (;;)
    {
      localObject5 = Collections.synchronizedList((List)new LinkedList());
      p.j(localObject5, "Collections.synchronizedList(LinkedList<String>())");
      ((Map)localObject1).put(parambhw, localObject5);
      ((LinkedList)localObject2).add(localObject4);
      break;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bkn)((Iterator)localObject2).next();
        parambhw = this.field_ctrInfo.MFx;
        p.j(parambhw, "field_ctrInfo.show_infos");
        localObject4 = ((Iterable)parambhw).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          parambhw = (bkn)((Iterator)localObject4).next();
          if (p.h(parambhw.HpB, ((bkn)localObject3).path))
          {
            localObject5 = (List)((Map)this.xuL).get(((bkn)localObject3).path);
            if (localObject5 != null)
            {
              localObject1 = parambhw.path;
              parambhw = (bhw)localObject1;
              if (localObject1 == null) {
                parambhw = "";
              }
              ((List)localObject5).add(parambhw);
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
    AppMethodBeat.i(291228);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.MFx.size();
    AppMethodBeat.o(291228);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeDependentRelation$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    c(l paraml, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$removeShowInfoWithPath$3$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<bkn, Boolean>
  {
    d(l paraml, LinkedList paramLinkedList, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(l paraml1, c paramc, l paraml2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.l
 * JD-Core Version:    0.7.0.1
 */