package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.h.c.dt;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends dt
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uid";
    locala.ujN.put("uid", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "uid";
    locala.columns[1] = "name";
    locala.ujN.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "devicetype";
    locala.ujN.put("devicetype", "TEXT default '' ");
    localStringBuilder.append(" devicetype TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createtime";
    locala.ujN.put("createtime", "LONG default '0' ");
    localStringBuilder.append(" createtime LONG default '0' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public d()
  {
    this.field_uid = "0";
    this.field_name = "";
    this.field_devicetype = "";
    this.field_createtime = 0L;
  }
  
  public d(auo paramauo)
  {
    this.field_uid = paramauo.dCX;
    this.field_devicetype = paramauo.devicetype;
    this.field_name = paramauo.devicename;
    this.field_createtime = paramauo.tqa;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.d
 * JD-Core Version:    0.7.0.1
 */