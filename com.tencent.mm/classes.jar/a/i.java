package a;

import a.d.a.a;
import a.d.b.g;
import java.io.Serializable;

public final class i<T>
  implements b<T>, Serializable
{
  private final Object lock;
  private a<? extends T> xob;
  private volatile Object xoc;
  
  private i(a<? extends T> parama)
  {
    this.xob = parama;
    this.xoc = l.xog;
    this.lock = this;
  }
  
  public final T getValue()
  {
    Object localObject1 = this.xoc;
    if (localObject1 != l.xog) {
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.xoc;
      l locall = l.xog;
      if (localObject1 != locall) {
        return localObject1;
      }
      localObject1 = this.xob;
      if (localObject1 == null) {
        g.cUk();
      }
      localObject1 = ((a)localObject1).invoke();
      this.xoc = localObject1;
      this.xob = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.i
 * JD-Core Version:    0.7.0.1
 */