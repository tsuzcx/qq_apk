package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends Drawable
{
  final ActionBarContainer oM;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.oM = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200001);
    if (this.oM.oT)
    {
      if (this.oM.oS != null)
      {
        this.oM.oS.draw(paramCanvas);
        AppMethodBeat.o(200001);
      }
    }
    else
    {
      if (this.oM.ni != null) {
        this.oM.ni.draw(paramCanvas);
      }
      if ((this.oM.oR != null) && (this.oM.oU)) {
        this.oM.oR.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(200001);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(200051);
    if (this.oM.oT)
    {
      if (this.oM.oS != null)
      {
        this.oM.oS.getOutline(paramOutline);
        AppMethodBeat.o(200051);
      }
    }
    else if (this.oM.ni != null) {
      this.oM.ni.getOutline(paramOutline);
    }
    AppMethodBeat.o(200051);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.b
 * JD-Core Version:    0.7.0.1
 */