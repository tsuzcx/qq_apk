package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa
  implements ab
{
  private final ViewGroupOverlay chu;
  
  aa(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(201593);
    this.chu = paramViewGroup.getOverlay();
    AppMethodBeat.o(201593);
  }
  
  public final void cd(View paramView)
  {
    AppMethodBeat.i(201612);
    this.chu.add(paramView);
    AppMethodBeat.o(201612);
  }
  
  public final void ce(View paramView)
  {
    AppMethodBeat.i(201618);
    this.chu.remove(paramView);
    AppMethodBeat.o(201618);
  }
  
  public final void x(Drawable paramDrawable)
  {
    AppMethodBeat.i(201599);
    this.chu.add(paramDrawable);
    AppMethodBeat.o(201599);
  }
  
  public final void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(201605);
    this.chu.remove(paramDrawable);
    AppMethodBeat.o(201605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.aa
 * JD-Core Version:    0.7.0.1
 */