package com.tencent.mm.be;

import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$6
  implements ServerMessageListener
{
  b$6(b paramb) {}
  
  public final void onMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(78533);
    ab.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramInt), paramString });
    if ((paramInt != 0) && (b.o(this.fNW) > 3))
    {
      ab.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
      b.aje();
      this.fNW.aiX();
    }
    AppMethodBeat.o(78533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.be.b.6
 * JD-Core Version:    0.7.0.1
 */