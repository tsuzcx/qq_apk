package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "list", "", "<set-?>", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "([Ljava/lang/Object;)Z", "", "", "any", "predicate", "Lkotlin/Function1;", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "minusAssign", "(Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "reversedAny", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "throwNoSuchElementException", "", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T>
  implements RandomAccess
{
  public static final int Ue = 8;
  public T[] aqq;
  private List<T> list;
  public int size;
  
  public e(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202061);
    this.aqq = paramArrayOfT;
    this.size = 0;
    AppMethodBeat.o(202061);
  }
  
  private void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(202072);
    Object[] arrayOfObject = this.aqq;
    if (arrayOfObject.length < paramInt)
    {
      arrayOfObject = Arrays.copyOf(arrayOfObject, Math.max(paramInt, arrayOfObject.length * 2));
      s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      this.aqq = arrayOfObject;
    }
    AppMethodBeat.o(202072);
  }
  
  public final void a(Comparator<T> paramComparator)
  {
    AppMethodBeat.i(202188);
    s.u(paramComparator, "comparator");
    Object[] arrayOfObject = this.aqq;
    int i = this.size;
    s.u(arrayOfObject, "$this$sortWith");
    s.u(paramComparator, "comparator");
    Arrays.sort(arrayOfObject, 0, i, paramComparator);
    AppMethodBeat.o(202188);
  }
  
  public final boolean a(int paramInt, e<T> parame)
  {
    AppMethodBeat.i(202114);
    s.u(parame, "elements");
    if (parame.isEmpty())
    {
      AppMethodBeat.o(202114);
      return false;
    }
    ensureCapacity(this.size + parame.size);
    Object[] arrayOfObject = this.aqq;
    if (paramInt != this.size) {
      k.a(arrayOfObject, arrayOfObject, parame.size + paramInt, paramInt, this.size);
    }
    k.a(parame.aqq, arrayOfObject, paramInt, 0, parame.size);
    this.size += parame.size;
    AppMethodBeat.o(202114);
    return true;
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(202101);
    ensureCapacity(this.size + 1);
    Object[] arrayOfObject = this.aqq;
    if (paramInt != this.size) {
      k.a(arrayOfObject, arrayOfObject, paramInt + 1, paramInt, this.size);
    }
    arrayOfObject[paramInt] = paramT;
    this.size += 1;
    AppMethodBeat.o(202101);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(202089);
    ensureCapacity(this.size + 1);
    this.aqq[this.size] = paramT;
    this.size += 1;
    AppMethodBeat.o(202089);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202125);
    s.u(paramCollection, "elements");
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(202125);
      return false;
    }
    ensureCapacity(this.size + paramCollection.size());
    Object[] arrayOfObject = this.aqq;
    if (paramInt != this.size) {
      k.a(arrayOfObject, arrayOfObject, paramCollection.size() + paramInt, paramInt, this.size);
    }
    Iterator localIterator = ((Iterable)paramCollection).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      arrayOfObject[(i + paramInt)] = localObject;
      i += 1;
    }
    this.size += paramCollection.size();
    AppMethodBeat.o(202125);
    return true;
  }
  
  public final void clear()
  {
    Object[] arrayOfObject = this.aqq;
    int i = this.size - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      arrayOfObject[i] = null;
      if (j < 0)
      {
        this.size = 0;
        return;
      }
      i = j;
    }
  }
  
  public final boolean contains(T paramT)
  {
    AppMethodBeat.i(202147);
    int j = this.size - 1;
    int i;
    if (j >= 0) {
      i = 0;
    }
    for (;;)
    {
      if (s.p(this.aqq[i], paramT))
      {
        AppMethodBeat.o(202147);
        return true;
      }
      if (i == j)
      {
        AppMethodBeat.o(202147);
        return false;
      }
      i += 1;
    }
  }
  
  public final int indexOf(T paramT)
  {
    AppMethodBeat.i(202154);
    int k = this.size;
    if (k > 0)
    {
      int i = 0;
      Object[] arrayOfObject = this.aqq;
      int j;
      do
      {
        if (s.p(paramT, arrayOfObject[i]))
        {
          AppMethodBeat.o(202154);
          return i;
        }
        j = i + 1;
        i = j;
      } while (j < k);
    }
    AppMethodBeat.o(202154);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return this.size == 0;
  }
  
  public final boolean qn()
  {
    return this.size != 0;
  }
  
  public final List<T> qp()
  {
    AppMethodBeat.i(202133);
    Object localObject = this.list;
    if (localObject == null)
    {
      localObject = new a(this);
      this.list = ((List)localObject);
      localObject = (List)localObject;
      AppMethodBeat.o(202133);
      return localObject;
    }
    AppMethodBeat.o(202133);
    return localObject;
  }
  
  public final boolean remove(T paramT)
  {
    AppMethodBeat.i(202176);
    int i = indexOf(paramT);
    if (i >= 0)
    {
      removeAt(i);
      AppMethodBeat.o(202176);
      return true;
    }
    AppMethodBeat.o(202176);
    return false;
  }
  
  public final T removeAt(int paramInt)
  {
    AppMethodBeat.i(202183);
    Object[] arrayOfObject = this.aqq;
    Object localObject = arrayOfObject[paramInt];
    if (paramInt != this.size - 1) {
      k.a(arrayOfObject, arrayOfObject, paramInt, paramInt + 1, this.size);
    }
    this.size -= 1;
    arrayOfObject[this.size] = null;
    AppMethodBeat.o(202183);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<T>
    implements List<T>, kotlin.g.b.a.e
  {
    private final e<T> aqr;
    
    public a(e<T> parame)
    {
      AppMethodBeat.i(202040);
      this.aqr = parame;
      AppMethodBeat.o(202040);
    }
    
    public final void add(int paramInt, T paramT)
    {
      AppMethodBeat.i(202117);
      this.aqr.add(paramInt, paramT);
      AppMethodBeat.o(202117);
    }
    
    public final boolean add(T paramT)
    {
      AppMethodBeat.i(202104);
      boolean bool = this.aqr.add(paramT);
      AppMethodBeat.o(202104);
      return bool;
    }
    
    public final boolean addAll(int paramInt, Collection<? extends T> paramCollection)
    {
      AppMethodBeat.i(202122);
      s.u(paramCollection, "elements");
      boolean bool = this.aqr.addAll(paramInt, paramCollection);
      AppMethodBeat.o(202122);
      return bool;
    }
    
    public final boolean addAll(Collection<? extends T> paramCollection)
    {
      AppMethodBeat.i(202127);
      s.u(paramCollection, "elements");
      e locale = this.aqr;
      s.u(paramCollection, "elements");
      boolean bool = locale.addAll(locale.size, paramCollection);
      AppMethodBeat.o(202127);
      return bool;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(202134);
      this.aqr.clear();
      AppMethodBeat.o(202134);
    }
    
    public final boolean contains(Object paramObject)
    {
      AppMethodBeat.i(202047);
      boolean bool = this.aqr.contains(paramObject);
      AppMethodBeat.o(202047);
      return bool;
    }
    
    public final boolean containsAll(Collection<? extends Object> paramCollection)
    {
      AppMethodBeat.i(202054);
      s.u(paramCollection, "elements");
      e locale = this.aqr;
      s.u(paramCollection, "elements");
      paramCollection = ((Iterable)paramCollection).iterator();
      while (paramCollection.hasNext()) {
        if (!locale.contains(paramCollection.next()))
        {
          AppMethodBeat.o(202054);
          return false;
        }
      }
      AppMethodBeat.o(202054);
      return true;
    }
    
    public final T get(int paramInt)
    {
      return this.aqr.aqq[paramInt];
    }
    
    public final int indexOf(Object paramObject)
    {
      AppMethodBeat.i(202069);
      int i = this.aqr.indexOf(paramObject);
      AppMethodBeat.o(202069);
      return i;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(202080);
      boolean bool = this.aqr.isEmpty();
      AppMethodBeat.o(202080);
      return bool;
    }
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(202086);
      Iterator localIterator = (Iterator)new e.c((List)this, 0);
      AppMethodBeat.o(202086);
      return localIterator;
    }
    
    public final int lastIndexOf(Object paramObject)
    {
      AppMethodBeat.i(202095);
      Object localObject = this.aqr;
      int i = ((e)localObject).size;
      if (i > 0)
      {
        i -= 1;
        localObject = ((e)localObject).aqq;
        int j;
        do
        {
          if (s.p(paramObject, localObject[i]))
          {
            AppMethodBeat.o(202095);
            return i;
          }
          j = i - 1;
          i = j;
        } while (j >= 0);
      }
      AppMethodBeat.o(202095);
      return -1;
    }
    
    public final ListIterator<T> listIterator()
    {
      AppMethodBeat.i(202141);
      ListIterator localListIterator = (ListIterator)new e.c((List)this, 0);
      AppMethodBeat.o(202141);
      return localListIterator;
    }
    
    public final ListIterator<T> listIterator(int paramInt)
    {
      AppMethodBeat.i(202148);
      ListIterator localListIterator = (ListIterator)new e.c((List)this, paramInt);
      AppMethodBeat.o(202148);
      return localListIterator;
    }
    
    public final T remove(int paramInt)
    {
      AppMethodBeat.i(202193);
      Object localObject = this.aqr.removeAt(paramInt);
      AppMethodBeat.o(202193);
      return localObject;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(202153);
      boolean bool = this.aqr.remove(paramObject);
      AppMethodBeat.o(202153);
      return bool;
    }
    
    public final boolean removeAll(Collection<? extends Object> paramCollection)
    {
      AppMethodBeat.i(202160);
      s.u(paramCollection, "elements");
      e locale = this.aqr;
      s.u(paramCollection, "elements");
      if (!paramCollection.isEmpty())
      {
        int i = locale.size;
        paramCollection = ((Iterable)paramCollection).iterator();
        while (paramCollection.hasNext()) {
          locale.remove(paramCollection.next());
        }
        if (i != locale.size)
        {
          AppMethodBeat.o(202160);
          return true;
        }
      }
      AppMethodBeat.o(202160);
      return false;
    }
    
    public final boolean retainAll(Collection<? extends Object> paramCollection)
    {
      AppMethodBeat.i(202169);
      s.u(paramCollection, "elements");
      e locale = this.aqr;
      s.u(paramCollection, "elements");
      int k = locale.size;
      int i = locale.size - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        if (!paramCollection.contains(locale.aqq[i])) {
          locale.removeAt(i);
        }
        if (j < 0)
        {
          if (k != locale.size)
          {
            AppMethodBeat.o(202169);
            return true;
          }
          AppMethodBeat.o(202169);
          return false;
        }
        i = j;
      }
    }
    
    public final T set(int paramInt, T paramT)
    {
      Object[] arrayOfObject = this.aqr.aqq;
      Object localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramT;
      return localObject;
    }
    
    public final List<T> subList(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202181);
      List localList = (List)new e.b((List)this, paramInt1, paramInt2);
      AppMethodBeat.o(202181);
      return localList;
    }
    
    public final Object[] toArray()
    {
      AppMethodBeat.i(202207);
      Object[] arrayOfObject = j.L((Collection)this);
      AppMethodBeat.o(202207);
      return arrayOfObject;
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      AppMethodBeat.i(202199);
      s.u(paramArrayOfT, "array");
      paramArrayOfT = j.b((Collection)this, paramArrayOfT);
      AppMethodBeat.o(202199);
      return paramArrayOfT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.a.e
 * JD-Core Version:    0.7.0.1
 */