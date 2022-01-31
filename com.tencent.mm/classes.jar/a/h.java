package a;

import a.d.a.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class h<T>
  implements b<T>, Serializable
{
  private static final AtomicReferenceFieldUpdater<h<?>, Object> xoe = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "xoc");
  public static final h.a xof = new h.a((byte)0);
  private volatile a<? extends T> xob;
  private volatile Object xoc;
  private final Object xod;
  
  public h(a<? extends T> parama)
  {
    this.xob = parama;
    this.xoc = l.xog;
    this.xod = l.xog;
  }
  
  public final T getValue()
  {
    Object localObject = this.xoc;
    if (localObject != l.xog) {
      return localObject;
    }
    localObject = this.xob;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (xoe.compareAndSet(this, l.xog, localObject))
      {
        this.xob = null;
        return localObject;
      }
    }
    return this.xoc;
  }
  
  public final String toString()
  {
    if (this.xoc != l.xog) {}
    for (int i = 1; i != 0; i = 0) {
      return String.valueOf(getValue());
    }
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.h
 * JD-Core Version:    0.7.0.1
 */