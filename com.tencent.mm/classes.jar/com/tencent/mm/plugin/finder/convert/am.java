package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.ai;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public class am
  extends b<BaseFinderFeed>
{
  private static int KLt;
  public static final a KLu;
  
  static
  {
    AppMethodBeat.i(197476);
    KLu = new a((byte)0);
    KLt = -2;
    AppMethodBeat.o(197476);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197473);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.setTag(Integer.valueOf(KLt));
    parame.arI.setTag(Integer.valueOf(KLt));
    paramRecyclerView = (TextView)parame.abq(2131307369);
    k.g(paramRecyclerView, "tipsTv");
    ai.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    AppMethodBeat.o(197473);
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197474);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    AppMethodBeat.o(197474);
  }
  
  public final int getLayoutId()
  {
    return 2131496228;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert$Companion;", "", "()V", "VIEW_TYPE_MORE_SIMILAR", "", "getVIEW_TYPE_MORE_SIMILAR", "()I", "setVIEW_TYPE_MORE_SIMILAR", "(I)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am
 * JD-Core Version:    0.7.0.1
 */