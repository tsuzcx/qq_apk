package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "GET_COMMENT", "", "INIT_VIEW", "IN_ANIM", "OUT_ANIM", "STAY_DURATION", "", "TAG", "", "contextTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContextTv", "()Landroid/widget/TextView;", "contextTv$delegate", "Lkotlin/Lazy;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "inAnim", "Landroid/animation/ObjectAnimator;", "getInAnim", "()Landroid/animation/ObjectAnimator;", "inAnim$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "outAnim", "getOutAnim", "outAnim$delegate", "canClearScreen", "", "initPosition", "", "aboveView", "Landroid/view/View;", "initTopComment", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "unMount", "updateMessages", "msgList", "", "plugin-finder_release"})
public final class bj
  extends d
{
  final String TAG;
  private final b hOp;
  private final kotlin.f lhN;
  private final kotlin.f uuj;
  private final kotlin.f uuk;
  final int uul;
  final int uum;
  final int uun;
  final int uuo;
  final long uup;
  final kotlin.f uuq;
  final kotlin.f uur;
  
  public bj(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247089);
    this.hOp = paramb;
    this.TAG = "FinderLiveTopCommentPlugin";
    this.uuj = kotlin.g.ah((kotlin.g.a.a)new e(paramViewGroup));
    this.uuk = kotlin.g.ah((kotlin.g.a.a)new a(paramViewGroup));
    this.uul = 1;
    this.uum = 2;
    this.uun = 3;
    this.uuo = 4;
    paramb = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(paramb, "MMKernel.service<IConfig…onfigService::class.java)");
    this.uup = (((com.tencent.mm.plugin.zero.b.a)paramb).aqJ().getInt("FinderLiveTopCommentDisplayTimeSec", 10) * 1000L);
    if (!isLandscape())
    {
      paramb = paramViewGroup.getContext();
      p.g(paramb, "root.context");
      int i = paramb.getResources().getDimensionPixelSize(2131165312);
      paramViewGroup.setPadding(i, paramViewGroup.getPaddingTop(), i, paramViewGroup.getPaddingBottom());
    }
    this.lhN = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.uuq = kotlin.g.ah((kotlin.g.a.a)new c(this, paramViewGroup));
    this.uur = kotlin.g.ah((kotlin.g.a.a)new f(paramViewGroup));
    AppMethodBeat.o(247089);
  }
  
  final MMHandler bkj()
  {
    AppMethodBeat.i(247085);
    MMHandler localMMHandler = (MMHandler)this.lhN.getValue();
    AppMethodBeat.o(247085);
    return localMMHandler;
  }
  
  public final void dY(View paramView)
  {
    AppMethodBeat.i(247086);
    p.h(paramView, "aboveView");
    int j = paramView.getBottom();
    int i;
    if (isLandscape()) {
      i = 0;
    }
    while ((this.hwr.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramView = this.hwr.getLayoutParams();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(247086);
        throw paramView;
        paramView = paramView.getContext();
        p.g(paramView, "aboveView.context");
        i = paramView.getResources().getDimensionPixelOffset(2131165303);
      }
      else
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.setMargins(paramView.leftMargin, j + i, paramView.rightMargin, paramView.bottomMargin);
        this.hwr.setLayoutParams((ViewGroup.LayoutParams)paramView);
      }
    }
    AppMethodBeat.o(247086);
  }
  
  public final boolean dgK()
  {
    return false;
  }
  
  public final void ea(List<awq> paramList)
  {
    AppMethodBeat.i(247087);
    p.h(paramList, "msgList");
    Message localMessage = bkj().obtainMessage();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    localMessage.obj = localArrayList;
    localMessage.what = this.uuo;
    bkj().sendMessage(localMessage);
    AppMethodBeat.o(247087);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247088);
    super.unMount();
    bkj().removeMessages(this.uul);
    bkj().removeMessages(this.uum);
    bkj().removeMessages(this.uun);
    AppMethodBeat.o(247088);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<TextView>
  {
    a(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    b(bj parambj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ObjectAnimator>
  {
    c(bj parambj, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(bj parambj, awq paramawq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ObjectAnimator>
  {
    f(ViewGroup paramViewGroup)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bj
 * JD-Core Version:    0.7.0.1
 */