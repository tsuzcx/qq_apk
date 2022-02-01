package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RecyclerView$f$c
{
  public int bZM;
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public c e(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(194727);
    paramv = paramv.caK;
    this.left = paramv.getLeft();
    this.top = paramv.getTop();
    this.right = paramv.getRight();
    this.bottom = paramv.getBottom();
    AppMethodBeat.o(194727);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.f.c
 * JD-Core Version:    0.7.0.1
 */