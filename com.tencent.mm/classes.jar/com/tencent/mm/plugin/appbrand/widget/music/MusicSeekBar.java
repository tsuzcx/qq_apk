package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicSeekBar
  extends FrameLayout
{
  private Context context;
  boolean isLoading;
  private TextView mhB;
  private TextView mhC;
  private SeekBar mhD;
  ValueAnimator mhE;
  boolean mhF;
  a mhG;
  Drawable mhH;
  private a mhI;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.mhF = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131494986, this);
    this.mhB = ((TextView)paramContext.findViewById(2131298899));
    this.mhC = ((TextView)paramContext.findViewById(2131299490));
    this.mhD = ((SeekBar)paramContext.findViewById(2131304485));
    this.mhB.setText("00:00");
    this.mhC.setText("--:--");
    this.mhG = new a(getResources().getDrawable(2131233397));
    this.mhH = getResources().getDrawable(2131233399);
    this.mhD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.mhF = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.mhF = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).vj(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String vi(int paramInt)
  {
    AppMethodBeat.i(133767);
    Object localObject = new StringBuilder();
    long l1 = paramInt / 60000;
    long l2 = Math.floor(paramInt % 60000 / 1000L);
    if (l1 < 10L) {
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(l1 + ":");
    if (l2 < 10L) {
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(l2);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(133767);
    return localObject;
  }
  
  public final void hE(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.mhE == null)
    {
      this.mhE = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.mhE.setTarget(this.mhD);
      this.mhE.setRepeatCount(100);
      this.mhE.setDuration(5000L);
      this.mhE.setInterpolator(new LinearInterpolator());
      this.mhE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.mhG;
          paramAnonymousValueAnimator.mhL = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.mhG);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.mhE.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.mhE.cancel();
    this.mhD.setThumb(this.mhH);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.mhB.setTextColor(paramInt);
    this.mhC.setTextColor(paramInt);
    this.mhD.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mhD.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mhH.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mhG.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.mhC.setText(vi(paramInt));
    this.mhD.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(a parama)
  {
    this.mhI = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.mhF))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.mhB.setText(vi(paramInt));
    this.mhD.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
  
  public static abstract interface a
  {
    public abstract void vj(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */