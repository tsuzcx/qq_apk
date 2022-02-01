package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q.ck;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.bl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "arrow", "Landroid/view/View;", "kotlin.jvm.PlatformType", "closeBtn", "contentGroup", "Landroid/widget/RelativeLayout;", "contentTv", "Landroid/widget/TextView;", "scene", "", "adjustBubbleLocation", "", "canClearScreen", "", "hideBubbleTip", "showBubbleTip", "text", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cv
  extends b
{
  public static final cv.a DmJ;
  private static final int DmM = 0;
  private static final String TAG;
  private final RelativeLayout DmK;
  private final View DmL;
  private final com.tencent.mm.live.b.b nfT;
  private final View niB;
  private final TextView noc;
  private int scene;
  
  static
  {
    AppMethodBeat.i(354662);
    DmJ = new cv.a((byte)0);
    TAG = "FinderLiveVisitorCommonBubblePlugin";
    AppMethodBeat.o(354662);
  }
  
  public cv(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354608);
    this.nfT = paramb;
    this.DmK = ((RelativeLayout)paramViewGroup.findViewById(p.e.BCs));
    this.DmL = paramViewGroup.findViewById(p.e.BCt);
    this.noc = ((TextView)paramViewGroup.findViewById(p.e.BCu));
    this.niB = paramViewGroup.findViewById(p.e.BCr);
    this.scene = -1;
    this.niB.setOnClickListener(new cv..ExternalSyntheticLambda0(this));
    this.DmK.setOnClickListener(new cv..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(354608);
  }
  
  private static final void a(cv paramcv)
  {
    AppMethodBeat.i(354647);
    s.u(paramcv, "this$0");
    int i1 = bd.fromDPToPix(paramcv.mJe.getContext(), 24);
    int i2 = bd.fromDPToPix(paramcv.mJe.getContext(), 16);
    Object localObject1 = (ci)paramcv.getPlugin(ci.class);
    Object localObject2;
    label66:
    int j;
    label73:
    int k;
    label80:
    int m;
    label88:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label208;
      }
      localObject2 = null;
      if (localObject1 != null) {
        break label221;
      }
      j = 0;
      if (localObject1 != null) {
        break label230;
      }
      k = 0;
      if (localObject1 != null) {
        break label239;
      }
      m = 0;
      if (localObject2 != null) {
        break label249;
      }
      i = 0;
      label95:
      if (localObject1 != null) {
        break label276;
      }
    }
    label276:
    for (int n = 0;; n = ((ViewGroup)localObject1).getPaddingStart())
    {
      i = n + i + (j - k - m) / 2;
      j = paramcv.DmK.getWidth() + i2;
      k = bf.bf(paramcv.mJe.getContext()).x;
      if (j - i >= i1) {
        break label286;
      }
      paramcv.mJe.setTranslationX(kotlin.k.k.bu(Math.abs(j - i) + i1 + paramcv.DmL.getWidth() / 2, k - j - i2));
      AppMethodBeat.o(354647);
      return;
      localObject1 = ((ci)localObject1).DlC.mJe;
      break;
      label208:
      localObject2 = d.cZ((View)localObject1);
      break label66;
      label221:
      j = ((ViewGroup)localObject1).getWidth();
      break label73;
      label230:
      k = ((ViewGroup)localObject1).getPaddingStart();
      break label80;
      label239:
      m = ((ViewGroup)localObject1).getPaddingEnd();
      break label88;
      label249:
      localObject2 = kotlin.a.k.A((int[])localObject2, 0);
      if (localObject2 == null)
      {
        i = 0;
        break label95;
      }
      i = ((Integer)localObject2).intValue();
      break label95;
    }
    label286:
    paramcv.mJe.setTranslationX(0.0F);
    AppMethodBeat.o(354647);
  }
  
  private static final void a(cv paramcv, View paramView)
  {
    AppMethodBeat.i(354619);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcv, "this$0");
    paramcv.esW();
    com.tencent.mm.plugin.finder.live.report.k.Doi.axw(String.valueOf(q.ck.DFM.action));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354619);
  }
  
  private static final void b(cv paramcv, View paramView)
  {
    AppMethodBeat.i(354629);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcv, "this$0");
    paramcv = (bv)paramcv.getPlugin(bv.class);
    if (paramcv != null) {
      paramcv.erI();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorVRBubblePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354629);
  }
  
  public final void bv(int paramInt, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(354720);
    if (((e)business(e.class)).DUe)
    {
      AppMethodBeat.o(354720);
      return;
    }
    Object localObject = (br)getPlugin(br.class);
    if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(TAG, "FinderLivePromoteBubblePlugin is showing, return ");
      AppMethodBeat.o(354720);
      return;
    }
    boolean bool1 = bool2;
    if (paramInt == DmM)
    {
      localObject = h.baE().ban().get(at.a.adbB, Boolean.FALSE);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(354720);
        throw paramString;
      }
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue()) {
        bool1 = false;
      }
    }
    if (bool1)
    {
      if (paramInt == DmM)
      {
        h.baE().ban().set(at.a.adbB, Boolean.TRUE);
        if (this.mJe.getVisibility() != 0) {
          com.tencent.mm.plugin.finder.live.report.k.Doi.axw(String.valueOf(q.ck.DFL.action));
        }
      }
      tO(0);
      localObject = this.noc;
      if (paramString == null)
      {
        paramString = (CharSequence)"";
        ((TextView)localObject).setText(paramString);
        this.scene = paramInt;
        esV();
      }
    }
    for (;;)
    {
      Log.i(TAG, "showBubbleTip scene:" + paramInt + " showTip:" + bool1);
      AppMethodBeat.o(354720);
      return;
      paramString = (CharSequence)paramString;
      break;
      tO(8);
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void esV()
  {
    AppMethodBeat.i(354693);
    if (this.mJe.getVisibility() == 0) {
      this.mJe.post(new cv..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(354693);
  }
  
  public final void esW()
  {
    AppMethodBeat.i(354706);
    tO(8);
    this.scene = -1;
    AppMethodBeat.o(354706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cv
 * JD-Core Version:    0.7.0.1
 */