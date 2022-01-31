package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ChooseCardFromWXCardPackage$Req
  extends BaseReq
{
  public String appId;
  public String canMultiSelect;
  public String cardId;
  public String cardSign;
  public String cardType;
  public String locationId;
  public String nonceStr;
  public String signType;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128176);
    if ((this.appId == null) || (this.appId.length() <= 0))
    {
      AppMethodBeat.o(128176);
      return false;
    }
    if ((this.signType == null) || (this.signType.length() <= 0))
    {
      AppMethodBeat.o(128176);
      return false;
    }
    if ((this.cardSign == null) || (this.cardSign.length() <= 0))
    {
      AppMethodBeat.o(128176);
      return false;
    }
    AppMethodBeat.o(128176);
    return true;
  }
  
  public int getType()
  {
    return 16;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128177);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
    AppMethodBeat.o(128177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Req
 * JD-Core Version:    0.7.0.1
 */