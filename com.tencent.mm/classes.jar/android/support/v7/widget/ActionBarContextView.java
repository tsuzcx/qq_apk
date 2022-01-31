package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.j;
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
  private CharSequence BM;
  private CharSequence BN;
  private TextView NI;
  private View WS;
  private LinearLayout WT;
  private TextView WV;
  private int WW;
  private int WX;
  public boolean WY;
  private int WZ;
  private View la;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ax.a(paramContext, paramAttributeSet, a.j.ActionMode, paramInt, 0);
    q.a(this, paramContext.getDrawable(a.j.ActionMode_background));
    this.WW = paramContext.getResourceId(a.j.ActionMode_titleTextStyle, 0);
    this.WX = paramContext.getResourceId(a.j.ActionMode_subtitleTextStyle, 0);
    this.WE = paramContext.getLayoutDimension(a.j.ActionMode_height, 0);
    this.WZ = paramContext.getResourceId(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
    paramContext.alZ.recycle();
  }
  
  private void fz()
  {
    int m = 8;
    int j = 1;
    if (this.WT == null)
    {
      LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
      this.WT = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.NI = ((TextView)this.WT.findViewById(a.f.action_bar_title));
      this.WV = ((TextView)this.WT.findViewById(a.f.action_bar_subtitle));
      if (this.WW != 0) {
        this.NI.setTextAppearance(getContext(), this.WW);
      }
      if (this.WX != 0) {
        this.WV.setTextAppearance(getContext(), this.WX);
      }
    }
    this.NI.setText(this.BM);
    this.WV.setText(this.BN);
    int i;
    label167:
    Object localObject;
    if (!TextUtils.isEmpty(this.BM))
    {
      i = 1;
      if (TextUtils.isEmpty(this.BN)) {
        break label234;
      }
      localObject = this.WV;
      if (j == 0) {
        break label239;
      }
    }
    label234:
    label239:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.WT;
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
      if (this.WT.getParent() == null) {
        addView(this.WT);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label167;
    }
  }
  
  public final void c(final b paramb)
  {
    if (this.WS == null)
    {
      this.WS = LayoutInflater.from(getContext()).inflate(this.WZ, this, false);
      addView(this.WS);
    }
    for (;;)
    {
      this.WS.findViewById(a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (h)paramb.getMenu();
      if (this.WD != null) {
        this.WD.fI();
      }
      this.WD = new ActionMenuPresenter(getContext());
      this.WD.fH();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.WD, this.WB);
      this.WC = ((ActionMenuView)this.WD.g(this));
      q.a(this.WC, null);
      addView(this.WC, localLayoutParams);
      return;
      if (this.WS.getParent() == null) {
        addView(this.WS);
      }
    }
  }
  
  public final void fA()
  {
    if (this.WS == null) {
      fB();
    }
  }
  
  public final void fB()
  {
    removeAllViews();
    this.la = null;
    this.WC = null;
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
    return this.BN;
  }
  
  public CharSequence getTitle()
  {
    return this.BM;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.WD != null)
    {
      this.WD.hideOverflowMenu();
      this.WD.fJ();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.BM);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = bf.bF(this);
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
      if (this.WS != null)
      {
        paramInt2 = i;
        if (this.WS.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.WS.getLayoutParams();
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
          paramInt2 = c(paramInt2 + a(this.WS, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.WT != null)
      {
        paramInt4 = paramInt2;
        if (this.la == null)
        {
          paramInt4 = paramInt2;
          if (this.WT.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.WT, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.la != null) {
        a(this.la, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.WC != null)
      {
        localObject = this.WC;
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
    if (this.WE > 0)
    {
      i = this.WE;
      int i1 = getPaddingTop() + getPaddingBottom();
      paramInt1 = n - getPaddingLeft() - getPaddingRight();
      m = i - i1;
      j = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.WS != null)
      {
        paramInt1 = g(this.WS, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.WS.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.WC != null)
      {
        paramInt1 = paramInt2;
        if (this.WC.getParent() == this) {
          paramInt1 = g(this.WC, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.WT != null)
      {
        paramInt2 = paramInt1;
        if (this.la == null)
        {
          if (!this.WY) {
            break label492;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.WT.measure(paramInt2, j);
          int i2 = this.WT.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label480;
          }
          j = 1;
          label288:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i2;
          }
          localObject = this.WT;
          if (j == 0) {
            break label486;
          }
          paramInt1 = 0;
          label313:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label319:
      if (this.la != null)
      {
        localObject = this.la.getLayoutParams();
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
        this.la.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label384:
      label404:
      if (this.WE > 0) {
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
      paramInt2 = g(this.WT, paramInt1, j);
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
    this.WE = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.la != null) {
      removeView(this.la);
    }
    this.la = paramView;
    if ((paramView != null) && (this.WT != null))
    {
      removeView(this.WT);
      this.WT = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.BN = paramCharSequence;
    fz();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    fz();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.WY) {
      requestLayout();
    }
    this.WY = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.WD != null) {
      return this.WD.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */