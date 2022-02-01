package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.b.a.a.a;
import com.tencent.mm.msgsubscription.b.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@i
@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "action", "", "getAction", "()I", "action$delegate", "Lkotlin/Lazy;", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "bizAppId$delegate", "bizUsername", "getBizUsername", "bizUsername$delegate", "content", "getContent", "content$delegate", "currentAction", "extInfo", "getExtInfo", "extInfo$delegate", "mDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRequestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "needResult", "", "getNeedResult", "()Z", "needResult$delegate", "scene", "getScene", "scene$delegate", "subscribeMsgRequestCallback", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1;", "subscribeUrl", "getSubscribeUrl", "subscribeUrl$delegate", "templateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIds", "()Ljava/util/ArrayList;", "templateIds$delegate", "configNavigationBar", "", "configStatusBar", "doRequest", "finishSelf", "delayed", "finishUIWithResult", "errCode", "errMsg", "data", "Landroid/os/Bundle;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onResume", "onUserCancel", "setFullScreen", "showProgressDialog", "Companion", "plugin-comm_release"})
public final class SubscribeMsgRequestProxyUI
  extends MMActivity
{
  public static final SubscribeMsgRequestProxyUI.a jCX;
  private HashMap _$_findViewCache;
  private com.tencent.mm.ui.base.q gxX;
  private k jCJ;
  private e jCK;
  private a.b jCL;
  private int jCM;
  private final f jCN;
  private final f jCO;
  private final f jCP;
  private final f jCQ;
  private final f jCR;
  private final f jCS;
  private final f jCT;
  private final f jCU;
  private final f jCV;
  private final j jCW;
  
  static
  {
    AppMethodBeat.i(149802);
    jCX = new SubscribeMsgRequestProxyUI.a((byte)0);
    AppMethodBeat.o(149802);
  }
  
  public SubscribeMsgRequestProxyUI()
  {
    AppMethodBeat.i(149810);
    this.jCN = g.ah((kotlin.g.a.a)new i(this));
    this.jCO = g.ah((kotlin.g.a.a)new d(this));
    this.jCP = g.ah((kotlin.g.a.a)new c(this));
    this.jCQ = g.ah((kotlin.g.a.a)new b(this));
    this.jCR = g.ah((kotlin.g.a.a)new l(this));
    this.jCS = g.ah((kotlin.g.a.a)new k(this));
    this.jCT = g.ah((kotlin.g.a.a)new e(this));
    this.jCU = g.ah((kotlin.g.a.a)new h(this));
    this.jCV = g.ah((kotlin.g.a.a)new f(this));
    this.jCW = new j(this);
    AppMethodBeat.o(149810);
  }
  
  private final String bjd()
  {
    AppMethodBeat.i(149803);
    String str = (String)this.jCO.getValue();
    AppMethodBeat.o(149803);
    return str;
  }
  
  private final String bje()
  {
    AppMethodBeat.i(223430);
    String str = (String)this.jCP.getValue();
    AppMethodBeat.o(223430);
    return str;
  }
  
  private final boolean bjf()
  {
    AppMethodBeat.i(223431);
    boolean bool = ((Boolean)this.jCU.getValue()).booleanValue();
    AppMethodBeat.o(223431);
    return bool;
  }
  
  private final String bjg()
  {
    AppMethodBeat.i(223432);
    String str = (String)this.jCV.getValue();
    AppMethodBeat.o(223432);
    return str;
  }
  
  private final void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(223434);
    a(this, 10005, "user cancel", false, null, 8);
    AppMethodBeat.o(223434);
  }
  
  private final int getAction()
  {
    AppMethodBeat.i(149804);
    int i = ((Number)this.jCQ.getValue()).intValue();
    AppMethodBeat.o(149804);
    return i;
  }
  
  private final int getScene()
  {
    AppMethodBeat.i(223429);
    int i = ((Number)this.jCN.getValue()).intValue();
    AppMethodBeat.o(223429);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(223437);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(223437);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(223436);
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
    AppMethodBeat.o(223436);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149809);
    Log.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onBackPressed currentAction: %d", new Object[] { Integer.valueOf(this.jCM) });
    Object localObject;
    if (com.tencent.mm.msgsubscription.b.a.a.uo(this.jCM))
    {
      localObject = this.gxX;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.q)localObject).dismiss();
      }
      gb(false);
      AppMethodBeat.o(149809);
      return;
    }
    if (com.tencent.mm.msgsubscription.b.a.a.up(this.jCM))
    {
      localObject = this.jCK;
      if (localObject != null)
      {
        ((e)localObject).onBackPressed();
        AppMethodBeat.o(149809);
        return;
      }
      AppMethodBeat.o(149809);
      return;
    }
    gb(false);
    AppMethodBeat.o(149809);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149805);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    this.gxX = h.a((Context)this, getResources().getString(2131762443), false, null);
    com.tencent.mm.msgsubscription.b.a.a locala;
    if (getScene() == 1)
    {
      paramBundle = getContext();
      p.g(paramBundle, "context");
      paramBundle = new a.b((Context)paramBundle, getAction(), bjd(), bje(), (String)this.jCS.getValue(), (String)this.jCT.getValue(), bjg(), (a.a)this.jCW);
      this.jCL = paramBundle;
      paramBundle = this.jCL;
      if (paramBundle != null)
      {
        paramBundle.gwE = getScene();
        if (!com.tencent.mm.msgsubscription.b.a.a.uo(getAction())) {
          break label295;
        }
        locala = com.tencent.mm.msgsubscription.b.a.a.jzQ;
        com.tencent.mm.msgsubscription.b.a.a.a(paramBundle);
      }
    }
    for (;;)
    {
      this.jCM = getAction();
      AppMethodBeat.o(149805);
      return;
      if (getScene() == 2)
      {
        paramBundle = getContext();
        p.g(paramBundle, "context");
        paramBundle = new a.b((Context)paramBundle, getAction(), bje(), (ArrayList)this.jCR.getValue(), bjg(), (a.a)this.jCW);
        break;
      }
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo requestSubscribeMessage scene invalid: " + getScene());
      paramBundle = null;
      break;
      label295:
      if (com.tencent.mm.msgsubscription.b.a.a.up(getAction()))
      {
        locala = com.tencent.mm.msgsubscription.b.a.a.jzQ;
        com.tencent.mm.msgsubscription.b.a.a.b(paramBundle);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(223435);
    super.onDestroy();
    Object localObject = this.gxX;
    if (localObject != null) {
      ((com.tencent.mm.ui.base.q)localObject).dismiss();
    }
    localObject = this.jCL;
    if (localObject != null)
    {
      Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo release");
      d locald = ((a.b)localObject).jzT;
      if (locald != null) {
        locald.dismiss();
      }
      localObject = ((a.b)localObject).jzU;
      if (localObject != null)
      {
        ((b)localObject).dismiss();
        AppMethodBeat.o(223435);
        return;
      }
      AppMethodBeat.o(223435);
      return;
    }
    AppMethodBeat.o(223435);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149806);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      p.g(localWindow, "window");
      localWindow.setStatusBarColor(getResources().getColor(2131101287));
    }
    setNavigationbarColor(getResources().getColor(2131099649));
    AppMethodBeat.o(149806);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    b(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    c(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    d(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    e(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    f(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149800);
      SubscribeMsgRequestProxyUI.a(this.jCY);
      AppMethodBeat.o(149800);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    h(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    i(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
  public static final class j
    implements a.a
  {
    public final void a(k paramk, e parame)
    {
      AppMethodBeat.i(223422);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onShowDialog");
      SubscribeMsgRequestProxyUI.a(this.jCY, paramk);
      SubscribeMsgRequestProxyUI.a(this.jCY, parame);
      AppMethodBeat.o(223422);
    }
    
    public final void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223425);
      p.h(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onGetSubscribeListSuccess bizUsername: %s, %d, showDialog: %b", new Object[] { SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(paramSubscribeMsgRequestResult.jyk.size()), Boolean.valueOf(paramBoolean) });
      paramSubscribeMsgRequestResult = SubscribeMsgRequestProxyUI.b(this.jCY);
      if (paramSubscribeMsgRequestResult != null) {
        paramSubscribeMsgRequestResult.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.jCY, com.tencent.mm.msgsubscription.b.a.a.un(SubscribeMsgRequestProxyUI.d(this.jCY)));
      if ((SubscribeMsgRequestProxyUI.e(this.jCY) == 1) || (!paramBoolean)) {
        SubscribeMsgRequestProxyUI.a(this.jCY, 0, "", false, null, 12);
      }
      AppMethodBeat.o(223425);
    }
    
    public final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223426);
      p.h(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onSubscribeMsgSuccess bizUsername: %s, %d", new Object[] { SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(paramSubscribeMsgRequestResult.jyk.size()) });
      SubscribeMsgRequestProxyUI.a(this.jCY, com.tencent.mm.msgsubscription.b.a.a.un(SubscribeMsgRequestProxyUI.d(this.jCY)));
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("key_result_data", paramSubscribeMsgRequestResult.jyk);
      localBundle.putString("key_result_ext_data", paramSubscribeMsgRequestResult.extData);
      SubscribeMsgRequestProxyUI.a(this.jCY, 0, "", false, localBundle, 4);
      AppMethodBeat.o(223426);
    }
    
    public final void biV()
    {
      AppMethodBeat.i(223423);
      Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onDismissDialog");
      SubscribeMsgRequestProxyUI.a(this.jCY, null);
      AppMethodBeat.o(223423);
    }
    
    public final void biW()
    {
      AppMethodBeat.i(223424);
      com.tencent.mm.ui.base.q localq = SubscribeMsgRequestProxyUI.b(this.jCY);
      if (localq != null)
      {
        localq.dismiss();
        AppMethodBeat.o(223424);
        return;
      }
      AppMethodBeat.o(223424);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(223427);
      p.h(paramString, "errMsg");
      Log.e("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onError bizUsername: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.q localq = SubscribeMsgRequestProxyUI.b(this.jCY);
      if (localq != null) {
        localq.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.jCY, paramInt2, paramString, true, null, 8);
      AppMethodBeat.o(223427);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    k(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends kotlin.g.b.q
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