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
import android.support.v4.content.a.c;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static aa pC = new aa();
  private static final String[] ps = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> pt = new ChangeBounds.1(PointF.class, "boundsOrigin");
  private static final Property<a, PointF> pu = new ChangeBounds.3(PointF.class, "topLeft");
  private static final Property<a, PointF> pv = new ChangeBounds.4(PointF.class, "bottomRight");
  private static final Property<View, PointF> pw = new ChangeBounds.5(PointF.class, "bottomRight");
  private static final Property<View, PointF> px = new ChangeBounds.6(PointF.class, "topLeft");
  private static final Property<View, PointF> py = new ChangeBounds.7(PointF.class, "position");
  private boolean pA = false;
  private boolean pB = false;
  private int[] pz = new int[2];
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rE);
    boolean bool = c.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    this.pA = bool;
  }
  
  private void c(ai paramai)
  {
    View localView = paramai.view;
    if ((android.support.v4.view.q.al(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramai.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramai.values.put("android:changeBounds:parent", paramai.view.getParent());
      if (this.pB)
      {
        paramai.view.getLocationInWindow(this.pz);
        paramai.values.put("android:changeBounds:windowX", Integer.valueOf(this.pz[0]));
        paramai.values.put("android:changeBounds:windowY", Integer.valueOf(this.pz[1]));
      }
      if (this.pA) {
        paramai.values.put("android:changeBounds:clip", android.support.v4.view.q.an(localView));
      }
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) || (paramai2 == null))
    {
      paramai1 = null;
      return paramai1;
    }
    Object localObject1 = paramai1.values;
    Object localObject2 = paramai2.values;
    localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    if ((localObject1 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject2 = paramai2.view;
    ai localai;
    int i;
    if (this.pB)
    {
      localai = c((View)localObject1, true);
      if (localai == null) {
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
        paramViewGroup = (Rect)paramai1.values.get("android:changeBounds:bounds");
        localObject1 = (Rect)paramai2.values.get("android:changeBounds:bounds");
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
        paramai1 = (Rect)paramai1.values.get("android:changeBounds:clip");
        localObject1 = (Rect)paramai2.values.get("android:changeBounds:clip");
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
        if ((paramai1 == null) || (paramai1.equals(localObject1)))
        {
          j = i;
          if (paramai1 == null)
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
        if (!this.pA)
        {
          av.b((View)localObject2, m, i1, i3, i5);
          if (j == 2) {
            if ((i7 == i9) && (i8 == i10))
            {
              paramViewGroup = this.ss.getPath(m, i1, n, i2);
              paramViewGroup = q.a(localObject2, py, paramViewGroup);
            }
          }
          for (;;)
          {
            paramai1 = paramViewGroup;
            if (!(((View)localObject2).getParent() instanceof ViewGroup)) {
              break;
            }
            paramai1 = (ViewGroup)((View)localObject2).getParent();
            ao.c(paramai1, true);
            a(new ChangeBounds.10(this, paramai1));
            return paramViewGroup;
            i = 0;
            break label101;
            if (localViewGroup == localai.view)
            {
              i = 1;
              break label101;
            }
            i = 0;
            break label101;
            paramai1 = new a((View)localObject2);
            paramViewGroup = this.ss.getPath(m, i1, n, i2);
            paramai2 = q.a(paramai1, pu, paramViewGroup);
            paramViewGroup = this.ss.getPath(i3, i5, i4, i6);
            localObject1 = q.a(paramai1, pv, paramViewGroup);
            paramViewGroup = new AnimatorSet();
            paramViewGroup.playTogether(new Animator[] { paramai2, localObject1 });
            paramViewGroup.addListener(new ChangeBounds.8(this, paramai1));
            continue;
            if ((m != n) || (i1 != i2))
            {
              paramViewGroup = this.ss.getPath(m, i1, n, i2);
              paramViewGroup = q.a(localObject2, px, paramViewGroup);
            }
            else
            {
              paramViewGroup = this.ss.getPath(i3, i5, i4, i6);
              paramViewGroup = q.a(localObject2, pw, paramViewGroup);
            }
          }
        }
        av.b((View)localObject2, m, i1, Math.max(i7, i9) + m, Math.max(i8, i10) + i1);
        if ((m == n) && (i1 == i2)) {
          break label1139;
        }
        paramViewGroup = this.ss.getPath(m, i1, n, i2);
      }
      label1123:
      label1139:
      for (paramViewGroup = q.a(localObject2, py, paramViewGroup);; paramViewGroup = null)
      {
        if (paramai1 == null) {
          paramai1 = new Rect(0, 0, i7, i8);
        }
        for (;;)
        {
          if (localObject1 == null) {}
          for (paramai2 = new Rect(0, 0, i9, i10);; paramai2 = (ai)localObject1)
          {
            if (!paramai1.equals(paramai2))
            {
              android.support.v4.view.q.c((View)localObject2, paramai1);
              paramai1 = ObjectAnimator.ofObject(localObject2, "clipBounds", pC, new Object[] { paramai1, paramai2 });
              paramai1.addListener(new ChangeBounds.9(this, (View)localObject2, (Rect)localObject1, n, i2, i4, i6));
            }
            for (;;)
            {
              paramViewGroup = ah.a(paramViewGroup, paramai1);
              break;
              i = ((Integer)paramai1.values.get("android:changeBounds:windowX")).intValue();
              j = ((Integer)paramai1.values.get("android:changeBounds:windowY")).intValue();
              k = ((Integer)paramai2.values.get("android:changeBounds:windowX")).intValue();
              m = ((Integer)paramai2.values.get("android:changeBounds:windowY")).intValue();
              if ((i != k) || (j != m))
              {
                paramViewGroup.getLocationInWindow(this.pz);
                paramai1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
                ((View)localObject2).draw(new Canvas(paramai1));
                paramai1 = new BitmapDrawable(paramai1);
                float f = av.H((View)localObject2);
                av.c((View)localObject2, 0.0F);
                av.F(paramViewGroup).add(paramai1);
                paramai2 = this.ss.getPath(i - this.pz[0], j - this.pz[1], k - this.pz[0], m - this.pz[1]);
                paramai2 = ObjectAnimator.ofPropertyValuesHolder(paramai1, new PropertyValuesHolder[] { v.a(pt, paramai2) });
                paramai2.addListener(new ChangeBounds.2(this, paramViewGroup, paramai1, (View)localObject2, f));
                return paramai2;
              }
              return null;
              paramai1 = null;
            }
          }
        }
      }
      i = 1;
    }
  }
  
  public final void a(ai paramai)
  {
    c(paramai);
  }
  
  public final void b(ai paramai)
  {
    c(paramai);
  }
  
  public final String[] getTransitionProperties()
  {
    return ps;
  }
  
  private static final class a
  {
    private View mView;
    int pR;
    int pS;
    int pT;
    int pU;
    int pV;
    int pW;
    
    a(View paramView)
    {
      this.mView = paramView;
    }
    
    final void bs()
    {
      av.b(this.mView, this.pR, this.pS, this.pT, this.pU);
      this.pV = 0;
      this.pW = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */