package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  static
  {
    AppMethodBeat.i(213349);
    ON_CREATE = new a("ON_CREATE", 0);
    ON_START = new a("ON_START", 1);
    ON_RESUME = new a("ON_RESUME", 2);
    ON_PAUSE = new a("ON_PAUSE", 3);
    ON_STOP = new a("ON_STOP", 4);
    ON_DESTROY = new a("ON_DESTROY", 5);
    ON_ANY = new a("ON_ANY", 6);
    $VALUES = new a[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY };
    AppMethodBeat.o(213349);
  }
  
  private h$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.h.a
 * JD-Core Version:    0.7.0.1
 */