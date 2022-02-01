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
  private TextView mJC;
  private TextView mJD;
  private SeekBar mJE;
  ValueAnimator mJF;
  boolean mJG;
  a mJH;
  Drawable mJI;
  private a mJJ;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.mJG = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131494986, this);
    this.mJC = ((TextView)paramContext.findViewById(2131298899));
    this.mJD = ((TextView)paramContext.findViewById(2131299490));
    this.mJE = ((SeekBar)paramContext.findViewById(2131304485));
    this.mJC.setText("00:00");
    this.mJD.setText("--:--");
    this.mJH = new a(getResources().getDrawable(2131233397));
    this.mJI = getResources().getDrawable(2131233399);
    this.mJE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.mJG = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.mJG = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).wa(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String vZ(int paramInt)
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
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.mJF == null)
    {
      this.mJF = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.mJF.setTarget(this.mJE);
      this.mJF.setRepeatCount(100);
      this.mJF.setDuration(5000L);
      this.mJF.setInterpolator(new LinearInterpolator());
      this.mJF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.mJH;
          paramAnonymousValueAnimator.mJM = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.mJH);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.mJF.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.mJF.cancel();
    this.mJE.setThumb(this.mJI);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.mJC.setTextColor(paramInt);
    this.mJD.setTextColor(paramInt);
    this.mJE.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mJE.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mJI.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mJH.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.mJD.setText(vZ(paramInt));
    this.mJE.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(a parama)
  {
    this.mJJ = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.mJG))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.mJC.setText(vZ(paramInt));
    this.mJE.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
  
  public static abstract interface a
  {
    public abstract void wa(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */