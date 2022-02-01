package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h;

public final class d
  extends com.tencent.mm.model.am
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20479);
    ad.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!op(paramInt))
    {
      ad.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    g.yhR.dD(336, 10);
    long l = System.currentTimeMillis();
    ba.aBQ();
    if (bt.n((Integer)c.ajl().get(86017, null)) == 3)
    {
      ad.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    ba.aBQ();
    c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    ba.aBQ();
    Cursor localCursor = c.azp().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      com.tencent.mm.storage.am localam = new com.tencent.mm.storage.am();
      localam.convertFrom(localCursor);
      ba.aBQ();
      c.azp().e(localam.field_username, localam);
      localCursor.moveToNext();
    }
    localCursor.close();
    ad.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ba.aBQ();
    c.ajl().set(86017, Integer.valueOf(3));
    ad.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ap.d
 * JD-Core Version:    0.7.0.1
 */