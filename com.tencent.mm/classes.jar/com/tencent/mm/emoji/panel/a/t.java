package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.plugin.m.a.g;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiLoadingViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends q<h>
{
  public t(View paramView)
  {
    super(paramView, null);
    AppMethodBeat.i(242399);
    AppMethodBeat.o(242399);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(242406);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = ((Iterable)k.qt(0, ((ViewGroup)this.caK).getChildCount())).iterator();
    while (paramae.hasNext())
    {
      int i = ((ah)paramae).Zo();
      ((ViewGroup)this.caK).getChildAt(i).setVisibility(8);
    }
    ((ProgressBar)this.caK.findViewById(a.g.load_progress)).setVisibility(0);
    AppMethodBeat.o(242406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.t
 * JD-Core Version:    0.7.0.1
 */