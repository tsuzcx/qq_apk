package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends o
{
  float value = 0.0F;
  
  public final void be(int paramInt)
  {
    AppMethodBeat.i(229805);
    if ((this.state == 0) || (this.value != paramInt))
    {
      this.value = paramInt;
      if (this.state == 1) {
        invalidate();
      }
      fV();
    }
    AppMethodBeat.o(229805);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(229801);
    super.reset();
    this.value = 0.0F;
    AppMethodBeat.o(229801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.n
 * JD-Core Version:    0.7.0.1
 */