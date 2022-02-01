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
  private TextView npg;
  private TextView nph;
  private SeekBar npi;
  ValueAnimator npj;
  boolean npk;
  a npl;
  Drawable npm;
  private MusicSeekBar.a npn;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.npk = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131494986, this);
    this.npg = ((TextView)paramContext.findViewById(2131298899));
    this.nph = ((TextView)paramContext.findViewById(2131299490));
    this.npi = ((SeekBar)paramContext.findViewById(2131304485));
    this.npg.setText("00:00");
    this.nph.setText("--:--");
    this.npl = new a(getResources().getDrawable(2131233397));
    this.npm = getResources().getDrawable(2131233399);
    this.npi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.npk = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.npk = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).wK(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String wJ(int paramInt)
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
  
  public final void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.npj == null)
    {
      this.npj = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.npj.setTarget(this.npi);
      this.npj.setRepeatCount(100);
      this.npj.setDuration(5000L);
      this.npj.setInterpolator(new LinearInterpolator());
      this.npj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.npl;
          paramAnonymousValueAnimator.npq = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.npl);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.npj.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.npj.cancel();
    this.npi.setThumb(this.npm);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.npg.setTextColor(paramInt);
    this.nph.setTextColor(paramInt);
    this.npi.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.npi.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.npm.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.npl.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.nph.setText(wJ(paramInt));
    this.npi.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(MusicSeekBar.a parama)
  {
    this.npn = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.npk))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.npg.setText(wJ(paramInt));
    this.npi.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */