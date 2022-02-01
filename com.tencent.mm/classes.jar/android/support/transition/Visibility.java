package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  private static final String[] zP = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BU);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static b b(v paramv1, v paramv2)
  {
    b localb = new b();
    localb.Eh = false;
    localb.Ei = false;
    if ((paramv1 != null) && (paramv1.values.containsKey("android:visibility:visibility")))
    {
      localb.Ej = ((Integer)paramv1.values.get("android:visibility:visibility")).intValue();
      localb.Bf = ((ViewGroup)paramv1.values.get("android:visibility:parent"));
      if ((paramv2 == null) || (!paramv2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.Ek = ((Integer)paramv2.values.get("android:visibility:visibility")).intValue();
      localb.El = ((ViewGroup)paramv2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramv1 != null) && (paramv2 != null))
      {
        if ((localb.Ej == localb.Ek) && (localb.Bf == localb.El))
        {
          return localb;
          localb.Ej = -1;
          localb.Bf = null;
          break;
          label177:
          localb.Ek = -1;
          localb.El = null;
          continue;
        }
        if (localb.Ej != localb.Ek) {
          if (localb.Ej == 0)
          {
            localb.Ei = false;
            localb.Eh = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.Ek == 0)
      {
        localb.Ei = true;
        localb.Eh = true;
        continue;
        if (localb.El == null)
        {
          localb.Ei = false;
          localb.Eh = true;
        }
        else if (localb.Bf == null)
        {
          localb.Ei = true;
          localb.Eh = true;
          continue;
          if ((paramv1 == null) && (localb.Ek == 0))
          {
            localb.Ei = true;
            localb.Eh = true;
          }
          else if ((paramv2 == null) && (localb.Ej == 0))
          {
            localb.Ei = false;
            localb.Eh = true;
          }
        }
      }
    }
  }
  
  private static void c(v paramv)
  {
    int i = paramv.view.getVisibility();
    paramv.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramv.values.put("android:visibility:parent", paramv.view.getParent());
    int[] arrayOfInt = new int[2];
    paramv.view.getLocationOnScreen(arrayOfInt);
    paramv.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public final Animator a(ViewGroup paramViewGroup, v paramv1, final v paramv2)
  {
    Object localObject1 = b(paramv1, paramv2);
    if ((((b)localObject1).Eh) && ((((b)localObject1).Bf != null) || (((b)localObject1).El != null)))
    {
      if (!((b)localObject1).Ei) {
        break label106;
      }
      if (((this.mMode & 0x1) == 1) && (paramv2 != null)) {
        break label55;
      }
    }
    label55:
    label106:
    int i;
    do
    {
      do
      {
        return null;
        if (paramv1 != null) {
          break;
        }
        localObject1 = (View)paramv2.view.getParent();
      } while (b(c((View)localObject1, false), b((View)localObject1, false)).Eh);
      return a(paramViewGroup, paramv2.view, paramv1, paramv2);
      i = ((b)localObject1).Ek;
    } while ((this.mMode & 0x2) != 2);
    label133:
    label142:
    Object localObject2;
    if (paramv1 != null)
    {
      localObject1 = paramv1.view;
      if (paramv2 == null) {
        break label300;
      }
      paramv2 = paramv2.view;
      if ((paramv2 != null) && (paramv2.getParent() != null)) {
        break label428;
      }
      if (paramv2 == null) {
        break label305;
      }
      localObject2 = null;
      localObject1 = paramv2;
      paramv2 = localObject2;
    }
    for (;;)
    {
      label166:
      int j;
      if ((localObject1 != null) && (paramv1 != null))
      {
        paramv2 = (int[])paramv1.values.get("android:visibility:screenLocation");
        i = paramv2[0];
        j = paramv2[1];
        paramv2 = new int[2];
        paramViewGroup.getLocationOnScreen(paramv2);
        ((View)localObject1).offsetLeftAndRight(i - paramv2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(j - paramv2[1] - ((View)localObject1).getTop());
        if (Build.VERSION.SDK_INT >= 18)
        {
          paramv2 = new z(paramViewGroup);
          label263:
          paramv2.add((View)localObject1);
          paramViewGroup = a(paramViewGroup, (View)localObject1, paramv1);
          if (paramViewGroup != null) {
            break label496;
          }
          paramv2.remove((View)localObject1);
          return paramViewGroup;
          localObject1 = null;
          break label133;
          label300:
          paramv2 = null;
          break label142;
          label305:
          if (localObject1 == null) {
            break label582;
          }
          if (((View)localObject1).getParent() == null)
          {
            paramv2 = null;
            continue;
          }
          if (!(((View)localObject1).getParent() instanceof View)) {
            break label582;
          }
          paramv2 = (View)((View)localObject1).getParent();
          if (!b(b(paramv2, true), c(paramv2, true)).Eh)
          {
            localObject1 = u.a(paramViewGroup, (View)localObject1, paramv2);
            paramv2 = null;
            continue;
          }
          if (paramv2.getParent() != null) {
            break label577;
          }
          j = paramv2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.Cx)) {
            break label577;
          }
        }
      }
      label428:
      label577:
      for (paramv2 = (v)localObject1;; paramv2 = null)
      {
        localObject2 = null;
        localObject1 = paramv2;
        paramv2 = localObject2;
        break label166;
        if (i == 4)
        {
          localObject1 = null;
          break label166;
        }
        if (localObject1 == paramv2)
        {
          localObject1 = null;
          break label166;
        }
        if (this.Cx)
        {
          paramv2 = null;
          break label166;
        }
        localObject1 = u.a(paramViewGroup, (View)localObject1, (View)((View)localObject1).getParent());
        paramv2 = null;
        break label166;
        paramv2 = (y)ae.M(paramViewGroup);
        break label263;
        label496:
        paramViewGroup.addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramv2.remove(this.Eb);
          }
        });
        return paramViewGroup;
        if (paramv2 == null) {
          break;
        }
        j = paramv2.getVisibility();
        ah.m(paramv2, 0);
        paramViewGroup = a(paramViewGroup, paramv2, paramv1);
        if (paramViewGroup != null)
        {
          paramv1 = new a(paramv2, i);
          paramViewGroup.addListener(paramv1);
          a.a(paramViewGroup, paramv1);
          a(paramv1);
          return paramViewGroup;
        }
        ah.m(paramv2, j);
        return paramViewGroup;
      }
      label582:
      paramv2 = null;
      localObject1 = null;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, v paramv)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, v paramv1, v paramv2)
  {
    return null;
  }
  
  public void a(v paramv)
  {
    c(paramv);
  }
  
  public final boolean a(v paramv1, v paramv2)
  {
    if ((paramv1 == null) && (paramv2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramv1 != null) && (paramv2 != null) && (paramv2.values.containsKey("android:visibility:visibility") != paramv1.values.containsKey("android:visibility:visibility")));
      paramv1 = b(paramv1, paramv2);
    } while ((!paramv1.Eh) || ((paramv1.Ej != 0) && (paramv1.Ek != 0)));
    return true;
  }
  
  public void b(v paramv)
  {
    c(paramv);
  }
  
  public final String[] getTransitionProperties()
  {
    return zP;
  }
  
  public final void setMode(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) != 0) {
      throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
    this.mMode = paramInt;
  }
  
  static final class a
    extends AnimatorListenerAdapter
    implements Transition.d, a.a
  {
    private final int Ed;
    private final ViewGroup Ee;
    private final boolean Ef;
    private boolean Eg;
    boolean mCanceled = false;
    private final View mView;
    
    a(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.Ed = paramInt;
      this.Ee = ((ViewGroup)paramView.getParent());
      this.Ef = true;
      suppressLayout(true);
    }
    
    private void dU()
    {
      if (!this.mCanceled)
      {
        ah.m(this.mView, this.Ed);
        if (this.Ee != null) {
          this.Ee.invalidate();
        }
      }
      suppressLayout(false);
    }
    
    private void suppressLayout(boolean paramBoolean)
    {
      if ((this.Ef) && (this.Eg != paramBoolean) && (this.Ee != null))
      {
        this.Eg = paramBoolean;
        ab.c(this.Ee, paramBoolean);
      }
    }
    
    public final void a(Transition paramTransition)
    {
      dU();
      paramTransition.b(this);
    }
    
    public final void dF()
    {
      suppressLayout(false);
    }
    
    public final void dG()
    {
      suppressLayout(true);
    }
    
    public final void dK() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      dU();
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ah.m(this.mView, this.Ed);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ah.m(this.mView, 0);
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  static final class b
  {
    ViewGroup Bf;
    boolean Eh;
    boolean Ei;
    int Ej;
    int Ek;
    ViewGroup El;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */