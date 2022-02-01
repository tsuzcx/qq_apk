package android.arch.b;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<Key, Value>
{
  AtomicBoolean cj = new AtomicBoolean(false);
  CopyOnWriteArrayList<b> dW = new CopyOnWriteArrayList();
  
  public static abstract class a<Key, Value>
  {
    public abstract d<Key, Value> ar();
  }
  
  public static abstract interface b {}
  
  static final class c<T>
  {
    private final g.a<T> dU;
    final int dX;
    private final d dY;
    final Object dZ = new Object();
    Executor ea = null;
    private boolean eb = false;
    
    c(d paramd, g.a<T> parama)
    {
      this.dY = paramd;
      this.dX = 0;
      this.ea = null;
      this.dU = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.d
 * JD-Core Version:    0.7.0.1
 */