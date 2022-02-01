package com.tencent.mm.plugin.appbrand.ab;

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
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.sdk.platformtools.ac;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements u
{
  private AppBrandRuntime jgY;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b maM;
  private ImageView mqQ;
  private View mqV;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.jgY = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493064, this);
    this.mqV = findViewById(2131305152);
    this.mqQ = ((ImageView)findViewById(2131305792));
    paramContext = (LinearLayout)findViewById(2131296767);
    this.maM = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.maM.setFullscreenMode(true);
    paramContext.addView(this.maM.getActionView());
    this.maM.setNavResetStyleListener(new b.c()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(49334);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(b.this.getContext().getResources(), 2131689682));
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
      
      public final int bqW()
      {
        return mts;
      }
    });
    this.maM.setFullscreenMode(true);
    this.maM.setForegroundStyle(false);
    this.maM.hA(false);
    this.maM.hM(true);
    this.maM.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        ac.i("MicroMsg.AppBrandThumbLoadingSplash", "splash click close button");
        g.bxO();
        if (b.a(b.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(b.a(b.this).mAppId, g.d.jdc);
          b.a(b.this).close();
        }
        AppMethodBeat.o(49335);
      }
    });
    g.a(this.jgY, this.mqQ);
    AppMethodBeat.o(49339);
  }
  
  public final void boo()
  {
    AppMethodBeat.i(49340);
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
                  ((ViewGroup)b.3.1.this.mbn).removeView(b.this);
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
    AppMethodBeat.o(49340);
  }
  
  public final void dN(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void tT(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.b
 * JD-Core Version:    0.7.0.1
 */