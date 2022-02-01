package android.arch.b;

import java.util.concurrent.Executor;

public abstract class f<Key, Value>
  extends b<Key, Value>
{
  private final Object er = new Object();
  private Key es = null;
  private Key et = null;
  
  final void a(int paramInt, boolean paramBoolean, Executor paramExecutor, g.a<Value> arg4)
  {
    ??? = new b(this, paramBoolean, ???);
    a(new c(paramInt, paramBoolean), ???);
    d.c localc = ???.eu;
    synchronized (localc.dZ)
    {
      localc.ea = paramExecutor;
      return;
    }
  }
  
  public abstract void a(c<Key> paramc, a<Key, Value> parama);
  
  public static abstract class a<Key, Value> {}
  
  static final class b<Key, Value>
    extends f.a<Key, Value>
  {
    final d.c<Value> eu;
    private final f<Key, Value> ev;
    private final boolean ew;
    
    b(f<Key, Value> paramf, boolean paramBoolean, g.a<Value> parama)
    {
      this.eu = new d.c(paramf, parama);
      this.ev = paramf;
      this.ew = paramBoolean;
    }
  }
  
  public static final class c<Key>
  {
    public final int ex;
    public final boolean ey;
    
    public c(int paramInt, boolean paramBoolean)
    {
      this.ex = paramInt;
      this.ey = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.f
 * JD-Core Version:    0.7.0.1
 */