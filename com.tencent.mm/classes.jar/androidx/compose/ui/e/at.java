package androidx.compose.ui.e;

import android.graphics.Rect;
import androidx.compose.ui.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeRect", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class at
{
  public static final Rect f(g paramg)
  {
    AppMethodBeat.i(206127);
    s.u(paramg, "<this>");
    paramg = new Rect((int)paramg.left, (int)paramg.top, (int)paramg.right, (int)paramg.bottom);
    AppMethodBeat.o(206127);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.at
 * JD-Core Version:    0.7.0.1
 */