package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.ai;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class w
  extends q<ai>
{
  private final ImageView ka;
  
  public w(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105691);
    paramView = paramView.findViewById(2131296943);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ka = ((ImageView)paramView);
    AppMethodBeat.o(105691);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105690);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (ai)this.gqo;
    if (paramac != null)
    {
      Object localObject = this.ka;
      e.fqT();
      ((ImageView)localObject).setImageDrawable(e.aTj(paramac.gol.key));
      localObject = e.fqT().aTk(paramac.gol.key);
      paramac = (ac)localObject;
      if (bu.isNullOrNil((String)localObject))
      {
        paramac = this.auu;
        p.g(paramac, "itemView");
        paramac = paramac.getContext().getString(2131758379);
      }
      this.ka.setContentDescription((CharSequence)paramac);
      AppMethodBeat.o(105690);
      return;
    }
    AppMethodBeat.o(105690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.w
 * JD-Core Version:    0.7.0.1
 */