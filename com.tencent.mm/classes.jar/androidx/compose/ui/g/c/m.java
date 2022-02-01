package androidx.compose.ui.g.c;

import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getId-J3iCeTQ", "()J", "J", "getPosition-F1C5BW0", "getPressed", "()Z", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public final long aLm;
  public final boolean aLn;
  private final long aLo;
  public final long aLp;
  final boolean aLq;
  public final b aLr;
  public final long id;
  public final long position;
  public final int type;
  
  private m(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, long paramLong4, long paramLong5, boolean paramBoolean2, b paramb, int paramInt)
  {
    this.id = paramLong1;
    this.aLm = paramLong2;
    this.position = paramLong3;
    this.aLn = paramBoolean1;
    this.aLo = paramLong4;
    this.aLp = paramLong5;
    this.aLq = paramBoolean2;
    this.aLr = paramb;
    this.type = paramInt;
  }
  
  private static m a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, long paramLong4, long paramLong5, boolean paramBoolean2, b paramb, int paramInt)
  {
    AppMethodBeat.i(205813);
    s.u(paramb, "consumed");
    paramb = new m(paramLong1, paramLong2, paramLong3, paramBoolean1, paramLong4, paramLong5, paramBoolean2, paramb, paramInt, (byte)0);
    AppMethodBeat.o(205813);
    return paramb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205822);
    String str = "PointerInputChange(id=" + l.H(this.id) + ", uptimeMillis=" + this.aLm + ", position=" + e.H(this.position) + ", pressed=" + this.aLn + ", previousUptimeMillis=" + this.aLo + ", previousPosition=" + e.H(this.aLp) + ", previousPressed=" + this.aLq + ", consumed=" + this.aLr + ", type=" + y.cJ(this.type) + ')';
    AppMethodBeat.o(205822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.m
 * JD-Core Version:    0.7.0.1
 */