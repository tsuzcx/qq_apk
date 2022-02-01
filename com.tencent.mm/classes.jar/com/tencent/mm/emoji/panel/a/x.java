package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiFullPageViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showId", "", "(Landroid/view/View;I)V", "getShowId", "()I", "setShowId", "(I)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends q<h>
{
  private int mlx;
  
  public x(View paramView, int paramInt)
  {
    super(paramView, null);
    AppMethodBeat.i(105682);
    this.mlx = paramInt;
    AppMethodBeat.o(105682);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105681);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = ((Iterable)k.qt(0, ((ViewGroup)this.caK).getChildCount())).iterator();
    while (paramae.hasNext())
    {
      int i = ((ah)paramae).Zo();
      ((ViewGroup)this.caK).getChildAt(i).setVisibility(8);
    }
    this.caK.findViewById(this.mlx).setVisibility(0);
    AppMethodBeat.o(105681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */