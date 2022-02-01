package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.t;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class m
  extends q<t>
{
  private final View hax;
  private final TextView hbb;
  
  public m(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105674);
    paramn = paramView.findViewById(2131300013);
    p.g(paramn, "itemView.findViewById(R.…_panel_item_expand_title)");
    this.hbb = ((TextView)paramn);
    paramView = paramView.findViewById(2131300012);
    p.g(paramView, "itemView.findViewById(R.…i_panel_item_expand_icon)");
    this.hax = paramView;
    AppMethodBeat.o(105674);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105673);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (t)this.hbh;
    if (paramac != null)
    {
      if (paramac.gYL)
      {
        this.hbb.setText(2131758569);
        this.hax.setRotation(180.0F);
        AppMethodBeat.o(105673);
        return;
      }
      this.hbb.setText(2131758570);
      this.hax.setRotation(0.0F);
      AppMethodBeat.o(105673);
      return;
    }
    AppMethodBeat.o(105673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.m
 * JD-Core Version:    0.7.0.1
 */