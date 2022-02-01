package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import d.a.ab;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class s
  extends q<com.tencent.mm.emoji.a.a.h>
{
  private int gnV;
  
  public s(View paramView, int paramInt)
  {
    super(paramView, null);
    AppMethodBeat.i(105682);
    this.gnV = paramInt;
    AppMethodBeat.o(105682);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105681);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.auu;
    if (paramac == null)
    {
      paramac = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(105681);
      throw paramac;
    }
    paramac = ((Iterable)d.k.h.lo(0, ((ViewGroup)paramac).getChildCount())).iterator();
    while (paramac.hasNext())
    {
      int i = ((ab)paramac).nextInt();
      View localView = ((ViewGroup)this.auu).getChildAt(i);
      p.g(localView, "itemView.getChildAt(it)");
      localView.setVisibility(8);
    }
    paramac = this.auu.findViewById(this.gnV);
    p.g(paramac, "itemView.findViewById<View>(showId)");
    paramac.setVisibility(0);
    AppMethodBeat.o(105681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.s
 * JD-Core Version:    0.7.0.1
 */