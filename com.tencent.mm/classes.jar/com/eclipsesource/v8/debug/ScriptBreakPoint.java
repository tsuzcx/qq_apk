package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ResultUndefined;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScriptBreakPoint
  implements Releasable
{
  private static final String CONDITION = "condition";
  private static final String LINE = "line";
  private static final String NUMBER = "number";
  private static final String SET_CONDITION = "setCondition";
  private V8Object v8Object;
  
  ScriptBreakPoint(V8Object paramV8Object)
  {
    AppMethodBeat.i(61535);
    this.v8Object = paramV8Object.twin();
    AppMethodBeat.o(61535);
  }
  
  public int getBreakPointNumber()
  {
    AppMethodBeat.i(61536);
    int i = this.v8Object.executeIntegerFunction("number", null);
    AppMethodBeat.o(61536);
    return i;
  }
  
  public String getCondition()
  {
    AppMethodBeat.i(61539);
    try
    {
      String str = this.v8Object.executeStringFunction("condition", null);
      AppMethodBeat.o(61539);
      return str;
    }
    catch (V8ResultUndefined localV8ResultUndefined)
    {
      AppMethodBeat.o(61539);
    }
    return "undefined";
  }
  
  public int getLine()
  {
    AppMethodBeat.i(61537);
    int i = this.v8Object.executeIntegerFunction("line", null);
    AppMethodBeat.o(61537);
    return i;
  }
  
  public void release()
  {
    AppMethodBeat.i(61540);
    if ((this.v8Object != null) && (!this.v8Object.isReleased()))
    {
      this.v8Object.release();
      this.v8Object = null;
    }
    AppMethodBeat.o(61540);
  }
  
  public void setCondition(String paramString)
  {
    AppMethodBeat.i(61538);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramString);
    try
    {
      this.v8Object.executeVoidFunction("setCondition", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61538);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.debug.ScriptBreakPoint
 * JD-Core Version:    0.7.0.1
 */