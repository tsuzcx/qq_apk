package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class e
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 604176383);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!hJ(paramInt))
    {
      y.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.h(336L, 10L, 1L);
    long l = System.currentTimeMillis();
    au.Hx();
    if (bk.g((Integer)c.Dz().get(86017, null)) == 3)
    {
      y.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      return;
    }
    au.Hx();
    c.Dv().gk("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    au.Hx();
    Cursor localCursor = c.Fw().c("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      ad localad = new ad();
      localad.d(localCursor);
      au.Hx();
      c.Fw().c(localad.field_username, localad);
      localCursor.moveToNext();
    }
    localCursor.close();
    y.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    au.Hx();
    c.Dz().o(86017, Integer.valueOf(3));
    y.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */