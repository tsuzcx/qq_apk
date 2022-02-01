package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage$Resp
  extends BaseResp
{
  public String cardItemList;
  
  public ChooseCardFromWXCardPackage$Resp() {}
  
  public ChooseCardFromWXCardPackage$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3888);
    fromBundle(paramBundle);
    AppMethodBeat.o(3888);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3889);
    String str = this.cardItemList;
    if ((str != null) && (str.length() != 0))
    {
      AppMethodBeat.o(3889);
      return true;
    }
    AppMethodBeat.o(3889);
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3891);
    super.fromBundle(paramBundle);
    paramBundle = paramBundle.getString("_wxapi_choose_card_from_wx_card_list");
    if ((paramBundle != null) && (paramBundle.length() > 0))
    {
      this.cardItemList = paramBundle;
      AppMethodBeat.o(3891);
      return;
    }
    Log.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
    AppMethodBeat.o(3891);
  }
  
  public int getType()
  {
    return 16;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3890);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
    AppMethodBeat.o(3890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp
 * JD-Core Version:    0.7.0.1
 */