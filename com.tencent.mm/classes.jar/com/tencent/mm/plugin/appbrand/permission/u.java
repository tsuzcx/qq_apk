package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.luggage.m.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.permission.a.b.d.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "scopeProvider", "Lcom/tencent/mm/plugin/appbrand/permission/ScopeProvider;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;ZLcom/tencent/mm/plugin/appbrand/permission/ScopeProvider;)V", "acceptInFgBtn", "Landroid/widget/Button;", "alwaysAcceptBtn", "rejectBtn", "threeBtnGroup", "Landroid/view/ViewGroup;", "setSelectListItem", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends d
{
  private final t tEQ;
  private final ViewGroup tER;
  private final Button tES;
  private final Button tET;
  private final Button tEU;
  private final b.d tgX;
  
  public u(Context paramContext, b.d paramd, boolean paramBoolean, t paramt)
  {
    super(paramContext, paramd, paramBoolean);
    AppMethodBeat.i(318731);
    this.tgX = paramd;
    this.tEQ = paramt;
    this.tER = ((ViewGroup)cHe().findViewById(a.d.three_button_group));
    this.tES = ((Button)cHe().findViewById(a.d.accept_in_foreground));
    this.tET = ((Button)cHe().findViewById(a.d.always_accept));
    this.tEU = ((Button)cHe().findViewById(a.d.reject));
    paramContext = (CharSequence)this.tEQ.cGW();
    if ((paramContext == null) || (paramContext.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      cPN().setVisibility(0);
      paramContext = this.tER;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      cPL().setOnClickListener(new u..ExternalSyntheticLambda1(this));
      cPM().setOnClickListener(new u..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(318731);
      return;
    }
    cPN().setVisibility(8);
    paramContext = this.tER;
    if (paramContext != null) {
      paramContext.setVisibility(0);
    }
    paramContext = this.tES;
    if (paramContext != null) {
      paramContext.setOnClickListener(new u..ExternalSyntheticLambda3(this));
    }
    paramContext = this.tET;
    if (paramContext != null) {
      paramContext.setOnClickListener(new u..ExternalSyntheticLambda0(this));
    }
    paramContext = this.tEU;
    if (paramContext != null) {
      paramContext.setOnClickListener(new u..ExternalSyntheticLambda4(this));
    }
    AppMethodBeat.o(318731);
  }
  
  private static final void a(u paramu, View paramView)
  {
    AppMethodBeat.i(318736);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    if (!paramu.cPQ())
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318736);
      return;
    }
    paramu.tgX.a(1, p.al(new String[] { paramu.tEQ.cGV() }), 0, paramu.cPO().cPS());
    paramView = paramu.cPP();
    if (paramView != null) {
      paramView.c((n)paramu);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318736);
  }
  
  private static final void b(u paramu, View paramView)
  {
    AppMethodBeat.i(318740);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    if (!paramu.cPQ())
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318740);
      return;
    }
    b.d.a.a(paramu.tgX, 2, p.al(new String[] { paramu.tEQ.cGV() }));
    paramView = paramu.cPP();
    if (paramView != null) {
      paramView.c((n)paramu);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318740);
  }
  
  private static final void c(u paramu, View paramView)
  {
    AppMethodBeat.i(318752);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    if (!paramu.cPQ())
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318752);
      return;
    }
    paramu.tgX.a(1, p.al(new String[] { paramu.tEQ.cGV() }), 0, paramu.cPO().cPS());
    paramView = paramu.cPP();
    if (paramView != null) {
      paramView.c((n)paramu);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318752);
  }
  
  private static final void d(u paramu, View paramView)
  {
    AppMethodBeat.i(318761);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    if (!paramu.cPQ())
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318761);
      return;
    }
    paramView = paramu.tgX;
    localObject = paramu.tEQ.cGW();
    s.checkNotNull(localObject);
    paramView.a(1, p.al(new String[] { localObject }), 0, paramu.cPO().cPS());
    paramView = paramu.cPP();
    if (paramView != null) {
      paramView.c((n)paramu);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318761);
  }
  
  private static final void e(u paramu, View paramView)
  {
    AppMethodBeat.i(318767);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    if (!paramu.cPQ())
    {
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318767);
      return;
    }
    paramView = paramu.tgX;
    localObject = paramu.tEQ.cGW();
    s.checkNotNull(localObject);
    b.d.a.a(paramView, 2, p.al(new String[] { localObject }));
    paramView = paramu.cPP();
    if (paramView != null) {
      paramView.c((n)paramu);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/permission/ThreeStateAuthorizePromptPresenterView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318767);
  }
  
  public final void setSelectListItem(List<k.a> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.u
 * JD-Core Version:    0.7.0.1
 */