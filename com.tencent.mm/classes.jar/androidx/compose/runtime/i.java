package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "collectParameterInformation", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData$annotations", "()V", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "getCompoundKeyHash", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "hasProvider", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerUpdates", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "startedGroup", "startedGroups", "writer", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "cleanUpCompose", "clearUpdatedNodeCounts", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "currentCompositionLocalScope", "disableReusing", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "insertedGroupVirtualIndex", "index", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "from", "to", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "rememberedValue", "resolveCompositionLocal", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)Ljava/lang/Object;", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "data", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements h
{
  final d<?> alG;
  final l alH;
  final be alI;
  private final Set<az> alJ;
  final List<q<d<?>, bg, ay, kotlin.ah>> alK;
  final s alL;
  private final bl<ar> alM;
  private ar alN;
  private int alO;
  private ad alP;
  private int alQ;
  private ad alR;
  private int[] alS;
  private HashMap<Integer, Integer> alT;
  private boolean alU;
  private boolean alV;
  final List<ae> alW;
  private final ad alX;
  private androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>> alY;
  private final HashMap<Integer, androidx.compose.runtime.b.a.a.a.i<p<Object>, bm<Object>>> alZ;
  private int amA;
  private boolean ama;
  private final ad amb;
  private boolean amc;
  private int amd;
  int ame;
  private androidx.compose.runtime.f.h amf;
  final bl<av> amg;
  boolean amh;
  boolean ami;
  bd amj;
  private final be amk;
  private bg aml;
  private boolean amm;
  private c amn;
  private final List<q<d<?>, bg, ay, kotlin.ah>> amo;
  private boolean amp;
  private int amq;
  private int amr;
  private bl<Object> ams;
  private int amt;
  private boolean amu;
  private final ad amv;
  private final bl<q<d<?>, bg, ay, kotlin.ah>> amw;
  private int amx;
  private int amy;
  private int amz;
  
  public i(d<?> paramd, l paraml, be parambe, Set<az> paramSet, List<q<d<?>, bg, ay, kotlin.ah>> paramList, s params)
  {
    AppMethodBeat.i(202417);
    this.alG = paramd;
    this.alH = paraml;
    this.alI = parambe;
    this.alJ = paramSet;
    this.alK = paramList;
    this.alL = params;
    this.alM = new bl();
    this.alP = new ad();
    this.alR = new ad();
    this.alW = ((List)new ArrayList());
    this.alX = new ad();
    this.alY = androidx.compose.runtime.b.a.a.a.a.qq();
    this.alZ = new HashMap();
    this.amb = new ad();
    this.amd = -1;
    this.amf = androidx.compose.runtime.f.l.rx();
    this.amg = new bl();
    paramd = this.alI.pW();
    paramd.close();
    paraml = kotlin.ah.aiuX;
    this.amj = paramd;
    this.amk = new be();
    paramd = this.amk.pX();
    paramd.close();
    paraml = kotlin.ah.aiuX;
    this.aml = paramd;
    paramd = this.amk.pW();
    try
    {
      paraml = paramd.bR(0);
      paramd.close();
      this.amn = paraml;
      this.amo = ((List)new ArrayList());
      this.ams = new bl();
      this.amv = new ad();
      this.amw = new bl();
      this.amx = -1;
      this.amy = -1;
      this.amz = -1;
      AppMethodBeat.o(202417);
      return;
    }
    finally
    {
      paramd.close();
      AppMethodBeat.o(202417);
    }
  }
  
  private final void H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202539);
    int m = bB(paramInt1);
    if (m != paramInt2)
    {
      int j = this.alM.aqh.size() - 1;
      int i = paramInt1;
      paramInt1 = j;
      while (i != -1)
      {
        int n = bB(i) + (paramInt2 - m);
        I(i, n);
        j = paramInt1;
        if (paramInt1 >= 0) {}
        int k;
        for (j = paramInt1;; j = k)
        {
          k = j - 1;
          ar localar = (ar)this.alM.aqh.get(j);
          if ((localar != null) && (localar.M(i, n))) {
            j -= 1;
          }
          do
          {
            if (i >= 0) {
              break label150;
            }
            i = this.amj.parent;
            paramInt1 = j;
            break;
            j = paramInt1;
          } while (k < 0);
        }
        label150:
        if (this.amj.bH(i)) {
          break;
        }
        i = this.amj.bG(i);
        paramInt1 = j;
      }
    }
    AppMethodBeat.o(202539);
  }
  
  private void H(Object paramObject)
  {
    AppMethodBeat.i(202455);
    if (this.amp)
    {
      this.aml.P(paramObject);
      if ((paramObject instanceof az))
      {
        b((q)new w(paramObject));
        AppMethodBeat.o(202455);
      }
    }
    else
    {
      a(true, (q)new x(paramObject, this, this.amj.pM() - 1));
    }
    AppMethodBeat.o(202455);
  }
  
  private final void I(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202559);
    if (bB(paramInt1) != paramInt2)
    {
      if (paramInt1 < 0)
      {
        localObject2 = this.alT;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = (i)this;
          localObject1 = new HashMap();
          ((i)localObject2).alT = ((HashMap)localObject1);
        }
        ((Map)localObject1).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        AppMethodBeat.o(202559);
        return;
      }
      Object localObject2 = this.alS;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (i)this;
        localObject1 = new int[((i)localObject2).amj.apC];
        kotlin.a.k.Z((int[])localObject1);
        ((i)localObject2).alS = ((int[])localObject1);
      }
      localObject1[paramInt1] = paramInt2;
    }
    AppMethodBeat.o(202559);
  }
  
  private final void I(Object paramObject)
  {
    AppMethodBeat.i(202698);
    this.ams.U(paramObject);
    AppMethodBeat.o(202698);
  }
  
  private final void J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202585);
    if ((paramInt1 > 0) && (paramInt1 != paramInt2))
    {
      J(this.amj.bG(paramInt1), paramInt2);
      if (this.amj.bH(paramInt1)) {
        I(this.amj.bJ(paramInt1));
      }
    }
    AppMethodBeat.o(202585);
  }
  
  private final void K(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202751);
    if (paramInt2 > 0)
    {
      if (paramInt1 >= 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        j.ah(kotlin.g.b.s.X("Invalid remove index ", Integer.valueOf(paramInt1)).toString());
        kotlin.f localf = new kotlin.f();
        AppMethodBeat.o(202751);
        throw localf;
      }
      if (this.amx == paramInt1)
      {
        this.amA += paramInt2;
        AppMethodBeat.o(202751);
        return;
      }
      oT();
      this.amx = paramInt1;
      this.amA = paramInt2;
    }
    AppMethodBeat.o(202751);
  }
  
  private static int a(bd parambd, int paramInt)
  {
    AppMethodBeat.i(202605);
    if (parambd.bM(paramInt))
    {
      parambd = parambd.bN(paramInt);
      if (parambd == null)
      {
        AppMethodBeat.o(202605);
        return 0;
      }
      paramInt = parambd.hashCode();
      AppMethodBeat.o(202605);
      return paramInt;
    }
    int i = parambd.bL(paramInt);
    if (i == 207)
    {
      parambd = parambd.bO(paramInt);
      if (parambd != null)
      {
        if (kotlin.g.b.s.p(parambd, h.a.ox()))
        {
          AppMethodBeat.o(202605);
          return i;
        }
        paramInt = parambd.hashCode();
        AppMethodBeat.o(202605);
        return paramInt;
      }
    }
    AppMethodBeat.o(202605);
    return i;
  }
  
  private final androidx.compose.runtime.b.a.a.a.i<p<Object>, bm<Object>> a(androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>> parami1, androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>> parami2)
  {
    AppMethodBeat.i(202464);
    parami1 = parami1.qt();
    ((Map)parami1).putAll((Map)parami2);
    parami1 = parami1.qu();
    j(204, j.ank);
    G(parami1);
    G(parami2);
    end(false);
    AppMethodBeat.o(202464);
    return parami1;
  }
  
  private static <T> T a(p<T> paramp, androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>> parami)
  {
    AppMethodBeat.i(202465);
    if (j.a(parami, paramp))
    {
      paramp = j.b(parami, paramp);
      AppMethodBeat.o(202465);
      return paramp;
    }
    paramp = paramp.anJ.nN();
    AppMethodBeat.o(202465);
    return paramp;
  }
  
  private final void a(int paramInt, Object paramObject1, boolean paramBoolean, Object paramObject2)
  {
    int i = 0;
    AppMethodBeat.i(202486);
    oK();
    b(paramInt, paramObject1, paramObject2);
    Object localObject2;
    Object localObject1;
    if (this.amp)
    {
      this.amj.pQ();
      i = this.aml.apF;
      if (paramBoolean) {
        this.aml.S(h.a.ox());
      }
      for (;;)
      {
        paramObject1 = this.alN;
        if (paramObject1 != null)
        {
          paramObject2 = new ah(paramInt, Integer.valueOf(-1), -2 - i, -1, 0);
          paramObject1.a(paramObject2, this.alO - paramObject1.startIndex);
          paramObject1.a(paramObject2);
        }
        a(paramBoolean, null);
        AppMethodBeat.o(202486);
        return;
        if (paramObject2 != null)
        {
          localObject2 = this.aml;
          localObject1 = paramObject1;
          if (paramObject1 == null) {
            localObject1 = h.a.ox();
          }
          ((bg)localObject2).d(paramInt, localObject1, paramObject2);
        }
        else
        {
          localObject1 = this.aml;
          paramObject2 = paramObject1;
          if (paramObject1 == null) {
            paramObject2 = h.a.ox();
          }
          ((bg)localObject1).j(paramInt, paramObject2);
        }
      }
    }
    int j;
    if (this.alN == null)
    {
      if ((this.amj.pL() == paramInt) && (kotlin.g.b.s.p(paramObject1, this.amj.pN()))) {
        b(paramBoolean, paramObject2);
      }
    }
    else
    {
      localObject2 = this.alN;
      if (localObject2 == null) {
        break label601;
      }
      localObject1 = ((ar)localObject2).k(paramInt, paramObject1);
      if (localObject1 == null) {
        break label395;
      }
      ((ar)localObject2).a((ah)localObject1);
      paramInt = ((ah)localObject1).location;
      this.alO = (((ar)localObject2).c((ah)localObject1) + ((ar)localObject2).startIndex);
      i = ((ar)localObject2).b((ah)localObject1);
      j = i - ((ar)localObject2).aoB;
      ((ar)localObject2).L(i, ((ar)localObject2).aoB);
      bC(paramInt);
      this.amj.bQ(paramInt);
      if (j > 0) {
        d((q)new t(j));
      }
      b(paramBoolean, paramObject2);
      paramObject1 = null;
    }
    for (;;)
    {
      a(paramBoolean, paramObject1);
      AppMethodBeat.o(202486);
      return;
      this.alN = new ar(this.amj.pV(), this.alO);
      break;
      label395:
      this.amj.pQ();
      this.amp = true;
      oF();
      this.aml.pZ();
      j = this.aml.apF;
      if (paramBoolean)
      {
        this.aml.S(h.a.ox());
        label441:
        this.amn = this.aml.bR(j);
        paramObject1 = new ah(paramInt, Integer.valueOf(-1), -2 - j, -1, 0);
        ((ar)localObject2).a(paramObject1, this.alO - ((ar)localObject2).startIndex);
        ((ar)localObject2).a(paramObject1);
        paramObject1 = (List)new ArrayList();
        if (!paramBoolean) {
          break label593;
        }
      }
      label593:
      for (paramInt = i;; paramInt = this.alO)
      {
        paramObject1 = new ar(paramObject1, paramInt);
        break;
        if (paramObject2 != null)
        {
          bg localbg = this.aml;
          localObject1 = paramObject1;
          if (paramObject1 == null) {
            localObject1 = h.a.ox();
          }
          localbg.d(paramInt, localObject1, paramObject2);
          break label441;
        }
        localObject1 = this.aml;
        paramObject2 = paramObject1;
        if (paramObject1 == null) {
          paramObject2 = h.a.ox();
        }
        ((bg)localObject1).j(paramInt, paramObject2);
        break label441;
      }
      label601:
      paramObject1 = null;
    }
  }
  
  private final void a(final c paramc)
  {
    AppMethodBeat.i(202712);
    if (this.amo.isEmpty())
    {
      d((q)new p(this.amk, paramc));
      AppMethodBeat.o(202712);
      return;
    }
    final List localList = kotlin.a.p.J((Collection)this.amo);
    this.amo.clear();
    oL();
    oM();
    d((q)new q(this.amk, paramc, localList));
    AppMethodBeat.o(202712);
  }
  
  private final void a(boolean paramBoolean, ar paramar)
  {
    AppMethodBeat.i(202492);
    this.alM.U(this.alN);
    this.alN = paramar;
    this.alP.bF(this.alO);
    if (paramBoolean) {
      this.alO = 0;
    }
    this.alR.bF(this.alQ);
    this.alQ = 0;
    AppMethodBeat.o(202492);
  }
  
  private final void a(boolean paramBoolean, q<? super d<?>, ? super bg, ? super ay, kotlin.ah> paramq)
  {
    AppMethodBeat.i(202668);
    an(paramBoolean);
    b(paramq);
    AppMethodBeat.o(202668);
  }
  
  private final void an(boolean paramBoolean)
  {
    AppMethodBeat.i(202708);
    int i;
    int k;
    if (paramBoolean)
    {
      i = this.amj.parent;
      k = i - this.amt;
      if (k < 0) {
        break label75;
      }
    }
    label75:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label80;
      }
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Tried to seek backward".toString());
      AppMethodBeat.o(202708);
      throw localThrowable;
      i = this.amj.apF;
      break;
    }
    label80:
    if (k > 0)
    {
      b((q)new n(k));
      this.amt = i;
    }
    AppMethodBeat.o(202708);
  }
  
  private final void b(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(202768);
    if (paramObject1 == null)
    {
      if ((paramObject2 != null) && (paramInt == 207) && (!kotlin.g.b.s.p(paramObject2, h.a.ox())))
      {
        bD(paramObject2.hashCode());
        AppMethodBeat.o(202768);
        return;
      }
      bD(paramInt);
      AppMethodBeat.o(202768);
      return;
    }
    if ((paramObject1 instanceof Enum))
    {
      bD(((Enum)paramObject1).ordinal());
      AppMethodBeat.o(202768);
      return;
    }
    bD(paramObject1.hashCode());
    AppMethodBeat.o(202768);
  }
  
  private final void b(q<? super d<?>, ? super bg, ? super ay, kotlin.ah> paramq)
  {
    AppMethodBeat.i(202640);
    this.alK.add(paramq);
    AppMethodBeat.o(202640);
  }
  
  private final void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(202473);
    if (paramBoolean)
    {
      paramObject = this.amj;
      if (paramObject.emptyCount <= 0)
      {
        if (!bf.f(paramObject.apB, paramObject.apF))
        {
          paramObject = (Throwable)new IllegalArgumentException("Expected a node group".toString());
          AppMethodBeat.o(202473);
          throw paramObject;
        }
        paramObject.pS();
      }
      AppMethodBeat.o(202473);
      return;
    }
    if ((paramObject != null) && (this.amj.pO() != paramObject)) {
      a(false, (q)new v(paramObject));
    }
    this.amj.pS();
    AppMethodBeat.o(202473);
  }
  
  private final void bA(int paramInt)
  {
    AppMethodBeat.i(202442);
    a(paramInt, null, false, null);
    AppMethodBeat.o(202442);
  }
  
  private final int bB(int paramInt)
  {
    AppMethodBeat.i(202549);
    if (paramInt < 0)
    {
      localObject = this.alT;
      if (localObject == null)
      {
        AppMethodBeat.o(202549);
        return 0;
      }
      localObject = (Integer)((HashMap)localObject).get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(202549);
        return 0;
      }
      paramInt = ((Integer)localObject).intValue();
      AppMethodBeat.o(202549);
      return paramInt;
    }
    Object localObject = this.alS;
    if (localObject != null)
    {
      int i = localObject[paramInt];
      if (i >= 0)
      {
        AppMethodBeat.o(202549);
        return i;
      }
    }
    paramInt = this.amj.bI(paramInt);
    AppMethodBeat.o(202549);
    return paramInt;
  }
  
  private final void bC(int paramInt)
  {
    this.amt = (paramInt - (this.amj.apF - this.amt));
  }
  
  private final void bD(int paramInt)
  {
    AppMethodBeat.i(202772);
    this.amq = (Integer.rotateLeft(this.amq, 3) ^ paramInt);
    AppMethodBeat.o(202772);
  }
  
  private final void bE(int paramInt)
  {
    AppMethodBeat.i(202786);
    this.amq = Integer.rotateRight(this.amq ^ paramInt, 3);
    AppMethodBeat.o(202786);
  }
  
  private final void c(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(202778);
    if (paramObject1 == null)
    {
      if ((paramObject2 != null) && (paramInt == 207) && (!kotlin.g.b.s.p(paramObject2, h.a.ox())))
      {
        bE(paramObject2.hashCode());
        AppMethodBeat.o(202778);
        return;
      }
      bE(paramInt);
      AppMethodBeat.o(202778);
      return;
    }
    if ((paramObject1 instanceof Enum))
    {
      bE(((Enum)paramObject1).ordinal());
      AppMethodBeat.o(202778);
      return;
    }
    bE(paramObject1.hashCode());
    AppMethodBeat.o(202778);
  }
  
  private final void c(q<? super d<?>, ? super bg, ? super ay, kotlin.ah> paramq)
  {
    AppMethodBeat.i(202646);
    oL();
    oM();
    b(paramq);
    AppMethodBeat.o(202646);
  }
  
  private final void c(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(202685);
    b((q)new k(paramArrayOfObject));
    AppMethodBeat.o(202685);
  }
  
  private final void d(q<? super d<?>, ? super bg, ? super ay, kotlin.ah> paramq)
  {
    AppMethodBeat.i(202656);
    an(false);
    oQ();
    b(paramq);
    AppMethodBeat.o(202656);
  }
  
  private final void e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202576);
    bd localbd = this.amj;
    paramInt3 = j.a(localbd, paramInt1, paramInt2, paramInt3);
    while ((paramInt1 > 0) && (paramInt1 != paramInt3))
    {
      if (localbd.bH(paramInt1)) {
        oN();
      }
      paramInt1 = localbd.bG(paramInt1);
    }
    J(paramInt2, paramInt3);
    AppMethodBeat.o(202576);
  }
  
  private final void e(q<? super d<?>, ? super bg, ? super ay, kotlin.ah> paramq)
  {
    AppMethodBeat.i(202715);
    this.amo.add(paramq);
    AppMethodBeat.o(202715);
  }
  
  private final void end(boolean paramBoolean)
  {
    AppMethodBeat.i(202513);
    int i;
    int j;
    ar localar;
    List localList1;
    List localList2;
    Set localSet1;
    Set localSet2;
    int n;
    int i1;
    int k;
    int m;
    Object localObject;
    if (this.amp)
    {
      i = this.aml.parent;
      c(this.aml.bL(i), this.aml.bN(i), this.aml.bO(i));
      j = this.alQ;
      localar = this.alN;
      if ((localar != null) && (localar.aoA.size() > 0))
      {
        localList1 = localar.aoA;
        localList2 = localar.aoC;
        localSet1 = androidx.compose.runtime.f.b.O(localList2);
        localSet2 = (Set)new LinkedHashSet();
        n = localList2.size();
        i = 0;
        i1 = localList1.size();
        k = 0;
        m = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i < i1)
        {
          ah localah = (ah)localList1.get(i);
          int i2;
          int i3;
          if (!localSet1.contains(localah))
          {
            K(localar.c(localah) + localar.startIndex, localah.aoo);
            localar.M(localah.location, 0);
            bC(localah.location);
            this.amj.bQ(localah.location);
            oP();
            this.amj.pT();
            localObject = this.alW;
            i2 = localah.location;
            i3 = localah.location;
            j.d((List)localObject, i2, this.amj.bK(localah.location) + i3);
            i += 1;
            continue;
            i = this.amj.parent;
            c(this.amj.bL(i), this.amj.bN(i), this.amj.bO(i));
            break;
          }
          if (localSet2.contains(localah))
          {
            i += 1;
          }
          else if (m < n)
          {
            localObject = (ah)localList2.get(m);
            if (localObject != localah)
            {
              i2 = localar.c((ah)localObject);
              localSet2.add(localObject);
              if (i2 == k) {
                break label754;
              }
              i3 = localar.d((ah)localObject);
              g(localar.startIndex + i2, localar.startIndex + k, i3);
              localar.h(i2, k, i3);
            }
          }
        }
      }
    }
    label749:
    label754:
    for (;;)
    {
      m += 1;
      k = localar.d((ah)localObject) + k;
      break;
      i += 1;
      continue;
      oT();
      if (localList1.size() > 0)
      {
        bC(this.amj.apG);
        this.amj.oi();
      }
      i = this.alO;
      while (!this.amj.pI())
      {
        k = this.amj.apF;
        oP();
        K(i, this.amj.pT());
        j.d(this.alW, k, this.amj.apF);
      }
      boolean bool = this.amp;
      if (bool)
      {
        if (!paramBoolean) {
          break label749;
        }
        oO();
      }
      for (i = 1;; i = j)
      {
        this.amj.pR();
        k = this.aml.parent;
        this.aml.qb();
        j = i;
        if (!this.amj.pJ())
        {
          k = -2 - k;
          this.aml.qa();
          this.aml.close();
          a(this.amn);
          this.amp = false;
          j = i;
          if (!this.alI.isEmpty())
          {
            I(k, 0);
            H(k, i);
          }
        }
        for (j = i;; j = i)
        {
          n(j, bool);
          AppMethodBeat.o(202513);
          return;
          if (paramBoolean) {
            oN();
          }
          oR();
          i = this.amj.parent;
          if (j != bB(i)) {
            H(i, j);
          }
          i = j;
          if (paramBoolean) {
            i = 1;
          }
          this.amj.pU();
          oT();
        }
      }
    }
  }
  
  private final int f(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202595);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(202595);
      return paramInt3;
    }
    paramInt2 = Integer.rotateLeft(f(this.amj.bG(paramInt1), paramInt2, paramInt3), 3);
    paramInt1 = a(this.amj, paramInt1);
    AppMethodBeat.o(202595);
    return paramInt2 ^ paramInt1;
  }
  
  private final void g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202758);
    if (paramInt3 > 0)
    {
      if ((this.amA > 0) && (this.amy == paramInt1 - this.amA) && (this.amz == paramInt2 - this.amA))
      {
        this.amA += paramInt3;
        AppMethodBeat.o(202758);
        return;
      }
      oT();
      this.amy = paramInt1;
      this.amz = paramInt2;
      this.amA = paramInt3;
    }
    AppMethodBeat.o(202758);
  }
  
  private final void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202445);
    a(paramInt, paramObject, false, null);
    AppMethodBeat.o(202445);
  }
  
  private final void n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202499);
    ar localar = (ar)this.alM.pop();
    if ((localar != null) && (!paramBoolean)) {
      localar.aoB += 1;
    }
    this.alN = localar;
    this.alO = (this.alP.pv() + paramInt);
    this.alQ = (this.alR.pv() + paramInt);
    AppMethodBeat.o(202499);
  }
  
  private final void oA()
  {
    AppMethodBeat.i(202437);
    oS();
    this.alM.aqh.clear();
    this.alP.aod = 0;
    this.alR.aod = 0;
    this.alX.aod = 0;
    this.amb.aod = 0;
    this.amj.close();
    this.amq = 0;
    this.ame = 0;
    this.alV = false;
    this.amh = false;
    AppMethodBeat.o(202437);
  }
  
  private final void oB()
  {
    AppMethodBeat.i(202446);
    this.alQ += this.amj.pT();
    AppMethodBeat.o(202446);
  }
  
  private Object oC()
  {
    AppMethodBeat.i(202451);
    if (this.amp)
    {
      oK();
      localObject = h.a.ox();
      AppMethodBeat.o(202451);
      return localObject;
    }
    Object localObject = this.amj.next();
    if (this.amc)
    {
      localObject = h.a.ox();
      AppMethodBeat.o(202451);
      return localObject;
    }
    AppMethodBeat.o(202451);
    return localObject;
  }
  
  private final androidx.compose.runtime.b.a.a.a.i<p<Object>, bm<Object>> oD()
  {
    AppMethodBeat.i(202461);
    int i;
    if ((this.amp) && (this.amm)) {
      for (i = this.aml.parent; i > 0; i = this.aml.bG(i)) {
        if ((this.aml.bL(i) == 202) && (kotlin.g.b.s.p(this.aml.bN(i), j.ani)))
        {
          localObject = this.aml.bO(i);
          if (localObject == null)
          {
            localObject = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            AppMethodBeat.o(202461);
            throw ((Throwable)localObject);
          }
          localObject = (androidx.compose.runtime.b.a.a.a.i)localObject;
          AppMethodBeat.o(202461);
          return localObject;
        }
      }
    }
    if (this.alI.apC > 0) {
      for (i = this.amj.parent; i > 0; i = this.amj.bG(i)) {
        if ((this.amj.bL(i) == 202) && (kotlin.g.b.s.p(this.amj.bN(i), j.ani)))
        {
          localObject = (androidx.compose.runtime.b.a.a.a.i)this.alZ.get(Integer.valueOf(i));
          if (localObject == null)
          {
            localObject = this.amj.bO(i);
            if (localObject == null)
            {
              localObject = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
              AppMethodBeat.o(202461);
              throw ((Throwable)localObject);
            }
            localObject = (androidx.compose.runtime.b.a.a.a.i)localObject;
            AppMethodBeat.o(202461);
            return localObject;
          }
          AppMethodBeat.o(202461);
          return localObject;
        }
      }
    }
    Object localObject = this.alY;
    AppMethodBeat.o(202461);
    return localObject;
  }
  
  private final void oF()
  {
    AppMethodBeat.i(202468);
    if (this.aml.closed)
    {
      this.aml = this.amk.pX();
      this.aml.oi();
      this.amm = false;
    }
    AppMethodBeat.o(202468);
  }
  
  private final void oG()
  {
    AppMethodBeat.i(202528);
    boolean bool = this.amh;
    this.amh = true;
    int j = 0;
    int i2 = this.amj.parent;
    int i8 = i2 + this.amj.bK(i2);
    int i1 = this.alO;
    int i6 = this.amq;
    int i7 = this.alQ;
    Object localObject1 = j.b(this.alW, this.amj.apF, i8);
    int i = i2;
    if (localObject1 != null)
    {
      int i9 = ((ae)localObject1).location;
      j.f(this.alW, i9);
      Object localObject2 = ((ae)localObject1).aoe;
      Object localObject3 = ((ae)localObject1).aof;
      int k;
      if (localObject3 != null)
      {
        localObject2 = ((av)localObject2).aoN;
        if ((localObject2 != null) && (((androidx.compose.runtime.a.c)localObject3).qn()))
        {
          localObject3 = (Iterable)localObject3;
          if ((!(localObject3 instanceof Collection)) || (!((Collection)localObject3).isEmpty()))
          {
            localObject3 = ((Iterable)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = ((Iterator)localObject3).next();
              if (((localObject4 instanceof v)) && (kotlin.g.b.s.p(((androidx.compose.runtime.a.b)localObject2).get(localObject4), ((v)localObject4).getValue())))
              {
                k = 1;
                label231:
                if (k != 0) {
                  break label319;
                }
                k = 0;
                label237:
                if (k == 0) {
                  break label326;
                }
                k = 0;
              }
            }
          }
        }
      }
      label319:
      label326:
      label463:
      for (;;)
      {
        label243:
        if (k != 0)
        {
          int i3 = 1;
          this.amj.bQ(i9);
          int i4 = this.amj.apF;
          e(i, i4, i2);
          j = this.amj.bG(i4);
          for (;;)
          {
            if ((j != i2) && (!this.amj.bH(j)))
            {
              j = this.amj.bG(j);
              continue;
              k = 0;
              break label231;
              break;
              k = 1;
              break label237;
              k = 1;
              break label243;
            }
          }
          if (this.amj.bH(j)) {}
          int m;
          for (i = 0;; i = i1)
          {
            m = i;
            if (j == i4) {
              break;
            }
            int i10 = bB(j);
            int i11 = this.amj.bI(i4);
            int n = j;
            m = i;
            j = m;
            m = j;
            if (j >= i + (i10 - i11)) {
              break;
            }
            m = j;
            if (n == i9) {
              break;
            }
            int i5;
            for (k = n + 1;; k = i5)
            {
              m = j;
              if (k >= i9) {
                break label463;
              }
              i5 = this.amj.bK(k) + k;
              m = j;
              n = k;
              if (i9 < i5) {
                break;
              }
              j += bB(k);
            }
          }
          this.alO = m;
          this.amq = f(this.amj.bG(i4), i2, i6);
          localObject2 = ((ae)localObject1).aoe;
          localObject1 = (h)this;
          kotlin.g.b.s.u(localObject1, "composer");
          localObject2 = ((av)localObject2).aoK;
          if (localObject2 == null) {}
          for (localObject1 = null; localObject1 == null; localObject1 = kotlin.ah.aiuX)
          {
            localObject1 = (Throwable)new IllegalStateException("Invalid restart scope".toString());
            AppMethodBeat.o(202528);
            throw ((Throwable)localObject1);
            ((m)localObject2).invoke(localObject1, Integer.valueOf(1));
          }
          localObject1 = this.amj;
          j = i2 + localObject1.apB[(i2 * 5 + 3)];
          k = ((bd)localObject1).apF;
          if ((k >= i2) && (k <= j)) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject1 = (Throwable)new IllegalArgumentException(("Index " + i2 + " is not a parent of " + k).toString());
            AppMethodBeat.o(202528);
            throw ((Throwable)localObject1);
          }
          ((bd)localObject1).parent = i2;
          ((bd)localObject1).apG = j;
          ((bd)localObject1).apH = 0;
          ((bd)localObject1).apI = 0;
          i = i4;
          j = i3;
        }
      }
      for (;;)
      {
        localObject1 = j.b(this.alW, this.amj.apF, i8);
        break;
        this.amg.U(((ae)localObject1).aoe);
        ((ae)localObject1).aoe.pD();
        this.amg.pop();
      }
    }
    if (j != 0)
    {
      e(i, i2, i2);
      this.amj.oi();
      i = bB(i2);
      this.alO = (i1 + i);
      this.alQ = (i + i7);
    }
    for (;;)
    {
      this.amq = i6;
      this.amh = bool;
      AppMethodBeat.o(202528);
      return;
      oI();
    }
  }
  
  private final void oH()
  {
    this.alS = null;
    this.alT = null;
  }
  
  private final void oI()
  {
    AppMethodBeat.i(202612);
    this.alQ = this.amj.pP();
    this.amj.oi();
    AppMethodBeat.o(202612);
  }
  
  private final void oJ()
  {
    AppMethodBeat.i(202624);
    if (!this.alV)
    {
      j.ah("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
      kotlin.f localf = new kotlin.f();
      AppMethodBeat.o(202624);
      throw localf;
    }
    this.alV = false;
    AppMethodBeat.o(202624);
  }
  
  private final void oK()
  {
    AppMethodBeat.i(202632);
    if (!this.alV) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("A call to createNode(), emitNode() or useNode() expected".toString());
      kotlin.f localf = new kotlin.f();
      AppMethodBeat.o(202632);
      throw localf;
    }
    AppMethodBeat.o(202632);
  }
  
  private final void oL()
  {
    AppMethodBeat.i(202680);
    int i = this.amr;
    if (i > 0)
    {
      this.amr = 0;
      b((q)new o(i));
    }
    AppMethodBeat.o(202680);
  }
  
  private final void oM()
  {
    AppMethodBeat.i(202693);
    if (this.ams.qn())
    {
      c(this.ams.toArray());
      this.ams.aqh.clear();
    }
    AppMethodBeat.o(202693);
  }
  
  private final void oN()
  {
    AppMethodBeat.i(202703);
    if (this.ams.qn())
    {
      this.ams.pop();
      AppMethodBeat.o(202703);
      return;
    }
    this.amr += 1;
    AppMethodBeat.o(202703);
  }
  
  private final void oO()
  {
    AppMethodBeat.i(202721);
    this.amo.add(this.amw.pop());
    AppMethodBeat.o(202721);
  }
  
  private final void oP()
  {
    AppMethodBeat.i(202725);
    d(j.anc);
    this.amt += this.amj.pK();
    AppMethodBeat.o(202725);
  }
  
  private final void oQ()
  {
    AppMethodBeat.i(202736);
    if (!this.alI.isEmpty())
    {
      Object localObject = this.amj;
      int i = ((bd)localObject).parent;
      if (this.amv.pw() != i)
      {
        if (!this.amu)
        {
          a(false, j.anf);
          this.amu = true;
        }
        localObject = ((bd)localObject).bR(i);
        this.amv.bF(i);
        a(false, (q)new s((c)localObject));
      }
    }
    AppMethodBeat.o(202736);
  }
  
  private final void oR()
  {
    AppMethodBeat.i(202740);
    int j = this.amj.parent;
    if (this.amv.pw() <= j) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Missed recording an endGroup".toString());
      kotlin.f localf = new kotlin.f();
      AppMethodBeat.o(202740);
      throw localf;
    }
    if (this.amv.pw() == j)
    {
      this.amv.pv();
      a(false, j.ane);
    }
    AppMethodBeat.o(202740);
  }
  
  private final void oS()
  {
    AppMethodBeat.i(202747);
    this.alN = null;
    this.alO = 0;
    this.alQ = 0;
    this.amt = 0;
    this.amq = 0;
    this.alV = false;
    this.amu = false;
    this.amv.aod = 0;
    this.amg.aqh.clear();
    oH();
    AppMethodBeat.o(202747);
  }
  
  private final void oT()
  {
    AppMethodBeat.i(202763);
    final int i = this.amA;
    this.amA = 0;
    if (i > 0)
    {
      if (this.amx >= 0)
      {
        j = this.amx;
        this.amx = -1;
        c((q)new l(j, i));
        AppMethodBeat.o(202763);
        return;
      }
      int j = this.amy;
      this.amy = -1;
      final int k = this.amz;
      this.amz = -1;
      c((q)new m(j, k, i));
    }
    AppMethodBeat.o(202763);
  }
  
  private final void oy()
  {
    AppMethodBeat.i(202428);
    this.amj = this.alI.pW();
    bA(100);
    this.alH.oY();
    this.alY = this.alH.oX();
    Object localObject = this.amb;
    if (this.ama) {}
    for (int i = 1;; i = 0)
    {
      ((ad)localObject).bF(i);
      this.ama = G(this.alY);
      this.alU = this.alH.oV();
      localObject = (Set)a((p)androidx.compose.runtime.g.c.rT(), this.alY);
      if (localObject != null)
      {
        ((Set)localObject).add(this.alI);
        this.alH.d((Set)localObject);
      }
      bA(this.alH.oU());
      AppMethodBeat.o(202428);
      return;
    }
  }
  
  private final void oz()
  {
    int i = 0;
    AppMethodBeat.i(202435);
    end(false);
    this.alH.oZ();
    end(false);
    if (this.amu)
    {
      a(false, j.ane);
      this.amu = false;
    }
    oL();
    kotlin.f localf;
    if (!this.alM.aqh.isEmpty())
    {
      j.ah("Start/end imbalance".toString());
      localf = new kotlin.f();
      AppMethodBeat.o(202435);
      throw localf;
    }
    if (this.amv.aod == 0) {
      i = 1;
    }
    if (i == 0)
    {
      j.ah("Missed recording an endGroup()".toString());
      localf = new kotlin.f();
      AppMethodBeat.o(202435);
      throw localf;
    }
    oS();
    this.amj.close();
    AppMethodBeat.o(202435);
  }
  
  public final void E(Object paramObject)
  {
    AppMethodBeat.i(202934);
    if ((this.amj.pL() == 207) && (!kotlin.g.b.s.p(this.amj.pO(), paramObject)) && (this.amd < 0))
    {
      this.amd = this.amj.apF;
      this.amc = true;
    }
    a(207, null, false, paramObject);
    AppMethodBeat.o(202934);
  }
  
  public final void F(Object paramObject)
  {
    AppMethodBeat.i(203097);
    H(paramObject);
    AppMethodBeat.o(203097);
  }
  
  public final boolean G(Object paramObject)
  {
    AppMethodBeat.i(202966);
    if (!kotlin.g.b.s.p(oC(), paramObject))
    {
      H(paramObject);
      AppMethodBeat.o(202966);
      return true;
    }
    AppMethodBeat.o(202966);
    return false;
  }
  
  public final boolean H(float paramFloat)
  {
    AppMethodBeat.i(202978);
    Object localObject = oC();
    if ((localObject instanceof Float))
    {
      if (paramFloat == ((Number)localObject).floatValue()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(202978);
        return false;
      }
    }
    H(Float.valueOf(paramFloat));
    AppMethodBeat.o(202978);
    return true;
  }
  
  public final <T> T a(p<T> paramp)
  {
    AppMethodBeat.i(203020);
    kotlin.g.b.s.u(paramp, "key");
    paramp = a(paramp, oD());
    AppMethodBeat.o(203020);
    return paramp;
  }
  
  final void a(androidx.compose.runtime.a.b<av, androidx.compose.runtime.a.c<Object>> paramb, m<? super h, ? super Integer, kotlin.ah> paramm)
  {
    int j = 0;
    AppMethodBeat.i(203075);
    if (!this.amh) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Reentrant composition is not supported".toString());
      paramb = new kotlin.f();
      AppMethodBeat.o(203075);
      throw paramb;
    }
    Object localObject = bq.aqj;
    bq.ai("Compose:recompose");
    for (;;)
    {
      int k;
      try
      {
        this.amf = androidx.compose.runtime.f.l.rx();
        k = paramb.size;
        if (k <= 0) {
          break label239;
        }
        i = j;
        j = i + 1;
        localObject = paramb.aqk[i];
        if (localObject == null)
        {
          paramb = new NullPointerException("null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
          AppMethodBeat.o(203075);
          throw paramb;
        }
      }
      finally
      {
        paramm = bq.aqj;
        bq.qo();
        AppMethodBeat.o(203075);
      }
      androidx.compose.runtime.a.c localc = (androidx.compose.runtime.a.c)paramb.aqm[i];
      av localav = (av)localObject;
      localObject = localav.aoJ;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Integer.valueOf(((c)localObject).location))
      {
        paramb = bq.aqj;
        bq.qo();
        AppMethodBeat.o(203075);
        return;
      }
      i = ((Integer)localObject).intValue();
      this.alW.add(new ae(localav, i, localc));
      if (j >= k)
      {
        label239:
        paramb = this.alW;
        if (paramb.size() > 1) {
          kotlin.a.p.a(paramb, (Comparator)new i());
        }
        this.alO = 0;
        this.amh = true;
        try
        {
          oy();
          bj.a((kotlin.g.a.b)new f(this), (kotlin.g.a.b)new g(this), (kotlin.g.a.a)new h(paramm, this));
          oz();
          this.amh = false;
          this.alW.clear();
          this.alZ.clear();
          paramb = kotlin.ah.aiuX;
          paramb = bq.aqj;
          bq.qo();
          AppMethodBeat.o(203075);
          return;
        }
        finally
        {
          this.amh = false;
          this.alW.clear();
          this.alZ.clear();
          oA();
          AppMethodBeat.o(203075);
        }
      }
      i = j;
    }
  }
  
  public final void a(au paramau)
  {
    AppMethodBeat.i(203104);
    kotlin.g.b.s.u(paramau, "scope");
    if ((paramau instanceof av)) {}
    for (paramau = (av)paramau;; paramau = null)
    {
      if (paramau != null) {
        paramau.pB();
      }
      AppMethodBeat.o(203104);
      return;
    }
  }
  
  public final <T> void a(kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(202918);
    kotlin.g.b.s.u(parama, "factory");
    oJ();
    if (!this.amp)
    {
      j.ah("createNode() can only be called when inserting".toString());
      parama = new kotlin.f();
      AppMethodBeat.o(202918);
      throw parama;
    }
    final int i = this.alP.px();
    final c localc = this.aml.bR(this.aml.parent);
    this.alQ += 1;
    e((q)new d(parama, localc, i));
    parama = (q)new e(localc, i);
    this.amw.U(parama);
    AppMethodBeat.o(202918);
  }
  
  public final void a(at<?>[] paramArrayOfat)
  {
    int i = 1;
    AppMethodBeat.i(203010);
    kotlin.g.b.s.u(paramArrayOfat, "values");
    Object localObject1 = oD();
    j(201, j.anh);
    j(203, j.anj);
    Object localObject2 = (h)this;
    paramArrayOfat = (m)new u(paramArrayOfat, (androidx.compose.runtime.b.a.a.a.i)localObject1);
    kotlin.g.b.s.u(localObject2, "composer");
    kotlin.g.b.s.u(paramArrayOfat, "composable");
    localObject2 = (androidx.compose.runtime.b.a.a.a.i)paramArrayOfat.invoke(localObject2, Integer.valueOf(1));
    end(false);
    boolean bool;
    if (this.amp)
    {
      paramArrayOfat = a((androidx.compose.runtime.b.a.a.a.i)localObject1, (androidx.compose.runtime.b.a.a.a.i)localObject2);
      this.amm = true;
      bool = false;
      if ((bool) && (!this.amp)) {
        ((Map)this.alZ).put(Integer.valueOf(this.amj.apF), paramArrayOfat);
      }
      localObject1 = this.amb;
      if (!this.ama) {
        break label335;
      }
    }
    for (;;)
    {
      ((ad)localObject1).bF(i);
      this.ama = bool;
      a(202, j.ani, false, paramArrayOfat);
      AppMethodBeat.o(203010);
      return;
      paramArrayOfat = this.amj.bP(0);
      if (paramArrayOfat == null)
      {
        paramArrayOfat = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
        AppMethodBeat.o(203010);
        throw paramArrayOfat;
      }
      paramArrayOfat = (androidx.compose.runtime.b.a.a.a.i)paramArrayOfat;
      Object localObject3 = this.amj.bP(1);
      if (localObject3 == null)
      {
        paramArrayOfat = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
        AppMethodBeat.o(203010);
        throw paramArrayOfat;
      }
      localObject3 = (androidx.compose.runtime.b.a.a.a.i)localObject3;
      if ((!nZ()) || (!kotlin.g.b.s.p(localObject3, localObject2)))
      {
        localObject1 = a((androidx.compose.runtime.b.a.a.a.i)localObject1, (androidx.compose.runtime.b.a.a.a.i)localObject2);
        if (!kotlin.g.b.s.p(localObject1, paramArrayOfat)) {}
        for (bool = true;; bool = false)
        {
          paramArrayOfat = (at<?>[])localObject1;
          break;
        }
      }
      oB();
      bool = false;
      break;
      label335:
      i = 0;
    }
  }
  
  public final boolean a(androidx.compose.runtime.a.b<av, androidx.compose.runtime.a.c<Object>> paramb)
  {
    AppMethodBeat.i(203062);
    kotlin.g.b.s.u(paramb, "invalidationsRequested");
    if (!this.alK.isEmpty())
    {
      j.ah("Expected applyChanges() to have been called".toString());
      paramb = new kotlin.f();
      AppMethodBeat.o(203062);
      throw paramb;
    }
    int i;
    if (paramb.size > 0)
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.alW).isEmpty()) {
          break label119;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        a(paramb, null);
        if (!((Collection)this.alK).isEmpty())
        {
          AppMethodBeat.o(203062);
          return true;
          i = 0;
          break;
          label119:
          i = 0;
          continue;
        }
        AppMethodBeat.o(203062);
        return false;
      }
    }
    AppMethodBeat.o(203062);
    return false;
  }
  
  public final boolean am(boolean paramBoolean)
  {
    AppMethodBeat.i(202972);
    Object localObject = oC();
    if (((localObject instanceof Boolean)) && (paramBoolean == ((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(202972);
      return false;
    }
    H(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(202972);
    return true;
  }
  
  public final void b(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(203001);
    kotlin.g.b.s.u(parama, "effect");
    b((q)new r(parama));
    AppMethodBeat.o(203001);
  }
  
  public final void bx(int paramInt)
  {
    AppMethodBeat.i(202840);
    a(paramInt, null, false, null);
    AppMethodBeat.o(202840);
  }
  
  public final h by(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(203047);
    a(paramInt, null, false, null);
    Object localObject1;
    if (this.amp)
    {
      localObject1 = new av((n)this.alL);
      this.amg.U(localObject1);
      H(localObject1);
      ((av)localObject1).start(this.amf.getId());
    }
    for (;;)
    {
      localObject1 = (h)this;
      AppMethodBeat.o(203047);
      return localObject1;
      localObject1 = j.f(this.alW, this.amj.parent);
      Object localObject2 = this.amj.next();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        AppMethodBeat.o(203047);
        throw ((Throwable)localObject1);
      }
      localObject2 = (av)localObject2;
      if (localObject1 != null) {
        bool = true;
      }
      ((av)localObject2).aq(bool);
      this.amg.U(localObject2);
      ((av)localObject2).start(this.amf.getId());
    }
  }
  
  public final boolean bz(int paramInt)
  {
    AppMethodBeat.i(202992);
    Object localObject = oC();
    if (((localObject instanceof Integer)) && (paramInt == ((Number)localObject).intValue()))
    {
      AppMethodBeat.o(202992);
      return false;
    }
    H(Integer.valueOf(paramInt));
    AppMethodBeat.o(202992);
    return true;
  }
  
  public final <V, T> void c(final V paramV, m<? super T, ? super V, kotlin.ah> paramm)
  {
    AppMethodBeat.i(202962);
    kotlin.g.b.s.u(paramm, "block");
    paramV = (q)new c(paramm, paramV);
    if (this.amp)
    {
      e(paramV);
      AppMethodBeat.o(202962);
      return;
    }
    c(paramV);
    AppMethodBeat.o(202962);
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202871);
    a(paramInt, paramObject, false, null);
    AppMethodBeat.o(202871);
  }
  
  public final d<?> nX()
  {
    return this.alG;
  }
  
  public final boolean nY()
  {
    return this.amp;
  }
  
  public final boolean nZ()
  {
    AppMethodBeat.i(202888);
    if ((!this.amp) && (!this.amc) && (!this.ama))
    {
      av localav = oE();
      if (localav != null) {
        if ((localav.flags & 0x8) != 0)
        {
          i = 1;
          if (i != 0) {
            break label71;
          }
        }
      }
      label71:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label76;
        }
        AppMethodBeat.o(202888);
        return true;
        i = 0;
        break;
      }
    }
    label76:
    AppMethodBeat.o(202888);
    return false;
  }
  
  public final av oE()
  {
    AppMethodBeat.i(203028);
    Object localObject = this.amg;
    if ((this.ame == 0) && (((bl)localObject).qn()))
    {
      localObject = (av)((bl)localObject).peek();
      AppMethodBeat.o(203028);
      return localObject;
    }
    AppMethodBeat.o(203028);
    return null;
  }
  
  public final boolean oa()
  {
    AppMethodBeat.i(202864);
    if (!this.ama)
    {
      av localav = oE();
      if (localav == null) {
        break label57;
      }
      if ((localav.flags & 0x4) == 0) {
        break label52;
      }
      i = 1;
      if (i != 1) {
        break label57;
      }
    }
    label52:
    label57:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label62;
      }
      AppMethodBeat.o(202864);
      return true;
      i = 0;
      break;
    }
    label62:
    AppMethodBeat.o(202864);
    return false;
  }
  
  public final au ob()
  {
    AppMethodBeat.i(203084);
    au localau = (au)oE();
    AppMethodBeat.o(203084);
    return localau;
  }
  
  public final int oc()
  {
    return this.amq;
  }
  
  public final void od()
  {
    AppMethodBeat.i(202845);
    end(false);
    AppMethodBeat.o(202845);
  }
  
  public final void oe()
  {
    AppMethodBeat.i(202877);
    end(false);
    AppMethodBeat.o(202877);
  }
  
  public final void of()
  {
    AppMethodBeat.i(202850);
    a(0, null, false, null);
    AppMethodBeat.o(202850);
  }
  
  public final void og()
  {
    AppMethodBeat.i(202855);
    end(false);
    av localav = oE();
    if ((localav != null) && (localav.pA())) {
      localav.flags |= 0x2;
    }
    AppMethodBeat.o(202855);
  }
  
  public final ba oh()
  {
    AppMethodBeat.i(203055);
    Object localObject1;
    int k;
    Object localObject2;
    int m;
    if (this.amg.qn())
    {
      localObject1 = (av)this.amg.pop();
      if (localObject1 != null) {
        ((av)localObject1).aq(false);
      }
      if (localObject1 == null) {
        break label189;
      }
      k = this.amf.getId();
      localObject2 = ((av)localObject1).aoM;
      if ((localObject2 == null) || (((av)localObject1).pC())) {
        break label298;
      }
      m = ((androidx.compose.runtime.a.a)localObject2).size;
      if (m <= 0) {
        break label293;
      }
    }
    int j;
    label146:
    label167:
    label189:
    label323:
    label329:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (localObject2.aqk[i] == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        AppMethodBeat.o(203055);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
      }
      if (localObject2.aql[i] != k)
      {
        i = 1;
        if (i == 0) {
          break label287;
        }
        i = 1;
        if (i == 0) {
          break label298;
        }
        localObject2 = (kotlin.g.a.b)new av.a((av)localObject1, k, (androidx.compose.runtime.a.a)localObject2);
        if (localObject2 != null) {
          b((q)new j((kotlin.g.a.b)localObject2, this));
        }
        if ((localObject1 == null) || (((av)localObject1).pC()) || ((!((av)localObject1).pA()) && (!this.alU))) {
          break label323;
        }
        if (((av)localObject1).aoJ == null)
        {
          if (!this.amp) {
            break label304;
          }
          localObject2 = this.aml.bR(this.aml.parent);
          label248:
          ((av)localObject1).aoJ = ((c)localObject2);
        }
        ((av)localObject1).ap(false);
      }
      for (;;)
      {
        end(false);
        localObject1 = (ba)localObject1;
        AppMethodBeat.o(203055);
        return localObject1;
        i = 0;
        break;
        if (j < m) {
          break label329;
        }
        i = 0;
        break label146;
        localObject2 = null;
        break label167;
        localObject2 = this.amj.bR(this.amj.parent);
        break label248;
        localObject1 = null;
      }
    }
  }
  
  public final void oi()
  {
    AppMethodBeat.i(203039);
    if (this.alQ == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("No nodes can be emitted before calling skipAndEndGroup".toString());
      localObject = new kotlin.f();
      AppMethodBeat.o(203039);
      throw ((Throwable)localObject);
    }
    Object localObject = oE();
    if (localObject != null) {
      ((av)localObject).as(true);
    }
    if (this.alW.isEmpty())
    {
      oI();
      AppMethodBeat.o(203039);
      return;
    }
    oG();
    AppMethodBeat.o(203039);
  }
  
  public final void oj()
  {
    AppMethodBeat.i(203035);
    if (this.alW.isEmpty())
    {
      oB();
      AppMethodBeat.o(203035);
      return;
    }
    bd localbd = this.amj;
    int i = localbd.pL();
    Object localObject1 = localbd.pN();
    Object localObject2 = localbd.pO();
    b(i, localObject1, localObject2);
    b(bf.f(localbd.apB, localbd.apF), null);
    oG();
    localbd.pU();
    c(i, localObject1, localObject2);
    AppMethodBeat.o(203035);
  }
  
  public final void ok()
  {
    int i = 126;
    AppMethodBeat.i(202904);
    if (!this.amp) {
      if (this.amc) {
        if (this.amj.pL() != 125) {}
      }
    }
    for (;;)
    {
      a(i, null, true, null);
      this.alV = true;
      AppMethodBeat.o(202904);
      return;
      i = 125;
      continue;
      if (this.amj.pL() != 126) {
        i = 125;
      }
    }
  }
  
  public final void ol()
  {
    AppMethodBeat.i(202910);
    a(125, null, true, null);
    this.alV = true;
    AppMethodBeat.o(202910);
  }
  
  public final void om()
  {
    AppMethodBeat.i(202924);
    oJ();
    if (!this.amp) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("useNode() called while inserting".toString());
      localObject = new kotlin.f();
      AppMethodBeat.o(202924);
      throw ((Throwable)localObject);
    }
    Object localObject = this.amj;
    I(((bd)localObject).bJ(((bd)localObject).parent));
    AppMethodBeat.o(202924);
  }
  
  public final void on()
  {
    AppMethodBeat.i(202930);
    end(true);
    AppMethodBeat.o(202930);
  }
  
  public final void oo()
  {
    AppMethodBeat.i(202940);
    if ((this.amc) && (this.amj.parent == this.amd))
    {
      this.amd = -1;
      this.amc = false;
    }
    end(false);
    AppMethodBeat.o(202940);
  }
  
  public final void op()
  {
    this.amc = false;
  }
  
  public final void oq()
  {
    if (this.amd >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.amc = bool;
      return;
    }
  }
  
  public final Object or()
  {
    AppMethodBeat.i(203089);
    Object localObject = oC();
    AppMethodBeat.o(203089);
    return localObject;
  }
  
  public final void os()
  {
    boolean bool = false;
    AppMethodBeat.i(203016);
    end(false);
    end(false);
    if (this.amb.pv() != 0) {
      bool = true;
    }
    this.ama = bool;
    AppMethodBeat.o(203016);
  }
  
  public final androidx.compose.runtime.g.a ot()
  {
    return (androidx.compose.runtime.g.a)this.alI;
  }
  
  public final void ou()
  {
    this.alU = true;
  }
  
  public final l ov()
  {
    AppMethodBeat.i(203025);
    j(206, j.anl);
    Object localObject1 = oC();
    if ((localObject1 instanceof a)) {}
    for (localObject1 = (a)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a(new b(this.amq, this.alU));
        H(localObject2);
      }
      localObject1 = ((a)localObject2).amB;
      androidx.compose.runtime.b.a.a.a.i locali = oD();
      kotlin.g.b.s.u(locali, "scope");
      ((b)localObject1).amG.setValue(locali);
      end(false);
      localObject1 = (l)((a)localObject2).amB;
      AppMethodBeat.o(203025);
      return localObject1;
    }
  }
  
  public final kotlin.d.f ow()
  {
    AppMethodBeat.i(202836);
    kotlin.d.f localf = this.alH.oW();
    AppMethodBeat.o(202836);
    return localf;
  }
  
  public final boolean y(long paramLong)
  {
    AppMethodBeat.i(202985);
    Object localObject = oC();
    if (((localObject instanceof Long)) && (paramLong == ((Number)localObject).longValue()))
    {
      AppMethodBeat.o(202985);
      return false;
    }
    H(Long.valueOf(paramLong));
    AppMethodBeat.o(202985);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements az
  {
    final i.b amB;
    
    public a(i.b paramb)
    {
      AppMethodBeat.i(202137);
      this.amB = paramb;
      AppMethodBeat.o(202137);
    }
    
    public final void mJ() {}
    
    public final void mK()
    {
      AppMethodBeat.i(202155);
      this.amB.dispose();
      AppMethodBeat.o(202155);
    }
    
    public final void mL()
    {
      AppMethodBeat.i(202151);
      this.amB.dispose();
      AppMethodBeat.o(202151);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends l
  {
    private final int amC;
    private final boolean amD;
    private Set<Set<androidx.compose.runtime.g.a>> amE;
    private final Set<i> amF;
    final an amG;
    
    public b(boolean paramBoolean)
    {
      AppMethodBeat.i(202168);
      this.amC = paramBoolean;
      boolean bool;
      this.amD = bool;
      this.amF = ((Set)new LinkedHashSet());
      this.amG = bj.T(androidx.compose.runtime.b.a.a.a.a.qq());
      AppMethodBeat.o(202168);
    }
    
    public final void a(s params)
    {
      AppMethodBeat.i(202204);
      kotlin.g.b.s.u(params, "composition");
      i.b(i.this).a(params);
      AppMethodBeat.o(202204);
    }
    
    public final void a(s params, m<? super h, ? super Integer, kotlin.ah> paramm)
    {
      AppMethodBeat.i(202218);
      kotlin.g.b.s.u(params, "composition");
      kotlin.g.b.s.u(paramm, "content");
      i.b(i.this).a(params, paramm);
      AppMethodBeat.o(202218);
    }
    
    public final void b(s params)
    {
      AppMethodBeat.i(202224);
      kotlin.g.b.s.u(params, "composition");
      i.b(i.this).b(i.this.alL);
      i.b(i.this).b(params);
      AppMethodBeat.o(202224);
    }
    
    public final void d(Set<androidx.compose.runtime.g.a> paramSet)
    {
      AppMethodBeat.i(202239);
      kotlin.g.b.s.u(paramSet, "table");
      Set localSet = this.amE;
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.amE = ((Set)localObject);
        localObject = (Set)localObject;
      }
      ((Set)localObject).add(paramSet);
      AppMethodBeat.o(202239);
    }
    
    public final void dispose()
    {
      AppMethodBeat.i(202186);
      int i;
      if (!((Collection)this.amF).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        Set localSet = this.amE;
        if (localSet != null)
        {
          Iterator localIterator1 = this.amF.iterator();
          for (;;)
          {
            if (localIterator1.hasNext())
            {
              i locali = (i)localIterator1.next();
              Iterator localIterator2 = localSet.iterator();
              while (localIterator2.hasNext()) {
                ((Set)localIterator2.next()).remove(i.d(locali));
              }
              continue;
              i = 0;
              break;
            }
          }
        }
        this.amF.clear();
      }
      AppMethodBeat.o(202186);
    }
    
    public final void n(h paramh)
    {
      AppMethodBeat.i(202190);
      kotlin.g.b.s.u(paramh, "composer");
      super.n((h)paramh);
      this.amF.add(paramh);
      AppMethodBeat.o(202190);
    }
    
    public final void o(h paramh)
    {
      AppMethodBeat.i(202196);
      kotlin.g.b.s.u(paramh, "composer");
      Object localObject = this.amE;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Set)((Iterator)localObject).next()).remove(i.d((i)paramh));
        }
      }
      localObject = (Collection)this.amF;
      if (localObject == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(202196);
        throw paramh;
      }
      kotlin.g.b.an.hA(localObject).remove(paramh);
      AppMethodBeat.o(202196);
    }
    
    public final int oU()
    {
      return this.amC;
    }
    
    public final boolean oV()
    {
      return this.amD;
    }
    
    public final kotlin.d.f oW()
    {
      AppMethodBeat.i(202213);
      kotlin.d.f localf = i.b(i.this).oW();
      AppMethodBeat.o(202213);
      return localf;
    }
    
    public final androidx.compose.runtime.b.a.a.a.i<p<Object>, bm<Object>> oX()
    {
      AppMethodBeat.i(202233);
      androidx.compose.runtime.b.a.a.a.i locali = (androidx.compose.runtime.b.a.a.a.i)((bm)this.amG).getValue();
      AppMethodBeat.o(202233);
      return locali;
    }
    
    public final void oY()
    {
      AppMethodBeat.i(202245);
      i locali = i.this;
      i.a(locali, i.c(locali) + 1);
      AppMethodBeat.o(202245);
    }
    
    public final void oZ()
    {
      AppMethodBeat.i(202251);
      i locali = i.this;
      i.a(locali, i.c(locali) - 1);
      AppMethodBeat.o(202251);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "V", "T", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    c(m<? super T, ? super V, kotlin.ah> paramm, V paramV)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    d(kotlin.g.a.a<? extends T> parama, c paramc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/runtime/State;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<bm<?>, kotlin.ah>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/runtime/State;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<bm<?>, kotlin.ah>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    h(m<? super h, ? super Integer, kotlin.ah> paramm, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class i<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(202113);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((ae)paramT1).location), (Comparable)Integer.valueOf(((ae)paramT2).location));
      AppMethodBeat.o(202113);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    j(kotlin.g.a.b<? super k, kotlin.ah> paramb, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    k(Object[] paramArrayOfObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    l(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    m(int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    n(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    o(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    p(be parambe, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    q(be parambe, c paramc, List<q<d<?>, bg, ay, kotlin.ah>> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    r(kotlin.g.a.a<kotlin.ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    s(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    t(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements m<h, Integer, androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>>>
  {
    u(at<?>[] paramArrayOfat, androidx.compose.runtime.b.a.a.a.i<p<Object>, ? extends bm<? extends Object>> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    v(Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    w(Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements q<d<?>, bg, ay, kotlin.ah>
  {
    x(Object paramObject, i parami, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.i
 * JD-Core Version:    0.7.0.1
 */