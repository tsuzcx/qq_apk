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
import android.support.v4.content.a.c;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final String[] ps;
  private static final Property<b, float[]> qd;
  private static final Property<b, PointF> qe;
  private static final boolean qf;
  private boolean pB = true;
  private boolean qg = true;
  private Matrix qh = new Matrix();
  
  static
  {
    boolean bool = true;
    ps = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    qd = new ChangeTransform.1([F.class, "nonTranslations");
    qe = new ChangeTransform.2(PointF.class, "translations");
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      qf = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rH);
    this.qg = c.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.pB = c.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    q.i(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private void b(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    View localView = paramai2.view;
    Object localObject = new Matrix((Matrix)paramai2.values.get("android:changeTransform:parentMatrix"));
    av.b(paramViewGroup, (Matrix)localObject);
    localObject = k.a(localView, paramViewGroup, (Matrix)localObject);
    if (localObject == null) {}
    do
    {
      return;
      ((j)localObject).a((ViewGroup)paramai1.values.get("android:changeTransform:parent"), paramai1.view);
      for (paramViewGroup = this; paramViewGroup.se != null; paramViewGroup = paramViewGroup.se) {}
      paramViewGroup.a(new ChangeTransform.a(localView, (j)localObject));
    } while (!qf);
    if (paramai1.view != paramai2.view) {
      av.c(paramai1.view, 0.0F);
    }
    av.c(localView, 1.0F);
  }
  
  private void c(ai paramai)
  {
    View localView = paramai.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramai.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new ChangeTransform.c(localView);
    paramai.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramai.values.put("android:changeTransform:matrix", localObject);
      if (!this.pB) {
        break;
      }
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      av.a(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramai.values.put("android:changeTransform:parentMatrix", localObject);
      paramai.values.put("android:changeTransform:intermediateMatrix", localView.getTag(z.a.transition_transform));
      paramai.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(z.a.parent_matrix));
      return;
    }
  }
  
  private static void t(View paramView)
  {
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) || (paramai2 == null) || (!paramai1.values.containsKey("android:changeTransform:parent")) || (!paramai2.values.containsKey("android:changeTransform:parent")))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)paramai1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramai2.values.get("android:changeTransform:parent");
    int i;
    if (this.pB) {
      if ((!z(localViewGroup)) || (!z((View)localObject1))) {
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
        localObject1 = (Matrix)paramai1.values.get("android:changeTransform:intermediateMatrix");
        if (localObject1 != null) {
          paramai1.values.put("android:changeTransform:matrix", localObject1);
        }
        localObject1 = (Matrix)paramai1.values.get("android:changeTransform:intermediateParentMatrix");
        if (localObject1 != null) {
          paramai1.values.put("android:changeTransform:parentMatrix", localObject1);
        }
        if (bool)
        {
          localObject1 = (Matrix)paramai2.values.get("android:changeTransform:parentMatrix");
          paramai2.view.setTag(z.a.parent_matrix, localObject1);
          localObject2 = this.qh;
          ((Matrix)localObject2).reset();
          ((Matrix)localObject1).invert((Matrix)localObject2);
          localObject1 = (Matrix)paramai1.values.get("android:changeTransform:matrix");
          if (localObject1 != null) {
            break label669;
          }
          localObject1 = new Matrix();
          paramai1.values.put("android:changeTransform:matrix", localObject1);
        }
      }
      label645:
      label669:
      for (;;)
      {
        ((Matrix)localObject1).postConcat((Matrix)paramai1.values.get("android:changeTransform:parentMatrix"));
        ((Matrix)localObject1).postConcat((Matrix)localObject2);
        Object localObject3 = (Matrix)paramai1.values.get("android:changeTransform:matrix");
        localObject1 = (Matrix)paramai2.values.get("android:changeTransform:matrix");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = p.ny;
        }
        if (localObject1 == null) {
          localObject1 = p.ny;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1)) {}
          for (localObject1 = null;; localObject1 = localObject2)
          {
            if ((!bool) || (localObject1 == null) || (!this.qg)) {
              break label645;
            }
            b(paramViewGroup, paramai1, paramai2);
            return localObject1;
            i = 0;
            break;
            localObject2 = c(localViewGroup, true);
            if (localObject2 == null) {
              break label672;
            }
            if (localObject1 == ((ai)localObject2).view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            bool = false;
            break label115;
            localObject3 = (ChangeTransform.c)paramai2.values.get("android:changeTransform:transforms");
            View localView = paramai2.view;
            t(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(qd, new f(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = this.ss.getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, v.a(qe, (Path)localObject4) });
            localObject1 = new ChangeTransform.3(this, bool, (Matrix)localObject1, localView, (ChangeTransform.c)localObject3, localb);
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
          }
          paramViewGroup = (ViewGroup)localObject1;
          if (qf) {
            break;
          }
          localViewGroup.endViewTransition(paramai1.view);
          return localObject1;
        }
      }
      label672:
      i = 0;
    }
  }
  
  public final void a(ai paramai)
  {
    c(paramai);
    if (!qf) {
      ((ViewGroup)paramai.view.getParent()).startViewTransition(paramai.view);
    }
  }
  
  public final void b(ai paramai)
  {
    c(paramai);
  }
  
  public final String[] getTransitionProperties()
  {
    return ps;
  }
  
  private static final class b
  {
    final Matrix mMatrix = new Matrix();
    private final View mView;
    final float[] qo;
    float qp;
    float qr;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.qo = ((float[])paramArrayOfFloat.clone());
      this.qp = this.qo[2];
      this.qr = this.qo[5];
      bt();
    }
    
    final void bt()
    {
      this.qo[2] = this.qp;
      this.qo[5] = this.qr;
      this.mMatrix.setValues(this.qo);
      av.c(this.mView, this.mMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */