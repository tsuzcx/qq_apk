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
  private TextView njY;
  private TextView njZ;
  private SeekBar nka;
  ValueAnimator nkb;
  boolean nkc;
  a nkd;
  Drawable nke;
  private a nkf;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.nkc = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131494986, this);
    this.njY = ((TextView)paramContext.findViewById(2131298899));
    this.njZ = ((TextView)paramContext.findViewById(2131299490));
    this.nka = ((SeekBar)paramContext.findViewById(2131304485));
    this.njY.setText("00:00");
    this.njZ.setText("--:--");
    this.nkd = new a(getResources().getDrawable(2131233397));
    this.nke = getResources().getDrawable(2131233399);
    this.nka.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.nkc = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.nkc = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).wF(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String wE(int paramInt)
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
  
  public final void im(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.nkb == null)
    {
      this.nkb = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.nkb.setTarget(this.nka);
      this.nkb.setRepeatCount(100);
      this.nkb.setDuration(5000L);
      this.nkb.setInterpolator(new LinearInterpolator());
      this.nkb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.nkd;
          paramAnonymousValueAnimator.nki = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.nkd);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.nkb.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.nkb.cancel();
    this.nka.setThumb(this.nke);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.njY.setTextColor(paramInt);
    this.njZ.setTextColor(paramInt);
    this.nka.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.nka.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.nke.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.nkd.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.njZ.setText(wE(paramInt));
    this.nka.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(a parama)
  {
    this.nkf = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.nkc))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.njY.setText(wE(paramInt));
    this.nka.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
  
  public static abstract interface a
  {
    public abstract void wF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */