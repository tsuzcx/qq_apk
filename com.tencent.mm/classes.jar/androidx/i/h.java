package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class h<T>
  extends AbstractList<T>
{
  final Executor acO;
  final Executor adS;
  final j<T> adT;
  int adU = 0;
  T adV = null;
  private boolean adW = false;
  private boolean adX = false;
  private int adY = 2147483647;
  private int adZ = -2147483648;
  final d adr;
  final a<T> adt;
  private final AtomicBoolean aea = new AtomicBoolean(false);
  private final ArrayList<WeakReference<c>> aeb = new ArrayList();
  
  h(j<T> paramj, Executor paramExecutor1, Executor paramExecutor2, a<T> parama, d paramd)
  {
    this.adT = paramj;
    this.acO = paramExecutor1;
    this.adS = paramExecutor2;
    this.adt = parama;
    this.adr = paramd;
  }
  
  public final void a(c paramc)
  {
    int i = this.aeb.size() - 1;
    while (i >= 0)
    {
      c localc = (c)((WeakReference)this.aeb.get(i)).get();
      if ((localc == null) || (localc == paramc)) {
        this.aeb.remove(i);
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
      if (!this.adT.isEmpty()) {
        paramc.W(0, this.adT.size());
      }
    }
    for (;;)
    {
      int i = this.aeb.size() - 1;
      while (i >= 0)
      {
        if ((c)((WeakReference)this.aeb.get(i)).get() == null) {
          this.aeb.remove(i);
        }
        i -= 1;
      }
      label90:
      a((h)paramList, paramc);
    }
    this.aeb.add(new WeakReference(paramc));
  }
  
  public final void detach()
  {
    this.aea.set(true);
  }
  
  public T get(int paramInt)
  {
    Object localObject = this.adT.get(paramInt);
    if (localObject != null) {
      this.adV = localObject;
    }
    return localObject;
  }
  
  public boolean isDetached()
  {
    return this.aea.get();
  }
  
  public boolean isImmutable()
  {
    return isDetached();
  }
  
  public abstract Object jA();
  
  public final List<T> jD()
  {
    if (isImmutable()) {
      return this;
    }
    return new l(this);
  }
  
  abstract boolean jy();
  
  public abstract d<?, T> jz();
  
  public int size()
  {
    return this.adT.size();
  }
  
  public static abstract class a<T> {}
  
  public static final class b<Key, Value>
  {
    final d<Key, Value> adm;
    final h.d adr;
    h.a adt;
    Executor adu;
    Executor aec;
    Key aed;
    
    public b(d<Key, Value> paramd, h.d paramd1)
    {
      AppMethodBeat.i(219505);
      if (paramd == null)
      {
        paramd = new IllegalArgumentException("DataSource may not be null");
        AppMethodBeat.o(219505);
        throw paramd;
      }
      if (paramd1 == null)
      {
        paramd = new IllegalArgumentException("Config may not be null");
        AppMethodBeat.o(219505);
        throw paramd;
      }
      this.adm = paramd;
      this.adr = paramd1;
      AppMethodBeat.o(219505);
    }
  }
  
  public static abstract class c
  {
    public abstract void W(int paramInt1, int paramInt2);
    
    public abstract void X(int paramInt1, int paramInt2);
  }
  
  public static final class d
  {
    public final int aee;
    public final boolean aef;
    public final int aeg;
    public final int pageSize;
    
    private d(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.pageSize = paramInt1;
      this.aee = paramInt2;
      this.aef = paramBoolean;
      this.aeg = paramInt3;
    }
    
    public static final class a
    {
      private int aeh = -1;
      private int aei = -1;
      private int aej = -1;
      private boolean aek = true;
      
      public final a jE()
      {
        this.aeh = 60;
        return this;
      }
      
      public final a jF()
      {
        this.aei = 30;
        return this;
      }
      
      public final a jG()
      {
        this.aek = false;
        return this;
      }
      
      public final a jH()
      {
        this.aej = 15;
        return this;
      }
      
      public final h.d jI()
      {
        AppMethodBeat.i(219518);
        if (this.aeh <= 0)
        {
          localObject = new IllegalArgumentException("Page size must be a positive number");
          AppMethodBeat.o(219518);
          throw ((Throwable)localObject);
        }
        if (this.aei < 0) {
          this.aei = this.aeh;
        }
        if (this.aej < 0) {
          this.aej = (this.aeh * 3);
        }
        if ((!this.aek) && (this.aei == 0))
        {
          localObject = new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
          AppMethodBeat.o(219518);
          throw ((Throwable)localObject);
        }
        Object localObject = new h.d(this.aeh, this.aei, this.aek, this.aej, (byte)0);
        AppMethodBeat.o(219518);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.h
 * JD-Core Version:    0.7.0.1
 */