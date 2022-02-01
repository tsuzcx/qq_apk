package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements e
{
  private final AtomicInteger cZt;
  private final AtomicInteger cZu;
  private final SparseArray<ByteBuffer> cZv;
  
  public u()
  {
    AppMethodBeat.i(144103);
    this.cZt = new AtomicInteger(0);
    this.cZu = new AtomicInteger(0);
    this.cZv = new SparseArray();
    AppMethodBeat.o(144103);
  }
  
  public final void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144107);
    ad.e("V8EngineBufferStore", "no bind to here");
    AppMethodBeat.o(144107);
  }
  
  public final int generateId()
  {
    AppMethodBeat.i(144104);
    try
    {
      int i = this.cZt.addAndGet(1);
      this.cZv.put(i, null);
      ad.i("V8EngineBufferStore", "generateId:%d", new Object[] { Integer.valueOf(i) });
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
    AppMethodBeat.i(221744);
    try
    {
      ByteBuffer localByteBuffer1 = (ByteBuffer)this.cZv.get(paramInt);
      this.cZv.remove(paramInt);
      if (localByteBuffer1 == null)
      {
        ad.e("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(221744);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(221744);
    }
    int i = localByteBuffer2.capacity();
    ad.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.cZu.addAndGet(-i)) });
    AppMethodBeat.o(221744);
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
    ByteBuffer localByteBuffer = v.q(paramByteBuffer);
    if (!localByteBuffer.isDirect())
    {
      ad.i("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144106);
      return;
    }
    try
    {
      if (this.cZv.indexOfKey(paramInt) < 0)
      {
        ad.i("V8EngineBufferStore", "setBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.cZv.put(paramInt, localByteBuffer);
      ad.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.cZu.addAndGet(paramByteBuffer.capacity())) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u
 * JD-Core Version:    0.7.0.1
 */