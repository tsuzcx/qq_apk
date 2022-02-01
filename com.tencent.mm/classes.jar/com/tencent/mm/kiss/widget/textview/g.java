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
  protected CharSequence bba = null;
  protected f mGY;
  public a mGZ;
  protected StaticLayout mHa;
  protected boolean mHb = false;
  int mHc;
  int mHd;
  private boolean mHe = false;
  boolean mHf = false;
  boolean mHg = false;
  private boolean mHh = false;
  private View mHi;
  private int mHj = 0;
  private int mHk = 0;
  
  public g(View paramView, a parama)
  {
    this.mHi = paramView;
    this.mGZ = parama;
  }
  
  private boolean sG(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.mHb) || (this.mGY == null) || (this.mHa == null))
    {
      if (this.mGZ == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        bbO();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.mGY = d.a(this.bba, paramInt, this.mGZ).bbK();
        this.mHa = this.mGY.mGW;
        this.mHb = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          Log.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.bba });
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
    if ((paramFloat != 0.0F) && (this.mGZ != null) && (paramFloat != this.mGZ.textSize))
    {
      this.mGZ.textSize = paramFloat;
      this.mHb = true;
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
    if ((this.bba == null) || (!paramCharSequence.equals(this.bba)) || (paramBoolean))
    {
      this.bba = paramCharSequence;
      this.mHb = true;
      this.mHi.requestLayout();
      this.mHi.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + Util.getStack().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void bbN()
  {
    AppMethodBeat.i(233781);
    if ((this.mGZ.mGP != 0.0F) || (this.mGZ.mGQ != 1.1F))
    {
      this.mGZ.mGP = 0.0F;
      this.mGZ.mGQ = 1.1F;
      this.mHb = true;
      this.mHi.requestLayout();
      this.mHi.invalidate();
    }
    AppMethodBeat.o(233781);
  }
  
  final void bbO()
  {
    this.mHk = 0;
    this.mHj = 0;
    this.mHc = 0;
    this.mHd = 0;
  }
  
  public final Point ed(int paramInt1, int paramInt2)
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
    sG(i);
    if (this.mHa != null) {
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
          CharSequence localCharSequence = this.bba;
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
        if (this.mGZ.bbe == null)
        {
          localObject1 = this.mHa;
          if (this.mHj == 0) {
            break label293;
          }
          paramInt1 = this.mHj;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.mHa.getText(), this.mHa.getPaint()));
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
          this.mHj = ((int)Math.ceil(f));
          this.mHj += this.mHi.getPaddingLeft() + this.mHi.getPaddingRight();
          paramInt1 = this.mHj;
        }
        localObject1 = this.mHa;
        if (this.mHk == 0) {
          break label460;
        }
        i = this.mHk;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.mGY.maxLines > 0)
      {
        paramInt2 = i;
        if (this.mGY.maxLines < i) {
          paramInt2 = this.mGY.maxLines;
        }
      }
      int k = this.mHi.getPaddingTop();
      n = this.mHi.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.mGZ.mHn > 0) && (paramInt2 < this.mGZ.mHn)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.mGZ.mHn - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.mHk = (paramInt2 + (k + n));
        i = this.mHk;
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
    return this.mGY;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.mHa == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.mHa.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.mGY.mGW.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.mGZ.dso;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.mGZ.mGQ + this.mGZ.mGP);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.mGZ != null) {
      return this.mGZ.maxLines;
    }
    return -1;
  }
  
  public final int getSelectionEnd()
  {
    AppMethodBeat.i(141091);
    if (this.bba == null)
    {
      AppMethodBeat.o(141091);
      return -1;
    }
    int i = Selection.getSelectionEnd(this.bba);
    AppMethodBeat.o(141091);
    return i;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(141090);
    if (this.bba == null)
    {
      AppMethodBeat.o(141090);
      return -1;
    }
    int i = Selection.getSelectionStart(this.bba);
    AppMethodBeat.o(141090);
    return i;
  }
  
  public final CharSequence getText()
  {
    return this.bba;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(141088);
    if (this.mGY == null)
    {
      if (this.mGZ != null)
      {
        i = this.mGZ.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.mGY.dso.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.mGY == null)
    {
      if (this.mGZ != null)
      {
        f = this.mGZ.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.mGY.dso.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.mHa;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.bba = "";
    this.mHi.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.mHa == null) || (this.mGY == null))
    {
      boolean bool = sG(this.mHi.getMeasuredWidth());
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.mHa, this.mGY, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.mHi.requestLayout();
        this.mHi.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.mHi.getPaddingLeft();
    int m = this.mHi.getPaddingTop();
    int n = this.mHi.getRight() - this.mHi.getLeft() - this.mHi.getPaddingRight();
    int i1 = this.mHi.getBottom() - this.mHi.getTop() - this.mHi.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.mHc == 0) || (this.mHd == 0))
    {
      j = this.mHi.getPaddingLeft();
      i = this.mHi.getRight() - this.mHi.getLeft() - this.mHi.getPaddingLeft() - this.mHi.getPaddingRight();
      i2 = this.mHa.getWidth();
      if (i2 > i)
      {
        i = j;
        this.mHc = i;
        j = this.mHi.getPaddingTop();
        i2 = this.mHi.getBottom() - this.mHi.getTop() - this.mHi.getPaddingTop() - this.mHi.getPaddingBottom();
        i = 0;
        i3 = this.mHa.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.mHd = i;
      }
    }
    else
    {
      paramCanvas.translate(this.mHc, this.mHd);
      this.mHa.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.bba, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.mGY.fl & 0x800007)
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
    switch (this.mGY.fl & 0x70)
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
    return (!this.mHh) && (this.mHf);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(141082);
    if ((this.mGZ != null) && (paramInt != this.mGZ.fl))
    {
      this.mGZ.fl = paramInt;
      this.mHb = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.mGZ.maxLines != paramInt) || (this.mGZ.mHn != paramInt))
    {
      this.mHb = true;
      bbO();
      this.mGZ.maxLines = paramInt;
      this.mGZ.mHn = paramInt;
      this.mHi.requestLayout();
      this.mHi.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.mGZ != null) && (paramInt != this.mGZ.maxLines))
    {
      this.mGZ.maxLines = paramInt;
      this.mHb = true;
      bbO();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.mHi.requestLayout();
      this.mHi.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.mGZ.mHn != paramInt)
    {
      this.mGZ.mHn = paramInt;
      bbO();
      this.mHi.requestLayout();
      this.mHi.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.mGZ.maxLines != i)
      {
        this.mGZ.maxLines = i;
        this.mHb = true;
        bbO();
        this.mHi.requestLayout();
        this.mHi.invalidate();
      }
      AppMethodBeat.o(141076);
      return;
    }
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.mGZ != null) && (paramInt != this.mGZ.textColor))
    {
      this.mGZ.textColor = paramInt;
      this.mHb = true;
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
    if ((paramf == null) || (paramf.mGW == null))
    {
      this.mGY = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.mGZ == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.mGZ = new a();
      localb.mGZ.maxLines = paramf.maxLines;
      localb.mGZ.maxLength = paramf.maxLength;
      localb.mGZ.dso = paramf.dso;
      localb.mGZ.bbd = paramf.bbd;
      localb.mGZ.bbe = paramf.bbe;
      localb.mGZ.fl = paramf.fl;
      localb.mGZ.textSize = paramf.dso.getTextSize();
      localb.mGZ.textColor = paramf.dso.getColor();
      localb.mGZ.bbl = paramf.bbl;
      this.mGZ = localb.mGZ;
    }
    bbO();
    this.mHi.setWillNotDraw(false);
    this.mGY = paramf;
    this.mHa = paramf.mGW;
    this.bba = paramf.bba;
    this.mHe = (this.bba instanceof Spannable);
    if (this.mHe)
    {
      this.bba = this.mGY.bba;
      com.tencent.mm.kiss.widget.textview.b.b.bbV();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.bba);
    }
    if (this.bba == null) {
      if (paramf.bba != null) {
        break label339;
      }
    }
    label339:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.mGY.bba == null) {
        bool2 = true;
      }
      Log.e("MicroMsg.StaticTextViewHolder", "text is null, [%b, %b, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Util.getStack() });
      this.mHi.requestLayout();
      this.mHi.invalidate();
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
  
  public final boolean w(MotionEvent paramMotionEvent)
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
      if (this.mHi.isEnabled())
      {
        bool1 = bool2;
        if (this.mHe)
        {
          com.tencent.mm.kiss.widget.textview.b.b.bbV();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.mHi, this.mHa, (Spannable)this.bba, paramMotionEvent);
          this.mHh = bool1;
          if ((!this.mHg) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.mHc) && (f1 <= this.mHa.getWidth() + this.mHc)) {
            break label210;
          }
          i = 0;
          label137:
          if (i == 0) {
            break label250;
          }
          paramMotionEvent = (ClickableSpan[])((Spannable)this.bba).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
          if (paramMotionEvent.length <= 0) {
            break label250;
          }
          Log.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.mHi);
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
      if ((f2 < this.mHd) || (f2 > this.mHa.getHeight() + this.mHd))
      {
        i = 0;
        break label137;
      }
      i = 1;
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */