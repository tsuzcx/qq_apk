package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.view.EmojiStatusView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class t
  extends q<h>
{
  private final EmojiStatusView fUu;
  public boolean fUv;
  
  public t(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105684);
    this.fUv = paramBoolean;
    paramView = paramView.findViewById(2131296943);
    k.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.fUu = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105683);
    k.h(paramy, "item");
    super.a(paramy);
    paramy = this.asD.findViewById(2131296305);
    k.g(paramy, "itemView.findViewById<View>(R.id.about_divider)");
    if (this.fUv) {}
    for (int i = 0;; i = 8)
    {
      paramy.setVisibility(i);
      if (this.fUu.getEmojiInfo() != null) {
        break;
      }
      paramy = (h)this.fUq;
      if (paramy == null) {
        break;
      }
      this.fUu.setEmojiInfo(paramy.fPB);
      AppMethodBeat.o(105683);
      return;
    }
    AppMethodBeat.o(105683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.t
 * JD-Core Version:    0.7.0.1
 */