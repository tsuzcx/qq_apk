package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "I", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getOnClick", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setOnClick", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "panelItem", "getPanelItem", "()Lcom/tencent/mm/emoji/model/panel/PanelItem;", "setPanelItem", "(Lcom/tencent/mm/emoji/model/panel/PanelItem;)V", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onBind", "", "item", "plugin-emojisdk_release"})
public class s<I extends ae>
  extends RecyclerView.v
{
  protected I jMr;
  p jMs;
  
  public s(View paramView, p paramp)
  {
    super(paramView);
    AppMethodBeat.i(105679);
    this.jMs = paramp;
    paramView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105677);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        localObject = this.jMt.jMs;
        if (localObject != null)
        {
          kotlin.g.b.p.j(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          kotlin.g.b.p.j(localContext, "it.context");
          ((p)localObject).a(paramAnonymousView, localContext, this.jMt.md(), this.jMt.jMr);
        }
        a.a(this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105677);
      }
    });
    paramView.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233999);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
        localObject = this.jMt.jMs;
        if (localObject != null)
        {
          kotlin.g.b.p.j(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          kotlin.g.b.p.j(localContext, "it.context");
          ((p)localObject).a(paramAnonymousView, localContext, this.jMt.md());
        }
        a.a(true, this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(233999);
        return true;
      }
    });
    AppMethodBeat.o(105679);
  }
  
  public void a(ae paramae)
  {
    AppMethodBeat.i(105678);
    kotlin.g.b.p.k(paramae, "item");
    this.jMr = paramae;
    AppMethodBeat.o(105678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.s
 * JD-Core Version:    0.7.0.1
 */