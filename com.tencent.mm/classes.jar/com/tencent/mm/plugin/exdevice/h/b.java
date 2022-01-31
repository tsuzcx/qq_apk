package com.tencent.mm.plugin.exdevice.h;

import com.tencent.mm.h.c.cc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends cc
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceID";
    locala.ujN.put("deviceID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" deviceID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "deviceID";
    locala.columns[1] = "brandName";
    locala.ujN.put("brandName", "TEXT");
    localStringBuilder.append(" brandName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mac";
    locala.ujN.put("mac", "LONG");
    localStringBuilder.append(" mac LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "deviceType";
    locala.ujN.put("deviceType", "TEXT");
    localStringBuilder.append(" deviceType TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "connProto";
    locala.ujN.put("connProto", "TEXT");
    localStringBuilder.append(" connProto TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "connStrategy";
    locala.ujN.put("connStrategy", "INTEGER");
    localStringBuilder.append(" connStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "closeStrategy";
    locala.ujN.put("closeStrategy", "INTEGER");
    localStringBuilder.append(" closeStrategy INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "md5Str";
    locala.ujN.put("md5Str", "TEXT");
    localStringBuilder.append(" md5Str TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "authKey";
    locala.ujN.put("authKey", "TEXT");
    localStringBuilder.append(" authKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "sessionKey";
    locala.ujN.put("sessionKey", "BLOB");
    localStringBuilder.append(" sessionKey BLOB");
    localStringBuilder.append(", ");
    locala.columns[11] = "sessionBuf";
    locala.ujN.put("sessionBuf", "BLOB");
    localStringBuilder.append(" sessionBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "authBuf";
    locala.ujN.put("authBuf", "BLOB");
    localStringBuilder.append(" authBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuffer";
    locala.ujN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.h.b
 * JD-Core Version:    0.7.0.1
 */