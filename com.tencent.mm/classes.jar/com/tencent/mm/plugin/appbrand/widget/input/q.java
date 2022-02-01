package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.f;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends y
{
  private float lyr;
  private com.tencent.mm.plugin.appbrand.widget.g.a mXZ;
  private final InputFilter njO;
  private float njP;
  private float njQ;
  private float njR;
  private boolean njS;
  private MotionEvent njT;
  private boolean njU;
  final ag<q> njV;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136436);
    this.njO = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(136435);
        if ((!TextUtils.isEmpty(paramAnonymousCharSequence)) && (q.a(q.this) != null))
        {
          if ((paramAnonymousCharSequence instanceof Spannable)) {}
          for (paramAnonymousCharSequence = (Spannable)paramAnonymousCharSequence;; paramAnonymousCharSequence = new SpannableStringBuilder(paramAnonymousCharSequence))
          {
            paramAnonymousCharSequence.setSpan(q.a(q.this), 0, paramAnonymousCharSequence.length(), 18);
            AppMethodBeat.o(136435);
            return paramAnonymousCharSequence;
          }
        }
        AppMethodBeat.o(136435);
        return null;
      }
    };
    this.njP = 0.0F;
    this.njQ = 1.2F;
    this.njR = getTextSize();
    this.njS = false;
    this.njU = false;
    this.njV = new ag(this);
    super.setSingleLine(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setVerticalScrollbarPosition(2);
    super.setSpannableFactory(new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(136432);
        paramAnonymousCharSequence = super.newSpannable(paramAnonymousCharSequence);
        if ((q.a(q.this) != null) && (!TextUtils.isEmpty(paramAnonymousCharSequence))) {
          paramAnonymousCharSequence.setSpan(q.a(q.this), 0, paramAnonymousCharSequence.length(), 18);
        }
        AppMethodBeat.o(136432);
        return paramAnonymousCharSequence;
      }
    });
    super.a(new ab.c()
    {
      public final void bFl()
      {
        AppMethodBeat.i(136433);
        q.this.bFh();
        AppMethodBeat.o(136433);
      }
    });
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136434);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        boolean bool = q.this.bDj();
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetMultiLine$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(136434);
        return bool;
      }
    });
    this.lyr = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setAutoHeight(false);
    b(0.0F, false);
    AppMethodBeat.o(136436);
  }
  
  private void b(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(136443);
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = this.njQ * this.njR + this.njP;
    }
    if ((this.mXZ != null) && (!this.mXZ.aP(f)))
    {
      AppMethodBeat.o(136443);
      return;
    }
    if (this.mXZ == null) {
      this.mXZ = new com.tencent.mm.plugin.appbrand.widget.g.a(f);
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(136443);
      return;
      this.mXZ.setHeight(f);
    }
    if (hasFocus())
    {
      invalidate();
      AppMethodBeat.o(136443);
      return;
    }
    bFD();
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
    if (bDj())
    {
      int i = aj.a.a(this, getScrollX() + paramFloat1, getScrollY() + paramFloat2);
      if (i >= 0) {
        setSelection(i);
      }
    }
    super.performClick();
    AppMethodBeat.o(136459);
  }
  
  public final boolean bDj()
  {
    AppMethodBeat.i(136453);
    if (!this.njS)
    {
      bFz();
      getMeasuredHeight();
    }
    if ((!isFocusable()) && (!bFm()))
    {
      AppMethodBeat.o(136453);
      return true;
    }
    AppMethodBeat.o(136453);
    return false;
  }
  
  protected final void bFh()
  {
    AppMethodBeat.i(136439);
    if (this.njS)
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
  
  public final boolean bFi()
  {
    return true;
  }
  
  public final boolean bFj()
  {
    return false;
  }
  
  public final void bFk()
  {
    AppMethodBeat.i(136452);
    aj.dp(this).restartInput(this);
    AppMethodBeat.o(136452);
  }
  
  final Editable c(Editable paramEditable)
  {
    AppMethodBeat.i(136437);
    paramEditable = super.c(paramEditable);
    if ((this.mXZ != null) && (!TextUtils.isEmpty(paramEditable))) {
      paramEditable.setSpan(this.mXZ, 0, paramEditable.length(), 18);
    }
    AppMethodBeat.o(136437);
    return paramEditable;
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(136457);
    if (bFz() <= getHeight())
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
    if (this.mXZ != null)
    {
      i = this.mXZ.height;
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
    if ((bDj()) && ((getParent() instanceof d)))
    {
      if ((paramMotionEvent.getActionMasked() != 0) || (((d)getParent()).H(paramMotionEvent)))
      {
        ag localag = this.njV;
        com.tencent.mm.plugin.appbrand.widget.base.a.a(localag.TAG, "processTouchEvent", paramMotionEvent);
        Object localObject2 = localag.nlt;
        i = paramMotionEvent.getActionIndex();
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((paramMotionEvent.getActionMasked() != 0) && (localag.nlw == null))
        {
          ae.v(localag.TAG, "[textscroll] no pointer down before, just return");
          localag.bFH();
          AppMethodBeat.o(136458);
          return false;
        }
        int j = 0;
        Object localObject1;
        Object localObject3;
        switch (paramMotionEvent.getActionMasked())
        {
        default: 
          localObject1 = localag.nlt;
          localObject3 = localag.nlt.getText();
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
            ae.v(localag.TAG, "[apptouch] ACTION_UP, pointerDown %B", new Object[] { Boolean.valueOf(localag.nlx) });
            if ((localag.nlx) && (localag.nlw != null))
            {
              localObject1 = e.cF(localag.nlt);
              if ((localag.nlv != null) && (Math.abs(localag.nlv.x - ((e.f)localObject1).x) <= 1.0F) && (Math.abs(localag.nlv.y - ((e.f)localObject1).y) <= 1.0F)) {
                break label398;
              }
              ae.v(localag.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
            }
            for (;;)
            {
              localag.bFH();
              break;
              if (!localag.a(localag.nlw, paramMotionEvent)) {
                ae.v(localag.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
              } else {
                ((ab)localObject2).M(f1, f2);
              }
            }
            localag.nlw = MotionEvent.obtain(paramMotionEvent);
            localag.nlv = e.cF((View)localObject2);
            if (localObject2 != null)
            {
              localObject1 = ((View)localObject2).getParent();
              if ((localObject1 != null) && ((localObject1 instanceof ViewGroup))) {
                if (((ViewGroup)localObject1).shouldDelayChildPressedState())
                {
                  i = 1;
                  ((EditText)localObject2).removeCallbacks(localag.nly);
                  if (i == 0) {
                    break label554;
                  }
                  ((EditText)localObject2).postDelayed(localag.nly, ViewConfiguration.getTapTimeout());
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
              localag.nly.run();
            }
            localag.bFH();
            break;
            f3 = localag.nlu;
            if ((f1 >= -f3) && (f2 >= -f3) && (f1 < ((View)localObject2).getWidth() + f3) && (f2 < ((View)localObject2).getHeight() + f3)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) && (localag.a(localag.nlw, paramMotionEvent))) {
                break label685;
              }
              localag.nlx = false;
              ((EditText)localObject2).removeCallbacks(localag.nly);
              ((EditText)localObject2).removeCallbacks(localag.nlz);
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
            localObject1 = ai.g((TextView)localObject1);
            if ((localObject1 != null) && (localObject1.length > 0) && (localObject1[0].nlL))
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
              if (!localObject2[0].nlK)
              {
                i = ViewConfiguration.get(((TextView)localObject1).getContext()).getScaledTouchSlop();
                if ((Math.abs(paramMotionEvent.getX() - localObject2[0].mX) >= i) || (Math.abs(paramMotionEvent.getY() - localObject2[0].mY) >= i)) {
                  localObject2[0].nlK = true;
                }
              }
              if (!localObject2[0].nlK) {
                break label236;
              }
              localObject2[0].nlL = true;
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
                if (!localObject2[0].nlM) {
                  break label1100;
                }
                localObject2[0].nlM = false;
                localObject2[0].nlK = false;
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
          ai.g((TextView)localObject1);
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
      this.njU = false;
      if (this.njT != null)
      {
        this.njT.recycle();
        this.njT = null;
      }
      if (this.njU)
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
        this.njT = MotionEvent.obtain(paramMotionEvent);
        this.njU = true;
        continue;
        if (this.njU)
        {
          f1 = this.njT.getX(this.njT.getActionIndex());
          f2 = this.njT.getY(this.njT.getActionIndex());
          f3 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
          float f4 = paramMotionEvent.getY(paramMotionEvent.getActionIndex());
          if ((Math.abs(f1 - f3) > this.lyr) || (Math.abs(f2 - f4) > this.lyr))
          {
            cancelLongPress();
            setPressed(false);
            this.njU = false;
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
    this.njS = paramBoolean;
    if (!this.njS) {}
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
    if (this.njO != null)
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
      paramArrayOfInputFilter[i] = this.njO;
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
    setLineSpacing(paramFloat, this.njQ);
    AppMethodBeat.o(136449);
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(136448);
    this.njP = paramFloat1;
    this.njQ = paramFloat2;
    b(0.0F, true);
    AppMethodBeat.o(136448);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(136446);
    super.setTextSize(paramInt, paramFloat);
    this.njR = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    b(0.0F, true);
    AppMethodBeat.o(136446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q
 * JD-Core Version:    0.7.0.1
 */