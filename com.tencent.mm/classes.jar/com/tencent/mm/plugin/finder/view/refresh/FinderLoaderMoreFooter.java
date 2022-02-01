package com.tencent.mm.plugin.finder.view.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.j;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/refresh/FinderLoaderMoreFooter;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNoMoreData", "", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "inflateView", "", "layoutId", "init", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "setNoMoreData", "noMoreData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLoaderMoreFooter
  extends RelativeLayout
  implements com.tencent.mm.view.refreshLayout.b.b
{
  private boolean FgG;
  
  public FinderLoaderMoreFooter(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FinderLoaderMoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderLoaderMoreFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345224);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, e.j.FinderLoaderMoreFooter);
    s.s(paramContext, "context.obtainStyledAttr…e.FinderLoaderMoreFooter)");
    paramInt = paramContext.getResourceId(e.j.FinderLoaderMoreFooter_loadMoreLayout, 0);
    if (paramInt != 0) {
      RelativeLayout.inflate(getContext(), paramInt, (ViewGroup)this);
    }
    paramContext.recycle();
    AppMethodBeat.o(345224);
  }
  
  public final void UM(int paramInt)
  {
    AppMethodBeat.i(345310);
    removeAllViews();
    RelativeLayout.inflate(getContext(), paramInt, (ViewGroup)this);
    AppMethodBeat.o(345310);
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(345230);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(345230);
    return 0;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(345285);
    s.u(paramd, "kernel");
    AppMethodBeat.o(345285);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(345290);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(345290);
  }
  
  public final void a(e parame, com.tencent.mm.view.refreshLayout.e.b paramb1, com.tencent.mm.view.refreshLayout.e.b paramb2)
  {
    AppMethodBeat.i(345265);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    if ((!this.FgG) && ((paramb2 == com.tencent.mm.view.refreshLayout.e.b.agQN) || (paramb2 == com.tencent.mm.view.refreshLayout.e.b.agQM)))
    {
      parame = (TextView)findViewById(e.e.load_more_footer_tip_tv);
      if (parame != null) {
        parame.setVisibility(0);
      }
    }
    AppMethodBeat.o(345265);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(345300);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(345300);
  }
  
  public final c getSpinnerStyle()
  {
    return c.agRc;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final boolean tk(boolean paramBoolean)
  {
    AppMethodBeat.i(345257);
    Object localObject;
    if (this.FgG != paramBoolean)
    {
      this.FgG = paramBoolean;
      if (!paramBoolean) {
        break label67;
      }
      localObject = (TextView)findViewById(e.e.load_more_footer_tip_tv);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = findViewById(e.e.load_more_footer_end_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(345257);
      return true;
      label67:
      localObject = (TextView)findViewById(e.e.load_more_footer_tip_tv);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = findViewById(e.e.load_more_footer_end_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.refresh.FinderLoaderMoreFooter
 * JD-Core Version:    0.7.0.1
 */