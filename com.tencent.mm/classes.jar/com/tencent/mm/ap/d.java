package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.al;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public final class d
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean nb(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20479);
    ad.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!nb(paramInt))
    {
      ad.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(336, 10);
    long l = System.currentTimeMillis();
    az.arV();
    if (bt.l((Integer)c.afk().get(86017, null)) == 3)
    {
      ad.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    az.arV();
    c.afg().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    az.arV();
    Cursor localCursor = c.apM().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      af localaf = new af();
      localaf.convertFrom(localCursor);
      az.arV();
      c.apM().e(localaf.field_username, localaf);
      localCursor.moveToNext();
    }
    localCursor.close();
    ad.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    az.arV();
    c.afk().set(86017, Integer.valueOf(3));
    ad.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ap.d
 * JD-Core Version:    0.7.0.1
 */