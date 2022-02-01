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
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.k.h;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "micBtnLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "micDescTv", "Landroid/widget/TextView;", "shareBtn", "Landroid/widget/ImageView;", "shareBtnClickArea", "Landroid/widget/RelativeLayout;", "shareBtnLayout", "shareDescTv", "switchBtnLayout", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "checkBtnLayout", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  public final ImageView gBd;
  public final RelativeLayout gBe;
  public final ImageView gBf;
  public final RelativeLayout gBg;
  public final TextView gBh;
  private final TextView gBi;
  private final TextView gBj;
  public final View gBk;
  final View gBl;
  final View gBm;
  int gBn;
  private final d.g.a.a<y> gBo;
  final b gzb;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190163);
    this.gzb = paramb;
    this.gBd = ((ImageView)paramViewGroup.findViewById(2131307749));
    this.gBe = ((RelativeLayout)paramViewGroup.findViewById(2131307750));
    this.gBf = ((ImageView)paramViewGroup.findViewById(2131307753));
    this.gBg = ((RelativeLayout)paramViewGroup.findViewById(2131307754));
    this.gBh = ((TextView)paramViewGroup.findViewById(2131307751));
    this.gBi = ((TextView)paramViewGroup.findViewById(2131307755));
    this.gBj = ((TextView)paramViewGroup.findViewById(2131307759));
    this.gBk = paramViewGroup.findViewById(2131307752);
    this.gBl = paramViewGroup.findViewById(2131307756);
    this.gBm = paramViewGroup.findViewById(2131307760);
    this.gBo = ((d.g.a.a)new a(this, paramViewGroup));
    paramb = c.gtd;
    c.d(name(), this.gBo);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      if (!aly()) {
        paramb.bottomMargin = ap.ej(paramViewGroup.getContext());
      }
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(190163);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190162);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (y.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190162);
      return;
      nj(8);
      AppMethodBeat.o(190162);
      return;
      nj(0);
      this.gnb.post((Runnable)new d(this));
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190159);
      this.gBp.gzb.a(b.c.gxN, new Bundle());
      AppMethodBeat.o(190159);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(190160);
      this.gBp.gzb.a(b.c.gxM, new Bundle());
      paramView = g.guG;
      paramView = g.akJ();
      if (paramView != null)
      {
        paramView = paramView.gnS;
        if (paramView != null)
        {
          Object localObject = g.guG;
          localObject = g.akJ();
          if (localObject != null)
          {
            localObject = ((d)localObject).gnS;
            if (localObject != null)
            {
              bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gnL;
              if (bool1) {
                break label105;
              }
            }
          }
          label105:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramView.gnL = bool1;
            AppMethodBeat.o(190160);
            return;
            bool1 = true;
            break;
          }
        }
      }
      AppMethodBeat.o(190160);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(x paramx) {}
    
    public final void run()
    {
      AppMethodBeat.i(190161);
      x localx = this.gBp;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(localx.gBl);
      ((ArrayList)localObject).add(localx.gBm);
      View localView = localx.gBl;
      k.g(localView, "switchBtnLayout");
      int i = localView.getWidth();
      localView = localx.gBm;
      k.g(localView, "micBtnLayout");
      i = h.la(i, localView.getWidth());
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        int j = (i - localView.getWidth()) / 2;
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), j + localView.getPaddingRight(), localView.getPaddingBottom());
      }
      localx.gnb.requestLayout();
      AppMethodBeat.o(190161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */