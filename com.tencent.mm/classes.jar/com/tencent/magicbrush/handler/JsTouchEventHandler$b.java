package com.tencent.magicbrush.handler;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class JsTouchEventHandler$b
  implements JsTouchEventHandler.a
{
  private WeakReference<JsTouchEventHandler> bJz;
  
  public JsTouchEventHandler$b(JsTouchEventHandler paramJsTouchEventHandler)
  {
    AppMethodBeat.i(115884);
    this.bJz = new WeakReference(paramJsTouchEventHandler);
    AppMethodBeat.o(115884);
  }
  
  public final void au(long paramLong)
  {
    AppMethodBeat.i(115885);
    JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.bJz.get();
    if (localJsTouchEventHandler != null) {
      JsTouchEventHandler.a(localJsTouchEventHandler, paramLong);
    }
    AppMethodBeat.o(115885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler.b
 * JD-Core Version:    0.7.0.1
 */