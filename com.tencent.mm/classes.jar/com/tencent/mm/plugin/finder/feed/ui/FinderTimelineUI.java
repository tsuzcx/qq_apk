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
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.convert.q.a;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.v;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.finder.api.e
{
  public static final a qBs;
  private final FinderGlobalLocationVM KTa;
  private HashMap _$_findViewCache;
  private ProgressDialog ipM;
  private boolean nFG;
  private final int qAD;
  private alv qBp;
  private final int qBq;
  private final int qBr;
  private i.b qrz;
  private String qwV;
  private i.a qxq;
  
  static
  {
    AppMethodBeat.i(166265);
    qBs = new a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(198589);
    this.qBq = 1;
    this.qAD = 2;
    this.qBr = 3;
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.k.g(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.KTa = ((FinderGlobalLocationVM)localObject);
    AppMethodBeat.o(198589);
  }
  
  private final void cmO()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.qIC;
    if (com.tencent.mm.plugin.finder.spam.a.Zv("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
    if (com.tencent.mm.plugin.finder.utils.a.ly((Context)this))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.kZ(true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.kZ(false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = com.tencent.mm.ui.y.js((Context)getContext()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject3 = u.aqO();
    d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = b.a.YL((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.k.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).Su()));
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cmV();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject3).field_avatarUrl);
      d.g.b.k.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).J(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)FinderTimelineUI.e.KTb);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)g.KTc);
    ((com.tencent.mm.ui.widget.a.e)localObject1).csG();
    AppMethodBeat.o(166254);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198590);
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
    AppMethodBeat.o(198590);
    return localView1;
  }
  
  public final void a(ahv paramahv)
  {
    AppMethodBeat.i(166255);
    d.g.b.k.h(paramahv, "cmdItem");
    switch (paramahv.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(166255);
      return;
      paramahv = this.qxq;
      if (paramahv == null) {
        d.g.b.k.aPZ("presenter");
      }
      paramahv.fTn();
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
      this.KTa.bMk();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.nFG = FinderGlobalLocationVM.fXe();
      AppMethodBeat.o(166264);
      return;
    }
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderCommentDrawerUIC.class)).fSY().r(paramInt1, paramIntent);
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    i.a locala = this.qxq;
    if (locala == null) {
      d.g.b.k.aPZ("presenter");
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
    this.qwV = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
    paramBundle = this.qwV;
    if (paramBundle == null) {
      d.g.b.k.aPZ("contextId");
    }
    com.tencent.mm.plugin.finder.report.b.fQ(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Cy(i);
    ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).getRedDotManager().YU("FinderEntrance");
    ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).getRedDotManager().YU("Discovery");
    this.nFG = FinderGlobalLocationVM.r((MMActivity)this);
    if (this.nFG) {
      this.KTa.bMk();
    }
    paramBundle = com.tencent.mm.plugin.finder.cgi.j.qoO;
    com.tencent.mm.plugin.finder.cgi.j.cky();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.qQD;
    com.tencent.mm.plugin.finder.upload.b.crx().crw();
    paramBundle = getContext();
    d.g.b.k.g(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(2131759376));
    com.tencent.mm.ad.c.b(null, (d.g.a.a)FinderTimelineUI.i.qBC);
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    this.qxq = ((i.a)new com.tencent.mm.plugin.finder.feed.j((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.qxq;
    if (localObject1 == null) {
      d.g.b.k.aPZ("presenter");
    }
    Object localObject2 = getContentView();
    d.g.b.k.g(localObject2, "contentView");
    this.qrz = ((i.b)new com.tencent.mm.plugin.finder.feed.k(paramBundle, (i.a)localObject1, (View)localObject2));
    paramBundle = this.qxq;
    if (paramBundle == null) {
      d.g.b.k.aPZ("presenter");
    }
    localObject1 = this.qrz;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    paramBundle.cW(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.f.qRf;
    com.tencent.mm.plugin.finder.upload.f.crB().crA();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.pluginsdk.g.p((MMActivity)this);
    setTitleBarClickListener((Runnable)new k(this), (Runnable)FinderTimelineUI.l.qBD);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
    if ((com.tencent.mm.plugin.finder.storage.b.cps()) && (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry()))
    {
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().YV("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().YW("TLCamera");
      paramBundle = i.qTa;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
        paramBundle = FinderReporterUIC.Ljl;
        paramBundle = FinderReporterUIC.a.lB((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.fXs();
          com.tencent.mm.plugin.finder.report.b.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 1472);
        }
      }
      else
      {
        removeOptionMenu(this.qAD);
        addIconOptionMenu(this.qAD, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (aln)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.f)localObject2));
        label603:
        removeOptionMenu(this.qBq);
        paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        paramBundle = ((PluginFinder)paramBundle).getRedDotManager().YV("TLPersonalCenter");
        localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)localObject1).getRedDotManager().YW("TLPersonalCenter");
        addIconOptionMenu(this.qBq, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, paramBundle, (com.tencent.mm.plugin.finder.extension.reddot.f)localObject1));
        localObject2 = i.qTa;
        if ((paramBundle != null) && (localObject1 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1).field_tipsId;
          d.g.b.k.g(localObject1, "ctrInfo.field_tipsId");
          paramBundle = FinderReporterUIC.Ljl;
          paramBundle = FinderReporterUIC.a.lB((Context)this);
          if (paramBundle == null) {
            break label875;
          }
        }
      }
    }
    label875:
    for (paramBundle = paramBundle.fXs();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.b.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 1408);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.cls(), (LifecycleOwner)this, (Observer)new m(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.clr(), (LifecycleOwner)this, (Observer)new n(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      removeOptionMenu(this.qBr);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpy()) {
        break label603;
      }
      addIconOptionMenu(this.qBr, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new d(this));
      break label603;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
    Object localObject = this.qxq;
    if (localObject == null) {
      d.g.b.k.aPZ("presenter");
    }
    ((i.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.f.qDu;
    com.tencent.mm.plugin.finder.model.f.release();
    com.tencent.mm.ad.c.b(null, (d.g.a.a)o.qBE);
    localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    localObject = this.qwV;
    if (localObject == null) {
      d.g.b.k.aPZ("contextId");
    }
    com.tencent.mm.plugin.finder.report.b.fQ((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    if (this.qxq == null) {
      d.g.b.k.aPZ("presenter");
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
    boolean bool = this.nFG;
    this.nFG = FinderGlobalLocationVM.fXe();
    if ((this.nFG) && (!bool)) {
      this.KTa.bMk();
    }
    Object localObject = this.qxq;
    if (localObject == null) {
      d.g.b.k.aPZ("presenter");
    }
    ((i.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.f.qRf;
    if (com.tencent.mm.plugin.finder.upload.f.crC())
    {
      localObject = this.qrz;
      if (localObject == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject = ((i.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.lg(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166258);
    ad.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.ipM;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.afk().getInt(ae.a.Fwn, 0);
      ad.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.qBp = ((com.tencent.mm.plugin.finder.cgi.y)paramn).ckV();
        com.tencent.mm.ui.base.h.R((Context)this, getString(2131759342), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = i.qTa;
    if (i.al((Activity)this))
    {
      paramString = i.qTa;
      if (i.a((Context)this, getString(2131759369), ((com.tencent.mm.plugin.finder.cgi.y)paramn).qpv, this.qBp)) {
        cmO();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_SELECT_PHOTO", "", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, aln paramaln, com.tencent.mm.plugin.finder.extension.reddot.f paramf) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      boolean bool2 = false;
      AppMethodBeat.i(178302);
      paramMenuItem = i.qTa;
      paramMenuItem = this.qBu;
      com.tencent.mm.plugin.finder.extension.reddot.f localf = this.qBv;
      if ((paramMenuItem != null) && (localf != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.b.qFq;
        paramMenuItem = FinderReporterUIC.Ljl;
        paramMenuItem = FinderReporterUIC.a.lB((Context)this.qBt);
        if (paramMenuItem == null) {
          break label189;
        }
      }
      label189:
      for (paramMenuItem = paramMenuItem.fXs();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 1472);
        paramMenuItem = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CJ(1);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.j)paramMenuItem).getRedDotManager().YU("TLCamera");
        if (!bt.isNullOrNil(u.aqO())) {
          break label320;
        }
        if (FinderTimelineUI.d(this.qBt) != null) {
          break;
        }
        ad.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
        paramMenuItem = (d.a)com.tencent.mm.plugin.finder.extension.reddot.d.clr().getValue();
        boolean bool1 = bool2;
        if (paramMenuItem != null)
        {
          bool1 = bool2;
          if (paramMenuItem.ddw == true) {
            bool1 = true;
          }
        }
        FinderTimelineUI.a(this.qBt, bool1);
        AppMethodBeat.o(178302);
        return true;
      }
      paramMenuItem = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.afk().getInt(ae.a.Fwn, 0);
      ad.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.R((Context)this.qBt, this.qBt.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = i.qTa;
        if (i.al((Activity)this.qBt))
        {
          paramMenuItem = i.qTa;
          i.a((Context)this.qBt, this.qBt.getString(2131759369), FinderTimelineUI.d(this.qBt));
          continue;
          label320:
          FinderTimelineUI.e(this.qBt);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, aln paramaln, com.tencent.mm.plugin.finder.extension.reddot.f paramf) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = i.qTa;
      Object localObject = paramBundle;
      paramMenuItem = this.qBx;
      if ((localObject != null) && (paramMenuItem != null))
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        localObject = paramMenuItem.field_tipsId;
        d.g.b.k.g(localObject, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.Ljl;
        paramMenuItem = FinderReporterUIC.a.lB((Context)this.qBt);
        if (paramMenuItem == null) {
          break label134;
        }
      }
      label134:
      for (paramMenuItem = paramMenuItem.fXs();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 1408);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.x((Context)this.qBt, null);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.j)paramMenuItem).getRedDotManager().YU("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(190863);
      paramMenuItem = new af();
      paramMenuItem.Qd();
      paramMenuItem.aBj();
      ad.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.Qe());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.c((Context)this.qBt.getContext());
      paramMenuItem.Do(2131494081);
      Object localObject = (TextView)paramMenuItem.jGG.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.jGG.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.jGG.findViewById(2131302881);
      d.g.b.k.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cpz());
      d.g.b.k.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cpA());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.csG();
      AppMethodBeat.o(190863);
      return true;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190862);
        this.qBy.bfo();
        AppMethodBeat.o(190862);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.d
  {
    f(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(198586);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.qSb;
        paramMenuItem = this.qBt.getContext();
        d.g.b.k.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.v((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(198586);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g KTc;
    
    static
    {
      AppMethodBeat.i(198588);
      KTc = new g();
      AppMethodBeat.o(198588);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(198587);
      com.tencent.mm.plugin.finder.report.a locala = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.CL(6);
      AppMethodBeat.o(198587);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.qBt.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.qBt).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).jO() <= 12)
      {
        localObject = FinderTimelineUI.a(this.qBt).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.convert.q.qrB;
        q.a.a(null, FinderTimelineUI.a(this.qBt), 0);
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.qBt).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<d.a>
  {
    m(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<d.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    public static final o qBE;
    
    static
    {
      AppMethodBeat.i(166248);
      qBE = new o();
      AppMethodBeat.o(166248);
    }
    
    o()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI
 * JD-Core Version:    0.7.0.1
 */