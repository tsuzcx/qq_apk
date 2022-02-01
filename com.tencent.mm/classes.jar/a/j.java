package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  h<?> aCg;
  
  public j(h<?> paramh)
  {
    this.aCg = paramh;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(53011);
    try
    {
      h localh = this.aCg;
      if ((localh != null) && (h.nE() != null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j
 * JD-Core Version:    0.7.0.1
 */