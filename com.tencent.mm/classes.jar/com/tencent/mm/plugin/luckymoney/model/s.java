package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class s
{
  public static void eOD()
  {
    AppMethodBeat.i(202742);
    if ((int)((n)h.ae(n.class)).bbL().bwg("1@fackuser").jxt > 0) {
      ((n)h.ae(n.class)).bbL().bwp("1@fackuser");
    }
    as localas = new as();
    localas.setUsername("1@fackuser");
    localas.setNickname(MMApplicationContext.getContext().getString(a.i.lucky_money_preview_contact_name));
    localas.axk();
    localas.jxt = -99L;
    localas.pv(3);
    ((n)h.ae(n.class)).bbL().as(localas);
    AppMethodBeat.o(202742);
  }
  
  public static void eOE()
  {
    AppMethodBeat.i(202745);
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", new Object[] { Integer.valueOf(((n)h.ae(n.class)).eSe().aOF("1@fackuser").getCount()) });
    ((n)h.ae(n.class)).eSe().aOO("1@fackuser");
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", new Object[] { Integer.valueOf(((n)h.ae(n.class)).eSe().aOF("1@fackuser").getCount()) });
    AppMethodBeat.o(202745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s
 * JD-Core Version:    0.7.0.1
 */