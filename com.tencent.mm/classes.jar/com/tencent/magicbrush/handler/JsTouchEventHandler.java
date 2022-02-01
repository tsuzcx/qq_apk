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
  private b cNA;
  private IntBuffer cNy;
  private FloatBuffer cNz;
  
  public JsTouchEventHandler()
  {
    AppMethodBeat.i(139991);
    this.cNA = new b(this);
    jo(10);
    AppMethodBeat.o(139991);
  }
  
  private void jo(int paramInt)
  {
    AppMethodBeat.i(139993);
    if ((this.cNy != null) && (this.cNy.capacity() >= paramInt))
    {
      this.cNy.clear();
      this.cNz.clear();
      AppMethodBeat.o(139993);
      return;
    }
    if (this.cNy != null)
    {
      i = this.cNy.capacity();
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
    if (this.cNy == null) {}
    for (int i = 0;; i = this.cNy.capacity())
    {
      c.c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      this.cNy = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
      this.cNz = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
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
  
  public final JsTouchEventHandler.a Vg()
  {
    return this.cNA;
  }
  
  public final long a(MotionEvent paramMotionEvent, float paramFloat, boolean paramBoolean)
  {
    int j = -1;
    AppMethodBeat.i(203660);
    jo(paramMotionEvent.getPointerCount());
    int m = p(paramMotionEvent);
    if (m == -1)
    {
      AppMethodBeat.o(203660);
      return 0L;
    }
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    if (i < k)
    {
      this.cNy.put(paramMotionEvent.getPointerId(i));
      float f;
      if (paramBoolean)
      {
        FloatBuffer localFloatBuffer = this.cNz;
        if (i == 0)
        {
          f = paramMotionEvent.getRawX();
          label86:
          localFloatBuffer.put(f / paramFloat);
          localFloatBuffer = this.cNz;
          if (i != 0) {
            break label153;
          }
          f = paramMotionEvent.getRawY();
          label113:
          localFloatBuffer.put(f / paramFloat);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f = paramMotionEvent.getX(i) + (paramMotionEvent.getRawX() - paramMotionEvent.getX());
        break label86;
        label153:
        f = paramMotionEvent.getY(i) + (paramMotionEvent.getRawY() - paramMotionEvent.getY());
        break label113;
        this.cNz.put(paramMotionEvent.getX(i) / paramFloat);
        this.cNz.put(paramMotionEvent.getY(i) / paramFloat);
      }
    }
    int n = p(paramMotionEvent);
    if (m == 1) {}
    for (i = j;; i = paramMotionEvent.getActionIndex())
    {
      long l = nativeCreateTouchEvent(n, i, k, this.cNy, this.cNz, paramMotionEvent.getEventTime());
      AppMethodBeat.o(203660);
      return l;
    }
  }
  
  public static final class b
    implements JsTouchEventHandler.a
  {
    private WeakReference<JsTouchEventHandler> cNB;
    
    public b(JsTouchEventHandler paramJsTouchEventHandler)
    {
      AppMethodBeat.i(139989);
      this.cNB = new WeakReference(paramJsTouchEventHandler);
      AppMethodBeat.o(139989);
    }
    
    public final void bh(long paramLong)
    {
      AppMethodBeat.i(139990);
      JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.cNB.get();
      if (localJsTouchEventHandler != null) {
        JsTouchEventHandler.a(localJsTouchEventHandler, paramLong);
      }
      AppMethodBeat.o(139990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.JsTouchEventHandler
 * JD-Core Version:    0.7.0.1
 */