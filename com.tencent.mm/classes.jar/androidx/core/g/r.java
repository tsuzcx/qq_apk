package androidx.core.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  private int btu;
  private int btv;
  
  public final void Eg()
  {
    AppMethodBeat.i(195715);
    eq(0);
    AppMethodBeat.o(195715);
  }
  
  public final void aA(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      this.btv = paramInt1;
      return;
    }
    this.btu = paramInt1;
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(195696);
    aA(paramInt, 0);
    AppMethodBeat.o(195696);
  }
  
  public final void eq(int paramInt)
  {
    if (paramInt == 1)
    {
      this.btv = 0;
      return;
    }
    this.btu = 0;
  }
  
  public final int getNestedScrollAxes()
  {
    return this.btu | this.btv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.r
 * JD-Core Version:    0.7.0.1
 */