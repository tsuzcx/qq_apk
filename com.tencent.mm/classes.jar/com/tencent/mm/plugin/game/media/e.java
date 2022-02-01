package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.db;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends db
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(40951);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "taskId";
    localMAutoDBInfo.colsMap.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "taskId";
    localMAutoDBInfo.columns[1] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "publishSource";
    localMAutoDBInfo.colsMap.put("publishSource", "INTEGER");
    localStringBuilder.append(" publishSource INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mediaType";
    localMAutoDBInfo.colsMap.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "localIdList";
    localMAutoDBInfo.colsMap.put("localIdList", "TEXT");
    localStringBuilder.append(" localIdList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "mediaList";
    localMAutoDBInfo.colsMap.put("mediaList", "TEXT");
    localStringBuilder.append(" mediaList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "BusinessData";
    localMAutoDBInfo.colsMap.put("BusinessData", "TEXT");
    localStringBuilder.append(" BusinessData TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "uploadState";
    localMAutoDBInfo.colsMap.put("uploadState", "INTEGER default '0' ");
    localStringBuilder.append(" uploadState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "publishState";
    localMAutoDBInfo.colsMap.put("publishState", "INTEGER default '0' ");
    localStringBuilder.append(" publishState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "compressImg";
    localMAutoDBInfo.colsMap.put("compressImg", "INTEGER default 'true' ");
    localStringBuilder.append(" compressImg INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "mixState";
    localMAutoDBInfo.colsMap.put("mixState", "INTEGER default '0' ");
    localStringBuilder.append(" mixState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "bgMixTaskId";
    localMAutoDBInfo.colsMap.put("bgMixTaskId", "TEXT");
    localStringBuilder.append(" bgMixTaskId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "sourceSceneId";
    localMAutoDBInfo.colsMap.put("sourceSceneId", "INTEGER default '0' ");
    localStringBuilder.append(" sourceSceneId INTEGER default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(40951);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e
 * JD-Core Version:    0.7.0.1
 */