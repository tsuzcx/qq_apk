package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String appId;
  public String appName;
  public String downloadUrl;
  public String extInfo;
  public int fileType;
  public int hMd;
  public int iiN;
  public String packageName;
  public int scene;
  public String tdo;
  public int xoP;
  public int xoQ;
  public int xoR;
  public boolean xoo;
  public String xrR;
  public String xrS;
  public long xrT;
  public boolean xrU = true;
  public boolean xrV;
  public boolean xrW = true;
  public LinkedList<com.tencent.mm.plugin.downloader.b.b.a> xrX;
  public boolean xrY = false;
  
  public static a aZ(JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(153083);
    a locala = new a();
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(153083);
      return locala;
    }
    locala.appName = paramJSONObject.optString("task_name");
    locala.downloadUrl = paramJSONObject.optString("task_url");
    locala.xrR = paramJSONObject.optString("alternative_url");
    locala.xrT = paramJSONObject.optLong("task_size");
    locala.tdo = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = Util.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.xrS = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.hMd = paramJSONObject.optInt("downloader_type", 1);
    locala.xoo = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.iiN = paramJSONObject.optInt("download_type", 1);
    locala.xoP = paramJSONObject.optInt("uiarea");
    locala.xoQ = paramJSONObject.optInt("notice_id");
    locala.xoR = paramJSONObject.optInt("ssid");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      locala.xrX = new LinkedList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.b.b.a locala1 = new com.tencent.mm.plugin.downloader.b.b.a();
          locala1.xll = localJSONObject.optLong("android_md5_section_begin");
          locala1.xlm = localJSONObject.optLong("android_md5_section_end");
          locala1.xln = localJSONObject.optString("android_md5_section_md5");
          locala.xrX.add(locala1);
        }
        i += 1;
      }
    }
    if (paramJSONObject.optInt("ignoreNetwork", 0) == 1) {
      bool = true;
    }
    locala.xrY = bool;
    AppMethodBeat.o(153083);
    return locala;
  }
  
  public static a af(Map<String, Object> paramMap)
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
    locala.xrR = ((String)paramMap.get("alternative_url"));
    locala.xrT = Util.getLong((String)paramMap.get("task_size"), 0L);
    locala.tdo = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = Util.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.xrS = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = Util.getInt((String)paramMap.get("scene"), 1000);
    locala.hMd = Util.getInt((String)paramMap.get("downloader_type"), 1);
    locala.iiN = Util.getInt((String)paramMap.get("download_type"), 1);
    locala.xoP = Util.getInt((String)paramMap.get("uiarea"), 0);
    locala.xoQ = Util.getInt((String)paramMap.get("notice_id"), 0);
    locala.xoR = Util.getInt((String)paramMap.get("ssid"), 0);
    Object localObject = (String)paramMap.get("fileSectionMd5");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        if (((JSONArray)localObject).length() > 0)
        {
          locala.xrX = new LinkedList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.b.b.a locala1 = new com.tencent.mm.plugin.downloader.b.b.a();
              locala1.xll = localJSONObject.optLong("android_md5_section_begin");
              locala1.xlm = localJSONObject.optLong("android_md5_section_end");
              locala1.xln = localJSONObject.optString("android_md5_section_md5");
              locala.xrX.add(locala1);
            }
            i += 1;
          }
        }
        if (Util.getInt((String)paramMap.get("ignoreNetwork"), 0) != 1) {}
      }
      catch (JSONException localJSONException) {}
    }
    for (boolean bool = true;; bool = false)
    {
      locala.xrY = bool;
      AppMethodBeat.o(153084);
      return locala;
    }
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153085);
    if (!Util.isNullOrNil(this.downloadUrl))
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