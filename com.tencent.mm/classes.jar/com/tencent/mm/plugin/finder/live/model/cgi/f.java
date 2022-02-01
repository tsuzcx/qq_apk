package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "liveId", "", "objectId", "objectNonceId", "", "username", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListRequest;", "dumpLocalGift", "gift", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "dumpRemoteGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalGift", "remoteGift", "Ljava/util/LinkedList;", "CallBack", "plugin-finder_release"})
public final class f
  extends k<ata>
{
  private final String TAG;
  private asz ukE;
  private final a ukF;
  
  public f(long paramLong1, long paramLong2, String paramString1, String paramString2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246308);
    this.ukF = parama;
    this.TAG = "Finder.CgiFinderGetLiveGiftList";
    this.ukE = new asz();
    parama = this.ukE;
    Object localObject = am.tuw;
    parama.LBM = am.cXY();
    this.ukE.hyH = paramLong1;
    this.ukE.object_id = paramLong2;
    this.ukE.object_nonce_id = paramString1;
    this.ukE.username = paramString2;
    parama = this.ukE;
    localObject = o.ujN;
    parama.LDs = o.dgc();
    Log.i(this.TAG, "liveId:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString1 + " username:" + paramString2);
    paramString1 = new d.a();
    paramString1.c((a)this.ukE);
    paramString2 = new ata();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/findergetliverewardgiftlist");
    paramString1.sG(4053);
    c(paramString1.aXF());
    AppMethodBeat.o(246308);
  }
  
  private static String a(s params)
  {
    AppMethodBeat.i(246307);
    params = "localGift : [id:" + params.field_rewardProductId + ", businessType:" + params.field_businessType + ", thumbnailFileUrl:" + params.field_thumbnailFileUrl + ", previewUrl:" + params.field_previewPagUrl + ", animationUrl:" + params.field_animationPagUrl + ", thumbnailMd5:" + params.field_thumbnailMd5 + ", previewMd5:" + params.field_previewPagMd5 + ", animationMd5:" + params.field_animationPagMd5 + ", type:" + params.field_giftType + ", name:" + params.field_name + ", price:" + params.field_price + ", state:" + params.field_state + ']';
    AppMethodBeat.o(246307);
    return params;
  }
  
  private static String a(awd paramawd)
  {
    AppMethodBeat.i(246306);
    paramawd = "remoteGift : [id:" + paramawd.LFM + ", businessType:" + paramawd.KTE + ", thumbnailFileUrl:" + paramawd.LGJ + ", previewUrl:" + paramawd.LGK + ", animationUrl:" + paramawd.LGL + ", thumbnailMd5:" + paramawd.LGM + ", previewMd5:" + paramawd.LGN + ", animationMd5:" + paramawd.LGO + ", type:" + paramawd.LGQ + ", name:" + paramawd.name + ", price:" + paramawd.LGP + ']';
    AppMethodBeat.o(246306);
    return paramawd;
  }
  
  private final void am(LinkedList<awd> paramLinkedList)
  {
    AppMethodBeat.i(246305);
    Object localObject3 = ((PluginFinder)g.ah(PluginFinder.class)).getLiveGiftStorage();
    Object localObject1 = ((t)localObject3).dxR();
    if (((Collection)localObject1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      i = 0;
      while (paramLinkedList.hasNext())
      {
        localObject1 = paramLinkedList.next();
        if (i < 0) {
          j.hxH();
        }
        localObject1 = (awd)localObject1;
        localObject2 = new s();
        ((s)localObject2).field_rewardProductId = ((awd)localObject1).LFM;
        ((s)localObject2).field_businessType = ((awd)localObject1).KTE;
        ((s)localObject2).field_thumbnailFileUrl = ((awd)localObject1).LGJ;
        ((s)localObject2).field_previewPagUrl = ((awd)localObject1).LGK;
        ((s)localObject2).field_animationPagUrl = ((awd)localObject1).LGL;
        ((s)localObject2).field_thumbnailMd5 = ((awd)localObject1).LGM;
        ((s)localObject2).field_previewPagMd5 = ((awd)localObject1).LGN;
        ((s)localObject2).field_animationPagMd5 = ((awd)localObject1).LGO;
        ((s)localObject2).field_giftType = ((awd)localObject1).LGQ;
        ((s)localObject2).field_name = ((awd)localObject1).name;
        ((s)localObject2).field_price = ((awd)localObject1).LGP;
        ((s)localObject2).field_giftIndex = i;
        ((PluginFinder)g.ah(PluginFinder.class)).getLiveGiftStorage().b((s)localObject2);
        Log.i(this.TAG, a((awd)localObject1));
        i += 1;
      }
    }
    Object localObject4 = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject5 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject5).hasNext())
    {
      s locals = (s)((Iterator)localObject5).next();
      Object localObject6 = ((Iterable)paramLinkedList).iterator();
      label357:
      boolean bool1;
      while (((Iterator)localObject6).hasNext())
      {
        localObject1 = ((Iterator)localObject6).next();
        if (Util.isEqual(((awd)localObject1).LFM, locals.field_rewardProductId))
        {
          if (localObject1 != null) {
            break label632;
          }
          bool1 = true;
          label365:
          localObject6 = ((Iterable)paramLinkedList).iterator();
          label376:
          if (!((Iterator)localObject6).hasNext()) {
            break label643;
          }
          localObject1 = ((Iterator)localObject6).next();
          awd localawd = (awd)localObject1;
          if ((!Util.isEqual(localawd.LFM, locals.field_rewardProductId)) || ((Util.isEqual(localawd.LGJ, locals.field_thumbnailFileUrl)) && (Util.isEqual(localawd.LGK, locals.field_previewPagUrl)) && (Util.isEqual(localawd.LGL, locals.field_animationPagUrl)))) {
            break label638;
          }
          i = 1;
          label468:
          if (i == 0) {
            break label641;
          }
          label472:
          if (localObject1 == null) {
            break label649;
          }
        }
      }
      label641:
      label643:
      label649:
      for (boolean bool2 = true;; bool2 = false)
      {
        localObject1 = (Map)localObject2;
        localObject6 = locals.field_rewardProductId;
        p.g(localObject6, "localGiftInfo.field_rewardProductId");
        ((Map)localObject1).put(localObject6, Integer.valueOf(locals.field_state));
        if ((bool1) || (bool2))
        {
          ((ArrayList)localObject4).add(locals);
          localObject1 = (Map)localObject2;
          localObject6 = locals.field_rewardProductId;
          p.g(localObject6, "localGiftInfo.field_rewardProductId");
          ((Map)localObject1).put(localObject6, Integer.valueOf(0));
        }
        Log.i(this.TAG, "localGiftDeprecated:" + bool1 + ", localGiftUrlDeprecated:" + bool2 + ' ' + a(locals));
        break;
        localObject1 = null;
        break label357;
        label632:
        bool1 = false;
        break label365;
        label638:
        i = 0;
        break label468;
        break label376;
        localObject1 = null;
        break label472;
      }
    }
    localObject1 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (s)((Iterator)localObject1).next();
      localObject5 = ((s)localObject4).field_rewardProductId;
      i = ((t)localObject3).db.delete("FinderLiveGiftInfo", "rewardProductId=?", new String[] { String.valueOf(localObject5) });
      Log.i(this.TAG, "remove " + i + ' ' + a((s)localObject4));
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    i = 0;
    if (paramLinkedList.hasNext())
    {
      localObject1 = paramLinkedList.next();
      if (i < 0) {
        j.hxH();
      }
      localObject1 = (awd)localObject1;
      localObject3 = new s();
      ((s)localObject3).field_rewardProductId = ((awd)localObject1).LFM;
      ((s)localObject3).field_businessType = ((awd)localObject1).KTE;
      ((s)localObject3).field_thumbnailFileUrl = ((awd)localObject1).LGJ;
      ((s)localObject3).field_previewPagUrl = ((awd)localObject1).LGK;
      ((s)localObject3).field_animationPagUrl = ((awd)localObject1).LGL;
      ((s)localObject3).field_thumbnailMd5 = ((awd)localObject1).LGM;
      ((s)localObject3).field_previewPagMd5 = ((awd)localObject1).LGN;
      ((s)localObject3).field_animationPagMd5 = ((awd)localObject1).LGO;
      ((s)localObject3).field_giftType = ((awd)localObject1).LGQ;
      ((s)localObject3).field_name = ((awd)localObject1).name;
      localObject4 = (Integer)((Map)localObject2).get(((awd)localObject1).LFM);
      if (localObject4 != null) {}
      for (int j = ((Integer)localObject4).intValue();; j = 0)
      {
        ((s)localObject3).field_state = j;
        ((s)localObject3).field_price = ((awd)localObject1).LGP;
        ((s)localObject3).field_giftIndex = i;
        ((PluginFinder)g.ah(PluginFinder.class)).getLiveGiftStorage().b((s)localObject3);
        Log.i(this.TAG, a((awd)localObject1));
        i += 1;
        break;
      }
    }
    paramLinkedList = e.uiD;
    e.dfz();
    AppMethodBeat.o(246305);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, ata paramata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */