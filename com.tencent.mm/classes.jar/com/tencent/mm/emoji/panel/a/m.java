package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.t;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/ExpandPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "getIcon", "()Landroid/view/View;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class m
  extends q<t>
{
  private final TextView gnM;
  private final View gni;
  
  public m(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105674);
    paramn = paramView.findViewById(2131299400);
    p.g(paramn, "itemView.findViewById(R.…_panel_item_expand_title)");
    this.gnM = ((TextView)paramn);
    paramView = paramView.findViewById(2131299399);
    p.g(paramView, "itemView.findViewById(R.…i_panel_item_expand_icon)");
    this.gni = paramView;
    AppMethodBeat.o(105674);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105673);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (t)this.gnS;
    if (paramac != null)
    {
      if (paramac.glv)
      {
        this.gnM.setText(2131758281);
        this.gni.setRotation(180.0F);
        AppMethodBeat.o(105673);
        return;
      }
      this.gnM.setText(2131758282);
      this.gni.setRotation(0.0F);
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