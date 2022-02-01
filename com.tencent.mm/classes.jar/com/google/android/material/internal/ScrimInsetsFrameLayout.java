package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.ah;
import androidx.core.g.s;
import androidx.core.g.z;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  private Rect aQJ;
  Drawable dvT;
  Rect dvU;
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209379);
    this.aQJ = new Rect();
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ScrimInsetsFrameLayout, paramInt, a.j.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.dvT = paramContext.getDrawable(a.k.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    z.a(this, new s()
    {
      public final ah a(View paramAnonymousView, ah paramAnonymousah)
      {
        AppMethodBeat.i(209255);
        if (ScrimInsetsFrameLayout.this.dvU == null) {
          ScrimInsetsFrameLayout.this.dvU = new Rect();
        }
        ScrimInsetsFrameLayout.this.dvU.set(paramAnonymousah.Em(), paramAnonymousah.En(), paramAnonymousah.Eo(), paramAnonymousah.Ep());
        ScrimInsetsFrameLayout.this.c(paramAnonymousah);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if ((!paramAnonymousah.Eq()) || (ScrimInsetsFrameLayout.this.dvT == null)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setWillNotDraw(bool);
          z.Q(ScrimInsetsFrameLayout.this);
          paramAnonymousView = paramAnonymousah.Es();
          AppMethodBeat.o(209255);
          return paramAnonymousView;
        }
      }
    });
    AppMethodBeat.o(209379);
  }
  
  protected void c(ah paramah) {}
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209394);
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.dvU != null) && (this.dvT != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.aQJ.set(0, 0, i, this.dvU.top);
      this.dvT.setBounds(this.aQJ);
      this.dvT.draw(paramCanvas);
      this.aQJ.set(0, j - this.dvU.bottom, i, j);
      this.dvT.setBounds(this.aQJ);
      this.dvT.draw(paramCanvas);
      this.aQJ.set(0, this.dvU.top, this.dvU.left, j - this.dvU.bottom);
      this.dvT.setBounds(this.aQJ);
      this.dvT.draw(paramCanvas);
      this.aQJ.set(i - this.dvU.right, this.dvU.top, i, j - this.dvU.bottom);
      this.dvT.setBounds(this.aQJ);
      this.dvT.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    AppMethodBeat.o(209394);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(209405);
    super.onAttachedToWindow();
    if (this.dvT != null) {
      this.dvT.setCallback(this);
    }
    AppMethodBeat.o(209405);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(209414);
    super.onDetachedFromWindow();
    if (this.dvT != null) {
      this.dvT.setCallback(null);
    }
    AppMethodBeat.o(209414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */