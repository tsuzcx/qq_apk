package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  JSONObject kOE = new JSONObject();
  
  protected h(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.kOE = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.GameServerData", "Json parsing error");
    }
  }
  
  private static String l(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString);
  }
  
  protected static LinkedList<d> q(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      y.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    y.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        y.e("MicroMsg.GameServerData", "Invalid json object");
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        i += 1;
        break;
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("YYB");
        String str = l((JSONObject)localObject, "appID");
        if (bk.bl(str))
        {
          y.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          y.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          d locald = new d();
          locald.field_appId = str;
          locald.field_appName = l((JSONObject)localObject, "name");
          locald.field_appIconUrl = l((JSONObject)localObject, "iconURL");
          locald.field_appType = ",1,";
          locald.field_packageName = l((JSONObject)localObject, "AndroidPackageName");
          locald.cN(l((JSONObject)localObject, "downloadURL"));
          locald.cQ(l((JSONObject)localObject, "AndroidApkMd5"));
          str = l((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          locald.cR(str);
          if (!bk.bl(str))
          {
            y.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            locald.fd(j);
          }
          if (localJSONObject != null) {
            locald.fd(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            locald.cW(l(localJSONObject, "DownloadUrl"));
            locald.cX(l(localJSONObject, "ApkMd5"));
            locald.cU(l(localJSONObject, "PreemptiveUrl"));
            locald.cV(l(localJSONObject, "ExtInfo"));
            locald.fe(localJSONObject.optInt("SupportedVersionCode"));
          }
          locald.kNX = l((JSONObject)localObject, "desc");
          locald.kNW = l((JSONObject)localObject, "brief");
          locald.type = ((JSONObject)localObject).optInt("type", 0);
          locald.status = ((JSONObject)localObject).optInt("status");
          locald.kNZ = l((JSONObject)localObject, "webURL");
          locald.kOa = l((JSONObject)localObject, "adUrl");
          locald.bGy = l((JSONObject)localObject, "noticeid");
          locald.kOb = ((JSONObject)localObject).optBoolean("isSubscribed");
          locald.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = locald;
          if (localJSONObject != null)
          {
            locald.kOc = l(localJSONObject, "DownloadTipsWording");
            locald.kOd = l(localJSONObject, "BackBtnWording");
            locald.kOe = l(localJSONObject, "DownloadBtnWording");
            localObject = locald;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.kOE.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */