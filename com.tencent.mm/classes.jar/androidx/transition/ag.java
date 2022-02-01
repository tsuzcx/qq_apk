package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ag
  implements ah
{
  private final ViewOverlay chI;
  
  ag(View paramView)
  {
    AppMethodBeat.i(201540);
    this.chI = paramView.getOverlay();
    AppMethodBeat.o(201540);
  }
  
  public final void x(Drawable paramDrawable)
  {
    AppMethodBeat.i(201551);
    this.chI.add(paramDrawable);
    AppMethodBeat.o(201551);
  }
  
  public final void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(201563);
    this.chI.remove(paramDrawable);
    AppMethodBeat.o(201563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ag
 * JD-Core Version:    0.7.0.1
 */