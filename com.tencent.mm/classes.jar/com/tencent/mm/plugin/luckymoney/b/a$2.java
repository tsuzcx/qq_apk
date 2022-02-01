package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.ye.a;
import com.tencent.mm.plugin.luckymoney.story.b.e;
import com.tencent.mm.plugin.luckymoney.story.b.f;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class a$2
  extends com.tencent.mm.sdk.b.c<ye>
{
  a$2(a parama)
  {
    AppMethodBeat.i(207092);
    this.__eventId = ye.class.getName().hashCode();
    AppMethodBeat.o(207092);
  }
  
  private boolean a(ye paramye)
  {
    AppMethodBeat.i(207093);
    Object localObject;
    if (!bs.isNullOrNil(paramye.dBH.drV))
    {
      k.b localb = k.b.vA(paramye.dBH.drV);
      if (!bs.isNullOrNil(localb.hjo))
      {
        ac.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[] { localb.hjo });
        localObject = s.eru().azx(localb.hjo);
        paramye = (ye)localObject;
        if (localObject == null) {
          paramye = new ad();
        }
        if (bs.isNullOrNil(paramye.field_mNativeUrl))
        {
          paramye.field_mNativeUrl = localb.hjo;
          paramye.field_receiveStatus = 0;
        }
        s.eru().a(paramye);
      }
      if (!bs.isNullOrNil(localb.hjo)) {
        paramye = Uri.parse(bs.nullAsNil(localb.hjo));
      }
    }
    try
    {
      paramye = paramye.getQueryParameter("sendid");
      localObject = new e();
      ((e)localObject).field_send_id = paramye;
      if (!this.ugm.cYu().get((com.tencent.mm.sdk.e.c)localObject, new String[0]))
      {
        ((e)localObject).field_open_count = 0;
        ac.d("MicroMsg.SubCoreLuckyMoney", "insert record: %s, %s", new Object[] { paramye, Boolean.valueOf(this.ugm.cYu().insert((com.tencent.mm.sdk.e.c)localObject)) });
      }
      label209:
      AppMethodBeat.o(207093);
      return false;
    }
    catch (Exception paramye)
    {
      break label209;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a.2
 * JD-Core Version:    0.7.0.1
 */