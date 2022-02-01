package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements e
{
  private final AtomicInteger hnP;
  private final AtomicInteger hnQ;
  private final SparseArray<ByteBuffer> hnR;
  
  public u()
  {
    AppMethodBeat.i(144103);
    this.hnP = new AtomicInteger(0);
    this.hnQ = new AtomicInteger(0);
    this.hnR = new SparseArray();
    AppMethodBeat.o(144103);
  }
  
  public final void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144107);
    Log.e("V8EngineBufferStore", "no bind to here");
    AppMethodBeat.o(144107);
  }
  
  public final int generateId()
  {
    AppMethodBeat.i(144104);
    try
    {
      int i = this.hnP.addAndGet(1);
      this.hnR.put(i, null);
      Log.i("V8EngineBufferStore", "generateId:%d", new Object[] { Integer.valueOf(i) });
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
    AppMethodBeat.i(238633);
    try
    {
      ByteBuffer localByteBuffer1 = (ByteBuffer)this.hnR.get(paramInt);
      this.hnR.remove(paramInt);
      if (localByteBuffer1 == null)
      {
        Log.e("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(238633);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(238633);
    }
    int i = localByteBuffer2.capacity();
    Log.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hnQ.addAndGet(-i)) });
    AppMethodBeat.o(238633);
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
    ByteBuffer localByteBuffer = ae.t(paramByteBuffer);
    if (!localByteBuffer.isDirect())
    {
      Log.i("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144106);
      return;
    }
    try
    {
      if (this.hnR.indexOfKey(paramInt) < 0)
      {
        Log.i("V8EngineBufferStore", "setBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.hnR.put(paramInt, localByteBuffer);
      Log.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.hnQ.addAndGet(paramByteBuffer.capacity())) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u
 * JD-Core Version:    0.7.0.1
 */