package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.ui.au;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "hangupBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkingTip", "Landroid/widget/TextView;", "nickname", "fillContent", "", "hideLinkMicBottomBar", "showLinkMicBottomBar", "plugin-finder_release"})
public final class bk
  extends d
{
  final com.tencent.mm.live.c.b hOp;
  final View unm;
  final TextView uuB;
  final TextView uuC;
  
  public bk(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247099);
    this.hOp = paramb;
    this.uuB = ((TextView)paramViewGroup.findViewById(2131301302));
    this.unm = paramViewGroup.findViewById(2131301300);
    this.uuC = ((TextView)paramViewGroup.findViewById(2131301301));
    paramViewGroup.setAlpha(0.0F);
    paramb = this.unm;
    if (paramb != null) {
      paramb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(247092);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (this.uuD.hOp.getLiveRole() == 0)
          {
            paramAnonymousView = m.vli;
            m.ou(true);
          }
          b.b.a(this.uuD.hOp, b.c.hNP);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoLinkBottomBarPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247092);
        }
      });
    }
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247099);
      throw paramViewGroup;
    }
    ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(au.az(paramViewGroup.getContext()).x / 2);
    AppMethodBeat.o(247099);
  }
  
  public final void dhS()
  {
    AppMethodBeat.i(247097);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(247097);
  }
  
  public final void dhT()
  {
    AppMethodBeat.i(247098);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(247098);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(bk parambk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(bk parambk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bk
 * JD-Core Version:    0.7.0.1
 */