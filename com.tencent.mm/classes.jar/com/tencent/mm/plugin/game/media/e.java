package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends cl
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(40951);
    c.a locala = new c.a();
    locala.EYt = new Field[12];
    locala.columns = new String[13];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.EYv.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "taskId";
    locala.columns[1] = "createTime";
    locala.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "publishSource";
    locala.EYv.put("publishSource", "INTEGER");
    localStringBuilder.append(" publishSource INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mediaType";
    locala.EYv.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "localIdList";
    locala.EYv.put("localIdList", "TEXT");
    localStringBuilder.append(" localIdList TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mediaList";
    locala.EYv.put("mediaList", "TEXT");
    localStringBuilder.append(" mediaList TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "BusinessData";
    locala.EYv.put("BusinessData", "TEXT");
    localStringBuilder.append(" BusinessData TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "uploadState";
    locala.EYv.put("uploadState", "INTEGER default '0' ");
    localStringBuilder.append(" uploadState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "publishState";
    locala.EYv.put("publishState", "INTEGER default '0' ");
    localStringBuilder.append(" publishState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "compressImg";
    locala.EYv.put("compressImg", "INTEGER default 'true' ");
    localStringBuilder.append(" compressImg INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "mixState";
    locala.EYv.put("mixState", "INTEGER default '0' ");
    localStringBuilder.append(" mixState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "bgMixTaskId";
    locala.EYv.put("bgMixTaskId", "TEXT");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e
 * JD-Core Version:    0.7.0.1
 */