package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.c.a;
import com.tencent.d.a.a.a.b.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.b.a<Lcom.tencent.mm.protocal.protobuf.dzw;>;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.ee;
import com.tencent.mm.plugin.finder.cgi.ef;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.p.d;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.protocal.protobuf.goc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.ak;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;", "", "liveBuContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "bulletStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;)V", "allBoxes", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "getAllBoxes", "()Landroidx/lifecycle/MutableLiveData;", "setAllBoxes", "(Landroidx/lifecycle/MutableLiveData;)V", "boxMsgPollingHander", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler;", "getBoxMsgPollingHander", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler;", "setBoxMsgPollingHander", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler;)V", "boxRedDotPollingHandler", "getBoxRedDotPollingHandler", "setBoxRedDotPollingHandler", "getBulletStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "getLiveBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveId", "", "getLiveId", "()J", "msgNotifierMap", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$BoxMsgNotifier;", "getMsgNotifierMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "redDotMap", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxRedDotInfo;", "getRedDotMap", "setRedDotMap", "redDotPollingSwitch", "", "getRedDotPollingSwitch", "()Z", "setRedDotPollingSwitch", "(Z)V", "addMsg", "", "tag", "newList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "boxContext", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "boxMsgInfo", "notifier", "debugLog", "str", "enterBox", "boxId", "firstBox", "getBoxMsgInfo", "getDataListForAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertLocal", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "prepare", "useLastBoxDefault", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "setMsgNotifier", "startPollingMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "startPollingRedDot", "stopPollingMsg", "stopPollingRedDot", "updateLikeMsg", "updateInfo", "selfOp", "updateLocalLike", "updateLocalSeq", "BoxMsgNotifier", "Companion", "MsgPollingTask", "NotifyMsg", "RedDotPollingTask", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final String TAG;
  public static final b akgm;
  private static final List<Integer> akgu;
  final com.tencent.mm.plugin.finder.live.model.context.a CMl;
  final c akgn;
  public x<ConcurrentHashMap<String, h>> akgo;
  public final ConcurrentHashMap<String, a> akgp;
  public x<ConcurrentHashMap<String, i>> akgq;
  public boolean akgr;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.p akgs;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.p akgt;
  
  static
  {
    AppMethodBeat.i(371751);
    akgm = new b((byte)0);
    TAG = "Finder.BoxDataStore";
    akgu = kotlin.a.p.listOf(new Integer[] { Integer.valueOf(20057), Integer.valueOf(20034), Integer.valueOf(20035), Integer.valueOf(20002) });
    AppMethodBeat.o(371751);
  }
  
  public f(com.tencent.mm.plugin.finder.live.model.context.a parama, c paramc)
  {
    AppMethodBeat.i(371695);
    this.CMl = parama;
    this.akgn = paramc;
    this.akgo = new x(new ConcurrentHashMap());
    this.akgp = new ConcurrentHashMap();
    this.akgq = new x(new ConcurrentHashMap());
    this.akgr = true;
    AppMethodBeat.o(371695);
  }
  
  public static void G(String paramString)
  {
    AppMethodBeat.i(371742);
    Log.i(TAG, s.X("boxDebugLog, ", paramString));
    AppMethodBeat.o(371742);
  }
  
  private static boolean a(String paramString, anc paramanc, h paramh, bdm parambdm, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(371727);
    Object localObject1 = (com.tencent.mm.bx.a)new etk();
    parambdm = parambdm.ZNY;
    if (parambdm == null) {
      parambdm = null;
    }
    Object localObject2;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom(parambdm);
      parambdm = (bdm)localObject1;
    }
    catch (Exception parambdm)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        Log.printDebugStack("safeParser", "", new Object[] { parambdm });
        parambdm = null;
        continue;
        j = 0;
        continue;
        i += 1;
        continue;
        int i = -1;
        continue;
        paramBoolean = false;
      }
      paramString = bq.akii;
      bq.rT(TAG, "update seq:" + ((b)localObject1).akfZ.seq + ", duplicate");
      AppMethodBeat.o(371727);
      return false;
    }
    parambdm = (etk)parambdm;
    int j;
    if (parambdm != null)
    {
      localObject1 = (List)paramh.pUj;
      i = 0;
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label648;
      }
      if (((b)((Iterator)localObject1).next()).akfZ.seq != parambdm.abWe) {
        break label633;
      }
      j = 1;
      if (j == 0) {
        break label639;
      }
      if (i >= 0)
      {
        localObject1 = (b)kotlin.a.p.ae((List)paramh.pUj, i);
        if (localObject1 != null)
        {
          if (!paramBoolean) {
            break label708;
          }
          j = parambdm.YAN;
          localObject2 = c.a.akmY;
          if (j != c.a.a.kMH()) {
            break label654;
          }
          paramBoolean = true;
          if (((b)localObject1).akga == paramBoolean) {
            break label660;
          }
          ((b)localObject1).akga = paramBoolean;
          ((b)localObject1).likeCount = parambdm.akkK;
          localObject2 = bq.akii;
          bq.rT(TAG, "update seq:" + ((b)localObject1).akfZ.seq + ", selfLike:" + paramBoolean + ", likeCount:" + ((b)localObject1).likeCount);
          label251:
          if ((((b)localObject1).akga) && (((b)localObject1).likeCount <= 0)) {
            ((b)localObject1).likeCount = 1;
          }
          if (paramanc != null)
          {
            paramanc = paramanc.akjP;
            if (paramanc != null)
            {
              localObject2 = ((Iterable)paramanc).iterator();
              label297:
              if (!((Iterator)localObject2).hasNext()) {
                break label775;
              }
              paramanc = ((Iterator)localObject2).next();
              localObject3 = (anf)paramanc;
              l = ((b)localObject1).akfZ.seq;
              localObject3 = ((anf)localObject3).akfZ;
              if ((localObject3 == null) || (l != ((bdm)localObject3).seq)) {
                break label769;
              }
              j = 1;
              label357:
              if (j == 0) {
                break label773;
              }
              label362:
              paramanc = (anf)paramanc;
              if (paramanc != null)
              {
                paramanc.likeCount = ((b)localObject1).likeCount;
                paramanc.akga = ((b)localObject1).akga;
                localObject2 = bq.akii;
                localObject2 = TAG;
                localObject3 = new StringBuilder("updateLikeMsg seq:");
                paramanc = paramanc.akfZ;
                if (paramanc != null) {
                  break label780;
                }
              }
            }
          }
        }
      }
    }
    label648:
    label780:
    for (paramanc = null;; paramanc = Long.valueOf(paramanc.seq))
    {
      bq.rQ((String)localObject2, paramanc + " likeCount:" + ((b)localObject1).likeCount + ", selfLike:" + ((b)localObject1).akga);
      G(paramString + ", boxCommentLikeTrack update likeCount:" + parambdm.akkK + ", show:" + parambdm.akkL + ", for " + ((b)localObject1).eYN());
      G(paramString + ", notifier update index:" + i + ", msg:" + ((b)localObject1).eYN());
      if (parama != null) {
        parama.c(new d(paramh.adma, i, 1, Integer.valueOf(101)));
      }
      AppMethodBeat.o(371727);
      return true;
      parambdm = parambdm.toByteArray();
      break;
      label633:
      label639:
      ((b)localObject1).likeCount = parambdm.akkK;
      label654:
      label660:
      label708:
      localObject2 = bq.akii;
      bq.rT(TAG, "update seq:" + ((b)localObject1).akfZ.seq + ", svr, likeCount:" + ((b)localObject1).likeCount);
      break label251;
      j = 0;
      break label357;
      break label297;
      paramanc = null;
      break label362;
    }
  }
  
  private long getLiveId()
  {
    AppMethodBeat.i(371705);
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    AppMethodBeat.o(371705);
    return l;
  }
  
  public final void a(bfv parambfv, anc paramanc, bui parambui)
  {
    AppMethodBeat.i(371761);
    s.u(parambfv, "boxId");
    s.u(paramanc, "boxContext");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("startPollingMsg, boxId:").append(parambfv.id).append(", boxContext ");
    bq localbq = bq.akii;
    Log.i(str, bq.c(paramanc) + ", " + paramanc.ZEQ);
    kLe();
    this.akgs = new com.tencent.mm.plugin.finder.live.viewmodel.data.p((p.d)new c(parambfv, paramanc, parambui), (kotlin.d.f)bg.kCi());
    parambfv = this.akgs;
    if (parambfv != null) {
      parambfv.start();
    }
    AppMethodBeat.o(371761);
  }
  
  public final Object b(String paramString, boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(371756);
    if ((paramd instanceof l))
    {
      localObject1 = (l)paramd;
      if ((((l)localObject1).label & 0x80000000) != 0) {
        ((l)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new l(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(371756);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = (ConcurrentHashMap)this.akgo.getValue();
    Object localObject3 = paramd;
    Object localObject2 = this;
    Object localObject4 = paramString;
    boolean bool = paramBoolean;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      localObject1 = paramString;
      paramString = this;
      localObject3 = paramd;
      localObject2 = paramString;
      localObject4 = localObject1;
      bool = paramBoolean;
      if (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        localObject3 = e.akgh;
        localObject2 = ((h)((Map.Entry)localObject2).getValue()).akgL;
        paramd.L$0 = paramString;
        paramd.Uf = localObject1;
        paramd.VC = localIterator;
        paramd.YF = paramBoolean;
        paramd.label = 1;
        if (e.a("prepare", (anc)localObject2, paramd) != locala) {
          break label695;
        }
        AppMethodBeat.o(371756);
        return locala;
        paramBoolean = paramd.YF;
        localIterator = (Iterator)paramd.VC;
        localObject2 = (String)paramd.Uf;
        paramString = (f)paramd.L$0;
        ResultKt.throwOnFailure(localObject1);
        localObject1 = localObject2;
      }
    }
    label655:
    label695:
    for (;;)
    {
      break;
      paramString = (ConcurrentHashMap)((f)localObject2).akgo.getValue();
      if (paramString != null) {
        paramString.clear();
      }
      paramString = (CharSequence)localObject4;
      int i;
      if ((paramString == null) || (paramString.length() == 0)) {
        i = 1;
      }
      while ((i != 0) && (bool))
      {
        paramString = new ArrayList();
        paramd = e.akgh;
        paramString.addAll((Collection)e.Cu(((f)localObject2).getLiveId()));
        paramd = (List)paramString;
        if (paramd.size() > 1) {
          kotlin.a.p.a(paramd, (Comparator)new k());
        }
        paramString = (anc)kotlin.a.p.oL((List)paramString);
        if (paramString != null)
        {
          paramd = bq.akii;
          bq.a(((f)localObject2).akgo, (kotlin.g.a.b)new m(paramString));
          paramString = ah.aiuX;
          AppMethodBeat.o(371756);
          return paramString;
          i = 0;
        }
        else
        {
          paramString = (f)localObject2;
          Log.i(TAG, s.X("prepare no exist recent box for liveId:", com.tencent.mm.ae.d.hF(paramString.getLiveId())));
        }
      }
      for (;;)
      {
        paramString = bq.akii;
        bq.a(((f)localObject2).akgo);
        paramString = ah.aiuX;
        AppMethodBeat.o(371756);
        return paramString;
        paramString = (CharSequence)localObject4;
        if ((paramString == null) || (paramString.length() == 0)) {}
        for (i = 1; i == 0; i = 0)
        {
          paramString = e.akgh;
          long l = ((f)localObject2).getLiveId();
          ((l)localObject3).L$0 = localObject2;
          ((l)localObject3).Uf = null;
          ((l)localObject3).VC = null;
          ((l)localObject3).label = 2;
          paramd = paramString.a("prepare", l, (String)localObject4, (kotlin.d.d)localObject3);
          paramString = paramd;
          if (paramd != locala) {
            break label655;
          }
          AppMethodBeat.o(371756);
          return locala;
        }
      }
      localObject2 = (f)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramString = (String)localObject1;
      paramString = (anc)paramString;
      paramd = bq.akii;
      bq.a(((f)localObject2).akgo, (kotlin.g.a.b)new f.n(paramString));
      paramString = ah.aiuX;
      AppMethodBeat.o(371756);
      return paramString;
    }
  }
  
  public final void bkI(String paramString)
  {
    AppMethodBeat.i(371757);
    s.u(paramString, "boxId");
    long l = cn.bDw();
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.akgo.getValue();
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(paramString) == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.akgo.getValue();
      if (localConcurrentHashMap == null) {
        break label143;
      }
      paramString = (h)localConcurrentHashMap.get(paramString);
      if (paramString == null) {
        break label143;
      }
      paramString.adlC = l;
      paramString.akgL.adlC = l;
      AppMethodBeat.o(371757);
      return;
    }
    Log.e(TAG, "enterBox without prepare");
    if (ak.aiuY)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(371757);
      throw paramString;
    }
    label143:
    AppMethodBeat.o(371757);
  }
  
  public final h bkJ(String paramString)
  {
    AppMethodBeat.i(371759);
    s.u(paramString, "boxId");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.akgo.getValue();
    if (localConcurrentHashMap == null)
    {
      AppMethodBeat.o(371759);
      return null;
    }
    paramString = (h)localConcurrentHashMap.get(paramString);
    AppMethodBeat.o(371759);
    return paramString;
  }
  
  public final boolean c(bdm parambdm)
  {
    AppMethodBeat.i(371760);
    s.u(parambdm, "updateInfo");
    Object localObject1 = parambdm.akjQ;
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label86;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = bkJ((String)localObject1);
        if (localObject2 == null)
        {
          AppMethodBeat.o(371760);
          return false;
          localObject1 = ((bfv)localObject1).id;
          break;
          label86:
          i = 0;
          continue;
        }
        localObject1 = (a)this.akgp.get(localObject1);
        boolean bool = a("selfLike", ((h)localObject2).akgL, (h)localObject2, parambdm, (a)localObject1, true);
        AppMethodBeat.o(371760);
        return bool;
      }
    }
    AppMethodBeat.o(371760);
    return false;
  }
  
  public final h kLd()
  {
    AppMethodBeat.i(371752);
    Object localObject = (ConcurrentHashMap)this.akgo.getValue();
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (h)((Map.Entry)((Iterator)localObject).next()).getValue();
        AppMethodBeat.o(371752);
        return localObject;
      }
    }
    AppMethodBeat.o(371752);
    return null;
  }
  
  public final void kLe()
  {
    AppMethodBeat.i(371762);
    Log.i(TAG, "stopPollingMsg");
    com.tencent.mm.plugin.finder.live.viewmodel.data.p localp = this.akgs;
    if (localp != null) {
      localp.stopAsync();
    }
    AppMethodBeat.o(371762);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$BoxMsgNotifier;", "", "notifyAdd", "", "notifyMsg", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$NotifyMsg;", "notifyRemove", "notifyUpdate", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(f.d paramd);
    
    public abstract void b(f.d paramd);
    
    public abstract void c(f.d paramd);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$Companion;", "", "()V", "DefaultInterval", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "ValidMsgType", "", "", "getValidMsgType", "()Ljava/util/List;", "toBoxMsgInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "toStoreData", "Lcom/tencent/mm/protocal/protobuf/BoxMsg;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "toUIData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static h b(anc paramanc)
    {
      AppMethodBeat.i(371674);
      s.u(paramanc, "<this>");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramanc.akjP;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label238;
        }
        localObject1 = (Collection)ab.aivy;
        label44:
        localArrayList.addAll((Collection)localObject1);
        localObject1 = paramanc.Don;
        if (localObject1 != null) {
          break label246;
        }
        localObject1 = "";
      }
      for (;;)
      {
        paramanc = new h((String)localObject1, localArrayList, paramanc.adlC, paramanc);
        AppMethodBeat.o(371674);
        return paramanc;
        localObject1 = (Iterable)localObject1;
        Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (localIterator.hasNext())
        {
          anf localanf = (anf)localIterator.next();
          localObject1 = f.akgm;
          s.s(localanf, "it");
          s.u(localanf, "<this>");
          localObject1 = localanf.akfZ;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = d((bdm)localObject1))
          {
            if (localObject1 != null) {
              ((b)localObject1).hJv = localanf.hJv;
            }
            if (localObject1 != null) {
              ((b)localObject1).likeCount = localanf.likeCount;
            }
            if (localObject1 != null) {
              ((b)localObject1).akga = localanf.akga;
            }
            ((Collection)localObject2).add(localObject1);
            break;
          }
        }
        localObject1 = kotlin.a.p.l((Iterable)localObject2);
        break;
        label238:
        localObject1 = (Collection)localObject1;
        break label44;
        label246:
        localObject2 = ((bfv)localObject1).id;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    
    public static b d(bdm parambdm)
    {
      AppMethodBeat.i(371663);
      s.u(parambdm, "<this>");
      switch (parambdm.msg_type)
      {
      default: 
        AppMethodBeat.o(371663);
        return null;
      case 20057: 
        parambdm = (b)new m(parambdm);
        AppMethodBeat.o(371663);
        return parambdm;
      case 20032: 
      case 20034: 
        parambdm = (b)new a(parambdm);
        AppMethodBeat.o(371663);
        return parambdm;
      case 20035: 
        parambdm = (b)new j(parambdm);
        AppMethodBeat.o(371663);
        return parambdm;
      }
      parambdm = (b)new k(parambdm);
      AppMethodBeat.o(371663);
      return parambdm;
    }
    
    public static anf g(b paramb)
    {
      AppMethodBeat.i(371667);
      s.u(paramb, "<this>");
      anf localanf = new anf();
      localanf.akfZ = paramb.akfZ;
      localanf.hJv = paramb.hJv;
      localanf.likeCount = paramb.likeCount;
      localanf.akga = paramb.akga;
      AppMethodBeat.o(371667);
      return localanf;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$MsgPollingTask;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$CgiTask;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFriendBoxLiveMsgResp;", "boxId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "boxContext", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;Lcom/tencent/mm/protocal/protobuf/BoxContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getBoxContext", "()Lcom/tencent/mm/protocal/protobuf/BoxContext;", "getBoxId", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "filterBulletMsg", "", "Lcom/tencent/mm/protocal/protobuf/BoxBulletComment;", "msgList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "filterUpdateMsg", "appMsgList", "Ljava/util/LinkedList;", "filterValidMsg", "generateCgi", "Lcom/tencent/mm/modelbase/Cgi;", "processResp", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "cgi", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "updateData", "", "needClear", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "updateList", "bulletList", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends p.b<dzw>
  {
    private final bui Auc;
    final bfv Don;
    final anc akgv;
    
    public c(anc paramanc, bui parambui)
    {
      AppMethodBeat.i(371662);
      this.Don = paramanc;
      this.akgv = parambui;
      Object localObject;
      this.Auc = localObject;
      AppMethodBeat.o(371662);
    }
    
    private static List<bdm> cC(LinkedList<bdm> paramLinkedList)
    {
      AppMethodBeat.i(371668);
      Object localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label77:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((bdm)localObject2).msg_type == 20062) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label77;
          }
          paramLinkedList.add(localObject2);
          break;
        }
      }
      paramLinkedList = (List)paramLinkedList;
      AppMethodBeat.o(371668);
      return paramLinkedList;
    }
    
    public final p.c a(final com.tencent.mm.am.b<dzw> paramb, final b.a<dzw> parama)
    {
      AppMethodBeat.i(371684);
      s.u(paramb, "cgi");
      s.u(parama, "cgiBack");
      long l;
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        dzw localdzw = (dzw)parama.ott;
        if (localdzw != null)
        {
          l = localdzw.akkG;
          parama = localdzw.ZJV;
          s.s(parama, "resp.app_msg_list");
          Object localObject2 = ((Iterable)parama).iterator();
          bdm localbdm;
          while (((Iterator)localObject2).hasNext())
          {
            localbdm = (bdm)((Iterator)localObject2).next();
            if (localbdm.akjQ == null)
            {
              parama = bq.akii;
              localObject1 = ((ef)paramb).Don.id;
              parama = (b.a<dzw>)localObject1;
              if (localObject1 == null) {
                parama = "";
              }
              localbdm.akjQ = bq.bLz(parama);
            }
          }
          paramb = localdzw.ZJV;
          s.s(paramb, "appMsgList");
          Object localObject1 = (Iterable)paramb;
          parama = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            localbdm = (bdm)localObject2;
            f.b localb = f.akgm;
            if (f.kLf().contains(Integer.valueOf(localbdm.msg_type))) {
              parama.add(localObject2);
            }
          }
          parama = (List)parama;
          paramb = cC(paramb);
          localObject1 = (List)ab.aivy;
          localObject2 = localdzw.ZEQ;
          kotlinx.coroutines.k.x((kotlin.g.a.m)new a(this, localdzw.akkI, (com.tencent.mm.bx.b)localObject2, parama, paramb, (List)localObject1, null));
        }
      }
      for (;;)
      {
        paramb = new p.c(true, l);
        AppMethodBeat.o(371684);
        return paramb;
        l = 1000L;
      }
    }
    
    public final com.tencent.mm.am.b<dzw> jKw()
    {
      AppMethodBeat.i(371672);
      Object localObject = bq.akii;
      f.bkK(s.X("lxltest boxContext: ", bq.c(this.akgv)));
      localObject = (com.tencent.mm.am.b)new ef(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, this.Don, this.akgv.ZEQ, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, this.Auc);
      AppMethodBeat.o(371672);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(f.c paramc, boolean paramBoolean, com.tencent.mm.bx.b paramb, List<? extends bdm> paramList1, List<? extends bdm> paramList2, List<? extends anb> paramList, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(371733);
        paramObject = (kotlin.d.d)new a(this.akgx, this.akgy, this.AEL, parama, paramb, this.akgA, paramd);
        AppMethodBeat.o(371733);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(371725);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(371725);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.f)bg.kCh();
          kotlin.g.a.m localm = (kotlin.g.a.m)new f.c.a.1(this.akgx, this.akgy, this.AEL, parama, paramb, this.akgA, null);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (l.a(paramObject, localm, locald) == locala)
          {
            AppMethodBeat.o(371725);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(371725);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$NotifyMsg;", "", "boxId", "", "start", "", "count", "payload", "(Ljava/lang/String;IILjava/lang/Object;)V", "getBoxId", "()Ljava/lang/String;", "getCount", "()I", "getPayload", "()Ljava/lang/Object;", "getStart", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public static final a akgB;
    private final String adma;
    public final Object bUn;
    public final int count;
    public final int start;
    
    static
    {
      AppMethodBeat.i(371661);
      akgB = new a((byte)0);
      AppMethodBeat.o(371661);
    }
    
    public d(String paramString, int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(371656);
      this.adma = paramString;
      this.start = paramInt1;
      this.count = paramInt2;
      this.bUn = paramObject;
      AppMethodBeat.o(371656);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(371664);
      String str = "start:" + this.start + ", count:" + this.count + ", payload:" + this.bUn;
      AppMethodBeat.o(371664);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$NotifyMsg$Companion;", "", "()V", "NOTIFY_BASE", "", "NOTIFY_MSG_LIKE_UPDATE", "NOTIFY_MSG_SEQ_UPDATE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore$RedDotPollingTask;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$BatchCgiTask;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetBoxMsgTipsResp;", "boxContext", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxDataStore;Lcom/tencent/mm/protocal/protobuf/BoxContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getBoxContext", "()Lcom/tencent/mm/protocal/protobuf/BoxContext;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "generateCgi", "", "Lcom/tencent/mm/modelbase/Cgi;", "processResp", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "cgi", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends p.a<goc>
  {
    private final bui Auc;
    private final anc akgv;
    
    public e(bui parambui)
    {
      AppMethodBeat.i(371659);
      this.akgv = parambui;
      Object localObject;
      this.Auc = localObject;
      AppMethodBeat.o(371659);
    }
    
    public final p.c a(final com.tencent.mm.am.b<goc> paramb, b.a<goc> parama)
    {
      AppMethodBeat.i(371671);
      s.u(paramb, "cgi");
      s.u(parama, "cgiBack");
      long l;
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        parama = (goc)parama.ott;
        if (parama != null)
        {
          final f localf = f.this;
          l = parama.akkG;
          Object localObject = bq.akii;
          localObject = f.akgm;
          localObject = f.access$getTAG$cp();
          LinkedList localLinkedList = parama.akkN;
          s.s(localLinkedList, "resp.box_readdot_list");
          bq.rS((String)localObject, s.X("polling reddot resp, ", kotlin.a.p.a((Iterable)localLinkedList, null, null, null, 0, null, (kotlin.g.a.b)a.akgC, 31)));
          if (parama.akkN.size() > 0) {
            kotlinx.coroutines.k.x((kotlin.g.a.m)new b(parama, localf, paramb, null));
          }
        }
      }
      for (;;)
      {
        paramb = new p.c(true, l);
        AppMethodBeat.o(371671);
        return paramb;
        l = 1000L;
      }
    }
    
    public final List<com.tencent.mm.am.b<goc>> jKv()
    {
      AppMethodBeat.i(371665);
      Object localObject1 = new ArrayList();
      if (!f.this.akgr)
      {
        localObject1 = (List)localObject1;
        AppMethodBeat.o(371665);
        return localObject1;
      }
      Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      Object localObject3 = new ArrayList();
      Object localObject4 = new and();
      ((and)localObject4).akjQ = this.akgv.Don;
      ((and)localObject4).ZEQ = this.akgv.ZEQ;
      ah localah = ah.aiuX;
      ((ArrayList)localObject3).add(localObject4);
      localObject4 = ah.aiuX;
      ((ArrayList)localObject1).add(new ee((byte[])localObject2, l1, l2, (List)localObject3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)f.this.CMl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC, this.Auc));
      localObject2 = bq.akii;
      localObject2 = f.akgm;
      localObject2 = f.access$getTAG$cp();
      localObject3 = bq.akii;
      bq.rS((String)localObject2, s.X("polling reddot, boxContext ", bq.c(this.akgv)));
      localObject1 = (List)localObject1;
      AppMethodBeat.o(371665);
      return localObject1;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BoxIdAndReaddot;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<ane, CharSequence>
    {
      public static final a akgC;
      
      static
      {
        AppMethodBeat.i(371635);
        akgC = new a();
        AppMethodBeat.o(371635);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(goc paramgoc, f paramf, com.tencent.mm.am.b<goc> paramb, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(371642);
        paramObject = (kotlin.d.d)new b(this.akgD, localf, paramb, paramd);
        AppMethodBeat.o(371642);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(371637);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(371637);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.f)bg.kCh();
          kotlin.g.a.m localm = (kotlin.g.a.m)new kotlin.d.b.a.k(this.akgD, localf)
          {
            int label;
            
            public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(371645);
              paramAnonymousObject = (kotlin.d.d)new 1(this.akgD, this.akgw, this.akfR, paramAnonymousd);
              AppMethodBeat.o(371645);
              return paramAnonymousObject;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(371640);
              Object localObject1 = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(371640);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = this.akgD.akkN;
              if (paramAnonymousObject != null)
              {
                paramAnonymousObject = (Iterable)paramAnonymousObject;
                com.tencent.mm.am.b localb = this.akfR;
                f localf = this.akgw;
                Iterator localIterator = paramAnonymousObject.iterator();
                while (localIterator.hasNext())
                {
                  ane localane = (ane)localIterator.next();
                  if (localane.muH)
                  {
                    label134:
                    label140:
                    Object localObject2;
                    Object localObject3;
                    if ((localb instanceof ee))
                    {
                      paramAnonymousObject = (ee)localb;
                      if (paramAnonymousObject != null) {
                        break label266;
                      }
                      paramAnonymousObject = null;
                      localObject1 = bq.akii;
                      localObject1 = f.akgm;
                      localObject2 = f.access$getTAG$cp();
                      localObject3 = new StringBuilder("get box redDot, boxId: ");
                      localObject1 = localane.akjQ;
                      if (localObject1 != null) {
                        break label388;
                      }
                      localObject1 = null;
                      label175:
                      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", lastBuffer:");
                      if (paramAnonymousObject != null) {
                        break label396;
                      }
                      localObject1 = null;
                      label194:
                      bq.rS((String)localObject2, localObject1);
                      localObject3 = (ConcurrentHashMap)localf.akgq.getValue();
                      if (localObject3 == null) {
                        continue;
                      }
                      localObject1 = localane.akjQ;
                      if (localObject1 != null) {
                        break label408;
                      }
                      localObject1 = "";
                    }
                    for (;;)
                    {
                      ((ConcurrentHashMap)localObject3).put(localObject1, new i(localane.muH, paramAnonymousObject));
                      break;
                      paramAnonymousObject = null;
                      break label134;
                      label266:
                      paramAnonymousObject = paramAnonymousObject.ynl;
                      if (paramAnonymousObject == null)
                      {
                        paramAnonymousObject = null;
                        break label140;
                      }
                      localObject3 = ((Iterable)paramAnonymousObject).iterator();
                      label291:
                      if (((Iterator)localObject3).hasNext())
                      {
                        localObject2 = ((Iterator)localObject3).next();
                        paramAnonymousObject = ((and)localObject2).akjQ;
                        if (paramAnonymousObject == null)
                        {
                          paramAnonymousObject = null;
                          label323:
                          localObject1 = localane.akjQ;
                          if (localObject1 != null) {
                            break label367;
                          }
                          localObject1 = null;
                          label335:
                          if (!s.p(paramAnonymousObject, localObject1)) {
                            break label373;
                          }
                        }
                      }
                      for (paramAnonymousObject = localObject2;; paramAnonymousObject = null)
                      {
                        paramAnonymousObject = (and)paramAnonymousObject;
                        if (paramAnonymousObject != null) {
                          break label380;
                        }
                        paramAnonymousObject = null;
                        break;
                        paramAnonymousObject = paramAnonymousObject.id;
                        break label323;
                        label367:
                        localObject1 = ((bfv)localObject1).id;
                        break label335;
                        label373:
                        break label291;
                      }
                      label380:
                      paramAnonymousObject = paramAnonymousObject.ZEQ;
                      break label140;
                      label388:
                      localObject1 = ((bfv)localObject1).id;
                      break label175;
                      label396:
                      localObject1 = bq.akii;
                      localObject1 = bq.l(paramAnonymousObject);
                      break label194;
                      label408:
                      localObject2 = ((bfv)localObject1).id;
                      localObject1 = localObject2;
                      if (localObject2 == null) {
                        localObject1 = "";
                      }
                    }
                  }
                }
              }
              paramAnonymousObject = bq.akii;
              bq.a(this.akgw.akgq);
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(371640);
              return paramAnonymousObject;
            }
          };
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (l.a(paramObject, localm, locald) == locala)
          {
            AppMethodBeat.o(371637);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(371637);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<b, CharSequence>
  {
    public static final f akgE;
    
    static
    {
      AppMethodBeat.i(371655);
      akgE = new f();
      AppMethodBeat.o(371655);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<b, CharSequence>
  {
    public static final g akgF;
    
    static
    {
      AppMethodBeat.i(371653);
      akgF = new g();
      AppMethodBeat.o(371653);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.b<b, Boolean>
  {
    public static final h akgG;
    
    static
    {
      AppMethodBeat.i(371652);
      akgG = new h();
      AppMethodBeat.o(371652);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BoxMsg;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.b<anf, Boolean>
  {
    public static final i akgH;
    
    static
    {
      AppMethodBeat.i(371646);
      akgH = new i();
      AppMethodBeat.o(371646);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    public j(f paramf, String paramString, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class k<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(371654);
      int i = kotlin.b.a.b((Comparable)Long.valueOf(((anc)paramT2).adlC), (Comparable)Long.valueOf(((anc)paramT1).adlC));
      AppMethodBeat.o(371654);
      return i;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    boolean YF;
    int label;
    
    l(f paramf, kotlin.d.d<? super l> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(371644);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.akgw.b(null, false, (kotlin.d.d)this);
      AppMethodBeat.o(371644);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxMsgInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<ConcurrentHashMap<String, h>, ah>
  {
    m(anc paramanc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.f
 * JD-Core Version:    0.7.0.1
 */