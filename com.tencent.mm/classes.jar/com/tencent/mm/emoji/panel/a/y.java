package com.tencent.mm.emoji.panel.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.u;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class y
  extends q<u>
{
  private final View gqH;
  private final TextView gqI;
  private final ImageView gqJ;
  private final View gqK;
  private final TextView gqi;
  
  public y(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(2131299410);
    p.g(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.gqi = ((TextView)paramn);
    paramn = paramView.findViewById(2131299407);
    p.g(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.gqH = paramn;
    paramn = paramView.findViewById(2131299406);
    p.g(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.gqI = ((TextView)paramn);
    paramn = paramView.findViewById(2131299408);
    p.g(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.gqJ = ((ImageView)paramn);
    paramn = paramView.findViewById(2131299409);
    p.g(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.gqK = paramn;
    paramView.setOnClickListener(null);
    this.gqH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = this.gqL.gqp;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          p.g(paramAnonymousView, "it.context");
          ((n)localObject).a(paramAnonymousView, this.gqL.lN(), this.gqL.gqo);
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
    paramac = (u)this.gqo;
    if (paramac != null)
    {
      this.gqi.setText((CharSequence)paramac.gkF.aKn());
      PersonalDesigner localPersonalDesigner = paramac.gnR;
      if (localPersonalDesigner != null)
      {
        this.gqI.setVisibility(0);
        this.gqI.setText((CharSequence)localPersonalDesigner.Name);
        this.gqJ.setVisibility(0);
        this.gqJ.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.gkH;
        localObject = com.tencent.mm.plugin.emoji.h.b.azV();
        p.g(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramac.gkF.fxk();
        p.g(str1, "it.groupInfo.productID");
        String str2 = localPersonalDesigner.HeadUrl;
        p.g(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        com.tencent.mm.av.a.a.aJh().a(localPersonalDesigner.HeadUrl, this.gqJ, new c.a().aJp().aJq().Gg((String)localObject).aJs().aJu());
        if (paramac.gnS)
        {
          this.gqK.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.gqK.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.gqJ.setImageDrawable(null);
      this.gqJ.setVisibility(8);
      this.gqI.setVisibility(8);
      this.gqK.setVisibility(8);
      AppMethodBeat.o(105704);
      return;
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.y
 * JD-Core Version:    0.7.0.1
 */