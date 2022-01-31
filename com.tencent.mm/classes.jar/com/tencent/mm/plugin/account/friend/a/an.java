package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class an
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )" };
  public final h fnw;
  
  public an(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean a(am paramam)
  {
    AppMethodBeat.i(108497);
    if (paramam != null) {}
    ContentValues localContentValues;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localContentValues = paramam.aqI();
      if (localContentValues.size() > 0) {
        break;
      }
      ab.e("MicroMsg.QQGroupStorage", "update failed, no values set");
      AppMethodBeat.o(108497);
      return false;
    }
    if (this.fnw.update("qqgroup", localContentValues, "grouopid= ?", new String[] { paramam.gyw }) <= 0)
    {
      AppMethodBeat.o(108497);
      return false;
    }
    doNotify();
    AppMethodBeat.o(108497);
    return true;
  }
  
  public final am mU(int paramInt)
  {
    am localam = null;
    AppMethodBeat.i(108496);
    Cursor localCursor = this.fnw.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(paramInt)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(108496);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localam = new am();
      localam.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(108496);
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.an
 * JD-Core Version:    0.7.0.1
 */