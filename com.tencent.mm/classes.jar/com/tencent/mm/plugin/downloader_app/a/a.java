package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String appId;
  public String appName;
  public int dOR;
  public String downloadUrl;
  public int duJ;
  public String extInfo;
  public int fileType;
  public String lMs;
  public String packageName;
  public boolean pmV;
  public int pnv;
  public int pnw;
  public int pnx;
  public long poA;
  public boolean poB = true;
  public boolean poC;
  public boolean poD = true;
  public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> poE;
  public String poy;
  public String poz;
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
    locala.poy = ((String)paramMap.get("alternative_url"));
    locala.poA = bt.getLong((String)paramMap.get("task_size"), 0L);
    locala.lMs = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = bt.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.poz = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = bt.getInt((String)paramMap.get("scene"), 1000);
    locala.duJ = bt.getInt((String)paramMap.get("downloader_type"), 1);
    locala.dOR = bt.getInt((String)paramMap.get("download_type"), 1);
    locala.pnv = bt.getInt((String)paramMap.get("uiarea"), 0);
    locala.pnw = bt.getInt((String)paramMap.get("notice_id"), 0);
    locala.pnx = bt.getInt((String)paramMap.get("ssid"), 0);
    paramMap = (String)paramMap.get("fileSectionMd5");
    if (!bt.isNullOrNil(paramMap)) {
      try
      {
        paramMap = new JSONArray(paramMap);
        if (paramMap.length() > 0)
        {
          locala.poE = new LinkedList();
          int i = 0;
          while (i < paramMap.length())
          {
            JSONObject localJSONObject = paramMap.optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
              locala1.pjZ = localJSONObject.optLong("android_md5_section_begin");
              locala1.pka = localJSONObject.optLong("android_md5_section_end");
              locala1.pkb = localJSONObject.optString("android_md5_section_md5");
              locala.poE.add(locala1);
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
    locala.poy = paramJSONObject.optString("alternative_url");
    locala.poA = paramJSONObject.optLong("task_size");
    locala.lMs = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = bt.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.poz = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.duJ = paramJSONObject.optInt("downloader_type", 1);
    locala.pmV = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.dOR = paramJSONObject.optInt("download_type", 1);
    locala.pnv = paramJSONObject.optInt("uiarea");
    locala.pnw = paramJSONObject.optInt("notice_id");
    locala.pnx = paramJSONObject.optInt("ssid");
    paramJSONObject = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      locala.poE = new LinkedList();
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
          locala1.pjZ = localJSONObject.optLong("android_md5_section_begin");
          locala1.pka = localJSONObject.optLong("android_md5_section_end");
          locala1.pkb = localJSONObject.optString("android_md5_section_md5");
          locala.poE.add(locala1);
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
    if (!bt.isNullOrNil(this.downloadUrl))
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