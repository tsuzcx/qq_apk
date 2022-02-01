package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;

final class b$2
  implements g
{
  b$2(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(132538);
    ac.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramn.setHasCallbackToQueue(true);
    AppMethodBeat.o(132538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b.2
 * JD-Core Version:    0.7.0.1
 */