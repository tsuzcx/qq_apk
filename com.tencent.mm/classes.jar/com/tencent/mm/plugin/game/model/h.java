package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  private JSONObject ICT = new JSONObject();
  
  protected h(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.ICT = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.GameServerData", "Json parsing error");
    }
  }
  
  protected static LinkedList<c> C(JSONArray paramJSONArray)
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
        String str = m((JSONObject)localObject, "appID");
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
          localc.field_appName = m((JSONObject)localObject, "name");
          localc.field_appIconUrl = m((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = m((JSONObject)localObject, "AndroidPackageName");
          localc.AE(m((JSONObject)localObject, "downloadURL"));
          localc.AH(m((JSONObject)localObject, "AndroidApkMd5"));
          str = m((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.AI(str);
          if (!Util.isNullOrNil(str))
          {
            Log.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.pl(j);
          }
          if (localJSONObject != null) {
            localc.pl(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.AN(m(localJSONObject, "DownloadUrl"));
            localc.AO(m(localJSONObject, "ApkMd5"));
            localc.AL(m(localJSONObject, "PreemptiveUrl"));
            localc.AM(m(localJSONObject, "ExtInfo"));
            localc.pm(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.ICg = m((JSONObject)localObject, "desc");
          localc.ICf = m((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.ICi = m((JSONObject)localObject, "webURL");
          localc.ICj = m((JSONObject)localObject, "adUrl");
          localc.hAR = m((JSONObject)localObject, "noticeid");
          localc.piu = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.ICk = m(localJSONObject, "DownloadTipsWording");
            localc.ICl = m(localJSONObject, "BackBtnWording");
            localc.ICm = m(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  private static String m(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString);
  }
  
  protected final int optInt(String paramString)
  {
    return this.ICT.optInt(paramString);
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.ICT.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */