package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class z
  extends s<h>
{
  private int jMy;
  
  public z(View paramView, int paramInt)
  {
    super(paramView, null);
    AppMethodBeat.i(105682);
    this.jMy = paramInt;
    AppMethodBeat.o(105682);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105681);
    p.k(paramae, "item");
    super.a(paramae);
    paramae = this.amk;
    if (paramae == null)
    {
      paramae = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(105681);
      throw paramae;
    }
    paramae = ((Iterable)i.ou(0, ((ViewGroup)paramae).getChildCount())).iterator();
    while (paramae.hasNext())
    {
      int i = ((ab)paramae).zD();
      View localView = ((ViewGroup)this.amk).getChildAt(i);
      p.j(localView, "itemView.getChildAt(it)");
      localView.setVisibility(8);
    }
    paramae = this.amk.findViewById(this.jMy);
    p.j(paramae, "itemView.findViewById<View>(showId)");
    paramae.setVisibility(0);
    AppMethodBeat.o(105681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.z
 * JD-Core Version:    0.7.0.1
 */