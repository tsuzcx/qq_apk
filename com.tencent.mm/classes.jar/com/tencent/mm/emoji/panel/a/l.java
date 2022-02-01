package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class l
  extends q<m>
{
  private final ImageView kc;
  
  public l(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(2131297050);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.kc = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105671);
    p.h(paramac, "item");
    super.a(paramac);
    e.cG(this.kc.getContext());
    paramac = (m)this.hbh;
    if (paramac != null)
    {
      if (paramac.gYH == 0)
      {
        this.kc.setImageDrawable(ar.m(this.kc.getContext(), 2131690131, this.kc.getContext().getResources().getColor(2131100634)));
        this.kc.setContentDescription((CharSequence)this.kc.getContext().getString(2131765381));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramac.gYH == 1)
      {
        this.kc.setImageDrawable(ar.m(this.kc.getContext(), 2131690130, this.kc.getContext().getResources().getColor(2131100634)));
        this.kc.setContentDescription((CharSequence)this.kc.getContext().getString(2131756946));
      }
      AppMethodBeat.o(105671);
      return;
    }
    AppMethodBeat.o(105671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.l
 * JD-Core Version:    0.7.0.1
 */