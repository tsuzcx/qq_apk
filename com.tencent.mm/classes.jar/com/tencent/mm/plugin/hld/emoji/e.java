package com.tencent.mm.plugin.hld.emoji;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "getContentRv", "()Landroidx/recyclerview/widget/RecyclerView;", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "rootLl", "Landroid/widget/LinearLayout;", "getRootLl", "()Landroid/widget/LinearLayout;", "subType", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
{
  final a Jpg;
  public final RecyclerView Jph;
  k Jpi;
  private final LinearLayout pKH;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312698);
    this.Jpg = parama;
    parama = paramView.findViewById(a.f.root_view);
    s.s(parama, "itemView.findViewById(R.id.root_view)");
    this.pKH = ((LinearLayout)parama);
    paramView = paramView.findViewById(a.f.root);
    s.s(paramView, "itemView.findViewById(R.id.root)");
    this.Jph = ((RecyclerView)paramView);
    AppMethodBeat.o(312698);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/emoji/ImeEmojiContentViewHolder$fillContent$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends GridLayoutManager.b
  {
    a(e parame) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(312663);
      Object localObject = this.Jpj.Jph.getAdapter();
      if ((localObject != null) && (((RecyclerView.a)localObject).getItemViewType(paramInt) == 1)) {
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        localObject = com.tencent.mm.plugin.hld.f.k.JyF;
        if (com.tencent.mm.plugin.hld.f.k.isLandscape())
        {
          AppMethodBeat.o(312663);
          return 11;
          paramInt = 0;
        }
        else
        {
          AppMethodBeat.o(312663);
          return 7;
        }
      }
      AppMethodBeat.o(312663);
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
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