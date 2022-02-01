package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.storage.b;
import com.tencent.mm.msgsubscription.storage.b.a;
import com.tencent.mm.msgsubscription.storage.b.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.f;
import d.g;
import d.g.b.ad;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;

@i
@com.tencent.mm.ui.base.a(7)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "action", "", "getAction", "()I", "action$delegate", "Lkotlin/Lazy;", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "bizUsername$delegate", "content", "getContent", "content$delegate", "currentAction", "mDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "subscribeUrl", "getSubscribeUrl", "subscribeUrl$delegate", "doRequest", "", "finishSelf", "delayed", "", "getLayoutId", "nextAction", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setFullScreen", "setStatusBarTransparent", "showProgressDialog", "Companion", "plugin-comm_release"})
public final class SubscribeMsgRequestProxyUI
  extends MMActivity
{
  public static final SubscribeMsgRequestProxyUI.a iGO;
  private com.tencent.mm.ui.base.p fSP;
  private k iGH;
  private e iGI;
  private int iGJ;
  private final f iGK;
  private final f iGL;
  private final f iGM;
  private final f iGN;
  
  static
  {
    AppMethodBeat.i(149802);
    iGO = new SubscribeMsgRequestProxyUI.a((byte)0);
    AppMethodBeat.o(149802);
  }
  
  public SubscribeMsgRequestProxyUI()
  {
    AppMethodBeat.i(149810);
    this.iGK = g.O((d.g.a.a)new c(this));
    this.iGL = g.O((d.g.a.a)new b(this));
    this.iGM = g.O((d.g.a.a)new g(this));
    this.iGN = g.O((d.g.a.a)new d(this));
    AppMethodBeat.o(149810);
  }
  
  private final String aOU()
  {
    AppMethodBeat.i(149803);
    String str = (String)this.iGK.getValue();
    AppMethodBeat.o(149803);
    return str;
  }
  
  private final void fj(boolean paramBoolean)
  {
    AppMethodBeat.i(149807);
    com.tencent.mm.ui.base.p localp = this.fSP;
    if (localp != null) {
      localp.dismiss();
    }
    if (paramBoolean)
    {
      getContentView().postDelayed((Runnable)new f(this), 300L);
      AppMethodBeat.o(149807);
      return;
    }
    super.finish();
    AppMethodBeat.o(149807);
  }
  
  private final int getAction()
  {
    AppMethodBeat.i(149804);
    int i = ((Number)this.iGL.getValue()).intValue();
    AppMethodBeat.o(149804);
    return i;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149809);
    ae.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onBackPressed currentAction: %d", new Object[] { Integer.valueOf(this.iGJ) });
    if (this.iGJ == 1)
    {
      e locale = this.iGI;
      if (locale != null)
      {
        locale.onBackPressed();
        AppMethodBeat.o(149809);
        return;
      }
      AppMethodBeat.o(149809);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(149809);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149805);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    d.g.b.p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    d.g.b.p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    this.fSP = h.b((Context)this, getResources().getString(2131760706), false, null);
    paramBundle = getContext();
    d.g.b.p.g(paramBundle, "context");
    paramBundle = new b.b((Context)paramBundle, getAction(), aOU(), (String)this.iGM.getValue(), (String)this.iGN.getValue(), (b.a)new e(this));
    if (getAction() == 3) {
      this.iGJ = 1;
    }
    b localb = b.iEm;
    b.a(paramBundle);
    AppMethodBeat.o(149805);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149806);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      d.g.b.p.g(localWindow, "window");
      localWindow.setStatusBarColor(getResources().getColor(2131101053));
    }
    AppMethodBeat.o(149806);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Integer>
  {
    b(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<String>
  {
    c(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<String>
  {
    d(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$doRequest$requestTask$1", "Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errType", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
  public static final class e
    implements b.a
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(149798);
      d.g.b.p.h(paramString, "errMsg");
      ae.e("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onError bizUsername: %s, action: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { SubscribeMsgRequestProxyUI.c(this.iGP), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      paramString = (Context)this.iGP.getContext();
      Object localObject = ad.Njc;
      localObject = this.iGP.getString(2131764318);
      d.g.b.p.g(localObject, "getString(R.string.subscribe_msg_common_failed)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt3) }, 1));
      d.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
      Toast.makeText(paramString, (CharSequence)localObject, 0).show();
      paramString = SubscribeMsgRequestProxyUI.b(this.iGP);
      if (paramString != null) {
        paramString.dismiss();
      }
      SubscribeMsgRequestProxyUI.a(this.iGP);
      AppMethodBeat.o(149798);
    }
    
    public final void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149797);
      d.g.b.p.h(paramSubscribeMsgRequestResult, "result");
      ae.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onSubscribeMsgSuccess bizUsername: %s, %d", new Object[] { SubscribeMsgRequestProxyUI.c(this.iGP), Integer.valueOf(paramSubscribeMsgRequestResult.iCV.size()) });
      SubscribeMsgRequestProxyUI.d(this.iGP);
      SubscribeMsgRequestProxyUI.a(this.iGP);
      AppMethodBeat.o(149797);
    }
    
    public final void a(k paramk, e parame)
    {
      AppMethodBeat.i(149793);
      ae.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onShowDialog");
      SubscribeMsgRequestProxyUI.a(this.iGP, paramk);
      SubscribeMsgRequestProxyUI.a(this.iGP, parame);
      AppMethodBeat.o(149793);
    }
    
    public final void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(149796);
      d.g.b.p.h(paramSubscribeMsgRequestResult, "result");
      ae.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onGetSubscribeListSuccess bizUsername: %s, %d, showDialog: %b", new Object[] { SubscribeMsgRequestProxyUI.c(this.iGP), Integer.valueOf(paramSubscribeMsgRequestResult.iCV.size()), Boolean.valueOf(paramBoolean) });
      paramSubscribeMsgRequestResult = SubscribeMsgRequestProxyUI.b(this.iGP);
      if (paramSubscribeMsgRequestResult != null) {
        paramSubscribeMsgRequestResult.dismiss();
      }
      SubscribeMsgRequestProxyUI.d(this.iGP);
      if ((SubscribeMsgRequestProxyUI.e(this.iGP) == 1) || (!paramBoolean)) {
        SubscribeMsgRequestProxyUI.a(this.iGP);
      }
      AppMethodBeat.o(149796);
    }
    
    public final void aOO()
    {
      AppMethodBeat.i(149794);
      ae.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onDismissDialog");
      SubscribeMsgRequestProxyUI.a(this.iGP, null);
      AppMethodBeat.o(149794);
    }
    
    public final void aOP()
    {
      AppMethodBeat.i(149795);
      com.tencent.mm.ui.base.p localp = SubscribeMsgRequestProxyUI.b(this.iGP);
      if (localp != null)
      {
        localp.dismiss();
        AppMethodBeat.o(149795);
        return;
      }
      AppMethodBeat.o(149795);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(149799);
      ae.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onCancel");
      SubscribeMsgRequestProxyUI.f(this.iGP);
      AppMethodBeat.o(149799);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149800);
      SubscribeMsgRequestProxyUI.g(this.iGP);
      AppMethodBeat.o(149800);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<String>
  {
    g(SubscribeMsgRequestProxyUI paramSubscribeMsgRequestProxyUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestProxyUI
 * JD-Core Version:    0.7.0.1
 */