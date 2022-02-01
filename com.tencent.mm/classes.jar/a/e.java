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
  final List<d> aBL;
  private ScheduledFuture<?> aBM;
  private boolean aBN;
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
      if (this.aBM != null)
      {
        this.aBM.cancel(true);
        this.aBM = null;
      }
      Iterator localIterator = this.aBL.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).close();
      }
    }
    this.aBL.clear();
    this.closed = true;
    AppMethodBeat.o(52985);
  }
  
  public final boolean isCancellationRequested()
  {
    AppMethodBeat.i(52984);
    synchronized (this.lock)
    {
      nD();
      boolean bool = this.aBN;
      AppMethodBeat.o(52984);
      return bool;
    }
  }
  
  final void nD()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.e
 * JD-Core Version:    0.7.0.1
 */