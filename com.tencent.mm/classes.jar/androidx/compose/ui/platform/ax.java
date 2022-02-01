package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewLayerContainer;", "Landroidx/compose/ui/platform/DrawChildContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchGetDisplayList", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends y
{
  public ax(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206915);
    AppMethodBeat.o(206915);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206920);
    s.u(paramCanvas, "canvas");
    AppMethodBeat.o(206920);
  }
  
  protected final void dispatchGetDisplayList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ax
 * JD-Core Version:    0.7.0.1
 */