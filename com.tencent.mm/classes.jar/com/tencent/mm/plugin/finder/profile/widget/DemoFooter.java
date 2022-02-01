package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/DemoFooter;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mFinishDuration", "", "mNoMoreData", "", "mTextFailed", "", "mTextFinish", "mTextLoading", "mTextNothing", "mTextPulling", "mTextRefreshing", "mTextRelease", "mTitleText", "Landroid/widget/TextView;", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "init", "", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "setNoMoreData", "noMoreData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoFooter
  extends RelativeLayout
  implements com.tencent.mm.view.refreshLayout.b.b
{
  private String FgA;
  private String FgB;
  private String FgC;
  private String FgD;
  private String FgE;
  private String FgF;
  private boolean FgG;
  private int FgH;
  private TextView Fgy;
  private String Fgz;
  
  public DemoFooter(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DemoFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(349155);
    this.FgH = 500;
    RelativeLayout.inflate(getContext(), e.f.finder_profile_more_live_list_widget_ui_footer, (ViewGroup)this);
    paramContext = findViewById(e.e.rl_default_title);
    s.s(paramContext, "findViewById(R.id.rl_default_title)");
    this.Fgy = ((TextView)paramContext);
    this.Fgz = "上拉加载更多";
    this.FgA = "释放立即加载";
    this.FgB = "正在加载…";
    this.FgC = "等待头部刷新完成…";
    this.FgD = "加载完成";
    this.FgE = "加载失败";
    this.FgF = "没有更多数据了";
    paramAttributeSet = this.Fgy;
    if (isInEditMode()) {}
    for (paramContext = (CharSequence)this.FgB;; paramContext = (CharSequence)this.Fgz)
    {
      paramAttributeSet.setText(paramContext);
      AppMethodBeat.o(349155);
      return;
    }
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(349162);
    s.u(parame, "refreshLayout");
    if (!this.FgG)
    {
      TextView localTextView = this.Fgy;
      if (paramBoolean) {}
      for (parame = (CharSequence)this.FgD;; parame = (CharSequence)this.FgE)
      {
        localTextView.setText(parame);
        int i = this.FgH;
        AppMethodBeat.o(349162);
        return i;
      }
    }
    AppMethodBeat.o(349162);
    return 0;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(349196);
    s.u(paramd, "kernel");
    AppMethodBeat.o(349196);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(349203);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(349203);
  }
  
  public final void a(e parame, com.tencent.mm.view.refreshLayout.e.b paramb1, com.tencent.mm.view.refreshLayout.e.b paramb2)
  {
    AppMethodBeat.i(349181);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    if (!this.FgG) {
      switch (a.$EnumSwitchMapping$0[paramb2.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(349181);
      return;
      this.Fgy.setText((CharSequence)this.Fgz);
      AppMethodBeat.o(349181);
      return;
      this.Fgy.setText((CharSequence)this.Fgz);
      AppMethodBeat.o(349181);
      return;
      this.Fgy.setText((CharSequence)this.FgB);
      AppMethodBeat.o(349181);
      return;
      this.Fgy.setText((CharSequence)this.FgA);
      AppMethodBeat.o(349181);
      return;
      this.Fgy.setText((CharSequence)this.FgC);
    }
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(349209);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(349209);
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
    AppMethodBeat.i(349173);
    if (this.FgG != paramBoolean)
    {
      this.FgG = paramBoolean;
      if (!paramBoolean) {
        break label43;
      }
      this.Fgy.setText((CharSequence)this.FgF);
    }
    for (;;)
    {
      AppMethodBeat.o(349173);
      return true;
      label43:
      this.Fgy.setText((CharSequence)this.Fgz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.DemoFooter
 * JD-Core Version:    0.7.0.1
 */