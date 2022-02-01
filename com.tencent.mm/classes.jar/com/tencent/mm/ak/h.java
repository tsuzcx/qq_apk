package com.tencent.mm.ak;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  com.tencent.mm.storagebase.h gPa;
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    this.gPa = paramh;
  }
  
  public final int a(String paramString, g paramg)
  {
    AppMethodBeat.i(150281);
    paramg = paramg.convertTo();
    int i = this.gPa.update("hdheadimginfo", paramg, "username=?", new String[] { paramString });
    AppMethodBeat.o(150281);
    return i;
  }
  
  public final g wc(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(150282);
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.gPa.a(paramString, null, 2);
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
      paramString.gTV = localCursor.getInt(1);
      paramString.gTW = localCursor.getInt(2);
      paramString.gTX = localCursor.getString(3);
      paramString.gTY = localCursor.getInt(4);
      paramString.cWU = localCursor.getInt(5);
      paramString.gTZ = localCursor.getInt(6);
      paramString.gUa = localCursor.getString(7);
      paramString.gUb = localCursor.getString(8);
      paramString.gUc = localCursor.getInt(9);
      paramString.gUd = localCursor.getInt(10);
    }
    localCursor.close();
    AppMethodBeat.o(150282);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.h
 * JD-Core Version:    0.7.0.1
 */