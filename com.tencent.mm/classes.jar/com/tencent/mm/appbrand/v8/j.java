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
  private final AtomicInteger fim;
  private final Map<Integer, a> fin;
  private final m fio;
  
  public j(m paramm)
  {
    AppMethodBeat.i(144037);
    this.fio = paramm;
    this.fim = new AtomicInteger(0);
    this.fin = new HashMap();
    AppMethodBeat.o(144037);
  }
  
  public final void destroy(int paramInt)
  {
    AppMethodBeat.i(144041);
    if (!this.fin.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144041);
      return;
    }
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", new Object[] { Integer.valueOf(paramInt) });
    a locala = (a)this.fin.get(Integer.valueOf(paramInt));
    locala.fio.fiy.q(new j.a.1(locala));
    this.fin.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(144041);
  }
  
  public final int kg(int paramInt)
  {
    AppMethodBeat.i(144038);
    int i = this.fim.addAndGet(1);
    a locala = new a(paramInt, this.fio);
    this.fin.put(Integer.valueOf(i), locala);
    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(144038);
    return i;
  }
  
  public final SharedV8ArrayBuffer kh(int paramInt)
  {
    AppMethodBeat.i(144039);
    if (!this.fin.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144039);
      return null;
    }
    Object localObject = (a)this.fin.get(Integer.valueOf(paramInt));
    if (((a)localObject).fir == null) {
      ((a)localObject).fir = ((a)localObject).fio.acm().newSharedV8ArrayBuffer(((a)localObject).fiq);
    }
    localObject = ((a)localObject).fir;
    AppMethodBeat.o(144039);
    return localObject;
  }
  
  public final ByteBuffer ki(int paramInt)
  {
    AppMethodBeat.i(144040);
    if (!this.fin.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(144040);
      return null;
    }
    ByteBuffer localByteBuffer = ((a)this.fin.get(Integer.valueOf(paramInt))).fiq;
    AppMethodBeat.o(144040);
    return localByteBuffer;
  }
  
  static final class a
  {
    final m fio;
    private final int fip;
    ByteBuffer fiq;
    SharedV8ArrayBuffer fir;
    
    a(int paramInt, m paramm)
    {
      AppMethodBeat.i(144036);
      this.fio = paramm;
      this.fip = paramInt;
      this.fiq = ByteBuffer.allocateDirect(this.fip);
      this.fir = null;
      AppMethodBeat.o(144036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.j
 * JD-Core Version:    0.7.0.1
 */