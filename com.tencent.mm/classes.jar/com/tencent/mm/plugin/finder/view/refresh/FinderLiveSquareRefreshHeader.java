package com.tencent.mm.plugin.finder.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/refresh/FinderLiveSquareRefreshHeader;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshHeader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headerTips", "Landroid/widget/TextView;", "loadingIcon", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "init", "", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "", "onFinishInflate", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSquareRefreshHeader
  extends RelativeLayout
  implements com.tencent.mm.view.refreshLayout.b.c
{
  private TextView GIe;
  private MMProcessBar GIf;
  
  public FinderLiveSquareRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderLiveSquareRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345218);
    RelativeLayout.inflate(getContext(), e.f.finder_live_squre_refresh_header, (ViewGroup)this);
    AppMethodBeat.o(345218);
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(345270);
    s.u(parame, "refreshLayout");
    MMProcessBar localMMProcessBar = this.GIf;
    parame = localMMProcessBar;
    if (localMMProcessBar == null)
    {
      s.bIx("loadingIcon");
      parame = null;
    }
    parame.setVisibility(8);
    if (!paramBoolean)
    {
      parame = this.GIe;
      if (parame == null)
      {
        s.bIx("headerTips");
        parame = localObject;
      }
      for (;;)
      {
        parame.setVisibility(0);
        AppMethodBeat.o(345270);
        return 500;
      }
    }
    AppMethodBeat.o(345270);
    return 0;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(345291);
    s.u(paramd, "kernel");
    AppMethodBeat.o(345291);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(345301);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(345301);
  }
  
  public final void a(e parame, b paramb1, b paramb2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(345281);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    switch (a.$EnumSwitchMapping$0[paramb2.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(345281);
      return;
      parame = this.GIf;
      if (parame == null)
      {
        s.bIx("loadingIcon");
        parame = localObject2;
      }
      for (;;)
      {
        parame.setVisibility(8);
        AppMethodBeat.o(345281);
        return;
      }
      paramb1 = this.GIf;
      parame = paramb1;
      if (paramb1 == null)
      {
        s.bIx("loadingIcon");
        parame = null;
      }
    } while (parame.getVisibility() == 0);
    parame = this.GIf;
    if (parame == null)
    {
      s.bIx("loadingIcon");
      parame = localObject1;
    }
    for (;;)
    {
      parame.setVisibility(0);
      break;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(345264);
    s.u(parame, "refreshLayout");
    TextView localTextView = this.GIe;
    parame = localTextView;
    if (localTextView == null)
    {
      s.bIx("headerTips");
      parame = null;
    }
    parame.setVisibility(8);
    AppMethodBeat.o(345264);
  }
  
  public final com.tencent.mm.view.refreshLayout.e.c getSpinnerStyle()
  {
    return com.tencent.mm.view.refreshLayout.e.c.agRc;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(345225);
    super.onFinishInflate();
    Object localObject = findViewById(e.e.refresh_header_tip_tv);
    s.s(localObject, "findViewById(R.id.refresh_header_tip_tv)");
    this.GIe = ((TextView)localObject);
    localObject = findViewById(e.e.rl_loading_icon);
    s.s(localObject, "findViewById(R.id.rl_loading_icon)");
    this.GIf = ((MMProcessBar)localObject);
    MMProcessBar localMMProcessBar = this.GIf;
    localObject = localMMProcessBar;
    if (localMMProcessBar == null)
    {
      s.bIx("loadingIcon");
      localObject = null;
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(345225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.refresh.FinderLiveSquareRefreshHeader
 * JD-Core Version:    0.7.0.1
 */