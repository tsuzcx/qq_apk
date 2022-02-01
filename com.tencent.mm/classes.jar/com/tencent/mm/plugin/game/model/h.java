package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h
{
  JSONObject tdx = new JSONObject();
  
  protected h(String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.GameServerData", "Null or nil json string");
      return;
    }
    try
    {
      this.tdx = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      ac.e("MicroMsg.GameServerData", "Json parsing error");
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
      ac.i("MicroMsg.GameServerData", "Null or empty json array");
      return localLinkedList;
    }
    ac.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[] { Integer.valueOf(paramJSONArray.length()) });
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null)
      {
        ac.e("MicroMsg.GameServerData", "Invalid json object");
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
        if (bs.isNullOrNil(str))
        {
          ac.e("MicroMsg.GameServerData", "No AppID field, abort");
          localObject = null;
        }
        else
        {
          ac.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[] { str });
          c localc = new c();
          localc.field_appId = str;
          localc.field_appName = i((JSONObject)localObject, "name");
          localc.field_appIconUrl = i((JSONObject)localObject, "iconURL");
          localc.field_appType = ",1,";
          localc.field_packageName = i((JSONObject)localObject, "AndroidPackageName");
          localc.pP(i((JSONObject)localObject, "downloadURL"));
          localc.pS(i((JSONObject)localObject, "AndroidApkMd5"));
          str = i((JSONObject)localObject, "GooglePlayDownloadUrl");
          int j = ((JSONObject)localObject).optInt("GooglePlayDownloadFlag");
          localc.pT(str);
          if (!bs.isNullOrNil(str))
          {
            ac.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[] { str, Integer.valueOf(j) });
            localc.jx(j);
          }
          if (localJSONObject != null) {
            localc.jx(localJSONObject.optInt("AndroidDownloadFlag"));
          }
          if (localJSONObject != null)
          {
            localc.pY(i(localJSONObject, "DownloadUrl"));
            localc.pZ(i(localJSONObject, "ApkMd5"));
            localc.pW(i(localJSONObject, "PreemptiveUrl"));
            localc.pX(i(localJSONObject, "ExtInfo"));
            localc.jy(localJSONObject.optInt("SupportedVersionCode"));
          }
          localc.tcL = i((JSONObject)localObject, "desc");
          localc.tcK = i((JSONObject)localObject, "brief");
          localc.type = ((JSONObject)localObject).optInt("type", 0);
          localc.status = ((JSONObject)localObject).optInt("status");
          localc.tcN = i((JSONObject)localObject, "webURL");
          localc.tcO = i((JSONObject)localObject, "adUrl");
          localc.daa = i((JSONObject)localObject, "noticeid");
          localc.iis = ((JSONObject)localObject).optBoolean("isSubscribed");
          localc.versionCode = ((JSONObject)localObject).optInt("versionCode");
          localObject = localc;
          if (localJSONObject != null)
          {
            localc.tcP = i(localJSONObject, "DownloadTipsWording");
            localc.tcQ = i(localJSONObject, "BackBtnWording");
            localc.tcR = i(localJSONObject, "DownloadBtnWording");
            localObject = localc;
          }
        }
      }
    }
    return localLinkedList;
  }
  
  protected final JSONArray optJSONArray(String paramString)
  {
    return this.tdx.optJSONArray(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */