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
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.l.b;
import com.tencent.mm.live.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeLayout", "Landroid/widget/LinearLayout;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLike", "scaleAnimate", "target", "targetValue", "", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, i
{
  public static final a kEN;
  private final TextView kCB;
  private final b kCL;
  public final bi kEF;
  private final ImageView kEG;
  private final RelativeLayout kEH;
  private final LinearLayout kEI;
  private boolean kEJ;
  private final Object kEK;
  private final kotlin.g.a.a<x> kEL;
  private final MTimerHandler kEM;
  private int likeCount;
  
  static
  {
    AppMethodBeat.i(188399);
    kEN = new a((byte)0);
    AppMethodBeat.o(188399);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(188398);
    this.kCL = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_visitor_mic_parent);
    p.j(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.kEF = new bi((ViewGroup)paramb, this.kCL);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like);
    p.j(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.kEG = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like_click_area);
    p.j(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.kEH = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like_count_tv);
    p.j(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.kCB = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_like_layout);
    p.j(paramb, "root.findViewById(R.id.live_like_layout)");
    this.kEI = ((LinearLayout)paramb);
    this.kEJ = true;
    this.kEK = paramViewGroup.getContext().getSystemService("vibrator");
    this.kEL = ((kotlin.g.a.a)new b(this, paramViewGroup));
    this.kEM = new MTimerHandler("RoomLiveLike::Timer", (MTimerHandler.CallBack)new e(this), true);
    paramb = this.kEG;
    Context localContext = paramViewGroup.getContext();
    p.j(localContext, "root.context");
    paramb.setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_call_good), -1));
    this.kEH.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(195421);
        p.j(paramAnonymousMotionEvent, "event");
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195421);
          return true;
          v.s((View)v.h(this.kEO), 1.7F);
          v.d(this.kEO).setVisibility(4);
          v.i(this.kEO).startTimer(0L, 200L);
          continue;
          v.i(this.kEO).stopTimer();
          v.s((View)v.h(this.kEO), 1.0F);
          v.d(this.kEO).setVisibility(0);
          if (v.j(this.kEO))
          {
            paramAnonymousView = o.kvA;
            o.tG(v.e(this.kEO));
            v.k(this.kEO);
            v.f(this.kEO);
          }
        }
      }
    });
    paramb = j.kue;
    j.d(name(), this.kEL);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ax.aB(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(b.e.content_root_view);
      p.j(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(188398);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(188385);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3957, (i)this);
    AppMethodBeat.o(188385);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(188369);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.e.live_right_panel_like_click_area;
      if (paramView != null) {
        break label90;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(188369);
      return;
      paramView = null;
      break;
      label90:
      if (paramView.intValue() == i)
      {
        paramView = new Bundle();
        localObject = new int[2];
        tmp113_111 = localObject;
        tmp113_111[0] = 0;
        tmp117_113 = tmp113_111;
        tmp117_113[1] = 0;
        tmp117_113;
        this.kEH.getLocationOnScreen((int[])localObject);
        i = localObject[0];
        int j = this.kEH.getWidth() / 2;
        l.b localb = l.b.kum;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - l.b.aNC() / 2);
        i = localObject[1];
        j = aw.fromDPToPix(this.kiF.getContext(), 16);
        localObject = l.b.kum;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - l.b.aNC());
        this.kCL.statusChange(b.c.kzs, paramView);
        this.likeCount += 1;
        if (this.kEJ)
        {
          paramView = o.kvA;
          o.tG(this.likeCount);
          this.kEJ = false;
          this.likeCount = 0;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(188394);
    if ((paramq instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        d.uiThread((kotlin.g.a.a)new c(this));
      }
      Log.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = o.kvA;
        o.tG(this.likeCount);
        this.kEJ = false;
        this.likeCount = 0;
        AppMethodBeat.o(188394);
        return;
      }
      this.kEJ = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(188394);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(188382);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (w.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188382);
      return;
      tU(8);
      AppMethodBeat.o(188382);
      return;
      tU(0);
      this.kiF.post((Runnable)new f(this));
      AppMethodBeat.o(188382);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        tU(8);
        AppMethodBeat.o(188382);
        return;
      }
      tU(0);
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(188371);
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(188371);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(188389);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3957, (i)this);
    AppMethodBeat.o(188389);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class e
    implements MTimerHandler.CallBack
  {
    e(v paramv) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(197018);
      if (v.e(this.kEO) < 9)
      {
        v.g(this.kEO);
        AppMethodBeat.o(197018);
        return true;
      }
      AppMethodBeat.o(197018);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(196348);
      v.c(this.kEO);
      AppMethodBeat.o(196348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */