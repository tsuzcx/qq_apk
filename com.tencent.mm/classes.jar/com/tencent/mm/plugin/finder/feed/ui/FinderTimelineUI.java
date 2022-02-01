package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.convert.u.a;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.x.a;
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.z;
import d.v;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.finder.api.e
{
  public static final FinderTimelineUI.a rst;
  private HashMap _$_findViewCache;
  private ProgressDialog iPT;
  private boolean oiH;
  private String qox;
  private x.b rbJ;
  private x.a rlB;
  private final int rrs;
  private aoy rsp;
  private final int rsq;
  private final int rsr;
  private final FinderGlobalLocationVM rss;
  
  static
  {
    AppMethodBeat.i(166265);
    rst = new FinderTimelineUI.a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(202513);
    this.rsq = 1;
    this.rrs = 2;
    this.rsr = 3;
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.k.g(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.rss = ((FinderGlobalLocationVM)localObject);
    AppMethodBeat.o(202513);
  }
  
  private final void cwh()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.rBD;
    if (com.tencent.mm.plugin.finder.spam.a.aed("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
    if (com.tencent.mm.plugin.finder.utils.a.eO((Context)this))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.ae(1, true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
    com.tencent.mm.plugin.finder.report.c.ae(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = z.jD((Context)getContext()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject3 = com.tencent.mm.model.u.axE();
    d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = b.a.adh((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.k.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).Tn()));
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cwo();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject3).field_avatarUrl);
      d.g.b.k.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).J(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)FinderTimelineUI.e.rsA);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)g.rsB);
    ((com.tencent.mm.ui.widget.a.e)localObject1).cED();
    AppMethodBeat.o(166254);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202514);
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
    AppMethodBeat.o(202514);
    return localView1;
  }
  
  public final void a(aiy paramaiy)
  {
    AppMethodBeat.i(166255);
    d.g.b.k.h(paramaiy, "cmdItem");
    switch (paramaiy.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(166255);
      return;
      paramaiy = this.rlB;
      if (paramaiy == null) {
        d.g.b.k.aVY("presenter");
      }
      paramaiy.cvg();
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
    ac.i("Finder.FinderTimelineUI", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(166264);
      return;
    case 563: 
      this.rss.bTx();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.oiH = FinderGlobalLocationVM.cFG();
      AppMethodBeat.o(166264);
      return;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderCommentDrawerUIC.class)).cuz().d(paramInt1, paramIntent);
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    x.a locala = this.rlB;
    if (locala == null) {
      d.g.b.k.aVY("presenter");
    }
    locala.onBackPressed();
    AppMethodBeat.o(166259);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(166253);
    com.tencent.mm.pluginsdk.g.o((MMActivity)this);
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.qox = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
    paramBundle = this.qox;
    if (paramBundle == null) {
      d.g.b.k.aVY("contextId");
    }
    com.tencent.mm.plugin.finder.report.d.ge(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Dw(i);
    ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).getRedDotManager().adv("FinderEntrance");
    ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).getRedDotManager().adv("Discovery");
    this.oiH = FinderGlobalLocationVM.g((MMActivity)this);
    if (this.oiH) {
      this.rss.bTx();
    }
    paramBundle = s.qXL;
    s.csj();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.rMB;
    com.tencent.mm.plugin.finder.upload.b.cCr().cCq();
    paramBundle = getContext();
    d.g.b.k.g(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(2131759376));
    com.tencent.mm.ac.c.b(null, (d.g.a.a)FinderTimelineUI.i.rsD);
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    this.rlB = ((x.a)new ag((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.rlB;
    if (localObject1 == null) {
      d.g.b.k.aVY("presenter");
    }
    Object localObject2 = getContentView();
    d.g.b.k.g(localObject2, "contentView");
    this.rbJ = ((x.b)new ah(paramBundle, (x.a)localObject1, (View)localObject2));
    paramBundle = this.rlB;
    if (paramBundle == null) {
      d.g.b.k.aVY("presenter");
    }
    localObject1 = this.rbJ;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    paramBundle.cY(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.f.rNg;
    com.tencent.mm.plugin.finder.upload.f.cCv().cCu();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.pluginsdk.g.p((MMActivity)this);
    setTitleBarClickListener((Runnable)new k(this), (Runnable)FinderTimelineUI.l.rsE);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
    if ((com.tencent.mm.plugin.finder.storage.b.cyP()) && (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry()))
    {
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().adw("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().adx("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.n.rPN;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
        paramBundle = FinderReporterUIC.seQ;
        paramBundle = FinderReporterUIC.a.eV((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.cGb();
          com.tencent.mm.plugin.finder.report.d.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.rrs);
        addIconOptionMenu(this.rrs, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (aon)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.h)localObject2));
        label604:
        removeOptionMenu(this.rsq);
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        paramBundle = ((PluginFinder)paramBundle).getRedDotManager().adw("TLPersonalCenter");
        localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)localObject1).getRedDotManager().adx("TLPersonalCenter");
        addIconOptionMenu(this.rsq, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, paramBundle, (com.tencent.mm.plugin.finder.extension.reddot.h)localObject1));
        localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
        if ((paramBundle != null) && (localObject1 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.h)localObject1).field_tipsId;
          d.g.b.k.g(localObject1, "ctrInfo.field_tipsId");
          paramBundle = FinderReporterUIC.seQ;
          paramBundle = FinderReporterUIC.a.eV((Context)this);
          if (paramBundle == null) {
            break label877;
          }
        }
      }
    }
    label877:
    for (paramBundle = paramBundle.cGb();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.d.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctO(), (LifecycleOwner)this, (Observer)new m(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctN(), (LifecycleOwner)this, (Observer)new n(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      removeOptionMenu(this.rsr);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.cyV()) {
        break label604;
      }
      addIconOptionMenu(this.rsr, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new d(this));
      break label604;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
    Object localObject = this.rlB;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    ((x.a)localObject).onDetach();
    localObject = i.ruE;
    i.release();
    com.tencent.mm.ac.c.b(null, (d.g.a.a)o.rsF);
    localObject = com.tencent.mm.plugin.finder.report.d.rxr;
    localObject = this.qox;
    if (localObject == null) {
      d.g.b.k.aVY("contextId");
    }
    com.tencent.mm.plugin.finder.report.d.ge((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    if (this.rlB == null) {
      d.g.b.k.aVY("presenter");
    }
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(102, false, false);
    }
    AppMethodBeat.o(166261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166260);
    super.onResume();
    boolean bool = this.oiH;
    this.oiH = FinderGlobalLocationVM.cFG();
    if ((this.oiH) && (!bool)) {
      this.rss.bTx();
    }
    Object localObject = this.rlB;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    ((x.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
    if (com.tencent.mm.plugin.finder.upload.f.cCw())
    {
      localObject = this.rbJ;
      if (localObject == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject = ((x.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.lO(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(166258);
    ac.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.iPT;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.agA().getInt(ah.a.GUi, 0);
      ac.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.rsp = ((aq)paramn).csO();
        com.tencent.mm.ui.base.h.Q((Context)this, getString(2131759342), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)this))
    {
      paramString = com.tencent.mm.plugin.finder.utils.n.rPN;
      if (com.tencent.mm.plugin.finder.utils.n.a((Context)this, getString(2131759369), ((aq)paramn).qYB, this.rsp)) {
        cwh();
      }
    }
    AppMethodBeat.o(166258);
    return;
    label250:
    t.makeText((Context)this, 2131759307, 1).show();
    label264:
    AppMethodBeat.o(166258);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, aon paramaon, com.tencent.mm.plugin.finder.extension.reddot.h paramh) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178302);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramMenuItem = this.rsv;
      com.tencent.mm.plugin.finder.extension.reddot.h localh = this.rsw;
      if ((paramMenuItem != null) && (localh != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.d.rxr;
        paramMenuItem = FinderReporterUIC.seQ;
        paramMenuItem = FinderReporterUIC.a.eV((Context)this.rsu);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cGb();
          com.tencent.mm.plugin.finder.report.d.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramMenuItem).getRedDotManager().adv("TLCamera");
        if (!bs.isNullOrNil(com.tencent.mm.model.u.axE())) {
          break label309;
        }
        if (FinderTimelineUI.d(this.rsu) != null) {
          break label183;
        }
        ac.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
        paramMenuItem = (f.a)com.tencent.mm.plugin.finder.extension.reddot.f.ctN().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.daU != true)) {
          break label178;
        }
      }
      label178:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUI.a(this.rsu, bool);
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = null;
        break;
      }
      label183:
      paramMenuItem = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.agA().getInt(ah.a.GUi, 0);
      ac.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.Q((Context)this.rsu, this.rsu.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)this.rsu))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
          com.tencent.mm.plugin.finder.utils.n.a((Context)this.rsu, this.rsu.getString(2131759369), FinderTimelineUI.d(this.rsu));
          continue;
          label309:
          FinderTimelineUI.e(this.rsu);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, aon paramaon, com.tencent.mm.plugin.finder.extension.reddot.h paramh) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
      Object localObject = paramBundle;
      paramMenuItem = this.rsy;
      if ((localObject != null) && (paramMenuItem != null))
      {
        localObject = com.tencent.mm.plugin.finder.report.d.rxr;
        localObject = paramMenuItem.field_tipsId;
        d.g.b.k.g(localObject, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.seQ;
        paramMenuItem = FinderReporterUIC.a.eV((Context)this.rsu);
        if (paramMenuItem == null) {
          break label135;
        }
      }
      label135:
      for (paramMenuItem = paramMenuItem.cGb();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.x((Context)this.rsu, null);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramMenuItem).getRedDotManager().adv("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202507);
      paramMenuItem = new ax();
      paramMenuItem.Qu();
      paramMenuItem.aHZ();
      ac.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.Qv());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.c((Context)this.rsu.getContext());
      paramMenuItem.EP(2131494081);
      Object localObject = (TextView)paramMenuItem.khe.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.khe.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.khe.findViewById(2131302881);
      d.g.b.k.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cyW());
      d.g.b.k.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cyX());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.cED();
      AppMethodBeat.o(202507);
      return true;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202506);
        this.rsz.bmi();
        AppMethodBeat.o(202506);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.d
  {
    f(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202510);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        paramMenuItem = this.rsu.getContext();
        d.g.b.k.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.v((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(202510);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g rsB;
    
    static
    {
      AppMethodBeat.i(202512);
      rsB = new g();
      AppMethodBeat.o(202512);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(202511);
      com.tencent.mm.plugin.finder.report.c localc = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.DS(6);
      AppMethodBeat.o(202511);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.rsu.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.rsu).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).jW() <= 12)
      {
        localObject = FinderTimelineUI.a(this.rsu).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.convert.u.rbM;
        u.a.a(null, FinderTimelineUI.a(this.rsu), 0);
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.rsu).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<f.a>
  {
    m(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<f.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final o rsF;
    
    static
    {
      AppMethodBeat.i(166248);
      rsF = new o();
      AppMethodBeat.o(166248);
    }
    
    o()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI
 * JD-Core Version:    0.7.0.1
 */