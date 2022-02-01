package androidx.compose.ui.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
  implements List<c>, a
{
  public final boolean addAll(int paramInt, Collection<? extends c> paramCollection)
  {
    AppMethodBeat.i(205344);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205344);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends c> paramCollection)
  {
    AppMethodBeat.i(205350);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205350);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(205356);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205356);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(205393);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(205393);
      return false;
    }
    s.u((c)paramObject, "element");
    AppMethodBeat.o(205393);
    throw null;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205316);
    s.u(paramCollection, "elements");
    AppMethodBeat.o(205316);
    throw null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(205403);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(205403);
      return -1;
    }
    s.u((c)paramObject, "element");
    AppMethodBeat.o(205403);
    throw null;
  }
  
  public final boolean isEmpty()
  {
    throw null;
  }
  
  public final Iterator<c> iterator()
  {
    throw null;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(205408);
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(205408);
      return -1;
    }
    s.u((c)paramObject, "element");
    AppMethodBeat.o(205408);
    throw null;
  }
  
  public final ListIterator<c> listIterator()
  {
    throw null;
  }
  
  public final ListIterator<c> listIterator(int paramInt)
  {
    throw null;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(205361);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205361);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205367);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205367);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<c> paramUnaryOperator)
  {
    AppMethodBeat.i(205374);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205374);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205379);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205379);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super c> paramComparator)
  {
    AppMethodBeat.i(205385);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205385);
    throw paramComparator;
  }
  
  public final List<c> subList(int paramInt1, int paramInt2)
  {
    throw null;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(205440);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(205440);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(205434);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(205434);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.m.b.e
 * JD-Core Version:    0.7.0.1
 */