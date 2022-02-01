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
import android.support.v4.view.t;
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
  private static final Property<b, float[]> Ar;
  private static final Property<b, PointF> As;
  private static final boolean At;
  private static final String[] zJ;
  boolean Au = true;
  private Matrix Av = new Matrix();
  private boolean zS = true;
  
  static
  {
    boolean bool = true;
    zJ = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    Ar = new Property([F.class, "nonTranslations") {};
    As = new Property(PointF.class, "translations") {};
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      At = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BP);
    this.Au = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.zS = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  static void B(View paramView)
  {
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    t.l(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private void b(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    View localView = paramu2.view;
    Object localObject = new Matrix((Matrix)paramu2.values.get("android:changeTransform:parentMatrix"));
    ag.b(paramViewGroup, (Matrix)localObject);
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
      paramViewGroup.a((ViewGroup)paramu1.values.get("android:changeTransform:parent"), paramu1.view);
      for (localObject = this; ((Transition)localObject).Cl != null; localObject = ((Transition)localObject).Cl) {}
      ((Transition)localObject).a(new a(localView, paramViewGroup));
    } while (!At);
    if (paramu1.view != paramu2.view) {
      ag.d(paramu1.view, 0.0F);
    }
    ag.d(localView, 1.0F);
  }
  
  private void c(u paramu)
  {
    View localView = paramu.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramu.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new c(localView);
    paramu.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramu.values.put("android:changeTransform:matrix", localObject);
      if (!this.zS) {
        break;
      }
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      ag.a(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramu.values.put("android:changeTransform:parentMatrix", localObject);
      paramu.values.put("android:changeTransform:intermediateMatrix", localView.getTag(2131306070));
      paramu.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(2131303140));
      return;
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    if ((paramu1 == null) || (paramu2 == null) || (!paramu1.values.containsKey("android:changeTransform:parent")) || (!paramu2.values.containsKey("android:changeTransform:parent")))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)paramu1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramu2.values.get("android:changeTransform:parent");
    int i;
    if (this.zS) {
      if ((!G(localViewGroup)) || (!G((View)localObject1))) {
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
        localObject1 = (Matrix)paramu1.values.get("android:changeTransform:intermediateMatrix");
        if (localObject1 != null) {
          paramu1.values.put("android:changeTransform:matrix", localObject1);
        }
        localObject1 = (Matrix)paramu1.values.get("android:changeTransform:intermediateParentMatrix");
        if (localObject1 != null) {
          paramu1.values.put("android:changeTransform:parentMatrix", localObject1);
        }
        if (bool)
        {
          localObject1 = (Matrix)paramu2.values.get("android:changeTransform:parentMatrix");
          paramu2.view.setTag(2131303140, localObject1);
          localObject2 = this.Av;
          ((Matrix)localObject2).reset();
          ((Matrix)localObject1).invert((Matrix)localObject2);
          localObject1 = (Matrix)paramu1.values.get("android:changeTransform:matrix");
          if (localObject1 != null) {
            break label668;
          }
          localObject1 = new Matrix();
          paramu1.values.put("android:changeTransform:matrix", localObject1);
        }
      }
      label644:
      label668:
      for (;;)
      {
        ((Matrix)localObject1).postConcat((Matrix)paramu1.values.get("android:changeTransform:parentMatrix"));
        ((Matrix)localObject1).postConcat((Matrix)localObject2);
        Object localObject3 = (Matrix)paramu1.values.get("android:changeTransform:matrix");
        localObject1 = (Matrix)paramu2.values.get("android:changeTransform:matrix");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = i.xP;
        }
        if (localObject1 == null) {
          localObject1 = i.xP;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1)) {}
          for (localObject1 = null;; localObject1 = localObject2)
          {
            if ((!bool) || (localObject1 == null) || (!this.Au)) {
              break label644;
            }
            b(paramViewGroup, paramu1, paramu2);
            return localObject1;
            i = 0;
            break;
            localObject2 = c(localViewGroup, true);
            if (localObject2 == null) {
              break label671;
            }
            if (localObject1 == ((u)localObject2).view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            bool = false;
            break label115;
            localObject3 = (c)paramu2.values.get("android:changeTransform:transforms");
            final View localView = paramu2.view;
            B(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            final b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(Ar, new c(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = this.Cy.getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, l.a(As, (Path)localObject4) });
            localObject1 = new AnimatorListenerAdapter()
            {
              private Matrix Av = new Matrix();
              private boolean mIsCanceled;
              
              private void a(Matrix paramAnonymousMatrix)
              {
                this.Av.set(paramAnonymousMatrix);
                localView.setTag(2131306070, this.Av);
                this.Ay.C(localView);
              }
              
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.mIsCanceled = true;
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                if (!this.mIsCanceled)
                {
                  if ((!bool) || (!ChangeTransform.this.Au)) {
                    break label52;
                  }
                  a(this.Ax);
                }
                for (;;)
                {
                  ag.c(localView, null);
                  this.Ay.C(localView);
                  return;
                  label52:
                  localView.setTag(2131306070, null);
                  localView.setTag(2131303140, null);
                }
              }
              
              public final void onAnimationPause(Animator paramAnonymousAnimator)
              {
                a(localb.mMatrix);
              }
              
              public final void onAnimationResume(Animator paramAnonymousAnimator)
              {
                ChangeTransform.B(localView);
              }
            };
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
          }
          paramViewGroup = (ViewGroup)localObject1;
          if (At) {
            break;
          }
          localViewGroup.endViewTransition(paramu1.view);
          return localObject1;
        }
      }
      label671:
      i = 0;
    }
  }
  
  public final void a(u paramu)
  {
    c(paramu);
    if (!At) {
      ((ViewGroup)paramu.view.getParent()).startViewTransition(paramu.view);
    }
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return zJ;
  }
  
  static final class a
    extends q
  {
    private g AB;
    private View mView;
    
    a(View paramView, g paramg)
    {
      this.mView = paramView;
      this.AB = paramg;
    }
    
    public final void a(Transition paramTransition)
    {
      paramTransition.b(this);
      paramTransition = this.mView;
      if ((Build.VERSION.SDK_INT < 21) || (!f.Bm)) {}
      try
      {
        f.dI();
        Method localMethod = f.Bh.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f.Bl = localMethod;
        localMethod.setAccessible(true);
        label55:
        f.Bm = true;
        if (f.Bl != null) {}
        try
        {
          f.Bl.invoke(null, new Object[] { paramTransition });
          label81:
          this.mView.setTag(2131306070, null);
          this.mView.setTag(2131303140, null);
          return;
        }
        catch (InvocationTargetException paramTransition)
        {
          for (;;)
          {
            throw new RuntimeException(paramTransition.getCause());
            e.D(paramTransition);
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
    
    public final void dC()
    {
      this.AB.setVisibility(4);
    }
    
    public final void dD()
    {
      this.AB.setVisibility(0);
    }
  }
  
  static final class b
  {
    final float[] AC;
    float AD;
    float AE;
    final Matrix mMatrix = new Matrix();
    private final View mView;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.AC = ((float[])paramArrayOfFloat.clone());
      this.AD = this.AC[2];
      this.AE = this.AC[5];
      dF();
    }
    
    final void dF()
    {
      this.AC[2] = this.AD;
      this.AC[5] = this.AE;
      this.mMatrix.setValues(this.AC);
      ag.c(this.mView, this.mMatrix);
    }
  }
  
  static final class c
  {
    final float AD;
    final float AE;
    final float AF;
    final float AG;
    final float AH;
    final float AI;
    final float xF;
    final float xG;
    
    c(View paramView)
    {
      this.AD = paramView.getTranslationX();
      this.AE = paramView.getTranslationY();
      this.AF = t.am(paramView);
      this.xF = paramView.getScaleX();
      this.xG = paramView.getScaleY();
      this.AG = paramView.getRotationX();
      this.AH = paramView.getRotationY();
      this.AI = paramView.getRotation();
    }
    
    public final void C(View paramView)
    {
      ChangeTransform.a(paramView, this.AD, this.AE, this.AF, this.xF, this.xG, this.AG, this.AH, this.AI);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while ((paramObject.AD != this.AD) || (paramObject.AE != this.AE) || (paramObject.AF != this.AF) || (paramObject.xF != this.xF) || (paramObject.xG != this.xG) || (paramObject.AG != this.AG) || (paramObject.AH != this.AH) || (paramObject.AI != this.AI));
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
      if (this.AD != 0.0F)
      {
        i = Float.floatToIntBits(this.AD);
        if (this.AE == 0.0F) {
          break label191;
        }
        j = Float.floatToIntBits(this.AE);
        if (this.AF == 0.0F) {
          break label196;
        }
        k = Float.floatToIntBits(this.AF);
        if (this.xF == 0.0F) {
          break label201;
        }
        m = Float.floatToIntBits(this.xF);
        if (this.xG == 0.0F) {
          break label207;
        }
        n = Float.floatToIntBits(this.xG);
        if (this.AG == 0.0F) {
          break label213;
        }
        i1 = Float.floatToIntBits(this.AG);
        label108:
        if (this.AH == 0.0F) {
          break label219;
        }
      }
      label191:
      label196:
      label201:
      label207:
      label213:
      label219:
      for (int i2 = Float.floatToIntBits(this.AH);; i2 = 0)
      {
        if (this.AI != 0.0F) {
          i3 = Float.floatToIntBits(this.AI);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */