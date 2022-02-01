package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;

class af
  implements ah
{
  protected a chC;
  
  af(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(201542);
    this.chC = new a(paramContext, paramViewGroup, paramView, this);
    AppMethodBeat.o(201542);
  }
  
  static af cf(View paramView)
  {
    AppMethodBeat.i(201552);
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
        paramView = ((a)localView).chH;
        AppMethodBeat.o(201552);
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
    AppMethodBeat.o(201552);
    return paramView;
    label133:
    AppMethodBeat.o(201552);
    return null;
  }
  
  public final void x(Drawable paramDrawable)
  {
    AppMethodBeat.i(201567);
    a locala = this.chC;
    if (locala.chG == null) {
      locala.chG = new ArrayList();
    }
    if (!locala.chG.contains(paramDrawable))
    {
      locala.chG.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
    AppMethodBeat.o(201567);
  }
  
  public final void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(201574);
    a locala = this.chC;
    if (locala.chG != null)
    {
      locala.chG.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
    AppMethodBeat.o(201574);
  }
  
  static final class a
    extends ViewGroup
  {
    static Method chD;
    ViewGroup chE;
    View chF;
    ArrayList<Drawable> chG;
    af chH;
    
    static
    {
      AppMethodBeat.i(201308);
      try
      {
        chD = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        AppMethodBeat.o(201308);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        AppMethodBeat.o(201308);
      }
    }
    
    a(Context paramContext, ViewGroup paramViewGroup, View paramView, af paramaf)
    {
      super();
      AppMethodBeat.i(201298);
      this.chG = null;
      this.chE = paramViewGroup;
      this.chF = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.chH = paramaf;
      AppMethodBeat.o(201298);
    }
    
    public final void cd(View paramView)
    {
      AppMethodBeat.i(201332);
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.chE) && (localViewGroup.getParent() != null) && (androidx.core.g.z.ay(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.chE.getLocationOnScreen(arrayOfInt2);
          androidx.core.g.z.u(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          androidx.core.g.z.s(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView, getChildCount() - 1);
      AppMethodBeat.o(201332);
    }
    
    public final void ce(View paramView)
    {
      AppMethodBeat.i(201340);
      super.removeView(paramView);
      if ((getChildCount() == 0) && ((this.chG == null) || (this.chG.size() == 0))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.chE.removeView(this);
        }
        AppMethodBeat.o(201340);
        return;
      }
    }
    
    protected final void dispatchDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(201358);
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.chE.getLocationOnScreen(arrayOfInt1);
      this.chF.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.chF.getWidth(), this.chF.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (this.chG == null) {}
      for (int i = 0;; i = this.chG.size())
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)this.chG.get(j)).draw(paramCanvas);
          j += 1;
        }
      }
      AppMethodBeat.o(201358);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      AppMethodBeat.i(201374);
      if (this.chE != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((this.chE instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          int[] arrayOfInt3 = new int[2];
          this.chE.getLocationOnScreen(arrayOfInt2);
          this.chF.getLocationOnScreen(arrayOfInt3);
          arrayOfInt3[0] -= arrayOfInt2[0];
          arrayOfInt3[1] -= arrayOfInt2[1];
          paramRect.offset(arrayOfInt1[0], arrayOfInt1[1]);
          paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
          AppMethodBeat.o(201374);
          return paramArrayOfInt;
        }
        invalidate(paramRect);
      }
      AppMethodBeat.o(201374);
      return null;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(201348);
      invalidate(paramDrawable.getBounds());
      AppMethodBeat.o(201348);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    protected final boolean verifyDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(201321);
      if ((super.verifyDrawable(paramDrawable)) || ((this.chG != null) && (this.chG.contains(paramDrawable))))
      {
        AppMethodBeat.o(201321);
        return true;
      }
      AppMethodBeat.o(201321);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.af
 * JD-Core Version:    0.7.0.1
 */