package com.tencent.mm.plugin.finder.live;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import java.util.Arrays;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPayloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBuyPayloadForBubbleClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "data", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "locClickId", "", "getDetailPayloadForBubbleClick", "getHalfMiniProgramHeight", "", "getNormalPayloadForBubbleClick", "getPayloadForAddProduct", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gotoHalfScreen", "bundle", "getPayloadForOrder", "getPayloadForProductBuyClick", "getPayloadForProductItemClick", "getPayloadForVisitorBubbleClick", "printPayload", "plugin-finder_release"})
public final class r
{
  private static final String TAG = "FinderLive.MiniProgramPayloadHelper";
  public static final r xWC;
  
  static
  {
    AppMethodBeat.i(266826);
    xWC = new r();
    TAG = "FinderLive.MiniProgramPayloadHelper";
    AppMethodBeat.o(266826);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, f paramf, m<? super Boolean, ? super g, x> paramm)
  {
    AppMethodBeat.i(266813);
    p.k(parama, "liveData");
    if (paramf == null)
    {
      Log.i(TAG, "[getPayloadForProductItemClick] fail, liveData is null:false,data is null:true!");
      AppMethodBeat.o(266813);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.NJ(paramf.yiH);
    localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool2 = com.tencent.c.a.a.a.a.a.imM();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("[getPayloadForProductItemClick] appId:");
    localObject1 = paramf.zaU;
    g localg;
    label280:
    label373:
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((ahj)localObject1).appid;
      Log.i((String)localObject2, (String)localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + arrayOfByte + '!');
      localg = new g();
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).appid;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.nBq = ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
        break label667;
      }
      localg.scene = 1176;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId != 0L) {
        break label659;
      }
      localObject1 = "pre_live_detail";
      localg.fvd = ((String)localObject1 + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
      int i = dwO();
      localObject2 = HalfScreenConfig.a.nZL;
      localObject3 = HalfScreenConfig.c.nZV;
      localObject4 = HalfScreenConfig.f.oac;
      com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      localg.nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject2, false, null, false, null, (HalfScreenConfig.c)localObject3, false, true, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaU), 1400);
      localObject2 = k.yBj;
      localObject2 = k.dDm();
      localObject3 = localg.fvd;
      p.j(localObject3, "sceneNote");
      ((s)localObject2).aCD((String)localObject3);
      localObject4 = new at();
      localObject3 = paramf.zaX;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((at)localObject4).aCh((String)localObject2);
      ((at)localObject4).yiz = paramf.zaO;
      ((at)localObject4).yiC = "";
      ((at)localObject4).yiD = 1;
      ((at)localObject4).yiE = arrayOfByte;
      ((at)localObject4).yiH = paramf.yiH;
      paramf = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
        break label777;
      }
      paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.axD(String.valueOf(((at)localObject4).yiE));
    }
    for (;;)
    {
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramf = n.zWF;
      paramf = localg.appId;
      p.j(paramf, "bundle.appId");
      n.a(3L, paramf, arrayOfByte.toString(), 1176L, String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId), (String)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).fIY);
      paramm.invoke(Boolean.TRUE, localg);
      AppMethodBeat.o(266813);
      return;
      localObject1 = null;
      break;
      label659:
      localObject1 = "post_live_detail";
      break label280;
      label667:
      localg.scene = 1177;
      localg.fvd = ("live_list_detail" + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
      localObject1 = "live_list_detail";
      break label373;
      label777:
      paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.f(String.valueOf(((at)localObject4).yiE), localg.appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, m<? super Boolean, ? super g, x> paramm)
  {
    AppMethodBeat.i(266809);
    p.k(parama, "liveData");
    String str2 = Util.getUuidRandom().toString();
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.axD(str2);
    }
    g localg = new g();
    localObject = ((j)parama.business(j.class)).ziI;
    String str1;
    if (localObject != null)
    {
      localObject = ((azy)localObject).SLz;
      if (localObject != null)
      {
        str1 = ((bln)localObject).appId;
        localObject = str1;
        if (str1 != null) {
          break label89;
        }
      }
    }
    localObject = "";
    label89:
    localg.appId = ((String)localObject);
    localObject = ((j)parama.business(j.class)).ziI;
    if (localObject != null)
    {
      localObject = ((azy)localObject).SLz;
      if (localObject != null)
      {
        str1 = ((bln)localObject).SWz;
        localObject = str1;
        if (str1 != null) {
          break label136;
        }
      }
    }
    localObject = "";
    label136:
    localg.nBq = ((String)localObject);
    localg.scene = 1177;
    localg.fvd = ("live_list_order:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + str2 + ':' + Util.getUuidRandom());
    localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.f(str2, localg.appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
    }
    parama = k.yBj;
    parama = k.dDm();
    localObject = localg.fvd;
    p.j(localObject, "sceneNote");
    parama.aCD((String)localObject);
    paramm.invoke(Boolean.FALSE, localg);
    AppMethodBeat.o(266809);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, f paramf, m<? super Boolean, ? super g, x> paramm)
  {
    AppMethodBeat.i(266817);
    p.k(parama, "liveData");
    if (paramf == null)
    {
      Log.i(TAG, "[getPayloadForProductBuyClick] fa  il, liveData is null:false,data is null:true!");
      AppMethodBeat.o(266817);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.NJ(paramf.yiH);
    localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool2 = com.tencent.c.a.a.a.a.a.imM();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("[getPayloadForProductBuyClick] appId:");
    localObject1 = paramf.zaU;
    if (localObject1 != null)
    {
      localObject1 = ((ahj)localObject1).appid;
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",purchase appId:");
      localObject1 = paramf.zaT;
      if (localObject1 == null) {
        break label625;
      }
    }
    label625:
    for (localObject1 = ((ahj)localObject1).appid;; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + arrayOfByte + '!');
      if (!bool1) {
        break label1065;
      }
      if (!bool2) {
        break label631;
      }
      localObject3 = new g();
      localObject4 = new at();
      localObject2 = paramf.zaX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((at)localObject4).aCh((String)localObject1);
      ((at)localObject4).yiz = paramf.zaO;
      ((at)localObject4).yiC = "";
      ((at)localObject4).yiD = 2;
      ((at)localObject4).yiE = arrayOfByte;
      ((at)localObject4).yiH = paramf.yiH;
      ((g)localObject3).nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).appid;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((g)localObject3).appId = ((String)localObject1);
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((g)localObject3).nBq = ((String)localObject1);
      ((g)localObject3).scene = 1177;
      ((g)localObject3).fvd = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
      i = dwO();
      localObject1 = HalfScreenConfig.a.nZL;
      localObject2 = HalfScreenConfig.c.nZV;
      localObject4 = HalfScreenConfig.f.oac;
      locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      ((g)localObject3).nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaU), 1400);
      paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.f(arrayOfByte.toString(), ((g)localObject3).appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
      parama = k.yBj;
      parama = k.dDm();
      paramf = ((g)localObject3).fvd;
      p.j(paramf, "sceneNote");
      parama.aCD(paramf);
      paramm.invoke(Boolean.TRUE, localObject3);
      AppMethodBeat.o(266817);
      return;
      localObject1 = null;
      break;
    }
    label631:
    localObject3 = new g();
    Object localObject4 = new at();
    localObject2 = paramf.zaX;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((at)localObject4).aCh((String)localObject1);
    ((at)localObject4).yiz = paramf.zaO;
    ((at)localObject4).yiC = "";
    ((at)localObject4).aCi("push");
    ((at)localObject4).yiD = 2;
    ((at)localObject4).yiE = arrayOfByte;
    ((at)localObject4).yiH = paramf.yiH;
    ((g)localObject3).nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((g)localObject3).appId = ((String)localObject1);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((g)localObject3).nBq = ((String)localObject1);
    ((g)localObject3).scene = 1177;
    ((g)localObject3).fvd = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
    localObject1 = k.yBj;
    localObject1 = k.dDm();
    localObject2 = ((g)localObject3).fvd;
    p.j(localObject2, "sceneNote");
    ((s)localObject1).aCD((String)localObject2);
    int i = dwO();
    localObject1 = HalfScreenConfig.a.nZL;
    localObject2 = HalfScreenConfig.c.nZV;
    localObject4 = HalfScreenConfig.f.oac;
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
    ((g)localObject3).nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaT), 1400);
    paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    c.a.f(arrayOfByte.toString(), ((g)localObject3).appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
    paramm.invoke(Boolean.TRUE, localObject3);
    AppMethodBeat.o(266817);
    return;
    label1065:
    localObject3 = new g();
    localObject4 = new at();
    localObject2 = paramf.zaX;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((at)localObject4).aCh((String)localObject1);
    ((at)localObject4).yiz = paramf.zaO;
    ((at)localObject4).yiC = "";
    ((at)localObject4).aCi("push");
    ((at)localObject4).yiD = 2;
    ((at)localObject4).yiE = arrayOfByte;
    ((at)localObject4).yiG = false;
    ((at)localObject4).yiH = paramf.yiH;
    ((g)localObject3).nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((g)localObject3).appId = ((String)localObject1);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((g)localObject3).nBq = ((String)localObject1);
    ((g)localObject3).scene = 1177;
    ((g)localObject3).fvd = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
    localObject1 = k.yBj;
    localObject1 = k.dDm();
    localObject2 = ((g)localObject3).fvd;
    p.j(localObject2, "sceneNote");
    ((s)localObject1).aCD((String)localObject2);
    i = dwO();
    localObject1 = HalfScreenConfig.a.nZM;
    localObject2 = HalfScreenConfig.c.nZW;
    localObject4 = HalfScreenConfig.f.oad;
    locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
    ((g)localObject3).nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, false, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaT), 1400);
    paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    c.a.f(arrayOfByte.toString(), ((g)localObject3).appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
    paramm.invoke(Boolean.TRUE, localObject3);
    AppMethodBeat.o(266817);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, m<? super Boolean, ? super g, x> paramm)
  {
    AppMethodBeat.i(266811);
    p.k(parama, "liveData");
    String str1 = Util.getUuidRandom().toString();
    g localg = new g();
    Object localObject1 = ((j)parama.business(j.class)).ziI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((azy)localObject1).SLw;
      if (localObject1 != null)
      {
        localObject2 = ((bln)localObject1).appId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label73;
        }
      }
    }
    localObject1 = "";
    label73:
    localg.appId = ((String)localObject1);
    localObject1 = ((j)parama.business(j.class)).ziI;
    if (localObject1 != null)
    {
      localObject1 = ((azy)localObject1).SLw;
      if (localObject1 != null)
      {
        localObject2 = ((bln)localObject1).SWz;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label123;
        }
      }
    }
    localObject1 = "";
    label123:
    p.j(localObject1, "liveData.business(LiveSh…product_url?.appUrl ?: \"\"");
    int i;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label482;
      }
      localObject2 = af.aaBG;
      localObject1 = String.format((String)localObject1 + "?objectId=%s", Arrays.copyOf(new Object[] { com.tencent.mm.ae.d.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk) }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      label210:
      localg.nBq = ((String)localObject1);
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)new at());
      localg.scene = 1176;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId != 0L) {
        break label485;
      }
    }
    label482:
    label485:
    for (localObject1 = "pre_live_add";; localObject1 = "post_live_add")
    {
      localg.fvd = ((String)localObject1 + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + str1);
      localObject2 = k.yBj;
      localObject2 = k.dDm();
      String str2 = localg.fvd;
      p.j(str2, "sceneNote");
      ((s)localObject2).aCD(str2);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.axD(str1);
      localObject2 = n.zWF;
      localObject2 = localg.appId;
      p.j(localObject2, "bundle.appId");
      n.a(3L, (String)localObject2, str1, 1176L, String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId), (String)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).fIY);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(266811);
      return;
      i = 0;
      break;
      break label210;
    }
  }
  
  public static void c(g paramg)
  {
    AppMethodBeat.i(266823);
    p.k(paramg, "bundle");
    Log.i(TAG, "[appId:" + paramg.appId + ",path:" + paramg.nBq + ",halfScreen:" + paramg.nBE.isEnable() + ",scene:" + paramg.scene + ",sceneNote:" + paramg.fvd + ",extraData:" + paramg.nBr + ']');
    AppMethodBeat.o(266823);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, f paramf, m<? super Boolean, ? super g, x> paramm)
  {
    AppMethodBeat.i(266819);
    p.k(parama, "liveData");
    if (paramf == null)
    {
      Log.i(TAG, "[getPayloadForVisitorBubbleClick] fail, data is null!");
      AppMethodBeat.o(266819);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.NJ(paramf.yiH);
    localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool2 = com.tencent.c.a.a.a.a.a.imM();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("[getPayloadForVisitorBubbleClick] appId:");
    localObject1 = paramf.zaU;
    if (localObject1 != null)
    {
      localObject1 = ((ahj)localObject1).appid;
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",purchase appId:");
      localObject1 = paramf.zaT;
      if (localObject1 == null) {
        break label636;
      }
    }
    label636:
    for (localObject1 = ((ahj)localObject1).appid;; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ", isThirdParty:" + bool1 + ",detailFirst:" + bool2 + ",locClickId:" + arrayOfByte + '!');
      if (bool1 != true) {
        break label1080;
      }
      if (!bool2) {
        break label642;
      }
      localObject3 = Boolean.TRUE;
      p.j(arrayOfByte, "locClickId");
      localg = new g();
      localg.scene = 1177;
      localg.fvd = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
      localObject1 = k.yBj;
      localObject1 = k.dDm();
      localObject2 = localg.fvd;
      p.j(localObject2, "sceneNote");
      ((s)localObject1).aCD((String)localObject2);
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).appid;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      localObject1 = paramf.zaU;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.nBq = ((String)localObject1);
      i = dwO();
      localObject1 = HalfScreenConfig.a.nZL;
      localObject2 = HalfScreenConfig.c.nZV;
      localObject4 = HalfScreenConfig.f.oac;
      locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      localg.nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaU), 1400);
      localObject4 = new at();
      localObject2 = paramf.zaX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((at)localObject4).aCh((String)localObject1);
      ((at)localObject4).yiz = paramf.zaO;
      ((at)localObject4).yiC = "";
      ((at)localObject4).yiD = 3;
      ((at)localObject4).yiE = arrayOfByte;
      ((at)localObject4).yiH = paramf.yiH;
      paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.f(arrayOfByte.toString(), localg.appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramm.invoke(localObject3, localg);
      AppMethodBeat.o(266819);
      return;
      localObject1 = null;
      break;
    }
    label642:
    localObject3 = Boolean.TRUE;
    p.j(arrayOfByte, "locClickId");
    g localg = new g();
    localg.scene = 1177;
    localg.fvd = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
    localObject1 = k.yBj;
    localObject1 = k.dDm();
    localObject2 = localg.fvd;
    p.j(localObject2, "sceneNote");
    ((s)localObject1).aCD((String)localObject2);
    int i = dwO();
    localObject1 = HalfScreenConfig.a.nZL;
    localObject2 = HalfScreenConfig.c.nZV;
    Object localObject4 = HalfScreenConfig.f.oac;
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
    localg.nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaT), 1400);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.appId = ((String)localObject1);
    localObject1 = paramf.zaT;
    if (localObject1 != null)
    {
      localObject2 = ((ahj)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localg.nBq = ((String)localObject1);
    localObject4 = new at();
    localObject2 = paramf.zaX;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((at)localObject4).aCh((String)localObject1);
    ((at)localObject4).yiz = paramf.zaO;
    ((at)localObject4).yiC = "";
    ((at)localObject4).yiD = 3;
    ((at)localObject4).yiE = arrayOfByte;
    ((at)localObject4).yiH = paramf.yiH;
    paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    c.a.f(arrayOfByte.toString(), localg.appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
    localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
    paramm.invoke(localObject3, localg);
    AppMethodBeat.o(266819);
    return;
    label1080:
    if (!bool1)
    {
      localObject3 = Boolean.TRUE;
      p.j(arrayOfByte, "locClickId");
      localg = new g();
      localg.scene = 1177;
      localg.fvd = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId + ':' + arrayOfByte);
      localObject1 = k.yBj;
      localObject1 = k.dDm();
      localObject2 = localg.fvd;
      p.j(localObject2, "sceneNote");
      ((s)localObject1).aCD((String)localObject2);
      i = dwO();
      localObject1 = HalfScreenConfig.a.nZL;
      localObject2 = HalfScreenConfig.c.nZW;
      localObject4 = HalfScreenConfig.f.oac;
      locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      localg.nBE = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, false, null, (HalfScreenConfig.f)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramf.zaT), 1400);
      localObject1 = paramf.zaT;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).appid;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.appId = ((String)localObject1);
      localObject1 = paramf.zaT;
      if (localObject1 != null)
      {
        localObject2 = ((ahj)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.nBq = ((String)localObject1);
      localObject4 = new at();
      localObject2 = paramf.zaX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((at)localObject4).aCh((String)localObject1);
      ((at)localObject4).yiz = paramf.zaO;
      ((at)localObject4).yiC = "";
      ((at)localObject4).yiD = 3;
      ((at)localObject4).yiE = arrayOfByte;
      ((at)localObject4).yiH = paramf.yiH;
      ((at)localObject4).yiG = false;
      paramf = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      c.a.f(arrayOfByte.toString(), localg.appId, com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId), "", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).sessionId));
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramm.invoke(localObject3, localg);
    }
    AppMethodBeat.o(266819);
  }
  
  public static int dwO()
  {
    AppMethodBeat.i(266822);
    float f = ax.au(MMApplicationContext.getContext()).y;
    Object localObject = MMApplicationContext.getResources();
    p.j(localObject, "MMApplicationContext.getResources()");
    if (((Resources)localObject).getConfiguration().orientation == 2) {
      f = ax.au(MMApplicationContext.getContext()).x;
    }
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int i = (int)(f * (com.tencent.c.a.a.a.a.a.imN() / 100.0F));
    AppMethodBeat.o(266822);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.r
 * JD-Core Version:    0.7.0.1
 */