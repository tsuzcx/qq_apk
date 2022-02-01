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
  private IntBuffer cql;
  private FloatBuffer cqm;
  private b cqn;
  
  public JsTouchEventHandler()
  {
    AppMethodBeat.i(139991);
    this.cqn = new b(this);
    hf(10);
    AppMethodBeat.o(139991);
  }
  
  private void hf(int paramInt)
  {
    AppMethodBeat.i(139993);
    if ((this.cql != null) && (this.cql.capacity() >= paramInt))
    {
      this.cql.clear();
      this.cqm.clear();
      AppMethodBeat.o(139993);
      return;
    }
    if (this.cql != null)
    {
      i = this.cql.capacity();
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
    if (this.cql == null) {}
    for (int i = 0;; i = this.cql.capacity())
    {
      c.c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      this.cql = ByteBuffer.allocateDirect(j * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
      this.cqm = ByteBuffer.allocateDirect(j * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      AppMethodBeat.o(139993);
      return;
    }
  }
  
  private native long nativeCreateTouchEvent(int paramInt1, int paramInt2, int paramInt3, IntBuffer paramIntBuffer, FloatBuffer paramFloatBuffer, long paramLong);
  
  private native void nativeFreeTouchEvent(long paramLong);
  
  private static int o(MotionEvent paramMotionEvent)
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
  
  public final a Gs()
  {
    return this.cqn;
  }
  
  public final long a(MotionEvent paramMotionEvent, float paramFloat)
  {
    int j = -1;
    AppMethodBeat.i(139992);
    hf(paramMotionEvent.getPointerCount());
    int m = o(paramMotionEvent);
    if (m == -1)
    {
      AppMethodBeat.o(139992);
      return 0L;
    }
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < k)
    {
      this.cql.put(paramMotionEvent.getPointerId(i));
      this.cqm.put(paramMotionEvent.getX(i) / paramFloat);
      this.cqm.put(paramMotionEvent.getY(i) / paramFloat);
      i += 1;
    }
    int n = o(paramMotionEvent);
    if (m == 1) {}
    for (i = j;; i = paramMotionEvent.getActionIndex())
    {
      long l = nativeCreateTouchEvent(n, i, k, this.cql, this.cqm, paramMotionEvent.getEventTime());
      AppMethodBeat.o(139992);
      return l;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aQ(long paramLong);
  }
  
  public static final class b
    implements JsTouchEventHandler.a
  {
    private WeakReference<JsTouchEventHandler> cqo;
    
    public b(JsTouchEventHandler paramJsTouchEventHandler)
    {
      AppMethodBeat.i(139989);
      this.cqo = new WeakReference(paramJsTouchEventHandler);
      AppMethodBeat.o(139989);
    }
    
    public final void aQ(long paramLong)
    {
      AppMethodBeat.i(139990);
      JsTouchEventHandler localJsTouchEventHandler = (JsTouchEventHandler)this.cqo.get();
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