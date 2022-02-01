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
  private static final String[] cec = { "android:visibility:visibility", "android:visibility:parent" };
  private int mMode = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfV);
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
    localb.cig = false;
    localb.cih = false;
    if ((paramw1 != null) && (paramw1.values.containsKey("android:visibility:visibility")))
    {
      localb.cii = ((Integer)paramw1.values.get("android:visibility:visibility")).intValue();
      localb.cfj = ((ViewGroup)paramw1.values.get("android:visibility:parent"));
      if ((paramw2 == null) || (!paramw2.values.containsKey("android:visibility:visibility"))) {
        break label177;
      }
      localb.cij = ((Integer)paramw2.values.get("android:visibility:visibility")).intValue();
      localb.cik = ((ViewGroup)paramw2.values.get("android:visibility:parent"));
    }
    for (;;)
    {
      if ((paramw1 != null) && (paramw2 != null))
      {
        if ((localb.cii == localb.cij) && (localb.cfj == localb.cik))
        {
          return localb;
          localb.cii = -1;
          localb.cfj = null;
          break;
          label177:
          localb.cij = -1;
          localb.cik = null;
          continue;
        }
        if (localb.cii != localb.cij) {
          if (localb.cii == 0)
          {
            localb.cih = false;
            localb.cig = true;
          }
        }
      }
    }
    for (;;)
    {
      return localb;
      if (localb.cij == 0)
      {
        localb.cih = true;
        localb.cig = true;
        continue;
        if (localb.cik == null)
        {
          localb.cih = false;
          localb.cig = true;
        }
        else if (localb.cfj == null)
        {
          localb.cih = true;
          localb.cig = true;
          continue;
          if ((paramw1 == null) && (localb.cij == 0))
          {
            localb.cih = true;
            localb.cig = true;
          }
          else if ((paramw2 == null) && (localb.cii == 0))
          {
            localb.cih = false;
            localb.cig = true;
          }
        }
      }
    }
  }
  
  public final String[] LI()
  {
    return cec;
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
    if ((((b)localObject1).cig) && ((((b)localObject1).cfj != null) || (((b)localObject1).cik != null)))
    {
      if (!((b)localObject1).cih) {
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
      } while (b(i((View)localObject1, false), h((View)localObject1, false)).cig);
      return a(paramViewGroup, paramw2.view, paramw1, paramw2);
      i = ((b)localObject1).cij;
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
          paramw2.cd((View)localObject1);
          paramViewGroup = a(paramViewGroup, (View)localObject1, paramw1);
          if (paramViewGroup != null) {
            break label496;
          }
          paramw2.ce((View)localObject1);
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
          if (!b(h(paramw2, true), i(paramw2, true)).cig)
          {
            localObject1 = v.a(paramViewGroup, (View)localObject1, paramw2);
            paramw2 = null;
            continue;
          }
          if (paramw2.getParent() != null) {
            break label577;
          }
          j = paramw2.getId();
          if ((j == -1) || (paramViewGroup.findViewById(j) == null) || (!this.cgA)) {
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
        if (this.cgA)
        {
          paramw2 = null;
          break label166;
        }
        localObject1 = v.a(paramViewGroup, (View)localObject1, (View)((View)localObject1).getParent());
        paramw2 = null;
        break label166;
        paramw2 = (z)af.cf(paramViewGroup);
        break label263;
        label496:
        paramViewGroup.addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(201475);
            paramw2.ce(this.cic);
            AppMethodBeat.o(201475);
          }
        });
        return paramViewGroup;
        if (paramw2 == null) {
          break;
        }
        j = paramw2.getVisibility();
        ai.K(paramw2, 0);
        paramViewGroup = a(paramViewGroup, paramw2, paramw1);
        if (paramViewGroup != null)
        {
          paramw1 = new a(paramw2, i);
          paramViewGroup.addListener(paramw1);
          a.a(paramViewGroup, paramw1);
          a(paramw1);
          return paramViewGroup;
        }
        ai.K(paramw2, j);
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
    } while ((!paramw1.cig) || ((paramw1.cii != 0) && (paramw1.cij != 0)));
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
    private final ViewGroup bCB;
    private final boolean cie;
    private boolean cif;
    boolean mCanceled;
    private final View mView;
    private final int oK;
    
    a(View paramView, int paramInt)
    {
      AppMethodBeat.i(201395);
      this.mCanceled = false;
      this.mView = paramView;
      this.oK = paramInt;
      this.bCB = ((ViewGroup)paramView.getParent());
      this.cie = true;
      bm(true);
      AppMethodBeat.o(201395);
    }
    
    private void Md()
    {
      AppMethodBeat.i(201406);
      if (!this.mCanceled)
      {
        ai.K(this.mView, this.oK);
        if (this.bCB != null) {
          this.bCB.invalidate();
        }
      }
      bm(false);
      AppMethodBeat.o(201406);
    }
    
    private void bm(boolean paramBoolean)
    {
      AppMethodBeat.i(201413);
      if ((this.cie) && (this.cif != paramBoolean) && (this.bCB != null))
      {
        this.cif = paramBoolean;
        ac.c(this.bCB, paramBoolean);
      }
      AppMethodBeat.o(201413);
    }
    
    public final void LJ()
    {
      AppMethodBeat.i(201508);
      bm(false);
      AppMethodBeat.o(201508);
    }
    
    public final void LK()
    {
      AppMethodBeat.i(201520);
      bm(true);
      AppMethodBeat.o(201520);
    }
    
    public final void LO() {}
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(201495);
      Md();
      paramTransition.b(this);
      AppMethodBeat.o(201495);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(201474);
      Md();
      AppMethodBeat.o(201474);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(201423);
      if (!this.mCanceled) {
        ai.K(this.mView, this.oK);
      }
      AppMethodBeat.o(201423);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(201434);
      if (!this.mCanceled) {
        ai.K(this.mView, 0);
      }
      AppMethodBeat.o(201434);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  static final class b
  {
    ViewGroup cfj;
    boolean cig;
    boolean cih;
    int cii;
    int cij;
    ViewGroup cik;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */