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
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.plugin.ball.a.b;
import com.tencent.mm.plugin.ball.a.d;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.g;
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.b.c;
import com.tencent.mm.plugin.ball.f.e;

public class FloatIndicatorView
  extends FrameLayout
{
  private Vibrator uAL;
  private ImageView vpW;
  private ImageView vpX;
  private TextView vpY;
  private c vpZ;
  private Animator vqa;
  private Animator vqb;
  private a vqc;
  private boolean vqd;
  
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
    View.inflate(paramContext, a.f.layout_float_indicator_view, this);
    this.vpW = ((ImageView)findViewById(a.e.backgroundImageView));
    this.vpX = ((ImageView)findViewById(a.e.indicatorImageView));
    this.vpY = ((TextView)findViewById(a.e.indicatorTextView));
    this.uAL = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.vpZ = new c(this);
    float f = e.vmj;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.vpW, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.vpW, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.vqa = paramContext;
    f = e.vmj;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.vpW, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.vpW, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.vqb = paramContext;
    AppMethodBeat.o(106480);
  }
  
  public final void GE(int paramInt)
  {
    AppMethodBeat.i(106482);
    if (paramInt >= 5)
    {
      b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", new Object[] { Integer.valueOf(paramInt) });
      this.vqd = true;
      this.vpY.setText(a.h.float_ball_full);
      this.vpY.setTextColor(androidx.core.content.a.w(getContext(), a.b.float_ball_corner_full_text_color));
      this.vpW.setImageResource(a.d.background_float_indicator_full_view);
      this.vpX.setImageDrawable(com.tencent.mm.svg.a.a.i(getResources(), a.g.float_indicator_full_icon));
      AppMethodBeat.o(106482);
      return;
    }
    b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", new Object[] { Integer.valueOf(paramInt) });
    this.vqd = false;
    this.vpY.setText(a.h.enter_float_ball);
    this.vpY.setTextColor(androidx.core.content.a.w(getContext(), a.b.float_ball_corner_text_color));
    this.vpW.setImageResource(a.d.background_float_indicator_view);
    this.vpX.setImageDrawable(com.tencent.mm.svg.a.a.i(getResources(), a.g.float_indicator_icon));
    AppMethodBeat.o(106482);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106481);
    super.onConfigurationChanged(paramConfiguration);
    a locala;
    if ((this.vqc != null) && (paramConfiguration != null))
    {
      locala = this.vqc;
      if (paramConfiguration.orientation != 2) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      locala.mw(bool);
      AppMethodBeat.o(106481);
      return;
    }
  }
  
  public void setOnOrientationChangedListener(a parama)
  {
    this.vqc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void mw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatIndicatorView
 * JD-Core Version:    0.7.0.1
 */