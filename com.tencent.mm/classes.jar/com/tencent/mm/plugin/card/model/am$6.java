package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class am$6
  implements bx.a
{
  am$6(am paramam) {}
  
  public final void a(final e.a parama)
  {
    final String str = aa.a(parama.dBs.svH);
    if ((str == null) || (str.length() == 0))
    {
      y.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
      return;
    }
    am.a(this.ior).post(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = am.aAC();
        Object localObject2 = str;
        String str = parama.dBs.ndp;
        y.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is " + str);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = bn.s((String)localObject2, "sysmsg");
          if (localObject2 == null)
          {
            localObject1 = null;
            if (localObject1 != null) {
              break label173;
            }
            y.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
          }
        }
        else
        {
          return;
        }
        localObject1 = new c.a((c)localObject1);
        str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
        if ((!TextUtils.isEmpty(str)) && (l.yS(str))) {}
        for (((c.a)localObject1).ioG = Integer.valueOf(str).intValue();; ((c.a)localObject1).ioG = 0)
        {
          ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
          ((c.a)localObject1).bZc = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
          break;
        }
        label173:
        if (TextUtils.isEmpty(((c.a)localObject1).bZc)) {
          y.e("MicroMsg.ShareCardMsgMgr", "card id == null");
        }
        y.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).bZc);
        am.aAz().aAN();
        l.aDe();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6
 * JD-Core Version:    0.7.0.1
 */