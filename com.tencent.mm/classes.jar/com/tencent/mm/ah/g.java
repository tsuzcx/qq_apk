package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  h fnw;
  
  public g(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final int a(String paramString, f paramf)
  {
    AppMethodBeat.i(77917);
    paramf = paramf.convertTo();
    int i = this.fnw.update("hdheadimginfo", paramf, "username=?", new String[] { paramString });
    AppMethodBeat.o(77917);
    return i;
  }
  
  public final f rh(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(77918);
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(77918);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new f();
      paramString.username = localCursor.getString(0);
      paramString.fsa = localCursor.getInt(1);
      paramString.fsb = localCursor.getInt(2);
      paramString.fsc = localCursor.getString(3);
      paramString.fsd = localCursor.getInt(4);
      paramString.chT = localCursor.getInt(5);
      paramString.fse = localCursor.getInt(6);
      paramString.fsf = localCursor.getString(7);
      paramString.fsg = localCursor.getString(8);
      paramString.fsh = localCursor.getInt(9);
      paramString.fsi = localCursor.getInt(10);
    }
    localCursor.close();
    AppMethodBeat.o(77918);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.g
 * JD-Core Version:    0.7.0.1
 */