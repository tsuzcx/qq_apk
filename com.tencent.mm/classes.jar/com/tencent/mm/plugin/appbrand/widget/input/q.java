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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;

public final class q
  extends y
{
  private float ifc;
  private com.tencent.mm.plugin.appbrand.widget.h.a jan;
  final ag<q> jmA;
  private final InputFilter jmt;
  private float jmu;
  private float jmv;
  private float jmw;
  private boolean jmx;
  private MotionEvent jmy;
  private boolean jmz;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123702);
    this.jmt = new q.4(this);
    this.jmu = 0.0F;
    this.jmv = 1.2F;
    this.jmw = getTextSize();
    this.jmx = false;
    this.jmz = false;
    this.jmA = new ag(this);
    super.setSingleLine(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setVerticalScrollbarPosition(2);
    super.setSpannableFactory(new q.1(this));
    super.a(new q.2(this));
    super.setOnLongClickListener(new q.3(this));
    this.ifc = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setAutoHeight(false);
    b(0.0F, false);
    AppMethodBeat.o(123702);
  }
  
  private void b(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(123709);
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = this.jmv * this.jmw + this.jmu;
    }
    if ((this.jan != null) && (!this.jan.aF(f)))
    {
      AppMethodBeat.o(123709);
      return;
    }
    if (this.jan == null) {
      this.jan = new com.tencent.mm.plugin.appbrand.widget.h.a(f);
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(123709);
      return;
      this.jan.setHeight(f);
    }
    if (hasFocus())
    {
      invalidate();
      AppMethodBeat.o(123709);
      return;
    }
    aRt();
    AppMethodBeat.o(123709);
  }
  
  public final void R(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(123725);
    if (!isEnabled())
    {
      AppMethodBeat.o(123725);
      return;
    }
    if (aOP())
    {
      int i = aj.a.a(this, getScrollX() + paramFloat1, getScrollY() + paramFloat2);
      if (i >= 0) {
        setSelection(i);
      }
    }
    super.performClick();
    AppMethodBeat.o(123725);
  }
  
  public final boolean aOP()
  {
    AppMethodBeat.i(123719);
    if (!this.jmx)
    {
      aRp();
      getMeasuredHeight();
    }
    if ((!isFocusable()) && (!aRb()))
    {
      AppMethodBeat.o(123719);
      return true;
    }
    AppMethodBeat.o(123719);
    return false;
  }
  
  protected final void aQW()
  {
    AppMethodBeat.i(123705);
    if (this.jmx)
    {
      if (getMeasuredHeight() > getMaxHeight())
      {
        setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        AppMethodBeat.o(123705);
        return;
      }
      if ((getMeasuredHeight() < getMinHeight()) && (getMinHeight() > 0)) {
        setMeasuredDimension(getMeasuredWidth(), getMinHeight());
      }
    }
    AppMethodBeat.o(123705);
  }
  
  public final boolean aQX()
  {
    return true;
  }
  
  public final boolean aQY()
  {
    return false;
  }
  
  public final void aQZ()
  {
    AppMethodBeat.i(123718);
    aj.cV(this).restartInput(this);
    AppMethodBeat.o(123718);
  }
  
  final Editable c(Editable paramEditable)
  {
    AppMethodBeat.i(123703);
    paramEditable = super.c(paramEditable);
    if ((this.jan != null) && (!TextUtils.isEmpty(paramEditable))) {
      paramEditable.setSpan(this.jan, 0, paramEditable.length(), 18);
    }
    AppMethodBeat.o(123703);
    return paramEditable;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(123723);
    if (aRp() <= getHeight())
    {
      AppMethodBeat.o(123723);
      return false;
    }
    boolean bool = super.canScrollVertically(paramInt);
    AppMethodBeat.o(123723);
    return bool;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(123717);
    w localw = w.cQ(this);
    AppMethodBeat.o(123717);
    return localw;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(123713);
    if (this.jan != null)
    {
      i = this.jan.height;
      AppMethodBeat.o(123713);
      return i;
    }
    int i = super.getLineHeight();
    AppMethodBeat.o(123713);
    return i;
  }
  
  @Deprecated
  public final float getLineSpacingExtra()
  {
    AppMethodBeat.i(123711);
    float f = super.getLineSpacingExtra();
    AppMethodBeat.o(123711);
    return f;
  }
  
  @Deprecated
  public final float getLineSpacingMultiplier()
  {
    AppMethodBeat.i(123710);
    float f = super.getLineSpacingMultiplier();
    AppMethodBeat.o(123710);
    return f;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123720);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(123720);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123724);
    int i;
    float f1;
    float f2;
    label236:
    boolean bool;
    label398:
    label472:
    label499:
    float f3;
    if ((aOP()) && ((getParent() instanceof com.tencent.mm.plugin.appbrand.widget.base.d)))
    {
      if ((paramMotionEvent.getActionMasked() != 0) || (((com.tencent.mm.plugin.appbrand.widget.base.d)getParent()).I(paramMotionEvent)))
      {
        ag localag = this.jmA;
        com.tencent.mm.plugin.appbrand.widget.base.a.a(localag.TAG, "processTouchEvent", paramMotionEvent);
        Object localObject2 = localag.jnZ;
        i = paramMotionEvent.getActionIndex();
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((paramMotionEvent.getActionMasked() != 0) && (localag.joc == null))
        {
          com.tencent.mm.sdk.platformtools.ab.v(localag.TAG, "[textscroll] no pointer down before, just return");
          localag.aRx();
          AppMethodBeat.o(123724);
          return false;
        }
        int j = 0;
        Object localObject1;
        Object localObject3;
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          localObject1 = localag.jnZ;
          localObject3 = localag.jnZ.getText();
          if ((((TextView)localObject1).canScrollVertically(-1)) || (((TextView)localObject1).canScrollVertically(1))) {
            switch (paramMotionEvent.getActionMasked())
            {
            }
          }
          break;
        }
        for (;;)
        {
          i = 0;
          for (;;)
          {
            bool = i | j;
            com.tencent.mm.plugin.appbrand.widget.base.a.a(localag.TAG, "[textscroll] handled | ".concat(String.valueOf(bool)), paramMotionEvent);
            AppMethodBeat.o(123724);
            return bool;
            com.tencent.mm.sdk.platformtools.ab.v(localag.TAG, "[apptouch] ACTION_UP, pointerDown %B", new Object[] { Boolean.valueOf(localag.jod) });
            if ((localag.jod) && (localag.joc != null))
            {
              localObject1 = com.tencent.mm.plugin.appbrand.jsapi.s.d.cr(localag.jnZ);
              if ((localag.job != null) && (Math.abs(localag.job.x - ((d.f)localObject1).x) <= 1.0F) && (Math.abs(localag.job.y - ((d.f)localObject1).y) <= 1.0F)) {
                break label398;
              }
              com.tencent.mm.sdk.platformtools.ab.v(localag.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
            }
            for (;;)
            {
              localag.aRx();
              break;
              if (!localag.a(localag.joc, paramMotionEvent)) {
                com.tencent.mm.sdk.platformtools.ab.v(localag.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
              } else {
                ((ab)localObject2).R(f1, f2);
              }
            }
            localag.joc = MotionEvent.obtain(paramMotionEvent);
            localag.job = com.tencent.mm.plugin.appbrand.jsapi.s.d.cr((View)localObject2);
            if (localObject2 != null)
            {
              localObject1 = ((View)localObject2).getParent();
              if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                if (((ViewGroup)localObject1).shouldDelayChildPressedState())
                {
                  i = 1;
                  ((EditText)localObject2).removeCallbacks(localag.joe);
                  if (i == 0) {
                    break label554;
                  }
                  ((EditText)localObject2).postDelayed(localag.joe, ViewConfiguration.getTapTimeout());
                }
              }
            }
            for (;;)
            {
              j = 1;
              break;
              localObject1 = ((ViewParent)localObject1).getParent();
              break label472;
              i = 0;
              break label499;
              label554:
              localag.joe.run();
            }
            localag.aRx();
            break;
            f3 = localag.joa;
            if ((f1 >= -f3) && (f2 >= -f3) && (f1 < ((View)localObject2).getWidth() + f3) && (f2 < ((View)localObject2).getHeight() + f3)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) && (localag.a(localag.joc, paramMotionEvent))) {
                break label685;
              }
              localag.jod = false;
              ((EditText)localObject2).removeCallbacks(localag.joe);
              ((EditText)localObject2).removeCallbacks(localag.jof);
              break;
            }
            label685:
            j = 1;
            break;
            localObject2 = (ai.a[])((Spannable)localObject3).getSpans(0, ((Spannable)localObject3).length(), ai.a.class);
            i = 0;
            while (i < localObject2.length)
            {
              ((Spannable)localObject3).removeSpan(localObject2[i]);
              i += 1;
            }
            ((Spannable)localObject3).setSpan(new ai.a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((TextView)localObject1).getScrollX(), ((TextView)localObject1).getScrollY()), 0, 0, 17);
            i = 1;
            continue;
            localObject1 = ai.f((TextView)localObject1);
            if ((localObject1 != null) && (localObject1.length > 0) && (localObject1[0].jor))
            {
              i = 1;
            }
            else
            {
              i = 0;
              continue;
              localObject2 = (ai.a[])((Spannable)localObject3).getSpans(0, ((Spannable)localObject3).length(), ai.a.class);
              if (localObject2.length <= 0) {
                break label236;
              }
              if (!localObject2[0].joq)
              {
                i = ViewConfiguration.get(((TextView)localObject1).getContext()).getScaledTouchSlop();
                if ((Math.abs(paramMotionEvent.getX() - localObject2[0].mX) >= i) || (Math.abs(paramMotionEvent.getY() - localObject2[0].mY) >= i)) {
                  localObject2[0].joq = true;
                }
              }
              if (!localObject2[0].joq) {
                break label236;
              }
              localObject2[0].jor = true;
              if (((paramMotionEvent.getMetaState() & 0x1) != 0) || (MetaKeyKeyListener.getMetaState((CharSequence)localObject3, 1) == 1) || (MetaKeyKeyListener.getMetaState((CharSequence)localObject3, 2048) != 0))
              {
                i = 1;
                label983:
                if (i == 0) {
                  break label1071;
                }
                f2 = paramMotionEvent.getX() - localObject2[0].mX;
              }
              for (f1 = paramMotionEvent.getY() - localObject2[0].mY;; f1 = localObject2[0].mY - paramMotionEvent.getY())
              {
                localObject2[0].mX = paramMotionEvent.getX();
                localObject2[0].mY = paramMotionEvent.getY();
                if (!localObject2[0].jos) {
                  break label1100;
                }
                localObject2[0].jos = false;
                localObject2[0].joq = false;
                break;
                i = 0;
                break label983;
                label1071:
                f2 = localObject2[0].mX - paramMotionEvent.getX();
              }
              label1100:
              int i1 = ((TextView)localObject1).getScrollX();
              int i2 = (int)f2;
              i = ((TextView)localObject1).getScrollY();
              int k = (int)f1;
              int m = ((TextView)localObject1).getTotalPaddingTop();
              int n = ((TextView)localObject1).getTotalPaddingBottom();
              localObject3 = ((TextView)localObject1).getLayout();
              k = Math.max(Math.min(k + i, ((Layout)localObject3).getHeight() - (((TextView)localObject1).getHeight() - (m + n))), 0);
              m = ((TextView)localObject1).getScrollX();
              n = ((TextView)localObject1).getScrollY();
              i = ((TextView)localObject1).getTotalPaddingLeft();
              int i3 = ((TextView)localObject1).getTotalPaddingRight();
              i3 = ((TextView)localObject1).getWidth() - (i + i3);
              i = ((Layout)localObject3).getLineForVertical(k);
              Layout.Alignment localAlignment = ((Layout)localObject3).getParagraphAlignment(i);
              label1246:
              int i4;
              if (((Layout)localObject3).getParagraphDirection(i) > 0)
              {
                i = 1;
                i4 = i3 + 0;
                if (i4 >= i3) {
                  break label1376;
                }
                if (localAlignment != Layout.Alignment.ALIGN_CENTER) {
                  break label1332;
                }
                i = 0 - (i3 - i4) / 2;
              }
              for (;;)
              {
                ((TextView)localObject1).scrollTo(i, k);
                if ((m == ((TextView)localObject1).getScrollX()) && (n == ((TextView)localObject1).getScrollY())) {
                  break label1394;
                }
                ((TextView)localObject1).cancelLongPress();
                localObject2[0].amA = true;
                i = 1;
                break;
                i = 0;
                break label1246;
                label1332:
                if (((i != 0) && (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)) || ((i == 0) && (localAlignment == Layout.Alignment.ALIGN_NORMAL)))
                {
                  i = 0 - (i3 - i4);
                }
                else
                {
                  i = 0;
                  continue;
                  label1376:
                  i = Math.max(Math.min(i2 + i1, 0), 0);
                }
              }
              label1394:
              if (!localObject2[0].amA) {
                break label1410;
              }
              i = 1;
            }
          }
          label1410:
          ai.f((TextView)localObject1);
        }
      }
      AppMethodBeat.o(123724);
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(123724);
      return bool;
      this.jmz = false;
      if (this.jmy != null)
      {
        this.jmy.recycle();
        this.jmy = null;
      }
      if (this.jmz)
      {
        i = aj.a.a(this, paramMotionEvent.getX(paramMotionEvent.getActionIndex()), paramMotionEvent.getY(paramMotionEvent.getActionIndex()));
        if (i >= 0) {
          setSelection(i);
        }
      }
      if (getParent() == null)
      {
        AppMethodBeat.o(123724);
        return true;
        this.jmy = MotionEvent.obtain(paramMotionEvent);
        this.jmz = true;
        continue;
        if (this.jmz)
        {
          f1 = this.jmy.getX(this.jmy.getActionIndex());
          f2 = this.jmy.getY(this.jmy.getActionIndex());
          f3 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
          float f4 = paramMotionEvent.getY(paramMotionEvent.getActionIndex());
          if ((Math.abs(f1 - f3) > this.ifc) || (Math.abs(f2 - f4) > this.ifc))
          {
            cancelLongPress();
            setPressed(false);
            this.jmz = false;
          }
        }
      }
    }
  }
  
  public final boolean performHapticFeedback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123726);
    boolean bool = super.performHapticFeedback(paramInt1, paramInt2);
    AppMethodBeat.o(123726);
    return bool;
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123722);
    super.scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(123722);
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123721);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(123721);
  }
  
  public final void setAutoHeight(boolean paramBoolean)
  {
    AppMethodBeat.i(123704);
    this.jmx = paramBoolean;
    if (!this.jmx) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setVerticalScrollBarEnabled(paramBoolean);
      AppMethodBeat.o(123704);
      return;
    }
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(123708);
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.jmt != null)
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
      paramArrayOfInputFilter[i] = this.jmt;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
    AppMethodBeat.o(123708);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(123706);
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFEF | 0x30);
    AppMethodBeat.o(123706);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(123707);
    super.setInputType(0x20000 | paramInt);
    AppMethodBeat.o(123707);
  }
  
  public final void setLineHeight(float paramFloat)
  {
    AppMethodBeat.i(123716);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(123716);
      return;
    }
    b(paramFloat, true);
    AppMethodBeat.o(123716);
  }
  
  public final void setLineSpace(float paramFloat)
  {
    AppMethodBeat.i(123715);
    setLineSpacing(paramFloat, this.jmv);
    AppMethodBeat.o(123715);
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(123714);
    this.jmu = paramFloat1;
    this.jmv = paramFloat2;
    b(0.0F, true);
    AppMethodBeat.o(123714);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(123712);
    super.setTextSize(paramInt, paramFloat);
    this.jmw = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    b(0.0F, true);
    AppMethodBeat.o(123712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q
 * JD-Core Version:    0.7.0.1
 */