package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedFullConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class an
  extends am
{
  public an(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, 2131494333);
    AppMethodBeat.i(243131);
    AppMethodBeat.o(243131);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243128);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    Context localContext = paramh.getContext();
    p.g(localContext, "holder.context");
    float f = localContext.getResources().getDimension(2131165291);
    paramInt = paramRecyclerView.getHeight();
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.g(paramRecyclerView, "recyclerView.context.resources");
    f = (Math.max(paramInt, paramRecyclerView.getDisplayMetrics().heightPixels) - f) / 3.0F;
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, (int)f));
    AppMethodBeat.o(243128);
  }
  
  public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243129);
    p.h(paramh, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(paramh, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = m.uJa;
    paramList = m.djY();
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getMediaList().getFirst();
    p.g(paramBaseFinderFeed, "item.feedObject.mediaList.first");
    paramList = paramList.bQ(new k((cjl)paramBaseFinderFeed, x.vEo, null, null, 12));
    paramBaseFinderFeed = c.vCb;
    if (((Number)c.dtK().value()).intValue() > 0) {}
    for (paramBaseFinderFeed = new com.tencent.mm.loader.e.d(null, null, 3);; paramBaseFinderFeed = null)
    {
      paramBaseFinderFeed = paramList.a((com.tencent.mm.loader.f.d)paramBaseFinderFeed);
      paramList = m.uJa;
      paramBaseFinderFeed = paramBaseFinderFeed.a(m.a(m.a.uJc));
      paramh = paramh.aus;
      p.g(paramh, "holder.itemView");
      paramh = (ImageView)paramh.findViewById(2131309073);
      p.g(paramh, "holder.itemView.thumb_iv");
      paramBaseFinderFeed.c(paramh);
      AppMethodBeat.o(243129);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.an
 * JD-Core Version:    0.7.0.1
 */