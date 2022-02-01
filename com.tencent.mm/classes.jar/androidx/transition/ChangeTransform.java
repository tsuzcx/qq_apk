package androidx.transition;

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
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final Property<b, float[]> apZ;
  private static final String[] apt;
  private static final Property<b, PointF> aqa;
  private static final boolean aqb;
  private Matrix JR;
  private boolean apC;
  boolean aqc;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(192031);
    apt = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    apZ = new Property([F.class, "nonTranslations") {};
    aqa = new Property(PointF.class, "translations") {};
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      aqb = bool;
      AppMethodBeat.o(192031);
      return;
      bool = false;
    }
  }
  
  public ChangeTransform()
  {
    AppMethodBeat.i(191992);
    this.aqc = true;
    this.apC = true;
    this.JR = new Matrix();
    AppMethodBeat.o(191992);
  }
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191999);
    this.aqc = true;
    this.apC = true;
    this.JR = new Matrix();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.aro);
    this.aqc = androidx.core.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.apC = androidx.core.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
    AppMethodBeat.o(191999);
  }
  
  static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(192026);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    androidx.core.g.w.k(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
    AppMethodBeat.o(192026);
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(192010);
    View localView = paramw.view;
    if (localView.getVisibility() == 8)
    {
      AppMethodBeat.o(192010);
      return;
    }
    paramw.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new c(localView);
    paramw.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramw.values.put("android:changeTransform:matrix", localObject);
      if (this.apC)
      {
        localObject = new Matrix();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        ai.a(localViewGroup, (Matrix)localObject);
        ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
        paramw.values.put("android:changeTransform:parentMatrix", localObject);
        paramw.values.put("android:changeTransform:intermediateMatrix", localView.getTag(m.a.transition_transform));
        paramw.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(m.a.parent_matrix));
      }
      AppMethodBeat.o(192010);
      return;
    }
  }
  
  private void b(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(192021);
    View localView = paramw2.view;
    Object localObject = new Matrix((Matrix)paramw2.values.get("android:changeTransform:parentMatrix"));
    ai.b(paramViewGroup, (Matrix)localObject);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramViewGroup = f.a(localView, paramViewGroup, (Matrix)localObject); paramViewGroup == null; paramViewGroup = e.a(localView, paramViewGroup))
    {
      AppMethodBeat.o(192021);
      return;
    }
    paramViewGroup.a((ViewGroup)paramw1.values.get("android:changeTransform:parent"), paramw1.view);
    for (localObject = this; ((Transition)localObject).arL != null; localObject = ((Transition)localObject).arL) {}
    ((Transition)localObject).a(new a(localView, paramViewGroup));
    if (aqb)
    {
      if (paramw1.view != paramw2.view) {
        ai.n(paramw1.view, 0.0F);
      }
      ai.n(localView, 1.0F);
    }
    AppMethodBeat.o(192021);
  }
  
  static void bA(View paramView)
  {
    AppMethodBeat.i(192024);
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(192024);
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(192017);
    if ((paramw1 == null) || (paramw2 == null) || (!paramw1.values.containsKey("android:changeTransform:parent")) || (!paramw2.values.containsKey("android:changeTransform:parent")))
    {
      AppMethodBeat.o(192017);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)paramw1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramw2.values.get("android:changeTransform:parent");
    int i;
    if (this.apC) {
      if ((!bE(localViewGroup)) || (!bE((View)localObject1))) {
        if (localViewGroup == localObject1) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      final boolean bool;
      label125:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        localObject1 = (Matrix)paramw1.values.get("android:changeTransform:intermediateMatrix");
        if (localObject1 != null) {
          paramw1.values.put("android:changeTransform:matrix", localObject1);
        }
        localObject1 = (Matrix)paramw1.values.get("android:changeTransform:intermediateParentMatrix");
        if (localObject1 != null) {
          paramw1.values.put("android:changeTransform:parentMatrix", localObject1);
        }
        if (bool)
        {
          localObject1 = (Matrix)paramw2.values.get("android:changeTransform:parentMatrix");
          paramw2.view.setTag(m.a.parent_matrix, localObject1);
          localObject2 = this.JR;
          ((Matrix)localObject2).reset();
          ((Matrix)localObject1).invert((Matrix)localObject2);
          localObject1 = (Matrix)paramw1.values.get("android:changeTransform:matrix");
          if (localObject1 != null) {
            break label682;
          }
          localObject1 = new Matrix();
          paramw1.values.put("android:changeTransform:matrix", localObject1);
        }
      }
      label388:
      label661:
      label682:
      for (;;)
      {
        ((Matrix)localObject1).postConcat((Matrix)paramw1.values.get("android:changeTransform:parentMatrix"));
        ((Matrix)localObject1).postConcat((Matrix)localObject2);
        Object localObject3 = (Matrix)paramw1.values.get("android:changeTransform:matrix");
        localObject1 = (Matrix)paramw2.values.get("android:changeTransform:matrix");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = i.aqQ;
        }
        if (localObject1 == null) {
          localObject1 = i.aqQ;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1))
          {
            localObject1 = null;
            if ((!bool) || (localObject1 == null) || (!this.aqc)) {
              break label661;
            }
            b(paramViewGroup, paramw1, paramw2);
          }
          for (;;)
          {
            AppMethodBeat.o(192017);
            return localObject1;
            i = 0;
            break;
            localObject2 = i(localViewGroup, true);
            if (localObject2 == null) {
              break label685;
            }
            if (localObject1 == ((w)localObject2).view)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            bool = false;
            break label125;
            localObject3 = (c)paramw2.values.get("android:changeTransform:transforms");
            final View localView = paramw2.view;
            bA(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            final b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(apZ, new c(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = ns().getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, l.a(aqa, (Path)localObject4) });
            localObject1 = new AnimatorListenerAdapter()
            {
              private Matrix JR;
              private boolean mIsCanceled;
              
              private void a(Matrix paramAnonymousMatrix)
              {
                AppMethodBeat.i(191943);
                this.JR.set(paramAnonymousMatrix);
                localView.setTag(m.a.transition_transform, this.JR);
                this.aqf.bB(localView);
                AppMethodBeat.o(191943);
              }
              
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.mIsCanceled = true;
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(191936);
                if (!this.mIsCanceled)
                {
                  if ((!bool) || (!ChangeTransform.this.aqc)) {
                    break label62;
                  }
                  a(this.aqe);
                }
                for (;;)
                {
                  ai.c(localView, null);
                  this.aqf.bB(localView);
                  AppMethodBeat.o(191936);
                  return;
                  label62:
                  localView.setTag(m.a.transition_transform, null);
                  localView.setTag(m.a.parent_matrix, null);
                }
              }
              
              public final void onAnimationPause(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(191938);
                a(localb.aqj);
                AppMethodBeat.o(191938);
              }
              
              public final void onAnimationResume(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(191940);
                ChangeTransform.bA(localView);
                AppMethodBeat.o(191940);
              }
            };
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
            localObject1 = localObject2;
            break label388;
            if (!aqb) {
              localViewGroup.endViewTransition(paramw1.view);
            }
          }
        }
      }
      label685:
      i = 0;
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(192013);
    a(paramw);
    if (!aqb) {
      ((ViewGroup)paramw.view.getParent()).startViewTransition(paramw.view);
    }
    AppMethodBeat.o(192013);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(192014);
    a(paramw);
    AppMethodBeat.o(192014);
  }
  
  public final String[] nf()
  {
    return apt;
  }
  
  static final class a
    extends s
  {
    private g aqi;
    private View mView;
    
    a(View paramView, g paramg)
    {
      this.mView = paramView;
      this.aqi = paramg;
    }
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(191958);
      paramTransition.b(this);
      paramTransition = this.mView;
      if ((Build.VERSION.SDK_INT < 21) || (!f.aqL)) {}
      try
      {
        f.nm();
        Method localMethod = f.aqG.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f.aqK = localMethod;
        localMethod.setAccessible(true);
        label60:
        f.aqL = true;
        if (f.aqK != null) {}
        try
        {
          f.aqK.invoke(null, new Object[] { paramTransition });
          label86:
          this.mView.setTag(m.a.transition_transform, null);
          this.mView.setTag(m.a.parent_matrix, null);
          AppMethodBeat.o(191958);
          return;
        }
        catch (InvocationTargetException paramTransition)
        {
          for (;;)
          {
            paramTransition = new RuntimeException(paramTransition.getCause());
            AppMethodBeat.o(191958);
            throw paramTransition;
            e.bC(paramTransition);
          }
        }
        catch (IllegalAccessException paramTransition)
        {
          break label86;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        break label60;
      }
    }
    
    public final void ng()
    {
      AppMethodBeat.i(191960);
      this.aqi.setVisibility(4);
      AppMethodBeat.o(191960);
    }
    
    public final void nh()
    {
      AppMethodBeat.i(191963);
      this.aqi.setVisibility(0);
      AppMethodBeat.o(191963);
    }
  }
  
  static final class b
  {
    final float[] Zt;
    final Matrix aqj;
    float aqk;
    float aql;
    private final View mView;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(191968);
      this.aqj = new Matrix();
      this.mView = paramView;
      this.Zt = ((float[])paramArrayOfFloat.clone());
      this.aqk = this.Zt[2];
      this.aql = this.Zt[5];
      nj();
      AppMethodBeat.o(191968);
    }
    
    final void nj()
    {
      AppMethodBeat.i(191970);
      this.Zt[2] = this.aqk;
      this.Zt[5] = this.aql;
      this.aqj.setValues(this.Zt);
      ai.c(this.mView, this.aqj);
      AppMethodBeat.o(191970);
    }
  }
  
  static final class c
  {
    final float aqk;
    final float aql;
    final float aqm;
    final float aqn;
    final float aqo;
    final float aqp;
    final float aqq;
    final float aqr;
    
    c(View paramView)
    {
      AppMethodBeat.i(191976);
      this.aqk = paramView.getTranslationX();
      this.aql = paramView.getTranslationY();
      this.aqm = androidx.core.g.w.V(paramView);
      this.aqn = paramView.getScaleX();
      this.aqo = paramView.getScaleY();
      this.aqp = paramView.getRotationX();
      this.aqq = paramView.getRotationY();
      this.aqr = paramView.getRotation();
      AppMethodBeat.o(191976);
    }
    
    public final void bB(View paramView)
    {
      AppMethodBeat.i(191980);
      ChangeTransform.a(paramView, this.aqk, this.aql, this.aqm, this.aqn, this.aqo, this.aqp, this.aqq, this.aqr);
      AppMethodBeat.o(191980);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while ((paramObject.aqk != this.aqk) || (paramObject.aql != this.aql) || (paramObject.aqm != this.aqm) || (paramObject.aqn != this.aqn) || (paramObject.aqo != this.aqo) || (paramObject.aqp != this.aqp) || (paramObject.aqq != this.aqq) || (paramObject.aqr != this.aqr));
      return true;
    }
    
    public final int hashCode()
    {
      int i3 = 0;
      AppMethodBeat.i(191989);
      int i;
      int j;
      label42:
      int k;
      label59:
      int m;
      label77:
      int n;
      label95:
      int i1;
      if (this.aqk != 0.0F)
      {
        i = Float.floatToIntBits(this.aqk);
        if (this.aql == 0.0F) {
          break label201;
        }
        j = Float.floatToIntBits(this.aql);
        if (this.aqm == 0.0F) {
          break label206;
        }
        k = Float.floatToIntBits(this.aqm);
        if (this.aqn == 0.0F) {
          break label211;
        }
        m = Float.floatToIntBits(this.aqn);
        if (this.aqo == 0.0F) {
          break label217;
        }
        n = Float.floatToIntBits(this.aqo);
        if (this.aqp == 0.0F) {
          break label223;
        }
        i1 = Float.floatToIntBits(this.aqp);
        label113:
        if (this.aqq == 0.0F) {
          break label229;
        }
      }
      label201:
      label206:
      label211:
      label217:
      label223:
      label229:
      for (int i2 = Float.floatToIntBits(this.aqq);; i2 = 0)
      {
        if (this.aqr != 0.0F) {
          i3 = Float.floatToIntBits(this.aqr);
        }
        AppMethodBeat.o(191989);
        return (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
        i = 0;
        break;
        j = 0;
        break label42;
        k = 0;
        break label59;
        m = 0;
        break label77;
        n = 0;
        break label95;
        i1 = 0;
        break label113;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */