package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class an
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )" };
  public final h dXo;
  
  public an(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(am paramam)
  {
    boolean bool;
    ContentValues localContentValues;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localContentValues = paramam.Xe();
      if (localContentValues.size() > 0) {
        break label36;
      }
      y.e("MicroMsg.QQGroupStorage", "update failed, no values set");
    }
    label36:
    while (this.dXo.update("qqgroup", localContentValues, "grouopid= ?", new String[] { paramam.fgO }) <= 0)
    {
      return false;
      bool = false;
      break;
    }
    doNotify();
    return true;
  }
  
  public final am jZ(int paramInt)
  {
    am localam = null;
    Cursor localCursor = this.dXo.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + paramInt, null, 2);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localam = new am();
      localam.d(localCursor);
    }
    localCursor.close();
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.an
 * JD-Core Version:    0.7.0.1
 */