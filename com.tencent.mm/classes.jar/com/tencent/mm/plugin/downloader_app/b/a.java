package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  public String appId;
  public String appName;
  public int cvQ;
  public String downloadUrl;
  public String extInfo;
  public int fileType;
  public boolean kYZ;
  public int kZA;
  public int kZB;
  public int kZy;
  public int kZz;
  public String laB;
  public long laC;
  public String laD;
  public String packageName;
  public int scene;
  
  public static a I(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(35547);
    a locala = new a();
    if (paramMap == null)
    {
      AppMethodBeat.o(35547);
      return locala;
    }
    locala.appName = ((String)paramMap.get("task_name"));
    locala.downloadUrl = ((String)paramMap.get("task_url"));
    locala.laB = ((String)paramMap.get("alternative_url"));
    locala.laC = bo.getLong((String)paramMap.get("task_size"), 0L);
    locala.laD = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = bo.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = bo.getInt((String)paramMap.get("scene"), 1000);
    locala.cvQ = bo.getInt((String)paramMap.get("downloader_type"), 1);
    locala.kZB = bo.getInt((String)paramMap.get("download_type"), 1);
    locala.kZy = bo.getInt((String)paramMap.get("uiarea"), 0);
    locala.kZz = bo.getInt((String)paramMap.get("notice_id"), 0);
    locala.kZA = bo.getInt((String)paramMap.get("ssid"), 0);
    AppMethodBeat.o(35547);
    return locala;
  }
  
  public static a Y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(35546);
    a locala = new a();
    locala.appName = paramJSONObject.optString("task_name");
    locala.downloadUrl = paramJSONObject.optString("task_url");
    locala.laB = paramJSONObject.optString("alternative_url");
    locala.laC = paramJSONObject.optLong("task_size");
    locala.laD = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = bo.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.cvQ = paramJSONObject.optInt("downloader_type", 1);
    locala.kYZ = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.kZB = paramJSONObject.optInt("download_type", 1);
    locala.kZy = paramJSONObject.optInt("uiarea");
    locala.kZz = paramJSONObject.optInt("notice_id");
    locala.kZA = paramJSONObject.optInt("ssid");
    AppMethodBeat.o(35546);
    return locala;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(35548);
    if (!bo.isNullOrNil(this.downloadUrl))
    {
      AppMethodBeat.o(35548);
      return true;
    }
    AppMethodBeat.o(35548);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.a
 * JD-Core Version:    0.7.0.1
 */