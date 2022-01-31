package com.tencent.kinda.framework.app;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.kinda.gen.IDeviceFrameDrawLoopCallback;
import com.tencent.kinda.gen.VoidI64Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaDeviceFrameDrawLoopCallback
  implements IDeviceFrameDrawLoopCallback
{
  private Choreographer choreographer;
  private Choreographer.FrameCallback frameCallback;
  private VoidI64Callback frameDrawCallback;
  private volatile boolean isStart;
  
  public KindaDeviceFrameDrawLoopCallback()
  {
    AppMethodBeat.i(144340);
    this.choreographer = Choreographer.getInstance();
    this.frameCallback = new Choreographer.FrameCallback()
    {
      public void doFrame(long paramAnonymousLong)
      {
        AppMethodBeat.i(144339);
        KindaDeviceFrameDrawLoopCallback.this.onDoFrame(paramAnonymousLong);
        AppMethodBeat.o(144339);
      }
    };
    this.isStart = false;
    AppMethodBeat.o(144340);
  }
  
  public void onDoFrame(long paramLong)
  {
    AppMethodBeat.i(144343);
    paramLong /= 1000000L;
    this.frameDrawCallback.call(paramLong);
    if (this.isStart) {
      this.choreographer.postFrameCallback(this.frameCallback);
    }
    AppMethodBeat.o(144343);
  }
  
  public void startListenerImpl(VoidI64Callback paramVoidI64Callback)
  {
    AppMethodBeat.i(144341);
    this.isStart = true;
    this.frameDrawCallback = paramVoidI64Callback;
    this.choreographer.removeFrameCallback(this.frameCallback);
    this.choreographer.postFrameCallback(this.frameCallback);
    AppMethodBeat.o(144341);
  }
  
  public void stopListener()
  {
    AppMethodBeat.i(144342);
    this.isStart = false;
    this.choreographer.removeFrameCallback(this.frameCallback);
    AppMethodBeat.o(144342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaDeviceFrameDrawLoopCallback
 * JD-Core Version:    0.7.0.1
 */