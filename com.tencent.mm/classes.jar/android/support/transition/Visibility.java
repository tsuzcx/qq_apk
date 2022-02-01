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
  private static final String[] xP = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.zW);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static b b(u paramu1, u paramu2)
  {
    b localb = new b();
    localb.Cg = false;
    localb.Ch = false;
    if ((paramu1 != null) && (paramu1.values.containsKey("android:visibility:visibility")))
    {
      localb.Ci = ((Integer)paramu1.values.get("android:visibility:visibility")).intValue();
      localb.zg = ((ViewGroup)paramu1.values.get("android:visibility:parent"));
      if ((paramu2 == null) || (!paramu2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.Cj = ((Integer)paramu2.values.get("android:visibility:visibility")).intValue();
      localb.Ck = ((ViewGroup)paramu2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramu1 != null) && (paramu2 != null))
      {
        if ((localb.Ci == localb.Cj) && (localb.zg == localb.Ck))
        {
          return localb;
          localb.Ci = -1;
          localb.zg = null;
          break;
          label177:
          localb.Cj = -1;
          localb.Ck = null;
          continue;
        }
        if (localb.Ci != localb.Cj) {
          if (localb.Ci == 0)
          {
            localb.Ch = false;
            localb.Cg = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.Cj == 0)
      {
        localb.Ch = true;
        localb.Cg = true;
        continue;
        if (localb.Ck == null)
        {
          localb.Ch = false;
          localb.Cg = true;
        }
        else if (localb.zg == null)
        {
          localb.Ch = true;
          localb.Cg = true;
          continue;
          if ((paramu1 == null) && (localb.Cj == 0))
          {
            localb.Ch = true;
            localb.Cg = true;
          }
          else if ((paramu2 == null) && (localb.Ci == 0))
          {
            localb.Ch = false;
            localb.Cg = true;
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
    if ((((b)localObject1).Cg) && ((((b)localObject1).zg != null) || (((b)localObject1).Ck != null)))
    {
      if (!((b)localObject1).Ch) {
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
      } while (b(c((View)localObject1, false), b((View)localObject1, false)).Cg);
      return a(paramViewGroup, paramu2.view, paramu1, paramu2);
      i = ((b)localObject1).Cj;
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
          if (!b(b(paramu2, true), c(paramu2, true)).Cg)
          {
            localObject1 = t.a(paramViewGroup, (View)localObject1, paramu2);
            paramu2 = null;
            continue;
          }
          if (paramu2.getParent() != null) {
            break label577;
          }
          j = paramu2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.Az)) {
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
        if (this.Az)
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
            paramu2.remove(this.Ca);
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
    } while ((!paramu1.Cg) || ((paramu1.Ci != 0) && (paramu1.Cj != 0)));
    return true;
  }
  
  public void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return xP;
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
    private final int Cc;
    private final ViewGroup Cd;
    private final boolean Ce;
    private boolean Cf;
    boolean mCanceled = false;
    private final View mView;
    
    a(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.Cc = paramInt;
      this.Cd = ((ViewGroup)paramView.getParent());
      this.Ce = true;
      C(true);
    }
    
    private void C(boolean paramBoolean)
    {
      if ((this.Ce) && (this.Cf != paramBoolean) && (this.Cd != null))
      {
        this.Cf = paramBoolean;
        aa.c(this.Cd, paramBoolean);
      }
    }
    
    private void dB()
    {
      if (!this.mCanceled)
      {
        ag.m(this.mView, this.Cc);
        if (this.Cd != null) {
          this.Cd.invalidate();
        }
      }
      C(false);
    }
    
    public final void a(Transition paramTransition)
    {
      dB();
      paramTransition.b(this);
    }
    
    public final void dn()
    {
      C(false);
    }
    
    public final void jdMethod_do()
    {
      C(true);
    }
    
    public final void ds() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      dB();
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ag.m(this.mView, this.Cc);
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
    boolean Cg;
    boolean Ch;
    int Ci;
    int Cj;
    ViewGroup Ck;
    ViewGroup zg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */