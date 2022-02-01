package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.List;

public final class d
  implements Closeable
{
  private e aBJ;
  private Runnable aBK;
  private boolean closed;
  private final Object lock;
  
  public final void close()
  {
    AppMethodBeat.i(52983);
    synchronized (this.lock)
    {
      if (this.closed)
      {
        AppMethodBeat.o(52983);
        return;
      }
      this.closed = true;
      e locale = this.aBJ;
      synchronized (locale.lock)
      {
        locale.nD();
        locale.aBL.remove(this);
        this.aBJ = null;
        this.aBK = null;
        AppMethodBeat.o(52983);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.d
 * JD-Core Version:    0.7.0.1
 */