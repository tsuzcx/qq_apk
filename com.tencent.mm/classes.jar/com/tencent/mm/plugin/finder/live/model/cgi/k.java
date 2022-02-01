package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.d.a.a.a.d.a.d.a;
import com.tencent.d.a.a.a.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.autogen.b.cs;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "liveId", "", "objectId", "objectNonceId", "", "username", "scene", "", "(JJLjava/lang/String;Ljava/lang/String;I)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "checkJoinFansClubGift", "", "remoteGift", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "dumpLocalGift", "gift", "Lcom/tencent/mm/autogen/table/BaseFinderLiveGiftInfo;", "dumpRemoteGift", "initReqResp", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalGift", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends o<bab>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private baa CJh;
  private final String TAG;
  
  public k(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(360331);
    this.TAG = "Finder.CgiFinderGetLiveGiftList";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CJh = new baa();
    baa localbaa = this.CJh;
    Object localObject = bi.ABn;
    localbaa.YIY = bi.dVu();
    this.CJh.mMJ = paramLong1;
    this.CJh.object_id = paramLong2;
    this.CJh.object_nonce_id = paramString1;
    this.CJh.username = paramString2;
    localbaa = this.CJh;
    localObject = aj.CGT;
    localbaa.ZEQ = aj.elt();
    this.CJh.scene = paramInt;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("username", paramString2);
    Log.i(this.TAG, "liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " username:" + paramString2 + ",scene:" + this.CJh.scene);
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CJh);
    paramString2 = new bab();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/findergetliverewardgiftlist";
    paramString1.funcId = 4053;
    c(paramString1.bEF());
    AppMethodBeat.o(360331);
  }
  
  private static String a(cs paramcs)
  {
    AppMethodBeat.i(360368);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("localGift : [id:").append(paramcs.field_rewardProductId).append(", businessType:").append(paramcs.field_businessType).append(", thumbnailFileUrl:").append(paramcs.field_thumbnailFileUrl).append(", previewUrl:").append(paramcs.field_previewPagUrl).append(", animationUrl:").append(paramcs.field_animationPagUrl).append(", thumbnailMd5:").append(paramcs.field_thumbnailMd5).append(", previewMd5:").append(paramcs.field_previewPagMd5).append(", animationMd5:").append(paramcs.field_animationPagMd5).append(", type:").append(paramcs.field_giftType).append(", name:").append(paramcs.field_name).append(", price:").append(paramcs.field_price).append("，flag:");
    localStringBuilder.append(paramcs.field_flag).append(", state:").append(paramcs.field_state).append(']');
    paramcs = localStringBuilder.toString();
    AppMethodBeat.o(360368);
    return paramcs;
  }
  
  private static String a(bim parambim)
  {
    AppMethodBeat.i(360360);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remoteGift : [id:").append(parambim.ZOC).append(", businessType:").append(parambim.business_type).append(", thumbnailFileUrl:").append(parambim.ZRC).append(", previewUrl:").append(parambim.ZRD).append(", animationUrl:").append(parambim.ZRE).append(", thumbnailMd5:").append(parambim.ZRF).append(", previewMd5:").append(parambim.ZRG).append(", animationMd5:").append(parambim.ZRH).append(", type:").append(parambim.ZRJ).append(", name:").append(parambim.name).append(", price:").append(parambim.ZRI).append("，flag:");
    localStringBuilder.append(parambim.eQp).append(']');
    parambim = localStringBuilder.toString();
    AppMethodBeat.o(360360);
    return parambim;
  }
  
  private final void gv(List<? extends bim> paramList)
  {
    AppMethodBeat.i(360339);
    Object localObject = ((Iterable)paramList).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = ((Iterator)localObject).next();
    } while (!com.tencent.mm.ae.d.ee(((bim)paramList).eQp, 4));
    for (;;)
    {
      paramList = (bim)paramList;
      if (paramList != null)
      {
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
        if (localObject != null)
        {
          d.a locala = com.tencent.d.a.a.a.d.a.d.ahpO;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)localObject).b(d.a.b(paramList));
        }
        Log.i(this.TAG, "join fans club Gift : [id:" + paramList.ZOC + ", type:" + paramList.ZRJ + ", name:" + paramList.name + ", price:" + paramList.ZRI + "，flag:" + paramList.eQp + ']');
      }
      AppMethodBeat.o(360339);
      return;
      paramList = null;
    }
  }
  
  private final void gw(List<? extends bim> paramList)
  {
    AppMethodBeat.i(360353);
    Object localObject3 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage();
    Object localObject1 = ((e)localObject3).etX();
    Object localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramList = ((Iterable)paramList).iterator();
      i = 0;
      while (paramList.hasNext())
      {
        localObject1 = paramList.next();
        if (i < 0) {
          p.kkW();
        }
        localObject1 = (bim)localObject1;
        localObject2 = new com.tencent.d.a.a.a.d.a.d();
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_rewardProductId = ((bim)localObject1).ZOC;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_businessType = ((bim)localObject1).business_type;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_thumbnailFileUrl = ((bim)localObject1).ZRC;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_previewPagUrl = ((bim)localObject1).ZRD;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_animationPagUrl = ((bim)localObject1).ZRE;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_thumbnailMd5 = ((bim)localObject1).ZRF;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_previewPagMd5 = ((bim)localObject1).ZRG;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_animationPagMd5 = ((bim)localObject1).ZRH;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_giftType = ((bim)localObject1).ZRJ;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_flag = ((bim)localObject1).eQp;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_unlockIntimacyLevel = ((bim)localObject1).ZRK;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_name = ((bim)localObject1).name;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_price = ((bim)localObject1).ZRI;
        ((com.tencent.d.a.a.a.d.a.d)localObject2).field_giftIndex = i;
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.d.a.a.a.d.a.d)localObject2);
        Log.i(this.TAG, a((bim)localObject1));
        i += 1;
      }
    }
    Object localObject4 = new ArrayList();
    localObject2 = new HashMap();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.d.a.a.a.d.a.d locald = (com.tencent.d.a.a.a.d.a.d)localIterator.next();
      Object localObject5 = ((Iterable)paramList).iterator();
      label390:
      boolean bool1;
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = ((Iterator)localObject5).next();
        if (Util.isEqual(((bim)localObject1).ZOC, locald.field_rewardProductId))
        {
          if (localObject1 != null) {
            break label668;
          }
          bool1 = true;
          label398:
          localObject5 = ((Iterable)paramList).iterator();
          label409:
          if (!((Iterator)localObject5).hasNext()) {
            break label679;
          }
          localObject1 = ((Iterator)localObject5).next();
          bim localbim = (bim)localObject1;
          if ((!Util.isEqual(localbim.ZOC, locald.field_rewardProductId)) || ((Util.isEqual(localbim.ZRC, locald.field_thumbnailFileUrl)) && (Util.isEqual(localbim.ZRD, locald.field_previewPagUrl)) && (Util.isEqual(localbim.ZRE, locald.field_animationPagUrl)))) {
            break label674;
          }
          i = 1;
          label501:
          if (i == 0) {
            break label677;
          }
          label505:
          if (localObject1 == null) {
            break label685;
          }
        }
      }
      label668:
      label674:
      label677:
      label679:
      label685:
      for (boolean bool2 = true;; bool2 = false)
      {
        localObject1 = (Map)localObject2;
        localObject5 = locald.field_rewardProductId;
        s.s(localObject5, "localGiftInfo.field_rewardProductId");
        ((Map)localObject1).put(localObject5, Integer.valueOf(locald.field_state));
        if ((bool1) || (bool2))
        {
          ((ArrayList)localObject4).add(locald);
          localObject1 = (Map)localObject2;
          localObject5 = locald.field_rewardProductId;
          s.s(localObject5, "localGiftInfo.field_rewardProductId");
          ((Map)localObject1).put(localObject5, Integer.valueOf(0));
        }
        Log.i(this.TAG, "localGiftDeprecated:" + bool1 + ", localGiftUrlDeprecated:" + bool2 + ' ' + a((cs)locald));
        break;
        localObject1 = null;
        break label390;
        bool1 = false;
        break label398;
        i = 0;
        break label501;
        break label409;
        localObject1 = null;
        break label505;
      }
    }
    localObject1 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.tencent.d.a.a.a.d.a.d)((Iterator)localObject1).next();
      i = ((e)localObject3).axI(((com.tencent.d.a.a.a.d.a.d)localObject4).field_rewardProductId);
      Log.i(this.TAG, "remove " + i + ' ' + a((cs)localObject4));
    }
    paramList = ((Iterable)paramList).iterator();
    i = 0;
    if (paramList.hasNext())
    {
      localObject1 = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject1 = (bim)localObject1;
      localObject3 = new com.tencent.d.a.a.a.d.a.d();
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_rewardProductId = ((bim)localObject1).ZOC;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_businessType = ((bim)localObject1).business_type;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_thumbnailFileUrl = ((bim)localObject1).ZRC;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_previewPagUrl = ((bim)localObject1).ZRD;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_animationPagUrl = ((bim)localObject1).ZRE;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_thumbnailMd5 = ((bim)localObject1).ZRF;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_previewPagMd5 = ((bim)localObject1).ZRG;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_animationPagMd5 = ((bim)localObject1).ZRH;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_giftType = ((bim)localObject1).ZRJ;
      ((com.tencent.d.a.a.a.d.a.d)localObject3).field_name = ((bim)localObject1).name;
      localObject4 = (Integer)((Map)localObject2).get(((bim)localObject1).ZOC);
      if (localObject4 == null) {}
      for (int j = 0;; j = ((Integer)localObject4).intValue())
      {
        ((com.tencent.d.a.a.a.d.a.d)localObject3).field_state = j;
        ((com.tencent.d.a.a.a.d.a.d)localObject3).field_flag = ((bim)localObject1).eQp;
        ((com.tencent.d.a.a.a.d.a.d)localObject3).field_unlockIntimacyLevel = ((bim)localObject1).ZRK;
        ((com.tencent.d.a.a.a.d.a.d)localObject3).field_price = ((bim)localObject1).ZRI;
        ((com.tencent.d.a.a.a.d.a.d)localObject3).field_giftIndex = i;
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.d.a.a.a.d.a.d)localObject3);
        Log.i(this.TAG, a((bim)localObject1));
        i += 1;
        break;
      }
    }
    paramList = q.CFU;
    q.ekO();
    AppMethodBeat.o(360353);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.k
 * JD-Core Version:    0.7.0.1
 */