package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import kotlin.g.a.a;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "MAX_LIKE_ONE_TIME", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "likeClickArea", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "likeContainer", "Landroid/widget/LinearLayout;", "likeCount", "likeIcon", "Landroid/widget/ImageView;", "likeTv", "Landroid/widget/TextView;", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "vibrator", "isVisible", "", "postHightLightLike", "", "postLike", "refreshLikeCount", "scaleAnimate", "target", "Landroid/view/View;", "targetValue", "", "setVisible", "visible", "shakeIt", "uploadLike", "plugin-finder_release"})
public final class p
{
  final String TAG;
  final b hOp;
  final TextView hPG;
  final Object hQn;
  final MTimerHandler hQp;
  public final ViewGroup hwr;
  int likeCount;
  final ImageView rNa;
  final com.tencent.mm.plugin.finder.live.plugin.d uFw;
  final int uHG;
  public final LinearLayout uHH;
  public final RelativeLayout uHI;
  
  public p(ViewGroup paramViewGroup, b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(248170);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveVisitorLikeWidget";
    this.uHG = 9;
    this.uHH = ((LinearLayout)this.hwr.findViewById(2131301062));
    this.uHI = ((RelativeLayout)this.hwr.findViewById(2131301061));
    this.rNa = ((ImageView)this.hwr.findViewById(2131301063));
    paramViewGroup = this.hwr.getParent();
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(248170);
      throw paramViewGroup;
    }
    this.hPG = ((TextView)((ViewGroup)paramViewGroup).findViewById(2131301065));
    this.hQn = this.hwr.getContext().getSystemService("vibrator");
    this.hQp = new MTimerHandler("FinderLiveLikePlugin::Timer", (MTimerHandler.CallBack)new c(this), true);
    paramViewGroup = this.rNa;
    paramb = this.hwr.getContext();
    kotlin.g.b.p.g(paramb, "root.context");
    paramViewGroup.setImageDrawable(ar.e(paramb.getResources().getDrawable(2131690500), -1));
    this.uHH.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(248162);
        kotlin.g.b.p.g(paramAnonymousMotionEvent, "event");
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(248162);
          return true;
          paramAnonymousView = this.uHJ.hPG;
          kotlin.g.b.p.g(paramAnonymousView, "likeTv");
          paramAnonymousView.setVisibility(4);
          p.u((View)this.uHJ.hwr, 1.7F);
          this.uHJ.hQp.startTimer(0L, 200L);
          paramAnonymousView = this.uHJ.rNa;
          kotlin.g.b.p.g(paramAnonymousView, "likeIcon");
          paramAnonymousView.setAlpha(0.3F);
          continue;
          this.uHJ.hQp.stopTimer();
          paramAnonymousView = this.uHJ.hPG;
          kotlin.g.b.p.g(paramAnonymousView, "likeTv");
          paramAnonymousView.setVisibility(0);
          p.u((View)this.uHJ.hwr, 1.0F);
          paramAnonymousView = this.uHJ;
          paramAnonymousMotionEvent = o.ujN;
          paramAnonymousMotionEvent = o.getFinderLiveAssistant();
          if (paramAnonymousMotionEvent != null) {
            paramAnonymousMotionEvent.Jf(paramAnonymousView.likeCount);
          }
          paramAnonymousView.Jr(paramAnonymousView.uFw.getLiveData().liveInfo.wBG);
          paramAnonymousView.likeCount = 0;
          paramAnonymousView = this.uHJ.rNa;
          kotlin.g.b.p.g(paramAnonymousView, "likeIcon");
          paramAnonymousView.setAlpha(1.0F);
        }
      }
    });
    AppMethodBeat.o(248170);
  }
  
  public final void Jr(final int paramInt)
  {
    AppMethodBeat.i(248168);
    this.hwr.post((Runnable)new d(this, paramInt));
    AppMethodBeat.o(248168);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(248169);
    if (this.hwr.getVisibility() == 0)
    {
      AppMethodBeat.o(248169);
      return true;
    }
    AppMethodBeat.o(248169);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(p paramp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(p paramp) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(248166);
      p localp;
      if (this.uHJ.likeCount < this.uHJ.uHG - 1)
      {
        localp = this.uHJ;
        if ((localp.hQn instanceof Vibrator)) {
          ((Vibrator)localp.hQn).vibrate(10L);
        }
        com.tencent.mm.ac.d.h((a)new p.b(localp));
        AppMethodBeat.o(248166);
        return true;
      }
      if (this.uHJ.likeCount == this.uHJ.uHG - 1)
      {
        localp = this.uHJ;
        if ((localp.hQn instanceof Vibrator)) {
          ((Vibrator)localp.hQn).vibrate(10L);
        }
        com.tencent.mm.ac.d.h((a)new p.a(localp));
      }
      AppMethodBeat.o(248166);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(p paramp, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(248167);
      TextView localTextView = this.uHJ.hPG;
      kotlin.g.b.p.g(localTextView, "likeTv");
      y localy = y.vXH;
      localTextView.setText((CharSequence)y.LT(paramInt));
      AppMethodBeat.o(248167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.p
 * JD-Core Version:    0.7.0.1
 */