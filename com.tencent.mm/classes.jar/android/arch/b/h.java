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
  final Executor dC;
  final Executor eF;
  final j<T> eG;
  int eH = 0;
  T eI = null;
  private boolean eJ = false;
  private boolean eK = false;
  private int eL = 2147483647;
  private int eM = -2147483648;
  final AtomicBoolean eN = new AtomicBoolean(false);
  private final ArrayList<WeakReference<c>> eO = new ArrayList();
  final d ee;
  final a<T> eg;
  
  h(j<T> paramj, Executor paramExecutor1, Executor paramExecutor2, a<T> parama, d paramd)
  {
    this.eG = paramj;
    this.dC = paramExecutor1;
    this.eF = paramExecutor2;
    this.eg = parama;
    this.ee = paramd;
  }
  
  public final void a(c paramc)
  {
    int i = this.eO.size() - 1;
    while (i >= 0)
    {
      c localc = (c)((WeakReference)this.eO.get(i)).get();
      if ((localc == null) || (localc == paramc)) {
        this.eO.remove(i);
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
      if (!this.eG.isEmpty()) {
        paramc.f(0, this.eG.size());
      }
    }
    for (;;)
    {
      int i = this.eO.size() - 1;
      while (i >= 0)
      {
        if ((c)((WeakReference)this.eO.get(i)).get() == null) {
          this.eO.remove(i);
        }
        i -= 1;
      }
      label90:
      a((h)paramList, paramc);
    }
    this.eO.add(new WeakReference(paramc));
  }
  
  abstract boolean am();
  
  public abstract d<?, T> an();
  
  public abstract Object ao();
  
  public final List<T> ar()
  {
    if (isImmutable()) {
      return this;
    }
    return new l(this);
  }
  
  public T get(int paramInt)
  {
    Object localObject = this.eG.get(paramInt);
    if (localObject != null) {
      this.eI = localObject;
    }
    return localObject;
  }
  
  public boolean isDetached()
  {
    return this.eN.get();
  }
  
  public boolean isImmutable()
  {
    return isDetached();
  }
  
  public int size()
  {
    return this.eG.size();
  }
  
  public static abstract class a<T> {}
  
  public static final class b<Key, Value>
  {
    final d<Key, Value> dZ;
    Executor eP;
    Key eQ;
    final h.d ee;
    h.a eg;
    Executor eh;
    
    public b(d<Key, Value> paramd, h.d paramd1)
    {
      if (paramd == null) {
        throw new IllegalArgumentException("DataSource may not be null");
      }
      if (paramd1 == null) {
        throw new IllegalArgumentException("Config may not be null");
      }
      this.dZ = paramd;
      this.ee = paramd1;
    }
  }
  
  public static abstract class c
  {
    public abstract void f(int paramInt1, int paramInt2);
    
    public abstract void g(int paramInt1, int paramInt2);
  }
  
  public static final class d
  {
    public final int eR;
    public final boolean eS;
    public final int eT;
    public final int pageSize;
    
    private d(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.pageSize = paramInt1;
      this.eR = paramInt2;
      this.eS = paramBoolean;
      this.eT = paramInt3;
    }
    
    public static final class a
    {
      private int eU = -1;
      private int eV = -1;
      private int eW = -1;
      private boolean eX = true;
      
      public final a as()
      {
        this.eU = 60;
        return this;
      }
      
      public final a at()
      {
        this.eV = 30;
        return this;
      }
      
      public final a au()
      {
        this.eX = false;
        return this;
      }
      
      public final a av()
      {
        this.eW = 15;
        return this;
      }
      
      public final h.d aw()
      {
        if (this.eU <= 0) {
          throw new IllegalArgumentException("Page size must be a positive number");
        }
        if (this.eV < 0) {
          this.eV = this.eU;
        }
        if (this.eW < 0) {
          this.eW = (this.eU * 3);
        }
        if ((!this.eX) && (this.eV == 0)) {
          throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        return new h.d(this.eU, this.eV, this.eX, this.eW, (byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.arch.b.h
 * JD-Core Version:    0.7.0.1
 */