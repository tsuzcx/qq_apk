package androidx.compose.b;

import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ContentAlpha;", "", "()V", "disabled", "", "getDisabled", "(Landroidx/compose/runtime/Composer;I)F", "high", "getHigh", "medium", "getMedium", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c air;
  
  static
  {
    AppMethodBeat.i(201705);
    air = new c();
    AppMethodBeat.o(201705);
  }
  
  static float a(float paramFloat1, float paramFloat2, h paramh)
  {
    AppMethodBeat.i(201701);
    paramh.bx(-1499253717);
    long l = ((z)paramh.a((p)e.nv())).value;
    m localm = m.aiH;
    if (m.j(paramh).nr()) {
      if (ab.ah(l) <= 0.5D) {}
    }
    for (;;)
    {
      paramh.od();
      AppMethodBeat.o(201701);
      return paramFloat1;
      paramFloat1 = paramFloat2;
      continue;
      if (ab.ah(l) >= 0.5D) {
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  public static float g(h paramh)
  {
    AppMethodBeat.i(201697);
    paramh.bx(575700177);
    float f = a(0.74F, 0.6F, paramh);
    paramh.od();
    AppMethodBeat.o(201697);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.c
 * JD-Core Version:    0.7.0.1
 */