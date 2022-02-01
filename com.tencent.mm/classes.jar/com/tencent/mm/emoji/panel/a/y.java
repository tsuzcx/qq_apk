package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y
  extends q<com.tencent.mm.emoji.a.a.q>
{
  private final View fUJ;
  private final TextView fUK;
  private final ImageView fUL;
  private final View fUM;
  private final TextView fUk;
  
  public y(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(2131299410);
    k.g(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.fUk = ((TextView)paramn);
    paramn = paramView.findViewById(2131299407);
    k.g(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.fUJ = paramn;
    paramn = paramView.findViewById(2131299406);
    k.g(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.fUK = ((TextView)paramn);
    paramn = paramView.findViewById(2131299408);
    k.g(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.fUL = ((ImageView)paramn);
    paramn = paramView.findViewById(2131299409);
    k.g(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.fUM = paramn;
    paramView.setOnClickListener(null);
    this.fUJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        n localn = this.fUN.fUr;
        if (localn != null)
        {
          k.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          k.g(paramAnonymousView, "it.context");
          localn.a(paramAnonymousView, this.fUN.lv(), this.fUN.fUq);
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
    paramy = (com.tencent.mm.emoji.a.a.q)this.fUq;
    if (paramy != null)
    {
      this.fUk.setText((CharSequence)paramy.fON.aGJ());
      PersonalDesigner localPersonalDesigner = paramy.fRS;
      if (localPersonalDesigner != null)
      {
        this.fUK.setVisibility(0);
        this.fUK.setText((CharSequence)localPersonalDesigner.Name);
        this.fUL.setVisibility(0);
        this.fUL.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.fOP;
        localObject = com.tencent.mm.plugin.emoji.h.b.awQ();
        k.g(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramy.fON.fdm();
        k.g(str1, "it.groupInfo.productID");
        String str2 = localPersonalDesigner.HeadUrl;
        k.g(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        a.aFG().a(localPersonalDesigner.HeadUrl, this.fUL, new c.a().aFO().aFP().CA((String)localObject).aFR().aFT());
        if (paramy.fRT)
        {
          this.fUM.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.fUM.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.fUL.setImageDrawable(null);
      this.fUL.setVisibility(8);
      this.fUK.setVisibility(8);
      this.fUM.setVisibility(8);
      AppMethodBeat.o(105704);
      return;
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.y
 * JD-Core Version:    0.7.0.1
 */