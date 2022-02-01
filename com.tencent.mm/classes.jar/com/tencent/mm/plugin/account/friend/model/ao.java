package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public class ao
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )" };
  public final h omV;
  
  public ao(h paramh)
  {
    this.omV = paramh;
  }
  
  public final boolean a(an paraman)
  {
    AppMethodBeat.i(131158);
    if (paraman != null) {}
    ContentValues localContentValues;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localContentValues = paraman.bXp();
      if (localContentValues.size() > 0) {
        break;
      }
      Log.e("MicroMsg.QQGroupStorage", "update failed, no values set");
      AppMethodBeat.o(131158);
      return false;
    }
    if (this.omV.update("qqgroup", localContentValues, "grouopid= ?", new String[] { paraman.pTM }) <= 0)
    {
      AppMethodBeat.o(131158);
      return false;
    }
    doNotify();
    AppMethodBeat.o(131158);
    return true;
  }
  
  public final an ys(int paramInt)
  {
    an localan = null;
    AppMethodBeat.i(131157);
    Cursor localCursor = this.omV.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(paramInt)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(131157);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localan = new an();
      localan.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(131157);
    return localan;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ao
 * JD-Core Version:    0.7.0.1
 */