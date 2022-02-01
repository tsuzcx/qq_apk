package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class ag
  extends s<w>
{
  private final View jMQ;
  private final TextView jMR;
  private final ImageView jMS;
  private final View jMT;
  private final TextView jMg;
  
  public ag(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105705);
    paramp = paramView.findViewById(a.g.emoji_panel_title_item_text);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.jMg = ((TextView)paramp);
    paramp = paramView.findViewById(a.g.emoji_panel_title_designer_group);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…nel_title_designer_group)");
    this.jMQ = paramp;
    paramp = paramView.findViewById(a.g.emoji_panel_title_designer);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.jMR = ((TextView)paramp);
    paramp = paramView.findViewById(a.g.emoji_panel_title_designer_icon);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.jMS = ((ImageView)paramp);
    paramp = paramView.findViewById(a.g.emoji_panel_title_designer_red_dot);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.jMT = paramp;
    paramView.setOnClickListener(null);
    this.jMQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.jMU.jMs;
        if (localObject != null)
        {
          kotlin.g.b.p.j(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          kotlin.g.b.p.j(localContext, "it.context");
          ((p)localObject).a(paramAnonymousView, localContext, this.jMU.md(), this.jMU.jMr);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183961);
      }
    });
    AppMethodBeat.o(105705);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105704);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (w)this.jMr;
    if (paramae != null)
    {
      this.jMg.setText((CharSequence)paramae.jGw.bnP());
      dkv localdkv = paramae.jJM;
      if (localdkv != null)
      {
        this.jMR.setVisibility(0);
        this.jMR.setText((CharSequence)localdkv.CMP);
        this.jMS.setVisibility(0);
        this.jMS.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.jGy;
        localObject = com.tencent.mm.plugin.emoji.i.b.bcb();
        kotlin.g.b.p.j(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramae.jGw.hBl();
        kotlin.g.b.p.j(str1, "it.groupInfo.productID");
        String str2 = localdkv.SuR;
        kotlin.g.b.p.j(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        com.tencent.mm.ay.a.a.bms().a(localdkv.SuR, this.jMS, new c.a().gs(true).bmF().Wq((String)localObject).bmJ().bmL());
        if (paramae.jJN)
        {
          this.jMT.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.jMT.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.jMS.setImageDrawable(null);
      this.jMS.setVisibility(8);
      this.jMR.setVisibility(8);
      this.jMT.setVisibility(8);
      AppMethodBeat.o(105704);
      return;
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ag
 * JD-Core Version:    0.7.0.1
 */