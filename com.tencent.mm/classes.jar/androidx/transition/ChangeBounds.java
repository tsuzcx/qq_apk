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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static n apD;
  private static final String[] apt;
  private static final Property<Drawable, PointF> apu;
  private static final Property<a, PointF> apv;
  private static final Property<a, PointF> apw;
  private static final Property<View, PointF> apx;
  private static final Property<View, PointF> apy;
  private static final Property<View, PointF> apz;
  private int[] apA;
  private boolean apB;
  private boolean apC;
  
  static
  {
    AppMethodBeat.i(191808);
    apt = new String[] { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
    apu = new ChangeBounds.1(PointF.class, "boundsOrigin");
    apv = new Property(PointF.class, "topLeft") {};
    apw = new Property(PointF.class, "bottomRight") {};
    apx = new Property(PointF.class, "bottomRight") {};
    apy = new Property(PointF.class, "topLeft") {};
    apz = new Property(PointF.class, "position") {};
    apD = new n();
    AppMethodBeat.o(191808);
  }
  
  public ChangeBounds()
  {
    AppMethodBeat.i(191760);
    this.apA = new int[2];
    this.apB = false;
    this.apC = false;
    AppMethodBeat.o(191760);
  }
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191764);
    this.apA = new int[2];
    this.apB = false;
    this.apC = false;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.arl);
    boolean bool = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.apB = bool;
    AppMethodBeat.o(191764);
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(191769);
    View localView = paramw.view;
    if ((androidx.core.g.w.ah(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramw.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramw.values.put("android:changeBounds:parent", paramw.view.getParent());
      if (this.apC)
      {
        paramw.view.getLocationInWindow(this.apA);
        paramw.values.put("android:changeBounds:windowX", Integer.valueOf(this.apA[0]));
        paramw.values.put("android:changeBounds:windowY", Integer.valueOf(this.apA[1]));
      }
      if (this.apB) {
        paramw.values.put("android:changeBounds:clip", androidx.core.g.w.ak(localView));
      }
    }
    AppMethodBeat.o(191769);
  }
  
  public final Animator a(final ViewGroup paramViewGroup, final w paramw1, w paramw2)
  {
    AppMethodBeat.i(191799);
    if ((paramw1 == null) || (paramw2 == null))
    {
      AppMethodBeat.o(191799);
      return null;
    }
    Object localObject1 = paramw1.values;
    Object localObject2 = paramw2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null))
    {
      AppMethodBeat.o(191799);
      return null;
    }
    localObject2 = paramw2.view;
    w localw;
    int i;
    if (this.apC)
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
        if (!this.apB)
        {
          ai.j((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = ns().getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, apz, paramViewGroup);
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
                
                public final void a(Transition paramAnonymousTransition)
                {
                  AppMethodBeat.i(191746);
                  if (!this.mCanceled) {
                    ac.c(paramw1, false);
                  }
                  paramAnonymousTransition.b(this);
                  AppMethodBeat.o(191746);
                }
                
                public final void ng()
                {
                  AppMethodBeat.i(191749);
                  ac.c(paramw1, false);
                  AppMethodBeat.o(191749);
                }
                
                public final void nh()
                {
                  AppMethodBeat.i(191752);
                  ac.c(paramw1, true);
                  AppMethodBeat.o(191752);
                }
              });
            }
            AppMethodBeat.o(191799);
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
            paramViewGroup = ns().getPath(m, i1, n, i2);
            paramw2 = j.a(paramw1, apv, paramViewGroup);
            paramViewGroup = ns().getPath(i3, i5, i4, i6);
            localObject1 = j.a(paramw1, apw, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramw2, localObject1 });
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              private ChangeBounds.a mViewBounds;
            });
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = ns().getPath(m, i1, n, i2);
              paramViewGroup = j.a(localObject2, apy, paramViewGroup);
            }
            else
            {
              paramViewGroup = ns().getPath(i3, i5, i4, i6);
              paramViewGroup = j.a(localObject2, apx, paramViewGroup);
            }
          }
        }
        ai.j((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1165;
        }
        paramViewGroup = ns().getPath(m, i1, n, i2);
      }
      label1165:
      for (paramViewGroup = j.a(localObject2, apz, paramViewGroup);; paramViewGroup = null)
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
              androidx.core.g.w.a((View)localObject2, paramw1);
              paramw1 = ObjectAnimator.ofObject(localObject2, "clipBounds", apD, new Object[] { paramw1, paramw2 });
              paramw1.addListener(new AnimatorListenerAdapter()
              {
                private boolean mIsCanceled;
                
                public final void onAnimationCancel(Animator paramAnonymousAnimator)
                {
                  this.mIsCanceled = true;
                }
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(191741);
                  if (!this.mIsCanceled)
                  {
                    androidx.core.g.w.a(this.val$view, this.apJ);
                    ai.j(this.val$view, n, i2, i4, i6);
                  }
                  AppMethodBeat.o(191741);
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
                paramViewGroup.getLocationInWindow(this.apA);
                paramw1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramw1));
                paramw1 = new BitmapDrawable(paramw1);
                final float f = ai.bO((View)localObject2);
                ai.n((View)localObject2, 0.0F);
                ai.bM(paramViewGroup).u(paramw1);
                paramw2 = ns().getPath(i - this.apA[0], j - this.apA[1], k - this.apA[0], m - this.apA[1]);
                paramw2 = ObjectAnimator.ofPropertyValuesHolder(paramw1, new PropertyValuesHolder[] { l.a(apu, paramw2) });
                paramw2.addListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationEnd(Animator paramAnonymousAnimator)
                  {
                    AppMethodBeat.i(191706);
                    ai.bM(paramViewGroup).v(paramw1);
                    ai.n(this.val$view, f);
                    AppMethodBeat.o(191706);
                  }
                });
                AppMethodBeat.o(191799);
                return paramw2;
              }
              label1144:
              AppMethodBeat.o(191799);
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
    AppMethodBeat.i(191770);
    a(paramw);
    AppMethodBeat.o(191770);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(191771);
    a(paramw);
    AppMethodBeat.o(191771);
  }
  
  public final String[] nf()
  {
    return apt;
  }
  
  static class a
  {
    int apP;
    int apQ;
    int apR;
    int apS;
    private View mView;
    int tF;
    int tG;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    final void ni()
    {
      AppMethodBeat.i(191756);
      ai.j(this.mView, this.tF, this.apP, this.tG, this.apQ);
      this.apR = 0;
      this.apS = 0;
      AppMethodBeat.o(191756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */