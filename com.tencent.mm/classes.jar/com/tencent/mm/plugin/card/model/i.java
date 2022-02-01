package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ar;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends ar
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(112781);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "lower_bound";
    localMAutoDBInfo.colsMap.put("lower_bound", "INTEGER");
    localStringBuilder.append(" lower_bound INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "need_insert_show_timestamp";
    localMAutoDBInfo.colsMap.put("need_insert_show_timestamp", "INTEGER default 'false' ");
    localStringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "show_timestamp_encrypt_key";
    localMAutoDBInfo.colsMap.put("show_timestamp_encrypt_key", "TEXT");
    localStringBuilder.append(" show_timestamp_encrypt_key TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expire_time_interval";
    localMAutoDBInfo.colsMap.put("expire_time_interval", "INTEGER");
    localStringBuilder.append(" expire_time_interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "show_expire_interval";
    localMAutoDBInfo.colsMap.put("show_expire_interval", "INTEGER");
    localStringBuilder.append(" show_expire_interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fetch_time";
    localMAutoDBInfo.colsMap.put("fetch_time", "LONG");
    localStringBuilder.append(" fetch_time LONG");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(112781);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.i
 * JD-Core Version:    0.7.0.1
 */