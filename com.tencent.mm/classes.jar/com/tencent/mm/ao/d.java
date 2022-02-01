package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.al;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class d
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20479);
    ac.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!nP(paramInt))
    {
      ac.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(20479);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.dB(336, 10);
    long l = System.currentTimeMillis();
    az.ayM();
    if (bs.m((Integer)c.agA().get(86017, null)) == 3)
    {
      ac.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(20479);
      return;
    }
    az.ayM();
    c.agw().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    az.ayM();
    Cursor localCursor = c.awB().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      ai localai = new ai();
      localai.convertFrom(localCursor);
      az.ayM();
      c.awB().e(localai.field_username, localai);
      localCursor.moveToNext();
    }
    localCursor.close();
    ac.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    az.ayM();
    c.agA().set(86017, Integer.valueOf(3));
    ac.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(20479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */