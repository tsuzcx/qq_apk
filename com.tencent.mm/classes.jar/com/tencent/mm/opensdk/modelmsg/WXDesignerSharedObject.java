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
    AppMethodBeat.i(254912);
    this.url = paramString2;
    this.thumburl = paramString1;
    this.designerUIN = paramInt;
    this.designerName = paramString3;
    AppMethodBeat.o(254912);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3972);
    if ((this.designerUIN != 0) && (!TextUtils.isEmpty(this.thumburl)) && (!TextUtils.isEmpty(this.url)))
    {
      AppMethodBeat.o(3972);
      return true;
    }
    Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
    AppMethodBeat.o(3972);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3970);
    paramBundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
    paramBundle.putInt("_wxemojisharedobject_designer_uin", this.designerUIN);
    paramBundle.putString("_wxemojisharedobject_designer_name", this.designerName);
    paramBundle.putString("_wxemojisharedobject_designer_rediretcturl", this.designerRediretctUrl);
    paramBundle.putString("_wxemojisharedobject_url", this.url);
    AppMethodBeat.o(3970);
  }
  
  public int type()
  {
    return 25;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3971);
    this.thumburl = paramBundle.getString("_wxwebpageobject_thumburl");
    this.designerUIN = paramBundle.getInt("_wxemojisharedobject_designer_uin");
    this.designerName = paramBundle.getString("_wxemojisharedobject_designer_name");
    this.designerRediretctUrl = paramBundle.getString("_wxemojisharedobject_designer_rediretcturl");
    this.url = paramBundle.getString("_wxwebpageobject_url");
    AppMethodBeat.o(3971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject
 * JD-Core Version:    0.7.0.1
 */