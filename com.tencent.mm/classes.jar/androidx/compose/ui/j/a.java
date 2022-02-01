package androidx.compose.ui.j;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final af b(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(204339);
    try
    {
      s.u(af.axy, "<this>");
      s.u(paramResources, "res");
      paramResources = paramResources.getDrawable(paramInt, null);
      if (paramResources == null)
      {
        paramResources = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(204339);
        throw paramResources;
      }
    }
    finally
    {
      paramResources = new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG");
      AppMethodBeat.o(204339);
    }
    paramResources = ((BitmapDrawable)paramResources).getBitmap();
    s.s(paramResources, "res.getDrawable(id, null…as BitmapDrawable).bitmap");
    paramResources = f.h(paramResources);
    AppMethodBeat.o(204339);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.j.a
 * JD-Core Version:    0.7.0.1
 */