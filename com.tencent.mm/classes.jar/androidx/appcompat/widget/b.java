package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends Drawable
{
  final ActionBarContainer nN;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.nN = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(239997);
    if (this.nN.nU)
    {
      if (this.nN.nT != null)
      {
        this.nN.nT.draw(paramCanvas);
        AppMethodBeat.o(239997);
      }
    }
    else
    {
      if (this.nN.mj != null) {
        this.nN.mj.draw(paramCanvas);
      }
      if ((this.nN.nS != null) && (this.nN.nV)) {
        this.nN.nS.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(239997);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(240003);
    if (this.nN.nU)
    {
      if (this.nN.nT != null)
      {
        this.nN.nT.getOutline(paramOutline);
        AppMethodBeat.o(240003);
      }
    }
    else if (this.nN.mj != null) {
      this.nN.mj.getOutline(paramOutline);
    }
    AppMethodBeat.o(240003);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.b
 * JD-Core Version:    0.7.0.1
 */