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
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private final ap mHandler;
  private TextView mkg;
  private final Runnable mkh;
  private ViewPropertyAnimator mki;
  ViewPropertyAnimator mkj;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135488);
    this.mkh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135483);
        a locala = a.this;
        if ((locala.getAlpha() == 0.0F) || (locala.mkj != null))
        {
          AppMethodBeat.o(135483);
          return;
        }
        locala.animate().cancel();
        ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
        locala.mkj = localViewPropertyAnimator;
        localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
        AppMethodBeat.o(135483);
      }
    };
    this.mHandler = new ap(Looper.getMainLooper());
    LayoutInflater.from(paramContext).inflate(2131493060, this, true);
    this.mkg = ((TextView)findViewById(2131305902));
    setOnClickListener(this);
    AppMethodBeat.o(135488);
  }
  
  public final void NU(String paramString)
  {
    AppMethodBeat.i(135489);
    this.mkg.setText(paramString);
    this.mHandler.removeCallbacks(this.mkh);
    this.mHandler.postDelayed(this.mkh, mkt);
    if ((getAlpha() == 1.0F) || (this.mki != null))
    {
      AppMethodBeat.o(135489);
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.mki = paramString;
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
    AppMethodBeat.o(135491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */