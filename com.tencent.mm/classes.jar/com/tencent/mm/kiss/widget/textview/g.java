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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  protected f gHV;
  public a gHW;
  protected StaticLayout gHX;
  protected boolean gHY = false;
  int gHZ;
  int gIa;
  private boolean gIb = false;
  boolean gIc = false;
  boolean gId = false;
  private boolean gIe = false;
  private View gIf;
  private int gIg = 0;
  private int gIh = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.gIf = paramView;
    this.gHW = parama;
  }
  
  private boolean mV(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.gHY) || (this.gHV == null) || (this.gHX == null))
    {
      if (this.gHW == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        akX();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.gHV = d.a(this.text, paramInt, this.gHW).akU();
        this.gHX = this.gHV.gHT;
        this.gHY = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          ae.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
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
    if ((paramFloat != 0.0F) && (this.gHW != null) && (paramFloat != this.gHW.textSize))
    {
      this.gHW.textSize = paramFloat;
      this.gHY = true;
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  final void akX()
  {
    this.gIh = 0;
    this.gIg = 0;
    this.gHZ = 0;
    this.gIa = 0;
  }
  
  public final Point cP(int paramInt1, int paramInt2)
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
    mV(i);
    if (this.gHX != null) {
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
          ae.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(141095);
        return localObject1;
        paramInt1 = 0;
        if (this.gHW.gHJ == null)
        {
          localObject1 = this.gHX;
          if (this.gIg == 0) {
            break label293;
          }
          paramInt1 = this.gIg;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.gHX.getText(), this.gHX.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            ae.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
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
          this.gIg = ((int)Math.ceil(f));
          this.gIg += this.gIf.getPaddingLeft() + this.gIf.getPaddingRight();
          paramInt1 = this.gIg;
        }
        localObject1 = this.gHX;
        if (this.gIh == 0) {
          break label460;
        }
        i = this.gIh;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.gHV.maxLines > 0)
      {
        paramInt2 = i;
        if (this.gHV.maxLines < i) {
          paramInt2 = this.gHV.maxLines;
        }
      }
      int k = this.gIf.getPaddingTop();
      n = this.gIf.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.gHW.minLines > 0) && (paramInt2 < this.gHW.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.gHW.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.gIh = (paramInt2 + (k + n));
        i = this.gIh;
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
    return this.gHV;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.gHX == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.gHX.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.gHV.gHT.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.gHW.iU;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.gHW.gHN + this.gHW.gHM);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.gHW != null) {
      return this.gHW.maxLines;
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
    if (this.gHV == null)
    {
      if (this.gHW != null)
      {
        i = this.gHW.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.gHV.iU.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.gHV == null)
    {
      if (this.gHW != null)
      {
        f = this.gHW.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.gHV.iU.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.gHX;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.text = "";
    this.gIf.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.gHX == null) || (this.gHV == null))
    {
      boolean bool = mV(this.gIf.getMeasuredWidth());
      if (h.DEBUG) {
        ae.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.gHX, this.gHV, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.gIf.requestLayout();
        this.gIf.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.gIf.getPaddingLeft();
    int m = this.gIf.getPaddingTop();
    int n = this.gIf.getRight() - this.gIf.getLeft() - this.gIf.getPaddingRight();
    int i1 = this.gIf.getBottom() - this.gIf.getTop() - this.gIf.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.gHZ == 0) || (this.gIa == 0))
    {
      j = this.gIf.getPaddingLeft();
      i = this.gIf.getRight() - this.gIf.getLeft() - this.gIf.getPaddingLeft() - this.gIf.getPaddingRight();
      i2 = this.gHX.getWidth();
      if (i2 > i)
      {
        i = j;
        this.gHZ = i;
        j = this.gIf.getPaddingTop();
        i2 = this.gIf.getBottom() - this.gIf.getTop() - this.gIf.getPaddingTop() - this.gIf.getPaddingBottom();
        i = 0;
        i3 = this.gHX.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.gIa = i;
      }
    }
    else
    {
      paramCanvas.translate(this.gHZ, this.gIa);
      this.gHX.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        ae.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.gHV.gravity & 0x800007)
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
    switch (this.gHV.gravity & 0x70)
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
    return (!this.gIe) && (this.gIc);
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
      if (this.gIf.isEnabled())
      {
        bool1 = bool2;
        if (this.gIb)
        {
          com.tencent.mm.kiss.widget.textview.b.b.alc();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.gIf, this.gHX, (Spannable)this.text, paramMotionEvent);
          this.gIe = bool1;
          if ((!this.gId) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.gHZ) && (f1 <= this.gHX.getWidth() + this.gHZ)) {
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
          ae.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.gIf);
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
      if ((f2 < this.gIa) || (f2 > this.gHX.getHeight() + this.gIa))
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
    if ((this.gHW != null) && (paramInt != this.gHW.gravity))
    {
      this.gHW.gravity = paramInt;
      this.gHY = true;
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.gHW.maxLines != paramInt) || (this.gHW.minLines != paramInt))
    {
      this.gHY = true;
      akX();
      this.gHW.maxLines = paramInt;
      this.gHW.minLines = paramInt;
      this.gIf.requestLayout();
      this.gIf.invalidate();
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.gHW != null) && (paramInt != this.gHW.maxLines))
    {
      this.gHW.maxLines = paramInt;
      this.gHY = true;
      akX();
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.gIf.requestLayout();
      this.gIf.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.gHW.minLines != paramInt)
    {
      this.gHW.minLines = paramInt;
      akX();
      this.gIf.requestLayout();
      this.gIf.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.gHW.maxLines != i)
      {
        this.gHW.maxLines = i;
        this.gHY = true;
        akX();
        this.gIf.requestLayout();
        this.gIf.invalidate();
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
      this.gHY = true;
      this.gIf.requestLayout();
      this.gIf.invalidate();
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bu.fpN().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.gHW != null) && (paramInt != this.gHW.textColor))
    {
      this.gHW.textColor = paramInt;
      this.gHY = true;
      if (h.DEBUG) {
        ae.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141081);
  }
  
  public final void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141080);
    if ((paramf == null) || (paramf.gHT == null))
    {
      this.gHV = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.gHW == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.gHW = new a();
      localb.gHW.maxLines = paramf.maxLines;
      localb.gHW.maxLength = paramf.maxLength;
      localb.gHW.iU = paramf.iU;
      localb.gHW.gHI = paramf.gHI;
      localb.gHW.gHJ = paramf.gHJ;
      localb.gHW.gravity = paramf.gravity;
      localb.gHW.textSize = paramf.iU.getTextSize();
      localb.gHW.textColor = paramf.iU.getColor();
      localb.gHW.breakStrategy = paramf.breakStrategy;
      this.gHW = localb.gHW;
    }
    akX();
    this.gIf.setWillNotDraw(false);
    this.gHV = paramf;
    this.gHX = paramf.gHT;
    this.text = paramf.text;
    this.gIb = (this.text instanceof Spannable);
    if (this.gIb)
    {
      this.text = this.gHV.text;
      com.tencent.mm.kiss.widget.textview.b.b.alc();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.gIf.requestLayout();
    this.gIf.invalidate();
    AppMethodBeat.o(141080);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141078);
    Object localObject = ak.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(141078);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */