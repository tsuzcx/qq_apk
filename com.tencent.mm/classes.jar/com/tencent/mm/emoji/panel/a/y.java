package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y
  extends q<com.tencent.mm.emoji.a.a.q>
{
  private final View fQO;
  private final TextView fQP;
  private final ImageView fQQ;
  private final View fQR;
  private final TextView fQp;
  
  public y(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(2131299410);
    k.g(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.fQp = ((TextView)paramn);
    paramn = paramView.findViewById(2131299407);
    k.g(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.fQO = paramn;
    paramn = paramView.findViewById(2131299406);
    k.g(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.fQP = ((TextView)paramn);
    paramn = paramView.findViewById(2131299408);
    k.g(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.fQQ = ((ImageView)paramn);
    paramn = paramView.findViewById(2131299409);
    k.g(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.fQR = paramn;
    paramView.setOnClickListener(null);
    this.fQO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        n localn = this.fQS.fQw;
        if (localn != null)
        {
          k.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          k.g(paramAnonymousView, "it.context");
          localn.a(paramAnonymousView, this.fQS.ln(), this.fQS.fQv);
          AppMethodBeat.o(183961);
          return;
        }
        AppMethodBeat.o(183961);
      }
    });
    AppMethodBeat.o(105705);
  }
  
  public final void a(com.tencent.mm.emoji.a.a.y paramy)
  {
    AppMethodBeat.i(105704);
    k.h(paramy, "item");
    super.a(paramy);
    paramy = (com.tencent.mm.emoji.a.a.q)this.fQv;
    if (paramy != null)
    {
      this.fQp.setText((CharSequence)paramy.fLb.azT());
      PersonalDesigner localPersonalDesigner = paramy.fOh;
      if (localPersonalDesigner != null)
      {
        this.fQP.setVisibility(0);
        this.fQP.setText((CharSequence)localPersonalDesigner.Name);
        this.fQQ.setVisibility(0);
        this.fQQ.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.fLd;
        localObject = com.tencent.mm.plugin.emoji.h.b.aqb();
        k.g(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramy.fLb.fZJ();
        k.g(str1, "it.groupInfo.productID");
        String str2 = localPersonalDesigner.HeadUrl;
        k.g(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        a.ayO().a(localPersonalDesigner.HeadUrl, this.fQQ, new c.a().ayX().ayY().yv((String)localObject).aza().azc());
        if (paramy.fOi)
        {
          this.fQR.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.fQR.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.fQQ.setImageDrawable(null);
      this.fQQ.setVisibility(8);
      this.fQP.setVisibility(8);
      this.fQR.setVisibility(8);
      AppMethodBeat.o(105704);
      return;
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.y
 * JD-Core Version:    0.7.0.1
 */