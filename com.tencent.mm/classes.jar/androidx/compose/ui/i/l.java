package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.h.x.a.a;
import androidx.compose.ui.n.b;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringMeasureLayout", "", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "dispatchOnPositionedCallbacks", "", "forceDispatch", "doRemeasure", "layoutNode", "doRemeasure-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)Z", "measureAndLayout", "onNodeDetached", "node", "requestRelayout", "requestRemeasure", "updateRootConstraints", "constraints", "updateRootConstraints-BRTryo0", "(J)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public final f aLw;
  public final c aPD;
  private final List<f> aPE;
  public boolean aPF;
  private final v aPG;
  private long aPH;
  public b aPI;
  private final k aPJ;
  
  public l(f paramf)
  {
    AppMethodBeat.i(204535);
    this.aLw = paramf;
    paramf = y.aQj;
    this.aPD = new c(y.a.yn());
    this.aPG = new v();
    this.aPH = 1L;
    this.aPE = ((List)new ArrayList());
    paramf = y.aQj;
    if (y.a.yn()) {}
    for (paramf = new k(this.aLw, this.aPD, this.aPE);; paramf = null)
    {
      this.aPJ = paramf;
      AppMethodBeat.o(204535);
      return;
    }
  }
  
  private final boolean a(f paramf, long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(204541);
    if (paramf == this.aLw) {}
    f localf;
    for (boolean bool = paramf.a(b.bb(paramLong));; bool = f.h(paramf))
    {
      localf = paramf.xu();
      if (!bool) {
        break label75;
      }
      if (localf != null) {
        break;
      }
      AppMethodBeat.o(204541);
      return true;
    }
    if (paramf.aOA == f.f.aOU) {
      t(localf);
    }
    for (;;)
    {
      label75:
      AppMethodBeat.o(204541);
      return false;
      if (paramf.aOA == f.f.aOV) {}
      while (i == 0)
      {
        paramf = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(204541);
        throw paramf;
        i = 0;
      }
      u(localf);
    }
  }
  
  private static boolean v(f paramf)
  {
    AppMethodBeat.i(204547);
    if ((paramf.aOn == f.d.aOO) && ((paramf.aOA == f.f.aOU) || (paramf.aOu.xO())))
    {
      AppMethodBeat.o(204547);
      return true;
    }
    AppMethodBeat.o(204547);
    return false;
  }
  
  public final void aw(boolean paramBoolean)
  {
    AppMethodBeat.i(204603);
    if (paramBoolean)
    {
      localv = this.aPG;
      localObject = this.aLw;
      s.u(localObject, "rootNode");
      localv.aPX.clear();
      localv.aPX.add(localObject);
      ((f)localObject).aOK = true;
    }
    v localv = this.aPG;
    localv.aPX.a((Comparator)v.a.a.aPY);
    Object localObject = localv.aPX;
    int i = ((e)localObject).size;
    if (i > 0)
    {
      localObject = ((e)localObject).aqq;
      i -= 1;
    }
    for (;;)
    {
      f localf = (f)localObject[i];
      if (localf.aOK) {
        localv.w(localf);
      }
      i -= 1;
      if (i < 0)
      {
        localv.aPX.clear();
        AppMethodBeat.o(204603);
        return;
      }
    }
  }
  
  public final long getMeasureIteration()
  {
    AppMethodBeat.i(204553);
    if (!this.aPF)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
      AppMethodBeat.o(204553);
      throw localThrowable;
    }
    long l = this.aPH;
    AppMethodBeat.o(204553);
    return l;
  }
  
  public final boolean t(f paramf)
  {
    AppMethodBeat.i(204561);
    s.u(paramf, "layoutNode");
    Object localObject = paramf.aOn;
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramf = new p();
      AppMethodBeat.o(204561);
      throw paramf;
    case 1: 
    case 2: 
      AppMethodBeat.o(204561);
      return false;
    case 3: 
      this.aPE.add(paramf);
      paramf = this.aPJ;
      if (paramf != null) {
        paramf.yc();
      }
      AppMethodBeat.o(204561);
      return false;
    }
    int i;
    if (this.aPF) {
      if (i.q(paramf).getMeasureIteration() == paramf.aOD.aPH)
      {
        i = 1;
        if (i == 0) {
          break label180;
        }
        this.aPE.add(paramf);
      }
    }
    label180:
    label236:
    for (;;)
    {
      if (this.aPF) {
        break label238;
      }
      AppMethodBeat.o(204561);
      return true;
      i = 0;
      break;
      paramf.a(f.d.aOO);
      if ((paramf.aOw) || (v(paramf)))
      {
        localObject = paramf.xu();
        if (localObject == null) {}
        for (localObject = null;; localObject = ((f)localObject).aOn)
        {
          if (localObject == f.d.aOO) {
            break label236;
          }
          this.aPD.d(paramf);
          break;
        }
      }
    }
    label238:
    AppMethodBeat.o(204561);
    return false;
  }
  
  public final boolean u(f paramf)
  {
    AppMethodBeat.i(204567);
    s.u(paramf, "layoutNode");
    Object localObject = paramf.aOn;
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramf = new p();
      AppMethodBeat.o(204567);
      throw paramf;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      paramf = this.aPJ;
      if (paramf != null) {
        paramf.yc();
      }
      AppMethodBeat.o(204567);
      return false;
    }
    paramf.a(f.d.aOQ);
    if (paramf.aOw)
    {
      localObject = paramf.xu();
      if (localObject != null) {
        break label159;
      }
    }
    label159:
    for (localObject = null;; localObject = ((f)localObject).aOn)
    {
      if ((localObject != f.d.aOO) && (localObject != f.d.aOQ)) {
        this.aPD.d(paramf);
      }
      if (this.aPF) {
        break;
      }
      AppMethodBeat.o(204567);
      return true;
    }
    AppMethodBeat.o(204567);
    return false;
  }
  
  public final boolean yd()
  {
    AppMethodBeat.i(204589);
    if (!this.aLw.isAttached())
    {
      localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(204589);
      throw ((Throwable)localObject1);
    }
    if (!this.aLw.aOw)
    {
      localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(204589);
      throw ((Throwable)localObject1);
    }
    if (!this.aPF) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(204589);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = this.aPI;
    if (localObject1 == null)
    {
      AppMethodBeat.o(204589);
      return false;
    }
    long l = ((b)localObject1).value;
    if (!this.aPD.aNV.isEmpty())
    {
      i = 1;
      if (i != 0) {
        this.aPF = true;
      }
    }
    for (;;)
    {
      boolean bool1;
      Object localObject4;
      int j;
      int k;
      try
      {
        localObject1 = this.aPD;
        bool1 = false;
        if (((c)localObject1).aNV.isEmpty()) {
          break label709;
        }
        i = 1;
        if (i == 0) {
          break label638;
        }
        Object localObject3 = (f)((c)localObject1).aNV.first();
        s.s(localObject3, "node");
        ((c)localObject1).e((f)localObject3);
        if ((!((f)localObject3).aOw) && (!v((f)localObject3)) && (!((f)localObject3).aOu.xO())) {
          break label684;
        }
        if ((((f)localObject3).aOn != f.d.aOO) || (!a((f)localObject3, l))) {
          break label681;
        }
        bool1 = true;
        if ((((f)localObject3).aOn == f.d.aOQ) && (((f)localObject3).aOw))
        {
          if (localObject3 != this.aLw) {
            continue;
          }
          localObject4 = x.a.aMX;
          i = ((f)localObject3).aOD.aPZ.wN();
          n localn = ((f)localObject3).agm;
          Object localObject5 = x.a.aMX;
          j = x.a.a.wV();
          localObject5 = x.a.aMX;
          localObject5 = x.a.a.wW();
          x.a.a locala = x.a.aMX;
          x.a.cP(i);
          locala = x.a.aMX;
          x.a.d(localn);
          x.a.a((x.a)localObject4, (x)((f)localObject3).aOD, 0, 0);
          localObject4 = x.a.aMX;
          x.a.cP(j);
          localObject4 = x.a.aMX;
          x.a.d((n)localObject5);
          localObject4 = this.aPG;
          s.u(localObject3, "node");
          ((v)localObject4).aPX.add(localObject3);
          ((f)localObject3).aOK = true;
          localObject3 = this.aPJ;
          if (localObject3 != null) {
            ((k)localObject3).yc();
          }
        }
        this.aPH = (getMeasureIteration() + 1L);
        if (((Collection)this.aPE).isEmpty()) {
          break label633;
        }
        i = 1;
        if (i == 0) {
          break label701;
        }
        localObject3 = this.aPE;
        k = ((List)localObject3).size() - 1;
        if (k >= 0)
        {
          i = 0;
          label505:
          j = i + 1;
          localObject4 = (f)((List)localObject3).get(i);
          if (!((f)localObject4).isAttached()) {
            break label693;
          }
          t((f)localObject4);
          break label693;
        }
        this.aPE.clear();
        break label701;
        localObject4 = ((f)localObject3).aOD;
        if (!((w)localObject4).aQb)
        {
          localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(204589);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        this.aPF = false;
        AppMethodBeat.o(204589);
      }
      ((w)localObject4).a(((w)localObject4).aQd, ((w)localObject4).aQf, ((w)localObject4).aQe);
      continue;
      label633:
      i = 0;
      continue;
      label638:
      this.aPF = false;
      k localk = this.aPJ;
      boolean bool2 = bool1;
      if (localk != null)
      {
        localk.yc();
        bool2 = bool1;
      }
      label667:
      AppMethodBeat.o(204589);
      return bool2;
      label681:
      label684:
      label693:
      do
      {
        i = j;
        break label505;
        break;
        break label701;
        bool2 = false;
        break label667;
      } while (j <= k);
      continue;
      label701:
      continue;
      i = 0;
      break;
      label709:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.l
 * JD-Core Version:    0.7.0.1
 */