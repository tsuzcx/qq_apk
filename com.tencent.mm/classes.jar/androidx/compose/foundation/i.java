package androidx.compose.foundation;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.z;
import androidx.compose.ui.e.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/Indication;", "()V", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "DefaultDebugIndicationInstance", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class i
  implements k
{
  public static final i YJ;
  
  static
  {
    AppMethodBeat.i(203552);
    YJ = new i();
    AppMethodBeat.o(203552);
  }
  
  public final l a(androidx.compose.foundation.b.c paramc, h paramh)
  {
    AppMethodBeat.i(203560);
    s.u(paramc, "interactionSource");
    paramh.bx(1543445948);
    s.u(paramc, "<this>");
    paramh.bx(1714643901);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == androidx.compose.runtime.h.a.ox())
    {
      localObject1 = bj.T(Boolean.FALSE);
      paramh.F(localObject1);
    }
    paramh.od();
    localObject1 = (an)localObject1;
    aa.a(paramc, (m)new androidx.compose.foundation.b.h.a(paramc, (an)localObject1, null), paramh);
    paramh.od();
    localObject1 = (bm)localObject1;
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramc);
    paramc = paramh.or();
    if (!bool)
    {
      localObject2 = h.alD;
      if (paramc != androidx.compose.runtime.h.a.ox()) {}
    }
    else
    {
      paramc = new a((bm)localObject1);
      paramh.F(paramc);
    }
    for (;;)
    {
      paramh.od();
      paramc = (a)paramc;
      paramh.od();
      paramc = (l)paramc;
      AppMethodBeat.o(203560);
      return paramc;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "isPressed", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;)V", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements l
  {
    private final bm<Boolean> YK;
    
    public a(bm<Boolean> parambm)
    {
      AppMethodBeat.i(203648);
      this.YK = parambm;
      AppMethodBeat.o(203648);
    }
    
    public final void b(androidx.compose.ui.e.b.c paramc)
    {
      AppMethodBeat.i(203652);
      s.u(paramc, "<this>");
      paramc.uK();
      if (((Boolean)this.YK.getValue()).booleanValue())
      {
        e locale = (e)paramc;
        z.a locala = z.awK;
        e.b.a(locale, z.g(z.tv(), 0.3F), 0L, paramc.sf(), 0.0F, null, null, 0, 122);
      }
      AppMethodBeat.o(203652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.i
 * JD-Core Version:    0.7.0.1
 */