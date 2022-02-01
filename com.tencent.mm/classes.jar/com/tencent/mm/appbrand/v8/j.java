package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.SharedV8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
  implements d
{
  private final Map<Integer, a> hmA;
  private final m hmB;
  private final AtomicInteger hmz;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.hmB = paramm;
    this.hmz = new AtomicInteger(0);
    this.hmA = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.hmA.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.hmA.get(Integer.valueOf(paramInt));
    locala.hmB.hmL.u(new j.a.1(locala));
    this.hmA.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int nO(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.hmz.addAndGet(1);
    a locala = new a(paramInt, this.hmB);
    this.hmA.put(Integer.valueOf(i), locala);
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer nP(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.hmA.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.hmA.get(Integer.valueOf(paramInt));
    if (((a)localObject).hmE == null) {
      ((a)localObject).hmE = ((a)localObject).hmB.aEm().newSharedV8ArrayBuffer(((a)localObject).hmD);
    }
    localObject = ((a)localObject).hmE;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer nQ(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.hmA.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.hmA.get(Integer.valueOf(paramInt))).hmD;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m hmB;
    private final int hmC;
    ByteBuffer hmD;
    SharedV8ArrayBuffer hmE;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.hmB = paramm;
      this.hmC = paramInt;
      this.hmD = ByteBuffer.allocateDirect(this.hmC);
      this.hmE = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */