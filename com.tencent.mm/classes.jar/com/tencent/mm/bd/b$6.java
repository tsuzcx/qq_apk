package com.tencent.mm.bd;

import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements ServerMessageListener
{
  b$6(b paramb) {}
  
  public final void onMessage(int paramInt, String paramString)
  {
    y.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", new Object[] { Integer.valueOf(paramInt), paramString });
    if ((paramInt != 0) && (b.o(this.eyi) > 3))
    {
      y.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", new Object[] { Integer.valueOf(3) });
      b.PZ();
      this.eyi.PS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bd.b.6
 * JD-Core Version:    0.7.0.1
 */