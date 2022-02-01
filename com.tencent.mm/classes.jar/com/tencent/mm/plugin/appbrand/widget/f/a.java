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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private final MMHandler mHandler;
  private TextView oBs;
  private final Runnable oBt;
  private ViewPropertyAnimator oBu;
  ViewPropertyAnimator oBv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135488);
    this.oBt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135483);
        a locala = a.this;
        if ((locala.getAlpha() == 0.0F) || (locala.oBv != null))
        {
          AppMethodBeat.o(135483);
          return;
        }
        locala.animate().cancel();
        ViewPropertyAnimator localViewPropertyAnimator = locala.animate();
        locala.oBv = localViewPropertyAnimator;
        localViewPropertyAnimator.alpha(0.0F).setListener(new a.3(locala)).start();
        AppMethodBeat.o(135483);
      }
    };
    this.mHandler = new MMHandler(Looper.getMainLooper());
    LayoutInflater.from(paramContext).inflate(2131493099, this, true);
    this.oBs = ((TextView)findViewById(2131309195));
    setOnClickListener(this);
    AppMethodBeat.o(135488);
  }
  
  public final void agi(String paramString)
  {
    AppMethodBeat.i(135489);
    this.oBs.setText(paramString);
    this.mHandler.removeCallbacks(this.oBt);
    this.mHandler.postDelayed(this.oBt, oBF);
    if ((getAlpha() == 1.0F) || (this.oBu != null))
    {
      AppMethodBeat.o(135489);
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.oBu = paramString;
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
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(135491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a
 * JD-Core Version:    0.7.0.1
 */