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
  private TextView oyN;
  private TextView oyO;
  private SeekBar oyP;
  ValueAnimator oyQ;
  boolean oyR;
  a oyS;
  Drawable oyT;
  private a oyU;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.oyR = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131495800, this);
    this.oyN = ((TextView)paramContext.findViewById(2131299375));
    this.oyO = ((TextView)paramContext.findViewById(2131300126));
    this.oyP = ((SeekBar)paramContext.findViewById(2131307482));
    this.oyN.setText("00:00");
    this.oyO.setText("--:--");
    this.oyS = new a(getResources().getDrawable(2131234193));
    this.oyT = getResources().getDrawable(2131234195);
    this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.oyR = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.oyR = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).As(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String Ar(int paramInt)
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
  
  public final void jl(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.oyQ == null)
    {
      this.oyQ = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.oyQ.setTarget(this.oyP);
      this.oyQ.setRepeatCount(100);
      this.oyQ.setDuration(5000L);
      this.oyQ.setInterpolator(new LinearInterpolator());
      this.oyQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.oyS;
          paramAnonymousValueAnimator.oyX = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.oyS);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.oyQ.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.oyQ.cancel();
    this.oyP.setThumb(this.oyT);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.oyN.setTextColor(paramInt);
    this.oyO.setTextColor(paramInt);
    this.oyP.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.oyP.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.oyT.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.oyS.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.oyO.setText(Ar(paramInt));
    this.oyP.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(a parama)
  {
    this.oyU = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.oyR))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.oyN.setText(Ar(paramInt));
    this.oyP.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
  
  public static abstract interface a
  {
    public abstract void As(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */