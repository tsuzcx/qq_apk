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
  public Vibrator nKv;
  private ImageView nLL;
  public ImageView nLM;
  private TextView nLN;
  private c nLO;
  public Animator nLP;
  public Animator nLQ;
  private a nLR;
  public boolean nLS;
  
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
    this.nLL = ((ImageView)findViewById(2131297030));
    this.nLM = ((ImageView)findViewById(2131301002));
    this.nLN = ((TextView)findViewById(2131301003));
    this.nKv = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.nLO = new c(this);
    float f = e.nIs;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.nLL, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.nLL, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.nLP = paramContext;
    f = e.nIs;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.nLL, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.nLL, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.nLQ = paramContext;
    AppMethodBeat.o(106480);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106481);
    super.onConfigurationChanged(paramConfiguration);
    a locala;
    if ((this.nLR != null) && (paramConfiguration != null))
    {
      locala = this.nLR;
      if (paramConfiguration.orientation != 2) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      locala.jb(bool);
      AppMethodBeat.o(106481);
      return;
    }
  }
  
  public void setOnOrientationChangedListener(a parama)
  {
    this.nLR = parama;
  }
  
  public final void yN(int paramInt)
  {
    AppMethodBeat.i(106482);
    if (paramInt >= 5)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", new Object[] { Integer.valueOf(paramInt) });
      this.nLS = true;
      this.nLN.setText(2131759447);
      this.nLN.setTextColor(android.support.v4.content.b.n(getContext(), 2131100375));
      this.nLL.setImageResource(2131231097);
      this.nLM.setImageDrawable(a.g(getResources(), 2131690224));
      AppMethodBeat.o(106482);
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", new Object[] { Integer.valueOf(paramInt) });
    this.nLS = false;
    this.nLN.setText(2131758422);
    this.nLN.setTextColor(android.support.v4.content.b.n(getContext(), 2131100376));
    this.nLL.setImageResource(2131231098);
    this.nLM.setImageDrawable(a.g(getResources(), 2131690226));
    AppMethodBeat.o(106482);
  }
  
  public static abstract interface a
  {
    public abstract void jb(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatIndicatorView
 * JD-Core Version:    0.7.0.1
 */