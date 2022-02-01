package android.support.v4.app;

import android.support.v4.e.f;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b
  extends k
  implements FragmentManagerImpl.h, g.a
{
  int EA;
  int EB;
  boolean EC;
  boolean ED = true;
  boolean EE;
  int EF;
  CharSequence EG;
  int EH;
  CharSequence EI;
  ArrayList<String> EJ;
  ArrayList<String> EK;
  boolean EL = false;
  ArrayList<Runnable> EM;
  final FragmentManagerImpl Eu;
  ArrayList<a> Ev = new ArrayList();
  int Ew;
  int Ex;
  int Ey;
  int Ez;
  int mIndex = -1;
  String mName;
  
  public b(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.Eu = paramFragmentManagerImpl;
  }
  
  private int D(boolean paramBoolean)
  {
    if (this.EE) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      PrintWriter localPrintWriter = new PrintWriter(new f("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.EE = true;
    if (this.EC) {}
    for (this.mIndex = this.Eu.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.Eu.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
    paramFragment.mFragmentManager = this.Eu;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == -1) {
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id");
      }
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    a(new a(paramInt2, paramFragment));
  }
  
  static boolean b(a parama)
  {
    parama = parama.fragment;
    return (parama != null) && (parama.mAdded) && (parama.mView != null) && (!parama.mDetached) && (!parama.mHidden) && (parama.isPostponed());
  }
  
  private k dV()
  {
    if (this.EC) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.ED = false;
    return this;
  }
  
  final void E(boolean paramBoolean)
  {
    int i = this.Ev.size() - 1;
    if (i >= 0)
    {
      a locala = (a)this.Ev.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.EA), this.EB);
      }
      switch (locala.EN)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.EN);
      case 1: 
        localFragment.setNextAnim(locala.ER);
        this.Eu.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.EL) && (locala.EN != 3) && (localFragment != null)) {
          this.Eu.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(locala.EQ);
        this.Eu.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(locala.EQ);
        this.Eu.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.ER);
        this.Eu.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.EQ);
        this.Eu.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.ER);
        this.Eu.detachFragment(localFragment);
        continue;
        this.Eu.setPrimaryNavigationFragment(null);
        continue;
        this.Eu.setPrimaryNavigationFragment(localFragment);
      }
    }
    if ((!this.EL) && (paramBoolean)) {
      this.Eu.moveToState(this.Eu.mCurState, true);
    }
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int j = 0;
    Fragment localFragment1 = paramFragment;
    a locala;
    int i;
    Fragment localFragment2;
    int m;
    int k;
    label218:
    Fragment localFragment3;
    if (j < this.Ev.size())
    {
      locala = (a)this.Ev.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.EN)
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
            this.Ev.add(j, new a(9, locala.fragment));
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
            break label451;
          }
          if (localFragment3 == localFragment2) {
            j = 1;
          }
        }
        break;
      }
    }
    label451:
    for (;;)
    {
      k -= 1;
      break label218;
      m = i;
      localFragment1 = paramFragment;
      if (localFragment3 == paramFragment)
      {
        this.Ev.add(i, new a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new a(3, localFragment3);
      paramFragment.EO = locala.EO;
      paramFragment.EQ = locala.EQ;
      paramFragment.EP = locala.EP;
      paramFragment.ER = locala.ER;
      this.Ev.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.Ev.remove(i);
        i -= 1;
        break;
      }
      locala.EN = 1;
      paramArrayList.add(localFragment2);
      break;
      this.Ev.add(j, new a(9, localFragment1));
      i = j + 1;
      paramFragment = locala.fragment;
      break;
      return localFragment1;
    }
  }
  
  public final k a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final k a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public final k a(Fragment paramFragment)
  {
    a(new a(3, paramFragment));
    return this;
  }
  
  public final k a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  final void a(Fragment.c paramc)
  {
    int i = 0;
    while (i < this.Ev.size())
    {
      a locala = (a)this.Ev.get(i);
      if (b(locala)) {
        locala.fragment.setOnStartEnterTransitionListener(paramc);
      }
      i += 1;
    }
  }
  
  final void a(a parama)
  {
    this.Ev.add(parama);
    parama.EO = this.Ew;
    parama.EP = this.Ex;
    parama.EQ = this.Ey;
    parama.ER = this.Ez;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.EE);
      if (this.EA != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.EA));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.EB));
      }
      if ((this.Ew != 0) || (this.Ex != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.Ew));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.Ex));
      }
      if ((this.Ey != 0) || (this.Ez != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.Ey));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.Ez));
      }
      if ((this.EF != 0) || (this.EG != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.EF));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.EG);
      }
      if ((this.EH != 0) || (this.EI != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.EH));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.EI);
      }
    }
    if (!this.Ev.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.Ev.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)this.Ev.get(i);
        String str;
        switch (locala.EN)
        {
        default: 
          str = "cmd=" + locala.EN;
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
            if ((locala.EO != 0) || (locala.EP != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.EO));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.EP));
            }
            if ((locala.EQ != 0) || (locala.ER != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.EQ));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.ER));
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
  }
  
  final boolean a(ArrayList<b> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i1 = this.Ev.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (a)this.Ev.get(k);
      if (((a)localObject).fragment != null)
      {
        i = ((a)localObject).fragment.mContainerId;
        if ((i == 0) || (i == j)) {
          break label200;
        }
        j = paramInt1;
      }
      for (;;)
      {
        if (j >= paramInt2) {
          break label185;
        }
        localObject = (b)paramArrayList.get(j);
        int i2 = ((b)localObject).Ev.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          a locala = (a)((b)localObject).Ev.get(m);
          if (locala.fragment != null) {}
          for (int n = locala.fragment.mContainerId;; n = 0)
          {
            if (n != i) {
              break label167;
            }
            return true;
            i = 0;
            break;
          }
          label167:
          m += 1;
        }
        label176:
        j += 1;
      }
    }
    for (;;)
    {
      label185:
      k += 1;
      j = i;
      break;
      return false;
      label200:
      i = j;
    }
  }
  
  public final boolean a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (FragmentManagerImpl.DEBUG) {
      new StringBuilder("Run: ").append(this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.EC) {
      this.Eu.addBackStackState(this);
    }
    return true;
  }
  
  final void aq(int paramInt)
  {
    if (!this.EC) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      int j = this.Ev.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.Ev.get(i);
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
    }
  }
  
  final boolean ar(int paramInt)
  {
    int k = this.Ev.size();
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.Ev.get(i);
      if (locala.fragment != null) {}
      for (int j = locala.fragment.mContainerId; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.Ev.size())
    {
      a locala = (a)this.Ev.get(i);
      paramFragment = localFragment;
      switch (locala.EN)
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
    return localFragment;
  }
  
  public final k b(int paramInt, Fragment paramFragment)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    a(paramInt, paramFragment, null, 2);
    return this;
  }
  
  public final k b(Fragment paramFragment)
  {
    a(new a(5, paramFragment));
    return this;
  }
  
  public final k c(Fragment paramFragment)
  {
    a(new a(6, paramFragment));
    return this;
  }
  
  public final int commit()
  {
    return D(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return D(true);
  }
  
  public final void commitNow()
  {
    dV();
    this.Eu.execSingleAction(this, false);
  }
  
  public final void commitNowAllowingStateLoss()
  {
    dV();
    this.Eu.execSingleAction(this, true);
  }
  
  public final k d(Fragment paramFragment)
  {
    a(new a(7, paramFragment));
    return this;
  }
  
  public final k dU()
  {
    if (!this.ED) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.EC = true;
    this.mName = null;
    return this;
  }
  
  public final void dW()
  {
    if (this.EM != null)
    {
      int j = this.EM.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.EM.get(i)).run();
        i += 1;
      }
      this.EM = null;
    }
  }
  
  final void dX()
  {
    int j = this.Ev.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.Ev.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.EA, this.EB);
      }
      switch (locala.EN)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.EN);
      case 1: 
        localFragment.setNextAnim(locala.EO);
        this.Eu.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.EL) && (locala.EN != 1) && (localFragment != null)) {
          this.Eu.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(locala.EP);
        this.Eu.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.EP);
        this.Eu.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.EO);
        this.Eu.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.EP);
        this.Eu.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.EO);
        this.Eu.attachFragment(localFragment);
        continue;
        this.Eu.setPrimaryNavigationFragment(localFragment);
        continue;
        this.Eu.setPrimaryNavigationFragment(null);
      }
    }
    if (!this.EL) {
      this.Eu.moveToState(this.Eu.mCurState, true);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final k u(int paramInt1, int paramInt2)
  {
    this.Ew = paramInt1;
    this.Ex = paramInt2;
    this.Ey = 0;
    this.Ez = 0;
    return this;
  }
  
  static final class a
  {
    int EN;
    int EO;
    int EP;
    int EQ;
    int ER;
    Fragment fragment;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.EN = paramInt;
      this.fragment = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.b
 * JD-Core Version:    0.7.0.1
 */