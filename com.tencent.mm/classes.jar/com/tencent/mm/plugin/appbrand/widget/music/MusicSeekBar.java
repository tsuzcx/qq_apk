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
import com.tencent.luggage.j.b.a.c;
import com.tencent.luggage.j.b.a.d;
import com.tencent.luggage.j.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicSeekBar
  extends FrameLayout
{
  private Context context;
  boolean isLoading;
  boolean msx;
  private TextView uMK;
  private TextView uML;
  private SeekBar uMM;
  ValueAnimator uMN;
  a uMO;
  Drawable uMP;
  private a uMQ;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.msx = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.music_seek_bar, this);
    this.uMK = ((TextView)paramContext.findViewById(a.d.current_time));
    this.uML = ((TextView)paramContext.findViewById(a.d.end_time));
    this.uMM = ((SeekBar)paramContext.findViewById(a.d.seek_bar));
    this.uMK.setText("00:00");
    this.uML.setText("--:--");
    this.uMO = new a(getResources().getDrawable(a.c.music_seek_bar_loading));
    this.uMP = getResources().getDrawable(a.c.music_seek_bar_tumb);
    this.uMM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.msx = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.msx = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).Ez(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String Ey(int paramInt)
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
  
  public final void lI(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.uMN == null)
    {
      this.uMN = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.uMN.setTarget(this.uMM);
      this.uMN.setRepeatCount(100);
      this.uMN.setDuration(5000L);
      this.uMN.setInterpolator(new LinearInterpolator());
      this.uMN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.uMO;
          paramAnonymousValueAnimator.uMT = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.uMO);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.uMN.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.uMN.cancel();
    this.uMM.setThumb(this.uMP);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.uMK.setTextColor(paramInt);
    this.uML.setTextColor(paramInt);
    this.uMM.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.uMM.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.uMP.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.uMO.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.uML.setText(Ey(paramInt));
    this.uMM.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(a parama)
  {
    this.uMQ = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.msx))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.uMK.setText(Ey(paramInt));
    this.uMM.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
  
  public static abstract interface a
  {
    public abstract void Ez(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */