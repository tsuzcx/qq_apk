package com.tencent.mm.plugin.appbrand.af;

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
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements af
{
  private AppBrandRuntime kEc;
  private ImageView ojE;
  private View ojI;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b ojJ;
  private boolean ojK;
  private boolean ojL;
  private kotlin.g.a.a<x> ojM;
  private boolean ojN;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.ojK = false;
    this.ojL = false;
    this.ojM = null;
    this.ojN = false;
    this.kEc = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493104, this);
    this.ojI = findViewById(2131308335);
    this.ojE = ((ImageView)findViewById(2131309067));
    paramContext = (LinearLayout)findViewById(2131296849);
    this.ojJ = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.ojJ.setFullscreenMode(true);
    paramContext.addView(this.ojJ.getActionView());
    this.ojJ.setNavResetStyleListener(new b.a()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(49334);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] set close button");
          paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(b.this.getContext().getResources(), 2131689687));
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
      
      public final int bQz()
      {
        return omi;
      }
    });
    this.ojJ.setFullscreenMode(true);
    this.ojJ.setForegroundStyle(false);
    this.ojJ.gz(false);
    this.ojJ.gx(true);
    this.ojJ.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] splash click close button");
        g.bZS();
        if (b.a(b.this) != null)
        {
          h.a(b.a(b.this).mAppId, h.d.kzP);
          b.a(b.this).close();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49335);
      }
    });
    g.a(this.kEc, this.ojE, null);
    AppMethodBeat.o(49339);
  }
  
  private void bZQ()
  {
    AppMethodBeat.i(227746);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] markCanHide, alreadyHide: %b, hideFromRuntime: %b", new Object[] { Boolean.valueOf(this.ojN), Boolean.valueOf(this.ojL) });
    if (this.ojN)
    {
      AppMethodBeat.o(227746);
      return;
    }
    if (this.ojL)
    {
      z(this.ojM);
      this.ojN = true;
      AppMethodBeat.o(227746);
      return;
    }
    this.ojK = true;
    AppMethodBeat.o(227746);
  }
  
  public final void B(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227747);
    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] hideLoadingSplashFromRuntime, alreadyHide: %b, canHide: %b", new Object[] { Boolean.valueOf(this.ojN), Boolean.valueOf(this.ojK) });
    if (this.ojN)
    {
      AppMethodBeat.o(227747);
      return;
    }
    if (this.ojK)
    {
      z(parama);
      this.ojN = true;
      AppMethodBeat.o(227747);
      return;
    }
    this.ojL = true;
    this.ojM = parama;
    AppMethodBeat.o(227747);
  }
  
  public final void bWI()
  {
    AppMethodBeat.i(227745);
    bZQ();
    AppMethodBeat.o(227745);
  }
  
  public final void eo(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void k(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(227744);
    bZQ();
    AppMethodBeat.o(227744);
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void yu(int paramInt) {}
  
  public final void z(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227743);
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
                  ((ViewGroup)b.3.1.this.nTy).removeView(b.this);
                  if (b.3.this.nTx != null) {
                    b.3.this.nTx.invoke();
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
        localValueAnimator.setInterpolator(new android.support.v4.view.b.a());
        localValueAnimator.start();
        AppMethodBeat.o(49338);
      }
    });
    AppMethodBeat.o(227743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.b
 * JD-Core Version:    0.7.0.1
 */