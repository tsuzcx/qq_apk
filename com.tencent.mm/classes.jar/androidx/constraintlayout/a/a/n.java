package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends o
{
  float value = 0.0F;
  
  public final void dS(int paramInt)
  {
    AppMethodBeat.i(194078);
    if ((this.state == 0) || (this.value != paramInt))
    {
      this.value = paramInt;
      if (this.state == 1) {
        invalidate();
      }
      De();
    }
    AppMethodBeat.o(194078);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194071);
    super.reset();
    this.value = 0.0F;
    AppMethodBeat.o(194071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.n
 * JD-Core Version:    0.7.0.1
 */