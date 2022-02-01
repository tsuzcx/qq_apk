package android.arch.b;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class h<T>
  extends AbstractList<T>
{
  final Executor dB;
  final Executor eE;
  final j<T> eF;
  int eG = 0;
  T eH = null;
  private boolean eI = false;
  private boolean eJ = false;
  private int eK = 2147483647;
  private int eL = -2147483648;
  final AtomicBoolean eM = new AtomicBoolean(false);
  private final ArrayList<WeakReference<c>> eN = new ArrayList();
  final d ed;
  final a<T> ef;
  
  h(j<T> paramj, Executor paramExecutor1, Executor paramExecutor2, a<T> parama, d paramd)
  {
    this.eF = paramj;
    this.dB = paramExecutor1;
    this.eE = paramExecutor2;
    this.ef = parama;
    this.ed = paramd;
  }
  
  public final void a(c paramc)
  {
    int i = this.eN.size() - 1;
    while (i >= 0)
    {
      c localc = (c)((WeakReference)this.eN.get(i)).get();
      if ((localc == null) || (localc == paramc)) {
        this.eN.remove(i);
      }
      i -= 1;
    }
  }
  
  abstract void a(h<T> paramh, c paramc);
  
  public final void a(List<T> paramList, c paramc)
  {
    if ((paramList != null) && (paramList != this))
    {
      if (!paramList.isEmpty()) {
        break label90;
      }
      if (!this.eF.isEmpty()) {
        paramc.f(0, this.eF.size());
      }
    }
    for (;;)
    {
      int i = this.eN.size() - 1;
      while (i >= 0)
      {
        if ((c)((WeakReference)this.eN.get(i)).get() == null) {
          this.eN.remove(i);
        }
        i -= 1;
      }
      label90:
      a((h)paramList, paramc);
    }
    this.eN.add(new WeakReference(paramc));
  }
  
  abstract boolean ao();
  
  public abstract d<?, T> ap();
  
  public abstract Object aq();
  
  public final List<T> at()
  {
    if (isImmutable()) {
      return this;
    }
    return new l(this);
  }
  
  public T get(int paramInt)
  {
    Object localObject = this.eF.get(paramInt);
    if (localObject != null) {
      this.eH = localObject;
    }
    return localObject;
  }
  
  public boolean isDetached()
  {
    return this.eM.get();
  }
  
  public boolean isImmutable()
  {
    return isDetached();
  }
  
  public int size()
  {
    return this.eF.size();
  }
  
  public static abstract class a<T> {}
  
  public static final class b<Key, Value>
  {
    final d<Key, Value> dY;
    Executor eO;
    Key eP;
    final h.d ed;
    h.a ef;
    Executor eg;
    
    public b(d<Key, Value> paramd, h.d paramd1)
    {
      if (paramd == null) {
        throw new IllegalArgumentException("DataSource may not be null");
      }
      if (paramd1 == null) {
        throw new IllegalArgumentException("Config may not be null");
      }
      this.dY = paramd;
      this.ed = paramd1;
    }
  }
  
  public static abstract class c
  {
    public abstract void f(int paramInt1, int paramInt2);
    
    public abstract void g(int paramInt1, int paramInt2);
  }
  
  public static final class d
  {
    public final int eQ;
    public final boolean eR;
    public final int eS;
    public final int pageSize;
    
    private d(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.pageSize = paramInt1;
      this.eQ = paramInt2;
      this.eR = paramBoolean;
      this.eS = paramInt3;
    }
    
    public static final class a
    {
      private int eT = -1;
      private int eU = -1;
      private int eV = -1;
      private boolean eW = true;
      
      public final a au()
      {
        this.eT = 60;
        return this;
      }
      
      public final a av()
      {
        this.eU = 30;
        return this;
      }
      
      public final a aw()
      {
        this.eW = false;
        return this;
      }
      
      public final a ax()
      {
        this.eV = 15;
        return this;
      }
      
      public final h.d ay()
      {
        if (this.eT <= 0) {
          throw new IllegalArgumentException("Page size must be a positive number");
        }
        if (this.eU < 0) {
          this.eU = this.eT;
        }
        if (this.eV < 0) {
          this.eV = (this.eT * 3);
        }
        if ((!this.eW) && (this.eU == 0)) {
          throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        return new h.d(this.eT, this.eU, this.eW, this.eV, (byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.h
 * JD-Core Version:    0.7.0.1
 */