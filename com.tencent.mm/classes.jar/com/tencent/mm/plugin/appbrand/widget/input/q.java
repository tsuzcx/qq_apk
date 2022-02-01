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
import com.tencent.mm.plugin.appbrand.jsapi.z.e;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends y
{
  private float ltS;
  private com.tencent.mm.plugin.appbrand.widget.g.a mSQ;
  private final InputFilter neG;
  private float neH;
  private float neI;
  private float neJ;
  private boolean neK;
  private MotionEvent neL;
  private boolean neM;
  final ag<q> neN;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136436);
    this.neG = new q.4(this);
    this.neH = 0.0F;
    this.neI = 1.2F;
    this.neJ = getTextSize();
    this.neK = false;
    this.neM = false;
    this.neN = new ag(this);
    super.setSingleLine(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setVerticalScrollbarPosition(2);
    super.setSpannableFactory(new q.1(this));
    super.a(new ab.c()
    {
      public final void bEt()
      {
        AppMethodBeat.i(136433);
        q.this.bEp();
        AppMethodBeat.o(136433);
      }
    });
    super.setOnLongClickListener(new q.3(this));
    this.ltS = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setAutoHeight(false);
    b(0.0F, false);
    AppMethodBeat.o(136436);
  }
  
  private void b(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(136443);
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = this.neI * this.neJ + this.neH;
    }
    if ((this.mSQ != null) && (!this.mSQ.aP(f)))
    {
      AppMethodBeat.o(136443);
      return;
    }
    if (this.mSQ == null) {
      this.mSQ = new com.tencent.mm.plugin.appbrand.widget.g.a(f);
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(136443);
      return;
      this.mSQ.setHeight(f);
    }
    if (hasFocus())
    {
      invalidate();
      AppMethodBeat.o(136443);
      return;
    }
    bEL();
    AppMethodBeat.o(136443);
  }
  
  public final void M(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(136459);
    if (!isEnabled())
    {
      AppMethodBeat.o(136459);
      return;
    }
    if (bCr())
    {
      int i = aj.a.a(this, getScrollX() + paramFloat1, getScrollY() + paramFloat2);
      if (i >= 0) {
        setSelection(i);
      }
    }
    super.performClick();
    AppMethodBeat.o(136459);
  }
  
  public final boolean bCr()
  {
    AppMethodBeat.i(136453);
    if (!this.neK)
    {
      bEH();
      getMeasuredHeight();
    }
    if ((!isFocusable()) && (!bEu()))
    {
      AppMethodBeat.o(136453);
      return true;
    }
    AppMethodBeat.o(136453);
    return false;
  }
  
  protected final void bEp()
  {
    AppMethodBeat.i(136439);
    if (this.neK)
    {
      if (getMeasuredHeight() > getMaxHeight())
      {
        setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        AppMethodBeat.o(136439);
        return;
      }
      if ((getMeasuredHeight() < getMinHeight()) && (getMinHeight() > 0)) {
        setMeasuredDimension(getMeasuredWidth(), getMinHeight());
      }
    }
    AppMethodBeat.o(136439);
  }
  
  public final boolean bEq()
  {
    return true;
  }
  
  public final boolean bEr()
  {
    return false;
  }
  
  public final void bEs()
  {
    AppMethodBeat.i(136452);
    aj.dp(this).restartInput(this);
    AppMethodBeat.o(136452);
  }
  
  final Editable c(Editable paramEditable)
  {
    AppMethodBeat.i(136437);
    paramEditable = super.c(paramEditable);
    if ((this.mSQ != null) && (!TextUtils.isEmpty(paramEditable))) {
      paramEditable.setSpan(this.mSQ, 0, paramEditable.length(), 18);
    }
    AppMethodBeat.o(136437);
    return paramEditable;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(136457);
    if (bEH() <= getHeight())
    {
      AppMethodBeat.o(136457);
      return false;
    }
    boolean bool = super.canScrollVertically(paramInt);
    AppMethodBeat.o(136457);
    return bool;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136451);
    w localw = w.dk(this);
    AppMethodBeat.o(136451);
    return localw;
  }
  
  public final int getLineHeight()
  {
    AppMethodBeat.i(136447);
    if (this.mSQ != null)
    {
      i = this.mSQ.height;
      AppMethodBeat.o(136447);
      return i;
    }
    int i = super.getLineHeight();
    AppMethodBeat.o(136447);
    return i;
  }
  
  @Deprecated
  public final float getLineSpacingExtra()
  {
    AppMethodBeat.i(136445);
    float f = super.getLineSpacingExtra();
    AppMethodBeat.o(136445);
    return f;
  }
  
  @Deprecated
  public final float getLineSpacingMultiplier()
  {
    AppMethodBeat.i(136444);
    float f = super.getLineSpacingMultiplier();
    AppMethodBeat.o(136444);
    return f;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136454);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136454);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136458);
    int i;
    float f1;
    float f2;
    label236:
    boolean bool;
    label398:
    label472:
    label499:
    float f3;
    if ((bCr()) && ((getParent() instanceof d)))
    {
      if ((paramMotionEvent.getActionMasked() != 0) || (((d)getParent()).J(paramMotionEvent)))
      {
        ag localag = this.neN;
        com.tencent.mm.plugin.appbrand.widget.base.a.a(localag.TAG, "processTouchEvent", paramMotionEvent);
        Object localObject2 = localag.ngl;
        i = paramMotionEvent.getActionIndex();
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((paramMotionEvent.getActionMasked() != 0) && (localag.ngo == null))
        {
          ad.v(localag.TAG, "[textscroll] no pointer down before, just return");
          localag.bEP();
          AppMethodBeat.o(136458);
          return false;
        }
        int j = 0;
        Object localObject1;
        Object localObject3;
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          localObject1 = localag.ngl;
          localObject3 = localag.ngl.getText();
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
            AppMethodBeat.o(136458);
            return bool;
            ad.v(localag.TAG, "[apptouch] ACTION_UP, pointerDown %B", new Object[] { Boolean.valueOf(localag.ngp) });
            if ((localag.ngp) && (localag.ngo != null))
            {
              localObject1 = e.cE(localag.ngl);
              if ((localag.ngn != null) && (Math.abs(localag.ngn.x - ((e.f)localObject1).x) <= 1.0F) && (Math.abs(localag.ngn.y - ((e.f)localObject1).y) <= 1.0F)) {
                break label398;
              }
              ad.v(localag.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
            }
            for (;;)
            {
              localag.bEP();
              break;
              if (!localag.a(localag.ngo, paramMotionEvent)) {
                ad.v(localag.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
              } else {
                ((ab)localObject2).M(f1, f2);
              }
            }
            localag.ngo = MotionEvent.obtain(paramMotionEvent);
            localag.ngn = e.cE((View)localObject2);
            if (localObject2 != null)
            {
              localObject1 = ((View)localObject2).getParent();
              if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                if (((ViewGroup)localObject1).shouldDelayChildPressedState())
                {
                  i = 1;
                  ((EditText)localObject2).removeCallbacks(localag.ngq);
                  if (i == 0) {
                    break label554;
                  }
                  ((EditText)localObject2).postDelayed(localag.ngq, ViewConfiguration.getTapTimeout());
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
              localag.ngq.run();
            }
            localag.bEP();
            break;
            f3 = localag.ngm;
            if ((f1 >= -f3) && (f2 >= -f3) && (f1 < ((View)localObject2).getWidth() + f3) && (f2 < ((View)localObject2).getHeight() + f3)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) && (localag.a(localag.ngo, paramMotionEvent))) {
                break label685;
              }
              localag.ngp = false;
              ((EditText)localObject2).removeCallbacks(localag.ngq);
              ((EditText)localObject2).removeCallbacks(localag.ngr);
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
            localObject1 = ai.h((TextView)localObject1);
            if ((localObject1 != null) && (localObject1.length > 0) && (localObject1[0].ngD))
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
              if (!localObject2[0].ngC)
              {
                i = ViewConfiguration.get(((TextView)localObject1).getContext()).getScaledTouchSlop();
                if ((Math.abs(paramMotionEvent.getX() - localObject2[0].mX) >= i) || (Math.abs(paramMotionEvent.getY() - localObject2[0].mY) >= i)) {
                  localObject2[0].ngC = true;
                }
              }
              if (!localObject2[0].ngC) {
                break label236;
              }
              localObject2[0].ngD = true;
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
                if (!localObject2[0].ngE) {
                  break label1100;
                }
                localObject2[0].ngE = false;
                localObject2[0].ngC = false;
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
                localObject2[0].awM = true;
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
              if (!localObject2[0].awM) {
                break label1410;
              }
              i = 1;
            }
          }
          label1410:
          ai.h((TextView)localObject1);
        }
      }
      AppMethodBeat.o(136458);
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(136458);
      return bool;
      this.neM = false;
      if (this.neL != null)
      {
        this.neL.recycle();
        this.neL = null;
      }
      if (this.neM)
      {
        i = aj.a.a(this, paramMotionEvent.getX(paramMotionEvent.getActionIndex()), paramMotionEvent.getY(paramMotionEvent.getActionIndex()));
        if (i >= 0) {
          setSelection(i);
        }
      }
      if (getParent() == null)
      {
        AppMethodBeat.o(136458);
        return true;
        this.neL = MotionEvent.obtain(paramMotionEvent);
        this.neM = true;
        continue;
        if (this.neM)
        {
          f1 = this.neL.getX(this.neL.getActionIndex());
          f2 = this.neL.getY(this.neL.getActionIndex());
          f3 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
          float f4 = paramMotionEvent.getY(paramMotionEvent.getActionIndex());
          if ((Math.abs(f1 - f3) > this.ltS) || (Math.abs(f2 - f4) > this.ltS))
          {
            cancelLongPress();
            setPressed(false);
            this.neM = false;
          }
        }
      }
    }
  }
  
  public final boolean performHapticFeedback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136460);
    boolean bool = super.performHapticFeedback(paramInt1, paramInt2);
    AppMethodBeat.o(136460);
    return bool;
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136456);
    super.scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(136456);
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136455);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(136455);
  }
  
  public final void setAutoHeight(boolean paramBoolean)
  {
    AppMethodBeat.i(136438);
    this.neK = paramBoolean;
    if (!this.neK) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setVerticalScrollBarEnabled(paramBoolean);
      AppMethodBeat.o(136438);
      return;
    }
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(136442);
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.neG != null)
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
      paramArrayOfInputFilter[i] = this.neG;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
    AppMethodBeat.o(136442);
  }
  
  public final void setGravity(int paramInt)
  {
    AppMethodBeat.i(136440);
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFEF | 0x30);
    AppMethodBeat.o(136440);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(136441);
    super.setInputType(0x20000 | paramInt);
    AppMethodBeat.o(136441);
  }
  
  public final void setLineHeight(float paramFloat)
  {
    AppMethodBeat.i(136450);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(136450);
      return;
    }
    b(paramFloat, true);
    AppMethodBeat.o(136450);
  }
  
  public final void setLineSpace(float paramFloat)
  {
    AppMethodBeat.i(136449);
    setLineSpacing(paramFloat, this.neI);
    AppMethodBeat.o(136449);
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(136448);
    this.neH = paramFloat1;
    this.neI = paramFloat2;
    b(0.0F, true);
    AppMethodBeat.o(136448);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(136446);
    super.setTextSize(paramInt, paramFloat);
    this.neJ = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    b(0.0F, true);
    AppMethodBeat.o(136446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q
 * JD-Core Version:    0.7.0.1
 */