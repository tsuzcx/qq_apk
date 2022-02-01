package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "I", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getOnClick", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setOnClick", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "panelItem", "getPanelItem", "()Lcom/tencent/mm/emoji/model/panel/PanelItem;", "setPanelItem", "(Lcom/tencent/mm/emoji/model/panel/PanelItem;)V", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onBind", "", "item", "plugin-emojisdk_release"})
public class q<I extends ac>
  extends RecyclerView.v
{
  protected I hbh;
  n hbi;
  
  public q(View paramView, n paramn)
  {
    super(paramView);
    AppMethodBeat.i(105679);
    this.hbi = paramn;
    paramView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105677);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = this.hbj.hbi;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          p.g(localContext, "it.context");
          ((n)localObject).a(paramAnonymousView, localContext, this.hbj.lR(), this.hbj.hbh);
        }
        a.a(this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105677);
      }
    });
    paramView.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199969);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
        localObject = this.hbj.hbi;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          p.g(localContext, "it.context");
          ((n)localObject).a(paramAnonymousView, localContext, this.hbj.lR());
        }
        a.a(true, this, "com/tencent/mm/emoji/panel/adapter/PanelViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(199969);
        return true;
      }
    });
    AppMethodBeat.o(105679);
  }
  
  public void a(ac paramac)
  {
    AppMethodBeat.i(105678);
    p.h(paramac, "item");
    this.hbh = paramac;
    AppMethodBeat.o(105678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.q
 * JD-Core Version:    0.7.0.1
 */