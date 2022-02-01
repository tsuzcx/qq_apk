package androidx.compose.ui.b;

import androidx.compose.ui.d.k.a;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.f;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/EmptyBuildDrawCacheParams;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "()V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class k
  implements b
{
  private static final d TD;
  private static final n agm;
  public static final k auv;
  private static final long size;
  
  static
  {
    AppMethodBeat.i(204832);
    auv = new k();
    k.a locala = androidx.compose.ui.d.k.avA;
    size = androidx.compose.ui.d.k.sw();
    agm = n.beP;
    TD = f.H(1.0F, 1.0F);
    AppMethodBeat.o(204832);
  }
  
  public final d getDensity()
  {
    return TD;
  }
  
  public final n getLayoutDirection()
  {
    return agm;
  }
  
  public final long sf()
  {
    return size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.k
 * JD-Core Version:    0.7.0.1
 */