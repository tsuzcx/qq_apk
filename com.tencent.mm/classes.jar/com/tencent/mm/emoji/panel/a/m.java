package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.p;
import com.tencent.mm.emoji.a.a.y;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class m
  extends q<p>
{
  private final View fTE;
  private final TextView fUk;
  
  public m(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105674);
    paramn = paramView.findViewById(2131299400);
    k.g(paramn, "itemView.findViewById(R.…_panel_item_expand_title)");
    this.fUk = ((TextView)paramn);
    paramView = paramView.findViewById(2131299399);
    k.g(paramView, "itemView.findViewById(R.…i_panel_item_expand_icon)");
    this.fTE = paramView;
    AppMethodBeat.o(105674);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105673);
    k.h(paramy, "item");
    super.a(paramy);
    paramy = (p)this.fUq;
    if (paramy != null)
    {
      if (paramy.fRR)
      {
        this.fUk.setText(2131758281);
        this.fTE.setRotation(180.0F);
        AppMethodBeat.o(105673);
        return;
      }
      this.fUk.setText(2131758282);
      this.fTE.setRotation(0.0F);
      AppMethodBeat.o(105673);
      return;
    }
    AppMethodBeat.o(105673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.m
 * JD-Core Version:    0.7.0.1
 */