package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class e
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16433);
    ab.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!kv(paramInt))
    {
      ab.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      AppMethodBeat.o(16433);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.cT(336, 10);
    long l = System.currentTimeMillis();
    aw.aaz();
    if (bo.g((Integer)c.Ru().get(86017, null)) == 3)
    {
      ab.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      AppMethodBeat.o(16433);
      return;
    }
    aw.aaz();
    c.Rq().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    aw.aaz();
    Cursor localCursor = c.YA().d("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      ad localad = new ad();
      localad.convertFrom(localCursor);
      aw.aaz();
      c.YA().d(localad.field_username, localad);
      localCursor.moveToNext();
    }
    localCursor.close();
    ab.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    aw.aaz();
    c.Ru().set(86017, Integer.valueOf(3));
    ab.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(16433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.am.e
 * JD-Core Version:    0.7.0.1
 */