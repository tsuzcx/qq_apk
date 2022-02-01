package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberLayout
  extends LinearLayout
{
  private static final int wIO;
  private int currentIndex;
  private int jcu;
  private d wIP;
  private Runnable wIQ;
  
  static
  {
    AppMethodBeat.i(186713);
    wIO = a.dKX();
    AppMethodBeat.o(186713);
  }
  
  public FaceNumberLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceNumberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceNumberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(186709);
    this.currentIndex = 0;
    this.jcu = 0;
    this.wIQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186708);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "showNumberRunnable current index:%s", new Object[] { Integer.valueOf(FaceNumberLayout.a(FaceNumberLayout.this)) });
        if (FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this)) != null)
        {
          FaceNumberView localFaceNumberView = (FaceNumberView)FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this));
          Log.i("MicroMsg.FaceFlashManagerNumberView", "show");
          localFaceNumberView.wIS.setVisibility(4);
          localFaceNumberView.wIT.clearAnimation();
          localFaceNumberView.wIU.setFillAfter(true);
          localFaceNumberView.wIU.setDuration(500L);
          localFaceNumberView.wIT.startAnimation(localFaceNumberView.wIU);
          localFaceNumberView.wIT.setVisibility(0);
          FaceNumberLayout.a(FaceNumberLayout.this, FaceNumberLayout.a(FaceNumberLayout.this) + 1);
          if (FaceNumberLayout.a(FaceNumberLayout.this) <= FaceNumberLayout.b(FaceNumberLayout.this)) {
            FaceNumberLayout.a(FaceNumberLayout.this, h.RTc.n(FaceNumberLayout.c(FaceNumberLayout.this), FaceNumberLayout.wIO));
          }
        }
        AppMethodBeat.o(186708);
      }
    };
    AppMethodBeat.o(186709);
  }
  
  public final void dLn()
  {
    AppMethodBeat.i(186711);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "startShowNumber");
    if ((this.wIP != null) && (!this.wIP.isDone()) && (!this.wIP.isCancelled())) {
      this.wIP.cancel(true);
    }
    this.wIP = h.RTc.aV(this.wIQ);
    AppMethodBeat.o(186711);
  }
  
  public final void release()
  {
    AppMethodBeat.i(186712);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
    if ((this.wIP != null) && (!this.wIP.isDone()) && (!this.wIP.isCancelled())) {
      this.wIP.cancel(true);
    }
    int i = 0;
    while (i < getChildCount())
    {
      ((FaceNumberView)getChildAt(i)).release();
      i += 1;
    }
    AppMethodBeat.o(186712);
  }
  
  public void setNumbers(String paramString)
  {
    AppMethodBeat.i(186710);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumbers %s", new Object[] { paramString });
    this.jcu = paramString.length();
    this.currentIndex = getChildCount();
    setWeightSum(this.jcu);
    int i = 0;
    while (i < this.jcu)
    {
      FaceNumberView localFaceNumberView = new FaceNumberView(getContext());
      localFaceNumberView.setNumber(String.valueOf(paramString.charAt(i)));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 1;
      addView(localFaceNumberView, localLayoutParams);
      i += 1;
    }
    AppMethodBeat.o(186710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceNumberLayout
 * JD-Core Version:    0.7.0.1
 */