package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedFullConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class ap
  extends ao
{
  public ap(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, b.g.finder_full_item_folded_item);
    AppMethodBeat.i(285047);
    AppMethodBeat.o(285047);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(285044);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    Context localContext = parami.getContext();
    p.j(localContext, "holder.context");
    float f = localContext.getResources().getDimension(b.d.Edge_22A);
    paramInt = paramRecyclerView.getHeight();
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = paramRecyclerView.getResources();
    p.j(paramRecyclerView, "recyclerView.context.resources");
    f = (Math.max(paramInt, paramRecyclerView.getDisplayMetrics().heightPixels) - f) / 3.0F;
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, (int)f));
    AppMethodBeat.o(285044);
  }
  
  public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(285045);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = t.ztT;
    paramList = t.dJe();
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getMediaList().getFirst();
    p.j(paramBaseFinderFeed, "item.feedObject.mediaList.first");
    paramList = paramList.bQ(new r((csg)paramBaseFinderFeed, u.Alz, null, null, 12));
    paramBaseFinderFeed = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() > 0) {}
    for (paramBaseFinderFeed = new com.tencent.mm.loader.e.d(null, null, 3);; paramBaseFinderFeed = null)
    {
      paramBaseFinderFeed = paramList.a((com.tencent.mm.loader.f.d)paramBaseFinderFeed);
      paramList = t.ztT;
      paramBaseFinderFeed = paramBaseFinderFeed.a(t.a(t.a.ztV));
      parami = parami.amk;
      p.j(parami, "holder.itemView");
      parami = (ImageView)parami.findViewById(b.f.thumb_iv);
      p.j(parami, "holder.itemView.thumb_iv");
      paramBaseFinderFeed.c(parami);
      AppMethodBeat.o(285045);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ap
 * JD-Core Version:    0.7.0.1
 */