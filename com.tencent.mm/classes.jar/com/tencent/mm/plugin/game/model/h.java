package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  JSONObject rVF = new JSONObject();
  
  protected h(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.rVF = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.GameServerData", "Json parsing error");
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
  
  protected static LinkedList<c> w(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      ad.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    ad.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        ad.e("MicroMsg.GameServerData", "Invalid json object");
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
        if (bt.isNullOrNil(str))
        {
          ad.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          ad.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          c localc = new c();
          localc.field_appId = str;
          localc.field_appName = i((JSONObject)localObject, "name");
          localc.field_appIconUrl = i((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = i((JSONObject)localObject, "AndroidPackageName");
          localc.mJ(i((JSONObject)localObject, "downloadURL"));
          localc.mM(i((JSONObject)localObject, "AndroidApkMd5"));
          str = i((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.mN(str);
          if (!bt.isNullOrNil(str))
          {
            ad.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.jz(j);
          }
          if (localJSONObject != null) {
            localc.jz(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.mS(i(localJSONObject, "DownloadUrl"));
            localc.mT(i(localJSONObject, "ApkMd5"));
            localc.mQ(i(localJSONObject, "PreemptiveUrl"));
            localc.mR(i(localJSONObject, "ExtInfo"));
            localc.jA(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.rUT = i((JSONObject)localObject, "desc");
          localc.rUS = i((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.rUV = i((JSONObject)localObject, "webURL");
          localc.rUW = i((JSONObject)localObject, "adUrl");
          localc.dcC = i((JSONObject)localObject, "noticeid");
          localc.hHQ = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.rUX = i(localJSONObject, "DownloadTipsWording");
            localc.rUY = i(localJSONObject, "BackBtnWording");
            localc.rUZ = i(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.rVF.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */