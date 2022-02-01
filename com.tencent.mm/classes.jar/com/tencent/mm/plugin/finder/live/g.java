package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPayloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBuyPayloadForBubbleClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "locClickId", "", "getDetailPayloadForBubbleClick", "getHalfMiniProgramHeight", "", "getNormalPayloadForBubbleClick", "getPayloadForAddProduct", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gotoHalfScreen", "bundle", "getPayloadForOrder", "getPayloadForProductBuyClick", "getPayloadForProductItemClick", "getPayloadForVisitorBubbleClick", "printPayload", "plugin-finder_release"})
public final class g
{
  private static final String TAG = "FinderLive.MiniProgramPayloadHelper";
  public static final g ufT;
  
  static
  {
    AppMethodBeat.i(245869);
    ufT = new g();
    TAG = "FinderLive.MiniProgramPayloadHelper";
    AppMethodBeat.o(245869);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, axg paramaxg, kotlin.g.a.m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, kotlin.x> paramm)
  {
    Object localObject3 = null;
    AppMethodBeat.i(245864);
    p.h(paramg, "liveData");
    if (paramaxg == null)
    {
      Log.i(TAG, "[getPayloadForProductItemClick] fail, liveData is null:false,data is null:true!");
      AppMethodBeat.o(245864);
      return;
    }
    Object localObject1 = y.vXH;
    boolean bool1 = y.c(paramaxg);
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool2 = com.tencent.mm.plugin.finder.storage.c.duW();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject4 = new StringBuilder("[getPayloadForProductItemClick] appId:");
    localObject1 = paramaxg.LHI;
    com.tencent.mm.plugin.appbrand.api.g localg;
    label270:
    label334:
    com.tencent.mm.plugin.finder.live.model.x localx;
    if (localObject1 != null)
    {
      localObject1 = ((det)localObject1).appId;
      Log.i((String)localObject2, (String)localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + arrayOfByte + '!');
      localg = new com.tencent.mm.plugin.appbrand.api.g();
      localObject1 = paramaxg.LHI;
      if (localObject1 != null)
      {
        localObject2 = ((det)localObject1).appId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      localObject1 = paramaxg.LHI;
      if (localObject1 != null)
      {
        localObject2 = ((det)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.kHw = ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
        break label597;
      }
      localg.scene = 1176;
      if (paramg.liveInfo.liveId != 0L) {
        break label583;
      }
      localObject1 = "pre_live_detail";
      localObject4 = new StringBuilder().append((String)localObject1).append(':').append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      localObject2 = paramg.uEl;
      if (localObject2 == null) {
        break label591;
      }
      localObject2 = ((awc)localObject2).vtD;
      localg.dCw = ((String)localObject2 + ':' + paramg.sessionId + ':' + arrayOfByte);
      localObject2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject2 = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject4 = localg.dCw;
      p.g(localObject4, "sceneNote");
      ((s)localObject2).auR((String)localObject4);
      localx = new com.tencent.mm.plugin.finder.live.model.x();
      localObject4 = paramaxg.dSJ;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      localx.atG((String)localObject2);
      localx.uko = paramaxg.uko;
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label725;
      }
      paramaxg = paramaxg.ukr;
      label460:
      localx.ukr = paramaxg;
      localx.uks = 1;
      localx.ukt = arrayOfByte;
      paramaxg = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
        break label730;
      }
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      c.a.apD(String.valueOf(localx.ukt));
    }
    for (;;)
    {
      localg.kHx = ((d)localx);
      paramaxg = com.tencent.mm.plugin.finder.report.k.vfA;
      paramaxg = localg.appId;
      p.g(paramaxg, "bundle.appId");
      com.tencent.mm.plugin.finder.report.k.a(3L, paramaxg, arrayOfByte.toString(), 1176L, String.valueOf(paramg.sessionId), (String)localObject1, paramg.dPI);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(245864);
      return;
      localObject1 = null;
      break;
      label583:
      localObject1 = "post_live_detail";
      break label270;
      label591:
      localObject2 = null;
      break label334;
      label597:
      localg.scene = 1177;
      localObject2 = "live_list_detail";
      localObject4 = new StringBuilder().append("live_list_detail").append(':').append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      localObject1 = paramg.uEl;
      if (localObject1 != null) {}
      for (localObject1 = ((awc)localObject1).vtD;; localObject1 = null)
      {
        localg.dCw = ((String)localObject1 + ':' + paramg.sessionId + ':' + arrayOfByte);
        localObject1 = localObject2;
        break;
      }
      label725:
      paramaxg = null;
      break label460;
      label730:
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject2 = String.valueOf(localx.ukt);
      localObject4 = localg.appId;
      String str = b.zs(paramg.liveInfo.liveId);
      awc localawc = paramg.uEl;
      paramaxg = localObject3;
      if (localawc != null) {
        paramaxg = localawc.vtD;
      }
      c.a.f((String)localObject2, (String)localObject4, str, paramaxg, b.zs(paramg.sessionId));
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, kotlin.g.a.m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, kotlin.x> paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(245862);
    p.h(paramg, "liveData");
    String str1 = Util.getUuidRandom().toString();
    Object localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP())
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      c.a.apD(str1);
    }
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject3 = ((awc)localObject1).LGE;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.appId = ((String)localObject1);
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject3 = ((awc)localObject1).LGA;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.kHw = ((String)localObject1);
    Object localObject3 = new com.tencent.mm.plugin.finder.live.model.x();
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject1 = ((awc)localObject1).ukr;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject3).ukr = ((String)localObject1);
      localg.kHx = ((d)localObject3);
      localg.scene = 1177;
      localObject3 = new StringBuilder("live_list_order:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      localObject1 = paramg.uEl;
      if (localObject1 == null) {
        break label379;
      }
    }
    label379:
    for (localObject1 = ((awc)localObject1).vtD;; localObject1 = null)
    {
      localg.dCw = ((String)localObject1 + ':' + paramg.sessionId + ':' + str1 + ':' + Util.getUuidRandom());
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (!com.tencent.mm.plugin.finder.utils.m.dBP())
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject3 = localg.appId;
        String str2 = b.zs(paramg.liveInfo.liveId);
        awc localawc = paramg.uEl;
        localObject1 = localObject2;
        if (localawc != null) {
          localObject1 = localawc.vtD;
        }
        c.a.f(str1, (String)localObject3, str2, (String)localObject1, b.zs(paramg.sessionId));
      }
      paramg = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramg = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject1 = localg.dCw;
      p.g(localObject1, "sceneNote");
      paramg.auR((String)localObject1);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(245862);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, axg paramaxg, kotlin.g.a.m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, kotlin.x> paramm)
  {
    String str = null;
    Object localObject2 = null;
    com.tencent.mm.plugin.appbrand.api.g localg = null;
    AppMethodBeat.i(245865);
    p.h(paramg, "liveData");
    if (paramaxg == null)
    {
      Log.i(TAG, "[getPayloadForProductBuyClick] fail, liveData is null:false,data is null:true!");
      AppMethodBeat.o(245865);
      return;
    }
    Object localObject1 = y.vXH;
    boolean bool1 = y.c(paramaxg);
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool2 = com.tencent.mm.plugin.finder.storage.c.duW();
    Object localObject3 = Util.getUuidRandom();
    Object localObject4 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("[getPayloadForProductBuyClick] appId:");
    localObject1 = paramaxg.LHI;
    if (localObject1 != null)
    {
      localObject1 = ((det)localObject1).appId;
      localStringBuilder = localStringBuilder.append((String)localObject1).append(",purchase appId:");
      localObject1 = paramaxg.LHN;
      if (localObject1 == null) {
        break label588;
      }
      localObject1 = ((det)localObject1).appId;
      label144:
      Log.i((String)localObject4, (String)localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + localObject3 + '!');
      if (bool1 != true) {
        break label1066;
      }
      if (!bool2) {
        break label605;
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
      localObject4 = new com.tencent.mm.plugin.finder.live.model.x();
      str = paramaxg.dSJ;
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).atG((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uko = paramaxg.uko;
      localObject1 = paramg.uEl;
      if (localObject1 == null) {
        break label594;
      }
      localObject1 = ((awc)localObject1).ukr;
      label274:
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukr = ((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uks = 2;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukt = ((byte[])localObject3);
      ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHx = ((d)localObject4);
      localObject1 = paramaxg.LHI;
      if (localObject1 != null)
      {
        str = ((det)localObject1).appId;
        localObject1 = str;
        if (str != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId = ((String)localObject1);
      paramaxg = paramaxg.LHI;
      if (paramaxg != null)
      {
        localObject1 = paramaxg.path;
        paramaxg = (axg)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramaxg = "";
      }
      ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHw = paramaxg;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject2).scene = 1177;
      localObject1 = new StringBuilder("live_list_buy:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label600;
      }
    }
    label588:
    label594:
    label600:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dCw = (paramaxg + ':' + paramg.sessionId + ':' + localObject3);
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject1 = ((byte[])localObject3).toString();
      str = ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId;
      localObject3 = b.zs(paramg.liveInfo.liveId);
      localObject4 = paramg.uEl;
      paramaxg = localg;
      if (localObject4 != null) {
        paramaxg = ((awc)localObject4).vtD;
      }
      c.a.f((String)localObject1, str, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      paramg = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramg = com.tencent.mm.plugin.finder.report.live.k.dpl();
      paramaxg = ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dCw;
      p.g(paramaxg, "sceneNote");
      paramg.auR(paramaxg);
      paramm.invoke(Boolean.FALSE, localObject2);
      AppMethodBeat.o(245865);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label144;
      localObject1 = null;
      break label274;
    }
    label605:
    localg = new com.tencent.mm.plugin.appbrand.api.g();
    localObject4 = new com.tencent.mm.plugin.finder.live.model.x();
    localObject2 = paramaxg.dSJ;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((com.tencent.mm.plugin.finder.live.model.x)localObject4).atG((String)localObject1);
    ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uko = paramaxg.uko;
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject1 = ((awc)localObject1).ukr;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukr = ((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).atH("push");
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uks = 2;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukt = ((byte[])localObject3);
      localg.kHx = ((d)localObject4);
      localObject1 = paramaxg.LHN;
      if (localObject1 != null)
      {
        localObject2 = ((det)localObject1).appId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      paramaxg = paramaxg.LHN;
      if (paramaxg != null)
      {
        localObject1 = paramaxg.path;
        paramaxg = (axg)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramaxg = "";
      }
      localg.kHw = paramaxg;
      localg.scene = 1177;
      localObject1 = new StringBuilder("live_list_buy:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label1061;
      }
    }
    label1061:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      localg.dCw = (paramaxg + ':' + paramg.sessionId + ':' + localObject3);
      paramaxg = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramaxg = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject1 = localg.dCw;
      p.g(localObject1, "sceneNote");
      paramaxg.auR((String)localObject1);
      paramaxg = MMApplicationContext.getContext();
      p.g(paramaxg, "MMApplicationContext.getContext()");
      paramaxg = new HalfScreenConfig.BackgroundShapeConfig(paramaxg.getResources().getDimension(2131166371), true, true, 24);
      localg.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.lfu, true, paramaxg, true, null, 128);
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject1 = ((byte[])localObject3).toString();
      localObject2 = localg.appId;
      localObject3 = b.zs(paramg.liveInfo.liveId);
      localObject4 = paramg.uEl;
      paramaxg = str;
      if (localObject4 != null) {
        paramaxg = ((awc)localObject4).vtD;
      }
      c.a.f((String)localObject1, (String)localObject2, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      paramm.invoke(Boolean.TRUE, localg);
      AppMethodBeat.o(245865);
      return;
      localObject1 = null;
      break;
    }
    label1066:
    if (!bool1)
    {
      localg = new com.tencent.mm.plugin.appbrand.api.g();
      localObject4 = new com.tencent.mm.plugin.finder.live.model.x();
      str = paramaxg.dSJ;
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).atG((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uko = paramaxg.uko;
      localObject1 = paramg.uEl;
      if (localObject1 == null) {
        break label1520;
      }
      localObject1 = ((awc)localObject1).ukr;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukr = ((String)localObject1);
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).atH("push");
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).uks = 2;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject4).ukt = ((byte[])localObject3);
      localg.kHx = ((d)localObject4);
      localObject1 = paramaxg.LHN;
      if (localObject1 != null)
      {
        str = ((det)localObject1).appId;
        localObject1 = str;
        if (str != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      paramaxg = paramaxg.LHN;
      if (paramaxg != null)
      {
        localObject1 = paramaxg.path;
        paramaxg = (axg)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramaxg = "";
      }
      localg.kHw = paramaxg;
      localg.scene = 1177;
      localObject1 = new StringBuilder("live_list_buy:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label1526;
      }
    }
    label1520:
    label1526:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      localg.dCw = (paramaxg + ':' + paramg.sessionId + ':' + localObject3);
      paramaxg = com.tencent.mm.plugin.finder.report.live.k.vkd;
      paramaxg = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject1 = localg.dCw;
      p.g(localObject1, "sceneNote");
      paramaxg.auR((String)localObject1);
      paramaxg = MMApplicationContext.getContext();
      p.g(paramaxg, "MMApplicationContext.getContext()");
      paramaxg = new HalfScreenConfig.BackgroundShapeConfig(paramaxg.getResources().getDimension(2131166371), true, true, 24);
      localg.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.lfu, true, paramaxg, true, null, 128);
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject1 = ((byte[])localObject3).toString();
      str = localg.appId;
      localObject3 = b.zs(paramg.liveInfo.liveId);
      localObject4 = paramg.uEl;
      paramaxg = (axg)localObject2;
      if (localObject4 != null) {
        paramaxg = ((awc)localObject4).vtD;
      }
      c.a.f((String)localObject1, str, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      paramm.invoke(Boolean.TRUE, localg);
      AppMethodBeat.o(245865);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, kotlin.g.a.m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, kotlin.x> paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(245863);
    p.h(paramg, "liveData");
    String str = Util.getUuidRandom().toString();
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    Object localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject3 = ((awc)localObject1).LGD;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.appId = ((String)localObject1);
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject3 = ((awc)localObject1).LGB;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.kHw = ((String)localObject1);
    Object localObject3 = new com.tencent.mm.plugin.finder.live.model.x();
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject1 = ((awc)localObject1).ukr;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject3).ukr = ((String)localObject1);
      localg.kHx = ((d)localObject3);
      localg.scene = 1176;
      if (paramg.liveInfo.liveId != 0L) {
        break label358;
      }
    }
    label358:
    for (localObject1 = "pre_live_add";; localObject1 = "post_live_add")
    {
      localObject3 = new StringBuilder().append((String)localObject1).append(':').append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      awc localawc = paramg.uEl;
      if (localawc != null) {
        localObject2 = localawc.vtD;
      }
      localg.dCw = ((String)localObject2 + ':' + paramg.sessionId + ':' + str);
      localObject2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject2 = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject3 = localg.dCw;
      p.g(localObject3, "sceneNote");
      ((s)localObject2).auR((String)localObject3);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      c.a.apD(str);
      localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
      localObject2 = localg.appId;
      p.g(localObject2, "bundle.appId");
      com.tencent.mm.plugin.finder.report.k.a(3L, (String)localObject2, str, 1176L, String.valueOf(paramg.sessionId), (String)localObject1, paramg.dPI);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(245863);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void c(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(245868);
    p.h(paramg, "bundle");
    Log.i(TAG, "[appId:" + paramg.appId + ",path:" + paramg.kHw + ",halfScreen:" + paramg.kHL.isEnable() + ",scene:" + paramg.scene + ",sceneNote:" + paramg.dCw + ",extraData:" + paramg.kHx + ']');
    AppMethodBeat.o(245868);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, axg paramaxg, kotlin.g.a.m<? super Boolean, ? super com.tencent.mm.plugin.appbrand.api.g, kotlin.x> paramm)
  {
    AppMethodBeat.i(245866);
    p.h(paramg, "liveData");
    if (paramaxg == null)
    {
      Log.i(TAG, "[getPayloadForVisitorBubbleClick] fail, data is null!");
      AppMethodBeat.o(245866);
      return;
    }
    Object localObject1 = y.vXH;
    boolean bool1 = y.c(paramaxg);
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool2 = com.tencent.mm.plugin.finder.storage.c.duW();
    Object localObject3 = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject4 = new StringBuilder("[getPayloadForVisitorBubbleClick] appId:");
    localObject1 = paramg.uEm;
    label149:
    label297:
    label466:
    com.tencent.mm.plugin.finder.live.model.x localx;
    label412:
    long l;
    if (localObject1 != null)
    {
      localObject1 = ((axg)localObject1).LHI;
      if (localObject1 != null)
      {
        localObject1 = ((det)localObject1).appId;
        localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",purchase appId:");
        localObject1 = paramg.uEm;
        if (localObject1 == null) {
          break label662;
        }
        localObject1 = ((axg)localObject1).LHN;
        if (localObject1 == null) {
          break label662;
        }
        localObject1 = ((det)localObject1).appId;
        Log.i((String)localObject2, (String)localObject1 + ", isThirdParty:" + bool1 + ",detailFirst:" + bool2 + ",locClickId:" + localObject3 + '!');
        if (bool1 != true) {
          break label1213;
        }
        if (!bool2) {
          break label685;
        }
        localObject4 = Boolean.FALSE;
        p.g(localObject3, "locClickId");
        localg = new com.tencent.mm.plugin.appbrand.api.g();
        localg.scene = 1177;
        localObject2 = new StringBuilder("live_bubble:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
        localObject1 = paramg.uEl;
        if (localObject1 == null) {
          break label668;
        }
        localObject1 = ((awc)localObject1).vtD;
        localg.dCw = ((String)localObject1 + ':' + paramg.sessionId + ':' + localObject3);
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.dpl();
        localObject2 = localg.dCw;
        p.g(localObject2, "sceneNote");
        ((s)localObject1).auR((String)localObject2);
        if (paramg != null)
        {
          localObject1 = paramg.uEm;
          if (localObject1 != null)
          {
            localObject1 = ((axg)localObject1).LHI;
            if (localObject1 != null)
            {
              localObject2 = ((det)localObject1).appId;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label412;
              }
            }
          }
        }
        localObject1 = "";
        localg.appId = ((String)localObject1);
        if (paramg != null)
        {
          localObject1 = paramg.uEm;
          if (localObject1 != null)
          {
            localObject1 = ((axg)localObject1).LHI;
            if (localObject1 != null)
            {
              localObject2 = ((det)localObject1).path;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label466;
              }
            }
          }
        }
        localObject1 = "";
        localg.kHw = ((String)localObject1);
        localx = new com.tencent.mm.plugin.finder.live.model.x();
        localObject1 = paramg.uEm;
        if (localObject1 != null)
        {
          localObject2 = ((axg)localObject1).dSJ;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localx.atG((String)localObject1);
        localObject1 = paramg.uEm;
        if (localObject1 == null) {
          break label674;
        }
        l = ((axg)localObject1).uko;
        label538:
        localx.uko = l;
        localx.ukr = paramaxg.ukr;
        localx.uks = 3;
        localx.ukt = ((byte[])localObject3);
        paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        localObject1 = ((byte[])localObject3).toString();
        localObject2 = localg.appId;
        localObject3 = b.zs(paramg.liveInfo.liveId);
        paramaxg = paramg.uEl;
        if (paramaxg == null) {
          break label680;
        }
      }
    }
    label662:
    label668:
    label674:
    label680:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      c.a.f((String)localObject1, (String)localObject2, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      localg.kHx = ((d)localx);
      paramm.invoke(localObject4, localg);
      AppMethodBeat.o(245866);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label149;
      localObject1 = null;
      break label297;
      l = 0L;
      break label538;
    }
    label685:
    localObject4 = Boolean.TRUE;
    p.g(localObject3, "locClickId");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.scene = 1177;
    localObject2 = new StringBuilder("live_bubble:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject1 = ((awc)localObject1).vtD;
      localg.dCw = ((String)localObject1 + ':' + paramg.sessionId + ':' + localObject3);
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject2 = localg.dCw;
      p.g(localObject2, "sceneNote");
      ((s)localObject1).auR((String)localObject2);
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = new HalfScreenConfig.BackgroundShapeConfig(((Context)localObject1).getResources().getDimension(2131166371), true, true, 24);
      localg.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.lft, true, (HalfScreenConfig.BackgroundShapeConfig)localObject1, true, null, 128);
      if (paramg != null)
      {
        localObject1 = paramg.uEm;
        if (localObject1 != null)
        {
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 != null)
          {
            localObject2 = ((det)localObject1).appId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label952;
            }
          }
        }
      }
      localObject1 = "";
      label952:
      localg.appId = ((String)localObject1);
      if (paramg != null)
      {
        localObject1 = paramg.uEm;
        if (localObject1 != null)
        {
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 != null)
          {
            localObject2 = ((det)localObject1).path;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label1006;
            }
          }
        }
      }
      localObject1 = "";
      label1006:
      localg.kHw = ((String)localObject1);
      localx = new com.tencent.mm.plugin.finder.live.model.x();
      localObject1 = paramg.uEm;
      if (localObject1 != null)
      {
        localObject2 = ((axg)localObject1).dSJ;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localx.atG((String)localObject1);
      localObject1 = paramg.uEm;
      if (localObject1 == null) {
        break label1202;
      }
      l = ((axg)localObject1).uko;
      label1078:
      localx.uko = l;
      localx.ukr = paramaxg.ukr;
      localx.uks = 3;
      localx.ukt = ((byte[])localObject3);
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject1 = ((byte[])localObject3).toString();
      localObject2 = localg.appId;
      localObject3 = b.zs(paramg.liveInfo.liveId);
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label1208;
      }
    }
    label1202:
    label1208:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      c.a.f((String)localObject1, (String)localObject2, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      localg.kHx = ((d)localx);
      paramm.invoke(localObject4, localg);
      AppMethodBeat.o(245866);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label1078;
    }
    label1213:
    if (!bool1)
    {
      localObject4 = Boolean.TRUE;
      p.g(localObject3, "locClickId");
      localg = new com.tencent.mm.plugin.appbrand.api.g();
      localg.scene = 1177;
      localObject2 = new StringBuilder("live_bubble:").append(paramg.liveInfo.liveId).append(':').append(paramg.hwd).append(':');
      localObject1 = paramg.uEl;
      if (localObject1 == null) {
        break label1728;
      }
      localObject1 = ((awc)localObject1).vtD;
      localg.dCw = ((String)localObject1 + ':' + paramg.sessionId + ':' + localObject3);
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject1 = com.tencent.mm.plugin.finder.report.live.k.dpl();
      localObject2 = localg.dCw;
      p.g(localObject2, "sceneNote");
      ((s)localObject1).auR((String)localObject2);
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = new HalfScreenConfig.BackgroundShapeConfig(((Context)localObject1).getResources().getDimension(2131166371), true, true, 24);
      localg.kHL = new HalfScreenConfig(true, deU(), true, HalfScreenConfig.a.lft, true, (HalfScreenConfig.BackgroundShapeConfig)localObject1, true, null, 128);
      if (paramg != null)
      {
        localObject1 = paramg.uEm;
        if (localObject1 != null)
        {
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 != null)
          {
            localObject2 = ((det)localObject1).appId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label1484;
            }
          }
        }
      }
      localObject1 = "";
      label1484:
      localg.appId = ((String)localObject1);
      if (paramg != null)
      {
        localObject1 = paramg.uEm;
        if (localObject1 != null)
        {
          localObject1 = ((axg)localObject1).LHN;
          if (localObject1 != null)
          {
            localObject2 = ((det)localObject1).path;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label1538;
            }
          }
        }
      }
      localObject1 = "";
      localg.kHw = ((String)localObject1);
      localx = new com.tencent.mm.plugin.finder.live.model.x();
      localObject1 = paramg.uEm;
      if (localObject1 != null)
      {
        localObject2 = ((axg)localObject1).dSJ;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localx.atG((String)localObject1);
      localObject1 = paramg.uEm;
      if (localObject1 == null) {
        break label1734;
      }
      l = ((axg)localObject1).uko;
      label1610:
      localx.uko = l;
      localx.ukr = paramaxg.ukr;
      localx.uks = 3;
      localx.ukt = ((byte[])localObject3);
      paramaxg = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject1 = ((byte[])localObject3).toString();
      localObject2 = localg.appId;
      localObject3 = b.zs(paramg.liveInfo.liveId);
      paramaxg = paramg.uEl;
      if (paramaxg == null) {
        break label1740;
      }
    }
    label1538:
    label1728:
    label1734:
    label1740:
    for (paramaxg = paramaxg.vtD;; paramaxg = null)
    {
      c.a.f((String)localObject1, (String)localObject2, (String)localObject3, paramaxg, b.zs(paramg.sessionId));
      localg.kHx = ((d)localx);
      paramm.invoke(localObject4, localg);
      AppMethodBeat.o(245866);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label1610;
    }
  }
  
  private static int deU()
  {
    AppMethodBeat.i(245867);
    float f = au.az(MMApplicationContext.getContext()).y;
    Object localObject = MMApplicationContext.getResources();
    p.g(localObject, "MMApplicationContext.getResources()");
    if (((Resources)localObject).getConfiguration().orientation == 2) {
      f = au.az(MMApplicationContext.getContext()).x;
    }
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = (int)(f * (com.tencent.mm.plugin.finder.storage.c.duX() / 100.0F));
    AppMethodBeat.o(245867);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.g
 * JD-Core Version:    0.7.0.1
 */