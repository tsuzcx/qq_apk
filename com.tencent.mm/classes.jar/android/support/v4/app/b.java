package android.support.v4.app;

import android.support.v4.e.f;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b
  extends k
  implements FragmentManagerImpl.h, g.a
{
  final FragmentManagerImpl BE;
  ArrayList<a> BF = new ArrayList();
  int BG;
  int BH;
  int BI;
  int BJ;
  int BK;
  int BL;
  boolean BM;
  boolean BN = true;
  boolean BO;
  int BP;
  CharSequence BQ;
  int BR;
  CharSequence BS;
  ArrayList<String> BT;
  ArrayList<String> BU;
  boolean BV = false;
  ArrayList<Runnable> BW;
  int mIndex = -1;
  String mName;
  
  public b(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.BE = paramFragmentManagerImpl;
  }
  
  private int D(boolean paramBoolean)
  {
    if (this.BO) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      PrintWriter localPrintWriter = new PrintWriter(new f("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.BO = true;
    if (this.BM) {}
    for (this.mIndex = this.BE.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.BE.enqueueAction(this, paramBoolean);
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
    paramFragment.mFragmentManager = this.BE;
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
  
  private k dz()
  {
    if (this.BM) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.BN = false;
    return this;
  }
  
  final void E(boolean paramBoolean)
  {
    int i = this.BF.size() - 1;
    if (i >= 0)
    {
      a locala = (a)this.BF.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.BK), this.BL);
      }
      switch (locala.BX)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.BX);
      case 1: 
        localFragment.setNextAnim(locala.Cb);
        this.BE.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.BV) && (locala.BX != 3) && (localFragment != null)) {
          this.BE.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(locala.Ca);
        this.BE.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(locala.Ca);
        this.BE.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.Cb);
        this.BE.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.Ca);
        this.BE.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.Cb);
        this.BE.detachFragment(localFragment);
        continue;
        this.BE.setPrimaryNavigationFragment(null);
        continue;
        this.BE.setPrimaryNavigationFragment(localFragment);
      }
    }
    if ((!this.BV) && (paramBoolean)) {
      this.BE.moveToState(this.BE.mCurState, true);
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
    if (j < this.BF.size())
    {
      locala = (a)this.BF.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.BX)
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
            this.BF.add(j, new a(9, locala.fragment));
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
        this.BF.add(i, new a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new a(3, localFragment3);
      paramFragment.BY = locala.BY;
      paramFragment.Ca = locala.Ca;
      paramFragment.BZ = locala.BZ;
      paramFragment.Cb = locala.Cb;
      this.BF.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.BF.remove(i);
        i -= 1;
        break;
      }
      locala.BX = 1;
      paramArrayList.add(localFragment2);
      break;
      this.BF.add(j, new a(9, localFragment1));
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
  
  public final k a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  final void a(Fragment.c paramc)
  {
    int i = 0;
    while (i < this.BF.size())
    {
      a locala = (a)this.BF.get(i);
      if (b(locala)) {
        locala.fragment.setOnStartEnterTransitionListener(paramc);
      }
      i += 1;
    }
  }
  
  final void a(a parama)
  {
    this.BF.add(parama);
    parama.BY = this.BG;
    parama.BZ = this.BH;
    parama.Ca = this.BI;
    parama.Cb = this.BJ;
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
      paramPrintWriter.println(this.BO);
      if (this.BK != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.BK));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.BL));
      }
      if ((this.BG != 0) || (this.BH != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.BG));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.BH));
      }
      if ((this.BI != 0) || (this.BJ != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.BI));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.BJ));
      }
      if ((this.BP != 0) || (this.BQ != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.BP));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.BQ);
      }
      if ((this.BR != 0) || (this.BS != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.BR));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.BS);
      }
    }
    if (!this.BF.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.BF.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)this.BF.get(i);
        String str;
        switch (locala.BX)
        {
        default: 
          str = "cmd=" + locala.BX;
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
            if ((locala.BY != 0) || (locala.BZ != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.BY));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.BZ));
            }
            if ((locala.Ca != 0) || (locala.Cb != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.Ca));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.Cb));
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
    int i1 = this.BF.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (a)this.BF.get(k);
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
        int i2 = ((b)localObject).BF.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          a locala = (a)((b)localObject).BF.get(m);
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
    if (this.BM) {
      this.BE.addBackStackState(this);
    }
    return true;
  }
  
  final void aq(int paramInt)
  {
    if (!this.BM) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      int j = this.BF.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.BF.get(i);
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
    int k = this.BF.size();
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.BF.get(i);
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
    if (i < this.BF.size())
    {
      a locala = (a)this.BF.get(i);
      paramFragment = localFragment;
      switch (locala.BX)
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
    a(new a(3, paramFragment));
    return this;
  }
  
  public final k c(Fragment paramFragment)
  {
    a(new a(5, paramFragment));
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
    dz();
    this.BE.execSingleAction(this, false);
  }
  
  public final void commitNowAllowingStateLoss()
  {
    dz();
    this.BE.execSingleAction(this, true);
  }
  
  public final k d(Fragment paramFragment)
  {
    a(new a(6, paramFragment));
    return this;
  }
  
  public final void dA()
  {
    if (this.BW != null)
    {
      int j = this.BW.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.BW.get(i)).run();
        i += 1;
      }
      this.BW = null;
    }
  }
  
  final void dB()
  {
    int j = this.BF.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.BF.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.BK, this.BL);
      }
      switch (locala.BX)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.BX);
      case 1: 
        localFragment.setNextAnim(locala.BY);
        this.BE.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.BV) && (locala.BX != 1) && (localFragment != null)) {
          this.BE.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(locala.BZ);
        this.BE.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.BZ);
        this.BE.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.BY);
        this.BE.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.BZ);
        this.BE.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.BY);
        this.BE.attachFragment(localFragment);
        continue;
        this.BE.setPrimaryNavigationFragment(localFragment);
        continue;
        this.BE.setPrimaryNavigationFragment(null);
      }
    }
    if (!this.BV) {
      this.BE.moveToState(this.BE.mCurState, true);
    }
  }
  
  public final k dy()
  {
    if (!this.BN) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.BM = true;
    this.mName = null;
    return this;
  }
  
  public final k e(Fragment paramFragment)
  {
    a(new a(7, paramFragment));
    return this;
  }
  
  public final k n(int paramInt1, int paramInt2)
  {
    this.BG = paramInt1;
    this.BH = paramInt2;
    this.BI = 0;
    this.BJ = 0;
    return this;
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
  
  static final class a
  {
    int BX;
    int BY;
    int BZ;
    int Ca;
    int Cb;
    Fragment fragment;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.BX = paramInt;
      this.fragment = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.b
 * JD-Core Version:    0.7.0.1
 */