package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.b.a.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class CoordinatorLayout$d
  extends ViewGroup.MarginLayoutParams
{
  public int anchorGravity = 0;
  public int gravity = 0;
  CoordinatorLayout.Behavior hP;
  boolean hQ = false;
  public int hR = -1;
  int hS = -1;
  public int hT = 0;
  public int hU = 0;
  int hV;
  int hW;
  View hX;
  View hY;
  boolean hZ;
  private boolean ia;
  private boolean ib;
  boolean ic;
  final Rect ie = new Rect();
  Object jdField_if;
  
  public CoordinatorLayout$d()
  {
    super(-2, -2);
  }
  
  CoordinatorLayout$d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout_Layout);
    this.gravity = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
    this.hS = localTypedArray.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
    this.anchorGravity = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
    this.hR = localTypedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
    this.hT = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
    this.hU = localTypedArray.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
    this.hQ = localTypedArray.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
    if (this.hQ) {
      this.hP = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(a.c.CoordinatorLayout_Layout_layout_behavior));
    }
    localTypedArray.recycle();
    if (this.hP != null) {
      this.hP.a(this);
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
  
  final boolean I(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.ia;
    }
    return this.ib;
  }
  
  public final void a(CoordinatorLayout.Behavior paramBehavior)
  {
    if (this.hP != paramBehavior)
    {
      this.hP = paramBehavior;
      this.jdField_if = null;
      this.hQ = true;
      if (paramBehavior != null) {
        paramBehavior.a(this);
      }
    }
  }
  
  final void i(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ia = paramBoolean;
      return;
    }
    this.ib = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.d
 * JD-Core Version:    0.7.0.1
 */