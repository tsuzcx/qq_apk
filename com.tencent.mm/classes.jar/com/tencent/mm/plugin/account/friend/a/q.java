package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  private h fnw;
  
  public q(h paramh)
  {
    this.fnw = paramh;
  }
  
  private boolean a(p paramp)
  {
    AppMethodBeat.i(108402);
    if (paramp == null)
    {
      AppMethodBeat.o(108402);
      return false;
    }
    paramp.bsY = -1;
    paramp = paramp.convertTo();
    if ((int)this.fnw.a("invitefriendopen", "username", paramp) != -1)
    {
      AppMethodBeat.o(108402);
      return true;
    }
    AppMethodBeat.o(108402);
    return false;
  }
  
  private boolean c(p paramp)
  {
    AppMethodBeat.i(108404);
    paramp.bsY = -1;
    ContentValues localContentValues = paramp.convertTo();
    if (this.fnw.update("invitefriendopen", localContentValues, "username=?", new String[] { paramp.getUsername() }) > 0)
    {
      AppMethodBeat.o(108404);
      return true;
    }
    AppMethodBeat.o(108404);
    return false;
  }
  
  public final boolean b(p paramp)
  {
    AppMethodBeat.i(108403);
    if (xm(paramp.getUsername()))
    {
      bool = c(paramp);
      AppMethodBeat.o(108403);
      return bool;
    }
    boolean bool = a(paramp);
    AppMethodBeat.o(108403);
    return bool;
  }
  
  public final boolean xm(String paramString)
  {
    AppMethodBeat.i(108405);
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    paramString = this.fnw.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(108405);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.q
 * JD-Core Version:    0.7.0.1
 */