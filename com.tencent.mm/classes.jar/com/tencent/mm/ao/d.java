package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;

public final class d
  extends com.tencent.mm.model.as
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20479);
    Log.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!rT(paramInt))
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(336, 10);
    long l = System.currentTimeMillis();
    bg.aVF();
    if (Util.nullAsNil((Integer)c.azQ().get(86017, null)) == 3)
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    bg.aVF();
    c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    bg.aVF();
    Cursor localCursor = c.aSN().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
      localas.convertFrom(localCursor);
      bg.aVF();
      c.aSN().e(localas.field_username, localas);
      localCursor.moveToNext();
    }
    localCursor.close();
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    bg.aVF();
    c.azQ().set(86017, Integer.valueOf(3));
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */