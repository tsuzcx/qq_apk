package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  h<?> aCe;
  
  public j(h<?> paramh)
  {
    this.aCe = paramh;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(53011);
    try
    {
      h localh = this.aCe;
      if ((localh != null) && (h.nG() != null)) {
        new k(localh.getError());
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
 * Qualified Name:     a.j
 * JD-Core Version:    0.7.0.1
 */