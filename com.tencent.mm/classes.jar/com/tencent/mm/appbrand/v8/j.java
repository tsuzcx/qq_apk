package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  implements d
{
  private final AtomicInteger cYc;
  private final Map<Integer, a> cYd;
  private final m cYe;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.cYe = paramm;
    this.cYc = new AtomicInteger(0);
    this.cYd = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.cYd.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    ad.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.cYd.get(Integer.valueOf(paramInt));
    locala.cYe.cYn.r(new j.a.1(locala));
    this.cYd.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int hw(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.cYc.addAndGet(1);
    a locala = new a(paramInt, this.cYe);
    this.cYd.put(Integer.valueOf(i), locala);
    ad.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer hx(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.cYd.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.cYd.get(Integer.valueOf(paramInt));
    if (((a)localObject).cYh == null) {
      ((a)localObject).cYh = ((a)localObject).cYe.NA().newSharedV8ArrayBuffer(((a)localObject).cYg);
    }
    localObject = ((a)localObject).cYh;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer hy(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.cYd.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.cYd.get(Integer.valueOf(paramInt))).cYg;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m cYe;
    private final int cYf;
    ByteBuffer cYg;
    SharedV8ArrayBuffer cYh;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.cYe = paramm;
      this.cYf = paramInt;
      this.cYg = ByteBuffer.allocateDirect(this.cYf);
      this.cYh = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */