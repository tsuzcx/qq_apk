package com.tencent.mm.aj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  com.tencent.mm.storagebase.h hKK;
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    this.hKK = paramh;
  }
  
  public final g DJ(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(150282);
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bu.aSk(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.hKK.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(150282);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.username = localCursor.getString(0);
      paramString.hPF = localCursor.getInt(1);
      paramString.hPG = localCursor.getInt(2);
      paramString.hPH = localCursor.getString(3);
      paramString.hPI = localCursor.getInt(4);
      paramString.dgI = localCursor.getInt(5);
      paramString.hPJ = localCursor.getInt(6);
      paramString.hPK = localCursor.getString(7);
      paramString.hPL = localCursor.getString(8);
      paramString.hPM = localCursor.getInt(9);
      paramString.hPN = localCursor.getInt(10);
    }
    localCursor.close();
    AppMethodBeat.o(150282);
    return paramString;
  }
  
  public final int a(String paramString, g paramg)
  {
    AppMethodBeat.i(150281);
    paramg = paramg.convertTo();
    int i = this.hKK.update("hdheadimginfo", paramg, "username=?", new String[] { paramString });
    AppMethodBeat.o(150281);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.h
 * JD-Core Version:    0.7.0.1
 */