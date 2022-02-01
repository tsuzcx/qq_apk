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
import com.tencent.mm.ak.n;
import com.tencent.mm.live.b.f.b;
import com.tencent.mm.live.b.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, com.tencent.mm.ak.g
{
  public static final v.a gBa;
  public final bi gAU;
  private final ImageView gAV;
  private final RelativeLayout gAW;
  private boolean gAX;
  private final Object gAY;
  private final d.g.a.a<y> gAZ;
  private final TextView gyR;
  private final b gzb;
  private int likeCount;
  
  static
  {
    AppMethodBeat.i(190153);
    gBa = new v.a((byte)0);
    AppMethodBeat.o(190153);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190152);
    this.gzb = paramb;
    paramb = paramViewGroup.findViewById(2131307850);
    k.g(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.gAU = new bi((ViewGroup)paramb, this.gzb);
    paramb = paramViewGroup.findViewById(2131307762);
    k.g(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.gAV = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307763);
    k.g(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.gAW = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307764);
    k.g(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.gyR = ((TextView)paramb);
    this.gAX = true;
    this.gAY = paramViewGroup.getContext().getSystemService("vibrator");
    this.gAZ = ((d.g.a.a)new b(this, paramViewGroup));
    paramb = this.gAV;
    Context localContext = paramViewGroup.getContext();
    k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690419), -1));
    this.gAW.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(190140);
        k.g(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getActionMasked() == 0)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousMotionEvent = new int[2];
          MotionEvent tmp31_30 = paramAnonymousMotionEvent;
          tmp31_30[0] = 0;
          MotionEvent tmp35_31 = tmp31_30;
          tmp35_31[1] = 0;
          tmp35_31;
          v.c(this.gBb).getLocationOnScreen(paramAnonymousMotionEvent);
          int i = paramAnonymousMotionEvent[0];
          int j = v.c(this.gBb).getWidth() / 2;
          f.b localb = f.b.gtm;
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.akk() / 2);
          paramAnonymousView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", paramAnonymousMotionEvent[1] - ao.fromDPToPix(paramViewGroup.getContext(), 16));
          v.d(this.gBb).a(b.c.gyi, paramAnonymousView);
          paramAnonymousView = this.gBb;
          v.a(paramAnonymousView, v.e(paramAnonymousView) + 1);
          if (v.f(this.gBb))
          {
            paramAnonymousView = i.gvw;
            i.nh(v.e(this.gBb));
            v.g(this.gBb);
            v.a(this.gBb, 0);
          }
          if ((v.h(this.gBb) instanceof Vibrator)) {
            ((Vibrator)v.h(this.gBb)).vibrate(10L);
          }
        }
        AppMethodBeat.o(190140);
        return true;
      }
    });
    paramb = com.tencent.mm.live.b.c.gtd;
    com.tencent.mm.live.b.c.d(name(), this.gAZ);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ap.ej(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(190152);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190148);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (w.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190148);
      return;
      nj(8);
      AppMethodBeat.o(190148);
      return;
      nj(0);
      this.gnb.post((Runnable)new d(this));
      AppMethodBeat.o(190148);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nj(8);
        AppMethodBeat.o(190148);
        return;
      }
      nj(0);
    }
  }
  
  public final void alM()
  {
    AppMethodBeat.i(190149);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(3957, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190149);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190150);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b(3957, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190150);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(190147);
    this.gnb.setVisibility(paramInt);
    AppMethodBeat.o(190147);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190146);
    if (paramView != null) {}
    for (paramView = Integer.valueOf(paramView.getId()); paramView == null; paramView = null)
    {
      AppMethodBeat.o(190146);
      return;
    }
    if (paramView.intValue() == 2131307763)
    {
      paramView = new Bundle();
      Object localObject = new int[2];
      Object tmp58_56 = localObject;
      tmp58_56[0] = 0;
      Object tmp62_58 = tmp58_56;
      tmp62_58[1] = 0;
      tmp62_58;
      this.gAW.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = this.gAW.getWidth() / 2;
      f.b localb = f.b.gtm;
      paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - f.b.akk() / 2);
      i = localObject[1];
      j = ao.fromDPToPix(this.gnb.getContext(), 16);
      localObject = f.b.gtm;
      paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - f.b.akk());
      this.gzb.a(b.c.gyi, paramView);
      this.likeCount += 1;
      if (this.gAX)
      {
        paramView = i.gvw;
        i.nh(this.likeCount);
        this.gAX = false;
        this.likeCount = 0;
      }
    }
    AppMethodBeat.o(190146);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190151);
    if ((paramn instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.mm.ac.c.g((d.g.a.a)new c(this));
      }
      ac.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = i.gvw;
        i.nh(this.likeCount);
        this.gAX = false;
        this.likeCount = 0;
        AppMethodBeat.o(190151);
        return;
      }
      this.gAX = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(190151);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(190145);
      v.a(this.gBb);
      AppMethodBeat.o(190145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */