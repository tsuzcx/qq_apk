package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
final class GameLifeConversationUI$e
  extends q
  implements kotlin.g.a.a<x>
{
  GameLifeConversationUI$e(GameLifeConversationUI paramGameLifeConversationUI)
  {
    super(0);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(GameLifeConversationUI.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204018);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      GameLifeConversationUI.a(this.DiS.DiR).onLoadMore();
      p.j(paramView, "it");
      paramView.setVisibility(8);
      paramView = ((RefreshLoadMoreLayout)this.DiS.DiR._$_findCachedViewById(d.c.rl_layout)).getLoadMoreFooter();
      if (paramView != null)
      {
        paramView = paramView.findViewById(d.c.loading);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI.e
 * JD-Core Version:    0.7.0.1
 */