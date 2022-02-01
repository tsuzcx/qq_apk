package androidx.compose.runtime.c;

import androidx.compose.runtime.au;
import androidx.compose.runtime.av;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"BITS_PER_SLOT", "", "SLOTS_PER_INT", "bitsForSlot", "bits", "slot", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "", "block", "", "composableLambdaInstance", "differentBits", "sameBits", "replacableWith", "Landroidx/compose/runtime/RecomposeScope;", "other", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final int W(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2 % 10 * 3 + 1;
  }
  
  public static final a a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(202295);
    s.u(paramObject, "block");
    b localb = new b(paramInt, paramBoolean);
    localb.ag(paramObject);
    paramObject = (a)localb;
    AppMethodBeat.o(202295);
    return paramObject;
  }
  
  public static final a a(h paramh, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(202289);
    s.u(paramh, "composer");
    s.u(paramObject, "block");
    paramh.bx(paramInt);
    Object localObject = paramh.or();
    h.a locala = h.alD;
    if (localObject == h.a.ox())
    {
      localObject = new b(paramInt, true);
      paramh.F(localObject);
    }
    for (;;)
    {
      ((b)localObject).ag(paramObject);
      paramh.od();
      paramh = (a)localObject;
      AppMethodBeat.o(202289);
      return paramh;
      if (localObject == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
        AppMethodBeat.o(202289);
        throw paramh;
      }
      localObject = (b)localObject;
    }
  }
  
  public static final boolean a(au paramau1, au paramau2)
  {
    AppMethodBeat.i(202284);
    s.u(paramau2, "other");
    if ((paramau1 == null) || (((paramau1 instanceof av)) && ((paramau2 instanceof av)) && ((!((av)paramau1).nS()) || (s.p(paramau1, paramau2)) || (s.p(((av)paramau1).aoJ, ((av)paramau2).aoJ)))))
    {
      AppMethodBeat.o(202284);
      return true;
    }
    AppMethodBeat.o(202284);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.c.c
 * JD-Core Version:    0.7.0.1
 */