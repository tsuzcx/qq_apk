package androidx.fragment.app;

import androidx.lifecycle.j.b;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class r
{
  int bBj;
  int bBk;
  CharSequence bBl;
  int bBm;
  CharSequence bBn;
  ArrayList<String> bBo;
  ArrayList<String> bBp;
  boolean bBq = false;
  int bCa;
  int bCb;
  int bCc;
  int bCd;
  ArrayList<a> bDF = new ArrayList();
  boolean bDG;
  boolean bDH = true;
  ArrayList<Runnable> bDI;
  private final ClassLoader mClassLoader;
  private final f mFragmentFactory;
  String mName;
  
  r(f paramf, ClassLoader paramClassLoader)
  {
    this.mFragmentFactory = paramf;
    this.mClassLoader = paramClassLoader;
  }
  
  public abstract int FW();
  
  public abstract int FX();
  
  public abstract void FY();
  
  public abstract void FZ();
  
  public final r GC()
  {
    if (this.bDG) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.bDH = false;
    return this;
  }
  
  public final r a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final r a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public r a(Fragment paramFragment)
  {
    b(new a(3, paramFragment));
    return this;
  }
  
  public r a(Fragment paramFragment, j.b paramb)
  {
    b(new a(paramFragment, paramb));
    return this;
  }
  
  public final r a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
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
    b(new a(paramInt2, paramFragment));
  }
  
  public final r aI(String paramString)
  {
    if (!this.bDH) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.bDG = true;
    this.mName = paramString;
    return this;
  }
  
  public final r aJ(int paramInt1, int paramInt2)
  {
    return r(paramInt1, paramInt2, 0, 0);
  }
  
  public final r b(int paramInt, Fragment paramFragment)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    a(paramInt, paramFragment, null, 2);
    return this;
  }
  
  public r b(Fragment paramFragment)
  {
    b(new a(4, paramFragment));
    return this;
  }
  
  final void b(a parama)
  {
    this.bDF.add(parama);
    parama.bCa = this.bCa;
    parama.bCb = this.bCb;
    parama.bCc = this.bCc;
    parama.bCd = this.bCd;
  }
  
  public r c(Fragment paramFragment)
  {
    b(new a(5, paramFragment));
    return this;
  }
  
  public r d(Fragment paramFragment)
  {
    b(new a(6, paramFragment));
    return this;
  }
  
  public final r r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bCa = paramInt1;
    this.bCb = paramInt2;
    this.bCc = paramInt3;
    this.bCd = paramInt4;
    return this;
  }
  
  public final r r(Fragment paramFragment)
  {
    b(new a(7, paramFragment));
    return this;
  }
  
  static final class a
  {
    int bCa;
    int bCb;
    int bCc;
    int bCd;
    int bDJ;
    j.b bDK;
    j.b bDL;
    Fragment bDv;
    
    a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.bDJ = paramInt;
      this.bDv = paramFragment;
      this.bDK = j.b.bHk;
      this.bDL = j.b.bHk;
    }
    
    a(Fragment paramFragment, j.b paramb)
    {
      this.bDJ = 10;
      this.bDv = paramFragment;
      this.bDK = paramFragment.mMaxState;
      this.bDL = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.r
 * JD-Core Version:    0.7.0.1
 */