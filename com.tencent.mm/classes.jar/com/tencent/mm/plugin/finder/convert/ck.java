package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderTopicFilterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "()V", "TAG", "", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ck
  extends e<bl>
{
  private final String TAG = "Finder.FinderTopicFilterConvert";
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243370);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (TextView)paramh.Mn(2131309359);
    if (paramRecyclerView != null)
    {
      paramRecyclerView.setTextSize(1, 12.0F);
      AppMethodBeat.o(243370);
      return;
    }
    AppMethodBeat.o(243370);
  }
  
  public final int getLayoutId()
  {
    return 2131494658;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ck
 * JD-Core Version:    0.7.0.1
 */