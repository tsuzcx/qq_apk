package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXDesignerSharedObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
  public String designerName;
  public String designerRediretctUrl;
  public int designerUIN;
  public String thumburl;
  public String url;
  
  public WXDesignerSharedObject() {}
  
  public WXDesignerSharedObject(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.url = paramString2;
    this.thumburl = paramString1;
    this.designerUIN = paramInt;
    this.designerName = paramString3;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128272);
    if ((this.designerUIN == 0) || (TextUtils.isEmpty(this.thumburl)) || (TextUtils.isEmpty(this.url)))
    {
      Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
      AppMethodBeat.o(128272);
      return false;
    }
    AppMethodBeat.o(128272);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128270);
    paramBundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
    paramBundle.putInt("_wxemojisharedobject_designer_uin", this.designerUIN);
    paramBundle.putString("_wxemojisharedobject_designer_name", this.designerName);
    paramBundle.putString("_wxemojisharedobject_designer_rediretcturl", this.designerRediretctUrl);
    paramBundle.putString("_wxemojisharedobject_url", this.url);
    AppMethodBeat.o(128270);
  }
  
  public int type()
  {
    return 25;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128271);
    this.thumburl = paramBundle.getString("_wxwebpageobject_thumburl");
    this.designerUIN = paramBundle.getInt("_wxemojisharedobject_designer_uin");
    this.designerName = paramBundle.getString("_wxemojisharedobject_designer_name");
    this.designerRediretctUrl = paramBundle.getString("_wxemojisharedobject_designer_rediretcturl");
    this.url = paramBundle.getString("_wxwebpageobject_url");
    AppMethodBeat.o(128271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject
 * JD-Core Version:    0.7.0.1
 */