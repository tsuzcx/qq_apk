package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedBulletSubtitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorItemPaddingStart", "", "getAuthorItemPaddingStart", "()I", "authorItemPaddingStart$delegate", "Lkotlin/Lazy;", "normalPaddingStart", "getNormalPaddingStart", "normalPaddingStart$delegate", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class d
  extends b<m>
{
  final Context context;
  private final f rMa;
  private final f rMb;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(201311);
    this.context = paramContext;
    this.rMa = g.O((a)new b(this));
    this.rMb = g.O((a)new a(this));
    AppMethodBeat.o(201311);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201309);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = (TextView)parame.Gd(2131308222);
    p.g(paramRecyclerView, "it");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(201309);
  }
  
  public final int getLayoutId()
  {
    return 2131496388;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d
 * JD-Core Version:    0.7.0.1
 */