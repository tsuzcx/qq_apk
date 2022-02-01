package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class d
  extends at
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(20479);
    Log.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!uQ(paramInt))
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(336, 10);
    long l = System.currentTimeMillis();
    bh.beI();
    if (Util.nullAsNil((Integer)c.aHp().b(86017, null)) == 3)
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    bh.beI();
    c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    bh.beI();
    Cursor localCursor = c.bbL().e("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      as localas = new as();
      localas.convertFrom(localCursor);
      bh.beI();
      c.bbL().e(localas.field_username, localas);
      localCursor.moveToNext();
    }
    localCursor.close();
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    bh.beI();
    c.aHp().i(86017, Integer.valueOf(3));
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
  
  public final boolean uQ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ar.d
 * JD-Core Version:    0.7.0.1
 */