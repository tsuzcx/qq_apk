package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  private static final String[] apt = { "android:visibility:visibility", "android:visibility:parent" };
  private int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.arm);
    int i = g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private static void a(w paramw)
  {
    int i = paramw.view.getVisibility();
    paramw.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramw.values.put("android:visibility:parent", paramw.view.getParent());
    int[] arrayOfInt = new int[2];
    paramw.view.getLocationOnScreen(arrayOfInt);
    paramw.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  private static b b(w paramw1, w paramw2)
  {
    b localb = new b();
    localb.atx = false;
    localb.aty = false;
    if ((paramw1 != null) && (paramw1.values.containsKey("android:visibility:visibility")))
    {
      localb.atz = ((Integer)paramw1.values.get("android:visibility:visibility")).intValue();
      localb.aqA = ((ViewGroup)paramw1.values.get("android:visibility:parent"));
      if ((paramw2 == null) || (!paramw2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.atA = ((Integer)paramw2.values.get("android:visibility:visibility")).intValue();
      localb.atB = ((ViewGroup)paramw2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramw1 != null) && (paramw2 != null))
      {
        if ((localb.atz == localb.atA) && (localb.aqA == localb.atB))
        {
          return localb;
          localb.atz = -1;
          localb.aqA = null;
          break;
          label177:
          localb.atA = -1;
          localb.atB = null;
          continue;
        }
        if (localb.atz != localb.atA) {
          if (localb.atz == 0)
          {
            localb.aty = false;
            localb.atx = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.atA == 0)
      {
        localb.aty = true;
        localb.atx = true;
        continue;
        if (localb.atB == null)
        {
          localb.aty = false;
          localb.atx = true;
        }
        else if (localb.aqA == null)
        {
          localb.aty = true;
          localb.atx = true;
          continue;
          if ((paramw1 == null) && (localb.atA == 0))
          {
            localb.aty = true;
            localb.atx = true;
          }
          else if ((paramw2 == null) && (localb.atz == 0))
          {
            localb.aty = false;
            localb.atx = true;
          }
        }
      }
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, w paramw)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, w paramw1, w paramw2)
  {
    return null;
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, final w paramw2)
  {
    Object localObject1 = b(paramw1, paramw2);
    if ((((b)localObject1).atx) && ((((b)localObject1).aqA != null) || (((b)localObject1).atB != null)))
    {
      if (!((b)localObject1).aty) {
        break label106;
      }
      if (((this.mMode & 0x1) == 1) && (paramw2 != null)) {
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
        if (paramw1 != null) {
          break;
        }
        localObject1 = (View)paramw2.view.getParent();
      } while (b(i((View)localObject1, false), h((View)localObject1, false)).atx);
      return a(paramViewGroup, paramw2.view, paramw1, paramw2);
      i = ((b)localObject1).atA;
    } while ((this.mMode & 0x2) != 2);
    label133:
    label142:
    Object localObject2;
    if (paramw1 != null)
    {
      localObject1 = paramw1.view;
      if (paramw2 == null) {
        break label300;
      }
      paramw2 = paramw2.view;
      if ((paramw2 != null) && (paramw2.getParent() != null)) {
        break label428;
      }
      if (paramw2 == null) {
        break label305;
      }
      localObject2 = null;
      localObject1 = paramw2;
      paramw2 = localObject2;
    }
    for (;;)
    {
      label166:
      int j;
      if ((localObject1 != null) && (paramw1 != null))
      {
        paramw2 = (int[])paramw1.values.get("android:visibility:screenLocation");
        i = paramw2[0];
        j = paramw2[1];
        paramw2 = new int[2];
        paramViewGroup.getLocationOnScreen(paramw2);
        ((View)localObject1).offsetLeftAndRight(i - paramw2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(j - paramw2[1] - ((View)localObject1).getTop());
        if (Build.VERSION.SDK_INT >= 18)
        {
          paramw2 = new aa(paramViewGroup);
          label263:
          paramw2.bJ((View)localObject1);
          paramViewGroup = a(paramViewGroup, (View)localObject1, paramw1);
          if (paramViewGroup != null) {
            break label496;
          }
          paramw2.bK((View)localObject1);
          return paramViewGroup;
          localObject1 = null;
          break label133;
          label300:
          paramw2 = null;
          break label142;
          label305:
          if (localObject1 == null) {
            break label582;
          }
          if (((View)localObject1).getParent() == null)
          {
            paramw2 = null;
            continue;
          }
          if (!(((View)localObject1).getParent() instanceof View)) {
            break label582;
          }
          paramw2 = (View)((View)localObject1).getParent();
          if (!b(h(paramw2, true), i(paramw2, true)).atx)
          {
            localObject1 = v.a(paramViewGroup, (View)localObject1, paramw2);
            paramw2 = null;
            continue;
          }
          if (paramw2.getParent() != null) {
            break label577;
          }
          j = paramw2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.arR)) {
            break label577;
          }
        }
      }
      label428:
      label577:
      for (paramw2 = (w)localObject1;; paramw2 = null)
      {
        localObject2 = null;
        localObject1 = paramw2;
        paramw2 = localObject2;
        break label166;
        if (i == 4)
        {
          localObject1 = null;
          break label166;
        }
        if (localObject1 == paramw2)
        {
          localObject1 = null;
          break label166;
        }
        if (this.arR)
        {
          paramw2 = null;
          break label166;
        }
        localObject1 = v.a(paramViewGroup, (View)localObject1, (View)((View)localObject1).getParent());
        paramw2 = null;
        break label166;
        paramw2 = (z)af.bL(paramViewGroup);
        break label263;
        label496:
        paramViewGroup.addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(193334);
            paramw2.bK(this.att);
            AppMethodBeat.o(193334);
          }
        });
        return paramViewGroup;
        if (paramw2 == null) {
          break;
        }
        j = paramw2.getVisibility();
        ai.G(paramw2, 0);
        paramViewGroup = a(paramViewGroup, paramw2, paramw1);
        if (paramViewGroup != null)
        {
          paramw1 = new a(paramw2, i);
          paramViewGroup.addListener(paramw1);
          a.a(paramViewGroup, paramw1);
          a(paramw1);
          return paramViewGroup;
        }
        ai.G(paramw2, j);
        return paramViewGroup;
      }
      label582:
      paramw2 = null;
      localObject1 = null;
    }
  }
  
  public final boolean a(w paramw1, w paramw2)
  {
    if ((paramw1 == null) && (paramw2 == null)) {}
    do
    {
      do
      {
        return false;
      } while ((paramw1 != null) && (paramw2 != null) && (paramw2.values.containsKey("android:visibility:visibility") != paramw1.values.containsKey("android:visibility:visibility")));
      paramw1 = b(paramw1, paramw2);
    } while ((!paramw1.atx) || ((paramw1.atz != 0) && (paramw1.atA != 0)));
    return true;
  }
  
  public void b(w paramw)
  {
    a(paramw);
  }
  
  public void c(w paramw)
  {
    a(paramw);
  }
  
  public final int getMode()
  {
    return this.mMode;
  }
  
  public final String[] nf()
  {
    return apt;
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
    private final ViewGroup VV;
    private final boolean atv;
    private boolean atw;
    boolean mCanceled;
    private final View mView;
    private final int nL;
    
    a(View paramView, int paramInt)
    {
      AppMethodBeat.i(193340);
      this.mCanceled = false;
      this.mView = paramView;
      this.nL = paramInt;
      this.VV = ((ViewGroup)paramView.getParent());
      this.atv = true;
      aE(true);
      AppMethodBeat.o(193340);
    }
    
    private void aE(boolean paramBoolean)
    {
      AppMethodBeat.i(193368);
      if ((this.atv) && (this.atw != paramBoolean) && (this.VV != null))
      {
        this.atw = paramBoolean;
        ac.c(this.VV, paramBoolean);
      }
      AppMethodBeat.o(193368);
    }
    
    private void nA()
    {
      AppMethodBeat.i(193365);
      if (!this.mCanceled)
      {
        ai.G(this.mView, this.nL);
        if (this.VV != null) {
          this.VV.invalidate();
        }
      }
      aE(false);
      AppMethodBeat.o(193365);
    }
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(193354);
      nA();
      paramTransition.b(this);
      AppMethodBeat.o(193354);
    }
    
    public final void ng()
    {
      AppMethodBeat.i(193356);
      aE(false);
      AppMethodBeat.o(193356);
    }
    
    public final void nh()
    {
      AppMethodBeat.i(193359);
      aE(true);
      AppMethodBeat.o(193359);
    }
    
    public final void nl() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(193351);
      nA();
      AppMethodBeat.o(193351);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(193342);
      if (!this.mCanceled) {
        ai.G(this.mView, this.nL);
      }
      AppMethodBeat.o(193342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(193345);
      if (!this.mCanceled) {
        ai.G(this.mView, 0);
      }
      AppMethodBeat.o(193345);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  static final class b
  {
    ViewGroup aqA;
    int atA;
    ViewGroup atB;
    boolean atx;
    boolean aty;
    int atz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */