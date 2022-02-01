package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.y;
import d.a.ab;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class s
  extends q<com.tencent.mm.emoji.a.a.h>
{
  private int fQy;
  
  public s(View paramView, int paramInt)
  {
    super(paramView, null);
    AppMethodBeat.i(105682);
    this.fQy = paramInt;
    AppMethodBeat.o(105682);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105681);
    k.h(paramy, "item");
    super.a(paramy);
    paramy = this.arI;
    if (paramy == null)
    {
      paramy = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(105681);
      throw paramy;
    }
    paramy = ((Iterable)d.k.h.kJ(0, ((ViewGroup)paramy).getChildCount())).iterator();
    while (paramy.hasNext())
    {
      int i = ((ab)paramy).nextInt();
      View localView = ((ViewGroup)this.arI).getChildAt(i);
      k.g(localView, "itemView.getChildAt(it)");
      localView.setVisibility(8);
    }
    paramy = this.arI.findViewById(this.fQy);
    k.g(paramy, "itemView.findViewById<View>(showId)");
    paramy.setVisibility(0);
    AppMethodBeat.o(105681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.s
 * JD-Core Version:    0.7.0.1
 */