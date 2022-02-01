package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ed;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.plugin.finder.convert.al.a;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.ap.a;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.feed.ba;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.j;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.x;

@com.tencent.mm.ui.widget.pulldown.c(0)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "contextId", "", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "postItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "Lkotlin/collections/HashMap;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "continuePost", "doClickPostAction", "doPrepareUser", "showPostRed", "getLayoutId", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUI
  extends MMFinderUI
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.api.h
{
  public static final a xSO;
  private HashMap _$_findViewCache;
  private ProgressDialog nbT;
  private boolean tCo;
  private ble wZz;
  private String wmL;
  private ap.b xCN;
  private ap.a xDV;
  private final int xSJ;
  private final int xSK;
  private final int xSL;
  private final com.tencent.mm.plugin.finder.viewmodel.a xSM;
  private HashMap<Integer, dna> xSN;
  
  static
  {
    AppMethodBeat.i(166265);
    xSO = new a((byte)0);
    AppMethodBeat.o(166265);
  }
  
  public FinderTimelineUI()
  {
    AppMethodBeat.i(271102);
    this.xSJ = 1;
    this.xSK = 2;
    this.xSL = 3;
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
    p.j(localObject, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.xSM = ((com.tencent.mm.plugin.finder.viewmodel.a)localObject);
    this.xSN = new HashMap();
    AppMethodBeat.o(271102);
  }
  
  private final void dvZ()
  {
    AppMethodBeat.i(166254);
    Object localObject1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGS("post"))
    {
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    if (com.tencent.mm.plugin.finder.utils.a.fF((Context)this))
    {
      localObject1 = k.zWs;
      k.av(1, true);
      AppMethodBeat.o(166254);
      return;
    }
    localObject1 = k.zWs;
    k.av(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 1, true);
    View localView = ad.kS((Context)getContext()).inflate(b.g.finder_sheet_header, null);
    Object localObject3 = (TextView)localView.findViewById(b.f.nickname);
    ImageView localImageView = (ImageView)localView.findViewById(b.f.avatar);
    Object localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject2 = d.a.aAK(com.tencent.mm.model.z.bdh());
    if (localObject2 != null)
    {
      p.j(localObject3, "nicknameTv");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getBaseContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.i)localObject2).getNickname()));
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject3 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject2 = new com.tencent.mm.plugin.finder.loader.e(((com.tencent.mm.plugin.finder.api.i)localObject2).field_avatarUrl);
      p.j(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject3).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).Z(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.g)new g(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)h.xSV);
    ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
    AppMethodBeat.o(166254);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(271105);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(271105);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(271104);
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
    AppMethodBeat.o(271104);
    return localView1;
  }
  
  public final void a(aqt paramaqt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271101);
    p.k(paramaqt, "cmdItem");
    switch (paramaqt.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271101);
      return;
      paramaqt = this.xDV;
      if (paramaqt == null) {
        p.bGy("presenter");
      }
      paramaqt.dto();
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_timeline_ui;
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
      this.xSM.cKK();
      AppMethodBeat.o(166264);
      return;
    case 564: 
      this.tCo = com.tencent.mm.plugin.finder.viewmodel.a.ejZ();
      AppMethodBeat.o(166264);
      return;
    }
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = ((j)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(j.class)).xvK;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.f)localObject).d(paramInt1, paramIntent);
      AppMethodBeat.o(166264);
      return;
    }
    AppMethodBeat.o(166264);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166259);
    ap.a locala = this.xDV;
    if (locala == null) {
      p.bGy("presenter");
    }
    locala.onBackPressed();
    AppMethodBeat.o(166259);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166253);
    com.tencent.mm.pluginsdk.h.r((MMActivity)this);
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.wmL = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
    paramBundle = this.wmL;
    if (paramBundle == null) {
      p.bGy("contextId");
    }
    com.tencent.mm.plugin.finder.report.n.hj(paramBundle, "OnCreate");
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
    paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)paramBundle).getRedDotManager().Mn(i);
    this.tCo = com.tencent.mm.plugin.finder.viewmodel.a.i((MMActivity)this);
    if (this.tCo) {
      this.xSM.cKK();
    }
    paramBundle = ap.xcn;
    ap.dnQ();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.Azp;
    com.tencent.mm.plugin.finder.upload.b.ebZ().ebY();
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setMMTitle(paramBundle.getResources().getString(b.j.finder_title));
    com.tencent.mm.ae.d.h((kotlin.g.a.a)j.xSX);
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    this.xDV = ((ap.a)new az((MMActivity)this, null));
    paramBundle = (MMActivity)this;
    localObject1 = this.xDV;
    if (localObject1 == null) {
      p.bGy("presenter");
    }
    Object localObject2 = getContentView();
    p.j(localObject2, "contentView");
    this.xCN = ((ap.b)new ba(paramBundle, (ap.a)localObject1, (View)localObject2, null));
    paramBundle = this.xDV;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    localObject1 = this.xCN;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    paramBundle.onAttach(localObject1);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.AAk;
    com.tencent.mm.plugin.finder.upload.g.ecj().eci();
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.h)this);
    com.tencent.mm.pluginsdk.h.s((MMActivity)this);
    setTitleBarClickListener((Runnable)new l(this), (Runnable)m.xSY);
    if (((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).showPostEntry())
    {
      paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().aBe("TLCamera");
      paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().aBf("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.l.zWx;
        paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramBundle = aj.a.fZ((Context)this);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.ekY();
          com.tencent.mm.plugin.finder.report.l.a("2", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1, 1, paramBundle, 0, 0, null, 224);
          paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
          paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramBundle = aj.a.fZ((Context)this);
          if (paramBundle == null) {
            break label862;
          }
          paramBundle = paramBundle.ekY();
          label535:
          com.tencent.mm.plugin.finder.report.n.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        }
      }
      else
      {
        removeOptionMenu(this.xSK);
        addIconOptionMenu(this.xSK, -1, b.i.icons_outlined_camera, (MenuItem.OnMenuItemClickListener)new b(this, (bkn)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2));
        label590:
        removeOptionMenu(this.xSJ);
        paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject1 = ((PluginFinder)paramBundle).getRedDotManager().aBe("TLPersonalCenter");
        paramBundle = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        localObject2 = ((PluginFinder)paramBundle).getRedDotManager().aBf("TLPersonalCenter");
        addIconOptionMenu(this.xSJ, -1, b.i.icons_outlined_me, (MenuItem.OnMenuItemClickListener)new c(this, (bkn)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2), (View.OnLongClickListener)FinderTimelineUI.d.xSU);
        paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if ((localObject1 != null) && (localObject2 != null))
        {
          paramBundle = com.tencent.mm.plugin.finder.report.l.zWx;
          paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramBundle = aj.a.fZ((Context)this);
          if (paramBundle == null) {
            break label912;
          }
          paramBundle = paramBundle.ekY();
          label724:
          com.tencent.mm.plugin.finder.report.l.a("2", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject1, 1, paramBundle, 0, 0, null, 224);
          paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
          localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_tipsId;
          paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramBundle = aj.a.fZ((Context)this);
          if (paramBundle == null) {
            break label917;
          }
        }
      }
    }
    label912:
    label917:
    for (paramBundle = paramBundle.ekY();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.n.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqR(), (androidx.lifecycle.l)this, (s)new n(this));
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqP(), (androidx.lifecycle.l)this, (s)new o(this));
      AppMethodBeat.o(166253);
      return;
      paramBundle = null;
      break;
      label862:
      paramBundle = null;
      break label535;
      removeOptionMenu(this.xSL);
      paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSM()) {
        break label590;
      }
      addIconOptionMenu(this.xSL, -1, b.i.finder_no_permission_post_camera, (MenuItem.OnMenuItemClickListener)new e(this));
      break label590;
      paramBundle = null;
      break label724;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166262);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.h)this);
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    Object localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.n.zAi;
    com.tencent.mm.plugin.finder.model.n.release();
    com.tencent.mm.ae.d.h((kotlin.g.a.a)p.xSZ);
    localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject = this.wmL;
    if (localObject == null) {
      p.bGy("contextId");
    }
    com.tencent.mm.plugin.finder.report.n.hj((String)localObject, "Exit");
    AppMethodBeat.o(166262);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166261);
    super.onPause();
    ap.a locala = this.xDV;
    if (locala == null) {
      p.bGy("presenter");
    }
    locala.onUIPause();
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class) != null) {
      ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class)).f(102, false, false);
    }
    AppMethodBeat.o(166261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166260);
    super.onResume();
    boolean bool = this.tCo;
    this.tCo = com.tencent.mm.plugin.finder.viewmodel.a.ejZ();
    if ((this.tCo) && (!bool)) {
      this.xSM.cKK();
    }
    Object localObject = this.xDV;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((ap.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
    if (com.tencent.mm.plugin.finder.upload.g.ecl())
    {
      localObject = this.xCN;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      localObject = ((ap.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
      com.tencent.mm.plugin.finder.upload.g.qS(false);
    }
    AppMethodBeat.o(166260);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(166258);
    Log.i("Finder.FinderTimelineUI", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.nbT;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramq != null)
    {
      if (paramq.getType() != 3761) {
        break label264;
      }
      com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label250;
      }
      paramString = com.tencent.mm.kernel.h.aHG();
      p.j(paramString, "MMKernel.storage()");
      paramInt1 = paramString.aHp().getInt(ar.a.VyF, 0);
      Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.wZz = ((ch)paramq).dnR();
        com.tencent.mm.ui.base.h.af((Context)this, getString(b.j.finder_self_contact_reviewing), "");
        AppMethodBeat.o(166258);
      }
    }
    else
    {
      AppMethodBeat.o(166258);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.at((Activity)this))
    {
      paramString = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.a((Context)this, getString(b.j.finder_timeline_create_contact_tip), ((ch)paramq).xdV, this.wZz)) {
        dvZ();
      }
    }
    AppMethodBeat.o(166258);
    return;
    label250:
    w.makeText((Context)this, b.j.finder_prepare_user_failed, 1).show();
    label264:
    AppMethodBeat.o(166258);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$Companion;", "", "()V", "REQUEST_CODE_LIVE", "", "REQUEST_CODE_POST_ACTIONSHEET", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "REQ_GPS_PERMISSION", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUI paramFinderTimelineUI, bkn parambkn, com.tencent.mm.plugin.finder.extension.reddot.l paraml) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178302);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
      bkn localbkn = this.xSQ;
      com.tencent.mm.plugin.finder.extension.reddot.l locall = this.xSR;
      if ((localbkn != null) && (locall != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.l.zWx;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.xSP);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.ekY();
          com.tencent.mm.plugin.finder.report.l.a("2", locall, localbkn, 2, paramMenuItem, 0, 0, null, 224);
          paramMenuItem = com.tencent.mm.plugin.finder.report.n.zWF;
          paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramMenuItem = aj.a.fZ((Context)this.xSP);
          if (paramMenuItem == null) {
            break label225;
          }
          paramMenuItem = paramMenuItem.ekY();
          label104:
          com.tencent.mm.plugin.finder.report.n.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((ak)paramMenuItem).getRedDotManager().aBd("TLCamera");
        if (!Util.isNullOrNil(com.tencent.mm.model.z.bdh())) {
          break label363;
        }
        if (FinderTimelineUI.f(this.xSP) != null) {
          break label235;
        }
        Log.i("Finder.FinderTimelineUI", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramMenuItem = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.dqP().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.fxt != true)) {
          break label230;
        }
      }
      label225:
      label230:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUI.a(this.xSP, bool);
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label104;
      }
      label235:
      paramMenuItem = com.tencent.mm.kernel.h.aHG();
      p.j(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.aHp().getInt(ar.a.VyF, 0);
      Log.i("Finder.FinderTimelineUI", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.af((Context)this.xSP, this.xSP.getString(b.j.finder_self_contact_reviewing), "");
      }
      for (;;)
      {
        AppMethodBeat.o(178302);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.at((Activity)this.xSP))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a((Context)this.xSP, this.xSP.getString(b.j.finder_timeline_create_contact_tip), FinderTimelineUI.f(this.xSP));
          continue;
          label363:
          FinderTimelineUI.g(this.xSP);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUI paramFinderTimelineUI, bkn parambkn, com.tencent.mm.plugin.finder.extension.reddot.l paraml) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(178303);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.aj.AGc;
      bkn localbkn = this.xSS;
      Object localObject = this.xST;
      if ((localbkn != null) && (localObject != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.l.zWx;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.xSP);
        if (paramMenuItem == null) {
          break label172;
        }
        paramMenuItem = paramMenuItem.ekY();
        com.tencent.mm.plugin.finder.report.l.a("2", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject, localbkn, 2, paramMenuItem, 0, 0, null, 224);
        paramMenuItem = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject).field_tipsId;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.xSP);
        if (paramMenuItem == null) {
          break label177;
        }
      }
      label172:
      label177:
      for (paramMenuItem = paramMenuItem.ekY();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.n.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)this.xSP, null);
        paramMenuItem = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((ak)paramMenuItem).getRedDotManager().aBd("TLPersonalCenter");
        AppMethodBeat.o(178303);
        return true;
        paramMenuItem = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(282275);
      paramMenuItem = new ed();
      paramMenuItem.ajX();
      paramMenuItem.bpa();
      Log.i("Finder.FinderTimelineUI", "report18939 postEdu: " + paramMenuItem.ajY());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.e((Context)this.xSP.getContext());
      paramMenuItem.RB(b.g.finder_post_edu_layout);
      Object localObject = (TextView)paramMenuItem.oFW.findViewById(b.f.no_post_edu_title);
      TextView localTextView1 = (TextView)paramMenuItem.oFW.findViewById(b.f.no_post_edu_desc);
      TextView localTextView2 = (TextView)paramMenuItem.oFW.findViewById(b.f.no_post_edu_ok);
      p.j(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.d.dSN());
      p.j(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.d.dSQ());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.eik();
      AppMethodBeat.o(282275);
      return true;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(271085);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.wZH.bYF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271085);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements q.f
  {
    f(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      Object localObject1 = null;
      AppMethodBeat.i(280451);
      p.j(paramo, "it");
      Object localObject2;
      if (paramo.hJO())
      {
        paramo.mn(1001, b.j.app_field_mmsight);
        paramo.mn(1002, b.j.app_field_select_new_pic);
        paramo.mn(1004, b.j.finder_live_entry);
        localObject2 = ab.AEA;
        localObject2 = FinderTimelineUI.e(this.xSP);
        AppCompatActivity localAppCompatActivity = this.xSP.getContext();
        p.j(localAppCompatActivity, "context");
        ab.a((HashMap)localObject2, paramo, (Activity)localAppCompatActivity);
      }
      paramo = com.tencent.mm.plugin.finder.report.n.zWF;
      paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramo = this.xSP.getContext();
      p.j(paramo, "context");
      paramo = aj.a.fZ((Context)paramo);
      if (paramo != null) {}
      for (paramo = paramo.ekY();; paramo = null)
      {
        com.tencent.mm.plugin.finder.report.n.b(0, "post_acionsheet_camera", "", paramo);
        paramo = com.tencent.mm.plugin.finder.report.n.zWF;
        paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramo = this.xSP.getContext();
        p.j(paramo, "context");
        localObject2 = aj.a.fZ((Context)paramo);
        paramo = localObject1;
        if (localObject2 != null) {
          paramo = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
        }
        com.tencent.mm.plugin.finder.report.n.b(0, "post_actionsheet_album", "", paramo);
        AppMethodBeat.o(280451);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(284968);
      Object localObject = new Intent();
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001)
      {
        ((Intent)localObject).putExtra("key_finder_post_router", 2);
        ((Intent)localObject).putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramMenuItem = this.xSP.getContext();
        p.j(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
        paramMenuItem = com.tencent.mm.plugin.finder.report.n.zWF;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = this.xSP.getContext();
        p.j(paramMenuItem, "context");
        paramMenuItem = aj.a.fZ((Context)paramMenuItem);
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.ekY();; paramMenuItem = null)
        {
          com.tencent.mm.plugin.finder.report.n.b(1, "post_acionsheet_camera", "", paramMenuItem);
          AppMethodBeat.o(284968);
          return;
        }
      }
      if (paramMenuItem.getItemId() == 1002)
      {
        ((Intent)localObject).putExtra("key_finder_post_router", 3);
        ((Intent)localObject).putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramMenuItem = this.xSP.getContext();
        p.j(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, (Intent)localObject);
        paramMenuItem = com.tencent.mm.plugin.finder.report.n.zWF;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = this.xSP.getContext();
        p.j(paramMenuItem, "context");
        paramMenuItem = aj.a.fZ((Context)paramMenuItem);
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.ekY();; paramMenuItem = null)
        {
          com.tencent.mm.plugin.finder.report.n.b(1, "post_actionsheet_album", "", paramMenuItem);
          AppMethodBeat.o(284968);
          return;
        }
      }
      if (paramMenuItem.getItemId() == 1004)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramMenuItem = this.xSP.getContext();
        p.j(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.a((Context)paramMenuItem, 0L, "", null, null, null, null, null, null, null, null, null, 8184);
        AppMethodBeat.o(284968);
        return;
      }
      if (FinderTimelineUI.e(this.xSP).containsKey(Integer.valueOf(paramMenuItem.getItemId())))
      {
        localObject = ab.AEA;
        ab.a((Context)this.xSP, (dna)FinderTimelineUI.e(this.xSP).get(Integer.valueOf(paramMenuItem.getItemId())));
        paramMenuItem = k.zWs;
        k.av(1, false);
      }
      AppMethodBeat.o(284968);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h xSV;
    
    static
    {
      AppMethodBeat.i(287957);
      xSV = new h();
      AppMethodBeat.o(287957);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(287956);
      k localk = k.zWs;
      k.Pw(6);
      AppMethodBeat.o(287956);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class i
    implements DialogInterface.OnCancelListener
  {
    i(FinderTimelineUI paramFinderTimelineUI, ch paramch) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(166241);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.xSW);
      com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this.xSP);
      AppMethodBeat.o(166241);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final j xSX;
    
    static
    {
      AppMethodBeat.i(166243);
      xSX = new j();
      AppMethodBeat.o(166243);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166244);
      this.xSP.onBackPressed();
      AppMethodBeat.o(166244);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderTimelineUI paramFinderTimelineUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(166245);
      Object localObject = FinderTimelineUI.a(this.xSP).getRecyclerView().getLayoutManager();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(166245);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.hellhoundlib.b.a locala;
      if (((LinearLayoutManager)localObject).kJ() <= 12)
      {
        localObject = FinderTimelineUI.a(this.xSP).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      for (;;)
      {
        localObject = al.xmH;
        al.a.a(FinderTimelineUI.a(this.xSP), FinderTimelineUI.b(this.xSP).getTabType());
        AppMethodBeat.o(166245);
        return;
        localObject = FinderTimelineUI.a(this.xSP).getRecyclerView();
        locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI$onCreate$3", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    public static final m xSY;
    
    static
    {
      AppMethodBeat.i(166246);
      xSY = new m();
      AppMethodBeat.o(166246);
    }
    
    public final void run() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class n<T>
    implements s<h.a>
  {
    n(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class o<T>
    implements s<h.a>
  {
    o(FinderTimelineUI paramFinderTimelineUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final p xSZ;
    
    static
    {
      AppMethodBeat.i(166248);
      xSZ = new p();
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