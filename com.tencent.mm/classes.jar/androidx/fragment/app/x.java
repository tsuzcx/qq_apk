package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.c.b;
import androidx.core.c.b.a;
import androidx.core.g.z;
import androidx.fragment.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class x
{
  final ArrayList<b> bEE = new ArrayList();
  final ArrayList<b> bEF = new ArrayList();
  boolean bEG = false;
  boolean bEH = false;
  private final ViewGroup mContainer;
  
  x(ViewGroup paramViewGroup)
  {
    this.mContainer = paramViewGroup;
  }
  
  private void GJ()
  {
    Iterator localIterator = this.bEE.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.bEN == x.b.a.bET) {
        localb.a(x.b.b.eU(localb.bDv.requireView().getVisibility()), x.b.a.bES);
      }
    }
  }
  
  static x a(ViewGroup paramViewGroup, FragmentManager paramFragmentManager)
  {
    return a(paramViewGroup, paramFragmentManager.getSpecialEffectsControllerFactory());
  }
  
  static x a(ViewGroup paramViewGroup, y paramy)
  {
    Object localObject = paramViewGroup.getTag(a.b.special_effects_controller_view_tag);
    if ((localObject instanceof x)) {
      return (x)localObject;
    }
    paramy = paramy.e(paramViewGroup);
    paramViewGroup.setTag(a.b.special_effects_controller_view_tag, paramy);
    return paramy;
  }
  
  private void a(final x.b.b paramb, x.b.a parama, o paramo)
  {
    synchronized (this.bEE)
    {
      b localb = new b();
      b localb1 = s(paramo.bDv);
      if (localb1 != null)
      {
        localb1.a(paramb, parama);
        return;
      }
      paramb = new a(paramb, parama, paramo, localb);
      this.bEE.add(paramb);
      paramb.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193649);
          if (x.this.bEE.contains(paramb)) {
            paramb.bEM.bc(paramb.bDv.mView);
          }
          AppMethodBeat.o(193649);
        }
      });
      paramb.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193655);
          x.this.bEE.remove(paramb);
          x.this.bEF.remove(paramb);
          AppMethodBeat.o(193655);
        }
      });
      return;
    }
  }
  
  private b s(Fragment paramFragment)
  {
    Iterator localIterator = this.bEE.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.bDv.equals(paramFragment)) && (!localb.mIsCanceled)) {
        return localb;
      }
    }
    return null;
  }
  
  private b t(Fragment paramFragment)
  {
    Iterator localIterator = this.bEF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.bDv.equals(paramFragment)) && (!localb.mIsCanceled)) {
        return localb;
      }
    }
    return null;
  }
  
  final void GG()
  {
    synchronized (this.bEE)
    {
      GJ();
      this.bEH = false;
      int i = this.bEE.size() - 1;
      if (i >= 0)
      {
        b localb = (b)this.bEE.get(i);
        x.b.b localb1 = x.b.b.bb(localb.bDv.mView);
        if ((localb.bEM == x.b.b.bEX) && (localb1 != x.b.b.bEX)) {
          this.bEH = localb.bDv.isPostponed();
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  final void GH()
  {
    if (this.bEH) {
      return;
    }
    if (!z.ay(this.mContainer))
    {
      GI();
      this.bEG = false;
      return;
    }
    synchronized (this.bEE)
    {
      if (this.bEE.isEmpty()) {
        break label212;
      }
      Object localObject1 = new ArrayList(this.bEF);
      this.bEF.clear();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (b)((Iterator)localObject1).next();
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("SpecialEffectsController: Cancelling operation ").append(localObject3);
        }
        ((b)localObject3).cancel();
        if (!((b)localObject3).bEQ) {
          this.bEF.add(localObject3);
        }
      }
    }
    GJ();
    ArrayList localArrayList2 = new ArrayList(this.bEE);
    this.bEE.clear();
    this.bEF.addAll(localArrayList2);
    Object localObject3 = localArrayList2.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((b)((Iterator)localObject3).next()).onStart();
    }
    c(localArrayList2, this.bEG);
    this.bEG = false;
    label212:
  }
  
  final void GI()
  {
    boolean bool = z.ay(this.mContainer);
    synchronized (this.bEE)
    {
      GJ();
      Iterator localIterator1 = this.bEE.iterator();
      if (localIterator1.hasNext()) {
        ((b)localIterator1.next()).onStart();
      }
    }
    Iterator localIterator2 = new ArrayList(this.bEF).iterator();
    b localb;
    StringBuilder localStringBuilder;
    String str;
    if (localIterator2.hasNext())
    {
      localb = (b)localIterator2.next();
      if (FragmentManager.isLoggingEnabled(2))
      {
        localStringBuilder = new StringBuilder("SpecialEffectsController: ");
        if (!bool) {
          break label144;
        }
      }
      label144:
      for (str = "";; str = "Container " + this.mContainer + " is not attached to window. ")
      {
        localStringBuilder.append(str).append("Cancelling running operation ").append(localb);
        localb.cancel();
        break;
      }
    }
    localIterator2 = new ArrayList(this.bEE).iterator();
    if (localIterator2.hasNext())
    {
      localb = (b)localIterator2.next();
      if (FragmentManager.isLoggingEnabled(2))
      {
        localStringBuilder = new StringBuilder("SpecialEffectsController: ");
        if (!bool) {
          break label261;
        }
      }
      label261:
      for (str = "";; str = "Container " + this.mContainer + " is not attached to window. ")
      {
        localStringBuilder.append(str).append("Cancelling pending operation ").append(localb);
        localb.cancel();
        break;
      }
    }
  }
  
  final void a(x.b.b paramb, o paramo)
  {
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("SpecialEffectsController: Enqueuing add operation for fragment ").append(paramo.bDv);
    }
    a(paramb, x.b.a.bET, paramo);
  }
  
  final x.b.a c(o paramo)
  {
    b localb = s(paramo.bDv);
    if (localb != null) {
      return localb.bEN;
    }
    paramo = t(paramo.bDv);
    if (paramo != null) {
      return paramo.bEN;
    }
    return null;
  }
  
  abstract void c(List<b> paramList, boolean paramBoolean);
  
  final void d(o paramo)
  {
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("SpecialEffectsController: Enqueuing show operation for fragment ").append(paramo.bDv);
    }
    a(x.b.b.bEX, x.b.a.bES, paramo);
  }
  
  final void e(o paramo)
  {
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("SpecialEffectsController: Enqueuing hide operation for fragment ").append(paramo.bDv);
    }
    a(x.b.b.bEY, x.b.a.bES, paramo);
  }
  
  final void f(o paramo)
  {
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("SpecialEffectsController: Enqueuing remove operation for fragment ").append(paramo.bDv);
    }
    a(x.b.b.bEW, x.b.a.bEU, paramo);
  }
  
  public final ViewGroup getContainer()
  {
    return this.mContainer;
  }
  
  static final class a
    extends x.b
  {
    private final o bEL;
    
    a(x.b.b paramb, x.b.a parama, o paramo, b paramb1)
    {
      super(parama, paramo.bDv, paramb1);
      this.bEL = paramo;
    }
    
    public final void GK()
    {
      AppMethodBeat.i(193559);
      super.GK();
      this.bEL.Gq();
      AppMethodBeat.o(193559);
    }
    
    final void onStart()
    {
      AppMethodBeat.i(193548);
      if (this.bEN == x.b.a.bET)
      {
        Fragment localFragment = this.bEL.bDv;
        View localView = localFragment.mView.findFocus();
        if (localView != null)
        {
          localFragment.setFocusedView(localView);
          if (FragmentManager.isLoggingEnabled(2)) {
            new StringBuilder("requestFocus: Saved focused view ").append(localView).append(" for Fragment ").append(localFragment);
          }
        }
        localView = this.bDv.requireView();
        if (localView.getParent() == null)
        {
          this.bEL.Gx();
          localView.setAlpha(0.0F);
        }
        if ((localView.getAlpha() == 0.0F) && (localView.getVisibility() == 0)) {
          localView.setVisibility(4);
        }
        localView.setAlpha(localFragment.getPostOnViewCreatedAlpha());
      }
      AppMethodBeat.o(193548);
    }
  }
  
  static class b
  {
    final Fragment bDv;
    b bEM;
    a bEN;
    private final List<Runnable> bEO;
    private final HashSet<b> bEP;
    boolean bEQ;
    boolean mIsCanceled;
    
    b(b paramb, a parama, Fragment paramFragment, b paramb1)
    {
      AppMethodBeat.i(193550);
      this.bEO = new ArrayList();
      this.bEP = new HashSet();
      this.mIsCanceled = false;
      this.bEQ = false;
      this.bEM = paramb;
      this.bEN = parama;
      this.bDv = paramFragment;
      paramb1.a(new b.a()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(193488);
          x.b.this.cancel();
          AppMethodBeat.o(193488);
        }
      });
      AppMethodBeat.o(193550);
    }
    
    public void GK()
    {
      AppMethodBeat.i(193630);
      if (this.bEQ)
      {
        AppMethodBeat.o(193630);
        return;
      }
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("SpecialEffectsController: ").append(this).append(" has called complete.");
      }
      this.bEQ = true;
      Iterator localIterator = this.bEO.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      AppMethodBeat.o(193630);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(193610);
      onStart();
      this.bEP.add(paramb);
      AppMethodBeat.o(193610);
    }
    
    final void a(b paramb, a parama)
    {
      AppMethodBeat.i(193591);
      switch (x.3.bEK[parama.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193591);
        return;
        if (this.bEM == b.bEW)
        {
          if (FragmentManager.isLoggingEnabled(2)) {
            new StringBuilder("SpecialEffectsController: For fragment ").append(this.bDv).append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ").append(this.bEN).append(" to ADDING.");
          }
          this.bEM = b.bEX;
          this.bEN = a.bET;
          AppMethodBeat.o(193591);
          return;
          if (FragmentManager.isLoggingEnabled(2)) {
            new StringBuilder("SpecialEffectsController: For fragment ").append(this.bDv).append(" mFinalState = ").append(this.bEM).append(" -> REMOVED. mLifecycleImpact  = ").append(this.bEN).append(" to REMOVING.");
          }
          this.bEM = b.bEW;
          this.bEN = a.bEU;
          AppMethodBeat.o(193591);
          return;
          if (this.bEM != b.bEW)
          {
            if (FragmentManager.isLoggingEnabled(2)) {
              new StringBuilder("SpecialEffectsController: For fragment ").append(this.bDv).append(" mFinalState = ").append(this.bEM).append(" -> ").append(paramb).append(". ");
            }
            this.bEM = paramb;
          }
        }
      }
    }
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(193619);
      if ((this.bEP.remove(paramb)) && (this.bEP.isEmpty())) {
        GK();
      }
      AppMethodBeat.o(193619);
    }
    
    final void cancel()
    {
      AppMethodBeat.i(193572);
      if (this.mIsCanceled)
      {
        AppMethodBeat.o(193572);
        return;
      }
      this.mIsCanceled = true;
      if (this.bEP.isEmpty())
      {
        GK();
        AppMethodBeat.o(193572);
        return;
      }
      Iterator localIterator = new ArrayList(this.bEP).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).cancel();
      }
      AppMethodBeat.o(193572);
    }
    
    final void g(Runnable paramRunnable)
    {
      AppMethodBeat.i(193597);
      this.bEO.add(paramRunnable);
      AppMethodBeat.o(193597);
    }
    
    void onStart() {}
    
    public String toString()
    {
      AppMethodBeat.i(193564);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Operation ");
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      ((StringBuilder)localObject).append("} ");
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append("mFinalState = ");
      ((StringBuilder)localObject).append(this.bEM);
      ((StringBuilder)localObject).append("} ");
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append("mLifecycleImpact = ");
      ((StringBuilder)localObject).append(this.bEN);
      ((StringBuilder)localObject).append("} ");
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append("mFragment = ");
      ((StringBuilder)localObject).append(this.bDv);
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(193564);
      return localObject;
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(193614);
        bES = new a("NONE", 0);
        bET = new a("ADDING", 1);
        bEU = new a("REMOVING", 2);
        bEV = new a[] { bES, bET, bEU };
        AppMethodBeat.o(193614);
      }
      
      private a() {}
    }
    
    static enum b
    {
      static
      {
        AppMethodBeat.i(193583);
        bEW = new b("REMOVED", 0);
        bEX = new b("VISIBLE", 1);
        bEY = new b("GONE", 2);
        bEZ = new b("INVISIBLE", 3);
        bFa = new b[] { bEW, bEX, bEY, bEZ };
        AppMethodBeat.o(193583);
      }
      
      private b() {}
      
      static b bb(View paramView)
      {
        AppMethodBeat.i(193563);
        if ((paramView.getAlpha() == 0.0F) && (paramView.getVisibility() == 0))
        {
          paramView = bEZ;
          AppMethodBeat.o(193563);
          return paramView;
        }
        paramView = eU(paramView.getVisibility());
        AppMethodBeat.o(193563);
        return paramView;
      }
      
      static b eU(int paramInt)
      {
        AppMethodBeat.i(193573);
        switch (paramInt)
        {
        default: 
          localObject = new IllegalArgumentException("Unknown visibility ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(193573);
          throw ((Throwable)localObject);
        case 0: 
          localObject = bEX;
          AppMethodBeat.o(193573);
          return localObject;
        case 4: 
          localObject = bEZ;
          AppMethodBeat.o(193573);
          return localObject;
        }
        Object localObject = bEY;
        AppMethodBeat.o(193573);
        return localObject;
      }
      
      final void bc(View paramView)
      {
        AppMethodBeat.i(193595);
        switch (x.3.bBu[ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193595);
          return;
          ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
          if (localViewGroup != null)
          {
            if (FragmentManager.isLoggingEnabled(2)) {
              new StringBuilder("SpecialEffectsController: Removing view ").append(paramView).append(" from container ").append(localViewGroup);
            }
            localViewGroup.removeView(paramView);
            AppMethodBeat.o(193595);
            return;
            if (FragmentManager.isLoggingEnabled(2)) {
              new StringBuilder("SpecialEffectsController: Setting view ").append(paramView).append(" to VISIBLE");
            }
            paramView.setVisibility(0);
            AppMethodBeat.o(193595);
            return;
            if (FragmentManager.isLoggingEnabled(2)) {
              new StringBuilder("SpecialEffectsController: Setting view ").append(paramView).append(" to GONE");
            }
            paramView.setVisibility(8);
            AppMethodBeat.o(193595);
            return;
            if (FragmentManager.isLoggingEnabled(2)) {
              new StringBuilder("SpecialEffectsController: Setting view ").append(paramView).append(" to INVISIBLE");
            }
            paramView.setVisibility(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.x
 * JD-Core Version:    0.7.0.1
 */