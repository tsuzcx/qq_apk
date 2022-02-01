package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderSnsLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "()V", "MAX_NAME_COUNT", "", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "setItemSize", "plugin-finder_release"})
public final class cg
  extends e<y>
{
  private final String TAG = "FinderFeedLiveListItemConvert";
  private final int tDx = 5;
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243278);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.getContext();
    p.g(paramRecyclerView, "holder.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.g(paramRecyclerView, "holder.context.resources");
    paramInt = paramRecyclerView.getDisplayMetrics().widthPixels;
    paramRecyclerView = paramh.getContext();
    p.g(paramRecyclerView, "holder.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.g(paramRecyclerView, "holder.context.resources");
    float f2 = (Math.min(paramRecyclerView.getDisplayMetrics().heightPixels, paramInt) - a.fromDPToPix(paramh.getContext(), 16)) / 3.5F;
    float f1 = f2;
    if (f2 <= 0.0F)
    {
      paramRecyclerView = paramh.getContext();
      p.g(paramRecyclerView, "holder.context");
      f1 = paramRecyclerView.getResources().getDimension(2131165283);
    }
    f2 = 4.0F * f1 / 3.0F;
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    paramRecyclerView.width = ((int)f1);
    paramRecyclerView.height = ((int)f2);
    paramh = paramh.aus;
    p.g(paramh, "holder.itemView");
    paramh.setLayoutParams(paramRecyclerView);
    AppMethodBeat.o(243278);
  }
  
  public final int getLayoutId()
  {
    return 2131494635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cg
 * JD-Core Version:    0.7.0.1
 */