package a.a;

import a.f.b.j;
import a.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"})
public abstract class b<E>
  extends a<E>
  implements a.f.b.a.a, List<E>
{
  public static final b.a BMk = new b.a((byte)0);
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == (b)this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    Object localObject = (Collection)this;
    paramObject = (Collection)paramObject;
    j.q(localObject, "c");
    j.q(paramObject, "other");
    if (((Collection)localObject).size() != paramObject.size()) {
      return false;
    }
    paramObject = paramObject.iterator();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((j.e(((Iterator)localObject).next(), paramObject.next()) ^ true)) {
        return false;
      }
    }
    return true;
  }
  
  public abstract E get(int paramInt);
  
  public int hashCode()
  {
    Object localObject1 = (Collection)this;
    j.q(localObject1, "c");
    int i = 1;
    localObject1 = ((Collection)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 != null) {}
      for (int j = localObject2.hashCode();; j = 0)
      {
        i = j + i * 31;
        break;
      }
    }
    return i;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (j.e(localIterator.next(), paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public Iterator<E> iterator()
  {
    return (Iterator)new b.b(this);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (j.e(localListIterator.previous(), paramObject)) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  public ListIterator<E> listIterator()
  {
    return (ListIterator)new b.c(this, 0);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return (ListIterator)new b.c(this, paramInt);
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return (List)new b.d(this, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.a.b
 * JD-Core Version:    0.7.0.1
 */