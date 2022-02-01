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
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  final b hOp;
  public final View hQA;
  final View hQB;
  final View hQC;
  int hQD;
  public final ImageView hQt;
  public final RelativeLayout hQu;
  public final ImageView hQv;
  public final RelativeLayout hQw;
  public final TextView hQx;
  private final TextView hQy;
  private final TextView hQz;
  private final kotlin.g.a.a<kotlin.x> liveMessageCallback;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208034);
    this.hOp = paramb;
    this.hQt = ((ImageView)paramViewGroup.findViewById(2131303535));
    this.hQu = ((RelativeLayout)paramViewGroup.findViewById(2131303536));
    this.hQv = ((ImageView)paramViewGroup.findViewById(2131303539));
    this.hQw = ((RelativeLayout)paramViewGroup.findViewById(2131303540));
    this.hQx = ((TextView)paramViewGroup.findViewById(2131303537));
    this.hQy = ((TextView)paramViewGroup.findViewById(2131303541));
    this.hQz = ((TextView)paramViewGroup.findViewById(2131303545));
    this.hQA = paramViewGroup.findViewById(2131303538);
    this.hQB = paramViewGroup.findViewById(2131303542);
    this.hQC = paramViewGroup.findViewById(2131303546);
    this.liveMessageCallback = ((kotlin.g.a.a)new a(this, paramViewGroup));
    paramb = m.hGg;
    m.d(name(), this.liveMessageCallback);
    if (paramViewGroup.findViewById(2131299216) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = au.aD(paramViewGroup.getContext());
      }
      paramViewGroup = paramViewGroup.findViewById(2131299216);
      p.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(208034);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208033);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (y.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208033);
      return;
      rg(8);
      AppMethodBeat.o(208033);
      return;
      rg(0);
      this.hwr.post((Runnable)new d(this));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208030);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.hQE.hOp.statusChange(b.c.hLF, new Bundle());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208030);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208031);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      this.hQE.hOp.statusChange(b.c.hLE, new Bundle());
      paramView = com.tencent.mm.live.b.x.hJf;
      paramView = com.tencent.mm.live.b.x.aGv();
      if (paramView != null)
      {
        paramView = paramView.hzt;
        if (paramView != null)
        {
          localObject = com.tencent.mm.live.b.x.hJf;
          localObject = com.tencent.mm.live.b.x.aGv();
          if (localObject == null) {
            break label132;
          }
          localObject = ((f)localObject).hzt;
          if (localObject == null) {
            break label132;
          }
          bool = ((d)localObject).hzh;
          if (bool) {
            break label137;
          }
        }
      }
      label132:
      label137:
      for (boolean bool = true;; bool = false)
      {
        paramView.hzh = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveHostRightPanelPlugin$setupForHost$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208031);
        return;
        bool = true;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(208032);
      x localx = this.hQE;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(localx.hQB);
      ((ArrayList)localObject).add(localx.hQC);
      View localView = localx.hQB;
      p.g(localView, "switchBtnLayout");
      int i = localView.getWidth();
      localView = localx.hQC;
      p.g(localView, "micBtnLayout");
      i = j.mZ(i, localView.getWidth());
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        int j = (i - localView.getWidth()) / 2;
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), j + localView.getPaddingRight(), localView.getPaddingBottom());
      }
      localx.hwr.requestLayout();
      AppMethodBeat.o(208032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */