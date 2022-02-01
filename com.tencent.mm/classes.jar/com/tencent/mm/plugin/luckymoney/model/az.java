package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class az
  extends aw
{
  public q EAX;
  public com.tencent.mm.plugin.wallet_core.utils.b EAY;
  public String EBH;
  public int EBI;
  public String EBJ;
  public String EBK;
  public String EBm;
  public int EBn;
  public LuckyMoneyEmojiSwitch EBo;
  public RealnameGuideHelper Evs;
  public String gbn;
  long msgId;
  public String talker;
  public String ybP;
  
  public az()
  {
    this.EAX = null;
    this.EBI = 0;
    this.EBJ = "";
    this.EBK = "";
  }
  
  public az(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "");
    AppMethodBeat.i(65301);
    AppMethodBeat.o(65301);
  }
  
  public az(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(274415);
    this.EAX = null;
    this.EBI = 0;
    this.EBJ = "";
    this.EBK = "";
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
    localHashMap.put("left_button_continue", paramString8);
    Log.i("MicroMsg.NetSceneOpenLuckyMoney", "NetSceneOpenLuckyMoney request");
    setRequestData(localHashMap);
    AppMethodBeat.o(274415);
  }
  
  public String cOd()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final void eOI()
  {
    AppMethodBeat.i(274417);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vxa, Integer.valueOf(0))).intValue();
    int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDT, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      if (this.EBo == null) {
        this.EBo = new LuckyMoneyEmojiSwitch();
      }
      this.EBo.EzG = 1;
      this.EBo.EzH = 1;
      this.EBo.EzI = 1;
      this.EBo.EzJ = 1;
      this.EBI = 1;
    }
    Log.i("MicroMsg.NetSceneOpenLuckyMoney", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.EBo.toString() });
    AppMethodBeat.o(274417);
  }
  
  public int getType()
  {
    return 1685;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65302);
    Log.i("MicroMsg.NetSceneOpenLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject.toString() });
    for (;;)
    {
      try
      {
        this.EAX = ad.bf(paramJSONObject);
        this.EBo = LuckyMoneyEmojiSwitch.be(paramJSONObject);
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "luckyMoneyEmojiSwitch:%s", new Object[] { this.EBo.toString() });
        this.EBm = paramJSONObject.optString("expression_md5");
        this.EBn = paramJSONObject.optInt("expression_type");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.EBm, Integer.valueOf(this.EBn) });
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
          this.EAY = com.tencent.mm.plugin.wallet_core.utils.b.cg(paramJSONObject.optJSONObject("intercept_win"));
        }
        if (paramJSONObject.has("intercept_win_after")) {
          this.EBJ = paramJSONObject.optJSONObject("intercept_win_after").toString();
        }
        if (paramJSONObject.has("left_button_continue")) {
          this.EBK = paramJSONObject.optString("left_button_continue");
        }
        this.EBH = paramJSONObject.optString("SystemMsgContext");
        this.EBI = paramJSONObject.optInt("showYearExpression");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.EBI) });
        if ((paramInt == 0) && (!Util.isNullOrNil(this.EBH)) && (!Util.isNullOrNil(this.EAX.Ezw)))
        {
          boolean bool = ab.Qg(this.talker);
          if (bool) {}
        }
        try
        {
          if (!z.bcZ().equals(this.EAX.Ezw)) {
            continue;
          }
          paramString = MMApplicationContext.getContext().getString(a.i.lucky_money_sys_msg_self);
          this.EBH = this.EBH.replace("$" + this.EAX.Ezw + "$", paramString);
          ag.iN(this.EBH, this.talker);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.NetSceneOpenLuckyMoney", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        eOI();
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        Log.w("MicroMsg.NetSceneOpenLuckyMoney", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(this.EAX.Ezw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.az
 * JD-Core Version:    0.7.0.1
 */