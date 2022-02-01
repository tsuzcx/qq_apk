package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.loader.b.a;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class ae
  extends q<u>
{
  private final View hbG;
  private final TextView hbH;
  private final ImageView hbI;
  private final View hbJ;
  private final TextView hbb;
  
  public ae(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105705);
    paramn = paramView.findViewById(2131300023);
    p.g(paramn, "itemView.findViewById(R.…ji_panel_title_item_text)");
    this.hbb = ((TextView)paramn);
    paramn = paramView.findViewById(2131300020);
    p.g(paramn, "itemView.findViewById(R.…nel_title_designer_group)");
    this.hbG = paramn;
    paramn = paramView.findViewById(2131300019);
    p.g(paramn, "itemView.findViewById(R.…oji_panel_title_designer)");
    this.hbH = ((TextView)paramn);
    paramn = paramView.findViewById(2131300021);
    p.g(paramn, "itemView.findViewById(R.…anel_title_designer_icon)");
    this.hbI = ((ImageView)paramn);
    paramn = paramView.findViewById(2131300022);
    p.g(paramn, "itemView.findViewById(R.…l_title_designer_red_dot)");
    this.hbJ = paramn;
    paramView.setOnClickListener(null);
    this.hbG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183961);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = this.hbK.hbi;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          p.g(localContext, "it.context");
          ((n)localObject).a(paramAnonymousView, localContext, this.hbK.lR(), this.hbK.hbh);
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
    paramac = (u)this.hbh;
    if (paramac != null)
    {
      this.hbb.setText((CharSequence)paramac.gVA.beq());
      PersonalDesigner localPersonalDesigner = paramac.gYM;
      if (localPersonalDesigner != null)
      {
        this.hbH.setVisibility(0);
        this.hbH.setText((CharSequence)localPersonalDesigner.Name);
        this.hbI.setVisibility(0);
        this.hbI.setImageDrawable(null);
        Object localObject = com.tencent.mm.emoji.loader.b.gVC;
        localObject = com.tencent.mm.plugin.emoji.h.b.aTd();
        p.g(localObject, "EmojiUtils.getAccEmojiPath()");
        String str1 = paramac.gVA.hRu();
        p.g(str1, "it.groupInfo.productID");
        String str2 = localPersonalDesigner.HeadUrl;
        p.g(str2, "designerInfo.HeadUrl");
        localObject = b.a.j((String)localObject, str1, str2);
        com.tencent.mm.av.a.a.bdb().a(localPersonalDesigner.HeadUrl, this.hbI, new c.a().bdo().bdp().OS((String)localObject).bdt().bdv());
        if (paramac.gYN)
        {
          this.hbJ.setVisibility(0);
          AppMethodBeat.o(105704);
          return;
        }
        this.hbJ.setVisibility(8);
        AppMethodBeat.o(105704);
        return;
      }
      this.hbI.setImageDrawable(null);
      this.hbI.setVisibility(8);
      this.hbH.setVisibility(8);
      this.hbJ.setVisibility(8);
      AppMethodBeat.o(105704);
      return;
    }
    AppMethodBeat.o(105704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ae
 * JD-Core Version:    0.7.0.1
 */