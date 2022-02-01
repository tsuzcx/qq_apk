package com.tencent.mm.plugin.finder.live.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callback", "Lkotlin/Function1;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancelBtn", "Landroid/widget/Button;", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "initView", "onCountDownEnd", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reset", "startCountDown", "stopCountDown", "updateText", "Companion", "plugin-finder_release"})
public final class h
  extends UIComponent
{
  public static final a zcg;
  public kotlin.g.a.b<? super Boolean, x> callback;
  private Button kGN;
  private TextView kGO;
  private int kGP;
  private final MTimerHandler timerHandler;
  private com.tencent.mm.plugin.findersdk.b.b ywG;
  
  static
  {
    AppMethodBeat.i(265867);
    zcg = new a((byte)0);
    AppMethodBeat.o(265867);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265866);
    this.kGP = 3;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new c(this), true);
    AppMethodBeat.o(265866);
  }
  
  private final void dFV()
  {
    AppMethodBeat.i(265865);
    TextView localTextView = this.kGO;
    if (localTextView == null) {
      p.bGy("countDownTv");
    }
    localTextView.setVisibility(0);
    localTextView = this.kGO;
    if (localTextView == null) {
      p.bGy("countDownTv");
    }
    localTextView.setText((CharSequence)String.valueOf(this.kGP));
    AppMethodBeat.o(265865);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(265864);
    this.kGP = 3;
    com.tencent.mm.plugin.findersdk.b.b localb = this.ywG;
    if (localb == null) {
      p.bGy("loadingComponent");
    }
    localb.end();
    AppMethodBeat.o(265864);
  }
  
  public final void dFU()
  {
    AppMethodBeat.i(265863);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(265863);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265862);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_cancel_btn);
    p.j(paramBundle, "activity.findViewById(R.id.finder_live_cancel_btn)");
    this.kGN = ((Button)paramBundle);
    paramBundle = getActivity().findViewById(b.f.finder_live_count_down_tv);
    p.j(paramBundle, "activity.findViewById(R.…inder_live_count_down_tv)");
    this.kGO = ((TextView)paramBundle);
    paramBundle = (ProgressBar)getActivity().findViewById(b.f.finder_live_loading_bar);
    b.a locala = com.tencent.mm.plugin.findersdk.b.b.Bvw;
    p.j(paramBundle, "it");
    this.ywG = b.a.a(paramBundle);
    paramBundle = this.kGN;
    if (paramBundle == null) {
      p.bGy("cancelBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = this.ywG;
    if (paramBundle == null) {
      p.bGy("loadingComponent");
    }
    paramBundle.end();
    dFV();
    this.timerHandler.startTimer(1000L, 1000L);
    paramBundle = this.ywG;
    if (paramBundle == null) {
      p.bGy("loadingComponent");
    }
    paramBundle.end();
    AppMethodBeat.o(265862);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC$Companion;", "", "()V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "DELAY_TIME", "", "INTERVAL_TIME", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278711);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zch.dFU();
      paramView = this.zch.callback;
      if (paramView != null) {
        paramView.invoke(Boolean.FALSE);
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveCountDownUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278711);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(h paramh) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(268081);
      if (h.a(this.zch) > 0)
      {
        h localh = this.zch;
        h.a(localh, h.a(localh) - 1);
        h.b(this.zch);
        AppMethodBeat.o(268081);
        return true;
      }
      h.c(this.zch);
      AppMethodBeat.o(268081);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.h
 * JD-Core Version:    0.7.0.1
 */