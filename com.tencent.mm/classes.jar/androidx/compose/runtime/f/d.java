package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  private final c asv;
  
  public d(int paramInt, j paramj, b<Object, ah> paramb1, b<Object, ah> paramb2, c paramc)
  {
    super(paramInt, paramj, paramb1, paramb2);
    AppMethodBeat.i(202593);
    this.asv = paramc;
    this.asv.b((h)this);
    AppMethodBeat.o(202593);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(202602);
    if (!rs())
    {
      super.dispose();
      this.asv.a((h)this);
    }
    AppMethodBeat.o(202602);
  }
  
  public final i rg()
  {
    AppMethodBeat.i(202618);
    Object localObject1;
    if ((this.asv.ro()) || (this.asv.rs()))
    {
      localObject1 = (i)new i.a((h)this);
      AppMethodBeat.o(202618);
      return localObject1;
    }
    Set localSet2 = rn();
    int i = getId();
    if (localSet2 != null) {
      localObject1 = l.a(this.asv, (c)this, this.asv.rq());
    }
    synchronized (l.ry())
    {
      for (;;)
      {
        l.d((h)this);
        if ((localSet2 != null) && (localSet2.size() != 0)) {
          break;
        }
        rk();
        if (this.asv.getId() < i) {
          this.asv.rm();
        }
        this.asv.e(this.asv.rq().ct(i).f(this.ass));
        this.asv.cp(i);
        this.asv.c(this.ass);
        localObject1 = ah.aiuX;
        rp();
        localObject1 = (i)i.b.asB;
        AppMethodBeat.o(202618);
        return localObject1;
        localObject1 = null;
      }
      localObject1 = a(this.asv.getId(), (Map)localObject1, this.asv.rq());
      boolean bool = s.p(localObject1, i.b.asB);
      if (!bool)
      {
        AppMethodBeat.o(202618);
        return localObject1;
      }
      Set localSet1 = this.asv.rn();
      localObject1 = localSet1;
      if (localSet1 == null)
      {
        localObject1 = new HashSet();
        this.asv.h((Set)localObject1);
        localObject1 = (Set)localObject1;
      }
      ((Set)localObject1).addAll((Collection)localSet2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.d
 * JD-Core Version:    0.7.0.1
 */