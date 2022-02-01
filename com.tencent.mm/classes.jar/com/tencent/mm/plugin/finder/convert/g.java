package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedBulletSubtitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorItemPaddingStart", "", "getAuthorItemPaddingStart", "()I", "authorItemPaddingStart$delegate", "Lkotlin/Lazy;", "normalPaddingStart", "getNormalPaddingStart", "normalPaddingStart$delegate", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class g
  extends e<s>
{
  final Context context;
  private final f tzj;
  private final f tzk;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(242783);
    this.context = paramContext;
    this.tzj = kotlin.g.ah((a)new b(this));
    this.tzk = kotlin.g.ah((a)new a(this));
    AppMethodBeat.o(242783);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(242781);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (TextView)paramh.Mn(2131309462);
    p.g(paramRecyclerView, "it");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(242781);
  }
  
  public final int getLayoutId()
  {
    return 2131494167;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g
 * JD-Core Version:    0.7.0.1
 */