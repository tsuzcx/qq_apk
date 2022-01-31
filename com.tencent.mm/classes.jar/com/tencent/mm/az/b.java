package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import junit.framework.Assert;

public final class b
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  public h dXo;
  
  public b(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(a parama)
  {
    parama.bcw = -1;
    ContentValues localContentValues = parama.vf();
    if ((int)this.dXo.insert("chattingbginfo", "username", localContentValues) != -1)
    {
      aam(parama.getUsername());
      return true;
    }
    return false;
  }
  
  public final boolean b(a parama)
  {
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = parama.vf();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.dXo.update("chattingbginfo", localContentValues, "username= ?", new String[] { parama.getUsername() }) <= 0) {
        break;
      }
      aam(parama.getUsername());
      return true;
    }
    return false;
  }
  
  public final a mI(String paramString)
  {
    Object localObject = null;
    paramString = "select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */