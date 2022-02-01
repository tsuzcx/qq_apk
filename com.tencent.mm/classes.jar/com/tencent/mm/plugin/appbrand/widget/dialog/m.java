package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.UnSupportMethodException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/HalfScreenDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "halfScreenView", "halfScreenViewContainer", "Landroid/view/View;", "isCanceledOnTouchOutside", "", "maxHeight", "", "peekHeight", "adjustBounds", "", "cancel", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCanceledOnTouchOutside", "setContentView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "setMaxHeight", "setPeekHeight", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends e
{
  public static final m.a uDe;
  public int dqv;
  public int maxHeight;
  public final View uDf;
  private final FrameLayout uDg;
  public final BottomSheetBehavior<FrameLayout> uDh;
  private boolean uDi;
  
  static
  {
    AppMethodBeat.i(324706);
    uDe = new m.a((byte)0);
    AppMethodBeat.o(324706);
  }
  
  public m(Context paramContext)
  {
    super(paramContext, ba.j.AppBrandBottomSheetDialog);
    AppMethodBeat.i(324694);
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.dqv = ((int)(0.5F * i));
    this.maxHeight = ((int)(1.0F * i));
    Log.i("MicroMsg.AppBrand.HalfScreenDialog", "<init>, screenHeight: " + i + ", defaultPeekHeight: " + this.dqv + ", defaultMaxHeight: " + this.maxHeight);
    bU();
    paramContext = getLayoutInflater().inflate(ba.g.app_brand_half_screen_layout, null);
    paramContext.setOnClickListener(new m..ExternalSyntheticLambda0(this));
    View localView = paramContext.findViewById(ba.f.content_layout_container);
    s.s(localView, "contentView.findViewById…content_layout_container)");
    this.uDf = localView;
    localView = this.uDf;
    ViewGroup.LayoutParams localLayoutParams = this.uDf.getLayoutParams();
    localLayoutParams.height = this.maxHeight;
    ah localah = ah.aiuX;
    localView.setLayoutParams(localLayoutParams);
    super.setContentView(paramContext);
    paramContext = this.uDf.findViewById(ba.f.content_layout);
    s.s(paramContext, "halfScreenViewContainer.…ById(R.id.content_layout)");
    this.uDg = ((FrameLayout)paramContext);
    paramContext = BottomSheetBehavior.cC((View)this.uDg);
    s.s(paramContext, "from(halfScreenView)");
    this.uDh = paramContext;
    this.uDh.setPeekHeight(this.dqv);
    this.uDh.setState(5);
    this.uDh.dqJ = ((BottomSheetBehavior.a)new BottomSheetBehavior.a()
    {
      public final void cD(View paramAnonymousView)
      {
        AppMethodBeat.i(324720);
        s.u(paramAnonymousView, "bottomSheet");
        AppMethodBeat.o(324720);
      }
      
      public final void e(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(324714);
        s.u(paramAnonymousView, "bottomSheet");
        Log.i("MicroMsg.AppBrand.HalfScreenDialog", s.X("onStateChanged, newState: ", Integer.valueOf(paramAnonymousInt)));
        if (5 == paramAnonymousInt) {
          m.a(this.uDj);
        }
        AppMethodBeat.o(324714);
      }
    });
    AppMethodBeat.o(324694);
  }
  
  private static final void a(m paramm, View paramView)
  {
    AppMethodBeat.i(324699);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/HalfScreenDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    boolean bool = paramm.uDi;
    Log.i("MicroMsg.AppBrand.HalfScreenDialog", s.X("onClick, isCanceledOnTouchOutside: ", Boolean.valueOf(bool)));
    if (bool) {
      paramm.dismiss();
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/HalfScreenDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324699);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(324728);
    if (5 != this.uDh.state) {
      this.uDh.setState(5);
    }
    AppMethodBeat.o(324728);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(324717);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(ba.j.BottomToTopSlowAnimation);
    }
    if (2 == getContext().getResources().getConfiguration().orientation) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setGravity(81);
      }
      paramBundle = getContext().getResources().getDisplayMetrics();
      i = k.qv(paramBundle.heightPixels, paramBundle.widthPixels);
      Log.i("MicroMsg.AppBrand.HalfScreenDialog", s.X("adjustBounds, width: ", Integer.valueOf(i)));
      paramBundle = getWindow();
      if (paramBundle == null) {
        break label176;
      }
      paramBundle.setLayout(i, -1);
      AppMethodBeat.o(324717);
      return;
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setGravity(80);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -1);
    }
    label176:
    AppMethodBeat.o(324717);
  }
  
  protected final void onStart()
  {
    AppMethodBeat.i(324724);
    super.onStart();
    if (5 == this.uDh.state) {
      this.uDh.setState(4);
    }
    AppMethodBeat.o(324724);
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(324749);
    super.setCanceledOnTouchOutside(paramBoolean);
    this.uDi = paramBoolean;
    AppMethodBeat.o(324749);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(324732);
    getLayoutInflater().inflate(paramInt, (ViewGroup)this.uDg);
    AppMethodBeat.o(324732);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(324737);
    s.u(paramView, "view");
    paramView = new UnSupportMethodException("Use setContentView(Int) instead.");
    AppMethodBeat.o(324737);
    throw paramView;
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(324744);
    s.u(paramView, "view");
    paramView = new UnSupportMethodException("Use setContentView(Int) instead.");
    AppMethodBeat.o(324744);
    throw paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.m
 * JD-Core Version:    0.7.0.1
 */