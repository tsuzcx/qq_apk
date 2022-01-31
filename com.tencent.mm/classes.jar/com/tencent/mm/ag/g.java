package com.tencent.mm.ag;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  h dXo;
  
  public g(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final int a(String paramString, f paramf)
  {
    paramf = paramf.vf();
    return this.dXo.update("hdheadimginfo", paramf, "username=?", new String[] { paramString });
  }
  
  public final f kn(String paramString)
  {
    Object localObject = null;
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new f();
      paramString.username = localCursor.getString(0);
      paramString.ebH = localCursor.getInt(1);
      paramString.ebI = localCursor.getInt(2);
      paramString.ebJ = localCursor.getString(3);
      paramString.ebK = localCursor.getInt(4);
      paramString.ebL = localCursor.getInt(5);
      paramString.ebM = localCursor.getInt(6);
      paramString.ebN = localCursor.getString(7);
      paramString.ebO = localCursor.getString(8);
      paramString.ebP = localCursor.getInt(9);
      paramString.ebQ = localCursor.getInt(10);
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.g
 * JD-Core Version:    0.7.0.1
 */