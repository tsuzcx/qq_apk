package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/DataUtil;", "", "()V", "getAppMsgListInfo", "", "msgList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "getConnectMicInfo", "connectList", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicUserInfo;", "getFeedListInfo", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFrameItemInfo", "item", "Lcom/tencent/mm/protocal/protobuf/FrameItem;", "getFrameItemListInfo", "getLinkMicInfo", "linkMicList", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "getMicInfo", "mickInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMicInfo;", "getMsgListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "getOffsetLiveMsgInfo", "msgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetResponse;", "parseFinderObject2LiveData", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "finderObject", "filterFansClubBadge", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "getLiveId", "", "getLiveStatus", "", "getLiveUrl", "getSmallResolutionLiveUrl", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveInfoResp;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePurchaseInfo;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "isValidLiveFeed", "", "liveCanPlay", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "promoteTitle", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "promoting", "showNavigationBar", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadCtrlInfo;", "simpleFinderObject", "pos", "simpleLiveInfo", "toFinderLiveReplayData", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowItem;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "Lcom/tencent/mm/protocal/protobuf/FinderShopCouponInfo;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "Lcom/tencent/mm/protocal/protobuf/PromotingInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a DUC;
  
  static
  {
    AppMethodBeat.i(358454);
    DUC = new a();
    AppMethodBeat.o(358454);
  }
  
  public static i a(bmt parambmt)
  {
    AppMethodBeat.i(358227);
    s.u(parambmt, "<this>");
    parambmt = new i(parambmt);
    AppMethodBeat.o(358227);
    return parambmt;
  }
  
  public static j a(bvo parambvo)
  {
    AppMethodBeat.i(358234);
    s.u(parambvo, "<this>");
    parambvo = new j(parambvo);
    AppMethodBeat.o(358234);
    return parambvo;
  }
  
  public static cc a(bmu parambmu)
  {
    AppMethodBeat.i(358246);
    s.u(parambmu, "<this>");
    Object localObject = parambmu.JaK;
    if (localObject == null)
    {
      AppMethodBeat.o(358246);
      return null;
    }
    switch (parambmu.item_type)
    {
    default: 
      AppMethodBeat.o(358246);
      return null;
    case 0: 
      parambmu = (com.tencent.mm.bx.a)new bzc();
      localObject = ((com.tencent.mm.bx.b)localObject).toByteArray();
      try
      {
        parambmu.parseFrom((byte[])localObject);
        parambmu = (bzc)parambmu;
        if (parambmu == null)
        {
          parambmu = null;
          parambmu = (cc)parambmu;
          AppMethodBeat.o(358246);
          return parambmu;
        }
      }
      catch (Exception parambmu)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parambmu });
          parambmu = null;
          continue;
          parambmu = b(parambmu);
        }
      }
    case 1: 
      parambmu = (com.tencent.mm.bx.a)new bmt();
      localObject = ((com.tencent.mm.bx.b)localObject).toByteArray();
      try
      {
        parambmu.parseFrom((byte[])localObject);
        parambmu = (bmt)parambmu;
        if (parambmu == null)
        {
          parambmu = null;
          parambmu = (cc)parambmu;
          AppMethodBeat.o(358246);
          return parambmu;
        }
      }
      catch (Exception parambmu)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parambmu });
          parambmu = null;
          continue;
          parambmu = a(parambmu);
        }
      }
    }
    parambmu = (com.tencent.mm.bx.a)new bvo();
    localObject = ((com.tencent.mm.bx.b)localObject).toByteArray();
    try
    {
      parambmu.parseFrom((byte[])localObject);
      parambmu = (bvo)parambmu;
      if (parambmu == null)
      {
        parambmu = null;
        parambmu = (cc)parambmu;
        AppMethodBeat.o(358246);
        return parambmu;
      }
    }
    catch (Exception parambmu)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { parambmu });
        parambmu = null;
        continue;
        parambmu = a(parambmu);
      }
    }
  }
  
  public static String a(bfy parambfy)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358322);
    Object localObject3 = new StringBuilder();
    Object localObject1;
    if (parambfy == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(',');
      if (parambfy != null) {
        break label121;
      }
      localObject1 = null;
      label38:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(',');
      if (parambfy != null) {
        break label132;
      }
      localObject1 = null;
      label55:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append("(room list:");
      if (parambfy != null) {
        break label154;
      }
      localObject1 = null;
      label72:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(",user list:");
      if (parambfy != null) {
        break label176;
      }
      parambfy = localObject2;
    }
    for (;;)
    {
      parambfy = parambfy + ')';
      AppMethodBeat.o(358322);
      return parambfy;
      localObject1 = Integer.valueOf(parambfy.ZGN);
      break;
      label121:
      localObject1 = Integer.valueOf(parambfy.ZGO);
      break label38;
      label132:
      localObject1 = parambfy.ZPJ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label55;
      }
      localObject1 = ((boe)localObject1).ZWz;
      break label55;
      label154:
      localObject1 = parambfy.ZPJ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label72;
      }
      localObject1 = ((boe)localObject1).ZWy;
      break label72;
      label176:
      localObject3 = parambfy.ZPJ;
      parambfy = localObject2;
      if (localObject3 != null) {
        parambfy = ((boe)localObject3).username_list;
      }
    }
  }
  
  public static String a(bjm parambjm)
  {
    AppMethodBeat.i(358414);
    if (parambjm == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (parambjm.ZTd.isEmpty()); localObject1 = parambjm.ZTd)
    {
      AppMethodBeat.o(358414);
      return "null";
    }
    localObject1 = new StringBuilder();
    parambjm = parambjm.ZTd;
    if (parambjm != null)
    {
      parambjm = (Iterable)parambjm;
      int i = 0;
      parambjm = parambjm.iterator();
      while (parambjm.hasNext())
      {
        Object localObject2 = parambjm.next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (bjl)localObject2;
        ((StringBuilder)localObject1).append("[" + i + ',' + ((bjl)localObject2).ZlX + ']');
        i += 1;
      }
    }
    parambjm = ((StringBuilder)localObject1).toString();
    s.s(parambjm, "result.toString()");
    AppMethodBeat.o(358414);
    return parambjm;
  }
  
  public static String a(blf paramblf)
  {
    AppMethodBeat.i(358334);
    if (paramblf == null)
    {
      AppMethodBeat.o(358334);
      return "";
    }
    paramblf = "PurchaseInfo:[" + paramblf.ZGN + ',' + paramblf.ZUj + ',' + paramblf.ZUk + ',' + paramblf.ZUl + ',' + paramblf.ZUm + ']';
    AppMethodBeat.o(358334);
    return paramblf;
  }
  
  public static String a(boe paramboe)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358326);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1;
    if (paramboe == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("(room list:");
      if (paramboe != null) {
        break label86;
      }
      localObject1 = null;
      label39:
      localObject1 = localStringBuilder.append(localObject1).append(",user list:");
      if (paramboe != null) {
        break label94;
      }
    }
    label86:
    label94:
    for (paramboe = localObject2;; paramboe = paramboe.username_list)
    {
      paramboe = paramboe + ')';
      AppMethodBeat.o(358326);
      return paramboe;
      localObject1 = paramboe.ZWz;
      break;
      localObject1 = paramboe.ZWy;
      break label39;
    }
  }
  
  public static String a(cai paramcai)
  {
    AppMethodBeat.i(358436);
    s.u(paramcai, "item");
    StringBuilder localStringBuilder = new StringBuilder("[offset:").append(paramcai.aajp).append(",msgList:(");
    Object localObject = paramcai.aajq;
    if (localObject == null)
    {
      localObject = null;
      localObject = localStringBuilder.append(gN((List)localObject)).append("),appMsgList:(");
      paramcai = paramcai.aajq;
      if (paramcai != null) {
        break label114;
      }
    }
    label114:
    for (paramcai = null;; paramcai = paramcai.ZJV)
    {
      paramcai = gO((List)paramcai) + ")]";
      AppMethodBeat.o(358436);
      return paramcai;
      localObject = ((azp)localObject).PmC;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(358312);
    s.u(paramf, "liveData");
    s.u(paramFinderObject, "finderObject");
    ((e)paramf.BxG.business(e.class)).PZ(2);
    ((e)paramf.BxG.business(e.class)).l(paramFinderObject);
    Object localObject3 = (e)paramf.BxG.business(e.class);
    Object localObject2 = paramFinderObject.username;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((e)localObject3).setAnchorUsername((String)localObject1);
    localObject2 = paramFinderObject.liveInfo;
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).setLiveInfo((bip)localObject2);
      localObject1 = ((bip)localObject2).ZOg;
      if (localObject1 != null) {
        break label343;
      }
      localObject1 = null;
      if (localObject1 == null) {
        Log.e("toFinderLiveReplayData", "parseFinderObject liveSdkInfo is null!");
      }
      localObject1 = (e)paramf.BxG.business(e.class);
      localObject2 = ((bip)localObject2).ZSm;
      if (localObject2 != null) {
        break label367;
      }
    }
    label343:
    label367:
    for (int i = 0;; i = ((blz)localObject2).ZUH)
    {
      ((e)localObject1).EcX = i;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN = paramFinderObject.id;
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject2 = paramFinderObject.objectNonceId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).setNonceId((String)localObject1);
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject2 = paramFinderObject.sessionBuffer;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).setSessionBuffer((String)localObject1);
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      localObject2 = paramFinderObject.nickname;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).awv((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).ayp(String.valueOf(paramFinderObject.hashCode()));
      AppMethodBeat.o(358312);
      return;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramf.BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).a((dix)localObject1);
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  public static boolean a(bog parambog)
  {
    return (parambog != null) && (parambog.Zrg == 1);
  }
  
  public static k b(bzc parambzc)
  {
    AppMethodBeat.i(358231);
    s.u(parambzc, "<this>");
    parambzc = new k(parambzc);
    AppMethodBeat.o(358231);
    return parambzc;
  }
  
  public static boolean b(aka paramaka)
  {
    return (paramaka != null) && (paramaka.Zrg == 1);
  }
  
  public static boolean b(bip parambip)
  {
    AppMethodBeat.i(358344);
    if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isUnPurchasedChargeLive(parambip))
    {
      Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
      int i = ((Number)com.tencent.d.a.a.a.a.a.jUn().bmg()).intValue();
      localObject = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage();
      long l;
      int j;
      if (parambip == null)
      {
        l = 0L;
        j = ((com.tencent.d.a.a.a.d.b)localObject).ov(l);
        localObject = new StringBuilder("feed:");
        if (parambip != null) {
          break label149;
        }
      }
      label149:
      for (parambip = null;; parambip = Long.valueOf(parambip.liveId))
      {
        Log.i("MicroMsg.Sport.PushSportTask", parambip + " is charge live:totalFreeTimeToWatch:" + i + ",usedTime:" + j);
        if (j < 0) {
          break label160;
        }
        if (j < i) {
          break label168;
        }
        AppMethodBeat.o(358344);
        return false;
        l = parambip.liveId;
        break;
      }
      label160:
      AppMethodBeat.o(358344);
      return false;
    }
    label168:
    AppMethodBeat.o(358344);
    return true;
  }
  
  public static String c(bip parambip)
  {
    AppMethodBeat.i(358372);
    if (parambip == null)
    {
      AppMethodBeat.o(358372);
      return "";
    }
    parambip = "liveId:" + d.hF(parambip.liveId) + " replay_status:" + parambip.replay_status + ' ' + a(parambip.ZSc);
    AppMethodBeat.o(358372);
    return parambip;
  }
  
  public static String d(FinderObject paramFinderObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358352);
    Object localObject1 = new StringBuilder();
    long l;
    if (paramFinderObject == null)
    {
      l = 0L;
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(d.hF(l)).append(',');
      if (paramFinderObject != null) {
        break label128;
      }
      localObject1 = null;
      label47:
      localStringBuilder = localStringBuilder.append(localObject1).append(',');
      if (paramFinderObject != null) {
        break label155;
      }
      localObject1 = null;
      label68:
      localObject1 = localStringBuilder.append(localObject1).append(',');
      if (paramFinderObject != null) {
        break label164;
      }
    }
    label128:
    label155:
    label164:
    for (paramFinderObject = localObject2;; paramFinderObject = paramFinderObject.liveInfo)
    {
      paramFinderObject = c(paramFinderObject) + ",pos:" + paramInt;
      AppMethodBeat.o(358352);
      return paramFinderObject;
      l = paramFinderObject.id;
      break;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label47;
      }
      localObject1 = ((FinderObjectDesc)localObject1).description;
      break label47;
      localObject1 = paramFinderObject.nickname;
      break label68;
    }
  }
  
  public static String ewb()
  {
    return "";
  }
  
  public static int ewc()
  {
    return 0;
  }
  
  private static String g(FinderObject paramFinderObject)
  {
    if (paramFinderObject == null) {
      paramFinderObject = "";
    }
    String str;
    do
    {
      return paramFinderObject;
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject == null) {
        return "";
      }
      str = paramFinderObject.mIE;
      paramFinderObject = str;
    } while (str != null);
    return "";
  }
  
  public static LinkedList<bfl> gJ(List<? extends bfl> paramList)
  {
    AppMethodBeat.i(358298);
    if (paramList == null)
    {
      AppMethodBeat.o(358298);
      return null;
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label88:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((bfl)localObject2).ZPp != 4) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label88;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = new LinkedList((Collection)paramList);
    AppMethodBeat.o(358298);
    return paramList;
  }
  
  public static String gK(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(358381);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(358381);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (FinderObject)localObject;
      localStringBuilder.append("[" + d((FinderObject)localObject, i) + ']');
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(358381);
    return paramList;
  }
  
  public static String gL(List<? extends dlh> paramList)
  {
    AppMethodBeat.i(358393);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(358393);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (dlh)localObject;
      localStringBuilder.append("[" + i + ':' + ((dlh)localObject).YRR + ',' + ((dlh)localObject).aaRl + ',' + ((dlh)localObject).aaRk + ']');
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(358393);
    return paramList;
  }
  
  public static String gM(List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> paramList)
  {
    AppMethodBeat.i(358404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(358404);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject;
      localStringBuilder.append("[" + i + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXL + ',' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXM + ',' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).AWE + ']');
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(358404);
    return paramList;
  }
  
  private static String gN(List<? extends bke> paramList)
  {
    AppMethodBeat.i(358423);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(358423);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (bke)localObject;
      localStringBuilder.append(i + ",type:" + ((bke)localObject).type + ",nickname:" + ((bke)localObject).nickname + "; ");
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "result.toString()");
    AppMethodBeat.o(358423);
    return paramList;
  }
  
  private static String gO(List<? extends bdm> paramList)
  {
    AppMethodBeat.i(358430);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(358430);
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      paramList = (bdm)paramList;
      StringBuilder localStringBuilder2 = new StringBuilder().append(i).append(",type:").append(paramList.msg_type).append(",from user:");
      paramList = paramList.ZOb;
      if (paramList == null) {
        paramList = null;
      }
      for (;;)
      {
        localStringBuilder1.append(paramList + "; ");
        i += 1;
        break;
        paramList = paramList.contact;
        if (paramList == null) {
          paramList = null;
        } else {
          paramList = paramList.nickname;
        }
      }
    }
    paramList = localStringBuilder1.toString();
    s.s(paramList, "result.toString()");
    AppMethodBeat.o(358430);
    return paramList;
  }
  
  public static String gP(List<? extends cai> paramList)
  {
    AppMethodBeat.i(358447);
    s.u(paramList, "msgList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(358447);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (cai)localObject;
      localStringBuilder.append("{" + i + ',' + a((cai)localObject) + "}\n");
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "result.toString()");
    AppMethodBeat.o(358447);
    return paramList;
  }
  
  private static String h(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(358278);
    Object localObject3 = "";
    Object localObject1 = localObject3;
    Object localObject2;
    if (paramFinderObject != null)
    {
      Object localObject4 = paramFinderObject.liveInfo;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((bip)localObject4).ZOg;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((dix)localObject4).aaOv;
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = (com.tencent.mm.bx.a)new diy();
            localObject4 = ((com.tencent.mm.bx.b)localObject4).toByteArray();
            int j;
            int k;
            try
            {
              ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
              localObject4 = (diy)localObject1;
              localObject1 = localObject3;
              if (localObject4 == null) {
                break label385;
              }
              localObject4 = ((diy)localObject4).aaOC;
              localObject1 = localObject3;
              if (localObject4 == null) {
                break label385;
              }
              j = ((diw)localObject4).aaNW;
              k = ((diw)localObject4).aaNK.size();
              if (j >= 0) {
                if (j < k)
                {
                  i = 1;
                  if (i == 0) {
                    break label255;
                  }
                  localObject3 = ((xb)((diw)localObject4).aaNK.get(j)).url;
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = "";
                  }
                  if (((CharSequence)localObject1).length() <= 0) {
                    break label250;
                  }
                  i = 1;
                  localObject3 = localObject1;
                  if (i == 0) {
                    break label255;
                  }
                  AppMethodBeat.o(358278);
                  return localObject1;
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { localException });
                localObject2 = null;
                continue;
                i = 0;
                continue;
                i = 0;
                continue;
                label250:
                i = 0;
              }
            }
            label255:
            if (((CharSequence)localObject3).length() == 0)
            {
              i = 1;
              localObject2 = localObject3;
              if (i == 0) {
                break label385;
              }
              i = ((diw)localObject4).aaNX;
              if (i < 0) {
                break label375;
              }
              if (i >= k) {
                break label370;
              }
              i = 1;
              localObject2 = localObject3;
              if (i == 0) {
                break label385;
              }
              localObject2 = ((xb)((diw)localObject4).aaNK.get(j)).url;
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = "";
              }
              if (((CharSequence)localObject3).length() <= 0) {
                break label380;
              }
            }
            label295:
            label370:
            label375:
            label380:
            for (i = 1;; i = 0)
            {
              localObject2 = localObject3;
              if (i == 0) {
                break label385;
              }
              AppMethodBeat.o(358278);
              return localObject3;
              i = 0;
              break;
              i = 0;
              break label295;
              i = 0;
              break label295;
            }
          }
        }
      }
    }
    label385:
    if (((CharSequence)localObject2).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e("MicroMsg.Sport.PushSportTask", "FinderObject.getSmallResolutionLiveUrl fail,get live stream instead!");
        localObject2 = g(paramFinderObject);
      }
      AppMethodBeat.o(358278);
      return localObject2;
    }
  }
  
  public static long i(FinderObject paramFinderObject)
  {
    if (paramFinderObject == null) {}
    do
    {
      return 0L;
      paramFinderObject = paramFinderObject.liveInfo;
    } while (paramFinderObject == null);
    return paramFinderObject.liveId;
  }
  
  public static boolean j(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(358288);
    if (i(paramFinderObject) != 0L)
    {
      if (((CharSequence)g(paramFinderObject)).length() > 0)
      {
        i = 1;
        if (i == 0) {
          if (((CharSequence)h(paramFinderObject)).length() <= 0) {
            break label70;
          }
        }
      }
      label70:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label75;
        }
        AppMethodBeat.o(358288);
        return true;
        i = 0;
        break;
      }
    }
    label75:
    AppMethodBeat.o(358288);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.data.f k(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(358304);
    if (paramFinderObject == null)
    {
      AppMethodBeat.o(358304);
      return null;
    }
    com.tencent.mm.plugin.finder.live.viewmodel.data.f localf = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramFinderObject);
    a(localf, paramFinderObject);
    AppMethodBeat.o(358304);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.a
 * JD-Core Version:    0.7.0.1
 */