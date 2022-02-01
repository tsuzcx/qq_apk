package com.tencent.mm.plugin.finder.activity.uic;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "acknowledgeBtn", "Landroid/widget/Button;", "container", "Landroid/widget/LinearLayout;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1;", "invalidDetailIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "invalidDetailText", "Landroid/widget/TextView;", "changeFeed", "", "responseCode", "", "initView", "type", "errMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class h
  extends UIComponent
{
  public static final a wZg;
  LinearLayout wSF;
  Button wZc;
  TextView wZd;
  WeImageView wZe;
  private final b wZf;
  
  static
  {
    AppMethodBeat.i(283671);
    wZg = new a((byte)0);
    AppMethodBeat.o(283671);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(283669);
    this.wZf = new b(this);
    AppMethodBeat.o(283669);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283666);
    super.onCreate(paramBundle);
    this.wZf.alive();
    AppMethodBeat.o(283666);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(283667);
    super.onDestroy();
    this.wZf.dead();
    AppMethodBeat.o(283667);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<iw>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$2$1"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281667);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.wZh.getActivity().isFinishing()) {
        this.wZh.getActivity().finish();
      }
      a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.h
 * JD-Core Version:    0.7.0.1
 */