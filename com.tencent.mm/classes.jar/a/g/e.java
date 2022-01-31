package a.g;

import a.d.a.b;
import java.util.Iterator;

public final class e<T, R>
  implements a<R>
{
  final a<T> xoG;
  final b<T, R> xoH;
  
  public e(a<? extends T> parama, b<? super T, ? extends R> paramb)
  {
    this.xoG = parama;
    this.xoH = paramb;
  }
  
  public final Iterator<R> iterator()
  {
    return (Iterator)new e.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.g.e
 * JD-Core Version:    0.7.0.1
 */