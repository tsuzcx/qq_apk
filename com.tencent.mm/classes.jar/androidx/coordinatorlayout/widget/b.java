package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final ThreadLocal<Matrix> bnL;
  private static final ThreadLocal<RectF> bnM;
  
  static
  {
    AppMethodBeat.i(193142);
    bnL = new ThreadLocal();
    bnM = new ThreadLocal();
    AppMethodBeat.o(193142);
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    AppMethodBeat.i(193121);
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = (Matrix)bnL.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      bnL.set(localMatrix);
    }
    for (;;)
    {
      a(paramViewGroup, paramView, localMatrix);
      paramView = (RectF)bnM.get();
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new RectF();
        bnM.set(paramViewGroup);
      }
      paramViewGroup.set(paramRect);
      localMatrix.mapRect(paramViewGroup);
      paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
      AppMethodBeat.o(193121);
      return;
      localMatrix.reset();
    }
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193134);
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
    AppMethodBeat.o(193134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */