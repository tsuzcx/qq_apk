package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.mirror.Frame;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExecutionState
  implements Releasable
{
  private static final String FRAME = "frame";
  private static final String FRAME_COUNT = "frameCount";
  private static final String PREPARE_STEP = "prepareStep";
  private V8Object v8Object;
  
  ExecutionState(V8Object paramV8Object)
  {
    AppMethodBeat.i(74851);
    this.v8Object = paramV8Object.twin();
    AppMethodBeat.o(74851);
  }
  
  public Frame getFrame(int paramInt)
  {
    AppMethodBeat.i(74854);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramInt);
    Object localObject1 = null;
    try
    {
      V8Object localV8Object = this.v8Object.executeObjectFunction("frame", localV8Array);
      localObject1 = localV8Object;
      Frame localFrame = new Frame(localV8Object);
      return localFrame;
    }
    finally
    {
      localV8Array.release();
      if (localObject1 != null) {
        localObject1.release();
      }
      AppMethodBeat.o(74854);
    }
  }
  
  public int getFrameCount()
  {
    AppMethodBeat.i(74852);
    int i = this.v8Object.executeIntegerFunction("frameCount", null);
    AppMethodBeat.o(74852);
    return i;
  }
  
  public void prepareStep(StepAction paramStepAction)
  {
    AppMethodBeat.i(74853);
    V8Array localV8Array = new V8Array(this.v8Object.getRuntime());
    localV8Array.push(paramStepAction.index);
    try
    {
      this.v8Object.executeVoidFunction("prepareStep", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(74853);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(74855);
    if ((this.v8Object != null) && (!this.v8Object.isReleased()))
    {
      this.v8Object.release();
      this.v8Object = null;
    }
    AppMethodBeat.o(74855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.debug.ExecutionState
 * JD-Core Version:    0.7.0.1
 */