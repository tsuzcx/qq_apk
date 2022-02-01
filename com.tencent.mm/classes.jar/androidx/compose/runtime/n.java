package androidx.compose.runtime;

import androidx.compose.runtime.a.b;
import androidx.compose.runtime.f.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "", "isComposing", "isDisposed", "isRoot", "lock", "observations", "observationsProcessed", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "addPendingInvalidationsLocked", "values", "", "applyChanges", "composeContent", "content", "dispose", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "block", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements s
{
  private final d<?> alG;
  private final be alI;
  private final List<q<d<?>, bg, ay, ah>> alK;
  private final kotlin.d.f anA;
  private final boolean anB;
  private boolean anC;
  private m<? super h, ? super Integer, ah> anD;
  private final l anq;
  private final AtomicReference<Object> anr;
  private final HashSet<az> ans;
  final androidx.compose.runtime.a.d<av> ant;
  private final androidx.compose.runtime.a.d<v<?>> anu;
  private final androidx.compose.runtime.a.d<av> anv;
  private b<av, androidx.compose.runtime.a.c<Object>> anw;
  boolean anx;
  private final i anz;
  private final Object lock;
  
  private n(l paraml, d<?> paramd)
  {
    AppMethodBeat.i(202290);
    this.anq = paraml;
    this.alG = paramd;
    this.anr = new AtomicReference(null);
    this.lock = new Object();
    this.ans = new HashSet();
    this.alI = new be();
    this.ant = new androidx.compose.runtime.a.d();
    this.anu = new androidx.compose.runtime.a.d();
    this.alK = ((List)new ArrayList());
    this.anv = new androidx.compose.runtime.a.d();
    this.anw = new b((byte)0);
    paraml = new i(this.alG, this.anq, this.alI, (Set)this.ans, this.alK, (s)this);
    this.anq.n((h)paraml);
    paramd = ah.aiuX;
    this.anz = paraml;
    this.anA = null;
    this.anB = (this.anq instanceof aw);
    paraml = f.alz;
    this.anD = f.nU();
    AppMethodBeat.o(202290);
  }
  
  private final void K(Object paramObject)
  {
    AppMethodBeat.i(202327);
    Object localObject = this.ant;
    int i = ((androidx.compose.runtime.a.d)localObject).V(paramObject);
    if (i >= 0)
    {
      localObject = ((Iterable)((androidx.compose.runtime.a.d)localObject).cb(i)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        av localav = (av)((Iterator)localObject).next();
        if (localav.O(paramObject) == af.aoj) {
          this.anv.g(paramObject, localav);
        }
      }
    }
    AppMethodBeat.o(202327);
  }
  
  private static final void a(n paramn, ah.f<HashSet<av>> paramf, Object paramObject)
  {
    AppMethodBeat.i(202343);
    Object localObject = paramn.ant;
    int i = ((androidx.compose.runtime.a.d)localObject).V(paramObject);
    if (i >= 0)
    {
      Iterator localIterator = ((Iterable)((androidx.compose.runtime.a.d)localObject).cb(i)).iterator();
      while (localIterator.hasNext())
      {
        av localav = (av)localIterator.next();
        if ((!paramn.anv.remove(paramObject, localav)) && (localav.O(paramObject) != af.aog))
        {
          HashSet localHashSet = (HashSet)paramf.aqH;
          localObject = localHashSet;
          if (localHashSet == null)
          {
            localObject = new HashSet();
            paramf.aqH = localObject;
          }
          ((HashSet)localObject).add(localav);
        }
      }
    }
    AppMethodBeat.o(202343);
  }
  
  private final void g(Set<? extends Object> paramSet)
  {
    AppMethodBeat.i(202317);
    Object localObject1 = new ah.f();
    paramSet = paramSet.iterator();
    Object localObject2;
    Object localObject3;
    int i;
    while (paramSet.hasNext())
    {
      localObject2 = paramSet.next();
      if ((localObject2 instanceof av))
      {
        ((av)localObject2).O(null);
      }
      else
      {
        a(this, (ah.f)localObject1, localObject2);
        localObject3 = this.anu;
        i = ((androidx.compose.runtime.a.d)localObject3).V(localObject2);
        if (i >= 0)
        {
          localObject2 = ((Iterable)((androidx.compose.runtime.a.d)localObject3).cb(i)).iterator();
          while (((Iterator)localObject2).hasNext()) {
            a(this, (ah.f)localObject1, (v)((Iterator)localObject2).next());
          }
        }
      }
    }
    paramSet = (HashSet)((ah.f)localObject1).aqH;
    int k;
    int j;
    int n;
    int m;
    label215:
    int i1;
    if (paramSet != null)
    {
      localObject1 = this.ant;
      int i2 = ((androidx.compose.runtime.a.d)localObject1).size;
      if (i2 <= 0) {
        break label484;
      }
      k = 0;
      j = 0;
      n = k + 1;
      int i3 = localObject1.aqo[k];
      localObject2 = localObject1.aqp[i3];
      kotlin.g.b.s.checkNotNull(localObject2);
      int i4 = ((androidx.compose.runtime.a.c)localObject2).size();
      if (i4 <= 0) {
        break label479;
      }
      m = 0;
      i = 0;
      i1 = m + 1;
      localObject3 = localObject2.aqm[m];
      if (localObject3 == null)
      {
        paramSet = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        AppMethodBeat.o(202317);
        throw paramSet;
      }
      if (paramSet.contains((av)localObject3)) {
        break label476;
      }
      if (i != m) {
        ((androidx.compose.runtime.a.c)localObject2).aqm[i] = localObject3;
      }
      i += 1;
      label286:
      if (i1 < i4) {
        break label469;
      }
      label293:
      i4 = ((androidx.compose.runtime.a.c)localObject2).size();
      if (i < i4)
      {
        m = i;
        label309:
        i1 = m + 1;
        ((androidx.compose.runtime.a.c)localObject2).aqm[m] = null;
        if (i1 < i4) {
          break label462;
        }
      }
      ((androidx.compose.runtime.a.c)localObject2).size = i;
      if (((androidx.compose.runtime.a.c)localObject2).size() <= 0) {
        break label457;
      }
      if (j != k)
      {
        i = localObject1.aqo[j];
        ((androidx.compose.runtime.a.d)localObject1).aqo[j] = i3;
        ((androidx.compose.runtime.a.d)localObject1).aqo[k] = i;
      }
      i = j + 1;
      label381:
      if (n < i2) {
        break label448;
      }
    }
    for (;;)
    {
      m = ((androidx.compose.runtime.a.d)localObject1).size;
      if (i < m) {}
      for (j = i;; j = k)
      {
        k = j + 1;
        ((androidx.compose.runtime.a.d)localObject1).aqm[localObject1.aqo[j]] = null;
        if (k >= m)
        {
          ((androidx.compose.runtime.a.d)localObject1).size = i;
          AppMethodBeat.o(202317);
          return;
        }
      }
      label448:
      k = n;
      j = i;
      break;
      label457:
      i = j;
      break label381;
      label462:
      m = i1;
      break label309;
      label469:
      m = i1;
      break label215;
      label476:
      break label286;
      label479:
      i = 0;
      break label293;
      label484:
      i = 0;
    }
  }
  
  private final void pe()
  {
    AppMethodBeat.i(202298);
    Object localObject = this.anr.getAndSet(o.pm());
    if (localObject != null)
    {
      if (kotlin.g.b.s.p(localObject, o.pm()))
      {
        localObject = (Throwable)new IllegalStateException("pending composition has not been applied".toString());
        AppMethodBeat.o(202298);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof Set))
      {
        g((Set)localObject);
        AppMethodBeat.o(202298);
        return;
      }
      if ((localObject instanceof Object[]))
      {
        localObject = (Set[])localObject;
        int i = 0;
        int j = localObject.length;
        while (i < j)
        {
          Set localSet = localObject[i];
          i += 1;
          g(localSet);
        }
      }
      localObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("corrupt pendingModifications drain: ", this.anr).toString());
      AppMethodBeat.o(202298);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(202298);
  }
  
  private final void pf()
  {
    AppMethodBeat.i(202302);
    Object localObject = this.anr.getAndSet(null);
    if (!kotlin.g.b.s.p(localObject, o.pm()))
    {
      if ((localObject instanceof Set))
      {
        g((Set)localObject);
        AppMethodBeat.o(202302);
        return;
      }
      if ((localObject instanceof Object[]))
      {
        localObject = (Set[])localObject;
        int i = 0;
        int j = localObject.length;
        while (i < j)
        {
          Set localSet = localObject[i];
          i += 1;
          g(localSet);
        }
      }
      if (localObject == null)
      {
        localObject = (Throwable)new IllegalStateException("calling recordModificationsOf and applyChanges concurrently is not supported".toString());
        AppMethodBeat.o(202302);
        throw ((Throwable)localObject);
      }
      localObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("corrupt pendingModifications drain: ", this.anr).toString());
      AppMethodBeat.o(202302);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(202302);
  }
  
  private final b<av, androidx.compose.runtime.a.c<Object>> pj()
  {
    AppMethodBeat.i(202333);
    b localb = this.anw;
    this.anw = new b((byte)0);
    AppMethodBeat.o(202333);
    return localb;
  }
  
  public final void J(Object paramObject)
  {
    AppMethodBeat.i(202409);
    kotlin.g.b.s.u(paramObject, "value");
    int i;
    if (this.anz.ame > 0) {
      i = 1;
    }
    av localav;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (i == 0)
      {
        localav = this.anz.oE();
        if (localav != null)
        {
          localav.pB();
          this.ant.g(paramObject, localav);
          if ((paramObject instanceof v))
          {
            localObject1 = ((Iterable)((v)paramObject).pr()).iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (aa)((Iterator)localObject1).next();
                this.anu.g(localObject2, paramObject);
                continue;
                i = 0;
                break;
              }
            }
          }
          kotlin.g.b.s.u(paramObject, "instance");
          if ((localav.flags & 0x20) != 0)
          {
            i = 1;
            if (i != 0) {
              break label354;
            }
            localObject1 = localav.aoM;
            if (localObject1 != null) {
              break label711;
            }
            localObject1 = new androidx.compose.runtime.a.a();
            localav.aoM = ((androidx.compose.runtime.a.a)localObject1);
          }
        }
      }
    }
    label697:
    label711:
    for (;;)
    {
      int m = localav.aoL;
      kotlin.g.b.s.u(paramObject, "key");
      int j;
      int n;
      int k;
      int i1;
      if (((androidx.compose.runtime.a.a)localObject1).size > 0)
      {
        j = ((androidx.compose.runtime.a.a)localObject1).size - 1;
        n = System.identityHashCode(paramObject);
        i = 0;
        for (;;)
        {
          if (i <= j)
          {
            k = i + j >>> 1;
            localObject2 = localObject1.aqk[k];
            i1 = System.identityHashCode(localObject2) - n;
            if (i1 < 0)
            {
              i = k + 1;
              continue;
              i = 0;
              break;
            }
            if (i1 > 0)
            {
              j = k - 1;
            }
            else
            {
              if (localObject2 == paramObject)
              {
                i = k;
                j = i;
                if (i < 0) {
                  break label490;
                }
                ((androidx.compose.runtime.a.a)localObject1).aql[i] = m;
                if ((paramObject instanceof v))
                {
                  localObject1 = localav.aoN;
                  if (localObject1 != null) {
                    break label697;
                  }
                  localObject1 = new b((byte)0);
                  localav.aoN = ((b)localObject1);
                  label339:
                  ((b)localObject1).set(paramObject, ((v)paramObject).pq());
                }
                label354:
                AppMethodBeat.o(202409);
                return;
              }
              i = k - 1;
              if (i < 0) {}
            }
          }
        }
      }
      for (;;)
      {
        j = i - 1;
        localObject2 = localObject1.aqk[i];
        if (localObject2 == paramObject) {
          break;
        }
        if ((System.identityHashCode(localObject2) != n) || (j < 0))
        {
          j = k + 1;
          i1 = ((androidx.compose.runtime.a.a)localObject1).size;
          if (j < i1) {}
          for (;;)
          {
            k = j + 1;
            localObject2 = localObject1.aqk[j];
            i = j;
            if (localObject2 == paramObject) {
              break;
            }
            if (System.identityHashCode(localObject2) != n)
            {
              i = -(j + 1);
              break;
            }
            if (k >= i1)
            {
              i = -(((androidx.compose.runtime.a.a)localObject1).size + 1);
              break;
              i = -(i + 1);
              break;
              j = -1;
              label490:
              i = -(j + 1);
              if (((androidx.compose.runtime.a.a)localObject1).size == ((androidx.compose.runtime.a.a)localObject1).aqk.length)
              {
                localObject2 = new Object[((androidx.compose.runtime.a.a)localObject1).aqk.length * 2];
                int[] arrayOfInt = new int[((androidx.compose.runtime.a.a)localObject1).aqk.length * 2];
                k.a(((androidx.compose.runtime.a.a)localObject1).aqk, (Object[])localObject2, i + 1, i, ((androidx.compose.runtime.a.a)localObject1).size);
                k.a(((androidx.compose.runtime.a.a)localObject1).aql, arrayOfInt, i + 1, i, ((androidx.compose.runtime.a.a)localObject1).size);
                k.a(((androidx.compose.runtime.a.a)localObject1).aqk, (Object[])localObject2, 0, 0, i, 6);
                k.a(((androidx.compose.runtime.a.a)localObject1).aql, arrayOfInt, i);
                ((androidx.compose.runtime.a.a)localObject1).aqk = ((Object[])localObject2);
                ((androidx.compose.runtime.a.a)localObject1).aql = arrayOfInt;
              }
              for (;;)
              {
                ((androidx.compose.runtime.a.a)localObject1).aqk[i] = paramObject;
                ((androidx.compose.runtime.a.a)localObject1).aql[i] = m;
                ((androidx.compose.runtime.a.a)localObject1).size += 1;
                break;
                k.a(((androidx.compose.runtime.a.a)localObject1).aqk, ((androidx.compose.runtime.a.a)localObject1).aqk, i + 1, i, ((androidx.compose.runtime.a.a)localObject1).size);
                k.a(((androidx.compose.runtime.a.a)localObject1).aql, ((androidx.compose.runtime.a.a)localObject1).aql, i + 1, i, ((androidx.compose.runtime.a.a)localObject1).size);
              }
              break label339;
            }
            j = k;
          }
        }
        i = j;
      }
    }
  }
  
  public final void L(Object paramObject)
  {
    AppMethodBeat.i(202412);
    kotlin.g.b.s.u(paramObject, "value");
    synchronized (this.lock)
    {
      K(paramObject);
      androidx.compose.runtime.a.d locald = this.anu;
      int i = locald.V(paramObject);
      if (i >= 0)
      {
        paramObject = ((Iterable)locald.cb(i)).iterator();
        if (paramObject.hasNext()) {
          K((v)paramObject.next());
        }
      }
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(202412);
  }
  
  public final af a(av paramav, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(202450);
    kotlin.g.b.s.u(paramav, "scope");
    Object localObject1;
    Object localObject2;
    if ((paramav.flags & 0x2) != 0)
    {
      i = 1;
      if (i != 0) {
        paramav.ap(true);
      }
      localObject1 = paramav.aoJ;
      if (localObject1 != null)
      {
        localObject2 = this.alI;
        kotlin.g.b.s.u(localObject1, "anchor");
        if (!((c)localObject1).nS()) {
          break label151;
        }
        i = bf.b(((be)localObject2).apL, ((c)localObject1).location, ((be)localObject2).apC);
        if ((i < 0) || (!kotlin.g.b.s.p(((be)localObject2).apL.get(i), localObject1))) {
          break label146;
        }
        i = 1;
        label111:
        if (i == 0) {
          break label151;
        }
      }
    }
    label146:
    label151:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (((c)localObject1).nS())) {
        break label156;
      }
      paramav = af.aog;
      AppMethodBeat.o(202450);
      return paramav;
      i = 0;
      break;
      i = 0;
      break label111;
    }
    label156:
    if (((c)localObject1).a(this.alI) < 0)
    {
      paramav = af.aog;
      AppMethodBeat.o(202450);
      return paramav;
    }
    if (this.anz.amh)
    {
      localObject1 = this.anz;
      kotlin.g.b.s.u(paramav, "scope");
      localObject2 = paramav.aoJ;
      i = j;
      if (localObject2 != null)
      {
        int k = ((c)localObject2).a(((i)localObject1).alI);
        i = j;
        if (((i)localObject1).amh)
        {
          i = j;
          if (k >= ((i)localObject1).amj.apF)
          {
            localObject2 = ((i)localObject1).alW;
            i = j.e((List)localObject2, k);
            if (i >= 0) {
              break label344;
            }
            i = -(i + 1);
            if (paramObject != null) {
              break label325;
            }
            localObject1 = null;
            ((List)localObject2).add(i, new ae(paramav, k, (androidx.compose.runtime.a.c)localObject1));
          }
        }
      }
      for (;;)
      {
        i = 1;
        if (i == 0) {
          break label397;
        }
        paramav = af.aoj;
        AppMethodBeat.o(202450);
        return paramav;
        label325:
        localObject1 = new androidx.compose.runtime.a.c();
        ((androidx.compose.runtime.a.c)localObject1).add(paramObject);
        break;
        label344:
        if (paramObject == null)
        {
          ((ae)((List)localObject2).get(i)).aof = null;
        }
        else
        {
          localObject1 = ((ae)((List)localObject2).get(i)).aof;
          if (localObject1 != null) {
            ((androidx.compose.runtime.a.c)localObject1).add(paramObject);
          }
        }
      }
    }
    label397:
    if (paramObject == null) {
      this.anw.set(paramav, null);
    }
    for (;;)
    {
      this.anq.b((s)this);
      if (!this.anz.amh) {
        break;
      }
      paramav = af.aoi;
      AppMethodBeat.o(202450);
      return paramav;
      o.a(this.anw, paramav, paramObject);
    }
    paramav = af.aoh;
    AppMethodBeat.o(202450);
    return paramav;
  }
  
  public final void a(m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(202363);
    kotlin.g.b.s.u(paramm, "content");
    i locali;
    b localb;
    synchronized (this.lock)
    {
      pe();
      locali = this.anz;
      localb = pj();
      kotlin.g.b.s.u(localb, "invalidationsRequested");
      kotlin.g.b.s.u(paramm, "content");
      if (!locali.alK.isEmpty())
      {
        j.ah("Expected applyChanges() to have been called".toString());
        paramm = new kotlin.f();
        AppMethodBeat.o(202363);
        throw paramm;
      }
    }
    locali.a(localb, paramm);
    paramm = ah.aiuX;
    AppMethodBeat.o(202363);
  }
  
  public final void c(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(202401);
    kotlin.g.b.s.u(parama, "block");
    i locali = this.anz;
    kotlin.g.b.s.u(parama, "block");
    if (!locali.amh) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Preparing a composition while composing is not supported".toString());
      parama = new kotlin.f();
      AppMethodBeat.o(202401);
      throw parama;
    }
    locali.amh = true;
    try
    {
      parama.invoke();
      return;
    }
    finally
    {
      locali.amh = false;
      AppMethodBeat.o(202401);
    }
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(202372);
    synchronized (this.lock)
    {
      Object localObject2;
      Object localObject5;
      if (!this.anC)
      {
        this.anC = true;
        localObject2 = f.alz;
        localObject2 = f.nV();
        kotlin.g.b.s.u(localObject2, "<set-?>");
        this.anD = ((m)localObject2);
        if (this.alI.apC > 0)
        {
          localObject5 = new a((Set)this.ans);
          localObject2 = this.alI.pX();
        }
      }
      try
      {
        j.a((bg)localObject2, (ay)localObject5);
        ah localah = ah.aiuX;
        ((bg)localObject2).close();
        this.alG.clear();
        ((a)localObject5).pk();
        localObject2 = this.anz;
        localObject5 = bq.aqj;
        bq.ai("Compose:Composer.dispose");
        localObject3 = finally;
      }
      finally
      {
        try
        {
          ((i)localObject2).alH.o((h)localObject2);
          ((i)localObject2).amg.aqh.clear();
          ((i)localObject2).alW.clear();
          ((i)localObject2).alK.clear();
          ((i)localObject2).alG.clear();
          ((i)localObject2).ami = true;
          localObject2 = ah.aiuX;
          localObject2 = bq.aqj;
          bq.qo();
          this.anq.a((s)this);
          this.anq.a((s)this);
          localObject2 = ah.aiuX;
          AppMethodBeat.o(202372);
          return;
        }
        finally
        {
          bq localbq = bq.aqj;
          bq.qo();
          AppMethodBeat.o(202372);
        }
        localObject6 = finally;
        ((bg)localObject2).close();
        AppMethodBeat.o(202372);
      }
    }
  }
  
  public final void e(Set<? extends Object> arg1)
  {
    AppMethodBeat.i(202383);
    kotlin.g.b.s.u(???, "values");
    Object localObject3 = this.anr.get();
    boolean bool;
    if (localObject3 == null) {
      bool = true;
    }
    for (;;)
    {
      Object localObject1;
      if (bool)
      {
        localObject1 = ???;
        label35:
        if (!this.anr.compareAndSet(localObject3, localObject1)) {
          break;
        }
        if (localObject3 != null) {
          break label205;
        }
      }
      synchronized (this.lock)
      {
        pf();
        localObject1 = ah.aiuX;
        AppMethodBeat.o(202383);
        return;
        bool = kotlin.g.b.s.p(localObject3, o.pm());
        continue;
        if ((localObject3 instanceof Set))
        {
          localObject1 = new Set[] { (Set)localObject3, ??? };
          break label35;
        }
        if ((localObject3 instanceof Object[]))
        {
          if (localObject3 == null)
          {
            ??? = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
            AppMethodBeat.o(202383);
            throw ???;
          }
          localObject1 = k.c((Set[])localObject3, ???);
          break label35;
        }
        ??? = (Throwable)new IllegalStateException(kotlin.g.b.s.X("corrupt pendingModifications: ", this.anr).toString());
        AppMethodBeat.o(202383);
        throw ???;
      }
    }
    label205:
    AppMethodBeat.o(202383);
  }
  
  public final boolean f(Set<? extends Object> paramSet)
  {
    AppMethodBeat.i(202392);
    kotlin.g.b.s.u(paramSet, "values");
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if ((this.ant.contains(localObject)) || (this.anu.contains(localObject)))
      {
        AppMethodBeat.o(202392);
        return true;
      }
    }
    AppMethodBeat.o(202392);
    return false;
  }
  
  public final boolean pa()
  {
    synchronized (this.lock)
    {
      int i = this.anw.size;
      if (i > 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean pb()
  {
    return this.anC;
  }
  
  public final boolean pd()
  {
    return this.anz.amh;
  }
  
  public final boolean pg()
  {
    AppMethodBeat.i(202426);
    synchronized (this.lock)
    {
      pe();
      boolean bool = this.anz.a(pj());
      if (!bool) {
        pf();
      }
      AppMethodBeat.o(202426);
      return bool;
    }
  }
  
  public final void ph()
  {
    AppMethodBeat.i(202440);
    Object localObject8;
    int i;
    int k;
    int j;
    label160:
    label187:
    int i3;
    label259:
    int i1;
    int i4;
    int i5;
    int m;
    label307:
    int i2;
    synchronized (this.lock)
    {
      a locala = new a((Set)this.ans);
      try
      {
        this.alG.nQ();
        Object localObject3 = this.alI.pX();
        Object localObject6;
        localObject2 = finally;
      }
      finally
      {
        try
        {
          localObject6 = this.alG;
          localObject8 = this.alK;
          i = 0;
          k = ((List)localObject8).size() - 1;
          if (k >= 0)
          {
            j = i + 1;
            ((q)((List)localObject8).get(i)).invoke(localObject6, localObject3, locala);
            if (j <= k) {
              break label956;
            }
          }
          this.alK.clear();
          localObject6 = ah.aiuX;
          ((bg)localObject3).close();
          this.alG.nR();
          locala.pk();
          if (((Collection)locala.anH).isEmpty()) {
            break label961;
          }
          i = 1;
          if (i != 0)
          {
            localObject3 = locala.anH;
            i = 0;
            k = ((List)localObject3).size() - 1;
            if (k >= 0)
            {
              j = i + 1;
              ((kotlin.g.a.a)((List)localObject3).get(i)).invoke();
              if (j <= k) {
                break label951;
              }
            }
            locala.anH.clear();
          }
          if (!this.anx) {
            break label851;
          }
          this.anx = false;
          localObject3 = this.ant;
          i = 0;
          i3 = ((androidx.compose.runtime.a.d)localObject3).size;
          if (i3 <= 0) {
            break label517;
          }
          k = 0;
          j = 0;
          i1 = k + 1;
          i4 = localObject3.aqo[k];
          localObject6 = localObject3.aqp[i4];
          kotlin.g.b.s.checkNotNull(localObject6);
          i = 0;
          i5 = ((androidx.compose.runtime.a.c)localObject6).size();
          if (i5 <= 0) {
            break label432;
          }
          m = 0;
          i = 0;
          i2 = m + 1;
          localObject8 = localObject6.aqm[m];
          if (localObject8 != null) {
            break label395;
          }
          localObject3 = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
          AppMethodBeat.o(202440);
          throw ((Throwable)localObject3);
        }
        finally
        {
          localObject4.close();
          AppMethodBeat.o(202440);
        }
        localObject4 = finally;
        locala.pl();
        AppMethodBeat.o(202440);
      }
    }
    label395:
    int n;
    label409:
    label432:
    label448:
    Object localObject5;
    if (!((av)localObject8).nS())
    {
      n = 1;
      if (n == 0)
      {
        if (i == m) {
          break label966;
        }
        localObject7.aqm[i] = localObject8;
        break label966;
        i2 = localObject7.size();
        if (i < i2)
        {
          m = i;
          n = m + 1;
          localObject7.aqm[m] = null;
          if (n < i2) {}
        }
        else
        {
          localObject7.size = i;
          if (localObject7.size() > 0)
          {
            if (j == k) {
              break label980;
            }
            i = localObject4.aqo[j];
            localObject4.aqo[j] = i4;
            localObject4.aqo[k] = i;
            break label980;
            label517:
            m = localObject4.size;
            if (i < m)
            {
              j = i;
              label532:
              k = j + 1;
              localObject4.aqm[localObject4.aqo[j]] = null;
              if (k < m) {}
            }
            else
            {
              localObject4.size = i;
              localObject5 = this.anu;
              i = 0;
              i3 = ((androidx.compose.runtime.a.d)localObject5).size;
              if (i3 > 0)
              {
                k = 0;
                j = 0;
                label586:
                i1 = k + 1;
                i4 = localObject5.aqo[k];
                androidx.compose.runtime.a.c localc = localObject5.aqp[i4];
                kotlin.g.b.s.checkNotNull(localc);
                i = 0;
                i5 = localc.size();
                if (i5 > 0)
                {
                  m = 0;
                  i = 0;
                  label634:
                  i2 = m + 1;
                  localObject8 = localc.aqm[m];
                  if (localObject8 == null)
                  {
                    localObject5 = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    AppMethodBeat.o(202440);
                    throw ((Throwable)localObject5);
                  }
                  v localv = (v)localObject8;
                  if (this.ant.contains(localv)) {
                    break label875;
                  }
                  n = 1;
                  if (n != 0) {
                    break label913;
                  }
                  if (i == m) {
                    break label1000;
                  }
                  localc.aqm[i] = localObject8;
                  break label1000;
                }
                label721:
                i2 = localc.size();
                if (i < i2)
                {
                  m = i;
                  label737:
                  n = m + 1;
                  localc.aqm[m] = null;
                  if (n < i2) {
                    break label899;
                  }
                }
                localc.size = i;
                if (localc.size() <= 0) {
                  break label894;
                }
                if (j == k) {
                  break label1014;
                }
                i = localObject5.aqo[j];
                ((androidx.compose.runtime.a.d)localObject5).aqo[j] = i4;
                ((androidx.compose.runtime.a.d)localObject5).aqo[k] = i;
                break label1014;
              }
            }
          }
        }
      }
    }
    label851:
    label875:
    label1014:
    for (;;)
    {
      m = ((androidx.compose.runtime.a.d)localObject5).size;
      if (i < m) {}
      for (j = i;; j = k)
      {
        k = j + 1;
        ((androidx.compose.runtime.a.d)localObject5).aqm[localObject5.aqo[j]] = null;
        if (k >= m)
        {
          ((androidx.compose.runtime.a.d)localObject5).size = i;
          localObject2.pl();
          pf();
          ah localah = ah.aiuX;
          AppMethodBeat.o(202440);
          return;
          n = 0;
          break;
        }
      }
      label894:
      do
      {
        k = i1;
        j = i;
        break label586;
        i = j;
        continue;
        m = n;
        break label737;
        do
        {
          m = i2;
          break label634;
          continue;
          j = k;
          break label532;
          do
          {
            k = i1;
            j = i;
            break label259;
            i = j;
            continue;
            m = n;
            break label448;
            do
            {
              m = i2;
              break label307;
              continue;
              i = j;
              break label187;
              i = j;
              break;
              i = 0;
              break label160;
              i += 1;
            } while (i2 < i5);
            break label432;
            i = j + 1;
          } while (i1 < i3);
          break label517;
          n = 0;
          break label409;
          i += 1;
        } while (i2 < i5);
        break label721;
        i = j + 1;
      } while (i1 < i3);
    }
  }
  
  public final void pi()
  {
    AppMethodBeat.i(202443);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        Object[] arrayOfObject = this.alI.apD;
        int j = arrayOfObject.length;
        i = 0;
        Object localObject1;
        if (i < j)
        {
          localObject1 = arrayOfObject[i];
          if (!(localObject1 instanceof av)) {
            break label96;
          }
          localObject1 = (av)localObject1;
          if (localObject1 != null) {
            ((av)localObject1).invalidate();
          }
        }
        else
        {
          localObject1 = ah.aiuX;
          AppMethodBeat.o(202443);
          return;
        }
      }
      i += 1;
      continue;
      label96:
      Object localObject3 = null;
    }
  }
  
  public final void setContent(m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(202356);
    kotlin.g.b.s.u(paramm, "content");
    if (!this.anC) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramm = (Throwable)new IllegalStateException("The composition is disposed".toString());
      AppMethodBeat.o(202356);
      throw paramm;
    }
    this.anD = paramm;
    this.anq.a((s)this, this.anD);
    AppMethodBeat.o(202356);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "remembering", "sideEffects", "Lkotlin/Function0;", "", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "instance", "sideEffect", "effect", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements ay
  {
    private final Set<az> anE;
    private final List<az> anF;
    private final List<az> anG;
    final List<kotlin.g.a.a<ah>> anH;
    
    public a(Set<az> paramSet)
    {
      AppMethodBeat.i(202301);
      this.anE = paramSet;
      this.anF = ((List)new ArrayList());
      this.anG = ((List)new ArrayList());
      this.anH = ((List)new ArrayList());
      AppMethodBeat.o(202301);
    }
    
    public final void a(az paramaz)
    {
      AppMethodBeat.i(202306);
      kotlin.g.b.s.u(paramaz, "instance");
      int i = this.anG.lastIndexOf(paramaz);
      if (i >= 0)
      {
        this.anG.remove(i);
        this.anE.remove(paramaz);
        AppMethodBeat.o(202306);
        return;
      }
      this.anF.add(paramaz);
      AppMethodBeat.o(202306);
    }
    
    public final void b(az paramaz)
    {
      AppMethodBeat.i(202311);
      kotlin.g.b.s.u(paramaz, "instance");
      int i = this.anF.lastIndexOf(paramaz);
      if (i >= 0)
      {
        this.anF.remove(i);
        this.anE.remove(paramaz);
        AppMethodBeat.o(202311);
        return;
      }
      this.anG.add(paramaz);
      AppMethodBeat.o(202311);
    }
    
    public final void d(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(202320);
      kotlin.g.b.s.u(parama, "effect");
      ((Collection)this.anH).add(parama);
      AppMethodBeat.o(202320);
    }
    
    public final void pk()
    {
      AppMethodBeat.i(202329);
      int i;
      if (!((Collection)this.anG).isEmpty())
      {
        i = 1;
        if (i != 0)
        {
          i = this.anG.size() - 1;
          if (i < 0) {}
        }
      }
      for (;;)
      {
        int j = i - 1;
        Object localObject = (az)this.anG.get(i);
        if (!this.anE.contains(localObject)) {
          ((az)localObject).mK();
        }
        if (j < 0)
        {
          label103:
          int k;
          if (!((Collection)this.anF).isEmpty())
          {
            i = 1;
            if (i != 0)
            {
              localObject = this.anF;
              k = ((List)localObject).size() - 1;
              if (k < 0) {}
            }
          }
          for (i = 0;; i = j)
          {
            j = i + 1;
            az localaz = (az)((List)localObject).get(i);
            this.anE.remove(localaz);
            localaz.mJ();
            if (j > k)
            {
              AppMethodBeat.o(202329);
              return;
              i = 0;
              break;
              i = 0;
              break label103;
            }
          }
        }
        i = j;
      }
    }
    
    public final void pl()
    {
      AppMethodBeat.i(202335);
      if (!((Collection)this.anE).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.anE.iterator();
        while (localIterator.hasNext())
        {
          az localaz = (az)localIterator.next();
          localIterator.remove();
          localaz.mL();
        }
      }
      AppMethodBeat.o(202335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.n
 * JD-Core Version:    0.7.0.1
 */