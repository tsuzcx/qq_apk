package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class g
{
  JSONObject nmB = new JSONObject();
  
  protected g(String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.nmB = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.GameServerData", "Json parsing error");
    }
  }
  
  private static String j(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString);
  }
  
  protected static LinkedList<c> u(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      ab.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    ab.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        ab.e("MicroMsg.GameServerData", "Invalid json object");
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
        String str = j((JSONObject)localObject, "appID");
        if (bo.isNullOrNil(str))
        {
          ab.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          ab.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          c localc = new c();
          localc.field_appId = str;
          localc.field_appName = j((JSONObject)localObject, "name");
          localc.field_appIconUrl = j((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = j((JSONObject)localObject, "AndroidPackageName");
          localc.iV(j((JSONObject)localObject, "downloadURL"));
          localc.iY(j((JSONObject)localObject, "AndroidApkMd5"));
          str = j((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.iZ(str);
          if (!bo.isNullOrNil(str))
          {
            ab.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.ho(j);
          }
          if (localJSONObject != null) {
            localc.ho(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.je(j(localJSONObject, "DownloadUrl"));
            localc.jf(j(localJSONObject, "ApkMd5"));
            localc.jc(j(localJSONObject, "PreemptiveUrl"));
            localc.jd(j(localJSONObject, "ExtInfo"));
            localc.hp(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.nlU = j((JSONObject)localObject, "desc");
          localc.nlT = j((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.nlW = j((JSONObject)localObject, "webURL");
          localc.nlX = j((JSONObject)localObject, "adUrl");
          localc.cnG = j((JSONObject)localObject, "noticeid");
          localc.nlY = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.nlZ = j(localJSONObject, "DownloadTipsWording");
            localc.nma = j(localJSONObject, "BackBtnWording");
            localc.nmb = j(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.nmB.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */