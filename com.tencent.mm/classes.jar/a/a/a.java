package a.a;

import a.f.a.b;
import a.f.b.f;
import a.l;
import a.v;
import java.util.Collection;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"})
public abstract class a<E>
  implements a.f.b.a.a, Collection<E>
{
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    if (!((Collection)this).isEmpty())
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        if (a.f.b.j.e(localIterator.next(), paramObject)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    a.f.b.j.q(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public abstract int getSize();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public Object[] toArray()
  {
    return f.h((Collection)this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    a.f.b.j.q(paramArrayOfT, "array");
    paramArrayOfT = f.a((Collection)this, paramArrayOfT);
    if (paramArrayOfT == null) {
      throw new v("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return paramArrayOfT;
  }
  
  public String toString()
  {
    return j.a(this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, (b)new a.a(this), 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.a.a
 * JD-Core Version:    0.7.0.1
 */