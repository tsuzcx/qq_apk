package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends aq
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(112781);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.IBN.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "card_id";
    locala.columns[1] = "lower_bound";
    locala.IBN.put("lower_bound", "INTEGER");
    localStringBuilder.append(" lower_bound INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "need_insert_show_timestamp";
    locala.IBN.put("need_insert_show_timestamp", "INTEGER default 'false' ");
    localStringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "show_timestamp_encrypt_key";
    locala.IBN.put("show_timestamp_encrypt_key", "TEXT");
    localStringBuilder.append(" show_timestamp_encrypt_key TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "expire_time_interval";
    locala.IBN.put("expire_time_interval", "INTEGER");
    localStringBuilder.append(" expire_time_interval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "show_expire_interval";
    locala.IBN.put("show_expire_interval", "INTEGER");
    localStringBuilder.append(" show_expire_interval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "fetch_time";
    locala.IBN.put("fetch_time", "LONG");
    localStringBuilder.append(" fetch_time LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112781);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.i
 * JD-Core Version:    0.7.0.1
 */