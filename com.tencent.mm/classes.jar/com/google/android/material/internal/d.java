package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static final ThreadLocal<Matrix> dvl;
  private static final ThreadLocal<RectF> dvm;
  
  static
  {
    AppMethodBeat.i(209323);
    dvl = new ThreadLocal();
    dvm = new ThreadLocal();
    AppMethodBeat.o(209323);
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    AppMethodBeat.i(209309);
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = (Matrix)dvl.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      dvl.set(localMatrix);
    }
    for (;;)
    {
      a(paramViewGroup, paramView, localMatrix);
      paramView = (RectF)dvm.get();
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new RectF();
        dvm.set(paramViewGroup);
      }
      paramViewGroup.set(paramRect);
      localMatrix.mapRect(paramViewGroup);
      paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
      AppMethodBeat.o(209309);
      return;
      localMatrix.reset();
    }
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(209315);
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
    AppMethodBeat.o(209315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.d
 * JD-Core Version:    0.7.0.1
 */