package a.a;

import a.f.a.b;
import a.f.b.z;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "shuffle", "random", "Lkotlin/random/Random;", "shuffled", "", "kotlin-stdlib"}, eaR=1)
public class q
  extends p
{
  public static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(56202);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramb, "predicate");
    boolean bool = a(paramIterable, paramb, false);
    AppMethodBeat.o(56202);
    return bool;
  }
  
  private static final <T> boolean a(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(142962);
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    if (paramIterable.hasNext())
    {
      if (((Boolean)paramb.S(paramIterable.next())).booleanValue() != paramBoolean) {
        break label63;
      }
      paramIterable.remove();
      bool = true;
    }
    label63:
    for (;;)
    {
      break;
      AppMethodBeat.o(142962);
      return bool;
    }
  }
  
  public static final <T> boolean a(Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56201);
    a.f.b.j.q(paramCollection, "receiver$0");
    a.f.b.j.q(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      bool = paramCollection.addAll((Collection)paramIterable);
      AppMethodBeat.o(56201);
      return bool;
    }
    boolean bool = false;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (paramCollection.add(paramIterable.next())) {
        bool = true;
      }
    }
    AppMethodBeat.o(56201);
    return bool;
  }
  
  public static final <T> boolean a(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(142963);
    a.f.b.j.q(paramList, "receiver$0");
    a.f.b.j.q(paramb, "predicate");
    boolean bool = b(paramList, paramb);
    AppMethodBeat.o(142963);
    return bool;
  }
  
  private static final <T> boolean b(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(142964);
    if (!(paramList instanceof RandomAccess))
    {
      if (paramList == null)
      {
        paramList = new v("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        AppMethodBeat.o(142964);
        throw paramList;
      }
      boolean bool = a(z.di(paramList), paramb, true);
      AppMethodBeat.o(142964);
      return bool;
    }
    int m = j.fO(paramList);
    int i;
    if (m >= 0)
    {
      int k = 0;
      for (j = 0;; j = i)
      {
        Object localObject = paramList.get(k);
        i = j;
        if (((Boolean)paramb.S(localObject)).booleanValue() != true)
        {
          if (j != k) {
            paramList.set(j, localObject);
          }
          i = j + 1;
        }
        j = i;
        if (k == m) {
          break;
        }
        k += 1;
      }
    }
    int j = 0;
    if (j < paramList.size())
    {
      i = j.fO(paramList);
      if (i >= j) {
        for (;;)
        {
          paramList.remove(i);
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(142964);
      return true;
    }
    AppMethodBeat.o(142964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.a.q
 * JD-Core Version:    0.7.0.1
 */