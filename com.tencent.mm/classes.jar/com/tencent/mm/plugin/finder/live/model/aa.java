package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.util.r;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.l;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.m;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.o;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.p;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.r;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.s;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.axe;>;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bbd;>;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager;", "", "()V", "TAG", "", "addLocalGiftToMsg", "", "getAddLocalGiftToMsg", "()Z", "setAddLocalGiftToMsg", "(Z)V", "gameTeamMsg", "", "giftMsgType", "highLightCheerMsg", "msgInCommentList", "msgInFirstLevelBullet", "msgPromoteAd", "msgPromoteProduct", "saveMyselfComment", "getSaveMyselfComment", "setSaveMyselfComment", "topMsg", "appendAudioModeTip", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "appendGameTeamModeTip", "appendGiftTip", "appendLinkMicTip", "appendLocationTip", "appendMicSettingTip", "appendOfficialAccountTips", "userInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizUserInfo;", "appendSysLawTip", "appendWelcomeTip", "checkCommentListSize", "liveRoomData", "remoteLiveMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "maxCount", "", "checkCommentListSizeSaveMySelf", "liveroomData", "checkFirstLiveReward", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "filterCommentMsg", "msgList", "filterCommentMsgForExternal", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "remoteLiveAppMsg", "filterFirstLevelBulletMsg", "filterGameTeamMsg", "appMsgList", "filterGiftMsg", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "filterHighLightCheerMsg", "filterPromoteAdMsg", "filterPromoteProduct", "remoteAppMsg", "filterPromoteProductMsg", "filterTopMsg", "handleBulletMsg", "handleCommentMsg", "selfID", "selfFinderID", "handleGameTeamMsg", "handleGiftMsg", "handleHighLightCheerMsg", "handleLinkMicMsg", "handleLinkMicPkMsg", "handlePromoteProductMsg", "handleTopMsg", "isMySelfLiveMsg", "scene", "liveMsg", "plugin-finder_release"})
public final class aa
{
  private static final String TAG = "Finder.FinderLiveMsgManager";
  private static boolean ygA;
  private static boolean ygB;
  private static final int[] ygC;
  private static final int[] ygD;
  private static final int[] ygE;
  private static final int[] ygF;
  private static final int[] ygG;
  private static final int[] ygH;
  private static final int[] ygI;
  private static final int[] ygJ;
  public static final aa ygK;
  
