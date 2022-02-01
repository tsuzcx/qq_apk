package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.c.a.a.a.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.c.cl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "liveId", "", "objectId", "objectNonceId", "", "username", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "dumpLocalGift", "gift", "Lcom/tencent/mm/autogen/table/BaseFinderLiveGiftInfo;", "dumpRemoteGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalGift", "remoteGift", "Ljava/util/LinkedList;", "CallBack", "plugin-finder_release"})
public final class j
  extends n<avd>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private avc yjb;
  private final a yjc;
  
  public j(long paramLong1, long paramLong2, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(272253);
    this.yjc = parama;
    this.TAG = "Finder.CgiFinderGetLiveGiftList";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yjb = new avc();
    parama = this.yjb;
    Object localObject = ao.xcj;
    parama.RLM = ao.dnO();
    this.yjb.klE = paramLong1;
    this.yjb.object_id = paramLong2;
    this.yjb.object_nonce_id = paramString1;
    this.yjb.username = paramString2;
    parama = this.yjb;
    localObject = ah.yhC;
    parama.SDI = ah.dzm();
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("username", paramString2);
    Log.i(this.TAG, "liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " username:" + paramString2);
    paramString1 = new d.a();
    paramString1.c((a)this.yjb);
    paramString2 = new avd();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/findergetliverewardgiftlist");
    paramString1.vD(4053);
    c(paramString1.bgN());
    AppMethodBeat.o(272253);
  }
  
  private static String a(cl paramcl)
  {
    AppMethodBeat.i(272252);
    paramcl = "localGift : [id:" + paramcl.field_rewardProductId + ", businessType:" + paramcl.field_businessType + ", thumbnailFileUrl:" + paramcl.field_thumbnailFileUrl + ", previewUrl:" + paramcl.field_previewPagUrl + ", animationUrl:" + paramcl.field_animationPagUrl + ", thumbnailMd5:" + paramcl.field_thumbnailMd5 + ", previewMd5:" + paramcl.field_previewPagMd5 + ", animationMd5:" + paramcl.field_animationPagMd5 + ", type:" + paramcl.field_giftType + ", name:" + paramcl.field_name + ", price:" + paramcl.field_price + ", state:" + paramcl.field_state + ']';
    AppMethodBeat.o(272252);
    return paramcl;
  }
  
  private static String a(bab parambab)
  {
    AppMethodBeat.i(272251);
    parambab = "remoteGift : [id:" + parambab.SKd + ", businessType:" + parambab.RUA + ", thumbnailFileUrl:" + parambab.SLD + ", previewUrl:" + parambab.SLE + ", animationUrl:" + parambab.SLF + ", thumbnailMd5:" + parambab.SLG + ", previewMd5:" + parambab.SLH + ", animationMd5:" + parambab.SLI + ", type:" + parambab.SLK + ", name:" + parambab.name + ", price:" + parambab.SLJ + ']';
    AppMethodBeat.o(272251);
    return parambab;
  }
  
  private final void an(LinkedList<bab> paramLinkedList)
  {
    AppMethodBeat.i(272250);
    Object localObject3 = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage();
    Object localObject1 = ((c)localObject3).dDN();
    if (((Collection)localObject1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      i = 0;
      while (paramLinkedList.hasNext())
      {
        localObject1 = paramLinkedList.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject1 = (bab)localObject1;
        localObject2 = new com.tencent.c.a.a.a.d.a.b();
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_rewardProductId = ((bab)localObject1).SKd;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_businessType = ((bab)localObject1).RUA;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_thumbnailFileUrl = ((bab)localObject1).SLD;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_previewPagUrl = ((bab)localObject1).SLE;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_animationPagUrl = ((bab)localObject1).SLF;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_thumbnailMd5 = ((bab)localObject1).SLG;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_previewPagMd5 = ((bab)localObject1).SLH;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_animationPagMd5 = ((bab)localObject1).SLI;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_giftType = ((bab)localObject1).SLK;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_name = ((bab)localObject1).name;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_price = ((bab)localObject1).SLJ;
        ((com.tencent.c.a.a.a.d.a.b)localObject2).field_giftIndex = i;
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.c.a.a.a.d.a.b)localObject2);
        Log.i(this.TAG, a((bab)localObject1));
        i += 1;
      }
    }
    Object localObject4 = new ArrayList();
    Object localObject2 = new HashMap();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.c.a.a.a.d.a.b localb = (com.tencent.c.a.a.a.d.a.b)localIterator.next();
      Object localObject5 = ((Iterable)paramLinkedList).iterator();
      label361:
      boolean bool1;
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = ((Iterator)localObject5).next();
        if (Util.isEqual(((bab)localObject1).SKd, localb.field_rewardProductId))
        {
          if (localObject1 != null) {
            break label639;
          }
          bool1 = true;
          label369:
          localObject5 = ((Iterable)paramLinkedList).iterator();
          label380:
          if (!((Iterator)localObject5).hasNext()) {
            break label650;
          }
          localObject1 = ((Iterator)localObject5).next();
          bab localbab = (bab)localObject1;
          if ((!Util.isEqual(localbab.SKd, localb.field_rewardProductId)) || ((Util.isEqual(localbab.SLD, localb.field_thumbnailFileUrl)) && (Util.isEqual(localbab.SLE, localb.field_previewPagUrl)) && (Util.isEqual(localbab.SLF, localb.field_animationPagUrl)))) {
            break label645;
          }
          i = 1;
          label472:
          if (i == 0) {
            break label648;
          }
          label476:
          if (localObject1 == null) {
            break label656;
          }
        }
      }
      label645:
      label648:
      label650:
      label656:
      for (boolean bool2 = true;; bool2 = false)
      {
        localObject1 = (Map)localObject2;
        localObject5 = localb.field_rewardProductId;
        p.j(localObject5, "localGiftInfo.field_rewardProductId");
        ((Map)localObject1).put(localObject5, Integer.valueOf(localb.field_state));
        if ((bool1) || (bool2))
        {
          ((ArrayList)localObject4).add(localb);
          localObject1 = (Map)localObject2;
          localObject5 = localb.field_rewardProductId;
          p.j(localObject5, "localGiftInfo.field_rewardProductId");
          ((Map)localObject1).put(localObject5, Integer.valueOf(0));
        }
        Log.i(this.TAG, "localGiftDeprecated:" + bool1 + ", localGiftUrlDeprecated:" + bool2 + ' ' + a((cl)localb));
        break;
        localObject1 = null;
        break label361;
        label639:
        bool1 = false;
        break label369;
        i = 0;
        break label472;
        break label380;
        localObject1 = null;
        break label476;
      }
    }
    localObject1 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.tencent.c.a.a.a.d.a.b)((Iterator)localObject1).next();
      i = ((c)localObject3).aCH(((com.tencent.c.a.a.a.d.a.b)localObject4).field_rewardProductId);
      Log.i(this.TAG, "remove " + i + ' ' + a((cl)localObject4));
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    i = 0;
    if (paramLinkedList.hasNext())
    {
      localObject1 = paramLinkedList.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject1 = (bab)localObject1;
      localObject3 = new com.tencent.c.a.a.a.d.a.b();
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_rewardProductId = ((bab)localObject1).SKd;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_businessType = ((bab)localObject1).RUA;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_thumbnailFileUrl = ((bab)localObject1).SLD;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_previewPagUrl = ((bab)localObject1).SLE;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_animationPagUrl = ((bab)localObject1).SLF;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_thumbnailMd5 = ((bab)localObject1).SLG;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_previewPagMd5 = ((bab)localObject1).SLH;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_animationPagMd5 = ((bab)localObject1).SLI;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_giftType = ((bab)localObject1).SLK;
      ((com.tencent.c.a.a.a.d.a.b)localObject3).field_name = ((bab)localObject1).name;
      localObject4 = (Integer)((HashMap)localObject2).get(((bab)localObject1).SKd);
      if (localObject4 != null) {}
      for (int j = ((Integer)localObject4).intValue();; j = 0)
      {
        ((com.tencent.c.a.a.a.d.a.b)localObject3).field_state = j;
        ((com.tencent.c.a.a.a.d.a.b)localObject3).field_price = ((bab)localObject1).SLJ;
        ((com.tencent.c.a.a.a.d.a.b)localObject3).field_giftIndex = i;
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveGiftStorage().a((com.tencent.c.a.a.a.d.a.b)localObject3);
        Log.i(this.TAG, a((bab)localObject1));
        i += 1;
        break;
      }
    }
    paramLinkedList = m.yfw;
    m.dyx();
    AppMethodBeat.o(272250);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, avd paramavd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */