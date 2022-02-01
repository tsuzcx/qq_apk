package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.model.a.q;
import com.tencent.mm.live.model.j;
import com.tencent.mm.live.model.l.b;
import com.tencent.mm.live.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeLayout", "Landroid/widget/LinearLayout;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLike", "scaleAnimate", "target", "targetValue", "", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
  implements View.OnClickListener, com.tencent.mm.am.h
{
  public static final m.a nhM;
  private int likeCount;
  private final b nfT;
  private final TextView nga;
  public final ag nhN;
  private final ImageView nhO;
  private final RelativeLayout nhP;
  private final LinearLayout nhQ;
  private boolean nhR;
  private final Object nhS;
  private final kotlin.g.a.a<ah> nhT;
  private final MTimerHandler nhU;
  
  static
  {
    AppMethodBeat.i(247162);
    nhM = new m.a((byte)0);
    AppMethodBeat.o(247162);
  }
  
  public m(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247087);
    this.nfT = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_visitor_mic_parent);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_visitor_mic_parent)");
    this.nhN = new ag((ViewGroup)paramb, this.nfT);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_right_panel_like)");
    this.nhO = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like_click_area);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…ht_panel_like_click_area)");
    this.nhP = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_right_panel_like_count_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
    this.nga = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_like_layout);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_like_layout)");
    this.nhQ = ((LinearLayout)paramb);
    this.nhR = true;
    this.nhS = paramViewGroup.getContext().getSystemService("vibrator");
    this.nhT = ((kotlin.g.a.a)new c(paramViewGroup, this));
    this.nhU = new MTimerHandler("RoomLiveLike::Timer", new m..ExternalSyntheticLambda1(this), true);
    this.nhO.setImageDrawable(bb.e(paramViewGroup.getContext().getResources().getDrawable(b.g.icons_filled_call_good), -1));
    this.nhP.setOnTouchListener(new m..ExternalSyntheticLambda0(this));
    paramb = j.mXT;
    j.g(name(), this.nhT);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = bf.bk(paramViewGroup.getContext());
      ((LinearLayout)paramViewGroup.findViewById(b.e.content_root_view)).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(247087);
  }
  
  private static final boolean a(m paramm)
  {
    AppMethodBeat.i(247106);
    kotlin.g.b.s.u(paramm, "this$0");
    if (paramm.likeCount < 9)
    {
      if ((paramm.nhS instanceof Vibrator)) {
        ((Vibrator)paramm.nhS).vibrate(10L);
      }
      paramm.likeCount += 1;
      d.uiThread((kotlin.g.a.a)new e(paramm));
      AppMethodBeat.o(247106);
      return true;
    }
    AppMethodBeat.o(247106);
    return false;
  }
  
  private static final boolean a(m paramm, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247116);
    kotlin.g.b.s.u(paramm, "this$0");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247116);
      return true;
      t((View)paramm.nhP, 1.7F);
      paramm.nga.setVisibility(4);
      paramm.nhU.startTimer(0L, 200L);
      continue;
      paramm.nhU.stopTimer();
      t((View)paramm.nhP, 1.0F);
      paramm.nga.setVisibility(0);
      if (paramm.nhR)
      {
        paramView = o.mZb;
        o.tA(paramm.likeCount);
        paramm.nhR = false;
        paramm.likeCount = 0;
      }
    }
  }
  
  private static final void b(m paramm)
  {
    AppMethodBeat.i(247132);
    kotlin.g.b.s.u(paramm, "this$0");
    Object localObject1 = paramm.nhN.nks;
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    ((ArrayList)localObject2).add(paramm.nhQ);
    int i = k.qu(paramm.nhQ.getWidth(), ((LinearLayout)localObject1).getWidth());
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      int j = (i - ((View)localObject2).getWidth()) / 2;
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), ((View)localObject2).getPaddingTop(), j + ((View)localObject2).getPaddingRight(), ((View)localObject2).getPaddingBottom());
    }
    paramm.mJe.requestLayout();
    AppMethodBeat.o(247132);
  }
  
  private static void t(View paramView, float paramFloat)
  {
    AppMethodBeat.i(247096);
    paramView.animate().setDuration(200L).scaleX(paramFloat).scaleY(paramFloat).start();
    AppMethodBeat.o(247096);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(247234);
    com.tencent.mm.kernel.h.baD().mCm.a(3957, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247234);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(247202);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.e.live_right_panel_like_click_area;
      if (paramView != null) {
        break label90;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247202);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label90:
      if (paramView.intValue() == i)
      {
        paramView = new Bundle();
        localObject = new int[2];
        localObject[0] = 0;
        localObject[1] = 0;
        this.nhP.getLocationOnScreen((int[])localObject);
        i = localObject[0];
        int j = this.nhP.getWidth() / 2;
        l.b localb = l.b.mYf;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_X", i + j - l.b.bhn() / 2);
        i = localObject[1];
        j = bd.fromDPToPix(this.mJe.getContext(), 16);
        localObject = l.b.mYf;
        paramView.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", i - j - l.b.bhn());
        this.nfT.statusChange(b.c.ncI, paramView);
        this.likeCount += 1;
        if (this.nhR)
        {
          paramView = o.mZb;
          o.tA(this.likeCount);
          this.nhR = false;
          this.likeCount = 0;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(247264);
    if ((paramp instanceof q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        d.uiThread((kotlin.g.a.a)new d(this));
      }
      Log.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " likeCount:" + this.likeCount);
      if (this.likeCount > 0)
      {
        paramString = o.mZb;
        o.tA(this.likeCount);
        this.nhR = false;
        this.likeCount = 0;
        AppMethodBeat.o(247264);
        return;
      }
      this.nhR = true;
      this.likeCount = 0;
    }
    AppMethodBeat.o(247264);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247223);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (m.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247223);
      return;
      tO(8);
      AppMethodBeat.o(247223);
      return;
      tO(0);
      this.mJe.post(new m..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(247223);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
      while (i != 0)
      {
        tO(8);
        AppMethodBeat.o(247223);
        return;
        i = 0;
      }
      tO(0);
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(247213);
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(247213);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247242);
    com.tencent.mm.kernel.h.baD().mCm.b(3957, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247242);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ViewGroup paramViewGroup, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.m
 * JD-Core Version:    0.7.0.1
 */