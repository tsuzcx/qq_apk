package com.tencent.mm.plugin.gamelife.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"})
public final class GameLifeConversationUI$g
  extends RefreshLoadMoreLayout.a
{
  public final void Ie(int paramInt)
  {
    AppMethodBeat.i(204242);
    b localb = new b();
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
    super.Ie(paramInt);
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
    AppMethodBeat.o(204242);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(204240);
    b localb = new b();
    localb.bn(paramc);
    a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
    p.k(paramc, "reason");
    ((RefreshLoadMoreLayout)this.DiR._$_findCachedViewById(d.c.rl_layout)).setEnableLoadMore(GameLifeConversationUI.b(this.DiR));
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(204240);
  }
  
  public final void cKQ()
  {
    AppMethodBeat.i(204238);
    a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
    GameLifeConversationUI.a(this.DiR).onLoadMore();
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
    AppMethodBeat.o(204238);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
  {
    AppMethodBeat.i(204243);
    b localb = new b();
    localb.bn(paramc);
    a.c("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
    super.onRefreshEnd(paramc);
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(204243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI.g
 * JD-Core Version:    0.7.0.1
 */