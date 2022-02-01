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
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final Property<b, float[]> Ax;
  private static final Property<b, PointF> Ay;
  private static final boolean Az;
  private static final String[] zP;
  boolean AA = true;
  private Matrix AB = new Matrix();
  private boolean zY = true;
  
  static
  {
    boolean bool = true;
    zP = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    Ax = new Property([F.class, "nonTranslations") {};
    Ay = new Property(PointF.class, "translations") {};
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      Az = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BW);
    this.AA = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.zY = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  static void C(View paramView)
  {
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    u.m(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private void b(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    View localView = paramv2.view;
    Object localObject = new Matrix((Matrix)paramv2.values.get("android:changeTransform:parentMatrix"));
    ah.b(paramViewGroup, (Matrix)localObject);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramViewGroup = f.a(localView, paramViewGroup, (Matrix)localObject);
      if (paramViewGroup != null) {
        break label67;
      }
    }
    label67:
    do
    {
      return;
      paramViewGroup = e.a(localView, paramViewGroup);
      break;
      paramViewGroup.a((ViewGroup)paramv1.values.get("android:changeTransform:parent"), paramv1.view);
      for (localObject = this; ((Transition)localObject).Cs != null; localObject = ((Transition)localObject).Cs) {}
      ((Transition)localObject).a(new a(localView, paramViewGroup));
    } while (!Az);
    if (paramv1.view != paramv2.view) {
      ah.d(paramv1.view, 0.0F);
    }
    ah.d(localView, 1.0F);
  }
  
  private void c(v paramv)
  {
    View localView = paramv.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramv.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new c(localView);
    paramv.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramv.values.put("android:changeTransform:matrix", localObject);
      if (!this.zY) {
        break;
      }
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      ah.a(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramv.values.put("android:changeTransform:parentMatrix", localObject);
      paramv.values.put("android:changeTransform:intermediateMatrix", localView.getTag(2131309400));
      paramv.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(2131305782));
      return;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    if ((paramv1 == null) || (paramv2 == null) || (!paramv1.values.containsKey("android:changeTransform:parent")) || (!paramv2.values.containsKey("android:changeTransform:parent")))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)paramv1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramv2.values.get("android:changeTransform:parent");
    int i;
    if (this.zY) {
      if ((!H(localViewGroup)) || (!H((View)localObject1))) {
        if (localViewGroup == localObject1) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      final boolean bool;
      label115:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        localObject1 = (Matrix)paramv1.values.get("android:changeTransform:intermediateMatrix");
        if (localObject1 != null) {
          paramv1.values.put("android:changeTransform:matrix", localObject1);
        }
        localObject1 = (Matrix)paramv1.values.get("android:changeTransform:intermediateParentMatrix");
        if (localObject1 != null) {
          paramv1.values.put("android:changeTransform:parentMatrix", localObject1);
        }
        if (bool)
        {
          localObject1 = (Matrix)paramv2.values.get("android:changeTransform:parentMatrix");
          paramv2.view.setTag(2131305782, localObject1);
          localObject2 = this.AB;
          ((Matrix)localObject2).reset();
          ((Matrix)localObject1).invert((Matrix)localObject2);
          localObject1 = (Matrix)paramv1.values.get("android:changeTransform:matrix");
          if (localObject1 != null) {
            break label668;
          }
          localObject1 = new Matrix();
          paramv1.values.put("android:changeTransform:matrix", localObject1);
        }
      }
      label644:
      label668:
      for (;;)
      {
        ((Matrix)localObject1).postConcat((Matrix)paramv1.values.get("android:changeTransform:parentMatrix"));
        ((Matrix)localObject1).postConcat((Matrix)localObject2);
        Object localObject3 = (Matrix)paramv1.values.get("android:changeTransform:matrix");
        localObject1 = (Matrix)paramv2.values.get("android:changeTransform:matrix");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = i.xV;
        }
        if (localObject1 == null) {
          localObject1 = i.xV;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1)) {}
          for (localObject1 = null;; localObject1 = localObject2)
          {
            if ((!bool) || (localObject1 == null) || (!this.AA)) {
              break label644;
            }
            b(paramViewGroup, paramv1, paramv2);
            return localObject1;
            i = 0;
            break;
            localObject2 = c(localViewGroup, true);
            if (localObject2 == null) {
              break label671;
            }
            if (localObject1 == ((v)localObject2).view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            bool = false;
            break label115;
            localObject3 = (c)paramv2.values.get("android:changeTransform:transforms");
            final View localView = paramv2.view;
            C(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            final b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(Ax, new c(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = this.CF.getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, l.a(Ay, (Path)localObject4) });
            localObject1 = new AnimatorListenerAdapter()
            {
              private Matrix AB = new Matrix();
              private boolean mIsCanceled;
              
              private void a(Matrix paramAnonymousMatrix)
              {
                this.AB.set(paramAnonymousMatrix);
                localView.setTag(2131309400, this.AB);
                this.AE.D(localView);
              }
              
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.mIsCanceled = true;
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                if (!this.mIsCanceled)
                {
                  if ((!bool) || (!ChangeTransform.this.AA)) {
                    break label52;
                  }
                  a(this.AD);
                }
                for (;;)
                {
                  ah.c(localView, null);
                  this.AE.D(localView);
                  return;
                  label52:
                  localView.setTag(2131309400, null);
                  localView.setTag(2131305782, null);
                }
              }
              
              public final void onAnimationPause(Animator paramAnonymousAnimator)
              {
                a(localb.mMatrix);
              }
              
              public final void onAnimationResume(Animator paramAnonymousAnimator)
              {
                ChangeTransform.C(localView);
              }
            };
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
          }
          paramViewGroup = (ViewGroup)localObject1;
          if (Az) {
            break;
          }
          localViewGroup.endViewTransition(paramv1.view);
          return localObject1;
        }
      }
      label671:
      i = 0;
    }
  }
  
  public final void a(v paramv)
  {
    c(paramv);
    if (!Az) {
      ((ViewGroup)paramv.view.getParent()).startViewTransition(paramv.view);
    }
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
    extends r
  {
    private g AH;
    private View mView;
    
    a(View paramView, g paramg)
    {
      this.mView = paramView;
      this.AH = paramg;
    }
    
    public final void a(Transition paramTransition)
    {
      paramTransition.b(this);
      paramTransition = this.mView;
      if ((Build.VERSION.SDK_INT < 21) || (!f.Bs)) {}
      try
      {
        f.dL();
        Method localMethod = f.Bn.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f.Br = localMethod;
        localMethod.setAccessible(true);
        label55:
        f.Bs = true;
        if (f.Br != null) {}
        try
        {
          f.Br.invoke(null, new Object[] { paramTransition });
          label81:
          this.mView.setTag(2131309400, null);
          this.mView.setTag(2131305782, null);
          return;
        }
        catch (InvocationTargetException paramTransition)
        {
          for (;;)
          {
            throw new RuntimeException(paramTransition.getCause());
            e.E(paramTransition);
          }
        }
        catch (IllegalAccessException paramTransition)
        {
          break label81;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label55;
      }
    }
    
    public final void dF()
    {
      this.AH.setVisibility(4);
    }
    
    public final void dG()
    {
      this.AH.setVisibility(0);
    }
  }
  
  static final class b
  {
    final float[] AI;
    float AJ;
    float AK;
    final Matrix mMatrix = new Matrix();
    private final View mView;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.AI = ((float[])paramArrayOfFloat.clone());
      this.AJ = this.AI[2];
      this.AK = this.AI[5];
      dI();
    }
    
    final void dI()
    {
      this.AI[2] = this.AJ;
      this.AI[5] = this.AK;
      this.mMatrix.setValues(this.AI);
      ah.c(this.mView, this.mMatrix);
    }
  }
  
  static final class c
  {
    final float AJ;
    final float AK;
    final float AL;
    final float AM;
    final float AN;
    final float AO;
    final float xL;
    final float xM;
    
    c(View paramView)
    {
      this.AJ = paramView.getTranslationX();
      this.AK = paramView.getTranslationY();
      this.AL = u.am(paramView);
      this.xL = paramView.getScaleX();
      this.xM = paramView.getScaleY();
      this.AM = paramView.getRotationX();
      this.AN = paramView.getRotationY();
      this.AO = paramView.getRotation();
    }
    
    public final void D(View paramView)
    {
      ChangeTransform.a(paramView, this.AJ, this.AK, this.AL, this.xL, this.xM, this.AM, this.AN, this.AO);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while ((paramObject.AJ != this.AJ) || (paramObject.AK != this.AK) || (paramObject.AL != this.AL) || (paramObject.xL != this.xL) || (paramObject.xM != this.xM) || (paramObject.AM != this.AM) || (paramObject.AN != this.AN) || (paramObject.AO != this.AO));
      return true;
    }
    
    public final int hashCode()
    {
      int i3 = 0;
      int i;
      int j;
      label37:
      int k;
      label54:
      int m;
      label72:
      int n;
      label90:
      int i1;
      if (this.AJ != 0.0F)
      {
        i = Float.floatToIntBits(this.AJ);
        if (this.AK == 0.0F) {
          break label191;
        }
        j = Float.floatToIntBits(this.AK);
        if (this.AL == 0.0F) {
          break label196;
        }
        k = Float.floatToIntBits(this.AL);
        if (this.xL == 0.0F) {
          break label201;
        }
        m = Float.floatToIntBits(this.xL);
        if (this.xM == 0.0F) {
          break label207;
        }
        n = Float.floatToIntBits(this.xM);
        if (this.AM == 0.0F) {
          break label213;
        }
        i1 = Float.floatToIntBits(this.AM);
        label108:
        if (this.AN == 0.0F) {
          break label219;
        }
      }
      label191:
      label196:
      label201:
      label207:
      label213:
      label219:
      for (int i2 = Float.floatToIntBits(this.AN);; i2 = 0)
      {
        if (this.AO != 0.0F) {
          i3 = Float.floatToIntBits(this.AO);
        }
        return (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
        i = 0;
        break;
        j = 0;
        break label37;
        k = 0;
        break label54;
        m = 0;
        break label72;
        n = 0;
        break label90;
        i1 = 0;
        break label108;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */