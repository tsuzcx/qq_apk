package com.tencent.mm.plugin.luckymoney.app;

import android.net.Uri;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adn;
import com.tencent.mm.autogen.a.adn.a;
import com.tencent.mm.message.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.story.b.e;
import com.tencent.mm.plugin.luckymoney.story.b.f;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class SubCoreLuckyMoney$12
  extends IListener<adn>
{
  SubCoreLuckyMoney$12(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(284074);
    this.__eventId = adn.class.getName().hashCode();
    AppMethodBeat.o(284074);
  }
  
  private boolean a(adn paramadn)
  {
    AppMethodBeat.i(284080);
    k.b localb;
    Object localObject;
    if (!Util.isNullOrNil(paramadn.ihH.hWn))
    {
      localb = k.b.Hf(paramadn.ihH.hWn);
      if (!Util.isNullOrNil(localb.nSL))
      {
        Log.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.nSL });
        localObject = Uri.parse(Util.nullAsNil(localb.nSL));
      }
    }
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("sendid");
      c localc = (c)localb.aK(c.class);
      ad localad2 = u.iiy().bgT(localb.nSL);
      ad localad1 = localad2;
      if (localad2 == null) {
        localad1 = new ad();
      }
      if (Util.isNullOrNil(localad1.field_mNativeUrl))
      {
        localad1.field_mNativeUrl = localb.nSL;
        localad1.field_receiveStatus = 0;
        if (!Util.isNullOrNil(localc.nQc))
        {
          localad1.field_hbType = 3;
          localad1.field_exclusiveUsername = localc.nQc;
        }
        localad1.field_invalidtime = localb.nSl;
        localad1.field_sender = paramadn.ihH.ihI;
        localad1.field_sendId = ((String)localObject);
        localad1.field_msgSvrId = paramadn.ihH.hTh;
      }
      u.iiy().a(localad1);
      if ((localad1.field_hbType == 3) && (z.bAM().equals(localad1.field_exclusiveUsername))) {
        this.KlU.co(paramadn.ihH.ihI, true);
      }
      paramadn = new e();
      paramadn.field_send_id = ((String)localObject);
      if (!this.KlU.fWj().get(paramadn, new String[0]))
      {
        paramadn.field_open_count = 0;
        Log.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { localObject, Boolean.valueOf(this.KlU.fWj().insert(paramadn)) });
      }
      AppMethodBeat.o(284080);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.app.SubCoreLuckyMoney.12
 * JD-Core Version:    0.7.0.1
 */