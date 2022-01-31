package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import org.json.JSONObject;

public final class WxaAttributes$d
{
  public int cau;
  public String fPA;
  public int fPB;
  public String fRr;
  public String fRs;
  public int fRt;
  public List<WxaAttributes.WxaVersionModuleInfo> fRu;
  public boolean fRv;
  public String fRw;
  
  public static d sI(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new d();
      paramString.cau = localJSONObject.optInt("AppVersion", 0);
      paramString.fPB = localJSONObject.optInt("VersionState", -1);
      paramString.fRr = localJSONObject.optString("VersionMD5");
      paramString.fRs = localJSONObject.optString("device_orientation");
      paramString.fPA = localJSONObject.optString("client_js_ext_info");
      paramString.fRt = localJSONObject.optInt("code_size");
      paramString.fRu = WxaAttributes.WxaVersionModuleInfo.sJ(localJSONObject.optString("module_list"));
      paramString.fRv = localJSONObject.optBoolean("UseModule", false);
      paramString.fRw = localJSONObject.optString("EntranceModule");
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.d
 * JD-Core Version:    0.7.0.1
 */