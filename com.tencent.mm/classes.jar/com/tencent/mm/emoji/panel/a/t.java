package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class t
  extends q<h>
{
  private final EmojiStatusView gqs;
  public boolean gqt;
  
  public t(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105684);
    this.gqt = paramBoolean;
    paramView = paramView.findViewById(2131296943);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.gqs = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105683);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.auu.findViewById(2131296305);
    p.g(paramac, "itemView.findViewById<View>(R.id.about_divider)");
    if (this.gqt) {}
    for (int i = 0;; i = 8)
    {
      paramac.setVisibility(i);
      if (this.gqs.getEmojiInfo() != null) {
        break;
      }
      paramac = (h)this.gqo;
      if (paramac == null) {
        break;
      }
      this.gqs.setEmojiInfo(paramac.glt);
      AppMethodBeat.o(105683);
      return;
    }
    AppMethodBeat.o(105683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.t
 * JD-Core Version:    0.7.0.1
 */