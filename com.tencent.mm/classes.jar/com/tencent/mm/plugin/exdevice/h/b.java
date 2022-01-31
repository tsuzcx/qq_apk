package com.tencent.mm.plugin.exdevice.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends ch
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(19711);
    c.a locala = new c.a();
    locala.yrK = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceID";
    locala.yrM.put("deviceID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "deviceID";
    locala.columns[1] = "brandName";
    locala.yrM.put("brandName", "TEXT");
    localStringBuilder.append(" brandName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mac";
    locala.yrM.put("mac", "LONG");
    localStringBuilder.append(" mac LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "deviceType";
    locala.yrM.put("deviceType", "TEXT");
    localStringBuilder.append(" deviceType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "connProto";
    locala.yrM.put("connProto", "TEXT");
    localStringBuilder.append(" connProto TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "connStrategy";
    locala.yrM.put("connStrategy", "INTEGER");
    localStringBuilder.append(" connStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "closeStrategy";
    locala.yrM.put("closeStrategy", "INTEGER");
    localStringBuilder.append(" closeStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "md5Str";
    locala.yrM.put("md5Str", "TEXT");
    localStringBuilder.append(" md5Str TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "authKey";
    locala.yrM.put("authKey", "TEXT");
    localStringBuilder.append(" authKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "sessionKey";
    locala.yrM.put("sessionKey", "BLOB");
    localStringBuilder.append(" sessionKey BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "sessionBuf";
    locala.yrM.put("sessionBuf", "BLOB");
    localStringBuilder.append(" sessionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "authBuf";
    locala.yrM.put("authBuf", "BLOB");
    localStringBuilder.append(" authBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuffer";
    locala.yrM.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(19711);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.b
 * JD-Core Version:    0.7.0.1
 */