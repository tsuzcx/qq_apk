package com.eclipsesource.v8.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DebugHandler$DebugEvent
{
  int index;
  
  static
  {
    AppMethodBeat.i(74832);
    Undefined = new DebugEvent("Undefined", 0, 0);
    Break = new DebugEvent("Break", 1, 1);
    Exception = new DebugEvent("Exception", 2, 2);
    NewFunction = new DebugEvent("NewFunction", 3, 3);
    BeforeCompile = new DebugEvent("BeforeCompile", 4, 4);
    AfterCompile = new DebugEvent("AfterCompile", 5, 5);
    CompileError = new DebugEvent("CompileError", 6, 6);
    PromiseError = new DebugEvent("PromiseError", 7, 7);
    AsyncTaskEvent = new DebugEvent("AsyncTaskEvent", 8, 8);
    $VALUES = new DebugEvent[] { Undefined, Break, Exception, NewFunction, BeforeCompile, AfterCompile, CompileError, PromiseError, AsyncTaskEvent };
    AppMethodBeat.o(74832);
  }
  
  private DebugHandler$DebugEvent(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler.DebugEvent
 * JD-Core Version:    0.7.0.1
 */