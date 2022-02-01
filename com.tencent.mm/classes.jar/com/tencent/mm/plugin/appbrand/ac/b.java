package com.tencent.mm.plugin.appbrand.ac;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements v
{
  private AppBrandRuntime iGV;
  private ImageView lOQ;
  private View lOV;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b lyP;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.iGV = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493064, this);
    this.lOV = findViewById(2131305152);
    this.lOQ = ((ImageView)findViewById(2131305792));
    paramContext = (LinearLayout)findViewById(2131296767);
    this.lyP = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.lyP.setFullscreenMode(true);
    paramContext.addView(this.lyP.getActionView());
    this.lyP.setNavResetStyleListener(new b.c()
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
      
      public final int bkf()
      {
        return lRp;
      }
    });
    this.lyP.setFullscreenMode(true);
    this.lyP.setForegroundStyle(false);
    this.lyP.hd(false);
    this.lyP.ho(true);
    this.lyP.setBackButtonClickListener(new b.2(this));
    g.a(this.iGV, this.lOQ);
    AppMethodBeat.o(49339);
  }
  
  public final void bhu()
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
                  ((ViewGroup)b.3.1.this.lzq).removeView(b.this);
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
  
  public final void dB(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void tc(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.b
 * JD-Core Version:    0.7.0.1
 */