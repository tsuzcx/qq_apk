package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Constraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "size", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final long a(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204724);
    paramLong = k(k.qu(b.aT(paramLong) + paramInt1, 0), al(b.aU(paramLong), paramInt1), k.qu(b.aV(paramLong) + paramInt2, 0), al(b.aW(paramLong), paramInt2));
    AppMethodBeat.o(204724);
    return paramLong;
  }
  
  private static final int al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204726);
    if (paramInt1 == 2147483647)
    {
      AppMethodBeat.o(204726);
      return paramInt1;
    }
    paramInt1 = k.qu(paramInt1 + paramInt2, 0);
    AppMethodBeat.o(204726);
    return paramInt1;
  }
  
  public static final int g(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204713);
    paramInt = k.bQ(paramInt, b.aT(paramLong), b.aU(paramLong));
    AppMethodBeat.o(204713);
    return paramInt;
  }
  
  public static final int h(long paramLong, int paramInt)
  {
    AppMethodBeat.i(204717);
    paramInt = k.bQ(paramInt, b.aV(paramLong), b.aW(paramLong));
    AppMethodBeat.o(204717);
    return paramInt;
  }
  
  public static final long k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 1;
    AppMethodBeat.i(204702);
    if (paramInt2 >= paramInt1) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(("maxWidth(" + paramInt2 + ") must be >= than minWidth(" + paramInt1 + ')').toString());
      AppMethodBeat.o(204702);
      throw ((Throwable)localObject);
    }
    if (paramInt4 >= paramInt3) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(("maxHeight(" + paramInt4 + ") must be >= than minHeight(" + paramInt3 + ')').toString());
      AppMethodBeat.o(204702);
      throw ((Throwable)localObject);
    }
    if ((paramInt1 >= 0) && (paramInt3 >= 0)) {}
    for (i = j; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(("minWidth(" + paramInt1 + ") and minHeight(" + paramInt3 + ") must be >= 0").toString());
      AppMethodBeat.o(204702);
      throw ((Throwable)localObject);
    }
    Object localObject = b.beE;
    long l = b.a.j(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(204702);
    return l;
  }
  
  public static final long q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(204709);
    paramLong1 = m.an(k.bQ(l.bi(paramLong2), b.aT(paramLong1), b.aU(paramLong1)), k.bQ(l.bj(paramLong2), b.aV(paramLong1), b.aW(paramLong1)));
    AppMethodBeat.o(204709);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.c
 * JD-Core Version:    0.7.0.1
 */