package com.tencent.mm.plugin.appbrand.widget.f;

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
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private TextView jbI;
  private final Runnable juc;
  private ViewPropertyAnimator jud;
  ViewPropertyAnimator jue;
  private final ak mHandler;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87527);
    this.juc = new a.1(this);
    this.mHandler = new ak(Looper.getMainLooper());
    LayoutInflater.from(paramContext).inflate(2130968738, this, true);
    this.jbI = ((TextView)findViewById(2131820680));
    setOnClickListener(this);
    AppMethodBeat.o(87527);
  }
  
  public final void FX(String paramString)
  {
    AppMethodBeat.i(87528);
    this.jbI.setText(paramString);
    this.mHandler.removeCallbacks(this.juc);
    this.mHandler.postDelayed(this.juc, juo);
    if ((getAlpha() == 1.0F) || (this.jud != null))
    {
      AppMethodBeat.o(87528);
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.jud = paramString;
    paramString.alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(87524);
        a.a(a.this);
        AppMethodBeat.o(87524);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(87523);
        a.a(a.this);
        AppMethodBeat.o(87523);
      }
    }).start();
    setVisibility(0);
    AppMethodBeat.o(87528);
  }
  
  public final void a(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(87529);
    paramFrameLayout.addView(this, new FrameLayout.LayoutParams(-2, -2, 17));
    AppMethodBeat.o(87529);
  }
  
  public final void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a
 * JD-Core Version:    0.7.0.1
 */