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
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveHostRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "lastLikeCount", "", "liveMessageCallback", "Lkotlin/Function0;", "", "liveScreenBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "liveScreenBtnClickArea", "Landroid/widget/RelativeLayout;", "micDescTv", "Landroid/widget/TextView;", "screenDescTv", "shareBtn", "shareBtnClickArea", "shareDescTv", "switchCameraBtn", "switchCameraBtnClickArea", "switchDescTv", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupForHost", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class x
  extends a
{
  final b IIs;
  public final ImageView Kvk;
  public final RelativeLayout Kvl;
  public final RelativeLayout Kvm;
  public final ImageView Kvn;
  public final RelativeLayout Kvo;
  public final TextView Kvp;
  private final TextView Kvq;
  public final TextView Kvr;
  private final TextView Kvs;
  int Kvt;
  private final d.g.a.a<y> Kvu;
  public final ImageView tKB;
  
  public x(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202945);
    this.IIs = paramb;
    this.Kvk = ((ImageView)paramViewGroup.findViewById(2131307666));
    this.Kvl = ((RelativeLayout)paramViewGroup.findViewById(2131307667));
    this.tKB = ((ImageView)paramViewGroup.findViewById(2131307670));
    this.Kvm = ((RelativeLayout)paramViewGroup.findViewById(2131307671));
    this.Kvn = ((ImageView)paramViewGroup.findViewById(2131307674));
    this.Kvo = ((RelativeLayout)paramViewGroup.findViewById(2131307675));
    this.Kvp = ((TextView)paramViewGroup.findViewById(2131307668));
    this.Kvq = ((TextView)paramViewGroup.findViewById(2131307672));
    this.Kvr = ((TextView)paramViewGroup.findViewById(2131307676));
    this.Kvs = ((TextView)paramViewGroup.findViewById(2131307680));
    this.Kvu = ((d.g.a.a)new a(this, paramViewGroup));
    paramb = c.qYi;
    c.L(this.Kvu);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ap.eb(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(202945);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202944);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (y.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202944);
      return;
      agK(8);
      AppMethodBeat.o(202944);
      return;
      agK(0);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(x paramx, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class b
    implements View.OnClickListener
  {
    public b(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202941);
      this.Kvv.IIs.a(b.c.FAZ, new Bundle());
      AppMethodBeat.o(202941);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202942);
      this.Kvv.IIs.a(b.c.FAY, new Bundle());
      AppMethodBeat.o(202942);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(x paramx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202943);
      this.Kvv.IIs.a(b.c.FBa, new Bundle());
      AppMethodBeat.o(202943);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.x
 * JD-Core Version:    0.7.0.1
 */