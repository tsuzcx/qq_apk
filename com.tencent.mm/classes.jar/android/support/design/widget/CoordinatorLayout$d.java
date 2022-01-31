package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.b.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class CoordinatorLayout$d
  extends ViewGroup.MarginLayoutParams
{
  public int anchorGravity = 0;
  public int gravity = 0;
  CoordinatorLayout.Behavior iM;
  boolean iN = false;
  public int iO = -1;
  int iP = -1;
  public int iQ = 0;
  public int iR = 0;
  int iS;
  int iT;
  View iU;
  View iV;
  boolean iW;
  private boolean iX;
  private boolean iY;
  boolean iZ;
  final Rect ja = new Rect();
  Object jb;
  
  public CoordinatorLayout$d()
  {
    super(-2, -2);
  }
  
  CoordinatorLayout$d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.CoordinatorLayout_Layout);
    this.gravity = localTypedArray.getInteger(0, 0);
    this.iP = localTypedArray.getResourceId(2, -1);
    this.anchorGravity = localTypedArray.getInteger(4, 0);
    this.iO = localTypedArray.getInteger(3, -1);
    this.iQ = localTypedArray.getInt(5, 0);
    this.iR = localTypedArray.getInt(6, 0);
    this.iN = localTypedArray.hasValue(1);
    if (this.iN) {
      this.iM = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(1));
    }
    localTypedArray.recycle();
    if (this.iM != null) {
      this.iM.a(this);
    }
  }
  
  public CoordinatorLayout$d(d paramd)
  {
    super(paramd);
  }
  
  public CoordinatorLayout$d(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  final boolean H(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.iX;
    }
    return this.iY;
  }
  
  public final void a(CoordinatorLayout.Behavior paramBehavior)
  {
    if (this.iM != paramBehavior)
    {
      this.iM = paramBehavior;
      this.jb = null;
      this.iN = true;
      if (paramBehavior != null) {
        paramBehavior.a(this);
      }
    }
  }
  
  final boolean bq()
  {
    return (this.iU == null) && (this.iP != -1);
  }
  
  final void e(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.iX = paramBoolean;
      return;
    }
    this.iY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.d
 * JD-Core Version:    0.7.0.1
 */