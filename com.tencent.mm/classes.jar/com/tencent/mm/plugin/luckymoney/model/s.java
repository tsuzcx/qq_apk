package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class s
{
  public static void fXa()
  {
    AppMethodBeat.i(283986);
    if ((int)((n)h.ax(n.class)).bzA().bxu("1@fackuser").maN > 0) {
      ((n)h.ax(n.class)).bzA().bxC("1@fackuser");
    }
    au localau = new au();
    localau.setUsername("1@fackuser");
    localau.setNickname(MMApplicationContext.getContext().getString(a.i.lucky_money_preview_contact_name));
    localau.aRK();
    localau.maN = -99L;
    localau.pu(3);
    ((n)h.ax(n.class)).bzA().ay(localau);
    AppMethodBeat.o(283986);
  }
  
  public static void fXb()
  {
    AppMethodBeat.i(283989);
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", new Object[] { Integer.valueOf(((n)h.ax(n.class)).gaZ().aLE("1@fackuser").getCount()) });
    ((n)h.ax(n.class)).gaZ().aLO("1@fackuser");
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", new Object[] { Integer.valueOf(((n)h.ax(n.class)).gaZ().aLE("1@fackuser").getCount()) });
    AppMethodBeat.o(283989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s
 * JD-Core Version:    0.7.0.1
 */