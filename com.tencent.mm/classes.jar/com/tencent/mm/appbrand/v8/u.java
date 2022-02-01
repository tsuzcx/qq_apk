package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements e
{
  private final AtomicInteger dar;
  private final AtomicInteger das;
  private final SparseArray<ByteBuffer> dat;
  
  public u()
  {
    AppMethodBeat.i(144103);
    this.dar = new AtomicInteger(0);
    this.das = new AtomicInteger(0);
    this.dat = new SparseArray();
    AppMethodBeat.o(144103);
  }
  
  public final void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144107);
    ae.e("V8EngineBufferStore", "no bind to here");
    AppMethodBeat.o(144107);
  }
  
  public final int generateId()
  {
    AppMethodBeat.i(144104);
    try
    {
      int i = this.dar.addAndGet(1);
      this.dat.put(i, null);
      ae.i("V8EngineBufferStore", "generateId:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144104);
      return i;
    }
    finally
    {
      AppMethodBeat.o(144104);
    }
  }
  
  public final ByteBuffer getBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194187);
    try
    {
      ByteBuffer localByteBuffer1 = (ByteBuffer)this.dat.get(paramInt);
      this.dat.remove(paramInt);
      if (localByteBuffer1 == null)
      {
        ae.e("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(194187);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(194187);
    }
    int i = localByteBuffer2.capacity();
    ae.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.das.addAndGet(-i)) });
    AppMethodBeat.o(194187);
    return localByteBuffer2;
  }
  
  public final void releaseDirectByteBuffer(ByteBuffer paramByteBuffer) {}
  
  public final void setBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144106);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(144106);
      return;
    }
    ByteBuffer localByteBuffer = x.q(paramByteBuffer);
    if (!localByteBuffer.isDirect())
    {
      ae.i("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144106);
      return;
    }
    try
    {
      if (this.dat.indexOfKey(paramInt) < 0)
      {
        ae.i("V8EngineBufferStore", "setBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.dat.put(paramInt, localByteBuffer);
      ae.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.das.addAndGet(paramByteBuffer.capacity())) });
      AppMethodBeat.o(144106);
      return;
    }
    finally
    {
      AppMethodBeat.o(144106);
    }
  }
  
  public final boolean supportBufferStoreBindTo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u
 * JD-Core Version:    0.7.0.1
 */