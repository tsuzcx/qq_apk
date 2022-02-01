package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkSwitchPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "hideLinkMicSwitch", "", "showLinkMicSwitch", "plugin-finder_release"})
public final class bl
  extends d
{
  final com.tencent.mm.live.c.b hOp;
  private final WeImageView hPc;
  
  public bl(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247105);
    this.hOp = paramb;
    this.hPc = ((WeImageView)paramViewGroup.findViewById(2131301305));
    this.hPc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247100);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkSwitchPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.uuG.hOp, b.c.hLE);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkSwitchPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247100);
      }
    });
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247105);
      throw paramViewGroup;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(at.fromDPToPix(paramViewGroup.getContext(), 8));
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247105);
      throw paramViewGroup;
    }
    ((ViewGroup.MarginLayoutParams)paramb).topMargin = at.fromDPToPix(paramViewGroup.getContext(), 8);
    AppMethodBeat.o(247105);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(bl parambl)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(bl parambl)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bl
 * JD-Core Version:    0.7.0.1
 */