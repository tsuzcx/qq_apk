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
  private int gFA = 0;
  protected f gFo;
  public a gFp;
  protected StaticLayout gFq;
  protected boolean gFr = false;
  int gFs;
  int gFt;
  private boolean gFu = false;
  boolean gFv = false;
  boolean gFw = false;
  private boolean gFx = false;
  private View gFy;
  private int gFz = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.gFy = paramView;
    this.gFp = parama;
  }
  
  private boolean mS(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.gFr) || (this.gFo == null) || (this.gFq == null))
    {
      if (this.gFp == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        akI();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.gFo = d.a(this.text, paramInt, this.gFp).akF();
        this.gFq = this.gFo.gFm;
        this.gFr = false;
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
    if ((paramFloat != 0.0F) && (this.gFp != null) && (paramFloat != this.gFp.textSize))
    {
      this.gFp.textSize = paramFloat;
      this.gFr = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  final void akI()
  {
    this.gFA = 0;
    this.gFz = 0;
    this.gFs = 0;
    this.gFt = 0;
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
    mS(i);
    if (this.gFq != null) {
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
        if (this.gFp.gFc == null)
        {
          localObject1 = this.gFq;
          if (this.gFz == 0) {
            break label293;
          }
          paramInt1 = this.gFz;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.gFq.getText(), this.gFq.getPaint()));
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
          this.gFz = ((int)Math.ceil(f));
          this.gFz += this.gFy.getPaddingLeft() + this.gFy.getPaddingRight();
          paramInt1 = this.gFz;
        }
        localObject1 = this.gFq;
        if (this.gFA == 0) {
          break label460;
        }
        i = this.gFA;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.gFo.maxLines > 0)
      {
        paramInt2 = i;
        if (this.gFo.maxLines < i) {
          paramInt2 = this.gFo.maxLines;
        }
      }
      int k = this.gFy.getPaddingTop();
      n = this.gFy.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.gFp.minLines > 0) && (paramInt2 < this.gFp.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.gFp.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.gFA = (paramInt2 + (k + n));
        i = this.gFA;
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
    return this.gFo;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.gFq == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.gFq.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.gFo.gFm.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.gFp.iU;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.gFp.gFg + this.gFp.gFf);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.gFp != null) {
      return this.gFp.maxLines;
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
    if (this.gFo == null)
    {
      if (this.gFp != null)
      {
        i = this.gFp.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.gFo.iU.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.gFo == null)
    {
      if (this.gFp != null)
      {
        f = this.gFp.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.gFo.iU.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.gFq;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.text = "";
    this.gFy.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.gFq == null) || (this.gFo == null))
    {
      boolean bool = mS(this.gFy.getMeasuredWidth());
      if (h.DEBUG) {
        ad.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.gFq, this.gFo, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.gFy.requestLayout();
        this.gFy.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.gFy.getPaddingLeft();
    int m = this.gFy.getPaddingTop();
    int n = this.gFy.getRight() - this.gFy.getLeft() - this.gFy.getPaddingRight();
    int i1 = this.gFy.getBottom() - this.gFy.getTop() - this.gFy.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.gFs == 0) || (this.gFt == 0))
    {
      j = this.gFy.getPaddingLeft();
      i = this.gFy.getRight() - this.gFy.getLeft() - this.gFy.getPaddingLeft() - this.gFy.getPaddingRight();
      i2 = this.gFq.getWidth();
      if (i2 > i)
      {
        i = j;
        this.gFs = i;
        j = this.gFy.getPaddingTop();
        i2 = this.gFy.getBottom() - this.gFy.getTop() - this.gFy.getPaddingTop() - this.gFy.getPaddingBottom();
        i = 0;
        i3 = this.gFq.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.gFt = i;
      }
    }
    else
    {
      paramCanvas.translate(this.gFs, this.gFt);
      this.gFq.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        ad.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.gFo.gravity & 0x800007)
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
    switch (this.gFo.gravity & 0x70)
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
    return (!this.gFx) && (this.gFv);
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
      if (this.gFy.isEnabled())
      {
        bool1 = bool2;
        if (this.gFu)
        {
          com.tencent.mm.kiss.widget.textview.b.b.akN();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.gFy, this.gFq, (Spannable)this.text, paramMotionEvent);
          this.gFx = bool1;
          if ((!this.gFw) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.gFs) && (f1 <= this.gFq.getWidth() + this.gFs)) {
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
          paramMotionEvent[0].onClick(this.gFy);
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
      if ((f2 < this.gFt) || (f2 > this.gFq.getHeight() + this.gFt))
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
    if ((this.gFp != null) && (paramInt != this.gFp.gravity))
    {
      this.gFp.gravity = paramInt;
      this.gFr = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.gFp.maxLines != paramInt) || (this.gFp.minLines != paramInt))
    {
      this.gFr = true;
      akI();
      this.gFp.maxLines = paramInt;
      this.gFp.minLines = paramInt;
      this.gFy.requestLayout();
      this.gFy.invalidate();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.gFp != null) && (paramInt != this.gFp.maxLines))
    {
      this.gFp.maxLines = paramInt;
      this.gFr = true;
      akI();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.gFy.requestLayout();
      this.gFy.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.gFp.minLines != paramInt)
    {
      this.gFp.minLines = paramInt;
      akI();
      this.gFy.requestLayout();
      this.gFy.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.gFp.maxLines != i)
      {
        this.gFp.maxLines = i;
        this.gFr = true;
        akI();
        this.gFy.requestLayout();
        this.gFy.invalidate();
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
      this.gFr = true;
      this.gFy.requestLayout();
      this.gFy.invalidate();
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + bt.flS().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.gFp != null) && (paramInt != this.gFp.textColor))
    {
      this.gFp.textColor = paramInt;
      this.gFr = true;
      if (h.DEBUG) {
        ad.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141081);
  }
  
  public final void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141080);
    if ((paramf == null) || (paramf.gFm == null))
    {
      this.gFo = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.gFp == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.gFp = new a();
      localb.gFp.maxLines = paramf.maxLines;
      localb.gFp.maxLength = paramf.maxLength;
      localb.gFp.iU = paramf.iU;
      localb.gFp.gFb = paramf.gFb;
      localb.gFp.gFc = paramf.gFc;
      localb.gFp.gravity = paramf.gravity;
      localb.gFp.textSize = paramf.iU.getTextSize();
      localb.gFp.textColor = paramf.iU.getColor();
      localb.gFp.breakStrategy = paramf.breakStrategy;
      this.gFp = localb.gFp;
    }
    akI();
    this.gFy.setWillNotDraw(false);
    this.gFo = paramf;
    this.gFq = paramf.gFm;
    this.text = paramf.text;
    this.gFu = (this.text instanceof Spannable);
    if (this.gFu)
    {
      this.text = this.gFo.text;
      com.tencent.mm.kiss.widget.textview.b.b.akN();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.gFy.requestLayout();
    this.gFy.invalidate();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.g
 * JD-Core Version:    0.7.0.1
 */