package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.a;
import com.tencent.mm.emoji.c.b.w;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends q<w>
{
  private final View mlP;
  private final TextView mlQ;
  private final ImageView mlR;
  private final View mlS;
  private final TextView mll;
  
  public ae(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(a.g.emoji_panel_title_item_text);
    s.s(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.mll = ((TextView)paramn);
    paramn = paramView.findViewById(a.g.emoji_panel_title_designer_group);
    s.s(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.mlP = paramn;
    paramn = paramView.findViewById(a.g.emoji_panel_title_designer);
    s.s(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.mlQ = ((TextView)paramn);
    paramn = paramView.findViewById(a.g.emoji_panel_title_designer_icon);
    s.s(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.mlR = ((ImageView)paramn);
    paramn = paramView.findViewById(a.g.emoji_panel_title_designer_red_dot);
    s.s(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.mlS = paramn;
    paramView.setOnClickListener(null);
    this.mlP.setOnClickListener(new ae..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(105705);
  }
  
  private static final void a(ae paramae, View paramView)
  {
    AppMethodBeat.i(242411);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramae);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramae, "this$0");
    localObject1 = paramae.aVS();
    if (localObject1 != null)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "it.context");
      ((n)localObject1).a(paramView, (Context)localObject2, paramae.KJ(), paramae.aVT());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242411);
  }
  
  public final void a(com.tencent.mm.emoji.c.b.ae paramae)
  {
    AppMethodBeat.i(105704);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (w)aVT();
    if (paramae != null)
    {
      this.mll.setText((CharSequence)paramae.mgd.field_packName);
      this.mll.setContentDescription((CharSequence)paramae.mgd.field_packName);
      Object localObject1 = paramae.mje;
      if (localObject1 != null)
      {
        this.mlQ.setVisibility(0);
        this.mlQ.setText((CharSequence)((gok)localObject1).IGU);
        this.mlP.setContentDescription((CharSequence)s.X(((gok)localObject1).IGU, this.mlP.getContext().getString(a.j.emoji_artist_details_description)));
        this.mll.setContentDescription((CharSequence)s.X(this.mll.getContext().getString(a.j.emoji_sets_description), paramae.mgd.field_packName));
        this.mlR.setVisibility(0);
        this.mlR.setImageDrawable(null);
        Object localObject2 = com.tencent.mm.emoji.b.b.mge;
        localObject2 = d.bzQ();
        s.s(localObject2, "getAccEmojiPath()");
        Object localObject3 = paramae.mgd.field_productID;
        s.s(localObject3, "it.groupInfo.productID");
        Object localObject4 = ((gok)localObject1).ZuK;
        s.s(localObject4, "designerInfo.HeadUrl");
        localObject2 = b.a.o((String)localObject2, (String)localObject3, (String)localObject4);
        localObject3 = com.tencent.mm.modelimage.loader.a.bKl();
        localObject1 = ((gok)localObject1).ZuK;
        localObject4 = this.mlR;
        c.a locala = new c.a();
        locala.oKn = true;
        locala.oKp = true;
        locala.fullPath = ((String)localObject2);
        locala.nrc = true;
        ((com.tencent.mm.modelimage.loader.a)localObject3).a((String)localObject1, (ImageView)localObject4, locala.bKx());
        if (paramae.mjf)
        {
          this.mlS.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.mlS.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.mlR.setImageDrawable(null);
      this.mlR.setVisibility(8);
      this.mlQ.setVisibility(8);
      this.mlS.setVisibility(8);
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ae
 * JD-Core Version:    0.7.0.1
 */