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
  public Vibrator paT;
  private ImageView pcg;
  public ImageView pch;
  private TextView pci;
  private c pcj;
  public Animator pck;
  public Animator pcl;
  private a pcm;
  public boolean pcn;
  
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
    View.inflate(paramContext, 2131495174, this);
    this.pcg = ((ImageView)findViewById(2131297172));
    this.pch = ((ImageView)findViewById(2131302643));
    this.pci = ((TextView)findViewById(2131302644));
    this.paT = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.pcj = new c(this);
    float f = e.oYQ;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.pcg, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.pcg, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.pck = paramContext;
    f = e.oYQ;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.pcg, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.pcg, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { paramAttributeSet, localObjectAnimator });
    this.pcl = paramContext;
    AppMethodBeat.o(106480);
  }
  
  public final void CC(int paramInt)
  {
    AppMethodBeat.i(106482);
    if (paramInt >= 5)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", new Object[] { Integer.valueOf(paramInt) });
      this.pcn = true;
      this.pci.setText(2131760760);
      this.pci.setTextColor(android.support.v4.content.b.n(getContext(), 2131100472));
      this.pcg.setImageResource(2131231132);
      this.pch.setImageDrawable(a.h(getResources(), 2131690320));
      AppMethodBeat.o(106482);
      return;
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", new Object[] { Integer.valueOf(paramInt) });
    this.pcn = false;
    this.pci.setText(2131758717);
    this.pci.setTextColor(android.support.v4.content.b.n(getContext(), 2131100473));
    this.pcg.setImageResource(2131231133);
    this.pch.setImageDrawable(a.h(getResources(), 2131690322));
    AppMethodBeat.o(106482);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106481);
    super.onConfigurationChanged(paramConfiguration);
    a locala;
    if ((this.pcm != null) && (paramConfiguration != null))
    {
      locala = this.pcm;
      if (paramConfiguration.orientation != 2) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      locala.jY(bool);
      AppMethodBeat.o(106481);
      return;
    }
  }
  
  public void setOnOrientationChangedListener(a parama)
  {
    this.pcm = parama;
  }
  
  public static abstract interface a
  {
    public abstract void jY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatIndicatorView
 * JD-Core Version:    0.7.0.1
 */