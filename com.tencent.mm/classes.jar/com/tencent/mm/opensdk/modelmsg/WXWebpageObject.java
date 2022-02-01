package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXWebpageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
  public String canvasPageXml;
  public String extInfo;
  public HashMap<String, String> extraInfoMap;
  public boolean isSecretMessage;
  public String webpageUrl;
  
  public WXWebpageObject()
  {
    AppMethodBeat.i(242996);
    this.isSecretMessage = false;
    this.extraInfoMap = null;
    AppMethodBeat.o(242996);
  }
  
  public WXWebpageObject(String paramString)
  {
    AppMethodBeat.i(242997);
    this.isSecretMessage = false;
    this.extraInfoMap = null;
    this.webpageUrl = paramString;
    AppMethodBeat.o(242997);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4023);
    String str = this.webpageUrl;
    if ((str != null) && (str.length() != 0) && (this.webpageUrl.length() <= 10240))
    {
      AppMethodBeat.o(4023);
      return true;
    }
    Log.e("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
    AppMethodBeat.o(4023);
    return false;
  }
  
  public String getExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243014);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null)
    {
      paramString1 = (String)localHashMap.get(paramString1);
      if (paramString1 != null) {
        break label41;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(243014);
      return paramString2;
      AppMethodBeat.o(243014);
      return null;
      label41:
      paramString2 = paramString1;
    }
  }
  
  public void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243009);
    if (this.extraInfoMap == null) {
      this.extraInfoMap = new HashMap();
    }
    if (!b.b(paramString1)) {
      this.extraInfoMap.put(paramString1, paramString2);
    }
    AppMethodBeat.o(243009);
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4021);
    paramBundle.putString("_wxwebpageobject_extInfo", this.extInfo);
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
    paramBundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
    paramBundle.putBoolean("_wxwebpageobject_issecretmsg", this.isSecretMessage);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null) {
      paramBundle.putSerializable("_wxwebpageobject_extrainfo", localHashMap);
    }
    AppMethodBeat.o(4021);
  }
  
  public int type()
  {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4022);
    this.extInfo = paramBundle.getString("_wxwebpageobject_extInfo");
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
    this.canvasPageXml = paramBundle.getString("_wxwebpageobject_canvaspagexml");
    this.isSecretMessage = paramBundle.getBoolean("_wxwebpageobject_issecretmsg");
    paramBundle = paramBundle.getSerializable("_wxwebpageobject_extrainfo");
    if (paramBundle != null) {
      this.extraInfoMap = ((HashMap)paramBundle);
    }
    AppMethodBeat.o(4022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXWebpageObject
 * JD-Core Version:    0.7.0.1
 */