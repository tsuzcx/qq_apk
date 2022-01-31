package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.h.c.bx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends bx
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.ujN.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appId";
    locala.columns[1] = "downloadUrl";
    locala.ujN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "size";
    locala.ujN.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "packageName";
    locala.ujN.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.ujN.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "randomTime";
    locala.ujN.put("randomTime", "LONG default '0' ");
    localStringBuilder.append(" randomTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "isFirst";
    locala.ujN.put("isFirst", "INTEGER default 'true' ");
    localStringBuilder.append(" isFirst INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "nextCheckTime";
    locala.ujN.put("nextCheckTime", "LONG default '0' ");
    localStringBuilder.append(" nextCheckTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "isRunning";
    locala.ujN.put("isRunning", "INTEGER default 'false' ");
    localStringBuilder.append(" isRunning INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "noWifi";
    locala.ujN.put("noWifi", "INTEGER default 'true' ");
    localStringBuilder.append(" noWifi INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "noSdcard";
    locala.ujN.put("noSdcard", "INTEGER default 'true' ");
    localStringBuilder.append(" noSdcard INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "noEnoughSpace";
    locala.ujN.put("noEnoughSpace", "INTEGER default 'true' ");
    localStringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lowBattery";
    locala.ujN.put("lowBattery", "INTEGER default 'true' ");
    localStringBuilder.append(" lowBattery INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "continueDelay";
    locala.ujN.put("continueDelay", "INTEGER default 'true' ");
    localStringBuilder.append(" continueDelay INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "SecondaryUrl";
    locala.ujN.put("SecondaryUrl", "TEXT");
    localStringBuilder.append(" SecondaryUrl TEXT");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.c
 * JD-Core Version:    0.7.0.1
 */