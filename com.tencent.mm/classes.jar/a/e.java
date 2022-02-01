package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public final class e
  implements Closeable
{
  final List<d> aBJ;
  private ScheduledFuture<?> aBK;
  private boolean aBL;
  private boolean closed;
  final Object lock;
  
  public final void close()
  {
    AppMethodBeat.i(52985);
    synchronized (this.lock)
    {
      if (this.closed)
      {
        AppMethodBeat.o(52985);
        return;
      }
      if (this.aBK != null)
      {
        this.aBK.cancel(true);
        this.aBK = null;
      }
      Iterator localIterator = this.aBJ.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).close();
      }
    }
    this.aBJ.clear();
    this.closed = true;
    AppMethodBeat.o(52985);
  }
  
  public final boolean isCancellationRequested()
  {
    AppMethodBeat.i(52984);
    synchronized (this.lock)
    {
      nF();
      boolean bool = this.aBL;
      AppMethodBeat.o(52984);
      return bool;
    }
  }
  
  final void nF()
  {
    AppMethodBeat.i(52987);
    if (this.closed)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Object already closed");
      AppMethodBeat.o(52987);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(52987);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52986);
    String str = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested()) });
    AppMethodBeat.o(52986);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.e
 * JD-Core Version:    0.7.0.1
 */