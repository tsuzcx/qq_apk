package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class af
{
  private static final Object Mp;
  private static final Map<Object, n> Mq;
  
  static
  {
    AppMethodBeat.i(198645);
    Mp = new Object();
    Mq = new HashMap();
    AppMethodBeat.o(198645);
  }
  
  public static n r(Object paramObject)
  {
    AppMethodBeat.i(198641);
    synchronized (Mp)
    {
      paramObject = (n)Mq.get(paramObject);
      if (paramObject == null)
      {
        paramObject = n.Lu;
        AppMethodBeat.o(198641);
        return paramObject;
      }
    }
    AppMethodBeat.o(198641);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.af
 * JD-Core Version:    0.7.0.1
 */