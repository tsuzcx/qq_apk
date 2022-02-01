package com.tencent.mm.plugin.finder.activity.uic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "acknowledgeBtn", "Landroid/widget/Button;", "container", "Landroid/widget/LinearLayout;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1;", "invalidDetailIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "invalidDetailText", "Landroid/widget/TextView;", "changeFeed", "", "responseCode", "", "initView", "type", "errMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderInvalidActivityUIC
  extends UIComponent
{
  public static final a tsa;
  LinearLayout tmh;
  Button trW;
  TextView trX;
  WeImageView trY;
  private final b trZ;
  
  static
  {
    AppMethodBeat.i(242152);
    tsa = new a((byte)0);
    AppMethodBeat.o(242152);
  }
  
  public FinderInvalidActivityUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242151);
    this.trZ = new b(this);
    AppMethodBeat.o(242151);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242149);
    super.onCreate(paramBundle);
    this.trZ.alive();
    AppMethodBeat.o(242149);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242150);
    super.onDestroy();
    this.trZ.dead();
    AppMethodBeat.o(242150);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<ih>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderInvalidActivityUIC paramFinderInvalidActivityUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242148);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!this.tsb.getActivity().isFinishing()) {
        this.tsb.getActivity().finish();
      }
      a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderInvalidActivityUIC
 * JD-Core Version:    0.7.0.1
 */