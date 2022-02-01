package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/DemoHeader;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshHeader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mArrowView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mHeaderText", "Landroid/widget/TextView;", "mProgressView", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "init", "", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoHeader
  extends LinearLayout
  implements com.tencent.mm.view.refreshLayout.b.c
{
  private TextView FgI;
  private WeImageView FgJ;
  private MMProcessBar FgK;
  
  public DemoHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DemoHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(349310);
    init();
    AppMethodBeat.o(349310);
  }
  
  public DemoHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(349321);
    init();
    AppMethodBeat.o(349321);
  }
  
  private final void init()
  {
    AppMethodBeat.i(349331);
    LinearLayout.inflate(getContext(), e.f.finder_profile_more_live_list_widget_ui_header, (ViewGroup)this);
    View localView = findViewById(e.e.default_title);
    s.s(localView, "findViewById(R.id.default_title)");
    this.FgI = ((TextView)localView);
    localView = findViewById(e.e.arrow_icon);
    s.s(localView, "findViewById(R.id.arrow_icon)");
    this.FgJ = ((WeImageView)localView);
    localView = findViewById(e.e.loading_icon);
    s.s(localView, "findViewById(R.id.loading_icon)");
    this.FgK = ((MMProcessBar)localView);
    AppMethodBeat.o(349331);
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(349360);
    s.u(parame, "refreshLayout");
    MMProcessBar localMMProcessBar = this.FgK;
    parame = localMMProcessBar;
    if (localMMProcessBar == null)
    {
      s.bIx("mProgressView");
      parame = null;
    }
    parame.jEP();
    localMMProcessBar = this.FgK;
    parame = localMMProcessBar;
    if (localMMProcessBar == null)
    {
      s.bIx("mProgressView");
      parame = null;
    }
    parame.setVisibility(8);
    if (paramBoolean)
    {
      parame = this.FgI;
      if (parame == null)
      {
        s.bIx("mHeaderText");
        parame = localObject1;
      }
      for (;;)
      {
        parame.setText((CharSequence)"刷新完成");
        AppMethodBeat.o(349360);
        return 500;
      }
    }
    parame = this.FgI;
    if (parame == null)
    {
      s.bIx("mHeaderText");
      parame = localObject2;
    }
    for (;;)
    {
      parame.setText((CharSequence)"刷新失败");
      break;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(349377);
    s.u(paramd, "kernel");
    AppMethodBeat.o(349377);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(349385);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(349385);
  }
  
  public final void a(e parame, b paramb1, b paramb2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(349374);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    switch (a.$EnumSwitchMapping$0[paramb2.ordinal()])
    {
    default: 
      AppMethodBeat.o(349374);
      return;
    case 1: 
    case 2: 
      parame = this.FgI;
      if (parame == null)
      {
        s.bIx("mHeaderText");
        parame = null;
        parame.setText((CharSequence)"下拉开始刷新");
        paramb1 = this.FgJ;
        parame = paramb1;
        if (paramb1 == null)
        {
          s.bIx("mArrowView");
          parame = null;
        }
        parame.setVisibility(0);
        paramb1 = this.FgK;
        parame = paramb1;
        if (paramb1 == null)
        {
          s.bIx("mProgressView");
          parame = null;
        }
        parame.setVisibility(8);
        parame = this.FgJ;
        if (parame != null) {
          break label185;
        }
        s.bIx("mArrowView");
        parame = localObject1;
      }
      for (;;)
      {
        parame.animate().rotation(0.0F);
        AppMethodBeat.o(349374);
        return;
        break;
      }
    case 3: 
      label185:
      parame = this.FgI;
      if (parame == null)
      {
        s.bIx("mHeaderText");
        parame = null;
        parame.setText((CharSequence)"正在刷新");
        paramb1 = this.FgK;
        parame = paramb1;
        if (paramb1 == null)
        {
          s.bIx("mProgressView");
          parame = null;
        }
        parame.setVisibility(0);
        parame = this.FgJ;
        if (parame != null) {
          break label268;
        }
        s.bIx("mArrowView");
        parame = localObject2;
      }
      label268:
      for (;;)
      {
        parame.setVisibility(8);
        AppMethodBeat.o(349374);
        return;
        break;
      }
    }
    parame = this.FgI;
    if (parame == null)
    {
      s.bIx("mHeaderText");
      parame = null;
      label287:
      parame.setText((CharSequence)"释放立即刷新");
      parame = this.FgJ;
      if (parame != null) {
        break label329;
      }
      s.bIx("mArrowView");
      parame = localObject3;
    }
    label329:
    for (;;)
    {
      parame.animate().rotation(180.0F);
      break;
      break label287;
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(349351);
    s.u(parame, "refreshLayout");
    MMProcessBar localMMProcessBar = this.FgK;
    parame = localMMProcessBar;
    if (localMMProcessBar == null)
    {
      s.bIx("mProgressView");
      parame = null;
    }
    parame.jEP();
    AppMethodBeat.o(349351);
  }
  
  public final com.tencent.mm.view.refreshLayout.e.c getSpinnerStyle()
  {
    return com.tencent.mm.view.refreshLayout.e.c.agRc;
  }
  
  public final View getView()
  {
    return (View)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.DemoHeader
 * JD-Core Version:    0.7.0.1
 */