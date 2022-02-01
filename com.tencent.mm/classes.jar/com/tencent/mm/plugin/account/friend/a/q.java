package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;

public final class q
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  private h hHS;
  
  public q(h paramh)
  {
    this.hHS = paramh;
  }
  
  private boolean a(p paramp)
  {
    AppMethodBeat.i(131063);
    if (paramp == null)
    {
      AppMethodBeat.o(131063);
      return false;
    }
    paramp.dDp = -1;
    paramp = paramp.convertTo();
    if ((int)this.hHS.a("invitefriendopen", "username", paramp) != -1)
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
    paramp.dDp = -1;
    ContentValues localContentValues = paramp.convertTo();
    if (this.hHS.update("invitefriendopen", localContentValues, "username=?", new String[] { paramp.getUsername() }) > 0)
    {
      AppMethodBeat.o(131065);
      return true;
    }
    AppMethodBeat.o(131065);
    return false;
  }
  
  public final boolean JI(String paramString)
  {
    AppMethodBeat.i(131066);
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bt.aQN(String.valueOf(paramString)) + "\"";
    paramString = this.hHS.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(131066);
    return bool;
  }
  
  public final boolean b(p paramp)
  {
    AppMethodBeat.i(131064);
    if (JI(paramp.getUsername()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.q
 * JD-Core Version:    0.7.0.1
 */