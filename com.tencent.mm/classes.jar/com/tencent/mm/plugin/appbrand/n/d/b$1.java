package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements e.c
{
  b$1(b paramb) {}
  
  public final void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102207);
    ab.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
    HashMap localHashMap = new HashMap();
    localHashMap.put("fg", paramArrayOfByte1);
    localHashMap.put("bg", paramArrayOfByte2);
    this.iuu.E(localHashMap);
    AppMethodBeat.o(102207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d.b.1
 * JD-Core Version:    0.7.0.1
 */