package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXEmojiSharedObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
  public int packageflag;
  public String packageid;
  public String thumburl;
  public String url;
  
  public WXEmojiSharedObject() {}
  
  public WXEmojiSharedObject(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.thumburl = paramString1;
    this.packageflag = paramInt;
    this.packageid = paramString2;
    this.url = paramString3;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128296);
    if ((TextUtils.isEmpty(this.packageid)) || (TextUtils.isEmpty(this.thumburl)) || (TextUtils.isEmpty(this.url)) || (this.packageflag == -1))
    {
      Log.e("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
      AppMethodBeat.o(128296);
      return false;
    }
    AppMethodBeat.o(128296);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128294);
    paramBundle.putString("_wxemojisharedobject_thumburl", this.thumburl);
    paramBundle.putInt("_wxemojisharedobject_packageflag", this.packageflag);
    paramBundle.putString("_wxemojisharedobject_packageid", this.packageid);
    paramBundle.putString("_wxemojisharedobject_url", this.url);
    AppMethodBeat.o(128294);
  }
  
  public int type()
  {
    return 15;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128295);
    this.thumburl = paramBundle.getString("_wxwebpageobject_thumburl");
    this.packageflag = paramBundle.getInt("_wxwebpageobject_packageflag");
    this.packageid = paramBundle.getString("_wxwebpageobject_packageid");
    this.url = paramBundle.getString("_wxwebpageobject_url");
    AppMethodBeat.o(128295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject
 * JD-Core Version:    0.7.0.1
 */