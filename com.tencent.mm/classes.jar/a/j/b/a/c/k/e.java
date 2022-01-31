package a.j.b.a.c.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e
  implements Lock
{
  public static final Lock CAN;
  
  static
  {
    AppMethodBeat.i(122478);
    CAN = new e();
    AppMethodBeat.o(122478);
  }
  
  public final void lock() {}
  
  public final void lockInterruptibly()
  {
    AppMethodBeat.i(122474);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(122474);
    throw localUnsupportedOperationException;
  }
  
  public final Condition newCondition()
  {
    AppMethodBeat.i(122477);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(122477);
    throw localUnsupportedOperationException;
  }
  
  public final boolean tryLock()
  {
    AppMethodBeat.i(122475);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(122475);
    throw localUnsupportedOperationException;
  }
  
  public final boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(122476);
    paramTimeUnit = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(122476);
    throw paramTimeUnit;
  }
  
  public final void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.k.e
 * JD-Core Version:    0.7.0.1
 */