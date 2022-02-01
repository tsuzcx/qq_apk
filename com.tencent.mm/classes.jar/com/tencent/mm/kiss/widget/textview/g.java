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
  protected f huJ;
  public a huK;
  protected StaticLayout huL;
  protected boolean huM = false;
  int huN;
  int huO;
  private boolean huP = false;
  boolean huQ = false;
  boolean huR = false;
  private boolean huS = false;
  private View huT;
  private int huU = 0;
  private int huV = 0;
  protected CharSequence text = null;
  
  public g(View paramView, a parama)
  {
    this.huT = paramView;
    this.huK = parama;
  }
  
  private boolean qj(int paramInt)
  {
    AppMethodBeat.i(141094);
    if ((this.huM) || (this.huJ == null) || (this.huL == null))
    {
      if (this.huK == null)
      {
        AppMethodBeat.o(141094);
        return false;
      }
      if (paramInt > 0)
      {
        aBo();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.huJ = d.a(this.text, paramInt, this.huK).aBl();
        this.huL = this.huJ.huH;
        this.huM = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          Log.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
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
    if ((paramFloat != 0.0F) && (this.huK != null) && (paramFloat != this.huK.textSize))
    {
      this.huK.textSize = paramFloat;
      this.huM = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141079);
  }
  
  final void aBo()
  {
    this.huV = 0;
    this.huU = 0;
    this.huN = 0;
    this.huO = 0;
  }
  
  public final Point cV(int paramInt1, int paramInt2)
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
    qj(i);
    if (this.huL != null) {
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
          Log.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        AppMethodBeat.o(141095);
        return localObject1;
        paramInt1 = 0;
        if (this.huK.hux == null)
        {
          localObject1 = this.huL;
          if (this.huU == 0) {
            break label293;
          }
          paramInt1 = this.huU;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.huL.getText(), this.huL.getPaint()));
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
          this.huU = ((int)Math.ceil(f));
          this.huU += this.huT.getPaddingLeft() + this.huT.getPaddingRight();
          paramInt1 = this.huU;
        }
        localObject1 = this.huL;
        if (this.huV == 0) {
          break label460;
        }
        i = this.huV;
        label439:
        paramInt2 = i;
        if (m == -2147483648) {
          paramInt2 = Math.min(i, j);
        }
      }
      label460:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.huJ.maxLines > 0)
      {
        paramInt2 = i;
        if (this.huJ.maxLines < i) {
          paramInt2 = this.huJ.maxLines;
        }
      }
      int k = this.huT.getPaddingTop();
      n = this.huT.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.huK.minLines > 0) && (paramInt2 < this.huK.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.huK.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.huV = (paramInt2 + (k + n));
        i = this.huV;
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
    return this.huJ;
  }
  
  public final int getLineCount()
  {
    AppMethodBeat.i(141089);
    if (this.huL == null)
    {
      AppMethodBeat.o(141089);
      return 0;
    }
    int i = this.huL.getLineCount();
    AppMethodBeat.o(141089);
    return i;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(141085);
    TextPaint localTextPaint2 = this.huJ.huH.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.huK.iW;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.huK.huB + this.huK.huA);
    AppMethodBeat.o(141085);
    return i;
  }
  
  public final int getMaxLines()
  {
    if (this.huK != null) {
      return this.huK.maxLines;
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
    if (this.huJ == null)
    {
      if (this.huK != null)
      {
        i = this.huK.textColor;
        AppMethodBeat.o(141088);
        return i;
      }
      AppMethodBeat.o(141088);
      return 0;
    }
    int i = this.huJ.iW.getColor();
    AppMethodBeat.o(141088);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(141087);
    if (this.huJ == null)
    {
      if (this.huK != null)
      {
        f = this.huK.textSize;
        AppMethodBeat.o(141087);
        return f;
      }
      AppMethodBeat.o(141087);
      return 0.0F;
    }
    float f = this.huJ.iW.getTextSize();
    AppMethodBeat.o(141087);
    return f;
  }
  
  public final Layout getTvLayout()
  {
    return this.huL;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141075);
    this.text = "";
    this.huT.setWillNotDraw(false);
    AppMethodBeat.o(141075);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141093);
    if ((this.huL == null) || (this.huJ == null))
    {
      boolean bool = qj(this.huT.getMeasuredWidth());
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.huL, this.huJ, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.huT.requestLayout();
        this.huT.invalidate();
      }
      AppMethodBeat.o(141093);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.huT.getPaddingLeft();
    int m = this.huT.getPaddingTop();
    int n = this.huT.getRight() - this.huT.getLeft() - this.huT.getPaddingRight();
    int i1 = this.huT.getBottom() - this.huT.getTop() - this.huT.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.huN == 0) || (this.huO == 0))
    {
      j = this.huT.getPaddingLeft();
      i = this.huT.getRight() - this.huT.getLeft() - this.huT.getPaddingLeft() - this.huT.getPaddingRight();
      i2 = this.huL.getWidth();
      if (i2 > i)
      {
        i = j;
        this.huN = i;
        j = this.huT.getPaddingTop();
        i2 = this.huT.getBottom() - this.huT.getTop() - this.huT.getPaddingTop() - this.huT.getPaddingBottom();
        i = 0;
        i3 = this.huL.getHeight();
        if (i3 <= i2) {
          break label566;
        }
        i = j;
        this.huO = i;
      }
    }
    else
    {
      paramCanvas.translate(this.huN, this.huO);
      this.huL.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        Log.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      AppMethodBeat.o(141093);
      return;
    }
    switch (this.huJ.gravity & 0x800007)
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
    switch (this.huJ.gravity & 0x70)
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
    return (!this.huS) && (this.huQ);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(141082);
    if ((this.huK != null) && (paramInt != this.huK.gravity))
    {
      this.huK.gravity = paramInt;
      this.huM = true;
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141082);
  }
  
  public final void setLines(int paramInt)
  {
    AppMethodBeat.i(141077);
    if ((this.huK.maxLines != paramInt) || (this.huK.minLines != paramInt))
    {
      this.huM = true;
      aBo();
      this.huK.maxLines = paramInt;
      this.huK.minLines = paramInt;
      this.huT.requestLayout();
      this.huT.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    AppMethodBeat.o(141077);
  }
  
  public final void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141083);
    if ((this.huK != null) && (paramInt != this.huK.maxLines))
    {
      this.huK.maxLines = paramInt;
      this.huM = true;
      aBo();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.huT.requestLayout();
      this.huT.invalidate();
    }
    AppMethodBeat.o(141083);
  }
  
  public final void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141084);
    if (this.huK.minLines != paramInt)
    {
      this.huK.minLines = paramInt;
      aBo();
      this.huT.requestLayout();
      this.huT.invalidate();
    }
    AppMethodBeat.o(141084);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141076);
    if (paramBoolean) {}
    for (int i = 1;; i = 2147483647)
    {
      if (this.huK.maxLines != i)
      {
        this.huK.maxLines = i;
        this.huM = true;
        aBo();
        this.huT.requestLayout();
        this.huT.invalidate();
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
    if ((this.text == null) || (!paramCharSequence.equals(this.text)) || (paramBoolean))
    {
      this.text = paramCharSequence;
      this.huM = true;
      this.huT.requestLayout();
      this.huT.invalidate();
      if (h.DEBUG) {
        Log.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + Util.getStack().toString());
      }
    }
    AppMethodBeat.o(141086);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141081);
    if ((this.huK != null) && (paramInt != this.huK.textColor))
    {
      this.huK.textColor = paramInt;
      this.huM = true;
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
    if ((paramf == null) || (paramf.huH == null))
    {
      this.huJ = null;
      AppMethodBeat.o(141080);
      return;
    }
    if (this.huK == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.huK = new a();
      localb.huK.maxLines = paramf.maxLines;
      localb.huK.maxLength = paramf.maxLength;
      localb.huK.iW = paramf.iW;
      localb.huK.huw = paramf.huw;
      localb.huK.hux = paramf.hux;
      localb.huK.gravity = paramf.gravity;
      localb.huK.textSize = paramf.iW.getTextSize();
      localb.huK.textColor = paramf.iW.getColor();
      localb.huK.breakStrategy = paramf.breakStrategy;
      this.huK = localb.huK;
    }
    aBo();
    this.huT.setWillNotDraw(false);
    this.huJ = paramf;
    this.huL = paramf.huH;
    this.text = paramf.text;
    this.huP = (this.text instanceof Spannable);
    if (this.huP)
    {
      this.text = this.huJ.text;
      com.tencent.mm.kiss.widget.textview.b.b.aBv();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    if (this.text == null) {
      if (paramf.text != null) {
        break label339;
      }
    }
    label339:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.huJ.text == null) {
        bool2 = true;
      }
      Log.e("MicroMsg.StaticTextViewHolder", "text is null, [%b, %b, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Util.getStack() });
      this.huT.requestLayout();
      this.huT.invalidate();
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
      if (this.huT.isEnabled())
      {
        bool1 = bool2;
        if (this.huP)
        {
          com.tencent.mm.kiss.widget.textview.b.b.aBv();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.huT, this.huL, (Spannable)this.text, paramMotionEvent);
          this.huS = bool1;
          if ((!this.huR) || (i == 0)) {
            break label250;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.huN) && (f1 <= this.huL.getWidth() + this.huN)) {
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
          Log.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.huT);
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
      if ((f2 < this.huO) || (f2 > this.huL.getHeight() + this.huO))
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