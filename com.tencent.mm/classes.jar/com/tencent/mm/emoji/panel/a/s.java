package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "searchMore", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/view/View;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class s
  extends q<h>
{
  private final View hbk;
  
  public s(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(199973);
    this.hbk = paramView.findViewById(2131307409);
    AppMethodBeat.o(199973);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(199972);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = this.hbk;
    p.g(paramac, "searchMore");
    paramac.setVisibility(0);
    this.hbk.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(199972);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199971);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = this.hbl.hbi;
      if (localObject != null)
      {
        p.g(paramView, "it");
        Context localContext = paramView.getContext();
        p.g(localContext, "it.context");
        ((n)localObject).a(paramView, localContext, this.hbl.lR(), this.hbl.hbh);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiHeadViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.s
 * JD-Core Version:    0.7.0.1
 */