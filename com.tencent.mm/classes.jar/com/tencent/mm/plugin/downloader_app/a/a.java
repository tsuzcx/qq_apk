package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String appId;
  public String appName;
  public int dCE;
  public int diX;
  public String downloadUrl;
  public String extInfo;
  public int fileType;
  public String lpa;
  public int oJO;
  public int oJP;
  public int oJQ;
  public boolean oJo;
  public String oKQ;
  public String oKR;
  public long oKS;
  public boolean oKT = true;
  public boolean oKU;
  public boolean oKV = true;
  public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> oKW;
  public String packageName;
  public int scene;
  
  public static a T(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(153084);
    a locala = new a();
    if (paramMap == null)
    {
      AppMethodBeat.o(153084);
      return locala;
    }
    locala.appName = ((String)paramMap.get("task_name"));
    locala.downloadUrl = ((String)paramMap.get("task_url"));
    locala.oKQ = ((String)paramMap.get("alternative_url"));
    locala.oKS = bs.getLong((String)paramMap.get("task_size"), 0L);
    locala.lpa = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = bs.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.oKR = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = bs.getInt((String)paramMap.get("scene"), 1000);
    locala.diX = bs.getInt((String)paramMap.get("downloader_type"), 1);
    locala.dCE = bs.getInt((String)paramMap.get("download_type"), 1);
    locala.oJO = bs.getInt((String)paramMap.get("uiarea"), 0);
    locala.oJP = bs.getInt((String)paramMap.get("notice_id"), 0);
    locala.oJQ = bs.getInt((String)paramMap.get("ssid"), 0);
    paramMap = (String)paramMap.get("fileSectionMd5");
    if (!bs.isNullOrNil(paramMap)) {
      try
      {
        paramMap = new JSONArray(paramMap);
        if (paramMap.length() > 0)
        {
          locala.oKW = new LinkedList();
          int i = 0;
          while (i < paramMap.length())
          {
            JSONObject localJSONObject = paramMap.optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
              locala1.oGv = localJSONObject.optLong("android_md5_section_begin");
              locala1.oGw = localJSONObject.optLong("android_md5_section_end");
              locala1.oGx = localJSONObject.optString("android_md5_section_md5");
              locala.oKW.add(locala1);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(153084);
      }
      catch (JSONException paramMap) {}
    }
    return locala;
  }
  
  public static a ao(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(153083);
    a locala = new a();
    locala.appName = paramJSONObject.optString("task_name");
    locala.downloadUrl = paramJSONObject.optString("task_url");
    locala.oKQ = paramJSONObject.optString("alternative_url");
    locala.oKS = paramJSONObject.optLong("task_size");
    locala.lpa = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = bs.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.oKR = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.diX = paramJSONObject.optInt("downloader_type", 1);
    locala.oJo = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.dCE = paramJSONObject.optInt("download_type", 1);
    locala.oJO = paramJSONObject.optInt("uiarea");
    locala.oJP = paramJSONObject.optInt("notice_id");
    locala.oJQ = paramJSONObject.optInt("ssid");
    paramJSONObject = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      locala.oKW = new LinkedList();
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
          locala1.oGv = localJSONObject.optLong("android_md5_section_begin");
          locala1.oGw = localJSONObject.optLong("android_md5_section_end");
          locala1.oGx = localJSONObject.optString("android_md5_section_md5");
          locala.oKW.add(locala1);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(153083);
    return locala;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153085);
    if (!bs.isNullOrNil(this.downloadUrl))
    {
      AppMethodBeat.o(153085);
      return true;
    }
    AppMethodBeat.o(153085);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.a
 * JD-Core Version:    0.7.0.1
 */