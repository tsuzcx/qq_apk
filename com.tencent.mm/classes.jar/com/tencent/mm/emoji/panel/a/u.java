package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "searchMore", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/view/View;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class u
  extends s<h>
{
  private final View jMu;
  
  public u(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(227403);
    this.jMu = paramView.findViewById(a.g.search_more_emoji);
    AppMethodBeat.o(227403);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(227401);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = this.jMu;
    kotlin.g.b.p.j(paramae, "searchMore");
    paramae.setVisibility(0);
    this.jMu.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(227401);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(u paramu) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229421);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.jMv.jMs;
      if (localObject != null)
      {
        kotlin.g.b.p.j(paramView, "it");
        Context localContext = paramView.getContext();
        kotlin.g.b.p.j(localContext, "it.context");
        ((p)localObject).a(paramView, localContext, this.jMv.md(), this.jMv.jMr);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.u
 * JD-Core Version:    0.7.0.1
 */