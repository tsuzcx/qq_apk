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
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.g.b.q;
import d.k.j;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  final b gVv;
  public final TextView gXA;
  private final TextView gXB;
  private final TextView gXC;
  public final View gXD;
  final View gXE;
  final View gXF;
  int gXG;
  private final d.g.a.a<z> gXH;
  public final ImageView gXw;
  public final RelativeLayout gXx;
  public final ImageView gXy;
  public final RelativeLayout gXz;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216072);
    this.gVv = paramb;
    this.gXw = ((ImageView)paramViewGroup.findViewById(2131307749));
    this.gXx = ((RelativeLayout)paramViewGroup.findViewById(2131307750));
    this.gXy = ((ImageView)paramViewGroup.findViewById(2131307753));
    this.gXz = ((RelativeLayout)paramViewGroup.findViewById(2131307754));
    this.gXA = ((TextView)paramViewGroup.findViewById(2131307751));
    this.gXB = ((TextView)paramViewGroup.findViewById(2131307755));
    this.gXC = ((TextView)paramViewGroup.findViewById(2131307759));
    this.gXD = paramViewGroup.findViewById(2131307752);
    this.gXE = paramViewGroup.findViewById(2131307756);
    this.gXF = paramViewGroup.findViewById(2131307760);
    this.gXH = ((d.g.a.a)new a(this, paramViewGroup));
    paramb = c.gPx;
    c.d(name(), this.gXH);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!aoA()) {
        paramb.bottomMargin = ar.en(paramViewGroup.getContext());
      }
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(216072);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216071);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (y.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216071);
      return;
      nL(8);
      AppMethodBeat.o(216071);
      return;
      nL(0);
      this.gJt.post((Runnable)new d(this));
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216068);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.gXI.gVv.a(b.c.gUg, new Bundle());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216068);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216069);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      this.gXI.gVv.a(b.c.gUf, new Bundle());
      paramView = g.gQZ;
      paramView = g.anL();
      if (paramView != null)
      {
        paramView = paramView.gKk;
        if (paramView != null)
        {
          localObject = g.gQZ;
          localObject = g.anL();
          if (localObject == null) {
            break label132;
          }
          localObject = ((d)localObject).gKk;
          if (localObject == null) {
            break label132;
          }
          bool = ((com.tencent.mm.live.core.core.b.b)localObject).gKd;
          if (bool) {
            break label137;
          }
        }
      }
      label132:
      label137:
      for (boolean bool = true;; bool = false)
      {
        paramView.gKd = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216069);
        return;
        bool = true;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(216070);
      x localx = this.gXI;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(localx.gXE);
      ((ArrayList)localObject).add(localx.gXF);
      View localView = localx.gXE;
      p.g(localView, "switchBtnLayout");
      int i = localView.getWidth();
      localView = localx.gXF;
      p.g(localView, "micBtnLayout");
      i = j.lw(i, localView.getWidth());
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        int j = (i - localView.getWidth()) / 2;
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), j + localView.getPaddingRight(), localView.getPaddingBottom());
      }
      localx.gJt.requestLayout();
      AppMethodBeat.o(216070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */