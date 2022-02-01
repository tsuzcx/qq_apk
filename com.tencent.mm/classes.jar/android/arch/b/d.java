package android.arch.b;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<Key, Value>
{
  AtomicBoolean cj = new AtomicBoolean(false);
  CopyOnWriteArrayList<b> dX = new CopyOnWriteArrayList();
  
  public static abstract class a<Key, Value>
  {
    public abstract d<Key, Value> ap();
  }
  
  public static abstract interface b {}
  
  static final class c<T>
  {
    private final g.a<T> dV;
    final int dY;
    private final d dZ;
    final Object ea = new Object();
    Executor eb = null;
    private boolean ec = false;
    
    c(d paramd, g.a<T> parama)
    {
      this.dZ = paramd;
      this.dY = 0;
      this.eb = null;
      this.dV = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.d
 * JD-Core Version:    0.7.0.1
 */