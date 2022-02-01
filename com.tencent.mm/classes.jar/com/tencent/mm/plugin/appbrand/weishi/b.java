package com.tencent.mm.plugin.appbrand.weishi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ah;

public final class b
  extends FrameLayout
  implements al
{
  private AppBrandRuntime qwG;
  private ImageView uvB;
  private View uvF;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b uvG;
  private boolean uvH;
  private boolean uvI;
  private kotlin.g.a.a<ah> uvJ;
  private boolean uvK;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.uvH = false;
    this.uvI = false;
    this.uvJ = null;
    this.uvK = false;
    this.qwG = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(ba.g.app_brand_splash_thumb, this);
    this.uvF = findViewById(ba.f.splash);
    this.uvB = ((ImageView)findViewById(ba.f.thumb));
    paramContext = (LinearLayout)findViewById(ba.f.app_brand_loading_fake_ab_container);
    this.uvG = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.uvG.setFullscreenMode(true);
    paramContext.addView(this.uvG.getActionView());
    this.uvG.setNavResetStyleListener(new b.a()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(49334);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] set close button");
          paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.i(b.this.getContext().getResources(), ba.h.app_brand_weishi_video_btn_close));
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
      
      public final int cDN()
      {
        return uyR;
      }
    });
    this.uvG.setFullscreenMode(true);
    this.uvG.setForegroundStyle(false);
    this.uvG.hZ(false);
    this.uvG.ia(true);
    this.uvG.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] splash click close button");
        h.cOB();
        if (b.a(b.this) != null)
        {
          k.a(b.a(b.this).mAppId, k.d.qrG);
          b.a(b.this).close();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49335);
      }
    });
    h.a(this.qwG, this.uvB, null);
    AppMethodBeat.o(49339);
  }
  
  private void cOw()
  {
    AppMethodBeat.i(317637);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] markCanHide, alreadyHide: %b, hideFromRuntime: %b", new Object[] { Boolean.valueOf(this.uvK), Boolean.valueOf(this.uvI) });
    if (this.uvK)
    {
      AppMethodBeat.o(317637);
      return;
    }
    if (this.uvI)
    {
      as(this.uvJ);
      this.uvK = true;
      AppMethodBeat.o(317637);
      return;
    }
    this.uvH = true;
    AppMethodBeat.o(317637);
  }
  
  public final void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(317646);
    cOw();
    AppMethodBeat.o(317646);
  }
  
  public final void Cj(int paramInt) {}
  
  public final void as(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(317643);
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
                  ((ViewGroup)b.3.1.this.uaG).removeView(b.this);
                  if (b.3.this.uaF != null) {
                    b.3.this.uaF.invoke();
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
        localValueAnimator.setInterpolator(new androidx.g.a.a.a());
        localValueAnimator.start();
        AppMethodBeat.o(49338);
      }
    });
    AppMethodBeat.o(317643);
  }
  
  public final void au(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(317656);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] hideLoadingSplashFromRuntime, alreadyHide: %b, canHide: %b", new Object[] { Boolean.valueOf(this.uvK), Boolean.valueOf(this.uvH) });
    if (this.uvK)
    {
      AppMethodBeat.o(317656);
      return;
    }
    if (this.uvH)
    {
      as(parama);
      this.uvK = true;
      AppMethodBeat.o(317656);
      return;
    }
    this.uvI = true;
    this.uvJ = parama;
    AppMethodBeat.o(317656);
  }
  
  public final void cKm()
  {
    AppMethodBeat.i(317652);
    cOw();
    AppMethodBeat.o(317652);
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b
 * JD-Core Version:    0.7.0.1
 */