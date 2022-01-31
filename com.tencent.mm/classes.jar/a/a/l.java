package a.a;

import a.d.b.a.a;
import java.util.ListIterator;

public final class l
  implements a, ListIterator
{
  public static final l xok = new l();
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return false;
  }
  
  public final int nextIndex()
  {
    return 0;
  }
  
  public final int previousIndex()
  {
    return -1;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.l
 * JD-Core Version:    0.7.0.1
 */