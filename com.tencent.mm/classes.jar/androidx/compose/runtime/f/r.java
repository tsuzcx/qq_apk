package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.a.e;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r<T>
  implements aa, List<T>, e
{
  ab asW;
  
  public r()
  {
    AppMethodBeat.i(202514);
    this.asW = ((ab)new a(androidx.compose.runtime.b.a.a.a.a.a.l.qG()));
    AppMethodBeat.o(202514);
  }
  
  private a<T> rM()
  {
    AppMethodBeat.i(202522);
    a locala = (a)l.a((ab)this.asW, (aa)this);
    AppMethodBeat.o(202522);
    return locala;
  }
  
  private T removeAt(int paramInt)
  {
    AppMethodBeat.i(202530);
    Object localObject1 = get(paramInt);
    Object localObject3 = (ab)this.asW;
    ??? = h.asx;
    ??? = (a)l.a((ab)localObject3, l.rx());
    localObject3 = ((a)???).asX.cc(paramInt);
    Object localObject5;
    if (localObject3 != ((a)???).asX)
    {
      localObject5 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject6 = h.asx;
      localObject6 = l.rx();
      localObject5 = (a)l.b((ab)localObject5, (aa)this, (h)localObject6);
      ((a)localObject5).a((androidx.compose.runtime.b.a.a.a.h)localObject3);
      ((a)localObject5).asY += 1;
      l.a((h)localObject6, (aa)this);
      AppMethodBeat.o(202530);
      return localObject1;
    }
  }
  
  public final ab a(ab paramab1, ab paramab2, ab paramab3)
  {
    AppMethodBeat.i(202719);
    paramab1 = aa.a.a(this, paramab1, paramab2, paramab3);
    AppMethodBeat.o(202719);
    return paramab1;
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(202548);
    s.u(paramab, "value");
    paramab.atu = this.asW;
    this.asW = ((ab)paramab);
    AppMethodBeat.o(202548);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(202660);
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramT = ((a)???).asX.n(paramInt, paramT);
    if (paramT != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
      ((a)localObject2).a(paramT);
      ((a)localObject2).asY += 1;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(202660);
      return;
    }
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(202653);
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramT = ((a)???).asX.X(paramT);
    if (paramT != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
      synchronized (l.ry())
      {
        Object localObject3 = h.asx;
        localObject3 = l.rx();
        localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
        ((a)localObject2).a(paramT);
        ((a)localObject2).asY += 1;
        l.a((h)localObject3, (aa)this);
        AppMethodBeat.o(202653);
        return true;
      }
    }
    AppMethodBeat.o(202653);
    return false;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202671);
    s.u(paramCollection, "elements");
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    localObject2 = ((a)???).asX.qr();
    boolean bool = ((List)localObject2).addAll(paramInt, paramCollection);
    paramCollection = ((androidx.compose.runtime.b.a.a.a.h.a)localObject2).qs();
    if (paramCollection != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
      ((a)localObject2).a(paramCollection);
      ((a)localObject2).asY += 1;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(202671);
      return bool;
    }
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202682);
    s.u(paramCollection, "elements");
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramCollection = ((a)???).asX.n(paramCollection);
    if (paramCollection != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
      synchronized (l.ry())
      {
        Object localObject3 = h.asx;
        localObject3 = l.rx();
        localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
        ((a)localObject2).a(paramCollection);
        ((a)localObject2).asY += 1;
        l.a((h)localObject3, (aa)this);
        AppMethodBeat.o(202682);
        return true;
      }
    }
    AppMethodBeat.o(202682);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202688);
    Object localObject2 = (ab)this.asW;
    l.rz();
    synchronized (l.ry())
    {
      Object localObject4 = h.asx;
      localObject4 = l.rx();
      ((a)l.b((ab)localObject2, (aa)this, (h)localObject4)).a(androidx.compose.runtime.b.a.a.a.a.a.l.qG());
      localObject2 = ah.aiuX;
      l.a((h)localObject4, (aa)this);
      AppMethodBeat.o(202688);
      return;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202564);
    boolean bool = rM().asX.contains(paramObject);
    AppMethodBeat.o(202564);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202573);
    s.u(paramCollection, "elements");
    boolean bool = rM().asX.containsAll(paramCollection);
    AppMethodBeat.o(202573);
    return bool;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(202579);
    Object localObject = rM().asX.get(paramInt);
    AppMethodBeat.o(202579);
    return localObject;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(202588);
    int i = rM().asX.indexOf(paramObject);
    AppMethodBeat.o(202588);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202600);
    boolean bool = rM().asX.isEmpty();
    AppMethodBeat.o(202600);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(202607);
    Iterator localIterator = (Iterator)listIterator();
    AppMethodBeat.o(202607);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(202614);
    int i = rM().asX.lastIndexOf(paramObject);
    AppMethodBeat.o(202614);
    return i;
  }
  
  public final ListIterator<T> listIterator()
  {
    AppMethodBeat.i(202625);
    ListIterator localListIterator = (ListIterator)new v(this, 0);
    AppMethodBeat.o(202625);
    return localListIterator;
  }
  
  public final ListIterator<T> listIterator(int paramInt)
  {
    AppMethodBeat.i(202636);
    ListIterator localListIterator = (ListIterator)new v(this, paramInt);
    AppMethodBeat.o(202636);
    return localListIterator;
  }
  
  public final ab pp()
  {
    return this.asW;
  }
  
  public final int rL()
  {
    AppMethodBeat.i(202556);
    ab localab = (ab)this.asW;
    h.a locala = h.asx;
    int i = ((a)l.a(localab, l.rx())).asY;
    AppMethodBeat.o(202556);
    return i;
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(202729);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(202729);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202695);
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramObject = ((a)???).asX.Y(paramObject);
    if (paramObject != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
      synchronized (l.ry())
      {
        Object localObject3 = h.asx;
        localObject3 = l.rx();
        localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
        ((a)localObject2).a(paramObject);
        ((a)localObject2).asY += 1;
        l.a((h)localObject3, (aa)this);
        AppMethodBeat.o(202695);
        return true;
      }
    }
    AppMethodBeat.o(202695);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202704);
    s.u(paramCollection, "elements");
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramCollection = ((a)???).asX.o(paramCollection);
    if (paramCollection != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
      synchronized (l.ry())
      {
        Object localObject3 = h.asx;
        localObject3 = l.rx();
        localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
        ((a)localObject2).a(paramCollection);
        ((a)localObject2).asY += 1;
        l.a((h)localObject3, (aa)this);
        AppMethodBeat.o(202704);
        return true;
      }
    }
    AppMethodBeat.o(202704);
    return false;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202709);
    s.u(paramCollection, "elements");
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    localObject2 = ((a)???).asX.qr();
    boolean bool = ((List)localObject2).retainAll(paramCollection);
    paramCollection = ((androidx.compose.runtime.b.a.a.a.h.a)localObject2).qs();
    if (paramCollection != ((a)???).asX)
    {
      localObject2 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
      ((a)localObject2).a(paramCollection);
      ((a)localObject2).asY += 1;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(202709);
      return bool;
    }
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(202713);
    Object localObject1 = get(paramInt);
    ??? = (ab)this.asW;
    Object localObject3 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    paramT = ((a)???).asX.m(paramInt, paramT);
    if (paramT != ((a)???).asX)
    {
      localObject3 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject4 = h.asx;
      localObject4 = l.rx();
      localObject3 = (a)l.b((ab)localObject3, (aa)this, (h)localObject4);
      ((a)localObject3).a(paramT);
      ((a)localObject3).asY += 1;
      l.a((h)localObject4, (aa)this);
      AppMethodBeat.o(202713);
      return localObject1;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(202723);
    int i = rM().asX.size();
    AppMethodBeat.o(202723);
    return i;
  }
  
  public final List<T> subList(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(202643);
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
      AppMethodBeat.o(202643);
      throw ((Throwable)localObject);
      i = 0;
      break;
      i = 0;
      break;
    }
    label81:
    Object localObject = (List)new ac(this, paramInt1, paramInt2);
    AppMethodBeat.o(202643);
    return localObject;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(202738);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(202738);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202734);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(202734);
    return paramArrayOfT;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T>
    extends ab
  {
    androidx.compose.runtime.b.a.a.a.h<? extends T> asX;
    int asY;
    
    public a(androidx.compose.runtime.b.a.a.a.h<? extends T> paramh)
    {
      AppMethodBeat.i(202476);
      this.asX = paramh;
      AppMethodBeat.o(202476);
    }
    
    public final void a(androidx.compose.runtime.b.a.a.a.h<? extends T> paramh)
    {
      AppMethodBeat.i(202482);
      s.u(paramh, "<set-?>");
      this.asX = paramh;
      AppMethodBeat.o(202482);
    }
    
    public final void b(ab paramab)
    {
      AppMethodBeat.i(202488);
      s.u(paramab, "value");
      this.asX = ((a)paramab).asX;
      this.asY = ((a)paramab).asY;
      AppMethodBeat.o(202488);
    }
    
    public final ab ps()
    {
      AppMethodBeat.i(202493);
      ab localab = (ab)new a(this.asX);
      AppMethodBeat.o(202493);
      return localab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.r
 * JD-Core Version:    0.7.0.1
 */