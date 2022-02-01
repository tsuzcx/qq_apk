package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;

public final class d
  extends ao
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20479);
    ae.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!os(paramInt))
    {
      ae.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    g.yxI.dD(336, 10);
    long l = System.currentTimeMillis();
    bc.aCg();
    if (bu.o((Integer)c.ajA().get(86017, null)) == 3)
    {
      ae.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    bc.aCg();
    c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    bc.aCg();
    Cursor localCursor = c.azF().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      an localan = new an();
      localan.convertFrom(localCursor);
      bc.aCg();
      c.azF().e(localan.field_username, localan);
      localCursor.moveToNext();
    }
    localCursor.close();
    ae.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    bc.aCg();
    c.ajA().set(86017, Integer.valueOf(3));
    ae.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */