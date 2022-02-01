package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final String[] zP = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> zQ = new Property(PointF.class, "boundsOrigin")
  {
    private Rect mBounds = new Rect();
  };
  private static final Property<a, PointF> zR = new Property(PointF.class, "topLeft") {};
  private static final Property<a, PointF> zS = new Property(PointF.class, "bottomRight") {};
  private static final Property<View, PointF> zT = new Property(PointF.class, "bottomRight") {};
  private static final Property<View, PointF> zU = new Property(PointF.class, "topLeft") {};
  private static final Property<View, PointF> zV = new Property(PointF.class, "position") {};
  private static m zZ = new m();
  private int[] zW = new int[2];
  private boolean zX = false;
  private boolean zY = false;
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BT);
    boolean bool = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.zX = bool;
  }
  
  private void c(v paramv)
  {
    View localView = paramv.view;
    if ((android.support.v4.view.u.az(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramv.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramv.values.put("android:changeBounds:parent", paramv.view.getParent());
      if (this.zY)
      {
        paramv.view.getLocationInWindow(this.zW);
        paramv.values.put("android:changeBounds:windowX", Integer.valueOf(this.zW[0]));
        paramv.values.put("android:changeBounds:windowY", Integer.valueOf(this.zW[1]));
      }
      if (this.zX) {
        paramv.values.put("android:changeBounds:clip", android.support.v4.view.u.aC(localView));
      }
    }
  }
  
  public final Animator a(final ViewGroup paramViewGroup, final v paramv1, v paramv2)
  {
    if ((paramv1 == null) || (paramv2 == null))
    {
      paramv1 = null;
      return paramv1;
    }
    Object localObject1 = paramv1.values;
    Object localObject2 = paramv2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject2 = paramv2.view;
    v localv;
    int i;
    if (this.zY)
    {
      localv = c((View)localObject1, true);
      if (localv == null) {
        if (localObject1 == localViewGroup) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      label101:
      int m;
      final int n;
      final int i2;
      final int i4;
      final int i6;
      int i7;
      int i8;
      int i9;
      int i10;
      int k;
      int j;
      if (i != 0)
      {
        paramViewGroup = (Rect)paramv1.values.get("android:changeBounds:bounds");
        localObject1 = (Rect)paramv2.values.get("android:changeBounds:bounds");
        m = paramViewGroup.left;
        n = ((Rect)localObject1).left;
        int i1 = paramViewGroup.top;
        i2 = ((Rect)localObject1).top;
        int i3 = paramViewGroup.right;
        i4 = ((Rect)localObject1).right;
        int i5 = paramViewGroup.bottom;
        i6 = ((Rect)localObject1).bottom;
        i7 = i3 - m;
        i8 = i5 - i1;
        i9 = i4 - n;
        i10 = i6 - i2;
        paramv1 = (Rect)paramv1.values.get("android:changeBounds:clip");
        localObject1 = (Rect)paramv2.values.get("android:changeBounds:clip");
        k = 0;
        j = 0;
        if ((i7 == 0) || (i8 == 0))
        {
          i = k;
          if (i9 != 0)
          {
            i = k;
            if (i10 == 0) {}
          }
        }
        else
        {
          if ((m != n) || (i1 != i2)) {
            j = 1;
          }
          if (i3 == i4)
          {
            i = j;
            if (i5 == i6) {}
          }
          else
          {
            i = j + 1;
          }
        }
        if ((paramv1 == null) || (paramv1.equals(localObject1)))
        {
          j = i;
          if (paramv1 == null)
          {
            j = i;
            if (localObject1 == null) {}
          }
        }
        else
        {
          j = i + 1;
        }
        if (j <= 0) {
          break label1123;
        }
        if (!this.zX)
        {
          ah.b((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = this.CF.getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, zV, paramViewGroup);
            }
          }
          for (;;)
          {
            paramv1 = paramViewGroup;
            if (!(((View)localObject2).getParent() instanceof ViewGroup)) {
              break;
            }
            paramv1 = (ViewGroup)((View)localObject2).getParent();
            ab.c(paramv1, true);
            a(new r()
            {
              boolean mCanceled = false;
              
              public final void a(Transition paramAnonymousTransition)
              {
                if (!this.mCanceled) {
                  ab.c(paramv1, false);
                }
                paramAnonymousTransition.b(this);
              }
              
              public final void dF()
              {
                ab.c(paramv1, false);
              }
              
              public final void dG()
              {
                ab.c(paramv1, true);
              }
            });
            return paramViewGroup;
            i = 0;
            break label101;
            if (localViewGroup == localv.view)
            {
              i = 1;
              break label101;
            }
            i = 0;
            break label101;
            paramv1 = new a((View)localObject2);
            paramViewGroup = this.CF.getPath(m, i1, n, i2);
            paramv2 = j.a(paramv1, zR, paramViewGroup);
            paramViewGroup = this.CF.getPath(i3, i5, i4, i6);
            localObject1 = j.a(paramv1, zS, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramv2, localObject1 });
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              private ChangeBounds.a mViewBounds = paramv1;
            });
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = this.CF.getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, zU, paramViewGroup);
            }
            else
            {
              paramViewGroup = this.CF.getPath(i3, i5, i4, i6);
              paramViewGroup = j.a(localObject2, zT, paramViewGroup);
            }
          }
        }
        ah.b((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1139;
        }
        paramViewGroup = this.CF.getPath(m, i1, n, i2);
      }
      label1123:
      label1139:
      for (paramViewGroup = j.a(localObject2, zV, paramViewGroup);; paramViewGroup = null)
      {
        if (paramv1 == null) {
          paramv1 = new Rect(0, 0, i7, i8);
        }
        for (;;)
        {
          if (localObject1 == null) {}
          for (paramv2 = new Rect(0, 0, i9, i10);; paramv2 = (v)localObject1)
          {
            if (!paramv1.equals(paramv2))
            {
              android.support.v4.view.u.b((View)localObject2, paramv1);
              paramv1 = ObjectAnimator.ofObject(localObject2, "clipBounds", zZ, new Object[] { paramv1, paramv2 });
              paramv1.addListener(new AnimatorListenerAdapter()
              {
                private boolean mIsCanceled;
                
                public final void onAnimationCancel(Animator paramAnonymousAnimator)
                {
                  this.mIsCanceled = true;
                }
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  if (!this.mIsCanceled)
                  {
                    android.support.v4.view.u.b(this.val$view, this.Af);
                    ah.b(this.val$view, n, i2, i4, i6);
                  }
                }
              });
            }
            for (;;)
            {
              paramViewGroup = u.a(paramViewGroup, paramv1);
              break;
              i = ((Integer)paramv1.values.get("android:changeBounds:windowX")).intValue();
              j = ((Integer)paramv1.values.get("android:changeBounds:windowY")).intValue();
              k = ((Integer)paramv2.values.get("android:changeBounds:windowX")).intValue();
              m = ((Integer)paramv2.values.get("android:changeBounds:windowY")).intValue();
              if ((i != k) || (j != m))
              {
                paramViewGroup.getLocationInWindow(this.zW);
                paramv1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramv1));
                paramv1 = new BitmapDrawable(paramv1);
                final float f = ah.P((View)localObject2);
                ah.d((View)localObject2, 0.0F);
                ah.N(paramViewGroup).add(paramv1);
                paramv2 = this.CF.getPath(i - this.zW[0], j - this.zW[1], k - this.zW[0], m - this.zW[1]);
                paramv2 = ObjectAnimator.ofPropertyValuesHolder(paramv1, new PropertyValuesHolder[] { l.a(zQ, paramv2) });
                paramv2.addListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    ah.N(paramViewGroup).remove(paramv1);
                    ah.d(this.val$view, f);
                  }
                });
                return paramv2;
              }
              return null;
              paramv1 = null;
            }
          }
        }
      }
      i = 1;
    }
  }
  
  public final void a(v paramv)
  {
    c(paramv);
  }
  
  public final void b(v paramv)
  {
    c(paramv);
  }
  
  public final String[] getTransitionProperties()
  {
    return zP;
  }
  
  static final class a
  {
    int Al;
    int Am;
    int An;
    int Ao;
    int Ap;
    int Aq;
    private View mView;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    final void dH()
    {
      ah.b(this.mView, this.Al, this.Am, this.An, this.Ao);
      this.Ap = 0;
      this.Aq = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */