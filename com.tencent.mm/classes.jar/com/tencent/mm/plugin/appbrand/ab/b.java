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
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.sdk.platformtools.ad;
import d.z;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements v
{
  private AppBrandRuntime jzY;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b mAX;
  private View mRA;
  private ImageView mRw;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.jzY = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493064, this);
    this.mRA = findViewById(2131305152);
    this.mRw = ((ImageView)findViewById(2131305792));
    paramContext = (LinearLayout)findViewById(2131296767);
    this.mAX = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.mAX.setFullscreenMode(true);
    paramContext.addView(this.mAX.getActionView());
    this.mAX.setNavResetStyleListener(new b.1(this));
    this.mAX.setFullscreenMode(true);
    this.mAX.setForegroundStyle(false);
    this.mAX.hK(false);
    this.mAX.hW(true);
    this.mAX.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.AppBrandThumbLoadingSplash", "splash click close button");
        g.bBT();
        if (b.a(b.this) != null)
        {
          com.tencent.mm.plugin.appbrand.g.a(b.a(b.this).mAppId, g.d.jwl);
          b.a(b.this).close();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49335);
      }
    });
    g.a(this.jzY, this.mRw);
    AppMethodBeat.o(49339);
  }
  
  public final void dV(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void u(final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188945);
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
                  ((ViewGroup)b.3.1.this.mBv).removeView(b.this);
                  if (b.3.this.mBu != null) {
                    b.3.this.mBu.invoke();
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
    AppMethodBeat.o(188945);
  }
  
  public final void ux(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.b
 * JD-Core Version:    0.7.0.1
 */