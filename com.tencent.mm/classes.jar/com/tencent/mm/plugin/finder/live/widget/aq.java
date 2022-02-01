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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.au;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "MAX_LIKE_ONE_TIME", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "filterVisitorZeroLikeValue", "", "getFilterVisitorZeroLikeValue", "()Z", "setFilterVisitorZeroLikeValue", "(Z)V", "likeClickArea", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "likeContainer", "Landroid/widget/LinearLayout;", "likeCount", "likeIcon", "Landroid/widget/ImageView;", "likeTv", "Landroid/widget/TextView;", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "vibrator", "checkVisible", "", "isVisible", "postHightLightLike", "postLike", "refreshLikeCount", "", "scaleAnimate", "target", "Landroid/view/View;", "targetValue", "", "setVisible", "visible", "shakeIt", "uploadLike", "plugin-finder_release"})
public final class aq
{
  final String TAG;
  final com.tencent.mm.live.c.b kCL;
  final Object kEK;
  final MTimerHandler kEM;
  final TextView kEc;
  public final ViewGroup kiF;
  int likeCount;
  final ImageView vsK;
  public final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  final int zsq;
  private final LinearLayout zsr;
  public final RelativeLayout zss;
  boolean zst;
  
  public aq(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(280266);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveVisitorLikeWidget";
    this.zsq = 9;
    this.zsr = ((LinearLayout)this.kiF.findViewById(b.f.finder_live_like_container));
    this.zss = ((RelativeLayout)this.kiF.findViewById(b.f.finder_live_like_click_area));
    this.vsK = ((ImageView)this.kiF.findViewById(b.f.finder_live_like_icon));
    paramViewGroup = this.kiF.getParent();
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(280266);
      throw paramViewGroup;
    }
    this.kEc = ((TextView)((ViewGroup)paramViewGroup).findViewById(b.f.finder_live_like_tv));
    this.kEK = this.kiF.getContext().getSystemService("vibrator");
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilY().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zst = bool;
      this.kEM = new MTimerHandler("FinderLiveLikePlugin::Timer", (MTimerHandler.CallBack)new c(this), true);
      paramViewGroup = this.vsK;
      paramb = this.kiF.getContext();
      p.j(paramb, "root.context");
      paramViewGroup.setImageDrawable(au.e(paramb.getResources().getDrawable(b.i.icons_filled_call_good), -1));
      this.zsr.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(273540);
          p.j(paramAnonymousMotionEvent, "event");
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(273540);
            return true;
            paramAnonymousView = this.zsu.kEc;
            p.j(paramAnonymousView, "likeTv");
            paramAnonymousView.setVisibility(4);
            aq.u((View)this.zsu.kiF, 1.5F);
            this.zsu.kEM.startTimer(0L, 200L);
            paramAnonymousView = this.zsu.vsK;
            p.j(paramAnonymousView, "likeIcon");
            paramAnonymousView.setAlpha(0.3F);
            continue;
            this.zsu.kEM.stopTimer();
            paramAnonymousView = this.zsu.kEc;
            p.j(paramAnonymousView, "likeTv");
            paramAnonymousView.setVisibility(0);
            aq.u((View)this.zsu.kiF, 1.0F);
            paramAnonymousView = this.zsu;
            paramAnonymousMotionEvent = com.tencent.mm.plugin.finder.live.plugin.d.getFinderLiveAssistant();
            if (paramAnonymousMotionEvent != null) {
              paramAnonymousMotionEvent.Nn(paramAnonymousView.likeCount);
            }
            paramAnonymousView.LW(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramAnonymousView.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfk);
            paramAnonymousView.likeCount = 0;
            paramAnonymousView = this.zsu.vsK;
            p.j(paramAnonymousView, "likeIcon");
            paramAnonymousView.setAlpha(1.0F);
          }
        }
      });
      AppMethodBeat.o(280266);
      return;
    }
  }
  
  public final void LW(final long paramLong)
  {
    AppMethodBeat.i(280263);
    this.kiF.post((Runnable)new d(this, paramLong));
    AppMethodBeat.o(280263);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(280265);
    if (this.kiF.getVisibility() == 0)
    {
      AppMethodBeat.o(280265);
      return true;
    }
    AppMethodBeat.o(280265);
    return false;
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(280264);
    this.kiF.setVisibility(paramInt);
    LinearLayout localLinearLayout = this.zsr;
    p.j(localLinearLayout, "likeContainer");
    localLinearLayout.setVisibility(this.kiF.getVisibility());
    AppMethodBeat.o(280264);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(aq paramaq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(aq paramaq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(286149);
      aq localaq;
      if (this.zsu.likeCount < this.zsu.zsq - 1)
      {
        localaq = this.zsu;
        if ((localaq.kEK instanceof Vibrator)) {
          ((Vibrator)localaq.kEK).vibrate(10L);
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new aq.b(localaq));
        AppMethodBeat.o(286149);
        return true;
      }
      if (this.zsu.likeCount == this.zsu.zsq - 1)
      {
        localaq = this.zsu;
        if ((localaq.kEK instanceof Vibrator)) {
          ((Vibrator)localaq.kEK).vibrate(10L);
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new aq.a(localaq));
      }
      AppMethodBeat.o(286149);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(aq paramaq, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(241434);
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (this.zsu.zst) && (paramLong == 0L))
      {
        AppMethodBeat.o(241434);
        return;
      }
      localObject = this.zsu.kEc;
      p.j(localObject, "likeTv");
      aj localaj = aj.AGc;
      ((TextView)localObject).setText((CharSequence)aj.Nh(paramLong));
      AppMethodBeat.o(241434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aq
 * JD-Core Version:    0.7.0.1
 */