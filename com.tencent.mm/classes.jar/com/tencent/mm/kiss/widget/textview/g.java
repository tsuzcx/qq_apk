package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  protected CharSequence LV = null;
  protected f kgF;
  public a kgG;
  protected StaticLayout kgH;
  protected boolean kgI = false;
  int kgJ;
  int kgK;
  private boolean kgL = false;
  boolean kgM = false;
  boolean kgN = false;
  private boolean kgO = false;
  private View kgP;
  private int kgQ = 0;
  private int kgR = 0;
  
  public g(View paramView, a parama)
  {
    this.kgP = paramView;
    this.kgG = parama;
  }
  
  private boolean sJ(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.kgI) || (this.kgF == null) || (this.kgH == null))
    {
      if (this.kgG == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        aIR();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.kgF = d.a(this.LV, paramInt, this.kgG).aIO();
        this.kgH = this.kgF.kgD;
        this.kgI = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          Log.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.LV });
        }
        AppMethodBeat.o(141094);
        return true;
      }
    }
    AppMethodBeat.o(141094);
    return false;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(141079);
    if ((paramFloat != 0.0F) && (this.kgG != null) && (paramFloat != this.kgG.textSize))
    {
      this.kgG.textSize = paramFloat;
      this.kgI = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(141086);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(141086);
      return;
    }
    if ((this.LV == null) || (!paramCharSequence.equals(this.LV)) || (paramBoolean))
    {
      this.LV = paramCharSequence;
      this.kgI = true;
      this.kgP.requestLayout();
      this.kgP.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + Util.getStack().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  final void aIR()
  {
    this.kgR = 0;
    this.kgQ = 0;
    this.kgJ = 0;
    this.kgK = 0;
  }
  
  public final Point dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141095);
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    sJ(i);
    if (this.kgH != null) {
      if (n == 1073741824) {
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (m == 1073741824) {
        paramInt2 = j;
      }
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        localObject1 = new Point(paramInt1, paramInt2);
        if (h.DEBUG)
        {
          double d = (System.nanoTime() - l) / 1000000.0D;
          paramInt1 = hashCode();
          CharSequence localCharSequence = this.LV;
          if (localObject1 != null) {
            break label598;
          }
          localObject2 = "";
          label126:
          Log.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(141095);
        return localObject1;
        paramInt1 = 0;
        if (this.kgG.kgs == null)
        {
          localObject1 = this.kgH;
          if (this.kgQ == 0) {
            break label293;
          }
          paramInt1 = this.kgQ;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.kgH.getText(), this.kgH.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            Log.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
          }
          if (n != -2147483648) {
            break label614;
          }
          paramInt1 = Math.min(i, paramInt2);
          break;
          label293:
          paramInt2 = ((Layout)localObject1).getLineCount();
          localObject2 = ((Layout)localObject1).getText();
          float f = 0.0F;
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramInt2 - 1) {
              break label350;
            }
            if (((CharSequence)localObject2).charAt(((Layout)localObject1).getLineEnd(paramInt1) - 1) != '\n')
            {
              paramInt1 = -1;
              break;
            }
            paramInt1 += 1;
          }
          label350:
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            f = Math.max(f, ((Layout)localObject1).getLineWidth(paramInt1));
            paramInt1 += 1;
          }
          this.kgQ = ((int)Math.ceil(f));
          this.kgQ += this.kgP.getPaddingLeft() + this.kgP.getPaddingRight();
          paramInt1 = this.kgQ;
        }
        localObject1 = this.kgH;
        if (this.kgR == 0) {
          break label460;
        }
        i = this.kgR;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.kgF.maxLines > 0)
      {
        paramInt2 = i;
        if (this.kgF.maxLines < i) {
          paramInt2 = this.kgF.maxLines;
        }
      }
      int k = this.kgP.getPaddingTop();
      n = this.kgP.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.kgG.kgU > 0) && (paramInt2 < this.kgG.kgU)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.kgG.kgU - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.kgR = (paramInt2 + (k + n));
        i = this.kgR;
        break label439;
        localObject1 = null;
        break;
        label598:
        localObject2 = ((Point)localObject1).toString();
        break label126;
      }
      label614:
      paramInt1 = paramInt2;
    }
  }
  
  public final f getLayoutWrapper()
  {
    return this.kgF;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.kgH == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.kgH.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.kgF.kgD.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.kgG.bzo;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.kgG.kgw + this.kgG.kgv);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.kgG != null) {
      return this.kgG.maxLines;
    }
    return -1;
  }
  
  public final int getSelectionEnd()
  {
    AppMethodBeat.i(141091);
    if (this.LV == null)
    {
      AppMethodBeat.o(141091);
      return -1;
    }
    int i = Selection.getSelectionEnd(this.LV);
    AppMethodBeat.o(141091);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(141090);
    if (this.LV == null)
    {
      AppMethodBeat.o(141090);
      return -1;
    }
    int i = Selection.getSelectionStart(this.LV);
    AppMethodBeat.o(141090);
    return i;
  }
  
  public final CharSequence getText()
  {
    return this.LV;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(141088);
    if (this.kgF == null)
    {
      if (this.kgG != null)
      {
        i = this.kgG.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.kgF.bzo.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.kgF == null)
    {
      if (this.kgG != null)
      {
        f = this.kgG.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.kgF.bzo.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.kgH;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.LV = "";
    this.kgP.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.kgH == null) || (this.kgF == null))
    {
      boolean bool = sJ(this.kgP.getMeasuredWidth());
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.kgH, this.kgF, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.kgP.requestLayout();
        this.kgP.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.kgP.getPaddingLeft();
    int m = this.kgP.getPaddingTop();
    int n = this.kgP.getRight() - this.kgP.getLeft() - this.kgP.getPaddingRight();
    int i1 = this.kgP.getBottom() - this.kgP.getTop() - this.kgP.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.kgJ == 0) || (this.kgK == 0))
    {
      j = this.kgP.getPaddingLeft();
      i = this.kgP.getRight() - this.kgP.getLeft() - this.kgP.getPaddingLeft() - this.kgP.getPaddingRight();
      i2 = this.kgH.getWidth();
      if (i2 > i)
      {
        i = j;
        this.kgJ = i;
        j = this.kgP.getPaddingTop();
        i2 = this.kgP.getBottom() - this.kgP.getTop() - this.kgP.getPaddingTop() - this.kgP.getPaddingBottom();
        i = 0;
        i3 = this.kgH.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.kgK = i;
      }
    }
    else
    {
      paramCanvas.translate(this.kgJ, this.kgK);
      this.kgH.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.LV, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.kgF.ek & 0x800007)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      i += j;
      break;
      i = 0;
      continue;
      i = i / 2 - i2 / 2;
      continue;
      i -= i2;
    }
    label566:
    switch (this.kgF.ek & 0x70)
    {
    }
    for (;;)
    {
      i += j;
      break;
      i = 0;
      continue;
      i = i2 / 2 - i3 / 2;
      continue;
      i = i2 - i3;
    }
  }
  
  public final boolean performClick()
  {
    return (!this.kgO) && (this.kgM);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(141082);
    if ((this.kgG != null) && (paramInt != this.kgG.ek))
    {
      this.kgG.ek = paramInt;
      this.kgI = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.kgG.maxLines != paramInt) || (this.kgG.kgU != paramInt))
    {
      this.kgI = true;
      aIR();
      this.kgG.maxLines = paramInt;
      this.kgG.kgU = paramInt;
      this.kgP.requestLayout();
      this.kgP.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.kgG != null) && (paramInt != this.kgG.maxLines))
    {
      this.kgG.maxLines = paramInt;
      this.kgI = true;
      aIR();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.kgP.requestLayout();
      this.kgP.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.kgG.kgU != paramInt)
    {
      this.kgG.kgU = paramInt;
      aIR();
      this.kgP.requestLayout();
      this.kgP.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.kgG.maxLines != i)
      {
        this.kgG.maxLines = i;
        this.kgI = true;
        aIR();
        this.kgP.requestLayout();
        this.kgP.invalidate();
      }
      AppMethodBeat.o(141076);
      return;
    }
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.kgG != null) && (paramInt != this.kgG.textColor))
    {
      this.kgG.textColor = paramInt;
      this.kgI = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141081);
  }
  
  public final void setTextLayout(f paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(141080);
    if ((paramf == null) || (paramf.kgD == null))
    {
      this.kgF = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.kgG == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.kgG = new a();
      localb.kgG.maxLines = paramf.maxLines;
      localb.kgG.maxLength = paramf.maxLength;
      localb.kgG.bzo = paramf.bzo;
      localb.kgG.kgr = paramf.kgr;
      localb.kgG.kgs = paramf.kgs;
      localb.kgG.ek = paramf.ek;
      localb.kgG.textSize = paramf.bzo.getTextSize();
      localb.kgG.textColor = paramf.bzo.getColor();
      localb.kgG.kgy = paramf.kgy;
      this.kgG = localb.kgG;
    }
    aIR();
    this.kgP.setWillNotDraw(false);
    this.kgF = paramf;
    this.kgH = paramf.kgD;
    this.LV = paramf.LV;
    this.kgL = (this.LV instanceof Spannable);
    if (this.kgL)
    {
      this.LV = this.kgF.LV;
      com.tencent.mm.kiss.widget.textview.b.b.aIY();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.LV);
    }
    if (this.LV == null) {
      if (paramf.LV != null) {
        break label339;
      }
    }
    label339:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.kgF.LV == null) {
        bool2 = true;
      }
      Log.e("MicroMsg.StaticTextViewHolder", "text is null, [%b, %b, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Util.getStack() });
      this.kgP.requestLayout();
      this.kgP.invalidate();
      AppMethodBeat.o(141080);
      return;
    }
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141078);
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(141078);
      return;
    }
  }
  
  public final boolean x(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(141092);
    int i;
    boolean bool1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      i = 1;
      bool1 = bool2;
      if (this.kgP.isEnabled())
      {
        bool1 = bool2;
        if (this.kgL)
        {
          com.tencent.mm.kiss.widget.textview.b.b.aIY();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.kgP, this.kgH, (Spannable)this.LV, paramMotionEvent);
          this.kgO = bool1;
          if ((!this.kgN) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.kgJ) && (f1 <= this.kgH.getWidth() + this.kgJ)) {
            break label210;
          }
          i = 0;
          label137:
          if (i == 0) {
            break label250;
          }
          paramMotionEvent = (ClickableSpan[])((Spannable)this.LV).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
          if (paramMotionEvent.length <= 0) {
            break label250;
          }
          Log.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.kgP);
          bool1 = true;
        }
      }
    }
    label210:
    label250:
    for (;;)
    {
      AppMethodBeat.o(141092);
      return bool1;
      i = 0;
      break;
      if ((f2 < this.kgK) || (f2 > this.kgH.getHeight() + this.kgK))
      {
        i = 0;
        break label137;
      }
      i = 1;
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */