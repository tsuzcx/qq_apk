package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.view.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "exceptionTipRl", "Landroid/widget/RelativeLayout;", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "subType", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getSpanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "plugin-hld_release"})
public final class n
  extends RecyclerView.v
{
  RelativeLayout DwF;
  RecyclerView Dwa;
  k Dwb;
  final a Dwc;
  
  public n(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(210767);
    this.Dwc = parama;
    parama = paramView.findViewById(a.f.root);
    p.j(parama, "itemView.findViewById(R.id.root)");
    this.Dwa = ((RecyclerView)parama);
    paramView = paramView.findViewById(a.f.emoji_exception_tip_rl);
    p.j(paramView, "itemView.findViewById(R.id.emoji_exception_tip_rl)");
    this.DwF = ((RelativeLayout)paramView);
    AppMethodBeat.o(210767);
  }
  
  static RecyclerView.h fn(Context paramContext)
  {
    AppMethodBeat.i(210765);
    paramContext = new a.a(paramContext).UN(a.d.ime_divider_size).UM(a.d.ime_divider_size).UL(a.c.ime_divider_color);
    paramContext.CbQ = true;
    paramContext = (RecyclerView.h)paramContext.eHD();
    AppMethodBeat.o(210765);
    return paramContext;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(n paramn, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder$getSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"})
  public static final class b
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      AppMethodBeat.i(211040);
      RecyclerView.a locala = n.a(this.DwG).getAdapter();
      if (locala != null)
      {
        paramInt = locala.getItemViewType(paramInt);
        AppMethodBeat.o(211040);
        return paramInt;
      }
      AppMethodBeat.o(211040);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.n
 * JD-Core Version:    0.7.0.1
 */