  static
  {
    AppMethodBeat.i(284055);
    ygK = new aa();
    TAG = "Finder.FinderLiveMsgManager";
    ygA = true;
    ygB = true;
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.ilZ().aSr()).intValue();
    locala = com.tencent.c.a.a.a.a.a.Zlt;
    int j = ((Number)com.tencent.c.a.a.a.a.a.ima().aSr()).intValue();
    if (i == 0)
    {
      bool = true;
      ygA = bool;
      if (j != 0) {
        break label302;
      }
    }
    label302:
    for (boolean bool = true;; bool = false)
    {
      ygB = bool;
      Log.i(TAG, "sendLocalGiftToMsgValue :" + i + ",saveMyselfCommentValue:" + j);
      ygC = new int[] { 1, 10007, 10008, 100000, 10006, 20001, 20002, 20013, 20014, 20019, 20020, 20031 };
      ygD = new int[] { 10012, 10005 };
      ygE = new int[] { 20025 };
      ygF = new int[] { 20021, 20022 };
      ygG = new int[] { 20009 };
      ygH = new int[] { 10017 };
      ygI = new int[] { 20006 };
      ygJ = new int[] { 20023 };
      AppMethodBeat.o(284055);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, aqi paramaqi)
  {
    Object localObject2 = null;
    AppMethodBeat.i(284052);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("#appendOfficialAccountTips nick=");
    if (paramaqi != null) {}
    for (Object localObject1 = paramaqi.RVI;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" user=");
      localObject1 = localObject2;
      if (paramaqi != null) {
        localObject1 = paramaqi.RVH;
      }
      Log.i(str, (String)localObject1);
      if ((parama != null) && (paramaqi != null)) {
        break;
      }
      AppMethodBeat.o(284052);
      return;
    }
    localObject1 = new bbd();
    ((bbd)localObject1).type = 10019;
    ((bbd)localObject1).content = paramaqi.RVI;
    localObject1 = new ab((bbd)localObject1, paramaqi);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject1);
    m.yCt.e(false, paramaqi.RVH, paramaqi.RVI);
    AppMethodBeat.o(284052);
  }
  
  private static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<ao> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(284037);
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (parama != null)
      {
        List localList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq;
        int j = paramInt - (localList.size() + paramLinkedList.size());
        if (j < 0)
        {
          paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziu;
          int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.size() - 1 - paramInt;
          if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziu >= 0) && (i > 0))
          {
            j = -j;
            if (i > j)
            {
              kotlin.g.b.p.j(localList, "commentList");
              localList.removeAll((Collection)kotlin.a.j.a(localList, new kotlin.k.e(paramInt + 1, j + paramInt)));
              AppMethodBeat.o(284037);
              return;
            }
            kotlin.g.b.p.j(localList, "commentList");
            localList.removeAll((Collection)kotlin.a.j.a(localList, i.ou(paramInt + 1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.size())));
            AppMethodBeat.o(284037);
            return;
          }
          kotlin.g.b.p.j(localList, "commentList");
          localList.removeAll((Collection)kotlin.a.j.c((Iterable)localList, -j));
        }
        AppMethodBeat.o(284037);
        return;
      }
    }
    AppMethodBeat.o(284037);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<bbd> paramLinkedList, LinkedList<axe> paramLinkedList1, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(284043);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveMsg");
    kotlin.g.b.p.k(paramLinkedList1, "remoteLiveAppMsg");
    Object localObject1 = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      ((LinkedList)localObject1).add(new ak((bbd)paramLinkedList.next()));
    }
    paramLinkedList = ((Iterable)paramLinkedList1).iterator();
    Object localObject2;
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (axe)paramLinkedList.next();
      switch (paramLinkedList1.msg_type)
      {
      default: 
        break;
      case 20001: 
      case 20002: 
        ((LinkedList)localObject1).add(new q(paramLinkedList1));
        break;
      case 20013: 
        paramLinkedList1 = new j(paramLinkedList1);
        Log.i(TAG, "receive FinderLiveComboRewardMsg:[" + paramLinkedList1.cGy() + ", " + paramLinkedList1.dyd() + ']');
        ((LinkedList)localObject1).add(paramLinkedList1);
        break;
      case 20014: 
        paramLinkedList1 = new ad(paramLinkedList1);
        Log.i(TAG, "receive FinderLiveRewardRankingMsg:[" + paramLinkedList1.cGy() + ", " + paramLinkedList1.dyd() + ']');
        ((LinkedList)localObject1).add(paramLinkedList1);
        break;
      case 20019: 
        paramLinkedList1 = new y(paramLinkedList1);
        localObject2 = paramLinkedList1.dyn();
        if (localObject2 == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgSendRedPacketInfo");
          AppMethodBeat.o(284043);
          throw parama;
        }
        localObject2 = (ayc)localObject2;
        Log.i(TAG, "receive AppMsgSendRedPacket:[" + ((ayc)localObject2).SKs + ", " + ((ayc)localObject2).SKx + ']');
        ((LinkedList)localObject1).add(paramLinkedList1);
        break;
      case 20020: 
        paramLinkedList1 = new x(paramLinkedList1);
        localObject2 = paramLinkedList1.dyn();
        if (localObject2 == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgRecvRedPacketInfo");
          AppMethodBeat.o(284043);
          throw parama;
        }
        localObject2 = (axz)localObject2;
        Log.i(TAG, "receive AppMsgRecvRedPacket:[" + ((axz)localObject2).SKs + ", " + ((axz)localObject2).SKt + ']');
        ((LinkedList)localObject1).add(paramLinkedList1);
        break;
      case 20031: 
        paramLinkedList1 = new n(paramLinkedList1);
        Log.i(TAG, "receive FinderLiveGlobalLevelUpgradeMsg:[" + paramLinkedList1 + ']');
        if (paramLinkedList1.dyn() != null) {
          ((LinkedList)localObject1).add(paramLinkedList1);
        }
        break;
      }
    }
    paramLinkedList = al((LinkedList)localObject1);
    kotlin.a.j.a((List)paramLinkedList, (Comparator)new aa.e());
    paramLinkedList1 = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList1.hasNext())
    {
      Object localObject3 = (ao)paramLinkedList1.next();
      localObject1 = ((ao)localObject3).cGy();
      if (localObject1 != null)
      {
        localObject2 = (Map)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfs;
        localObject3 = ((ao)localObject3).dye();
        if ((localObject3 != null) && (((aza)localObject3).SKR == 1)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Map)localObject2).put(localObject1, Boolean.valueOf(bool));
          break;
        }
      }
    }
    if (ygB) {
      b(parama, paramLinkedList, paramInt);
    }
    for (;;)
    {
      paramLinkedList1 = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList1.hasNext())
      {
        localObject1 = (ao)paramLinkedList1.next();
        if (((((ao)localObject1).getType() == 20013) && (!ygA)) || (((((ao)localObject1).getType() == 20014) || (((ao)localObject1).getType() == 20019) || (((ao)localObject1).getType() == 20020) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgh.contains(((ao)localObject1).dyi()))) && ((((ao)localObject1).getType() != 20013) || (!ygA) || ((!kotlin.g.b.p.h(((ao)localObject1).cGy(), paramString1)) && (!kotlin.g.b.p.h(((ao)localObject1).cGy(), paramString2)))) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfR.get(Long.valueOf(((ao)localObject1).cYY())) == null)))
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject1);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfR.put(Long.valueOf(((ao)localObject1).cYY()), localObject1);
        }
      }
      a(parama, paramLinkedList, paramInt);
    }
    if (paramLinkedList.size() - ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.size() > 10)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.clear();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.addAll((Collection)paramLinkedList);
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfr = (i.be(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfr, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.size()) + paramLinkedList.size());
    AppMethodBeat.o(284043);
  }
  
  private static LinkedList<ao> al(LinkedList<ao> paramLinkedList)
  {
    AppMethodBeat.i(284035);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      ao localao = (ao)localObject2;
      if (kotlin.a.e.contains(ygC, localao.getType())) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(284035);
    return localLinkedList;
  }
  
  private static axe am(LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(284036);
    paramLinkedList = (List)paramLinkedList;
    ListIterator localListIterator = paramLinkedList.listIterator(paramLinkedList.size());
    axe localaxe;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      paramLinkedList = localListIterator.previous();
      localaxe = (axe)paramLinkedList;
    } while (!kotlin.a.e.contains(ygF, localaxe.msg_type));
    for (;;)
    {
      paramLinkedList = (axe)paramLinkedList;
      AppMethodBeat.o(284036);
      return paramLinkedList;
      paramLinkedList = null;
    }
  }
  
  private static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<ao> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(284038);
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (parama == null) {}
    }
    label134:
    label527:
    for (;;)
    {
      int k;
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        k = paramInt / 2;
        j = paramInt * 4 / 5;
        parama = parama.ziq;
        i = paramLinkedList.size();
        i = parama.size() + i;
        if (i <= paramInt) {
          break label510;
        }
        j = i - j;
        Log.i(TAG, "checkCommentListSizeSaveMySelf maxCount:" + paramInt + ", totalMsgSize;" + i + ", removeSize:" + j);
        if (j > 0)
        {
          localObject1 = new LinkedList();
          Iterator localIterator = parama.iterator();
          i = 0;
          paramInt = i;
          aj localaj;
          if (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            kotlin.g.b.p.j(localObject2, "localMsgIterator.next()");
            localObject2 = (ao)localObject2;
            localaj = aj.AGc;
            if (!aj.aFJ(((ao)localObject2).cGy()))
            {
              localIterator.remove();
              paramInt = i + 1;
              break label516;
            }
          }
          else
          {
            label202:
            if (paramInt >= j) {
              break label505;
            }
            localIterator = paramLinkedList.iterator();
            kotlin.g.b.p.j(localIterator, "remoteLiveMsg.iterator()");
            i = paramInt;
            label224:
            if (!localIterator.hasNext()) {
              break label502;
            }
            localObject2 = localIterator.next();
            kotlin.g.b.p.j(localObject2, "remoteMsgIterator.next()");
            localObject2 = (ao)localObject2;
            localaj = aj.AGc;
            if (aj.aFJ(((ao)localObject2).cGy())) {
              break label465;
            }
            localIterator.remove();
            i += 1;
            break label527;
            label290:
            j = ((LinkedList)localObject1).size();
            if (j <= k) {
              break label493;
            }
            int m = k * 4 / 5;
            if (m <= 0) {
              break label476;
            }
            j -= m;
            localObject1 = kotlin.a.j.a((List)localObject1, new kotlin.k.e(0, j));
            parama.removeAll((Collection)localObject1);
            paramLinkedList.removeAll((Collection)localObject1);
            Log.i(TAG, "checkCommentListSizeSaveMySelf localMsgRemoveSize:" + paramInt + ",remoteMsgRemoveSize:" + (i - paramInt) + ",myselfRemoveSize:" + j);
            AppMethodBeat.o(284038);
            return;
          }
          ((LinkedList)localObject1).add(localObject2);
          paramInt = i;
        }
      }
      catch (Exception parama)
      {
        f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveCheckCommentMsgErr", false, false, null, 28);
        paramLinkedList = aj.AGc;
        aj.a(parama, "checkCommentListSizeSaveMySelf");
        AppMethodBeat.o(284038);
        return;
      }
      label465:
      ((LinkedList)localObject1).add(localObject2);
      break label527;
      label476:
      j -= k;
      continue;
      AppMethodBeat.o(284038);
      return;
      label493:
      int j = 0;
      label502:
      label505:
      label510:
      while (i < j)
      {
        break label224;
        break label290;
        i = paramInt;
        break label290;
        j = 0;
        break;
        i = paramInt;
        if (paramInt < j) {
          break label134;
        }
        break label202;
      }
    }
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(284049);
    if (parama != null)
    {
      Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeY;
      if (localObject != null)
      {
        localObject = ((awl)localObject).SJe;
        if (localObject != null)
        {
          bbd localbbd = new bbd();
          localbbd.type = 10001;
          localbbd.content = ((String)localObject);
          localObject = new ak(localbbd);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(0, localObject);
          Log.i(TAG, "appendSysLawTip:" + ((ak)localObject).yig.content);
          AppMethodBeat.o(284049);
          return;
        }
      }
      AppMethodBeat.o(284049);
      return;
    }
    AppMethodBeat.o(284049);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<bbd> paramLinkedList)
  {
    AppMethodBeat.i(284039);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveMsg");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zir.clear();
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zir;
    Object localObject2 = new LinkedList();
    Object localObject3 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      bbd localbbd = (bbd)localObject4;
      if (kotlin.a.e.contains(ygD, localbbd.type)) {
        paramLinkedList.add(localObject4);
      }
    }
    ((LinkedList)localObject2).addAll((Collection)paramLinkedList);
    ((List)localObject1).addAll((Collection)localObject2);
    paramLinkedList = aj.AGc;
    if ((aj.eej()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zir.size() > 0))
    {
      paramLinkedList = TAG;
      localObject1 = new StringBuilder("handleBulletMsg size:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zir.size()).append(',');
      parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zir;
      kotlin.g.b.p.j(parama, "roomData.business(LiveMs…ss.java).bulletCommetList");
      localObject2 = (Iterable)parama;
      parama = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        parama.add(((bbd)((Iterator)localObject2).next()).ilo);
      }
      Log.i(paramLinkedList, (List)parama);
    }
    AppMethodBeat.o(284039);
  }
  
  public static void d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    int j = 0;
    AppMethodBeat.i(284050);
    if (parama != null)
    {
      Object localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).desc;
      int i;
      label66:
      Object localObject2;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label542;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).desc;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq;
        kotlin.g.b.p.j(localObject2, "roomData.business(LiveMs…lice::class.java).msgList");
      }
      for (;;)
      {
        synchronized ((Iterable)localObject2)
        {
          Object localObject4 = ((Iterable)???).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject2 = ((Iterator)localObject4).next();
            i = ((ao)localObject2).getType();
            if (i == 100000)
            {
              i = 1;
              if (i == 0) {
                continue;
              }
              if (localObject2 == null) {
                break label661;
              }
              bool1 = true;
              localObject2 = TAG;
              ??? = new StringBuilder("[START_LIVE], desc is empty:");
              localObject4 = (CharSequence)localObject1;
              if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                break label666;
              }
              bool2 = true;
              Log.i((String)localObject2, bool2 + ", containWelcomeMsg:" + bool1);
              localObject2 = (CharSequence)localObject1;
              if (localObject2 != null)
              {
                i = j;
                if (((CharSequence)localObject2).length() != 0) {}
              }
              else
              {
                i = 1;
              }
              if ((i != 0) || (bool1)) {
                break label672;
              }
              FinderObject localFinderObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
              if (localFinderObject == null) {
                break label672;
              }
              localObject4 = new bbd();
              aza localaza = new aza();
              FinderContact localFinderContact = new FinderContact();
              localObject2 = localFinderObject.contact;
              if (localObject2 != null)
              {
                ??? = ((FinderContact)localObject2).username;
                localObject2 = ???;
                if (??? != null) {}
              }
              else
              {
                localObject2 = "";
              }
              localFinderContact.username = ((String)localObject2);
              localObject2 = localFinderObject.contact;
              if (localObject2 != null)
              {
                ??? = ((FinderContact)localObject2).nickname;
                localObject2 = ???;
                if (??? != null) {}
              }
              else
              {
                localObject2 = "";
              }
              localFinderContact.nickname = ((String)localObject2);
              localObject2 = localFinderObject.contact;
              if (localObject2 != null)
              {
                ??? = ((FinderContact)localObject2).headUrl;
                localObject2 = ???;
                if (??? != null) {}
              }
              else
              {
                localObject2 = "";
              }
              localFinderContact.headUrl = ((String)localObject2);
              localaza.contact = localFinderContact;
              ((bbd)localObject4).zeL = localaza;
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = "";
              }
              ((bbd)localObject4).content = ((String)localObject2);
              ((bbd)localObject4).type = 100000;
              localObject1 = new ak((bbd)localObject4);
              ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject1);
              Log.i(TAG, "appendWelcomeTip:" + ((ak)localObject1).yig.content);
              AppMethodBeat.o(284050);
              return;
              i = 0;
              break;
              label542:
              if (((c)parama.business(c.class)).zgW == null)
              {
                localObject1 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
                localObject1 = e.a.MH(((c)parama.business(c.class)).xbk);
                if (localObject1 != null)
                {
                  localObject1 = ((FinderItem)localObject1).getDescription();
                  break label66;
                }
                localObject1 = null;
                break label66;
              }
              localObject1 = ((c)parama.business(c.class)).zgW;
              if (localObject1 != null)
              {
                localObject1 = ((FinderObjectDesc)localObject1).description;
                break label66;
              }
              localObject1 = null;
              break label66;
            }
            i = 0;
            continue;
            continue;
          }
          localObject2 = null;
        }
        label661:
        boolean bool1 = false;
        continue;
        label666:
        boolean bool2 = false;
      }
      label672:
      AppMethodBeat.o(284050);
      return;
    }
    AppMethodBeat.o(284050);
  }
  
  public static void d(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    String str = null;
    AppMethodBeat.i(284040);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    Object localObject1 = (List)paramLinkedList;
    Object localObject4 = ((List)localObject1).listIterator(((List)localObject1).size());
    Object localObject5;
    label97:
    int i;
    for (;;)
    {
      if (((ListIterator)localObject4).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject4).previous();
        localObject5 = (axe)localObject1;
        if (kotlin.a.e.contains(ygE, ((axe)localObject5).msg_type))
        {
          localObject5 = (axe)localObject1;
          if (localObject5 == null) {
            break label645;
          }
          localObject1 = ((axe)localObject5).SJE;
          if (localObject1 == null) {
            break label678;
          }
          localObject4 = (com.tencent.mm.cd.a)new axy();
          localObject1 = ((axe)localObject5).SJE;
          if (localObject1 == null) {
            break label650;
          }
          localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();
        }
      }
      try
      {
        label128:
        ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject6;
          com.tencent.mm.plugin.finder.live.view.convert.a locala;
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localblm = null;
        }
      }
      localObject1 = (axy)localObject1;
      if (localObject1 == null) {
        break label678;
      }
      localObject1 = ((axy)localObject1).SKr;
      label152:
      if (localObject1 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK;
        localObject5 = TAG;
        localObject6 = new StringBuilder("filterPromoteProduct remotePromoting:").append(((blm)localObject1).title).append(",localPromoting:");
        locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        Log.i((String)localObject5, com.tencent.mm.plugin.finder.live.view.convert.a.dFL());
        if (((localObject4 instanceof com.tencent.mm.plugin.finder.live.view.convert.f)) && (((com.tencent.mm.plugin.finder.live.view.convert.f)localObject4).zaO == ((blm)localObject1).zaO)) {
          break label683;
        }
        i = 1;
        label248:
        if ((localObject4 == null) || (((blm)localObject1).zaV != 0) || (i == 0)) {
          break label688;
        }
        localObject5 = TAG;
        localObject1 = new StringBuilder("filterPromoteProduct remote productId:").append(((blm)localObject1).zaO).append(" promoting:").append(((blm)localObject1).zaV).append(", local productId:").append(((bu)localObject4).mf()).append(" promoting:");
        localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        Log.i((String)localObject5, 0);
      }
      kotlin.a.j.c((List)paramLinkedList, (kotlin.g.a.b)aa.c.ygN);
      localObject5 = am(paramLinkedList);
      if ((localObject5 == null) || (((axe)localObject5).msg_type != 20021)) {
        break label781;
      }
      localObject4 = (com.tencent.mm.cd.a)new axx();
      localObject1 = ((axe)localObject5).SJE;
      if (localObject1 == null) {
        break label753;
      }
      localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();
      try
      {
        label403:
        ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = localObject4;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label433:
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          label529:
          localObject2 = null;
        }
      }
      localObject4 = (axx)localObject1;
      localObject1 = str;
      if (localObject4 != null) {
        localObject1 = ((axx)localObject4).SKh;
      }
      if (localObject1 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK;
        str = TAG;
        localObject5 = new StringBuilder("ad filterPromoteProduct remotePromoting:").append(((bcq)localObject1).title).append(",localPromoting:");
        localObject6 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        Log.i(str, com.tencent.mm.plugin.finder.live.view.convert.a.dFL());
        if (((localObject4 instanceof com.tencent.mm.plugin.finder.live.view.convert.e)) && (((com.tencent.mm.plugin.finder.live.view.convert.e)localObject4).zaI == ((bcq)localObject1).zaI)) {
          break label891;
        }
        i = 1;
        if ((localObject4 == null) || (((bcq)localObject1).promoting != 0) || (i == 0)) {
          break label896;
        }
        parama = TAG;
        localObject1 = new StringBuilder("ad filterPromoteProduct remote productId:").append(((bcq)localObject1).zaI).append(" promoting:").append(((bcq)localObject1).promoting).append(", local productId:").append(((bu)localObject4).mf()).append(" promoting:");
        localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        Log.i(parama, 0);
      }
    }
    for (;;)
    {
      kotlin.a.j.c((List)paramLinkedList, (kotlin.g.a.b)aa.d.ygO);
      AppMethodBeat.o(284040);
      return;
      localObject1 = null;
      break;
      label645:
      localObject1 = null;
      break label97;
      label650:
      localObject1 = null;
      break label128;
      label678:
      blm localblm = null;
      break label152;
      label683:
      i = 0;
      break label248;
      label688:
      if (localblm != null) {
        localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      }
      for (localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.b(localblm);; localObject4 = null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).d((bu)localObject4);
        localObject4 = ah.yhC;
        localObject4 = ah.getFinderLiveAssistant();
        if (localObject4 == null) {
          break;
        }
        ((an)localObject4).a(localblm);
        break;
      }
      label753:
      localblm = null;
      break label403;
      label781:
      Object localObject2 = str;
      if (localObject5 == null) {
        break label433;
      }
      localObject2 = str;
      if (((axe)localObject5).msg_type != 20022) {
        break label433;
      }
      localObject4 = (com.tencent.mm.cd.a)new axr();
      localObject2 = ((axe)localObject5).SJE;
      if (localObject2 != null) {}
      for (localObject2 = ((com.tencent.mm.cd.b)localObject2).toByteArray();; localObject2 = null)
      {
        try
        {
          ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject2);
          localObject2 = localObject4;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException3 });
            localObject3 = null;
          }
        }
        localObject4 = (axr)localObject2;
        localObject2 = str;
        if (localObject4 == null) {
          break;
        }
        localObject2 = ((axr)localObject4).SKh;
        break;
      }
      label891:
      i = 0;
      break label529;
      label896:
      localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      Object localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.a((bcq)localObject3);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).d((bu)localObject3);
    }
  }
  
  public static ArrayList<cuc> e(LinkedList<bbd> paramLinkedList, LinkedList<axe> paramLinkedList1)
  {
    AppMethodBeat.i(284042);
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveMsg");
    kotlin.g.b.p.k(paramLinkedList1, "remoteLiveAppMsg");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label136:
    label176:
    int i;
    while (localIterator.hasNext())
    {
      localObject2 = (bbd)localIterator.next();
      if (kotlin.a.e.contains(ygC, ((bbd)localObject2).type))
      {
        localObject3 = new cuc();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.p.ADF;
        ((cuc)localObject3).msgType = com.tencent.mm.plugin.finder.utils.p.QK(((bbd)localObject2).type);
        paramLinkedList = ((bbd)localObject2).zeL;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            localObject1 = paramLinkedList.nickname;
            paramLinkedList = (LinkedList<bbd>)localObject1;
            if (localObject1 != null) {
              break label136;
            }
          }
        }
        paramLinkedList = "";
        ((cuc)localObject3).TBM = paramLinkedList;
        paramLinkedList = ((bbd)localObject2).zeL;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            localObject1 = paramLinkedList.headUrl;
            paramLinkedList = (LinkedList<bbd>)localObject1;
            if (localObject1 != null) {
              break label176;
            }
          }
        }
        paramLinkedList = "";
        ((cuc)localObject3).TBQ = paramLinkedList;
        ((cuc)localObject3).content = ((bbd)localObject2).content;
        ((cuc)localObject3).TBO = ((bbd)localObject2).seq;
        ((cuc)localObject3).ilo = ((bbd)localObject2).ilo;
        ((cuc)localObject3).SMN = ((bbd)localObject2).SMN;
        paramLinkedList = ((bbd)localObject2).zeL;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.SHb;
          if (paramLinkedList == null) {}
        }
        for (i = paramLinkedList.SKC;; i = 0)
        {
          ((cuc)localObject3).TBP = i;
          localArrayList.add(localObject3);
          break;
        }
      }
      switch (((bbd)localObject2).type)
      {
      default: 
        break;
      case 10005: 
        localObject3 = new cuc();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.p.ADF;
        ((cuc)localObject3).msgType = com.tencent.mm.plugin.finder.utils.p.QK(((bbd)localObject2).type);
        paramLinkedList = ((bbd)localObject2).zeL;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            localObject1 = paramLinkedList.nickname;
            paramLinkedList = (LinkedList<bbd>)localObject1;
            if (localObject1 != null) {
              break label355;
            }
          }
        }
        paramLinkedList = "";
        label355:
        ((cuc)localObject3).TBM = paramLinkedList;
        paramLinkedList = ((bbd)localObject2).zeL;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            localObject1 = paramLinkedList.headUrl;
            paramLinkedList = (LinkedList<bbd>)localObject1;
            if (localObject1 != null) {
              break label395;
            }
          }
        }
        paramLinkedList = "";
        label395:
        ((cuc)localObject3).TBQ = paramLinkedList;
        ((cuc)localObject3).content = MMApplicationContext.getContext().getString(b.j.finder_live_new_coming_tip_2);
        ((cuc)localObject3).TBO = ((bbd)localObject2).seq;
        ((cuc)localObject3).ilo = ((bbd)localObject2).ilo;
        ((cuc)localObject3).SMN = ((bbd)localObject2).SMN;
        localArrayList.add(localObject3);
      }
    }
    localIterator = ((Iterable)paramLinkedList1).iterator();
    label770:
    label909:
    while (localIterator.hasNext())
    {
      localObject2 = (axe)localIterator.next();
      label678:
      label1191:
      switch (((axe)localObject2).msg_type)
      {
      default: 
        break;
      case 20002: 
        localObject1 = new cuc();
        paramLinkedList = com.tencent.mm.plugin.finder.utils.p.ADF;
        ((cuc)localObject1).msgType = com.tencent.mm.plugin.finder.utils.p.QK(((axe)localObject2).msg_type);
        localObject3 = MMApplicationContext.getContext();
        i = b.j.finder_live_someone_reply_someone;
        paramLinkedList = ((axe)localObject2).SJH;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            paramLinkedList1 = paramLinkedList.nickname;
            paramLinkedList = paramLinkedList1;
            if (paramLinkedList1 != null) {
              break label598;
            }
          }
        }
        paramLinkedList = "";
        paramLinkedList1 = ((axe)localObject2).SJC;
        if (paramLinkedList1 != null)
        {
          paramLinkedList1 = paramLinkedList1.contact;
          if (paramLinkedList1 != null)
          {
            paramLinkedList1 = paramLinkedList1.nickname;
            ((cuc)localObject1).TBM = ((Context)localObject3).getString(i, new Object[] { paramLinkedList, paramLinkedList1 });
            paramLinkedList = ((axe)localObject2).SJH;
            if (paramLinkedList != null)
            {
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList != null)
              {
                paramLinkedList1 = paramLinkedList.headUrl;
                paramLinkedList = paramLinkedList1;
                if (paramLinkedList1 != null) {
                  break label678;
                }
              }
            }
            paramLinkedList = "";
            ((cuc)localObject1).TBQ = paramLinkedList;
            ((cuc)localObject1).content = new q((axe)localObject2).getContent();
            ((cuc)localObject1).TBO = ((axe)localObject2).seq;
            ((cuc)localObject1).ilo = ((axe)localObject2).SJs;
            ((cuc)localObject1).SMN = ((axe)localObject2).SJI;
            paramLinkedList = ((axe)localObject2).SJH;
            if (paramLinkedList == null) {
              break label770;
            }
            paramLinkedList = paramLinkedList.SHb;
            if (paramLinkedList == null) {
              break label770;
            }
          }
        }
        for (i = paramLinkedList.SKC;; i = 0)
        {
          ((cuc)localObject1).TBP = i;
          localArrayList.add(localObject1);
          break;
          paramLinkedList1 = null;
          break label622;
        }
      case 20009: 
        localObject1 = new axu();
        paramLinkedList1 = (com.tencent.mm.cd.a)localObject1;
        paramLinkedList = ((axe)localObject2).SJE;
        if (paramLinkedList != null) {
          paramLinkedList = paramLinkedList.toByteArray();
        }
        try
        {
          for (;;)
          {
            paramLinkedList1.parseFrom(paramLinkedList);
            localObject3 = new cuc();
            paramLinkedList = com.tencent.mm.plugin.finder.utils.p.ADF;
            ((cuc)localObject3).msgType = com.tencent.mm.plugin.finder.utils.p.QK(((axe)localObject2).msg_type);
            paramLinkedList = ((axe)localObject2).SJH;
            if (paramLinkedList != null)
            {
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList != null)
              {
                paramLinkedList1 = paramLinkedList.nickname;
                paramLinkedList = paramLinkedList1;
                if (paramLinkedList1 != null) {
                  break label869;
                }
              }
            }
            paramLinkedList = "";
            ((cuc)localObject3).TBM = paramLinkedList;
            paramLinkedList = ((axe)localObject2).SJH;
            if (paramLinkedList != null)
            {
              paramLinkedList = paramLinkedList.contact;
              if (paramLinkedList != null)
              {
                paramLinkedList1 = paramLinkedList.headUrl;
                paramLinkedList = paramLinkedList1;
                if (paramLinkedList1 != null) {
                  break label909;
                }
              }
            }
            paramLinkedList = "";
            ((cuc)localObject3).TBQ = paramLinkedList;
            paramLinkedList = ((axu)localObject1).SKe;
            if (paramLinkedList == null) {
              break label1093;
            }
            paramLinkedList = paramLinkedList.name;
            ((cuc)localObject3).ySp = paramLinkedList;
            ((cuc)localObject3).content = MMApplicationContext.getContext().getString(b.j.finder_live_msg_gift_prefix, new Object[] { ((cuc)localObject3).ySp });
            ((cuc)localObject3).TBO = ((axe)localObject2).seq;
            ((cuc)localObject3).ilo = ((axe)localObject2).SJs;
            ((cuc)localObject3).SMN = ((axe)localObject2).SJI;
            ((cuc)localObject3).Dmv = ((axu)localObject1).SKf;
            ((cuc)localObject3).Dmt = ((axu)localObject1).SKd;
            ((cuc)localObject3).TBR = ((axu)localObject1).SKp;
            paramLinkedList = ((axu)localObject1).SKe;
            if (paramLinkedList == null) {
              break label1098;
            }
            paramLinkedList = paramLinkedList.SLD;
            ((cuc)localObject3).Dmu = paramLinkedList;
            ((cuc)localObject3).yru = ((axu)localObject1).SKg;
            ((cuc)localObject3).TBS = ((axu)localObject1).SKo;
            localArrayList.add(localObject3);
            break;
            paramLinkedList = null;
          }
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            continue;
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
          }
        }
      case 20014: 
        label598:
        label622:
        paramLinkedList1 = new ad((axe)localObject2).dyn();
        label869:
        if ((paramLinkedList1 instanceof ayb))
        {
          localObject3 = new cuc();
          paramLinkedList = com.tencent.mm.plugin.finder.utils.p.ADF;
          ((cuc)localObject3).msgType = com.tencent.mm.plugin.finder.utils.p.QK(((axe)localObject2).msg_type);
          ((cuc)localObject3).TBM = "";
          paramLinkedList = ((axe)localObject2).SJH;
          if (paramLinkedList != null)
          {
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList != null)
            {
              localObject1 = paramLinkedList.headUrl;
              paramLinkedList = (LinkedList<bbd>)localObject1;
              if (localObject1 != null) {
                break label1191;
              }
            }
          }
          paramLinkedList = "";
          ((cuc)localObject3).TBQ = paramLinkedList;
          if ((paramLinkedList1 instanceof ayb)) {
            break label1368;
          }
        }
        label1093:
        label1098:
        break;
      }
    }
    label1368:
    for (paramLinkedList = null;; paramLinkedList = paramLinkedList1)
    {
      paramLinkedList = (ayb)paramLinkedList;
      if (paramLinkedList != null) {}
      for (i = paramLinkedList.SKw;; i = 0)
      {
        ((cuc)localObject3).TBP = i;
        localObject1 = new StringBuilder();
        paramLinkedList = ((axe)localObject2).SJH;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList != null)
          {
            paramLinkedList1 = paramLinkedList.nickname;
            paramLinkedList = paramLinkedList1;
            if (paramLinkedList1 != null) {
              break label1268;
            }
          }
        }
        paramLinkedList = "";
        label1268:
        ((cuc)localObject3).content = (paramLinkedList + ' ' + MMApplicationContext.getContext().getString(b.j.finder_live_msg_reward_rank_content, new Object[] { Integer.valueOf(((cuc)localObject3).TBP) }));
        ((cuc)localObject3).TBO = ((axe)localObject2).seq;
        ((cuc)localObject3).ilo = ((axe)localObject2).SJs;
        ((cuc)localObject3).SMN = ((axe)localObject2).SJI;
        localArrayList.add(localObject3);
        break;
      }
      AppMethodBeat.o(284042);
      return localArrayList;
    }
  }
  
  public static void e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(284051);
    if (parama != null)
    {
      Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).location;
      if (localObject1 != null)
      {
        Object localObject2 = (CharSequence)((bdm)localObject1).poiName;
        int i;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label184;
          }
          i = 1;
          label57:
          if (i == 0) {
            break label189;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label194;
          }
          localObject2 = new bbd();
          ((bbd)localObject2).type = 10018;
          ((bbd)localObject2).content = (((bdm)localObject1).city + " • " + ((bdm)localObject1).poiName);
          localObject1 = new w((bbd)localObject2, (bdm)localObject1);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject1);
          Log.i(TAG, "appendLocationTip:" + ((ak)localObject1).yig.content);
          AppMethodBeat.o(284051);
          return;
          i = 0;
          break;
          label184:
          i = 0;
          break label57;
          label189:
          localObject1 = null;
        }
      }
      label194:
      AppMethodBeat.o(284051);
      return;
    }
    AppMethodBeat.o(284051);
  }
  
  public static void e(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<bbd> paramLinkedList)
  {
    AppMethodBeat.i(284044);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveMsg");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zis.clear();
    List localList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zis;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label172:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      bbd localbbd = (bbd)localObject2;
      if ((kotlin.a.e.contains(ygH, localbbd.type)) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgg.contains(localbbd.SMN))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label172;
        }
        paramLinkedList.add(localObject2);
        break;
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    localList.addAll((Collection)localLinkedList);
    AppMethodBeat.o(284044);
  }
  
  public static void f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(284053);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("appendGameTeamModeTip:");
    if (parama != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfD;
        if (localObject1 == null) {}
      }
    }
    for (Object localObject1 = Integer.valueOf(((azh)localObject1).SLe);; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      if (parama == null) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfD;
      if ((localObject1 == null) || (((azh)localObject1).SLe != 0)) {
        break;
      }
      AppMethodBeat.o(284053);
      return;
    }
    if (parama != null)
    {
      localObject2 = new bbd();
      ((bbd)localObject2).type = 10001;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfD;
      if ((localObject1 != null) && (((azh)localObject1).SLe == 1))
      {
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
      }
      for (localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_game_live_team_join_off);; localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_game_live_team_join_on))
      {
        ((bbd)localObject2).content = ((String)localObject1);
        localObject1 = new ak((bbd)localObject2);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject1);
        AppMethodBeat.o(284053);
        return;
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
      }
    }
    AppMethodBeat.o(284053);
  }
  
  public static void f(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(284045);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zit.clear();
    List localList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zit;
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (axe)localObject3;
      if (kotlin.a.e.contains(ygI, ((axe)localObject4).msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label260:
    label263:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = (axe)localObject3;
      localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      paramLinkedList = paramLinkedList.SJH;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.username;
          label229:
          if (com.tencent.mm.plugin.finder.live.utils.a.aCQ(paramLinkedList)) {
            break label260;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label263;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = null;
        break label229;
      }
    }
    localList.addAll((Collection)localObject1);
    Log.i(TAG, "handleHighLightCheerMsg roomData.business(LiveCommonSlice::class.java).highLightCheerList:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).zit.size());
    AppMethodBeat.o(284045);
  }
  
  public static void g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(284054);
    if (parama != null)
    {
      Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((cxh)localObject1).TFP);
        if (!com.tencent.mm.plugin.finder.live.utils.a.Ly(((Long)localObject1).longValue())) {
          break label181;
        }
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_setting_follow_msg_tip);
        label74:
        kotlin.g.b.p.j(localObject1, "when {\n                F…          }\n            }");
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label346;
        }
      }
      label181:
      label346:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = new bbd();
          ((bbd)localObject2).type = 10001;
          ((bbd)localObject2).content = ((String)localObject1);
          localObject2 = new ak((bbd)localObject2);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localObject2);
        }
        Log.i(TAG, "appendMicSettingTip:".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(284054);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((cxh)localObject1).TFP);; localObject1 = null)
        {
          if (!com.tencent.mm.plugin.finder.live.utils.a.Lz(((Long)localObject1).longValue())) {
            break label251;
          }
          localObject1 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_setting_reward_msg_tip);
          break;
        }
        label251:
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        cxh localcxh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhx;
        localObject1 = localObject2;
        if (localcxh != null) {
          localObject1 = Long.valueOf(localcxh.TFP);
        }
        if (com.tencent.mm.plugin.finder.live.utils.a.LA(((Long)localObject1).longValue()))
        {
          localObject1 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_setting_buy_product_msg_tip);
          break label74;
        }
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_setting_all_msg_tip);
        break label74;
      }
    }
    AppMethodBeat.o(284054);
  }
  
  public static void g(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(284046);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = (Iterable)paramLinkedList;
    parama = (Collection)new ArrayList();
    paramLinkedList = paramLinkedList.iterator();
    Object localObject1;
    while (paramLinkedList.hasNext())
    {
      localObject1 = paramLinkedList.next();
      localObject2 = (axe)localObject1;
      if (kotlin.a.e.contains(localf.zhB, ((axe)localObject2).msg_type)) {
        parama.add(localObject1);
      }
    }
    localLinkedList.addAll((Collection)parama);
    Object localObject2 = ((Iterable)localLinkedList).iterator();
    label313:
    label570:
    label954:
    while (((Iterator)localObject2).hasNext())
    {
      axe localaxe = (axe)((Iterator)localObject2).next();
      axk localaxk = new axk();
      paramLinkedList = (com.tencent.mm.cd.a)localaxk;
      parama = localaxe.SJE;
      if (parama != null) {
        parama = parama.toByteArray();
      }
      try
      {
        for (;;)
        {
          paramLinkedList.parseFrom(parama);
          Log.i("MMFinder.LiveLinkMicSlice", "receive apply mic msg: [sessionId:" + localaxe.session_id + ", applyUserSdkId:" + localaxk.SnB + ']');
          parama = localaxe.session_id;
          if (parama == null) {
            break;
          }
          if (localf.zhv.get(parama) == null) {
            break label313;
          }
          Log.i("MMFinder.LiveLinkMicSlice", "has received mic apply, skip msg. sessionId:".concat(String.valueOf(parama)));
          break;
          parama = null;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parama });
        }
        ((Map)localf.zhv).put(parama, Integer.valueOf(0));
        parama = localf.zhj;
        kotlin.g.b.p.j(parama, "linkMicUserList");
        kotlin.a.j.c(parama, (kotlin.g.a.b)new f.j(localaxk, localaxe, localf));
        List localList = localf.zhj;
        String str = localaxk.SnB;
        parama = localaxe.SJH;
        if (parama != null)
        {
          parama = parama.contact;
          if (parama != null)
          {
            parama = parama.headUrl;
            paramLinkedList = localaxe.SJH;
            if (paramLinkedList == null) {
              break label756;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label756;
            }
            paramLinkedList = paramLinkedList.username;
            localObject1 = localaxe.SJH;
            if (localObject1 == null) {
              break label761;
            }
            localObject1 = ((aza)localObject1).contact;
            if (localObject1 == null) {
              break label761;
            }
            localObject1 = ((FinderContact)localObject1).nickname;
            label448:
            localList.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str, parama, paramLinkedList, (String)localObject1, localaxk.SJK, localaxe.session_id, null, false, 0, null, null, 0, 0, false, null, localaxk.SJZ, localaxe.SJH, 65472));
            parama = localf.zhk;
            kotlin.g.b.p.j(parama, "newLinkMicUserList");
            kotlin.a.j.c(parama, (kotlin.g.a.b)new f.k(localaxk, localaxe, localf));
            localList = localf.zhk;
            str = localaxk.SnB;
            parama = localaxe.SJH;
            if (parama == null) {
              break label766;
            }
            parama = parama.contact;
            if (parama == null) {
              break label766;
            }
            parama = parama.headUrl;
            paramLinkedList = localaxe.SJH;
            if (paramLinkedList == null) {
              break label771;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label771;
            }
            paramLinkedList = paramLinkedList.username;
            label594:
            localObject1 = localaxe.SJH;
            if (localObject1 == null) {
              break label776;
            }
            localObject1 = ((aza)localObject1).contact;
            if (localObject1 == null) {
              break label776;
            }
            localObject1 = ((FinderContact)localObject1).nickname;
            label618:
            localList.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str, parama, paramLinkedList, (String)localObject1, localaxk.SJK, localaxe.session_id, null, false, 0, null, null, 0, 0, false, null, localaxk.SJZ, localaxe.SJH, 65472));
            parama = r.yQS;
            parama = localf.zhx;
            if (parama == null) {
              break label781;
            }
          }
        }
        for (parama = Long.valueOf(parama.TFP);; parama = null)
        {
          if (!r.Ly(parama.longValue())) {
            break label786;
          }
          parama = localf.zhj;
          kotlin.g.b.p.j(parama, "linkMicUserList");
          kotlin.a.j.c(parama, (kotlin.g.a.b)f.l.zhT);
          parama = localf.zhk;
          kotlin.g.b.p.j(parama, "newLinkMicUserList");
          kotlin.a.j.c(parama, (kotlin.g.a.b)f.m.zhU);
          break;
          parama = null;
          break label400;
          label756:
          paramLinkedList = null;
          break label424;
          label761:
          localObject1 = null;
          break label448;
          label766:
          parama = null;
          break label570;
          paramLinkedList = null;
          break label594;
          localObject1 = null;
          break label618;
        }
        parama = r.yQS;
        parama = localf.zhx;
        if (parama != null) {}
        for (parama = Long.valueOf(parama.TFP);; parama = null)
        {
          if (!r.Lz(parama.longValue())) {
            break label871;
          }
          parama = localf.zhj;
          kotlin.g.b.p.j(parama, "linkMicUserList");
          kotlin.a.j.c(parama, (kotlin.g.a.b)f.n.zhV);
          parama = localf.zhk;
          kotlin.g.b.p.j(parama, "newLinkMicUserList");
          kotlin.a.j.c(parama, (kotlin.g.a.b)f.o.zhW);
          break;
        }
        label871:
        parama = r.yQS;
        parama = localf.zhx;
        if (parama == null) {}
      }
      for (parama = Long.valueOf(parama.TFP);; parama = null)
      {
        if (!r.LA(parama.longValue())) {
          break label954;
        }
        parama = localf.zhj;
        kotlin.g.b.p.j(parama, "linkMicUserList");
        kotlin.a.j.c(parama, (kotlin.g.a.b)f.p.zhX);
        parama = localf.zhk;
        kotlin.g.b.p.j(parama, "newLinkMicUserList");
        kotlin.a.j.c(parama, (kotlin.g.a.b)f.q.zhY);
        break;
      }
    }
    label400:
    label424:
    Log.i("MMFinder.LiveLinkMicSlice", "handleLinkMicMsg applyMicMsgList:".concat(String.valueOf(localLinkedList)));
    label771:
    label776:
    label781:
    label786:
    AppMethodBeat.o(284046);
  }
  
  public static void h(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(284047);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.f localf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = (Iterable)paramLinkedList;
    parama = (Collection)new ArrayList();
    paramLinkedList = paramLinkedList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramLinkedList.hasNext())
    {
      localObject1 = paramLinkedList.next();
      localObject2 = (axe)localObject1;
      if (kotlin.a.e.contains(localf.zhE, ((axe)localObject2).msg_type)) {
        parama.add(localObject1);
      }
    }
    localLinkedList.addAll((Collection)parama);
    Iterator localIterator = ((Iterable)localLinkedList).iterator();
    axe localaxe;
    axl localaxl;
    label330:
    List localList;
    String str1;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label890;
      }
      localaxe = (axe)localIterator.next();
      localaxl = new axl();
      paramLinkedList = (com.tencent.mm.cd.a)localaxl;
      parama = localaxe.SJE;
      if (parama != null) {
        parama = parama.toByteArray();
      }
      try
      {
        for (;;)
        {
          paramLinkedList.parseFrom(parama);
          Log.i("MMFinder.LiveLinkMicSlice", "receive apply mic pk msg: [sessionId:" + localaxe.session_id + ", pkUserSdkId:" + localaxl.SJO + ", pkSdkLiveId:" + localaxl.SJP + ']');
          parama = localaxe.session_id;
          if (parama == null) {
            break;
          }
          if (localf.zhv.get(parama) == null) {
            break label330;
          }
          Log.i("MMFinder.LiveLinkMicSlice", "has received mic pk apply, skip msg. sessionId:".concat(String.valueOf(parama)));
          break;
          parama = null;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parama });
        }
        ((Map)localf.zhv).put(parama, Integer.valueOf(0));
        parama = localf.zhj;
        kotlin.g.b.p.j(parama, "linkMicUserList");
        kotlin.a.j.c(parama, (kotlin.g.a.b)new f.r(localaxl, localaxe, localf));
        localList = localf.zhj;
        str1 = localaxl.SJO;
        parama = localaxe.SJH;
        if (parama == null) {
          break label836;
        }
      }
    }
    parama = parama.contact;
    label421:
    label445:
    label469:
    String str2;
    int i;
    if (parama != null)
    {
      parama = parama.headUrl;
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList == null) {
        break label841;
      }
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null) {
        break label841;
      }
      paramLinkedList = paramLinkedList.username;
      localObject1 = localaxe.SJH;
      if (localObject1 == null) {
        break label846;
      }
      localObject1 = ((aza)localObject1).contact;
      if (localObject1 == null) {
        break label846;
      }
      localObject1 = ((FinderContact)localObject1).nickname;
      str2 = localaxe.session_id;
      i = localaxl.SJP;
      localObject2 = localaxe.SJH;
      if (localObject2 == null) {
        break label851;
      }
      localObject2 = ((aza)localObject2).contact;
      if (localObject2 == null) {
        break label851;
      }
      localObject2 = ((FinderContact)localObject2).authInfo;
      label513:
      localObject3 = localaxe.SJH;
      if (localObject3 == null) {
        break label857;
      }
      localObject3 = ((aza)localObject3).contact;
      if (localObject3 == null) {
        break label857;
      }
      localObject3 = ((FinderContact)localObject3).signature;
      label544:
      localList.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, parama, paramLinkedList, (String)localObject1, 2, str2, null, true, i, (FinderAuthInfo)localObject2, (String)localObject3, 0, 0, false, localaxl.SKa, 0L, localaxe.SJH, 112640));
      parama = localf.zhk;
      kotlin.g.b.p.j(parama, "newLinkMicUserList");
      kotlin.a.j.c(parama, (kotlin.g.a.b)new f.s(localaxl, localaxe, localf));
      localList = localf.zhk;
      str1 = localaxl.SJO;
      parama = localaxe.SJH;
      if (parama == null) {
        break label863;
      }
      parama = parama.contact;
      if (parama == null) {
        break label863;
      }
      parama = parama.headUrl;
      label663:
      paramLinkedList = localaxe.SJH;
      if (paramLinkedList == null) {
        break label868;
      }
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null) {
        break label868;
      }
      paramLinkedList = paramLinkedList.username;
      label687:
      localObject1 = localaxe.SJH;
      if (localObject1 == null) {
        break label873;
      }
      localObject1 = ((aza)localObject1).contact;
      if (localObject1 == null) {
        break label873;
      }
      localObject1 = ((FinderContact)localObject1).nickname;
      label711:
      str2 = localaxe.session_id;
      i = localaxl.SJP;
      localObject2 = localaxe.SJH;
      if (localObject2 == null) {
        break label878;
      }
      localObject2 = ((aza)localObject2).contact;
      if (localObject2 == null) {
        break label878;
      }
      localObject2 = ((FinderContact)localObject2).authInfo;
      label755:
      localObject3 = localaxe.SJH;
      if (localObject3 == null) {
        break label884;
      }
      localObject3 = ((aza)localObject3).contact;
      if (localObject3 == null) {
        break label884;
      }
    }
    label836:
    label841:
    label846:
    label851:
    label857:
    label863:
    label868:
    label873:
    label878:
    label884:
    for (Object localObject3 = ((FinderContact)localObject3).signature;; localObject3 = null)
    {
      localList.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.h(str1, parama, paramLinkedList, (String)localObject1, 2, str2, null, true, i, (FinderAuthInfo)localObject2, (String)localObject3, 0, 0, false, localaxl.SKa, 0L, localaxe.SJH, 112640));
      break;
      parama = null;
      break label421;
      paramLinkedList = null;
      break label445;
      localObject1 = null;
      break label469;
      localObject2 = null;
      break label513;
      localObject3 = null;
      break label544;
      parama = null;
      break label663;
      paramLinkedList = null;
      break label687;
      localObject1 = null;
      break label711;
      localObject2 = null;
      break label755;
    }
    label890:
    Log.i("MMFinder.LiveLinkMicSlice", "handleLinkMicPkMsg applyMicPkMsgList:".concat(String.valueOf(localLinkedList)));
    AppMethodBeat.o(284047);
  }
  
  public static void i(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    String str = null;
    AppMethodBeat.i(284048);
    kotlin.g.b.p.k(parama, "roomData");
    kotlin.g.b.p.k(paramLinkedList, "remoteLiveAppMsg");
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      axe localaxe = (axe)localObject3;
      if (kotlin.a.e.contains(ygJ, localaxe.msg_type)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    Object localObject3 = (axe)kotlin.a.j.lr((List)localObject1);
    if (localObject3 != null)
    {
      localObject1 = (com.tencent.mm.cd.a)new axs();
      paramLinkedList = ((axe)localObject3).SJE;
      if (paramLinkedList != null) {}
      for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
      {
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
          paramLinkedList = (LinkedList<axe>)localObject1;
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
            continue;
            paramLinkedList = null;
            continue;
            boolean bool = false;
          }
        }
        localObject1 = (axs)paramLinkedList;
        localObject2 = TAG;
        localObject3 = new StringBuilder("gameteam lastMsg, seq:").append(((axe)localObject3).seq).append(", gameLiveTeamUpInfo in_team_up:");
        if (localObject1 == null) {
          break;
        }
        paramLinkedList = Integer.valueOf(((axs)localObject1).SKk);
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", is_team_full:");
        if (localObject1 == null) {
          break label633;
        }
        paramLinkedList = Integer.valueOf(((axs)localObject1).SKl);
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", title:");
        if (localObject1 == null) {
          break label638;
        }
        paramLinkedList = ((axs)localObject1).title;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", rank:");
        if (localObject1 == null) {
          break label643;
        }
        paramLinkedList = ((axs)localObject1).SKj;
        localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", member:");
        paramLinkedList = str;
        if (localObject1 != null) {
          paramLinkedList = ((axs)localObject1).SKi;
        }
        Log.i((String)localObject2, paramLinkedList);
        if (localObject1 != null)
        {
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE == null)
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).a(new azi());
            paramLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
            if (paramLinkedList != null) {
              paramLinkedList.SLi = "";
            }
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
          if (localObject2 != null)
          {
            str = ((axs)localObject1).title;
            paramLinkedList = str;
            if (str == null) {
              paramLinkedList = "";
            }
            ((azi)localObject2).title = paramLinkedList;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
          if (localObject2 != null)
          {
            str = ((axs)localObject1).SKj;
            paramLinkedList = str;
            if (str == null) {
              paramLinkedList = "";
            }
            ((azi)localObject2).SKj = paramLinkedList;
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
          if (localObject2 != null)
          {
            str = ((axs)localObject1).SKi;
            paramLinkedList = str;
            if (str == null) {
              paramLinkedList = "";
            }
            ((azi)localObject2).SLh = paramLinkedList;
          }
          paramLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
          if (paramLinkedList != null) {
            paramLinkedList.SKk = ((axs)localObject1).SKk;
          }
          parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (((axs)localObject1).SKl != 1) {
            break label648;
          }
          bool = true;
          parama.zfF = bool;
        }
        AppMethodBeat.o(284048);
        return;
      }
    }
    label633:
    label638:
    AppMethodBeat.o(284048);
    label643:
    label648:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aa
 * JD-Core Version:    0.7.0.1
 */