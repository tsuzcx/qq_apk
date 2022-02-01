package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ChooseCardFromWXCardPackage
{
  private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";
  
  public static class Req
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
      AppMethodBeat.i(3873);
      String str = this.appId;
      if ((str != null) && (str.length() > 0))
      {
        str = this.signType;
        if ((str != null) && (str.length() > 0))
        {
          str = this.cardSign;
          if ((str != null) && (str.length() > 0))
          {
            AppMethodBeat.o(3873);
            return true;
          }
          AppMethodBeat.o(3873);
          return false;
        }
        AppMethodBeat.o(3873);
        return false;
      }
      AppMethodBeat.o(3873);
      return false;
    }
    
    public int getType()
    {
      return 16;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3874);
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
      AppMethodBeat.o(3874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage
 * JD-Core Version:    0.7.0.1
 */