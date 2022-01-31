package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.v4.content.a.g;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final String[] qo;
  private static final Property<b, float[]> ra;
  private static final Property<b, PointF> rb;
  private static final boolean rc;
  private boolean qy = true;
  private boolean rd = true;
  private Matrix re = new Matrix();
  
  static
  {
    boolean bool = true;
    qo = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    ra = new ChangeTransform.1([F.class, "nonTranslations");
    rb = new ChangeTransform.2(PointF.class, "translations");
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      rc = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sI);
    this.rd = g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.qy = g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    t.j(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private void b(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    View localView = paramah2.view;
    Object localObject = new Matrix((Matrix)paramah2.values.get("android:changeTransform:parentMatrix"));
    au.b(paramViewGroup, (Matrix)localObject);
    localObject = k.a(localView, paramViewGroup, (Matrix)localObject);
    if (localObject == null) {}
    do
    {
      return;
      ((j)localObject).a((ViewGroup)paramah1.values.get("android:changeTransform:parent"), paramah1.view);
      for (paramViewGroup = this; paramViewGroup.te != null; paramViewGroup = paramViewGroup.te) {}
      paramViewGroup.a(new ChangeTransform.a(localView, (j)localObject));
    } while (!rc);
    if (paramah1.view != paramah2.view) {
      au.d(paramah1.view, 0.0F);
    }
    au.d(localView, 1.0F);
  }
  
  private void c(ah paramah)
  {
    View localView = paramah.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramah.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new ChangeTransform.c(localView);
    paramah.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramah.values.put("android:changeTransform:matrix", localObject);
      if (!this.qy) {
        break;
      }
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      au.a(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramah.values.put("android:changeTransform:parentMatrix", localObject);
      paramah.values.put("android:changeTransform:intermediateMatrix", localView.getTag(2131820686));
      paramah.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(2131820648));
      return;
    }
  }
  
  private static void w(View paramView)
  {
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) || (paramah2 == null) || (!paramah1.values.containsKey("android:changeTransform:parent")) || (!paramah2.values.containsKey("android:changeTransform:parent")))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)paramah1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramah2.values.get("android:changeTransform:parent");
    int i;
    if (this.qy) {
      if ((!C(localViewGroup)) || (!C((View)localObject1))) {
        if (localViewGroup == localObject1) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      boolean bool;
      label115:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        localObject1 = (Matrix)paramah1.values.get("android:changeTransform:intermediateMatrix");
        if (localObject1 != null) {
          paramah1.values.put("android:changeTransform:matrix", localObject1);
        }
        localObject1 = (Matrix)paramah1.values.get("android:changeTransform:intermediateParentMatrix");
        if (localObject1 != null) {
          paramah1.values.put("android:changeTransform:parentMatrix", localObject1);
        }
        if (bool)
        {
          localObject1 = (Matrix)paramah2.values.get("android:changeTransform:parentMatrix");
          paramah2.view.setTag(2131820648, localObject1);
          localObject2 = this.re;
          ((Matrix)localObject2).reset();
          ((Matrix)localObject1).invert((Matrix)localObject2);
          localObject1 = (Matrix)paramah1.values.get("android:changeTransform:matrix");
          if (localObject1 != null) {
            break label668;
          }
          localObject1 = new Matrix();
          paramah1.values.put("android:changeTransform:matrix", localObject1);
        }
      }
      label644:
      label668:
      for (;;)
      {
        ((Matrix)localObject1).postConcat((Matrix)paramah1.values.get("android:changeTransform:parentMatrix"));
        ((Matrix)localObject1).postConcat((Matrix)localObject2);
        Object localObject3 = (Matrix)paramah1.values.get("android:changeTransform:matrix");
        localObject1 = (Matrix)paramah2.values.get("android:changeTransform:matrix");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = p.ow;
        }
        if (localObject1 == null) {
          localObject1 = p.ow;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1)) {}
          for (localObject1 = null;; localObject1 = localObject2)
          {
            if ((!bool) || (localObject1 == null) || (!this.rd)) {
              break label644;
            }
            b(paramViewGroup, paramah1, paramah2);
            return localObject1;
            i = 0;
            break;
            localObject2 = c(localViewGroup, true);
            if (localObject2 == null) {
              break label671;
            }
            if (localObject1 == ((ah)localObject2).view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            bool = false;
            break label115;
            localObject3 = (ChangeTransform.c)paramah2.values.get("android:changeTransform:transforms");
            View localView = paramah2.view;
            w(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(ra, new f(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = this.tt.getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, v.a(rb, (Path)localObject4) });
            localObject1 = new ChangeTransform.3(this, bool, (Matrix)localObject1, localView, (ChangeTransform.c)localObject3, localb);
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
          }
          paramViewGroup = (ViewGroup)localObject1;
          if (rc) {
            break;
          }
          localViewGroup.endViewTransition(paramah1.view);
          return localObject1;
        }
      }
      label671:
      i = 0;
    }
  }
  
  public final void a(ah paramah)
  {
    c(paramah);
    if (!rc) {
      ((ViewGroup)paramah.view.getParent()).startViewTransition(paramah.view);
    }
  }
  
  public final void b(ah paramah)
  {
    c(paramah);
  }
  
  public final String[] getTransitionProperties()
  {
    return qo;
  }
  
  static final class b
  {
    final Matrix mMatrix = new Matrix();
    private final View mView;
    final float[] rl;
    float rm;
    float rn;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.rl = ((float[])paramArrayOfFloat.clone());
      this.rm = this.rl[2];
      this.rn = this.rl[5];
      ch();
    }
    
    final void ch()
    {
      this.rl[2] = this.rm;
      this.rl[5] = this.rn;
      this.mMatrix.setValues(this.rl);
      au.c(this.mView, this.mMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */