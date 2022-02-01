package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/WxaLabelConstant;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a eqs;
  
  static
  {
    AppMethodBeat.i(220241);
    eqs = new a((byte)0);
    AppMethodBeat.o(220241);
  }
  
  public static final boolean da(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && ((paramInt1 & 0x1) == 1) && ((paramInt1 >> paramInt2 - 1 & 0x1) == 1);
  }
  
  public static final boolean mq(int paramInt)
  {
    return paramInt != 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/WxaLabelConstant$Companion;", "", "()V", "OFFICIAL_FLAG_COMMON", "", "OFFICIAL_FLAG_E_COMMERCE", "OFFICIAL_FLAG_NONE", "RELIEVED_BUY_FLAG_BIT_BizAds", "RELIEVED_BUY_FLAG_BIT_BizH5", "RELIEVED_BUY_FLAG_BIT_Chat", "RELIEVED_BUY_FLAG_BIT_FriendAds", "RELIEVED_BUY_FLAG_BIT_LocalSearch", "RELIEVED_BUY_FLAG_BIT_Master", "RELIEVED_BUY_FLAG_BIT_MinShop", "RELIEVED_BUY_FLAG_BIT_Profile", "RELIEVED_BUY_FLAG_BIT_RecentlyList", "RELIEVED_BUY_FLAG_BIT_ScanIdentify", "RELIEVED_BUY_FLAG_BIT_Search", "RELIEVED_BUY_FLAG_BIT_TradeModule", "RELIEVED_BUY_FLAG_BIT_WxaLoading", "RELIEVED_BUY_FLAG_BIT_WxaMenu", "RELIEVED_BUY_FLAG_NONE", "RELIEVED_BUY_FLAG_SHOW", "TRADING_GUARANTEE_FLAG_NONE", "TRADING_GUARANTEE_FLAG_SHOW", "showBrandOfficialLabel", "", "flag", "showRelievedBuyFlagLabel", "bit", "showTradingGuaranteeLabel", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.g
 * JD-Core Version:    0.7.0.1
 */