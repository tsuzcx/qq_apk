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
  private Vibrator rqC;
  private ImageView seg;
  private ImageView seh;
  private TextView sei;
  private c sej;
  private Animator sek;
  private Animator sel;
  private a sem;
  private boolean sen;
  
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
    this.seg = ((ImageView)findViewById(a.e.backgroundImageView));
    this.seh = ((ImageView)findViewById(a.e.indicatorImageView));
    this.sei = ((TextView)findViewById(a.e.indicatorTextView));
    this.rqC = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.sej = new c(this);
    float f = e.saR;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.seg, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.seg, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.sek = paramContext;
    f = e.saR;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.seg, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.seg, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.sel = paramContext;
    AppMethodBeat.o(106480);
  }
  
  public final void Gf(int paramInt)
  {
    AppMethodBeat.i(106482);
    if (paramInt >= 5)
    {
      b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", new Object[] { Integer.valueOf(paramInt) });
      this.sen = true;
      this.sei.setText(a.h.float_ball_full);
      this.sei.setTextColor(androidx.core.content.a.w(getContext(), a.b.float_ball_corner_full_text_color));
      this.seg.setImageResource(a.d.background_float_indicator_full_view);
      this.seh.setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), a.g.float_indicator_full_icon));
      AppMethodBeat.o(106482);
      return;
    }
    b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", new Object[] { Integer.valueOf(paramInt) });
    this.sen = false;
    this.sei.setText(a.h.enter_float_ball);
    this.sei.setTextColor(androidx.core.content.a.w(getContext(), a.b.float_ball_corner_text_color));
    this.seg.setImageResource(a.d.background_float_indicator_view);
    this.seh.setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), a.g.float_indicator_icon));
    AppMethodBeat.o(106482);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106481);
    super.onConfigurationChanged(paramConfiguration);
    a locala;
    if ((this.sem != null) && (paramConfiguration != null))
    {
      locala = this.sem;
      if (paramConfiguration.orientation != 2) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      locala.lj(bool);
      AppMethodBeat.o(106481);
      return;
    }
  }
  
  public void setOnOrientationChangedListener(a parama)
  {
    this.sem = parama;
  }
  
  public static abstract interface a
  {
    public abstract void lj(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatIndicatorView
 * JD-Core Version:    0.7.0.1
 */