package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import lqx;

public abstract class AbsSpinner
  extends AdapterView
{
  private static final int jdField_a_of_type_Int = a("AbsSpinner_entries");
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  SpinnerAdapter jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  final lqx jdField_a_of_type_Lqx = new lqx(this);
  boolean jdField_a_of_type_Boolean;
  private Rect b;
  int d;
  int e;
  int f;
  int g = 0;
  int h = 0;
  int i = 0;
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    this.jdField_f_of_type_Int = 0;
    d();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_f_of_type_Int = 0;
    d();
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("AbsSpinner"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(jdField_a_of_type_Int);
    if (arrayOfCharSequence != null)
    {
      paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
      paramContext.setDropDownViewResource(17367049);
      setAdapter(paramContext);
    }
    paramAttributeSet.a();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (k)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (j < paramInt1)
      {
        paramInt2 = j | 0x1000000;
        continue;
        paramInt2 = j;
      }
    }
  }
  
  private void d()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.b = new Rect();
      localObject1 = this.b;
    }
    int j = getChildCount() - 1;
    while (j >= 0)
    {
      localObject2 = getChildAt(j);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.ao + j;
        }
      }
      j -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public View a()
  {
    if ((this.aA > 0) && (this.az >= 0)) {
      return getChildAt(this.az - this.ao);
    }
    return null;
  }
  
  public SpinnerAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  }
  
  protected AdapterView.AdapterDataSetObserver a()
  {
    return new AdapterView.AdapterDataSetObserver(this);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.aD)
    {
      this.jdField_a_of_type_Boolean = true;
      int j = this.az;
      h(paramInt);
      b(paramInt - j, paramBoolean);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int b()
  {
    return this.aA;
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void b()
  {
    this.q = false;
    this.o = false;
    removeAllViewsInLayout();
    this.aD = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    g(-1);
    h(-1);
    invalidate();
  }
  
  abstract void b(int paramInt, boolean paramBoolean);
  
  void c()
  {
    int k = getChildCount();
    lqx locallqx = this.jdField_a_of_type_Lqx;
    int m = this.ao;
    int j = 0;
    while (j < k)
    {
      locallqx.a(m + j, getChildAt(j));
      j += 1;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    int j;
    label56:
    label84:
    label112:
    int k;
    int m;
    if (this.mPaddingLeft > this.jdField_f_of_type_Int)
    {
      j = this.mPaddingLeft;
      ((Rect)localObject).left = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingTop <= this.g) {
        break label415;
      }
      j = this.mPaddingTop;
      ((Rect)localObject).top = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingRight <= this.h) {
        break label423;
      }
      j = this.mPaddingRight;
      ((Rect)localObject).right = j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingBottom <= this.i) {
        break label431;
      }
      j = this.mPaddingBottom;
      ((Rect)localObject).bottom = j;
      if (this.q) {
        p();
      }
      j = r();
      if ((j < 0) || (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter == null) || (j >= this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount())) {
        break label439;
      }
      View localView = this.jdField_a_of_type_Lqx.a(j);
      localObject = localView;
      if (localView == null) {
        localObject = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(j, null, this);
      }
      if (localObject != null) {
        this.jdField_a_of_type_Lqx.a(j, (View)localObject);
      }
      if (localObject == null) {
        break label439;
      }
      if (((View)localObject).getLayoutParams() == null)
      {
        this.jdField_a_of_type_Boolean = true;
        ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
        this.jdField_a_of_type_Boolean = false;
      }
      measureChild((View)localObject, paramInt1, paramInt2);
      k = a((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      j = b((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
      m = 0;
    }
    for (;;)
    {
      int n = j;
      if (m != 0)
      {
        m = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        n = j;
        k = m;
        if (i1 == 0)
        {
          n = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
          k = m;
        }
      }
      j = Math.max(k, getSuggestedMinimumHeight());
      k = Math.max(n, getSuggestedMinimumWidth());
      j = a(j, paramInt2, 0);
      setMeasuredDimension(a(k, paramInt1, 0), j);
      this.d = paramInt2;
      this.e = paramInt1;
      return;
      j = this.jdField_f_of_type_Int;
      break;
      label415:
      j = this.g;
      break label56;
      label423:
      j = this.h;
      break label84;
      label431:
      j = this.i;
      break label112;
      label439:
      m = 1;
      j = 0;
      k = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.q = true;
      this.o = true;
      this.jdField_a_of_type_Long = paramParcelable.jdField_a_of_type_Long;
      this.ar = paramParcelable.jdField_a_of_type_Int;
      this.as = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Long = a();
    if (localSavedState.jdField_a_of_type_Long >= 0L)
    {
      localSavedState.jdField_a_of_type_Int = r();
      return localSavedState;
    }
    localSavedState.jdField_a_of_type_Int = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int j = -1;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      b();
    }
    this.jdField_a_of_type_AndroidWidgetSpinnerAdapter = paramSpinnerAdapter;
    this.aD = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.aB = this.aA;
      this.aA = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount();
      w();
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = a();
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (this.aA > 0) {
        j = 0;
      }
      g(j);
      h(j);
      if (this.aA == 0) {
        x();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      w();
      b();
      x();
    }
  }
  
  public void setSelection(int paramInt)
  {
    h(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ao <= paramInt) && (paramInt <= this.ao + getChildCount() - 1)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramInt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */