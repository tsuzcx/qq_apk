package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.aw.b;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;I)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$scrollListener$1;", "stickItemView", "Landroid/view/View;", "getLayoutId", "isTipFeed", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "floatPosition", "onAttachedToRecyclerView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends f<am>
{
  public static final a AKO;
  private static final String AKP;
  private static final String AKQ;
  private static final String AKR;
  private static final int AKS;
  private static boolean[] AKT;
  private static Integer[] AKU;
  
  static
  {
    AppMethodBeat.i(165430);
    AKO = new a((byte)0);
    AKP = "1";
    AKQ = "2";
    AKR = "3";
    AKS = -2;
    AKT = new boolean[3];
    AKU = new Integer[] { Integer.valueOf(AKS), Integer.valueOf(AKS), Integer.valueOf(AKS) };
    AppMethodBeat.o(165430);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(350252);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    AppMethodBeat.o(350252);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350254);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350254);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_tip_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTipConvert$Companion;", "", "()V", "INVALID_POS", "", "getINVALID_POS", "()I", "TAG", "", "TYPE_FLOATVIEW_TIP", "getTYPE_FLOATVIEW_TIP", "()Ljava/lang/String;", "TYPE_TXT_FLOATVIEW_TIP", "getTYPE_TXT_FLOATVIEW_TIP", "TYPE_TXT_TIP", "getTYPE_TXT_TIP", "floatModeSet", "", "getFloatModeSet", "()[Z", "setFloatModeSet", "([Z)V", "floatPositionSet", "", "getFloatPositionSet", "()[Ljava/lang/Integer;", "setFloatPositionSet", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "changeToDecorView", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "parent", "Landroid/view/ViewGroup;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isHard", "", "tabType", "changeToItemView", "stickView", "Landroid/view/View;", "clickRefreshTipView", "isFloat", "getFloatPosition", "getIndex", "type", "gotoMachine", "context", "Landroid/content/Context;", "position", "isFloatMode", "reset", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static int Ni(int paramInt)
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
    
    public static void a(aw.b paramb, int paramInt)
    {
      AppMethodBeat.i(350493);
      s.u(paramb, "viewCallback");
      if (ag.dXJ()[Ni(paramInt)] == 0)
      {
        AppMethodBeat.o(350493);
        return;
      }
      paramb = paramb.getRootView().findViewById(e.e.finder_stick_float_view);
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      ag.dXJ()[Ni(paramInt)] = 0;
      AppMethodBeat.o(350493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ag
 * JD-Core Version:    0.7.0.1
 */