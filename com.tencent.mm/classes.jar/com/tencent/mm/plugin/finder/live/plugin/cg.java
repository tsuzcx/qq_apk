package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bn;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "videoOrientationBtn", "Landroid/widget/ImageView;", "videoOrientationBg", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/widget/ImageView;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getVideoOrientationBg", "()Landroid/view/ViewGroup;", "getVideoOrientationBtn", "()Landroid/widget/ImageView;", "canClearScreen", "", "checkLayoutParam", "", "preview", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "requestLayout", "requestLayoutWithHeight", "topMargin", "", "rightMargin", "setLayoutOrientation", "isFitRenderMode", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg
  extends b
{
  public static final cg.a Dlc;
  private static final String Dlf;
  private static final String Dlg;
  private final ImageView Dld;
  private final ViewGroup Dle;
  private final String TAG;
  private final com.tencent.mm.live.b.b ngl;
  
  static
  {
    AppMethodBeat.i(354335);
    Dlc = new cg.a((byte)0);
    Dlf = "PORTRAIT_ACTION_CHANGE_VIDEO";
    Dlg = "LANDSCAPE_ACTION_CHANGE_VIDEO";
    AppMethodBeat.o(354335);
  }
  
  public cg(ViewGroup paramViewGroup1, ImageView paramImageView, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup1, paramb);
    AppMethodBeat.i(354287);
    this.Dld = paramImageView;
    this.Dle = paramViewGroup2;
    this.ngl = paramb;
    this.TAG = "Finder.LiveVideoOrientationPlugin";
    paramViewGroup1.setOnClickListener(new cg..ExternalSyntheticLambda0(paramViewGroup1, this));
    paramViewGroup1.post(new cg..ExternalSyntheticLambda1(paramViewGroup1));
    if ((paramViewGroup1.getLayoutParams() != null) && ((paramViewGroup1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      paramViewGroup1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
      AppMethodBeat.o(354287);
      return;
      paramImageView = paramViewGroup1.getLayoutParams();
      if (paramImageView == null)
      {
        paramViewGroup1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354287);
        throw paramViewGroup1;
      }
      ((ViewGroup.MarginLayoutParams)paramImageView).setMarginEnd(bf.bk(paramViewGroup1.getContext()));
      continue;
      paramImageView = paramViewGroup1.getLayoutParams();
      if (paramImageView == null)
      {
        paramViewGroup1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354287);
        throw paramViewGroup1;
      }
      ((ViewGroup.MarginLayoutParams)paramImageView).setMarginEnd(bd.fromDPToPix(paramViewGroup1.getContext(), 16));
    }
  }
  
  private static final void D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(354318);
    s.u(paramViewGroup, "$root");
    Rect localRect = new Rect();
    paramViewGroup.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramViewGroup.getParent();
    if (localViewParent == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(354318);
      throw paramViewGroup;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, (View)paramViewGroup));
    AppMethodBeat.o(354318);
  }
  
  private static final void a(ViewGroup paramViewGroup, cg paramcg, View paramView)
  {
    AppMethodBeat.i(354312);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramViewGroup);
    localb.cH(paramcg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewGroup, "$root");
    s.u(paramcg, "this$0");
    if (paramViewGroup.getAlpha() <= 0.0F)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354312);
      return;
    }
    if (paramViewGroup.getContext().getResources().getConfiguration().orientation == 1)
    {
      b.b((b)paramcg, Dlg);
      j.Dob.a(q.s.Dux, ak.f(new r[] { new r("screen_type", "1") }));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354312);
      return;
      b.a((b)paramcg, Dlf);
      j.Dob.a(q.s.Dux, ak.f(new r[] { new r("screen_type", "2") }));
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(354414);
    s.u(paramLinkedHashMap, "micUserMap");
    int i = this.mJe.getContext().getResources().getConfiguration().orientation;
    Log.i(this.TAG, "onMicUserChanged: micUserMap.size:" + paramLinkedHashMap.size() + ", curOrientation:" + i);
    if (paramLinkedHashMap.size() > 1)
    {
      tO(8);
      if (i == 2)
      {
        b.a((b)this, Dlf);
        AppMethodBeat.o(354414);
      }
    }
    else
    {
      rK(((e)business(e.class)).eyC());
    }
    AppMethodBeat.o(354414);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(354363);
    bj localbj = bj.GlQ;
    if ((bj.y(getBuContext())) && (!isLandscape()))
    {
      AppMethodBeat.o(354363);
      return false;
    }
    AppMethodBeat.o(354363);
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void fY(View paramView)
  {
    AppMethodBeat.i(354395);
    s.u(paramView, "preview");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (!isLandscape())
    {
      Object localObject = (ar)getPlugin(ar.class);
      if ((localObject != null) && (((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() == 0))
      {
        i = 1;
        if ((i == 0) || (localObject == null)) {
          break label124;
        }
        localObject = ((com.tencent.mm.live.b.a)localObject).mJe;
        if (localObject == null) {
          break label124;
        }
      }
      label124:
      for (int i = ((ViewGroup)localObject).getHeight();; i = 0)
      {
        localObject = this.mJe.getLayoutParams();
        if (localObject != null) {
          break label129;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(354395);
        throw paramView;
        i = 0;
        break;
      }
      label129:
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i + (arrayOfInt[1] + paramView.getHeight()));
      this.mJe.setTag(Integer.valueOf(arrayOfInt[1] + paramView.getHeight()));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 0);
      this.mJe.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Dle.setBackgroundResource(p.d.orientation_icon_bg);
    }
    for (;;)
    {
      if (((e)business(e.class)).eyC()) {
        tO(0);
      }
      AppMethodBeat.o(354395);
      return;
      this.Dle.setBackground(null);
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(354435);
    if (aw.jkS()) {
      tO(8);
    }
    AppMethodBeat.o(354435);
  }
  
  public final void rK(boolean paramBoolean)
  {
    AppMethodBeat.i(354384);
    int i = this.mJe.getContext().getResources().getConfiguration().orientation;
    Log.i(this.TAG, "setLayoutOrientation isFitRenderMode:" + paramBoolean + ",orientaion:" + i);
    if (!paramBoolean)
    {
      tO(8);
      AppMethodBeat.o(354384);
      return;
    }
    switch (i)
    {
    default: 
      tO(8);
      AppMethodBeat.o(354384);
      return;
    case 2: 
      this.Dld.setImageDrawable(bb.m(MMApplicationContext.getContext(), p.g.icons_outlined_htov_new, -1));
      tO(0);
      k.Doi.a(Integer.valueOf(0), 2, q.bn.DBJ);
      j.Dob.a(q.t.DvH, ak.f(new r[] { new r("screen_type", "2") }));
      AppMethodBeat.o(354384);
      return;
    }
    this.Dld.setImageDrawable(bb.m(MMApplicationContext.getContext(), p.g.icons_outlined_vtoh_new, -1));
    tO(0);
    k.Doi.a(Integer.valueOf(0), 1, q.bn.DBJ);
    j.Dob.a(q.t.DvH, ak.f(new r[] { new r("screen_type", "1") }));
    AppMethodBeat.o(354384);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354406);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354406);
      return;
      tO(8);
      AppMethodBeat.o(354406);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      AppMethodBeat.o(354406);
      return;
      Log.i(this.TAG, s.X("show orientation, ", paramc));
      paramc = bj.GlQ;
      if (bj.z(getBuContext()))
      {
        this.mJe.setAlpha(1.0F);
        AppMethodBeat.o(354406);
        return;
      }
      this.mJe.setAlpha(0.0F);
      AppMethodBeat.o(354406);
      return;
      Log.i(this.TAG, s.X("hide orientation, ", paramc));
      this.mJe.setAlpha(0.0F);
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354425);
    boolean bool = ((e)business(e.class)).eyK();
    int i;
    if (paramInt == 0) {
      if ((aw.jkS()) || (bool)) {
        i = 8;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "setVisible: isMicLinking:" + bool + ", visible:" + paramInt + ", newVisible:" + i);
      super.tO(i);
      AppMethodBeat.o(354425);
      return;
      i = paramInt;
      continue;
      i = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cg
 * JD-Core Version:    0.7.0.1
 */