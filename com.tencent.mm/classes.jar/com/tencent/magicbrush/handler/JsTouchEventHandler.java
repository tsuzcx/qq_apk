package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler
{
  public IntBuffer bJw;
  public FloatBuffer bJx;
  public JsTouchEventHandler.b bJy;
  public float mDensity;
  public MBRuntime mbRuntime;
  
  public JsTouchEventHandler(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(115886);
    this.bJy = new JsTouchEventHandler.b(this);
    this.mbRuntime = paramMBRuntime;
    this.mDensity = ((float)this.mbRuntime.getParams().device_pixel_ratio_);
    fJ(10);
    AppMethodBeat.o(115886);
  }
  
  public static int n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115888);
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      AppMethodBeat.o(115888);
      return -1;
    case 0: 
    case 5: 
      AppMethodBeat.o(115888);
      return 0;
    case 2: 
      AppMethodBeat.o(115888);
      return 1;
    case 1: 
    case 6: 
      AppMethodBeat.o(115888);
      return 2;
    }
    AppMethodBeat.o(115888);
    return 3;
  }
  
  private native void nativeFreeTouchEvent(long paramLong);
  
  public final void fJ(int paramInt)
  {
    AppMethodBeat.i(115887);
    if ((this.bJw != null) && (this.bJw.capacity() >= paramInt))
    {
      this.bJw.clear();
      this.bJx.clear();
      AppMethodBeat.o(115887);
      return;
    }
    if (this.bJw != null)
    {
      i = this.bJw.capacity();
      for (;;)
      {
        j = i;
        if (i >= paramInt) {
          break;
        }
        i *= 2;
      }
    }
    int j = paramInt;
    if (this.bJw == null) {}
    for (int i = 0;; i = this.bJw.capacity())
    {
      c.c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      this.bJw = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
      this.bJx = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      AppMethodBeat.o(115887);
      return;
    }
  }
  
  public native long nativeCreateTouchEvent(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, FloatBuffer paramFloatBuffer, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */