package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.m;
import com.tencent.mm.emoji.d.c;
import com.tencent.mm.ui.ao;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class l
  extends q<m>
{
  private final ImageView ka;
  
  public l(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(2131296943);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ka = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105671);
    p.h(paramac, "item");
    super.a(paramac);
    c.ck(this.ka.getContext());
    paramac = (m)this.gnS;
    if (paramac != null)
    {
      if (paramac.glr == 0)
      {
        this.ka.setImageDrawable(ao.k(this.ka.getContext(), 2131690099, this.ka.getContext().getResources().getColor(2131100499)));
        this.ka.setContentDescription((CharSequence)this.ka.getContext().getString(2131763213));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramac.glr == 1)
      {
        this.ka.setImageDrawable(ao.k(this.ka.getContext(), 2131690098, this.ka.getContext().getResources().getColor(2131100499)));
        this.ka.setContentDescription((CharSequence)this.ka.getContext().getString(2131756781));
      }
      AppMethodBeat.o(105671);
      return;
    }
    AppMethodBeat.o(105671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.l
 * JD-Core Version:    0.7.0.1
 */