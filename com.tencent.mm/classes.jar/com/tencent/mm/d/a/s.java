package com.tencent.mm.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
  implements f
{
  private final AtomicInteger ccr;
  private final AtomicInteger ccs;
  private final HashMap<Integer, ByteBuffer> cct;
  
  public s()
  {
    AppMethodBeat.i(113887);
    this.ccr = new AtomicInteger(0);
    this.ccs = new AtomicInteger(0);
    this.cct = new HashMap();
    AppMethodBeat.o(113887);
  }
  
  public final int Co()
  {
    AppMethodBeat.i(113888);
    Integer localInteger = Integer.valueOf(this.ccr.addAndGet(1));
    this.cct.put(localInteger, null);
    ab.i("V8EngineBufferStore", "generateId:%d", new Object[] { localInteger });
    int i = localInteger.intValue();
    AppMethodBeat.o(113888);
    return i;
  }
  
  public final void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(113890);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(113890);
      return;
    }
    ByteBuffer localByteBuffer;
    if (paramByteBuffer == null) {
      localByteBuffer = paramByteBuffer;
    }
    while (!localByteBuffer.isDirect())
    {
      ab.i("V8EngineBufferStore", "setBuffer: cannot convert to direct buffer");
      AppMethodBeat.o(113890);
      return;
      if (paramByteBuffer.isDirect()) {
        localByteBuffer = paramByteBuffer;
      } else if (!paramByteBuffer.hasArray()) {
        localByteBuffer = paramByteBuffer;
      } else {
        localByteBuffer = q.ak(paramByteBuffer.array());
      }
    }
    if (!this.cct.containsKey(Integer.valueOf(paramInt)))
    {
      ab.i("V8EngineBufferStore", "setBuffer: already in the store");
      AppMethodBeat.o(113890);
      return;
    }
    ab.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()), Integer.valueOf(this.ccs.addAndGet(paramByteBuffer.capacity())) });
    this.cct.put(Integer.valueOf(paramInt), localByteBuffer);
    AppMethodBeat.o(113890);
  }
  
  public final ByteBuffer gk(int paramInt)
  {
    AppMethodBeat.i(113889);
    if (!this.cct.containsKey(Integer.valueOf(paramInt)))
    {
      ab.i("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(113889);
      return null;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)this.cct.get(Integer.valueOf(paramInt));
    this.cct.remove(Integer.valueOf(paramInt));
    if (localByteBuffer == null) {}
    for (int i = 0;; i = localByteBuffer.capacity())
    {
      ab.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ccs.addAndGet(-i)) });
      AppMethodBeat.o(113889);
      return localByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.s
 * JD-Core Version:    0.7.0.1
 */