package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public class ar
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )" };
  public final h lvy;
  
  public ar(h paramh)
  {
    this.lvy = paramh;
  }
  
  public final boolean a(aq paramaq)
  {
    AppMethodBeat.i(131158);
    if (paramaq != null) {}
    ContentValues localContentValues;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localContentValues = paramaq.byB();
      if (localContentValues.size() > 0) {
        break;
      }
      Log.e("MicroMsg.QQGroupStorage", "update failed, no values set");
      AppMethodBeat.o(131158);
      return false;
    }
    if (this.lvy.update("qqgroup", localContentValues, "grouopid= ?", new String[] { paramaq.mXe }) <= 0)
    {
      AppMethodBeat.o(131158);
      return false;
    }
    doNotify();
    AppMethodBeat.o(131158);
    return true;
  }
  
  public final aq ym(int paramInt)
  {
    aq localaq = null;
    AppMethodBeat.i(131157);
    Cursor localCursor = this.lvy.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(paramInt)), null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(131157);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localaq = new aq();
      localaq.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(131157);
    return localaq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ar
 * JD-Core Version:    0.7.0.1
 */