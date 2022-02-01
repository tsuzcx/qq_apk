package androidx.fragment.app;

import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a
  extends r
  implements FragmentManager.a, FragmentManager.f
{
  final FragmentManager bBd;
  boolean bBe;
  int mIndex;
  
  a(FragmentManager paramFragmentManager) {}
  
  static boolean a(r.a parama)
  {
    AppMethodBeat.i(193612);
    parama = parama.bDv;
    if ((parama != null) && (parama.mAdded) && (parama.mView != null) && (!parama.mDetached) && (!parama.mHidden) && (parama.isPostponed()))
    {
      AppMethodBeat.o(193612);
      return true;
    }
    AppMethodBeat.o(193612);
    return false;
  }
  
  private int aP(boolean paramBoolean)
  {
    AppMethodBeat.i(193600);
    Object localObject;
    if (this.bBe)
    {
      localObject = new IllegalStateException("commit already called");
      AppMethodBeat.o(193600);
      throw ((Throwable)localObject);
    }
    if (FragmentManager.isLoggingEnabled(2))
    {
      new StringBuilder("Commit: ").append(this);
      localObject = new PrintWriter(new w("FragmentManager"));
      a("  ", (PrintWriter)localObject);
      ((PrintWriter)localObject).close();
    }
    this.bBe = true;
    if (this.bDG) {}
    for (this.mIndex = this.bBd.allocBackStackIndex();; this.mIndex = -1)
    {
      this.bBd.enqueueAction(this, paramBoolean);
      int i = this.mIndex;
      AppMethodBeat.o(193600);
      return i;
    }
  }
  
  public final void FV()
  {
    AppMethodBeat.i(193698);
    if (this.bDI != null)
    {
      int i = 0;
      while (i < this.bDI.size())
      {
        ((Runnable)this.bDI.get(i)).run();
        i += 1;
      }
      this.bDI = null;
    }
    AppMethodBeat.o(193698);
  }
  
  public final int FW()
  {
    AppMethodBeat.i(193703);
    int i = aP(false);
    AppMethodBeat.o(193703);
    return i;
  }
  
  public final int FX()
  {
    AppMethodBeat.i(193708);
    int i = aP(true);
    AppMethodBeat.o(193708);
    return i;
  }
  
  public final void FY()
  {
    AppMethodBeat.i(193715);
    GC();
    this.bBd.execSingleAction(this, false);
    AppMethodBeat.o(193715);
  }
  
  public final void FZ()
  {
    AppMethodBeat.i(193721);
    GC();
    this.bBd.execSingleAction(this, true);
    AppMethodBeat.o(193721);
  }
  
  final void Ga()
  {
    AppMethodBeat.i(193760);
    int j = this.bDF.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (r.a)this.bDF.get(i);
      Fragment localFragment = ((r.a)localObject).bDv;
      if (localFragment != null)
      {
        localFragment.setPopDirection(false);
        localFragment.setAnimations(((r.a)localObject).bCa, ((r.a)localObject).bCb, ((r.a)localObject).bCc, ((r.a)localObject).bCd);
        localFragment.setNextTransition(this.bBj);
        localFragment.setSharedElementNames(this.bBo, this.bBp);
      }
      switch (((r.a)localObject).bDJ)
      {
      case 2: 
      default: 
        localObject = new IllegalArgumentException("Unknown cmd: " + ((r.a)localObject).bDJ);
        AppMethodBeat.o(193760);
        throw ((Throwable)localObject);
      case 1: 
        this.bBd.setExitAnimationOrder(localFragment, false);
        this.bBd.addFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.bBq) && (((r.a)localObject).bDJ != 1) && (localFragment != null) && (!FragmentManager.USE_STATE_MANAGER)) {
          this.bBd.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        this.bBd.removeFragment(localFragment);
        continue;
        this.bBd.hideFragment(localFragment);
        continue;
        this.bBd.setExitAnimationOrder(localFragment, false);
        this.bBd.showFragment(localFragment);
        continue;
        this.bBd.detachFragment(localFragment);
        continue;
        this.bBd.setExitAnimationOrder(localFragment, false);
        this.bBd.attachFragment(localFragment);
        continue;
        this.bBd.setPrimaryNavigationFragment(localFragment);
        continue;
        this.bBd.setPrimaryNavigationFragment(null);
        continue;
        this.bBd.setMaxLifecycle(localFragment, ((r.a)localObject).bDL);
      }
    }
    if ((!this.bBq) && (!FragmentManager.USE_STATE_MANAGER)) {
      this.bBd.moveToState(this.bBd.mCurState, true);
    }
    AppMethodBeat.o(193760);
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    AppMethodBeat.i(193781);
    int j = 0;
    Fragment localFragment1 = paramFragment;
    r.a locala;
    int i;
    Fragment localFragment2;
    int m;
    int k;
    label226:
    Fragment localFragment3;
    if (j < this.bDF.size())
    {
      locala = (r.a)this.bDF.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.bDJ)
      {
      default: 
        paramFragment = localFragment1;
        i = j;
      case 4: 
      case 5: 
      case 1: 
      case 7: 
      case 3: 
      case 6: 
        for (;;)
        {
          j = i + 1;
          localFragment1 = paramFragment;
          break;
          paramArrayList.add(locala.bDv);
          i = j;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(locala.bDv);
          i = j;
          paramFragment = localFragment1;
          if (locala.bDv == localFragment1)
          {
            this.bDF.add(j, new r.a(9, locala.bDv));
            i = j + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = locala.bDv;
        int n = localFragment2.mContainerId;
        m = 0;
        k = paramArrayList.size() - 1;
        i = j;
        paramFragment = localFragment1;
        j = m;
        if (k >= 0)
        {
          localFragment3 = (Fragment)paramArrayList.get(k);
          if (localFragment3.mContainerId != n) {
            break label465;
          }
          if (localFragment3 == localFragment2) {
            j = 1;
          }
        }
        break;
      }
    }
    label465:
    for (;;)
    {
      k -= 1;
      break label226;
      m = i;
      localFragment1 = paramFragment;
      if (localFragment3 == paramFragment)
      {
        this.bDF.add(i, new r.a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new r.a(3, localFragment3);
      paramFragment.bCa = locala.bCa;
      paramFragment.bCc = locala.bCc;
      paramFragment.bCb = locala.bCb;
      paramFragment.bCd = locala.bCd;
      this.bDF.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.bDF.remove(i);
        i -= 1;
        break;
      }
      locala.bDJ = 1;
      paramArrayList.add(localFragment2);
      break;
      this.bDF.add(j, new r.a(9, localFragment1));
      i = j + 1;
      paramFragment = locala.bDv;
      break;
      AppMethodBeat.o(193781);
      return localFragment1;
    }
  }
  
  public final r a(Fragment paramFragment)
  {
    AppMethodBeat.i(193659);
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.bBd))
    {
      paramFragment = new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
      AppMethodBeat.o(193659);
      throw paramFragment;
    }
    paramFragment = super.a(paramFragment);
    AppMethodBeat.o(193659);
    return paramFragment;
  }
  
  public final r a(Fragment paramFragment, j.b paramb)
  {
    AppMethodBeat.i(193682);
    if (paramFragment.mFragmentManager != this.bBd)
    {
      paramFragment = new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.bBd);
      AppMethodBeat.o(193682);
      throw paramFragment;
    }
    if ((paramb == j.b.bHh) && (paramFragment.mState >= 0))
    {
      paramFragment = new IllegalArgumentException("Cannot set maximum Lifecycle to " + paramb + " after the Fragment has been created");
      AppMethodBeat.o(193682);
      throw paramFragment;
    }
    if (paramb == j.b.bHg)
    {
      paramFragment = new IllegalArgumentException("Cannot set maximum Lifecycle to " + paramb + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
      AppMethodBeat.o(193682);
      throw paramFragment;
    }
    paramFragment = super.a(paramFragment, paramb);
    AppMethodBeat.o(193682);
    return paramFragment;
  }
  
  final void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    AppMethodBeat.i(193650);
    super.a(paramInt1, paramFragment, paramString, paramInt2);
    paramFragment.mFragmentManager = this.bBd;
    AppMethodBeat.o(193650);
  }
  
  final void a(Fragment.d paramd)
  {
    AppMethodBeat.i(193797);
    int i = 0;
    while (i < this.bDF.size())
    {
      r.a locala = (r.a)this.bDF.get(i);
      if (a(locala)) {
        locala.bDv.setOnStartEnterTransitionListener(paramd);
      }
      i += 1;
    }
    AppMethodBeat.o(193797);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(193634);
    a(paramString, paramPrintWriter, true);
    AppMethodBeat.o(193634);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    AppMethodBeat.i(193644);
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.bBe);
      if (this.bBj != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.bBj));
      }
      if ((this.bCa != 0) || (this.bCb != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.bCa));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.bCb));
      }
      if ((this.bCc != 0) || (this.bCd != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.bCc));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.bCd));
      }
      if ((this.bBk != 0) || (this.bBl != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.bBk));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.bBl);
      }
      if ((this.bBm != 0) || (this.bBn != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.bBm));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.bBn);
      }
    }
    if (!this.bDF.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int j = this.bDF.size();
      int i = 0;
      if (i < j)
      {
        r.a locala = (r.a)this.bDF.get(i);
        String str;
        switch (locala.bDJ)
        {
        default: 
          str = "cmd=" + locala.bDJ;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locala.bDv);
          if (paramBoolean)
          {
            if ((locala.bCa != 0) || (locala.bCb != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.bCa));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.bCb));
            }
            if ((locala.bCc != 0) || (locala.bCd != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.bCc));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.bCd));
            }
          }
          i += 1;
          break;
          str = "NULL";
          continue;
          str = "ADD";
          continue;
          str = "REPLACE";
          continue;
          str = "REMOVE";
          continue;
          str = "HIDE";
          continue;
          str = "SHOW";
          continue;
          str = "DETACH";
          continue;
          str = "ATTACH";
          continue;
          str = "SET_PRIMARY_NAV";
          continue;
          str = "UNSET_PRIMARY_NAV";
          continue;
          str = "OP_SET_MAX_LIFECYCLE";
        }
      }
    }
    AppMethodBeat.o(193644);
  }
  
  public final boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    AppMethodBeat.i(193729);
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Run: ").append(this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.bDG) {
      this.bBd.addBackStackState(this);
    }
    AppMethodBeat.o(193729);
    return true;
  }
  
  final void aQ(boolean paramBoolean)
  {
    AppMethodBeat.i(193769);
    int i = this.bDF.size() - 1;
    if (i >= 0)
    {
      Object localObject = (r.a)this.bDF.get(i);
      Fragment localFragment = ((r.a)localObject).bDv;
      if (localFragment != null)
      {
        localFragment.setPopDirection(true);
        localFragment.setAnimations(((r.a)localObject).bCa, ((r.a)localObject).bCb, ((r.a)localObject).bCc, ((r.a)localObject).bCd);
        localFragment.setNextTransition(FragmentManager.reverseTransit(this.bBj));
        localFragment.setSharedElementNames(this.bBp, this.bBo);
      }
      switch (((r.a)localObject).bDJ)
      {
      case 2: 
      default: 
        localObject = new IllegalArgumentException("Unknown cmd: " + ((r.a)localObject).bDJ);
        AppMethodBeat.o(193769);
        throw ((Throwable)localObject);
      case 1: 
        this.bBd.setExitAnimationOrder(localFragment, true);
        this.bBd.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.bBq) && (((r.a)localObject).bDJ != 3) && (localFragment != null) && (!FragmentManager.USE_STATE_MANAGER)) {
          this.bBd.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        this.bBd.addFragment(localFragment);
        continue;
        this.bBd.showFragment(localFragment);
        continue;
        this.bBd.setExitAnimationOrder(localFragment, true);
        this.bBd.hideFragment(localFragment);
        continue;
        this.bBd.attachFragment(localFragment);
        continue;
        this.bBd.setExitAnimationOrder(localFragment, true);
        this.bBd.detachFragment(localFragment);
        continue;
        this.bBd.setPrimaryNavigationFragment(null);
        continue;
        this.bBd.setPrimaryNavigationFragment(localFragment);
        continue;
        this.bBd.setMaxLifecycle(localFragment, ((r.a)localObject).bDK);
      }
    }
    if ((!this.bBq) && (paramBoolean) && (!FragmentManager.USE_STATE_MANAGER)) {
      this.bBd.moveToState(this.bBd.mCurState, true);
    }
    AppMethodBeat.o(193769);
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    AppMethodBeat.i(193788);
    int i = this.bDF.size() - 1;
    if (i >= 0)
    {
      r.a locala = (r.a)this.bDF.get(i);
      switch (locala.bDJ)
      {
      }
      for (;;)
      {
        i -= 1;
        break;
        paramArrayList.remove(locala.bDv);
        continue;
        paramArrayList.add(locala.bDv);
        continue;
        paramFragment = locala.bDv;
        continue;
        paramFragment = null;
        continue;
        locala.bDL = locala.bDK;
      }
    }
    AppMethodBeat.o(193788);
    return paramFragment;
  }
  
  public final r b(Fragment paramFragment)
  {
    AppMethodBeat.i(193664);
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.bBd))
    {
      paramFragment = new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
      AppMethodBeat.o(193664);
      throw paramFragment;
    }
    paramFragment = super.b(paramFragment);
    AppMethodBeat.o(193664);
    return paramFragment;
  }
  
  public final r c(Fragment paramFragment)
  {
    AppMethodBeat.i(193669);
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.bBd))
    {
      paramFragment = new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
      AppMethodBeat.o(193669);
      throw paramFragment;
    }
    paramFragment = super.c(paramFragment);
    AppMethodBeat.o(193669);
    return paramFragment;
  }
  
  public final r d(Fragment paramFragment)
  {
    AppMethodBeat.i(193675);
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.bBd))
    {
      paramFragment = new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
      AppMethodBeat.o(193675);
      throw paramFragment;
    }
    paramFragment = super.d(paramFragment);
    AppMethodBeat.o(193675);
    return paramFragment;
  }
  
  final boolean d(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193750);
    if (paramInt2 == paramInt1)
    {
      AppMethodBeat.o(193750);
      return false;
    }
    int i1 = this.bDF.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (r.a)this.bDF.get(k);
      if (((r.a)localObject).bDv != null)
      {
        i = ((r.a)localObject).bDv.mContainerId;
        if ((i == 0) || (i == j)) {
          break label224;
        }
        j = paramInt1;
      }
      for (;;)
      {
        if (j >= paramInt2) {
          break label203;
        }
        localObject = (a)paramArrayList.get(j);
        int i2 = ((a)localObject).bDF.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label194;
          }
          r.a locala = (r.a)((a)localObject).bDF.get(m);
          if (locala.bDv != null) {}
          for (int n = locala.bDv.mContainerId;; n = 0)
          {
            if (n != i) {
              break label185;
            }
            AppMethodBeat.o(193750);
            return true;
            i = 0;
            break;
          }
          label185:
          m += 1;
        }
        label194:
        j += 1;
      }
    }
    for (;;)
    {
      label203:
      k += 1;
      j = i;
      break;
      AppMethodBeat.o(193750);
      return false;
      label224:
      i = j;
    }
  }
  
  final void eS(int paramInt)
  {
    AppMethodBeat.i(193690);
    if (!this.bDG)
    {
      AppMethodBeat.o(193690);
      return;
    }
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
    }
    int j = this.bDF.size();
    int i = 0;
    while (i < j)
    {
      r.a locala = (r.a)this.bDF.get(i);
      if (locala.bDv != null)
      {
        Fragment localFragment = locala.bDv;
        localFragment.mBackStackNesting += paramInt;
        if (FragmentManager.isLoggingEnabled(2)) {
          new StringBuilder("Bump nesting of ").append(locala.bDv).append(" to ").append(locala.bDv.mBackStackNesting);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(193690);
  }
  
  final boolean eT(int paramInt)
  {
    AppMethodBeat.i(193737);
    int k = this.bDF.size();
    int i = 0;
    while (i < k)
    {
      r.a locala = (r.a)this.bDF.get(i);
      if (locala.bDv != null) {}
      for (int j = locala.bDv.mContainerId; (j != 0) && (j == paramInt); j = 0)
      {
        AppMethodBeat.o(193737);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(193737);
    return false;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193622);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("BackStackEntry{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      ((StringBuilder)localObject).append(" #");
      ((StringBuilder)localObject).append(this.mIndex);
    }
    if (this.mName != null)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.mName);
    }
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193622);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.a
 * JD-Core Version:    0.7.0.1
 */