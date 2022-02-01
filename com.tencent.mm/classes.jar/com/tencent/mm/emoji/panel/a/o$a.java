package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.kernel.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-emojisdk_release"})
public final class o$a
  implements View.OnAttachStateChangeListener
{
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(226007);
    paramView = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
    ((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().a((a)o.b(this.jMm));
    AppMethodBeat.o(226007);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(226008);
    paramView = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
    ((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().b((a)o.b(this.jMm));
    AppMethodBeat.o(226008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o.a
 * JD-Core Version:    0.7.0.1
 */