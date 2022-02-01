package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RecyclerView$f$c
{
  public int alk;
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public c e(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(262126);
    paramv = paramv.amk;
    this.left = paramv.getLeft();
    this.top = paramv.getTop();
    this.right = paramv.getRight();
    this.bottom = paramv.getBottom();
    AppMethodBeat.o(262126);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.f.c
 * JD-Core Version:    0.7.0.1
 */