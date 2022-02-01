package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends ba
{
  public int Kvk;
  private boolean Kvl;
  public Map<String, String> Kvm;
  public int oQk;
  
  public b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt3)
  {
    AppMethodBeat.i(283898);
    this.oQk = 0;
    this.Kvk = 0;
    this.Kvl = false;
    this.Kvm = null;
    this.CAf = paramString1;
    this.ihx = paramString2;
    this.talker = paramString5;
    this.Kvm = new HashMap();
    this.Kvm.put("msgType", String.valueOf(paramInt1));
    this.Kvm.put("channelId", String.valueOf(paramInt2));
    this.Kvm.put("sendId", paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      this.Kvm.put("nativeUrl", URLEncoder.encode(paramString2));
    }
    if (!Util.isNullOrNil(paramString3))
    {
      this.Kvm.put("headImg", URLEncoder.encode(paramString3));
      this.Kvm.put("nickName", URLEncoder.encode(Util.nullAsNil(paramString4)));
    }
    this.Kvm.put("ver", paramString6);
    this.Kvm.put("timingIdentifier", paramString7);
    this.Kvm.put("left_button_continue", paramString8);
    this.Kvm.put("liveid", paramString9);
    this.Kvm.put("liveattach", paramString10);
    if (paramInt3 > 0) {
      this.Kvm.put("channellive_sender_flag", String.valueOf(paramInt3));
    }
    if (this.Kvl) {
      this.Kvm.put("policy_retry", "1");
    }
    Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "NetSceneOpenLuckyMoney request");
    setRequestData(this.Kvm);
    AppMethodBeat.o(283898);
  }
  
  public b(Map<String, String> paramMap)
  {
    AppMethodBeat.i(283902);
    this.oQk = 0;
    this.Kvk = 0;
    this.Kvl = false;
    this.Kvm = null;
    setRequestData(paramMap);
    AppMethodBeat.o(283902);
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/ftfhb/channelliveopenwxhb";
  }
  
  public final void e(int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283906);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "needCallbackWhenError error ok or json null");
      this.oQk = 0;
      this.Kvk = 0;
      AppMethodBeat.o(283906);
      return;
    }
    int i = paramJSONObject.optInt("tryafterms");
    Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "needCallbackWhenError delayTimeMS: %s, retryTimes: %s, errCode: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oQk), Integer.valueOf(paramInt) });
    if ((i > 0) && (this.oQk <= 0))
    {
      this.oQk += 1;
      this.Kvk = Math.min(i, 5000);
      AppMethodBeat.o(283906);
      return;
    }
    this.oQk = 0;
    this.Kvk = 0;
    AppMethodBeat.o(283906);
  }
  
  public final int getType()
  {
    return 4595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a.b
 * JD-Core Version:    0.7.0.1
 */