package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicSeekBar
  extends FrameLayout
{
  private Context context;
  boolean isLoading;
  private TextView jrK;
  private TextView jrL;
  private SeekBar jrM;
  ValueAnimator jrN;
  boolean jrO;
  a jrP;
  Drawable jrQ;
  private MusicSeekBar.a jrR;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141884);
    this.jrO = false;
    this.isLoading = false;
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2130970330, this);
    this.jrK = ((TextView)paramContext.findViewById(2131826462));
    this.jrL = ((TextView)paramContext.findViewById(2131824842));
    this.jrM = ((SeekBar)paramContext.findViewById(2131826463));
    this.jrK.setText("00:00");
    this.jrL.setText("--:--");
    this.jrP = new a(getResources().getDrawable(2130839755));
    this.jrQ = getResources().getDrawable(2130839757);
    this.jrM.setOnSeekBarChangeListener(new MusicSeekBar.1(this));
    AppMethodBeat.o(141884);
  }
  
  private static String qG(int paramInt)
  {
    AppMethodBeat.i(141889);
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
    AppMethodBeat.o(141889);
    return localObject;
  }
  
  public final void fs(boolean paramBoolean)
  {
    AppMethodBeat.i(141885);
    if (this.jrN == null)
    {
      this.jrN = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.jrN.setTarget(this.jrM);
      this.jrN.setRepeatCount(100);
      this.jrN.setDuration(5000L);
      this.jrN.setInterpolator(new LinearInterpolator());
      this.jrN.addUpdateListener(new MusicSeekBar.2(this));
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.jrN.start();
      AppMethodBeat.o(141885);
      return;
    }
    this.jrN.cancel();
    this.jrM.setThumb(this.jrQ);
    AppMethodBeat.o(141885);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(141886);
    this.jrK.setTextColor(paramInt);
    this.jrL.setTextColor(paramInt);
    this.jrM.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.jrM.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.jrQ.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.jrP.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    AppMethodBeat.o(141886);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(141888);
    this.jrL.setText(qG(paramInt));
    this.jrM.setMax(paramInt);
    AppMethodBeat.o(141888);
  }
  
  public void setOnSeekBarChange(MusicSeekBar.a parama)
  {
    this.jrR = parama;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(141887);
    if ((this.isLoading) || (this.jrO))
    {
      AppMethodBeat.o(141887);
      return;
    }
    this.jrK.setText(qG(paramInt));
    this.jrM.setProgress(paramInt);
    AppMethodBeat.o(141887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */