package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ap.b;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "isTipFeed", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "floatPosition", "onAttachedToRecyclerView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"})
public final class al
  extends e<ak>
{
  private static final String xmB = "1";
  private static final String xmC = "2";
  private static final String xmD = "3";
  private static final int xmE = -2;
  private static boolean[] xmF;
  private static Integer[] xmG;
  public static final a xmH;
  
  static
  {
    AppMethodBeat.i(165430);
    xmH = new a((byte)0);
    xmB = "1";
    xmC = "2";
    xmD = "3";
    xmE = -2;
    xmF = new boolean[3];
    xmG = new Integer[] { Integer.valueOf(xmE), Integer.valueOf(xmE), Integer.valueOf(xmE) };
    AppMethodBeat.o(165430);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(268719);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(268719);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(268720);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(268720);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_tip_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "INVALID_POS", "", "getINVALID_POS", "()I", "TAG", "", "TYPE_FLOATVIEW_TIP", "getTYPE_FLOATVIEW_TIP", "()Ljava/lang/String;", "TYPE_TXT_FLOATVIEW_TIP", "getTYPE_TXT_FLOATVIEW_TIP", "TYPE_TXT_TIP", "getTYPE_TXT_TIP", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getFloatPosition", "getIndex", "type", "gotoMachine", "context", "Landroid/content/Context;", "position", "isFloatMode", "reset", "plugin-finder_release"})
  public static final class a
  {
    private static int Me(int paramInt)
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
    
    public static void a(ap.b paramb, int paramInt)
    {
      AppMethodBeat.i(276103);
      p.k(paramb, "viewCallback");
      if (al.dpE()[Me(paramInt)] == 0)
      {
        AppMethodBeat.o(276103);
        return;
      }
      paramb = paramb.getRootView().findViewById(b.f.finder_stick_float_view);
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      al.dpE()[Me(paramInt)] = 0;
      AppMethodBeat.o(276103);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.al
 * JD-Core Version:    0.7.0.1
 */