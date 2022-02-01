package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.u;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y
  extends q<u>
{
  private final TextView gnM;
  private final View gol;
  private final TextView gom;
  private final ImageView gon;
  private final View goo;
  
  public y(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(2131299410);
    p.g(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.gnM = ((TextView)paramn);
    paramn = paramView.findViewById(2131299407);
    p.g(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.gol = paramn;
    paramn = paramView.findViewById(2131299406);
    p.g(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.gom = ((TextView)paramn);
    paramn = paramView.findViewById(2131299408);
    p.g(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.gon = ((ImageView)paramn);
    paramn = paramView.findViewById(2131299409);
    p.g(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.goo = paramn;
    paramView.setOnClickListener(null);
    this.gol.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = this.goq.gnT;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          p.g(paramAnonymousView, "it.context");
          ((n)localObject).a(paramAnonymousView, this.goq.lN(), this.goq.gnS);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(183961);
      }
    });
    AppMethodBeat.o(105705);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105704);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (u)this.gnS;
    if (paramac != null)
    {
      this.gnM.setText((CharSequence)paramac.gin.aJU());
      PersonalDesigner localPersonalDesigner = paramac.glw;
      if (localPersonalDesigner != null)
      {
        this.gom.setVisibility(0);
        this.gom.setText((CharSequence)localPersonalDesigner.Name);
        this.gon.setVisibility(0);
        this.gon.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.gip;
        localObject = com.tencent.mm.plugin.emoji.h.b.azF();
        p.g(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramac.gin.fxi();
        p.g(str1, "it.groupInfo.productID");
        String str2 = localPersonalDesigner.HeadUrl;
        p.g(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        com.tencent.mm.aw.a.a.aIP().a(localPersonalDesigner.HeadUrl, this.gon, new c.a().aIX().aIY().FE((String)localObject).aJa().aJc());
        if (paramac.glx)
        {
          this.goo.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.goo.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.gon.setImageDrawable(null);
      this.gon.setVisibility(8);
      this.gom.setVisibility(8);
      this.goo.setVisibility(8);
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