package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.mm.h.c.al;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends al
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "mediaId";
    locala.ujN.put("mediaId", "TEXT");
    localStringBuilder.append(" mediaId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "downloadUrlHashCode";
    locala.ujN.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "downloadUrlHashCode";
    locala.columns[2] = "downloadUrl";
    locala.ujN.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "httpsUrl";
    locala.ujN.put("httpsUrl", "TEXT");
    localStringBuilder.append(" httpsUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "filePath";
    locala.ujN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "verifyHeaders";
    locala.ujN.put("verifyHeaders", "TEXT");
    localStringBuilder.append(" verifyHeaders TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "game_package_download";
    locala.ujN.put("game_package_download", "INTEGER");
    localStringBuilder.append(" game_package_download INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "allowMobileNetDownload";
    locala.ujN.put("allowMobileNetDownload", "INTEGER");
    localStringBuilder.append(" allowMobileNetDownload INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "wifiAutoDownload";
    locala.ujN.put("wifiAutoDownload", "INTEGER");
    localStringBuilder.append(" wifiAutoDownload INTEGER");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.a
 * JD-Core Version:    0.7.0.1
 */