package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.conv.r;
import com.tencent.mm.plugin.finder.conv.t;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.plugin.finder.feed.ax;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAppPushRouteProxyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "ctrlFlag", "", "getCtrlFlag", "()J", "ctrlFlag$delegate", "Lkotlin/Lazy;", "demotionFlag", "getDemotionFlag", "demotionFlag$delegate", "failReturnTo", "", "getFailReturnTo", "()I", "failReturnTo$delegate", "feedId", "getFeedId", "feedId$delegate", "jumpTypeCode", "getJumpTypeCode", "jumpTypeCode$delegate", "nonceId", "", "getNonceId", "()Ljava/lang/String;", "nonceId$delegate", "pushLevel", "getPushLevel", "pushLevel$delegate", "report_ext_info", "getReport_ext_info", "report_ext_info$delegate", "sessionId", "getSessionId", "sessionId$delegate", "showSource", "getShowSource", "showSource$delegate", "taskId", "getTaskId", "taskId$delegate", "backToFindPage", "", "backToMainPage", "enterFinderHome", "intent", "Landroid/content/Intent;", "getEnter", "getLayoutId", "handleFinderHomeRedDot", "handleLiveEntranceRedDot", "isFinderClose", "", "extStatus", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openFinderEntrance", "report23587", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "path", "contextId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAppPushRouteProxyUI
  extends MMFinderUI
{
  public static final a Blp;
  private final kotlin.j AZZ;
  private final kotlin.j Blq;
  private final kotlin.j Blr;
  private final kotlin.j Bls;
  private final kotlin.j Blt;
  private final kotlin.j Blu;
  private final kotlin.j Blv;
  private final kotlin.j Blw;
  private final kotlin.j Blx;
  private final kotlin.j nWN;
  private final kotlin.j pmQ;
  
  static
  {
    AppMethodBeat.i(365437);
    Blp = new a((byte)0);
    AppMethodBeat.o(365437);
  }
  
  public FinderAppPushRouteProxyUI()
  {
    AppMethodBeat.i(365281);
    this.pmQ = kotlin.k.cm((kotlin.g.a.a)new q(this));
    this.Blq = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Blr = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Bls = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Blt = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.AZZ = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.Blu = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.Blv = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.Blw = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.Blx = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.nWN = kotlin.k.cm((kotlin.g.a.a)new o(this));
    AppMethodBeat.o(365281);
  }
  
  private static final ah a(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(365431);
    kotlin.g.b.s.u(paramFinderAppPushRouteProxyUI, "this$0");
    Log.i("Finder.AppPushRouteProxyUI", "[CgiGetFinderFeedComment] errType=" + parama.errType + " errCode=" + parama.errCode);
    if (parama.errCode == -4200)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { paramFinderAppPushRouteProxyUI.bQs(), "return", Long.valueOf(System.currentTimeMillis()), "-4200", Integer.valueOf(1), Integer.valueOf(2) });
      paramString = (Intent)paramFinderAppPushRouteProxyUI.getIntent().getParcelableExtra("KEY_JUMP_HOT_INTENT");
      paramFinderAppPushRouteProxyUI.eey();
      paramFinderAppPushRouteProxyUI.at(paramString);
      paramFinderAppPushRouteProxyUI = ah.aiuX;
      AppMethodBeat.o(365431);
      return paramFinderAppPushRouteProxyUI;
    }
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("client_trigger_scene", paramFinderAppPushRouteProxyUI.ees());
    Object localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
    Object localObject2 = paramFinderAppPushRouteProxyUI.bQs();
    long l = System.currentTimeMillis();
    localObject3 = ((JSONObject)localObject3).toString();
    kotlin.g.b.s.s(localObject3, "json.toString()");
    ((com.tencent.mm.plugin.report.service.h)localObject1).b(23498, new Object[] { localObject2, Integer.valueOf(1), Long.valueOf(l), kotlin.n.n.bV((String)localObject3, ",", ";"), Integer.valueOf(paramFinderAppPushRouteProxyUI.eet()), Integer.valueOf(paramFinderAppPushRouteProxyUI.eeu()), paramFinderAppPushRouteProxyUI.getSessionId(), paramFinderAppPushRouteProxyUI.eev() });
    localObject1 = (ayl)parama.ott;
    localObject2 = ((ayl)parama.ott).feedObject;
    if (localObject1 == null)
    {
      l = 0L;
      if ((l != 0L) && (((ayl)localObject1).feedObject != null)) {
        break label573;
      }
      Log.e("Finder.AppPushRouteProxyUI", "get liveId failed.");
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { paramFinderAppPushRouteProxyUI.bQs(), "return", Long.valueOf(System.currentTimeMillis()), "liveId == 0L", Integer.valueOf(1), Integer.valueOf(2) });
      i = ((Number)paramFinderAppPushRouteProxyUI.Bls.getValue()).intValue();
      paramString = t.AHw;
      if (i != t.dXt()) {
        break label513;
      }
      paramString = new Intent();
      paramString.addFlags(67108864);
      paramString.putExtra("preferred_tab", 0);
      com.tencent.mm.br.c.g((Context)paramFinderAppPushRouteProxyUI, ".ui.LauncherUI", paramString);
      paramFinderAppPushRouteProxyUI.overridePendingTransition(com.tencent.mm.plugin.finder.e.a.slide_left_in, com.tencent.mm.plugin.finder.e.a.slide_right_out);
    }
    for (;;)
    {
      paramFinderAppPushRouteProxyUI = ah.aiuX;
      AppMethodBeat.o(365431);
      return paramFinderAppPushRouteProxyUI;
      parama = ((ayl)localObject1).feedObject;
      if (parama == null)
      {
        l = 0L;
        break;
      }
      parama = parama.liveInfo;
      if (parama == null)
      {
        l = 0L;
        break;
      }
      l = parama.liveId;
      break;
      label513:
      paramString = t.AHw;
      if (i == t.dXu())
      {
        paramString = new Intent();
        paramString.addFlags(67108864);
        paramString.putExtra("preferred_tab", 2);
        com.tencent.mm.br.c.g((Context)paramFinderAppPushRouteProxyUI, ".ui.LauncherUI", paramString);
        paramFinderAppPushRouteProxyUI.overridePendingTransition(com.tencent.mm.plugin.finder.e.a.slide_left_in, com.tencent.mm.plugin.finder.e.a.slide_right_out);
      }
    }
    label573:
    if (localObject2 == null)
    {
      paramFinderAppPushRouteProxyUI = ah.aiuX;
      AppMethodBeat.o(365431);
      return paramFinderAppPushRouteProxyUI;
    }
    localObject3 = new Intent();
    l = paramFinderAppPushRouteProxyUI.eer();
    parama = com.tencent.mm.plugin.finder.conv.s.AHq;
    if ((l & com.tencent.mm.plugin.finder.conv.s.dXn()) != 0L) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).jr(paramFinderAppPushRouteProxyUI.getFeedId());
    }
    l = paramFinderAppPushRouteProxyUI.eer();
    parama = com.tencent.mm.plugin.finder.conv.s.AHq;
    if ((l & com.tencent.mm.plugin.finder.conv.s.dXp()) != 0L) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).js(paramFinderAppPushRouteProxyUI.getFeedId());
    }
    ((Intent)localObject3).putExtra("key_enter_live_param_visitor_enter_scene", paramFinderAppPushRouteProxyUI.getIntent().getIntExtra("key_enter_live_param_visitor_enter_scene", 0));
    ((Intent)localObject3).putExtra("KEY_TASK_ID", paramFinderAppPushRouteProxyUI.bQs());
    ((Intent)localObject3).putExtra("key_enter_live_param_by_pass_type", paramFinderAppPushRouteProxyUI.getIntent().getIntExtra("key_enter_live_param_by_pass_type", 0));
    ((Intent)localObject3).putExtra("key_enter_live_param_by_pass_info", paramFinderAppPushRouteProxyUI.getIntent().getStringExtra("key_enter_live_param_by_pass_info"));
    ((Intent)localObject3).putExtra("KEY_ENTER_LIVE_PARAM_APP_PUSH_TASK_ID", paramFinderAppPushRouteProxyUI.getIntent().getStringExtra("KEY_ENTER_LIVE_PARAM_APP_PUSH_TASK_ID"));
    parama = e.FMN;
    parama = FinderItem.Companion;
    com.tencent.mm.plugin.finder.storage.data.e.a.s(FinderItem.a.e((FinderObject)localObject2, 0));
    paramFinderAppPushRouteProxyUI.eey();
    com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.s.s(localContext, "getContext()");
    FinderLiveBundle localFinderLiveBundle = new FinderLiveBundle();
    parama = new ArrayList(1);
    localObject1 = com.tencent.mm.kernel.h.ax(g.class);
    kotlin.g.b.s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
    parama.add(g.a.a((g)localObject1, (FinderObject)localObject2, 0, 2));
    localObject1 = ah.aiuX;
    localFinderLiveBundle.ag(parama);
    localFinderLiveBundle.AJo = 65;
    localFinderLiveBundle.CFf = 1;
    localFinderLiveBundle.zIO = paramString;
    localObject1 = ((FinderObject)localObject2).nickname;
    parama = (b.a)localObject1;
    if (localObject1 == null) {
      parama = "";
    }
    localFinderLiveBundle.awv(parama);
    parama = ((FinderObject)localObject2).liveInfo;
    if (parama == null) {}
    for (int i = 0;; i = parama.ZRR)
    {
      localFinderLiveBundle.extFlag = i;
      parama = ah.aiuX;
      kotlin.g.b.s.s(paramString, "contextId");
      f.a.a(localf, localContext, localFinderLiveBundle, paramString, "", (Intent)localObject3, false, 32);
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { paramFinderAppPushRouteProxyUI.bQs(), "getcommentdetail", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(2) });
      paramFinderAppPushRouteProxyUI = ah.aiuX;
      AppMethodBeat.o(365431);
      return paramFinderAppPushRouteProxyUI;
    }
  }
  
  private static void a(com.tencent.mm.plugin.finder.extension.reddot.i parami, String paramString1, String paramString2)
  {
    AppMethodBeat.i(365397);
    p localp = parami.Su(paramString1);
    parami = parami.avp(paramString1);
    if ((localp != null) && (parami != null))
    {
      paramString1 = w.FrV;
      w.a(localp, parami, 1, paramString2);
    }
    AppMethodBeat.o(365397);
  }
  
  private final void at(Intent paramIntent)
  {
    AppMethodBeat.i(365358);
    if (paramIntent == null)
    {
      AppMethodBeat.o(365358);
      return;
    }
    long l = eer();
    Object localObject1 = com.tencent.mm.plugin.finder.conv.s.AHq;
    if ((l & com.tencent.mm.plugin.finder.conv.s.dXm()) != 0L)
    {
      localObject1 = com.tencent.mm.plugin.finder.feed.model.i.Bfg;
      com.tencent.mm.plugin.finder.feed.model.i.edN();
    }
    l = eer();
    localObject1 = com.tencent.mm.plugin.finder.conv.s.AHq;
    if ((l & com.tencent.mm.plugin.finder.conv.s.dXo()) != 0L) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).jo(getFeedId());
    }
    l = z.bAR();
    Object localObject3 = new JSONObject();
    Object localObject2;
    if (nM(l))
    {
      nN(l);
      ((JSONObject)localObject3).put("if_enforce_disc_finder_on", 1);
      ((JSONObject)localObject3).put("client_trigger_scene", ees());
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      localObject2 = bQs();
      l = System.currentTimeMillis();
      localObject3 = ((JSONObject)localObject3).toString();
      kotlin.g.b.s.s(localObject3, "json.toString()");
      ((com.tencent.mm.plugin.report.service.h)localObject1).b(23498, new Object[] { localObject2, Integer.valueOf(1), Long.valueOf(l), kotlin.n.n.bV((String)localObject3, ",", ";"), Integer.valueOf(eet()), Integer.valueOf(eeu()), getSessionId(), eev() });
      paramIntent.putExtra("KEY_FROM_PATH", "appPush");
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4);
      ((d.a)localObject1).a(d.d.GKM);
      ((d.a)localObject1).GKz = -1L;
      ((d.a)localObject1).GKD = true;
      l = eeq();
      localObject2 = r.AHk;
      if ((l & r.dXk()) == 0L) {
        break label455;
      }
    }
    label455:
    for (boolean bool = true;; bool = false)
    {
      ((d.a)localObject1).GKE = bool;
      localObject2 = ax.AZe;
      ax.ecC();
      l = eer();
      localObject2 = com.tencent.mm.plugin.finder.conv.s.AHq;
      if ((l & com.tencent.mm.plugin.finder.conv.s.dXq()) == 0L)
      {
        ((d.a)localObject1).GKv.clear();
        localObject1 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
        com.tencent.mm.plugin.finder.storage.data.k.a.a(8, "", (b)d.Blz);
      }
      eex();
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, paramIntent, 0, false, 12);
      AppMethodBeat.o(365358);
      return;
      ((JSONObject)localObject3).put("if_enforce_disc_finder_on", 0);
      ((JSONObject)localObject3).put("client_trigger_scene", ees());
      break;
    }
  }
  
  private final String bQs()
  {
    AppMethodBeat.i(365287);
    String str = (String)this.pmQ.getValue();
    AppMethodBeat.o(365287);
    return str;
  }
  
  private final long eeq()
  {
    AppMethodBeat.i(365300);
    long l = ((Number)this.Blr.getValue()).longValue();
    AppMethodBeat.o(365300);
    return l;
  }
  
  private final long eer()
  {
    AppMethodBeat.i(365307);
    long l = ((Number)this.Blt.getValue()).longValue();
    AppMethodBeat.o(365307);
    return l;
  }
  
  private final String ees()
  {
    AppMethodBeat.i(365313);
    String str = (String)this.Blu.getValue();
    AppMethodBeat.o(365313);
    return str;
  }
  
  private final int eet()
  {
    AppMethodBeat.i(365320);
    int i = ((Number)this.Blv.getValue()).intValue();
    AppMethodBeat.o(365320);
    return i;
  }
  
  private final int eeu()
  {
    AppMethodBeat.i(365325);
    int i = ((Number)this.Blw.getValue()).intValue();
    AppMethodBeat.o(365325);
    return i;
  }
  
  private final String eev()
  {
    AppMethodBeat.i(365331);
    String str = (String)this.Blx.getValue();
    AppMethodBeat.o(365331);
    return str;
  }
  
  private final int eew()
  {
    AppMethodBeat.i(365366);
    long l = eeq();
    r localr = r.AHk;
    if ((l & r.dXk()) != 0L)
    {
      AppMethodBeat.o(365366);
      return 29;
    }
    AppMethodBeat.o(365366);
    return 34;
  }
  
  private final void eex()
  {
    AppMethodBeat.i(365377);
    Object localObject1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(eew(), 2, 20, getIntent());
    Object localObject2 = w.FrV;
    kotlin.g.b.s.s(localObject1, "contextId");
    w.azS((String)localObject1);
    localObject2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
      AppMethodBeat.o(365377);
      throw ((Throwable)localObject1);
    }
    localObject2 = (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2;
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "FinderEntrance", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).TL("FinderEntrance");
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "TLPersonalCenter", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).a("TLPersonalCenter", (b)FinderAppPushRouteProxyUI.g.BlA, true);
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "Discovery", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).a("Discovery", (b)FinderAppPushRouteProxyUI.h.BlB, true);
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "TLFollow", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).TL("TLFollow");
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "TLRecommendTab", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).TL("TLRecommendTab");
    a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, "finder_tl_hot_tab", (String)localObject1);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).TL("finder_tl_hot_tab");
    AppMethodBeat.o(365377);
  }
  
  private final void eey()
  {
    long l = 0L;
    AppMethodBeat.i(365391);
    Object localObject1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
      AppMethodBeat.o(365391);
      throw ((Throwable)localObject1);
    }
    localObject1 = (com.tencent.mm.plugin.finder.extension.reddot.i)localObject1;
    String str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(eew(), 2, 65);
    Object localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su("FinderLiveEntrance");
      if (localObject2 == null) {}
      for (;;)
      {
        Log.i("Finder.AppPushRouteProxyUI", "[handleLiveEntranceRedDot] objId=" + com.tencent.mm.ae.d.hF(l) + " feedId=" + com.tencent.mm.ae.d.hF(getFeedId()));
        if (getFeedId() == l)
        {
          kotlin.g.b.s.s(str, "contextId");
          a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "FinderLiveEntrance", str);
          localObject2 = m.ASi;
          m.a.avE(str);
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("FinderLiveEntrance");
          a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "Discovery", str);
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a("Discovery", (b)FinderAppPushRouteProxyUI.i.BlC, true);
        }
        localObject1 = q.ASF;
        q.eaY();
        AppMethodBeat.o(365391);
        return;
        localObject2 = ((p)localObject2).ASz;
        if (localObject2 != null) {
          l = ((btx)localObject2).object_id;
        }
      }
    }
    localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su("NearbyEntrance");
    if (localObject2 == null) {}
    for (;;)
    {
      Log.i("Finder.AppPushRouteProxyUI", "[handleLiveEntranceRedDot] objId=" + com.tencent.mm.ae.d.hF(l) + " feedId=" + com.tencent.mm.ae.d.hF(getFeedId()));
      if (getFeedId() == l)
      {
        kotlin.g.b.s.s(str, "contextId");
        a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "NearbyEntrance", str);
        localObject2 = m.ASi;
        m.a.ew(str, 1);
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("NearbyEntrance");
        a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "Discovery", str);
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a("Discovery", (b)FinderAppPushRouteProxyUI.j.BlD, true);
      }
      localObject1 = q.ASF;
      q.eaW();
      AppMethodBeat.o(365391);
      return;
      localObject2 = ((p)localObject2).ASz;
      if (localObject2 != null) {
        l = ((btx)localObject2).object_id;
      }
    }
  }
  
  private final long getFeedId()
  {
    AppMethodBeat.i(365294);
    long l = ((Number)this.Blq.getValue()).longValue();
    AppMethodBeat.o(365294);
    return l;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(365340);
    String str = (String)this.nWN.getValue();
    AppMethodBeat.o(365340);
    return str;
  }
  
  private static boolean nM(long paramLong)
  {
    return (0x0 & paramLong) != 0L;
  }
  
  private static void nN(long paramLong)
  {
    AppMethodBeat.i(365411);
    paramLong = 0xFFFFFFFF & paramLong;
    com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(paramLong));
    Log.i("Finder.AppPushRouteProxyUI", kotlin.g.b.s.X("openFinderEntrance extstatus:", Long.valueOf(paramLong)));
    cas localcas = new cas();
    localcas.aajJ = 57;
    localcas.NkL = 1;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d((com.tencent.mm.plugin.messenger.foundation.a.a.k.b)new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(23, (com.tencent.mm.bx.a)localcas));
    Log.d("Finder.AppPushRouteProxyUI", "openFinderEntrance switch functionId:" + localcas.aajJ + " to " + localcas.NkL);
    AppMethodBeat.o(365411);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_transparent_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365463);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.findersdk.a.n.Hcg;
    com.tencent.mm.plugin.findersdk.a.n.rk(System.currentTimeMillis());
    paramBundle = com.tencent.mm.plugin.findersdk.a.n.Hcg;
    paramBundle = bQs();
    kotlin.g.b.s.checkNotNull(paramBundle);
    kotlin.g.b.s.s(paramBundle, "taskId!!");
    com.tencent.mm.plugin.findersdk.a.n.aDc(paramBundle);
    paramBundle = com.tencent.mm.plugin.findersdk.a.n.Hcg;
    paramBundle = bQs();
    kotlin.g.b.s.checkNotNull(paramBundle);
    kotlin.g.b.s.s(paramBundle, "taskId!!");
    com.tencent.mm.plugin.findersdk.a.n.aDd(paramBundle);
    if (getIntent().getIntExtra("KEY_ROUTE_TYPE", -1) == 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { bQs(), "route_create", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(1) });
      at(getIntent());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(365463);
      return;
      long l;
      Object localObject1;
      Object localObject2;
      if (getIntent().getIntExtra("KEY_ROUTE_TYPE", -1) == 1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { bQs(), "route_create", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(2) });
        paramBundle = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(eew(), 2, 65);
        l = getFeedId();
        localObject1 = (String)this.AZZ.getValue();
        localObject2 = new bui();
        ((bui)localObject2).zIO = paramBundle;
        ah localah = ah.aiuX;
        localObject1 = new az(l, (String)localObject1, 65, 2, "", true, null, null, 0L, null, false, false, null, (bui)localObject2, 0, null, 57280);
        ((az)localObject1).frW().setIsUserCmd(true);
        ((az)localObject1).bFJ().b(new FinderAppPushRouteProxyUI..ExternalSyntheticLambda0(this, paramBundle));
      }
      else if ((getIntent().getIntExtra("KEY_ROUTE_TYPE", -1) == 2) && (getIntent().getByteArrayExtra("KEY_JUMP_INFO") != null))
      {
        getIntent().putExtra("KEY_ROUTE_TO_TOPIC", true);
        at(getIntent());
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("client_trigger_scene", ees());
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        localObject1 = bQs();
        l = System.currentTimeMillis();
        localObject2 = ((JSONObject)localObject2).toString();
        kotlin.g.b.s.s(localObject2, "json.toString()");
        paramBundle.b(23498, new Object[] { localObject1, Integer.valueOf(1), Long.valueOf(l), kotlin.n.n.bV((String)localObject2, ",", ";"), Integer.valueOf(eet()), Integer.valueOf(eeu()), getSessionId(), eev() });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAppPushRouteProxyUI$Companion;", "", "()V", "KEY_FINDER_OBJECT", "", "KEY_JUMP_HOT_INTENT", "KEY_JUMP_INFO", "KEY_JUMP_TYPE_CODE", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_PUSH_CTRL_FLAG", "KEY_PUSH_DEMOTION_FLAG", "KEY_PUSH_FAIL_RETURN_READY", "KEY_PUSH_FAIL_RETURN_TO", "KEY_PUSH_LEVEL", "KEY_REPORT_EXT_INFO", "KEY_ROUTE_TYPE", "KEY_SESSION_ID", "KEY_SHOW_SOURCE", "KEY_TASK_ID", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Long>
  {
    b(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Long>
  {
    c(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<axb, Boolean>
  {
    public static final d Blz;
    
    static
    {
      AppMethodBeat.i(365697);
      Blz = new d();
      AppMethodBeat.o(365697);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Long>
  {
    f(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Integer>
  {
    k(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<String>
  {
    l(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<Integer>
  {
    m(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<String>
  {
    n(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<String>
  {
    o(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<String>
  {
    p(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<String>
  {
    q(FinderAppPushRouteProxyUI paramFinderAppPushRouteProxyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAppPushRouteProxyUI
 * JD-Core Version:    0.7.0.1
 */