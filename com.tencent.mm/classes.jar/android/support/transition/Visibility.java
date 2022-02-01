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
  private static final String[] wR = { "android:visibility:visibility", "android:visibility:parent" };
  int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.yW);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static b b(u paramu1, u paramu2)
  {
    b localb = new b();
    localb.Bi = false;
    localb.Bj = false;
    if ((paramu1 != null) && (paramu1.values.containsKey("android:visibility:visibility")))
    {
      localb.Bk = ((Integer)paramu1.values.get("android:visibility:visibility")).intValue();
      localb.yi = ((ViewGroup)paramu1.values.get("android:visibility:parent"));
      if ((paramu2 == null) || (!paramu2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.Bl = ((Integer)paramu2.values.get("android:visibility:visibility")).intValue();
      localb.Bm = ((ViewGroup)paramu2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramu1 != null) && (paramu2 != null))
      {
        if ((localb.Bk == localb.Bl) && (localb.yi == localb.Bm))
        {
          return localb;
          localb.Bk = -1;
          localb.yi = null;
          break;
          label177:
          localb.Bl = -1;
          localb.Bm = null;
          continue;
        }
        if (localb.Bk != localb.Bl) {
          if (localb.Bk == 0)
          {
            localb.Bj = false;
            localb.Bi = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.Bl == 0)
      {
        localb.Bj = true;
        localb.Bi = true;
        continue;
        if (localb.Bm == null)
        {
          localb.Bj = false;
          localb.Bi = true;
        }
        else if (localb.yi == null)
        {
          localb.Bj = true;
          localb.Bi = true;
          continue;
          if ((paramu1 == null) && (localb.Bl == 0))
          {
            localb.Bj = true;
            localb.Bi = true;
          }
          else if ((paramu2 == null) && (localb.Bk == 0))
          {
            localb.Bj = false;
            localb.Bi = true;
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
    if ((((b)localObject1).Bi) && ((((b)localObject1).yi != null) || (((b)localObject1).Bm != null)))
    {
      if (!((b)localObject1).Bj) {
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
      } while (b(c((View)localObject1, false), b((View)localObject1, false)).Bi);
      return a(paramViewGroup, paramu2.view, paramu1, paramu2);
      i = ((b)localObject1).Bl;
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
          if (!b(b(paramu2, true), c(paramu2, true)).Bi)
          {
            localObject1 = t.a(paramViewGroup, (View)localObject1, paramu2);
            paramu2 = null;
            continue;
          }
          if (paramu2.getParent() != null) {
            break label577;
          }
          j = paramu2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.zB)) {
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
        if (this.zB)
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
            paramu2.remove(this.Bc);
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
    } while ((!paramu1.Bi) || ((paramu1.Bk != 0) && (paramu1.Bl != 0)));
    return true;
  }
  
  public void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return wR;
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
    private final int Be;
    private final ViewGroup Bf;
    private final boolean Bg;
    private boolean Bh;
    boolean mCanceled = false;
    private final View mView;
    
    a(View paramView, int paramInt)
    {
      this.mView = paramView;
      this.Be = paramInt;
      this.Bf = ((ViewGroup)paramView.getParent());
      this.Bg = true;
      C(true);
    }
    
    private void C(boolean paramBoolean)
    {
      if ((this.Bg) && (this.Bh != paramBoolean) && (this.Bf != null))
      {
        this.Bh = paramBoolean;
        aa.c(this.Bf, paramBoolean);
      }
    }
    
    private void du()
    {
      if (!this.mCanceled)
      {
        ag.m(this.mView, this.Be);
        if (this.Bf != null) {
          this.Bf.invalidate();
        }
      }
      C(false);
    }
    
    public final void a(Transition paramTransition)
    {
      du();
      paramTransition.b(this);
    }
    
    public final void dg()
    {
      C(false);
    }
    
    public final void dh()
    {
      C(true);
    }
    
    public final void dl() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      du();
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      if (!this.mCanceled) {
        ag.m(this.mView, this.Be);
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
    boolean Bi;
    boolean Bj;
    int Bk;
    int Bl;
    ViewGroup Bm;
    ViewGroup yi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */