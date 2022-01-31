package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.f;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends x
{
  private float gFU;
  private com.tencent.mm.plugin.appbrand.widget.g.a hob;
  private final InputFilter hun = new p.4(this);
  private float huo = 0.0F;
  private float hup = 1.2F;
  private float huq = getTextSize();
  private boolean hur = false;
  private MotionEvent hus;
  private boolean hut = false;
  final af<p> huu = new af(this);
  
  public p(Context paramContext)
  {
    super(paramContext);
    super.setSingleLine(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setVerticalScrollbarPosition(2);
    super.setSpannableFactory(new p.1(this));
    super.a(new p.2(this));
    super.setOnLongClickListener(new p.3(this));
    this.gFU = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setAutoHeight(false);
    b(0.0F, false);
  }
  
  private void b(float paramFloat, boolean paramBoolean)
  {
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = this.hup * this.huq + this.huo;
    }
    if ((this.hob != null) && (!this.hob.an(f))) {}
    do
    {
      return;
      this.hob = new com.tencent.mm.plugin.appbrand.widget.g.a(f);
    } while (!paramBoolean);
    if (hasFocus())
    {
      invalidate();
      return;
    }
    aso();
    setText(getEditableText());
    asp();
  }
  
  public final void K(float paramFloat1, float paramFloat2)
  {
    if (!isEnabled()) {
      return;
    }
    if (arc())
    {
      int i = ai.a.a(this, paramFloat1, paramFloat2);
      if (i >= 0) {
        setSelection(i);
      }
    }
    super.performClick();
  }
  
  protected final void arS()
  {
    if (this.hur)
    {
      if (getMeasuredHeight() <= getMaxHeight()) {
        break label31;
      }
      setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
    }
    label31:
    while ((getMeasuredHeight() >= getMinHeight()) || (getMinHeight() <= 0)) {
      return;
    }
    setMeasuredDimension(getMeasuredWidth(), getMinHeight());
  }
  
  public final boolean arT()
  {
    return true;
  }
  
  public final boolean arU()
  {
    return false;
  }
  
  public final void arV()
  {
    ai.cs(this).restartInput(this);
  }
  
  public final boolean arc()
  {
    if (!this.hur)
    {
      ask();
      getMeasuredHeight();
    }
    return (!isFocusable()) && (!arX());
  }
  
  final Editable c(Editable paramEditable)
  {
    paramEditable = super.c(paramEditable);
    if ((this.hob != null) && (!TextUtils.isEmpty(paramEditable))) {
      paramEditable.setSpan(this.hob, 0, paramEditable.length(), 18);
    }
    return paramEditable;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    if (ask() <= getHeight()) {
      return false;
    }
    return super.canScrollVertically(paramInt);
  }
  
  public final View getInputPanel()
  {
    return v.cn(this);
  }
  
  public final int getLineHeight()
  {
    if (this.hob != null) {
      return this.hob.height;
    }
    return super.getLineHeight();
  }
  
  @Deprecated
  public final float getLineSpacingExtra()
  {
    return super.getLineSpacingExtra();
  }
  
  @Deprecated
  public final float getLineSpacingMultiplier()
  {
    return super.getLineSpacingMultiplier();
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 1;
    int i;
    float f1;
    float f2;
    label228:
    label495:
    float f3;
    if ((arc()) && ((getParent() instanceof d)))
    {
      af localaf;
      Object localObject2;
      if ((paramMotionEvent.getActionMasked() != 0) || (((d)getParent()).z(paramMotionEvent)))
      {
        localaf = this.huu;
        com.tencent.mm.plugin.appbrand.widget.base.a.a(localaf.TAG, "processTouchEvent", paramMotionEvent);
        localObject2 = localaf.hvM;
        i = paramMotionEvent.getActionIndex();
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((paramMotionEvent.getActionMasked() != 0) && (localaf.hvP == null))
        {
          y.v(localaf.TAG, "[textscroll] no pointer down before, just return");
          localaf.ast();
        }
      }
      else
      {
        return false;
      }
      Object localObject1;
      Object localObject3;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        i = 0;
        localObject1 = localaf.hvM;
        localObject3 = localaf.hvM.getText();
        if ((((TextView)localObject1).canScrollVertically(-1)) || (((TextView)localObject1).canScrollVertically(1))) {
          switch (paramMotionEvent.getActionMasked())
          {
          }
        }
        break;
      }
      label394:
      label550:
      label687:
      label1072:
      label1334:
      for (;;)
      {
        int j = 0;
        label468:
        label984:
        label1247:
        label1378:
        label1396:
        do
        {
          for (;;)
          {
            boolean bool = i | j;
            com.tencent.mm.plugin.appbrand.widget.base.a.a(localaf.TAG, "[textscroll] handled | " + bool, paramMotionEvent);
            return bool;
            y.v(localaf.TAG, "[apptouch] ACTION_UP, pointerDown %B", new Object[] { Boolean.valueOf(localaf.hvQ) });
            if ((localaf.hvQ) && (localaf.hvP != null))
            {
              localObject1 = c.bU(localaf.hvM);
              if ((localaf.hvO != null) && (Math.abs(localaf.hvO.x - ((c.f)localObject1).x) <= 1.0F) && (Math.abs(localaf.hvO.y - ((c.f)localObject1).y) <= 1.0F)) {
                break label394;
              }
              y.v(localaf.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
            }
            for (;;)
            {
              localaf.ast();
              i = 0;
              break;
              if (!localaf.a(localaf.hvP, paramMotionEvent)) {
                y.v(localaf.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
              } else {
                ((aa)localObject2).K(f1, f2);
              }
            }
            localaf.hvP = MotionEvent.obtain(paramMotionEvent);
            localaf.hvO = c.bU((View)localObject2);
            if (localObject2 != null)
            {
              localObject1 = ((View)localObject2).getParent();
              if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                if (((ViewGroup)localObject1).shouldDelayChildPressedState())
                {
                  i = 1;
                  ((EditText)localObject2).removeCallbacks(localaf.hvR);
                  if (i == 0) {
                    break label550;
                  }
                  ((EditText)localObject2).postDelayed(localaf.hvR, ViewConfiguration.getTapTimeout());
                }
              }
            }
            for (;;)
            {
              i = 1;
              break;
              localObject1 = ((ViewParent)localObject1).getParent();
              break label468;
              i = 0;
              break label495;
              localaf.hvR.run();
            }
            localaf.ast();
            i = 0;
            break;
            f3 = localaf.hvN;
            if ((f1 >= -f3) && (f2 >= -f3) && (f1 < ((View)localObject2).getWidth() + f3) && (f2 < ((View)localObject2).getHeight() + f3)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) && (localaf.a(localaf.hvP, paramMotionEvent))) {
                break label687;
              }
              localaf.hvQ = false;
              ((EditText)localObject2).removeCallbacks(localaf.hvR);
              ((EditText)localObject2).removeCallbacks(localaf.hvS);
              i = 0;
              break;
            }
            i = 1;
            break;
            localObject2 = (ah.a[])((Spannable)localObject3).getSpans(0, ((Spannable)localObject3).length(), ah.a.class);
            j = 0;
            while (j < localObject2.length)
            {
              ((Spannable)localObject3).removeSpan(localObject2[j]);
              j += 1;
            }
            ((Spannable)localObject3).setSpan(new ah.a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((TextView)localObject1).getScrollX(), ((TextView)localObject1).getScrollY()), 0, 0, 17);
            j = k;
            continue;
            localObject1 = ah.e((TextView)localObject1);
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              j = k;
              if (localObject1[0].hwe) {}
            }
            else
            {
              j = 0;
            }
          }
          localObject2 = (ah.a[])((Spannable)localObject3).getSpans(0, ((Spannable)localObject3).length(), ah.a.class);
          if (localObject2.length <= 0) {
            break label228;
          }
          if (!localObject2[0].hwd)
          {
            j = ViewConfiguration.get(((TextView)localObject1).getContext()).getScaledTouchSlop();
            if ((Math.abs(paramMotionEvent.getX() - localObject2[0].aoq) >= j) || (Math.abs(paramMotionEvent.getY() - localObject2[0].aor) >= j)) {
              localObject2[0].hwd = true;
            }
          }
          if (!localObject2[0].hwd) {
            break label228;
          }
          localObject2[0].hwe = true;
          if (((paramMotionEvent.getMetaState() & 0x1) != 0) || (MetaKeyKeyListener.getMetaState((CharSequence)localObject3, 1) == 1) || (MetaKeyKeyListener.getMetaState((CharSequence)localObject3, 2048) != 0))
          {
            j = 1;
            if (j == 0) {
              break label1072;
            }
            f2 = paramMotionEvent.getX() - localObject2[0].aoq;
          }
          for (f1 = paramMotionEvent.getY() - localObject2[0].aor;; f1 = localObject2[0].aor - paramMotionEvent.getY())
          {
            localObject2[0].aoq = paramMotionEvent.getX();
            localObject2[0].aor = paramMotionEvent.getY();
            if (!localObject2[0].hwg) {
              break label1101;
            }
            localObject2[0].hwg = false;
            localObject2[0].hwd = false;
            break;
            j = 0;
            break label984;
            f2 = localObject2[0].aoq - paramMotionEvent.getX();
          }
          int i2 = ((TextView)localObject1).getScrollX();
          int i3 = (int)f2;
          j = ((TextView)localObject1).getScrollY();
          int m = (int)f1;
          int n = ((TextView)localObject1).getTotalPaddingTop();
          int i1 = ((TextView)localObject1).getTotalPaddingBottom();
          localObject3 = ((TextView)localObject1).getLayout();
          m = Math.max(Math.min(m + j, ((Layout)localObject3).getHeight() - (((TextView)localObject1).getHeight() - (n + i1))), 0);
          n = ((TextView)localObject1).getScrollX();
          i1 = ((TextView)localObject1).getScrollY();
          j = ((TextView)localObject1).getTotalPaddingLeft();
          int i4 = ((TextView)localObject1).getTotalPaddingRight();
          i4 = ((TextView)localObject1).getWidth() - (j + i4);
          j = ((Layout)localObject3).getLineForVertical(m);
          Layout.Alignment localAlignment = ((Layout)localObject3).getParagraphAlignment(j);
          int i5;
          if (((Layout)localObject3).getParagraphDirection(j) > 0)
          {
            j = 1;
            i5 = i4 + 0;
            if (i5 >= i4) {
              break label1378;
            }
            if (localAlignment != Layout.Alignment.ALIGN_CENTER) {
              break label1334;
            }
            j = 0 - (i4 - i5) / 2;
          }
          for (;;)
          {
            ((TextView)localObject1).scrollTo(j, m);
            if ((n == ((TextView)localObject1).getScrollX()) && (i1 == ((TextView)localObject1).getScrollY())) {
              break label1396;
            }
            ((TextView)localObject1).cancelLongPress();
            localObject2[0].hwf = true;
            j = k;
            break;
            j = 0;
            break label1247;
            if (((j != 0) && (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)) || ((j == 0) && (localAlignment == Layout.Alignment.ALIGN_NORMAL)))
            {
              j = 0 - (i4 - i5);
            }
            else
            {
              j = 0;
              continue;
              j = Math.max(Math.min(i3 + i2, 0), 0);
            }
          }
          j = k;
        } while (localObject2[0].hwf);
        label1101:
        ah.e((TextView)localObject1);
      }
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.hut = false;
      if (this.hus != null)
      {
        this.hus.recycle();
        this.hus = null;
      }
      if (this.hut)
      {
        i = ai.a.a(this, paramMotionEvent.getX(paramMotionEvent.getActionIndex()), paramMotionEvent.getY(paramMotionEvent.getActionIndex()));
        if (i >= 0) {
          setSelection(i);
        }
      }
      if (getParent() == null)
      {
        return true;
        this.hus = MotionEvent.obtain(paramMotionEvent);
        this.hut = true;
        continue;
        if (this.hut)
        {
          f1 = this.hus.getX(this.hus.getActionIndex());
          f2 = this.hus.getY(this.hus.getActionIndex());
          f3 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
          float f4 = paramMotionEvent.getY(paramMotionEvent.getActionIndex());
          if ((Math.abs(f1 - f3) > this.gFU) || (Math.abs(f2 - f4) > this.gFU))
          {
            cancelLongPress();
            setPressed(false);
            this.hut = false;
          }
        }
      }
    }
  }
  
  public final boolean performHapticFeedback(int paramInt1, int paramInt2)
  {
    return super.performHapticFeedback(paramInt1, paramInt2);
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    super.scrollBy(paramInt1, paramInt2);
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public final void setAutoHeight(boolean paramBoolean)
  {
    this.hur = paramBoolean;
    if (!this.hur) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setVerticalScrollBarEnabled(paramBoolean);
      return;
    }
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.hun != null)
    {
      arrayOfInputFilter = paramArrayOfInputFilter;
      if (paramArrayOfInputFilter == null) {
        arrayOfInputFilter = new InputFilter[0];
      }
      paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
      while (i < arrayOfInputFilter.length)
      {
        paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
        i += 1;
      }
      paramArrayOfInputFilter[i] = this.hun;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
  }
  
  public final void setGravity(int paramInt)
  {
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFEF | 0x30);
  }
  
  public final void setInputType(int paramInt)
  {
    super.setInputType(0x20000 | paramInt);
  }
  
  public final void setLineHeight(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    b(paramFloat, true);
  }
  
  public final void setLineSpace(float paramFloat)
  {
    setLineSpacing(paramFloat, this.hup);
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.huo = paramFloat1;
    this.hup = paramFloat2;
    b(0.0F, true);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.huq = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    b(0.0F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.p
 * JD-Core Version:    0.7.0.1
 */