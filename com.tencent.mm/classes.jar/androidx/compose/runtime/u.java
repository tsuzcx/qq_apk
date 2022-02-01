package androidx.compose.runtime;

import androidx.compose.runtime.f.aa;
import androidx.compose.runtime.f.aa.a;
import androidx.compose.runtime.f.ab;
import androidx.compose.runtime.f.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "", "getDependencies", "()Ljava/util/Set;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "value", "getValue", "currentRecord", "readable", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u<T>
  implements aa, v<T>
{
  private final a<T> anN;
  private a<T> anO;
  
  public u(a<? extends T> parama)
  {
    AppMethodBeat.i(202209);
    this.anN = parama;
    this.anO = new a();
    AppMethodBeat.o(202209);
  }
  
  private final a<T> a(a<T> arg1, final androidx.compose.runtime.f.h paramh, a<? extends T> parama1)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(202230);
    if (???.a((v)this, paramh))
    {
      AppMethodBeat.o(202230);
      return ???;
    }
    paramh = new HashSet();
    ??? = (androidx.compose.runtime.b.a.a.a.h)bj.qm().get();
    Object localObject;
    int n;
    if (??? == null)
    {
      ??? = androidx.compose.runtime.b.a.a.a.a.a.l.qG();
      localObject = (List)???;
      n = ((List)localObject).size() - 1;
      if (n < 0) {}
    }
    int m;
    for (int i = 0;; i = m)
    {
      m = i + 1;
      ((b)((r)((List)localObject).get(i)).bsC).invoke((v)this);
      if (m > n) {
        try
        {
          localObject = androidx.compose.runtime.f.h.asx;
          parama1 = h.a.a((b)new b(this, paramh), parama1);
          ??? = (List)???;
          k = ???.size() - 1;
          if (k >= 0)
          {
            i = j;
            j = i + 1;
            ((b)((r)???.get(i)).bsD).invoke((v)this);
            if (j <= k) {
              break label385;
            }
          }
        }
        finally
        {
          for (;;)
          {
            synchronized (androidx.compose.runtime.f.l.ry())
            {
              localObject = androidx.compose.runtime.f.h.asx;
              androidx.compose.runtime.f.h localh = androidx.compose.runtime.f.l.rx();
              localObject = (a)androidx.compose.runtime.f.l.c((ab)this.anO, (aa)this, localh);
              ((a)localObject).anP = paramh;
              ((a)localObject).anQ = ((a)localObject).b((v)this, localh);
              ((a)localObject).result = parama1;
              ??? = androidx.compose.runtime.f.h.asx;
              androidx.compose.runtime.f.l.rx().rf();
              AppMethodBeat.o(202230);
              return localObject;
              break;
              paramh = finally;
              ??? = (List)???;
              m = ???.size() - 1;
              if (m >= 0)
              {
                i = k;
                j = i + 1;
                ((b)((r)???.get(i)).bsD).invoke((v)this);
                if (j <= m) {}
              }
              else
              {
                AppMethodBeat.o(202230);
                throw paramh;
              }
            }
            i = j;
            continue;
            label385:
            i = j;
          }
        }
      }
    }
  }
  
  public final ab a(ab paramab1, ab paramab2, ab paramab3)
  {
    AppMethodBeat.i(202282);
    paramab1 = aa.a.a(this, paramab1, paramab2, paramab3);
    AppMethodBeat.o(202282);
    return paramab1;
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(202247);
    s.u(paramab, "value");
    this.anO = ((a)paramab);
    AppMethodBeat.o(202247);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(202254);
    Object localObject = androidx.compose.runtime.f.h.asx;
    localObject = androidx.compose.runtime.f.l.rx().rh();
    if (localObject != null) {
      ((b)localObject).invoke(this);
    }
    localObject = pq();
    AppMethodBeat.o(202254);
    return localObject;
  }
  
  public final ab pp()
  {
    return (ab)this.anO;
  }
  
  public final T pq()
  {
    AppMethodBeat.i(202261);
    Object localObject = (ab)this.anO;
    h.a locala = androidx.compose.runtime.f.h.asx;
    localObject = (a)androidx.compose.runtime.f.l.a((ab)localObject, androidx.compose.runtime.f.l.rx());
    locala = androidx.compose.runtime.f.h.asx;
    localObject = a((a)localObject, androidx.compose.runtime.f.l.rx(), this.anN).result;
    AppMethodBeat.o(202261);
    return localObject;
  }
  
  public final Set<aa> pr()
  {
    AppMethodBeat.i(202270);
    Object localObject = (ab)this.anO;
    h.a locala = androidx.compose.runtime.f.h.asx;
    localObject = (a)androidx.compose.runtime.f.l.a((ab)localObject, androidx.compose.runtime.f.l.rx());
    locala = androidx.compose.runtime.f.h.asx;
    localObject = a((a)localObject, androidx.compose.runtime.f.l.rx(), this.anN).anP;
    if (localObject == null)
    {
      localObject = (Set)ad.aivA;
      AppMethodBeat.o(202270);
      return localObject;
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(202270);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202278);
    Object localObject1 = (ab)this.anO;
    Object localObject2 = androidx.compose.runtime.f.h.asx;
    androidx.compose.runtime.f.l.a((ab)localObject1, androidx.compose.runtime.f.l.rx());
    localObject2 = new StringBuilder("DerivedState(value=");
    localObject1 = (ab)this.anO;
    Object localObject3 = androidx.compose.runtime.f.h.asx;
    localObject1 = (a)androidx.compose.runtime.f.l.a((ab)localObject1, androidx.compose.runtime.f.l.rx());
    localObject3 = (v)this;
    h.a locala = androidx.compose.runtime.f.h.asx;
    if (((a)localObject1).a((v)localObject3, androidx.compose.runtime.f.l.rx())) {}
    for (localObject1 = String.valueOf(((a)localObject1).result);; localObject1 = "<Not calculated>")
    {
      localObject1 = (String)localObject1 + ")@" + hashCode();
      AppMethodBeat.o(202278);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "getDependencies", "()Ljava/util/HashSet;", "setDependencies", "(Ljava/util/HashSet;)V", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<T>
    extends ab
  {
    HashSet<aa> anP;
    int anQ;
    T result;
    
    public final boolean a(v<?> paramv, androidx.compose.runtime.f.h paramh)
    {
      AppMethodBeat.i(201877);
      s.u(paramv, "derivedState");
      s.u(paramh, "snapshot");
      if ((this.result != null) && (this.anQ == b(paramv, paramh)))
      {
        AppMethodBeat.o(201877);
        return true;
      }
      AppMethodBeat.o(201877);
      return false;
    }
    
    public final int b(v<?> paramv, androidx.compose.runtime.f.h paramh)
    {
      int k = 0;
      int j = 0;
      AppMethodBeat.i(201892);
      s.u(paramv, "derivedState");
      s.u(paramh, "snapshot");
      Object localObject2;
      Object localObject3;
      int n;
      int i;
      label91:
      int m;
      synchronized (androidx.compose.runtime.f.l.ry())
      {
        localObject2 = this.anP;
        if (localObject2 != null)
        {
          ??? = (androidx.compose.runtime.b.a.a.a.h)bj.qm().get();
          if (??? == null)
          {
            ??? = androidx.compose.runtime.b.a.a.a.a.a.l.qG();
            localObject3 = (List)???;
            n = ((List)localObject3).size() - 1;
            if (n >= 0)
            {
              i = 0;
              m = i + 1;
              ((b)((r)((List)localObject3).get(i)).bsC).invoke(paramv);
              if (m <= n) {
                break label382;
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = ((HashSet)localObject2).iterator();
          i = 7;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (aa)((Iterator)localObject2).next();
            ab localab = ((aa)localObject3).pp();
            s.s(localObject3, "stateObject");
            localObject3 = androidx.compose.runtime.f.l.a(localab, (aa)localObject3, paramh);
            m = System.identityHashCode(localObject3);
            n = ((ab)localObject3).att;
            i = (i * 31 + m) * 31 + n;
            continue;
            paramv = finally;
            AppMethodBeat.o(201892);
            throw paramv;
            break;
          }
          paramh = ah.aiuX;
          paramh = (List)???;
          m = paramh.size() - 1;
          if (m >= 0)
          {
            k = j + 1;
            ((b)((r)paramh.get(j)).bsD).invoke(paramv);
            if (k <= m) {
              break label375;
            }
          }
          AppMethodBeat.o(201892);
          return i;
        }
        finally
        {
          ??? = (List)???;
          m = ((List)???).size() - 1;
          if (m >= 0)
          {
            i = k;
            j = i + 1;
            ((b)((r)((List)???).get(i)).bsD).invoke(paramv);
            if (j <= m) {}
          }
          else
          {
            AppMethodBeat.o(201892);
          }
        }
        i = j;
        continue;
        label375:
        j = k;
        continue;
        label382:
        i = m;
        break label91;
        i = 7;
      }
    }
    
    public final void b(ab paramab)
    {
      AppMethodBeat.i(201863);
      s.u(paramab, "value");
      paramab = (a)paramab;
      this.anP = paramab.anP;
      this.result = paramab.result;
      this.anQ = paramab.anQ;
      AppMethodBeat.o(201863);
    }
    
    public final ab ps()
    {
      AppMethodBeat.i(201869);
      ab localab = (ab)new a();
      AppMethodBeat.o(201869);
      return localab;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<Object, ah>
  {
    b(u<T> paramu, HashSet<aa> paramHashSet)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.u
 * JD-Core Version:    0.7.0.1
 */