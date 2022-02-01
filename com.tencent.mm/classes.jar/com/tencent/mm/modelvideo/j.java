package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends fv
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(126888);
    c.a locala = new c.a();
    locala.IBL = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localId";
    locala.columns[1] = "fileName";
    locala.IBN.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileNameHash";
    locala.IBN.put("fileNameHash", "INTEGER");
    localStringBuilder.append(" fileNameHash INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "fileMd5";
    locala.IBN.put("fileMd5", "TEXT default '' ");
    localStringBuilder.append(" fileMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileLength";
    locala.IBN.put("fileLength", "LONG default '0' ");
    localStringBuilder.append(" fileLength LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "fileStatus";
    locala.IBN.put("fileStatus", "INTEGER default '0' ");
    localStringBuilder.append(" fileStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "fileDuration";
    locala.IBN.put("fileDuration", "INTEGER default '0' ");
    localStringBuilder.append(" fileDuration INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "createTime";
    locala.IBN.put("createTime", "LONG default '0' ");
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