package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fd;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fd
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(125520);
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "uid";
    locala.GvH.put("uid", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "uid";
    locala.columns[1] = "name";
    locala.GvH.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "devicetype";
    locala.GvH.put("devicetype", "TEXT default '' ");
    localStringBuilder.append(" devicetype TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "createtime";
    locala.GvH.put("createtime", "LONG default '0' ");
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
  
  public d(brk parambrk)
  {
    AppMethodBeat.i(125519);
    this.field_uid = parambrk.uuid;
    this.field_devicetype = parambrk.devicetype;
    this.field_name = parambrk.devicename;
    this.field_createtime = parambrk.Fgw;
    AppMethodBeat.o(125519);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.d
 * JD-Core Version:    0.7.0.1
 */