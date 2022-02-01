package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;

public final class i
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  com.tencent.mm.storagebase.h lvy;
  
  public i(com.tencent.mm.storagebase.h paramh)
  {
    this.lvy = paramh;
  }
  
  public final h TP(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(150282);
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.lvy.rawQuery(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(150282);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new h();
      paramString.username = localCursor.getString(0);
      paramString.lAT = localCursor.getInt(1);
      paramString.lAU = localCursor.getInt(2);
      paramString.lAV = localCursor.getString(3);
      paramString.lAW = localCursor.getInt(4);
      paramString.bPt = localCursor.getInt(5);
      paramString.lAX = localCursor.getInt(6);
      paramString.lAY = localCursor.getString(7);
      paramString.lAZ = localCursor.getString(8);
      paramString.lBa = localCursor.getInt(9);
      paramString.lBb = localCursor.getInt(10);
    }
    localCursor.close();
    AppMethodBeat.o(150282);
    return paramString;
  }
  
  public final int a(String paramString, h paramh)
  {
    AppMethodBeat.i(150281);
    paramh = paramh.convertTo();
    int i = this.lvy.update("hdheadimginfo", paramh, "username=?", new String[] { paramString });
    AppMethodBeat.o(150281);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.i
 * JD-Core Version:    0.7.0.1
 */