package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.b;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class bg
  extends e<b>
{
  private static int xns;
  public static final a xnt;
  
  static
  {
    AppMethodBeat.i(282403);
    xnt = new a((byte)0);
    xns = -2;
    AppMethodBeat.o(282403);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(282400);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami.setTag(Integer.valueOf(xns));
    parami.amk.setTag(Integer.valueOf(xns));
    paramRecyclerView = (TextView)parami.RD(b.f.finder_similar_feed_tv);
    p.j(paramRecyclerView, "tipsTv");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(282400);
  }
  
  public void a(i parami, b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(282401);
    p.k(parami, "holder");
    p.k(paramb, "item");
    AppMethodBeat.o(282401);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_more_similar_feed_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert$Companion;", "", "()V", "VIEW_TYPE_MORE_SIMILAR", "", "getVIEW_TYPE_MORE_SIMILAR", "()I", "setVIEW_TYPE_MORE_SIMILAR", "(I)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bg
 * JD-Core Version:    0.7.0.1
 */