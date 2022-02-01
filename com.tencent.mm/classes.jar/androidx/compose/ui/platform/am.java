package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.k.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "adjustedBounds", "Landroid/graphics/Rect;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroid/graphics/Rect;)V", "getAdjustedBounds", "()Landroid/graphics/Rect;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
{
  final o aVg;
  final Rect aVh;
  
  public am(o paramo, Rect paramRect)
  {
    AppMethodBeat.i(206720);
    this.aVg = paramo;
    this.aVh = paramRect;
    AppMethodBeat.o(206720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.am
 * JD-Core Version:    0.7.0.1
 */