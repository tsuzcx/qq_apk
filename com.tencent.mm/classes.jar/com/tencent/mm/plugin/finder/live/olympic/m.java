package com.tencent.mm.plugin.finder.live.olympic;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsTorchPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "switchWidget", "Landroid/view/View;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Landroid/view/View;)V", "TAG", "", "bgRect", "Landroid/graphics/Rect;", "getBgRect", "()Landroid/graphics/Rect;", "setBgRect", "(Landroid/graphics/Rect;)V", "inMini", "", "isLighted", "lightObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicBaseData;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "switchRect", "getSwitchRect", "setSwitchRect", "getSwitchWidget", "()Landroid/view/View;", "switchWidgetLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "torchCenterOffset", "", "torchView", "Lorg/libpag/PAGView;", "kotlin.jvm.PlatformType", "getTorchView", "()Lorg/libpag/PAGView;", "torchViewParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getTorchViewParent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "adjustTorchView", "", "scaleX", "scaleY", "clipPercent", "calc", "start", "end", "percent", "checkRect", "rect", "initTorchView", "miniView", "tag", "animate", "fromRect", "toRect", "view", "moveView", "endX", "endY", "endScaleX", "endScaleY", "clipTorch", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateRect", "updateTorchView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  private boolean COB;
  private final y<n.e> COC;
  private final View COL;
  private Rect COM;
  private Rect CON;
  final PAGView COO;
  private final ConstraintLayout COP;
  private boolean COQ;
  private float COR;
  private final View.OnLayoutChangeListener COS;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public m(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, View paramView)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360456);
    this.nfT = paramb;
    this.COL = paramView;
    this.TAG = "Finder.FinderLiveOlympicsTorchPlugin";
    this.COO = ((PAGView)paramViewGroup.findViewById(p.e.BXd));
    this.COP = ((ConstraintLayout)paramViewGroup.findViewById(p.e.CbG));
    this.COC = new m..ExternalSyntheticLambda1(this);
    this.COS = new m..ExternalSyntheticLambda0(this);
    paramViewGroup = bf.bf(paramViewGroup.getContext());
    this.COM = new Rect(0, 0, paramViewGroup.x, paramViewGroup.y);
    this.CON = new Rect(0, 0, 0, 0);
    if (this.COL == null)
    {
      Log.e(this.TAG, "switchWidget is null");
      tO(8);
      AppMethodBeat.o(360456);
      return;
    }
    this.COL.addOnLayoutChangeListener(this.COS);
    AppMethodBeat.o(360456);
  }
  
  private static final void a(m paramm, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(360491);
    s.u(paramm, "this$0");
    paramView = bj.GlQ;
    if (bj.y(paramm.getBuContext()))
    {
      Log.i(paramm.TAG, "switchWidgetLayoutListener updateTorchView");
      paramm.bz("onLayout", false);
    }
    AppMethodBeat.o(360491);
  }
  
  private static final void a(m paramm, n.e parame)
  {
    AppMethodBeat.i(360483);
    s.u(paramm, "this$0");
    boolean bool = paramm.COB;
    int i;
    String str;
    if ((parame != null) && (bool == parame.EhJ))
    {
      i = 1;
      if (i == 0)
      {
        str = paramm.TAG;
        if (parame != null) {
          break label75;
        }
      }
    }
    label75:
    for (parame = null;; parame = Boolean.valueOf(parame.EhJ))
    {
      Log.i(str, s.X("lightObserver ", parame));
      paramm.enI();
      AppMethodBeat.o(360483);
      return;
      i = 0;
      break;
    }
  }
  
  private final void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(360473);
    Log.i(this.TAG, paramString + " updateTorchView, animate:" + paramBoolean + ", inMini:" + this.COQ);
    this.COO.setAlpha(1.0F);
    if (this.COQ)
    {
      this.COO.setVisibility(8);
      AppMethodBeat.o(360473);
      return;
    }
    this.COO.setVisibility(0);
    AppMethodBeat.o(360473);
  }
  
  private final void enI()
  {
    AppMethodBeat.i(360464);
    Log.i(this.TAG, "initTorchView");
    n.e locale = (n.e)((n)business(n.class)).Ehd.getValue();
    if (locale == null) {}
    for (boolean bool = false;; bool = locale.EhJ)
    {
      this.COB = bool;
      d.z((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(360464);
      return;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(360538);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360538);
      return;
      if (!isLandscape())
      {
        enI();
        paramc = this.mJe.getContext();
        if ((paramc instanceof MMActivity)) {}
        for (paramc = (MMActivity)paramc; paramc != null; paramc = null)
        {
          Log.i(this.TAG, "observe olympicData");
          ((n)business(n.class)).Ehd.a((q)paramc, this.COC);
          AppMethodBeat.o(360538);
          return;
        }
        this.COQ = true;
        bz("video", false);
        AppMethodBeat.o(360538);
        return;
        this.COQ = false;
        bz("bgm", false);
        AppMethodBeat.o(360538);
        return;
        this.COQ = true;
        if (paramBundle == null) {}
        for (;;)
        {
          bz("normal", bool);
          AppMethodBeat.o(360538);
          return;
          bool = paramBundle.getBoolean("animate", false);
        }
        this.COQ = false;
        bz("mini", true);
        AppMethodBeat.o(360538);
        return;
        Log.i(this.TAG, s.X("updateTorchView clear ", Boolean.valueOf(this.COQ)));
        if (this.COQ)
        {
          this.COO.setAlpha(0.0F);
          AppMethodBeat.o(360538);
          return;
          Log.i(this.TAG, "updateTorchView clear, set alpha 1");
          this.COO.setAlpha(1.0F);
        }
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(360542);
    super.unMount();
    View localView = this.COL;
    if (localView != null) {
      localView.removeOnLayoutChangeListener(this.COS);
    }
    this.COO.setVisibility(8);
    this.COQ = false;
    this.COR = 0.0F;
    this.COB = false;
    ((n)business(n.class)).Ehd.b(this.COC);
    AppMethodBeat.o(360542);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.m
 * JD-Core Version:    0.7.0.1
 */