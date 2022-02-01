package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.m.a.g;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "showId", "", "word", "showSearchMore", "", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;IIZ)V", "searchMore", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/widget/LinearLayout;", "getShowId", "()I", "setShowId", "(I)V", "getShowSearchMore", "()Z", "setShowSearchMore", "(Z)V", "tips", "Landroid/widget/TextView;", "getTips", "()Landroid/widget/TextView;", "getWord", "setWord", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class x
  extends s<m>
{
  private boolean jMA;
  private final TextView jMw;
  private final LinearLayout jMx;
  private int jMy;
  private int jMz;
  
  public x(View paramView, p paramp, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramp);
    AppMethodBeat.i(224412);
    this.jMy = paramInt1;
    this.jMz = paramInt2;
    this.jMA = paramBoolean;
    this.jMw = ((TextView)paramView.findViewById(this.jMy));
    this.jMx = ((LinearLayout)paramView.findViewById(a.g.search_more));
    paramView.setOnClickListener(null);
    AppMethodBeat.o(224412);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(224408);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = this.amk;
    if (paramae == null)
    {
      paramae = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(224408);
      throw paramae;
    }
    paramae = ((Iterable)i.ou(0, ((ViewGroup)paramae).getChildCount())).iterator();
    while (paramae.hasNext())
    {
      int i = ((ab)paramae).zD();
      localObject = ((ViewGroup)this.amk).getChildAt(i);
      kotlin.g.b.p.j(localObject, "itemView.getChildAt(it)");
      ((View)localObject).setVisibility(8);
    }
    paramae = this.jMw;
    kotlin.g.b.p.j(paramae, "tips");
    Object localObject = this.jMw;
    kotlin.g.b.p.j(localObject, "tips");
    paramae.setText((CharSequence)((TextView)localObject).getContext().getString(this.jMz));
    paramae = this.jMw;
    kotlin.g.b.p.j(paramae, "tips");
    paramae.setVisibility(0);
    if (this.jMA)
    {
      paramae = this.jMx;
      kotlin.g.b.p.j(paramae, "searchMore");
      paramae.setVisibility(0);
      this.jMx.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(224408);
      return;
    }
    paramae = this.jMx;
    kotlin.g.b.p.j(paramae, "searchMore");
    paramae.setVisibility(8);
    AppMethodBeat.o(224408);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225392);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.jMB.jMs;
      if (localObject != null)
      {
        kotlin.g.b.p.j(paramView, "it");
        Context localContext = paramView.getContext();
        kotlin.g.b.p.j(localContext, "it.context");
        ((p)localObject).a(paramView, localContext, this.jMB.md(), this.jMB.jMr);
      }
      a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.x
 * JD-Core Version:    0.7.0.1
 */