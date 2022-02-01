package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.V8Object;

public abstract interface BreakHandler
{
  public abstract void onBreak(DebugHandler.DebugEvent paramDebugEvent, ExecutionState paramExecutionState, EventData paramEventData, V8Object paramV8Object);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.BreakHandler
 * JD-Core Version:    0.7.0.1
 */