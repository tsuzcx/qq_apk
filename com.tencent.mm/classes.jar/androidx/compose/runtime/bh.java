package androidx.compose.runtime;

import androidx.compose.runtime.f.aa;
import androidx.compose.runtime.f.ab;
import androidx.compose.runtime.f.h;
import androidx.compose.runtime.f.h.a;
import androidx.compose.runtime.f.l;
import androidx.compose.runtime.f.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SnapshotMutableStateImpl;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "StateStateRecord", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public class bh<T>
  implements aa, q<T>
{
  private final bi<T> anV;
  private a<T> aqa;
  
  public bh(T paramT, bi<T> parambi)
  {
    AppMethodBeat.i(201964);
    this.anV = parambi;
    this.aqa = new a(paramT);
    AppMethodBeat.o(201964);
  }
  
  public final ab a(ab paramab1, ab paramab2, ab paramab3)
  {
    AppMethodBeat.i(201983);
    s.u(paramab1, "previous");
    s.u(paramab2, "current");
    s.u(paramab3, "applied");
    paramab1 = (a)paramab2;
    paramab3 = (a)paramab3;
    if (this.anV.f(paramab1.value, paramab3.value))
    {
      AppMethodBeat.o(201983);
      return paramab2;
    }
    paramab1 = this.anV.py();
    if (paramab1 != null)
    {
      paramab2 = paramab3.ps();
      ((a)paramab2).value = paramab1;
      AppMethodBeat.o(201983);
      return paramab2;
    }
    AppMethodBeat.o(201983);
    return null;
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(201980);
    s.u(paramab, "value");
    this.aqa = ((a)paramab);
    AppMethodBeat.o(201980);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(201971);
    Object localObject = ((a)l.a((ab)this.aqa, (aa)this)).value;
    AppMethodBeat.o(201971);
    return localObject;
  }
  
  public final ab pp()
  {
    return (ab)this.aqa;
  }
  
  public final bi<T> qg()
  {
    return this.anV;
  }
  
  public final void setValue(T paramT)
  {
    AppMethodBeat.i(201977);
    ??? = (ab)this.aqa;
    Object localObject2 = h.asx;
    localObject2 = (a)l.a((ab)???, l.rx());
    ab localab;
    if (!this.anV.f(((a)localObject2).value, paramT))
    {
      localab = (ab)this.aqa;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      ((a)l.a(localab, (aa)this, (h)localObject3, (ab)localObject2)).value = paramT;
      paramT = ah.aiuX;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(201977);
      return;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(201987);
    Object localObject = (ab)this.aqa;
    h.a locala = h.asx;
    localObject = (a)l.a((ab)localObject, l.rx());
    localObject = "MutableState(value=" + ((a)localObject).value + ")@" + hashCode();
    AppMethodBeat.o(201987);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "myValue", "(Ljava/lang/Object;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "assign", "", "create", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<T>
    extends ab
  {
    T value;
    
    public a(T paramT)
    {
      this.value = paramT;
    }
    
    public final void b(ab paramab)
    {
      AppMethodBeat.i(202164);
      s.u(paramab, "value");
      this.value = ((a)paramab).value;
      AppMethodBeat.o(202164);
    }
    
    public final ab ps()
    {
      AppMethodBeat.i(202171);
      ab localab = (ab)new a(this.value);
      AppMethodBeat.o(202171);
      return localab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bh
 * JD-Core Version:    0.7.0.1
 */