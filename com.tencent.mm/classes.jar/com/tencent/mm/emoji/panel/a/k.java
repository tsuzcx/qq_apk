package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public class k
  extends q<h>
{
  private final TextView gnM;
  private final ImageView ka;
  
  public k(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105670);
    paramn = paramView.findViewById(2131296943);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.ka = ((ImageView)paramn);
    paramView = paramView.findViewById(2131296944);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.gnM = ((TextView)paramView);
    AppMethodBeat.o(105670);
  }
  
  public void a(ac paramac)
  {
    AppMethodBeat.i(105669);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (h)this.gnS;
    if (paramac != null)
    {
      Object localObject = com.tencent.mm.emoji.loader.e.giz;
      com.tencent.mm.emoji.loader.e.a(paramac.gjb, this.ka);
      if (paramac.gkP == 2)
      {
        this.gnM.setVisibility(0);
        localObject = g.ad(d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramac = ((d)localObject).getProvider().abv(paramac.gjb.Lb());
        this.gnM.setText((CharSequence)paramac);
        AppMethodBeat.o(105669);
        return;
      }
      if (p.i(paramac.gjb.getName(), "dice"))
      {
        paramac = this.ka;
        localObject = this.auu;
        p.g(localObject, "itemView");
        paramac.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758255));
      }
      for (;;)
      {
        this.gnM.setVisibility(8);
        AppMethodBeat.o(105669);
        return;
        if (p.i(paramac.gjb.getName(), "jsb"))
        {
          paramac = this.ka;
          localObject = this.auu;
          p.g(localObject, "itemView");
          paramac.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758265));
        }
      }
    }
    AppMethodBeat.o(105669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.k
 * JD-Core Version:    0.7.0.1
 */