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
  private static final String[] zJ = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BN);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static b b(u paramu1, u paramu2)
  {
    b localb = new b();
    localb.DY = false;
    localb.DZ = false;
    if ((paramu1 != null) && (paramu1.values.containsKey("android:visibility:visibility")))
    {
      localb.Ea = ((Integer)paramu1.values.get("android:visibility:visibility")).intValue();
      localb.AZ = ((ViewGroup)paramu1.values.get("android:visibility:parent"));
      if ((paramu2 == null) || (!paramu2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.Eb = ((Integer)paramu2.values.get("android:visibility:visibility")).intValue();
      localb.Ec = ((ViewGroup)paramu2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramu1 != null) && (paramu2 != null))
      {
        if ((localb.Ea == localb.Eb) && (localb.AZ == localb.Ec))
        {
          return localb;
          localb.Ea = -1;
          localb.AZ = null;
          break;
          label177:
          localb.Eb = -1;
          localb.Ec = null;
          continue;
        }
        if (localb.Ea != localb.Eb) {
          if (localb.Ea == 0)
          {
            localb.DZ = false;
            localb.DY = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.Eb == 0)
      {
        localb.DZ = true;
        localb.DY = true;
        continue;
        if (localb.Ec == null)
        {
          localb.DZ = false;
          localb.DY = true;
        }
        else if (localb.AZ == null)
        {
          localb.DZ = true;
          localb.DY = true;
          continue;
          if ((paramu1 == null) && (localb.Eb == 0))
          {
            localb.DZ = true;
            localb.DY = true;
          }
          else if ((paramu2 == null) && (localb.Ea == 0))
          {
            localb.DZ = false;
            localb.DY = true;
          }
        }
      }
    }
  }
  
  private static void c(u paramu)
  {
    int i = paramu.view.getVisibility();
    paramu.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramu.values.put("android:visibility:parent", paramu.view.getParent());
    int[] arrayOfInt = new int[2];
    paramu.view.getLocationOnScreen(arrayOfInt);
    paramu.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public final Animator a(ViewGroup paramViewGroup, u paramu1, final u paramu2)
  {
    Object localObject1 = b(paramu1, paramu2);
    if ((((b)localObject1).DY) && ((((b)localObject1).AZ != null) || (((b)localObject1).Ec != null)))
    {
      if (!((b)localObject1).DZ) {
        break label106;
      }
      if (((this.mMode & 0x1) == 1) && (paramu2 != null)) {
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
        if (paramu1 != null) {
          break;
        }
        localObject1 = (View)paramu2.view.getParent();
      } while (b(c((View)localObject1, false), b((View)localObject1, false)).DY);
      return a(paramViewGroup, paramu2.view, paramu1, paramu2);
      i = ((b)localObject1).Eb;
    } while ((this.mMode & 0x2) != 2);
    label133:
    label142:
    Object localObject2;
    if (paramu1 != null)
    {
      localObject1 = paramu1.view;
      if (paramu2 == null) {
        break label300;
      }
      paramu2 = paramu2.view;
      if ((paramu2 != null) && (paramu2.getParent() != null)) {
        break label428;
      }
      if (paramu2 == null) {
        break label305;
      }
      localObject2 = null;
      localObject1 = paramu2;
      paramu2 = localObject2;
    }
    for (;;)
    {
      label166:
      int j;
      if ((localObject1 != null) && (paramu1 != null))
      {
        paramu2 = (int[])paramu1.values.get("android:visibility:screenLocation");
        i = paramu2[0];
        j = paramu2[1];
        paramu2 = new int[2];
        paramViewGroup.getLocationOnScreen(paramu2);
        ((View)localObject1).offsetLeftAndRight(i - paramu2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(j - paramu2[1] - ((View)localObject1).getTop());
        if (Build.VERSION.SDK_INT >= 18)
        {
          paramu2 = new y(paramViewGroup);
          label263:
          paramu2.add((View)localObject1);
          paramViewGroup = a(paramViewGroup, (View)localObject1, paramu1);
          if (paramViewGroup != null) {
            break label496;
          }
          paramu2.remove((View)localObject1);
          return paramViewGroup;
          localObject1 = null;
          break label133;
          label300:
          paramu2 = null;
          break label142;
          label305:
          if (localObject1 == null) {
            break label582;
          }
          if (((View)localObject1).getParent() == null)
          {
            paramu2 = null;
            continue;
          }
          if (!(((View)localObject1).getParent() instanceof View)) {
            break label582;
          }
          paramu2 = (View)((View)localObject1).getParent();
          if (!b(b(paramu2, true), c(paramu2, true)).DY)
          {
            localObject1 = t.a(paramViewGroup, (View)localObject1, paramu2);
            paramu2 = null;
            continue;
          }
          if (paramu2.getParent() != null) {
            break label577;
          }
          j = paramu2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.Cq)) {
            break label577;
          }
        }
      }
      label428:
      label577:
      for (paramu2 = (u)localObject1;; paramu2 = null)
      {
        localObject2 = null;
        localObject1 = paramu2;
        paramu2 = localObject2;
        break label166;
        if (i == 4)
        {
          localObject1 = null;
          break label166;
        }
        if (localObject1 == paramu2)
        {
          localObject1 = null;
          break label166;
        }
        if (this.Cq)
        {
          paramu2 = null;
          break label166;
        }
        localObject1 = t.a(paramViewGroup, (View)localObject1, (View)((View)localObject1).getParent());
        paramu2 = null;
        break label166;
        paramu2 = (x)ad.L(paramViewGroup);
        break label263;
        label496:
        paramViewGroup.addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramu2.remove(this.DS);
          }
        });
        return paramViewGroup;
        if (paramu2 == null) {
          break;
        }
        j = paramu2.getVisibility();
        ag.m(paramu2, 0);
        paramViewGroup = a(paramViewGroup, paramu2, paramu1);
        if (paramViewGroup != null)
        {
          paramu1 = new a(paramu2, i);
          paramViewGroup.addListener(paramu1);
          a.a(paramViewGroup, paramu1);
          a(paramu1);
          return paramViewGroup;
        }
        ag.m(paramu2, j);
        return paramViewGroup;
      }
      label582:
      paramu2 = null;
      localObject1 = null;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, u paramu)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, u paramu1, u paramu2)
  {
    return null;
  }
  
  public void a(u paramu)
  {
    c(paramu);
  }
  
  public final boolean a(u paramu1, u paramu2)
  {
    if ((paramu1 == null) && (paramu2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramu1 != null) && (paramu2 != null) && (paramu2.values.containsKey("android:visibility:visibility") != paramu1.values.containsKey("android:visibility:visibility")));
      paramu1 = b(paramu1, paramu2);
    } while ((!paramu1.DY) || ((paramu1.Ea != 0) && (paramu1.Eb != 0)));
    return true;
  }
  
  public void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return zJ;
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
    implements Transition.c, a.a
  {
    private final int DU;
    private final ViewGroup DV;
    private final boolean DW;
    private boolean DX;
    boolean mCanceled = false;
    private final View mView;
    
    a(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.DU = paramInt;
      this.DV = ((ViewGroup)paramView.getParent());
      this.DW = true;
      C(true);
    }
    
    private void C(boolean paramBoolean)
    {
      if ((this.DW) && (this.DX != paramBoolean) && (this.DV != null))
      {
        this.DX = paramBoolean;
        aa.c(this.DV, paramBoolean);
      }
    }
    
    private void dQ()
    {
      if (!this.mCanceled)
      {
        ag.m(this.mView, this.DU);
        if (this.DV != null) {
          this.DV.invalidate();
        }
      }
      C(false);
    }
    
    public final void a(Transition paramTransition)
    {
      dQ();
      paramTransition.b(this);
    }
    
    public final void dC()
    {
      C(false);
    }
    
    public final void dD()
    {
      C(true);
    }
    
    public final void dH() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      dQ();
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ag.m(this.mView, this.DU);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ag.m(this.mView, 0);
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  static final class b
  {
    ViewGroup AZ;
    boolean DY;
    boolean DZ;
    int Ea;
    int Eb;
    ViewGroup Ec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */