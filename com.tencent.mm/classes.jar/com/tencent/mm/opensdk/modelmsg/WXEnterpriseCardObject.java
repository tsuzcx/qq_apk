package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXEnterpriseCardObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
  public String cardInfo;
  public int msgType;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3999);
    String str = this.cardInfo;
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(3999);
      return true;
    }
    Log.e("MicroMsg.SDK.WXEnterpriseCardObject", "checkArgs fail, cardInfo is invalid");
    AppMethodBeat.o(3999);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3997);
    paramBundle.putInt("_wxenterprisecard_msgtype", this.msgType);
    paramBundle.putString("_wxenterprisecard_cardinfo", this.cardInfo);
    AppMethodBeat.o(3997);
  }
  
  public int type()
  {
    return 45;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3998);
    this.msgType = paramBundle.getInt("_wxenterprisecard_msgtype");
    this.cardInfo = paramBundle.getString("_wxenterprisecard_cardinfo");
    AppMethodBeat.o(3998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject
 * JD-Core Version:    0.7.0.1
 */