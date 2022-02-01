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
  private static final String[] xP;
  private static final boolean yA;
  private static final Property<b, float[]> yy;
  private static final Property<b, PointF> yz;
  private boolean xY = true;
  boolean yB = true;
  private Matrix yC = new Matrix();
  
  static
  {
    boolean bool = true;
    xP = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    yy = new Property([F.class, "nonTranslations") {};
    yz = new Property(PointF.class, "translations") {};
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      yA = bool;
      return;
      bool = false;
    }
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.zY);
    this.yB = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.xY = android.support.v4.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
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
      for (localObject = this; ((Transition)localObject).Au != null; localObject = ((Transition)localObject).Au) {}
      ((Transition)localObject).a(new a(localView, paramViewGroup));
    } while (!yA);
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
      if (!this.xY) {
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
    if (this.xY) {
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
          localObject2 = this.yC;
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
          localObject2 = i.vW;
        }
        if (localObject1 == null) {
          localObject1 = i.vW;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1)) {}
          for (localObject1 = null;; localObject1 = localObject2)
          {
            if ((!bool) || (localObject1 == null) || (!this.yB)) {
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
            localObject2 = PropertyValuesHolder.ofObject(yy, new c(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = this.AH.getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, l.a(yz, (Path)localObject4) });
            localObject1 = new AnimatorListenerAdapter()
            {
              private boolean mIsCanceled;
              private Matrix yC = new Matrix();
              
              private void a(Matrix paramAnonymousMatrix)
              {
                this.yC.set(paramAnonymousMatrix);
                localView.setTag(2131306070, this.yC);
                this.yF.C(localView);
              }
              
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.mIsCanceled = true;
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                if (!this.mIsCanceled)
                {
                  if ((!bool) || (!ChangeTransform.this.yB)) {
                    break label52;
                  }
                  a(this.yE);
                }
                for (;;)
                {
                  ag.c(localView, null);
                  this.yF.C(localView);
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
          if (yA) {
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
    if (!yA) {
      ((ViewGroup)paramu.view.getParent()).startViewTransition(paramu.view);
    }
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return xP;
  }
  
  static final class a
    extends q
  {
    private View mView;
    private g yI;
    
    a(View paramView, g paramg)
    {
      this.mView = paramView;
      this.yI = paramg;
    }
    
    public final void a(Transition paramTransition)
    {
      paramTransition.b(this);
      paramTransition = this.mView;
      if ((Build.VERSION.SDK_INT < 21) || (!f.zv)) {}
      try
      {
        f.dt();
        Method localMethod = f.zp.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f.zu = localMethod;
        localMethod.setAccessible(true);
        label55:
        f.zv = true;
        if (f.zu != null) {}
        try
        {
          f.zu.invoke(null, new Object[] { paramTransition });
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
    
    public final void dn()
    {
      this.yI.setVisibility(4);
    }
    
    public final void jdMethod_do()
    {
      this.yI.setVisibility(0);
    }
  }
  
  static final class b
  {
    final Matrix mMatrix = new Matrix();
    private final View mView;
    final float[] yJ;
    float yK;
    float yL;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.yJ = ((float[])paramArrayOfFloat.clone());
      this.yK = this.yJ[2];
      this.yL = this.yJ[5];
      dq();
    }
    
    final void dq()
    {
      this.yJ[2] = this.yK;
      this.yJ[5] = this.yL;
      this.mMatrix.setValues(this.yJ);
      ag.c(this.mView, this.mMatrix);
    }
  }
  
  static final class c
  {
    final float vM;
    final float vN;
    final float yK;
    final float yL;
    final float yM;
    final float yN;
    final float yO;
    final float yP;
    
    c(View paramView)
    {
      this.yK = paramView.getTranslationX();
      this.yL = paramView.getTranslationY();
      this.yM = t.am(paramView);
      this.vM = paramView.getScaleX();
      this.vN = paramView.getScaleY();
      this.yN = paramView.getRotationX();
      this.yO = paramView.getRotationY();
      this.yP = paramView.getRotation();
    }
    
    public final void C(View paramView)
    {
      ChangeTransform.a(paramView, this.yK, this.yL, this.yM, this.vM, this.vN, this.yN, this.yO, this.yP);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while ((paramObject.yK != this.yK) || (paramObject.yL != this.yL) || (paramObject.yM != this.yM) || (paramObject.vM != this.vM) || (paramObject.vN != this.vN) || (paramObject.yN != this.yN) || (paramObject.yO != this.yO) || (paramObject.yP != this.yP));
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
      if (this.yK != 0.0F)
      {
        i = Float.floatToIntBits(this.yK);
        if (this.yL == 0.0F) {
          break label191;
        }
        j = Float.floatToIntBits(this.yL);
        if (this.yM == 0.0F) {
          break label196;
        }
        k = Float.floatToIntBits(this.yM);
        if (this.vM == 0.0F) {
          break label201;
        }
        m = Float.floatToIntBits(this.vM);
        if (this.vN == 0.0F) {
          break label207;
        }
        n = Float.floatToIntBits(this.vN);
        if (this.yN == 0.0F) {
          break label213;
        }
        i1 = Float.floatToIntBits(this.yN);
        label108:
        if (this.yO == 0.0F) {
          break label219;
        }
      }
      label191:
      label196:
      label201:
      label207:
      label213:
      label219:
      for (int i2 = Float.floatToIntBits(this.yO);; i2 = 0)
      {
        if (this.yP != 0.0F) {
          i3 = Float.floatToIntBits(this.yP);
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