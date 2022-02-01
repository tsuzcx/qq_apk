package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  extends am
{
  public String dPb;
  long msgId;
  public String talker;
  public l vBT;
  public String vCB;
  public int vCC;
  public com.tencent.mm.plugin.wallet_core.utils.b vCD;
  public String vCg;
  public int vCh;
  public LuckyMoneyEmojiSwitch vCi;
  public String vwq;
  public RealnameGuideHelper vxf;
  
  public ap(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(65301);
    this.vBT = null;
    this.vCC = 0;
    this.vwq = paramString1;
    this.dPb = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!bu.isNullOrNil(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(bu.nullAsNil(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    setRequestData(localHashMap);
    AppMethodBeat.o(65301);
  }
  
  public final String cbJ()
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
        this.vBT = x.aD(paramJSONObject);
        this.vCi = LuckyMoneyEmojiSwitch.aC(paramJSONObject);
        ae.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.vCi.toString() });
        this.vCg = paramJSONObject.optString("expression_md5");
        this.vCh = paramJSONObject.optInt("expression_type");
        ae.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.vCg, Integer.valueOf(this.vCh) });
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
            this.vxf = new RealnameGuideHelper();
            this.vxf.b(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.vCD = com.tencent.mm.plugin.wallet_core.utils.b.bw(paramJSONObject.optJSONObject("intercept_win"));
        }
        this.vCB = paramJSONObject.optString("SystemMsgContext");
        this.vCC = paramJSONObject.optInt("showYearExpression");
        ae.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", new Object[] { Integer.valueOf(this.vCC) });
        if ((paramInt == 0) && (!bu.isNullOrNil(this.vCB)) && (!bu.isNullOrNil(this.vBT.vAE)))
        {
          boolean bool = com.tencent.mm.model.x.Ai(this.talker);
          if (bool) {}
        }
        try
        {
          if (!v.aAC().equals(this.vBT.vAE)) {
            continue;
          }
          paramString = ak.getContext().getString(2131760972);
          this.vCB = this.vCB.replace("$" + this.vBT.vAE + "$", paramString);
          z.hR(this.vCB, this.talker);
        }
        catch (Exception paramString)
        {
          int i;
          ae.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        g.ajS();
        paramInt = ((Integer)g.ajR().ajA().get(am.a.Jae, Integer.valueOf(0))).intValue();
        i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDX, 0);
        if ((bu.jB(paramInt, 1)) || (bu.jB(i, 1)))
        {
          if (this.vCi == null) {
            this.vCi = new LuckyMoneyEmojiSwitch();
          }
          this.vCi.vAI = 1;
          this.vCi.vAJ = 1;
          this.vCi.vAK = 1;
          this.vCi.vAL = 1;
          this.vCC = 1;
        }
        ae.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.vCi.toString() });
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        ae.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(this.vBT.vAE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ap
 * JD-Core Version:    0.7.0.1
 */