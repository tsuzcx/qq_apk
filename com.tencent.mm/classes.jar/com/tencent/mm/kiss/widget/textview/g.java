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
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  protected f dOl;
  public a dOm;
  protected StaticLayout dOn;
  protected boolean dOo = false;
  int dOp;
  int dOq;
  private boolean dOr = false;
  boolean dOs = false;
  boolean dOt = false;
  private boolean dOu = false;
  private View dOv;
  private int dOw = 0;
  private int dOx = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.dOv = paramView;
    this.dOm = parama;
  }
  
  private boolean hz(int paramInt)
  {
    if ((this.dOo) || (this.dOl == null) || (this.dOn == null))
    {
      if (this.dOm == null) {
        return false;
      }
      if (paramInt > 0)
      {
        EI();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.dOl = d.a(this.text, paramInt, this.dOm).EF();
        this.dOn = this.dOl.dOj;
        this.dOo = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          y.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
        }
        return true;
      }
    }
    return false;
  }
  
  final void EI()
  {
    this.dOx = 0;
    this.dOw = 0;
    this.dOp = 0;
    this.dOq = 0;
  }
  
  public final Point bf(int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    hz(i);
    if (this.dOn != null) {
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
          CharSequence localCharSequence = this.text;
          if (localObject1 != null) {
            break label588;
          }
          localObject2 = "";
          label121:
          y.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        return localObject1;
        paramInt1 = 0;
        if (this.dOm.dNY == null)
        {
          localObject1 = this.dOn;
          if (this.dOw == 0) {
            break label283;
          }
          paramInt1 = this.dOw;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.dOn.getText(), this.dOn.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            y.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
          }
          if (n != -2147483648) {
            break label604;
          }
          paramInt1 = Math.min(i, paramInt2);
          break;
          label283:
          paramInt2 = ((Layout)localObject1).getLineCount();
          localObject2 = ((Layout)localObject1).getText();
          float f = 0.0F;
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramInt2 - 1) {
              break label340;
            }
            if (((CharSequence)localObject2).charAt(((Layout)localObject1).getLineEnd(paramInt1) - 1) != '\n')
            {
              paramInt1 = -1;
              break;
            }
            paramInt1 += 1;
          }
          label340:
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            f = Math.max(f, ((Layout)localObject1).getLineWidth(paramInt1));
            paramInt1 += 1;
          }
          this.dOw = ((int)Math.ceil(f));
          this.dOw += this.dOv.getPaddingLeft() + this.dOv.getPaddingRight();
          paramInt1 = this.dOw;
        }
        localObject1 = this.dOn;
        if (this.dOx == 0) {
          break label450;
        }
        i = this.dOx;
        label429:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label450:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.dOl.maxLines > 0)
      {
        paramInt2 = i;
        if (this.dOl.maxLines < i) {
          paramInt2 = this.dOl.maxLines;
        }
      }
      int k = this.dOv.getPaddingTop();
      n = this.dOv.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.dOm.minLines > 0) && (paramInt2 < this.dOm.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.dOm.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.dOx = (paramInt2 + (k + n));
        i = this.dOx;
        break label429;
        localObject1 = null;
        break;
        label588:
        localObject2 = ((Point)localObject1).toString();
        break label121;
      }
      label604:
      paramInt1 = paramInt2;
    }
  }
  
  public final f getLayoutWrapper()
  {
    return this.dOl;
  }
  
  public final int getLineCount()
  {
    if (this.dOn == null) {
      return 0;
    }
    return this.dOn.getLineCount();
  }
  
  public final int getLineHeight()
  {
    TextPaint localTextPaint2 = this.dOl.dOj.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.dOm.dOi;
    }
    return Math.round(localTextPaint1.getFontMetricsInt(null) * this.dOm.dOc + this.dOm.dOb);
  }
  
  public final int getMaxLines()
  {
    if (this.dOm != null) {
      return this.dOm.maxLines;
    }
    return -1;
  }
  
  public final int getSelectionEnd()
  {
    if (this.text == null) {
      return -1;
    }
    return Selection.getSelectionEnd(this.text);
  }
  
  public final int getSelectionStart()
  {
    if (this.text == null) {
      return -1;
    }
    return Selection.getSelectionStart(this.text);
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    if (this.dOl == null)
    {
      if (this.dOm != null) {
        return this.dOm.textColor;
      }
      return 0;
    }
    return this.dOl.dOi.getColor();
  }
  
  public final float getTextSize()
  {
    if (this.dOl == null)
    {
      if (this.dOm != null) {
        return this.dOm.dOB;
      }
      return 0.0F;
    }
    return this.dOl.dOi.getTextSize();
  }
  
  public final Layout getTvLayout()
  {
    return this.dOn;
  }
  
  public final void init()
  {
    this.text = "";
    this.dOv.setWillNotDraw(false);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if ((this.dOn == null) || (this.dOl == null))
    {
      boolean bool = hz(this.dOv.getMeasuredWidth());
      if (h.DEBUG) {
        y.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.dOn, this.dOl, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.dOv.requestLayout();
        this.dOv.invalidate();
      }
    }
    long l;
    int k;
    int m;
    int n;
    int i1;
    int j;
    int i;
    int i2;
    int i3;
    do
    {
      return;
      l = 0L;
      if (h.DEBUG) {
        l = System.nanoTime();
      }
      paramCanvas.save();
      k = this.dOv.getPaddingLeft();
      m = this.dOv.getPaddingTop();
      n = this.dOv.getRight() - this.dOv.getLeft() - this.dOv.getPaddingRight();
      i1 = this.dOv.getBottom() - this.dOv.getTop() - this.dOv.getPaddingBottom();
      paramCanvas.clipRect(k, m, n, i1);
      if ((this.dOp == 0) || (this.dOq == 0))
      {
        j = this.dOv.getPaddingLeft();
        i = this.dOv.getRight() - this.dOv.getLeft() - this.dOv.getPaddingLeft() - this.dOv.getPaddingRight();
        i2 = this.dOn.getWidth();
        if (i2 <= i) {
          break;
        }
        i = j;
        this.dOp = i;
        j = this.dOv.getPaddingTop();
        i2 = this.dOv.getBottom() - this.dOv.getTop() - this.dOv.getPaddingTop() - this.dOv.getPaddingBottom();
        i = 0;
        i3 = this.dOn.getHeight();
        if (i3 <= i2) {
          break label550;
        }
        i = j;
        this.dOq = i;
      }
      paramCanvas.translate(this.dOp, this.dOq);
      this.dOn.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
    } while (!h.DEBUG);
    y.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
    return;
    switch (this.dOl.gravity & 0x800007)
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
    label550:
    switch (this.dOl.gravity & 0x70)
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
    return (!this.dOu) && (this.dOs);
  }
  
  public final boolean r(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      i = 1;
      bool1 = bool2;
      if (this.dOv.isEnabled())
      {
        bool1 = bool2;
        if (this.dOr)
        {
          com.tencent.mm.kiss.widget.textview.b.b.EK();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.dOv, this.dOn, (Spannable)this.text, paramMotionEvent);
          this.dOu = bool1;
          if ((!this.dOt) || (i == 0)) {
            break label238;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.dOp) && (f1 <= this.dOn.getWidth() + this.dOp)) {
            break label198;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label238;
      }
      paramMotionEvent = (ClickableSpan[])((Spannable)this.text).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
      if (paramMotionEvent.length <= 0) {
        break label238;
      }
      y.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
      paramMotionEvent[0].onClick(this.dOv);
      bool1 = true;
      return bool1;
      i = 0;
      break;
      label198:
      if ((f2 < this.dOq) || (f2 > this.dOn.getHeight() + this.dOq)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label238:
    return bool1;
  }
  
  public final void setGravity(int paramInt)
  {
    if ((this.dOm != null) && (paramInt != this.dOm.gravity))
    {
      this.dOm.gravity = paramInt;
      this.dOo = true;
      if (h.DEBUG) {
        y.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
  }
  
  public final void setLines(int paramInt)
  {
    if ((this.dOm.maxLines != paramInt) || (this.dOm.minLines != paramInt))
    {
      this.dOo = true;
      EI();
      this.dOm.maxLines = paramInt;
      this.dOm.minLines = paramInt;
      this.dOv.requestLayout();
      this.dOv.invalidate();
      if (h.DEBUG) {
        y.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
  }
  
  public final void setMaxLines(int paramInt)
  {
    if ((this.dOm != null) && (paramInt != this.dOm.maxLines))
    {
      this.dOm.maxLines = paramInt;
      this.dOo = true;
      EI();
      if (h.DEBUG) {
        y.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.dOv.requestLayout();
      this.dOv.invalidate();
    }
  }
  
  public final void setMinLines(int paramInt)
  {
    if (this.dOm.minLines != paramInt)
    {
      this.dOm.minLines = paramInt;
      EI();
      this.dOv.requestLayout();
      this.dOv.invalidate();
    }
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.dOm.maxLines != i)
      {
        this.dOm.maxLines = i;
        this.dOo = true;
        EI();
        this.dOv.requestLayout();
        this.dOv.invalidate();
      }
      return;
    }
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramCharSequence == null) {}
    do
    {
      do
      {
        return;
      } while ((this.text != null) && (this.text.equals(paramCharSequence)) && (!paramBoolean));
      this.text = paramCharSequence;
      this.dOo = true;
      this.dOv.requestLayout();
      this.dOv.invalidate();
    } while (!h.DEBUG);
    y.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bk.csb().toString());
  }
  
  public final void setTextColor(int paramInt)
  {
    if ((this.dOm != null) && (paramInt != this.dOm.textColor))
    {
      this.dOm.textColor = paramInt;
      this.dOo = true;
      if (h.DEBUG) {
        y.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
  }
  
  public final void setTextLayout(f paramf)
  {
    if ((paramf == null) || (paramf.dOj == null))
    {
      this.dOl = null;
      return;
    }
    if (this.dOm == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.dOm = new a();
      localb.dOm.maxLines = paramf.maxLines;
      localb.dOm.maxLength = paramf.maxLength;
      localb.dOm.dOi = paramf.dOi;
      localb.dOm.dNX = paramf.dNX;
      localb.dOm.dNY = paramf.dNY;
      localb.dOm.gravity = paramf.gravity;
      localb.dOm.dOB = paramf.dOi.getTextSize();
      localb.dOm.textColor = paramf.dOi.getColor();
      this.dOm = localb.dOm;
    }
    EI();
    this.dOv.setWillNotDraw(false);
    this.dOl = paramf;
    this.dOn = paramf.dOj;
    this.text = paramf.text;
    this.dOr = (this.text instanceof Spannable);
    if (this.dOr)
    {
      this.text = this.dOl.text;
      com.tencent.mm.kiss.widget.textview.b.b.EK();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.dOv.requestLayout();
    this.dOv.invalidate();
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = ae.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if ((paramFloat != 0.0F) && (this.dOm != null) && (paramFloat != this.dOm.dOB))
      {
        this.dOm.dOB = paramFloat;
        this.dOo = true;
        if (h.DEBUG) {
          y.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */