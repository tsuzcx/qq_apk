package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderSnsLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "()V", "MAX_NAME_COUNT", "", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "setItemSize", "plugin-finder_release"})
public final class cn
  extends e<y>
{
  private final String TAG = "FinderFeedLiveListItemConvert";
  private final int xlY = 5;
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(265089);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.getContext();
    p.j(paramRecyclerView, "holder.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.j(paramRecyclerView, "holder.context.resources");
    paramInt = paramRecyclerView.getDisplayMetrics().widthPixels;
    paramRecyclerView = parami.getContext();
    p.j(paramRecyclerView, "holder.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.j(paramRecyclerView, "holder.context.resources");
    float f2 = (Math.min(paramRecyclerView.getDisplayMetrics().heightPixels, paramInt) - a.fromDPToPix(parami.getContext(), 16)) / 3.5F;
    float f1 = f2;
    if (f2 <= 0.0F)
    {
      paramRecyclerView = parami.getContext();
      p.j(paramRecyclerView, "holder.context");
      f1 = paramRecyclerView.getResources().getDimension(b.d.Edge_14A);
    }
    f2 = 4.0F * f1 / 3.0F;
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    paramRecyclerView.width = ((int)f1);
    paramRecyclerView.height = ((int)f2);
    parami = parami.amk;
    p.j(parami, "holder.itemView");
    parami.setLayoutParams(paramRecyclerView);
    AppMethodBeat.o(265089);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_sns_live_list_square_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cn
 * JD-Core Version:    0.7.0.1
 */