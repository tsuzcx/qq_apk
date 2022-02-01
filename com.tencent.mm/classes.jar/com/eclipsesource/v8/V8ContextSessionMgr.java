package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class V8ContextSessionMgr
{
  private V8ContextWrapper currentContext;
  private final V8 v8;
  
  V8ContextSessionMgr(V8 paramV8)
  {
    this.v8 = paramV8;
  }
  
  public final void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(62073);
    if (paramV8ContextWrapper == null)
    {
      AppMethodBeat.o(62073);
      return;
    }
    if (paramV8ContextWrapper.equals(this.currentContext))
    {
      AppMethodBeat.o(62073);
      return;
    }
    this.v8.switchV8Context(paramV8ContextWrapper.getPtr());
    this.currentContext = paramV8ContextWrapper;
    AppMethodBeat.o(62073);
  }
  
  public final void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    AppMethodBeat.i(62074);
    if (paramV8ContextWrapper == null)
    {
      AppMethodBeat.o(62074);
      return;
    }
    this.v8.releaseV8Context(paramV8ContextWrapper.getPtr());
    AppMethodBeat.o(62074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.V8ContextSessionMgr
 * JD-Core Version:    0.7.0.1
 */