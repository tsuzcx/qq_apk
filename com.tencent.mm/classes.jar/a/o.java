package a;

import a.d.a.a;
import a.d.b.g;
import java.io.Serializable;

public final class o<T>
  implements b<T>, Serializable
{
  private a<? extends T> xob;
  private Object xoc;
  
  public o(a<? extends T> parama)
  {
    this.xob = parama;
    this.xoc = l.xog;
  }
  
  public final T getValue()
  {
    if (this.xoc == l.xog)
    {
      a locala = this.xob;
      if (locala == null) {
        g.cUk();
      }
      this.xoc = locala.invoke();
      this.xob = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.o
 * JD-Core Version:    0.7.0.1
 */