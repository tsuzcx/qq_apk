package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class am$7$1
  implements Runnable
{
  am$7$1(am.7 param7, String paramString, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87940);
    Object localObject1 = am.bcn();
    Object localObject2 = this.gWF;
    ab.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(this.fkG.eyJ.pIG)));
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = br.F((String)localObject2, "sysmsg");
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 == null)
        {
          ab.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
          AppMethodBeat.o(87940);
        }
      }
      else
      {
        localObject1 = new c.a((c)localObject1);
        String str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
        if ((!TextUtils.isEmpty(str)) && (l.isNumeric(str))) {}
        for (((c.a)localObject1).kpN = Integer.valueOf(str).intValue();; ((c.a)localObject1).kpN = 0)
        {
          ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
          ((c.a)localObject1).cHn = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
          break;
        }
      }
      if (TextUtils.isEmpty(((c.a)localObject1).cHn)) {
        ab.e("MicroMsg.ShareCardMsgMgr", "card id == null");
      }
      ab.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).cHn);
      am.bck().bcy();
      l.bfB();
    }
    AppMethodBeat.o(87940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.7.1
 * JD-Core Version:    0.7.0.1
 */