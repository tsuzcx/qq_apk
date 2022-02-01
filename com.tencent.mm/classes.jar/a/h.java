package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
{
  f<?> awt;
  
  public h(f<?> paramf)
  {
    this.awt = paramf;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(53011);
    try
    {
      f localf = this.awt;
      if ((localf != null) && (f.nP() != null)) {
        new i(localf.getError());
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(53011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.h
 * JD-Core Version:    0.7.0.1
 */