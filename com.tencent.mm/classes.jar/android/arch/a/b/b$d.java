package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

public final class b$d
  implements b.f<K, V>, Iterator<Map.Entry<K, V>>
{
  private b.c<K, V> bP;
  private boolean bQ = true;
  
  private b$d(b paramb) {}
  
  public final void c(b.c<K, V> paramc)
  {
    if (paramc == this.bP)
    {
      this.bP = this.bP.bO;
      if (this.bP != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.bQ = bool;
      return;
    }
  }
  
  public final boolean hasNext()
  {
    if (this.bQ) {
      if (b.a(this.bR) == null) {}
    }
    while ((this.bP != null) && (this.bP.bN != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.arch.a.b.b.d
 * JD-Core Version:    0.7.0.1
 */