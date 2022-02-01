package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.m.a.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class aa
  extends s<h>
{
  private final EmojiStatusView jMC;
  public boolean jMD;
  
  public aa(View paramView, boolean paramBoolean, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105684);
    this.jMD = paramBoolean;
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.jMC = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105683);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = this.amk.findViewById(a.g.about_divider);
    kotlin.g.b.p.j(paramae, "itemView.findViewById<View>(R.id.about_divider)");
    if (this.jMD) {}
    for (int i = 0;; i = 8)
    {
      paramae.setVisibility(i);
      if (this.jMC.getEmojiInfo() != null) {
        break;
      }
      paramae = (h)this.jMr;
      if (paramae == null) {
        break;
      }
      this.jMC.setEmojiInfo(paramae.jHh);
      AppMethodBeat.o(105683);
      return;
    }
    AppMethodBeat.o(105683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.aa
 * JD-Core Version:    0.7.0.1
 */