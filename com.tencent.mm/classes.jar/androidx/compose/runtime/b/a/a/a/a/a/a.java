package androidx.compose.runtime.b.a.a.a.a.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "E", "", "index", "", "size", "(II)V", "getIndex", "()I", "setIndex", "(I)V", "getSize", "setSize", "checkHasNext", "", "checkHasNext$runtime_release", "checkHasPrevious", "checkHasPrevious$runtime_release", "hasNext", "", "hasPrevious", "nextIndex", "previousIndex", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<E>
  implements ListIterator<E>, kotlin.g.b.a.a
{
  private int index;
  private int size;
  
  public a(int paramInt1, int paramInt2)
  {
    this.index = paramInt1;
    this.size = paramInt2;
  }
  
  public void add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public boolean hasNext()
  {
    return this.index < this.size;
  }
  
  public boolean hasPrevious()
  {
    return this.index > 0;
  }
  
  public E next()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public int nextIndex()
  {
    return this.index;
  }
  
  public int previousIndex()
  {
    return this.index - 1;
  }
  
  public final void qv()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
  }
  
  public final void qw()
  {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void set(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void setSize(int paramInt)
  {
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */