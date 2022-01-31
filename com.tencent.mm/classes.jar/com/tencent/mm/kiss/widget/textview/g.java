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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
{
  protected f eLT;
  public a eLU;
  protected StaticLayout eLV;
  protected boolean eLW = false;
  int eLX;
  int eLY;
  private boolean eLZ = false;
  boolean eMa = false;
  boolean eMb = false;
  private boolean eMc = false;
  private View eMd;
  private int eMe = 0;
  private int eMf = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.eMd = paramView;
    this.eLU = parama;
  }
  
  private boolean jQ(int paramInt)
  {
    AppMethodBeat.i(105775);
    if ((this.eLW) || (this.eLT == null) || (this.eLV == null))
    {
      if (this.eLU == null)
      {
        AppMethodBeat.o(105775);
        return false;
      }
      if (paramInt > 0)
      {
        SN();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.eLT = d.a(this.text, paramInt, this.eLU).SK();
        this.eLV = this.eLT.eLR;
        this.eLW = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          ab.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
        }
        AppMethodBeat.o(105775);
        return true;
      }
    }
    AppMethodBeat.o(105775);
    return false;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(105760);
    if ((paramFloat != 0.0F) && (this.eLU != null) && (paramFloat != this.eLU.textSize))
    {
      this.eLU.textSize = paramFloat;
      this.eLW = true;
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(105760);
  }
  
  final void SN()
  {
    this.eMf = 0;
    this.eMe = 0;
    this.eLX = 0;
    this.eLY = 0;
  }
  
  public final Point cj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105776);
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    jQ(i);
    if (this.eLV != null) {
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
            break label598;
          }
          localObject2 = "";
          label126:
          ab.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(105776);
        return localObject1;
        paramInt1 = 0;
        if (this.eLU.eLG == null)
        {
          localObject1 = this.eLV;
          if (this.eMe == 0) {
            break label293;
          }
          paramInt1 = this.eMe;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.eLV.getText(), this.eLV.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            ab.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
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
          this.eMe = ((int)Math.ceil(f));
          this.eMe += this.eMd.getPaddingLeft() + this.eMd.getPaddingRight();
          paramInt1 = this.eMe;
        }
        localObject1 = this.eLV;
        if (this.eMf == 0) {
          break label460;
        }
        i = this.eMf;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.eLT.maxLines > 0)
      {
        paramInt2 = i;
        if (this.eLT.maxLines < i) {
          paramInt2 = this.eLT.maxLines;
        }
      }
      int k = this.eMd.getPaddingTop();
      n = this.eMd.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.eLU.minLines > 0) && (paramInt2 < this.eLU.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.eLU.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.eMf = (paramInt2 + (k + n));
        i = this.eMf;
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
    return this.eLT;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(105770);
    if (this.eLV == null)
    {
      AppMethodBeat.o(105770);
      return 0;
    }
    int i = this.eLV.getLineCount();
    AppMethodBeat.o(105770);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(105766);
    TextPaint localTextPaint2 = this.eLT.eLR.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.eLU.eLQ;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.eLU.eLK + this.eLU.eLJ);
    AppMethodBeat.o(105766);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.eLU != null) {
      return this.eLU.maxLines;
    }
    return -1;
  }
  
  public final int getSelectionEnd()
  {
    AppMethodBeat.i(105772);
    if (this.text == null)
    {
      AppMethodBeat.o(105772);
      return -1;
    }
    int i = Selection.getSelectionEnd(this.text);
    AppMethodBeat.o(105772);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(105771);
    if (this.text == null)
    {
      AppMethodBeat.o(105771);
      return -1;
    }
    int i = Selection.getSelectionStart(this.text);
    AppMethodBeat.o(105771);
    return i;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(105769);
    if (this.eLT == null)
    {
      if (this.eLU != null)
      {
        i = this.eLU.textColor;
        AppMethodBeat.o(105769);
        return i;
      }
      AppMethodBeat.o(105769);
      return 0;
    }
    int i = this.eLT.eLQ.getColor();
    AppMethodBeat.o(105769);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(105768);
    if (this.eLT == null)
    {
      if (this.eLU != null)
      {
        f = this.eLU.textSize;
        AppMethodBeat.o(105768);
        return f;
      }
      AppMethodBeat.o(105768);
      return 0.0F;
    }
    float f = this.eLT.eLQ.getTextSize();
    AppMethodBeat.o(105768);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.eLV;
  }
  
  public final void init()
  {
    AppMethodBeat.i(105756);
    this.text = "";
    this.eMd.setWillNotDraw(false);
    AppMethodBeat.o(105756);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105774);
    if ((this.eLV == null) || (this.eLT == null))
    {
      boolean bool = jQ(this.eMd.getMeasuredWidth());
      if (h.DEBUG) {
        ab.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.eLV, this.eLT, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.eMd.requestLayout();
        this.eMd.invalidate();
      }
      AppMethodBeat.o(105774);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.eMd.getPaddingLeft();
    int m = this.eMd.getPaddingTop();
    int n = this.eMd.getRight() - this.eMd.getLeft() - this.eMd.getPaddingRight();
    int i1 = this.eMd.getBottom() - this.eMd.getTop() - this.eMd.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.eLX == 0) || (this.eLY == 0))
    {
      j = this.eMd.getPaddingLeft();
      i = this.eMd.getRight() - this.eMd.getLeft() - this.eMd.getPaddingLeft() - this.eMd.getPaddingRight();
      i2 = this.eLV.getWidth();
      if (i2 > i)
      {
        i = j;
        this.eLX = i;
        j = this.eMd.getPaddingTop();
        i2 = this.eMd.getBottom() - this.eMd.getTop() - this.eMd.getPaddingTop() - this.eMd.getPaddingBottom();
        i = 0;
        i3 = this.eLV.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.eLY = i;
      }
    }
    else
    {
      paramCanvas.translate(this.eLX, this.eLY);
      this.eLV.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        ab.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(105774);
      return;
    }
    switch (this.eLT.gravity & 0x800007)
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
    switch (this.eLT.gravity & 0x70)
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
    return (!this.eMc) && (this.eMa);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(105763);
    if ((this.eLU != null) && (paramInt != this.eLU.gravity))
    {
      this.eLU.gravity = paramInt;
      this.eLW = true;
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(105763);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(105758);
    if ((this.eLU.maxLines != paramInt) || (this.eLU.minLines != paramInt))
    {
      this.eLW = true;
      SN();
      this.eLU.maxLines = paramInt;
      this.eLU.minLines = paramInt;
      this.eMd.requestLayout();
      this.eMd.invalidate();
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(105758);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(105764);
    if ((this.eLU != null) && (paramInt != this.eLU.maxLines))
    {
      this.eLU.maxLines = paramInt;
      this.eLW = true;
      SN();
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.eMd.requestLayout();
      this.eMd.invalidate();
    }
    AppMethodBeat.o(105764);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(105765);
    if (this.eLU.minLines != paramInt)
    {
      this.eLU.minLines = paramInt;
      SN();
      this.eMd.requestLayout();
      this.eMd.invalidate();
    }
    AppMethodBeat.o(105765);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.eLU.maxLines != i)
      {
        this.eLU.maxLines = i;
        this.eLW = true;
        SN();
        this.eMd.requestLayout();
        this.eMd.invalidate();
      }
      AppMethodBeat.o(105757);
      return;
    }
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(105767);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(105767);
      return;
    }
    if ((this.text == null) || (!this.text.equals(paramCharSequence)) || (paramBoolean))
    {
      this.text = paramCharSequence;
      this.eLW = true;
      this.eMd.requestLayout();
      this.eMd.invalidate();
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bo.dtY().toString());
      }
    }
    AppMethodBeat.o(105767);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(105762);
    if ((this.eLU != null) && (paramInt != this.eLU.textColor))
    {
      this.eLU.textColor = paramInt;
      this.eLW = true;
      if (h.DEBUG) {
        ab.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(105762);
  }
  
  public final void setTextLayout(f paramf)
  {
    AppMethodBeat.i(105761);
    if ((paramf == null) || (paramf.eLR == null))
    {
      this.eLT = null;
      AppMethodBeat.o(105761);
      return;
    }
    if (this.eLU == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.eLU = new a();
      localb.eLU.maxLines = paramf.maxLines;
      localb.eLU.maxLength = paramf.maxLength;
      localb.eLU.eLQ = paramf.eLQ;
      localb.eLU.eLF = paramf.eLF;
      localb.eLU.eLG = paramf.eLG;
      localb.eLU.gravity = paramf.gravity;
      localb.eLU.textSize = paramf.eLQ.getTextSize();
      localb.eLU.textColor = paramf.eLQ.getColor();
      this.eLU = localb.eLU;
    }
    SN();
    this.eMd.setWillNotDraw(false);
    this.eLT = paramf;
    this.eLV = paramf.eLR;
    this.text = paramf.text;
    this.eLZ = (this.text instanceof Spannable);
    if (this.eLZ)
    {
      this.text = this.eLT.text;
      com.tencent.mm.kiss.widget.textview.b.b.SR();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.eMd.requestLayout();
    this.eMd.invalidate();
    AppMethodBeat.o(105761);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(105759);
    Object localObject = ah.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(105759);
      return;
    }
  }
  
  public final boolean t(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(105773);
    int i;
    boolean bool1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      i = 1;
      bool1 = bool2;
      if (this.eMd.isEnabled())
      {
        bool1 = bool2;
        if (this.eLZ)
        {
          com.tencent.mm.kiss.widget.textview.b.b.SR();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.eMd, this.eLV, (Spannable)this.text, paramMotionEvent);
          this.eMc = bool1;
          if ((!this.eMb) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.eLX) && (f1 <= this.eLV.getWidth() + this.eLX)) {
            break label210;
          }
          i = 0;
          label137:
          if (i == 0) {
            break label250;
          }
          paramMotionEvent = (ClickableSpan[])((Spannable)this.text).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
          if (paramMotionEvent.length <= 0) {
            break label250;
          }
          ab.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.eMd);
          bool1 = true;
        }
      }
    }
    label210:
    label250:
    for (;;)
    {
      AppMethodBeat.o(105773);
      return bool1;
      i = 0;
      break;
      if ((f2 < this.eLY) || (f2 > this.eLV.getHeight() + this.eLY))
      {
        i = 0;
        break label137;
      }
      i = 1;
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */