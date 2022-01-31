package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class an
  extends ak
{
  public String cMO;
  long cpO;
  public String ojA;
  public RealnameGuideHelper okp;
  public k ooO;
  public String opb;
  public int opc;
  public LuckyMoneyEmojiSwitch opd;
  public String opw;
  public int opx;
  public String talker;
  
  public an(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(42413);
    this.ooO = null;
    this.opx = 0;
    this.ojA = paramString1;
    this.cMO = paramString2;
    this.talker = paramString5;
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("channelId", String.valueOf(paramInt2));
    localHashMap.put("sendId", paramString1);
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!bo.isNullOrNil(paramString3))
    {
      localHashMap.put("headImg", URLEncoder.encode(paramString3));
      localHashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(paramString4)));
    }
    localHashMap.put("sessionUserName", paramString5);
    localHashMap.put("ver", paramString6);
    localHashMap.put("timingIdentifier", paramString7);
    setRequestData(localHashMap);
    AppMethodBeat.o(42413);
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final int getType()
  {
    return 1685;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(42414);
    for (;;)
    {
      try
      {
        this.ooO = v.ae(paramJSONObject);
        this.opd = LuckyMoneyEmojiSwitch.ad(paramJSONObject);
        ab.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", new Object[] { this.opd.toString() });
        this.opb = paramJSONObject.optString("expression_md5");
        this.opc = paramJSONObject.optInt("expression_type");
        ab.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", new Object[] { this.opb, Integer.valueOf(this.opc) });
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
            this.okp = new RealnameGuideHelper();
            this.okp.a(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        this.opw = paramJSONObject.optString("SystemMsgContext");
        this.opx = paramJSONObject.optInt("showYearExpression");
        ab.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", new Object[] { Integer.valueOf(this.opx) });
        if ((paramInt == 0) && (!bo.isNullOrNil(this.opw)))
        {
          boolean bool = bo.isNullOrNil(this.ooO.onN);
          if (bool) {}
        }
        try
        {
          if (!r.Zn().equals(this.ooO.onN)) {
            continue;
          }
          paramString = ah.getContext().getString(2131301327);
          this.opw = this.opw.replace("$" + this.ooO.onN + "$", paramString);
          x.fd(this.opw, this.talker);
        }
        catch (Exception paramString)
        {
          int i;
          ab.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        g.RM();
        paramInt = ((Integer)g.RL().Ru().get(ac.a.yLJ, Integer.valueOf(0))).intValue();
        i = ((a)g.E(a.class)).a(a.a.lVp, 0);
        if ((bo.hl(paramInt, 1)) || (bo.hl(i, 1)))
        {
          if (this.opd == null) {
            this.opd = new LuckyMoneyEmojiSwitch();
          }
          this.opd.onR = 1;
          this.opd.onS = 1;
          this.opd.onT = 1;
          this.opd.onU = 1;
          this.opx = 1;
        }
        ab.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.opd.toString() });
        AppMethodBeat.o(42414);
        return;
      }
      catch (JSONException paramString)
      {
        ab.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(42414);
      }
      paramString = ((b)g.E(b.class)).nE(this.ooO.onN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.an
 * JD-Core Version:    0.7.0.1
 */