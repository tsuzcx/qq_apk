package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.m.a.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "showTip", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getShowTip", "()Z", "setShowTip", "(Z)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends q<h>
{
  public boolean mlC;
  private final EmojiStatusView mlD;
  
  public y(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105684);
    this.mlC = paramBoolean;
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    s.s(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.mlD = ((EmojiStatusView)paramView);
    AppMethodBeat.o(105684);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105683);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = this.caK.findViewById(a.g.about_divider);
    if (this.mlC) {}
    for (int i = 0;; i = 8)
    {
      paramae.setVisibility(i);
      if (this.mlD.getEmojiInfo() == null)
      {
        paramae = (h)aVT();
        if (paramae != null) {
          this.mlD.setEmojiInfo(paramae.mgK);
        }
      }
      AppMethodBeat.o(105683);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.y
 * JD-Core Version:    0.7.0.1
 */