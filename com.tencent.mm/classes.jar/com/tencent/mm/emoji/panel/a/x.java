package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class x
  extends q<h>
{
  private int hbo;
  
  public x(View paramView, int paramInt)
  {
    super(paramView, null);
    AppMethodBeat.i(105682);
    this.hbo = paramInt;
    AppMethodBeat.o(105682);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105681);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.aus;
    if (paramac == null)
    {
      paramac = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(105681);
      throw paramac;
    }
    paramac = ((Iterable)j.mY(0, ((ViewGroup)paramac).getChildCount())).iterator();
    while (paramac.hasNext())
    {
      int i = ((ab)paramac).nextInt();
      View localView = ((ViewGroup)this.aus).getChildAt(i);
      p.g(localView, "itemView.getChildAt(it)");
      localView.setVisibility(8);
    }
    paramac = this.aus.findViewById(this.hbo);
    p.g(paramac, "itemView.findViewById<View>(showId)");
    paramac.setVisibility(0);
    AppMethodBeat.o(105681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */