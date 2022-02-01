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
  private IntBuffer cML;
  private FloatBuffer cMM;
  private b cMN;
  
  public JsTouchEventHandler()
  {
    AppMethodBeat.i(139991);
    this.cMN = new b(this);
    il(10);
    AppMethodBeat.o(139991);
  }
  
  private void il(int paramInt)
  {
    AppMethodBeat.i(139993);
    if ((this.cML != null) && (this.cML.capacity() >= paramInt))
    {
      this.cML.clear();
      this.cMM.clear();
      AppMethodBeat.o(139993);
      return;
    }
    if (this.cML != null)
    {
      i = this.cML.capacity();
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
    if (this.cML == null) {}
    for (int i = 0;; i = this.cML.capacity())
    {
      c.c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      this.cML = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
      this.cMM = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      AppMethodBeat.o(139993);
      return;
    }
  }
  
  private native long nativeCreateTouchEvent(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, FloatBuffer paramFloatBuffer, long paramLong);
  
  private native void nativeFreeTouchEvent(long paramLong);
  
  private static int p(MotionEvent paramMotionEvent)
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
  
  public final JsTouchEventHandler.a Rw()
  {
    return this.cMN;
  }
  
  public final long a(MotionEvent paramMotionEvent, float paramFloat)
  {
    int j = -1;
    AppMethodBeat.i(139992);
    il(paramMotionEvent.getPointerCount());
    int m = p(paramMotionEvent);
    if (m == -1)
    {
      AppMethodBeat.o(139992);
      return 0L;
    }
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < k)
    {
      this.cML.put(paramMotionEvent.getPointerId(i));
      this.cMM.put(paramMotionEvent.getX(i) / paramFloat);
      this.cMM.put(paramMotionEvent.getY(i) / paramFloat);
      i += 1;
    }
    int n = p(paramMotionEvent);
    if (m == 1) {}
    for (i = j;; i = paramMotionEvent.getActionIndex())
    {
      long l = nativeCreateTouchEvent(n, i, k, this.cML, this.cMM, paramMotionEvent.getEventTime());
      AppMethodBeat.o(139992);
      return l;
    }
  }
  
  public static final class b
    implements JsTouchEventHandler.a
  {
    private WeakReference<JsTouchEventHandler> cMO;
    
    public b(JsTouchEventHandler paramJsTouchEventHandler)
    {
      AppMethodBeat.i(139989);
      this.cMO = new WeakReference(paramJsTouchEventHandler);
      AppMethodBeat.o(139989);
    }
    
    public final void aY(long paramLong)
    {
      AppMethodBeat.i(139990);
      JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.cMO.get();
      if (localJsTouchEventHandler != null) {
        JsTouchEventHandler.a(localJsTouchEventHandler, paramLong);
      }
      AppMethodBeat.o(139990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */