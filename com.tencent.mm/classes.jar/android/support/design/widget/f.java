package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class f
{
  private static final ThreadLocal<Matrix> pb = new ThreadLocal();
  private static final ThreadLocal<RectF> pc = new ThreadLocal();
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = (Matrix)pb.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      pb.set(localMatrix);
    }
    for (;;)
    {
      a(paramViewGroup, paramView, localMatrix);
      paramView = (RectF)pc.get();
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new RectF();
        pc.set(paramViewGroup);
      }
      paramViewGroup.set(paramRect);
      localMatrix.mapRect(paramViewGroup);
      paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
      return;
      localMatrix.reset();
    }
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if (((localObject instanceof View)) && (localObject != paramViewParent))
    {
      localObject = (View)localObject;
      a(paramViewParent, (View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity()) {
      paramMatrix.preConcat(paramView.getMatrix());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.f
 * JD-Core Version:    0.7.0.1
 */