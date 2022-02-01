package androidx.compose.ui.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "localeList", "", "(Ljava/util/List;)V", "getLocaleList", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "equals", "other", "", "get", "i", "hashCode", "isEmpty", "iterator", "", "toString", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements Collection<d>, a
{
  public static final a bdD;
  public final List<d> bdE;
  private final int size;
  
  static
  {
    AppMethodBeat.i(205137);
    bdD = new a((byte)0);
    AppMethodBeat.o(205137);
  }
  
  public e(List<d> paramList)
  {
    AppMethodBeat.i(205133);
    this.bdE = paramList;
    this.size = this.bdE.size();
    AppMethodBeat.o(205133);
  }
  
  public final d BK()
  {
    AppMethodBeat.i(205144);
    d locald = (d)this.bdE.get(0);
    AppMethodBeat.o(205144);
    return locald;
  }
  
  public final boolean addAll(Collection<? extends d> paramCollection)
  {
    AppMethodBeat.i(205177);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205177);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(205182);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205182);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(205202);
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(205202);
      return false;
    }
    paramObject = (d)paramObject;
    s.u(paramObject, "element");
    boolean bool = this.bdE.contains(paramObject);
    AppMethodBeat.o(205202);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205151);
    s.u(paramCollection, "elements");
    boolean bool = this.bdE.containsAll(paramCollection);
    AppMethodBeat.o(205151);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205167);
    if (this == paramObject)
    {
      AppMethodBeat.o(205167);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(205167);
      return false;
    }
    if (!s.p(this.bdE, ((e)paramObject).bdE))
    {
      AppMethodBeat.o(205167);
      return false;
    }
    AppMethodBeat.o(205167);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205171);
    int i = this.bdE.hashCode();
    AppMethodBeat.o(205171);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(205157);
    boolean bool = this.bdE.isEmpty();
    AppMethodBeat.o(205157);
    return bool;
  }
  
  public final Iterator<d> iterator()
  {
    AppMethodBeat.i(205163);
    Iterator localIterator = this.bdE.iterator();
    AppMethodBeat.o(205163);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(205188);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205188);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205190);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205190);
    throw paramCollection;
  }
  
  public final boolean removeIf(Predicate<? super d> paramPredicate)
  {
    AppMethodBeat.i(205194);
    paramPredicate = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205194);
    throw paramPredicate;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(205198);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(205198);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(205219);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(205219);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(205214);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(205214);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205173);
    String str = "LocaleList(localeList=" + this.bdE + ')';
    AppMethodBeat.o(205173);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static e BL()
    {
      AppMethodBeat.i(205143);
      Object localObject1 = h.BM().BI();
      ArrayList localArrayList = new ArrayList(((List)localObject1).size());
      int i = 0;
      int k = ((List)localObject1).size() - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        Object localObject2 = ((List)localObject1).get(i);
        ((Collection)localArrayList).add(new d((f)localObject2));
        if (j > k)
        {
          localObject1 = new e((List)localArrayList);
          AppMethodBeat.o(205143);
          return localObject1;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.e
 * JD-Core Version:    0.7.0.1
 */