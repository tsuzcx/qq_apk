package androidx.compose.runtime.b.a.a.a.a.a;

import androidx.compose.runtime.b.a.a.a.h;
import androidx.compose.runtime.b.a.a.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "bufferOfSize", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "set", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j<E>
  extends b<E>
{
  public static final j.a aqI;
  private static final j aqJ;
  private final Object[] buffer;
  
  static
  {
    AppMethodBeat.i(202875);
    aqI = new j.a((byte)0);
    aqJ = new j(new Object[0]);
    AppMethodBeat.o(202875);
  }
  
  public j(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(202860);
    this.buffer = paramArrayOfObject;
    AppMethodBeat.o(202860);
  }
  
  public final h<E> X(E paramE)
  {
    AppMethodBeat.i(202887);
    if (size() < 32)
    {
      Object[] arrayOfObject = Arrays.copyOf(this.buffer, size() + 1);
      s.s(arrayOfObject, "java.util.Arrays.copyOf(this, newSize)");
      arrayOfObject[size()] = paramE;
      paramE = (h)new j(arrayOfObject);
      AppMethodBeat.o(202887);
      return paramE;
    }
    paramE = l.ac(paramE);
    paramE = (h)new e(this.buffer, paramE, size() + 1, 0);
    AppMethodBeat.o(202887);
    return paramE;
  }
  
  public final h<E> cc(int paramInt)
  {
    AppMethodBeat.i(202921);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    if (size() == 1)
    {
      localObject = (h)aqJ;
      AppMethodBeat.o(202921);
      return localObject;
    }
    Object localObject = Arrays.copyOf(this.buffer, size() - 1);
    s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
    k.a(this.buffer, (Object[])localObject, paramInt, paramInt + 1, size());
    localObject = (h)new j((Object[])localObject);
    AppMethodBeat.o(202921);
    return localObject;
  }
  
  public final h<E> e(kotlin.g.a.b<? super E, Boolean> paramb)
  {
    AppMethodBeat.i(202905);
    s.u(paramb, "predicate");
    Object[] arrayOfObject = this.buffer;
    int i = size();
    int n = size();
    int k;
    int j;
    int m;
    Object localObject;
    if (n > 0)
    {
      k = 0;
      j = 0;
      m = k + 1;
      localObject = this.buffer[k];
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        if (j != 0) {
          break label196;
        }
        arrayOfObject = this.buffer;
        arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
        s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
        j = 1;
        i = k;
        label102:
        if (m < n) {
          break label189;
        }
      }
    }
    for (;;)
    {
      if (i == size())
      {
        paramb = (h)this;
        AppMethodBeat.o(202905);
        return paramb;
        if (j == 0) {
          break label196;
        }
        arrayOfObject[i] = localObject;
        i += 1;
        break label102;
      }
      if (i == 0)
      {
        paramb = (h)aqJ;
        AppMethodBeat.o(202905);
        return paramb;
      }
      paramb = (h)new j(k.e(arrayOfObject, 0, i));
      AppMethodBeat.o(202905);
      return paramb;
      label189:
      k = m;
      break;
      label196:
      break label102;
    }
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(202951);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    Object localObject = this.buffer[paramInt];
    AppMethodBeat.o(202951);
    return localObject;
  }
  
  public final int getSize()
  {
    return this.buffer.length;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(202933);
    int i = k.indexOf(this.buffer, paramObject);
    AppMethodBeat.o(202933);
    return i;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(202937);
    Object[] arrayOfObject = this.buffer;
    s.u(arrayOfObject, "$this$lastIndexOf");
    if (paramObject == null)
    {
      i = arrayOfObject.length - 1;
      while (i >= 0)
      {
        if (arrayOfObject[i] == null)
        {
          AppMethodBeat.o(202937);
          return i;
        }
        i -= 1;
      }
    }
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (s.p(paramObject, arrayOfObject[i]))
      {
        AppMethodBeat.o(202937);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(202937);
    return -1;
  }
  
  public final ListIterator<E> listIterator(int paramInt)
  {
    AppMethodBeat.i(202944);
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, size());
    ListIterator localListIterator = (ListIterator)new c(this.buffer, paramInt, size());
    AppMethodBeat.o(202944);
    return localListIterator;
  }
  
  public final h<E> m(int paramInt, E paramE)
  {
    AppMethodBeat.i(202959);
    androidx.compose.runtime.b.a.a.a.b.c.U(paramInt, size());
    Object[] arrayOfObject = this.buffer;
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    arrayOfObject[paramInt] = paramE;
    paramE = (h)new j(arrayOfObject);
    AppMethodBeat.o(202959);
    return paramE;
  }
  
  public final h<E> n(int paramInt, E paramE)
  {
    AppMethodBeat.i(202914);
    androidx.compose.runtime.b.a.a.a.b.c.V(paramInt, size());
    if (paramInt == size())
    {
      paramE = X(paramE);
      AppMethodBeat.o(202914);
      return paramE;
    }
    if (size() < 32)
    {
      arrayOfObject = new Object[size() + 1];
      k.a(this.buffer, arrayOfObject, 0, 0, paramInt, 6);
      k.a(this.buffer, arrayOfObject, paramInt + 1, paramInt, size());
      arrayOfObject[paramInt] = paramE;
      paramE = (h)new j(arrayOfObject);
      AppMethodBeat.o(202914);
      return paramE;
    }
    Object[] arrayOfObject = this.buffer;
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    k.a(this.buffer, arrayOfObject, paramInt + 1, paramInt, size() - 1);
    arrayOfObject[paramInt] = paramE;
    paramE = (h)new e(arrayOfObject, l.ac(this.buffer[31]), size() + 1, 0);
    AppMethodBeat.o(202914);
    return paramE;
  }
  
  public final h<E> n(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(202894);
    s.u(paramCollection, "elements");
    if (size() + paramCollection.size() <= 32)
    {
      localObject = Arrays.copyOf(this.buffer, size() + paramCollection.size());
      s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
      int i = size();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject[i] = paramCollection.next();
        i += 1;
      }
      paramCollection = (h)new j((Object[])localObject);
      AppMethodBeat.o(202894);
      return paramCollection;
    }
    Object localObject = ((h)this).qr();
    ((List)localObject).addAll(paramCollection);
    paramCollection = ((h.a)localObject).qs();
    AppMethodBeat.o(202894);
    return paramCollection;
  }
  
  public final h.a<E> qr()
  {
    AppMethodBeat.i(202927);
    h.a locala = (h.a)new f((h)this, null, this.buffer, 0);
    AppMethodBeat.o(202927);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */