package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements d.c
{
  b$1(b paramb) {}
  
  public final void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(147407);
    Log.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
    HashMap localHashMap = new HashMap();
    localHashMap.put("fg", paramArrayOfByte1);
    localHashMap.put("bg", paramArrayOfByte2);
    this.qlO.T(localHashMap);
    AppMethodBeat.o(147407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.b.1
 * JD-Core Version:    0.7.0.1
 */