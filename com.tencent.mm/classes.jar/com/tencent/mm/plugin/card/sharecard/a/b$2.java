package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(87983);
    ab.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
    Object localObject1 = am.bcl();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
    localObject2 = "delete from ShareCardInfo" + ((StringBuilder)localObject2).toString();
    boolean bool = ((k)localObject1).db.execSQL("ShareCardInfo", (String)localObject2);
    localObject1 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.ShareCardInfoStorage", i);
      ab.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
      AppMethodBeat.o(87983);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b.2
 * JD-Core Version:    0.7.0.1
 */