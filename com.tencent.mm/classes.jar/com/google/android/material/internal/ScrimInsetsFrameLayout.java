package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.ae;
import androidx.core.g.ae.e;
import androidx.core.g.s;
import androidx.core.g.w;
import androidx.core.graphics.c;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable bCR;
  Rect bCS;
  private Rect bCT;
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238113);
    this.bCT = new Rect();
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ScrimInsetsFrameLayout, paramInt, a.j.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.bCR = paramContext.getDrawable(a.k.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    w.a(this, new s()
    {
      public final ae a(View paramAnonymousView, ae paramAnonymousae)
      {
        boolean bool = false;
        AppMethodBeat.i(238090);
        if (ScrimInsetsFrameLayout.this.bCS == null) {
          ScrimInsetsFrameLayout.this.bCS = new Rect();
        }
        ScrimInsetsFrameLayout.this.bCS.set(paramAnonymousae.hc(), paramAnonymousae.hd(), paramAnonymousae.he(), paramAnonymousae.hf());
        ScrimInsetsFrameLayout.this.b(paramAnonymousae);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if (!paramAnonymousae.Oa.hp().equals(c.Kn)) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (ScrimInsetsFrameLayout.this.bCR == null)) {
            bool = true;
          }
          paramAnonymousView.setWillNotDraw(bool);
          w.G(ScrimInsetsFrameLayout.this);
          paramAnonymousView = paramAnonymousae.Oa.hl();
          AppMethodBeat.o(238090);
          return paramAnonymousView;
        }
      }
    });
    AppMethodBeat.o(238113);
  }
  
  protected void b(ae paramae) {}
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238115);
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.bCS != null) && (this.bCR != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.bCT.set(0, 0, i, this.bCS.top);
      this.bCR.setBounds(this.bCT);
      this.bCR.draw(paramCanvas);
      this.bCT.set(0, j - this.bCS.bottom, i, j);
      this.bCR.setBounds(this.bCT);
      this.bCR.draw(paramCanvas);
      this.bCT.set(0, this.bCS.top, this.bCS.left, j - this.bCS.bottom);
      this.bCR.setBounds(this.bCT);
      this.bCR.draw(paramCanvas);
      this.bCT.set(i - this.bCS.right, this.bCS.top, i, j - this.bCS.bottom);
      this.bCR.setBounds(this.bCT);
      this.bCR.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    AppMethodBeat.o(238115);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(238116);
    super.onAttachedToWindow();
    if (this.bCR != null) {
      this.bCR.setCallback(this);
    }
    AppMethodBeat.o(238116);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(238117);
    super.onDetachedFromWindow();
    if (this.bCR != null) {
      this.bCR.setCallback(null);
    }
    AppMethodBeat.o(238117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */