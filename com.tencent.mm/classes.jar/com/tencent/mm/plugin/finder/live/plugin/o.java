package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.cgi.x;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ANIMATION_FILE", "", "TAG", "applaudBg", "Landroid/view/View;", "kotlin.jvm.PlatformType", "applaudIcon", "applaudRoot", "applaudTipsClose", "applaudTipsContent", "applaudTipsView", "canApplaudMode", "", "isInApplaudMode", "lastApplaudExitTimeStamp", "", "lastCheerIconUrl", "likeCntTv", "Landroid/widget/TextView;", "likeIcon", "Landroid/widget/ImageView;", "likeIconPag", "Lorg/libpag/PAGView;", "canClearScreen", "changeApplaudMode", "", "enterOrExit", "checkCheerIcon", "cheerIconUrl", "checkVisible", "likeIconChangeToApplaud", "setVisible", "visible", "", "showApplaudTip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateCheerIcon", "updateLikeCnt", "likeCnt", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends b
{
  private final TextView CUO;
  private final PAGView CUP;
  private final View CUQ;
  private final View CUR;
  private final View CUS;
  private final View CUU;
  private final View CUV;
  private final View CUW;
  private final String CUX;
  private String CUY;
  private long CUZ;
  private boolean CVa;
  private boolean CVb;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final ImageView yEV;
  
  public o(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353800);
    this.nfT = paramb;
    this.TAG = "FinderLiveAnchorLikePlugin";
    paramb = paramViewGroup.findViewById(p.e.BFn);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…chor_like_indicator_icon)");
    this.yEV = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BFo);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…anchor_like_indicator_tv)");
    this.CUO = ((TextView)paramb);
    this.CUP = ((PAGView)paramViewGroup.findViewById(p.e.BMD));
    this.CUQ = paramViewGroup.findViewById(p.e.BFd);
    this.CUR = paramViewGroup.findViewById(p.e.BFf);
    this.CUS = paramViewGroup.findViewById(p.e.BFe);
    this.CUU = paramViewGroup.findViewById(p.e.BGz);
    this.CUV = paramViewGroup.findViewById(p.e.BGy);
    this.CUW = paramViewGroup.findViewById(p.e.BGx);
    this.CUX = "finder_live_clap_anim.pag";
    this.CUY = ((e)business(e.class)).EdA.EeQ;
    epa();
    AppMethodBeat.o(353800);
  }
  
  private static final void a(o paramo)
  {
    AppMethodBeat.i(353829);
    kotlin.g.b.s.u(paramo, "this$0");
    Rect localRect = new Rect();
    paramo.CUW.getHitRect(localRect);
    localRect.inset(localRect.width() * -2, -localRect.width());
    ViewParent localViewParent = paramo.CUW.getParent();
    if (localViewParent == null)
    {
      paramo = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(353829);
      throw paramo;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramo.CUW));
    AppMethodBeat.o(353829);
  }
  
  private static final void a(o paramo, View paramView)
  {
    AppMethodBeat.i(353821);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    paramo.CUU.setVisibility(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353821);
  }
  
  private static final void a(final o paramo, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(353813);
    kotlin.g.b.s.u(paramo, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramBitmap, paramo));
    AppMethodBeat.o(353813);
  }
  
  private static final void b(o paramo, View paramView)
  {
    AppMethodBeat.i(353838);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    paramo.CUR.performClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353838);
  }
  
  private static final void c(o paramo, View paramView)
  {
    AppMethodBeat.i(353848);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramo);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    j.Dob.Pi(2);
    paramo.CVb = false;
    paramo.CUR.setVisibility(8);
    paramo.CUU.setVisibility(8);
    paramo.rf(true);
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramView = paramo.mJe.getContext();
    kotlin.g.b.s.s(paramView, "root.context");
    com.tencent.mm.plugin.finder.live.utils.a.gF(paramView);
    paramo.CUR.setOnClickListener(null);
    paramView = x.CvN;
    paramView = new bdm();
    localObject1 = new bdx();
    ((bdx)localObject1).level = 1;
    localObject2 = ah.aiuX;
    paramView.ZNY = com.tencent.mm.bx.b.cX(((bdx)localObject1).toByteArray());
    paramView.msg_type = 20041;
    paramView.Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
    new x(paramView, paramo.getBuContext(), null, null).bFJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353848);
  }
  
  private final void epa()
  {
    AppMethodBeat.i(353810);
    Log.i(this.TAG, kotlin.g.b.s.X("updateCheerIcon:", this.CUY));
    if ((this.CVa) || (this.CVb))
    {
      Log.i(this.TAG, "applaud mode ,return");
      AppMethodBeat.o(353810);
      return;
    }
    Object localObject = (CharSequence)this.CUY;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = p.ExI;
      p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(this.CUY, v.FKZ)).a(new o..ExternalSyntheticLambda3(this)).Td();
      AppMethodBeat.o(353810);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(353810);
  }
  
  public final void awQ(String paramString)
  {
    AppMethodBeat.i(353954);
    Log.i(this.TAG, "checkCheerIcon, new:" + paramString + " old:" + this.CUY);
    if (((e)business(e.class)).EdA.lTH == 0)
    {
      this.CUY = null;
      epa();
      AppMethodBeat.o(353954);
      return;
    }
    if (!Util.isEqual(this.CUY, paramString))
    {
      this.CUY = paramString;
      paramString = (CharSequence)this.CUY;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        epa();
      }
      AppMethodBeat.o(353954);
      return;
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(353997);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      tO(0);
      AppMethodBeat.o(353997);
      return;
    }
    tO(8);
    AppMethodBeat.o(353997);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void oo(final long paramLong)
  {
    AppMethodBeat.i(353949);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramLong));
    AppMethodBeat.o(353949);
  }
  
  public final void rf(final boolean paramBoolean)
  {
    AppMethodBeat.i(353975);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramBoolean));
    AppMethodBeat.o(353975);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(353969);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(353969);
      return;
      if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_FINDER_LIVE_LIKE_ENABLE", true))) {}
      for (int i = 1; i == 0; i = 0)
      {
        ((e)business(e.class)).Ecy = true;
        tO(0);
        AppMethodBeat.o(353969);
        return;
      }
      tO(8);
      AppMethodBeat.o(353969);
      return;
      if ((((e)business(e.class)).Ecx) && (!com.tencent.mm.ae.d.ee(((e)business(e.class)).Ecp, 512)) && (((e)business(e.class)).isLiveStarted()))
      {
        ((e)business(e.class)).Ecy = true;
        tO(0);
        AppMethodBeat.o(353969);
        return;
      }
      tO(8);
      AppMethodBeat.o(353969);
      return;
      if (System.currentTimeMillis() - this.CUZ > 10000L)
      {
        if ((!this.CVa) && (!this.CVb))
        {
          paramc = com.tencent.d.a.a.a.a.a.ahiX;
          if ((((Boolean)com.tencent.d.a.a.a.a.a.jUy().bmg()).booleanValue()) || (!h.baE().ban().getBoolean(at.a.adgl, false)))
          {
            h.baE().ban().set(at.a.adgl, Boolean.TRUE);
            this.CUU.setVisibility(0);
            this.CUW.setOnClickListener(new o..ExternalSyntheticLambda0(this));
            this.CUW.post(new o..ExternalSyntheticLambda4(this));
            this.CUV.setOnClickListener(new o..ExternalSyntheticLambda1(this));
          }
          j.Dob.Pi(1);
          this.CVb = true;
          this.CUQ.setVisibility(0);
          this.yEV.setVisibility(4);
          this.CUR.setVisibility(0);
          paramc = ObjectAnimator.ofFloat(this.CUQ, "scaleX", new float[] { 1.0F, 1.5F, 1.0F });
          kotlin.g.b.s.s(paramc, "ofFloat(applaudBg, \"scaleX\", 1F, 1.5F, 1F)");
          paramBundle = ObjectAnimator.ofFloat(this.CUQ, "scaleY", new float[] { 1.0F, 1.5F, 1.0F });
          kotlin.g.b.s.s(paramBundle, "ofFloat(applaudBg, \"scaleY\", 1F, 1.5F, 1F)");
          paramc.setDuration(300L);
          paramBundle.setDuration(300L);
          paramc.start();
          paramBundle.start();
          this.CUR.setOnClickListener(new o..ExternalSyntheticLambda2(this));
          AppMethodBeat.o(353969);
          return;
        }
        Log.i(this.TAG, "in applaud mode ,return");
        AppMethodBeat.o(353969);
        return;
      }
      paramc = aw.Gjk;
      if (aw.bgV()) {
        aa.makeText(this.mJe.getContext(), (CharSequence)"applaud time interval limit, return", 0).show();
      }
      Log.i(this.TAG, "applaud time interval limit, return");
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354003);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      super.tO(paramInt);
      AppMethodBeat.o(354003);
      return;
    }
    super.tO(8);
    AppMethodBeat.o(354003);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(353990);
    super.unMount();
    this.CUY = null;
    AppMethodBeat.o(353990);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(o paramo, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(Bitmap paramBitmap, o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(o paramo, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.o
 * JD-Core Version:    0.7.0.1
 */