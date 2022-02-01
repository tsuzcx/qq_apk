package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.b.h;
import com.tencent.mm.live.b.o.c;
import com.tencent.mm.live.b.o.l;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager;", "", "()V", "TAG", "", "acceptMicMsg", "", "addLocalGiftToMsg", "", "getAddLocalGiftToMsg", "()Z", "setAddLocalGiftToMsg", "(Z)V", "applyMicMsg", "closeMicMsg", "giftMsgType", "highLightCheerMsg", "msgInCommentList", "msgInFirstLevelBullet", "msgPromoteProduct", "saveMyselfComment", "getSaveMyselfComment", "setSaveMyselfComment", "topMsg", "appendGiftTip", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "appendLinkMicTip", "appendSysLawTip", "appendWelcomeTip", "checkCommentListSize", "remoteLiveMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "maxCount", "", "checkCommentListSizeSaveMySelf", "filterAcceptLinkMicMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "appMsgList", "filterApplyLinkMicMsg", "filterCloseLinkMicMsg", "filterCommentMsg", "msgList", "filterFirstLevelBulletMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "filterGiftMsg", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "filterHighLightCheerMsg", "filterPromoteProduct", "remote", "filterPromoteProductMsg", "filterTopMsg", "handleBulletMsg", "handleCommentMsg", "remoteLiveAppMsg", "selfID", "selfFinderID", "handleGiftMsg", "handleHighLightCheerMsg", "handleLinkMicMsg", "handlePromoteProductMsg", "handleTopMsg", "isMySelfLiveMsg", "scene", "liveMsg", "parsePromoteProductContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "msgContent", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderLiveMsgManager";
  private static boolean uiP;
  private static boolean uiQ;
  private static final int[] uiR;
  private static final int[] uiS;
  private static final int[] uiT;
  private static final int[] uiU;
  private static final int[] uiV;
  private static final int[] uiW;
  private static final int[] uiX;
  private static final int[] uiY;
  private static final int[] uiZ;
  public static final i uja;
  
  static
  {
    AppMethodBeat.i(246164);
    uja = new i();
    TAG = "Finder.FinderLiveMsgManager";
    uiP = true;
    uiQ = true;
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.c.dwg().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.c.dwh().value()).intValue();
    if (i == 0)
    {
      bool = true;
      uiP = bool;
      if (j != 0) {
        break label403;
      }
    }
    label403:
    for (boolean bool = true;; bool = false)
    {
      uiQ = bool;
      Log.i(TAG, "sendLocalGiftToMsgValue :" + i + ",saveMyselfCommentValue:" + j);
      localObject = o.c.hGH;
      i = o.c.aFn();
      localObject = o.c.hGH;
      j = o.c.aFr();
      localObject = o.c.hGH;
      int k = o.c.aFs();
      localObject = o.c.hGH;
      int m = o.c.aFw();
      localObject = o.c.hGH;
      int n = o.c.aFq();
      localObject = o.l.hHy;
      int i1 = o.l.aFO();
      localObject = o.l.hHy;
      uiR = new int[] { i, j, k, m, n, i1, o.l.aFP(), 20013, 20014 };
      localObject = o.c.hGH;
      i = o.c.aFv();
      localObject = o.c.hGH;
      uiS = new int[] { i, o.c.aFp() };
      localObject = o.c.hGH;
      i = o.c.aFt();
      localObject = o.c.hGH;
      uiT = new int[] { i, o.c.aFu() };
      uiU = new int[] { 20009 };
      localObject = o.c.hGH;
      uiV = new int[] { o.c.aFx() };
      localObject = o.l.hHy;
      uiW = new int[] { o.l.aFT() };
      localObject = o.l.hHy;
      uiX = new int[] { o.l.aFR() };
      localObject = o.l.hHy;
      uiY = new int[] { o.l.aFQ() };
      localObject = o.l.hHy;
      uiZ = new int[] { o.l.aFS() };
      AppMethodBeat.o(246164);
      return;
      bool = false;
      break;
    }
  }
  
  private static void a(g paramg, LinkedList<t> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(246152);
    List localList = paramg.uDs;
    int j = paramInt - (localList.size() + paramLinkedList.size());
    if (j < 0)
    {
      paramInt = paramg.uEO;
      int i = paramg.uDs.size() - 1 - paramInt;
      if ((paramg.uEO >= 0) && (i > 0))
      {
        j = -j;
        if (i > j)
        {
          p.g(localList, "commentList");
          localList.removeAll((Collection)kotlin.a.j.a(localList, new kotlin.k.f(paramInt + 1, paramInt + j)));
          AppMethodBeat.o(246152);
          return;
        }
        p.g(localList, "commentList");
        localList.removeAll((Collection)kotlin.a.j.a(localList, kotlin.k.j.mY(paramInt + 1, paramg.uDs.size())));
        AppMethodBeat.o(246152);
        return;
      }
      p.g(localList, "commentList");
      localList.removeAll((Collection)kotlin.a.j.b((Iterable)localList, -j));
    }
    AppMethodBeat.o(246152);
  }
  
  public static void a(g paramg, LinkedList<awq> paramLinkedList, LinkedList<aut> paramLinkedList1, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246156);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveMsg");
    p.h(paramLinkedList1, "remoteLiveAppMsg");
    Object localObject1 = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      ((LinkedList)localObject1).add(new r((awq)paramLinkedList.next()));
    }
    paramLinkedList = ((Iterable)paramLinkedList1).iterator();
    Object localObject2;
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = (aut)paramLinkedList.next();
      int i = paramLinkedList1.ybm;
      localObject2 = o.l.hHy;
      if (i != o.l.aFP())
      {
        localObject2 = o.l.hHy;
        if (i != o.l.aFO()) {}
      }
      else
      {
        ((LinkedList)localObject1).add(new f(paramLinkedList1));
        continue;
      }
      if (i == 20013) {
        ((LinkedList)localObject1).add(new d(paramLinkedList1));
      } else if (i == 20014) {
        ((LinkedList)localObject1).add(new k(paramLinkedList1));
      }
    }
    paramLinkedList = ai((LinkedList)localObject1);
    kotlin.a.j.a((List)paramLinkedList, (Comparator)new d());
    paramLinkedList1 = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList1.hasNext())
    {
      Object localObject3 = (t)paramLinkedList1.next();
      localObject1 = ((t)localObject3).csW();
      if (localObject1 != null)
      {
        localObject2 = (Map)paramg.uDX;
        localObject3 = ((t)localObject3).dfs();
        if ((localObject3 != null) && (((avn)localObject3).LGh == 1)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Map)localObject2).put(localObject1, Boolean.valueOf(bool));
          break;
        }
      }
    }
    if (uiQ) {
      b(paramg, paramLinkedList, paramInt);
    }
    for (;;)
    {
      paramLinkedList1 = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList1.hasNext())
      {
        localObject1 = (t)paramLinkedList1.next();
        if (((!p.j(((t)localObject1).csW(), paramString1)) && (!p.j(((t)localObject1).csW(), paramString2))) || ((((t)localObject1).getType() == 20013) && (!uiP)) || ((((t)localObject1).getType() == 20014) && (paramg.uEX.get(Long.valueOf(((t)localObject1).cKo())) == null)))
        {
          paramg.uDs.add(localObject1);
          paramg.uEX.put(Long.valueOf(((t)localObject1).cKo()), localObject1);
        }
      }
      a(paramg, paramLinkedList, paramInt);
    }
    if (paramLinkedList.size() - paramg.uDs.size() > 10)
    {
      paramg.uDs.clear();
      paramg.uDs.addAll((Collection)paramLinkedList);
    }
    long l = kotlin.k.j.aM(paramg.uDW, paramg.uDs.size());
    paramg.uDW = (paramLinkedList.size() + l);
    AppMethodBeat.o(246156);
  }
  
  private static LinkedList<t> ai(LinkedList<t> paramLinkedList)
  {
    AppMethodBeat.i(246148);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      t localt = (t)localObject2;
      if (kotlin.a.e.contains(uiR, localt.getType())) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(246148);
    return localLinkedList;
  }
  
  public static LinkedList<aut> aj(LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(246149);
    p.h(paramLinkedList, "appMsgList");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      aut localaut = (aut)localObject2;
      if (kotlin.a.e.contains(uiX, localaut.ybm)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(246149);
    return localLinkedList;
  }
  
  public static LinkedList<aut> ak(LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(246150);
    p.h(paramLinkedList, "appMsgList");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      aut localaut = (aut)localObject2;
      if (kotlin.a.e.contains(uiZ, localaut.ybm)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(246150);
    return localLinkedList;
  }
  
  private static axg atE(String paramString)
  {
    AppMethodBeat.i(246151);
    if (paramString != null) {
      try
      {
        paramString = new com.tencent.mm.ab.i(paramString);
        axg localaxg = new axg();
        localaxg.uko = paramString.optLong("product_id");
        com.tencent.mm.ab.i locali = paramString.FK("product_page");
        localaxg.LHI = new det();
        det localdet;
        if (locali != null)
        {
          localdet = localaxg.LHI;
          if (localdet != null) {
            localdet.appId = locali.optString("app_id");
          }
          localdet = localaxg.LHI;
          if (localdet != null) {
            localdet.path = locali.optString("path");
          }
        }
        localaxg.title = paramString.optString("title");
        localaxg.twt = paramString.optString("img_url");
        localaxg.LHJ = paramString.optInt("stock");
        localaxg.AZr = paramString.optInt("min_price");
        localaxg.AZq = paramString.optInt("max_price");
        localaxg.LHK = paramString.optInt("promoting");
        localaxg.LHL = paramString.optString("ext_buff");
        localaxg.LHM = paramString.optString("platform_name");
        localaxg.status = paramString.optInt("status");
        locali = paramString.FK("user_purchase_page");
        localaxg.LHN = new det();
        if (locali != null)
        {
          localdet = localaxg.LHN;
          if (localdet != null) {
            localdet.appId = locali.optString("app_id");
          }
          localdet = localaxg.LHN;
          if (localdet != null) {
            localdet.path = locali.optString("path");
          }
        }
        localaxg.LHO = paramString.optInt("platform_id");
        localaxg.dCu = paramString.optString("app_username");
        localaxg.ukr = paramString.optString("shop_extra_data");
        AppMethodBeat.o(246151);
        return localaxg;
      }
      catch (Exception paramString)
      {
        Log.i(TAG, paramString.toString());
        AppMethodBeat.o(246151);
        return null;
      }
    }
    AppMethodBeat.o(246151);
    return null;
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(246160);
    if (paramg != null)
    {
      if (paramg.uDs.isEmpty())
      {
        Object localObject = paramg.uDy;
        if (localObject != null)
        {
          localObject = ((aug)localObject).LFa;
          if (localObject != null)
          {
            awq localawq = new awq();
            o.c localc = o.c.hGH;
            localawq.type = o.c.aFo();
            localawq.content = ((String)localObject);
            localObject = new r(localawq);
            paramg.uDs.add(0, localObject);
            Log.i(TAG, "appendSysLawTip:" + ((r)localObject).uke.content);
            AppMethodBeat.o(246160);
            return;
          }
        }
      }
      AppMethodBeat.o(246160);
      return;
    }
    AppMethodBeat.o(246160);
  }
  
  private static void b(g paramg, LinkedList<t> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(246153);
    for (;;)
    {
      int k;
      int i;
      Object localObject1;
      label114:
      Object localObject2;
      try
      {
        k = paramInt / 2;
        j = paramInt * 4 / 5;
        paramg = paramg.uDs;
        i = paramLinkedList.size() + paramg.size();
        if (i <= paramInt) {
          break label483;
        }
        j = i - j;
        Log.i(TAG, "checkCommentListSizeSaveMySelf maxCount:" + paramInt + ", totalMsgSize;" + i + ", removeSize:" + j);
        if (j > 0)
        {
          localObject1 = new LinkedList();
          Iterator localIterator = paramg.iterator();
          i = 0;
          paramInt = i;
          y localy;
          if (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            p.g(localObject2, "localMsgIterator.next()");
            localObject2 = (t)localObject2;
            localy = y.vXH;
            if (!y.awn(((t)localObject2).csW()))
            {
              localIterator.remove();
              paramInt = i + 1;
              break label489;
            }
          }
          else
          {
            label182:
            if (paramInt >= j) {
              break label478;
            }
            localIterator = paramLinkedList.iterator();
            p.g(localIterator, "remoteLiveMsg.iterator()");
            i = paramInt;
            label204:
            if (!localIterator.hasNext()) {
              break label475;
            }
            localObject2 = localIterator.next();
            p.g(localObject2, "remoteMsgIterator.next()");
            localObject2 = (t)localObject2;
            localy = y.vXH;
            if (y.awn(((t)localObject2).csW())) {
              break label445;
            }
            localIterator.remove();
            i += 1;
            break label500;
            label270:
            j = ((LinkedList)localObject1).size();
            if (j <= k) {
              break label466;
            }
            int m = k * 4 / 5;
            if (m <= 0) {
              break label456;
            }
            j -= m;
            localObject1 = kotlin.a.j.a((List)localObject1, new kotlin.k.f(0, j));
            paramg.removeAll((Collection)localObject1);
            paramLinkedList.removeAll((Collection)localObject1);
            Log.i(TAG, "checkCommentListSizeSaveMySelf localMsgRemoveSize:" + paramInt + ",remoteMsgRemoveSize:" + (i - paramInt) + ",myselfRemoveSize:" + j);
            AppMethodBeat.o(246153);
            return;
          }
          ((LinkedList)localObject1).add(localObject2);
          paramInt = i;
        }
      }
      catch (Exception paramg)
      {
        f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "liveCheckCommentMsgErr", false, false, null, 28);
        paramLinkedList = y.vXH;
        y.a(paramg, "checkCommentListSizeSaveMySelf");
        AppMethodBeat.o(246153);
        return;
      }
      label445:
      ((LinkedList)localObject1).add(localObject2);
      break label500;
      label456:
      j -= k;
      continue;
      label466:
      int j = 0;
      label475:
      label478:
      label483:
      label489:
      label500:
      while (i < j)
      {
        break label204;
        break label270;
        i = paramInt;
        break label270;
        j = 0;
        break;
        i = paramInt;
        if (paramInt < j) {
          break label114;
        }
        break label182;
      }
    }
  }
  
  public static void c(g paramg)
  {
    int j = 0;
    AppMethodBeat.i(246161);
    if (paramg != null)
    {
      Object localObject1 = (CharSequence)paramg.desc;
      int i;
      label48:
      Object localObject2;
      Object localObject3;
      label74:
      Object localObject4;
      label118:
      label122:
      boolean bool1;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label501;
        }
        localObject1 = paramg.desc;
        localObject2 = paramg.uDs;
        p.g(localObject2, "liveData.msgList");
        localObject3 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label575;
        }
        localObject2 = ((Iterator)localObject3).next();
        i = ((t)localObject2).getType();
        localObject4 = o.c.hGH;
        if (i != o.c.aFw()) {
          break label570;
        }
        i = 1;
        if (i == 0) {
          break label573;
        }
        if (localObject2 == null) {
          break label581;
        }
        bool1 = true;
        label129:
        localObject2 = TAG;
        localObject3 = new StringBuilder("[START_LIVE], desc is empty:");
        localObject4 = (CharSequence)localObject1;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label586;
        }
      }
      label570:
      label573:
      label575:
      label581:
      label586:
      for (boolean bool2 = true;; bool2 = false)
      {
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
          break label592;
        }
        FinderObject localFinderObject = paramg.uDz;
        if (localFinderObject == null) {
          break label592;
        }
        localObject4 = new awq();
        avn localavn = new avn();
        FinderContact localFinderContact = new FinderContact();
        localObject2 = localFinderObject.contact;
        if (localObject2 != null)
        {
          localObject3 = ((FinderContact)localObject2).username;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localFinderContact.username = ((String)localObject2);
        localObject2 = localFinderObject.contact;
        if (localObject2 != null)
        {
          localObject3 = ((FinderContact)localObject2).nickname;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localFinderContact.nickname = ((String)localObject2);
        localObject2 = localFinderObject.contact;
        if (localObject2 != null)
        {
          localObject3 = ((FinderContact)localObject2).headUrl;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localFinderContact.headUrl = ((String)localObject2);
        localavn.contact = localFinderContact;
        ((awq)localObject4).LHp = localavn;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        ((awq)localObject4).content = ((String)localObject2);
        localObject1 = o.c.hGH;
        ((awq)localObject4).type = o.c.aFw();
        localObject1 = new r((awq)localObject4);
        paramg.uDs.add(localObject1);
        Log.i(TAG, "appendWelcomeTip:" + ((r)localObject1).uke.content);
        AppMethodBeat.o(246161);
        return;
        i = 0;
        break;
        label501:
        if (paramg.uDm == null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
          localObject1 = e.a.Fy(paramg.hFK);
          if (localObject1 != null)
          {
            localObject1 = ((FinderItem)localObject1).getDescription();
            break label48;
          }
          localObject1 = null;
          break label48;
        }
        localObject1 = paramg.uDm;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).description;
          break label48;
        }
        localObject1 = null;
        break label48;
        i = 0;
        break label118;
        break label74;
        localObject2 = null;
        break label122;
        bool1 = false;
        break label129;
      }
      label592:
      AppMethodBeat.o(246161);
      return;
    }
    AppMethodBeat.o(246161);
  }
  
  public static void c(g paramg, LinkedList<awq> paramLinkedList)
  {
    AppMethodBeat.i(246154);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveMsg");
    paramg.uDt.clear();
    paramg = paramg.uDt;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      awq localawq = (awq)localObject2;
      if (kotlin.a.e.contains(uiS, localawq.type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    paramg.addAll((Collection)localLinkedList);
    AppMethodBeat.o(246154);
  }
  
  public static void d(g paramg)
  {
    AppMethodBeat.i(246162);
    awq localawq = new awq();
    Object localObject = o.c.hGH;
    localawq.type = o.c.aFo();
    if (!paramg.diZ())
    {
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
    }
    for (localObject = ((Context)localObject).getResources().getString(2131759985);; localObject = ((Context)localObject).getResources().getString(2131759983))
    {
      localawq.content = ((String)localObject);
      localObject = new r(localawq);
      paramg.uDs.add(localObject);
      Log.i(TAG, "appendLinkMicTip:" + ((r)localObject).uke.content);
      AppMethodBeat.o(246162);
      return;
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
    }
  }
  
  public static void d(g paramg, LinkedList<awq> paramLinkedList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(246155);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveMsg");
    Object localObject1 = (List)paramLinkedList;
    Object localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
    for (;;)
    {
      if (((ListIterator)localObject3).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject3).previous();
        Object localObject4 = (awq)localObject1;
        if (kotlin.a.e.contains(uiT, ((awq)localObject4).type))
        {
          localObject1 = (awq)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((awq)localObject1).content;
            if (localObject1 != null)
            {
              localObject3 = atE((String)localObject1);
              localObject4 = paramg.uEm;
              String str = TAG;
              StringBuilder localStringBuilder = new StringBuilder("filterPromoteProduct remotePromoting:");
              if (localObject3 == null) {
                break label305;
              }
              localObject1 = ((axg)localObject3).title;
              label137:
              localStringBuilder = localStringBuilder.append((String)localObject1).append(",localPromoting:");
              localObject1 = localObject2;
              if (localObject4 != null) {
                localObject1 = ((axg)localObject4).title;
              }
              Log.i(str, (String)localObject1);
              if ((localObject3 == null) || (localObject4 == null) || (((axg)localObject3).LHK != 0) || (((axg)localObject4).uko == ((axg)localObject3).uko)) {
                break label310;
              }
              Log.i(TAG, "filterPromoteProduct remote productId:" + ((axg)localObject3).uko + " promoting:" + ((axg)localObject3).LHK + ", local productId:" + ((axg)localObject4).uko + " promoting:" + ((axg)localObject4).LHK);
            }
          }
        }
      }
    }
    for (;;)
    {
      kotlin.a.j.c((List)paramLinkedList, (kotlin.g.a.b)c.ujd);
      AppMethodBeat.o(246155);
      return;
      localObject1 = null;
      break;
      label305:
      localObject1 = null;
      break label137;
      label310:
      paramg.b((axg)localObject3);
      paramg = paramg.uEm;
      if (paramg != null)
      {
        localObject1 = o.ujN;
        localObject1 = o.getFinderLiveAssistant();
        if (localObject1 != null) {
          ((s)localObject1).a(paramg);
        }
      }
    }
  }
  
  public static void e(g paramg)
  {
    AppMethodBeat.i(246163);
    awq localawq = new awq();
    Object localObject = o.c.hGH;
    localawq.type = o.c.aFo();
    if (!paramg.dja())
    {
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
    }
    for (localObject = ((Context)localObject).getResources().getString(2131759942);; localObject = ((Context)localObject).getResources().getString(2131759940))
    {
      localawq.content = ((String)localObject);
      localObject = new r(localawq);
      paramg.uDs.add(localObject);
      Log.i(TAG, "appendGiftTip:" + ((r)localObject).uke.content);
      AppMethodBeat.o(246163);
      return;
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
    }
  }
  
  public static void e(g paramg, LinkedList<awq> paramLinkedList)
  {
    AppMethodBeat.i(246157);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveMsg");
    paramg.uDu.clear();
    paramg = paramg.uDu;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      awq localawq = (awq)localObject2;
      if (kotlin.a.e.contains(uiV, localawq.type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    paramg.addAll((Collection)localLinkedList);
    AppMethodBeat.o(246157);
  }
  
  public static void f(g paramg, LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(246158);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveAppMsg");
    String str = z.aTY();
    paramg.uDv.clear();
    List localList = paramg.uDv;
    Object localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      aut localaut = (aut)localObject3;
      if (kotlin.a.e.contains(uiW, localaut.ybm)) {
        paramLinkedList.add(localObject3);
      }
    }
    ((LinkedList)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = paramLinkedList.iterator();
    label211:
    label243:
    label246:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramLinkedList = ((aut)localObject3).LFE;
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.contact;
        if (paramLinkedList != null)
        {
          paramLinkedList = paramLinkedList.username;
          if (Util.isEqual(paramLinkedList, str)) {
            break label243;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label246;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        paramLinkedList = null;
        break label211;
      }
    }
    localList.addAll((Collection)localObject1);
    Log.i(TAG, "handleHighLightCheerMsg roomData.highLightCheerList:" + paramg.uDv.size());
    AppMethodBeat.o(246158);
  }
  
  public static void g(g paramg, LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(246159);
    p.h(paramg, "roomData");
    p.h(paramLinkedList, "remoteLiveAppMsg");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (aut)localObject2;
      if (kotlin.a.e.contains(uiY, ((aut)localObject3).ybm)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    Object localObject3 = ((Iterable)localLinkedList).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        aut localaut = (aut)((Iterator)localObject3).next();
        auw localauw = new auw();
        localObject1 = (com.tencent.mm.bw.a)localauw;
        paramLinkedList = localaut.LFB;
        if (paramLinkedList != null) {
          paramLinkedList = paramLinkedList.toByteArray();
        }
        try
        {
          for (;;)
          {
            ((com.tencent.mm.bw.a)localObject1).parseFrom(paramLinkedList);
            kotlin.a.j.c((List)paramg.uEz, (kotlin.g.a.b)new e(localauw));
            ArrayList localArrayList = paramg.uEz;
            String str = localauw.Lmn;
            paramLinkedList = localaut.LFE;
            if (paramLinkedList == null) {
              break label483;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label483;
            }
            paramLinkedList = paramLinkedList.headUrl;
            localObject1 = localaut.LFE;
            if (localObject1 == null) {
              break label488;
            }
            localObject1 = ((avn)localObject1).contact;
            if (localObject1 == null) {
              break label488;
            }
            localObject1 = ((FinderContact)localObject1).username;
            localObject2 = localaut.LFE;
            if (localObject2 == null) {
              break label493;
            }
            localObject2 = ((avn)localObject2).contact;
            if (localObject2 == null) {
              break label493;
            }
            localObject2 = ((FinderContact)localObject2).nickname;
            localArrayList.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str, paramLinkedList, (String)localObject1, (String)localObject2, localauw.LFG, localaut.session_id));
            kotlin.a.j.c((List)paramg.uEA, (kotlin.g.a.b)new f(localauw));
            localArrayList = paramg.uEA;
            str = localauw.Lmn;
            paramLinkedList = localaut.LFE;
            if (paramLinkedList == null) {
              break label498;
            }
            paramLinkedList = paramLinkedList.contact;
            if (paramLinkedList == null) {
              break label498;
            }
            paramLinkedList = paramLinkedList.headUrl;
            localObject1 = localaut.LFE;
            if (localObject1 == null) {
              break label503;
            }
            localObject1 = ((avn)localObject1).contact;
            if (localObject1 == null) {
              break label503;
            }
            localObject1 = ((FinderContact)localObject1).username;
            localObject2 = localaut.LFE;
            if (localObject2 == null) {
              break label508;
            }
            localObject2 = ((avn)localObject2).contact;
            if (localObject2 == null) {
              break label508;
            }
            localObject2 = ((FinderContact)localObject2).nickname;
            localArrayList.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str, paramLinkedList, (String)localObject1, (String)localObject2, localauw.LFG, localaut.session_id));
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
            label483:
            paramLinkedList = null;
            continue;
            label488:
            localObject1 = null;
            continue;
            label493:
            localObject2 = null;
            continue;
            label498:
            paramLinkedList = null;
            continue;
            label503:
            localObject1 = null;
            continue;
            label508:
            localObject2 = null;
          }
        }
      }
    }
    Log.i(TAG, "handleLinkMicMsg applyMicMsgList:" + localLinkedList.size());
    AppMethodBeat.o(246159);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<aut, Boolean>
  {
    public static final a ujb;
    
    static
    {
      AppMethodBeat.i(246140);
      ujb = new a();
      AppMethodBeat.o(246140);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<aut, p.b>
  {
    public static final b ujc;
    
    static
    {
      AppMethodBeat.i(246142);
      ujc = new b();
      AppMethodBeat.o(246142);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<awq, Boolean>
  {
    public static final c ujd;
    
    static
    {
      AppMethodBeat.i(246144);
      ujd = new c();
      AppMethodBeat.o(246144);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(246145);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((t)paramT1).cKo()), (Comparable)Long.valueOf(((t)paramT2).cKo()));
      AppMethodBeat.o(246145);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean>
  {
    e(auw paramauw)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean>
  {
    f(auw paramauw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.i
 * JD-Core Version:    0.7.0.1
 */