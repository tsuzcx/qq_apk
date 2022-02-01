package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.co;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends co
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(41672);
    c.a locala = new c.a();
    locala.EYt = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.EYv.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "appId";
    locala.columns[1] = "downloadUrl";
    locala.EYv.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "size";
    locala.EYv.put("size", "LONG default '0' ");
    localStringBuilder.append(" size LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "md5";
    locala.EYv.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "packageName";
    locala.EYv.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.EYv.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "randomTime";
    locala.EYv.put("randomTime", "LONG default '0' ");
    localStringBuilder.append(" randomTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "isFirst";
    locala.EYv.put("isFirst", "INTEGER default 'true' ");
    localStringBuilder.append(" isFirst INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "nextCheckTime";
    locala.EYv.put("nextCheckTime", "LONG default '0' ");
    localStringBuilder.append(" nextCheckTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "isRunning";
    locala.EYv.put("isRunning", "INTEGER default 'false' ");
    localStringBuilder.append(" isRunning INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "noWifi";
    locala.EYv.put("noWifi", "INTEGER default 'true' ");
    localStringBuilder.append(" noWifi INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "noSdcard";
    locala.EYv.put("noSdcard", "INTEGER default 'true' ");
    localStringBuilder.append(" noSdcard INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "noEnoughSpace";
    locala.EYv.put("noEnoughSpace", "INTEGER default 'true' ");
    localStringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lowBattery";
    locala.EYv.put("lowBattery", "INTEGER default 'true' ");
    localStringBuilder.append(" lowBattery INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "continueDelay";
    locala.EYv.put("continueDelay", "INTEGER default 'true' ");
    localStringBuilder.append(" continueDelay INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "SecondaryUrl";
    locala.EYv.put("SecondaryUrl", "TEXT");
    localStringBuilder.append(" SecondaryUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "downloadInWidget";
    locala.EYv.put("downloadInWidget", "INTEGER");
    localStringBuilder.append(" downloadInWidget INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "sectionMd5Byte";
    locala.EYv.put("sectionMd5Byte", "BLOB");
    localStringBuilder.append(" sectionMd5Byte BLOB");
    localStringBuilder.append(", ");
    locala.columns[18] = "forceUpdateFlag";
    locala.EYv.put("forceUpdateFlag", "INTEGER default '0' ");
    localStringBuilder.append(" forceUpdateFlag INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(41672);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.d
 * JD-Core Version:    0.7.0.1
 */