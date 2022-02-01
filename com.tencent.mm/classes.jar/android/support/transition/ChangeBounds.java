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
  private static final String[] wR = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> wS = new Property(PointF.class, "boundsOrigin")
  {
    private Rect xc = new Rect();
  };
  private static final Property<a, PointF> wT = new Property(PointF.class, "topLeft") {};
  private static final Property<a, PointF> wU = new Property(PointF.class, "bottomRight") {};
  private static final Property<View, PointF> wV = new ChangeBounds.5(PointF.class, "bottomRight");
  private static final Property<View, PointF> wW = new ChangeBounds.6(PointF.class, "topLeft");
  private static final Property<View, PointF> wX = new ChangeBounds.7(PointF.class, "position");
  private static m xb = new m();
  private int[] wY = new int[2];
  private boolean wZ = false;
  private boolean xa = false;
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.yV);
    boolean bool = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.wZ = bool;
  }
  
  private void c(u paramu)
  {
    View localView = paramu.view;
    if ((android.support.v4.view.t.ay(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramu.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramu.values.put("android:changeBounds:parent", paramu.view.getParent());
      if (this.xa)
      {
        paramu.view.getLocationInWindow(this.wY);
        paramu.values.put("android:changeBounds:windowX", Integer.valueOf(this.wY[0]));
        paramu.values.put("android:changeBounds:windowY", Integer.valueOf(this.wY[1]));
      }
      if (this.wZ) {
        paramu.values.put("android:changeBounds:clip", android.support.v4.view.t.aB(localView));
      }
    }
  }
  
  public final Animator a(final ViewGroup paramViewGroup, final u paramu1, u paramu2)
  {
    if ((paramu1 == null) || (paramu2 == null))
    {
      paramu1 = null;
      return paramu1;
    }
    Object localObject1 = paramu1.values;
    Object localObject2 = paramu2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject2 = paramu2.view;
    u localu;
    int i;
    if (this.xa)
    {
      localu = c((View)localObject1, true);
      if (localu == null) {
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
        paramViewGroup = (Rect)paramu1.values.get("android:changeBounds:bounds");
        localObject1 = (Rect)paramu2.values.get("android:changeBounds:bounds");
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
        paramu1 = (Rect)paramu1.values.get("android:changeBounds:clip");
        localObject1 = (Rect)paramu2.values.get("android:changeBounds:clip");
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
        if ((paramu1 == null) || (paramu1.equals(localObject1)))
        {
          j = i;
          if (paramu1 == null)
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
        if (!this.wZ)
        {
          ag.b((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = this.zJ.getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, wX, paramViewGroup);
            }
          }
          for (;;)
          {
            paramu1 = paramViewGroup;
            if (!(((View)localObject2).getParent() instanceof ViewGroup)) {
              break;
            }
            paramu1 = (ViewGroup)((View)localObject2).getParent();
            aa.c(paramu1, true);
            a(new q()
            {
              boolean mCanceled = false;
              
              public final void a(Transition paramAnonymousTransition)
              {
                if (!this.mCanceled) {
                  aa.c(paramu1, false);
                }
                paramAnonymousTransition.b(this);
              }
              
              public final void dg()
              {
                aa.c(paramu1, false);
              }
              
              public final void dh()
              {
                aa.c(paramu1, true);
              }
            });
            return paramViewGroup;
            i = 0;
            break label101;
            if (localViewGroup == localu.view)
            {
              i = 1;
              break label101;
            }
            i = 0;
            break label101;
            paramu1 = new a((View)localObject2);
            paramViewGroup = this.zJ.getPath(m, i1, n, i2);
            paramu2 = j.a(paramu1, wT, paramViewGroup);
            paramViewGroup = this.zJ.getPath(i3, i5, i4, i6);
            localObject1 = j.a(paramu1, wU, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramu2, localObject1 });
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              private ChangeBounds.a mViewBounds = paramu1;
            });
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = this.zJ.getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, wW, paramViewGroup);
            }
            else
            {
              paramViewGroup = this.zJ.getPath(i3, i5, i4, i6);
              paramViewGroup = j.a(localObject2, wV, paramViewGroup);
            }
          }
        }
        ag.b((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1139;
        }
        paramViewGroup = this.zJ.getPath(m, i1, n, i2);
      }
      label1123:
      label1139:
      for (paramViewGroup = j.a(localObject2, wX, paramViewGroup);; paramViewGroup = null)
      {
        if (paramu1 == null) {
          paramu1 = new Rect(0, 0, i7, i8);
        }
        for (;;)
        {
          if (localObject1 == null) {}
          for (paramu2 = new Rect(0, 0, i9, i10);; paramu2 = (u)localObject1)
          {
            if (!paramu1.equals(paramu2))
            {
              android.support.v4.view.t.b((View)localObject2, paramu1);
              paramu1 = ObjectAnimator.ofObject(localObject2, "clipBounds", xb, new Object[] { paramu1, paramu2 });
              paramu1.addListener(new AnimatorListenerAdapter()
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
                    android.support.v4.view.t.b(this.val$view, this.xi);
                    ag.b(this.val$view, n, i2, i4, i6);
                  }
                }
              });
            }
            for (;;)
            {
              paramViewGroup = t.a(paramViewGroup, paramu1);
              break;
              i = ((Integer)paramu1.values.get("android:changeBounds:windowX")).intValue();
              j = ((Integer)paramu1.values.get("android:changeBounds:windowY")).intValue();
              k = ((Integer)paramu2.values.get("android:changeBounds:windowX")).intValue();
              m = ((Integer)paramu2.values.get("android:changeBounds:windowY")).intValue();
              if ((i != k) || (j != m))
              {
                paramViewGroup.getLocationInWindow(this.wY);
                paramu1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramu1));
                paramu1 = new BitmapDrawable(paramu1);
                final float f = ag.O((View)localObject2);
                ag.d((View)localObject2, 0.0F);
                ag.M(paramViewGroup).add(paramu1);
                paramu2 = this.zJ.getPath(i - this.wY[0], j - this.wY[1], k - this.wY[0], m - this.wY[1]);
                paramu2 = ObjectAnimator.ofPropertyValuesHolder(paramu1, new PropertyValuesHolder[] { l.a(wS, paramu2) });
                paramu2.addListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    ag.M(paramViewGroup).remove(paramu1);
                    ag.d(this.val$view, f);
                  }
                });
                return paramu2;
              }
              return null;
              paramu1 = null;
            }
          }
        }
      }
      i = 1;
    }
  }
  
  public final void a(u paramu)
  {
    c(paramu);
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return wR;
  }
  
  static final class a
  {
    private View mView;
    int xo;
    int xp;
    int xq;
    int xr;
    int xs;
    int xt;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    final void di()
    {
      ag.b(this.mView, this.xo, this.xp, this.xq, this.xr);
      this.xs = 0;
      this.xt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */