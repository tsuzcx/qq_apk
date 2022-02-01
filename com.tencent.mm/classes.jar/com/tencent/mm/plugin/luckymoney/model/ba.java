package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ba
  extends ax
{
  public String CAf;
  public RealnameGuideHelper Koa;
  public q KtU;
  public com.tencent.mm.plugin.wallet_core.utils.c KtV;
  public String KuH;
  public int KuI;
  public String KuJ;
  public String KuK;
  public aa KuL;
  public String Kuk;
  public int Kul;
  public LuckyMoneyEmojiSwitch Kum;
  public String ihx;
  long msgId;
  public String talker;
  
  public ba()
  {
    this.KtU = null;
    this.KuI = 0;
    this.KuJ = "";
    this.KuK = "";
  }
  
  public ba(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "");
    AppMethodBeat.i(65301);
    AppMethodBeat.o(65301);
  }
  
  public ba(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(283948);
    this.KtU = null;
    this.KuI = 0;
    this.KuJ = "";
    this.KuK = "";
    this.CAf = paramString1;
    this.ihx = paramString2;
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
    AppMethodBeat.o(283948);
  }
  
  public String drI()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final void fXl()
  {
    AppMethodBeat.i(283959);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acYL, Integer.valueOf(0))).intValue();
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTa, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      if (this.Kum == null) {
        this.Kum = new LuckyMoneyEmojiSwitch();
      }
      this.Kum.Kss = 1;
      this.Kum.Kst = 1;
      this.Kum.Ksu = 1;
      this.Kum.Ksv = 1;
      this.KuI = 1;
    }
    Log.i("MicroMsg.NetSceneOpenLuckyMoney", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.Kum.toString() });
    AppMethodBeat.o(283959);
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
        this.KtU = ae.bt(paramJSONObject);
        this.KuL = ae.bw(paramJSONObject.optJSONObject("new_year_cover_config"));
        this.Kum = LuckyMoneyEmojiSwitch.bs(paramJSONObject);
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "luckyMoneyEmojiSwitch:%s", new Object[] { this.Kum.toString() });
        this.Kuk = paramJSONObject.optString("expression_md5");
        this.Kul = paramJSONObject.optInt("expression_type");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.Kuk, Integer.valueOf(this.Kul) });
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
            this.Koa = new RealnameGuideHelper();
            this.Koa.a(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.KtV = com.tencent.mm.plugin.wallet_core.utils.c.cC(paramJSONObject.optJSONObject("intercept_win"));
        }
        if (paramJSONObject.has("intercept_win_after")) {
          this.KuJ = paramJSONObject.optJSONObject("intercept_win_after").toString();
        }
        if (paramJSONObject.has("left_button_continue")) {
          this.KuK = paramJSONObject.optString("left_button_continue");
        }
        this.KuH = paramJSONObject.optString("SystemMsgContext");
        this.KuI = paramJSONObject.optInt("showYearExpression");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.KuI) });
        if ((paramInt == 0) && (!Util.isNullOrNil(this.KuH)) && (!Util.isNullOrNil(this.KtU.Ksi)))
        {
          boolean bool = ab.IN(this.talker);
          if (bool) {}
        }
        try
        {
          if (!z.bAM().equals(this.KtU.Ksi)) {
            continue;
          }
          paramString = MMApplicationContext.getContext().getString(a.i.lucky_money_sys_msg_self);
          this.KuH = this.KuH.replace("$" + this.KtU.Ksi + "$", paramString);
          ah.kb(this.KuH, this.talker);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.NetSceneOpenLuckyMoney", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        fXl();
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        Log.w("MicroMsg.NetSceneOpenLuckyMoney", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((b)h.ax(b.class)).getDisplayName(this.KtU.Ksi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ba
 * JD-Core Version:    0.7.0.1
 */