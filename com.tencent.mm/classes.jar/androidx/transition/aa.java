package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa
  implements ab
{
  private final ViewGroupOverlay asL;
  
  aa(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193096);
    this.asL = paramViewGroup.getOverlay();
    AppMethodBeat.o(193096);
  }
  
  public final void bJ(View paramView)
  {
    AppMethodBeat.i(193109);
    this.asL.add(paramView);
    AppMethodBeat.o(193109);
  }
  
  public final void bK(View paramView)
  {
    AppMethodBeat.i(193111);
    this.asL.remove(paramView);
    AppMethodBeat.o(193111);
  }
  
  public final void u(Drawable paramDrawable)
  {
    AppMethodBeat.i(193101);
    this.asL.add(paramDrawable);
    AppMethodBeat.o(193101);
  }
  
  public final void v(Drawable paramDrawable)
  {
    AppMethodBeat.i(193106);
    this.asL.remove(paramDrawable);
    AppMethodBeat.o(193106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.aa
 * JD-Core Version:    0.7.0.1
 */