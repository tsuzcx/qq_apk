package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public class l
  extends s<com.tencent.mm.emoji.b.b.h>
{
  private final ImageView bwJ;
  private final TextView jMg;
  
  public l(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105670);
    paramp = paramView.findViewById(a.g.art_emoji_icon_iv);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.bwJ = ((ImageView)paramp);
    paramView = paramView.findViewById(a.g.art_emoji_icon_text);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.jMg = ((TextView)paramView);
    AppMethodBeat.o(105670);
  }
  
  public void a(ae paramae)
  {
    AppMethodBeat.i(105669);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (com.tencent.mm.emoji.b.b.h)this.jMr;
    if (paramae != null)
    {
      Object localObject;
      if (paramae.jJc != 3)
      {
        localObject = com.tencent.mm.emoji.loader.e.jGI;
        com.tencent.mm.emoji.loader.e.a(paramae.jHh, this.bwJ);
      }
      while (paramae.jJc == 2)
      {
        this.jMg.setVisibility(0);
        localObject = com.tencent.mm.kernel.h.ag(d.class);
        kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramae = ((d)localObject).getProvider().auh(paramae.jHh.getMd5());
        this.jMg.setText((CharSequence)paramae);
        AppMethodBeat.o(105669);
        return;
        localObject = com.tencent.mm.emoji.loader.e.jGI;
        com.tencent.mm.emoji.loader.e.cD((View)this.bwJ);
        this.bwJ.setImageResource(a.f.emoji_download_icon);
      }
      if (kotlin.g.b.p.h(paramae.jHh.getName(), "dice"))
      {
        paramae = this.bwJ;
        localObject = this.amk;
        kotlin.g.b.p.j(localObject, "itemView");
        paramae.setContentDescription((CharSequence)((View)localObject).getContext().getString(a.j.emoji_dice));
      }
      for (;;)
      {
        this.jMg.setVisibility(8);
        AppMethodBeat.o(105669);
        return;
        if (kotlin.g.b.p.h(paramae.jHh.getName(), "jsb"))
        {
          paramae = this.bwJ;
          localObject = this.amk;
          kotlin.g.b.p.j(localObject, "itemView");
          paramae.setContentDescription((CharSequence)((View)localObject).getContext().getString(a.j.emoji_jsb));
        }
        else
        {
          paramae = this.bwJ;
          localObject = this.amk;
          kotlin.g.b.p.j(localObject, "itemView");
          paramae.setContentDescription((CharSequence)((View)localObject).getContext().getString(a.j.emoji_description));
        }
      }
    }
    AppMethodBeat.o(105669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.l
 * JD-Core Version:    0.7.0.1
 */