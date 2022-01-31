package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends ab
{
  long bIt;
  public String ceb;
  public RealnameGuideHelper lMW;
  public String lMg;
  public f lQZ = null;
  public String lRz;
  public String talker;
  
  public ad(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.lMg = paramString1;
    this.ceb = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!bk.bl(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!bk.bl(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(bk.pm(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      this.lQZ = m.T(paramJSONObject);
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
          this.lMW = new RealnameGuideHelper();
          this.lMW.a(paramString, str1, str2, str3, (String)localObject, 1003);
        }
      }
      this.lRz = paramJSONObject.optString("SystemMsgContext");
      if ((paramInt == 0) && (!bk.bl(this.lRz)))
      {
        boolean bool = bk.bl(this.lQZ.lQp);
        if (bool) {}
      }
      try
      {
        this.lRz = this.lRz.replace("$" + this.lQZ.lQp + "$", ((b)g.r(b.class)).gV(this.lQZ.lQp));
        o.dL(this.lRz, this.talker);
        return;
      }
      catch (Exception paramString)
      {
        y.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      y.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
    }
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final int getType()
  {
    return 1685;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ad
 * JD-Core Version:    0.7.0.1
 */