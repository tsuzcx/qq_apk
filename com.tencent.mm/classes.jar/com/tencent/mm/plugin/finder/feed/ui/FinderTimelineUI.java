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
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.convert.v.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.finder.api.f
{
  public static final FinderTimelineUI.a sqw;
  private HashMap _$_findViewCache;
  private ProgressDialog jlU;
  private boolean oSD;
  private String rfA;
  private ac.b shU;
  private ac.a siY;
  private final int spr;
  private atf sqs;
  private final int sqt;
  private final int squ;
  private final FinderGlobalLocationVM sqv;
  
  static
  {
    AppMethodBeat.i(166265);
    sqw = new FinderTimelineUI.a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(203375);
    this.sqt = 1;
    this.spr = 2;
    this.squ = 3;
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.p.g(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.sqv = ((FinderGlobalLocationVM)localObject);
    AppMethodBeat.o(203375);
  }
  
  private final void cEh()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.sEK;
    if (com.tencent.mm.plugin.finder.spam.a.ajm("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
    if (com.tencent.mm.plugin.finder.utils.a.eS((Context)this))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.am(1, true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.am(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = com.tencent.mm.ui.z.jV((Context)getContext()).inflate(2131494113, null);
    Object localObject3 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject2 = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject2 = c.a.ahT(com.tencent.mm.model.v.aAK());
    if (localObject2 != null)
    {
      d.g.b.p.g(localObject3, "nicknameTv");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).VK()));
      localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject3 = com.tencent.mm.plugin.finder.loader.i.cEo();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).field_avatarUrl);
      d.g.b.p.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
      ((com.tencent.mm.loader.d)localObject3).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).P(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)FinderTimelineUI.f.sqE);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.e)new g(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)h.sqF);
    ((com.tencent.mm.ui.widget.a.e)localObject1).cPF();
    AppMethodBeat.o(166254);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203377);
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
    AppMethodBeat.o(203377);
    return localView1;
  }
  
  public final void a(ama paramama)
  {
    AppMethodBeat.i(166255);
    d.g.b.p.h(paramama, "cmdItem");
    switch (paramama.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(166255);
      return;
      paramama = this.siY;
      if (paramama == null) {
        d.g.b.p.bdF("presenter");
      }
      paramama.cDk();
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
    ae.i("Finder.FinderTimelineUI", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(166264);
      return;
    case 563: 
      this.sqv.bZr();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.oSD = FinderGlobalLocationVM.cQK();
      AppMethodBeat.o(166264);
      return;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderCommentDrawerUIC.class)).cCx().d(paramInt1, paramIntent);
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    ac.a locala = this.siY;
    if (locala == null) {
      d.g.b.p.bdF("presenter");
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
    this.rfA = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.i.syT;
    paramBundle = this.rfA;
    if (paramBundle == null) {
      d.g.b.p.bdF("contextId");
    }
    com.tencent.mm.plugin.finder.report.i.gs(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().EC(i);
    this.oSD = FinderGlobalLocationVM.h((MMActivity)this);
    if (this.oSD) {
      this.sqv.bZr();
    }
    paramBundle = x.rRf;
    x.czA();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.sTP;
    com.tencent.mm.plugin.finder.upload.b.cNg().cNf();
    paramBundle = getContext();
    d.g.b.p.g(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(2131759376));
    com.tencent.mm.ac.c.b(null, (d.g.a.a)FinderTimelineUI.j.sqH);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    this.siY = ((ac.a)new an((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.siY;
    if (localObject1 == null) {
      d.g.b.p.bdF("presenter");
    }
    Object localObject2 = getContentView();
    d.g.b.p.g(localObject2, "contentView");
    this.shU = ((ac.b)new ao(paramBundle, (ac.a)localObject1, (View)localObject2));
    paramBundle = this.siY;
    if (paramBundle == null) {
      d.g.b.p.bdF("presenter");
    }
    localObject1 = this.shU;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    paramBundle.dc(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.sUx;
    com.tencent.mm.plugin.finder.upload.g.cNo().cNn();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    setTitleBarClickListener((Runnable)new l(this), (Runnable)FinderTimelineUI.m.sqI);
    if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())
    {
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().aii("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().aij("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.p.sXz;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.h.syO;
        paramBundle = FinderReporterUIC.tnG;
        paramBundle = FinderReporterUIC.a.fc((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.cQZ();
          com.tencent.mm.plugin.finder.report.h.a("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ast)localObject1, 1, paramBundle, 0, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.i.syT;
          paramBundle = FinderReporterUIC.tnG;
          paramBundle = FinderReporterUIC.a.fc((Context)this);
          if (paramBundle == null) {
            break label858;
          }
          paramBundle = paramBundle.cQZ();
          label533:
          com.tencent.mm.plugin.finder.report.i.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.spr);
        addIconOptionMenu(this.spr, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (ast)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2));
        label588:
        removeOptionMenu(this.sqt);
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().aii("TLPersonalCenter");
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().aij("TLPersonalCenter");
        addIconOptionMenu(this.sqt, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, (ast)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2), (View.OnLongClickListener)FinderTimelineUI.d.sqC);
        paramBundle = com.tencent.mm.plugin.finder.utils.p.sXz;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.report.h.syO;
          paramBundle = FinderReporterUIC.tnG;
          paramBundle = FinderReporterUIC.a.fc((Context)this);
          if (paramBundle == null) {
            break label908;
          }
          paramBundle = paramBundle.cQZ();
          label722:
          com.tencent.mm.plugin.finder.report.h.a("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ast)localObject1, 1, paramBundle, 0, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.i.syT;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).field_tipsId;
          paramBundle = FinderReporterUIC.tnG;
          paramBundle = FinderReporterUIC.a.fc((Context)this);
          if (paramBundle == null) {
            break label913;
          }
        }
      }
    }
    label908:
    label913:
    for (paramBundle = paramBundle.cQZ();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.i.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBB(), (LifecycleOwner)this, (Observer)new n(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBz(), (LifecycleOwner)this, (Observer)new o(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      label858:
      paramBundle = null;
      break label533;
      removeOptionMenu(this.squ);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cHN()) {
        break label588;
      }
      addIconOptionMenu(this.squ, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new e(this));
      break label588;
      paramBundle = null;
      break label722;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    Object localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    ((ac.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.k.ssU;
    com.tencent.mm.plugin.finder.model.k.release();
    com.tencent.mm.ac.c.b(null, (d.g.a.a)p.sqJ);
    localObject = com.tencent.mm.plugin.finder.report.i.syT;
    localObject = this.rfA;
    if (localObject == null) {
      d.g.b.p.bdF("contextId");
    }
    com.tencent.mm.plugin.finder.report.i.gs((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    ac.a locala = this.siY;
    if (locala == null) {
      d.g.b.p.bdF("presenter");
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
    boolean bool = this.oSD;
    this.oSD = FinderGlobalLocationVM.cQK();
    if ((this.oSD) && (!bool)) {
      this.sqv.bZr();
    }
    Object localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    ((ac.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.sUx;
    if (com.tencent.mm.plugin.finder.upload.g.cNp())
    {
      localObject = this.shU;
      if (localObject == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject = ((ac.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.sUx;
      com.tencent.mm.plugin.finder.upload.g.mj(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166258);
    ae.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.jlU;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.ajA().getInt(am.a.Jbp, 0);
      ae.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.sqs = ((ay)paramn).cAk();
        com.tencent.mm.ui.base.h.T((Context)this, getString(2131759342), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (com.tencent.mm.plugin.finder.utils.p.aq((Activity)this))
    {
      paramString = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (com.tencent.mm.plugin.finder.utils.p.a((Context)this, getString(2131759369), ((ay)paramn).rSf, this.sqs)) {
        cEh();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, ast paramast, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178302);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
      ast localast = this.sqy;
      com.tencent.mm.plugin.finder.extension.reddot.i locali = this.sqz;
      if ((localast != null) && (locali != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.h.syO;
        paramMenuItem = FinderReporterUIC.tnG;
        paramMenuItem = FinderReporterUIC.a.fc((Context)this.sqx);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cQZ();
          com.tencent.mm.plugin.finder.report.h.a("2", locali, localast, 2, paramMenuItem, 0, 0, 96);
          paramMenuItem = com.tencent.mm.plugin.finder.report.i.syT;
          paramMenuItem = FinderReporterUIC.tnG;
          paramMenuItem = FinderReporterUIC.a.fc((Context)this.sqx);
          if (paramMenuItem == null) {
            break label223;
          }
          paramMenuItem = paramMenuItem.cQZ();
          label102:
          com.tencent.mm.plugin.finder.report.i.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().aih("TLCamera");
        if (!bu.isNullOrNil(com.tencent.mm.model.v.aAK())) {
          break label359;
        }
        if (FinderTimelineUI.e(this.sqx) != null) {
          break label233;
        }
        ae.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
        paramMenuItem = (g.a)com.tencent.mm.plugin.finder.extension.reddot.g.cBz().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.dnq != true)) {
          break label228;
        }
      }
      label223:
      label228:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUI.a(this.sqx, bool);
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label102;
      }
      label233:
      paramMenuItem = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.ajA().getInt(am.a.Jbp, 0);
      ae.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.T((Context)this.sqx, this.sqx.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.aq((Activity)this.sqx))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a((Context)this.sqx, this.sqx.getString(2131759369), FinderTimelineUI.e(this.sqx));
          continue;
          label359:
          FinderTimelineUI.f(this.sqx);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, ast paramast, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
      ast localast = this.sqA;
      Object localObject = this.sqB;
      if ((localast != null) && (localObject != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.h.syO;
        paramMenuItem = FinderReporterUIC.tnG;
        paramMenuItem = FinderReporterUIC.a.fc((Context)this.sqx);
        if (paramMenuItem == null) {
          break label170;
        }
        paramMenuItem = paramMenuItem.cQZ();
        com.tencent.mm.plugin.finder.report.h.a("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject, localast, 2, paramMenuItem, 0, 0, 96);
        paramMenuItem = com.tencent.mm.plugin.finder.report.i.syT;
        localObject = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).field_tipsId;
        paramMenuItem = FinderReporterUIC.tnG;
        paramMenuItem = FinderReporterUIC.a.fc((Context)this.sqx);
        if (paramMenuItem == null) {
          break label175;
        }
      }
      label170:
      label175:
      for (paramMenuItem = paramMenuItem.cQZ();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.i.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.y((Context)this.sqx, null);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().aih("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203369);
      paramMenuItem = new bj();
      paramMenuItem.Sq();
      paramMenuItem.aLH();
      ae.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.Sr());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.d((Context)this.sqx.getContext());
      paramMenuItem.GC(2131494081);
      Object localObject = (TextView)paramMenuItem.kFh.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.kFh.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.kFh.findViewById(2131302881);
      d.g.b.p.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cHO());
      d.g.b.p.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cHP());
      localTextView2.setOnClickListener((View.OnClickListener)new FinderTimelineUI.e.a(paramMenuItem));
      paramMenuItem.cPF();
      AppMethodBeat.o(203369);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(203372);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramMenuItem = this.sqx.getContext();
        d.g.b.p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(203372);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h sqF;
    
    static
    {
      AppMethodBeat.i(203374);
      sqF = new h();
      AppMethodBeat.o(203374);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(203373);
      com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fs(6);
      AppMethodBeat.o(203373);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.sqx.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.sqx).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).km() <= 12)
      {
        localObject = FinderTimelineUI.a(this.sqx).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.convert.v.rXd;
        v.a.a(FinderTimelineUI.a(this.sqx), FinderTimelineUI.b(this.sqx).cDl());
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.sqx).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<g.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class o<T>
    implements Observer<g.a>
  {
    o(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    public static final p sqJ;
    
    static
    {
      AppMethodBeat.i(166248);
      sqJ = new p();
      AppMethodBeat.o(166248);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI
 * JD-Core Version:    0.7.0.1
 */