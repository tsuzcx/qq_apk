package com.tencent.mm.ap;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;

public final class d
  extends com.tencent.mm.model.au
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(20479);
    Log.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!vc(paramInt))
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(336, 10);
    long l = System.currentTimeMillis();
    bh.bCz();
    if (Util.nullAsNil((Integer)c.ban().d(86017, null)) == 3)
    {
      Log.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    bh.bCz();
    c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    bh.bCz();
    Cursor localCursor = c.bzA().g("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      com.tencent.mm.storage.au localau = new com.tencent.mm.storage.au();
      localau.convertFrom(localCursor);
      bh.bCz();
      c.bzA().f(localau.field_username, localau);
      localCursor.moveToNext();
    }
    localCursor.close();
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    bh.bCz();
    c.ban().B(86017, Integer.valueOf(3));
    Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
  
  public final boolean vc(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ap.d
 * JD-Core Version:    0.7.0.1
 */