package com.tencent.mm.plugin.finder.view.teens;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.teenmode.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/finder/view/teens/ITeensGuideView;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "gotoTeensLayout", "Landroid/widget/LinearLayout;", "rootView", "Landroid/view/View;", "teensGuideMsg", "Landroid/widget/TextView;", "teensGuideOk", "dismissGuide", "", "gotoTeensHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setTeensGuideMsg", "msg", "", "showGuide", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends Dialog
  implements c
{
  private final LinearLayout GJG;
  private final TextView GJH;
  private final TextView GJK;
  private final Activity activity;
  private final View rootView;
  
  public b(Activity paramActivity)
  {
    super((Context)paramActivity, e.i.mmtipsdialog);
    AppMethodBeat.i(345357);
    this.activity = paramActivity;
    paramActivity = View.inflate(getContext(), e.f.finder_teens_guide_customer_view, null);
    s.s(paramActivity, "inflate(context, R.layou…uide_customer_view, null)");
    this.rootView = paramActivity;
    paramActivity = this.rootView.findViewById(e.e.ll_goto_teens);
    s.s(paramActivity, "rootView.findViewById(R.id.ll_goto_teens)");
    this.GJG = ((LinearLayout)paramActivity);
    paramActivity = this.rootView.findViewById(e.e.tv_teens_guide_msg);
    s.s(paramActivity, "rootView.findViewById(R.id.tv_teens_guide_msg)");
    this.GJH = ((TextView)paramActivity);
    paramActivity = this.rootView.findViewById(e.e.tv_teens_guide_ok);
    s.s(paramActivity, "rootView.findViewById(R.id.tv_teens_guide_ok)");
    this.GJK = ((TextView)paramActivity);
    setCanceledOnTouchOutside(true);
    this.rootView.setOnClickListener(new b..ExternalSyntheticLambda2(this));
    this.GJG.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    this.GJK.setOnClickListener(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(345357);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(345366);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345366);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(345372);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    ((d)h.ax(d.class)).setScene(2);
    ((d)h.ax(d.class)).rG(1);
    com.tencent.mm.br.c.ai((Context)paramb.activity, "teenmode", ".ui.SettingsTeenModeIntro");
    paramb.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345372);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(345378);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345378);
  }
  
  public final void aCL(String paramString)
  {
    AppMethodBeat.i(345425);
    s.u(paramString, "msg");
    this.GJH.setText((CharSequence)paramString);
    AppMethodBeat.o(345425);
  }
  
  public final void fmH()
  {
    AppMethodBeat.i(345410);
    show();
    z localz = z.FrZ;
    z.gP((Context)this.activity);
    AppMethodBeat.o(345410);
  }
  
  public final void fmI()
  {
    AppMethodBeat.i(345417);
    dismiss();
    AppMethodBeat.o(345417);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(345404);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(e.i.ToastPopupWindow);
    }
    setContentView(this.rootView);
    AppMethodBeat.o(345404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.teens.b
 * JD-Core Version:    0.7.0.1
 */