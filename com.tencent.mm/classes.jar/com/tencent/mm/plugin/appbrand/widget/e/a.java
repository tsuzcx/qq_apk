package com.tencent.mm.plugin.appbrand.widget.e;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private final ap mHandler;
  private TextView nmC;
  private final Runnable nmD;
  private ViewPropertyAnimator nmE;
  ViewPropertyAnimator nmF;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135488);
    this.nmD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135483);
        a locala = a.this;
        if ((locala.getAlpha() == 0.0F) || (locala.nmF != null))
        {
          AppMethodBeat.o(135483);
          return;
        }
        locala.animate().cancel();
        ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
        locala.nmF = localViewPropertyAnimator;
        localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
        AppMethodBeat.o(135483);
      }
    };
    this.mHandler = new ap(Looper.getMainLooper());
    LayoutInflater.from(paramContext).inflate(2131493060, this, true);
    this.nmC = ((TextView)findViewById(2131305902));
    setOnClickListener(this);
    AppMethodBeat.o(135488);
  }
  
  public final void VA(String paramString)
  {
    AppMethodBeat.i(135489);
    this.nmC.setText(paramString);
    this.mHandler.removeCallbacks(this.nmD);
    this.mHandler.postDelayed(this.nmD, nmQ);
    if ((getAlpha() == 1.0F) || (this.nmE != null))
    {
      AppMethodBeat.o(135489);
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.nmE = paramString;
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
  
  public final void b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(135490);
    paramFrameLayout.addView(this, new FrameLayout.LayoutParams(-2, -2, 17));
    AppMethodBeat.o(135490);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135491);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(135491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */