package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends az
{
  public int ECj;
  private boolean ECk;
  public Map<String, String> ECl;
  public int lXi;
  
  public b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt3)
  {
    AppMethodBeat.i(194445);
    this.lXi = 0;
    this.ECj = 0;
    this.ECk = false;
    this.ECl = null;
    this.ybP = paramString1;
    this.gbn = paramString2;
    this.talker = paramString5;
    this.ECl = new HashMap();
    this.ECl.put("msgType", String.valueOf(paramInt1));
    this.ECl.put("channelId", String.valueOf(paramInt2));
    this.ECl.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      this.ECl.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!Util.isNullOrNil(paramString3))
    {
      this.ECl.put("headImg", URLEncoder.encode(paramString3));
      this.ECl.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString4)));
    }
    this.ECl.put("ver", paramString6);
    this.ECl.put("timingIdentifier", paramString7);
    this.ECl.put("left_button_continue", paramString8);
    this.ECl.put("liveid", paramString9);
    this.ECl.put("liveattach", paramString10);
    if (paramInt3 > 0) {
      this.ECl.put("channellive_sender_flag", String.valueOf(paramInt3));
    }
    if (this.ECk) {
      this.ECl.put("policy_retry", "1");
    }
    Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "NetSceneOpenLuckyMoney request");
    setRequestData(this.ECl);
    AppMethodBeat.o(194445);
  }
  
  public b(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194446);
    this.lXi = 0;
    this.ECj = 0;
    this.ECk = false;
    this.ECl = null;
    setRequestData(paramMap);
    AppMethodBeat.o(194446);
  }
  
  public final void c(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194448);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "needCallbackWhenError error ok or json null");
      this.lXi = 0;
      this.ECj = 0;
      AppMethodBeat.o(194448);
      return;
    }
    int i = paramJSONObject.optInt("tryafterms");
    Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "needCallbackWhenError delayTimeMS: %s, retryTimes: %s, errCode: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lXi), Integer.valueOf(paramInt) });
    if ((i > 0) && (this.lXi <= 0))
    {
      this.lXi += 1;
      this.ECj = Math.min(i, 5000);
      AppMethodBeat.o(194448);
      return;
    }
    this.lXi = 0;
    this.ECj = 0;
    AppMethodBeat.o(194448);
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliveopenwxhb";
  }
  
  public final int getType()
  {
    return 4595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.b
 * JD-Core Version:    0.7.0.1
 */