package androidx.compose.ui.g.c;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.e.a;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"anyChangeConsumed", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changedToDown", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "consumeAllChanges", "", "consumeDownChange", "consumePositionChange", "isOutOfBounds", "size", "Landroidx/compose/ui/unit/IntSize;", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "positionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeConsumed", "positionChangeIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "positionChanged", "positionChangedIgnoreConsumed", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final long a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(205905);
    long l = paramm.aLp;
    l = e.f(paramm.position, l);
    if ((!paramBoolean) && (paramm.aLr.aKS))
    {
      paramm = e.avo;
      l = e.su();
      AppMethodBeat.o(205905);
      return l;
    }
    AppMethodBeat.o(205905);
    return l;
  }
  
  public static final boolean a(m paramm)
  {
    AppMethodBeat.i(205858);
    s.u(paramm, "<this>");
    if ((!paramm.aLr.aKT) && (!paramm.aLq) && (paramm.aLn))
    {
      AppMethodBeat.o(205858);
      return true;
    }
    AppMethodBeat.o(205858);
    return false;
  }
  
  public static final boolean a(m paramm, long paramLong)
  {
    AppMethodBeat.i(205929);
    s.u(paramm, "$this$isOutOfBounds");
    long l = paramm.position;
    float f1 = e.F(l);
    float f2 = e.G(l);
    int i = l.bi(paramLong);
    int j = l.bj(paramLong);
    if ((f1 < 0.0F) || (f1 > i) || (f2 < 0.0F) || (f2 > j))
    {
      AppMethodBeat.o(205929);
      return true;
    }
    AppMethodBeat.o(205929);
    return false;
  }
  
  public static final boolean b(m paramm)
  {
    AppMethodBeat.i(205864);
    s.u(paramm, "<this>");
    if ((!paramm.aLq) && (paramm.aLn))
    {
      AppMethodBeat.o(205864);
      return true;
    }
    AppMethodBeat.o(205864);
    return false;
  }
  
  public static final boolean c(m paramm)
  {
    AppMethodBeat.i(205874);
    s.u(paramm, "<this>");
    if ((!paramm.aLr.aKT) && (paramm.aLq) && (!paramm.aLn))
    {
      AppMethodBeat.o(205874);
      return true;
    }
    AppMethodBeat.o(205874);
    return false;
  }
  
  public static final boolean d(m paramm)
  {
    AppMethodBeat.i(205880);
    s.u(paramm, "<this>");
    if ((paramm.aLq) && (!paramm.aLn))
    {
      AppMethodBeat.o(205880);
      return true;
    }
    AppMethodBeat.o(205880);
    return false;
  }
  
  public static final long e(m paramm)
  {
    AppMethodBeat.i(205889);
    s.u(paramm, "<this>");
    long l = a(paramm, false);
    AppMethodBeat.o(205889);
    return l;
  }
  
  public static final long f(m paramm)
  {
    AppMethodBeat.i(205897);
    s.u(paramm, "<this>");
    long l = a(paramm, true);
    AppMethodBeat.o(205897);
    return l;
  }
  
  public static final boolean g(m paramm)
  {
    AppMethodBeat.i(205910);
    s.u(paramm, "<this>");
    boolean bool = paramm.aLr.aKS;
    AppMethodBeat.o(205910);
    return bool;
  }
  
  public static final boolean h(m paramm)
  {
    AppMethodBeat.i(205913);
    s.u(paramm, "<this>");
    if ((g(paramm)) || (paramm.aLr.aKT))
    {
      AppMethodBeat.o(205913);
      return true;
    }
    AppMethodBeat.o(205913);
    return false;
  }
  
  public static final void i(m paramm)
  {
    AppMethodBeat.i(205917);
    s.u(paramm, "<this>");
    if (paramm.aLn != paramm.aLq) {
      paramm.aLr.aKT = true;
    }
    AppMethodBeat.o(205917);
  }
  
  public static final void j(m paramm)
  {
    AppMethodBeat.i(205921);
    s.u(paramm, "<this>");
    long l = e(paramm);
    e.a locala = e.avo;
    if (!e.e(l, e.su())) {
      paramm.aLr.aKS = true;
    }
    AppMethodBeat.o(205921);
  }
  
  public static final void k(m paramm)
  {
    AppMethodBeat.i(205924);
    s.u(paramm, "<this>");
    i(paramm);
    j(paramm);
    AppMethodBeat.o(205924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.j
 * JD-Core Version:    0.7.0.1
 */