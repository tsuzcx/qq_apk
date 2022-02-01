package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public class n
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  private h omV;
  
  public n(h paramh)
  {
    this.omV = paramh;
  }
  
  private boolean a(m paramm)
  {
    AppMethodBeat.i(131063);
    if (paramm == null)
    {
      AppMethodBeat.o(131063);
      return false;
    }
    paramm.eQp = -1;
    paramm = paramm.convertTo();
    if ((int)this.omV.insert("invitefriendopen", "username", paramm) != -1)
    {
      AppMethodBeat.o(131063);
      return true;
    }
    AppMethodBeat.o(131063);
    return false;
  }
  
  private boolean c(m paramm)
  {
    AppMethodBeat.i(131065);
    paramm.eQp = -1;
    ContentValues localContentValues = paramm.convertTo();
    if (this.omV.update("invitefriendopen", localContentValues, "username=?", new String[] { paramm.getUsername() }) > 0)
    {
      AppMethodBeat.o(131065);
      return true;
    }
    AppMethodBeat.o(131065);
    return false;
  }
  
  public final boolean Te(String paramString)
  {
    AppMethodBeat.i(131066);
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    paramString = this.omV.rawQuery(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(131066);
    return bool;
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(131064);
    if (Te(paramm.getUsername()))
    {
      bool = c(paramm);
      AppMethodBeat.o(131064);
      return bool;
    }
    boolean bool = a(paramm);
    AppMethodBeat.o(131064);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.n
 * JD-Core Version:    0.7.0.1
 */