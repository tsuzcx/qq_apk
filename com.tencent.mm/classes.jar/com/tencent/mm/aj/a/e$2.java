package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.bo;

final class e$2
  implements Runnable
{
  e$2(String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(11531);
    c localc = z.afk().sl(this.fxG);
    if (localc == null)
    {
      AppMethodBeat.o(11531);
      return;
    }
    if (localc.field_chatVersion < bo.getInt(this.fxH, 2147483647))
    {
      localc.field_needToUpdate = true;
      z.afk().b(localc);
    }
    if (localc.isGroup())
    {
      z.afq().aH(localc.field_bizChatServId, this.fxD);
      AppMethodBeat.o(11531);
      return;
    }
    z.afq().aJ(localc.field_bizChatServId, this.fxD);
    AppMethodBeat.o(11531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.e.2
 * JD-Core Version:    0.7.0.1
 */