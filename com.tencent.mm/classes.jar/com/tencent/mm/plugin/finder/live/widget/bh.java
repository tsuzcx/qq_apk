package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.u;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "ANIMATION_FILE", "", "MAX_LIKE_ONE_TIME", "", "TAG", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "filterVisitorZeroLikeValue", "", "getFilterVisitorZeroLikeValue", "()Z", "setFilterVisitorZeroLikeValue", "(Z)V", "isInApplaudMode", "setInApplaudMode", "likeClickArea", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "likeContainer", "Landroid/widget/LinearLayout;", "likeCount", "likeIcon", "Landroid/widget/ImageView;", "likeIconPag", "Lorg/libpag/PAGView;", "likeTv", "Landroid/widget/TextView;", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "vibrator", "changeApplaudMode", "", "enterOrExit", "checkVisible", "isVisible", "postHightLightLike", "postLike", "refreshLikeCount", "", "scaleAnimate", "target", "Landroid/view/View;", "targetValue", "", "setVisible", "visible", "shakeIt", "updateCheerIcon", "iconUrl", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "succ", "uploadLike", "vibrate", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh
{
  final PAGView CUP;
  final String CUX;
  boolean CVa;
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final int Ewd;
  private final LinearLayout Ewe;
  private final RelativeLayout Ewf;
  private boolean Ewg;
  final String TAG;
  int likeCount;
  public final ViewGroup mJe;
  final com.tencent.mm.live.b.b nfT;
  private final Object nhS;
  private final MTimerHandler nhU;
  final TextView nhq;
  final ImageView yEV;
  
  public bh(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361332);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveVisitorLikeWidget";
    this.Ewd = 9;
    this.Ewe = ((LinearLayout)this.mJe.findViewById(p.e.BMB));
    this.Ewf = ((RelativeLayout)this.mJe.findViewById(p.e.BMA));
    this.yEV = ((ImageView)this.mJe.findViewById(p.e.BMC));
    this.CUP = ((PAGView)this.mJe.findViewById(p.e.BMD));
    paramViewGroup = this.mJe.getParent();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(361332);
      throw paramViewGroup;
    }
    this.nhq = ((TextView)((ViewGroup)paramViewGroup).findViewById(p.e.BME));
    this.CUX = "finder_live_clap_anim.pag";
    this.nhS = this.mJe.getContext().getSystemService("vibrator");
    paramViewGroup = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSB().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ewg = bool;
      this.nhU = new MTimerHandler("FinderLiveLikePlugin::Timer", new bh..ExternalSyntheticLambda2(this), true);
      this.Ewe.setOnTouchListener(new bh..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(361332);
      return;
    }
  }
  
  private static final void a(bh parambh, long paramLong)
  {
    AppMethodBeat.i(361366);
    kotlin.g.b.s.u(parambh, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (parambh.Ewg) && (paramLong == 0L))
    {
      AppMethodBeat.o(361366);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = parambh.mJe.getContext();
    kotlin.g.b.s.s(localObject, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, 12.0F);
    parambh.nhq.setTextSize(1, f);
    parambh = parambh.nhq;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    parambh.setText((CharSequence)com.tencent.mm.plugin.finder.live.utils.a.jp(paramLong));
    AppMethodBeat.o(361366);
  }
  
  private static final void a(final bh parambh, final kotlin.g.a.b paramb, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(361399);
    kotlin.g.b.s.u(parambh, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramBitmap, parambh, paramb));
    AppMethodBeat.o(361399);
  }
  
  private static final boolean a(bh parambh)
  {
    AppMethodBeat.i(361372);
    kotlin.g.b.s.u(parambh, "this$0");
    if (parambh.likeCount < parambh.Ewd - 1)
    {
      parambh.cZL();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(parambh));
      AppMethodBeat.o(361372);
      return true;
    }
    if (parambh.likeCount == parambh.Ewd - 1)
    {
      parambh.cZL();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(parambh));
    }
    AppMethodBeat.o(361372);
    return false;
  }
  
  private static final boolean a(bh parambh, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(361392);
    kotlin.g.b.s.u(parambh, "this$0");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        AppMethodBeat.o(361392);
        return true;
        parambh.nhq.setVisibility(4);
        t((View)parambh.mJe, 1.5F);
        parambh.nhU.startTimer(0L, 200L);
        parambh.yEV.setAlpha(0.3F);
      }
    }
    parambh.nhU.stopTimer();
    parambh.mJe.postDelayed(new bh..ExternalSyntheticLambda3(parambh), 200L);
    com.tencent.mm.ae.d.a(400L, (kotlin.g.a.a)new a(parambh));
    paramView = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
    if (paramView != null) {
      paramView.OM(parambh.likeCount);
    }
    parambh.pe(((e)parambh.CwG.business(e.class)).EcF);
    parambh.likeCount = 0;
    paramView = ak.CHI;
    paramMotionEvent = parambh.nfT;
    paramView = (f)parambh.CwG.business(f.class);
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.liveInfo)
    {
      ak.a(paramMotionEvent, paramView.liveId, ak.b.CHM);
      parambh.yEV.setAlpha(1.0F);
      parambh.rf(parambh.CVa);
      break;
    }
  }
  
  private static final void b(bh parambh)
  {
    AppMethodBeat.i(361377);
    kotlin.g.b.s.u(parambh, "this$0");
    t((View)parambh.mJe, 1.0F);
    AppMethodBeat.o(361377);
  }
  
  private final void cZL()
  {
    AppMethodBeat.i(361345);
    if ((this.nhS instanceof Vibrator))
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        ((Vibrator)this.nhS).vibrate(VibrationEffect.createOneShot(10L, 255));
        AppMethodBeat.o(361345);
        return;
      }
      ((Vibrator)this.nhS).vibrate(10L);
    }
    AppMethodBeat.o(361345);
  }
  
  private static void t(View paramView, float paramFloat)
  {
    AppMethodBeat.i(361354);
    paramView.animate().setDuration(200L).scaleX(paramFloat).scaleY(paramFloat).start();
    AppMethodBeat.o(361354);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361446);
    if ((!((e)this.CwG.business(e.class)).DUe) && (((e)this.CwG.business(e.class)).Ecx))
    {
      tO(0);
      AppMethodBeat.o(361446);
      return;
    }
    tO(8);
    AppMethodBeat.o(361446);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(361453);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(361453);
      return true;
    }
    AppMethodBeat.o(361453);
    return false;
  }
  
  public final void pe(long paramLong)
  {
    AppMethodBeat.i(361440);
    this.mJe.post(new bh..ExternalSyntheticLambda4(this, paramLong));
    AppMethodBeat.o(361440);
  }
  
  public final void r(String paramString, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(361459);
    Log.i(this.TAG, kotlin.g.b.s.X("updateCheerIcon:", paramString));
    if (this.CVa)
    {
      Log.i(this.TAG, "applaud mode ,return");
      AppMethodBeat.o(361459);
      return;
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = p.ExI;
      p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(paramString, v.FKZ)).a(new bh..ExternalSyntheticLambda1(this, paramb)).Td();
      AppMethodBeat.o(361459);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramb));
    AppMethodBeat.o(361459);
  }
  
  public final void rf(final boolean paramBoolean)
  {
    AppMethodBeat.i(361465);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramBoolean));
    AppMethodBeat.o(361465);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361450);
    this.mJe.setVisibility(paramInt);
    this.Ewe.setVisibility(this.mJe.getVisibility());
    AppMethodBeat.o(361450);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(bh parambh, boolean paramBoolean)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(bh parambh)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(bh parambh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(Bitmap paramBitmap, bh parambh, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(bh parambh, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bh
 * JD-Core Version:    0.7.0.1
 */