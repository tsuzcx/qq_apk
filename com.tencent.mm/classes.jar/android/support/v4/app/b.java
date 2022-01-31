package android.support.v4.app;

import android.support.v4.e.e;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b
  extends k
  implements FragmentManagerImpl.h, g.a
{
  int mIndex = -1;
  String mName;
  final FragmentManagerImpl vh;
  ArrayList<a> vi = new ArrayList();
  int vj;
  int vk;
  int vl;
  int vm;
  int vn;
  int vo;
  boolean vp;
  boolean vq = true;
  boolean vr;
  int vs;
  CharSequence vt;
  int vu;
  CharSequence vv;
  ArrayList<String> vw;
  ArrayList<String> vx;
  boolean vy = false;
  ArrayList<Runnable> vz;
  
  public b(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.vh = paramFragmentManagerImpl;
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
    paramFragment.mFragmentManager = this.vh;
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
  
  private k cw()
  {
    if (this.vp) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.vq = false;
    return this;
  }
  
  private int x(boolean paramBoolean)
  {
    if (this.vr) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      PrintWriter localPrintWriter = new PrintWriter(new e("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.vr = true;
    if (this.vp) {}
    for (this.mIndex = this.vh.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.vh.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  public final k F(String paramString)
  {
    if (!this.vq) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.vp = true;
    this.mName = paramString;
    return this;
  }
  
  final void W(int paramInt)
  {
    if (!this.vp) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      int j = this.vi.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.vi.get(i);
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
  
  final boolean X(int paramInt)
  {
    int k = this.vi.size();
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.vi.get(i);
      if (locala.fragment != null) {}
      for (int j = locala.fragment.mContainerId; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
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
    if (j < this.vi.size())
    {
      locala = (a)this.vi.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.vA)
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
            this.vi.add(j, new a(9, locala.fragment));
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
        this.vi.add(i, new a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new a(3, localFragment3);
      paramFragment.vB = locala.vB;
      paramFragment.vD = locala.vD;
      paramFragment.vC = locala.vC;
      paramFragment.vE = locala.vE;
      this.vi.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.vi.remove(i);
        i -= 1;
        break;
      }
      locala.vA = 1;
      paramArrayList.add(localFragment2);
      break;
      this.vi.add(j, new a(9, localFragment1));
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
    while (i < this.vi.size())
    {
      a locala = (a)this.vi.get(i);
      if (b(locala)) {
        locala.fragment.setOnStartEnterTransitionListener(paramc);
      }
      i += 1;
    }
  }
  
  final void a(a parama)
  {
    this.vi.add(parama);
    parama.vB = this.vj;
    parama.vC = this.vk;
    parama.vD = this.vl;
    parama.vE = this.vm;
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
      paramPrintWriter.println(this.vr);
      if (this.vn != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.vn));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.vo));
      }
      if ((this.vj != 0) || (this.vk != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.vj));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.vk));
      }
      if ((this.vl != 0) || (this.vm != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.vl));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.vm));
      }
      if ((this.vs != 0) || (this.vt != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.vs));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.vt);
      }
      if ((this.vu != 0) || (this.vv != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.vu));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.vv);
      }
    }
    if (!this.vi.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.vi.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)this.vi.get(i);
        String str;
        switch (locala.vA)
        {
        default: 
          str = "cmd=" + locala.vA;
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
            if ((locala.vB != 0) || (locala.vC != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.vB));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.vC));
            }
            if ((locala.vD != 0) || (locala.vE != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.vD));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.vE));
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
    int i1 = this.vi.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (a)this.vi.get(k);
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
        int i2 = ((b)localObject).vi.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          a locala = (a)((b)localObject).vi.get(m);
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
    if (this.vp) {
      this.vh.addBackStackState(this);
    }
    return true;
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.vi.size())
    {
      a locala = (a)this.vi.get(i);
      paramFragment = localFragment;
      switch (locala.vA)
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
    return x(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return x(true);
  }
  
  public final void commitNow()
  {
    cw();
    this.vh.execSingleAction(this, false);
  }
  
  public final void commitNowAllowingStateLoss()
  {
    cw();
    this.vh.execSingleAction(this, true);
  }
  
  public final void cx()
  {
    if (this.vz != null)
    {
      int j = this.vz.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.vz.get(i)).run();
        i += 1;
      }
      this.vz = null;
    }
  }
  
  final void cy()
  {
    int j = this.vi.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.vi.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.vn, this.vo);
      }
      switch (locala.vA)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.vA);
      case 1: 
        localFragment.setNextAnim(locala.vB);
        this.vh.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.vy) && (locala.vA != 1) && (localFragment != null)) {
          this.vh.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(locala.vC);
        this.vh.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vC);
        this.vh.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vB);
        this.vh.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vC);
        this.vh.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vB);
        this.vh.attachFragment(localFragment);
        continue;
        this.vh.setPrimaryNavigationFragment(localFragment);
        continue;
        this.vh.setPrimaryNavigationFragment(null);
      }
    }
    if (!this.vy) {
      this.vh.moveToState(this.vh.mCurState, true);
    }
  }
  
  public final k d(Fragment paramFragment)
  {
    a(new a(6, paramFragment));
    return this;
  }
  
  public final k e(Fragment paramFragment)
  {
    a(new a(7, paramFragment));
    return this;
  }
  
  public final k m(int paramInt1, int paramInt2)
  {
    this.vj = paramInt1;
    this.vk = paramInt2;
    this.vl = 0;
    this.vm = 0;
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
  
  final void y(boolean paramBoolean)
  {
    int i = this.vi.size() - 1;
    if (i >= 0)
    {
      a locala = (a)this.vi.get(i);
      Fragment localFragment = locala.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.vn), this.vo);
      }
      switch (locala.vA)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.vA);
      case 1: 
        localFragment.setNextAnim(locala.vE);
        this.vh.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.vy) && (locala.vA != 3) && (localFragment != null)) {
          this.vh.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(locala.vD);
        this.vh.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(locala.vD);
        this.vh.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vE);
        this.vh.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vD);
        this.vh.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(locala.vE);
        this.vh.detachFragment(localFragment);
        continue;
        this.vh.setPrimaryNavigationFragment(null);
        continue;
        this.vh.setPrimaryNavigationFragment(localFragment);
      }
    }
    if ((!this.vy) && (paramBoolean)) {
      this.vh.moveToState(this.vh.mCurState, true);
    }
  }
  
  static final class a
  {
    Fragment fragment;
    int vA;
    int vB;
    int vC;
    int vD;
    int vE;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.vA = paramInt;
      this.fragment = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.b
 * JD-Core Version:    0.7.0.1
 */