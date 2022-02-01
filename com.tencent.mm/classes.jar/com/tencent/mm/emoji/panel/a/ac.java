package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class ac
  extends q<ai>
{
  private final ImageView kc;
  
  public ac(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105691);
    paramView = paramView.findViewById(2131297050);
    kotlin.g.b.p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.kc = ((ImageView)paramView);
    AppMethodBeat.o(105691);
  }
  
  public final void a(com.tencent.mm.emoji.b.b.ac paramac)
  {
    AppMethodBeat.i(105690);
    kotlin.g.b.p.h(paramac, "item");
    super.a(paramac);
    paramac = (ai)this.hbh;
    if (paramac != null)
    {
      Object localObject = this.kc;
      e.gxR();
      ((ImageView)localObject).setImageDrawable(e.bid(paramac.gZf.key));
      localObject = e.gxR().bie(paramac.gZf.key);
      paramac = (com.tencent.mm.emoji.b.b.ac)localObject;
      if (Util.isNullOrNil((String)localObject))
      {
        paramac = this.aus;
        kotlin.g.b.p.g(paramac, "itemView");
        paramac = paramac.getContext().getString(2131758673);
      }
      this.kc.setContentDescription((CharSequence)paramac);
      AppMethodBeat.o(105690);
      return;
    }
    AppMethodBeat.o(105690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ac
 * JD-Core Version:    0.7.0.1
 */