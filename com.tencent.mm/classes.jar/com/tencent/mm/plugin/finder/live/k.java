package com.tencent.mm.plugin.finder.live;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.ShareActionConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.h;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.ay;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.bm;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPayloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "generateShareActionConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "data", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "getBuyPayloadForBubbleClick", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "locClickId", "", "getDetailPayloadForBubbleClick", "getHalfMiniProgramHeight", "", "getNormalPayloadForBubbleClick", "getPayloadForAddProduct", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "gotoHalfScreen", "bundle", "appId", "appUrl", "objectId", "", "liveId", "anchorUserName", "sessionId", "requestId", "ec_source", "setting", "getPayloadForOrder", "getPayloadForProductBuyClick", "getPayloadForProductItemClick", "getPayloadForVisitorBubbleClick", "printPayload", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Bxu;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(350853);
    Bxu = new k();
    TAG = "FinderLive.MiniProgramPayloadHelper";
    AppMethodBeat.o(350853);
  }
  
  public static g a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(350776);
    s.u(paramString1, "appId");
    s.u(paramString2, "appUrl");
    s.u(paramString3, "anchorUserName");
    s.u(paramString4, "sessionId");
    s.u(paramString5, "requestId");
    s.u(paramString6, "ec_source");
    s.u(paramString7, "setting");
    String str = Util.getUuidRandom().toString();
    g localg = new g();
    localg.appId = paramString1;
    if (((CharSequence)paramString2).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      paramString1 = paramString2;
      if (i != 0)
      {
        paramString1 = am.aixg;
        paramString1 = String.format(s.X(paramString2, "?objectId=%s"), Arrays.copyOf(new Object[] { com.tencent.mm.ae.d.hF(paramLong1) }, 1));
        s.s(paramString1, "java.lang.String.format(format, *args)");
      }
      localg.qAF = paramString1;
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)new ay());
      localg.scene = 1176;
      localg.hzx = (paramString7 + ':' + paramLong2 + ':' + paramString3 + "::" + paramString4 + ':' + str + ':' + paramString5 + ':' + paramString6);
      paramString1 = j.Dob;
      paramString1 = j.Doc;
      paramString2 = localg.hzx;
      s.s(paramString2, "sceneNote");
      paramString1.axA(paramString2);
      paramString1 = c.zGj;
      c.a.arH(str);
      paramString1 = (bm)h.ax(bm.class);
      paramString2 = localg.appId;
      s.s(paramString2, "bundle.appId");
      paramString1.b(3L, paramString2, str, paramString4, paramString7, paramString5);
      AppMethodBeat.o(350776);
      return localg;
    }
  }
  
  public static HalfScreenConfig.ShareActionConfig a(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.convert.k paramk)
  {
    AppMethodBeat.i(350797);
    s.u(parama, "liveData");
    s.u(paramk, "data");
    Object localObject = ((e)parama.business(e.class)).mIC;
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    paramk = paramk.DVj;
    com.tencent.mm.plugin.finder.utils.ah localah = com.tencent.mm.plugin.finder.utils.ah.Ghp;
    localObject = com.tencent.mm.plugin.finder.utils.ah.a((String)localObject, l, str, paramk, com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
    parama = com.tencent.mm.plugin.finder.utils.ah.Ghp;
    str = com.tencent.mm.plugin.finder.utils.ah.a((bth)localObject);
    parama = com.tencent.mm.plugin.finder.utils.ah.Ghp;
    parama = com.tencent.mm.plugin.finder.utils.ah.Ghp;
    paramk = ((bth)localObject).productId;
    parama = paramk;
    if (paramk == null) {
      parama = "";
    }
    com.tencent.mm.plugin.finder.utils.ah.a((bth)localObject, "commodity_item", com.tencent.mm.plugin.finder.utils.ah.aBC(parama));
    parama = new HalfScreenConfig.ShareActionConfig(true, str);
    AppMethodBeat.o(350797);
    return parama;
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.convert.k paramk, m<? super Boolean, ? super g, kotlin.ah> paramm)
  {
    AppMethodBeat.i(350792);
    s.u(parama, "liveData");
    if (paramk == null)
    {
      Log.i(TAG, "[getPayloadForProductItemClick] fail, liveData is null:false,data is null:true!");
      AppMethodBeat.o(350792);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.Pr(paramk.DVs);
    localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool2 = com.tencent.d.a.a.a.a.a.jTs();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = paramk.DVq;
    localObject1 = paramk.ewd();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((aoj)localObject1).ZvP;
      if (localObject1 != null)
      {
        localObject1 = ((aka)localObject1).appid;
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label775;
            }
            i = 1;
            label134:
            if (i == 0) {
              break label1075;
            }
            localObject1 = paramk.ewd();
            if (localObject1 != null) {
              break label780;
            }
            localObject1 = null;
            label152:
            localObject2 = localObject1;
          }
        }
      }
    }
    label276:
    label293:
    label810:
    label1075:
    for (;;)
    {
      Object localObject3 = TAG;
      Object localObject4 = new StringBuilder("[getPayloadForProductItemClick] appId:");
      label181:
      label204:
      label344:
      label477:
      Object localObject5;
      if (localObject2 == null)
      {
        localObject1 = null;
        localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", path:");
        if (localObject2 != null) {
          break label800;
        }
        localObject1 = null;
        Log.i((String)localObject3, localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + arrayOfByte + '!');
        localObject4 = new g();
        if (localObject2 != null) {
          break label810;
        }
        localObject1 = "";
        ((g)localObject4).appId = ((String)localObject1);
        if (localObject2 != null) {
          break label834;
        }
        localObject1 = "";
        ((g)localObject4).qAF = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          break label866;
        }
        ((g)localObject4).scene = 1176;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId != 0L) {
          break label858;
        }
        localObject1 = "pre_live_detail";
        ((g)localObject4).hzx = ((String)localObject1 + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
        i = bUw();
        localObject3 = HalfScreenConfig.a.rae;
        localObject5 = HalfScreenConfig.c.rao;
        HalfScreenConfig.h localh = HalfScreenConfig.h.raE;
        com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        ((g)localObject4).qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject3, false, null, false, null, (HalfScreenConfig.c)localObject5, false, true, null, localh, com.tencent.mm.plugin.finder.live.view.convert.a.b((aka)localObject2), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
        localObject2 = j.Dob;
        localObject2 = j.Doc;
        localObject3 = ((g)localObject4).hzx;
        s.s(localObject3, "sceneNote");
        ((com.tencent.mm.plugin.finder.live.report.q)localObject2).axA((String)localObject3);
        localObject5 = new ay();
        localObject3 = paramk.DVu;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        ((ay)localObject5).awD((String)localObject2);
        ((ay)localObject5).Azu = paramk.DVk;
        ((ay)localObject5).CIG = "";
        ((ay)localObject5).CIH = 1;
        ((ay)localObject5).CII = arrayOfByte;
        paramk = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          break label1016;
        }
        paramk = c.zGj;
        c.a.arH(String.valueOf(((ay)localObject5).CII));
      }
      for (;;)
      {
        paramk = kotlin.ah.aiuX;
        ((g)localObject4).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject5);
        paramk = (bm)h.ax(bm.class);
        localObject2 = ((g)localObject4).appId;
        s.s(localObject2, "bundle.appId");
        paramk.b(3L, (String)localObject2, arrayOfByte.toString(), String.valueOf(((e)parama.business(e.class)).sessionId), (String)localObject1, ((e)parama.business(e.class)).hOG);
        paramm.invoke(Boolean.TRUE, localObject4);
        AppMethodBeat.o(350792);
        return;
        i = 0;
        break;
        i = 0;
        break label134;
        localObject1 = ((aoj)localObject1).ZvP;
        break label152;
        localObject1 = ((aka)localObject2).appid;
        break label181;
        localObject1 = ((aka)localObject2).path;
        break label204;
        localObject3 = ((aka)localObject2).appid;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label276;
        }
        localObject1 = "";
        break label276;
        label834:
        localObject3 = ((aka)localObject2).path;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label293;
        }
        localObject1 = "";
        break label293;
        label858:
        localObject1 = "post_live_detail";
        break label344;
        label866:
        ((g)localObject4).scene = 1177;
        ((g)localObject4).hzx = ("live_list_detail" + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
        localObject1 = "live_list_detail";
        break label477;
        label1016:
        paramk = c.zGj;
        c.a.f(String.valueOf(((ay)localObject5).CII), ((g)localObject4).appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, m<? super Boolean, ? super g, kotlin.ah> paramm)
  {
    AppMethodBeat.i(350754);
    s.u(parama, "liveData");
    String str2 = Util.getUuidRandom().toString();
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = c.zGj;
      c.a.arH(str2);
    }
    g localg = new g();
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
    if (localObject == null)
    {
      localObject = "";
      localg.appId = ((String)localObject);
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
      if (localObject != null) {
        break label376;
      }
      localObject = "";
    }
    for (;;)
    {
      localg.qAF = ((String)localObject);
      localg.scene = 1177;
      localg.hzx = ("live_list_order:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + str2 + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
      {
        localObject = c.zGj;
        c.a.f(str2, localg.appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      }
      parama = j.Dob;
      parama = j.Doc;
      localObject = localg.hzx;
      s.s(localObject, "sceneNote");
      parama.axA((String)localObject);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(350754);
      return;
      localObject = ((bih)localObject).ZRs;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      String str1 = ((bzd)localObject).appId;
      localObject = str1;
      if (str1 != null) {
        break;
      }
      localObject = "";
      break;
      label376:
      localObject = ((bih)localObject).ZRs;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str1 = ((bzd)localObject).aail;
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.convert.k paramk, m<? super Boolean, ? super g, kotlin.ah> paramm)
  {
    AppMethodBeat.i(350818);
    s.u(parama, "liveData");
    if (paramk == null)
    {
      Log.i(TAG, "[getPayloadForProductBuyClick] fa  il, liveData is null:false,data is null:true!");
      AppMethodBeat.o(350818);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.Pr(paramk.DVs);
    localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool2 = com.tencent.d.a.a.a.a.a.jTs();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = null;
    localObject1 = paramk.ewd();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((aoj)localObject1).ZvP;
      if (localObject1 != null)
      {
        localObject1 = ((aka)localObject1).appid;
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label783;
            }
            i = 1;
            label131:
            if (i != 0)
            {
              localObject1 = paramk.ewd();
              if (localObject1 != null) {
                break label788;
              }
              localObject1 = null;
              label149:
              localObject3 = TAG;
              if (localObject1 != null) {
                break label798;
              }
              localObject2 = "";
              label164:
              Log.i((String)localObject3, s.X("[getPayloadForProductBuyClick] use exclusive page ", com.tencent.mm.ae.f.dg(localObject2)));
              localObject2 = localObject1;
            }
            localObject3 = TAG;
            localObject4 = new StringBuilder("[getPayloadForProductBuyClick] appId:");
            localObject1 = paramk.DVq;
            if (localObject1 != null) {
              break label805;
            }
            localObject1 = null;
            label215:
            localObject4 = ((StringBuilder)localObject4).append(localObject1).append(",purchase appId:");
            localObject1 = paramk.DVp;
            if (localObject1 != null) {
              break label815;
            }
            localObject1 = null;
            label244:
            Log.i((String)localObject3, localObject1 + ", isThirdParty:" + bool1 + ", detailPageFirst:" + bool2 + ",clickId:" + arrayOfByte + '!');
            if (!bool1) {
              break label1478;
            }
            if (!bool2) {
              break label911;
            }
            localObject4 = new g();
            localObject5 = new ay();
            localObject3 = paramk.DVu;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            ((ay)localObject5).awD((String)localObject1);
            ((ay)localObject5).Azu = paramk.DVk;
            ((ay)localObject5).CIG = "";
            ((ay)localObject5).CIH = 2;
            ((ay)localObject5).CII = arrayOfByte;
            localObject1 = kotlin.ah.aiuX;
            ((g)localObject4).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject5);
            if (localObject2 == null) {
              break label825;
            }
            localObject3 = ((aka)localObject2).appid;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            label423:
            ((g)localObject4).appId = ((String)localObject1);
            if (localObject2 == null) {
              break label868;
            }
            localObject2 = ((aka)localObject2).path;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
    }
    for (;;)
    {
      ((g)localObject4).qAF = ((String)localObject1);
      ((g)localObject4).scene = 1177;
      ((g)localObject4).hzx = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      i = bUw();
      localObject1 = HalfScreenConfig.a.rae;
      localObject2 = HalfScreenConfig.c.rao;
      localObject3 = HalfScreenConfig.h.raE;
      localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      ((g)localObject4).qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.h)localObject3, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVq), false, null, false, a(parama, paramk), 0, 0, 0, false, false, false, null, 16704888);
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), ((g)localObject4).appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = j.Dob;
      parama = j.Doc;
      paramk = ((g)localObject4).hzx;
      s.s(paramk, "sceneNote");
      parama.axA(paramk);
      parama = kotlin.ah.aiuX;
      paramm.invoke(Boolean.TRUE, localObject4);
      parama = kotlin.ah.aiuX;
      AppMethodBeat.o(350818);
      return;
      i = 0;
      break;
      label783:
      i = 0;
      break label131;
      label788:
      localObject1 = ((aoj)localObject1).ZvP;
      break label149;
      label798:
      localObject2 = localObject1;
      break label164;
      label805:
      localObject1 = ((aka)localObject1).appid;
      break label215;
      label815:
      localObject1 = ((aka)localObject1).appid;
      break label244;
      label825:
      localObject1 = paramk.DVq;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label423;
      }
      localObject3 = ((aka)localObject1).appid;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label423;
      }
      localObject1 = "";
      break label423;
      label868:
      localObject1 = paramk.DVq;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((aka)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    label911:
    Object localObject4 = new g();
    Object localObject5 = new ay();
    Object localObject3 = paramk.DVu;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    ((ay)localObject5).awD((String)localObject1);
    ((ay)localObject5).Azu = paramk.DVk;
    ((ay)localObject5).CIG = "";
    ((ay)localObject5).awE("push");
    ((ay)localObject5).CIH = 2;
    ((ay)localObject5).CII = arrayOfByte;
    localObject1 = kotlin.ah.aiuX;
    ((g)localObject4).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject5);
    if (localObject2 != null)
    {
      localObject3 = ((aka)localObject2).appid;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((g)localObject4).appId = ((String)localObject1);
      if (localObject2 == null) {
        break label1435;
      }
      localObject2 = ((aka)localObject2).path;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      ((g)localObject4).qAF = ((String)localObject1);
      ((g)localObject4).scene = 1177;
      ((g)localObject4).hzx = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject1 = j.Dob;
      localObject1 = j.Doc;
      localObject2 = ((g)localObject4).hzx;
      s.s(localObject2, "sceneNote");
      ((com.tencent.mm.plugin.finder.live.report.q)localObject1).axA((String)localObject2);
      i = bUw();
      localObject1 = HalfScreenConfig.a.rae;
      localObject2 = HalfScreenConfig.c.rao;
      localObject3 = HalfScreenConfig.h.raE;
      localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      ((g)localObject4).qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.h)localObject3, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVp), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), ((g)localObject4).appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = kotlin.ah.aiuX;
      paramm.invoke(Boolean.TRUE, localObject4);
      parama = kotlin.ah.aiuX;
      AppMethodBeat.o(350818);
      return;
      localObject1 = paramk.DVp;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject3 = ((aka)localObject1).appid;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject1 = "";
      break;
      label1435:
      localObject1 = paramk.DVp;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((aka)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    label1478:
    localObject4 = new g();
    localObject5 = new ay();
    localObject3 = paramk.DVu;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    ((ay)localObject5).awD((String)localObject1);
    ((ay)localObject5).Azu = paramk.DVk;
    ((ay)localObject5).CIG = "";
    ((ay)localObject5).awE("push");
    ((ay)localObject5).CIH = 2;
    ((ay)localObject5).CII = arrayOfByte;
    ((ay)localObject5).CIK = false;
    localObject1 = kotlin.ah.aiuX;
    ((g)localObject4).qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject5);
    if (localObject2 != null)
    {
      localObject3 = ((aka)localObject2).appid;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((g)localObject4).appId = ((String)localObject1);
      if (localObject2 == null) {
        break label2008;
      }
      localObject2 = ((aka)localObject2).path;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      ((g)localObject4).qAF = ((String)localObject1);
      ((g)localObject4).scene = 1177;
      ((g)localObject4).hzx = ("live_list_buy:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject1 = j.Dob;
      localObject1 = j.Doc;
      localObject2 = ((g)localObject4).hzx;
      s.s(localObject2, "sceneNote");
      ((com.tencent.mm.plugin.finder.live.report.q)localObject1).axA((String)localObject2);
      i = bUw();
      localObject1 = HalfScreenConfig.a.raf;
      localObject2 = HalfScreenConfig.c.rap;
      localObject3 = HalfScreenConfig.h.raF;
      localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      ((g)localObject4).qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, false, null, (HalfScreenConfig.h)localObject3, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVp), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), ((g)localObject4).appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = kotlin.ah.aiuX;
      paramm.invoke(Boolean.TRUE, localObject4);
      parama = kotlin.ah.aiuX;
      AppMethodBeat.o(350818);
      return;
      localObject1 = paramk.DVp;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject3 = ((aka)localObject1).appid;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject1 = "";
      break;
      label2008:
      localObject1 = paramk.DVp;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((aka)localObject1).path;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, m<? super Boolean, ? super g, kotlin.ah> paramm)
  {
    AppMethodBeat.i(350770);
    s.u(parama, "liveData");
    String str1 = Util.getUuidRandom().toString();
    g localg = new g();
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
    label79:
    int i;
    label93:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      localg.appId = ((String)localObject1);
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
      if (localObject1 != null) {
        break label498;
      }
      localObject1 = "";
      if (((CharSequence)localObject1).length() <= 0) {
        break label535;
      }
      i = 1;
      localObject2 = localObject1;
      if (i != 0)
      {
        localObject2 = am.aixg;
        localObject2 = String.format(s.X((String)localObject1, "?objectId=%s"), Arrays.copyOf(new Object[] { com.tencent.mm.ae.d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN) }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
      }
      localg.qAF = ((String)localObject2);
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)new ay());
      localg.scene = 1176;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId != 0L) {
        break label540;
      }
    }
    label535:
    label540:
    for (localObject1 = "pre_live_add";; localObject1 = "post_live_add")
    {
      localg.hzx = ((String)localObject1 + ':' + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + str1 + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject2 = j.Dob;
      localObject2 = j.Doc;
      String str2 = localg.hzx;
      s.s(str2, "sceneNote");
      ((com.tencent.mm.plugin.finder.live.report.q)localObject2).axA(str2);
      localObject2 = c.zGj;
      c.a.arH(str1);
      localObject2 = (bm)h.ax(bm.class);
      str2 = localg.appId;
      s.s(str2, "bundle.appId");
      ((bm)localObject2).b(3L, str2, str1, String.valueOf(((e)parama.business(e.class)).sessionId), (String)localObject1, ((e)parama.business(e.class)).hOG);
      paramm.invoke(Boolean.FALSE, localg);
      AppMethodBeat.o(350770);
      return;
      localObject1 = ((bih)localObject1).ZRp;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((bzd)localObject1).appId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label498:
      localObject1 = ((bih)localObject1).ZRp;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label79;
      }
      localObject2 = ((bzd)localObject1).aail;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label79;
      }
      localObject1 = "";
      break label79;
      i = 0;
      break label93;
    }
  }
  
  public static int bUw()
  {
    AppMethodBeat.i(350841);
    float f = bf.bf(MMApplicationContext.getContext()).y;
    if (MMApplicationContext.getResources().getConfiguration().orientation == 2) {
      f = bf.bf(MMApplicationContext.getContext()).x;
    }
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    int i = (int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F));
    AppMethodBeat.o(350841);
    return i;
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.convert.k paramk, m<? super Boolean, ? super g, kotlin.ah> paramm)
  {
    AppMethodBeat.i(350836);
    s.u(parama, "liveData");
    if (paramk == null)
    {
      Log.i(TAG, "[getPayloadForVisitorBubbleClick] fail, data is null!");
      AppMethodBeat.o(350836);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool1 = com.tencent.mm.plugin.finder.live.utils.a.Pr(paramk.DVs);
    localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool2 = com.tencent.d.a.a.a.a.a.jTs();
    byte[] arrayOfByte = Util.getUuidRandom();
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("[getPayloadForVisitorBubbleClick] appId:");
    localObject1 = paramk.DVq;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",purchase appId:");
      localObject1 = paramk.DVp;
      if (localObject1 != null) {
        break label651;
      }
      localObject1 = null;
      label121:
      Log.i((String)localObject2, localObject1 + ", isThirdParty:" + bool1 + ",detailFirst:" + bool2 + ",locClickId:" + arrayOfByte + '!');
      if (bool1 != true) {
        break label1213;
      }
      if (!bool2) {
        break label709;
      }
      localObject3 = Boolean.TRUE;
      s.s(arrayOfByte, "locClickId");
      localg = new g();
      localg.scene = 1177;
      localg.hzx = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject1 = j.Dob;
      localObject1 = j.Doc;
      localObject2 = localg.hzx;
      s.s(localObject2, "sceneNote");
      ((com.tencent.mm.plugin.finder.live.report.q)localObject1).axA((String)localObject2);
      localObject1 = paramk.DVq;
      if (localObject1 != null) {
        break label661;
      }
      localObject1 = "";
      label388:
      localg.appId = ((String)localObject1);
      localObject1 = paramk.DVq;
      if (localObject1 != null) {
        break label685;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localg.qAF = ((String)localObject1);
      i = bUw();
      localObject1 = HalfScreenConfig.a.rae;
      localObject2 = HalfScreenConfig.c.rao;
      localObject4 = HalfScreenConfig.h.raE;
      locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      localg.qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.h)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVq), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
      localObject4 = new ay();
      localObject2 = paramk.DVu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ay)localObject4).awD((String)localObject1);
      ((ay)localObject4).Azu = paramk.DVk;
      ((ay)localObject4).CIG = "";
      ((ay)localObject4).CIH = 3;
      ((ay)localObject4).CII = arrayOfByte;
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), localg.appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = kotlin.ah.aiuX;
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramm.invoke(localObject3, localg);
      AppMethodBeat.o(350836);
      return;
      localObject1 = ((aka)localObject1).appid;
      break;
      label651:
      localObject1 = ((aka)localObject1).appid;
      break label121;
      label661:
      localObject2 = ((aka)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label388;
      }
      localObject1 = "";
      break label388;
      label685:
      localObject2 = ((aka)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label709:
    localObject3 = Boolean.TRUE;
    s.s(arrayOfByte, "locClickId");
    g localg = new g();
    localg.scene = 1177;
    localg.hzx = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
    localObject1 = j.Dob;
    localObject1 = j.Doc;
    localObject2 = localg.hzx;
    s.s(localObject2, "sceneNote");
    ((com.tencent.mm.plugin.finder.live.report.q)localObject1).axA((String)localObject2);
    int i = bUw();
    localObject1 = HalfScreenConfig.a.rae;
    localObject2 = HalfScreenConfig.c.rao;
    Object localObject4 = HalfScreenConfig.h.raE;
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localg.qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, true, null, (HalfScreenConfig.h)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVp), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
    localObject1 = paramk.DVp;
    if (localObject1 == null)
    {
      localObject1 = "";
      localg.appId = ((String)localObject1);
      localObject1 = paramk.DVp;
      if (localObject1 != null) {
        break label1189;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localg.qAF = ((String)localObject1);
      localObject4 = new ay();
      localObject2 = paramk.DVu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ay)localObject4).awD((String)localObject1);
      ((ay)localObject4).Azu = paramk.DVk;
      ((ay)localObject4).CIG = "";
      ((ay)localObject4).CIH = 3;
      ((ay)localObject4).CII = arrayOfByte;
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), localg.appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = kotlin.ah.aiuX;
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramm.invoke(localObject3, localg);
      AppMethodBeat.o(350836);
      return;
      localObject2 = ((aka)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label1189:
      localObject2 = ((aka)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label1213:
    if (!bool1)
    {
      localObject3 = Boolean.TRUE;
      s.s(arrayOfByte, "locClickId");
      localg = new g();
      localg.scene = 1177;
      localg.hzx = ("live_bubble:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ':' + ((e)parama.business(e.class)).mIC + "::" + ((e)parama.business(e.class)).sessionId + ':' + arrayOfByte + ':' + ((e)parama.business(e.class)).hOG + ':' + ((e)parama.business(e.class)).Edo);
      localObject1 = j.Dob;
      localObject1 = j.Doc;
      localObject2 = localg.hzx;
      s.s(localObject2, "sceneNote");
      ((com.tencent.mm.plugin.finder.live.report.q)localObject1).axA((String)localObject2);
      i = bUw();
      localObject1 = HalfScreenConfig.a.rae;
      localObject2 = HalfScreenConfig.c.rap;
      localObject4 = HalfScreenConfig.h.raE;
      locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      localg.qAT = new HalfScreenConfig(true, i, (HalfScreenConfig.a)localObject1, false, null, false, null, (HalfScreenConfig.c)localObject2, false, false, null, (HalfScreenConfig.h)localObject4, com.tencent.mm.plugin.finder.live.view.convert.a.b(paramk.DVp), false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
      localObject1 = paramk.DVp;
      if (localObject1 != null) {
        break label1680;
      }
      localObject1 = "";
      localg.appId = ((String)localObject1);
      localObject1 = paramk.DVp;
      if (localObject1 != null) {
        break label1704;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localg.qAF = ((String)localObject1);
      localObject4 = new ay();
      localObject2 = paramk.DVu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ay)localObject4).awD((String)localObject1);
      ((ay)localObject4).Azu = paramk.DVk;
      ((ay)localObject4).CIG = "";
      ((ay)localObject4).CIH = 3;
      ((ay)localObject4).CII = arrayOfByte;
      ((ay)localObject4).qZT = true;
      paramk = c.zGj;
      c.a.f(arrayOfByte.toString(), localg.appId, b.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), "", b.hF(((e)parama.business(e.class)).sessionId));
      parama = kotlin.ah.aiuX;
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject4);
      paramm.invoke(localObject3, localg);
      AppMethodBeat.o(350836);
      return;
      label1680:
      localObject2 = ((aka)localObject1).appid;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label1704:
      localObject2 = ((aka)localObject1).path;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public static void d(g paramg)
  {
    AppMethodBeat.i(350847);
    s.u(paramg, "bundle");
    Log.i(TAG, "[appId:" + paramg.appId + ",path:" + paramg.qAF + ",halfScreen:" + paramg.qAT.isEnable() + ",scene:" + paramg.scene + ",sceneNote:" + paramg.hzx + ",extraData:" + paramg.qAG + ']');
    AppMethodBeat.o(350847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.k
 * JD-Core Version:    0.7.0.1
 */