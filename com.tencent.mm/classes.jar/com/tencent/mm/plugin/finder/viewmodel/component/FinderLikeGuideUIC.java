package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "listener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1;", "shownSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkShow", "", "feedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "report21875", "", "Companion", "plugin-finder_release"})
public final class FinderLikeGuideUIC
  extends UIComponent
{
  public static final a wxT;
  private final HashSet<Long> wxR;
  private final c wxS;
  
  static
  {
    AppMethodBeat.i(255711);
    wxT = new a((byte)0);
    AppMethodBeat.o(255711);
  }
  
  public FinderLikeGuideUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255710);
    this.wxR = new HashSet();
    this.wxS = new c(this);
    AppMethodBeat.o(255710);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255708);
    super.onCreate(paramBundle);
    this.wxS.alive();
    AppMethodBeat.o(255708);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255709);
    super.onDestroy();
    this.wxS.dead();
    AppMethodBeat.o(255709);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(FinderLikeGuideUIC paramFinderLikeGuideUIC, LinearLayout paramLinearLayout) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(255705);
      p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = this.wxU.getActivity().getWindow();
        p.g(paramView, "activity.window");
        paramView = paramView.getDecorView();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout");
          AppMethodBeat.o(255705);
          throw paramView;
        }
        ((FrameLayout)paramView).removeView((View)this.wxV);
      }
      AppMethodBeat.o(255705);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hj>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderLikeGuideUIC.c paramc, hj paramhj)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC
 * JD-Core Version:    0.7.0.1
 */