package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<Key, Value>
{
  AtomicBoolean ZF = new AtomicBoolean(false);
  CopyOnWriteArrayList<b> adk = new CopyOnWriteArrayList();
  
  public static abstract class a<Key, Value>
  {
    public abstract d<Key, Value> jB();
  }
  
  public static abstract interface b {}
  
  static final class c<T>
  {
    private final g.a<T> adi;
    final int adl;
    private final d adm;
    final Object adn;
    Executor ado;
    private boolean adp;
    
    c(d paramd, g.a<T> parama)
    {
      AppMethodBeat.i(219471);
      this.adn = new Object();
      this.ado = null;
      this.adp = false;
      this.adm = paramd;
      this.adl = 0;
      this.ado = null;
      this.adi = parama;
      AppMethodBeat.o(219471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.d
 * JD-Core Version:    0.7.0.1
 */