package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.f;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.q;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class ae
  extends s<ak>
{
  private final ImageView bwJ;
  
  public ae(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105691);
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.bwJ = ((ImageView)paramView);
    AppMethodBeat.o(105691);
  }
  
  public final void a(com.tencent.mm.emoji.b.b.ae paramae)
  {
    AppMethodBeat.i(105690);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (ak)this.jMr;
    if (paramae != null)
    {
      Object localObject = this.bwJ;
      f.htQ();
      ((ImageView)localObject).setImageDrawable(f.buv(paramae.jKg.key));
      localObject = f.htQ().buw(paramae.jKg.key);
      paramae = (com.tencent.mm.emoji.b.b.ae)localObject;
      if (Util.isNullOrNil((String)localObject))
      {
        paramae = this.amk;
        kotlin.g.b.p.j(paramae, "itemView");
        paramae = paramae.getContext().getString(a.j.emoji_store_title);
      }
      this.bwJ.setContentDescription((CharSequence)paramae);
      AppMethodBeat.o(105690);
      return;
    }
    AppMethodBeat.o(105690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ae
 * JD-Core Version:    0.7.0.1
 */