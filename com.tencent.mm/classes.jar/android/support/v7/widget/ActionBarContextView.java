package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.u;
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
  private CharSequence Hn;
  private CharSequence Md;
  private TextView Xy;
  private View ahI;
  private View ahJ;
  private LinearLayout ahK;
  private TextView ahL;
  private int ahM;
  private int ahN;
  public boolean ahO;
  private int ahP;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968625);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.ActionMode, paramInt, 0);
    u.a(this, paramContext.getDrawable(0));
    this.ahM = paramContext.getResourceId(5, 0);
    this.ahN = paramContext.getResourceId(4, 0);
    this.ahu = paramContext.getLayoutDimension(3, 0);
    this.ahP = paramContext.getResourceId(2, 2131492913);
    paramContext.ayy.recycle();
  }
  
  private void iw()
  {
    int m = 8;
    int j = 1;
    if (this.ahK == null)
    {
      LayoutInflater.from(getContext()).inflate(2131492908, this);
      this.ahK = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.Xy = ((TextView)this.ahK.findViewById(2131296373));
      this.ahL = ((TextView)this.ahK.findViewById(2131296372));
      if (this.ahM != 0) {
        this.Xy.setTextAppearance(getContext(), this.ahM);
      }
      if (this.ahN != 0) {
        this.ahL.setTextAppearance(getContext(), this.ahN);
      }
    }
    this.Xy.setText(this.Hn);
    this.ahL.setText(this.Md);
    int i;
    label164:
    Object localObject;
    if (!TextUtils.isEmpty(this.Hn))
    {
      i = 1;
      if (TextUtils.isEmpty(this.Md)) {
        break label231;
      }
      localObject = this.ahL;
      if (j == 0) {
        break label236;
      }
    }
    label231:
    label236:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.ahK;
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
      if (this.ahK.getParent() == null) {
        addView(this.ahK);
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
    if (this.ahI == null)
    {
      this.ahI = LayoutInflater.from(getContext()).inflate(this.ahP, this, false);
      addView(this.ahI);
    }
    for (;;)
    {
      this.ahI.findViewById(2131296398).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.aht != null) {
        this.aht.iG();
      }
      this.aht = new ActionMenuPresenter(getContext());
      this.aht.iF();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.aht, this.ahr);
      this.ahs = ((ActionMenuView)this.aht.c(this));
      u.a(this.ahs, null);
      addView(this.ahs, localLayoutParams);
      return;
      if (this.ahI.getParent() == null) {
        addView(this.ahI);
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
    return this.Md;
  }
  
  public CharSequence getTitle()
  {
    return this.Hn;
  }
  
  public final void ix()
  {
    if (this.ahI == null) {
      iy();
    }
  }
  
  public final void iy()
  {
    removeAllViews();
    this.ahJ = null;
    this.ahs = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.aht != null)
    {
      this.aht.hideOverflowMenu();
      this.aht.iH();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.Hn);
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
      if (this.ahI != null)
      {
        paramInt2 = i;
        if (this.ahI.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.ahI.getLayoutParams();
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
          paramInt2 = c(paramInt2 + a(this.ahI, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.ahK != null)
      {
        paramInt4 = paramInt2;
        if (this.ahJ == null)
        {
          paramInt4 = paramInt2;
          if (this.ahK.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.ahK, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.ahJ != null) {
        a(this.ahJ, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.ahs != null)
      {
        localObject = this.ahs;
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
    if (this.ahu > 0)
    {
      i = this.ahu;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.ahI != null)
      {
        paramInt1 = j(this.ahI, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.ahI.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.ahs != null)
      {
        paramInt1 = paramInt2;
        if (this.ahs.getParent() == this) {
          paramInt1 = j(this.ahs, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.ahK != null)
      {
        paramInt2 = paramInt1;
        if (this.ahJ == null)
        {
          if (!this.ahO) {
            break label492;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.ahK.measure(paramInt2, j);
          int i2 = this.ahK.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label480;
          }
          j = 1;
          label288:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.ahK;
          if (j == 0) {
            break label486;
          }
          paramInt1 = 0;
          label313:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label319:
      if (this.ahJ != null)
      {
        localObject = this.ahJ.getLayoutParams();
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
        this.ahJ.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label384:
      label404:
      if (this.ahu > 0) {
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
      paramInt2 = j(this.ahK, paramInt1, j);
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
    this.ahu = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.ahJ != null) {
      removeView(this.ahJ);
    }
    this.ahJ = paramView;
    if ((paramView != null) && (this.ahK != null))
    {
      removeView(this.ahK);
      this.ahK = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.Md = paramCharSequence;
    iw();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    iw();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.ahO) {
      requestLayout();
    }
    this.ahO = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.aht != null) {
      return this.aht.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */