package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ad
  implements af
{
  protected a BA = new a(paramContext, paramViewGroup, paramView, this);
  
  ad(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static ad L(View paramView)
  {
    Object localObject = paramView;
    label27:
    int j;
    int i;
    if (localObject != null) {
      if ((((View)localObject).getId() == 16908290) && ((localObject instanceof ViewGroup)))
      {
        localObject = (ViewGroup)localObject;
        if (localObject == null) {
          break label114;
        }
        j = ((ViewGroup)localObject).getChildCount();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label100;
      }
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof a))
      {
        return ((a)localView).BF;
        if (!(((View)localObject).getParent() instanceof ViewGroup)) {
          break;
        }
        localObject = (ViewGroup)((View)localObject).getParent();
        break;
        localObject = null;
        break label27;
      }
      i += 1;
    }
    label100:
    return new x(((ViewGroup)localObject).getContext(), (ViewGroup)localObject, paramView);
    label114:
    return null;
  }
  
  public final void add(Drawable paramDrawable)
  {
    a locala = this.BA;
    if (locala.BE == null) {
      locala.BE = new ArrayList();
    }
    if (!locala.BE.contains(paramDrawable))
    {
      locala.BE.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
  }
  
  public final void remove(Drawable paramDrawable)
  {
    a locala = this.BA;
    if (locala.BE != null)
    {
      locala.BE.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
  }
  
  static final class a
    extends ViewGroup
  {
    static Method BB;
    ViewGroup BC;
    View BD;
    ArrayList<Drawable> BE = null;
    ad BF;
    
    static
    {
      try
      {
        BB = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    
    a(Context paramContext, ViewGroup paramViewGroup, View paramView, ad paramad)
    {
      super();
      this.BC = paramViewGroup;
      this.BD = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.BF = paramad;
    }
    
    public final void add(View paramView)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.BC) && (localViewGroup.getParent() != null) && (t.aC(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.BC.getLocationOnScreen(arrayOfInt2);
          t.u(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          t.s(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView, getChildCount() - 1);
    }
    
    protected final void dispatchDraw(Canvas paramCanvas)
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.BC.getLocationOnScreen(arrayOfInt1);
      this.BD.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.BD.getWidth(), this.BD.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (this.BE == null) {}
      for (int i = 0;; i = this.BE.size())
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)this.BE.get(j)).draw(paramCanvas);
          j += 1;
        }
      }
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      if (this.BC != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((this.BC instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          int[] arrayOfInt3 = new int[2];
          this.BC.getLocationOnScreen(arrayOfInt2);
          this.BD.getLocationOnScreen(arrayOfInt3);
          arrayOfInt3[0] -= arrayOfInt2[0];
          arrayOfInt3[1] -= arrayOfInt2[1];
          paramRect.offset(arrayOfInt1[0], arrayOfInt1[1]);
          return super.invalidateChildInParent(paramArrayOfInt, paramRect);
        }
        invalidate(paramRect);
      }
      return null;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable)
    {
      invalidate(paramDrawable.getBounds());
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void remove(View paramView)
    {
      super.removeView(paramView);
      if ((getChildCount() == 0) && ((this.BE == null) || (this.BE.size() == 0))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.BC.removeView(this);
        }
        return;
      }
    }
    
    protected final boolean verifyDrawable(Drawable paramDrawable)
    {
      return (super.verifyDrawable(paramDrawable)) || ((this.BE != null) && (this.BE.contains(paramDrawable)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ad
 * JD-Core Version:    0.7.0.1
 */