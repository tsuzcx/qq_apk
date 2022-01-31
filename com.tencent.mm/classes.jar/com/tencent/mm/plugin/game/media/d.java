package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bz
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151806);
    c.a locala = new c.a();
    locala.yrK = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "taskId";
    locala.yrM.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "taskId";
    locala.columns[1] = "createTime";
    locala.yrM.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "publishSource";
    locala.yrM.put("publishSource", "INTEGER");
    localStringBuilder.append(" publishSource INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mediaType";
    locala.yrM.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "localIdList";
    locala.yrM.put("localIdList", "TEXT");
    localStringBuilder.append(" localIdList TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "mediaList";
    locala.yrM.put("mediaList", "TEXT");
    localStringBuilder.append(" mediaList TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "BusinessData";
    locala.yrM.put("BusinessData", "TEXT");
    localStringBuilder.append(" BusinessData TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "uploadState";
    locala.yrM.put("uploadState", "INTEGER default '0' ");
    localStringBuilder.append(" uploadState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "publishState";
    locala.yrM.put("publishState", "INTEGER default '0' ");
    localStringBuilder.append(" publishState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "compressImg";
    locala.yrM.put("compressImg", "INTEGER default 'true' ");
    localStringBuilder.append(" compressImg INTEGER default 'true' ");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151806);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.d
 * JD-Core Version:    0.7.0.1
 */