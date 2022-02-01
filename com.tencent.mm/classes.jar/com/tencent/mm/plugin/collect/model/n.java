package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends a
{
  public int dDN;
  public String desc;
  public long eht;
  public String jTx;
  public String jTy;
  public String qwn;
  public String qwo;
  public int qwp;
  public String qwq;
  public String qwr;
  public String qws;
  public String qwt;
  public String qwu;
  public String qwv;
  public int qww;
  public String qwx;
  public String qwy;
  public int qwz;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(63832);
  }
  
  public n(long paramLong, String paramString, int paramInt)
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
      this.eht = paramLong;
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
  
  public final String czD()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int czE()
  {
    return 1335;
  }
  
  public final boolean czF()
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
    this.dDN = paramJSONObject.optInt("retcode", 0);
    this.qwn = paramJSONObject.optString("retmsg", "");
    this.qwo = paramJSONObject.optString("qrcode_url", "");
    this.qwp = paramJSONObject.optInt("alert_type", 0);
    this.qwq = paramJSONObject.optString("alert_title", "");
    this.qwr = paramJSONObject.optString("left_button_text", "");
    this.qws = paramJSONObject.optString("right_button_text", "");
    this.qwt = paramJSONObject.optString("right_button_url", "");
    this.qwu = paramJSONObject.optString("bottom_text", "");
    this.qwv = paramJSONObject.optString("bottom_url", "");
    this.qww = paramJSONObject.optInt("currency", 0);
    this.qwx = paramJSONObject.optString("currencyunit", "");
    this.jTx = paramJSONObject.optString("notice", "");
    this.jTy = paramJSONObject.optString("notice_url", "");
    this.qwy = paramJSONObject.optString("recv_realname", "");
    this.qwz = paramJSONObject.optInt("set_amount", 0);
    if (this.qwz == 0)
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.Oco, this.qwo);
      Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.qwo });
    }
    Log.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.qwo, Integer.valueOf(this.qww) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */