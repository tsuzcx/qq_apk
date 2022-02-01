package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
  extends am
{
  public String dNL;
  long msgId;
  public String talker;
  public String vkl;
  public RealnameGuideHelper vla;
  public l vpO;
  public String vqb;
  public int vqc;
  public LuckyMoneyEmojiSwitch vqd;
  public String vqw;
  public int vqx;
  public com.tencent.mm.plugin.wallet_core.utils.b vqy;
  
  public ap(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(65301);
    this.vpO = null;
    this.vqx = 0;
    this.vkl = paramString1;
    this.dNL = paramString2;
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
  
  public final String cau()
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
        this.vpO = x.aD(paramJSONObject);
        this.vqd = LuckyMoneyEmojiSwitch.aC(paramJSONObject);
        ad.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.vqd.toString() });
        this.vqb = paramJSONObject.optString("expression_md5");
        this.vqc = paramJSONObject.optInt("expression_type");
        ad.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.vqb, Integer.valueOf(this.vqc) });
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
            this.vla = new RealnameGuideHelper();
            this.vla.b(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.vqy = com.tencent.mm.plugin.wallet_core.utils.b.bw(paramJSONObject.optJSONObject("intercept_win"));
        }
        this.vqw = paramJSONObject.optString("SystemMsgContext");
        this.vqx = paramJSONObject.optInt("showYearExpression");
        ad.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", new Object[] { Integer.valueOf(this.vqx) });
        if ((paramInt == 0) && (!bt.isNullOrNil(this.vqw)) && (!bt.isNullOrNil(this.vpO.voz)))
        {
          boolean bool = w.zy(this.talker);
          if (bool) {}
        }
        try
        {
          if (!u.aAm().equals(this.vpO.voz)) {
            continue;
          }
          paramString = aj.getContext().getString(2131760972);
          this.vqw = this.vqw.replace("$" + this.vpO.voz + "$", paramString);
          z.hK(this.vqw, this.talker);
        }
        catch (Exception paramString)
        {
          int i;
          ad.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        g.ajD();
        paramInt = ((Integer)g.ajC().ajl().get(al.a.IFE, Integer.valueOf(0))).intValue();
        i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwX, 0);
        if ((bt.jx(paramInt, 1)) || (bt.jx(i, 1)))
        {
          if (this.vqd == null) {
            this.vqd = new LuckyMoneyEmojiSwitch();
          }
          this.vqd.voD = 1;
          this.vqd.voE = 1;
          this.vqd.voF = 1;
          this.vqd.voG = 1;
          this.vqx = 1;
        }
        ad.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.vqd.toString() });
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        ad.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(this.vpO.voz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ap
 * JD-Core Version:    0.7.0.1
 */