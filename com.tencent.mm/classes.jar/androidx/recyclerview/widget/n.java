package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
{
  boolean bXp = true;
  int bXq;
  int bXr;
  int bXs;
  int bXt = 0;
  int bXu = 0;
  boolean bXv;
  boolean bXw;
  int mLayoutDirection;
  
  final View a(RecyclerView.n paramn)
  {
    AppMethodBeat.i(194807);
    paramn = paramn.gc(this.bXr);
    this.bXr += this.bXs;
    AppMethodBeat.o(194807);
    return paramn;
  }
  
  final boolean a(RecyclerView.s params)
  {
    AppMethodBeat.i(194792);
    if ((this.bXr >= 0) && (this.bXr < params.getItemCount()))
    {
      AppMethodBeat.o(194792);
      return true;
    }
    AppMethodBeat.o(194792);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194823);
    String str = "LayoutState{mAvailable=" + this.bXq + ", mCurrentPosition=" + this.bXr + ", mItemDirection=" + this.bXs + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.bXt + ", mEndLine=" + this.bXu + '}';
    AppMethodBeat.o(194823);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.n
 * JD-Core Version:    0.7.0.1
 */