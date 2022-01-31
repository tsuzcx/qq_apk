package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaAttributes$WxaVersionModuleInfo
  extends ModulePkgInfo
{
  public int size;
  
  public static List<WxaVersionModuleInfo> sJ(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString.length() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          while (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject != null)
            {
              WxaVersionModuleInfo localWxaVersionModuleInfo = new WxaVersionModuleInfo();
              localWxaVersionModuleInfo.name = localJSONObject.getString("name");
              localWxaVersionModuleInfo.bIW = localJSONObject.getString("md5");
              localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
              localWxaVersionModuleInfo.bGd = localJSONObject.optBoolean("independent", false);
              localLinkedList.add(localWxaVersionModuleInfo);
            }
            i += 1;
          }
          return localLinkedList;
        }
      }
      catch (JSONException paramString)
      {
        y.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramString });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo
 * JD-Core Version:    0.7.0.1
 */