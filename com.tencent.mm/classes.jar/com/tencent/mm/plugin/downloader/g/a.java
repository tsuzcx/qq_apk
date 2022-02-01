package com.tencent.mm.plugin.downloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ca
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(89087);
    c.a locala = new c.a();
    locala.GvF = new Field[40];
    locala.columns = new String[41];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "downloadId";
    locala.GvH.put("downloadId", "LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(" downloadId LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "downloadId";
    locala.columns[1] = "downloadUrl";
    locala.GvH.put("downloadUrl", "TEXT default '' ");
    localStringBuilder.append(" downloadUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "secondaryUrl";
    locala.GvH.put("secondaryUrl", "TEXT default '' ");
    localStringBuilder.append(" secondaryUrl TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "fileSize";
    locala.GvH.put("fileSize", "LONG default '0' ");
    localStringBuilder.append(" fileSize LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileName";
    locala.GvH.put("fileName", "TEXT default '' ");
    localStringBuilder.append(" fileName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "filePath";
    locala.GvH.put("filePath", "TEXT default '' ");
    localStringBuilder.append(" filePath TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "fileType";
    locala.GvH.put("fileType", "INTEGER default '0' ");
    localStringBuilder.append(" fileType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "status";
    locala.GvH.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "md5";
    locala.GvH.put("md5", "TEXT default '' ");
    localStringBuilder.append(" md5 TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "autoInstall";
    locala.GvH.put("autoInstall", "INTEGER default 'false' ");
    localStringBuilder.append(" autoInstall INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "showNotification";
    locala.GvH.put("showNotification", "INTEGER default 'false' ");
    localStringBuilder.append(" showNotification INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "sysDownloadId";
    locala.GvH.put("sysDownloadId", "LONG default '-1' ");
    localStringBuilder.append(" sysDownloadId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "downloaderType";
    locala.GvH.put("downloaderType", "INTEGER default '0' ");
    localStringBuilder.append(" downloaderType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "appId";
    locala.GvH.put("appId", "TEXT default '' ");
    localStringBuilder.append(" appId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "downloadUrlHashCode";
    locala.GvH.put("downloadUrlHashCode", "INTEGER default '0' ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "packageName";
    locala.GvH.put("packageName", "TEXT default '' ");
    localStringBuilder.append(" packageName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "downloadedSize";
    locala.GvH.put("downloadedSize", "LONG default '0' ");
    localStringBuilder.append(" downloadedSize LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "totalSize";
    locala.GvH.put("totalSize", "LONG default '0' ");
    localStringBuilder.append(" totalSize LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "autoDownload";
    locala.GvH.put("autoDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" autoDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "channelId";
    locala.GvH.put("channelId", "TEXT default '' ");
    localStringBuilder.append(" channelId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "scene";
    locala.GvH.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "errCode";
    locala.GvH.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "startTime";
    locala.GvH.put("startTime", "LONG default '0' ");
    localStringBuilder.append(" startTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "startSize";
    locala.GvH.put("startSize", "LONG default '0' ");
    localStringBuilder.append(" startSize LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[24] = "startState";
    locala.GvH.put("startState", "INTEGER default '0' ");
    localStringBuilder.append(" startState INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "fromWeApp";
    locala.GvH.put("fromWeApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromWeApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "downloadInWifi";
    locala.GvH.put("downloadInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" downloadInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[27] = "extInfo";
    locala.GvH.put("extInfo", "TEXT default '' ");
    localStringBuilder.append(" extInfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "finishTime";
    locala.GvH.put("finishTime", "LONG default '0' ");
    localStringBuilder.append(" finishTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[29] = "isSecondDownload";
    locala.GvH.put("isSecondDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" isSecondDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[30] = "fromDownloadApp";
    locala.GvH.put("fromDownloadApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromDownloadApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[31] = "updateTime";
    locala.GvH.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[32] = "reserveInWifi";
    locala.GvH.put("reserveInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" reserveInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[33] = "ssid";
    locala.GvH.put("ssid", "INTEGER default '0' ");
    localStringBuilder.append(" ssid INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[34] = "uiarea";
    locala.GvH.put("uiarea", "INTEGER default '0' ");
    localStringBuilder.append(" uiarea INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[35] = "noticeId";
    locala.GvH.put("noticeId", "INTEGER default '0' ");
    localStringBuilder.append(" noticeId INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[36] = "downloadType";
    locala.GvH.put("downloadType", "INTEGER default '0' ");
    localStringBuilder.append(" downloadType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[37] = "startScene";
    locala.GvH.put("startScene", "INTEGER default '0' ");
    localStringBuilder.append(" startScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[38] = "sectionMd5Byte";
    locala.GvH.put("sectionMd5Byte", "BLOB");
    localStringBuilder.append(" sectionMd5Byte BLOB");
    localStringBuilder.append(", ");
    locala.columns[39] = "rawAppId";
    locala.GvH.put("rawAppId", "TEXT default '' ");
    localStringBuilder.append(" rawAppId TEXT default '' ");
    locala.columns[40] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(89087);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a
 * JD-Core Version:    0.7.0.1
 */