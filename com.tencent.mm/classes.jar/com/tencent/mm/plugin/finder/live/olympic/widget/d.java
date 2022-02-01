package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.olympic.c;
import com.tencent.mm.plugin.finder.live.olympic.report.a.a;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveVisitorOlympicEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "btnText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "certificateLayout", "Landroid/widget/RelativeLayout;", "certificateNumText", "certificateText", "imageLight", "Landroid/widget/ImageView;", "imageStar", "imageTorch", "olympicsState", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicState;", "relayNumText", "reportMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "torchBtnLayout", "torchLayout", "burnTorchState", "", "checkVisible", "initCertReport", "isVisible", "myCertificateState", "onClick", "view", "Landroid/view/View;", "relayTorchState", "setVisible", "visible", "", "updateBtnState", "state", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements View.OnClickListener
{
  public static final d.a CSV;
  private n.f CNm;
  private final RelativeLayout CSW;
  private final TextView CSX;
  private final TextView CSY;
  private final ImageView CSZ;
  private final ImageView CTa;
  private final ImageView CTb;
  private final RelativeLayout CTc;
  private final RelativeLayout CTd;
  private final TextView CTe;
  private final TextView CTf;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final ViewGroup mJe;
  final com.tencent.mm.live.b.b nfT;
  private final HashMap<n.f, Boolean> xLE;
  
  static
  {
    AppMethodBeat.i(360803);
    CSV = new d.a((byte)0);
    AppMethodBeat.o(360803);
  }
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(360743);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.CSW = ((RelativeLayout)this.mJe.findViewById(p.e.BQq));
    this.CSX = ((TextView)this.mJe.findViewById(p.e.finder_live_olympic_btn_text));
    this.CSY = ((TextView)this.mJe.findViewById(p.e.BPO));
    this.CSZ = ((ImageView)this.mJe.findViewById(p.e.BPN));
    this.CTa = ((ImageView)this.mJe.findViewById(p.e.BPP));
    this.CTb = ((ImageView)this.mJe.findViewById(p.e.BPS));
    this.CTc = ((RelativeLayout)this.mJe.findViewById(p.e.BQn));
    this.CTd = ((RelativeLayout)this.mJe.findViewById(p.e.BQo));
    this.CTe = ((TextView)this.mJe.findViewById(p.e.BPR));
    this.CTf = ((TextView)this.mJe.findViewById(p.e.BPQ));
    this.CNm = n.f.EhL;
    this.xLE = new HashMap();
    this.mJe.setOnClickListener((View.OnClickListener)this);
    this.CTd.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BAk));
    AppMethodBeat.o(360743);
  }
  
  private static final void a(d paramd, n.e parame)
  {
    boolean bool3 = true;
    AppMethodBeat.i(360787);
    s.u(paramd, "this$0");
    parame = (n.e)((n)paramd.CwG.getBuContext().business(n.class)).Ehd.getValue();
    boolean bool1;
    label78:
    int i;
    label98:
    label105:
    long l;
    if ((parame != null) && (parame.EhI == true))
    {
      bool1 = true;
      parame = ((n)paramd.CwG.getBuContext().business(n.class)).Ehe;
      if (parame != null) {
        break label228;
      }
      parame = null;
      parame = (CharSequence)parame;
      if ((parame != null) && (parame.length() != 0)) {
        break label236;
      }
      i = 1;
      if (i != 0) {
        break label241;
      }
      bool2 = true;
      Log.i("LiveOlympicButton", "initReportData isTorcher: " + bool1 + " isRelay: " + bool2);
      parame = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
      l = ((f)paramd.CwG.getBuContext().business(f.class)).liveInfo.liveId;
      if ((bool1) || (!bool2)) {
        break label247;
      }
    }
    label228:
    label236:
    label241:
    label247:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      com.tencent.mm.plugin.finder.live.olympic.report.a.a(new a.a(l, bool2, bool1));
      paramd.a(((n)paramd.CwG.getBuContext().business(n.class)).ezi());
      AppMethodBeat.o(360787);
      return;
      bool1 = false;
      break;
      parame = parame.ZVq;
      break label78;
      i = 0;
      break label98;
      bool2 = false;
      break label105;
    }
  }
  
  private final void a(n.f paramf)
  {
    AppMethodBeat.i(360751);
    Log.i("LiveOlympicButton", s.X("updateBtnState: ", paramf));
    this.CNm = paramf;
    if (!s.p(this.xLE.get(paramf), Boolean.TRUE))
    {
      ((Map)this.xLE).put(paramf, Boolean.TRUE);
      com.tencent.mm.plugin.finder.live.olympic.report.a locala = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
      com.tencent.mm.plugin.finder.live.olympic.report.a.b(paramf, false);
    }
    switch (d.b.$EnumSwitchMapping$0[paramf.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360751);
      return;
      eoE();
      AppMethodBeat.o(360751);
      return;
      eoF();
      AppMethodBeat.o(360751);
      return;
      eoG();
    }
  }
  
  private final void eoE()
  {
    AppMethodBeat.i(360757);
    this.CSW.setVisibility(0);
    this.CTd.setVisibility(8);
    this.CTb.setVisibility(0);
    this.CSZ.setVisibility(0);
    this.CTa.setVisibility(8);
    this.CSX.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cps));
    this.CSY.setVisibility(4);
    b.b.a(this.nfT, b.c.nfR);
    AppMethodBeat.o(360757);
  }
  
  private final void eoF()
  {
    AppMethodBeat.i(360766);
    this.CSW.setVisibility(0);
    this.CTd.setVisibility(8);
    this.CTb.setVisibility(8);
    this.CSZ.setVisibility(0);
    this.CTa.setVisibility(0);
    this.CSX.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.Cpr));
    this.CSY.setVisibility(4);
    this.CTc.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new c(this));
    AppMethodBeat.o(360766);
  }
  
  private final void eoG()
  {
    AppMethodBeat.i(360774);
    this.CSW.setVisibility(8);
    this.CTd.setVisibility(0);
    TextView localTextView = this.CTf;
    Context localContext = this.mJe.getContext();
    int i = p.h.Cpi;
    Object localObject = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    localObject = (n.e)((n)this.CwG.getBuContext().business(n.class)).Ehd.getValue();
    if (localObject == null) {}
    for (long l = 0L;; l = ((n.e)localObject).CPl)
    {
      localTextView.setText((CharSequence)localContext.getString(i, new Object[] { com.tencent.mm.plugin.finder.live.olympic.util.a.on(l) }));
      b.b.a(this.nfT, b.c.nfR);
      AppMethodBeat.o(360774);
      return;
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(360820);
    Object localObject = ((n)this.CwG.getBuContext().business(n.class)).Ehd;
    Context localContext = this.mJe.getContext();
    if (localContext == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
      AppMethodBeat.o(360820);
      throw ((Throwable)localObject);
    }
    ((x)localObject).a((q)localContext, new d..ExternalSyntheticLambda0(this));
    this.CNm = ((n)this.CwG.getBuContext().business(n.class)).ezi();
    a(this.CNm);
    this.mJe.setVisibility(0);
    AppMethodBeat.o(360820);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(360833);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(360833);
      return true;
    }
    AppMethodBeat.o(360833);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(360827);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveVisitorOlympicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BYH;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveVisitorOlympicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(360827);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i)
      {
        paramView = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
        com.tencent.mm.plugin.finder.live.olympic.report.a.b(this.CNm, true);
        paramView = (c)this.CwG.getPlugin(c.class);
        if (paramView != null) {
          c.a(paramView, this.CNm);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/FinderLiveVisitorOlympicEntranceWidget$burnTorchState$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewTreeObserver.OnPreDrawListener
  {
    c(d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(360755);
      d.a(this.CTg).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      com.tencent.mm.live.b.b localb = this.CTg.nfT;
      b.c localc = b.c.nfQ;
      Bundle localBundle = new Bundle();
      Object localObject = this.CTg;
      int[] arrayOfInt = new int[2];
      d.a((d)localObject).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      localBundle.putInt("bubbleX", d.a((d)localObject).getWidth() / 2 + i);
      localBundle.putInt("bubbleY", arrayOfInt[1]);
      localObject = ah.aiuX;
      localb.statusChange(localc, localBundle);
      AppMethodBeat.o(360755);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.d
 * JD-Core Version:    0.7.0.1
 */