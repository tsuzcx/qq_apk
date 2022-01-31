package com.tencent.mm.d.a;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class k
  implements e
{
  private final AtomicInteger cbw;
  private final Map<Integer, k.a> cbx;
  private final l cby;
  
  public k(l paraml)
  {
    AppMethodBeat.i(113830);
    this.cby = paraml;
    this.cbw = new AtomicInteger(0);
    this.cbx = new HashMap();
    AppMethodBeat.o(113830);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(113834);
    if (!this.cbx.containsKey(Integer.valueOf(paramInt)))
    {
      ab.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(113834);
      return;
    }
    ab.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    k.a locala = (k.a)this.cbx.get(Integer.valueOf(paramInt));
    locala.cby.cbC.k(new k.a.1(locala));
    this.cbx.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(113834);
  }
  
  public final int gh(int paramInt)
  {
    AppMethodBeat.i(113831);
    int i = this.cbw.addAndGet(1);
    k.a locala = new k.a(paramInt, this.cby);
    this.cbx.put(Integer.valueOf(i), locala);
    ab.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(113831);
    return i;
  }
  
  public final SharedV8ArrayBuffer gi(int paramInt)
  {
    AppMethodBeat.i(113832);
    if (!this.cbx.containsKey(Integer.valueOf(paramInt)))
    {
      ab.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(113832);
      return null;
    }
    Object localObject = (k.a)this.cbx.get(Integer.valueOf(paramInt));
    if (((k.a)localObject).cbA == null) {
      ((k.a)localObject).cbA = ((k.a)localObject).cby.Cu().newSharedV8ArrayBuffer(((k.a)localObject).cbz);
    }
    localObject = ((k.a)localObject).cbA;
    AppMethodBeat.o(113832);
    return localObject;
  }
  
  public final ByteBuffer gj(int paramInt)
  {
    AppMethodBeat.i(113833);
    if (!this.cbx.containsKey(Integer.valueOf(paramInt)))
    {
      ab.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(113833);
      return null;
    }
    ByteBuffer localByteBuffer = ((k.a)this.cbx.get(Integer.valueOf(paramInt))).cbz;
    AppMethodBeat.o(113833);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.k
 * JD-Core Version:    0.7.0.1
 */