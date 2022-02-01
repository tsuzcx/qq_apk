package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
{
  f<?> ckQ;
  
  public h(f<?> paramf)
  {
    this.ckQ = paramf;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(53011);
    try
    {
      f localf = this.ckQ;
      if ((localf != null) && (f.Mu() != null)) {
        new i(localf.Mw());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     a.h
 * JD-Core Version:    0.7.0.1
 */