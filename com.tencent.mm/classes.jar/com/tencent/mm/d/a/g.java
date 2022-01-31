package com.tencent.mm.d.a;

import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements a
{
  private final AtomicInteger bzy = new AtomicInteger(0);
  private final HashMap<Integer, ByteBuffer> bzz = new HashMap();
  
  public final void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    y.i("V8EngineBufferStore", "setBuffer %d isDirect:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramByteBuffer.isDirect()) });
    if (paramByteBuffer == null) {
      return;
    }
    ByteBuffer localByteBuffer;
    if (paramByteBuffer == null) {
      localByteBuffer = paramByteBuffer;
    }
    while (!localByteBuffer.isDirect())
    {
      y.i("V8EngineBufferStore", "setBuffer: cannot convert to direct buffer");
      return;
      localByteBuffer = paramByteBuffer;
      if (!paramByteBuffer.isDirect())
      {
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer.hasArray()) {
          localByteBuffer = n.Q(paramByteBuffer.array());
        }
      }
    }
    if (!this.bzz.containsKey(Integer.valueOf(paramInt)))
    {
      y.i("V8EngineBufferStore", "setBuffer: already in the store");
      return;
    }
    this.bzz.put(Integer.valueOf(paramInt), localByteBuffer);
  }
  
  public final ByteBuffer eu(int paramInt)
  {
    y.i("V8EngineBufferStore", "getBuffer:%d", new Object[] { Integer.valueOf(paramInt) });
    if (!this.bzz.containsKey(Integer.valueOf(paramInt)))
    {
      y.i("V8EngineBufferStore", "getBuffer:%d not contains", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)this.bzz.get(Integer.valueOf(paramInt));
    this.bzz.remove(Integer.valueOf(paramInt));
    return localByteBuffer;
  }
  
  public final int tD()
  {
    Integer localInteger = Integer.valueOf(this.bzy.addAndGet(1));
    this.bzz.put(localInteger, null);
    y.i("V8EngineBufferStore", "generateId:%d", new Object[] { localInteger });
    return localInteger.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.g
 * JD-Core Version:    0.7.0.1
 */