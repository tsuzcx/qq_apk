package com.tencent.mm.plugin.finder.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.ew;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTeensGuideDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "gotoTeensLaout", "Landroid/widget/LinearLayout;", "getGotoTeensLaout", "()Landroid/widget/LinearLayout;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "teensGuideMsg", "Landroid/widget/TextView;", "getTeensGuideMsg", "()Landroid/widget/TextView;", "teensGuideOk", "getTeensGuideOk", "gotoTeensHome", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAppCompatActivity", "setTeensGuideMsg", "msg", "", "show", "plugin-finder_release"})
public final class n
  extends Dialog
{
  private final LinearLayout BaO;
  public final TextView BaP;
  private final TextView BaQ;
  private final View oFW;
  public AppCompatActivity xGq;
  
  public n(Context paramContext)
  {
    super(paramContext, b.k.mmtipsdialog);
    AppMethodBeat.i(270451);
    paramContext = View.inflate(paramContext, b.g.finder_teens_guide_customer_view, null);
    p.j(paramContext, "View.inflate(context, R.…uide_customer_view, null)");
    this.oFW = paramContext;
    paramContext = this.oFW.findViewById(b.f.ll_goto_teens);
    p.j(paramContext, "rootView.findViewById<Li…yout>(R.id.ll_goto_teens)");
    this.BaO = ((LinearLayout)paramContext);
    paramContext = this.oFW.findViewById(b.f.tv_teens_gudie_msg);
    p.j(paramContext, "rootView.findViewById<Te…(R.id.tv_teens_gudie_msg)");
    this.BaP = ((TextView)paramContext);
    paramContext = this.oFW.findViewById(b.f.tv_teens_gudie_ok);
    p.j(paramContext, "rootView.findViewById<Te…>(R.id.tv_teens_gudie_ok)");
    this.BaQ = ((TextView)paramContext);
    setCanceledOnTouchOutside(true);
    this.BaO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(272190);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTeensGuideDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.BaR;
        ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).setScene(2);
        ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(1);
        c.ad(paramAnonymousView.getContext(), "teenmode", ".ui.SettingsTeenModeIntro");
        paramAnonymousView.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTeensGuideDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(272190);
      }
    });
    this.BaQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(284844);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTeensGuideDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.BaR.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderTeensGuideDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284844);
      }
    });
    AppMethodBeat.o(270451);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270448);
    super.onCreate(paramBundle);
    setContentView(this.oFW);
    AppMethodBeat.o(270448);
  }
  
  public final void show()
  {
    AppMethodBeat.i(270449);
    super.show();
    Object localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    localObject1 = this.xGq;
    if (localObject1 == null) {
      p.bGy("activity");
    }
    localObject1 = (Context)localObject1;
    p.k(localObject1, "context");
    Object localObject2 = g.Xox;
    localObject1 = ((aj)g.lm((Context)localObject1).i(aj.class)).ekY();
    localObject2 = new ew();
    ((ew)localObject2).th(((bid)localObject1).sessionId);
    ((ew)localObject2).ti(((bid)localObject1).wmL);
    ((ew)localObject2).tj(String.valueOf(((bid)localObject1).xkX));
    ((ew)localObject2).tn(((bid)localObject1).wmz);
    ((ew)localObject2).mq(0);
    ((ew)localObject2).tl("teenagemode_set");
    ((ew)localObject2).tk(String.valueOf(cm.bfE()));
    ((ew)localObject2).bpa();
    com.tencent.mm.plugin.finder.report.n.a((com.tencent.mm.plugin.report.a)localObject2);
    AppMethodBeat.o(270449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.n
 * JD-Core Version:    0.7.0.1
 */