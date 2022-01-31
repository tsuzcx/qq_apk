package android.support.v4.app;

import android.support.v4.f.e;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class b
  extends o
  implements k.g
{
  int mIndex = -1;
  String mName;
  boolean uA = false;
  ArrayList<Runnable> uB;
  final k ug;
  ArrayList<a> uh = new ArrayList();
  int uj;
  int uk;
  int ul;
  int um;
  int un;
  int uo;
  boolean uq;
  boolean ur = true;
  boolean ut;
  int uu;
  CharSequence uv;
  int uw;
  CharSequence ux;
  ArrayList<String> uy;
  ArrayList<String> uz;
  
  public b(k paramk)
  {
    this.ug = paramk;
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
    paramFragment.mFragmentManager = this.ug;
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
    parama = parama.uD;
    return (parama != null) && (parama.mAdded) && (parama.mView != null) && (!parama.mDetached) && (!parama.mHidden) && (parama.isPostponed());
  }
  
  private o bJ()
  {
    if (this.uq) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.ur = false;
    return this;
  }
  
  private int w(boolean paramBoolean)
  {
    if (this.ut) {
      throw new IllegalStateException("commit already called");
    }
    if (k.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      PrintWriter localPrintWriter = new PrintWriter(new e("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.ut = true;
    if (this.uq) {}
    for (this.mIndex = this.ug.a(this);; this.mIndex = -1)
    {
      this.ug.a(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  final void X(int paramInt)
  {
    if (!this.uq) {}
    for (;;)
    {
      return;
      if (k.DEBUG) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      int j = this.uh.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.uh.get(i);
        if (locala.uD != null)
        {
          Fragment localFragment = locala.uD;
          localFragment.mBackStackNesting += paramInt;
          if (k.DEBUG) {
            new StringBuilder("Bump nesting of ").append(locala.uD).append(" to ").append(locala.uD.mBackStackNesting);
          }
        }
        i += 1;
      }
    }
  }
  
  final boolean Y(int paramInt)
  {
    int k = this.uh.size();
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.uh.get(i);
      if (locala.uD != null) {}
      for (int j = locala.uD.mContainerId; (j != 0) && (j == paramInt); j = 0) {
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
    if (j < this.uh.size())
    {
      locala = (a)this.uh.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locala.uC)
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
          paramArrayList.add(locala.uD);
          i = j;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(locala.uD);
          i = j;
          paramFragment = localFragment1;
          if (locala.uD == localFragment1)
          {
            this.uh.add(j, new a(9, locala.uD));
            i = j + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = locala.uD;
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
        this.uh.add(i, new a(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new a(3, localFragment3);
      paramFragment.uE = locala.uE;
      paramFragment.uG = locala.uG;
      paramFragment.uF = locala.uF;
      paramFragment.uH = locala.uH;
      this.uh.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.uh.remove(i);
        i -= 1;
        break;
      }
      locala.uC = 1;
      paramArrayList.add(localFragment2);
      break;
      this.uh.add(j, new a(9, localFragment1));
      i = j + 1;
      paramFragment = locala.uD;
      break;
      return localFragment1;
    }
  }
  
  public final o a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final o a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public final o a(Fragment paramFragment)
  {
    a(new a(3, paramFragment));
    return this;
  }
  
  public final o a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  final void a(Fragment.c paramc)
  {
    int i = 0;
    while (i < this.uh.size())
    {
      a locala = (a)this.uh.get(i);
      if (b(locala)) {
        locala.uD.setOnStartEnterTransitionListener(paramc);
      }
      i += 1;
    }
  }
  
  final void a(a parama)
  {
    this.uh.add(parama);
    parama.uE = this.uj;
    parama.uF = this.uk;
    parama.uG = this.ul;
    parama.uH = this.um;
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
      paramPrintWriter.println(this.ut);
      if (this.un != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.un));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.uo));
      }
      if ((this.uj != 0) || (this.uk != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.uj));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.uk));
      }
      if ((this.ul != 0) || (this.um != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.ul));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.um));
      }
      if ((this.uu != 0) || (this.uv != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.uu));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.uv);
      }
      if ((this.uw != 0) || (this.ux != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.uw));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.ux);
      }
    }
    if (!this.uh.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.uh.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)this.uh.get(i);
        String str;
        switch (locala.uC)
        {
        default: 
          str = "cmd=" + locala.uC;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locala.uD);
          if (paramBoolean)
          {
            if ((locala.uE != 0) || (locala.uF != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.uE));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.uF));
            }
            if ((locala.uG != 0) || (locala.uH != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.uG));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.uH));
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
    int i1 = this.uh.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (a)this.uh.get(k);
      if (((a)localObject).uD != null)
      {
        i = ((a)localObject).uD.mContainerId;
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
        int i2 = ((b)localObject).uh.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          a locala = (a)((b)localObject).uh.get(m);
          if (locala.uD != null) {}
          for (int n = locala.uD.mContainerId;; n = 0)
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
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.uh.size())
    {
      a locala = (a)this.uh.get(i);
      paramFragment = localFragment;
      switch (locala.uC)
      {
      default: 
        paramFragment = localFragment;
      }
      for (;;)
      {
        i += 1;
        localFragment = paramFragment;
        break;
        paramArrayList.remove(locala.uD);
        paramFragment = localFragment;
        continue;
        paramArrayList.add(locala.uD);
        paramFragment = localFragment;
        continue;
        paramFragment = locala.uD;
        continue;
        paramFragment = null;
      }
    }
    return localFragment;
  }
  
  public final o b(int paramInt, Fragment paramFragment)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    a(paramInt, paramFragment, null, 2);
    return this;
  }
  
  public final o b(Fragment paramFragment)
  {
    a(new a(5, paramFragment));
    return this;
  }
  
  public final o bI()
  {
    if (!this.ur) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.uq = true;
    this.mName = null;
    return this;
  }
  
  public final void bK()
  {
    if (this.uB != null)
    {
      int j = this.uB.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.uB.get(i)).run();
        i += 1;
      }
      this.uB = null;
    }
  }
  
  final void bL()
  {
    int j = this.uh.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.uh.get(i);
      Fragment localFragment = locala.uD;
      if (localFragment != null) {
        localFragment.setNextTransition(this.un, this.uo);
      }
      switch (locala.uC)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.uC);
      case 1: 
        localFragment.setNextAnim(locala.uE);
        this.ug.a(localFragment, false);
      }
      for (;;)
      {
        if ((!this.uA) && (locala.uC != 1) && (localFragment != null)) {
          this.ug.h(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(locala.uF);
        this.ug.j(localFragment);
        continue;
        localFragment.setNextAnim(locala.uF);
        k.k(localFragment);
        continue;
        localFragment.setNextAnim(locala.uE);
        k.l(localFragment);
        continue;
        localFragment.setNextAnim(locala.uF);
        this.ug.m(localFragment);
        continue;
        localFragment.setNextAnim(locala.uE);
        this.ug.n(localFragment);
        continue;
        this.ug.q(localFragment);
        continue;
        this.ug.q(null);
      }
    }
    if (!this.uA) {
      this.ug.k(this.ug.vy, true);
    }
  }
  
  public final o c(Fragment paramFragment)
  {
    a(new a(6, paramFragment));
    return this;
  }
  
  public final boolean c(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (k.DEBUG) {
      new StringBuilder("Run: ").append(this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.uq)
    {
      paramArrayList = this.ug;
      if (paramArrayList.vs == null) {
        paramArrayList.vs = new ArrayList();
      }
      paramArrayList.vs.add(this);
    }
    return true;
  }
  
  public final int commit()
  {
    return w(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return w(true);
  }
  
  public final void commitNow()
  {
    bJ();
    this.ug.b(this, false);
  }
  
  public final void commitNowAllowingStateLoss()
  {
    bJ();
    this.ug.b(this, true);
  }
  
  public final o d(Fragment paramFragment)
  {
    a(new a(7, paramFragment));
    return this;
  }
  
  public final o m(int paramInt1, int paramInt2)
  {
    this.uj = paramInt1;
    this.uk = paramInt2;
    this.ul = 0;
    this.um = 0;
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
  
  final void x(boolean paramBoolean)
  {
    int i = this.uh.size() - 1;
    if (i >= 0)
    {
      a locala = (a)this.uh.get(i);
      Fragment localFragment = locala.uD;
      if (localFragment != null) {
        localFragment.setNextTransition(k.ad(this.un), this.uo);
      }
      switch (locala.uC)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locala.uC);
      case 1: 
        localFragment.setNextAnim(locala.uH);
        this.ug.j(localFragment);
      }
      for (;;)
      {
        if ((!this.uA) && (locala.uC != 3) && (localFragment != null)) {
          this.ug.h(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(locala.uG);
        this.ug.a(localFragment, false);
        continue;
        localFragment.setNextAnim(locala.uG);
        k.l(localFragment);
        continue;
        localFragment.setNextAnim(locala.uH);
        k.k(localFragment);
        continue;
        localFragment.setNextAnim(locala.uG);
        this.ug.n(localFragment);
        continue;
        localFragment.setNextAnim(locala.uH);
        this.ug.m(localFragment);
        continue;
        this.ug.q(null);
        continue;
        this.ug.q(localFragment);
      }
    }
    if ((!this.uA) && (paramBoolean)) {
      this.ug.k(this.ug.vy, true);
    }
  }
  
  static final class a
  {
    int uC;
    Fragment uD;
    int uE;
    int uF;
    int uG;
    int uH;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.uC = paramInt;
      this.uD = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.b
 * JD-Core Version:    0.7.0.1
 */