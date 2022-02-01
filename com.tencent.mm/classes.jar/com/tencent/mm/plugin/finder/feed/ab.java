package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract;", "", "()V", "IProfileTimelinePresenter", "ProfileTimelinePresenter", "ProfileTimelineViewCallback", "plugin-finder_release"})
public final class ab
{
  public static final ab tPv;
  
  static
  {
    AppMethodBeat.i(165796);
    tPv = new ab();
    AppMethodBeat.o(165796);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class b$p
    implements u.b
  {
    public static final p tPQ;
    
    static
    {
      AppMethodBeat.i(244060);
      tPQ = new p();
      AppMethodBeat.o(244060);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(244059);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(2131309260);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(244059);
          return;
        }
      }
      AppMethodBeat.o(244059);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class b$s
    implements u.b
  {
    public static final s tPS;
    
    static
    {
      AppMethodBeat.i(244066);
      tPS = new s();
      AppMethodBeat.o(244066);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(244065);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(2131309260);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(244065);
          return;
        }
      }
      AppMethodBeat.o(244065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab
 * JD-Core Version:    0.7.0.1
 */