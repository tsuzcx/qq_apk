package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y
  extends q<h>
{
  private final EmojiStatusView hbs;
  public boolean hbt;
  
  public y(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105684);
    this.hbt = paramBoolean;
    paramView = paramView.findViewById(2131297050);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.hbs = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105683);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.aus.findViewById(2131296318);
    p.g(paramac, "itemView.findViewById<View>(R.id.about_divider)");
    if (this.hbt) {}
    for (int i = 0;; i = 8)
    {
      paramac.setVisibility(i);
      if (this.hbs.getEmojiInfo() != null) {
        break;
      }
      paramac = (h)this.hbh;
      if (paramac == null) {
        break;
      }
      this.hbs.setEmojiInfo(paramac.gWm);
      AppMethodBeat.o(105683);
      return;
    }
    AppMethodBeat.o(105683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.y
 * JD-Core Version:    0.7.0.1
 */