package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.content.a.c;
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
  private static final String[] ps = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rF);
    int i = c.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static Visibility.b b(ai paramai1, ai paramai2)
  {
    Visibility.b localb = new Visibility.b((byte)0);
    localb.tT = false;
    localb.tU = false;
    if ((paramai1 != null) && (paramai1.values.containsKey("android:visibility:visibility")))
    {
      localb.tV = ((Integer)paramai1.values.get("android:visibility:visibility")).intValue();
      localb.qM = ((ViewGroup)paramai1.values.get("android:visibility:parent"));
      if ((paramai2 == null) || (!paramai2.values.containsKey("android:visibility:visibility"))) {
        break label178;
      }
      localb.tW = ((Integer)paramai2.values.get("android:visibility:visibility")).intValue();
      localb.tX = ((ViewGroup)paramai2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramai1 != null) && (paramai2 != null))
      {
        if ((localb.tV == localb.tW) && (localb.qM == localb.tX))
        {
          return localb;
          localb.tV = -1;
          localb.qM = null;
          break;
          label178:
          localb.tW = -1;
          localb.tX = null;
          continue;
        }
        if (localb.tV != localb.tW) {
          if (localb.tV == 0)
          {
            localb.tU = false;
            localb.tT = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.tW == 0)
      {
        localb.tU = true;
        localb.tT = true;
        continue;
        if (localb.tX == null)
        {
          localb.tU = false;
          localb.tT = true;
        }
        else if (localb.qM == null)
        {
          localb.tU = true;
          localb.tT = true;
          continue;
          if ((paramai1 == null) && (localb.tW == 0))
          {
            localb.tU = true;
            localb.tT = true;
          }
          else if ((paramai2 == null) && (localb.tV == 0))
          {
            localb.tU = false;
            localb.tT = true;
          }
        }
      }
    }
  }
  
  private static void c(ai paramai)
  {
    int i = paramai.view.getVisibility();
    paramai.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramai.values.put("android:visibility:parent", paramai.view.getParent());
    int[] arrayOfInt = new int[2];
    paramai.view.getLocationOnScreen(arrayOfInt);
    paramai.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, final ai paramai2)
  {
    Object localObject1 = b(paramai1, paramai2);
    int i;
    label144:
    Canvas localCanvas;
    Object localObject3;
    Object localObject2;
    int j;
    if ((((Visibility.b)localObject1).tT) && ((((Visibility.b)localObject1).qM != null) || (((Visibility.b)localObject1).tX != null)))
    {
      if (((Visibility.b)localObject1).tU)
      {
        if (((this.mMode & 0x1) != 1) || (paramai2 == null)) {
          return null;
        }
        if (paramai1 == null)
        {
          localObject1 = (View)paramai2.view.getParent();
          if (b(c((View)localObject1, false), b((View)localObject1, false)).tT) {
            return null;
          }
        }
        return a(paramViewGroup, paramai2.view, paramai1, paramai2);
      }
      i = ((Visibility.b)localObject1).tW;
      if ((this.mMode & 0x2) == 2)
      {
        if (paramai1 != null)
        {
          localObject1 = paramai1.view;
          if (paramai2 == null) {
            break label293;
          }
          paramai2 = paramai2.view;
          localCanvas = null;
          localObject3 = null;
          if ((paramai2 != null) && (paramai2.getParent() != null)) {
            break label739;
          }
          if (paramai2 == null) {
            break label298;
          }
          localObject2 = localObject3;
        }
        for (;;)
        {
          if ((paramai2 != null) && (paramai1 != null))
          {
            localObject1 = (int[])paramai1.values.get("android:visibility:screenLocation");
            i = localObject1[0];
            j = localObject1[1];
            localObject1 = new int[2];
            paramViewGroup.getLocationOnScreen((int[])localObject1);
            paramai2.offsetLeftAndRight(i - localObject1[0] - paramai2.getLeft());
            paramai2.offsetTopAndBottom(j - localObject1[1] - paramai2.getTop());
            localObject1 = ao.d(paramViewGroup);
            ((an)localObject1).add(paramai2);
            paramViewGroup = a(paramViewGroup, paramai2, paramai1);
            if (paramViewGroup == null)
            {
              ((an)localObject1).remove(paramai2);
              return paramViewGroup;
              localObject1 = null;
              break;
              label293:
              paramai2 = null;
              break label144;
              label298:
              paramai2 = localCanvas;
              localObject2 = localObject3;
              if (localObject1 == null) {
                continue;
              }
              if (((View)localObject1).getParent() != null)
              {
                paramai2 = localCanvas;
                localObject2 = localObject3;
                if (!(((View)localObject1).getParent() instanceof View)) {
                  continue;
                }
                paramai2 = (View)((View)localObject1).getParent();
                if (!b(b(paramai2, true), c(paramai2, true)).tT)
                {
                  Matrix localMatrix = new Matrix();
                  localMatrix.setTranslate(-paramai2.getScrollX(), -paramai2.getScrollY());
                  av.a((View)localObject1, localMatrix);
                  av.b(paramViewGroup, localMatrix);
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
                  paramai2 = localCanvas;
                  if (i2 > 0)
                  {
                    paramai2 = localCanvas;
                    if (i1 > 0)
                    {
                      float f = Math.min(1.0F, 1048576.0F / (i2 * i1));
                      i2 = (int)(i2 * f);
                      i1 = (int)(i1 * f);
                      localMatrix.postTranslate(-localRectF.left, -localRectF.top);
                      localMatrix.postScale(f, f);
                      paramai2 = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
                      localCanvas = new Canvas(paramai2);
                      localCanvas.concat(localMatrix);
                      ((View)localObject1).draw(localCanvas);
                    }
                  }
                  if (paramai2 != null) {
                    ((ImageView)localObject2).setImageBitmap(paramai2);
                  }
                  ((ImageView)localObject2).measure(View.MeasureSpec.makeMeasureSpec(m - j, 1073741824), View.MeasureSpec.makeMeasureSpec(n - k, 1073741824));
                  ((ImageView)localObject2).layout(j, k, m, n);
                  paramai2 = (ai)localObject2;
                  localObject2 = localObject3;
                  continue;
                }
                if (paramai2.getParent() != null) {
                  break label870;
                }
                j = paramai2.getId();
                if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.sk)) {
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
    for (paramai2 = (ai)localObject1;; paramai2 = null)
    {
      localObject2 = localObject3;
      break;
      if (i == 4)
      {
        localObject2 = paramai2;
        paramai2 = localCanvas;
        break;
      }
      if (localObject1 == paramai2)
      {
        localObject2 = paramai2;
        paramai2 = localCanvas;
        break;
      }
      paramai2 = (ai)localObject1;
      localObject2 = localObject3;
      break;
      paramViewGroup.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.tM.remove(paramai2);
        }
      });
      return paramViewGroup;
      if (localObject2 != null)
      {
        j = ((View)localObject2).getVisibility();
        av.k((View)localObject2, 0);
        paramViewGroup = a(paramViewGroup, (View)localObject2, paramai1);
        if (paramViewGroup != null)
        {
          paramai1 = new Visibility.a((View)localObject2, i);
          paramViewGroup.addListener(paramai1);
          a.a(paramViewGroup, paramai1);
          a(paramai1);
          return paramViewGroup;
        }
        av.k((View)localObject2, j);
        return paramViewGroup;
      }
      return null;
      return null;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, ai paramai)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, ai paramai1, ai paramai2)
  {
    return null;
  }
  
  public void a(ai paramai)
  {
    c(paramai);
  }
  
  public final boolean a(ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) && (paramai2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramai1 != null) && (paramai2 != null) && (paramai2.values.containsKey("android:visibility:visibility") != paramai1.values.containsKey("android:visibility:visibility")));
      paramai1 = b(paramai1, paramai2);
    } while ((!paramai1.tT) || ((paramai1.tV != 0) && (paramai1.tW != 0)));
    return true;
  }
  
  public void b(ai paramai)
  {
    c(paramai);
  }
  
  public final String[] getTransitionProperties()
  {
    return ps;
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