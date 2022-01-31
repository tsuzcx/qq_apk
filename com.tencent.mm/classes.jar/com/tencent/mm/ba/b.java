package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  public h fnw;
  
  public b(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(78433);
    parama.bsY = -1;
    ContentValues localContentValues = parama.convertTo();
    if ((int)this.fnw.a("chattingbginfo", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(78433);
      return true;
    }
    AppMethodBeat.o(78433);
    return false;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(78434);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = parama.convertTo();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.fnw.update("chattingbginfo", localContentValues, "username= ?", new String[] { parama.getUsername() }) <= 0) {
        break;
      }
      doNotify(parama.getUsername());
      AppMethodBeat.o(78434);
      return true;
    }
    AppMethodBeat.o(78434);
    return false;
  }
  
  public final a tS(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(78435);
    paramString = "select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(78435);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(78435);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */