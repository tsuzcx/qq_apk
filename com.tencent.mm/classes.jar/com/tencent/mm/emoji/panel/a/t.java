package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class t
  extends q<h>
{
  private final EmojiStatusView gnW;
  public boolean gnX;
  
  public t(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105684);
    this.gnX = paramBoolean;
    paramView = paramView.findViewById(2131296943);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.gnW = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105683);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.auu.findViewById(2131296305);
    p.g(paramac, "itemView.findViewById<View>(R.id.about_divider)");
    if (this.gnX) {}
    for (int i = 0;; i = 8)
    {
      paramac.setVisibility(i);
      if (this.gnW.getEmojiInfo() != null) {
        break;
      }
      paramac = (h)this.gnS;
      if (paramac == null) {
        break;
      }
      this.gnW.setEmojiInfo(paramac.gjb);
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