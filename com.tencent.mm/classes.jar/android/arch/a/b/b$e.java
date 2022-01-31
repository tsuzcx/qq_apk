package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

abstract class b$e<K, V>
  implements b.f<K, V>, Iterator<Map.Entry<K, V>>
{
  b.c<K, V> bR;
  b.c<K, V> bW;
  
  b$e(b.c<K, V> paramc1, b.c<K, V> paramc2)
  {
    this.bW = paramc2;
    this.bR = paramc1;
  }
  
  private b.c<K, V> ag()
  {
    if ((this.bR == this.bW) || (this.bW == null)) {
      return null;
    }
    return a(this.bR);
  }
  
  abstract b.c<K, V> a(b.c<K, V> paramc);
  
  abstract b.c<K, V> b(b.c<K, V> paramc);
  
  public final void c(b.c<K, V> paramc)
  {
    if ((this.bW == paramc) && (paramc == this.bR))
    {
      this.bR = null;
      this.bW = null;
    }
    if (this.bW == paramc) {
      this.bW = b(this.bW);
    }
    if (this.bR == paramc) {
      this.bR = ag();
    }
  }
  
  public boolean hasNext()
  {
    return this.bR != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.a.b.b.e
 * JD-Core Version:    0.7.0.1
 */