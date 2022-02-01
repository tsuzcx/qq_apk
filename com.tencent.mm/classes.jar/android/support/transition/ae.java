package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ae
  implements ag
{
  protected a DB = new a(paramContext, paramViewGroup, paramView, this);
  
  ae(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static ae M(View paramView)
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
        return ((a)localView).DG;
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
    return new y(((ViewGroup)localObject).getContext(), (ViewGroup)localObject, paramView);
    label114:
    return null;
  }
  
  public final void add(Drawable paramDrawable)
  {
    a locala = this.DB;
    if (locala.DF == null) {
      locala.DF = new ArrayList();
    }
    if (!locala.DF.contains(paramDrawable))
    {
      locala.DF.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
  }
  
  public final void remove(Drawable paramDrawable)
  {
    a locala = this.DB;
    if (locala.DF != null)
    {
      locala.DF.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
  }
  
  static final class a
    extends ViewGroup
  {
    static Method DC;
    ViewGroup DD;
    View DE;
    ArrayList<Drawable> DF = null;
    ae DG;
    
    static
    {
      try
      {
        DC = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    
    a(Context paramContext, ViewGroup paramViewGroup, View paramView, ae paramae)
    {
      super();
      this.DD = paramViewGroup;
      this.DE = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      this.DG = paramae;
    }
    
    public final void add(View paramView)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != this.DD) && (localViewGroup.getParent() != null) && (u.aD(localViewGroup)))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          this.DD.getLocationOnScreen(arrayOfInt2);
          u.u(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          u.s(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
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
      this.DD.getLocationOnScreen(arrayOfInt1);
      this.DE.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, this.DE.getWidth(), this.DE.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (this.DF == null) {}
      for (int i = 0;; i = this.DF.size())
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)this.DF.get(j)).draw(paramCanvas);
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
      if (this.DD != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((this.DD instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          int[] arrayOfInt3 = new int[2];
          this.DD.getLocationOnScreen(arrayOfInt2);
          this.DE.getLocationOnScreen(arrayOfInt3);
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
      if ((getChildCount() == 0) && ((this.DF == null) || (this.DF.size() == 0))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.DD.removeView(this);
        }
        return;
      }
    }
    
    protected final boolean verifyDrawable(Drawable paramDrawable)
    {
      return (super.verifyDrawable(paramDrawable)) || ((this.DF != null) && (this.DF.contains(paramDrawable)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ae
 * JD-Core Version:    0.7.0.1
 */