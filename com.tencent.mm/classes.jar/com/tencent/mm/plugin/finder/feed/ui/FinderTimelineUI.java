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
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.convert.aj.a;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.ai.a;
import com.tencent.mm.plugin.finder.feed.ai.b;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.api.f
{
  public static final a udh;
  private HashMap _$_findViewCache;
  private ProgressDialog kkd;
  private boolean qgs;
  private String sGQ;
  private ai.b tRV;
  private ai.a tTf;
  private bed udb;
  private final int udc;
  private final int udd;
  private final int ude;
  private final FinderGlobalLocationVM udf;
  private HashMap<Integer, ddk> udg;
  
  static
  {
    AppMethodBeat.i(166265);
    udh = new a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(245576);
    this.udc = 1;
    this.udd = 2;
    this.ude = 3;
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.udf = ((FinderGlobalLocationVM)localObject);
    this.udg = new HashMap();
    AppMethodBeat.o(245576);
  }
  
  private final void det()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.vwk;
    if (com.tencent.mm.plugin.finder.spam.a.avp("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.fs((Context)this);
    localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
    com.tencent.mm.plugin.finder.report.i.as(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = aa.jQ((Context)getContext()).inflate(2131494632, null);
    Object localObject3 = (TextView)localView.findViewById(2131305436);
    ImageView localImageView = (ImageView)localView.findViewById(2131297119);
    Object localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject2 = c.a.asG(com.tencent.mm.model.z.aUg());
    if (localObject2 != null)
    {
      p.g(localObject3, "nicknameTv");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).getNickname()));
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).field_avatarUrl);
      p.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject3).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).V(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((o.f)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((o.g)new g(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)h.udo);
    ((com.tencent.mm.ui.widget.a.e)localObject1).dGm();
    AppMethodBeat.o(166254);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245579);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245579);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245578);
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
    AppMethodBeat.o(245578);
    return localView1;
  }
  
  public final void a(apf paramapf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245575);
    p.h(paramapf, "cmdItem");
    switch (paramapf.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(245575);
      return;
      paramapf = this.tTf;
      if (paramapf == null) {
        p.btv("presenter");
      }
      paramapf.dcO();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494655;
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
      AppMethodBeat.o(166264);
      return;
    case 563: 
      this.udf.cxh();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.qgs = FinderGlobalLocationVM.dHO();
      AppMethodBeat.o(166264);
      return;
    }
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = ((FinderCommentDrawerUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderCommentDrawerUIC.class)).tLT;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.e)localObject).d(paramInt1, paramIntent);
      AppMethodBeat.o(166264);
      return;
    }
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    ai.a locala = this.tTf;
    if (locala == null) {
      p.btv("presenter");
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
    this.sGQ = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
    paramBundle = this.sGQ;
    if (paramBundle == null) {
      p.btv("contextId");
    }
    com.tencent.mm.plugin.finder.report.k.gS(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Iw(i);
    this.qgs = FinderGlobalLocationVM.h((MMActivity)this);
    if (this.qgs) {
      this.udf.cxh();
    }
    paramBundle = com.tencent.mm.plugin.finder.cgi.ao.tuE;
    com.tencent.mm.plugin.finder.cgi.ao.cYb();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.vRM;
    com.tencent.mm.plugin.finder.upload.b.dAQ().dAP();
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(2131760633));
    com.tencent.mm.ac.d.i((kotlin.g.a.a)j.udq);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    this.tTf = ((ai.a)new at((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.tTf;
    if (localObject1 == null) {
      p.btv("presenter");
    }
    Object localObject2 = getContentView();
    p.g(localObject2, "contentView");
    this.tRV = ((ai.b)new au(paramBundle, (ai.a)localObject1, (View)localObject2, null));
    paramBundle = this.tTf;
    if (paramBundle == null) {
      p.btv("presenter");
    }
    localObject1 = this.tRV;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    paramBundle.onAttach(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.vSJ;
    com.tencent.mm.plugin.finder.upload.g.dBa().dAZ();
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    setTitleBarClickListener((Runnable)new l(this), (Runnable)m.udr);
    if (((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).showPostEntry())
    {
      paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().asW("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().asX("TLCamera");
      paramBundle = y.vXH;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = j.vft;
        paramBundle = FinderReporterUIC.wzC;
        paramBundle = FinderReporterUIC.a.fH((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.dIx();
          j.a("2", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1, 1, paramBundle, 0, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
          paramBundle = FinderReporterUIC.wzC;
          paramBundle = FinderReporterUIC.a.fH((Context)this);
          if (paramBundle == null) {
            break label858;
          }
          paramBundle = paramBundle.dIx();
          label533:
          com.tencent.mm.plugin.finder.report.k.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.udd);
        addIconOptionMenu(this.udd, -1, 2131690751, (MenuItem.OnMenuItemClickListener)new b(this, (bdo)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2));
        label588:
        removeOptionMenu(this.udc);
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().asW("TLPersonalCenter");
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().asX("TLPersonalCenter");
        addIconOptionMenu(this.udc, -1, 2131690829, (MenuItem.OnMenuItemClickListener)new c(this, (bdo)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2), (View.OnLongClickListener)FinderTimelineUI.d.udn);
        paramBundle = y.vXH;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = j.vft;
          paramBundle = FinderReporterUIC.wzC;
          paramBundle = FinderReporterUIC.a.fH((Context)this);
          if (paramBundle == null) {
            break label908;
          }
          paramBundle = paramBundle.dIx();
          label722:
          j.a("2", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject2, (bdo)localObject1, 1, paramBundle, 0, 0, 96);
          paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject2).field_tipsId;
          paramBundle = FinderReporterUIC.wzC;
          paramBundle = FinderReporterUIC.a.fH((Context)this);
          if (paramBundle == null) {
            break label913;
          }
        }
      }
    }
    label908:
    label913:
    for (paramBundle = paramBundle.dIx();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.k.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daN(), (LifecycleOwner)this, (Observer)new n(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daL(), (LifecycleOwner)this, (Observer)new o(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      label858:
      paramBundle = null;
      break label533;
      removeOptionMenu(this.ude);
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drx()) {
        break label588;
      }
      addIconOptionMenu(this.ude, -1, 2131690278, (MenuItem.OnMenuItemClickListener)new e(this));
      break label588;
      paramBundle = null;
      break label722;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.azz().b(3761, (com.tencent.mm.ak.i)this);
    Object localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onDetach();
    localObject = n.uNU;
    n.release();
    com.tencent.mm.ac.d.i((kotlin.g.a.a)p.uds);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    localObject = this.sGQ;
    if (localObject == null) {
      p.btv("contextId");
    }
    com.tencent.mm.plugin.finder.report.k.gS((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    ai.a locala = this.tTf;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onUIPause();
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(102, false, false);
    }
    AppMethodBeat.o(166261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166260);
    super.onResume();
    boolean bool = this.qgs;
    this.qgs = FinderGlobalLocationVM.dHO();
    if ((this.qgs) && (!bool)) {
      this.udf.cxh();
    }
    Object localObject = this.tTf;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((ai.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
    if (com.tencent.mm.plugin.finder.upload.g.dBb())
    {
      localObject = this.tRV;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      localObject = ((ai.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.oF(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(166258);
    Log.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.kkd;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramq != null)
    {
      if (paramq.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.g.azz().b(3761, (com.tencent.mm.ak.i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.g.aAh();
      p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.azQ().getInt(ar.a.Okh, 0);
      Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.udb = ((cd)paramq).cZc();
        com.tencent.mm.ui.base.h.X((Context)this, getString(2131760533), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = y.vXH;
    if (y.an((Activity)this))
    {
      paramString = y.vXH;
      if (y.a((Context)this, getString(2131760623), ((cd)paramq).twh, this.udb)) {
        det();
      }
    }
    AppMethodBeat.o(166258);
    return;
    label250:
    u.makeText((Context)this, 2131760430, 1).show();
    label264:
    AppMethodBeat.o(166258);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_LIVE", "", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, bdo parambdo, com.tencent.mm.plugin.finder.extension.reddot.k paramk) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178302);
      paramMenuItem = y.vXH;
      bdo localbdo = this.udj;
      com.tencent.mm.plugin.finder.extension.reddot.k localk = this.udk;
      if ((localbdo != null) && (localk != null))
      {
        paramMenuItem = j.vft;
        paramMenuItem = FinderReporterUIC.wzC;
        paramMenuItem = FinderReporterUIC.a.fH((Context)this.udi);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.dIx();
          j.a("2", localk, localbdo, 2, paramMenuItem, 0, 0, 96);
          paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
          paramMenuItem = FinderReporterUIC.wzC;
          paramMenuItem = FinderReporterUIC.a.fH((Context)this.udi);
          if (paramMenuItem == null) {
            break label223;
          }
          paramMenuItem = paramMenuItem.dIx();
          label102:
          com.tencent.mm.plugin.finder.report.k.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
        p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.aj)paramMenuItem).getRedDotManager().asV("TLCamera");
        if (!Util.isNullOrNil(com.tencent.mm.model.z.aUg())) {
          break label359;
        }
        if (FinderTimelineUI.f(this.udi) != null) {
          break label233;
        }
        Log.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        paramMenuItem = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.daL().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.dEF != true)) {
          break label228;
        }
      }
      label223:
      label228:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUI.a(this.udi, bool);
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label102;
      }
      label233:
      paramMenuItem = com.tencent.mm.kernel.g.aAh();
      p.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.azQ().getInt(ar.a.Okh, 0);
      Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.X((Context)this.udi, this.udi.getString(2131760533), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = y.vXH;
        if (y.an((Activity)this.udi))
        {
          paramMenuItem = y.vXH;
          y.a((Context)this.udi, this.udi.getString(2131760623), FinderTimelineUI.f(this.udi));
          continue;
          label359:
          FinderTimelineUI.g(this.udi);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, bdo parambdo, com.tencent.mm.plugin.finder.extension.reddot.k paramk) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = y.vXH;
      bdo localbdo = this.udl;
      Object localObject = this.udm;
      if ((localbdo != null) && (localObject != null))
      {
        paramMenuItem = j.vft;
        paramMenuItem = FinderReporterUIC.wzC;
        paramMenuItem = FinderReporterUIC.a.fH((Context)this.udi);
        if (paramMenuItem == null) {
          break label170;
        }
        paramMenuItem = paramMenuItem.dIx();
        j.a("2", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, localbdo, 2, paramMenuItem, 0, 0, 96);
        paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
        localObject = ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).field_tipsId;
        paramMenuItem = FinderReporterUIC.wzC;
        paramMenuItem = FinderReporterUIC.a.fH((Context)this.udi);
        if (paramMenuItem == null) {
          break label175;
        }
      }
      label170:
      label175:
      for (paramMenuItem = paramMenuItem.dIx();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.k.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.z((Context)this.udi, null);
        paramMenuItem = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
        p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.aj)paramMenuItem).getRedDotManager().asV("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245570);
      paramMenuItem = new dl();
      paramMenuItem.afd();
      paramMenuItem.bfK();
      Log.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.afe());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.d((Context)this.udi.getContext());
      paramMenuItem.Ml(2131494569);
      Object localObject = (TextView)paramMenuItem.lJI.findViewById(2131305458);
      TextView localTextView1 = (TextView)paramMenuItem.lJI.findViewById(2131305456);
      TextView localTextView2 = (TextView)paramMenuItem.lJI.findViewById(2131305457);
      p.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.c.dry());
      p.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.c.drz());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.dGm();
      AppMethodBeat.o(245570);
      return true;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(245569);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.tru.bMo();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245569);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    f(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(245571);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(1001, 2131755822);
        paramm.kV(1002, 2131755831);
        paramm.kV(1004, 2131759919);
        r localr = r.vWn;
        r.a(FinderTimelineUI.e(this.udi), paramm);
      }
      AppMethodBeat.o(245571);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245572);
      Object localObject = new Intent();
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001)
      {
        ((Intent)localObject).putExtra("key_finder_post_router", 2);
        ((Intent)localObject).putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramMenuItem = this.udi.getContext();
        p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
        AppMethodBeat.o(245572);
        return;
      }
      if (paramMenuItem.getItemId() == 1002)
      {
        ((Intent)localObject).putExtra("key_finder_post_router", 3);
        ((Intent)localObject).putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramMenuItem = this.udi.getContext();
        p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
        AppMethodBeat.o(245572);
        return;
      }
      if (paramMenuItem.getItemId() == 1004)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramMenuItem = this.udi.getContext();
        p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.a((Context)paramMenuItem, 0L, "", null, false, null, null, null, null, null, null, null, 8184);
        AppMethodBeat.o(245572);
        return;
      }
      if (FinderTimelineUI.e(this.udi).containsKey(Integer.valueOf(paramMenuItem.getItemId())))
      {
        localObject = r.vWn;
        r.a((Context)this.udi, (ddk)FinderTimelineUI.e(this.udi).get(Integer.valueOf(paramMenuItem.getItemId())));
        paramMenuItem = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.as(1, false);
      }
      AppMethodBeat.o(245572);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h udo;
    
    static
    {
      AppMethodBeat.i(245574);
      udo = new h();
      AppMethodBeat.o(245574);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(245573);
      com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Ks(6);
      AppMethodBeat.o(245573);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class i
    implements DialogInterface.OnCancelListener
  {
    i(FinderTimelineUI paramFinderTimelineUI, cd paramcd) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(166241);
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)this.udp);
      com.tencent.mm.kernel.g.azz().b(3761, (com.tencent.mm.ak.i)this.udi);
      AppMethodBeat.o(166241);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final j udq;
    
    static
    {
      AppMethodBeat.i(166243);
      udq = new j();
      AppMethodBeat.o(166243);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.udi.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.udi).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).ks() <= 12)
      {
        localObject = FinderTimelineUI.a(this.udi).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.convert.aj.tEf;
        aj.a.a(FinderTimelineUI.a(this.udi), FinderTimelineUI.b(this.udi).getTabType());
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.udi).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    public static final m udr;
    
    static
    {
      AppMethodBeat.i(166246);
      udr = new m();
      AppMethodBeat.o(166246);
    }
    
    public final void run() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class n<T>
    implements Observer<h.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class o<T>
    implements Observer<h.a>
  {
    o(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final p uds;
    
    static
    {
      AppMethodBeat.i(166248);
      uds = new p();
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