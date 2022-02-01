package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.t;
import com.tencent.mm.plugin.m.a.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class n
  extends s<t>
{
  private final View jLy;
  private final TextView jMg;
  
  public n(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105674);
    paramp = paramView.findViewById(a.g.emoji_panel_item_expand_title);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…_panel_item_expand_title)");
    this.jMg = ((TextView)paramp);
    paramView = paramView.findViewById(a.g.emoji_panel_item_expand_icon);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.…i_panel_item_expand_icon)");
    this.jLy = paramView;
    AppMethodBeat.o(105674);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105673);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    if ((t)this.jMr != null)
    {
      AppMethodBeat.o(105673);
      throw null;
    }
    AppMethodBeat.o(105673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.n
 * JD-Core Version:    0.7.0.1
 */