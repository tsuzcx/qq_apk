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
  private CharSequence Cv;
  private CharSequence Cw;
  private TextView Nx;
  private View XF;
  private LinearLayout XG;
  private TextView XH;
  private int XI;
  private int XJ;
  public boolean XK;
  private int XL;
  private View lX;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772148);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.ActionMode, paramInt, 0);
    t.a(this, paramContext.getDrawable(3));
    this.XI = paramContext.getResourceId(1, 0);
    this.XJ = paramContext.getResourceId(2, 0);
    this.Xr = paramContext.getLayoutDimension(0, 0);
    this.XL = paramContext.getResourceId(5, 2130968589);
    paramContext.aoo.recycle();
  }
  
  private void gs()
  {
    int m = 8;
    int j = 1;
    if (this.XG == null)
    {
      LayoutInflater.from(getContext()).inflate(2130968584, this);
      this.XG = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.Nx = ((TextView)this.XG.findViewById(2131820922));
      this.XH = ((TextView)this.XG.findViewById(2131820923));
      if (this.XI != 0) {
        this.Nx.setTextAppearance(getContext(), this.XI);
      }
      if (this.XJ != 0) {
        this.XH.setTextAppearance(getContext(), this.XJ);
      }
    }
    this.Nx.setText(this.Cv);
    this.XH.setText(this.Cw);
    int i;
    label164:
    Object localObject;
    if (!TextUtils.isEmpty(this.Cv))
    {
      i = 1;
      if (TextUtils.isEmpty(this.Cw)) {
        break label231;
      }
      localObject = this.XH;
      if (j == 0) {
        break label236;
      }
    }
    label231:
    label236:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.XG;
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
      if (this.XG.getParent() == null) {
        addView(this.XG);
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
    if (this.XF == null)
    {
      this.XF = LayoutInflater.from(getContext()).inflate(this.XL, this, false);
      addView(this.XF);
    }
    for (;;)
    {
      this.XF.findViewById(2131820924).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.Xq != null) {
        this.Xq.gC();
      }
      this.Xq = new ActionMenuPresenter(getContext());
      this.Xq.gB();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.Xq, this.Xo);
      this.Xp = ((ActionMenuView)this.Xq.e(this));
      t.a(this.Xp, null);
      addView(this.Xp, localLayoutParams);
      return;
      if (this.XF.getParent() == null) {
        addView(this.XF);
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
    return this.Cw;
  }
  
  public CharSequence getTitle()
  {
    return this.Cv;
  }
  
  public final void gt()
  {
    if (this.XF == null) {
      gu();
    }
  }
  
  public final void gu()
  {
    removeAllViews();
    this.lX = null;
    this.Xp = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Xq != null)
    {
      this.Xq.hideOverflowMenu();
      this.Xq.gD();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.Cv);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = bh.bY(this);
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
      if (this.XF != null)
      {
        paramInt2 = i;
        if (this.XF.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.XF.getLayoutParams();
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
          paramInt2 = c(paramInt2 + a(this.XF, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.XG != null)
      {
        paramInt4 = paramInt2;
        if (this.lX == null)
        {
          paramInt4 = paramInt2;
          if (this.XG.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.XG, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.lX != null) {
        a(this.lX, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.Xp != null)
      {
        localObject = this.Xp;
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
    if (this.Xr > 0)
    {
      i = this.Xr;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.XF != null)
      {
        paramInt1 = k(this.XF, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.XF.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.Xp != null)
      {
        paramInt1 = paramInt2;
        if (this.Xp.getParent() == this) {
          paramInt1 = k(this.Xp, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.XG != null)
      {
        paramInt2 = paramInt1;
        if (this.lX == null)
        {
          if (!this.XK) {
            break label492;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.XG.measure(paramInt2, j);
          int i2 = this.XG.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label480;
          }
          j = 1;
          label288:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.XG;
          if (j == 0) {
            break label486;
          }
          paramInt1 = 0;
          label313:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label319:
      if (this.lX != null)
      {
        localObject = this.lX.getLayoutParams();
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
        this.lX.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label384:
      label404:
      if (this.Xr > 0) {
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
      paramInt2 = k(this.XG, paramInt1, j);
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
    this.Xr = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.lX != null) {
      removeView(this.lX);
    }
    this.lX = paramView;
    if ((paramView != null) && (this.XG != null))
    {
      removeView(this.XG);
      this.XG = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.Cw = paramCharSequence;
    gs();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    gs();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.XK) {
      requestLayout();
    }
    this.XK = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.Xq != null) {
      return this.Xq.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */