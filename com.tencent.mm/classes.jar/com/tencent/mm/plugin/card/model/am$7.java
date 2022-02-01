package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.c;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class am$7
  implements ck.a
{
  am$7(am paramam) {}
  
  public final void a(final h.a parama)
  {
    AppMethodBeat.i(112880);
    final String str = z.a(parama.jQG.RIF);
    if ((str == null) || (str.length() == 0))
    {
      Log.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(112880);
      return;
    }
    am.a(this.trc).post(new Runnable()
    {
      public final void run()
      {
        c.a locala = null;
        AppMethodBeat.i(112879);
        Object localObject2 = am.cHC();
        Object localObject1 = str;
        Log.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(parama.jQG.HlH)));
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
          if (localObject1 == null)
          {
            if (locala == null)
            {
              Log.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
              AppMethodBeat.o(112879);
            }
          }
          else
          {
            locala = new c.a((c)localObject2);
            localObject2 = (String)((Map)localObject1).get(".sysmsg.notifysharecard.state_flag");
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (l.isNumeric((String)localObject2))) {}
            for (locala.trS = Util.getInt((String)localObject2, 0);; locala.trS = 0)
            {
              locala.username = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.username"));
              locala.fUL = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.card_id"));
              break;
            }
          }
          if (TextUtils.isEmpty(locala.fUL)) {
            Log.e("MicroMsg.ShareCardMsgMgr", "card id == null");
          }
          Log.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + locala.fUL);
          am.cHz().cHW();
          l.cLi();
        }
        AppMethodBeat.o(112879);
      }
    });
    AppMethodBeat.o(112880);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.7
 * JD-Core Version:    0.7.0.1
 */