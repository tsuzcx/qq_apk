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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final Property<b, float[]> ceI;
  private static final Property<b, PointF> ceJ;
  private static final boolean ceK;
  private static final String[] cec;
  private Matrix bpU;
  boolean ceL;
  private boolean cel;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(201535);
    cec = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
    ceI = new Property([F.class, "nonTranslations") {};
    ceJ = new Property(PointF.class, "translations") {};
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      ceK = bool;
      AppMethodBeat.o(201535);
      return;
      bool = false;
    }
  }
  
  public ChangeTransform()
  {
    AppMethodBeat.i(201481);
    this.ceL = true;
    this.cel = true;
    this.bpU = new Matrix();
    AppMethodBeat.o(201481);
  }
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201489);
    this.ceL = true;
    this.cel = true;
    this.bpU = new Matrix();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfX);
    this.ceL = androidx.core.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparentWithOverlay", 1, true);
    this.cel = androidx.core.content.a.g.a(paramContext, (XmlPullParser)paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
    AppMethodBeat.o(201489);
  }
  
  static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(201528);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    z.l(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
    AppMethodBeat.o(201528);
  }
  
  private void a(w paramw)
  {
    AppMethodBeat.i(201501);
    View localView = paramw.view;
    if (localView.getVisibility() == 8)
    {
      AppMethodBeat.o(201501);
      return;
    }
    paramw.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new ChangeTransform.c(localView);
    paramw.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject == null) || (((Matrix)localObject).isIdentity())) {}
    for (localObject = null;; localObject = new Matrix((Matrix)localObject))
    {
      paramw.values.put("android:changeTransform:matrix", localObject);
      if (this.cel)
      {
        localObject = new Matrix();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        ai.a(localViewGroup, (Matrix)localObject);
        ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
        paramw.values.put("android:changeTransform:parentMatrix", localObject);
        paramw.values.put("android:changeTransform:intermediateMatrix", localView.getTag(m.a.transition_transform));
        paramw.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(m.a.parent_matrix));
      }
      AppMethodBeat.o(201501);
      return;
    }
  }
  
  private void b(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201512);
    View localView = paramw2.view;
    Object localObject = new Matrix((Matrix)paramw2.values.get("android:changeTransform:parentMatrix"));
    ai.b(paramViewGroup, (Matrix)localObject);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramViewGroup = f.a(localView, paramViewGroup, (Matrix)localObject); paramViewGroup == null; paramViewGroup = e.a(localView, paramViewGroup))
    {
      AppMethodBeat.o(201512);
      return;
    }
    paramViewGroup.a((ViewGroup)paramw1.values.get("android:changeTransform:parent"), paramw1.view);
    for (localObject = this; ((Transition)localObject).cgu != null; localObject = ((Transition)localObject).cgu) {}
    ((Transition)localObject).a(new a(localView, paramViewGroup));
    if (ceK)
    {
      if (paramw1.view != paramw2.view) {
        ai.o(paramw1.view, 0.0F);
      }
      ai.o(localView, 1.0F);
    }
    AppMethodBeat.o(201512);
  }
  
  static void bU(View paramView)
  {
    AppMethodBeat.i(201521);
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(201521);
  }
  
  public final String[] LI()
  {
    return cec;
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201571);
    if ((paramw1 == null) || (paramw2 == null) || (!paramw1.values.containsKey("android:changeTransform:parent")) || (!paramw2.values.containsKey("android:changeTransform:parent")))
    {
      AppMethodBeat.o(201571);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)paramw1.values.get("android:changeTransform:parent");
    Object localObject1 = (ViewGroup)paramw2.values.get("android:changeTransform:parent");
    int i;
    if (this.cel) {
      if ((!bY(localViewGroup)) || (!bY((View)localObject1))) {
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
          localObject2 = this.bpU;
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
          localObject2 = i.cfz;
        }
        if (localObject1 == null) {
          localObject1 = i.cfz;
        }
        for (;;)
        {
          if (((Matrix)localObject2).equals(localObject1))
          {
            localObject1 = null;
            if ((!bool) || (localObject1 == null) || (!this.ceL)) {
              break label661;
            }
            b(paramViewGroup, paramw1, paramw2);
          }
          for (;;)
          {
            AppMethodBeat.o(201571);
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
            localObject3 = (ChangeTransform.c)paramw2.values.get("android:changeTransform:transforms");
            final View localView = paramw2.view;
            bU(localView);
            Object localObject4 = new float[9];
            ((Matrix)localObject2).getValues((float[])localObject4);
            float[] arrayOfFloat = new float[9];
            ((Matrix)localObject1).getValues(arrayOfFloat);
            final b localb = new b(localView, (float[])localObject4);
            localObject2 = PropertyValuesHolder.ofObject(ceI, new c(new float[9]), new float[][] { localObject4, arrayOfFloat });
            localObject4 = LV().getPath(localObject4[2], localObject4[5], arrayOfFloat[2], arrayOfFloat[5]);
            localObject2 = ObjectAnimator.ofPropertyValuesHolder(localb, new PropertyValuesHolder[] { localObject2, l.a(ceJ, (Path)localObject4) });
            localObject1 = new AnimatorListenerAdapter()
            {
              private Matrix bpU;
              private boolean mIsCanceled;
              
              private void c(Matrix paramAnonymousMatrix)
              {
                AppMethodBeat.i(201448);
                this.bpU.set(paramAnonymousMatrix);
                localView.setTag(m.a.transition_transform, this.bpU);
                this.ceO.bV(localView);
                AppMethodBeat.o(201448);
              }
              
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.mIsCanceled = true;
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(201465);
                if (!this.mIsCanceled)
                {
                  if ((!bool) || (!ChangeTransform.this.ceL)) {
                    break label62;
                  }
                  c(this.ceN);
                }
                for (;;)
                {
                  ai.c(localView, null);
                  this.ceO.bV(localView);
                  AppMethodBeat.o(201465);
                  return;
                  label62:
                  localView.setTag(m.a.transition_transform, null);
                  localView.setTag(m.a.parent_matrix, null);
                }
              }
              
              public final void onAnimationPause(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(201470);
                c(localb.avQ);
                AppMethodBeat.o(201470);
              }
              
              public final void onAnimationResume(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(201479);
                ChangeTransform.bU(localView);
                AppMethodBeat.o(201479);
              }
            };
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)localObject1);
            a.a((Animator)localObject2, (AnimatorListenerAdapter)localObject1);
            localObject1 = localObject2;
            break label388;
            if (!ceK) {
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
    AppMethodBeat.i(201547);
    a(paramw);
    if (!ceK) {
      ((ViewGroup)paramw.view.getParent()).startViewTransition(paramw.view);
    }
    AppMethodBeat.o(201547);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201554);
    a(paramw);
    AppMethodBeat.o(201554);
  }
  
  static final class a
    extends s
  {
    private g ceR;
    private View mView;
    
    a(View paramView, g paramg)
    {
      this.mView = paramView;
      this.ceR = paramg;
    }
    
    public final void LJ()
    {
      AppMethodBeat.i(201397);
      this.ceR.setVisibility(4);
      AppMethodBeat.o(201397);
    }
    
    public final void LK()
    {
      AppMethodBeat.i(201405);
      this.ceR.setVisibility(0);
      AppMethodBeat.o(201405);
    }
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(201392);
      paramTransition.b(this);
      paramTransition = this.mView;
      if ((Build.VERSION.SDK_INT < 21) || (!f.cfu)) {}
      try
      {
        f.LP();
        Method localMethod = f.cfp.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f.cft = localMethod;
        localMethod.setAccessible(true);
        label60:
        f.cfu = true;
        if (f.cft != null) {}
        try
        {
          f.cft.invoke(null, new Object[] { paramTransition });
          label86:
          this.mView.setTag(m.a.transition_transform, null);
          this.mView.setTag(m.a.parent_matrix, null);
          AppMethodBeat.o(201392);
          return;
        }
        catch (InvocationTargetException paramTransition)
        {
          for (;;)
          {
            paramTransition = new RuntimeException(paramTransition.getCause());
            AppMethodBeat.o(201392);
            throw paramTransition;
            e.bW(paramTransition);
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
  }
  
  static final class b
  {
    final Matrix avQ;
    final float[] bGM;
    float ceS;
    float ceT;
    private final View mView;
    
    b(View paramView, float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(201379);
      this.avQ = new Matrix();
      this.mView = paramView;
      this.bGM = ((float[])paramArrayOfFloat.clone());
      this.ceS = this.bGM[2];
      this.ceT = this.bGM[5];
      LM();
      AppMethodBeat.o(201379);
    }
    
    final void LM()
    {
      AppMethodBeat.i(201386);
      this.bGM[2] = this.ceS;
      this.bGM[5] = this.ceT;
      this.avQ.setValues(this.bGM);
      ai.c(this.mView, this.avQ);
      AppMethodBeat.o(201386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.ChangeTransform
 * JD-Core Version:    0.7.0.1
 */