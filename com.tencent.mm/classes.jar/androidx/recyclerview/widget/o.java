package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o
{
  boolean aiK = true;
  int aiL;
  int aiM;
  int aiN;
  int aiO = 0;
  int aiP = 0;
  boolean aiQ;
  boolean aiR;
  int mLayoutDirection;
  
  final View a(RecyclerView.n paramn)
  {
    AppMethodBeat.i(261558);
    paramn = paramn.cS(this.aiM);
    this.aiM += this.aiN;
    AppMethodBeat.o(261558);
    return paramn;
  }
  
  final boolean a(RecyclerView.s params)
  {
    AppMethodBeat.i(261557);
    if ((this.aiM >= 0) && (this.aiM < params.getItemCount()))
    {
      AppMethodBeat.o(261557);
      return true;
    }
    AppMethodBeat.o(261557);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261560);
    String str = "LayoutState{mAvailable=" + this.aiL + ", mCurrentPosition=" + this.aiM + ", mItemDirection=" + this.aiN + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.aiO + ", mEndLine=" + this.aiP + '}';
    AppMethodBeat.o(261560);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.o
 * JD-Core Version:    0.7.0.1
 */