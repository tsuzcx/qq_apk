package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.emoji.a.a.ae;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class w
  extends q<ae>
{
  private final ImageView ig;
  
  public w(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105691);
    paramView = paramView.findViewById(2131296943);
    k.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ig = ((ImageView)paramView);
    AppMethodBeat.o(105691);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(105690);
    k.h(paramy, "item");
    super.a(paramy);
    paramy = (ae)this.fUq;
    if (paramy != null)
    {
      Object localObject = this.ig;
      e.eXp();
      ((ImageView)localObject).setImageDrawable(e.aMf(paramy.fSm.key));
      localObject = e.eXp().aMg(paramy.fSm.key);
      paramy = (y)localObject;
      if (bs.isNullOrNil((String)localObject))
      {
        paramy = this.asD;
        k.g(paramy, "itemView");
        paramy = paramy.getContext().getString(2131758379);
      }
      this.ig.setContentDescription((CharSequence)paramy);
      AppMethodBeat.o(105690);
      return;
    }
    AppMethodBeat.o(105690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.w
 * JD-Core Version:    0.7.0.1
 */