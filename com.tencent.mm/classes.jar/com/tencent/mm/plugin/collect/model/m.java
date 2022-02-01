package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends a
{
  public String desc;
  public int hAV;
  public long ihV;
  public String pHt;
  public String pHu;
  public String wYI;
  public String wYJ;
  public int wYK;
  public String wYL;
  public String wYM;
  public String wYN;
  public String wYO;
  public String wYP;
  public String wYQ;
  public int wYR;
  public String wYS;
  public String wYT;
  public int wYU;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(63832);
  }
  
  public m(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(63833);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", "1");
    try
    {
      if (!Util.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.ihV = paramLong;
      this.desc = paramString;
      Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(63833);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String drI()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int drJ()
  {
    return 1335;
  }
  
  public final boolean drK()
  {
    return true;
  }
  
  public final int getType()
  {
    return 1335;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63834);
    this.hAV = paramJSONObject.optInt("retcode", 0);
    this.wYI = paramJSONObject.optString("retmsg", "");
    this.wYJ = paramJSONObject.optString("qrcode_url", "");
    this.wYK = paramJSONObject.optInt("alert_type", 0);
    this.wYL = paramJSONObject.optString("alert_title", "");
    this.wYM = paramJSONObject.optString("left_button_text", "");
    this.wYN = paramJSONObject.optString("right_button_text", "");
    this.wYO = paramJSONObject.optString("right_button_url", "");
    this.wYP = paramJSONObject.optString("bottom_text", "");
    this.wYQ = paramJSONObject.optString("bottom_url", "");
    this.wYR = paramJSONObject.optInt("currency", 0);
    this.wYS = paramJSONObject.optString("currencyunit", "");
    this.pHt = paramJSONObject.optString("notice", "");
    this.pHu = paramJSONObject.optString("notice_url", "");
    this.wYT = paramJSONObject.optString("recv_realname", "");
    this.wYU = paramJSONObject.optInt("set_amount", 0);
    if (this.wYU == 0)
    {
      h.baF();
      h.baE().ban().set(at.a.acRT, this.wYJ);
      Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.wYJ });
    }
    Log.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.wYJ, Integer.valueOf(this.wYR) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */