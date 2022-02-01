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
  public int fGH;
  public int fileType;
  public int gcB;
  public String pYB;
  public String packageName;
  public int scene;
  public int uiM;
  public int uiN;
  public int uiO;
  public boolean uij;
  public String ulF;
  public String ulG;
  public long ulH;
  public boolean ulI = true;
  public boolean ulJ;
  public boolean ulK = true;
  public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> ulL;
  public boolean ulM = false;
  
  public static a V(Map<String, Object> paramMap)
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
    locala.ulF = ((String)paramMap.get("alternative_url"));
    locala.ulH = Util.getLong((String)paramMap.get("task_size"), 0L);
    locala.pYB = ((String)paramMap.get("file_md5"));
    locala.extInfo = ((String)paramMap.get("extInfo"));
    locala.fileType = Util.getInt((String)paramMap.get("fileType"), 0);
    locala.appId = ((String)paramMap.get("appid"));
    locala.ulG = ((String)paramMap.get("raw_appid"));
    locala.packageName = ((String)paramMap.get("package_name"));
    locala.scene = Util.getInt((String)paramMap.get("scene"), 1000);
    locala.fGH = Util.getInt((String)paramMap.get("downloader_type"), 1);
    locala.gcB = Util.getInt((String)paramMap.get("download_type"), 1);
    locala.uiM = Util.getInt((String)paramMap.get("uiarea"), 0);
    locala.uiN = Util.getInt((String)paramMap.get("notice_id"), 0);
    locala.uiO = Util.getInt((String)paramMap.get("ssid"), 0);
    Object localObject = (String)paramMap.get("fileSectionMd5");
    if (!Util.isNullOrNil((String)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        if (((JSONArray)localObject).length() > 0)
        {
          locala.ulL = new LinkedList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject != null)
            {
              com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
              locala1.ufk = localJSONObject.optLong("android_md5_section_begin");
              locala1.ufl = localJSONObject.optLong("android_md5_section_end");
              locala1.ufm = localJSONObject.optString("android_md5_section_md5");
              locala.ulL.add(locala1);
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
      locala.ulM = bool;
      AppMethodBeat.o(153084);
      return locala;
    }
  }
  
  public static a aO(JSONObject paramJSONObject)
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
    locala.ulF = paramJSONObject.optString("alternative_url");
    locala.ulH = paramJSONObject.optLong("task_size");
    locala.pYB = paramJSONObject.optString("file_md5");
    locala.extInfo = paramJSONObject.optString("extInfo");
    locala.fileType = Util.getInt(paramJSONObject.optString("fileType"), 0);
    locala.appId = paramJSONObject.optString("appid");
    locala.ulG = paramJSONObject.optString("raw_appid");
    locala.packageName = paramJSONObject.optString("packageName");
    locala.scene = paramJSONObject.optInt("scene", 1000);
    locala.fGH = paramJSONObject.optInt("downloader_type", 1);
    locala.uij = paramJSONObject.optBoolean("download_in_wifi", false);
    locala.gcB = paramJSONObject.optInt("download_type", 1);
    locala.uiM = paramJSONObject.optInt("uiarea");
    locala.uiN = paramJSONObject.optInt("notice_id");
    locala.uiO = paramJSONObject.optInt("ssid");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("fileSectionMd5");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      locala.ulL = new LinkedList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          com.tencent.mm.plugin.downloader.c.b.a locala1 = new com.tencent.mm.plugin.downloader.c.b.a();
          locala1.ufk = localJSONObject.optLong("android_md5_section_begin");
          locala1.ufl = localJSONObject.optLong("android_md5_section_end");
          locala1.ufm = localJSONObject.optString("android_md5_section_md5");
          locala.ulL.add(locala1);
        }
        i += 1;
      }
    }
    if (paramJSONObject.optInt("ignoreNetwork", 0) == 1) {
      bool = true;
    }
    locala.ulM = bool;
    AppMethodBeat.o(153083);
    return locala;
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