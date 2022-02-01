package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String appId;
  public String appName;
  public int dQh;
  public String downloadUrl;
  public int dvO;
  public String extInfo;
  public int fileType;
  public String lQS;
  public String packageName;
  public boolean ptC;
  public int puc;
  public int pud;
  public int pue;
  public String pve;
  public String pvf;
  public long pvg;
  public boolean pvh = true;
  public boolean pvi;
  public boolean pvj = true;
  public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> pvk;
  public int scene;
  
  public static a aa(Map<String, Object> paramMap)
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
    locala.pve = ((String)paramMap.get("alternative_url"));
    locala.pvg = bu.getLong((String)paramMap.get("task_size"), 0L);
    locala.lQS = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = bu.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.pvf = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = bu.getInt((String)paramMap.get("scene"), 1000);
    locala.dvO = bu.getInt((String)paramMap.get("downloader_type"), 1);
    locala.dQh = bu.getInt((String)paramMap.get("download_type"), 1);
    locala.puc = bu.getInt((String)paramMap.get("uiarea"), 0);
    locala.pud = bu.getInt((String)paramMap.get("notice_id"), 0);
    locala.pue = bu.getInt((String)paramMap.get("ssid"), 0);
    paramMap = (String)paramMap.get("fileSectionMd5");
    if (!bu.isNullOrNil(paramMap)) {
      try
      {
        paramMap = new JSONArray(paramMap);
        if (paramMap.length() > 0)
        {
          locala.pvk = new LinkedList();
          int i = 0;
          while (i < paramMap.length())
          {
            JSONObject localJSONObject = paramMap.optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
              locala1.pqE = localJSONObject.optLong("android_md5_section_begin");
              locala1.pqF = localJSONObject.optLong("android_md5_section_end");
              locala1.pqG = localJSONObject.optString("android_md5_section_md5");
              locala.pvk.add(locala1);
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
  
  public static a ar(JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(153083);
    a locala = new a();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(153083);
      return locala;
    }
    locala.appName = paramJSONObject.optString("task_name");
    locala.downloadUrl = paramJSONObject.optString("task_url");
    locala.pve = paramJSONObject.optString("alternative_url");
    locala.pvg = paramJSONObject.optLong("task_size");
    locala.lQS = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = bu.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.pvf = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.dvO = paramJSONObject.optInt("downloader_type", 1);
    locala.ptC = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.dQh = paramJSONObject.optInt("download_type", 1);
    locala.puc = paramJSONObject.optInt("uiarea");
    locala.pud = paramJSONObject.optInt("notice_id");
    locala.pue = paramJSONObject.optInt("ssid");
    paramJSONObject = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      locala.pvk = new LinkedList();
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
          locala1.pqE = localJSONObject.optLong("android_md5_section_begin");
          locala1.pqF = localJSONObject.optLong("android_md5_section_end");
          locala1.pqG = localJSONObject.optString("android_md5_section_md5");
          locala.pvk.add(locala1);
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
    if (!bu.isNullOrNil(this.downloadUrl))
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