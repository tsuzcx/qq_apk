package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements e
{
  private final AtomicInteger dqV;
  private final AtomicInteger dqW;
  private final SparseArray<ByteBuffer> dqX;
  
  public u()
  {
    AppMethodBeat.i(144103);
    this.dqV = new AtomicInteger(0);
    this.dqW = new AtomicInteger(0);
    this.dqX = new SparseArray();
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
      int i = this.dqV.addAndGet(1);
      this.dqX.put(i, null);
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
    AppMethodBeat.i(216907);
    try
    {
      ByteBuffer localByteBuffer1 = (ByteBuffer)this.dqX.get(paramInt);
      this.dqX.remove(paramInt);
      if (localByteBuffer1 == null)
      {
        Log.e("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(216907);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(216907);
    }
    int i = localByteBuffer2.capacity();
    Log.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dqW.addAndGet(-i)) });
    AppMethodBeat.o(216907);
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
      Log.i("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144106);
      return;
    }
    try
    {
      if (this.dqX.indexOfKey(paramInt) < 0)
      {
        Log.i("V8EngineBufferStore", "setBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.dqX.put(paramInt, localByteBuffer);
      Log.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.dqW.addAndGet(paramByteBuffer.capacity())) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u
 * JD-Core Version:    0.7.0.1
 */