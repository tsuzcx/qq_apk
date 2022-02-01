package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.emoji.sync.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupLoadingMoreItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "attachListener", "com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1", "Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1;", "loadCallback", "com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1", "Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1;", "getLoader", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "plugin-emojisdk_release"})
public final class d
  extends s<u>
{
  private final a jLD;
  private final b jLE;
  
  public d(final View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(227837);
    this.jLD = new a(this);
    this.jLE = new b(this, paramView);
    paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.jLD);
    AppMethodBeat.o(227837);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-emojisdk_release"})
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(230569);
      d.a(this.jLF).a((g.i)d.b(this.jLF));
      if (d.a(this.jLF).aDl()) {
        d.a(this.jLF).aDi();
      }
      AppMethodBeat.o(230569);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(230571);
      d.a(this.jLF).b((g.i)d.b(this.jLF));
      AppMethodBeat.o(230571);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"})
  public static final class b
    implements g.i
  {
    b(View paramView) {}
    
    public final void aCN()
    {
      AppMethodBeat.i(224841);
      if ((d.a(this.jLF).aDl()) && (paramView.isAttachedToWindow())) {
        d.a(this.jLF).aDi();
      }
      AppMethodBeat.o(224841);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d
 * JD-Core Version:    0.7.0.1
 */