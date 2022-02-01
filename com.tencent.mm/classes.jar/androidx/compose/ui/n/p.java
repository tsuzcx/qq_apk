package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final boolean bq(long paramLong)
  {
    AppMethodBeat.i(204734);
    if (o.bm(paramLong) == 0L)
    {
      AppMethodBeat.o(204734);
      return true;
    }
    AppMethodBeat.o(204734);
    return false;
  }
  
  public static final long dG(int paramInt)
  {
    AppMethodBeat.i(204750);
    long l = i(4294967296L, paramInt);
    AppMethodBeat.o(204750);
    return l;
  }
  
  public static final long i(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(204760);
    paramLong = o.J(Float.floatToIntBits(paramFloat) & 0xFFFFFFFF | paramLong);
    AppMethodBeat.o(204760);
    return paramLong;
  }
  
  public static final long p(double paramDouble)
  {
    AppMethodBeat.i(204741);
    long l = i(4294967296L, (float)paramDouble);
    AppMethodBeat.o(204741);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.p
 * JD-Core Version:    0.7.0.1
 */