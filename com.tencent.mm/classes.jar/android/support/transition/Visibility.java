package android.support.transition;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  private static final String[] qo = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sG);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static Visibility.b b(ah paramah1, ah paramah2)
  {
    Visibility.b localb = new Visibility.b((byte)0);
    localb.uU = false;
    localb.uV = false;
    if ((paramah1 != null) && (paramah1.values.containsKey("android:visibility:visibility")))
    {
      localb.uW = ((Integer)paramah1.values.get("android:visibility:visibility")).intValue();
      localb.rJ = ((ViewGroup)paramah1.values.get("android:visibility:parent"));
      if ((paramah2 == null) || (!paramah2.values.containsKey("android:visibility:visibility"))) {
        break label178;
      }
      localb.uX = ((Integer)paramah2.values.get("android:visibility:visibility")).intValue();
      localb.uY = ((ViewGroup)paramah2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramah1 != null) && (paramah2 != null))
      {
        if ((localb.uW == localb.uX) && (localb.rJ == localb.uY))
        {
          return localb;
          localb.uW = -1;
          localb.rJ = null;
          break;
          label178:
          localb.uX = -1;
          localb.uY = null;
          continue;
        }
        if (localb.uW != localb.uX) {
          if (localb.uW == 0)
          {
            localb.uV = false;
            localb.uU = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.uX == 0)
      {
        localb.uV = true;
        localb.uU = true;
        continue;
        if (localb.uY == null)
        {
          localb.uV = false;
          localb.uU = true;
        }
        else if (localb.rJ == null)
        {
          localb.uV = true;
          localb.uU = true;
          continue;
          if ((paramah1 == null) && (localb.uX == 0))
          {
            localb.uV = true;
            localb.uU = true;
          }
          else if ((paramah2 == null) && (localb.uW == 0))
          {
            localb.uV = false;
            localb.uU = true;
          }
        }
      }
    }
  }
  
  private static void c(ah paramah)
  {
    int i = paramah.view.getVisibility();
    paramah.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramah.values.put("android:visibility:parent", paramah.view.getParent());
    int[] arrayOfInt = new int[2];
    paramah.view.getLocationOnScreen(arrayOfInt);
    paramah.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    Object localObject1 = b(paramah1, paramah2);
    int i;
    label144:
    Canvas localCanvas;
    Object localObject3;
    Object localObject2;
    int j;
    if ((((Visibility.b)localObject1).uU) && ((((Visibility.b)localObject1).rJ != null) || (((Visibility.b)localObject1).uY != null)))
    {
      if (((Visibility.b)localObject1).uV)
      {
        if (((this.mMode & 0x1) != 1) || (paramah2 == null)) {
          return null;
        }
        if (paramah1 == null)
        {
          localObject1 = (View)paramah2.view.getParent();
          if (b(c((View)localObject1, false), b((View)localObject1, false)).uU) {
            return null;
          }
        }
        return a(paramViewGroup, paramah2.view, paramah1, paramah2);
      }
      i = ((Visibility.b)localObject1).uX;
      if ((this.mMode & 0x2) == 2)
      {
        if (paramah1 != null)
        {
          localObject1 = paramah1.view;
          if (paramah2 == null) {
            break label293;
          }
          paramah2 = paramah2.view;
          localCanvas = null;
          localObject3 = null;
          if ((paramah2 != null) && (paramah2.getParent() != null)) {
            break label739;
          }
          if (paramah2 == null) {
            break label298;
          }
          localObject2 = localObject3;
        }
        for (;;)
        {
          if ((paramah2 != null) && (paramah1 != null))
          {
            localObject1 = (int[])paramah1.values.get("android:visibility:screenLocation");
            i = localObject1[0];
            j = localObject1[1];
            localObject1 = new int[2];
            paramViewGroup.getLocationOnScreen((int[])localObject1);
            paramah2.offsetLeftAndRight(i - localObject1[0] - paramah2.getLeft());
            paramah2.offsetTopAndBottom(j - localObject1[1] - paramah2.getTop());
            localObject1 = an.c(paramViewGroup);
            ((am)localObject1).add(paramah2);
            paramViewGroup = a(paramViewGroup, paramah2, paramah1);
            if (paramViewGroup == null)
            {
              ((am)localObject1).remove(paramah2);
              return paramViewGroup;
              localObject1 = null;
              break;
              label293:
              paramah2 = null;
              break label144;
              label298:
              paramah2 = localCanvas;
              localObject2 = localObject3;
              if (localObject1 == null) {
                continue;
              }
              if (((View)localObject1).getParent() != null)
              {
                paramah2 = localCanvas;
                localObject2 = localObject3;
                if (!(((View)localObject1).getParent() instanceof View)) {
                  continue;
                }
                paramah2 = (View)((View)localObject1).getParent();
                if (!b(b(paramah2, true), c(paramah2, true)).uU)
                {
                  Matrix localMatrix = new Matrix();
                  localMatrix.setTranslate(-paramah2.getScrollX(), -paramah2.getScrollY());
                  au.a((View)localObject1, localMatrix);
                  au.b(paramViewGroup, localMatrix);
                  RectF localRectF = new RectF(0.0F, 0.0F, ((View)localObject1).getWidth(), ((View)localObject1).getHeight());
                  localMatrix.mapRect(localRectF);
                  j = Math.round(localRectF.left);
                  int k = Math.round(localRectF.top);
                  int m = Math.round(localRectF.right);
                  int n = Math.round(localRectF.bottom);
                  localObject2 = new ImageView(((View)localObject1).getContext());
                  ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
                  localCanvas = null;
                  int i2 = Math.round(localRectF.width());
                  int i1 = Math.round(localRectF.height());
                  paramah2 = localCanvas;
                  if (i2 > 0)
                  {
                    paramah2 = localCanvas;
                    if (i1 > 0)
                    {
                      float f = Math.min(1.0F, 1048576.0F / (i2 * i1));
                      i2 = (int)(i2 * f);
                      i1 = (int)(i1 * f);
                      localMatrix.postTranslate(-localRectF.left, -localRectF.top);
                      localMatrix.postScale(f, f);
                      paramah2 = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
                      localCanvas = new Canvas(paramah2);
                      localCanvas.concat(localMatrix);
                      ((View)localObject1).draw(localCanvas);
                    }
                  }
                  if (paramah2 != null) {
                    ((ImageView)localObject2).setImageBitmap(paramah2);
                  }
                  ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(m - j, 1073741824), View.MeasureSpec.makeMeasureSpec(n - k, 1073741824));
                  ((ImageView)localObject2).layout(j, k, m, n);
                  paramah2 = (ah)localObject2;
                  localObject2 = localObject3;
                  continue;
                }
                if (paramah2.getParent() != null) {
                  break label870;
                }
                j = paramah2.getId();
                if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.tj)) {
                  break label870;
                }
              }
            }
          }
        }
      }
    }
    label739:
    label870:
    for (paramah2 = (ah)localObject1;; paramah2 = null)
    {
      localObject2 = localObject3;
      break;
      if (i == 4)
      {
        localObject2 = paramah2;
        paramah2 = localCanvas;
        break;
      }
      if (localObject1 == paramah2)
      {
        localObject2 = paramah2;
        paramah2 = localCanvas;
        break;
      }
      paramah2 = (ah)localObject1;
      localObject2 = localObject3;
      break;
      paramViewGroup.addListener(new Visibility.1(this, (am)localObject1, paramah2));
      return paramViewGroup;
      if (localObject2 != null)
      {
        j = ((View)localObject2).getVisibility();
        au.l((View)localObject2, 0);
        paramViewGroup = a(paramViewGroup, (View)localObject2, paramah1);
        if (paramViewGroup != null)
        {
          paramah1 = new Visibility.a((View)localObject2, i);
          paramViewGroup.addListener(paramah1);
          a.a(paramViewGroup, paramah1);
          a(paramah1);
          return paramViewGroup;
        }
        au.l((View)localObject2, j);
        return paramViewGroup;
      }
      return null;
      return null;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, ah paramah)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, ah paramah1, ah paramah2)
  {
    return null;
  }
  
  public void a(ah paramah)
  {
    c(paramah);
  }
  
  public final boolean a(ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) && (paramah2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramah1 != null) && (paramah2 != null) && (paramah2.values.containsKey("android:visibility:visibility") != paramah1.values.containsKey("android:visibility:visibility")));
      paramah1 = b(paramah1, paramah2);
    } while ((!paramah1.uU) || ((paramah1.uW != 0) && (paramah1.uX != 0)));
    return true;
  }
  
  public void b(ah paramah)
  {
    c(paramah);
  }
  
  public final String[] getTransitionProperties()
  {
    return qo;
  }
  
  public final void setMode(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) != 0) {
      throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
    this.mMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */