package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fn
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(125520);
    c.a locala = new c.a();
    locala.IhA = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uid";
    locala.IhC.put("uid", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "uid";
    locala.columns[1] = "name";
    locala.IhC.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "devicetype";
    locala.IhC.put("devicetype", "TEXT default '' ");
    localStringBuilder.append(" devicetype TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createtime";
    locala.IhC.put("createtime", "LONG default '0' ");
    localStringBuilder.append(" createtime LONG default '0' ");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(125520);
  }
  
  public d()
  {
    this.field_uid = "0";
    this.field_name = "";
    this.field_devicetype = "";
    this.field_createtime = 0L;
  }
  
  public d(bvx parambvx)
  {
    AppMethodBeat.i(125519);
    this.field_uid = parambvx.uuid;
    this.field_devicetype = parambvx.devicetype;
    this.field_name = parambvx.devicename;
    this.field_createtime = parambvx.GPY;
    AppMethodBeat.o(125519);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.d
 * JD-Core Version:    0.7.0.1
 */