package android.support.constraint;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class Barrier
  extends ConstraintHelper
{
  public static final int BOTTOM = 3;
  public static final int END = 6;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int START = 5;
  public static final int TOP = 2;
  private android.support.constraint.solver.widgets.Barrier mBarrier;
  private int mIndicatedType;
  private int mResolvedType;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setVisibility(8);
  }
  
  public boolean allowsGoneWidget()
  {
    return this.mBarrier.allowsGoneWidget();
  }
  
  public int getType()
  {
    return this.mIndicatedType;
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    this.mBarrier = new android.support.constraint.solver.widgets.Barrier();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == 6) {
          setType(paramAttributeSet.getInt(k, 0));
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 5) {
            this.mBarrier.setAllowsGoneWidget(paramAttributeSet.getBoolean(k, true));
          }
        }
      }
    }
    this.mHelperWidget = this.mBarrier;
    validateParams();
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.mBarrier.setAllowsGoneWidget(paramBoolean);
  }
  
  public void setType(int paramInt)
  {
    this.mIndicatedType = paramInt;
    this.mResolvedType = paramInt;
    if (Build.VERSION.SDK_INT < 17) {
      if (this.mIndicatedType == 5) {
        this.mResolvedType = 0;
      }
    }
    for (;;)
    {
      this.mBarrier.setBarrierType(this.mResolvedType);
      return;
      if (this.mIndicatedType == 6)
      {
        this.mResolvedType = 1;
        continue;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt != 0)
          {
            if (this.mIndicatedType == 5)
            {
              this.mResolvedType = 1;
              break;
              paramInt = 0;
              continue;
            }
            if (this.mIndicatedType != 6) {
              break;
            }
            this.mResolvedType = 0;
            break;
          }
        }
        if (this.mIndicatedType == 5) {
          this.mResolvedType = 0;
        } else if (this.mIndicatedType == 6) {
          this.mResolvedType = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.Barrier
 * JD-Core Version:    0.7.0.1
 */