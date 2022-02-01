package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements q
{
  private final RecyclerView.a bUp;
  
  public b(RecyclerView.a parama)
  {
    this.bUp = parama;
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194682);
    this.bUp.bA(paramInt1, paramInt2);
    AppMethodBeat.o(194682);
  }
  
  public final void aS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194691);
    this.bUp.bB(paramInt1, paramInt2);
    AppMethodBeat.o(194691);
  }
  
  public final void aW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194698);
    this.bUp.bz(paramInt1, paramInt2);
    AppMethodBeat.o(194698);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(194709);
    this.bUp.e(paramInt1, paramInt2, paramObject);
    AppMethodBeat.o(194709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.b
 * JD-Core Version:    0.7.0.1
 */