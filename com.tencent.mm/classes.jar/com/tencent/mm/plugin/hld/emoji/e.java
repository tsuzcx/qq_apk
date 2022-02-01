package com.tencent.mm.plugin.hld.emoji;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "getContentRv", "()Landroidx/recyclerview/widget/RecyclerView;", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "rootLl", "Landroid/widget/LinearLayout;", "getRootLl", "()Landroid/widget/LinearLayout;", "subType", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "plugin-hld_release"})
public final class e
  extends RecyclerView.v
{
  public final RecyclerView Dwa;
  k Dwb;
  final a Dwc;
  private final LinearLayout mNZ;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(209916);
    this.Dwc = parama;
    parama = paramView.findViewById(a.f.root_view);
    p.j(parama, "itemView.findViewById(R.id.root_view)");
    this.mNZ = ((LinearLayout)parama);
    paramView = paramView.findViewById(a.f.root);
    p.j(paramView, "itemView.findViewById(R.id.root)");
    this.Dwa = ((RecyclerView)paramView);
    AppMethodBeat.o(209916);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder$fillContent$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"})
  public static final class a
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      AppMethodBeat.i(210261);
      Object localObject = this.Dwd.Dwa.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemViewType(paramInt) == 1))
      {
        localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        if (com.tencent.mm.plugin.hld.f.k.isLandscape())
        {
          AppMethodBeat.o(210261);
          return 11;
        }
        AppMethodBeat.o(210261);
        return 7;
      }
      AppMethodBeat.o(210261);
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.e
 * JD-Core Version:    0.7.0.1
 */