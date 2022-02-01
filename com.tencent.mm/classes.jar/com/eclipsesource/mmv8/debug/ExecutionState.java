package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.debug.mirror.Frame;
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
    AppMethodBeat.i(61474);
    this.v8Object = paramV8Object.twin();
    AppMethodBeat.o(61474);
  }
  
  public Frame getFrame(int paramInt)
  {
    AppMethodBeat.i(61477);
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
      AppMethodBeat.o(61477);
    }
  }
  
  public int getFrameCount()
  {
    AppMethodBeat.i(61475);
    int i = this.v8Object.executeIntegerFunction("frameCount", null);
    AppMethodBeat.o(61475);
    return i;
  }
  
  public void prepareStep(StepAction paramStepAction)
  {
    AppMethodBeat.i(61476);
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
      AppMethodBeat.o(61476);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(61478);
    if ((this.v8Object != null) && (!this.v8Object.isReleased()))
    {
      this.v8Object.release();
      this.v8Object = null;
    }
    AppMethodBeat.o(61478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.ExecutionState
 * JD-Core Version:    0.7.0.1
 */