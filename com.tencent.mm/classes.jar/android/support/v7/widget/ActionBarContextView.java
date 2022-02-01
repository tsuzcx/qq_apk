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
  private CharSequence Hd;
  private CharSequence LT;
  private TextView Xl;
  private int ahA;
  public boolean ahB;
  private int ahC;
  private View ahv;
  private View ahw;
  private LinearLayout ahx;
  private TextView ahy;
  private int ahz;
  
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
    this.ahz = paramContext.getResourceId(5, 0);
    this.ahA = paramContext.getResourceId(4, 0);
    this.ahh = paramContext.getLayoutDimension(3, 0);
    this.ahC = paramContext.getResourceId(2, 2131492896);
    paramContext.ayA.recycle();
  }
  
  private void im()
  {
    int m = 8;
    int j = 1;
    if (this.ahx == null)
    {
      LayoutInflater.from(getContext()).inflate(2131492891, this);
      this.ahx = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.Xl = ((TextView)this.ahx.findViewById(2131296351));
      this.ahy = ((TextView)this.ahx.findViewById(2131296350));
      if (this.ahz != 0) {
        this.Xl.setTextAppearance(getContext(), this.ahz);
      }
      if (this.ahA != 0) {
        this.ahy.setTextAppearance(getContext(), this.ahA);
      }
    }
    this.Xl.setText(this.Hd);
    this.ahy.setText(this.LT);
    int i;
    label164:
    Object localObject;
    if (!TextUtils.isEmpty(this.Hd))
    {
      i = 1;
      if (TextUtils.isEmpty(this.LT)) {
        break label231;
      }
      localObject = this.ahy;
      if (j == 0) {
        break label236;
      }
    }
    label231:
    label236:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.ahx;
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
      if (this.ahx.getParent() == null) {
        addView(this.ahx);
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
    if (this.ahv == null)
    {
      this.ahv = LayoutInflater.from(getContext()).inflate(this.ahC, this, false);
      addView(this.ahv);
    }
    for (;;)
    {
      this.ahv.findViewById(2131296373).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.ahg != null) {
        this.ahg.ix();
      }
      this.ahg = new ActionMenuPresenter(getContext());
      this.ahg.iw();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.ahg, this.ahe);
      this.ahf = ((ActionMenuView)this.ahg.c(this));
      t.a(this.ahf, null);
      addView(this.ahf, localLayoutParams);
      return;
      if (this.ahv.getParent() == null) {
        addView(this.ahv);
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
    return this.LT;
  }
  
  public CharSequence getTitle()
  {
    return this.Hd;
  }
  
  public final void in()
  {
    if (this.ahv == null) {
      ip();
    }
  }
  
  public final void ip()
  {
    removeAllViews();
    this.ahw = null;
    this.ahf = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.ahg != null)
    {
      this.ahg.hideOverflowMenu();
      this.ahg.iy();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.Hd);
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
      if (this.ahv != null)
      {
        paramInt2 = i;
        if (this.ahv.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.ahv.getLayoutParams();
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
          paramInt2 = c(paramInt2 + a(this.ahv, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.ahx != null)
      {
        paramInt4 = paramInt2;
        if (this.ahw == null)
        {
          paramInt4 = paramInt2;
          if (this.ahx.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.ahx, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.ahw != null) {
        a(this.ahw, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.ahf != null)
      {
        localObject = this.ahf;
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
    if (this.ahh > 0)
    {
      i = this.ahh;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.ahv != null)
      {
        paramInt1 = j(this.ahv, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.ahv.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.ahf != null)
      {
        paramInt1 = paramInt2;
        if (this.ahf.getParent() == this) {
          paramInt1 = j(this.ahf, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.ahx != null)
      {
        paramInt2 = paramInt1;
        if (this.ahw == null)
        {
          if (!this.ahB) {
            break label492;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.ahx.measure(paramInt2, j);
          int i2 = this.ahx.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label480;
          }
          j = 1;
          label288:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.ahx;
          if (j == 0) {
            break label486;
          }
          paramInt1 = 0;
          label313:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label319:
      if (this.ahw != null)
      {
        localObject = this.ahw.getLayoutParams();
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
        this.ahw.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label384:
      label404:
      if (this.ahh > 0) {
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
      paramInt2 = j(this.ahx, paramInt1, j);
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
    this.ahh = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.ahw != null) {
      removeView(this.ahw);
    }
    this.ahw = paramView;
    if ((paramView != null) && (this.ahx != null))
    {
      removeView(this.ahx);
      this.ahx = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.LT = paramCharSequence;
    im();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    im();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.ahB) {
      requestLayout();
    }
    this.ahB = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.ahg != null) {
      return this.ahg.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */