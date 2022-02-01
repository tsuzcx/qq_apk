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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
{
  protected f glE;
  public a glF;
  protected StaticLayout glG;
  protected boolean glH = false;
  int glI;
  int glJ;
  private boolean glK = false;
  boolean glL = false;
  boolean glM = false;
  private boolean glN = false;
  private View glO;
  private int glP = 0;
  private int glQ = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.glO = paramView;
    this.glF = parama;
  }
  
  private boolean mt(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.glH) || (this.glE == null) || (this.glG == null))
    {
      if (this.glF == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        ahX();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.glE = d.a(this.text, paramInt, this.glF).ahU();
        this.glG = this.glE.glC;
        this.glH = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          ac.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
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
    if ((paramFloat != 0.0F) && (this.glF != null) && (paramFloat != this.glF.textSize))
    {
      this.glF.textSize = paramFloat;
      this.glH = true;
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  final void ahX()
  {
    this.glQ = 0;
    this.glP = 0;
    this.glI = 0;
    this.glJ = 0;
  }
  
  public final Point cN(int paramInt1, int paramInt2)
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
    mt(i);
    if (this.glG != null) {
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
          ac.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(141095);
        return localObject1;
        paramInt1 = 0;
        if (this.glF.gls == null)
        {
          localObject1 = this.glG;
          if (this.glP == 0) {
            break label293;
          }
          paramInt1 = this.glP;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.glG.getText(), this.glG.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            ac.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
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
          this.glP = ((int)Math.ceil(f));
          this.glP += this.glO.getPaddingLeft() + this.glO.getPaddingRight();
          paramInt1 = this.glP;
        }
        localObject1 = this.glG;
        if (this.glQ == 0) {
          break label460;
        }
        i = this.glQ;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.glE.maxLines > 0)
      {
        paramInt2 = i;
        if (this.glE.maxLines < i) {
          paramInt2 = this.glE.maxLines;
        }
      }
      int k = this.glO.getPaddingTop();
      n = this.glO.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.glF.minLines > 0) && (paramInt2 < this.glF.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.glF.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.glQ = (paramInt2 + (k + n));
        i = this.glQ;
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
    return this.glE;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.glG == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.glG.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.glE.glC.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.glF.gZ;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.glF.glw + this.glF.glv);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.glF != null) {
      return this.glF.maxLines;
    }
    return -1;
  }
  
  public final int getSelectionEnd()
  {
    AppMethodBeat.i(141091);
    if (this.text == null)
    {
      AppMethodBeat.o(141091);
      return -1;
    }
    int i = Selection.getSelectionEnd(this.text);
    AppMethodBeat.o(141091);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(141090);
    if (this.text == null)
    {
      AppMethodBeat.o(141090);
      return -1;
    }
    int i = Selection.getSelectionStart(this.text);
    AppMethodBeat.o(141090);
    return i;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(141088);
    if (this.glE == null)
    {
      if (this.glF != null)
      {
        i = this.glF.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.glE.gZ.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.glE == null)
    {
      if (this.glF != null)
      {
        f = this.glF.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.glE.gZ.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.glG;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.text = "";
    this.glO.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.glG == null) || (this.glE == null))
    {
      boolean bool = mt(this.glO.getMeasuredWidth());
      if (h.DEBUG) {
        ac.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.glG, this.glE, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.glO.requestLayout();
        this.glO.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.glO.getPaddingLeft();
    int m = this.glO.getPaddingTop();
    int n = this.glO.getRight() - this.glO.getLeft() - this.glO.getPaddingRight();
    int i1 = this.glO.getBottom() - this.glO.getTop() - this.glO.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.glI == 0) || (this.glJ == 0))
    {
      j = this.glO.getPaddingLeft();
      i = this.glO.getRight() - this.glO.getLeft() - this.glO.getPaddingLeft() - this.glO.getPaddingRight();
      i2 = this.glG.getWidth();
      if (i2 > i)
      {
        i = j;
        this.glI = i;
        j = this.glO.getPaddingTop();
        i2 = this.glO.getBottom() - this.glO.getTop() - this.glO.getPaddingTop() - this.glO.getPaddingBottom();
        i = 0;
        i3 = this.glG.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.glJ = i;
      }
    }
    else
    {
      paramCanvas.translate(this.glI, this.glJ);
      this.glG.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        ac.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.glE.gravity & 0x800007)
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
    switch (this.glE.gravity & 0x70)
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
    return (!this.glN) && (this.glL);
  }
  
  public final boolean s(MotionEvent paramMotionEvent)
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
      if (this.glO.isEnabled())
      {
        bool1 = bool2;
        if (this.glK)
        {
          com.tencent.mm.kiss.widget.textview.b.b.aib();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.glO, this.glG, (Spannable)this.text, paramMotionEvent);
          this.glN = bool1;
          if ((!this.glM) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.glI) && (f1 <= this.glG.getWidth() + this.glI)) {
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
          ac.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.glO);
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
      if ((f2 < this.glJ) || (f2 > this.glG.getHeight() + this.glJ))
      {
        i = 0;
        break label137;
      }
      i = 1;
      break label137;
    }
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(141082);
    if ((this.glF != null) && (paramInt != this.glF.gravity))
    {
      this.glF.gravity = paramInt;
      this.glH = true;
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.glF.maxLines != paramInt) || (this.glF.minLines != paramInt))
    {
      this.glH = true;
      ahX();
      this.glF.maxLines = paramInt;
      this.glF.minLines = paramInt;
      this.glO.requestLayout();
      this.glO.invalidate();
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.glF != null) && (paramInt != this.glF.maxLines))
    {
      this.glF.maxLines = paramInt;
      this.glH = true;
      ahX();
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.glO.requestLayout();
      this.glO.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.glF.minLines != paramInt)
    {
      this.glF.minLines = paramInt;
      ahX();
      this.glO.requestLayout();
      this.glO.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.glF.maxLines != i)
      {
        this.glF.maxLines = i;
        this.glH = true;
        ahX();
        this.glO.requestLayout();
        this.glO.invalidate();
      }
      AppMethodBeat.o(141076);
      return;
    }
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(141086);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(141086);
      return;
    }
    if ((this.text == null) || (!this.text.equals(paramCharSequence)) || (paramBoolean))
    {
      this.text = paramCharSequence;
      this.glH = true;
      this.glO.requestLayout();
      this.glO.invalidate();
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bs.eWi().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.glF != null) && (paramInt != this.glF.textColor))
    {
      this.glF.textColor = paramInt;
      this.glH = true;
      if (h.DEBUG) {
        ac.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141081);
  }
  
  public final void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141080);
    if ((paramf == null) || (paramf.glC == null))
    {
      this.glE = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.glF == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.glF = new a();
      localb.glF.maxLines = paramf.maxLines;
      localb.glF.maxLength = paramf.maxLength;
      localb.glF.gZ = paramf.gZ;
      localb.glF.glr = paramf.glr;
      localb.glF.gls = paramf.gls;
      localb.glF.gravity = paramf.gravity;
      localb.glF.textSize = paramf.gZ.getTextSize();
      localb.glF.textColor = paramf.gZ.getColor();
      this.glF = localb.glF;
    }
    ahX();
    this.glO.setWillNotDraw(false);
    this.glE = paramf;
    this.glG = paramf.glC;
    this.text = paramf.text;
    this.glK = (this.text instanceof Spannable);
    if (this.glK)
    {
      this.text = this.glE.text;
      com.tencent.mm.kiss.widget.textview.b.b.aib();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.glO.requestLayout();
    this.glO.invalidate();
    AppMethodBeat.o(141080);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141078);
    Object localObject = ai.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(141078);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */