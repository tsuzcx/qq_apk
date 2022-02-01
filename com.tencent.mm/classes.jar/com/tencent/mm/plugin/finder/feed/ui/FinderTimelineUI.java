package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.convert.v.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.finder.api.f
{
  public static final a shB;
  private HashMap _$_findViewCache;
  private ProgressDialog jjb;
  private boolean oMb;
  private String qXu;
  private ac.b rZi;
  private ac.a saj;
  private final int sgy;
  private final FinderGlobalLocationVM shA;
  private asp shx;
  private final int shy;
  private final int shz;
  
  static
  {
    AppMethodBeat.i(166265);
    shB = new a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(202896);
    this.shy = 1;
    this.sgy = 2;
    this.shz = 3;
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.p.g(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.shA = ((FinderGlobalLocationVM)localObject);
    AppMethodBeat.o(202896);
  }
  
  private final void cCv()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.suA;
    if (com.tencent.mm.plugin.finder.spam.a.aip("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
    if (com.tencent.mm.plugin.finder.utils.a.eO((Context)this))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.ai(1, true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
    com.tencent.mm.plugin.finder.report.f.ai(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = com.tencent.mm.ui.z.jO((Context)getContext()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.c.rHn;
    localObject3 = u.aAu();
    d.g.b.p.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = c.a.agW((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.p.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)k.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).VC()));
      localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.cCC();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject3).field_avatarUrl);
      d.g.b.p.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).K(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)f.shJ);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.e)new g(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)h.shK);
    ((com.tencent.mm.ui.widget.a.e)localObject1).cMW();
    AppMethodBeat.o(166254);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202898);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(202898);
    return localView1;
  }
  
  public final void a(alo paramalo)
  {
    AppMethodBeat.i(166255);
    d.g.b.p.h(paramalo, "cmdItem");
    switch (paramalo.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(166255);
      return;
      paramalo = this.saj;
      if (paramalo == null) {
        d.g.b.p.bcb("presenter");
      }
      paramalo.cBy();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494117;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(166264);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("Finder.FinderTimelineUI", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(166264);
      return;
    case 563: 
      this.shA.bYc();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.oMb = FinderGlobalLocationVM.cOa();
      AppMethodBeat.o(166264);
      return;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderCommentDrawerUIC.class)).cAL().d(paramInt1, paramIntent);
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    ac.a locala = this.saj;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    locala.onBackPressed();
    AppMethodBeat.o(166259);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166253);
    com.tencent.mm.pluginsdk.h.q((MMActivity)this);
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.qXu = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
    paramBundle = this.qXu;
    if (paramBundle == null) {
      d.g.b.p.bcb("contextId");
    }
    com.tencent.mm.plugin.finder.report.h.gn(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Ep(i);
    this.oMb = FinderGlobalLocationVM.h((MMActivity)this);
    if (this.oMb) {
      this.shA.bYc();
    }
    paramBundle = x.rIV;
    x.cxZ();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.sID;
    com.tencent.mm.plugin.finder.upload.b.cKC().cKB();
    paramBundle = getContext();
    d.g.b.p.g(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(2131759376));
    com.tencent.mm.ad.c.b(null, (d.g.a.a)j.shM);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    this.saj = ((ac.a)new an((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.saj;
    if (localObject1 == null) {
      d.g.b.p.bcb("presenter");
    }
    Object localObject2 = getContentView();
    d.g.b.p.g(localObject2, "contentView");
    this.rZi = ((ac.b)new ao(paramBundle, (ac.a)localObject1, (View)localObject2));
    paramBundle = this.saj;
    if (paramBundle == null) {
      d.g.b.p.bcb("presenter");
    }
    localObject1 = this.rZi;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    paramBundle.db(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.sJk;
    com.tencent.mm.plugin.finder.upload.g.cKK().cKJ();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    setTitleBarClickListener((Runnable)new l(this), (Runnable)m.shN);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((com.tencent.mm.plugin.finder.storage.b.cFK()) && (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry()))
    {
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().ahm("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().ahn("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.g.soH;
        paramBundle = FinderReporterUIC.tcM;
        paramBundle = FinderReporterUIC.a.eY((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.cOu();
          com.tencent.mm.plugin.finder.report.g.b("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ase)localObject1, 1, paramBundle, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
          paramBundle = FinderReporterUIC.tcM;
          paramBundle = FinderReporterUIC.a.eY((Context)this);
          if (paramBundle == null) {
            break label873;
          }
          paramBundle = paramBundle.cOu();
          label542:
          com.tencent.mm.plugin.finder.report.h.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.sgy);
        addIconOptionMenu(this.sgy, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (ase)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2));
        label597:
        removeOptionMenu(this.shy);
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().ahm("TLPersonalCenter");
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().ahn("TLPersonalCenter");
        addIconOptionMenu(this.shy, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, (ase)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2), (View.OnLongClickListener)FinderTimelineUI.d.shH);
        paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.report.g.soH;
          paramBundle = FinderReporterUIC.tcM;
          paramBundle = FinderReporterUIC.a.eY((Context)this);
          if (paramBundle == null) {
            break label923;
          }
          paramBundle = paramBundle.cOu();
          label731:
          com.tencent.mm.plugin.finder.report.g.b("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ase)localObject1, 1, paramBundle, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).field_tipsId;
          d.g.b.p.g(localObject1, "ctrInfo.field_tipsId");
          paramBundle = FinderReporterUIC.tcM;
          paramBundle = FinderReporterUIC.a.eY((Context)this);
          if (paramBundle == null) {
            break label928;
          }
        }
      }
    }
    label923:
    label928:
    for (paramBundle = paramBundle.cOu();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.h.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czW(), (LifecycleOwner)this, (Observer)new n(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czV(), (LifecycleOwner)this, (Observer)new o(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      label873:
      paramBundle = null;
      break label542;
      removeOptionMenu(this.shz);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cFQ()) {
        break label597;
      }
      addIconOptionMenu(this.shz, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new e(this));
      break label597;
      paramBundle = null;
      break label731;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
    Object localObject = this.saj;
    if (localObject == null) {
      d.g.b.p.bcb("presenter");
    }
    ((ac.a)localObject).onDetach();
    localObject = j.sjX;
    j.release();
    com.tencent.mm.ad.c.b(null, (d.g.a.a)p.shO);
    localObject = com.tencent.mm.plugin.finder.report.h.soM;
    localObject = this.qXu;
    if (localObject == null) {
      d.g.b.p.bcb("contextId");
    }
    com.tencent.mm.plugin.finder.report.h.gn((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    ac.a locala = this.saj;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    locala.onUIPause();
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(102, false, false);
    }
    AppMethodBeat.o(166261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166260);
    super.onResume();
    boolean bool = this.oMb;
    this.oMb = FinderGlobalLocationVM.cOa();
    if ((this.oMb) && (!bool)) {
      this.shA.bYc();
    }
    Object localObject = this.saj;
    if (localObject == null) {
      d.g.b.p.bcb("presenter");
    }
    ((ac.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
    if (com.tencent.mm.plugin.finder.upload.g.cKL())
    {
      localObject = this.rZi;
      if (localObject == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject = ((ac.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.me(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166258);
    ad.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.jjb;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.ajl().getInt(al.a.IGO, 0);
      ad.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.shx = ((ax)paramn).cyJ();
        com.tencent.mm.ui.base.h.T((Context)this, getString(2131759342), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)this))
    {
      paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.a((Context)this, getString(2131759369), ((ax)paramn).rJR, this.shx)) {
        cCv();
      }
    }
    AppMethodBeat.o(166258);
    return;
    label250:
    com.tencent.mm.ui.base.t.makeText((Context)this, 2131759307, 1).show();
    label264:
    AppMethodBeat.o(166258);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_SELECT_PHOTO", "", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, ase paramase, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178302);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
      ase localase = this.shD;
      com.tencent.mm.plugin.finder.extension.reddot.i locali = this.shE;
      if ((localase != null) && (locali != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.g.soH;
        paramMenuItem = FinderReporterUIC.tcM;
        paramMenuItem = FinderReporterUIC.a.eY((Context)this.shC);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cOu();
          com.tencent.mm.plugin.finder.report.g.b("2", locali, localase, 2, paramMenuItem, 0, 96);
          paramMenuItem = com.tencent.mm.plugin.finder.report.h.soM;
          paramMenuItem = FinderReporterUIC.tcM;
          paramMenuItem = FinderReporterUIC.a.eY((Context)this.shC);
          if (paramMenuItem == null) {
            break label222;
          }
          paramMenuItem = paramMenuItem.cOu();
          label101:
          com.tencent.mm.plugin.finder.report.h.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().ahl("TLCamera");
        if (!bt.isNullOrNil(u.aAu())) {
          break label358;
        }
        if (FinderTimelineUI.e(this.shC) != null) {
          break label232;
        }
        ad.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
        paramMenuItem = (g.a)com.tencent.mm.plugin.finder.extension.reddot.g.czV().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.dmo != true)) {
          break label227;
        }
      }
      label222:
      label227:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUI.a(this.shC, bool);
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label101;
      }
      label232:
      paramMenuItem = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.ajl().getInt(al.a.IGO, 0);
      ad.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.T((Context)this.shC, this.shC.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)this.shC))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a((Context)this.shC, this.shC.getString(2131759369), FinderTimelineUI.e(this.shC));
          continue;
          label358:
          FinderTimelineUI.f(this.shC);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, ase paramase, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
      ase localase = this.shF;
      Object localObject = this.shG;
      if ((localase != null) && (localObject != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.g.soH;
        paramMenuItem = FinderReporterUIC.tcM;
        paramMenuItem = FinderReporterUIC.a.eY((Context)this.shC);
        if (paramMenuItem == null) {
          break label175;
        }
        paramMenuItem = paramMenuItem.cOu();
        com.tencent.mm.plugin.finder.report.g.b("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject, localase, 2, paramMenuItem, 0, 96);
        paramMenuItem = com.tencent.mm.plugin.finder.report.h.soM;
        localObject = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).field_tipsId;
        d.g.b.p.g(localObject, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.tcM;
        paramMenuItem = FinderReporterUIC.a.eY((Context)this.shC);
        if (paramMenuItem == null) {
          break label180;
        }
      }
      label175:
      label180:
      for (paramMenuItem = paramMenuItem.cOu();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.h.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.y((Context)this.shC, null);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().ahl("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202890);
      paramMenuItem = new bj();
      paramMenuItem.Ss();
      paramMenuItem.aLk();
      ad.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.St());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.d((Context)this.shC.getContext());
      paramMenuItem.Gc(2131494081);
      Object localObject = (TextView)paramMenuItem.kBS.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.kBS.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.kBS.findViewById(2131302881);
      d.g.b.p.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cFR());
      d.g.b.p.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cFS());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.cMW();
      AppMethodBeat.o(202890);
      return true;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202889);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.shI.bpT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202889);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    public static final f shJ;
    
    static
    {
      AppMethodBeat.i(202892);
      shJ = new f();
      AppMethodBeat.o(202892);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(202891);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(1001, 2131755747);
        paraml.jI(1002, 2131755754);
      }
      AppMethodBeat.o(202891);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202893);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramMenuItem = this.shC.getContext();
        d.g.b.p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(202893);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h shK;
    
    static
    {
      AppMethodBeat.i(202895);
      shK = new h();
      AppMethodBeat.o(202895);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(202894);
      com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.EW(6);
      AppMethodBeat.o(202894);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class i
    implements DialogInterface.OnCancelListener
  {
    i(FinderTimelineUI paramFinderTimelineUI, ax paramax) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(166241);
      com.tencent.mm.kernel.g.aiU().a((n)this.shL);
      com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this.shC);
      AppMethodBeat.o(166241);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    public static final j shM;
    
    static
    {
      AppMethodBeat.i(166243);
      shM = new j();
      AppMethodBeat.o(166243);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.shC.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.shC).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).km() <= 12)
      {
        localObject = FinderTimelineUI.a(this.shC).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.convert.v.rOD;
        v.a.a(FinderTimelineUI.a(this.shC), FinderTimelineUI.b(this.shC).cBz());
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.shC).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    public static final m shN;
    
    static
    {
      AppMethodBeat.i(166246);
      shN = new m();
      AppMethodBeat.o(166246);
    }
    
    public final void run() {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<g.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class o<T>
    implements Observer<g.a>
  {
    o(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    public static final p shO;
    
    static
    {
      AppMethodBeat.i(166248);
      shO = new p();
      AppMethodBeat.o(166248);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI
 * JD-Core Version:    0.7.0.1
 */