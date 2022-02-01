package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fk
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(126888);
    c.a locala = new c.a();
    locala.GvF = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.GvH.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "localId";
    locala.columns[1] = "fileName";
    locala.GvH.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileNameHash";
    locala.GvH.put("fileNameHash", "INTEGER");
    localStringBuilder.append(" fileNameHash INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "fileMd5";
    locala.GvH.put("fileMd5", "TEXT default '' ");
    localStringBuilder.append(" fileMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileLength";
    locala.GvH.put("fileLength", "LONG default '0' ");
    localStringBuilder.append(" fileLength LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "fileStatus";
    locala.GvH.put("fileStatus", "INTEGER default '0' ");
    localStringBuilder.append(" fileStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "fileDuration";
    locala.GvH.put("fileDuration", "INTEGER default '0' ");
    localStringBuilder.append(" fileDuration INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "createTime";
    locala.GvH.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(126888);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.j
 * JD-Core Version:    0.7.0.1
 */