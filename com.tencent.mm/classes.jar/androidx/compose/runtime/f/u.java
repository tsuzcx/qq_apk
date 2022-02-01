package androidx.compose.runtime.f;

import androidx.compose.runtime.a.c;
import androidx.compose.runtime.a.d;
import androidx.compose.runtime.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "isObserving", "", "isPaused", "readObserver", "callOnChanged", "clear", "scope", "clearIf", "predicate", "ensureMap", "T", "onChanged", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "start", "stop", "withNoObservations", "ApplyMap", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final int Ue = 8;
  private final b<Object, ah> asp;
  private final b<a<ah>, ah> atd;
  private final m<Set<? extends Object>, h, ah> ate;
  public final e<a<?>> atf;
  private f atg;
  private boolean ath;
  private a<?> ati;
  private boolean isPaused;
  
  public u(b<? super a<ah>, ah> paramb)
  {
    AppMethodBeat.i(202485);
    this.atd = paramb;
    this.ate = ((m)new b(this));
    this.asp = ((b)new c(this));
    this.atf = new e(new a[16]);
    AppMethodBeat.o(202485);
  }
  
  public final <T> void a(T paramT, b<? super T, ah> paramb, a<ah> parama)
  {
    AppMethodBeat.i(202544);
    s.u(paramT, "scope");
    s.u(paramb, "onValueChangedForScope");
    s.u(parama, "block");
    a locala = this.ati;
    boolean bool = this.isPaused;
    Object localObject1;
    int k;
    int i;
    int j;
    d locald;
    int i4;
    label189:
    int i2;
    int i5;
    c localc;
    int m;
    int i6;
    int n;
    label241:
    int i3;
    Object localObject2;
    synchronized (this.atf)
    {
      localObject1 = this.atf;
      k = ((e)localObject1).size;
      if (k > 0)
      {
        i = 0;
        localObject1 = ((e)localObject1).aqq;
        if (((a)localObject1[i]).atj == paramb)
        {
          j = 1;
          break label651;
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label332;
        }
        paramb = new a(paramb);
        this.atf.add(paramb);
        localObject1 = paramb.atm;
        paramb.atm = paramT;
        this.ati = paramb;
        this.isPaused = false;
        if (this.ath) {
          break label605;
        }
        this.ath = true;
        try
        {
          synchronized (this.atf)
          {
            locald = paramb.atk;
            i = 0;
            j = 0;
            i4 = locald.size;
            if (i4 <= 0) {
              break label497;
            }
            k = 0;
            i2 = k + 1;
            i5 = locald.aqo[k];
            localc = locald.aqp[i5];
            s.checkNotNull(localc);
            i = 0;
            m = 0;
            i6 = localc.size();
            if (i6 <= 0) {
              break label398;
            }
            n = 0;
            i3 = n + 1;
            localObject2 = localc.aqm[n];
            if (localObject2 != null) {
              break label360;
            }
            paramT = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            AppMethodBeat.o(202544);
            throw paramT;
          }
          j = 0;
        }
        finally
        {
          this.ath = false;
          AppMethodBeat.o(202544);
        }
        break label651;
        label309:
        j = i + 1;
        i = j;
        if (j < k) {
          break;
        }
        i = -1;
      }
      label332:
      paramb = (a)this.atf.aqq[i];
    }
    label360:
    int i1;
    if (localObject2 == paramT)
    {
      i1 = 1;
      i = m;
      if (i1 != 0) {
        break label665;
      }
      if (m == n) {
        break label659;
      }
      localc.aqm[m] = localObject2;
      break label659;
      label398:
      i1 = localc.size();
      if (i < i1)
      {
        m = i;
        label416:
        n = m + 1;
        localc.aqm[m] = null;
        if (n < i1) {
          break label633;
        }
      }
      localc.size = i;
      i = j;
      if (localc.size() <= 0) {
        break label681;
      }
      if (j == k) {
        break label675;
      }
      i = locald.aqo[j];
      locald.aqo[j] = i5;
      locald.aqo[k] = i;
      break label675;
    }
    label651:
    label659:
    label665:
    label675:
    label681:
    for (;;)
    {
      label497:
      m = locald.size;
      if (i < m) {}
      for (j = i;; j = k)
      {
        k = j + 1;
        locald.aqm[locald.aqo[j]] = null;
        if (k >= m)
        {
          locald.size = i;
          paramT = ah.aiuX;
          paramT = h.asx;
          h.a.a(this.asp, parama);
          this.ath = false;
          for (;;)
          {
            this.ati = locala;
            paramb.atm = localObject1;
            this.isPaused = bool;
            AppMethodBeat.o(202544);
            return;
            i1 = 0;
            break;
            label605:
            parama.invoke();
          }
        }
      }
      label633:
      do
      {
        k = i2;
        j = i;
        break label189;
        m = n;
        break label416;
        do
        {
          n = i3;
          m = i;
          break label241;
          if (j == 0) {
            break label309;
          }
          break;
          i = m + 1;
        } while (i3 < i6);
        break label398;
        i = j + 1;
      } while (i2 < i4);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202583);
    for (;;)
    {
      int k;
      synchronized (this.atf)
      {
        Object localObject1 = this.atf;
        int m = ((e)localObject1).size;
        if (m > 0)
        {
          localObject1 = ((e)localObject1).aqq;
          int i = 0;
          d locald = ((a)localObject1[i]).atk;
          int n = locald.aqp.length;
          if (n > 0)
          {
            j = 0;
            k = j + 1;
            c localc = locald.aqp[j];
            if (localc != null) {
              localc.clear();
            }
            locald.aqo[j] = j;
            locald.aqm[j] = null;
            if (k < n) {
              break label162;
            }
          }
          locald.size = 0;
          i += 1;
          if (i < m) {}
        }
        else
        {
          localObject1 = ah.aiuX;
          AppMethodBeat.o(202583);
          return;
        }
      }
      continue;
      label162:
      int j = k;
    }
  }
  
  public final void h(a<ah> parama)
  {
    AppMethodBeat.i(202552);
    s.u(parama, "block");
    boolean bool = this.isPaused;
    this.isPaused = true;
    try
    {
      parama.invoke();
      return;
    }
    finally
    {
      this.isPaused = bool;
      AppMethodBeat.o(202552);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(202560);
    h.a locala = h.asx;
    this.atg = h.a.c(this.ate);
    AppMethodBeat.o(202560);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(202571);
    f localf = this.atg;
    if (localf != null) {
      localf.dispose();
    }
    AppMethodBeat.o(202571);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "T", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "getCurrentScope", "()Ljava/lang/Object;", "setCurrentScope", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "invalidated", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getInvalidated", "()Ljava/util/HashSet;", "map", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "getMap", "()Landroidx/compose/runtime/collection/IdentityScopeMap;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "addValue", "value", "callOnChanged", "scopes", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T>
  {
    final b<T, ah> atj;
    public final d<T> atk;
    final HashSet<Object> atl;
    T atm;
    
    public a(b<? super T, ah> paramb)
    {
      AppMethodBeat.i(202429);
      this.atj = paramb;
      this.atk = new d();
      this.atl = new HashSet();
      AppMethodBeat.o(202429);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applied", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<Set<? extends Object>, h, ah>
  {
    b(u paramu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements b<Object, ah>
  {
    c(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.u
 * JD-Core Version:    0.7.0.1
 */