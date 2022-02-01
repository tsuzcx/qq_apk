package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedBulletSubtitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorItemPaddingStart", "", "getAuthorItemPaddingStart", "()I", "authorItemPaddingStart$delegate", "Lkotlin/Lazy;", "normalPaddingStart", "getNormalPaddingStart", "normalPaddingStart$delegate", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class h
  extends e<s>
{
  final Context context;
  private final f xgU;
  private final f xgV;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(273394);
    this.context = paramContext;
    this.xgU = g.ar((a)new b(this));
    this.xgV = g.ar((a)new a(this));
    AppMethodBeat.o(273394);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(273388);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.RD(b.f.tv_bullet_subtitle);
    p.j(paramRecyclerView, "it");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(273388);
  }
  
  public final int getLayoutId()
  {
    return b.g.feed_bullet_subtitle_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    b(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h
 * JD-Core Version:    0.7.0.1
 */