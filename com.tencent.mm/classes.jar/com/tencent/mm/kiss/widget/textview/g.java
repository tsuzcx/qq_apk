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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
{
  protected f ggY;
  public a ggZ;
  protected StaticLayout gha;
  protected boolean ghb = false;
  int ghc;
  int ghd;
  private boolean ghe = false;
  boolean ghf = false;
  boolean ghg = false;
  private boolean ghh = false;
  private View ghi;
  private int ghj = 0;
  private int ghk = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.ghi = paramView;
    this.ggZ = parama;
  }
  
  private boolean mu(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.ghb) || (this.ggY == null) || (this.gha == null))
    {
      if (this.ggZ == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        agG();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.ggY = d.a(this.text, paramInt, this.ggZ).agD();
        this.gha = this.ggY.ggW;
        this.ghb = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          ad.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
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
    if ((paramFloat != 0.0F) && (this.ggZ != null) && (paramFloat != this.ggZ.textSize))
    {
      this.ggZ.textSize = paramFloat;
      this.ghb = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  final void agG()
  {
    this.ghk = 0;
    this.ghj = 0;
    this.ghc = 0;
    this.ghd = 0;
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
    mu(i);
    if (this.gha != null) {
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
          ad.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(141095);
        return localObject1;
        paramInt1 = 0;
        if (this.ggZ.ggM == null)
        {
          localObject1 = this.gha;
          if (this.ghj == 0) {
            break label293;
          }
          paramInt1 = this.ghj;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.gha.getText(), this.gha.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            ad.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
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
          this.ghj = ((int)Math.ceil(f));
          this.ghj += this.ghi.getPaddingLeft() + this.ghi.getPaddingRight();
          paramInt1 = this.ghj;
        }
        localObject1 = this.gha;
        if (this.ghk == 0) {
          break label460;
        }
        i = this.ghk;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.ggY.maxLines > 0)
      {
        paramInt2 = i;
        if (this.ggY.maxLines < i) {
          paramInt2 = this.ggY.maxLines;
        }
      }
      int k = this.ghi.getPaddingTop();
      n = this.ghi.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.ggZ.minLines > 0) && (paramInt2 < this.ggZ.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.ggZ.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.ghk = (paramInt2 + (k + n));
        i = this.ghk;
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
    return this.ggY;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.gha == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.gha.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.ggY.ggW.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.ggZ.ga;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.ggZ.ggQ + this.ggZ.ggP);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.ggZ != null) {
      return this.ggZ.maxLines;
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
    if (this.ggY == null)
    {
      if (this.ggZ != null)
      {
        i = this.ggZ.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.ggY.ga.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.ggY == null)
    {
      if (this.ggZ != null)
      {
        f = this.ggZ.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.ggY.ga.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.gha;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.text = "";
    this.ghi.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.gha == null) || (this.ggY == null))
    {
      boolean bool = mu(this.ghi.getMeasuredWidth());
      if (h.DEBUG) {
        ad.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.gha, this.ggY, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.ghi.requestLayout();
        this.ghi.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.ghi.getPaddingLeft();
    int m = this.ghi.getPaddingTop();
    int n = this.ghi.getRight() - this.ghi.getLeft() - this.ghi.getPaddingRight();
    int i1 = this.ghi.getBottom() - this.ghi.getTop() - this.ghi.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.ghc == 0) || (this.ghd == 0))
    {
      j = this.ghi.getPaddingLeft();
      i = this.ghi.getRight() - this.ghi.getLeft() - this.ghi.getPaddingLeft() - this.ghi.getPaddingRight();
      i2 = this.gha.getWidth();
      if (i2 > i)
      {
        i = j;
        this.ghc = i;
        j = this.ghi.getPaddingTop();
        i2 = this.ghi.getBottom() - this.ghi.getTop() - this.ghi.getPaddingTop() - this.ghi.getPaddingBottom();
        i = 0;
        i3 = this.gha.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.ghd = i;
      }
    }
    else
    {
      paramCanvas.translate(this.ghc, this.ghd);
      this.gha.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        ad.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.ggY.gravity & 0x800007)
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
    switch (this.ggY.gravity & 0x70)
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
    return (!this.ghh) && (this.ghf);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(141082);
    if ((this.ggZ != null) && (paramInt != this.ggZ.gravity))
    {
      this.ggZ.gravity = paramInt;
      this.ghb = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.ggZ.maxLines != paramInt) || (this.ggZ.minLines != paramInt))
    {
      this.ghb = true;
      agG();
      this.ggZ.maxLines = paramInt;
      this.ggZ.minLines = paramInt;
      this.ghi.requestLayout();
      this.ghi.invalidate();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.ggZ != null) && (paramInt != this.ggZ.maxLines))
    {
      this.ggZ.maxLines = paramInt;
      this.ghb = true;
      agG();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.ghi.requestLayout();
      this.ghi.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.ggZ.minLines != paramInt)
    {
      this.ggZ.minLines = paramInt;
      agG();
      this.ghi.requestLayout();
      this.ghi.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.ggZ.maxLines != i)
      {
        this.ggZ.maxLines = i;
        this.ghb = true;
        agG();
        this.ghi.requestLayout();
        this.ghi.invalidate();
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
      this.ghb = true;
      this.ghi.requestLayout();
      this.ghi.invalidate();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bt.eGN().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.ggZ != null) && (paramInt != this.ggZ.textColor))
    {
      this.ggZ.textColor = paramInt;
      this.ghb = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141081);
  }
  
  public final void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141080);
    if ((paramf == null) || (paramf.ggW == null))
    {
      this.ggY = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.ggZ == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.ggZ = new a();
      localb.ggZ.maxLines = paramf.maxLines;
      localb.ggZ.maxLength = paramf.maxLength;
      localb.ggZ.ga = paramf.ga;
      localb.ggZ.ggL = paramf.ggL;
      localb.ggZ.ggM = paramf.ggM;
      localb.ggZ.gravity = paramf.gravity;
      localb.ggZ.textSize = paramf.ga.getTextSize();
      localb.ggZ.textColor = paramf.ga.getColor();
      this.ggZ = localb.ggZ;
    }
    agG();
    this.ghi.setWillNotDraw(false);
    this.ggY = paramf;
    this.gha = paramf.ggW;
    this.text = paramf.text;
    this.ghe = (this.text instanceof Spannable);
    if (this.ghe)
    {
      this.text = this.ggY.text;
      com.tencent.mm.kiss.widget.textview.b.b.agK();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.ghi.requestLayout();
    this.ghi.invalidate();
    AppMethodBeat.o(141080);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141078);
    Object localObject = aj.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(141078);
      return;
    }
  }
  
  public final boolean u(MotionEvent paramMotionEvent)
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
      if (this.ghi.isEnabled())
      {
        bool1 = bool2;
        if (this.ghe)
        {
          com.tencent.mm.kiss.widget.textview.b.b.agK();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.ghi, this.gha, (Spannable)this.text, paramMotionEvent);
          this.ghh = bool1;
          if ((!this.ghg) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.ghc) && (f1 <= this.gha.getWidth() + this.ghc)) {
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
          ad.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.ghi);
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
      if ((f2 < this.ghd) || (f2 > this.gha.getHeight() + this.ghd))
      {
        i = 0;
        break label137;
      }
      i = 1;
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */