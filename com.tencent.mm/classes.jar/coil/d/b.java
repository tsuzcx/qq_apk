package coil.d;

import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.c.c;
import coil.size.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"rememberCrossfadePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "key", "", "start", "end", "scale", "Lcoil/size/Scale;", "durationMillis", "", "fadeStart", "", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lcoil/size/Scale;IZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "coil-compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final c a(Object paramObject, c paramc1, c paramc2, e parame, int paramInt, boolean paramBoolean, h paramh)
  {
    AppMethodBeat.i(188019);
    s.u(paramObject, "key");
    s.u(parame, "scale");
    paramh.bx(-1764073009);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramObject);
    Object localObject = paramh.or();
    if (!bool)
    {
      paramObject = h.alD;
      paramObject = localObject;
      if (localObject != h.a.ox()) {}
    }
    else
    {
      paramObject = new a(paramc1, paramc2, parame, paramInt, paramBoolean);
      paramh.F(paramObject);
    }
    paramh.od();
    paramObject = (a)paramObject;
    paramh.od();
    paramObject = (c)paramObject;
    AppMethodBeat.o(188019);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d.b
 * JD-Core Version:    0.7.0.1
 */