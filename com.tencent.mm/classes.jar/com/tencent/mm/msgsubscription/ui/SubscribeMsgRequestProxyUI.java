package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.b.a.a.a;
import com.tencent.mm.msgsubscription.b.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "action", "", "getAction", "()I", "action$delegate", "Lkotlin/Lazy;", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "bizAppId$delegate", "bizUsername", "getBizUsername", "bizUsername$delegate", "content", "getContent", "content$delegate", "currentAction", "extInfo", "getExtInfo", "extInfo$delegate", "mDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRequestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "needResult", "", "getNeedResult", "()Z", "needResult$delegate", "scene", "getScene", "scene$delegate", "subscribeMsgRequestCallback", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1;", "subscribeUrl", "getSubscribeUrl", "subscribeUrl$delegate", "templateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIds", "()Ljava/util/ArrayList;", "templateIds$delegate", "configNavigationBar", "", "configStatusBar", "doRequest", "finishSelf", "delayed", "finishUIWithResult", "errCode", "errMsg", "data", "Landroid/os/Bundle;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onResume", "onUserCancel", "setFullScreen", "showProgressDialog", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubscribeMsgRequestProxyUI
  extends MMActivity
{
  public static final SubscribeMsgRequestProxyUI.a pms;
  private w lKp;
  private final j pmA;
  private final j pmB;
  private final j pmC;
  private final j pmD;
  private final j pmE;
  private final j pmF;
  private final i pmG;
  private n pmt;
  private g pmu;
  private a.b pmv;
  private int pmw;
  private final j pmx;
  private final j pmy;
  private final j pmz;
  
  static
  {
    AppMethodBeat.i(149802);
    pms = new SubscribeMsgRequestProxyUI.a((byte)0);
    AppMethodBeat.o(149802);
  }
  
  public SubscribeMsgRequestProxyUI()
  {
    AppMethodBeat.i(149810);
    this.pmx = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.pmy = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.pmz = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.pmA = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.pmB = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.pmC = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.pmD = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.pmE = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.pmF = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.pmG = new i(this);
    AppMethodBeat.o(149810);
  }
  
  private static final void a(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
  {
    AppMethodBeat.i(236667);
    s.u(paramSubscribeMsgRequestProxyUI, "this$0");
    paramSubscribeMsgRequestProxyUI.finish();
    AppMethodBeat.o(236667);
  }
  
  private final String bQk()
  {
    AppMethodBeat.i(149803);
    String str = (String)this.pmy.getValue();
    AppMethodBeat.o(149803);
    return str;
  }
  
  private final String bQl()
  {
    AppMethodBeat.i(236629);
    String str = (String)this.pmz.getValue();
    AppMethodBeat.o(236629);
    return str;
  }
  
  private final int bQm()
  {
    AppMethodBeat.i(149804);
    int i = ((Number)this.pmA.getValue()).intValue();
    AppMethodBeat.o(149804);
    return i;
  }
  
  private final boolean bQn()
  {
    AppMethodBeat.i(236642);
    boolean bool = ((Boolean)this.pmE.getValue()).booleanValue();
    AppMethodBeat.o(236642);
    return bool;
  }
  
  private final String bQo()
  {
    AppMethodBeat.i(236647);
    String str = (String)this.pmF.getValue();
    AppMethodBeat.o(236647);
    return str;
  }
  
  private final int getScene()
  {
    AppMethodBeat.i(236623);
    int i = ((Number)this.pmx.getValue()).intValue();
    AppMethodBeat.o(236623);
    return i;
  }
  
  private final void hA(boolean paramBoolean)
  {
    AppMethodBeat.i(236660);
    a(this, 10005, "user cancel", paramBoolean, null, 8);
    AppMethodBeat.o(236660);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149809);
    Log.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onBackPressed currentAction: %d", new Object[] { Integer.valueOf(this.pmw) });
    Object localObject;
    if (com.tencent.mm.msgsubscription.b.a.a.xo(this.pmw))
    {
      localObject = this.lKp;
      if (localObject != null) {
        ((w)localObject).dismiss();
      }
      hA(false);
      AppMethodBeat.o(149809);
      return;
    }
    if (com.tencent.mm.msgsubscription.b.a.a.xp(this.pmw))
    {
      localObject = this.pmu;
      if (localObject != null)
      {
        ((g)localObject).onBackPressed();
        AppMethodBeat.o(149809);
      }
    }
    else
    {
      hA(false);
    }
    AppMethodBeat.o(149809);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149805);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.lKp = com.tencent.mm.ui.base.k.a((Context)this, getResources().getString(c.h.loading), false, null);
    Object localObject1;
    if (getScene() == 1)
    {
      paramBundle = getContext();
      s.s(paramBundle, "context");
      paramBundle = new a.b((Context)paramBundle, bQm(), bQk(), bQl(), (String)this.pmC.getValue(), (String)this.pmD.getValue(), bQo(), (a.a)this.pmG);
      this.pmv = paramBundle;
      paramBundle = this.pmv;
      if (paramBundle != null)
      {
        paramBundle.lCR = getScene();
        if (!com.tencent.mm.msgsubscription.b.a.a.xo(bQm())) {
          break label288;
        }
        localObject1 = com.tencent.mm.msgsubscription.b.a.a.pji;
        com.tencent.mm.msgsubscription.b.a.a.a(paramBundle);
      }
    }
    for (;;)
    {
      this.pmw = bQm();
      AppMethodBeat.o(149805);
      return;
      if (getScene() == 2)
      {
        paramBundle = getContext();
        s.s(paramBundle, "context");
        paramBundle = (Context)paramBundle;
        int i = bQm();
        localObject1 = bQl();
        Object localObject2 = this.pmB.getValue();
        s.s(localObject2, "<get-templateIds>(...)");
        paramBundle = new a.b(paramBundle, i, (String)localObject1, (ArrayList)localObject2, bQo(), (a.a)this.pmG);
        break;
      }
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", s.X("alvinluo requestSubscribeMessage scene invalid: ", Integer.valueOf(getScene())));
      paramBundle = null;
      break;
      label288:
      if (com.tencent.mm.msgsubscription.b.a.a.xp(bQm()))
      {
        localObject1 = com.tencent.mm.msgsubscription.b.a.a.pji;
        com.tencent.mm.msgsubscription.b.a.a.b(paramBundle);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(236719);
    super.onDestroy();
    Object localObject = this.lKp;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    localObject = this.pmv;
    if (localObject != null)
    {
      Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo release");
      e locale = ((a.b)localObject).pjp;
      if (locale != null) {
        locale.dismiss();
      }
      localObject = ((a.b)localObject).pjq;
      if (localObject != null) {
        ((f)localObject).dismiss();
      }
    }
    AppMethodBeat.o(236719);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149806);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(c.b.transparent));
    }
    setNavigationbarColor(getResources().getColor(c.b.BG_1));
    AppMethodBeat.o(149806);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    b(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    d(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<String>
  {
    e(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<String>
  {
    f(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    g(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Integer>
  {
    h(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements a.a
  {
    i(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI) {}
    
    public final void a(n paramn, g paramg)
    {
      AppMethodBeat.i(236621);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onShowDialog");
      SubscribeMsgRequestProxyUI.a(this.pmH, paramn);
      SubscribeMsgRequestProxyUI.a(this.pmH, paramg);
      AppMethodBeat.o(236621);
    }
    
    public final void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236650);
      s.u(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onGetSubscribeListSuccess bizUsername: %s, %d, showDialog: %b", new Object[] { SubscribeMsgRequestProxyUI.c(this.pmH), Integer.valueOf(paramSubscribeMsgRequestResult.phC.size()), Boolean.valueOf(paramBoolean) });
      paramSubscribeMsgRequestResult = SubscribeMsgRequestProxyUI.b(this.pmH);
      if (paramSubscribeMsgRequestResult != null) {
        paramSubscribeMsgRequestResult.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.pmH, com.tencent.mm.msgsubscription.b.a.a.xn(SubscribeMsgRequestProxyUI.d(this.pmH)));
      if ((SubscribeMsgRequestProxyUI.e(this.pmH) == 1) || (!paramBoolean)) {
        SubscribeMsgRequestProxyUI.a(this.pmH, 0, "", false, null, 12);
      }
      AppMethodBeat.o(236650);
    }
    
    public final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236662);
      s.u(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onSubscribeMsgSuccess bizUsername: %s, %d", new Object[] { SubscribeMsgRequestProxyUI.c(this.pmH), Integer.valueOf(paramSubscribeMsgRequestResult.phC.size()) });
      SubscribeMsgRequestProxyUI.a(this.pmH, com.tencent.mm.msgsubscription.b.a.a.xn(SubscribeMsgRequestProxyUI.d(this.pmH)));
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("key_result_data", paramSubscribeMsgRequestResult.phC);
      localBundle.putString("key_result_ext_data", paramSubscribeMsgRequestResult.extData);
      SubscribeMsgRequestProxyUI.a(this.pmH, 0, "", false, localBundle, 4);
      AppMethodBeat.o(236662);
    }
    
    public final void bPZ()
    {
      AppMethodBeat.i(236626);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onDismissDialog");
      SubscribeMsgRequestProxyUI.a(this.pmH, null);
      AppMethodBeat.o(236626);
    }
    
    public final void bQa()
    {
      AppMethodBeat.i(236635);
      w localw = SubscribeMsgRequestProxyUI.b(this.pmH);
      if (localw != null) {
        localw.dismiss();
      }
      AppMethodBeat.o(236635);
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(236671);
      s.u(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onError bizUsername: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { SubscribeMsgRequestProxyUI.c(this.pmH), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      w localw = SubscribeMsgRequestProxyUI.b(this.pmH);
      if (localw != null) {
        localw.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.pmH, paramInt2, paramString, true, null, 8);
      AppMethodBeat.o(236671);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(236684);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onCancel");
      SubscribeMsgRequestProxyUI.f(this.pmH);
      AppMethodBeat.o(236684);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<String>
  {
    j(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ArrayList<String>>
  {
    k(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestProxyUI
 * JD-Core Version:    0.7.0.1
 */