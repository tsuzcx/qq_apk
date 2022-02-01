package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, f
{
  public static final v.a gUK;
  private final TextView gSC;
  private final b gSM;
  public final bi gUE;
  private final ImageView gUF;
  private final RelativeLayout gUG;
  private boolean gUH;
  private final Object gUI;
  private final d.g.a.a<z> gUJ;
  private int likeCount;
  
  static
  {
    AppMethodBeat.i(212442);
    gUK = new v.a((byte)0);
    AppMethodBeat.o(212442);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212441);
    this.gSM = paramb;
    paramb = paramViewGroup.findViewById(2131307850);
    p.g(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.gUE = new bi((ViewGroup)paramb, this.gSM);
    paramb = paramViewGroup.findViewById(2131307762);
    p.g(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.gUF = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307763);
    p.g(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.gUG = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307764);
    p.g(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.gSC = ((TextView)paramb);
    this.gUH = true;
    this.gUI = paramViewGroup.getContext().getSystemService("vibrator");
    this.gUJ = ((d.g.a.a)new b(this, paramViewGroup));
    paramb = this.gUF;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131690419), -1));
    this.gUG.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(212429);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        p.g(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getActionMasked() == 0)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousMotionEvent = new int[2];
          MotionEvent tmp69_68 = paramAnonymousMotionEvent;
          tmp69_68[0] = 0;
          MotionEvent tmp73_69 = tmp69_68;
          tmp73_69[1] = 0;
          tmp73_69;
          v.c(this.gUL).getLocationOnScreen(paramAnonymousMotionEvent);
          int i = paramAnonymousMotionEvent[0];
          int j = v.c(this.gUL).getWidth() / 2;
          localObject = f.b.gMX;
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.amW() / 2);
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", paramAnonymousMotionEvent[1] - aq.fromDPToPix(paramViewGroup.getContext(), 16));
          v.d(this.gUL).a(b.c.gRT, paramAnonymousView);
          paramAnonymousView = this.gUL;
          v.a(paramAnonymousView, v.e(paramAnonymousView) + 1);
          if (v.f(this.gUL))
          {
            paramAnonymousView = i.gPh;
            i.nG(v.e(this.gUL));
            v.g(this.gUL);
            v.a(this.gUL, 0);
          }
          if ((v.h(this.gUL) instanceof Vibrator)) {
            ((Vibrator)v.h(this.gUL)).vibrate(10L);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(212429);
        return true;
      }
    });
    paramb = com.tencent.mm.live.b.c.gMO;
    com.tencent.mm.live.b.c.d(name(), this.gUJ);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ar.ej(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(212441);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212437);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (w.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212437);
      return;
      nI(8);
      AppMethodBeat.o(212437);
      return;
      nI(0);
      this.gGK.post((Runnable)new d(this));
      AppMethodBeat.o(212437);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nI(8);
        AppMethodBeat.o(212437);
        return;
      }
      nI(0);
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212439);
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3957, (f)this);
    AppMethodBeat.o(212439);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(212438);
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3957, (f)this);
    AppMethodBeat.o(212438);
  }
  
  public final void nI(int paramInt)
  {
    AppMethodBeat.i(212436);
    this.gGK.setVisibility(paramInt);
    AppMethodBeat.o(212436);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212435);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
      AppMethodBeat.o(212435);
      return;
      paramView = null;
      break;
      label86:
      if (paramView.intValue() == 2131307763)
      {
        paramView = new Bundle();
        localObject = new int[2];
        tmp110_108 = localObject;
        tmp110_108[0] = 0;
        tmp114_110 = tmp110_108;
        tmp114_110[1] = 0;
        tmp114_110;
        this.gUG.getLocationOnScreen((int[])localObject);
        int i = localObject[0];
        int j = this.gUG.getWidth() / 2;
        f.b localb = f.b.gMX;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.amW() / 2);
        i = localObject[1];
        j = aq.fromDPToPix(this.gGK.getContext(), 16);
        localObject = f.b.gMX;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - f.b.amW());
        this.gSM.a(b.c.gRT, paramView);
        this.likeCount += 1;
        if (this.gUH)
        {
          paramView = i.gPh;
          i.nG(this.likeCount);
          this.gUH = false;
          this.likeCount = 0;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212440);
    if ((paramn instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.mm.ad.c.g((d.g.a.a)new c(this));
      }
      ad.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = i.gPh;
        i.nG(this.likeCount);
        this.gUH = false;
        this.likeCount = 0;
        AppMethodBeat.o(212440);
        return;
      }
      this.gUH = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(212440);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(212434);
      v.a(this.gUL);
      AppMethodBeat.o(212434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */