package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  JSONObject ump = new JSONObject();
  
  protected h(String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.ump = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      ae.e("MicroMsg.GameServerData", "Json parsing error");
    }
  }
  
  private static String i(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString);
  }
  
  protected static LinkedList<c> y(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      ae.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    ae.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        ae.e("MicroMsg.GameServerData", "Invalid json object");
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
        String str = i((JSONObject)localObject, "appID");
        if (bu.isNullOrNil(str))
        {
          ae.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          ae.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          c localc = new c();
          localc.field_appId = str;
          localc.field_appName = i((JSONObject)localObject, "name");
          localc.field_appIconUrl = i((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = i((JSONObject)localObject, "AndroidPackageName");
          localc.sU(i((JSONObject)localObject, "downloadURL"));
          localc.sX(i((JSONObject)localObject, "AndroidApkMd5"));
          str = i((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.sY(str);
          if (!bu.isNullOrNil(str))
          {
            ae.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.jX(j);
          }
          if (localJSONObject != null) {
            localc.jX(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.td(i(localJSONObject, "DownloadUrl"));
            localc.te(i(localJSONObject, "ApkMd5"));
            localc.tb(i(localJSONObject, "PreemptiveUrl"));
            localc.tc(i(localJSONObject, "ExtInfo"));
            localc.jY(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.ulD = i((JSONObject)localObject, "desc");
          localc.ulC = i((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.ulF = i((JSONObject)localObject, "webURL");
          localc.ulG = i((JSONObject)localObject, "adUrl");
          localc.dmu = i((JSONObject)localObject, "noticeid");
          localc.iEF = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.ulH = i(localJSONObject, "DownloadTipsWording");
            localc.ulI = i(localJSONObject, "BackBtnWording");
            localc.ulJ = i(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.ump.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */