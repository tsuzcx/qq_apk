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
import d.k.h;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  final b gSM;
  public final ImageView gUN;
  public final RelativeLayout gUO;
  public final ImageView gUP;
  public final RelativeLayout gUQ;
  public final TextView gUR;
  private final TextView gUS;
  private final TextView gUT;
  public final View gUU;
  final View gUV;
  final View gUW;
  int gUX;
  private final d.g.a.a<z> gUY;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212452);
    this.gSM = paramb;
    this.gUN = ((ImageView)paramViewGroup.findViewById(2131307749));
    this.gUO = ((RelativeLayout)paramViewGroup.findViewById(2131307750));
    this.gUP = ((ImageView)paramViewGroup.findViewById(2131307753));
    this.gUQ = ((RelativeLayout)paramViewGroup.findViewById(2131307754));
    this.gUR = ((TextView)paramViewGroup.findViewById(2131307751));
    this.gUS = ((TextView)paramViewGroup.findViewById(2131307755));
    this.gUT = ((TextView)paramViewGroup.findViewById(2131307759));
    this.gUU = paramViewGroup.findViewById(2131307752);
    this.gUV = paramViewGroup.findViewById(2131307756);
    this.gUW = paramViewGroup.findViewById(2131307760);
    this.gUY = ((d.g.a.a)new a(this, paramViewGroup));
    paramb = c.gMO;
    c.d(name(), this.gUY);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!aol()) {
        paramb.bottomMargin = ar.ej(paramViewGroup.getContext());
      }
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(212452);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212451);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (y.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212451);
      return;
      nI(8);
      AppMethodBeat.o(212451);
      return;
      nI(0);
      this.gGK.post((Runnable)new d(this));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212448);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.gUZ.gSM.a(b.c.gRy, new Bundle());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212448);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212449);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      this.gUZ.gSM.a(b.c.gRx, new Bundle());
      paramView = g.gOr;
      paramView = g.anw();
      if (paramView != null)
      {
        paramView = paramView.gHB;
        if (paramView != null)
        {
          localObject = g.gOr;
          localObject = g.anw();
          if (localObject == null) {
            break label132;
          }
          localObject = ((d)localObject).gHB;
          if (localObject == null) {
            break label132;
          }
          bool = ((com.tencent.mm.live.core.core.b.b)localObject).gHu;
          if (bool) {
            break label137;
          }
        }
      }
      label132:
      label137:
      for (boolean bool = true;; bool = false)
      {
        paramView.gHu = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212449);
        return;
        bool = true;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(212450);
      x localx = this.gUZ;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(localx.gUV);
      ((ArrayList)localObject).add(localx.gUW);
      View localView = localx.gUV;
      p.g(localView, "switchBtnLayout");
      int i = localView.getWidth();
      localView = localx.gUW;
      p.g(localView, "micBtnLayout");
      i = h.lp(i, localView.getWidth());
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        int j = (i - localView.getWidth()) / 2;
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), j + localView.getPaddingRight(), localView.getPaddingBottom());
      }
      localx.gGK.requestLayout();
      AppMethodBeat.o(212450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */