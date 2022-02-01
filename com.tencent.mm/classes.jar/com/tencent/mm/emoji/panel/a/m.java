package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.i;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.ui.au;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class m
  extends s<com.tencent.mm.emoji.b.b.m>
{
  private final ImageView bwJ;
  
  public m(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.bwJ = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105671);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (com.tencent.mm.emoji.b.b.m)this.jMr;
    if (paramae != null)
    {
      if (paramae.jJH == 0)
      {
        this.bwJ.setImageDrawable(au.o(this.bwJ.getContext(), a.i.emoji_add_custom, this.bwJ.getContext().getResources().getColor(a.d.icon_color)));
        this.bwJ.setContentDescription((CharSequence)this.bwJ.getContext().getString(a.j.settings_emoji_manager));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramae.jJH == 1)
      {
        this.bwJ.setImageDrawable(au.o(this.bwJ.getContext(), a.i.emoji_add_capture, this.bwJ.getContext().getResources().getColor(a.d.icon_color)));
        this.bwJ.setContentDescription((CharSequence)this.bwJ.getContext().getString(a.j.capture_emoji_entrance));
      }
      AppMethodBeat.o(105671);
      return;
    }
    AppMethodBeat.o(105671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.m
 * JD-Core Version:    0.7.0.1
 */