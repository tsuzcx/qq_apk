package androidx.fragment.app;

import androidx.core.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class a
  extends i
  implements FragmentManagerImpl.h, e.a
{
  final FragmentManagerImpl UN;
  ArrayList<a> UO;
  int UQ;
  int UR;
  int US;
  int UT;
  int UU;
  int UV;
  boolean UW;
  boolean UX;
  boolean UY;
  int UZ;
  CharSequence Va;
  int Vb;
  CharSequence Vc;
  ArrayList<String> Vd;
  ArrayList<String> Ve;
  boolean Vf;
  ArrayList<Runnable> Vg;
  int mIndex;
  String mName;
  
  public a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    AppMethodBeat.i(211833);
    this.UO = new ArrayList();
    this.UX = true;
    this.mIndex = -1;
    this.Vf = false;
    this.UN = paramFragmentManagerImpl;
    AppMethodBeat.o(211833);
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    AppMethodBeat.i(211839);
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i))))
    {
      paramFragment = new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
      AppMethodBeat.o(211839);
      throw paramFragment;
    }
    paramFragment.mFragmentManager = this.UN;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag)))
      {
        paramFragment = new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
        AppMethodBeat.o(211839);
        throw paramFragment;
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == -1)
      {
        paramFragment = new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id");
        AppMethodBeat.o(211839);
        throw paramFragment;
      }
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1))
      {
        paramFragment = new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
        AppMethodBeat.o(211839);
        throw paramFragment;
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    a(new a(paramInt2, paramFragment));
    AppMethodBeat.o(211839);
  }
  
  private int ag(boolean paramBoolean)
  {
    AppMethodBeat.i(211872);
    Object localObject;
    if (this.UY)
    {
      localObject = new IllegalStateException("commit already called");
      AppMethodBeat.o(211872);
      throw ((Throwable)localObject);
    }
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      localObject = new PrintWriter(new c("FragmentManager"));
      a("  ", (PrintWriter)localObject);
      ((PrintWriter)localObject).close();
    }
    this.UY = true;
    if (this.UW) {}
    for (this.mIndex = this.UN.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.UN.enqueueAction(this, paramBoolean);
      int i = this.mIndex;
      AppMethodBeat.o(211872);
      return i;
    }
  }
  
  static boolean b(a parama)
  {
    AppMethodBeat.i(211888);
    parama = parama.fragment;
    if ((parama != null) && (parama.mAdded) && (parama.mView != null) && (!parama.mDetached) && (!parama.mHidden) && (parama.isPostponed()))
    {
      AppMethodBeat.o(211888);
      return true;
    }
    AppMethodBeat.o(211888);
    return false;
  }
  
  private i il()
  {
    AppMethodBeat.i(211861);
    if (this.UW)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("This transaction is already being added to the back stack");
      AppMethodBeat.o(211861);
      throw localIllegalStateException;
    }
    this.UX = false;
    AppMethodBeat.o(211861);
    return this;
  }
  
  public final i O(int paramInt1, int paramInt2)
  {
    this.UQ = paramInt1;
    this.UR = paramInt2;
    this.US = 0;
    this.UT = 0;
    return this;
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    AppMethodBeat.i(211884);
    int j = 0;
    Fragment localFragment1 = paramFragment;
    a locala;
    int i;
    Fragment localFragment2;
    int m;
    int k;
    label226:
    Fragment localFragment3;
    if (j < this.UO.size())
    {
      locala = (a)this.UO.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.Vh)
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
          paramArrayList.add(locala.fragment);
          i = j;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(locala.fragment);
          i = j;
          paramFragment = localFragment1;
          if (locala.fragment == localFragment1)
          {
            this.UO.add(j, new a(9, locala.fragment));
            i = j + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = locala.fragment;
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
            break label464;
          }
          if (localFragment3 == localFragment2) {
            j = 1;
          }
        }
        break;
      }
    }
    label464:
    for (;;)
    {
      k -= 1;
      break label226;
      m = i;
      localFragment1 = paramFragment;
      if (localFragment3 == paramFragment)
      {
        this.UO.add(i, new a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new a(3, localFragment3);
      paramFragment.Vi = locala.Vi;
      paramFragment.Vk = locala.Vk;
      paramFragment.Vj = locala.Vj;
      paramFragment.Vl = locala.Vl;
      this.UO.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.UO.remove(i);
        i -= 1;
        break;
      }
      locala.Vh = 1;
      paramArrayList.add(localFragment2);
      break;
      this.UO.add(j, new a(9, localFragment1));
      i = j + 1;
      paramFragment = locala.fragment;
      break;
      AppMethodBeat.o(211884);
      return localFragment1;
    }
  }
  
  public final i a(int paramInt, Fragment paramFragment)
  {
    AppMethodBeat.i(211837);
    a(paramInt, paramFragment, null, 1);
    AppMethodBeat.o(211837);
    return this;
  }
  
  public final i a(int paramInt, Fragment paramFragment, String paramString)
  {
    AppMethodBeat.i(211838);
    a(paramInt, paramFragment, paramString, 1);
    AppMethodBeat.o(211838);
    return this;
  }
  
  public final i a(Fragment paramFragment)
  {
    AppMethodBeat.i(211846);
    a(new a(3, paramFragment));
    AppMethodBeat.o(211846);
    return this;
  }
  
  public final i a(Fragment paramFragment, String paramString)
  {
    AppMethodBeat.i(211835);
    a(0, paramFragment, paramString, 1);
    AppMethodBeat.o(211835);
    return this;
  }
  
  final void a(Fragment.c paramc)
  {
    AppMethodBeat.i(211887);
    int i = 0;
    while (i < this.UO.size())
    {
      a locala = (a)this.UO.get(i);
      if (b(locala)) {
        locala.fragment.setOnStartEnterTransitionListener(paramc);
      }
      i += 1;
    }
    AppMethodBeat.o(211887);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(211834);
    this.UO.add(parama);
    parama.Vi = this.UQ;
    parama.Vj = this.UR;
    parama.Vk = this.US;
    parama.Vl = this.UT;
    AppMethodBeat.o(211834);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(211829);
    a(paramString, paramPrintWriter, true);
    AppMethodBeat.o(211829);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    AppMethodBeat.i(211832);
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.UY);
      if (this.UU != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.UU));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.UV));
      }
      if ((this.UQ != 0) || (this.UR != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.UQ));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.UR));
      }
      if ((this.US != 0) || (this.UT != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.US));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.UT));
      }
      if ((this.UZ != 0) || (this.Va != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.UZ));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.Va);
      }
      if ((this.Vb != 0) || (this.Vc != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.Vb));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.Vc);
      }
    }
    if (!this.UO.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.UO.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)this.UO.get(i);
        String str;
        switch (locala.Vh)
        {
        default: 
          str = "cmd=" + locala.Vh;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locala.fragment);
          if (paramBoolean)
          {
            if ((locala.Vi != 0) || (locala.Vj != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.Vi));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.Vj));
            }
            if ((locala.Vk != 0) || (locala.Vl != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.Vk));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.Vl));
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
        }
      }
    }
    AppMethodBeat.o(211832);
  }
  
  final boolean a(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211876);
    if (paramInt2 == paramInt1)
    {
      AppMethodBeat.o(211876);
      return false;
    }
    int i1 = this.UO.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (a)this.UO.get(k);
      if (((a)localObject).fragment != null)
      {
        i = ((a)localObject).fragment.mContainerId;
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
        int i2 = ((a)localObject).UO.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label194;
          }
          a locala = (a)((a)localObject).UO.get(m);
          if (locala.fragment != null) {}
          for (int n = locala.fragment.mContainerId;; n = 0)
          {
            if (n != i) {
              break label185;
            }
            AppMethodBeat.o(211876);
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
      AppMethodBeat.o(211876);
      return false;
      label224:
      i = j;
    }
  }
  
  public final boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    AppMethodBeat.i(211873);
    if (FragmentManagerImpl.DEBUG) {
      new StringBuilder("Run: ").append(this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.UW) {
      this.UN.addBackStackState(this);
    }
    AppMethodBeat.o(211873);
    return true;
  }
  
  final void ah(boolean paramBoolean)
  {
    AppMethodBeat.i(211882);
    int i = this.UO.size() - 1;
    if (i >= 0)
    {
      Object localObject = (a)this.UO.get(i);
      Fragment localFragment = ((a)localObject).fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.UU), this.UV);
      }
      switch (((a)localObject).Vh)
      {
      case 2: 
      default: 
        localObject = new IllegalArgumentException("Unknown cmd: " + ((a)localObject).Vh);
        AppMethodBeat.o(211882);
        throw ((Throwable)localObject);
      case 1: 
        localFragment.setNextAnim(((a)localObject).Vl);
        this.UN.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.Vf) && (((a)localObject).Vh != 3) && (localFragment != null)) {
          this.UN.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(((a)localObject).Vk);
        this.UN.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(((a)localObject).Vk);
        this.UN.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vl);
        this.UN.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vk);
        this.UN.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vl);
        this.UN.detachFragment(localFragment);
        continue;
        this.UN.setPrimaryNavigationFragment(null);
        continue;
        this.UN.setPrimaryNavigationFragment(localFragment);
      }
    }
    if ((!this.Vf) && (paramBoolean)) {
      this.UN.moveToState(this.UN.mCurState, true);
    }
    AppMethodBeat.o(211882);
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    AppMethodBeat.i(211885);
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.UO.size())
    {
      a locala = (a)this.UO.get(i);
      paramFragment = localFragment;
      switch (locala.Vh)
      {
      default: 
        paramFragment = localFragment;
      }
      for (;;)
      {
        i += 1;
        localFragment = paramFragment;
        break;
        paramArrayList.remove(locala.fragment);
        paramFragment = localFragment;
        continue;
        paramArrayList.add(locala.fragment);
        paramFragment = localFragment;
        continue;
        paramFragment = locala.fragment;
        continue;
        paramFragment = null;
      }
    }
    AppMethodBeat.o(211885);
    return localFragment;
  }
  
  public final i b(int paramInt, Fragment paramFragment)
  {
    AppMethodBeat.i(211842);
    if (paramInt == 0)
    {
      paramFragment = new IllegalArgumentException("Must use non-zero containerViewId");
      AppMethodBeat.o(211842);
      throw paramFragment;
    }
    a(paramInt, paramFragment, null, 2);
    AppMethodBeat.o(211842);
    return this;
  }
  
  public final i b(Fragment paramFragment)
  {
    AppMethodBeat.i(211847);
    a(new a(4, paramFragment));
    AppMethodBeat.o(211847);
    return this;
  }
  
  final void bX(int paramInt)
  {
    AppMethodBeat.i(211862);
    if (!this.UW)
    {
      AppMethodBeat.o(211862);
      return;
    }
    if (FragmentManagerImpl.DEBUG) {
      new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
    }
    int j = this.UO.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.UO.get(i);
      if (locala.fragment != null)
      {
        Fragment localFragment = locala.fragment;
        localFragment.mBackStackNesting += paramInt;
        if (FragmentManagerImpl.DEBUG) {
          new StringBuilder("Bump nesting of ").append(locala.fragment).append(" to ").append(locala.fragment.mBackStackNesting);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(211862);
  }
  
  final boolean bY(int paramInt)
  {
    AppMethodBeat.i(211875);
    int k = this.UO.size();
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.UO.get(i);
      if (locala.fragment != null) {}
      for (int j = locala.fragment.mContainerId; (j != 0) && (j == paramInt); j = 0)
      {
        AppMethodBeat.o(211875);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(211875);
    return false;
  }
  
  public final i c(Fragment paramFragment)
  {
    AppMethodBeat.i(211850);
    a(new a(5, paramFragment));
    AppMethodBeat.o(211850);
    return this;
  }
  
  public final i d(Fragment paramFragment)
  {
    AppMethodBeat.i(211853);
    a(new a(6, paramFragment));
    AppMethodBeat.o(211853);
    return this;
  }
  
  public final i e(Fragment paramFragment)
  {
    AppMethodBeat.i(211856);
    a(new a(7, paramFragment));
    AppMethodBeat.o(211856);
    return this;
  }
  
  public final i ik()
  {
    AppMethodBeat.i(211859);
    if (!this.UX)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
      AppMethodBeat.o(211859);
      throw localIllegalStateException;
    }
    this.UW = true;
    this.mName = null;
    AppMethodBeat.o(211859);
    return this;
  }
  
  public final void im()
  {
    AppMethodBeat.i(211864);
    if (this.Vg != null)
    {
      int j = this.Vg.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.Vg.get(i)).run();
        i += 1;
      }
      this.Vg = null;
    }
    AppMethodBeat.o(211864);
  }
  
  public final int in()
  {
    AppMethodBeat.i(211865);
    int i = ag(false);
    AppMethodBeat.o(211865);
    return i;
  }
  
  public final int ip()
  {
    AppMethodBeat.i(211867);
    int i = ag(true);
    AppMethodBeat.o(211867);
    return i;
  }
  
  public final void iq()
  {
    AppMethodBeat.i(211868);
    il();
    this.UN.execSingleAction(this, false);
    AppMethodBeat.o(211868);
  }
  
  public final void ir()
  {
    AppMethodBeat.i(211870);
    il();
    this.UN.execSingleAction(this, true);
    AppMethodBeat.o(211870);
  }
  
  final void is()
  {
    AppMethodBeat.i(211879);
    int j = this.UO.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (a)this.UO.get(i);
      Fragment localFragment = ((a)localObject).fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.UU, this.UV);
      }
      switch (((a)localObject).Vh)
      {
      case 2: 
      default: 
        localObject = new IllegalArgumentException("Unknown cmd: " + ((a)localObject).Vh);
        AppMethodBeat.o(211879);
        throw ((Throwable)localObject);
      case 1: 
        localFragment.setNextAnim(((a)localObject).Vi);
        this.UN.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.Vf) && (((a)localObject).Vh != 1) && (localFragment != null)) {
          this.UN.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(((a)localObject).Vj);
        this.UN.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vj);
        this.UN.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vi);
        this.UN.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vj);
        this.UN.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(((a)localObject).Vi);
        this.UN.attachFragment(localFragment);
        continue;
        this.UN.setPrimaryNavigationFragment(localFragment);
        continue;
        this.UN.setPrimaryNavigationFragment(null);
      }
    }
    if (!this.Vf) {
      this.UN.moveToState(this.UN.mCurState, true);
    }
    AppMethodBeat.o(211879);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211828);
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
    AppMethodBeat.o(211828);
    return localObject;
  }
  
  static final class a
  {
    int Vh;
    int Vi;
    int Vj;
    int Vk;
    int Vl;
    Fragment fragment;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.Vh = paramInt;
      this.fragment = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.a
 * JD-Core Version:    0.7.0.1
 */