package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.by;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends by
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(151801);
    c.a locala = new c.a();
    locala.yrK = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.yrM.put("localId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" localId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "localId";
    locala.columns[1] = "mediaId";
    locala.yrM.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mediaType";
    locala.yrM.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.yrM.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "compressPath";
    locala.yrM.put("compressPath", "TEXT");
    localStringBuilder.append(" compressPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbPath";
    locala.yrM.put("thumbPath", "TEXT");
    localStringBuilder.append(" thumbPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "width";
    locala.yrM.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "height";
    locala.yrM.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "duration";
    locala.yrM.put("duration", "INTEGER");
    localStringBuilder.append(" duration INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "size";
    locala.yrM.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "isGif";
    locala.yrM.put("isGif", "INTEGER");
    localStringBuilder.append(" isGif INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "mediaUrl";
    locala.yrM.put("mediaUrl", "TEXT");
    localStringBuilder.append(" mediaUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "thumbPicUrl";
    locala.yrM.put("thumbPicUrl", "TEXT");
    localStringBuilder.append(" thumbPicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "uploadState";
    locala.yrM.put("uploadState", "INTEGER default 'false' ");
    localStringBuilder.append(" uploadState INTEGER default 'false' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(151801);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.b
 * JD-Core Version:    0.7.0.1
 */