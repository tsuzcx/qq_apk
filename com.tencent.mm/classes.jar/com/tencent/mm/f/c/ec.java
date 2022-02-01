package com.tencent.mm.f.c;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ec
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "JsLogBlockList", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("JsLogBlockList");
  public static final Column ifr = new Column("logid", "int", "JsLogBlockList", "");
  public static final Column ifs = new Column("lifttime", "long", "JsLogBlockList", "");
  private static final int ifv = "logId".hashCode();
  private static final int ifw = "liftTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_liftTime;
  public int field_logId;
  private boolean ift = true;
  private boolean ifu = true;
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "logId";
    localMAutoDBInfo.colsMap.put("logId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" logId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "logId";
    localMAutoDBInfo.columns[1] = "liftTime";
    localMAutoDBInfo.colsMap.put("liftTime", "LONG");
    localStringBuilder.append(" liftTime LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ec
 * JD-Core Version:    0.7.0.1
 */