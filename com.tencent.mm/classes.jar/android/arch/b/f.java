package android.arch.b;

import java.util.concurrent.Executor;

public abstract class f<Key, Value>
  extends b<Key, Value>
{
  private final Object es = new Object();
  private Key et = null;
  private Key eu = null;
  
  final void a(int paramInt, boolean paramBoolean, Executor paramExecutor, g.a<Value> arg4)
  {
    ??? = new b(this, paramBoolean, ???);
    a(new c(paramInt, paramBoolean), ???);
    d.c localc = ???.ev;
    synchronized (localc.ea)
    {
      localc.eb = paramExecutor;
      return;
    }
  }
  
  public abstract void a(c<Key> paramc, a<Key, Value> parama);
  
  public static abstract class a<Key, Value> {}
  
  static final class b<Key, Value>
    extends f.a<Key, Value>
  {
    final d.c<Value> ev;
    private final f<Key, Value> ew;
    private final boolean ex;
    
    b(f<Key, Value> paramf, boolean paramBoolean, g.a<Value> parama)
    {
      this.ev = new d.c(paramf, parama);
      this.ew = paramf;
      this.ex = paramBoolean;
    }
  }
  
  public static final class c<Key>
  {
    public final int ey;
    public final boolean ez;
    
    public c(int paramInt, boolean paramBoolean)
    {
      this.ey = paramInt;
      this.ez = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.arch.b.f
 * JD-Core Version:    0.7.0.1
 */