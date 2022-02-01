package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.y;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "I", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getOnClick", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setOnClick", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "panelItem", "getPanelItem", "()Lcom/tencent/mm/emoji/model/panel/PanelItem;", "setPanelItem", "(Lcom/tencent/mm/emoji/model/panel/PanelItem;)V", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onBind", "", "item", "plugin-emojisdk_release"})
public class q<I extends y>
  extends RecyclerView.v
{
  public I fQv;
  n fQw;
  
  public q(View paramView, n paramn)
  {
    super(paramView);
    AppMethodBeat.i(105679);
    this.fQw = paramn;
    paramView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105677);
        n localn = this.fQx.fQw;
        if (localn != null)
        {
          k.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          k.g(paramAnonymousView, "it.context");
          localn.a(paramAnonymousView, this.fQx.ln(), this.fQx.fQv);
          AppMethodBeat.o(105677);
          return;
        }
        AppMethodBeat.o(105677);
      }
    });
    paramView.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193414);
        n localn = this.fQx.fQw;
        if (localn != null)
        {
          k.g(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          k.g(localContext, "it.context");
          localn.a(paramAnonymousView, localContext, this.fQx.ln());
        }
        AppMethodBeat.o(193414);
        return true;
      }
    });
    AppMethodBeat.o(105679);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(105678);
    k.h(paramy, "item");
    this.fQv = paramy;
    AppMethodBeat.o(105678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.q
 * JD-Core Version:    0.7.0.1
 */