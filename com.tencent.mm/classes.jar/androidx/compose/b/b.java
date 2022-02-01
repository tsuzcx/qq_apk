package androidx.compose.b;

import androidx.compose.runtime.an;
import androidx.compose.runtime.as;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.runtime.q;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final as<a> aip;
  
  static
  {
    AppMethodBeat.i(201735);
    aip = q.e((kotlin.g.a.a)a.aiq);
    AppMethodBeat.o(201735);
  }
  
  public static final long a(long paramLong, h paramh)
  {
    AppMethodBeat.i(201718);
    Object localObject = m.aiH;
    paramLong = a(m.j(paramh), paramLong);
    localObject = z.awK;
    if (paramLong != z.sw()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(201718);
      return paramLong;
    }
    paramLong = ((z)paramh.a((p)e.nv())).value;
    AppMethodBeat.o(201718);
    return paramLong;
  }
  
  public static final long a(a parama)
  {
    AppMethodBeat.i(201709);
    s.u(parama, "<this>");
    if (parama.nr())
    {
      l = parama.nf();
      AppMethodBeat.o(201709);
      return l;
    }
    long l = parama.nk();
    AppMethodBeat.o(201709);
    return l;
  }
  
  public static final long a(a parama, long paramLong)
  {
    AppMethodBeat.i(201713);
    s.u(parama, "$this$contentColorFor");
    if (z.e(paramLong, parama.nf()))
    {
      paramLong = parama.nm();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.ng()))
    {
      paramLong = parama.nm();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.nh()))
    {
      paramLong = parama.nn();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.ni()))
    {
      paramLong = parama.nn();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.nj()))
    {
      paramLong = parama.no();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.nk()))
    {
      paramLong = parama.np();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    if (z.e(paramLong, parama.nl()))
    {
      paramLong = parama.nq();
      AppMethodBeat.o(201713);
      return paramLong;
    }
    parama = z.awK;
    paramLong = z.sw();
    AppMethodBeat.o(201713);
    return paramLong;
  }
  
  public static final void a(a parama1, a parama2)
  {
    AppMethodBeat.i(201724);
    s.u(parama1, "<this>");
    s.u(parama2, "other");
    long l = parama2.nf();
    parama1.aib.setValue(z.ad(l));
    l = parama2.ng();
    parama1.aic.setValue(z.ad(l));
    l = parama2.nh();
    parama1.aie.setValue(z.ad(l));
    l = parama2.ni();
    parama1.aif.setValue(z.ad(l));
    l = parama2.nj();
    parama1.aig.setValue(z.ad(l));
    l = parama2.nk();
    parama1.aih.setValue(z.ad(l));
    l = parama2.nl();
    parama1.aii.setValue(z.ad(l));
    l = parama2.nm();
    parama1.aij.setValue(z.ad(l));
    l = parama2.nn();
    parama1.aik.setValue(z.ad(l));
    l = parama2.no();
    parama1.ail.setValue(z.ad(l));
    l = parama2.np();
    parama1.aim.setValue(z.ad(l));
    l = parama2.nq();
    parama1.ain.setValue(z.ad(l));
    boolean bool = parama2.nr();
    parama1.aio.setValue(Boolean.valueOf(bool));
    AppMethodBeat.o(201724);
  }
  
  public static final as<a> nt()
  {
    return aip;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/material/Colors;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<a>
  {
    public static final a aiq;
    
    static
    {
      AppMethodBeat.i(201695);
      aiq = new a();
      AppMethodBeat.o(201695);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.b
 * JD-Core Version:    0.7.0.1
 */