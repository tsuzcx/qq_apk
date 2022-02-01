package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends a
{
  private CharSequence Fm;
  private CharSequence Kd;
  private TextView Vw;
  private View afE;
  private View afF;
  private LinearLayout afG;
  private TextView afH;
  private int afI;
  private int afJ;
  public boolean afK;
  private int afL;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968624);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.ActionMode, paramInt, 0);
    t.a(this, paramContext.getDrawable(0));
    this.afI = paramContext.getResourceId(5, 0);
    this.afJ = paramContext.getResourceId(4, 0);
    this.afq = paramContext.getLayoutDimension(3, 0);
    this.afL = paramContext.getResourceId(2, 2131492896);
    paramContext.awJ.recycle();
  }
  
  private void hV()
  {
    int m = 8;
    int j = 1;
    if (this.afG == null)
    {
      LayoutInflater.from(getContext()).inflate(2131492891, this);
      this.afG = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.Vw = ((TextView)this.afG.findViewById(2131296351));
      this.afH = ((TextView)this.afG.findViewById(2131296350));
      if (this.afI != 0) {
        this.Vw.setTextAppearance(getContext(), this.afI);
      }
      if (this.afJ != 0) {
        this.afH.setTextAppearance(getContext(), this.afJ);
      }
    }
    this.Vw.setText(this.Fm);
    this.afH.setText(this.Kd);
    int i;
    label164:
    Object localObject;
    if (!TextUtils.isEmpty(this.Fm))
    {
      i = 1;
      if (TextUtils.isEmpty(this.Kd)) {
        break label231;
      }
      localObject = this.afH;
      if (j == 0) {
        break label236;
      }
    }
    label231:
    label236:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.afG;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (this.afG.getParent() == null) {
        addView(this.afG);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label164;
    }
  }
  
  public final void c(final b paramb)
  {
    if (this.afE == null)
    {
      this.afE = LayoutInflater.from(getContext()).inflate(this.afL, this, false);
      addView(this.afE);
    }
    for (;;)
    {
      this.afE.findViewById(2131296373).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.afp != null) {
        this.afp.ig();
      }
      this.afp = new ActionMenuPresenter(getContext());
      this.afp.jdMethod_if();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.afp, this.afn);
      this.afo = ((ActionMenuView)this.afp.c(this));
      t.a(this.afo, null);
      addView(this.afo, localLayoutParams);
      return;
      if (this.afE.getParent() == null) {
        addView(this.afE);
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.Kd;
  }
  
  public CharSequence getTitle()
  {
    return this.Fm;
  }
  
  public final void hW()
  {
    if (this.afE == null) {
      hX();
    }
  }
  
  public final void hX()
  {
    removeAllViews();
    this.afF = null;
    this.afo = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.afp != null)
    {
      this.afp.hideOverflowMenu();
      this.afp.ih();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.Fm);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = bh.d(this);
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      paramInt2 = i;
      if (this.afE != null)
      {
        paramInt2 = i;
        if (this.afE.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.afE.getLayoutParams();
          if (!paramBoolean) {
            break label254;
          }
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
          label89:
          if (!paramBoolean) {
            break label263;
          }
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          label100:
          paramInt2 = c(i, paramInt2, paramBoolean);
          paramInt2 = c(paramInt2 + a(this.afE, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.afG != null)
      {
        paramInt4 = paramInt2;
        if (this.afF == null)
        {
          paramInt4 = paramInt2;
          if (this.afG.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.afG, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.afF != null) {
        a(this.afF, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.afo != null)
      {
        localObject = this.afo;
        if (paramBoolean) {
          break label286;
        }
      }
    }
    label263:
    label273:
    label286:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a((View)localObject, paramInt1, j, k, paramBoolean);
      return;
      i = getPaddingLeft();
      break;
      label254:
      paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      break label89;
      paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      break label100;
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
      break label213;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1073741824;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    }
    int n = View.MeasureSpec.getSize(paramInt1);
    int i;
    int m;
    int j;
    if (this.afq > 0)
    {
      i = this.afq;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.afE != null)
      {
        paramInt1 = j(this.afE, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.afE.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.afo != null)
      {
        paramInt1 = paramInt2;
        if (this.afo.getParent() == this) {
          paramInt1 = j(this.afo, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.afG != null)
      {
        paramInt2 = paramInt1;
        if (this.afF == null)
        {
          if (!this.afK) {
            break label492;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.afG.measure(paramInt2, j);
          int i2 = this.afG.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label480;
          }
          j = 1;
          label288:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.afG;
          if (j == 0) {
            break label486;
          }
          paramInt1 = 0;
          label313:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label319:
      if (this.afF != null)
      {
        localObject = this.afF.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject).width == -2) {
          break label506;
        }
        paramInt1 = 1073741824;
        label349:
        j = paramInt2;
        if (((ViewGroup.LayoutParams)localObject).width >= 0) {
          j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -2) {
          break label513;
        }
        paramInt2 = k;
        if (((ViewGroup.LayoutParams)localObject).height < 0) {
          break label520;
        }
        k = Math.min(((ViewGroup.LayoutParams)localObject).height, m);
        this.afF.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label384:
      label404:
      if (this.afq > 0) {
        break label535;
      }
      j = getChildCount();
      paramInt2 = 0;
      paramInt1 = 0;
      label440:
      if (paramInt2 >= j) {
        break label527;
      }
      i = getChildAt(paramInt2).getMeasuredHeight() + i1;
      if (i <= paramInt1) {
        break label543;
      }
      paramInt1 = i;
    }
    label513:
    label520:
    label527:
    label535:
    label543:
    for (;;)
    {
      paramInt2 += 1;
      break label440;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      label480:
      j = 0;
      break label288;
      label486:
      paramInt1 = 8;
      break label313;
      label492:
      paramInt2 = j(this.afG, paramInt1, j);
      break label319;
      label506:
      paramInt1 = -2147483648;
      break label349;
      paramInt2 = -2147483648;
      break label384;
      k = m;
      break label404;
      setMeasuredDimension(n, paramInt1);
      return;
      setMeasuredDimension(n, i);
      return;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.afq = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.afF != null) {
      removeView(this.afF);
    }
    this.afF = paramView;
    if ((paramView != null) && (this.afG != null))
    {
      removeView(this.afG);
      this.afG = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.Kd = paramCharSequence;
    hV();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    hV();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.afK) {
      requestLayout();
    }
    this.afK = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.afp != null) {
      return this.afp.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */