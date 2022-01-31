package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  public final void run()
  {
    y.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
    Object localObject1 = am.aAA();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
    localObject2 = "delete from ShareCardInfo" + ((StringBuilder)localObject2).toString();
    boolean bool = ((k)localObject1).dXw.gk("ShareCardInfo", (String)localObject2);
    localObject1 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      y.i("MicroMsg.ShareCardInfoStorage", i);
      y.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b.2
 * JD-Core Version:    0.7.0.1
 */