package com.tencent.mm.plugin.finder.view.teens;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/finder/view/teens/ITeensGuideView;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "closePanel", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "gotoTeensLayout", "Landroid/widget/LinearLayout;", "rootView", "Landroid/view/View;", "teensGuideMsg", "Landroid/widget/TextView;", "teensGuideOk", "Landroid/widget/Button;", "dismissGuide", "", "gotoTeensHome", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setTeensGuideMsg", "msg", "", "showGuide", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Dialog
  implements c
{
  private final LinearLayout GJG;
  private final TextView GJH;
  private final Button GJI;
  private final WeImageView GJJ;
  private final Activity activity;
  private final View rootView;
  
  public a(Activity paramActivity)
  {
    super((Context)paramActivity, e.i.mmtipsdialog);
    AppMethodBeat.i(345354);
    this.activity = paramActivity;
    paramActivity = View.inflate(getContext(), e.f.finder_teens_guide_btm_view, null);
    s.s(paramActivity, "inflate(context, R.layou…ens_guide_btm_view, null)");
    this.rootView = paramActivity;
    paramActivity = this.rootView.findViewById(e.e.ll_goto_teens);
    s.s(paramActivity, "rootView.findViewById(R.id.ll_goto_teens)");
    this.GJG = ((LinearLayout)paramActivity);
    paramActivity = this.rootView.findViewById(e.e.tv_teens_guide_msg);
    s.s(paramActivity, "rootView.findViewById(R.id.tv_teens_guide_msg)");
    this.GJH = ((TextView)paramActivity);
    paramActivity = this.rootView.findViewById(e.e.btn_teens_guide_ok);
    s.s(paramActivity, "rootView.findViewById(R.id.btn_teens_guide_ok)");
    this.GJI = ((Button)paramActivity);
    paramActivity = this.rootView.findViewById(e.e.wiv_close);
    s.s(paramActivity, "rootView.findViewById(R.id.wiv_close)");
    this.GJJ = ((WeImageView)paramActivity);
    setCanceledOnTouchOutside(true);
    this.rootView.setOnClickListener(new a..ExternalSyntheticLambda2(this));
    this.GJG.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    this.GJI.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    this.GJJ.setOnClickListener(new a..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(345354);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(345364);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345364);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(345371);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    ((d)h.ax(d.class)).setScene(2);
    ((d)h.ax(d.class)).rG(1);
    com.tencent.mm.br.c.ai((Context)parama.activity, "teenmode", ".ui.SettingsTeenModeIntro");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345371);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(345377);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345377);
  }
  
  private static final void d(a parama, View paramView)
  {
    AppMethodBeat.i(345384);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/teens/FinderTeensGuideBtmDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345384);
  }
  
  public final void aCL(String paramString)
  {
    AppMethodBeat.i(345440);
    s.u(paramString, "msg");
    this.GJH.setText((CharSequence)paramString);
    AppMethodBeat.o(345440);
  }
  
  public final void fmH()
  {
    AppMethodBeat.i(345428);
    show();
    z localz = z.FrZ;
    z.gP((Context)this.activity);
    AppMethodBeat.o(345428);
  }
  
  public final void fmI()
  {
    AppMethodBeat.i(345433);
    dismiss();
    AppMethodBeat.o(345433);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(345419);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setGravity(80);
      paramBundle.setWindowAnimations(e.i.FinderBottomToTopAnimation);
      paramBundle.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = -1;
        localLayoutParams.height = -2;
        paramBundle.setAttributes(localLayoutParams);
      }
    }
    setContentView(this.rootView);
    AppMethodBeat.o(345419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.teens.a
 * JD-Core Version:    0.7.0.1
 */