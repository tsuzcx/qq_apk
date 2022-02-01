package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.b;
import kotlin.k.c;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "", "current", "", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "(FLkotlin/ranges/ClosedFloatingPointRange;I)V", "getCurrent", "()F", "getRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "getSteps", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final f aWC;
  public static final a aWy;
  public final c<Float> aWA;
  public final int aWB;
  public final float aWz;
  
  static
  {
    AppMethodBeat.i(205441);
    aWy = new a((byte)0);
    aWC = new f((c)new b(), (byte)0);
    AppMethodBeat.o(205441);
  }
  
  private f(c<Float> paramc)
  {
    AppMethodBeat.i(205424);
    this.aWz = 0.0F;
    this.aWA = paramc;
    this.aWB = 0;
    AppMethodBeat.o(205424);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205447);
    if (this == paramObject)
    {
      AppMethodBeat.o(205447);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(205447);
      return false;
    }
    if (this.aWz == ((f)paramObject).aWz) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(205447);
      return false;
    }
    if (!s.p(this.aWA, ((f)paramObject).aWA))
    {
      AppMethodBeat.o(205447);
      return false;
    }
    if (this.aWB != ((f)paramObject).aWB)
    {
      AppMethodBeat.o(205447);
      return false;
    }
    AppMethodBeat.o(205447);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205450);
    int i = Float.floatToIntBits(this.aWz);
    int j = this.aWA.hashCode();
    int k = this.aWB;
    AppMethodBeat.o(205450);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205455);
    String str = "ProgressBarRangeInfo(current=" + this.aWz + ", range=" + this.aWA + ", steps=" + this.aWB + ')';
    AppMethodBeat.o(205455);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/ProgressBarRangeInfo$Companion;", "", "()V", "Indeterminate", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getIndeterminate", "()Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.k.f
 * JD-Core Version:    0.7.0.1
 */