package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.g.z;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAuthorizeUserAgreementComponent;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "externalToolsHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/UserAgreementCheckedAlertListener;", "userAgreementCb", "Landroid/widget/CheckBox;", "userAgreementCbClickArea", "userAgreementEnable", "", "userAgreementLayout", "userAgreementTv", "Landroid/widget/TextView;", "ensureUserAgreementLayoutVisible", "", "findViewById", "T", "id", "", "(I)Landroid/view/View;", "isUserUserAgreementChecked", "isUserUserAgreementVisible", "setIExternalToolsHelper", "setUserAgreementCheckBoxWording", "wording", "", "setUserAgreementCheckedAlertListener", "shakeUserAgreementLayout", "userAgreementChecked", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements q
{
  private final Context context;
  private View uBT;
  private TextView uBU;
  private CheckBox uBV;
  private View uBW;
  private aj uBX;
  private boolean uBY;
  private u uBZ;
  private final View view;
  
  public e(Context paramContext, View paramView)
  {
    AppMethodBeat.i(324684);
    this.context = paramContext;
    this.view = paramView;
    this.uBT = findViewById(a.d.user_agreement_layout);
    this.uBU = ((TextView)findViewById(a.d.user_agreement_desc_tv));
    this.uBV = ((CheckBox)findViewById(a.d.user_agreement_cb));
    this.uBW = findViewById(a.d.user_agreement_cb_click_area);
    this.uBT.setOnClickListener(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(324684);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(324696);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    paramView = parame.uBV;
    if (!parame.uBV.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(324696);
      return;
    }
  }
  
  private static final void a(e parame, String paramString)
  {
    AppMethodBeat.i(324700);
    s.u(parame, "this$0");
    aj localaj = parame.uBX;
    if (localaj != null) {
      localaj.a(parame.context, paramString, "", null);
    }
    AppMethodBeat.o(324700);
  }
  
  private void cPT()
  {
    AppMethodBeat.i(324688);
    int i = this.context.getResources().getDimensionPixelOffset(a.b.Edge_A);
    Object localObject = ObjectAnimator.ofFloat(this.view, "translationX", new float[] { 0.0F, -i, i, -i, 0.0F }).setDuration(300L);
    s.s(localObject, "ofFloat(\n            vie…       ).setDuration(300)");
    ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ObjectAnimator)localObject).start();
    localObject = MMApplicationContext.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(324688);
      throw ((Throwable)localObject);
    }
    ((Vibrator)localObject).vibrate(100L);
    AppMethodBeat.o(324688);
  }
  
  private <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(324692);
    View localView = this.view.findViewById(paramInt);
    AppMethodBeat.o(324692);
    return localView;
  }
  
  public final boolean cBy()
  {
    AppMethodBeat.i(324726);
    if ((this.uBY) && (!this.uBV.isChecked()))
    {
      cPT();
      u localu = this.uBZ;
      if (localu != null) {
        localu.onAlert();
      }
      AppMethodBeat.o(324726);
      return false;
    }
    AppMethodBeat.o(324726);
    return true;
  }
  
  public final boolean cPR()
  {
    AppMethodBeat.i(324734);
    if ((this.uBY) && (this.view.getVisibility() == 0))
    {
      AppMethodBeat.o(324734);
      return true;
    }
    AppMethodBeat.o(324734);
    return false;
  }
  
  public final boolean cPS()
  {
    AppMethodBeat.i(324739);
    if ((this.uBT.getVisibility() == 0) && (this.uBV.isChecked()))
    {
      AppMethodBeat.o(324739);
      return true;
    }
    AppMethodBeat.o(324739);
    return false;
  }
  
  public final void setIExternalToolsHelper(aj paramaj)
  {
    this.uBX = paramaj;
  }
  
  public final void setUserAgreementCheckBoxWording(String paramString)
  {
    AppMethodBeat.i(324716);
    s.u(paramString, "wording");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(324716);
      return;
    }
    if (this.view.getVisibility() != 0) {
      this.view.setVisibility(0);
    }
    this.uBU.setText(c.a(paramString, false, new e..ExternalSyntheticLambda1(this)));
    this.uBU.setMovementMethod(LinkMovementMethod.getInstance());
    this.uBU.setLinkTextColor(this.context.getResources().getColor(a.a.link_color));
    z.T((View)this.uBU);
    this.uBY = true;
    AppMethodBeat.o(324716);
  }
  
  public final void setUserAgreementCheckedAlertListener(u paramu)
  {
    this.uBZ = paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */