package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  extends am
{
  public String dDM;
  long msgId;
  public String sZn;
  public RealnameGuideHelper tac;
  public String talker;
  public l teT;
  public String tfB;
  public int tfC;
  public com.tencent.mm.plugin.wallet_core.utils.b tfD;
  public String tfg;
  public int tfh;
  public LuckyMoneyEmojiSwitch tfi;
  
  public ap(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(65301);
    this.teT = null;
    this.tfC = 0;
    this.sZn = paramString1;
    this.dDM = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!bt.isNullOrNil(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(bt.nullAsNil(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    setRequestData(localHashMap);
    AppMethodBeat.o(65301);
  }
  
  public final String bOB()
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
        this.teT = x.at(paramJSONObject);
        this.tfi = LuckyMoneyEmojiSwitch.as(paramJSONObject);
        ad.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.tfi.toString() });
        this.tfg = paramJSONObject.optString("expression_md5");
        this.tfh = paramJSONObject.optInt("expression_type");
        ad.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.tfg, Integer.valueOf(this.tfh) });
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
            this.tac = new RealnameGuideHelper();
            this.tac.b(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.tfD = com.tencent.mm.plugin.wallet_core.utils.b.bm(paramJSONObject.optJSONObject("intercept_win"));
        }
        this.tfB = paramJSONObject.optString("SystemMsgContext");
        this.tfC = paramJSONObject.optInt("showYearExpression");
        ad.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", new Object[] { Integer.valueOf(this.tfC) });
        if ((paramInt == 0) && (!bt.isNullOrNil(this.tfB)) && (!bt.isNullOrNil(this.teT.tdE)))
        {
          boolean bool = w.sz(this.talker);
          if (bool) {}
        }
        try
        {
          if (!u.aqG().equals(this.teT.tdE)) {
            continue;
          }
          paramString = aj.getContext().getString(2131760972);
          this.tfB = this.tfB.replace("$" + this.teT.tdE + "$", paramString);
          z.hf(this.tfB, this.talker);
        }
        catch (Exception paramString)
        {
          int i;
          ad.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        g.afC();
        paramInt = ((Integer)g.afB().afk().get(ae.a.Fvf, Integer.valueOf(0))).intValue();
        i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poL, 0);
        if ((bt.iY(paramInt, 1)) || (bt.iY(i, 1)))
        {
          if (this.tfi == null) {
            this.tfi = new LuckyMoneyEmojiSwitch();
          }
          this.tfi.tdI = 1;
          this.tfi.tdJ = 1;
          this.tfi.tdK = 1;
          this.tfi.tdL = 1;
          this.tfC = 1;
        }
        ad.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.tfi.toString() });
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        ad.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(this.teT.tdE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ap
 * JD-Core Version:    0.7.0.1
 */