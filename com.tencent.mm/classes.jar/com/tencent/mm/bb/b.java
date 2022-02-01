package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import junit.framework.Assert;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  public h hKK;
  
  public b(h paramh)
  {
    this.hKK = paramh;
  }
  
  public final a GD(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(150789);
    paramString = "select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bu.aSk(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.hKK.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(150789);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150789);
    return paramString;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150787);
    parama.dEu = -1;
    ContentValues localContentValues = parama.convertTo();
    if ((int)this.hKK.a("chattingbginfo", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(150787);
      return true;
    }
    AppMethodBeat.o(150787);
    return false;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(150788);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = parama.convertTo();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.hKK.update("chattingbginfo", localContentValues, "username= ?", new String[] { parama.getUsername() }) <= 0) {
        break;
      }
      doNotify(parama.getUsername());
      AppMethodBeat.o(150788);
      return true;
    }
    AppMethodBeat.o(150788);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.b
 * JD-Core Version:    0.7.0.1
 */