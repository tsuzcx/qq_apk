package androidx.compose.runtime.f;

import androidx.compose.runtime.b.a.a.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.a.e;
import kotlin.g.b.a.f;
import kotlin.g.b.ah.d;
import kotlin.g.b.j;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SubList;", "T", "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "modification", "offset", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ac<T>
  implements List<T>, e
{
  private int asY;
  private final r<T> atv;
  private final int offset;
  private int size;
  
  public ac(r<T> paramr, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202466);
    this.atv = paramr;
    this.offset = paramInt1;
    this.asY = this.atv.rL();
    this.size = (paramInt2 - paramInt1);
    AppMethodBeat.o(202466);
  }
  
  private final void rP()
  {
    AppMethodBeat.i(202469);
    if (this.atv.rL() != this.asY)
    {
      ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException();
      AppMethodBeat.o(202469);
      throw localConcurrentModificationException;
    }
    AppMethodBeat.o(202469);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(202523);
    rP();
    this.atv.add(this.offset + paramInt, paramT);
    this.size = (size() + 1);
    this.asY = this.atv.rL();
    AppMethodBeat.o(202523);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(202516);
    rP();
    this.atv.add(this.offset + size(), paramT);
    this.size = (size() + 1);
    this.asY = this.atv.rL();
    AppMethodBeat.o(202516);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202529);
    kotlin.g.b.s.u(paramCollection, "elements");
    rP();
    boolean bool = this.atv.addAll(this.offset + paramInt, paramCollection);
    if (bool)
    {
      this.size = (size() + paramCollection.size());
      this.asY = this.atv.rL();
    }
    AppMethodBeat.o(202529);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202540);
    kotlin.g.b.s.u(paramCollection, "elements");
    boolean bool = addAll(size(), paramCollection);
    AppMethodBeat.o(202540);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202553);
    r localr;
    Object localObject2;
    Object localObject4;
    if (size() > 0)
    {
      rP();
      localr = this.atv;
      int i = this.offset;
      int j = this.offset;
      int k = size();
      localObject2 = (ab)localr.asW;
      ??? = h.asx;
      ??? = (r.a)l.a((ab)localObject2, l.rx());
      localObject2 = ((r.a)???).asX.qr();
      ((List)localObject2).subList(i, j + k).clear();
      localObject4 = kotlin.ah.aiuX;
      localObject2 = ((h.a)localObject2).qs();
      if (localObject2 != ((r.a)???).asX)
      {
        localObject4 = (ab)localr.asW;
        l.rz();
      }
    }
    synchronized (l.ry())
    {
      Object localObject5 = h.asx;
      localObject5 = l.rx();
      localObject4 = (r.a)l.b((ab)localObject4, (aa)localr, (h)localObject5);
      ((r.a)localObject4).a((androidx.compose.runtime.b.a.a.a.h)localObject2);
      ((r.a)localObject4).asY += 1;
      l.a((h)localObject5, (aa)localr);
      this.size = 0;
      this.asY = this.atv.rL();
      AppMethodBeat.o(202553);
      return;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202474);
    if (indexOf(paramObject) >= 0)
    {
      AppMethodBeat.o(202474);
      return true;
    }
    AppMethodBeat.o(202474);
    return false;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202480);
    kotlin.g.b.s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(202480);
          return false;
        }
      }
    }
    AppMethodBeat.o(202480);
    return true;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(202487);
    rP();
    s.X(paramInt, size());
    Object localObject = this.atv.get(this.offset + paramInt);
    AppMethodBeat.o(202487);
    return localObject;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(202494);
    rP();
    Iterator localIterator = ((Iterable)k.qt(this.offset, this.offset + size())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((kotlin.a.ah)localIterator).Zo();
      if (kotlin.g.b.s.p(paramObject, this.atv.get(i)))
      {
        int j = this.offset;
        AppMethodBeat.o(202494);
        return i - j;
      }
    }
    AppMethodBeat.o(202494);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202500);
    if (size() == 0)
    {
      AppMethodBeat.o(202500);
      return true;
    }
    AppMethodBeat.o(202500);
    return false;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(202504);
    Iterator localIterator = (Iterator)listIterator();
    AppMethodBeat.o(202504);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(202508);
    rP();
    int i = this.offset + size() - 1;
    while (i >= this.offset)
    {
      if (kotlin.g.b.s.p(paramObject, this.atv.get(i)))
      {
        int j = this.offset;
        AppMethodBeat.o(202508);
        return i - j;
      }
      i -= 1;
    }
    AppMethodBeat.o(202508);
    return -1;
  }
  
  public final ListIterator<T> listIterator()
  {
    AppMethodBeat.i(202562);
    ListIterator localListIterator = listIterator(0);
    AppMethodBeat.o(202562);
    return localListIterator;
  }
  
  public final ListIterator<T> listIterator(int paramInt)
  {
    AppMethodBeat.i(202574);
    rP();
    Object localObject = new ah.d();
    ((ah.d)localObject).aixb = (paramInt - 1);
    localObject = (ListIterator)new a((ah.d)localObject, this);
    AppMethodBeat.o(202574);
    return localObject;
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(202645);
    rP();
    Object localObject = this.atv.remove(this.offset + paramInt);
    this.size = (size() - 1);
    this.asY = this.atv.rL();
    AppMethodBeat.o(202645);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202584);
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      remove(i);
      AppMethodBeat.o(202584);
      return true;
    }
    AppMethodBeat.o(202584);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202594);
    kotlin.g.b.s.u(paramCollection, "elements");
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      if ((remove(paramCollection.next())) || (bool)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    AppMethodBeat.o(202594);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202610);
    kotlin.g.b.s.u(paramCollection, "elements");
    rP();
    int i = this.offset + size() - 1;
    boolean bool2;
    for (boolean bool1 = false; i >= this.offset; bool1 = bool2)
    {
      bool2 = bool1;
      if (!paramCollection.contains(this.atv.get(i)))
      {
        bool2 = bool1;
        if (!bool1) {
          bool2 = true;
        }
        this.atv.remove(i);
        this.size = (size() - 1);
      }
      i -= 1;
    }
    if (bool1) {
      this.asY = this.atv.rL();
    }
    AppMethodBeat.o(202610);
    return bool1;
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(202620);
    s.X(paramInt, size());
    rP();
    paramT = this.atv.set(this.offset + paramInt, paramT);
    this.asY = this.atv.rL();
    AppMethodBeat.o(202620);
    return paramT;
  }
  
  public final List<T> subList(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(202630);
    if (paramInt1 >= 0) {
      if (paramInt1 <= paramInt2)
      {
        i = 1;
        if ((i == 0) || (paramInt2 > size())) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label81;
      }
      localObject = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(202630);
      throw ((Throwable)localObject);
      i = 0;
      break;
      i = 0;
      break;
    }
    label81:
    rP();
    Object localObject = (List)new ac(this.atv, this.offset + paramInt1, this.offset + paramInt2);
    AppMethodBeat.o(202630);
    return localObject;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(202665);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(202665);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202657);
    kotlin.g.b.s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(202657);
    return paramArrayOfT;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/snapshots/SubList$listIterator$1", "", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ListIterator<T>, f
  {
    a(ah.d paramd, ac<T> paramac) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(202648);
      if (this.atw.aixb < jdField_this.size() - 1)
      {
        AppMethodBeat.o(202648);
        return true;
      }
      AppMethodBeat.o(202648);
      return false;
    }
    
    public final boolean hasPrevious()
    {
      return this.atw.aixb >= 0;
    }
    
    public final T next()
    {
      AppMethodBeat.i(202655);
      int i = this.atw.aixb + 1;
      s.X(i, jdField_this.size());
      this.atw.aixb = i;
      Object localObject = jdField_this.get(i);
      AppMethodBeat.o(202655);
      return localObject;
    }
    
    public final int nextIndex()
    {
      return this.atw.aixb + 1;
    }
    
    public final T previous()
    {
      AppMethodBeat.i(202634);
      int i = this.atw.aixb;
      s.X(i, jdField_this.size());
      this.atw.aixb = (i - 1);
      Object localObject = jdField_this.get(i);
      AppMethodBeat.o(202634);
      return localObject;
    }
    
    public final int previousIndex()
    {
      return this.atw.aixb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.ac
 * JD-Core Version:    0.7.0.1
 */