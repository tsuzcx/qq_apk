package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiContextNodeJS$1
  implements JavaVoidCallback
{
  MultiContextNodeJS$1(MultiContextNodeJS paramMultiContextNodeJS) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(74963);
    paramV8Object = (V8Function)paramV8Array.get(0);
    try
    {
      MultiContextNodeJS.access$000(this.val$node, paramV8Object.twin());
      return;
    }
    finally
    {
      paramV8Object.release();
      AppMethodBeat.o(74963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.MultiContextNodeJS.1
 * JD-Core Version:    0.7.0.1
 */