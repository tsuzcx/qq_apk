package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  implements d
{
  private final AtomicInteger dpF;
  private final Map<Integer, a> dpG;
  private final m dpH;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.dpH = paramm;
    this.dpF = new AtomicInteger(0);
    this.dpG = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.dpG.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.dpG.get(Integer.valueOf(paramInt));
    locala.dpH.dpQ.r(new j.a.1(locala));
    this.dpG.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int iQ(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.dpF.addAndGet(1);
    a locala = new a(paramInt, this.dpH);
    this.dpG.put(Integer.valueOf(i), locala);
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer iR(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.dpG.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.dpG.get(Integer.valueOf(paramInt));
    if (((a)localObject).dpK == null) {
      ((a)localObject).dpK = ((a)localObject).dpH.XJ().newSharedV8ArrayBuffer(((a)localObject).dpJ);
    }
    localObject = ((a)localObject).dpK;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer iS(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.dpG.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.dpG.get(Integer.valueOf(paramInt))).dpJ;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m dpH;
    private final int dpI;
    ByteBuffer dpJ;
    SharedV8ArrayBuffer dpK;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.dpH = paramm;
      this.dpI = paramInt;
      this.dpJ = ByteBuffer.allocateDirect(this.dpI);
      this.dpK = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */