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
import com.tencent.luggage.i.b.a.c;
import com.tencent.luggage.i.b.a.d;
import com.tencent.luggage.i.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicSeekBar
  extends FrameLayout
{
  private Context context;
  boolean isLoading;
  Drawable rBA;
  private MusicSeekBar.a rBB;
  private TextView rBv;
  private TextView rBw;
  private SeekBar rBx;
  ValueAnimator rBy;
  a rBz;
  boolean rjZ;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133762);
    this.rjZ = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.music_seek_bar, this);
    this.rBv = ((TextView)paramContext.findViewById(a.d.current_time));
    this.rBw = ((TextView)paramContext.findViewById(a.d.end_time));
    this.rBx = ((SeekBar)paramContext.findViewById(a.d.seek_bar));
    this.rBv.setText("00:00");
    this.rBw.setText("--:--");
    this.rBz = new a(getResources().getDrawable(a.c.music_seek_bar_loading));
    this.rBA = getResources().getDrawable(a.c.music_seek_bar_tumb);
    this.rBx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        MusicSeekBar.this.rjZ = true;
      }
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(133760);
        MusicSeekBar.this.rjZ = false;
        if (MusicSeekBar.a(MusicSeekBar.this) != null) {
          MusicSeekBar.a(MusicSeekBar.this).DZ(paramAnonymousSeekBar.getProgress());
        }
        AppMethodBeat.o(133760);
      }
    });
    AppMethodBeat.o(133762);
  }
  
  private static String DY(int paramInt)
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
  
  public final void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(133763);
    if (this.rBy == null)
    {
      this.rBy = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.rBy.setTarget(this.rBx);
      this.rBy.setRepeatCount(100);
      this.rBy.setDuration(5000L);
      this.rBy.setInterpolator(new LinearInterpolator());
      this.rBy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(133761);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramAnonymousValueAnimator = MusicSeekBar.this.rBz;
          paramAnonymousValueAnimator.rBE = f;
          paramAnonymousValueAnimator.invalidateSelf();
          MusicSeekBar.b(MusicSeekBar.this).setThumb(MusicSeekBar.this.rBz);
          AppMethodBeat.o(133761);
        }
      });
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.rBy.start();
      AppMethodBeat.o(133763);
      return;
    }
    this.rBy.cancel();
    this.rBx.setThumb(this.rBA);
    AppMethodBeat.o(133763);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(133764);
    this.rBv.setTextColor(paramInt);
    this.rBw.setTextColor(paramInt);
    this.rBx.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.rBx.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.rBA.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.rBz.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(133764);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(133766);
    this.rBw.setText(DY(paramInt));
    this.rBx.setMax(paramInt);
    AppMethodBeat.o(133766);
  }
  
  public void setOnSeekBarChange(MusicSeekBar.a parama)
  {
    this.rBB = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(133765);
    if ((this.isLoading) || (this.rjZ))
    {
      AppMethodBeat.o(133765);
      return;
    }
    this.rBv.setText(DY(paramInt));
    this.rBx.setProgress(paramInt);
    AppMethodBeat.o(133765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */