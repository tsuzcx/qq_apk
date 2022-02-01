package com.tencent.mm.live.c;

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
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.model.e;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  private final b kCL;
  public final ImageView kEQ;
  public final RelativeLayout kER;
  public final ImageView kES;
  public final RelativeLayout kET;
  public final TextView kEU;
  private final TextView kEV;
  private final TextView kEW;
  public final View kEX;
  private final View kEY;
  private final View kEZ;
  private int kFa;
  private final kotlin.g.a.a<kotlin.x> liveMessageCallback;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(189406);
    this.kCL = paramb;
    this.kEQ = ((ImageView)paramViewGroup.findViewById(b.e.live_right_panel_btn1));
    this.kER = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_right_panel_btn1_click_area));
    this.kES = ((ImageView)paramViewGroup.findViewById(b.e.live_right_panel_btn2));
    this.kET = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_right_panel_btn2_click_area));
    this.kEU = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn1_desc));
    this.kEV = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn2_desc));
    this.kEW = ((TextView)paramViewGroup.findViewById(b.e.live_right_panel_btn4_desc));
    this.kEX = paramViewGroup.findViewById(b.e.live_right_panel_btn1_group);
    this.kEY = paramViewGroup.findViewById(b.e.live_right_panel_btn2_group);
    this.kEZ = paramViewGroup.findViewById(b.e.live_right_panel_btn4_parent);
    this.liveMessageCallback = ((kotlin.g.a.a)new a(this, paramViewGroup));
    paramb = j.kue;
    j.d(name(), this.liveMessageCallback);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = ax.aB(paramViewGroup.getContext());
      }
      paramViewGroup = paramViewGroup.findViewById(b.e.content_root_view);
      p.j(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(189406);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(189393);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (y.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189393);
      return;
      tU(8);
      AppMethodBeat.o(189393);
      return;
      tU(0);
      this.kiF.post((Runnable)new d(this));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193554);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      x.a(this.kFb).statusChange(b.c.kyY, new Bundle());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193554);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192106);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      x.a(this.kFb).statusChange(b.c.kyX, new Bundle());
      paramView = u.kwz;
      paramView = u.aOv();
      if (paramView != null)
      {
        paramView = paramView.kmp;
        if (paramView != null)
        {
          localObject = u.kwz;
          localObject = u.aOv();
          if (localObject == null) {
            break label132;
          }
          localObject = ((g)localObject).kmp;
          if (localObject == null) {
            break label132;
          }
          bool = ((e)localObject).kme;
          if (bool) {
            break label137;
          }
        }
      }
      label132:
      label137:
      for (boolean bool = true;; bool = false)
      {
        paramView.kme = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192106);
        return;
        bool = true;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(200138);
      x.b(this.kFb);
      AppMethodBeat.o(200138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */