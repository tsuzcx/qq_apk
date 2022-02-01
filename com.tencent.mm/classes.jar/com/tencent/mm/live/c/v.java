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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, f
{
  public static final v.a gXt;
  private final TextView gVl;
  private final b gVv;
  public final bi gXn;
  private final ImageView gXo;
  private final RelativeLayout gXp;
  private boolean gXq;
  private final Object gXr;
  private final d.g.a.a<z> gXs;
  private int likeCount;
  
  static
  {
    AppMethodBeat.i(216062);
    gXt = new v.a((byte)0);
    AppMethodBeat.o(216062);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216061);
    this.gVv = paramb;
    paramb = paramViewGroup.findViewById(2131307850);
    p.g(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.gXn = new bi((ViewGroup)paramb, this.gVv);
    paramb = paramViewGroup.findViewById(2131307762);
    p.g(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.gXo = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307763);
    p.g(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.gXp = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307764);
    p.g(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.gVl = ((TextView)paramb);
    this.gXq = true;
    this.gXr = paramViewGroup.getContext().getSystemService("vibrator");
    this.gXs = ((d.g.a.a)new b(this, paramViewGroup));
    paramb = this.gXo;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691626), -1));
    this.gXp.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(216049);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
          v.c(this.gXu).getLocationOnScreen(paramAnonymousMotionEvent);
          int i = paramAnonymousMotionEvent[0];
          int j = v.c(this.gXu).getWidth() / 2;
          localObject = f.b.gPG;
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.anl() / 2);
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", paramAnonymousMotionEvent[1] - aq.fromDPToPix(paramViewGroup.getContext(), 16));
          v.d(this.gXu).a(b.c.gUB, paramAnonymousView);
          paramAnonymousView = this.gXu;
          v.a(paramAnonymousView, v.e(paramAnonymousView) + 1);
          if (v.f(this.gXu))
          {
            paramAnonymousView = i.gRP;
            i.nJ(v.e(this.gXu));
            v.g(this.gXu);
            v.a(this.gXu, 0);
          }
          if ((v.h(this.gXu) instanceof Vibrator)) {
            ((Vibrator)v.h(this.gXu)).vibrate(10L);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(216049);
        return true;
      }
    });
    paramb = com.tencent.mm.live.b.c.gPx;
    com.tencent.mm.live.b.c.d(name(), this.gXs);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ar.en(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(216061);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216057);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (w.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216057);
      return;
      nL(8);
      AppMethodBeat.o(216057);
      return;
      nL(0);
      this.gJt.post((Runnable)new d(this));
      AppMethodBeat.o(216057);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nL(8);
        AppMethodBeat.o(216057);
        return;
      }
      nL(0);
    }
  }
  
  public final void aoO()
  {
    AppMethodBeat.i(216058);
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3957, (f)this);
    AppMethodBeat.o(216058);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216059);
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3957, (f)this);
    AppMethodBeat.o(216059);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(216056);
    this.gJt.setVisibility(paramInt);
    AppMethodBeat.o(216056);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216055);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
      AppMethodBeat.o(216055);
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
        this.gXp.getLocationOnScreen((int[])localObject);
        int i = localObject[0];
        int j = this.gXp.getWidth() / 2;
        f.b localb = f.b.gPG;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.anl() / 2);
        i = localObject[1];
        j = aq.fromDPToPix(this.gJt.getContext(), 16);
        localObject = f.b.gPG;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - f.b.anl());
        this.gVv.a(b.c.gUB, paramView);
        this.likeCount += 1;
        if (this.gXq)
        {
          paramView = i.gRP;
          i.nJ(this.likeCount);
          this.gXq = false;
          this.likeCount = 0;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(216060);
    if ((paramn instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.mm.ac.c.h((d.g.a.a)new c(this));
      }
      ae.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = i.gRP;
        i.nJ(this.likeCount);
        this.gXq = false;
        this.likeCount = 0;
        AppMethodBeat.o(216060);
        return;
      }
      this.gXq = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(216060);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(216054);
      v.a(this.gXu);
      AppMethodBeat.o(216054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */