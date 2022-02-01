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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class l
  extends q<m>
{
  private final ImageView hg;
  
  public l(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(2131296943);
    k.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.hg = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105671);
    k.h(paramy, "item");
    super.a(paramy);
    c.ch(this.hg.getContext());
    paramy = (m)this.fQv;
    if (paramy != null)
    {
      if (paramy.fOf == 0)
      {
        this.hg.setImageDrawable(am.i(this.hg.getContext(), 2131690099, this.hg.getContext().getResources().getColor(2131100499)));
        this.hg.setContentDescription((CharSequence)this.hg.getContext().getString(2131763213));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramy.fOf == 1)
      {
        this.hg.setImageDrawable(am.i(this.hg.getContext(), 2131690098, this.hg.getContext().getResources().getColor(2131100499)));
        this.hg.setContentDescription((CharSequence)this.hg.getContext().getString(2131756781));
      }
      AppMethodBeat.o(105671);
      return;
    }
    AppMethodBeat.o(105671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.l
 * JD-Core Version:    0.7.0.1
 */