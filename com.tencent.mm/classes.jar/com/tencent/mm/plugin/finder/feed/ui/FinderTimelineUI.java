package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fo;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.ag.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.feed.aw.a;
import com.tencent.mm.plugin.finder.feed.aw.b;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.feed.bh;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.bd;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.api.k
{
  public static final a Bsl;
  private aw.a AIY;
  private aw.b AZO;
  private bys AwM;
  private final int Bsm;
  private final int Bsn;
  private final int Bso;
  private final com.tencent.mm.plugin.finder.viewmodel.b Bsp;
  private HashMap<Integer, efo> Bsq;
  private ProgressDialog qbH;
  private boolean wGs;
  private String zIO;
  
  static
  {
    AppMethodBeat.i(166265);
    Bsl = new a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(364941);
    this.Bsm = 1;
    this.Bsn = 2;
    this.Bso = 3;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.Bsp = ((com.tencent.mm.plugin.finder.viewmodel.b)localObject);
    this.Bsq = new HashMap();
    AppMethodBeat.o(364941);
  }
  
  private static final void a(di paramdi, FinderTimelineUI paramFinderTimelineUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(365074);
    kotlin.g.b.s.u(paramdi, "$prepareScene");
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramdi);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)paramFinderTimelineUI);
    AppMethodBeat.o(365074);
  }
  
  private static final void a(FinderTimelineUI paramFinderTimelineUI)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364981);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    Object localObject3 = paramFinderTimelineUI.AZO;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject1 = ((aw.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      paramFinderTimelineUI = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(364981);
      throw paramFinderTimelineUI;
    }
    if (((LinearLayoutManager)localObject1).Ju() <= 12)
    {
      localObject3 = paramFinderTimelineUI.AZO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject1 = ag.AKO;
      localObject3 = paramFinderTimelineUI.AZO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      paramFinderTimelineUI = paramFinderTimelineUI.AIY;
      if (paramFinderTimelineUI != null) {
        break label340;
      }
      kotlin.g.b.s.bIx("presenter");
      paramFinderTimelineUI = localObject2;
    }
    label340:
    for (;;)
    {
      ag.a.a((aw.b)localObject1, paramFinderTimelineUI.getTabType());
      AppMethodBeat.o(364981);
      return;
      localObject3 = paramFinderTimelineUI.AZO;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onCreate$lambda-1", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;)V", "Undefined", "scrollToPosition", "(I)V");
      break;
    }
  }
  
  private static final void a(FinderTimelineUI paramFinderTimelineUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(365015);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    Object localObject = new Intent();
    if (paramMenuItem.getItemId() == 1001)
    {
      ((Intent)localObject).putExtra("key_finder_post_router", 2);
      ((Intent)localObject).putExtra("key_finder_post_from", 5);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramMenuItem = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramMenuItem = as.GSQ;
      paramFinderTimelineUI = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramFinderTimelineUI, "context");
      paramFinderTimelineUI = as.a.hu((Context)paramFinderTimelineUI);
      if (paramFinderTimelineUI == null) {}
      for (paramFinderTimelineUI = null;; paramFinderTimelineUI = paramFinderTimelineUI.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "post_acionsheet_camera", "", paramFinderTimelineUI);
        AppMethodBeat.o(365015);
        return;
      }
    }
    if (paramMenuItem.getItemId() == 1002)
    {
      ((Intent)localObject).putExtra("key_finder_post_router", 3);
      ((Intent)localObject).putExtra("key_finder_post_from", 5);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramMenuItem = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramMenuItem = as.GSQ;
      paramFinderTimelineUI = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramFinderTimelineUI, "context");
      paramFinderTimelineUI = as.a.hu((Context)paramFinderTimelineUI);
      if (paramFinderTimelineUI == null) {}
      for (paramFinderTimelineUI = null;; paramFinderTimelineUI = paramFinderTimelineUI.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_album", "", paramFinderTimelineUI);
        AppMethodBeat.o(365015);
        return;
      }
    }
    if (paramMenuItem.getItemId() == 1004)
    {
      paramMenuItem = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(paramMenuItem, "service(IActivityRouter::class.java)");
      paramMenuItem = (com.tencent.mm.plugin.f)paramMenuItem;
      paramFinderTimelineUI = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramFinderTimelineUI, "context");
      f.a.a(paramMenuItem, (Context)paramFinderTimelineUI, 0L, "", null, null, null, null, null, null, null, null, null, 8184);
      AppMethodBeat.o(365015);
      return;
    }
    if (paramFinderTimelineUI.Bsq.containsKey(Integer.valueOf(paramMenuItem.getItemId())))
    {
      localObject = am.GhD;
      am.a((Context)paramFinderTimelineUI, (efo)paramFinderTimelineUI.Bsq.get(Integer.valueOf(paramMenuItem.getItemId())));
      paramFinderTimelineUI = v.FrN;
      v.aP(1, false);
    }
    AppMethodBeat.o(365015);
  }
  
  private static final void a(FinderTimelineUI paramFinderTimelineUI, l.a parama)
  {
    AppMethodBeat.i(364994);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    boolean bool;
    int i;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      Log.i("Finder.FinderTimelineUI", kotlin.g.b.s.X("[MENU_ID_PROFILE] red=", Boolean.valueOf(bool)));
      if ((parama == null) || (parama.hBY != true)) {
        break label94;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        if (m.a.ean())
        {
          paramFinderTimelineUI.getController().updateOptionMenuRedDot(paramFinderTimelineUI.Bsm, true);
          AppMethodBeat.o(364994);
          return;
          bool = false;
          break;
          label94:
          i = 0;
          continue;
        }
        paramFinderTimelineUI.getController().updateOptionMenuRedDot(paramFinderTimelineUI.Bsm, false);
        Log.w("Finder.FinderTimelineUI", "has red dot,but not count.");
        com.tencent.mm.plugin.report.service.h.OAn.p(1347L, 1L, 1L);
        AppMethodBeat.o(364994);
        return;
      }
    }
    paramFinderTimelineUI.getController().updateOptionMenuRedDot(paramFinderTimelineUI.Bsm, false);
    AppMethodBeat.o(364994);
  }
  
  private static final void a(FinderTimelineUI paramFinderTimelineUI, com.tencent.mm.ui.base.s params)
  {
    Object localObject1 = null;
    AppMethodBeat.i(365007);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
      params.oh(1004, e.h.finder_live_entry);
      Object localObject2 = am.GhD;
      localObject2 = paramFinderTimelineUI.Bsq;
      AppCompatActivity localAppCompatActivity = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(localAppCompatActivity, "context");
      am.a((HashMap)localObject2, params, (Activity)localAppCompatActivity);
    }
    params = com.tencent.mm.plugin.finder.report.z.FrZ;
    params = as.GSQ;
    params = paramFinderTimelineUI.getContext();
    kotlin.g.b.s.s(params, "context");
    params = as.a.hu((Context)params);
    if (params == null)
    {
      params = null;
      com.tencent.mm.plugin.finder.report.z.b(0, "post_acionsheet_camera", "", params);
      params = com.tencent.mm.plugin.finder.report.z.FrZ;
      params = as.GSQ;
      paramFinderTimelineUI = paramFinderTimelineUI.getContext();
      kotlin.g.b.s.s(paramFinderTimelineUI, "context");
      paramFinderTimelineUI = as.a.hu((Context)paramFinderTimelineUI);
      if (paramFinderTimelineUI != null) {
        break label192;
      }
    }
    label192:
    for (paramFinderTimelineUI = localObject1;; paramFinderTimelineUI = paramFinderTimelineUI.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "post_actionsheet_album", "", paramFinderTimelineUI);
      AppMethodBeat.o(365007);
      return;
      params = params.fou();
      break;
    }
  }
  
  private static final boolean a(FinderTimelineUI paramFinderTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364965);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    paramFinderTimelineUI.onBackPressed();
    AppMethodBeat.o(364965);
    return true;
  }
  
  private static final boolean a(bxq parambxq, com.tencent.mm.plugin.finder.extension.reddot.p paramp, FinderTimelineUI paramFinderTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365032);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    paramMenuItem = av.GiL;
    paramMenuItem = aw.Gjk;
    if ((parambxq != null) && (paramp != null))
    {
      w localw = w.FrV;
      paramMenuItem = as.GSQ;
      paramMenuItem = as.a.hu((Context)paramFinderTimelineUI);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        w.a(localw, "2", paramp, parambxq, 2, paramMenuItem, 0, null, 0, 480);
        parambxq = com.tencent.mm.plugin.finder.report.z.FrZ;
        parambxq = as.GSQ;
        parambxq = as.a.hu((Context)paramFinderTimelineUI);
        if (parambxq != null) {
          break label274;
        }
        parambxq = null;
        label91:
        com.tencent.mm.plugin.finder.report.z.a("2", 2, 2, 1, 1, 0, null, null, 0L, parambxq, 0, 0, 3520);
      }
    }
    else
    {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLCamera");
      if (!Util.isNullOrNil(com.tencent.mm.model.z.bAW())) {
        break label398;
      }
      if (paramFinderTimelineUI.AwM != null) {
        break label288;
      }
      Log.i("Finder.FinderTimelineUI", "need prepare user");
      parambxq = l.ARA;
      parambxq = (l.a)l.dZD().getValue();
      if ((parambxq == null) || (parambxq.hBY != true)) {
        break label282;
      }
    }
    label274:
    label282:
    for (boolean bool = true;; bool = false)
    {
      parambxq = new di(3);
      parambxq.ADf = bool;
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)parambxq, 0);
      com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)paramFinderTimelineUI);
      paramFinderTimelineUI.qbH = ((ProgressDialog)com.tencent.mm.ui.base.k.a((Context)paramFinderTimelineUI, paramFinderTimelineUI.getString(e.h.app_waiting), true, new FinderTimelineUI..ExternalSyntheticLambda0(parambxq, paramFinderTimelineUI)));
      AppMethodBeat.o(365032);
      return true;
      paramMenuItem = paramMenuItem.fou();
      break;
      parambxq = parambxq.fou();
      break label91;
    }
    label288:
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0);
    Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x2) != 0) {
      com.tencent.mm.ui.base.k.c((Context)paramFinderTimelineUI, paramFinderTimelineUI.getString(e.h.finder_self_contact_reviewing), "", true);
    }
    for (;;)
    {
      AppMethodBeat.o(365032);
      return true;
      parambxq = av.GiL;
      if (av.aO((Activity)paramFinderTimelineUI))
      {
        parambxq = av.GiL;
        av.a((Context)paramFinderTimelineUI, paramFinderTimelineUI.getString(e.h.finder_timeline_create_contact_tip), paramFinderTimelineUI.AwM);
        continue;
        label398:
        paramFinderTimelineUI.efU();
      }
    }
  }
  
  private static final void b(FinderTimelineUI paramFinderTimelineUI, l.a parama)
  {
    AppMethodBeat.i(365000);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    boolean bool;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      Log.i("Finder.FinderTimelineUI", kotlin.g.b.s.X("[MENU_ID_POST] red=", Boolean.valueOf(bool)));
      if ((parama == null) || (parama.hBY != true)) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label89;
      }
      paramFinderTimelineUI.getController().updateOptionMenuRedDot(paramFinderTimelineUI.Bsn, true);
      AppMethodBeat.o(365000);
      return;
      bool = false;
      break;
    }
    label89:
    paramFinderTimelineUI.getController().updateOptionMenuRedDot(paramFinderTimelineUI.Bsn, false);
    AppMethodBeat.o(365000);
  }
  
  private static final boolean b(FinderTimelineUI paramFinderTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365068);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    paramMenuItem = new fo();
    paramMenuItem.iIo = 1;
    paramMenuItem.bMH();
    Log.i("Finder.FinderTimelineUI", kotlin.g.b.s.X("report18939 postEdu: ", Integer.valueOf(paramMenuItem.iIo)));
    paramFinderTimelineUI = new com.tencent.mm.plugin.finder.view.d((Context)paramFinderTimelineUI.getContext());
    paramFinderTimelineUI.UD(e.f.finder_post_edu_layout);
    Object localObject = (TextView)paramFinderTimelineUI.rootView.findViewById(e.e.no_post_edu_title);
    paramMenuItem = (TextView)paramFinderTimelineUI.rootView.findViewById(e.e.no_post_edu_desc);
    TextView localTextView = (TextView)paramFinderTimelineUI.rootView.findViewById(e.e.no_post_edu_ok);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.d.eQY());
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    paramMenuItem.setText((CharSequence)com.tencent.mm.plugin.finder.storage.d.eRb());
    localTextView.setOnClickListener(new FinderTimelineUI..ExternalSyntheticLambda5(paramFinderTimelineUI));
    paramFinderTimelineUI.dDn();
    AppMethodBeat.o(365068);
    return true;
  }
  
  private static final boolean b(bxq parambxq, com.tencent.mm.plugin.finder.extension.reddot.p paramp, FinderTimelineUI paramFinderTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365045);
    kotlin.g.b.s.u(paramFinderTimelineUI, "this$0");
    paramMenuItem = av.GiL;
    paramMenuItem = aw.Gjk;
    if ((parambxq != null) && (paramp != null))
    {
      w localw = w.FrV;
      paramMenuItem = as.GSQ;
      paramMenuItem = as.a.hu((Context)paramFinderTimelineUI);
      if (paramMenuItem != null) {
        break label158;
      }
      paramMenuItem = null;
      w.a(localw, "2", paramp, parambxq, 2, paramMenuItem, 0, null, 0, 480);
      parambxq = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramp = paramp.field_tipsId;
      parambxq = as.GSQ;
      parambxq = as.a.hu((Context)paramFinderTimelineUI);
      if (parambxq != null) {
        break label166;
      }
    }
    label158:
    label166:
    for (parambxq = null;; parambxq = parambxq.fou())
    {
      com.tencent.mm.plugin.finder.report.z.a("2", 1, 2, 1, 2, 0, paramp, null, 0L, parambxq, 0, 0, 3456);
      parambxq = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)paramFinderTimelineUI, null);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLPersonalCenter");
      AppMethodBeat.o(365045);
      return true;
      paramMenuItem = paramMenuItem.fou();
      break;
    }
  }
  
  private static final void d(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(365056);
    kotlin.g.b.s.u(paramd, "$this_apply");
    paramd.cyW();
    AppMethodBeat.o(365056);
  }
  
  private final void efU()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    if (com.tencent.mm.plugin.finder.utils.a.gX((Context)this))
    {
      localObject1 = v.FrN;
      v.aP(1, true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = v.FrN;
    v.aP(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, true);
    View localView = af.mU((Context)getContext()).inflate(e.f.finder_sheet_header, null);
    Object localObject4 = (TextView)localView.findViewById(e.e.nickname);
    Object localObject2 = (ImageView)localView.findViewById(e.e.avatar);
    Object localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject3 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject3 != null)
    {
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject3).getNickname()));
      localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject4 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject3).field_avatarUrl);
      kotlin.g.b.s.s(localObject2, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject4).a(localb, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject2 = av.GiL;
      kotlin.g.b.s.s(localView, "headerView");
      av.a((com.tencent.mm.plugin.finder.api.m)localObject3, localView);
    }
    ((com.tencent.mm.ui.widget.a.f)localObject1).af(localView, true);
    ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = new FinderTimelineUI..ExternalSyntheticLambda9(this);
    ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new FinderTimelineUI..ExternalSyntheticLambda10(this);
    ((com.tencent.mm.ui.widget.a.f)localObject1).aeLi = FinderTimelineUI..ExternalSyntheticLambda11.INSTANCE;
    ((com.tencent.mm.ui.widget.a.f)localObject1).dDn();
    AppMethodBeat.o(166254);
  }
  
  private static final void efV() {}
  
  private static final void efW()
  {
    AppMethodBeat.i(365020);
    v localv = v.FrN;
    v.SA(6);
    AppMethodBeat.o(365020);
  }
  
  private static final boolean fL(View paramView)
  {
    AppMethodBeat.i(365053);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(365053);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(auw paramauw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(365195);
    kotlin.g.b.s.u(paramauw, "cmdItem");
    if (paramauw.cmdId == 108)
    {
      aw.a locala = this.AIY;
      paramauw = locala;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("presenter");
        paramauw = null;
      }
      paramauw.ecA();
    }
    AppMethodBeat.o(365195);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_timeline_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(166264);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("Finder.FinderTimelineUI", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    Object localObject;
    do
    {
      AppMethodBeat.o(166264);
      return;
      this.Bsp.pH(false);
      AppMethodBeat.o(166264);
      return;
      this.wGs = this.Bsp.dUi();
      AppMethodBeat.o(166264);
      return;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.i)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.i.class)).ATy;
    } while (localObject == null);
    ((com.tencent.mm.plugin.finder.view.f)localObject).g(paramInt1, paramIntent);
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    aw.a locala2 = this.AIY;
    aw.a locala1 = locala2;
    if (locala2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      locala1 = null;
    }
    locala1.onBackPressed();
    AppMethodBeat.o(166259);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166253);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.zIO = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject1 = this.zIO;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("contextId");
      paramBundle = null;
    }
    com.tencent.mm.plugin.finder.report.z.id(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Ns(i);
    paramBundle = bj.ABo;
    bj.dVw();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.Gbu;
    com.tencent.mm.plugin.finder.upload.b.fdT().fdz();
    setMMTitle(getContext().getResources().getString(e.h.finder_title));
    com.tencent.mm.ae.d.B((kotlin.g.a.a)b.Bsr);
    setBackBtn(new FinderTimelineUI..ExternalSyntheticLambda1(this));
    this.AIY = ((aw.a)new bg((MMActivity)this));
    Object localObject2 = (MMActivity)this;
    localObject1 = this.AIY;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      paramBundle = null;
    }
    localObject1 = getContentView();
    kotlin.g.b.s.s(localObject1, "contentView");
    this.AZO = ((aw.b)new bh((MMActivity)localObject2, paramBundle, (View)localObject1, null));
    localObject1 = this.AIY;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      paramBundle = null;
    }
    localObject2 = this.AZO;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    paramBundle.onAttach(localObject1);
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().eKX();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.k)this);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.k)this);
    com.tencent.mm.pluginsdk.h.x((MMActivity)this);
    setTitleBarClickListener(new FinderTimelineUI..ExternalSyntheticLambda12(this), FinderTimelineUI..ExternalSyntheticLambda13.INSTANCE);
    if (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).showPostEntry())
    {
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera");
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLCamera");
      paramBundle = av.GiL;
      paramBundle = aw.Gjk;
      w localw;
      if ((localObject1 != null) && (localObject2 != null))
      {
        localw = w.FrV;
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)this);
        if (paramBundle == null)
        {
          paramBundle = null;
          w.a(localw, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, (bxq)localObject1, 1, paramBundle, 0, null, 0, 480);
          paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
          paramBundle = as.GSQ;
          paramBundle = as.a.hu((Context)this);
          if (paramBundle != null) {
            break label790;
          }
          paramBundle = null;
          label495:
          com.tencent.mm.plugin.finder.report.z.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.Bsn);
        addIconOptionMenu(this.Bsn, -1, e.g.icons_outlined_camera, new FinderTimelineUI..ExternalSyntheticLambda3((bxq)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, this));
        label547:
        removeOptionMenu(this.Bsm);
        localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLPersonalCenter");
        localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLPersonalCenter");
        addIconOptionMenu(this.Bsm, -1, e.g.icons_outlined_me, new FinderTimelineUI..ExternalSyntheticLambda4((bxq)localObject2, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, this), FinderTimelineUI..ExternalSyntheticLambda6.INSTANCE);
        paramBundle = av.GiL;
        paramBundle = aw.Gjk;
        if ((localObject2 != null) && (localObject1 != null))
        {
          localw = w.FrV;
          paramBundle = as.GSQ;
          paramBundle = as.a.hu((Context)this);
          if (paramBundle != null) {
            break label840;
          }
          paramBundle = null;
          label659:
          w.a(localw, "2", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, (bxq)localObject2, 1, paramBundle, 0, null, 0, 480);
          paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
          paramBundle = as.GSQ;
          paramBundle = as.a.hu((Context)this);
          if (paramBundle != null) {
            break label848;
          }
        }
      }
    }
    label790:
    label840:
    label848:
    for (paramBundle = null;; paramBundle = paramBundle.fou())
    {
      com.tencent.mm.plugin.finder.report.z.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZF(), (q)this, new FinderTimelineUI..ExternalSyntheticLambda8(this));
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZD(), (q)this, new FinderTimelineUI..ExternalSyntheticLambda7(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = paramBundle.fou();
      break;
      paramBundle = paramBundle.fou();
      break label495;
      removeOptionMenu(this.Bso);
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eQX()) {
        break label547;
      }
      addIconOptionMenu(this.Bso, -1, e.g.finder_no_permission_post_camera, new FinderTimelineUI..ExternalSyntheticLambda2(this));
      break label547;
      paramBundle = paramBundle.fou();
      break label659;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.k)this);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.k)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    aw.a locala = this.AIY;
    Object localObject1 = locala;
    if (locala == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject1 = null;
    }
    ((aw.a)localObject1).onDetach();
    localObject1 = o.ECp;
    o.release();
    com.tencent.mm.ae.d.B((kotlin.g.a.a)c.Bss);
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject1 = this.zIO;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("contextId");
      localObject1 = localObject2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.id((String)localObject1, "Exit");
      AppMethodBeat.o(166262);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    aw.a locala2 = this.AIY;
    aw.a locala1 = locala2;
    if (locala2 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      locala1 = null;
    }
    locala1.onUIPause();
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.a.class)).f(102, false, false);
    }
    AppMethodBeat.o(166261);
  }
  
  public final void onResume()
  {
    com.tencent.mm.hellhoundlib.b.a locala = null;
    AppMethodBeat.i(166260);
    super.onResume();
    boolean bool = this.wGs;
    this.wGs = this.Bsp.dUi();
    if ((this.wGs) && (!bool)) {
      this.Bsp.pH(false);
    }
    aw.a locala1 = this.AIY;
    Object localObject = locala1;
    if (locala1 == null)
    {
      kotlin.g.b.s.bIx("presenter");
      localObject = null;
    }
    ((aw.a)localObject).onUIResume();
    localObject = bd.GVA;
    if (bd.fpr())
    {
      localObject = this.AZO;
      if (localObject != null) {
        break label200;
      }
      kotlin.g.b.s.bIx("viewCallback");
      localObject = locala;
    }
    label200:
    for (;;)
    {
      localObject = ((aw.b)localObject).getRecyclerView();
      locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = bd.GVA;
      bd.vq(false);
      AppMethodBeat.o(166260);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(166258);
    Log.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.qbH;
    if (paramString != null) {
      paramString.dismiss();
    }
    int i;
    if ((paramp != null) && (paramp.getType() == 3761)) {
      i = 1;
    }
    while (i != 0)
    {
      com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0);
        Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 & 0x2) != 0)
        {
          if (paramp == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
            AppMethodBeat.o(166258);
            throw paramString;
            i = 0;
          }
          else
          {
            this.AwM = ((di)paramp).dVy();
            com.tencent.mm.ui.base.k.c((Context)this, getString(e.h.finder_self_contact_reviewing), "", true);
            AppMethodBeat.o(166258);
          }
        }
        else
        {
          paramString = av.GiL;
          if (av.aO((Activity)this))
          {
            paramString = av.GiL;
            paramString = (Context)this;
            String str = getString(e.h.finder_timeline_create_contact_tip);
            if (paramp == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
              AppMethodBeat.o(166258);
              throw paramString;
            }
            if (av.a(paramString, str, ((di)paramp).ADf, this.AwM))
            {
              efU();
              AppMethodBeat.o(166258);
            }
          }
        }
      }
      else
      {
        aa.makeText((Context)this, e.h.finder_prepare_user_failed, 1).show();
      }
    }
    AppMethodBeat.o(166258);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_LIVE", "", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_POST_MJ_TEMPLATE", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_SELECT_SNS_ALBUM", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b Bsr;
    
    static
    {
      AppMethodBeat.i(166243);
      Bsr = new b();
      AppMethodBeat.o(166243);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final c Bss;
    
    static
    {
      AppMethodBeat.i(166248);
      Bss = new c();
      AppMethodBeat.o(166248);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI
 * JD-Core Version:    0.7.0.1
 */