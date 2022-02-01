package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ag
  implements ah
{
  private final ViewOverlay asZ;
  
  ag(View paramView)
  {
    AppMethodBeat.i(193200);
    this.asZ = paramView.getOverlay();
    AppMethodBeat.o(193200);
  }
  
  public final void u(Drawable paramDrawable)
  {
    AppMethodBeat.i(193204);
    this.asZ.add(paramDrawable);
    AppMethodBeat.o(193204);
  }
  
  public final void v(Drawable paramDrawable)
  {
    AppMethodBeat.i(193208);
    this.asZ.remove(paramDrawable);
    AppMethodBeat.o(193208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ag
 * JD-Core Version:    0.7.0.1
 */