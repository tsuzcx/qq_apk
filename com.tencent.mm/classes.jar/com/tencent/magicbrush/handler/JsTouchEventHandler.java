package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler
{
  private IntBuffer cxX;
  private FloatBuffer cxY;
  private b cxZ;
  
  public JsTouchEventHandler()
  {
    AppMethodBeat.i(139991);
    this.cxZ = new b(this);
    gT(10);
    AppMethodBeat.o(139991);
  }
  
  private void gT(int paramInt)
  {
    AppMethodBeat.i(139993);
    if ((this.cxX != null) && (this.cxX.capacity() >= paramInt))
    {
      this.cxX.clear();
      this.cxY.clear();
      AppMethodBeat.o(139993);
      return;
    }
    if (this.cxX != null)
    {
      i = this.cxX.capacity();
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
    if (this.cxX == null) {}
    for (int i = 0;; i = this.cxX.capacity())
    {
      c.c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      this.cxX = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
      this.cxY = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      AppMethodBeat.o(139993);
      return;
    }
  }
  
  private static int m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139994);
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      AppMethodBeat.o(139994);
      return -1;
    case 0: 
    case 5: 
      AppMethodBeat.o(139994);
      return 0;
    case 2: 
      AppMethodBeat.o(139994);
      return 1;
    case 1: 
    case 6: 
      AppMethodBeat.o(139994);
      return 2;
    }
    AppMethodBeat.o(139994);
    return 3;
  }
  
  private native long nativeCreateTouchEvent(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, FloatBuffer paramFloatBuffer, long paramLong);
  
  private native void nativeFreeTouchEvent(long paramLong);
  
  public final JsTouchEventHandler.a Hz()
  {
    return this.cxZ;
  }
  
  public final long a(MotionEvent paramMotionEvent, float paramFloat)
  {
    int j = -1;
    AppMethodBeat.i(139992);
    gT(paramMotionEvent.getPointerCount());
    int m = m(paramMotionEvent);
    if (m == -1)
    {
      AppMethodBeat.o(139992);
      return 0L;
    }
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < k)
    {
      this.cxX.put(paramMotionEvent.getPointerId(i));
      this.cxY.put(paramMotionEvent.getX(i) / paramFloat);
      this.cxY.put(paramMotionEvent.getY(i) / paramFloat);
      i += 1;
    }
    int n = m(paramMotionEvent);
    if (m == 1) {}
    for (i = j;; i = paramMotionEvent.getActionIndex())
    {
      long l = nativeCreateTouchEvent(n, i, k, this.cxX, this.cxY, paramMotionEvent.getEventTime());
      AppMethodBeat.o(139992);
      return l;
    }
  }
  
  public static final class b
    implements JsTouchEventHandler.a
  {
    private WeakReference<JsTouchEventHandler> cya;
    
    public b(JsTouchEventHandler paramJsTouchEventHandler)
    {
      AppMethodBeat.i(139989);
      this.cya = new WeakReference(paramJsTouchEventHandler);
      AppMethodBeat.o(139989);
    }
    
    public final void aM(long paramLong)
    {
      AppMethodBeat.i(139990);
      JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.cya.get();
      if (localJsTouchEventHandler != null) {
        JsTouchEventHandler.a(localJsTouchEventHandler, paramLong);
      }
      AppMethodBeat.o(139990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */