package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;

public class FaceNumberLayout
  extends LinearLayout
{
  private static final int HjN;
  private d HjO;
  private Runnable HjP;
  private int currentIndex;
  private int total;
  
  static
  {
    AppMethodBeat.i(264660);
    HjN = c.fuD();
    AppMethodBeat.o(264660);
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
    AppMethodBeat.i(264625);
    this.currentIndex = 0;
    this.total = 0;
    this.HjP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264635);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "showNumberRunnable current index:%s", new Object[] { Integer.valueOf(FaceNumberLayout.a(FaceNumberLayout.this)) });
        if (FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this)) != null)
        {
          FaceNumberView localFaceNumberView = (FaceNumberView)FaceNumberLayout.this.getChildAt(FaceNumberLayout.a(FaceNumberLayout.this));
          Log.i("MicroMsg.FaceFlashManagerNumberView", "show");
          localFaceNumberView.HjR.setVisibility(4);
          localFaceNumberView.HjS.clearAnimation();
          localFaceNumberView.HjT.setFillAfter(true);
          localFaceNumberView.HjT.setDuration(500L);
          localFaceNumberView.HjS.startAnimation(localFaceNumberView.HjT);
          localFaceNumberView.HjS.setVisibility(0);
          FaceNumberLayout.b(FaceNumberLayout.this);
          if (FaceNumberLayout.a(FaceNumberLayout.this) <= FaceNumberLayout.c(FaceNumberLayout.this)) {
            FaceNumberLayout.a(FaceNumberLayout.this, h.ahAA.o(FaceNumberLayout.d(FaceNumberLayout.this), FaceNumberLayout.HjN));
          }
        }
        AppMethodBeat.o(264635);
      }
    };
    AppMethodBeat.o(264625);
  }
  
  public final void fuV()
  {
    AppMethodBeat.i(264676);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "startShowNumber");
    if ((this.HjO != null) && (!this.HjO.isDone()) && (!this.HjO.isCancelled())) {
      this.HjO.cancel(true);
    }
    this.HjO = h.ahAA.bk(this.HjP);
    AppMethodBeat.o(264676);
  }
  
  public final void release()
  {
    AppMethodBeat.i(264684);
    Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
    if ((this.HjO != null) && (!this.HjO.isDone()) && (!this.HjO.isCancelled())) {
      this.HjO.cancel(true);
    }
    int i = 0;
    while (i < getChildCount())
    {
      ((FaceNumberView)getChildAt(i)).release();
      i += 1;
    }
    AppMethodBeat.o(264684);
  }
  
  public void setNumbers(String paramString)
  {
    AppMethodBeat.i(264668);
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
    AppMethodBeat.o(264668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.view.FaceNumberLayout
 * JD-Core Version:    0.7.0.1
 */