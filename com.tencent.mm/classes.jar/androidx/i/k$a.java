package androidx.i;

import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$a
  implements s
{
  private final s aeB;
  private final int zP;
  
  k$a(int paramInt, s params)
  {
    this.zP = paramInt;
    this.aeB = params;
  }
  
  public final void W(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216674);
    this.aeB.W(this.zP + paramInt1, paramInt2);
    AppMethodBeat.o(216674);
  }
  
  public final void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216676);
    this.aeB.ac(this.zP + paramInt1, paramInt2);
    AppMethodBeat.o(216676);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216677);
    this.aeB.ad(this.zP + paramInt1, this.zP + paramInt2);
    AppMethodBeat.o(216677);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(216679);
    this.aeB.c(this.zP + paramInt1, paramInt2, paramObject);
    AppMethodBeat.o(216679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.i.k.a
 * JD-Core Version:    0.7.0.1
 */