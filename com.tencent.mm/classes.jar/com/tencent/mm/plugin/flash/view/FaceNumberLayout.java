package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberLayout
  extends LinearLayout
{
  private static final int BCg;
  private d BCh;
  private Runnable BCi;
  private int currentIndex;
  private int total;
  
  static
  {
    AppMethodBeat.i(191802);
    BCg = a.epB();
    AppMethodBeat.o(191802);
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
    AppMethodBeat.i(191780);
    this.currentIndex = 0;
    this.total = 0;
    this.BCi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191147);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "showNumberRunnable current index:%s", new Object[] { Integer.valueOf(FaceNumberLayout.a(FaceNumberLayout.this)) });
        if (FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this)) != null)
        {
          FaceNumberView localFaceNumberView = (FaceNumberView)FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this));
          Log.i("MicroMsg.FaceFlashManagerNumberView", "show");
          localFaceNumberView.BCk.setVisibility(4);
          localFaceNumberView.BCl.clearAnimation();
          localFaceNumberView.BCm.setFillAfter(true);
          localFaceNumberView.BCm.setDuration(500L);
          localFaceNumberView.BCl.startAnimation(localFaceNumberView.BCm);
          localFaceNumberView.BCl.setVisibility(0);
          FaceNumberLayout.a(FaceNumberLayout.this, FaceNumberLayout.a(FaceNumberLayout.this) + 1);
          if (FaceNumberLayout.a(FaceNumberLayout.this) <= FaceNumberLayout.b(FaceNumberLayout.this)) {
            FaceNumberLayout.a(FaceNumberLayout.this, h.ZvG.n(FaceNumberLayout.c(FaceNumberLayout.this), FaceNumberLayout.BCg));
          }
        }
        AppMethodBeat.o(191147);
      }
    };
    AppMethodBeat.o(191780);
  }
  
  public final void epT()
  {
    AppMethodBeat.i(191792);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "startShowNumber");
    if ((this.BCh != null) && (!this.BCh.isDone()) && (!this.BCh.isCancelled())) {
      this.BCh.cancel(true);
    }
    this.BCh = h.ZvG.bc(this.BCi);
    AppMethodBeat.o(191792);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191795);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
    if ((this.BCh != null) && (!this.BCh.isDone()) && (!this.BCh.isCancelled())) {
      this.BCh.cancel(true);
    }
    int i = 0;
    while (i < getChildCount())
    {
      ((FaceNumberView)getChildAt(i)).release();
      i += 1;
    }
    AppMethodBeat.o(191795);
  }
  
  public void setNumbers(String paramString)
  {
    AppMethodBeat.i(191786);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumbers %s", new Object[] { paramString });
    this.total = paramString.length();
    this.currentIndex = getChildCount();
    setWeightSum(this.total);
    int i = 0;
    while (i < this.total)
    {
      FaceNumberView localFaceNumberView = new FaceNumberView(getContext());
      localFaceNumberView.setNumber(String.valueOf(paramString.charAt(i)));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 1;
      addView(localFaceNumberView, localLayoutParams);
      i += 1;
    }
    AppMethodBeat.o(191786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceNumberLayout
 * JD-Core Version:    0.7.0.1
 */