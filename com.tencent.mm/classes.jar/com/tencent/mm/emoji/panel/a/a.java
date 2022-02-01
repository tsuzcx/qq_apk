package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.t;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/view/View;", "plugin-emojisdk_release"})
public final class a
  extends q<t>
{
  private final View hax;
  
  public a(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105627);
    this.hax = paramView.findViewById(2131297999);
    paramView.setOnClickListener(null);
    this.hax.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(105626);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = this.hay.hbi;
        if (localObject != null)
        {
          p.g(paramAnonymousView, "it");
          Context localContext = paramAnonymousView.getContext();
          p.g(localContext, "it.context");
          ((n)localObject).a(paramAnonymousView, localContext, this.hay.lR(), this.hay.hbh);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/CaptureEmptyViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105626);
      }
    });
    paramView = this.hax;
    p.g(paramView, "icon");
    paramn = this.hax;
    p.g(paramn, "icon");
    paramView.setContentDescription((CharSequence)paramn.getContext().getString(2131756946));
    AppMethodBeat.o(105627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.a
 * JD-Core Version:    0.7.0.1
 */