package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;

public final class q
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  private h dXo;
  
  public q(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(p paramp)
  {
    if (pQ(paramp.getUsername()))
    {
      paramp.bcw = -1;
      ContentValues localContentValues = paramp.vf();
      if (this.dXo.update("invitefriendopen", localContentValues, "username=?", new String[] { paramp.getUsername() }) <= 0) {}
    }
    do
    {
      return true;
      return false;
      paramp.bcw = -1;
      paramp = paramp.vf();
    } while ((int)this.dXo.insert("invitefriendopen", "username", paramp) != -1);
    return false;
  }
  
  public final boolean pQ(String paramString)
  {
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bk.pl(paramString) + "\"";
    paramString = this.dXo.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.q
 * JD-Core Version:    0.7.0.1
 */