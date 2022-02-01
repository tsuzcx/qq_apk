package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class t
  extends q<h>
{
  public t(View paramView)
  {
    super(paramView, null);
    AppMethodBeat.i(199975);
    AppMethodBeat.o(199975);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(199974);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.aus;
    if (paramac == null)
    {
      paramac = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(199974);
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
    paramac = this.aus.findViewById(2131303688);
    p.g(paramac, "itemView.findViewById<Pr…sBar>(R.id.load_progress)");
    ((ProgressBar)paramac).setVisibility(0);
    AppMethodBeat.o(199974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.t
 * JD-Core Version:    0.7.0.1
 */