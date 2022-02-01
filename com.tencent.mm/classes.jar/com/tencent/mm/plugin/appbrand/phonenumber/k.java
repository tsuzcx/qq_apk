package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.g.z;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.permission.g.a;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "candidateMinHeight", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "maxHeight", "minHeight", "rootView", "titleTv", "applyStyleByRotation", "", "calculateMaxHeight", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "onShown", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements com.tencent.mm.plugin.appbrand.permission.g, n
{
  private static final k.a tGD;
  private final String content;
  private final Context context;
  private int maxHeight;
  private final TextView noc;
  private int plU;
  private r rIV;
  private final int rIW;
  private final View rIZ;
  private final ImageView rJa;
  private final View rootView;
  private final aj tGE;
  private final boolean tGF;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(318941);
    tGD = new k.a((byte)0);
    AppMethodBeat.o(318941);
  }
  
  public k(aj paramaj, String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(318899);
    this.tGE = paramaj;
    this.content = paramString;
    this.context = paramContext;
    this.tGF = paramBoolean;
    this.rIW = kotlin.k.k.qu(bd.fromDPToPix(this.context, 360), paramInt);
    this.maxHeight = cHu();
    if (this.tGE == null) {
      Log.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.plU = 2;
    paramaj = View.inflate(this.context, a.e.app_brand_phone_number_explain_dialog, null);
    s.s(paramaj, "inflate(context, R.layou…ber_explain_dialog, null)");
    this.rootView = paramaj;
    paramaj = this.rootView.findViewById(a.d.phone_number_explain_content);
    s.s(paramaj, "rootView.findViewById(R.…e_number_explain_content)");
    this.rIZ = paramaj;
    this.rIZ.setMinimumHeight(this.rIW);
    this.rIZ.addOnLayoutChangeListener(new k..ExternalSyntheticLambda1(this));
    paramaj = this.rootView.findViewById(a.d.phone_number_explain_dialog_back);
    s.s(paramaj, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.rJa = ((ImageView)paramaj);
    paramaj = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.rJa, null, null, false, null, Integer.valueOf(17), Integer.valueOf(a.b.Edge_1_5_A), 3838);
    paramaj = this.rJa;
    if (paramaj != null) {
      paramaj.setOnClickListener(new k..ExternalSyntheticLambda0(this));
    }
    paramaj = this.rootView.findViewById(a.d.phone_number_explain_dialog_title);
    s.s(paramaj, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramaj);
    this.titleTv.setText(this.rootView.getContext().getText(a.g.appbrand_permission_authorize_explain_title));
    paramaj = this.rootView.findViewById(a.d.phone_number_explain_dialog_content);
    s.s(paramaj, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.noc = ((TextView)paramaj);
    this.noc.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(this.content, false, new k..ExternalSyntheticLambda2(this)));
    this.noc.setMovementMethod(LinkMovementMethod.getInstance());
    this.noc.setLinkTextColor(Color.parseColor("#FF576B95"));
    z.T((View)this.noc);
    AppMethodBeat.o(318899);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(318924);
    s.u(paramk, "this$0");
    paramk.rIZ.getLayoutParams().height = paramk.maxHeight;
    AppMethodBeat.o(318924);
  }
  
  private static final void a(k paramk, View paramView)
  {
    AppMethodBeat.i(318930);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramk, "this$0");
    paramView = paramk.rIV;
    if (paramView != null) {
      paramView.c((n)paramk);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318930);
  }
  
  private static final void a(k paramk, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(318926);
    s.u(paramk, "this$0");
    if ((Math.abs(paramInt4 - paramInt2) > paramk.maxHeight) && (paramk.maxHeight >= paramk.rIW)) {
      paramk.rIZ.post(new k..ExternalSyntheticLambda3(paramk));
    }
    AppMethodBeat.o(318926);
  }
  
  private static final void a(k paramk, String paramString)
  {
    AppMethodBeat.i(318935);
    s.u(paramk, "this$0");
    aj localaj = paramk.tGE;
    if (localaj != null) {
      localaj.a(paramk.context, paramString, "", null);
    }
    AppMethodBeat.o(318935);
  }
  
  private final void cHt()
  {
    AppMethodBeat.i(318911);
    Object localObject1 = this.context.getSystemService("window");
    if ((localObject1 instanceof WindowManager)) {}
    for (localObject1 = (WindowManager)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = t.uFu;
        localObject2 = this.rootView.getContext();
        s.s(localObject2, "contentView.context");
        t.a((Context)localObject2, this.rootView, null, ((WindowManager)localObject1).getDefaultDisplay().getRotation(), this.tGF);
      }
      AppMethodBeat.o(318911);
      return;
    }
  }
  
  private final int cHu()
  {
    AppMethodBeat.i(318918);
    int i = this.context.getResources().getDisplayMetrics().heightPixels;
    if (2 == this.context.getResources().getConfiguration().orientation) {}
    for (i = (int)(i * 1.0F);; i = (int)(i * 0.75F))
    {
      Log.i("Luggage.FULL.DialogExplainDialog", s.X("calculateMaxHeight, maxHeight: ", Integer.valueOf(i)));
      AppMethodBeat.o(318918);
      return i;
    }
  }
  
  private r j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318920);
    paramg = g.a.a((com.tencent.mm.plugin.appbrand.permission.g)this, paramg);
    AppMethodBeat.o(318920);
    return paramg;
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(319003);
    this.rIV = paramr;
    cHt();
    AppMethodBeat.o(319003);
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh()
  {
    AppMethodBeat.i(319008);
    com.tencent.mm.plugin.appbrand.widget.a.a.dQ(this.rootView);
    AppMethodBeat.o(319008);
  }
  
  public final boolean bQi()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(318981);
    r localr = this.rIV;
    if (localr != null) {
      localr.c((n)this);
    }
    AppMethodBeat.o(318981);
  }
  
  public final View getContentView()
  {
    return this.rootView;
  }
  
  public final int getPosition()
  {
    return this.plU;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318975);
    s.u(paramg, "component");
    setPosition(this.plU);
    j(paramg).b((n)this);
    AppMethodBeat.o(318975);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318979);
    s.u(paramg, "component");
    j(paramg).c((n)this);
    AppMethodBeat.o(318979);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(318986);
    this.plU = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(318986);
      return;
      this.rootView.setBackground(androidx.core.content.a.m(this.context, a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(318986);
      return;
      this.rootView.setBackground(androidx.core.content.a.m(this.context, a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(319018);
    cHt();
    this.maxHeight = cHu();
    AppMethodBeat.o(319018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */