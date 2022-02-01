package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends cy
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(23779);
    c.a locala = new c.a();
    locala.GvF = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceID";
    locala.GvH.put("deviceID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "deviceID";
    locala.columns[1] = "brandName";
    locala.GvH.put("brandName", "TEXT");
    localStringBuilder.append(" brandName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mac";
    locala.GvH.put("mac", "LONG");
    localStringBuilder.append(" mac LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "deviceType";
    locala.GvH.put("deviceType", "TEXT");
    localStringBuilder.append(" deviceType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "connProto";
    locala.GvH.put("connProto", "TEXT");
    localStringBuilder.append(" connProto TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "connStrategy";
    locala.GvH.put("connStrategy", "INTEGER");
    localStringBuilder.append(" connStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "closeStrategy";
    locala.GvH.put("closeStrategy", "INTEGER");
    localStringBuilder.append(" closeStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "md5Str";
    locala.GvH.put("md5Str", "TEXT");
    localStringBuilder.append(" md5Str TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "authKey";
    locala.GvH.put("authKey", "TEXT");
    localStringBuilder.append(" authKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "url";
    locala.GvH.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "sessionKey";
    locala.GvH.put("sessionKey", "BLOB");
    localStringBuilder.append(" sessionKey BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "sessionBuf";
    locala.GvH.put("sessionBuf", "BLOB");
    localStringBuilder.append(" sessionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "authBuf";
    locala.GvH.put("authBuf", "BLOB");
    localStringBuilder.append(" authBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuffer";
    locala.GvH.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(23779);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.b
 * JD-Core Version:    0.7.0.1
 */