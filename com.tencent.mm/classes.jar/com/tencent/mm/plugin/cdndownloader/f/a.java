package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.as;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends as
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(120810);
    c.a locala = new c.a();
    locala.IhA = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.IhC.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "downloadUrlHashCode";
    locala.IhC.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "downloadUrlHashCode";
    locala.columns[2] = "downloadUrl";
    locala.IhC.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "httpsUrl";
    locala.IhC.put("httpsUrl", "TEXT");
    localStringBuilder.append(" httpsUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "filePath";
    locala.IhC.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "verifyHeaders";
    locala.IhC.put("verifyHeaders", "TEXT");
    localStringBuilder.append(" verifyHeaders TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "game_package_download";
    locala.IhC.put("game_package_download", "INTEGER");
    localStringBuilder.append(" game_package_download INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "allowMobileNetDownload";
    locala.IhC.put("allowMobileNetDownload", "INTEGER");
    localStringBuilder.append(" allowMobileNetDownload INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "wifiAutoDownload";
    locala.IhC.put("wifiAutoDownload", "INTEGER");
    localStringBuilder.append(" wifiAutoDownload INTEGER");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(120810);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.a
 * JD-Core Version:    0.7.0.1
 */