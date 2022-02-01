package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fv;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends fv
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(125520);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uid";
    localMAutoDBInfo.colsMap.put("uid", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "uid";
    localMAutoDBInfo.columns[1] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT default '' ");
    localStringBuilder.append(" name TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "devicetype";
    localMAutoDBInfo.colsMap.put("devicetype", "TEXT default '' ");
    localStringBuilder.append(" devicetype TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG default '0' ");
    localStringBuilder.append(" createtime LONG default '0' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(125520);
  }
  
  public d()
  {
    this.field_uid = "0";
    this.field_name = "";
    this.field_devicetype = "";
    this.field_createtime = 0L;
  }
  
  public d(ckf paramckf)
  {
    AppMethodBeat.i(125519);
    this.field_uid = paramckf.uuid;
    this.field_devicetype = paramckf.devicetype;
    this.field_name = paramckf.devicename;
    this.field_createtime = paramckf.MpC;
    AppMethodBeat.o(125519);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.d
 * JD-Core Version:    0.7.0.1
 */