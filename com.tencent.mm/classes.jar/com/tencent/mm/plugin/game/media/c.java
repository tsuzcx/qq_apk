package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends cr
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(40945);
    c.a locala = new c.a();
    locala.IhA = new Field[16];
    locala.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IhC.put("localId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" localId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localId";
    locala.columns[1] = "mediaId";
    locala.IhC.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "mediaType";
    locala.IhC.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "filePath";
    locala.IhC.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "compressPath";
    locala.IhC.put("compressPath", "TEXT");
    localStringBuilder.append(" compressPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbPath";
    locala.IhC.put("thumbPath", "TEXT");
    localStringBuilder.append(" thumbPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "width";
    locala.IhC.put("width", "INTEGER");
    localStringBuilder.append(" width INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "height";
    locala.IhC.put("height", "INTEGER");
    localStringBuilder.append(" height INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "duration";
    locala.IhC.put("duration", "INTEGER");
    localStringBuilder.append(" duration INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "size";
    locala.IhC.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "isGif";
    locala.IhC.put("isGif", "INTEGER");
    localStringBuilder.append(" isGif INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "mediaUrl";
    locala.IhC.put("mediaUrl", "TEXT");
    localStringBuilder.append(" mediaUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "thumbPicUrl";
    locala.IhC.put("thumbPicUrl", "TEXT");
    localStringBuilder.append(" thumbPicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "uploadState";
    locala.IhC.put("uploadState", "INTEGER default 'false' ");
    localStringBuilder.append(" uploadState INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "hostTaskId";
    locala.IhC.put("hostTaskId", "TEXT");
    localStringBuilder.append(" hostTaskId TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "editFlag";
    locala.IhC.put("editFlag", "INTEGER default '0' ");
    localStringBuilder.append(" editFlag INTEGER default '0' ");
    locala.columns[16] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(40945);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.c
 * JD-Core Version:    0.7.0.1
 */