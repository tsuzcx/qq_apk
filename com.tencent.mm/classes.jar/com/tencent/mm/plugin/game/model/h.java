package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  JSONObject xEH = new JSONObject();
  
  protected h(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.xEH = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.GameServerData", "Json parsing error");
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
  
  protected static LinkedList<c> z(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      Log.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    Log.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        Log.e("MicroMsg.GameServerData", "Invalid json object");
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
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          Log.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          c localc = new c();
          localc.field_appId = str;
          localc.field_appName = l((JSONObject)localObject, "name");
          localc.field_appIconUrl = l((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = l((JSONObject)localObject, "AndroidPackageName");
          localc.Bl(l((JSONObject)localObject, "downloadURL"));
          localc.Bo(l((JSONObject)localObject, "AndroidApkMd5"));
          str = l((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.Bp(str);
          if (!Util.isNullOrNil(str))
          {
            Log.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.mZ(j);
          }
          if (localJSONObject != null) {
            localc.mZ(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.Bu(l(localJSONObject, "DownloadUrl"));
            localc.Bv(l(localJSONObject, "ApkMd5"));
            localc.Bs(l(localJSONObject, "PreemptiveUrl"));
            localc.Bt(l(localJSONObject, "ExtInfo"));
            localc.na(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.xDV = l((JSONObject)localObject, "desc");
          localc.xDU = l((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.xDX = l((JSONObject)localObject, "webURL");
          localc.xDY = l((JSONObject)localObject, "adUrl");
          localc.dDJ = l((JSONObject)localObject, "noticeid");
          localc.jyX = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.xDZ = l(localJSONObject, "DownloadTipsWording");
            localc.xEa = l(localJSONObject, "BackBtnWording");
            localc.xEb = l(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.xEH.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */