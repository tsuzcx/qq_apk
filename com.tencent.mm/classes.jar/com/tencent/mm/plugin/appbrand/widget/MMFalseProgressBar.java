package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

public class MMFalseProgressBar
  extends ProgressBar
{
  private float Tb;
  private float jaD;
  private float jaE;
  private float jaF;
  private float jaG;
  private boolean jaH;
  private ak mHandler;
  private boolean mIsStart;
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMFalseProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(87444);
    this.mIsStart = false;
    this.Tb = 0.0F;
    this.jaH = true;
    this.mHandler = new MMFalseProgressBar.1(this, Looper.getMainLooper());
    setMax(1000);
    if (at.ha(ah.getContext()))
    {
      this.jaD = 4.0F;
      this.jaE = 1.0F;
      this.jaF = 0.3F;
      this.jaG = 50.0F;
      AppMethodBeat.o(87444);
      return;
    }
    this.jaD = 2.0F;
    this.jaE = 0.5F;
    this.jaF = 0.15F;
    this.jaG = 50.0F;
    AppMethodBeat.o(87444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar
 * JD-Core Version:    0.7.0.1
 */