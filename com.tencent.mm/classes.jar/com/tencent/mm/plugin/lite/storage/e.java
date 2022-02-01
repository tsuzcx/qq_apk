package com.tencent.mm.plugin.lite.storage;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends b
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(198898);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT");
    localStringBuilder.append(" groupId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "signatureKey";
    localMAutoDBInfo.colsMap.put("signatureKey", "TEXT");
    localStringBuilder.append(" signatureKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pkgPath";
    localMAutoDBInfo.colsMap.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pkgType";
    localMAutoDBInfo.colsMap.put("pkgType", "TEXT");
    localStringBuilder.append(" pkgType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "patchId";
    localMAutoDBInfo.colsMap.put("patchId", "TEXT");
    localStringBuilder.append(" patchId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "version";
    localMAutoDBInfo.colsMap.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(198898);
  }
  
  public final WxaLiteAppInfo ecG()
  {
    AppMethodBeat.i(198897);
    WxaLiteAppInfo localWxaLiteAppInfo = new WxaLiteAppInfo();
    localWxaLiteAppInfo.appId = this.field_appId;
    localWxaLiteAppInfo.path = this.field_pkgPath;
    localWxaLiteAppInfo.crh = this.field_signatureKey;
    localWxaLiteAppInfo.crj = this.field_updateTime;
    localWxaLiteAppInfo.cri = this.field_patchId;
    localWxaLiteAppInfo.url = this.field_url;
    localWxaLiteAppInfo.md5 = this.field_md5;
    localWxaLiteAppInfo.crk = this.field_lastUseTime;
    localWxaLiteAppInfo.groupId = this.field_groupId;
    localWxaLiteAppInfo.type = this.field_pkgType;
    AppMethodBeat.o(198897);
    return localWxaLiteAppInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.e
 * JD-Core Version:    0.7.0.1
 */