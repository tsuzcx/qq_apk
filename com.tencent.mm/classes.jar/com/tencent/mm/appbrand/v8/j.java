package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  implements d
{
  private final AtomicInteger cMM;
  private final Map<Integer, a> cMN;
  private final m cMO;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.cMO = paramm;
    this.cMM = new AtomicInteger(0);
    this.cMN = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.cMN.containsKey(Integer.valueOf(paramInt)))
    {
      ac.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    ac.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.cMN.get(Integer.valueOf(paramInt));
    locala.cMO.cMX.r(new j.a.1(locala));
    this.cMN.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int hp(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.cMM.addAndGet(1);
    a locala = new a(paramInt, this.cMO);
    this.cMN.put(Integer.valueOf(i), locala);
    ac.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer hq(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.cMN.containsKey(Integer.valueOf(paramInt)))
    {
      ac.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.cMN.get(Integer.valueOf(paramInt));
    if (((a)localObject).cMR == null) {
      ((a)localObject).cMR = ((a)localObject).cMO.LR().newSharedV8ArrayBuffer(((a)localObject).cMQ);
    }
    localObject = ((a)localObject).cMR;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer hr(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.cMN.containsKey(Integer.valueOf(paramInt)))
    {
      ac.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.cMN.get(Integer.valueOf(paramInt))).cMQ;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m cMO;
    private final int cMP;
    ByteBuffer cMQ;
    SharedV8ArrayBuffer cMR;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.cMO = paramm;
      this.cMP = paramInt;
      this.cMQ = ByteBuffer.allocateDirect(this.cMP);
      this.cMR = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */