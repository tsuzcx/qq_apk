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
    locala.IBL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.IBN.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "downloadUrlHashCode";
    locala.IBN.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "downloadUrlHashCode";
    locala.columns[2] = "downloadUrl";
    locala.IBN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "httpsUrl";
    locala.IBN.put("httpsUrl", "TEXT");
    localStringBuilder.append(" httpsUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "filePath";
    locala.IBN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "verifyHeaders";
    locala.IBN.put("verifyHeaders", "TEXT");
    localStringBuilder.append(" verifyHeaders TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "game_package_download";
    locala.IBN.put("game_package_download", "INTEGER");
    localStringBuilder.append(" game_package_download INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "allowMobileNetDownload";
    locala.IBN.put("allowMobileNetDownload", "INTEGER");
    localStringBuilder.append(" allowMobileNetDownload INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "wifiAutoDownload";
    locala.IBN.put("wifiAutoDownload", "INTEGER");
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