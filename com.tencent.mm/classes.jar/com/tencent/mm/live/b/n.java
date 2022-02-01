package com.tencent.mm.live.b;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.model.j;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends a
{
  private final kotlin.g.a.a<ah> liveMessageCallback;
  private final b nfT;
  private final ImageView nhX;
  private final RelativeLayout nhY;
  private final ImageView nhZ;
  private final RelativeLayout nia;
  private final TextView nib;
  private final TextView nic;
  private final TextView nid;
  private final View nie;
  private final View nif;
  private final View nig;
  private int nih;
  
  public n(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247098);
    this.nfT = paramb;
    this.nhX = ((ImageView)paramViewGroup.findViewById(b.e.live_right_panel_btn1));
    this.nhY = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_right_panel_btn1_click_area));
    this.nhZ = ((ImageView)paramViewGroup.findViewById(b.e.live_right_panel_btn2));
    this.nia = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_right_panel_btn2_click_area));
    this.nib = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn1_desc));
    this.nic = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn2_desc));
    this.nid = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn4_desc));
    this.nie = paramViewGroup.findViewById(b.e.live_right_panel_btn1_group);
    this.nif = paramViewGroup.findViewById(b.e.live_right_panel_btn2_group);
    this.nig = paramViewGroup.findViewById(b.e.live_right_panel_btn4_parent);
    this.liveMessageCallback = ((kotlin.g.a.a)new b(paramViewGroup, this));
    paramb = j.mXT;
    j.g(name(), this.liveMessageCallback);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = bf.bk(paramViewGroup.getContext());
      }
      ((LinearLayout)paramViewGroup.findViewById(b.e.content_root_view)).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(247098);
  }
  
  private static final void a(n paramn)
  {
    AppMethodBeat.i(247134);
    s.u(paramn, "this$0");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramn.nif);
    ((ArrayList)localObject).add(paramn.nig);
    int i = k.qu(paramn.nif.getWidth(), paramn.nig.getWidth());
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      int j = (i - localView.getWidth()) / 2;
      localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), j + localView.getPaddingRight(), localView.getPaddingBottom());
    }
    paramn.mJe.requestLayout();
    AppMethodBeat.o(247134);
  }
  
  private static final void a(n paramn, View paramView)
  {
    AppMethodBeat.i(247107);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "this$0");
    paramn.nfT.statusChange(b.c.ncn, new Bundle());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247107);
  }
  
  private static final void b(n paramn, View paramView)
  {
    AppMethodBeat.i(247119);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "this$0");
    paramn.nfT.statusChange(b.c.ncm, new Bundle());
    paramn = com.tencent.mm.live.model.u.mZl;
    paramn = com.tencent.mm.live.model.u.bii();
    if (paramn == null)
    {
      paramn = null;
      if (paramn != null)
      {
        paramView = com.tencent.mm.live.model.u.mZl;
        paramView = com.tencent.mm.live.model.u.bii();
        if (paramView != null) {
          break label161;
        }
        bool = true;
        label113:
        if (bool) {
          break label183;
        }
      }
    }
    label161:
    label183:
    for (boolean bool = true;; bool = false)
    {
      paramn.mNj = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247119);
      return;
      paramn = paramn.mNB;
      break;
      paramView = paramView.mNB;
      if (paramView == null)
      {
        bool = true;
        break label113;
      }
      bool = paramView.mNj;
      break label113;
    }
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(247201);
    s.u(paramLiveConfig, "config");
    this.nhX.setVisibility(0);
    this.nhZ.setVisibility(0);
    this.nhX.setImageDrawable(bb.e(this.mJe.getResources().getDrawable(b.g.icons_filled_share), -1));
    this.nhZ.setImageDrawable(bb.e(this.mJe.getResources().getDrawable(b.g.icons_filled_camera_switch), -1));
    this.nhY.setOnClickListener(new n..ExternalSyntheticLambda0(this));
    this.nia.setOnClickListener(new n..ExternalSyntheticLambda1(this));
    this.nhY.setVisibility(8);
    this.nib.setVisibility(8);
    this.nie.setVisibility(8);
    AppMethodBeat.o(247201);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247212);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (n.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247212);
      return;
      tO(8);
      AppMethodBeat.o(247212);
      return;
      tO(0);
      this.mJe.post(new n..ExternalSyntheticLambda2(this));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(ViewGroup paramViewGroup, n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.n
 * JD-Core Version:    0.7.0.1
 */