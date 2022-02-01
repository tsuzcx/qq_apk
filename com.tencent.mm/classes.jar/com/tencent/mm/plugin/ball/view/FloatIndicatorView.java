package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.b.c;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.svg.a.a;

public class FloatIndicatorView
  extends FrameLayout
{
  public Vibrator nQa;
  private ImageView nRq;
  public ImageView nRr;
  private TextView nRs;
  private c nRt;
  public Animator nRu;
  public Animator nRv;
  private a nRw;
  public boolean nRx;
  
  public FloatIndicatorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106480);
    View.inflate(paramContext, 2131494558, this);
    this.nRq = ((ImageView)findViewById(2131297030));
    this.nRr = ((ImageView)findViewById(2131301002));
    this.nRs = ((TextView)findViewById(2131301003));
    this.nQa = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.nRt = new c(this);
    float f = e.nNV;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.nRq, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nRq, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.nRu = paramContext;
    f = e.nNV;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.nRq, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.nRq, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.nRv = paramContext;
    AppMethodBeat.o(106480);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106481);
    super.onConfigurationChanged(paramConfiguration);
    a locala;
    if ((this.nRw != null) && (paramConfiguration != null))
    {
      locala = this.nRw;
      if (paramConfiguration.orientation != 2) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      locala.ja(bool);
      AppMethodBeat.o(106481);
      return;
    }
  }
  
  public void setOnOrientationChangedListener(a parama)
  {
    this.nRw = parama;
  }
  
  public final void yW(int paramInt)
  {
    AppMethodBeat.i(106482);
    if (paramInt >= 5)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", new Object[] { Integer.valueOf(paramInt) });
      this.nRx = true;
      this.nRs.setText(2131759447);
      this.nRs.setTextColor(android.support.v4.content.b.n(getContext(), 2131100375));
      this.nRq.setImageResource(2131231097);
      this.nRr.setImageDrawable(a.g(getResources(), 2131690224));
      AppMethodBeat.o(106482);
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", new Object[] { Integer.valueOf(paramInt) });
    this.nRx = false;
    this.nRs.setText(2131758422);
    this.nRs.setTextColor(android.support.v4.content.b.n(getContext(), 2131100376));
    this.nRq.setImageResource(2131231098);
    this.nRr.setImageDrawable(a.g(getResources(), 2131690226));
    AppMethodBeat.o(106482);
  }
  
  public static abstract interface a
  {
    public abstract void ja(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatIndicatorView
 * JD-Core Version:    0.7.0.1
 */