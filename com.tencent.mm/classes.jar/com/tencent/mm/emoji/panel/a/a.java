package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.p;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/view/View;", "plugin-emojisdk_release"})
public final class a
  extends q<p>
{
  private final View fTE;
  
  public a(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105627);
    this.fTE = paramView.findViewById(2131297704);
    paramView.setOnClickListener(null);
    this.fTE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105626);
        n localn = this.fTF.fUr;
        if (localn != null)
        {
          k.g(paramAnonymousView, "it");
          paramAnonymousView = paramAnonymousView.getContext();
          k.g(paramAnonymousView, "it.context");
          localn.a(paramAnonymousView, this.fTF.lv(), this.fTF.fUq);
          AppMethodBeat.o(105626);
          return;
        }
        AppMethodBeat.o(105626);
      }
    });
    paramView = this.fTE;
    k.g(paramView, "icon");
    paramn = this.fTE;
    k.g(paramn, "icon");
    paramView.setContentDescription((CharSequence)paramn.getContext().getString(2131756781));
    AppMethodBeat.o(105627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.a
 * JD-Core Version:    0.7.0.1
 */