package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  private JSONObject CII = new JSONObject();
  
  protected h(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.CII = new JSONObject(paramString);
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
          localc.HZ(l((JSONObject)localObject, "downloadURL"));
          localc.Ic(l((JSONObject)localObject, "AndroidApkMd5"));
          str = l((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.Id(str);
          if (!Util.isNullOrNil(str))
          {
            Log.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.pm(j);
          }
          if (localJSONObject != null) {
            localc.pm(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.Ii(l(localJSONObject, "DownloadUrl"));
            localc.Ij(l(localJSONObject, "ApkMd5"));
            localc.Ig(l(localJSONObject, "PreemptiveUrl"));
            localc.Ih(l(localJSONObject, "ExtInfo"));
            localc.pn(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.CHW = l((JSONObject)localObject, "desc");
          localc.CHV = l((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.CHY = l((JSONObject)localObject, "webURL");
          localc.CHZ = l((JSONObject)localObject, "adUrl");
          localc.fwt = l((JSONObject)localObject, "noticeid");
          localc.moD = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.CIa = l(localJSONObject, "DownloadTipsWording");
            localc.CIb = l(localJSONObject, "BackBtnWording");
            localc.CIc = l(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final int optInt(String paramString)
  {
    return this.CII.optInt(paramString);
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.CII.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */