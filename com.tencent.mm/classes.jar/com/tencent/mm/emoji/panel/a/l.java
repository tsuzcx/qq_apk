package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.m;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.d.c;
import com.tencent.mm.ui.am;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class l
  extends q<m>
{
  private final ImageView ig;
  
  public l(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(2131296943);
    k.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ig = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105671);
    k.h(paramy, "item");
    super.a(paramy);
    c.cn(this.ig.getContext());
    paramy = (m)this.fUq;
    if (paramy != null)
    {
      if (paramy.fRQ == 0)
      {
        this.ig.setImageDrawable(am.k(this.ig.getContext(), 2131690099, this.ig.getContext().getResources().getColor(2131100499)));
        this.ig.setContentDescription((CharSequence)this.ig.getContext().getString(2131763213));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramy.fRQ == 1)
      {
        this.ig.setImageDrawable(am.k(this.ig.getContext(), 2131690098, this.ig.getContext().getResources().getColor(2131100499)));
        this.ig.setContentDescription((CharSequence)this.ig.getContext().getString(2131756781));
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