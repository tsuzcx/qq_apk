package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.dc;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "Lcom/tencent/mm/autogen/table/BaseFinderRedDotInfo;", "()V", "finderRedDotExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "getFinderRedDotExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "setFinderRedDotExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;)V", "showInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getShowInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "showRelationMap", "", "build", "proto", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "aiScene", "", "cloneInstance", "containsPath", "", "path", "delete", "storage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "isAsync", "findShowInfoByPath", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getTipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getType", "", "isAiRedDot", "isShowInfoEmpty", "isValid", "parseEntranceExtInfo", "", "parseRedDotExtInfo", "removeDependentRelation", "parent", "childPath", "removeShowInfoWithPath", "Ljava/util/LinkedList;", "isForceRemove", "store", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends dc
{
  public static final a ASw;
  private static final IAutoDBItem.MAutoDBInfo info;
  final ConcurrentHashMap<String, bxq> ASx;
  private final ConcurrentHashMap<String, List<String>> ASy;
  public btx ASz;
  
  static
  {
    AppMethodBeat.i(178205);
    ASw = new a((byte)0);
    info = dc.aJm();
    AppMethodBeat.o(178205);
  }
  
  public p()
  {
    AppMethodBeat.i(178204);
    this.ASx = new ConcurrentHashMap();
    this.ASy = new ConcurrentHashMap();
    this.ASz = new btx();
    AppMethodBeat.o(178204);
  }
  
  private boolean a(final MAutoStorage<p> paramMAutoStorage, boolean paramBoolean)
  {
    AppMethodBeat.i(366839);
    s.u(paramMAutoStorage, "storage");
    Object localObject = (CharSequence)this.field_ctrInfo.ZYN;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label81;
      }
      Log.e("Finder.RedDotCtrInfo", s.X(this.field_tipsId, " is inValid"));
      AppMethodBeat.o(366839);
      return false;
      i = 0;
      break;
    }
    label81:
    localObject = new p();
    btw localbtw = new btw();
    localbtw.priority = this.field_ctrInfo.priority;
    localbtw.type = this.field_ctrInfo.type;
    localbtw.aabz = this.field_ctrInfo.aabz;
    localbtw.aabA.addAll((Collection)this.field_ctrInfo.aabA);
    localbtw.ZYN = this.field_ctrInfo.ZYN;
    localbtw.wso = this.field_ctrInfo.wso;
    localbtw.feedId = this.field_ctrInfo.feedId;
    localbtw.aabD = this.field_ctrInfo.aabD;
    localbtw.start_time = this.field_ctrInfo.start_time;
    ah localah = ah.aiuX;
    ((p)localObject).field_ctrInfo = localbtw;
    ((p)localObject).field_aiScene = this.field_aiScene;
    ((p)localObject).field_tipsId = this.field_tipsId;
    ((p)localObject).field_time = this.field_time;
    ((p)localObject).field_revokeId = this.field_revokeId;
    ((p)localObject).field_ctrType = this.field_ctrType;
    ((p)localObject).field_expiredTime = this.field_expiredTime;
    ((p)localObject).field_tipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
    paramMAutoStorage = (a)new f(this, paramMAutoStorage, (p)localObject);
    if (paramBoolean) {
      d.e("Finder.RedDotCtrInfo", (a)new e(paramMAutoStorage));
    }
    for (;;)
    {
      AppMethodBeat.o(366839);
      return true;
      paramMAutoStorage.invoke();
    }
  }
  
  private final void eaw()
  {
    AppMethodBeat.i(366818);
    for (;;)
    {
      try
      {
        Object localObject = this.field_ctrInfo.aabz;
        if (localObject != null) {
          this.ASz.parseFrom(((com.tencent.mm.bx.b)localObject).Op);
        }
        if (this.ASz.tab_type == 0)
        {
          localObject = this.field_tipsShowEntranceExtInfo;
          this.ASz.tabTipsByPassInfo = ((FinderTipsShowEntranceExtInfo)localObject).tabTipsByPassInfo;
          this.ASz.username = ((FinderTipsShowEntranceExtInfo)localObject).username;
          btx localbtx = this.ASz;
          int i;
          if (((FinderTipsShowEntranceExtInfo)localObject).tab_type == 0)
          {
            i = -1;
            localbtx.tab_type = i;
            this.ASz.object_id = ((FinderTipsShowEntranceExtInfo)localObject).object_id;
            this.ASz.object_nonce_id = ((FinderTipsShowEntranceExtInfo)localObject).object_nonce_id;
            localObject = new StringBuilder("[parseRedDotExtInfo] use old logic username=").append(this.ASz.username).append(" object_id=").append(this.ASz.object_id).append(" tabTipsByPassInfo=");
            if (this.ASz.tabTipsByPassInfo != null)
            {
              bool = true;
              Log.i("Finder.RedDotCtrInfo", bool + " tipsId=" + this.field_tipsId);
              AppMethodBeat.o(366818);
            }
          }
          else
          {
            i = ((FinderTipsShowEntranceExtInfo)localObject).tab_type;
            continue;
          }
        }
        else
        {
          localObject = new StringBuilder("[parseRedDotExtInfo] username=").append(this.ASz.username).append(" object_id=").append(this.ASz.object_id).append(" tabTipsByPassInfo=");
          if (this.ASz.tabTipsByPassInfo != null)
          {
            bool = true;
            Log.i("Finder.RedDotCtrInfo", bool + " tipsId=" + this.field_tipsId);
            AppMethodBeat.o(366818);
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
        AppMethodBeat.o(366818);
        return;
      }
    }
  }
  
  private final void hI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178203);
    bxq localbxq = (bxq)this.ASx.get(paramString1);
    if ((localbxq == null) || (localbxq.aagq != 2))
    {
      AppMethodBeat.o(178203);
      return;
    }
    paramString1 = (List)this.ASy.get(paramString1);
    if (paramString1 != null) {
      d.a(paramString1, (kotlin.g.a.b)new p.b(paramString2));
    }
    AppMethodBeat.o(178203);
  }
  
  public final p a(btw parambtw, long paramLong)
  {
    AppMethodBeat.i(366900);
    s.u(parambtw, "proto");
    this.field_ctrInfo = parambtw;
    this.field_ctrType = parambtw.type;
    this.field_expiredTime = parambtw.wso;
    this.field_tipsId = parambtw.ZYN;
    this.field_aiScene = paramLong;
    if (this.field_time <= 0L) {
      this.field_time = cn.bDw();
    }
    h(parambtw);
    eaw();
    this.field_revokeId = this.ASz.aabE;
    parambtw.feedId = this.ASz.object_id;
    Object localObject2 = new LinkedList();
    parambtw = this.field_ctrInfo.aabA;
    s.s(parambtw, "field_ctrInfo.show_infos");
    Object localObject3 = ((Iterable)parambtw).iterator();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bxq)((Iterator)localObject3).next();
      localObject5 = (Map)this.ASx;
      localObject1 = ((bxq)localObject4).path;
      parambtw = (btw)localObject1;
      if (localObject1 == null) {
        parambtw = "";
      }
      s.s(localObject4, "it");
      ((Map)localObject5).put(parambtw, localObject4);
      if (((bxq)localObject4).aagq == 2)
      {
        localObject1 = (Map)this.ASy;
        parambtw = ((bxq)localObject4).path;
        if (parambtw == null) {
          parambtw = "";
        }
        for (;;)
        {
          localObject5 = Collections.synchronizedList((List)new LinkedList());
          s.s(localObject5, "synchronizedList(LinkedList<String>())");
          ((Map)localObject1).put(parambtw, localObject5);
          ((LinkedList)localObject2).add(localObject4);
          break;
        }
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bxq)((Iterator)localObject2).next();
      parambtw = this.field_ctrInfo.aabA;
      s.s(parambtw, "field_ctrInfo.show_infos");
      localObject4 = ((Iterable)parambtw).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        parambtw = (bxq)((Iterator)localObject4).next();
        if (s.p(parambtw.Nnp, ((bxq)localObject3).path))
        {
          localObject5 = (List)((Map)this.ASy).get(((bxq)localObject3).path);
          if (localObject5 != null)
          {
            localObject1 = parambtw.path;
            parambtw = (btw)localObject1;
            if (localObject1 == null) {
              parambtw = "";
            }
            ((List)localObject5).add(parambtw);
          }
        }
      }
    }
    AppMethodBeat.o(366900);
    return this;
  }
  
  public final boolean avJ(String paramString)
  {
    AppMethodBeat.i(366924);
    s.u(paramString, "path");
    if (this.ASx.get(paramString) != null)
    {
      AppMethodBeat.o(366924);
      return true;
    }
    AppMethodBeat.o(366924);
    return false;
  }
  
  public final bxq avK(String paramString)
  {
    AppMethodBeat.i(178201);
    s.u(paramString, "path");
    paramString = (bxq)this.ASx.get(paramString);
    AppMethodBeat.o(178201);
    return paramString;
  }
  
  public final boolean b(MAutoStorage<p> paramMAutoStorage, boolean paramBoolean)
  {
    AppMethodBeat.i(366921);
    s.u(paramMAutoStorage, "storage");
    this.field_ctrInfo.aabA.clear();
    this.ASx.clear();
    this.ASy.clear();
    paramBoolean = a(paramMAutoStorage, paramBoolean);
    AppMethodBeat.o(366921);
    return paramBoolean;
  }
  
  public final LinkedList<String> bt(String paramString, boolean paramBoolean)
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(366931);
    s.u(paramString, "path");
    LinkedList localLinkedList = new LinkedList();
    ??? = (bxq)this.ASx.get(paramString);
    bxq localbxq;
    if ((??? != null) && (((bxq)???).aagq == 1))
    {
      i = 1;
      if (i == 0) {
        break label264;
      }
      localbxq = (bxq)this.ASx.remove(paramString);
      if (localbxq != null)
      {
        localLinkedList.add(paramString);
        ??? = (CharSequence)localbxq.Nnp;
        i = k;
        if (??? != null) {
          if (((CharSequence)???).length() != 0) {
            break label259;
          }
        }
      }
    }
    Object localObject2;
    Object localObject3;
    label259:
    for (int i = k;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = localbxq.Nnp;
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = "";
        }
        localObject3 = localbxq.path;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        hI((String)???, (String)localObject2);
        localObject2 = localbxq.Nnp;
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = "";
        }
        localLinkedList.addAll((Collection)bt((String)???, false));
      }
      ??? = this.field_ctrInfo.aabA;
      s.s(???, "field_ctrInfo.show_infos");
      kotlin.a.p.e((List)???, (kotlin.g.a.b)new c(paramString));
      AppMethodBeat.o(366931);
      return localLinkedList;
      i = 0;
      break;
    }
    label264:
    if ((??? != null) && (((bxq)???).aagq == 2)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ??? = (List)this.ASy.get(paramString);
        if (??? == null) {
          break label708;
        }
      }
      label532:
      label691:
      label700:
      label705:
      label708:
      label713:
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          localObject2 = ((Iterable)???).iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if (!this.ASx.containsKey(localObject3)) {
              break label705;
            }
            i = 1;
            break label713;
          }
          localObject2 = ah.aiuX;
          if ((i != 0) && (!paramBoolean)) {
            break label691;
          }
          localbxq = (bxq)this.ASx.remove(paramString);
          if (localbxq == null) {
            break label691;
          }
          localLinkedList.add(paramString);
          if ((!paramBoolean) || (i == 0)) {
            break label532;
          }
          ??? = (List)this.ASy.get(paramString);
          if (??? == null) {
            break label532;
          }
          synchronized ((Iterable)???)
          {
            localObject2 = ((Iterable)???).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localObject3 = (bxq)this.ASx.get(localObject3);
              if (localObject3 == null) {
                continue;
              }
              ((bxq)localObject3).Nnp = "";
            }
          }
        }
        localObject2 = ah.aiuX;
        ??? = (CharSequence)localbxq.Nnp;
        i = j;
        if (??? != null) {
          if (((CharSequence)???).length() != 0) {
            break label700;
          }
        }
        for (i = j;; i = 0)
        {
          if (i == 0)
          {
            localObject2 = localbxq.Nnp;
            ??? = localObject2;
            if (localObject2 == null) {
              ??? = "";
            }
            localObject3 = localbxq.path;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            hI((String)???, (String)localObject2);
            localObject2 = localbxq.Nnp;
            ??? = localObject2;
            if (localObject2 == null) {
              ??? = "";
            }
            localLinkedList.addAll((Collection)bt((String)???, false));
          }
          ??? = this.field_ctrInfo.aabA;
          s.s(???, "field_ctrInfo.show_infos");
          kotlin.a.p.e((List)???, (kotlin.g.a.b)new d(paramString));
          AppMethodBeat.o(366931);
          return localLinkedList;
        }
        break label713;
        i = 0;
      }
    }
  }
  
  public final FinderTipsShowEntranceExtInfo eav()
  {
    AppMethodBeat.i(366890);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
    if (localFinderTipsShowEntranceExtInfo == null)
    {
      localFinderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
      AppMethodBeat.o(366890);
      return localFinderTipsShowEntranceExtInfo;
    }
    AppMethodBeat.o(366890);
    return localFinderTipsShowEntranceExtInfo;
  }
  
  public final boolean eax()
  {
    AppMethodBeat.i(178200);
    Collection localCollection = (Collection)this.field_ctrInfo.aabA;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      AppMethodBeat.o(178200);
      return true;
    }
    AppMethodBeat.o(178200);
    return false;
  }
  
  public final boolean eay()
  {
    return this.field_aiScene >= 10000L;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void h(btw parambtw)
  {
    AppMethodBeat.i(366904);
    s.u(parambtw, "proto");
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
    parambtw = parambtw.aabA;
    s.s(parambtw, "proto.show_infos");
    Iterator localIterator = ((Iterable)parambtw).iterator();
    while (localIterator.hasNext())
    {
      parambtw = (bxq)localIterator.next();
      if (parambtw.aagr == 1)
      {
        parambtw = parambtw.aags;
        if (parambtw == null) {}
        for (parambtw = null;; parambtw = parambtw.Op)
        {
          localFinderTipsShowEntranceExtInfo.parseFrom(parambtw);
          break;
        }
      }
    }
    parambtw = ah.aiuX;
    this.field_tipsShowEntranceExtInfo = localFinderTipsShowEntranceExtInfo;
    AppMethodBeat.o(366904);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366912);
    String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.aabA.size() + " displayTabType=" + this.ASz.tab_type;
    AppMethodBeat.o(366912);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo$Companion;", "", "()V", "TAG", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    c(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<bxq, Boolean>
  {
    d(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(p paramp1, MAutoStorage<p> paramMAutoStorage, p paramp2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.p
 * JD-Core Version:    0.7.0.1
 */