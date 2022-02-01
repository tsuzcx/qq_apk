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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroidx/recyclerview/widget/RecyclerView;", "exceptionTipRl", "Landroid/widget/RelativeLayout;", "getListener", "()Lcom/tencent/mm/plugin/hld/emoji/IEmojiContentViewListener;", "subType", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getSpanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends RecyclerView.v
{
  RelativeLayout JpL;
  final a Jpg;
  RecyclerView Jph;
  k Jpi;
  
  public n(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(312685);
    this.Jpg = parama;
    parama = paramView.findViewById(a.f.root);
    s.s(parama, "itemView.findViewById(R.id.root)");
    this.Jph = ((RecyclerView)parama);
    paramView = paramView.findViewById(a.f.emoji_exception_tip_rl);
    s.s(paramView, "itemView.findViewById(R.id.emoji_exception_tip_rl)");
    this.JpL = ((RelativeLayout)paramView);
    AppMethodBeat.o(312685);
  }
  
  static RecyclerView.h gl(Context paramContext)
  {
    AppMethodBeat.i(312693);
    paramContext = new a.a(paramContext).YL(a.d.ime_divider_size).YK(a.d.ime_divider_size).YJ(a.c.ime_divider_color);
    paramContext.HNS = true;
    paramContext = (RecyclerView.h)paramContext.fPp();
    AppMethodBeat.o(312693);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(n paramn, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/emoji/ImeKaoEmojiContentViewHolder$getSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends GridLayoutManager.b
  {
    b(n paramn) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(312681);
      RecyclerView.a locala = n.a(this.JpM).getAdapter();
      if (locala == null)
      {
        AppMethodBeat.o(312681);
        return 1;
      }
      paramInt = locala.getItemViewType(paramInt);
      AppMethodBeat.o(312681);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.n
 * JD-Core Version:    0.7.0.1
 */