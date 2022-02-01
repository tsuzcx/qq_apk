package com.tencent.mm.plugin.downloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends cc
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(89087);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[41];
    localMAutoDBInfo.columns = new String[42];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "downloadId";
    localMAutoDBInfo.colsMap.put("downloadId", "LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(" downloadId LONG default '-1'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "downloadId";
    localMAutoDBInfo.columns[1] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT default '' ");
    localStringBuilder.append(" downloadUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "secondaryUrl";
    localMAutoDBInfo.colsMap.put("secondaryUrl", "TEXT default '' ");
    localStringBuilder.append(" secondaryUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "fileSize";
    localMAutoDBInfo.colsMap.put("fileSize", "LONG default '0' ");
    localStringBuilder.append(" fileSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT default '' ");
    localStringBuilder.append(" fileName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT default '' ");
    localStringBuilder.append(" filePath TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fileType";
    localMAutoDBInfo.colsMap.put("fileType", "INTEGER default '0' ");
    localStringBuilder.append(" fileType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT default '' ");
    localStringBuilder.append(" md5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "autoInstall";
    localMAutoDBInfo.colsMap.put("autoInstall", "INTEGER default 'false' ");
    localStringBuilder.append(" autoInstall INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "showNotification";
    localMAutoDBInfo.colsMap.put("showNotification", "INTEGER default 'false' ");
    localStringBuilder.append(" showNotification INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "sysDownloadId";
    localMAutoDBInfo.colsMap.put("sysDownloadId", "LONG default '-1' ");
    localStringBuilder.append(" sysDownloadId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "downloaderType";
    localMAutoDBInfo.colsMap.put("downloaderType", "INTEGER default '0' ");
    localStringBuilder.append(" downloaderType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT default '' ");
    localStringBuilder.append(" appId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "downloadUrlHashCode";
    localMAutoDBInfo.colsMap.put("downloadUrlHashCode", "INTEGER default '0' ");
    localStringBuilder.append(" downloadUrlHashCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT default '' ");
    localStringBuilder.append(" packageName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "downloadedSize";
    localMAutoDBInfo.colsMap.put("downloadedSize", "LONG default '0' ");
    localStringBuilder.append(" downloadedSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "totalSize";
    localMAutoDBInfo.colsMap.put("totalSize", "LONG default '0' ");
    localStringBuilder.append(" totalSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "autoDownload";
    localMAutoDBInfo.colsMap.put("autoDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" autoDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "channelId";
    localMAutoDBInfo.colsMap.put("channelId", "TEXT default '' ");
    localStringBuilder.append(" channelId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "errCode";
    localMAutoDBInfo.colsMap.put("errCode", "INTEGER default '0' ");
    localStringBuilder.append(" errCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG default '0' ");
    localStringBuilder.append(" startTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "startSize";
    localMAutoDBInfo.colsMap.put("startSize", "LONG default '0' ");
    localStringBuilder.append(" startSize LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "startState";
    localMAutoDBInfo.colsMap.put("startState", "INTEGER default '0' ");
    localStringBuilder.append(" startState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "fromWeApp";
    localMAutoDBInfo.colsMap.put("fromWeApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromWeApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "downloadInWifi";
    localMAutoDBInfo.colsMap.put("downloadInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" downloadInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT default '' ");
    localStringBuilder.append(" extInfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "finishTime";
    localMAutoDBInfo.colsMap.put("finishTime", "LONG default '0' ");
    localStringBuilder.append(" finishTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "isSecondDownload";
    localMAutoDBInfo.colsMap.put("isSecondDownload", "INTEGER default 'false' ");
    localStringBuilder.append(" isSecondDownload INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "fromDownloadApp";
    localMAutoDBInfo.colsMap.put("fromDownloadApp", "INTEGER default 'false' ");
    localStringBuilder.append(" fromDownloadApp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "reserveInWifi";
    localMAutoDBInfo.colsMap.put("reserveInWifi", "INTEGER default 'false' ");
    localStringBuilder.append(" reserveInWifi INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "ssid";
    localMAutoDBInfo.colsMap.put("ssid", "INTEGER default '0' ");
    localStringBuilder.append(" ssid INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "uiarea";
    localMAutoDBInfo.colsMap.put("uiarea", "INTEGER default '0' ");
    localStringBuilder.append(" uiarea INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "noticeId";
    localMAutoDBInfo.colsMap.put("noticeId", "INTEGER default '0' ");
    localStringBuilder.append(" noticeId INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "downloadType";
    localMAutoDBInfo.colsMap.put("downloadType", "INTEGER default '0' ");
    localStringBuilder.append(" downloadType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "startScene";
    localMAutoDBInfo.colsMap.put("startScene", "INTEGER default '0' ");
    localStringBuilder.append(" startScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "sectionMd5Byte";
    localMAutoDBInfo.colsMap.put("sectionMd5Byte", "BLOB");
    localStringBuilder.append(" sectionMd5Byte BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "rawAppId";
    localMAutoDBInfo.colsMap.put("rawAppId", "TEXT default '' ");
    localStringBuilder.append(" rawAppId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "notificationTitle";
    localMAutoDBInfo.colsMap.put("notificationTitle", "TEXT default '' ");
    localStringBuilder.append(" notificationTitle TEXT default '' ");
    localMAutoDBInfo.columns[41] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(89087);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a
 * JD-Core Version:    0.7.0.1
 */