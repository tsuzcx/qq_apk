package com.tencent.mm.plugin.appbrand.ag;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements ae
{
  private AppBrandRuntime nxs;
  private ImageView rlS;
  private View rlW;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b rlX;
  private boolean rlY;
  private boolean rlZ;
  private kotlin.g.a.a<x> rma;
  private boolean rmb;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.rlY = false;
    this.rlZ = false;
    this.rma = null;
    this.rmb = false;
    this.nxs = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(au.g.app_brand_splash_thumb, this);
    this.rlW = findViewById(au.f.splash);
    this.rlS = ((ImageView)findViewById(au.f.thumb));
    paramContext = (LinearLayout)findViewById(au.f.app_brand_loading_fake_ab_container);
    this.rlX = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.rlX.setFullscreenMode(true);
    paramContext.addView(this.rlX.getActionView());
    this.rlX.setNavResetStyleListener(new b.a()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(49334);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] set close button");
          paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(b.this.getContext().getResources(), au.h.app_brand_weishi_video_btn_close));
          paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
          paramAnonymousView2.height = -1;
          paramAnonymousView2.width = -2;
          paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
        }
        if (paramAnonymousView1 != null) {
          paramAnonymousView1.setBackground(null);
        }
        AppMethodBeat.o(49334);
      }
      
      public final int cdp()
      {
        return roL;
      }
    });
    this.rlX.setFullscreenMode(true);
    this.rlX.setForegroundStyle(false);
    this.rlX.hk(false);
    this.rlX.hi(true);
    this.rlX.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] splash click close button");
        g.cmN();
        if (b.a(b.this) != null)
        {
          k.a(b.a(b.this).mAppId, k.d.ntb);
          b.a(b.this).close();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49335);
      }
    });
    g.a(this.nxs, this.rlS, null);
    AppMethodBeat.o(49339);
  }
  
  private void cmL()
  {
    AppMethodBeat.i(278272);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] markCanHide, alreadyHide: %b, hideFromRuntime: %b", new Object[] { Boolean.valueOf(this.rmb), Boolean.valueOf(this.rlZ) });
    if (this.rmb)
    {
      AppMethodBeat.o(278272);
      return;
    }
    if (this.rlZ)
    {
      x(this.rma);
      this.rmb = true;
      AppMethodBeat.o(278272);
      return;
    }
    this.rlY = true;
    AppMethodBeat.o(278272);
  }
  
  public final void BU(int paramInt) {}
  
  public final void cjm()
  {
    AppMethodBeat.i(278271);
    cmL();
    AppMethodBeat.o(278271);
  }
  
  public final void eC(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void o(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(278269);
    cmL();
    AppMethodBeat.o(278269);
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void x(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(278268);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49338);
        final ViewParent localViewParent = b.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          AppMethodBeat.o(49338);
          return;
        }
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            AppMethodBeat.i(49337);
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            int j = Color.argb(i, 0, 0, 0);
            b.b(b.this).setBackgroundColor(j);
            if (i == 0) {
              b.this.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(49336);
                  b.this.setVisibility(8);
                  ((ViewGroup)b.3.1.this.qUZ).removeView(b.this);
                  if (b.3.this.qUY != null) {
                    b.3.this.qUY.invoke();
                  }
                  AppMethodBeat.o(49336);
                }
              });
            }
            AppMethodBeat.o(49337);
          }
        });
        localValueAnimator.setStartDelay(Math.round((float)localValueAnimator.getDuration() * 0.8F));
        localValueAnimator.setDuration(Math.round((float)localValueAnimator.getDuration() * 0.2F));
        localValueAnimator.setInterpolator(new androidx.f.a.a.a());
        localValueAnimator.start();
        AppMethodBeat.o(49338);
      }
    });
    AppMethodBeat.o(278268);
  }
  
  public final void z(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(278273);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] hideLoadingSplashFromRuntime, alreadyHide: %b, canHide: %b", new Object[] { Boolean.valueOf(this.rmb), Boolean.valueOf(this.rlY) });
    if (this.rmb)
    {
      AppMethodBeat.o(278273);
      return;
    }
    if (this.rlY)
    {
      x(parama);
      this.rmb = true;
      AppMethodBeat.o(278273);
      return;
    }
    this.rlZ = true;
    this.rma = parama;
    AppMethodBeat.o(278273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b
 * JD-Core Version:    0.7.0.1
 */