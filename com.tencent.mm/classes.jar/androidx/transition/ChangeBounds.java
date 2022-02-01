package androidx.transition;

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
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.g;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final String[] cec;
  private static final Property<Drawable, PointF> ced;
  private static final Property<a, PointF> cee;
  private static final Property<a, PointF> cef;
  private static final Property<View, PointF> ceg;
  private static final Property<View, PointF> ceh;
  private static final Property<View, PointF> cei;
  private static n cem;
  private int[] cej;
  private boolean cek;
  private boolean cel;
  
  static
  {
    AppMethodBeat.i(201313);
    cec = new String[] { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
    ced = new ChangeBounds.1(PointF.class, "boundsOrigin");
    cee = new Property(PointF.class, "topLeft") {};
    cef = new Property(PointF.class, "bottomRight") {};
    ceg = new ChangeBounds.5(PointF.class, "bottomRight");
    ceh = new ChangeBounds.6(PointF.class, "topLeft");
    cei = new ChangeBounds.7(PointF.class, "position");
    cem = new n();
    AppMethodBeat.o(201313);
  }
  
  public ChangeBounds()
  {
    AppMethodBeat.i(201282);
    this.cej = new int[2];
    this.cek = false;
    this.cel = false;
    AppMethodBeat.o(201282);
  }
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201293);
    this.cej = new int[2];
    this.cek = false;
    this.cel = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfU);
    boolean bool = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.cek = bool;
    AppMethodBeat.o(201293);
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(201302);
    View localView = paramw.view;
    if ((z.au(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramw.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramw.values.put("android:changeBounds:parent", paramw.view.getParent());
      if (this.cel)
      {
        paramw.view.getLocationInWindow(this.cej);
        paramw.values.put("android:changeBounds:windowX", Integer.valueOf(this.cej[0]));
        paramw.values.put("android:changeBounds:windowY", Integer.valueOf(this.cej[1]));
      }
      if (this.cek) {
        paramw.values.put("android:changeBounds:clip", z.ax(localView));
      }
    }
    AppMethodBeat.o(201302);
  }
  
  public final String[] LI()
  {
    return cec;
  }
  
  public final Animator a(final ViewGroup paramViewGroup, final w paramw1, w paramw2)
  {
    AppMethodBeat.i(201357);
    if ((paramw1 == null) || (paramw2 == null))
    {
      AppMethodBeat.o(201357);
      return null;
    }
    Object localObject1 = paramw1.values;
    Object localObject2 = paramw2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null))
    {
      AppMethodBeat.o(201357);
      return null;
    }
    localObject2 = paramw2.view;
    w localw;
    int i;
    if (this.cel)
    {
      localw = i((View)localObject1, true);
      if (localw == null) {
        if (localObject1 == localViewGroup) {
          i = 1;
        }
      }
    }
    for (;;)
    {
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
        paramViewGroup = (Rect)paramw1.values.get("android:changeBounds:bounds");
        localObject1 = (Rect)paramw2.values.get("android:changeBounds:bounds");
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
        paramw1 = (Rect)paramw1.values.get("android:changeBounds:clip");
        localObject1 = (Rect)paramw2.values.get("android:changeBounds:clip");
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
        if ((paramw1 == null) || (paramw1.equals(localObject1)))
        {
          j = i;
          if (paramw1 == null)
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
          break label1144;
        }
        if (!this.cek)
        {
          ai.j((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = LV().getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, cei, paramViewGroup);
            }
          }
          for (;;)
          {
            if ((((View)localObject2).getParent() instanceof ViewGroup))
            {
              paramw1 = (ViewGroup)((View)localObject2).getParent();
              ac.c(paramw1, true);
              a(new s()
              {
                boolean mCanceled = false;
                
                public final void LJ()
                {
                  AppMethodBeat.i(201303);
                  ac.c(paramw1, false);
                  AppMethodBeat.o(201303);
                }
                
                public final void LK()
                {
                  AppMethodBeat.i(201309);
                  ac.c(paramw1, true);
                  AppMethodBeat.o(201309);
                }
                
                public final void a(Transition paramAnonymousTransition)
                {
                  AppMethodBeat.i(201295);
                  if (!this.mCanceled) {
                    ac.c(paramw1, false);
                  }
                  paramAnonymousTransition.b(this);
                  AppMethodBeat.o(201295);
                }
              });
            }
            AppMethodBeat.o(201357);
            return paramViewGroup;
            i = 0;
            break;
            if (localViewGroup == localw.view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            paramw1 = new a((View)localObject2);
            paramViewGroup = LV().getPath(m, i1, n, i2);
            paramw2 = j.a(paramw1, cee, paramViewGroup);
            paramViewGroup = LV().getPath(i3, i5, i4, i6);
            localObject1 = j.a(paramw1, cef, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramw2, localObject1 });
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              private ChangeBounds.a mViewBounds;
            });
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = LV().getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, ceh, paramViewGroup);
            }
            else
            {
              paramViewGroup = LV().getPath(i3, i5, i4, i6);
              paramViewGroup = j.a(localObject2, ceg, paramViewGroup);
            }
          }
        }
        ai.j((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1165;
        }
        paramViewGroup = LV().getPath(m, i1, n, i2);
      }
      label1165:
      for (paramViewGroup = j.a(localObject2, cei, paramViewGroup);; paramViewGroup = null)
      {
        if (paramw1 == null) {
          paramw1 = new Rect(0, 0, i7, i8);
        }
        for (;;)
        {
          if (localObject1 == null) {}
          for (paramw2 = new Rect(0, 0, i9, i10);; paramw2 = (w)localObject1)
          {
            if (!paramw1.equals(paramw2))
            {
              z.a((View)localObject2, paramw1);
              paramw1 = ObjectAnimator.ofObject(localObject2, "clipBounds", cem, new Object[] { paramw1, paramw2 });
              paramw1.addListener(new AnimatorListenerAdapter()
              {
                private boolean mIsCanceled;
                
                public final void onAnimationCancel(Animator paramAnonymousAnimator)
                {
                  this.mIsCanceled = true;
                }
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(201362);
                  if (!this.mIsCanceled)
                  {
                    z.a(this.val$view, this.ces);
                    ai.j(this.val$view, n, i2, i4, i6);
                  }
                  AppMethodBeat.o(201362);
                }
              });
            }
            for (;;)
            {
              paramViewGroup = v.a(paramViewGroup, paramw1);
              break;
              i = ((Integer)paramw1.values.get("android:changeBounds:windowX")).intValue();
              j = ((Integer)paramw1.values.get("android:changeBounds:windowY")).intValue();
              k = ((Integer)paramw2.values.get("android:changeBounds:windowX")).intValue();
              m = ((Integer)paramw2.values.get("android:changeBounds:windowY")).intValue();
              if ((i != k) || (j != m))
              {
                paramViewGroup.getLocationInWindow(this.cej);
                paramw1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramw1));
                paramw1 = new BitmapDrawable(paramw1);
                final float f = ai.ci((View)localObject2);
                ai.o((View)localObject2, 0.0F);
                ai.cg(paramViewGroup).x(paramw1);
                paramw2 = LV().getPath(i - this.cej[0], j - this.cej[1], k - this.cej[0], m - this.cej[1]);
                paramw2 = ObjectAnimator.ofPropertyValuesHolder(paramw1, new PropertyValuesHolder[] { l.a(ced, paramw2) });
                paramw2.addListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    AppMethodBeat.i(201439);
                    ai.cg(paramViewGroup).y(paramw1);
                    ai.o(this.val$view, f);
                    AppMethodBeat.o(201439);
                  }
                });
                AppMethodBeat.o(201357);
                return paramw2;
              }
              label1144:
              AppMethodBeat.o(201357);
              return null;
              paramw1 = null;
            }
          }
        }
      }
      i = 1;
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201324);
    a(paramw);
    AppMethodBeat.o(201324);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201330);
    a(paramw);
    AppMethodBeat.o(201330);
  }
  
  static class a
  {
    int ceA;
    int ceB;
    int cey;
    int cez;
    private View mView;
    int uE;
    int uF;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    final void LL()
    {
      AppMethodBeat.i(201276);
      ai.j(this.mView, this.uE, this.cey, this.uF, this.cez);
      this.ceA = 0;
      this.ceB = 0;
      AppMethodBeat.o(201276);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */