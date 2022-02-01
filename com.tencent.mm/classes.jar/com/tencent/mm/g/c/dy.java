package com.tencent.mm.g.c;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dy
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fNf = "logId".hashCode();
  private static final int fNg = "liftTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fNd = true;
  private boolean fNe = true;
  public long field_liftTime;
  public int field_logId;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dy
 * JD-Core Version:    0.7.0.1
 */