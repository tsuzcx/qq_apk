package androidx.compose.ui.n;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "isEm", "", "isEm-impl", "(J)Z", "isSp", "isSp-impl", "rawType", "getRawType$annotations", "()V", "getRawType-impl", "type", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "value", "", "getValue-impl", "(J)F", "compareTo", "", "other", "compareTo--R2X_6o", "(JJ)I", "div", "", "div-kPz2Gy4", "(JD)J", "(JF)J", "(JI)J", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "times", "times-kPz2Gy4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-XSAIIZE", "Companion", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final long avr;
  public static final a beS;
  private static final q[] beT;
  public final long avp;
  
  static
  {
    AppMethodBeat.i(204842);
    beS = new a((byte)0);
    Object localObject1 = q.beU;
    localObject1 = q.br(q.sw());
    Object localObject2 = q.beU;
    localObject2 = q.br(q.Ci());
    q.a locala = q.beU;
    beT = new q[] { localObject1, localObject2, q.br(q.Cj()) };
    avr = p.i(0L, (0.0F / 0.0F));
    AppMethodBeat.o(204842);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(204758);
    long l = bn(paramLong);
    Object localObject = q.beU;
    if (q.e(l, q.sw()))
    {
      AppMethodBeat.o(204758);
      return "Unspecified";
    }
    localObject = q.beU;
    if (q.e(l, q.Ci()))
    {
      localObject = bo(paramLong) + ".sp";
      AppMethodBeat.o(204758);
      return localObject;
    }
    localObject = q.beU;
    if (q.e(l, q.Cj()))
    {
      localObject = bo(paramLong) + ".em";
      AppMethodBeat.o(204758);
      return localObject;
    }
    AppMethodBeat.o(204758);
    return "Invalid";
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(204797);
    int i = q.a..ExternalSyntheticBackport0.m(paramLong);
    AppMethodBeat.o(204797);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final long bm(long paramLong)
  {
    return 0x0 & paramLong;
  }
  
  public static final long bn(long paramLong)
  {
    return beT[((int)((0x0 & paramLong) >>> 32))].beV;
  }
  
  public static final float bo(long paramLong)
  {
    AppMethodBeat.i(204787);
    m localm = m.aiwV;
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(204787);
    return f;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.avp;
    if (!(paramObject instanceof o)) {}
    while (l != ((o)paramObject).avp) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204859);
    int i = q.a..ExternalSyntheticBackport0.m(this.avp);
    AppMethodBeat.o(204859);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204852);
    String str = H(this.avp);
    AppMethodBeat.o(204852);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit_release", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.o
 * JD-Core Version:    0.7.0.1
 */