package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.b.a.a.a;
import com.tencent.mm.msgsubscription.b.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@k
@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "action", "", "getAction", "()I", "action$delegate", "Lkotlin/Lazy;", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "bizAppId$delegate", "bizUsername", "getBizUsername", "bizUsername$delegate", "content", "getContent", "content$delegate", "currentAction", "extInfo", "getExtInfo", "extInfo$delegate", "mDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRequestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "needResult", "", "getNeedResult", "()Z", "needResult$delegate", "scene", "getScene", "scene$delegate", "subscribeMsgRequestCallback", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1;", "subscribeUrl", "getSubscribeUrl", "subscribeUrl$delegate", "templateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIds", "()Ljava/util/ArrayList;", "templateIds$delegate", "configNavigationBar", "", "configStatusBar", "doRequest", "finishSelf", "delayed", "finishUIWithResult", "errCode", "errMsg", "data", "Landroid/os/Bundle;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onResume", "onUserCancel", "setFullScreen", "showProgressDialog", "Companion", "plugin-comm_release"})
public final class SubscribeMsgRequestProxyUI
  extends MMActivity
{
  public static final SubscribeMsgRequestProxyUI.a mtk;
  private HashMap _$_findViewCache;
  private s jhZ;
  private j msW;
  private com.tencent.mm.plugin.appbrand.widget.dialog.d msX;
  private a.b msY;
  private int msZ;
  private final f mta;
  private final f mtb;
  private final f mtc;
  private final f mtd;
  private final f mte;
  private final f mtf;
  private final f mtg;
  private final f mth;
  private final f mti;
  private final j mtj;
  
  static
  {
    AppMethodBeat.i(149802);
    mtk = new SubscribeMsgRequestProxyUI.a((byte)0);
    AppMethodBeat.o(149802);
  }
  
  public SubscribeMsgRequestProxyUI()
  {
    AppMethodBeat.i(149810);
    this.mta = g.ar((kotlin.g.a.a)new i(this));
    this.mtb = g.ar((kotlin.g.a.a)new d(this));
    this.mtc = g.ar((kotlin.g.a.a)new c(this));
    this.mtd = g.ar((kotlin.g.a.a)new b(this));
    this.mte = g.ar((kotlin.g.a.a)new l(this));
    this.mtf = g.ar((kotlin.g.a.a)new k(this));
    this.mtg = g.ar((kotlin.g.a.a)new e(this));
    this.mth = g.ar((kotlin.g.a.a)new h(this));
    this.mti = g.ar((kotlin.g.a.a)new f(this));
    this.mtj = new j(this);
    AppMethodBeat.o(149810);
  }
  
  private final String bsD()
  {
    AppMethodBeat.i(149803);
    String str = (String)this.mtb.getValue();
    AppMethodBeat.o(149803);
    return str;
  }
  
  private final String bsE()
  {
    AppMethodBeat.i(202932);
    String str = (String)this.mtc.getValue();
    AppMethodBeat.o(202932);
    return str;
  }
  
  private final int bsF()
  {
    AppMethodBeat.i(149804);
    int i = ((Number)this.mtd.getValue()).intValue();
    AppMethodBeat.o(149804);
    return i;
  }
  
  private final boolean bsG()
  {
    AppMethodBeat.i(202935);
    boolean bool = ((Boolean)this.mth.getValue()).booleanValue();
    AppMethodBeat.o(202935);
    return bool;
  }
  
  private final String bsH()
  {
    AppMethodBeat.i(202936);
    String str = (String)this.mti.getValue();
    AppMethodBeat.o(202936);
    return str;
  }
  
  private final void gL(boolean paramBoolean)
  {
    AppMethodBeat.i(202967);
    a(this, 10005, "user cancel", false, null, 8);
    AppMethodBeat.o(202967);
  }
  
  private final int getScene()
  {
    AppMethodBeat.i(202929);
    int i = ((Number)this.mta.getValue()).intValue();
    AppMethodBeat.o(202929);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(203015);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203015);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203013);
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
    AppMethodBeat.o(203013);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149809);
    Log.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onBackPressed currentAction: %d", new Object[] { Integer.valueOf(this.msZ) });
    Object localObject;
    if (com.tencent.mm.msgsubscription.b.a.a.xo(this.msZ))
    {
      localObject = this.jhZ;
      if (localObject != null) {
        ((s)localObject).dismiss();
      }
      gL(false);
      AppMethodBeat.o(149809);
      return;
    }
    if (com.tencent.mm.msgsubscription.b.a.a.xp(this.msZ))
    {
      localObject = this.msX;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.widget.dialog.d)localObject).onBackPressed();
        AppMethodBeat.o(149809);
        return;
      }
      AppMethodBeat.o(149809);
      return;
    }
    gL(false);
    AppMethodBeat.o(149809);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149805);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    this.jhZ = h.a((Context)this, getResources().getString(c.h.loading), false, null);
    com.tencent.mm.msgsubscription.b.a.a locala;
    if (getScene() == 1)
    {
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = new a.b((Context)paramBundle, bsF(), bsD(), bsE(), (String)this.mtf.getValue(), (String)this.mtg.getValue(), bsH(), (a.a)this.mtj);
      this.msY = paramBundle;
      paramBundle = this.msY;
      if (paramBundle != null)
      {
        paramBundle.jaR = getScene();
        if (!com.tencent.mm.msgsubscription.b.a.a.xo(bsF())) {
          break label295;
        }
        locala = com.tencent.mm.msgsubscription.b.a.a.mpw;
        com.tencent.mm.msgsubscription.b.a.a.a(paramBundle);
      }
    }
    for (;;)
    {
      this.msZ = bsF();
      AppMethodBeat.o(149805);
      return;
      if (getScene() == 2)
      {
        paramBundle = getContext();
        p.j(paramBundle, "context");
        paramBundle = new a.b((Context)paramBundle, bsF(), bsE(), (ArrayList)this.mte.getValue(), bsH(), (a.a)this.mtj);
        break;
      }
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo requestSubscribeMessage scene invalid: " + getScene());
      paramBundle = null;
      break;
      label295:
      if (com.tencent.mm.msgsubscription.b.a.a.xp(bsF()))
      {
        locala = com.tencent.mm.msgsubscription.b.a.a.mpw;
        com.tencent.mm.msgsubscription.b.a.a.b(paramBundle);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202983);
    super.onDestroy();
    Object localObject = this.jhZ;
    if (localObject != null) {
      ((s)localObject).dismiss();
    }
    localObject = this.msY;
    if (localObject != null)
    {
      Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo release");
      com.tencent.mm.ui.widget.a.d locald = ((a.b)localObject).mpz;
      if (locald != null) {
        locald.dismiss();
      }
      localObject = ((a.b)localObject).mpA;
      if (localObject != null)
      {
        ((c)localObject).dismiss();
        AppMethodBeat.o(202983);
        return;
      }
      AppMethodBeat.o(202983);
      return;
    }
    AppMethodBeat.o(202983);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149806);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      p.j(localWindow, "window");
      localWindow.setStatusBarColor(getResources().getColor(c.b.transparent));
    }
    setNavigationbarColor(getResources().getColor(c.b.BG_1));
    AppMethodBeat.o(149806);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Integer>
  {
    b(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<String>
  {
    e(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<String>
  {
    f(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149800);
      SubscribeMsgRequestProxyUI.a(this.mtl);
      AppMethodBeat.o(149800);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    h(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Integer>
  {
    i(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
  public static final class j
    implements a.a
  {
    public final void a(j paramj, com.tencent.mm.plugin.appbrand.widget.dialog.d paramd)
    {
      AppMethodBeat.i(194752);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onShowDialog");
      SubscribeMsgRequestProxyUI.a(this.mtl, paramj);
      SubscribeMsgRequestProxyUI.a(this.mtl, paramd);
      AppMethodBeat.o(194752);
    }
    
    public final void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(194762);
      p.k(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onGetSubscribeListSuccess bizUsername: %s, %d, showDialog: %b", new Object[] { SubscribeMsgRequestProxyUI.c(this.mtl), Integer.valueOf(paramSubscribeMsgRequestResult.mnO.size()), Boolean.valueOf(paramBoolean) });
      paramSubscribeMsgRequestResult = SubscribeMsgRequestProxyUI.b(this.mtl);
      if (paramSubscribeMsgRequestResult != null) {
        paramSubscribeMsgRequestResult.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.mtl, com.tencent.mm.msgsubscription.b.a.a.xn(SubscribeMsgRequestProxyUI.d(this.mtl)));
      if ((SubscribeMsgRequestProxyUI.e(this.mtl) == 1) || (!paramBoolean)) {
        SubscribeMsgRequestProxyUI.a(this.mtl, 0, "", false, null, 12);
      }
      AppMethodBeat.o(194762);
    }
    
    public final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(194767);
      p.k(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onSubscribeMsgSuccess bizUsername: %s, %d", new Object[] { SubscribeMsgRequestProxyUI.c(this.mtl), Integer.valueOf(paramSubscribeMsgRequestResult.mnO.size()) });
      SubscribeMsgRequestProxyUI.a(this.mtl, com.tencent.mm.msgsubscription.b.a.a.xn(SubscribeMsgRequestProxyUI.d(this.mtl)));
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("key_result_data", paramSubscribeMsgRequestResult.mnO);
      localBundle.putString("key_result_ext_data", paramSubscribeMsgRequestResult.extData);
      SubscribeMsgRequestProxyUI.a(this.mtl, 0, "", false, localBundle, 4);
      AppMethodBeat.o(194767);
    }
    
    public final void bst()
    {
      AppMethodBeat.i(194753);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onDismissDialog");
      SubscribeMsgRequestProxyUI.a(this.mtl, null);
      AppMethodBeat.o(194753);
    }
    
    public final void bsu()
    {
      AppMethodBeat.i(194756);
      s locals = SubscribeMsgRequestProxyUI.b(this.mtl);
      if (locals != null)
      {
        locals.dismiss();
        AppMethodBeat.o(194756);
        return;
      }
      AppMethodBeat.o(194756);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(194773);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onError bizUsername: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { SubscribeMsgRequestProxyUI.c(this.mtl), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      s locals = SubscribeMsgRequestProxyUI.b(this.mtl);
      if (locals != null) {
        locals.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.mtl, paramInt2, paramString, true, null, 8);
      AppMethodBeat.o(194773);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<String>
  {
    k(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<ArrayList<String>>
  {
    l(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestProxyUI
 * JD-Core Version:    0.7.0.1
 */