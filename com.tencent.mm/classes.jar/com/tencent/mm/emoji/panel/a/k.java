package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public class k
  extends q<h>
{
  private final TextView fQp;
  private final ImageView hg;
  
  public k(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105670);
    paramn = paramView.findViewById(2131296943);
    d.g.b.k.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.hg = ((ImageView)paramn);
    paramView = paramView.findViewById(2131296944);
    d.g.b.k.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.fQp = ((TextView)paramView);
    AppMethodBeat.o(105670);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(105669);
    d.g.b.k.h(paramy, "item");
    super.a(paramy);
    paramy = (h)this.fQv;
    if (paramy != null)
    {
      Object localObject = com.tencent.mm.emoji.loader.e.fLn;
      com.tencent.mm.emoji.loader.e.a(paramy.fLP, this.hg);
      if (paramy.fNE == 2)
      {
        this.fQp.setVisibility(0);
        localObject = g.ad(d.class);
        d.g.b.k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramy = ((d)localObject).getProvider().TD(paramy.fLP.JS());
        this.fQp.setText((CharSequence)paramy);
        AppMethodBeat.o(105669);
        return;
      }
      if (d.g.b.k.g(paramy.fLP.getName(), "dice"))
      {
        paramy = this.hg;
        localObject = this.arI;
        d.g.b.k.g(localObject, "itemView");
        paramy.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758255));
      }
      for (;;)
      {
        this.fQp.setVisibility(8);
        AppMethodBeat.o(105669);
        return;
        if (d.g.b.k.g(paramy.fLP.getName(), "jsb"))
        {
          paramy = this.hg;
          localObject = this.arI;
          d.g.b.k.g(localObject, "itemView");
          paramy.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758265));
        }
      }
    }
    AppMethodBeat.o(105669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.k
 * JD-Core Version:    0.7.0.1
 */