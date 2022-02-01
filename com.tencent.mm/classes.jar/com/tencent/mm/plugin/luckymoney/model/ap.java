package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  extends am
{
  public String dBy;
  long msgId;
  public String talker;
  public String uhB;
  public RealnameGuideHelper uis;
  public String unQ;
  public int unR;
  public com.tencent.mm.plugin.wallet_core.utils.b unS;
  public l uni;
  public String unv;
  public int unw;
  public LuckyMoneyEmojiSwitch unx;
  
  public ap(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(65301);
    this.uni = null;
    this.unR = 0;
    this.uhB = paramString1;
    this.dBy = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!bs.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!bs.isNullOrNil(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(bs.nullAsNil(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    setRequestData(localHashMap);
    AppMethodBeat.o(65301);
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final int getType()
  {
    return 1685;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65302);
    for (;;)
    {
      try
      {
        this.uni = x.au(paramJSONObject);
        this.unx = LuckyMoneyEmojiSwitch.at(paramJSONObject);
        ac.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.unx.toString() });
        this.unv = paramJSONObject.optString("expression_md5");
        this.unw = paramJSONObject.optInt("expression_type");
        ac.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.unv, Integer.valueOf(this.unw) });
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
            this.uis = new RealnameGuideHelper();
            this.uis.b(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.unS = com.tencent.mm.plugin.wallet_core.utils.b.bn(paramJSONObject.optJSONObject("intercept_win"));
        }
        this.unQ = paramJSONObject.optString("SystemMsgContext");
        this.unR = paramJSONObject.optInt("showYearExpression");
        ac.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", new Object[] { Integer.valueOf(this.unR) });
        if ((paramInt == 0) && (!bs.isNullOrNil(this.unQ)) && (!bs.isNullOrNil(this.uni.ulT)))
        {
          boolean bool = w.wC(this.talker);
          if (bool) {}
        }
        try
        {
          if (!u.axw().equals(this.uni.ulT)) {
            continue;
          }
          paramString = ai.getContext().getString(2131760972);
          this.unQ = this.unQ.replace("$" + this.uni.ulT + "$", paramString);
          z.hy(this.unQ, this.talker);
        }
        catch (Exception paramString)
        {
          int i;
          ac.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        g.agS();
        paramInt = ((Integer)g.agR().agA().get(ah.a.GSZ, Integer.valueOf(0))).intValue();
        i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSw, 0);
        if ((bs.jl(paramInt, 1)) || (bs.jl(i, 1)))
        {
          if (this.unx == null) {
            this.unx = new LuckyMoneyEmojiSwitch();
          }
          this.unx.ulX = 1;
          this.unx.ulY = 1;
          this.unx.ulZ = 1;
          this.unx.uma = 1;
          this.unR = 1;
        }
        ac.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.unx.toString() });
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        ac.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(this.uni.ulT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ap
 * JD-Core Version:    0.7.0.1
 */