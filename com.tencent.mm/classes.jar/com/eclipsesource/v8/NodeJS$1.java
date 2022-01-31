package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class NodeJS$1
  implements JavaVoidCallback
{
  NodeJS$1(NodeJS paramNodeJS) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(74991);
    paramV8Object = (V8Function)paramV8Array.get(0);
    try
    {
      NodeJS.access$000(this.val$node, paramV8Object.twin());
      return;
    }
    finally
    {
      paramV8Object.release();
      AppMethodBeat.o(74991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.NodeJS.1
 * JD-Core Version:    0.7.0.1
 */