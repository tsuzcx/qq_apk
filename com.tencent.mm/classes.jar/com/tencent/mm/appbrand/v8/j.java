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
  private final AtomicInteger cPr;
  private final Map<Integer, a> cPs;
  private final m cPt;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.cPt = paramm;
    this.cPr = new AtomicInteger(0);
    this.cPs = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.cPs.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    ad.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.cPs.get(Integer.valueOf(paramInt));
    locala.cPt.cPC.q(new j.a.1(locala));
    this.cPs.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int hF(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.cPr.addAndGet(1);
    a locala = new a(paramInt, this.cPt);
    this.cPs.put(Integer.valueOf(i), locala);
    ad.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer hG(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.cPs.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.cPs.get(Integer.valueOf(paramInt));
    if (((a)localObject).cPw == null) {
      ((a)localObject).cPw = ((a)localObject).cPt.LT().newSharedV8ArrayBuffer(((a)localObject).cPv);
    }
    localObject = ((a)localObject).cPw;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer hH(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.cPs.containsKey(Integer.valueOf(paramInt)))
    {
      ad.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.cPs.get(Integer.valueOf(paramInt))).cPv;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m cPt;
    private final int cPu;
    ByteBuffer cPv;
    SharedV8ArrayBuffer cPw;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.cPt = paramm;
      this.cPu = paramInt;
      this.cPv = ByteBuffer.allocateDirect(this.cPu);
      this.cPw = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */