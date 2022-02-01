package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public class k
  extends q<h>
{
  private final TextView hbb;
  private final ImageView kc;
  
  public k(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105670);
    paramn = paramView.findViewById(2131297050);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.kc = ((ImageView)paramn);
    paramView = paramView.findViewById(2131297051);
    p.g(paramView, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.hbb = ((TextView)paramView);
    AppMethodBeat.o(105670);
  }
  
  public void a(ac paramac)
  {
    AppMethodBeat.i(105669);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (h)this.hbh;
    if (paramac != null)
    {
      Object localObject = com.tencent.mm.emoji.loader.e.gVM;
      com.tencent.mm.emoji.loader.e.a(paramac.gWm, this.kc);
      if (paramac.gYc == 2)
      {
        this.hbb.setVisibility(0);
        localObject = g.ah(d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramac = ((d)localObject).getProvider().amp(paramac.gWm.getMd5());
        this.hbb.setText((CharSequence)paramac);
        AppMethodBeat.o(105669);
        return;
      }
      if (p.j(paramac.gWm.getName(), "dice"))
      {
        paramac = this.kc;
        localObject = this.aus;
        p.g(localObject, "itemView");
        paramac.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758543));
      }
      for (;;)
      {
        this.hbb.setVisibility(8);
        AppMethodBeat.o(105669);
        return;
        if (p.j(paramac.gWm.getName(), "jsb"))
        {
          paramac = this.kc;
          localObject = this.aus;
          p.g(localObject, "itemView");
          paramac.setContentDescription((CharSequence)((View)localObject).getContext().getString(2131758553));
        }
      }
    }
    AppMethodBeat.o(105669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.k
 * JD-Core Version:    0.7.0.1
 */