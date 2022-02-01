package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.Panel;
import com.tencent.mm.plugin.game.chatroom.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPanelAdapter", "Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelAdapter;", "initView", "", "onMeasure", "widthSpec", "heightSpec", "setData", "panel_list", "", "Lcom/tencent/mm/plugin/game/autogen/chatroom/Panel;", "Companion", "PanelAdapter", "PanelItemDecoration", "PanelViewHolder", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PanelGridView
  extends MRecyclerView
{
  public static final a Isb;
  private PanelGridView.b Isc;
  
  static
  {
    AppMethodBeat.i(276355);
    Isb = new a((byte)0);
    AppMethodBeat.o(276355);
  }
  
  public PanelGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(276332);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.Isc = new PanelGridView.b(paramContext);
    initView();
    AppMethodBeat.o(276332);
  }
  
  public PanelGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276341);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.Isc = new PanelGridView.b(paramContext);
    initView();
    AppMethodBeat.o(276341);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(276350);
    getContext();
    setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
    a((RecyclerView.h)new c((MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels - getContext().getResources().getDimensionPixelSize(h.c.IeB) * 4) / 5));
    setAdapter((RecyclerView.a)this.Isc);
    AppMethodBeat.o(276350);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276362);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(h.c.IeA), -2147483648) * 2);
    AppMethodBeat.o(276362);
  }
  
  public final void setData(List<Panel> paramList)
  {
    AppMethodBeat.i(276368);
    int i;
    if (paramList != null)
    {
      if (((Collection)paramList).isEmpty()) {
        break label77;
      }
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        PanelGridView.b localb = this.Isc;
        s.u(paramList, "panelList");
        ((Collection)paramList).isEmpty();
        localb.Isd.addAll((Collection)paramList);
        localb.bZE.notifyChanged();
      }
      AppMethodBeat.o(276368);
      return;
      label77:
      i = 0;
      break;
      label82:
      paramList = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$Companion;", "", "()V", "COLUMN_NUM", "", "TAG", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spaceWidth", "", "(I)V", "edgeSpace", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    private int Ise;
    private int Isf;
    
    public c(int paramInt)
    {
      this.Ise = paramInt;
      this.Isf = paramInt;
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(276448);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = paramView.getLayoutParams();
      if (params == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(276448);
        throw paramRect;
      }
      params = (GridLayoutManager.LayoutParams)params;
      s.checkNotNull(paramRecyclerView);
      int i = paramRecyclerView.bWl;
      RecyclerView.bA(paramView);
      int j = params.bWs;
      int k = (this.Ise * (i - 1) + this.Isf * 2) / i;
      int m = (k - this.Isf - this.Isf) * j / (i - 1) + this.Isf;
      paramRect.set(m, 0, k - m, 0);
      Log.d("MicroMsg.PanelGridView", "getItemOffsets, spanCount = %d, index = %d, left = %d, right = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRect.left), Integer.valueOf(paramRect.right) });
      AppMethodBeat.o(276448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.PanelGridView
 * JD-Core Version:    0.7.0.1
 */