package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.o.b;
import com.tencent.mm.live.b.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeLayout", "Landroid/widget/LinearLayout;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLike", "scaleAnimate", "target", "targetValue", "", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, i
{
  public static final a hQq;
  private final TextView hOf;
  private final b hOp;
  public final bi hQi;
  private final ImageView hQj;
  private final RelativeLayout hQk;
  private final LinearLayout hQl;
  private boolean hQm;
  private final Object hQn;
  private final kotlin.g.a.a<x> hQo;
  private final MTimerHandler hQp;
  private int likeCount;
  
  static
  {
    AppMethodBeat.i(208022);
    hQq = new a((byte)0);
    AppMethodBeat.o(208022);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208021);
    this.hOp = paramb;
    paramb = paramViewGroup.findViewById(2131303638);
    p.g(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.hQi = new bi((ViewGroup)paramb, this.hOp);
    paramb = paramViewGroup.findViewById(2131303548);
    p.g(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.hQj = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303549);
    p.g(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.hQk = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131303550);
    p.g(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.hOf = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303422);
    p.g(paramb, "root.findViewById(R.id.live_like_layout)");
    this.hQl = ((LinearLayout)paramb);
    this.hQm = true;
    this.hQn = paramViewGroup.getContext().getSystemService("vibrator");
    this.hQo = ((kotlin.g.a.a)new b(this, paramViewGroup));
    this.hQp = new MTimerHandler("RoomLiveLike::Timer", (MTimerHandler.CallBack)new e(this), true);
    paramb = this.hQj;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690500), -1));
    this.hQk.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208007);
        p.g(paramAnonymousMotionEvent, "event");
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(208007);
          return true;
          v.s((View)v.h(this.hQr), 1.7F);
          v.d(this.hQr).setVisibility(4);
          v.i(this.hQr).startTimer(0L, 200L);
          continue;
          v.i(this.hQr).stopTimer();
          v.s((View)v.h(this.hQr), 1.0F);
          v.d(this.hQr).setVisibility(0);
          if (v.j(this.hQr))
          {
            paramAnonymousView = r.hIg;
            r.qR(v.e(this.hQr));
            v.k(this.hQr);
            v.f(this.hQr);
          }
        }
      }
    });
    paramb = m.hGg;
    m.d(name(), this.hQo);
    if (paramViewGroup.findViewById(2131299216) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = au.aD(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131299216);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(208021);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(208018);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3957, (i)this);
    AppMethodBeat.o(208018);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208015);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label86;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208015);
      return;
      paramView = null;
      break;
      label86:
      if (paramView.intValue() == 2131303549)
      {
        paramView = new Bundle();
        localObject = new int[2];
        tmp110_108 = localObject;
        tmp110_108[0] = 0;
        tmp114_110 = tmp110_108;
        tmp114_110[1] = 0;
        tmp114_110;
        this.hQk.getLocationOnScreen((int[])localObject);
        int i = localObject[0];
        int j = this.hQk.getWidth() / 2;
        o.b localb = o.b.hGo;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - o.b.aFl() / 2);
        i = localObject[1];
        j = at.fromDPToPix(this.hwr.getContext(), 16);
        localObject = o.b.hGo;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - o.b.aFl());
        this.hOp.statusChange(b.c.hMa, paramView);
        this.likeCount += 1;
        if (this.hQm)
        {
          paramView = r.hIg;
          r.qR(this.likeCount);
          this.hQm = false;
          this.likeCount = 0;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(208020);
    if ((paramq instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        d.h((kotlin.g.a.a)new c(this));
      }
      Log.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = r.hIg;
        r.qR(this.likeCount);
        this.hQm = false;
        this.likeCount = 0;
        AppMethodBeat.o(208020);
        return;
      }
      this.hQm = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(208020);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(208016);
    this.hwr.setVisibility(paramInt);
    AppMethodBeat.o(208016);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208017);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (w.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208017);
      return;
      rg(8);
      AppMethodBeat.o(208017);
      return;
      rg(0);
      this.hwr.post((Runnable)new f(this));
      AppMethodBeat.o(208017);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        rg(8);
        AppMethodBeat.o(208017);
        return;
      }
      rg(0);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208019);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3957, (i)this);
    AppMethodBeat.o(208019);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(v paramv)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements MTimerHandler.CallBack
  {
    e(v paramv) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(208013);
      if (v.e(this.hQr) < 9)
      {
        v.g(this.hQr);
        AppMethodBeat.o(208013);
        return true;
      }
      AppMethodBeat.o(208013);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(208014);
      v.c(this.hQr);
      AppMethodBeat.o(208014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */