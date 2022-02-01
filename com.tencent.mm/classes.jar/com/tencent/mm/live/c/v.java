package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.a.p;
import com.tencent.mm.live.b.e.b;
import com.tencent.mm.live.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v
  extends a
  implements View.OnClickListener, com.tencent.mm.al.g
{
  public static final a Kvh;
  private final b IIs;
  private final bj Kvd;
  private final RelativeLayout Kve;
  private boolean Kvf;
  private final d.g.a.a<y> Kvg;
  private int likeCount;
  private final TextView qrL;
  private final ImageView xmT;
  
  static
  {
    AppMethodBeat.i(202936);
    Kvh = new a((byte)0);
    AppMethodBeat.o(202936);
  }
  
  public v(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202935);
    this.IIs = paramb;
    paramb = paramViewGroup.findViewById(2131307770);
    k.g(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.Kvd = new bj((ViewGroup)paramb, this.IIs);
    paramb = paramViewGroup.findViewById(2131307683);
    k.g(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.xmT = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307684);
    k.g(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.Kve = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307685);
    k.g(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.qrL = ((TextView)paramb);
    this.Kvf = true;
    this.Kvg = ((d.g.a.a)new b(this, paramViewGroup));
    paramb = this.xmT;
    Object localObject = paramViewGroup.getContext();
    k.g(localObject, "root.context");
    paramb.setImageDrawable(am.e(((Context)localObject).getResources().getDrawable(2131690419), -1));
    this.Kve.setOnClickListener((View.OnClickListener)this);
    paramb = com.tencent.mm.live.b.c.qYi;
    com.tencent.mm.live.b.c.L(this.Kvg);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      localObject = paramViewGroup.getResources();
      k.g(localObject, "root.resources");
      if (((Resources)localObject).getConfiguration().orientation != 1) {
        break label281;
      }
      paramb.bottomMargin = ap.eb(paramViewGroup.getContext());
    }
    for (;;)
    {
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
      AppMethodBeat.o(202935);
      return;
      label281:
      paramb.setMarginEnd(ap.eb(paramViewGroup.getContext()));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202931);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (w.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202931);
      return;
      agK(8);
      AppMethodBeat.o(202931);
      return;
      agK(0);
    }
  }
  
  public final void agK(int paramInt)
  {
    AppMethodBeat.i(202930);
    this.pTc.setVisibility(paramInt);
    AppMethodBeat.o(202930);
  }
  
  public final boolean dia()
  {
    return false;
  }
  
  public final void fOM()
  {
    AppMethodBeat.i(202932);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3957, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202932);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(202933);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3957, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202933);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202929);
    if (paramView != null) {}
    for (paramView = Integer.valueOf(paramView.getId()); paramView == null; paramView = null)
    {
      AppMethodBeat.o(202929);
      return;
    }
    if (paramView.intValue() == 2131307684)
    {
      paramView = new Bundle();
      Object localObject = new int[2];
      Object tmp58_56 = localObject;
      tmp58_56[0] = 0;
      Object tmp62_58 = tmp58_56;
      tmp62_58[1] = 0;
      tmp62_58;
      this.Kve.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = this.Kve.getWidth() / 2;
      e.b localb = e.b.qYo;
      paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - e.b.elZ() / 2);
      i = localObject[1];
      j = ao.fromDPToPix(this.pTc.getContext(), 16);
      localObject = e.b.qYo;
      paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - e.b.elZ());
      this.IIs.a(b.c.FBs, paramView);
      this.likeCount += 1;
      if (this.Kvf)
      {
        paramView = h.xfu;
        h.agI(this.likeCount);
        this.Kvf = false;
        this.likeCount = 0;
      }
    }
    AppMethodBeat.o(202929);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202934);
    if ((paramn instanceof p))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.mm.ad.c.g((d.g.a.a)new c(this));
      }
      ad.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = h.xfu;
        h.agI(this.likeCount);
        this.Kvf = false;
        this.likeCount = 0;
        AppMethodBeat.o(202934);
        return;
      }
      this.Kvf = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(202934);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(v paramv, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.v
 * JD-Core Version:    0.7.0.1
 */