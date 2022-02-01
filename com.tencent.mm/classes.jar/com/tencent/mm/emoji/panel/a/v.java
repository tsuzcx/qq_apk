package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.plugin.m.a.g;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class v
  extends s<h>
{
  public v(View paramView)
  {
    super(paramView, null);
    AppMethodBeat.i(225561);
    AppMethodBeat.o(225561);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(225559);
    p.k(paramae, "item");
    super.a(paramae);
    paramae = this.amk;
    if (paramae == null)
    {
      paramae = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(225559);
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
    paramae = this.amk.findViewById(a.g.load_progress);
    p.j(paramae, "itemView.findViewById<Pr…sBar>(R.id.load_progress)");
    ((ProgressBar)paramae).setVisibility(0);
    AppMethodBeat.o(225559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */