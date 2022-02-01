package com.tencent.mm.plugin.appbrand.widget.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private final MMHandler mHandler;
  private TextView rEb;
  private final Runnable rEc;
  private ViewPropertyAnimator rEd;
  ViewPropertyAnimator rEe;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135488);
    this.rEc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135483);
        a locala = a.this;
        if ((locala.getAlpha() == 0.0F) || (locala.rEe != null))
        {
          AppMethodBeat.o(135483);
          return;
        }
        locala.animate().cancel();
        ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
        locala.rEe = localViewPropertyAnimator;
        localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
        AppMethodBeat.o(135483);
      }
    };
    this.mHandler = new MMHandler(Looper.getMainLooper());
    LayoutInflater.from(paramContext).inflate(a.e.app_brand_show_no_icon_toast, this, true);
    this.rEb = ((TextView)findViewById(a.d.title));
    setOnClickListener(this);
    AppMethodBeat.o(135488);
  }
  
  public final void anL(String paramString)
  {
    AppMethodBeat.i(135489);
    this.rEb.setText(paramString);
    this.mHandler.removeCallbacks(this.rEc);
    this.mHandler.postDelayed(this.rEc, rEo);
    if ((getAlpha() == 1.0F) || (this.rEd != null))
    {
      AppMethodBeat.o(135489);
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.rEd = paramString;
    paramString.alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(135485);
        a.a(a.this);
        AppMethodBeat.o(135485);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(135484);
        a.a(a.this);
        AppMethodBeat.o(135484);
      }
    }).start();
    setVisibility(0);
    AppMethodBeat.o(135489);
  }
  
  public final void c(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(135490);
    paramFrameLayout.addView(this, new FrameLayout.LayoutParams(-2, -2, 17));
    AppMethodBeat.o(135490);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135491);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(135491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.a
 * JD-Core Version:    0.7.0.1
 */