package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  implements d
{
  private final AtomicInteger cZa;
  private final Map<Integer, a> cZb;
  private final m cZc;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.cZc = paramm;
    this.cZa = new AtomicInteger(0);
    this.cZb = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.cZb.containsKey(Integer.valueOf(paramInt)))
    {
      ae.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    ae.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.cZb.get(Integer.valueOf(paramInt));
    locala.cZc.cZl.r(new j.a.1(locala));
    this.cZb.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int hw(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.cZa.addAndGet(1);
    a locala = new a(paramInt, this.cZc);
    this.cZb.put(Integer.valueOf(i), locala);
    ae.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer hx(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.cZb.containsKey(Integer.valueOf(paramInt)))
    {
      ae.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.cZb.get(Integer.valueOf(paramInt));
    if (((a)localObject).cZf == null) {
      ((a)localObject).cZf = ((a)localObject).cZc.Ny().newSharedV8ArrayBuffer(((a)localObject).cZe);
    }
    localObject = ((a)localObject).cZf;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer hy(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.cZb.containsKey(Integer.valueOf(paramInt)))
    {
      ae.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.cZb.get(Integer.valueOf(paramInt))).cZe;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m cZc;
    private final int cZd;
    ByteBuffer cZe;
    SharedV8ArrayBuffer cZf;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.cZc = paramm;
      this.cZd = paramInt;
      this.cZe = ByteBuffer.allocateDirect(this.cZd);
      this.cZf = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */