package a.a;

import a.d.b.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class k
  extends j
{
  public static final <T, A extends Appendable> A a(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    g.k(paramIterable, "$receiver");
    g.k(paramA, "buffer");
    g.k(paramCharSequence1, "separator");
    g.k(paramCharSequence2, "prefix");
    g.k(paramCharSequence3, "postfix");
    g.k(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramCharSequence2 = paramIterable.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      a.h.e.a(paramA, paramCharSequence2);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> paramIterable, C paramC)
  {
    g.k(paramIterable, "$receiver");
    g.k(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    return paramC;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable)
  {
    g.k(paramIterable, "$receiver");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        return e.e((Collection)paramIterable);
      case 0: 
        return (List)m.xol;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next()) {
        return e.cw(paramIterable);
      }
    }
    paramIterable = e.d(paramIterable);
    g.k(paramIterable, "$receiver");
    switch (paramIterable.size())
    {
    default: 
      return paramIterable;
    case 0: 
      return (List)m.xol;
    }
    return e.cw(paramIterable.get(0));
  }
  
  public static final <T> List<T> d(Iterable<? extends T> paramIterable)
  {
    g.k(paramIterable, "$receiver");
    if ((paramIterable instanceof Collection)) {
      return e.e((Collection)paramIterable);
    }
    return (List)e.a(paramIterable, (Collection)new ArrayList());
  }
  
  public static final <T> List<T> e(Collection<? extends T> paramCollection)
  {
    g.k(paramCollection, "$receiver");
    return (List)new ArrayList(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.a.k
 * JD-Core Version:    0.7.0.1
 */