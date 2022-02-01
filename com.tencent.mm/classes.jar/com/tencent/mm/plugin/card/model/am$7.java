package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

final class am$7
  implements cc.a
{
  am$7(am paramam) {}
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(112880);
    final String str = z.a(parama.fTo.Cxz);
    if ((str == null) || (str.length() == 0))
    {
      ad.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(112880);
      return;
    }
    am.a(this.nuz).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112879);
        Object localObject1 = am.bJf();
        Object localObject2 = str;
        ad.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(parama.fTo.uKZ)));
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = bw.K((String)localObject2, "sysmsg");
          if (localObject2 == null)
          {
            localObject1 = null;
            if (localObject1 == null)
            {
              ad.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
              AppMethodBeat.o(112879);
            }
          }
          else
          {
            localObject1 = new c.a((c)localObject1);
            String str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
            if ((!TextUtils.isEmpty(str)) && (l.isNumeric(str))) {}
            for (((c.a)localObject1).nvh = bt.getInt(str, 0);; ((c.a)localObject1).nvh = 0)
            {
              ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
              ((c.a)localObject1).dyc = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
              break;
            }
          }
          if (TextUtils.isEmpty(((c.a)localObject1).dyc)) {
            ad.e("MicroMsg.ShareCardMsgMgr", "card id == null");
          }
          ad.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).dyc);
          am.bJc().bJw();
          l.bMM();
        }
        AppMethodBeat.o(112879);
      }
    });
    AppMethodBeat.o(112880);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.7
 * JD-Core Version:    0.7.0.1
 */