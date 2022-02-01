package com.tencent.mm.plugin.finder.live.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callback", "Lkotlin/Function1;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancelBtn", "Landroid/widget/Button;", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "initView", "onBackPressed", "onCountDownEnd", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reset", "startCountDown", "stopCountDown", "updateText", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends UIComponent
{
  public static final j.a DYA;
  private com.tencent.mm.plugin.findersdk.b.b DiB;
  public kotlin.g.a.b<? super Boolean, ah> callback;
  private Button njI;
  private TextView njJ;
  private int njK;
  private final MTimerHandler timerHandler;
  
  static
  {
    AppMethodBeat.i(356226);
    DYA = new j.a((byte)0);
    AppMethodBeat.o(356226);
  }
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356181);
    this.njK = 3;
    this.timerHandler = new MTimerHandler(new j..ExternalSyntheticLambda1(this), true);
    AppMethodBeat.o(356181);
  }
  
  private static final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(356220);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramj.exf();
    paramj = paramj.callback;
    if (paramj != null) {
      paramj.invoke(Boolean.FALSE);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356220);
  }
  
  private static final boolean a(j paramj)
  {
    AppMethodBeat.i(356208);
    s.u(paramj, "this$0");
    if (paramj.njK > 0)
    {
      paramj.njK -= 1;
      paramj.exg();
      AppMethodBeat.o(356208);
      return true;
    }
    Object localObject = paramj.callback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
    }
    localObject = paramj.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).begin();
    }
    localObject = paramj.njJ;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    paramj = paramj.njI;
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    AppMethodBeat.o(356208);
    return false;
  }
  
  private final void exg()
  {
    AppMethodBeat.i(356199);
    TextView localTextView = this.njJ;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = this.njJ;
    if (localTextView != null) {
      localTextView.setText((CharSequence)String.valueOf(this.njK));
    }
    AppMethodBeat.o(356199);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(356190);
    this.njK = 3;
    com.tencent.mm.plugin.findersdk.b.b localb = this.DiB;
    if (localb != null) {
      localb.end();
    }
    AppMethodBeat.o(356190);
  }
  
  public final void exf()
  {
    AppMethodBeat.i(356266);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(356266);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(356275);
    Button localButton = this.njI;
    if (localButton == null)
    {
      AppMethodBeat.o(356275);
      return false;
    }
    boolean bool = localButton.performClick();
    AppMethodBeat.o(356275);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356257);
    super.onCreate(paramBundle);
    this.njI = ((Button)getActivity().findViewById(p.e.BJb));
    this.njJ = ((TextView)getActivity().findViewById(p.e.BKf));
    paramBundle = (ProgressBar)getActivity().findViewById(p.e.BNo);
    b.a locala = com.tencent.mm.plugin.findersdk.b.b.HcE;
    s.s(paramBundle, "it");
    this.DiB = b.a.a(paramBundle);
    paramBundle = this.njI;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new j..ExternalSyntheticLambda0(this));
    }
    paramBundle = this.DiB;
    if (paramBundle != null) {
      paramBundle.end();
    }
    exg();
    this.timerHandler.startTimer(1000L, 1000L);
    paramBundle = this.DiB;
    if (paramBundle != null) {
      paramBundle.end();
    }
    AppMethodBeat.o(356257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.j
 * JD-Core Version:    0.7.0.1
 */