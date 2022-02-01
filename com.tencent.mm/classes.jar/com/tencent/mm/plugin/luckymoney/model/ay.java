package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
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

public class ay
  extends av
{
  public String egX;
  long msgId;
  public String talker;
  public String yQE;
  public RealnameGuideHelper yRu;
  public q yWT;
  public String yXC;
  public int yXD;
  public com.tencent.mm.plugin.wallet_core.utils.b yXE;
  public String yXF;
  public String yXG;
  public String yXh;
  public int yXi;
  public LuckyMoneyEmojiSwitch yXj;
  
  public ay()
  {
    this.yWT = null;
    this.yXD = 0;
    this.yXF = "";
    this.yXG = "";
  }
  
  public ay(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, "");
    AppMethodBeat.i(65301);
    AppMethodBeat.o(65301);
  }
  
  public ay(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(213323);
    this.yWT = null;
    this.yXD = 0;
    this.yXF = "";
    this.yXG = "";
    this.yQE = paramString1;
    this.egX = paramString2;
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
    AppMethodBeat.o(213323);
  }
  
  public String czD()
  {
    return "/cgi-bin/mmpay-bin/openwxhb";
  }
  
  public final void efk()
  {
    AppMethodBeat.i(213324);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.OiK, Integer.valueOf(0))).intValue();
    int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXc, 0);
    if ((Util.isEqual(i, 1)) || (Util.isEqual(j, 1)))
    {
      if (this.yXj == null) {
        this.yXj = new LuckyMoneyEmojiSwitch();
      }
      this.yXj.yVG = 1;
      this.yXj.yVH = 1;
      this.yXj.yVI = 1;
      this.yXj.yVJ = 1;
      this.yXD = 1;
    }
    Log.i("MicroMsg.NetSceneOpenLuckyMoney", "localSwitch() luckyMoneyEmojiSwitch:%s ", new Object[] { this.yXj.toString() });
    AppMethodBeat.o(213324);
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
        this.yWT = ac.aY(paramJSONObject);
        this.yXj = LuckyMoneyEmojiSwitch.aX(paramJSONObject);
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "luckyMoneyEmojiSwitch:%s", new Object[] { this.yXj.toString() });
        this.yXh = paramJSONObject.optString("expression_md5");
        this.yXi = paramJSONObject.optInt("expression_type");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "expressionmd5:%s expressiontype:%s", new Object[] { this.yXh, Integer.valueOf(this.yXi) });
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
            this.yRu = new RealnameGuideHelper();
            this.yRu.b(paramString, str1, str2, str3, (String)localObject, 1003);
          }
        }
        if (paramJSONObject.has("intercept_win")) {
          this.yXE = com.tencent.mm.plugin.wallet_core.utils.b.bV(paramJSONObject.optJSONObject("intercept_win"));
        }
        if (paramJSONObject.has("intercept_win_after")) {
          this.yXF = paramJSONObject.optJSONObject("intercept_win_after").toString();
        }
        if (paramJSONObject.has("left_button_continue")) {
          this.yXG = paramJSONObject.optString("left_button_continue");
        }
        this.yXC = paramJSONObject.optString("SystemMsgContext");
        this.yXD = paramJSONObject.optInt("showYearExpression");
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "showYearExpression:%s", new Object[] { Integer.valueOf(this.yXD) });
        if ((paramInt == 0) && (!Util.isNullOrNil(this.yXC)) && (!Util.isNullOrNil(this.yWT.yVy)))
        {
          boolean bool = ab.IN(this.talker);
          if (bool) {}
        }
        try
        {
          if (!z.aTY().equals(this.yWT.yVy)) {
            continue;
          }
          paramString = MMApplicationContext.getContext().getString(2131762746);
          this.yXC = this.yXC.replace("$" + this.yWT.yVy + "$", paramString);
          af.iB(this.yXC, this.talker);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.NetSceneOpenLuckyMoney", "insertLocalSysMsgIfNeed error: %s", new Object[] { paramString.getMessage() });
          continue;
        }
        efk();
        AppMethodBeat.o(65302);
        return;
      }
      catch (JSONException paramString)
      {
        Log.w("MicroMsg.NetSceneOpenLuckyMoney", "parse luckyMoneyDetail fail: " + paramString.getLocalizedMessage());
        AppMethodBeat.o(65302);
      }
      paramString = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yWT.yVy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ay
 * JD-Core Version:    0.7.0.1
 */