package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;

class af
  implements ah
{
  protected a asT;
  
  af(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(193186);
    this.asT = new a(paramContext, paramViewGroup, paramView, this);
    AppMethodBeat.o(193186);
  }
  
  static af bL(View paramView)
  {
    AppMethodBeat.i(193191);
    Object localObject = paramView;
    label32:
    int j;
    int i;
    if (localObject != null) {
      if ((((View)localObject).getId() == 16908290) && ((localObject instanceof ViewGroup)))
      {
        localObject = (ViewGroup)localObject;
        if (localObject == null) {
          break label133;
        }
        j = ((ViewGroup)localObject).getChildCount();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof a))
      {
        paramView = ((a)localView).asY;
        AppMethodBeat.o(193191);
        return paramView;
        if (!(((View)localObject).getParent() instanceof ViewGroup)) {
          break;
        }
        localObject = (ViewGroup)((View)localObject).getParent();
        break;
        localObject = null;
        break label32;
      }
      i += 1;
    }
    label112:
    paramView = new z(((ViewGroup)localObject).getContext(), (ViewGroup)localObject, paramView);
    AppMethodBeat.o(193191);
    return paramView;
    label133:
    AppMethodBeat.o(193191);
    return null;
  }
  
  public final void u(Drawable paramDrawable)
  {
    AppMethodBeat.i(193194);
    a locala = this.asT;
    if (locala.asX == null) {
      locala.asX = new ArrayList();
    }
    if (!locala.asX.contains(paramDrawable))
    {
      locala.asX.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
    AppMethodBeat.o(193194);
  }
  
  public final void v(Drawable paramDrawable)
  {
    AppMethodBeat.i(193197);
    a locala = this.asT;
    if (locala.asX != null)
    {
      locala.asX.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
    AppMethodBeat.o(193197);
  }
  
  static final class a
    extends ViewGroup
  {
    static Method asU;
    ViewGroup asV;
    View asW;
    ArrayList<Drawable> asX;
    af asY;
    
    static
    {
      AppMethodBeat.i(193179);
      try
      {
        asU = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        AppMethodBeat.o(193179);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        AppMethodBeat.o(193179);
      }
    }
    
    a(Context paramContext, ViewGroup paramViewGroup, View paramView, af paramaf)
    {
      super();
      AppMethodBeat.i(193157);
      this.asX = null;
      this.asV = paramViewGroup;
      this.asW = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.asY = paramaf;
      AppMethodBeat.o(193157);
    }
    
    public final void bJ(View paramView)
    {
      AppMethodBeat.i(193162);
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.asV) && (localViewGroup.getParent() != null) && (w.al(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.asV.getLocationOnScreen(arrayOfInt2);
          w.u(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          w.s(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView, getChildCount() - 1);
      AppMethodBeat.o(193162);
    }
    
    public final void bK(View paramView)
    {
      AppMethodBeat.i(193166);
      super.removeView(paramView);
      if ((getChildCount() == 0) && ((this.asX == null) || (this.asX.size() == 0))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.asV.removeView(this);
        }
        AppMethodBeat.o(193166);
        return;
      }
    }
    
    protected final void dispatchDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(193173);
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.asV.getLocationOnScreen(arrayOfInt1);
      this.asW.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.asW.getWidth(), this.asW.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (this.asX == null) {}
      for (int i = 0;; i = this.asX.size())
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)this.asX.get(j)).draw(paramCanvas);
          j += 1;
        }
      }
      AppMethodBeat.o(193173);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      AppMethodBeat.i(193178);
      if (this.asV != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((this.asV instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          int[] arrayOfInt3 = new int[2];
          this.asV.getLocationOnScreen(arrayOfInt2);
          this.asW.getLocationOnScreen(arrayOfInt3);
          arrayOfInt3[0] -= arrayOfInt2[0];
          arrayOfInt3[1] -= arrayOfInt2[1];
          paramRect.offset(arrayOfInt1[0], arrayOfInt1[1]);
          paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
          AppMethodBeat.o(193178);
          return paramArrayOfInt;
        }
        invalidate(paramRect);
      }
      AppMethodBeat.o(193178);
      return null;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(193168);
      invalidate(paramDrawable.getBounds());
      AppMethodBeat.o(193168);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    protected final boolean verifyDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(193160);
      if ((super.verifyDrawable(paramDrawable)) || ((this.asX != null) && (this.asX.contains(paramDrawable))))
      {
        AppMethodBeat.o(193160);
        return true;
      }
      AppMethodBeat.o(193160);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.af
 * JD-Core Version:    0.7.0.1
 */