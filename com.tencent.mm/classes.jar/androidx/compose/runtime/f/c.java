package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "<set-?>", "", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "close", "close$runtime_release", "dispose", "hasPendingChanges", "innerApply", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApply$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotApplied$runtime_release", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends h
{
  public static final int Ue = 8;
  private final b<Object, ah> asp;
  private final b<Object, ah> asq;
  private Set<aa> asr;
  j ass;
  private int ast;
  private boolean asu;
  
  public c(int paramInt, j paramj, b<Object, ah> paramb1, b<Object, ah> paramb2)
  {
    super(paramInt, paramj, (byte)0);
    AppMethodBeat.i(202558);
    this.asp = paramb1;
    this.asq = paramb2;
    paramj = j.asC;
    this.ass = j.rw();
    this.ast = 1;
    AppMethodBeat.o(202558);
  }
  
  private final void abandon()
  {
    AppMethodBeat.i(202578);
    Object localObject = rn();
    if (localObject != null)
    {
      rl();
      h(null);
      int i = getId();
      Iterator localIterator = ((Set)localObject).iterator();
      while (localIterator.hasNext()) {
        for (localObject = ((aa)localIterator.next()).pp(); localObject != null; localObject = ((ab)localObject).atu) {
          if ((((ab)localObject).att == i) || (p.a((Iterable)this.ass, Integer.valueOf(((ab)localObject).att)))) {
            ((ab)localObject).att = 0;
          }
        }
      }
    }
    rk();
    AppMethodBeat.o(202578);
  }
  
  private void d(j paramj)
  {
    AppMethodBeat.i(202589);
    s.u(paramj, "<set-?>");
    this.ass = paramj;
    AppMethodBeat.o(202589);
  }
  
  private void rl()
  {
    AppMethodBeat.i(202568);
    if (!this.asu) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Unsupported operation on a snapshot that has been applied".toString());
      AppMethodBeat.o(202568);
      throw localThrowable;
    }
    AppMethodBeat.o(202568);
  }
  
  public final i a(int paramInt, Map<ab, ? extends ab> arg2, j paramj)
  {
    AppMethodBeat.i(202711);
    s.u(paramj, "invalidSnapshots");
    j localj = rq().cs(getId()).g(this.ass);
    Set localSet = rn();
    s.checkNotNull(localSet);
    Object localObject1 = null;
    Iterator localIterator = localSet.iterator();
    List localList = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      aa localaa = (aa)localIterator.next();
      localObject2 = localaa.pp();
      Object localObject3 = l.c((ab)localObject2, paramInt, paramj);
      label283:
      label421:
      if (localObject3 != null)
      {
        ab localab1 = l.c((ab)localObject2, getId(), localj);
        label350:
        if ((localab1 != null) && (!s.p(localObject3, localab1)))
        {
          ab localab2 = l.c((ab)localObject2, getId(), rq());
          if (localab2 == null)
          {
            l.rI();
            ??? = new f();
            AppMethodBeat.o(202711);
            throw ???;
          }
          if (??? == null)
          {
            localObject2 = null;
            if (localObject2 != null) {
              break label239;
            }
            localObject2 = localaa.a(localab1, (ab)localObject3, localab2);
          }
          label239:
          for (;;)
          {
            if (localObject2 != null) {
              break label242;
            }
            ??? = (i)new i.a((h)this);
            AppMethodBeat.o(202711);
            return ???;
            localObject2 = (ab)???.get(localObject3);
            break;
          }
          label242:
          if (!s.p(localObject2, localab2))
          {
            if (s.p(localObject2, localObject3))
            {
              if (localList == null)
              {
                localList = (List)new ArrayList();
                localObject2 = localList;
                ((List)localObject2).add(v.Y(localaa, ((ab)localObject3).ps()));
                if (localObject1 != null) {
                  break label350;
                }
                localObject2 = (List)new ArrayList();
                localObject1 = localObject2;
                localObject3 = localObject1;
                localObject1 = localObject2;
              }
              for (;;)
              {
                ((List)localObject3).add(localaa);
                break;
                localObject2 = localList;
                break label283;
                localObject2 = localObject1;
                localObject3 = localObject2;
              }
            }
            if (localList == null)
            {
              localList = (List)new ArrayList();
              localObject3 = localList;
              label382:
              if (s.p(localObject2, localab1)) {
                break label421;
              }
            }
            for (localObject2 = v.Y(localaa, localObject2);; localObject2 = v.Y(localaa, localab1.ps()))
            {
              ((List)localObject3).add(localObject2);
              break;
              localObject3 = localList;
              break label382;
            }
          }
        }
      }
    }
    int j;
    if (localList != null)
    {
      rm();
      paramInt = 0;
      j = localList.size() - 1;
      if (j < 0) {}
    }
    for (;;)
    {
      int i = paramInt + 1;
      ??? = (r)localList.get(paramInt);
      paramj = (aa)???.bsC;
      localObject2 = (ab)???.bsD;
      ((ab)localObject2).att = getId();
      synchronized (l.ry())
      {
        ((ab)localObject2).atu = paramj.pp();
        paramj.a((ab)localObject2);
        paramj = ah.aiuX;
        if (i > j)
        {
          if (localObject1 != null) {
            localSet.removeAll((Collection)localObject1);
          }
          ??? = (i)i.b.asB;
          AppMethodBeat.o(202711);
          return ???;
        }
      }
      paramInt = i;
    }
  }
  
  public void a(aa paramaa)
  {
    AppMethodBeat.i(202731);
    s.u(paramaa, "state");
    Set localSet = rn();
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      h((Set)localObject);
      localObject = (Set)localObject;
    }
    ((Set)localObject).add(paramaa);
    AppMethodBeat.o(202731);
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(202692);
    s.u(paramh, "snapshot");
    if (this.ast > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(202692);
      throw paramh;
    }
    this.ast -= 1;
    if ((this.ast == 0) && (!this.asu)) {
      abandon();
    }
    AppMethodBeat.o(202692);
  }
  
  public void b(h paramh)
  {
    AppMethodBeat.i(202684);
    s.u(paramh, "snapshot");
    this.ast += 1;
    AppMethodBeat.o(202684);
  }
  
  public c c(b<Object, ah> arg1, b<Object, ah> paramb2)
  {
    AppMethodBeat.i(202631);
    ru();
    rl();
    cp(getId());
    int i;
    synchronized (l.ry())
    {
      i = l.rJ();
      l.cu(i + 1);
      l.l(l.rG().cs(i));
      j localj = rq();
      e(localj.cs(i));
      paramb2 = new d(i, localj, l.e(???, this.asp), l.f(paramb2, this.asq), this);
      i = getId();
    }
    label232:
    for (;;)
    {
      int j;
      synchronized (l.ry())
      {
        j = l.rJ();
        l.cu(j + 1);
        cq(j);
        l.l(l.rG().cs(getId()));
        ??? = ah.aiuX;
        ??? = rq();
        i += 1;
        int k = getId();
        if (i >= k) {
          break label232;
        }
        j = i + 1;
        ??? = ???.cs(i);
        if (j >= k)
        {
          e(???);
          ??? = (c)paramb2;
          AppMethodBeat.o(202631);
          return ???;
          ??? = finally;
          AppMethodBeat.o(202631);
          throw ???;
        }
      }
      i = j;
    }
  }
  
  public final void c(j paramj)
  {
    AppMethodBeat.i(202726);
    s.u(paramj, "snapshots");
    synchronized (l.ry())
    {
      d(this.ass.g(paramj));
      paramj = ah.aiuX;
      AppMethodBeat.o(202726);
      return;
    }
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(202722);
    synchronized (l.ry())
    {
      d(this.ass.cs(paramInt));
      ah localah = ah.aiuX;
      AppMethodBeat.o(202722);
      return;
    }
  }
  
  public void dispose()
  {
    AppMethodBeat.i(202663);
    if (!rs())
    {
      super.dispose();
      a((h)this);
    }
    AppMethodBeat.o(202663);
  }
  
  public h h(b<Object, ah> arg1)
  {
    AppMethodBeat.i(202678);
    ru();
    rl();
    int i = getId();
    cp(getId());
    for (;;)
    {
      int k;
      Object localObject1;
      Object localObject3;
      int j;
      synchronized (l.ry())
      {
        k = l.rJ();
        l.cu(k + 1);
        l.l(l.rG().cs(k));
        localObject1 = rq();
        i += 1;
        localObject3 = localObject1;
        if (i < k)
        {
          j = i + 1;
          localObject1 = ((j)localObject1).cs(i);
          if (j < k) {
            break label256;
          }
          localObject3 = localObject1;
        }
        localObject1 = new e(k, (j)localObject3, ???, (h)this);
        i = getId();
      }
      label253:
      for (;;)
      {
        synchronized (l.ry())
        {
          j = l.rJ();
          l.cu(j + 1);
          cq(j);
          l.l(l.rG().cs(getId()));
          localObject3 = ah.aiuX;
          ??? = rq();
          i += 1;
          k = getId();
          if (i >= k) {
            break label253;
          }
          j = i + 1;
          ??? = ???.cs(i);
          if (j >= k)
          {
            e(???);
            ??? = (h)localObject1;
            AppMethodBeat.o(202678);
            return ???;
            ??? = finally;
            AppMethodBeat.o(202678);
            throw ???;
          }
        }
        i = j;
      }
      label256:
      i = j;
    }
  }
  
  public void h(Set<aa> paramSet)
  {
    this.asr = paramSet;
  }
  
  public void rf()
  {
    AppMethodBeat.i(202699);
    if ((this.asu) || (rs()))
    {
      AppMethodBeat.o(202699);
      return;
    }
    rm();
    AppMethodBeat.o(202699);
  }
  
  public i rg()
  {
    int j = 0;
    AppMethodBeat.i(202647);
    Set localSet = rn();
    Object localObject1;
    if (localSet != null)
    {
      localObject1 = l.rH().get();
      s.s(localObject1, "currentGlobalSnapshot.get()");
      localObject1 = l.a((c)localObject1, this, l.rG().ct(((a)l.rH().get()).getId()));
    }
    for (;;)
    {
      int k;
      synchronized (l.ry())
      {
        l.d((h)this);
        if ((localSet == null) || (localSet.size() == 0))
        {
          rk();
          localObject1 = (a)l.rH().get();
          s.s(localObject1, "previousGlobalSnapshot");
          l.b((h)localObject1, l.rC());
          localObject1 = ((a)localObject1).rn();
          if (localObject1 != null) {
            if (!((Collection)localObject1).isEmpty())
            {
              i = 1;
              if (i != 0)
              {
                localObject1 = v.Y(p.J((Collection)l.rD()), localObject1);
                ??? = (List)((r)localObject1).bsC;
                localObject1 = (Set)((r)localObject1).bsD;
                this.asu = true;
                if (localObject1 != null)
                {
                  if (((Collection)localObject1).isEmpty()) {
                    break label523;
                  }
                  i = 1;
                  if (i != 0)
                  {
                    int m = ((List)???).size() - 1;
                    if (m >= 0)
                    {
                      i = 0;
                      k = i + 1;
                      ((m)((List)???).get(i)).invoke(localObject1, this);
                      if (k <= m) {
                        break label538;
                      }
                    }
                  }
                }
                if (localSet != null)
                {
                  if (((Collection)localSet).isEmpty()) {
                    break label528;
                  }
                  i = 1;
                  if (i != 0)
                  {
                    k = ((List)???).size() - 1;
                    if (k >= 0)
                    {
                      i = j;
                      j = i + 1;
                      ((m)((List)???).get(i)).invoke(localSet, this);
                      if (j <= k) {
                        break label533;
                      }
                    }
                  }
                }
                localObject1 = (i)i.b.asB;
                AppMethodBeat.o(202647);
                return localObject1;
                localObject1 = null;
              }
            }
            else
            {
              i = 0;
              continue;
            }
          }
          localObject1 = v.Y((List)kotlin.a.ab.aivy, null);
          continue;
        }
        else
        {
          a locala = (a)l.rH().get();
          localObject1 = a(l.rJ(), (Map)localObject1, l.rG().ct(locala.getId()));
          boolean bool = s.p(localObject1, i.b.asB);
          if (!bool)
          {
            AppMethodBeat.o(202647);
            return localObject1;
          }
          rk();
          s.s(locala, "previousGlobalSnapshot");
          l.b((h)locala, l.rC());
          localObject1 = locala.rn();
          h(null);
          locala.h(null);
          localObject1 = v.Y(p.J((Collection)l.rD()), localObject1);
        }
      }
      label523:
      int i = 0;
      continue;
      label528:
      i = 0;
      continue;
      label533:
      i = j;
      continue;
      label538:
      i = k;
    }
  }
  
  public final b<Object, ah> rh()
  {
    return this.asp;
  }
  
  public final b<Object, ah> ri()
  {
    return this.asq;
  }
  
  public boolean rj()
  {
    return false;
  }
  
  public final void rk()
  {
    AppMethodBeat.i(202705);
    synchronized (l.ry())
    {
      l.l(l.rG().ct(getId()).f(this.ass));
      ah localah = ah.aiuX;
      AppMethodBeat.o(202705);
      return;
    }
  }
  
  public final void rm()
  {
    AppMethodBeat.i(202716);
    cp(getId());
    ??? = ah.aiuX;
    int j;
    for (int i = getId();; i = j) {
      synchronized (l.ry())
      {
        j = l.rJ();
        l.cu(j + 1);
        cq(j);
        l.l(l.rG().cs(getId()));
        Object localObject2 = ah.aiuX;
        ??? = rq();
        i += 1;
        int k = getId();
        localObject2 = ???;
        if (i < k)
        {
          j = i + 1;
          ??? = ((j)???).cs(i);
          if (j >= k) {
            localObject2 = ???;
          }
        }
        else
        {
          e((j)localObject2);
          AppMethodBeat.o(202716);
          return;
        }
      }
    }
  }
  
  public Set<aa> rn()
  {
    return this.asr;
  }
  
  public final boolean ro()
  {
    return this.asu;
  }
  
  public final void rp()
  {
    this.asu = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.c
 * JD-Core Version:    0.7.0.1
 */