package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

public final class b$d
  implements b.f<K, V>, Iterator<Map.Entry<K, V>>
{
  private b.c<K, V> bT;
  private boolean bU = true;
  
  private b$d(b paramb) {}
  
  public final void c(b.c<K, V> paramc)
  {
    if (paramc == this.bT)
    {
      this.bT = this.bT.bS;
      if (this.bT != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.bU = bool;
      return;
    }
  }
  
  public final boolean hasNext()
  {
    if (this.bU) {
      if (b.a(this.bV) == null) {}
    }
    while ((this.bT != null) && (this.bT.bR != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.a.b.b.d
 * JD-Core Version:    0.7.0.1
 */