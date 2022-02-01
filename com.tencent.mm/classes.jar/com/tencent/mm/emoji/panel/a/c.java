package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.u;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.emoji.sync.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupLoadingMoreItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "attachListener", "com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1", "Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1;", "loadCallback", "com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1", "Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1;", "getLoader", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends q<u>
{
  private final a mkL;
  private final b mkM;
  
  public c(final View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(242452);
    this.mkL = new a(this);
    this.mkM = new b(this, paramView);
    paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.mkL);
    AppMethodBeat.o(242452);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(c paramc) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(242485);
      c.a(this.mkN).a((g.i)c.b(this.mkN));
      if (c.a(this.mkN).aWl()) {
        c.a(this.mkN).aWi();
      }
      AppMethodBeat.o(242485);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(242490);
      c.a(this.mkN).b((g.i)c.b(this.mkN));
      AppMethodBeat.o(242490);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/adapter/EmojiLoadingViewHolder$loadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.i
  {
    b(c paramc, View paramView) {}
    
    public final void aVL()
    {
      AppMethodBeat.i(242486);
      if ((c.a(this.mkN).aWl()) && (paramView.isAttachedToWindow())) {
        c.a(this.mkN).aWi();
      }
      AppMethodBeat.o(242486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.c
 * JD-Core Version:    0.7.0.1
 */