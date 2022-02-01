package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.t;
import com.tencent.mm.plugin.m.a.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends q<t>
{
  private final View mkH;
  private final TextView mll;
  
  public l(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105674);
    paramn = paramView.findViewById(a.g.emoji_panel_item_expand_title);
    s.s(paramn, "itemView.findViewById(R.…_panel_item_expand_title)");
    this.mll = ((TextView)paramn);
    paramView = paramView.findViewById(a.g.emoji_panel_item_expand_icon);
    s.s(paramView, "itemView.findViewById(R.…i_panel_item_expand_icon)");
    this.mkH = paramView;
    AppMethodBeat.o(105674);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105673);
    s.u(paramae, "item");
    super.a(paramae);
    if ((t)aVT() != null)
    {
      AppMethodBeat.o(105673);
      throw null;
    }
    AppMethodBeat.o(105673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.l
 * JD-Core Version:    0.7.0.1
 */