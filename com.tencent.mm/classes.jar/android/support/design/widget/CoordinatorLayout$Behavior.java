package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class CoordinatorLayout$Behavior<V extends View>
{
  public CoordinatorLayout$Behavior() {}
  
  public CoordinatorLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public static ab b(ab paramab)
  {
    return paramab;
  }
  
  public void a(CoordinatorLayout.d paramd) {}
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramV, paramView);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      a(paramV, paramView, paramInt1, paramArrayOfInt);
    }
  }
  
  @Deprecated
  public void a(V paramV, View paramView) {}
  
  @Deprecated
  public void a(V paramV, View paramView, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return s(paramInt1);
    }
    return false;
  }
  
  public boolean a(V paramV, Rect paramRect)
  {
    return false;
  }
  
  public Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return View.BaseSavedState.EMPTY_STATE;
  }
  
  public void b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {}
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean d(View paramView)
  {
    return false;
  }
  
  @Deprecated
  public boolean s(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.Behavior
 * JD-Core Version:    0.7.0.1
 */