package android.support.transition;

import android.animation.Animator;
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
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final String[] qo = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> qp = new ChangeBounds.1(PointF.class, "boundsOrigin");
  private static final Property<ChangeBounds.a, PointF> qr = new ChangeBounds.3(PointF.class, "topLeft");
  private static final Property<ChangeBounds.a, PointF> qs = new Property(PointF.class, "bottomRight") {};
  private static final Property<View, PointF> qt = new ChangeBounds.5(PointF.class, "bottomRight");
  private static final Property<View, PointF> qu = new ChangeBounds.6(PointF.class, "topLeft");
  private static final Property<View, PointF> qv = new ChangeBounds.7(PointF.class, "position");
  private static z qz = new z();
  private int[] qw = new int[2];
  private boolean qx = false;
  private boolean qy = false;
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sF);
    boolean bool = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.qx = bool;
  }
  
  private void c(ah paramah)
  {
    View localView = paramah.view;
    if ((t.as(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramah.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramah.values.put("android:changeBounds:parent", paramah.view.getParent());
      if (this.qy)
      {
        paramah.view.getLocationInWindow(this.qw);
        paramah.values.put("android:changeBounds:windowX", Integer.valueOf(this.qw[0]));
        paramah.values.put("android:changeBounds:windowY", Integer.valueOf(this.qw[1]));
      }
      if (this.qx) {
        paramah.values.put("android:changeBounds:clip", t.av(localView));
      }
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) || (paramah2 == null))
    {
      paramah1 = null;
      return paramah1;
    }
    Object localObject1 = paramah1.values;
    Object localObject2 = paramah2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject2 = paramah2.view;
    ah localah;
    int i;
    if (this.qy)
    {
      localah = c((View)localObject1, true);
      if (localah == null) {
        if (localObject1 == localViewGroup) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      label101:
      int m;
      int n;
      int i2;
      int i4;
      int i6;
      int i7;
      int i8;
      int i9;
      int i10;
      int k;
      int j;
      if (i != 0)
      {
        paramViewGroup = (Rect)paramah1.values.get("android:changeBounds:bounds");
        localObject1 = (Rect)paramah2.values.get("android:changeBounds:bounds");
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
        paramah1 = (Rect)paramah1.values.get("android:changeBounds:clip");
        localObject1 = (Rect)paramah2.values.get("android:changeBounds:clip");
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
        if ((paramah1 == null) || (paramah1.equals(localObject1)))
        {
          j = i;
          if (paramah1 == null)
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
        if (!this.qx)
        {
          au.b((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = this.tt.getPath(m, i1, n, i2);
              paramViewGroup = q.a(localObject2, qv, paramViewGroup);
            }
          }
          for (;;)
          {
            paramah1 = paramViewGroup;
            if (!(((View)localObject2).getParent() instanceof ViewGroup)) {
              break;
            }
            paramah1 = (ViewGroup)((View)localObject2).getParent();
            an.c(paramah1, true);
            a(new ChangeBounds.10(this, paramah1));
            return paramViewGroup;
            i = 0;
            break label101;
            if (localViewGroup == localah.view)
            {
              i = 1;
              break label101;
            }
            i = 0;
            break label101;
            paramah1 = new ChangeBounds.a((View)localObject2);
            paramViewGroup = this.tt.getPath(m, i1, n, i2);
            paramah2 = q.a(paramah1, qr, paramViewGroup);
            paramViewGroup = this.tt.getPath(i3, i5, i4, i6);
            localObject1 = q.a(paramah1, qs, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramah2, localObject1 });
            paramViewGroup.addListener(new ChangeBounds.8(this, paramah1));
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = this.tt.getPath(m, i1, n, i2);
              paramViewGroup = q.a(localObject2, qu, paramViewGroup);
            }
            else
            {
              paramViewGroup = this.tt.getPath(i3, i5, i4, i6);
              paramViewGroup = q.a(localObject2, qt, paramViewGroup);
            }
          }
        }
        au.b((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1139;
        }
        paramViewGroup = this.tt.getPath(m, i1, n, i2);
      }
      label1123:
      label1139:
      for (paramViewGroup = q.a(localObject2, qv, paramViewGroup);; paramViewGroup = null)
      {
        if (paramah1 == null) {
          paramah1 = new Rect(0, 0, i7, i8);
        }
        for (;;)
        {
          if (localObject1 == null) {}
          for (paramah2 = new Rect(0, 0, i9, i10);; paramah2 = (ah)localObject1)
          {
            if (!paramah1.equals(paramah2))
            {
              t.c((View)localObject2, paramah1);
              paramah1 = ObjectAnimator.ofObject(localObject2, "clipBounds", qz, new Object[] { paramah1, paramah2 });
              paramah1.addListener(new ChangeBounds.9(this, (View)localObject2, (Rect)localObject1, n, i2, i4, i6));
            }
            for (;;)
            {
              paramViewGroup = ag.a(paramViewGroup, paramah1);
              break;
              i = ((Integer)paramah1.values.get("android:changeBounds:windowX")).intValue();
              j = ((Integer)paramah1.values.get("android:changeBounds:windowY")).intValue();
              k = ((Integer)paramah2.values.get("android:changeBounds:windowX")).intValue();
              m = ((Integer)paramah2.values.get("android:changeBounds:windowY")).intValue();
              if ((i != k) || (j != m))
              {
                paramViewGroup.getLocationInWindow(this.qw);
                paramah1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramah1));
                paramah1 = new BitmapDrawable(paramah1);
                float f = au.L((View)localObject2);
                au.d((View)localObject2, 0.0F);
                au.J(paramViewGroup).add(paramah1);
                paramah2 = this.tt.getPath(i - this.qw[0], j - this.qw[1], k - this.qw[0], m - this.qw[1]);
                paramah2 = ObjectAnimator.ofPropertyValuesHolder(paramah1, new PropertyValuesHolder[] { v.a(qp, paramah2) });
                paramah2.addListener(new ChangeBounds.2(this, paramViewGroup, paramah1, (View)localObject2, f));
                return paramah2;
              }
              return null;
              paramah1 = null;
            }
          }
        }
      }
      i = 1;
    }
  }
  
  public final void a(ah paramah)
  {
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    c(paramah);
  }
  
  public final String[] getTransitionProperties()
  {
    return qo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */