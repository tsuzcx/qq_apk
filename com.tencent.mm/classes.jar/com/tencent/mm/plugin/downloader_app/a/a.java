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
  public int dNv;
  public String downloadUrl;
  public int eik;
  public String extInfo;
  public int fileType;
  public String mYc;
  public String packageName;
  public int qJH;
  public int qJI;
  public int qJJ;
  public boolean qJg;
  public boolean qKA = false;
  public String qKt;
  public String qKu;
  public long qKv;
  public boolean qKw = true;
  public boolean qKx;
  public boolean qKy = true;
  public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> qKz;
  public int scene;
  
  public static a aK(JSONObject paramJSONObject)
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
    locala.qKt = paramJSONObject.optString("alternative_url");
    locala.qKv = paramJSONObject.optLong("task_size");
    locala.mYc = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = Util.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.qKu = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.dNv = paramJSONObject.optInt("downloader_type", 1);
    locala.qJg = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.eik = paramJSONObject.optInt("download_type", 1);
    locala.qJH = paramJSONObject.optInt("uiarea");
    locala.qJI = paramJSONObject.optInt("notice_id");
    locala.qJJ = paramJSONObject.optInt("ssid");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      locala.qKz = new LinkedList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
          locala1.qGj = localJSONObject.optLong("android_md5_section_begin");
          locala1.qGk = localJSONObject.optLong("android_md5_section_end");
          locala1.qGl = localJSONObject.optString("android_md5_section_md5");
          locala.qKz.add(locala1);
        }
        i += 1;
      }
    }
    if (paramJSONObject.optInt("ignoreNetwork", 0) == 1) {
      bool = true;
    }
    locala.qKA = bool;
    AppMethodBeat.o(153083);
    return locala;
  }
  
  public static a ad(Map<String, Object> paramMap)
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
    locala.qKt = ((String)paramMap.get("alternative_url"));
    locala.qKv = Util.getLong((String)paramMap.get("task_size"), 0L);
    locala.mYc = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = Util.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.qKu = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = Util.getInt((String)paramMap.get("scene"), 1000);
    locala.dNv = Util.getInt((String)paramMap.get("downloader_type"), 1);
    locala.eik = Util.getInt((String)paramMap.get("download_type"), 1);
    locala.qJH = Util.getInt((String)paramMap.get("uiarea"), 0);
    locala.qJI = Util.getInt((String)paramMap.get("notice_id"), 0);
    locala.qJJ = Util.getInt((String)paramMap.get("ssid"), 0);
    Object localObject = (String)paramMap.get("fileSectionMd5");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        if (((JSONArray)localObject).length() > 0)
        {
          locala.qKz = new LinkedList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
              locala1.qGj = localJSONObject.optLong("android_md5_section_begin");
              locala1.qGk = localJSONObject.optLong("android_md5_section_end");
              locala1.qGl = localJSONObject.optString("android_md5_section_md5");
              locala.qKz.add(locala1);
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
      locala.qKA = bool;
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