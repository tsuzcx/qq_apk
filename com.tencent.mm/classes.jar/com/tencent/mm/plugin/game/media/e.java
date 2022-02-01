package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends cn
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(40951);
    c.a locala = new c.a();
    locala.GvF = new Field[12];
    locala.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.GvH.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "taskId";
    locala.columns[1] = "createTime";
    locala.GvH.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "publishSource";
    locala.GvH.put("publishSource", "INTEGER");
    localStringBuilder.append(" publishSource INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mediaType";
    locala.GvH.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "localIdList";
    locala.GvH.put("localIdList", "TEXT");
    localStringBuilder.append(" localIdList TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mediaList";
    locala.GvH.put("mediaList", "TEXT");
    localStringBuilder.append(" mediaList TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "BusinessData";
    locala.GvH.put("BusinessData", "TEXT");
    localStringBuilder.append(" BusinessData TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "uploadState";
    locala.GvH.put("uploadState", "INTEGER default '0' ");
    localStringBuilder.append(" uploadState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "publishState";
    locala.GvH.put("publishState", "INTEGER default '0' ");
    localStringBuilder.append(" publishState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "compressImg";
    locala.GvH.put("compressImg", "INTEGER default 'true' ");
    localStringBuilder.append(" compressImg INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "mixState";
    locala.GvH.put("mixState", "INTEGER default '0' ");
    localStringBuilder.append(" mixState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "bgMixTaskId";
    locala.GvH.put("bgMixTaskId", "TEXT");
    localStringBuilder.append(" bgMixTaskId TEXT");
    locala.columns[12] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(40951);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e
 * JD-Core Version:    0.7.0.1
 */