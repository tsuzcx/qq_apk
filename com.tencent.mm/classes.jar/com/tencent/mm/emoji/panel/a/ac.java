package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.ak;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.o;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends q<ak>
{
  private final ImageView dpM;
  
  public ac(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105691);
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    s.s(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.dpM = ((ImageView)paramView);
    AppMethodBeat.o(105691);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105690);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (ak)aVT();
    if (paramae != null)
    {
      Object localObject = this.dpM;
      o.iVl();
      ((ImageView)localObject).setImageDrawable(o.buC(paramae.mjw.key));
      localObject = o.iVl().buD(paramae.mjw.key);
      paramae = (ae)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        paramae = this.caK.getContext().getString(a.j.emoji_store_title);
      }
      this.dpM.setContentDescription((CharSequence)paramae);
    }
    AppMethodBeat.o(105690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ac
 * JD-Core Version:    0.7.0.1
 */