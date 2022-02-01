package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXMiniProgramObject
  implements WXMediaMessage.IMediaObject
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
  public int disableforward;
  private HashMap<String, String> extraInfoMap;
  public boolean isSecretMessage;
  public boolean isUpdatableMessage;
  public int miniprogramType;
  public String path;
  public String userName;
  public String webpageUrl;
  public boolean withShareTicket;
  
  public WXMiniProgramObject()
  {
    AppMethodBeat.i(253686);
    this.miniprogramType = 0;
    this.disableforward = 0;
    this.isUpdatableMessage = false;
    this.isSecretMessage = false;
    this.extraInfoMap = null;
    AppMethodBeat.o(253686);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3948);
    if (b.b(this.webpageUrl))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "webPageUrl is null");
      AppMethodBeat.o(3948);
      return false;
    }
    if (b.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "userName is null");
      AppMethodBeat.o(3948);
      return false;
    }
    int i = this.miniprogramType;
    if ((i >= 0) && (i <= 2))
    {
      AppMethodBeat.o(3948);
      return true;
    }
    Log.e("MicroMsg.SDK.WXMiniProgramObject", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
    AppMethodBeat.o(3948);
    return false;
  }
  
  public String getExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253690);
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
      AppMethodBeat.o(253690);
      return paramString2;
      AppMethodBeat.o(253690);
      return null;
      label41:
      paramString2 = paramString1;
    }
  }
  
  public void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253689);
    if (this.extraInfoMap == null) {
      this.extraInfoMap = new HashMap();
    }
    if (!b.b(paramString1)) {
      this.extraInfoMap.put(paramString1, paramString2);
    }
    AppMethodBeat.o(253689);
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3946);
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    paramBundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    paramBundle.putBoolean("_wxminiprogram_isupdatablemsg", this.isUpdatableMessage);
    paramBundle.putBoolean("_wxminiprogram_issecretmsg", this.isSecretMessage);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null) {
      paramBundle.putSerializable("_wxminiprogram_extrainfo", localHashMap);
    }
    AppMethodBeat.o(3946);
  }
  
  public int type()
  {
    return 36;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3947);
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    this.disableforward = paramBundle.getInt("_wxminiprogram_disableforward");
    this.isUpdatableMessage = paramBundle.getBoolean("_wxminiprogram_isupdatablemsg");
    this.isSecretMessage = paramBundle.getBoolean("_wxminiprogram_issecretmsg");
    this.extraInfoMap = ((HashMap)paramBundle.getSerializable("_wxminiprogram_extrainfo"));
    AppMethodBeat.o(3947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */