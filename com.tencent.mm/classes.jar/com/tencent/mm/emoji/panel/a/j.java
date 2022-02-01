package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j
  extends q<com.tencent.mm.emoji.c.b.h>
{
  private final ImageView dpM;
  private final TextView mll;
  
  public j(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105670);
    paramn = paramView.findViewById(a.g.art_emoji_icon_iv);
    s.s(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.dpM = ((ImageView)paramn);
    paramView = paramView.findViewById(a.g.art_emoji_icon_text);
    s.s(paramView, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.mll = ((TextView)paramView);
    AppMethodBeat.o(105670);
  }
  
  public void a(ae paramae)
  {
    AppMethodBeat.i(105669);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (com.tencent.mm.emoji.c.b.h)aVT();
    Object localObject;
    if (paramae != null)
    {
      if (paramae.miu == 3) {
        break label155;
      }
      localObject = com.tencent.mm.emoji.b.e.mgl;
      com.tencent.mm.emoji.b.e.a(paramae.mgK, this.dpM);
    }
    while (paramae.miu == 2)
    {
      this.mll.setVisibility(0);
      localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aoi(paramae.mgK.getMd5());
      this.mll.setText((CharSequence)localObject);
      this.dpM.setContentDescription((CharSequence)localObject);
      if (com.tencent.mm.plugin.emoji.g.d.z(paramae.mgK)) {
        this.dpM.setContentDescription((CharSequence)this.caK.getContext().getString(a.j.emoji_description));
      }
      AppMethodBeat.o(105669);
      return;
      label155:
      localObject = com.tencent.mm.emoji.b.e.mgl;
      com.tencent.mm.emoji.b.e.cX((View)this.dpM);
      this.dpM.setImageResource(a.f.emoji_download_icon);
    }
    if (paramae.mgK.getMd5().equals("08f223fa83f1ca34e143d1e580252c7c")) {
      this.dpM.setContentDescription((CharSequence)this.caK.getContext().getString(a.j.emoji_dice));
    }
    for (;;)
    {
      this.mll.setVisibility(8);
      break;
      if (paramae.mgK.getMd5().equals("9bd1281af3a31710a45b84d736363691"))
      {
        this.dpM.setContentDescription((CharSequence)this.caK.getContext().getString(a.j.emoji_jsb));
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aoi(paramae.mgK.getMd5());
        this.dpM.setContentDescription((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.j
 * JD-Core Version:    0.7.0.1
 */