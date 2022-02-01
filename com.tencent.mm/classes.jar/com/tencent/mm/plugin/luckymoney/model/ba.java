package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba
  extends az
{
  public ba(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(271530);
    this.ybP = paramString1;
    this.gbn = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!Util.isNullOrNil(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    localHashMap.put("union_source", "0");
    Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "NetSceneOpenLuckyMoneyUnion request");
    setRequestData(localHashMap);
    AppMethodBeat.o(271530);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/unionhb/openunionhb";
  }
  
  public final int getType()
  {
    return 5148;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271536);
    Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    try
    {
      this.EAX = ad.bf(paramJSONObject);
      this.EBo = LuckyMoneyEmojiSwitch.be(paramJSONObject);
      Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "luckyMoneyEmojiSwitch:%s", new Object[] { this.EBo.toString() });
      this.EBm = paramJSONObject.optString("expression_md5");
      this.EBn = paramJSONObject.optInt("expression_type");
      Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", new Object[] { this.EBm, Integer.valueOf(this.EBn) });
      if ((paramInt == 0) && (paramJSONObject.has("real_name_info")))
      {
        Object localObject = paramJSONObject.optJSONObject("real_name_info");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("guide_flag");
          String str1 = ((JSONObject)localObject).optString("guide_wording");
          String str2 = ((JSONObject)localObject).optString("left_button_wording");
          String str3 = ((JSONObject)localObject).optString("right_button_wording");
          localObject = ((JSONObject)localObject).optString("upload_credit_url");
          this.Evs = new RealnameGuideHelper();
          this.Evs.a(paramString, str1, str2, str3, (String)localObject, 1003);
        }
      }
      if (paramJSONObject.has("intercept_win")) {
        this.EAY = b.cg(paramJSONObject.optJSONObject("intercept_win"));
      }
      this.EBH = paramJSONObject.optString("SystemMsgContext");
      this.EBI = paramJSONObject.optInt("showYearExpression");
      Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "showYearExpression:%s", new Object[] { Integer.valueOf(this.EBI) });
      if ((paramInt == 0) && (!Util.isNullOrNil(this.EBH)))
      {
        boolean bool = ab.Qg(this.talker);
        if (bool) {}
      }
      try
      {
        ag.iN(this.EBH, this.talker);
        eOI();
        AppMethodBeat.o(271536);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneOpenLuckyMoneyUnion", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      Log.w("MicroMsg.NetSceneOpenLuckyMoneyUnion", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
      AppMethodBeat.o(271536);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ba
 * JD-Core Version:    0.7.0.1
 */