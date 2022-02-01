package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.m;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.i;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EntrancePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends q<m>
{
  private final ImageView dpM;
  
  public k(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105672);
    paramView = paramView.findViewById(a.g.art_emoji_icon_iv);
    s.s(paramView, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.dpM = ((ImageView)paramView);
    AppMethodBeat.o(105672);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105671);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (m)aVT();
    if (paramae != null)
    {
      if (paramae.miZ == 0)
      {
        this.dpM.setImageDrawable(bb.m(this.dpM.getContext(), a.i.emoji_add_custom, this.dpM.getContext().getResources().getColor(a.d.icon_color)));
        this.dpM.setContentDescription((CharSequence)this.dpM.getContext().getString(a.j.settings_single_emoji_manager));
        AppMethodBeat.o(105671);
        return;
      }
      if (paramae.miZ == 1)
      {
        this.dpM.setImageDrawable(bb.m(this.dpM.getContext(), a.i.emoji_add_capture, this.dpM.getContext().getResources().getColor(a.d.icon_color)));
        this.dpM.setContentDescription((CharSequence)this.dpM.getContext().getString(a.j.capture_emoji_entrance_desc));
      }
    }
    AppMethodBeat.o(105671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.k
 * JD-Core Version:    0.7.0.1
 */