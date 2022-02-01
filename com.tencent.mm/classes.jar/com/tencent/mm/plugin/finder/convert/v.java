package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "isTipFeed", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "floatPosition", "onAttachedToRecyclerView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class v
  extends b<com.tencent.mm.plugin.finder.model.v>
{
  private static final int rOA = -2;
  private static boolean[] rOB;
  private static Integer[] rOC;
  public static final a rOD;
  private static final String rOx = "1";
  private static final String rOy = "2";
  private static final String rOz = "3";
  
  static
  {
    AppMethodBeat.i(165430);
    rOD = new a((byte)0);
    rOx = "1";
    rOy = "2";
    rOz = "3";
    rOA = -2;
    rOB = new boolean[3];
    rOC = new Integer[] { Integer.valueOf(rOA), Integer.valueOf(rOA), Integer.valueOf(rOA) };
    AppMethodBeat.o(165430);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(178135);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(178135);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165427);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(165427);
  }
  
  public final int getLayoutId()
  {
    return 2131492873;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "INVALID_POS", "", "getINVALID_POS", "()I", "TAG", "", "TYPE_FLOATVIEW_TIP", "getTYPE_FLOATVIEW_TIP", "()Ljava/lang/String;", "TYPE_TXT_FLOATVIEW_TIP", "getTYPE_TXT_FLOATVIEW_TIP", "TYPE_TXT_TIP", "getTYPE_TXT_TIP", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getFloatPosition", "getIndex", "type", "gotoMachine", "context", "Landroid/content/Context;", "position", "isFloatMode", "reset", "plugin-finder_release"})
  public static final class a
  {
    public static void a(ac.b paramb, int paramInt)
    {
      AppMethodBeat.i(201406);
      p.h(paramb, "viewCallback");
      if (v.cza()[getIndex(paramInt)] == 0)
      {
        AppMethodBeat.o(201406);
        return;
      }
      paramb = paramb.getRootView().findViewById(2131300074);
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      v.cza()[getIndex(paramInt)] = 0;
      AppMethodBeat.o(201406);
    }
    
    private static int getIndex(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return 2;
      case 3: 
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v
 * JD-Core Version:    0.7.0.1
 */