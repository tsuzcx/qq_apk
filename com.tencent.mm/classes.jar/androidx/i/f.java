package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public abstract class f<Key, Value>
  extends b<Key, Value>
{
  private final Object adE = new Object();
  private Key adF = null;
  private Key adG = null;
  
  final void a(int paramInt, boolean paramBoolean, Executor paramExecutor, g.a<Value> arg4)
  {
    ??? = new b(this, paramBoolean, ???);
    a(new c(paramInt, paramBoolean), ???);
    d.c localc = ???.adH;
    synchronized (localc.adn)
    {
      localc.ado = paramExecutor;
      return;
    }
  }
  
  public abstract void a(c<Key> paramc, a<Key, Value> parama);
  
  public static abstract class a<Key, Value> {}
  
  static final class b<Key, Value>
    extends f.a<Key, Value>
  {
    final d.c<Value> adH;
    private final f<Key, Value> adI;
    private final boolean adJ;
    
    b(f<Key, Value> paramf, boolean paramBoolean, g.a<Value> parama)
    {
      AppMethodBeat.i(219475);
      this.adH = new d.c(paramf, parama);
      this.adI = paramf;
      this.adJ = paramBoolean;
      AppMethodBeat.o(219475);
    }
  }
  
  public static final class c<Key>
  {
    public final int adK;
    public final boolean adL;
    
    public c(int paramInt, boolean paramBoolean)
    {
      this.adK = paramInt;
      this.adL = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.f
 * JD-Core Version:    0.7.0.1
 */