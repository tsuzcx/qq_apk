package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class q
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  private h iFy;
  
  public q(h paramh)
  {
    this.iFy = paramh;
  }
  
  private boolean a(p paramp)
  {
    AppMethodBeat.i(131063);
    if (paramp == null)
    {
      AppMethodBeat.o(131063);
      return false;
    }
    paramp.cSx = -1;
    paramp = paramp.convertTo();
    if ((int)this.iFy.insert("invitefriendopen", "username", paramp) != -1)
    {
      AppMethodBeat.o(131063);
      return true;
    }
    AppMethodBeat.o(131063);
    return false;
  }
  
  private boolean c(p paramp)
  {
    AppMethodBeat.i(131065);
    paramp.cSx = -1;
    ContentValues localContentValues = paramp.convertTo();
    if (this.iFy.update("invitefriendopen", localContentValues, "username=?", new String[] { paramp.getUsername() }) > 0)
    {
      AppMethodBeat.o(131065);
      return true;
    }
    AppMethodBeat.o(131065);
    return false;
  }
  
  public final boolean Tf(String paramString)
  {
    AppMethodBeat.i(131066);
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    paramString = this.iFy.rawQuery(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(131066);
    return bool;
  }
  
  public final boolean b(p paramp)
  {
    AppMethodBeat.i(131064);
    if (Tf(paramp.getUsername()))
    {
      bool = c(paramp);
      AppMethodBeat.o(131064);
      return bool;
    }
    boolean bool = a(paramp);
    AppMethodBeat.o(131064);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.q
 * JD-Core Version:    0.7.0.1
 */